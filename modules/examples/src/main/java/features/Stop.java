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
import com.ibm.cloud.cloudant.v1.model.ChangesResultItem;
import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;

public class Stop {
    public static void main(String[] args) {

        Cloudant client = Cloudant.newInstance();

        PostChangesOptions options = new PostChangesOptions.Builder("example")
            .build();
        ChangesFollower changesFollower = new ChangesFollower(client, options);
        Stream<ChangesResultItem> changesItems = changesFollower.start();
        changesItems.forEach(changesItem -> {
            // Option 1: call stop after some condition.
            // Note that at least one change item must be returned
            // from the stream to reach to this point.
            // Note additional changes may be processed before the Stream stops.
            changesFollower.stop();
        });

        // Option 2: call stop method when you want to end the continuous loop from
        // outside the Stream.  For example, you've put the changes follower in a
        // separate thread and need to call stop on the main thread.
        // N.B. In this context the call must be made from a different thread because
        // code immediately following a Stream terminal operation is unreachable until
        // the Stream has stopped.
        changesFollower.stop();
    }
}
