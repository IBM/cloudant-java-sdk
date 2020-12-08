#!/bin/bash

# Store GIT properties in vars
GIT_COMMIT=$(git rev-parse --short HEAD)
GIT_REPO=$(git remote get-url origin)

# Clone gh-pages branch
printf ">>>>> Publishing javadoc for release build: repo=%s branch=%s build_num=%s job_name=%s" ${GIT_REPO} ${BRANCH_NAME} ${BUILD_NUMBER} ${JOB_NAME}
printf ">>>>> Cloning repository's gh-pages branch into directory 'gh-pages'"
git clone --branch=gh-pages https://${GH_CREDS}@github.com/IBM/cloudant-java-sdk.git gh-pages

printf ">>>>> Finished cloning..."

pushd gh-pages

# Create a new directory for this tag_name and copy the aggregated javadocs there, if it's a tagged release.
if [ -n "TAG_NAME" ]; then
  printf "\n>>>>> Copying aggregated javadocs to new tagged-release directory: %s\n" ${BRANCH_NAME}
  rm -rf docs/${TAG_NAME}
  mkdir -p docs/${TAG_NAME}
  cp -rf ../target/site/apidocs/* docs/${TAG_NAME}

  printf "\n>>>>> Generating gh-pages index.html...\n"
  ../build/generate-index-html.sh > index.html

  # Update the 'latest' symlink to point to this directory
  pushd docs
  rm latest
  ln -s ./${TAG_NAME} latest
  printf "\n>>>>> Updated 'docs/latest' symlink:\n"
  ls -l latest
  popd

  printf "\n>>>>> Setting credential details...\n"
  git config user.email '71659186+cloudant-sdks-automation@users.noreply.github.com'
  git config user.name 'cloudant-sdks-automation'

  printf "\n>>>>> Committing new javadoc...\n"
  git add -f .
  git commit -m "Javadoc for release ${TAG_NAME} (${GIT_COMMIT})"
  git push -f origin gh-pages

  popd

  printf "\n>>>>> Published javadoc for release build: repo=%s branch=%s build_num=%s job_name=%s\n" ${GIT_REPO} ${BRANCH_NAME} ${BUILD_NUMBER} ${JOB_NAME}
else
  printf "\n>>>>> Failed to publish javadoc for release build: TAG_NAME was empty\n"
fi

