/**
 * © Copyright IBM Corporation 2025. All Rights Reserved.
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

package com.ibm.cloud.cloudant.features.pagination;

import java.util.function.BiFunction;
import java.util.function.Function;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.AllDocsResult;
import com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions.Builder;
import com.ibm.cloud.sdk.core.http.ServiceCall;

final class AllDocsPartitionPager extends AllDocsBasePager<PostPartitionAllDocsOptions.Builder, PostPartitionAllDocsOptions> {

  protected AllDocsPartitionPager(PostPartitionAllDocsOptions options) {
    super(options);
    //TODO Auto-generated constructor stub
  }

  @Override
  protected Function<PostPartitionAllDocsOptions, Builder> optionsToBuilderFunction() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getOptionsToBuilderFunction'");
  }

  @Override
  protected Function<Builder, PostPartitionAllDocsOptions> builderToOptionsFunction() {
    return Builder::build;
  }

  @Override
  protected BiFunction<Cloudant, PostPartitionAllDocsOptions, ServiceCall<AllDocsResult>> nextRequestFunction() {
    return Cloudant::postPartitionAllDocs;
  }


  @Override
  protected BiFunction<Builder, String, Builder> nextKeySetter() {
    return Builder::startKey;
  }

}
