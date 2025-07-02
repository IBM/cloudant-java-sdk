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
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.AllDocsResult;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsOptions.Builder;
import com.ibm.cloud.sdk.core.http.ServiceCall;

final class AllDocsPageIterator extends AllDocsBasePageIterator<Builder, PostAllDocsOptions> {

  AllDocsPageIterator(Cloudant client, PostAllDocsOptions options) {
     super(client, options, OptionsHandler.POST_ALL_DOCS);
  }

  @Override
  BiFunction<Cloudant, PostAllDocsOptions, ServiceCall<AllDocsResult>> nextRequestFunction() {
    return Cloudant::postAllDocs;
  }

  @Override
  BiFunction<Builder, String, Builder> nextKeySetter() {
    return Builder::startKey;
  }

}
