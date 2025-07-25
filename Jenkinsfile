#!groovy

pipeline {
  agent {
    kubernetes {
      yaml kubePodTemplate(name: 'gauge.yaml')
    }
  }
  parameters {
    validatingString( name: 'TARGET_VERSION',
                      defaultValue: 'NONE',
                      description: 'Tag to create after successful QA',
                      failedValidationMessage: 'Tag name must be NONE or a semantic version release or pre-release (i.e. no build metadata)',
                      regex: /NONE|${globals.SVRE_PRE_RELEASE}/)
  }
  environment {
    ARTIFACTORY_CREDS = credentials('artifactory')
    ARTIFACTORY_URL_UP = "${Artifactory.server('taas-artifactory-upload').getUrl()}"
    ARTIFACTORY_URL_DOWN = "${Artifactory.server('taas-artifactory').getUrl()}"
  }
  stages {
    stage('Detect Secrets') {
      steps {
        detectSecrets()
      }
    }

    stage('Init') {
      steps {
        script {
          defaultInit()
          applyCustomizations()
          commitHash = "${env.GIT_COMMIT.take(7)}"
        }
      }
    }
    stage('QA') {
      steps {
        withEnv(['DOCKER_HOST=',
          'SERVER_AUTH_TYPE=basic',
          'SERVER_URL=http://127.0.0.1:5984',
          'WIREMOCK_URL=http://127.0.0.1:8080',
          'WIREMOCK_PORT=8080'
        ]) {
          withCredentials([
            usernamePassword(credentialsId: 'container-test-server',
                             usernameVariable: 'SERVER_USERNAME',
                             passwordVariable: 'SERVER_PASSWORD')
            ]) {
              script {
                  sh './scripts/setup_couch.sh'
                  sh './scripts/setup_wiremock.sh'
              }
              runTests()
          }
        }
      }

      post {
        always {
          junit (
            testResults: '**/junitreports/*.xml'
          )
        }
      }
    }
    stage('SonarQube analysis') {
      environment {
        scannerHome = tool 'SonarQubeScanner'
      }
      // Scanning runs on dependabot core update and non-dependabot branches
      when {
        anyOf {
          branch pattern: /^dependabot.*(?i)(ibm)[\.-].+sdk-core.*$/, comparator: 'REGEXP'
          not {
            branch 'dependabot*'
          }
        }
      }
      steps {
        scanCode()
      }
    }
    stage('Publish[staging]') {
      environment {
        STAGE_ROOT = "${ARTIFACTORY_URL_UP}/api/"
      }
      steps {
        bumpVersion(true)
        customizePublishingInfo()
        withEnv(["LIB_NAME=${libName}",
          "TYPE=${buildType}",
          "ARTIFACT_URL=${artifactUrl}",
          "MODULE_ID=${moduleId}",
          "BUILD_NAME=${env.JOB_NAME}"]) {
            publishStaging()
            publishArtifactoryBuildInfo()
        }
      }
      // This post stage resets the temporary version bump used to publish to staging
      post {
        always {
          sh 'git reset --hard'
        }
      }
    }
    stage('Run Gauge tests') {
      steps {
        script {
            buildResults = null

            // For standard builds attempt to run on a matching env.BRANCH_NAME branch first and if it doesn't exist
            // then fallback to TARGET_GAUGE_RELEASE_BRANCH_NAME if set or env.TARGET_GAUGE_DEFAULT_BRANCH_NAME.
            gaugeBranchName = env.BRANCH_NAME
            fallbackBranchName = env.TARGET_GAUGE_RELEASE_BRANCH_NAME ?: env.TARGET_GAUGE_DEFAULT_BRANCH_NAME

            // For release builds (tag builds or the primary branch) do the reverse and attempt to run on the
            // TARGET_GAUGE_RELEASE_BRANCH_NAME falling back to env.BRANCH_NAME or env.TAG_NAME if there is no match.
            if (env.TAG_NAME || env.BRANCH_IS_PRIMARY){
              gaugeBranchName = env.TARGET_GAUGE_RELEASE_BRANCH_NAME
              fallbackBranchName = env.TAG_NAME ?: env.BRANCH_NAME
            }
          try {
            buildResults = build job: "/${env.SDKS_GAUGE_PIPELINE_PROJECT}/${gaugeBranchName}", parameters: [
                string(name: 'SDK_RUN_LANG', value: "$libName"),
                string(name: "SDK_VERSION_${libName.toUpperCase()}", value: "${env.NEW_SDK_VERSION}")]
          } catch (hudson.AbortException ae) {
            // only run build in sdks-gauge default branch if BRANCH_NAME doesn't exist
            if (ae.getMessage().contains("No item named /${env.SDKS_GAUGE_PIPELINE_PROJECT}/${gaugeBranchName} found")) {
              echo "No matching branch named '${gaugeBranchName}' in sdks-gauge, building ${fallbackBranchName} branch"
              build job: "/${env.SDKS_GAUGE_PIPELINE_PROJECT}/${fallbackBranchName}", parameters: [
                  string(name: 'SDK_RUN_LANG', value: "$libName"),
                  string(name: "SDK_VERSION_${libName.toUpperCase()}", value: "${env.NEW_SDK_VERSION}")]
            } else {
              throw ae
            }
          }
        }
      }
    }
    stage('Update version and tag') {
      when {
        beforeAgent true
        allOf {
          // We only bump the version and create a tag when building the default primary branch with a TARGET_VERSION
          branch 'main'
          not {
            equals expected: 'NONE', actual: "${params.TARGET_VERSION}"
          }
        }
      }
      steps {
        gitsh('github.com') {
          // bump the version
          bumpVersion(false)
          // Push the version bump and release tag
          sh 'git push --tags origin HEAD:main'
        }
      }
    }
    stage('Publish[repository]') {
      // We publish only when building a tag that meets our semantic version release or pre-release tag format
      when {
        beforeAgent true
        allOf {
          buildingTag()
          anyOf {
            tag pattern: /${env.SVRE_PRE_RELEASE_TAG}/, comparator: "REGEXP"
          }
        }
      }
      steps {
        publishPublic()
        gitsh('github.com') {
          publishDocs()
        }
      }
    }
  }
}

