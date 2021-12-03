#!groovy

pipeline {
  agent {
    label 'sdks-executor'
  }
  options {
    skipDefaultCheckout()
  }
  environment {
    GH_CREDS = credentials('gh-sdks-automation')
    STAGE_ROOT = 'https://na.artifactory.swg-devops.com/artifactory/api/'
    buildType = ''
  }
  stages {
    stage('Checkout') {
      steps {
        script {
          defaultInit()
          applyCustomizations()
          checkoutResult = checkout scm
          commitHash = "${checkoutResult.GIT_COMMIT[0..6]}"
          sh '''
            git config --global user.email $GH_SDKS_AUTOMATION_MAIL
            git config --global user.name $GH_CREDS_USR
            git config --global credential.username $GH_CREDS_USR
            git config --global credential.helper '!f() { echo password=\$GH_CREDS_PSW; echo; }; f'
          '''
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
              sh './scripts/setup_couch.sh'
              sh './scripts/setup_wiremock.sh'
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
    stage('Publish[staging]') {
      steps {
        bumpVersion(true)
        publishStaging()
        publishArtifactoryBuildInfo()
      }
    }
    stage('Run Gauge tests') {
      steps {
        script {
            buildResults = null
            prefixedSdkVersion = ''
            if (libName == 'go') {
              prefixedSdkVersion = "@$commitHash"
            } else if (libName == 'node') {
              prefixedSdkVersion = "@${env.NEW_SDK_VERSION}"
            } else if (libName == 'python') {
              prefixedSdkVersion = "==${env.NEW_SDK_VERSION}"
            } else if (libName == 'java') {
              prefixedSdkVersion = "${env.NEW_SDK_VERSION}"
            }
          try {
            buildResults = build job: "/${env.SDKS_GAUGE_PIPELINE_PROJECT}/${env.BRANCH_NAME}", parameters: [
                string(name: 'SDK_RUN_LANG', value: "$libName"),
                string(name: "SDK_VERSION_${libName.toUpperCase()}", value: "$prefixedSdkVersion")]
          } catch (Exception e) {
            // only run build in sdks-gauge master branch if BRANCH_NAME doesn't exist
            if (buildResults == null) {
              echo "No matching branch named '${env.BRANCH_NAME}' in sdks-gauge, building master branch"
              build job: "/${env.SDKS_GAUGE_PIPELINE_PROJECT}/master", parameters: [
                  string(name: 'SDK_RUN_LANG', value: "$libName"),
                  string(name: "SDK_VERSION_${libName.toUpperCase()}", value: "$prefixedSdkVersion")]
            }
          }
        }
      }
    }
    stage('Publish[repository]') {
      when {
        beforeAgent true
        allOf {
          // Publish master branch, but not on the version update commit after just publishing
          branch 'master'
          not {
            changelog 'Update version.*'
          }
        }
      }
      steps {
        // Throw away any temporary version changes used for stage/test
        sh 'git reset --hard'
        bumpVersion(false)
        // Push the version bump and release tag
        sh 'git push --tags origin HEAD:master'
        publishPublic()
        publishDocs()
      }
    }
  }
}

def libName
def commitHash
def bumpVersion
def customizeVersion
def prefixSdkVersion
def customizePublishingInfo
def publishArtifactoryBuildInfo
def artifactUrl = ''
def moduleId = ''
def buildName = ''
def buildType = ''

void defaultInit() {
  // Default to using bump2version
  bumpVersion = { isDevRelease ->
    newVersion = getNextVersion(isDevRelease)
    // Set an env var with the new version
    env.NEW_SDK_VERSION = newVersion
    doVersionBump(isDevRelease, newVersion)
  }

  doVersionBump = { isDevRelease, newVersion, allowDirty ->
    sh "bump2version --new-version ${newVersion} ${allowDirty ? '--allow-dirty': ''} ${isDevRelease ? '--no-commit' : '--tag --tag-message "Release {new_version}"'} patch"
  }

  getNextVersion = { isDevRelease ->
    // Identify what the next patch version is
    patchBumpedVersion = sh returnStdout: true, script: 'bump2version --list --dry-run patch | grep new_version=.* | cut -f2 -d='
    // Now the customized new version
    return getNewVersion(isDevRelease, patchBumpedVersion)
  }

  // Default no-op implementation to use semverFormatVersion
  customizeVersion = { semverFormatVersion ->
    semverFormatVersion
  }

  // Default no-op, may be overridden
  customizePublishingInfo = {}

  publishArtifactoryBuildInfo = {
    // create custom build name e.g. SDKs::cloudant-node-sdk::generated-branch
    buildName = "${env.JOB_NAME}".replaceAll('/', '::')
    buildType = 'GENERIC' // default, may be overridden
    customizePublishingInfo()
    withEnv(["LIB_NAME=${libName}",
      "TYPE=${buildType}",
      "ARTIFACT_URL=${artifactUrl}",
      "MODULE_ID=${moduleId}",
      "BUILD_NAME=${buildName}"]) {
      withCredentials([usernamePassword(credentialsId: 'artifactory', passwordVariable: 'ARTIFACTORY_APIKEY', usernameVariable: 'ARTIFACTORY_USER')]) {
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
        // put build info on module/artifacts then overwrite and publish artifactory build
        sh './scripts/publish_buildinfo.sh'
      }
    }
  }
}

String getNewVersion(isDevRelease, version) {
  wipVersion = ''
  if (isDevRelease) {
    // Add uniqueness and build metadata to dev build versions
    wipVersion = "${version.trim()}-dev${currentBuild.startTimeInMillis}+${commitHash}.${currentBuild.number}"
  } else {
    wipVersion = "${version.trim()}"
  }
  // Customize with lang specific requirements
  return customizeVersion(wipVersion)
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
}

void runTests() {
  sh 'mvn test'
}

void publishStaging() {
  withCredentials([usernamePassword(credentialsId: 'artifactory', passwordVariable: 'ARTIFACTORY_APIKEY', usernameVariable: 'ARTIFACTORY_USER')]) {
    publishMaven('-P artifactory')
  }
}

void publishPublic() {
  withCredentials([usernamePassword(credentialsId: 'ossrh', passwordVariable: 'OSSRH_PSW', usernameVariable: 'OSSRH_USR')]) {
    publishMaven('-P central')
  }
}

void publishMaven(mvnArgs='') {
  withCredentials([usernamePassword(credentialsId: 'signing-creds', passwordVariable: 'SIGNING_PSW', usernameVariable: 'SIGNING_USR'),
                   file(credentialsId: 'signing-key', variable: 'SIGNING_KEYFILE')]) {
    sh "mvn deploy --settings build/.travis.settings.xml -DskipTests ${mvnArgs}"
  }
}

void publishDocs() {
  sh './scripts/javadoc/publish-doc.sh'
}

