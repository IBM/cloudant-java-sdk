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

import java.util.stream.Stream;
import com.ibm.cloud.cloudant.features.ChangesFollower;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.Change;
import com.ibm.cloud.cloudant.v1.model.ChangesResultItem;
import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;

public class StartAndProcess {
    public static void main(String[] args) {

        Cloudant client = Cloudant.newInstance();

        // Start from a perviously persisted seq
        // Normally this would be read by the app from persistent storage
        // e.g. String previouslyPersistedSeq = yourAppPersistenceReadFunction();
        String previouslyPersistedSeq = "3-g1AG3...";
        PostChangesOptions options = new PostChangesOptions.Builder("example")
            .since(previouslyPersistedSeq)
            .build();
        ChangesFollower changesFollower = new ChangesFollower(client, options);
        Stream<ChangesResultItem> changesItems = changesFollower.start();
        changesItems.forEach(changesItem -> {
            // do something with changes
            System.out.println(changesItem.getId());
            for (Change change : changesItem.getChanges()) {
                System.out.println(change.getRev());
            }
            // when change item processing is complete app can store seq
            String seq = changesItem.getSeq();
            // write seq to persistent storage for use as since if required to resume later
            // e.g. call yourAppPersistenceWriteFunction(seq);
        });
        // Note: java.util.Stream terminal operations are blocking, code here will be unreachable
        // until the stream is stopped or another stop condition is reached.
        // For long running followers careful consideration should be made of where the terminal
        // operation is invoked.
    }
}
