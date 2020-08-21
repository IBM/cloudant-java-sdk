#!/bin/bash

if [ $# -lt 5 ]
then
    echo "
 Syntax:
      $0 <bintray-user> <bintray-apikey> <bintray-repo-owner> <bintray-reponame> <bintray-packageversion>>
 Example:
      $0 btuser1 btapikey1 bintray-org1 bintray-repo1 0.0.1
"

 exit 1
fi

user=$1
apikey=$2
subject=$3
reponame=$4
pkgversion=$5

# List of maven artifacts to be sync'd from bintray to maven central"
package_names="
com.ibm.cloud:cloudant-parent
com.ibm.cloud:cloudant-common
com.ibm.cloud:cloudant"

this_dir=`dirname "$0"`

for pkg in ${package_names}
do
    $this_dir/sync2MC.sh $user $apikey $subject $reponame $pkg $pkgversion
done
