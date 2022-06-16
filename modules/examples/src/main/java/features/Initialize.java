/**
 * © Copyright IBM Corporation 2023. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package features;

import java.time.Duration;
import com.ibm.cloud.cloudant.features.ChangesFollower;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;

public class Initialize {
    public static void main(String[] args) {

        Cloudant client = Cloudant.newInstance();

        PostChangesOptions options = new PostChangesOptions.Builder("example") // Required: the database name.
            .limit(100) // Optional: return only 100 changes (including duplicates).
            .since("3-g1AG3...") // Optional: start from this sequence ID (e.g. with a value read from persistent storage).
            .build();
        ChangesFollower changesFollower = new ChangesFollower(
            client, // Required: the Cloudant service client instance.
            options, // Required: changes feed configuration options object.
            Duration.ofSeconds(10) // Optional: suppress transient errors for at least 10 seconds before terminating.
        );
    }
}
