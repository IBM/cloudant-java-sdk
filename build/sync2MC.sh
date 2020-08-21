#!/bin/bash

if [ $# -lt 6 ]
then
    echo "
 Syntax:  
      $0 <bintray-user> <bintray-apikey> <bintray-repo-owner> <bintray-reponame> <bintray-packagename> <bintray-packageversion>>
 Example:
      $0 btuser1 btapikey1 bintray-org1 bintray-repo1 my-bintray-package 0.0.1
"

 exit 1
fi

user=$1
apikey=$2
subject=$3
reponame=$4
pkgname=$5
pkgversion=$6

urlstring="https://api.bintray.com/maven_central_sync/${subject}/${reponame}/${pkgname}/versions/${pkgversion}"

basicauth="${user}:${apikey}"

set -x

time curl -X POST --data '{ "close": "1" }' -H "Content-Type: application/json" -L -k --max-time 600 --user ${basicauth} ${urlstring}
