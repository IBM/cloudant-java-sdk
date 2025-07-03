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

import java.util.List;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.OptionsProvider;
import com.ibm.cloud.cloudant.features.pagination.PaginationTestHelpers.OptionsWrapper;
import com.ibm.cloud.cloudant.v1.model.PostSearchOptions;

public class OptionsValidationTest {

  @Test(dataProvider = "allOptions", dataProviderClass = PaginationTestHelpers.class)
  public void testOptionsValidationLimitLessThanMin(OptionsProvider<Object, Object> provider)
      throws Exception {
    provider.setRequiredOpts();
    provider.set("limit", OptionsHandler.MIN_LIMIT - 1);
    Assert.assertThrows("There should be a validation exception", IllegalArgumentException.class,
        () -> {
          provider.handler.validate(provider.build());
        });
  }

  @Test(dataProvider = "allOptions", dataProviderClass = PaginationTestHelpers.class)
  public void testOptionsValidationLimitEqualToMin(OptionsProvider<Object, Object> provider)
      throws Exception {
    provider.setRequiredOpts();
    provider.set("limit", OptionsHandler.MIN_LIMIT);
    try {
      provider.handler.validate(provider.build());
    } catch (IllegalArgumentException e) {
      Assert.fail("There should be no validation exception.", e);
    }
  }

  @Test(dataProvider = "allOptions", dataProviderClass = PaginationTestHelpers.class)
  public void testOptionsValidationLimitLessThanMax(OptionsProvider<Object, Object> provider)
      throws Exception {
    provider.setRequiredOpts();
    provider.set("limit", OptionsHandler.MAX_LIMIT - 1);
    try {
      provider.handler.validate(provider.build());
    } catch (IllegalArgumentException e) {
      Assert.fail("There should be no validation exception.", e);
    }
  }

  @Test(dataProvider = "allOptions", dataProviderClass = PaginationTestHelpers.class)
  public void testOptionsValidationLimitEqualToMax(OptionsProvider<Object, Object> provider)
      throws Exception {
    provider.setRequiredOpts();
    provider.set("limit", OptionsHandler.MAX_LIMIT);
    try {
      provider.handler.validate(provider.build());
    } catch (IllegalArgumentException e) {
      Assert.fail("There should be no validation exception.", e);
    }
  }

  @Test(dataProvider = "allOptions", dataProviderClass = PaginationTestHelpers.class)
  public void testOptionsValidationLimitGreaterThanMax(OptionsProvider<Object, Object> provider)
      throws Exception {
    provider.setRequiredOpts();
    provider.set("limit", OptionsHandler.MAX_LIMIT + 1);
    Assert.assertThrows("There should be a validation exception", IllegalArgumentException.class,
        () -> {
          provider.handler.validate(provider.build());
        });
  }

  @Test(dataProvider = "allOptions", dataProviderClass = PaginationTestHelpers.class)
  public void testOptionsValidationLimitUnset(OptionsProvider<Object, Object> provider)
      throws Exception {
    provider.setRequiredOpts();
    try {
      provider.handler.validate(provider.build());
    } catch (IllegalArgumentException e) {
      Assert.fail("There should be no validation exception.", e);
    }
  }

  @Test(dataProvider = "viewLikeOptions", dataProviderClass = PaginationTestHelpers.class)
  public void testValidationExceptionForKeys(OptionsProvider<Object, Object> provider)
      throws Exception {
    provider.setRequiredOpts();
    provider.set("keys", List.of("key1", "key2"));
    Assert.assertThrows("There should be a validation exception", IllegalArgumentException.class,
        () -> {
          provider.handler.validate(provider.build());
        });
  }

  @Test(dataProvider = "searchFacetOptions", dataProviderClass = PaginationTestHelpers.class)
  public void testValidationExceptionForFacetedSearch(String optionName, Object optionValue)
      throws Exception {
    OptionsProvider<PostSearchOptions.Builder, PostSearchOptions> provider =
        OptionsWrapper.POST_SEARCH.newProvider();
    provider.setRequiredOpts();
    provider.set(optionName, optionValue);
    Assert.assertThrows("There should be a validation exception", IllegalArgumentException.class,
        () -> {
          provider.handler.validate(provider.build());
        });
  }

  @Test(dataProvider = "allDocsOptions", dataProviderClass = PaginationTestHelpers.class)
  public void testValidationExceptionForAllDocsKey(OptionsProvider<Object, Object> provider)
      throws Exception {
    provider.setRequiredOpts();
    provider.set("key", "foo");
    Assert.assertThrows("There should be a validation exception", IllegalArgumentException.class,
        () -> {
          try {
            provider.handler.validate(provider.build());
          } catch (IllegalArgumentException e) {
            Assert.assertTrue(e.getMessage().endsWith(
                "The option 'key' is invalid when using pagination. No need to paginate as 'key' returns a single result for an ID."));
            throw e;
          }
        });
  }

  @Test(dataProvider = "viewOptions", dataProviderClass = PaginationTestHelpers.class)
  public void testValidationExceptionForViewsKey(OptionsProvider<Object, Object> provider)
      throws Exception {
    provider.setRequiredOpts();
    provider.set("key", new Object());
    Assert.assertThrows("There should be a validation exception", IllegalArgumentException.class,
        () -> {
          try {
            provider.handler.validate(provider.build());
          } catch (IllegalArgumentException e) {
            Assert.assertTrue(e.getMessage().endsWith(
                "The option 'key' is invalid when using pagination. Use startKey and endKey instead."));
            throw e;
          }
        });
  }
}