// Note default values cannot be assigned here.
def libName
def commitHash
def bumpVersion
def customizeVersion
def getNewVersion
def testVersionPrefix
def customizePublishingInfo
def publishArtifactoryBuildInfo
def publishArtifactoryBuildInfoScript
def artifactUrl
def moduleId
def buildType
def scanCode

void defaultInit() {
  // Default to using bump-my-version
  bumpVersion = { isDevRelease ->
    newVersion = getNewVersion(isDevRelease)
    // Set an env var with the new version
    env.NEW_SDK_VERSION = newVersion
    doVersionBump(isDevRelease, newVersion)
  }

  doVersionBump = { isDevRelease, newVersion, allowDirty ->
    sh "bump-my-version bump patch --new-version ${newVersion} ${allowDirty ? '--allow-dirty': ''} ${isDevRelease ? '--no-commit' : '--tag --tag-message "Release {new_version}"'}"
  }

  getNewVersion = { isDevRelease ->
    // Get a staging or target version and customize with lang specific requirements
    return customizeVersion(isDevRelease ? getDevVersion() : getTargetVersion())
  }

  getTargetVersion = {
    version = ''
    if ('NONE' != params.TARGET_VERSION) {
      version = params.TARGET_VERSION
    } else {
      // If a target version is not provided default to a patch bump
      version = sh returnStdout: true, script: 'bump-my-version show-bump --ascii | grep patch | rev | cut -f1 -d " " | rev'
    }
    return version.trim()
  }

  getDevVersion = {
    devVersion = getTargetVersion()
    if (devVersion ==~ /${env.SVRE_RELEASE}/) {
      // For a release (e.g. 1.0.0) use a hyphen separator (e.g. 1.0.0-dev)
      devVersion += "-"
    } else if (devVersion ==~ /${env.SVRE_PRE_RELEASE}/) {
      // For a pre-release (e.g. 1.0.0-b7), add dot separator (e.g. 1.0.0-b7.dev)
      devVersion += "."
    }
    // Now add dev identifier (a number is required by some package managers)
    devVersion += "dev0"
    // Add uniqueness with build metadata to dev build versions
    devVersion += "+git${commitHash}.${currentBuild.startTimeInMillis}.${currentBuild.number}"

    return devVersion
  }

  // Default no-op implementation to use semverFormatVersion
  customizeVersion = { semverFormatVersion ->
    semverFormatVersion
  }

  publishArtifactoryBuildInfoScript = {
      // put build info on module/artifacts then overwrite and publish artifactory build
      sh './scripts/publish_buildinfo.sh'
  }

  publishArtifactoryBuildInfo = {
    // create base build info
    rtBuildInfo (
      buildName: "${env.BUILD_NAME}",
      buildNumber: "${env.BUILD_NUMBER}",
      includeEnvPatterns: ['BRANCH_NAME'],
      maxDays: 90,
      deleteBuildArtifacts: true,
      asyncBuildRetention: true
    )
    rtPublishBuildInfo (
      buildName: "${env.BUILD_NAME}",
      buildNumber: "${env.BUILD_NUMBER}",
      serverId: 'taas-artifactory-upload'
    )
    publishArtifactoryBuildInfoScript()
  }

  scanCode = {
    withSonarQubeEnv(installationName: 'SonarQubeServer') {
      sh "${scannerHome}/bin/sonar-scanner -Dsonar.qualitygate.wait=true -Dsonar.projectKey=cloudant-${libName}-sdk -Dsonar.branch.name=${env.BRANCH_NAME} -Dsonar.exclusions=examples/**"
    }
  }
}

