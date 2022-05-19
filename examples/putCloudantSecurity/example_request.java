// section: code imports
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Ok;
import com.ibm.cloud.cloudant.v1.model.PutCloudantSecurityConfigurationOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// section: code
Cloudant service = Cloudant.newInstance();

Map<String, List<String>> securityObject = new HashMap<>();
securityObject.put("nobody", Arrays.asList("_reader"));

PutCloudantSecurityConfigurationOptions securityOptions =
    new PutCloudantSecurityConfigurationOptions.Builder()
        .db("products")
        .cloudant(securityObject)
        .build();

Ok response =
    service.putCloudantSecurityConfiguration(securityOptions)
        .execute()
        .getResult();

System.out.println(response);
// section: markdown
// The `nobody` username applies to all unauthenticated connection attempts. For example, if an application tries to read data from a database, but didn't identify itself, the task can continue only if the `nobody` user has the role `_reader`.
// section: markdown
// If instead of using Cloudant's security model for managing permissions you opt to use the Apache CouchDB `_users` database (that is using legacy credentials _and_ the `couchdb_auth_only:true` option) then be aware that the user must already exist in `_users` database before adding permissions. For information on the `_users` database, see <a href="https://cloud.ibm.com/docs/Cloudant?topic=Cloudant-work-with-your-account#using-the-users-database-with-cloudant-nosql-db" target="_blank">Using the `_users` database with Cloudant</a>.