// Language specific implementations of the methods:
// applyCustomizations()
// runTests()
// publishStaging()
// publishPublic()
// publishDocs()
// + other customizations
void applyCustomizations() {
  libName = 'java'
  originalDoVersionBump = doVersionBump
  // Customize doVersionBump with maven version updates
  doVersionBump = { isDevRelease, newVersion ->
    // Bump the poms first
    sh "mvn versions:set -DnewVersion=${newVersion} -DgenerateBackupPoms=false"
    sh 'git add -A'
    // Then bump everything else and commit (note we need to allow dirty because of the updated poms)
    originalDoVersionBump(isDevRelease, newVersion, true)
  }
  customizePublishingInfo = {
    // Set the publishing names and types
    buildType = 'MAVEN'
    artifactUrl = "${STAGE_ROOT}storage/cloudant-sdks-maven-local/com/ibm/cloud/cloudant/${env.NEW_SDK_VERSION}"
    moduleId = "com.ibm.cloud:cloudant:${env.NEW_SDK_VERSION}"
  }

  scanCode = {
    withSonarQubeEnv(installationName: 'SonarQubeServer') {
      sh "mvn sonar:sonar -Dsonar.qualitygate.wait=true -Dsonar.branch.name=${env.BRANCH_NAME} -Dsonar.exclusions=examples/** --settings build/jenkins.settings.xml"
    }
  }
}

void runTests() {
  // Allow tests to run classes in parallel
  sh 'mvn verify -DperCoreThreadCount=false -DthreadCount=2 -Dparallel=classes --settings build/jenkins.settings.xml'
}

void publishStaging() {
  publishMaven('-P staging')
}

void publishPublic() {
  withCredentials([usernamePassword(credentialsId: 'central-portal', passwordVariable: 'CP_PSW', usernameVariable: 'CP_USR')]) {
    publishMaven('-P public')
  }
}

void publishMaven(mvnArgs='') {
  withCredentials([certificate(credentialsId: 'cldtsdks-signing-cert', keystoreVariable: 'CODE_SIGNING_PFX_FILE', passwordVariable: 'CODE_SIGNING_P12_PASSWORD')]) {
    sh '''
      #!/bin/bash -e
      # Configure the client
      setup-garasign-client

      export SIGNING_KEYID=$(grep 'Key ID' $HOME/.gnupggrs/keysinfo.txt | awk 'NR==1{print $5}')
    '''
    sh "mvn deploy --settings build/jenkins.settings.xml -DskipTests ${mvnArgs}"
  }
}

void publishDocs() {
  sh './scripts/javadoc/publish-doc.sh'
}

