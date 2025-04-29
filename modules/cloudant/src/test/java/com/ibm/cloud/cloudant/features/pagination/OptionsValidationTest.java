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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.ibm.cloud.cloudant.v1.model.PostAllDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostDesignDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostFindOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionAllDocsOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionFindOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionSearchOptions;
import com.ibm.cloud.cloudant.v1.model.PostPartitionViewOptions;
import com.ibm.cloud.cloudant.v1.model.PostSearchOptions;
import com.ibm.cloud.cloudant.v1.model.PostViewOptions;

public class OptionsValidationTest {

  private static final OptionsWrapper<PostSearchOptions.Builder, PostSearchOptions> SEARCH_OPTS_WRAPPER =
      new OptionsWrapper<>(OptionsHandler.POST_SEARCH, PostSearchOptions.Builder::new);

  private static final class OptionsWrapper<B, O> {

    private final OptionsHandler<B, O> handler;
    private final Supplier<B> builderSupplier;

    OptionsWrapper(OptionsHandler<B, O> handler, Supplier<B> builderSupplier) {
      this.handler = handler;
      this.builderSupplier = builderSupplier;
    }

    OptionsProvider<B, O> newProvider() {
      return new OptionsProvider<B, O>(this.handler, this.builderSupplier.get());
    }

  }

  private static final class OptionsProvider<B, O> {

    private final OptionsHandler<B, O> handler;
    private final B builder;

    OptionsProvider(OptionsHandler<B, O> handler, B builder) {
      this.handler = handler;
      this.builder = builder;
    }

    void setRequiredOpts() throws Exception {
      // database is always required
      this.set("db", "testdb");

      // For partitioned operations we need
      // partitionKey
      if (OptionsHandler.POST_PARTITION_ALL_DOCS.equals(handler)
          || OptionsHandler.POST_PARTITION_FIND.equals(handler)
          || OptionsHandler.POST_PARTITION_SEARCH.equals(handler)
          || OptionsHandler.POST_PARTITION_VIEW.equals(handler)) {
        this.set("partitionKey", "testpart");
      }

      // For find operations we need
      // selector
      if (OptionsHandler.POST_FIND.equals(handler)
          || OptionsHandler.POST_PARTITION_FIND.equals(handler)) {
        Map<String, Object> selector = Collections.emptyMap();
        this.set("selector", selector);
      }

      // For search operations we need
      // ddoc
      // index
      // query
      if (OptionsHandler.POST_PARTITION_SEARCH.equals(handler)
          || OptionsHandler.POST_SEARCH.equals(handler)) {
        this.set("ddoc", "testddoc");
        this.set("index", "testsearchindex");
        this.set("query", "*:*");
      }

      // For view operations we need
      // ddoc
      // view
      if (OptionsHandler.POST_PARTITION_VIEW.equals(handler)
          || OptionsHandler.POST_VIEW.equals(handler)) {
        this.set("ddoc", "testddoc");
        this.set("view", "testview");
      }
    }

    void set(String name, Object... values) throws Exception {
      List<Class<?>> argTypes = Arrays.asList(values).stream().map(a -> {
        Class<?> c = a.getClass();
        if (List.class.isAssignableFrom(c)) {
          c = List.class;
        }
        if (Long.class.equals(c)) {
          c = long.class;
        }
        if (Map.class.isAssignableFrom(c)) {
          c = Map.class;
        }
        return c;
      }).collect(Collectors.toList());
      Class<?>[] argTypesArray = argTypes.toArray(new Class[argTypes.size()]);
      Method method = this.builder.getClass().getMethod(name, argTypesArray);
      method.invoke(this.builder, values);
    }

    O build() {
      return this.handler.optionsFromBuilder(this.builder);
    }

  }

  List<OptionsWrapper<?, ?>> allDocsOptions = List.of(
      new OptionsWrapper<>(OptionsHandler.POST_ALL_DOCS, PostAllDocsOptions.Builder::new),
      new OptionsWrapper<>(OptionsHandler.POST_PARTITION_ALL_DOCS,
          PostPartitionAllDocsOptions.Builder::new),
      new OptionsWrapper<>(OptionsHandler.POST_DESIGN_DOCS, PostDesignDocsOptions.Builder::new));

  List<OptionsWrapper<?, ?>> viewOptions =
      List.of(new OptionsWrapper<>(OptionsHandler.POST_VIEW, PostViewOptions.Builder::new),
          new OptionsWrapper<>(OptionsHandler.POST_PARTITION_VIEW,
              PostPartitionViewOptions.Builder::new));

  List<OptionsWrapper<?, ?>> viewLikeOptions =
      Stream.of(allDocsOptions, viewOptions).flatMap(List::stream).collect(Collectors.toList());

  List<OptionsWrapper<?, ?>> findOptions =
      List.of(new OptionsWrapper<>(OptionsHandler.POST_FIND, PostFindOptions.Builder::new),
          new OptionsWrapper<>(OptionsHandler.POST_PARTITION_FIND,
              PostPartitionFindOptions.Builder::new));

  List<OptionsWrapper<?, ?>> searchOptions =
      List.of(SEARCH_OPTS_WRAPPER, new OptionsWrapper<>(OptionsHandler.POST_PARTITION_SEARCH,
          PostPartitionSearchOptions.Builder::new));

  List<OptionsWrapper<?, ?>> allOptions = Stream.of(findOptions, searchOptions, viewLikeOptions)
      .flatMap(List::stream).collect(Collectors.toList());

  @DataProvider(name = "allOptions")
  public Iterator<Object[]> allOptions() {
    return allOptions.stream().map(w -> {
      return new Object[] {w.newProvider()};
    }).iterator();
  }

  @DataProvider(name = "findOptions")
  public Iterator<Object[]> findOptions() {
    return findOptions.stream().map(w -> {
      return new Object[] {w.newProvider()};
    }).iterator();
  }

  @DataProvider(name = "searchOptions")
  public Iterator<Object[]> searchOptions() {
    return searchOptions.stream().map(w -> {
      return new Object[] {w.newProvider()};
    }).iterator();
  }

  @DataProvider(name = "searchFacetOptions")
  public Iterator<Object[]> facets() {
    List<Object[]> options = new ArrayList<>(5);
    options.add(new Object[] {"counts", Collections.singletonList("aTestFieldToCount")});
    options.add(new Object[] {"groupField", "testField"});
    options.add(new Object[] {"groupLimit", 6L});
    options.add(new Object[] {"groupSort", Collections.singletonList("aTestFieldToGroupSort")});
    options.add(new Object[] {"ranges", Collections.singletonMap("aTestFieldForRanges",
        Map.of("low", "[0 TO 5}", "high", "[5 TO 10]"))});
    return options.iterator();
  }

  @DataProvider(name = "viewLikeOptions")
  public Iterator<Object[]> viewLikeOptions() {
    return viewLikeOptions.stream().map(w -> {
      return new Object[] {w.newProvider()};
    }).iterator();
  }

  @Test(dataProvider = "allOptions")
  public <B, O> void testOptionsValidationLimitLessThanMin(OptionsProvider<B, O> provider)
      throws Exception {
    provider.setRequiredOpts();
    provider.set("limit", OptionsHandler.MIN_LIMIT - 1);
    Assert.assertThrows("There should be a validation exception", IllegalArgumentException.class,
        () -> {
          provider.handler.validate(provider.build());
        });
  }

  @Test(dataProvider = "allOptions")
  public <B, O> void testOptionsValidationLimitEqualToMin(OptionsProvider<B, O> provider)
      throws Exception {
    provider.setRequiredOpts();
    provider.set("limit", OptionsHandler.MIN_LIMIT);
    try {
      provider.handler.validate(provider.build());
    } catch (IllegalArgumentException e) {
      Assert.fail("There should be no validation exception.", e);
    }
  }

  @Test(dataProvider = "allOptions")
  public <B, O> void testOptionsValidationLimitLessThanMax(OptionsProvider<B, O> provider)
      throws Exception {
    provider.setRequiredOpts();
    provider.set("limit", OptionsHandler.MAX_LIMIT - 1);
    try {
      provider.handler.validate(provider.build());
    } catch (IllegalArgumentException e) {
      Assert.fail("There should be no validation exception.", e);
    }
  }

  @Test(dataProvider = "allOptions")
  public <B, O> void testOptionsValidationLimitEqualToMax(OptionsProvider<B, O> provider)
      throws Exception {
    provider.setRequiredOpts();
    provider.set("limit", OptionsHandler.MAX_LIMIT);
    try {
      provider.handler.validate(provider.build());
    } catch (IllegalArgumentException e) {
      Assert.fail("There should be no validation exception.", e);
    }
  }

  @Test(dataProvider = "allOptions")
  public <B, O> void testOptionsValidationLimitGreaterThanMax(OptionsProvider<B, O> provider)
      throws Exception {
    provider.setRequiredOpts();
    provider.set("limit", OptionsHandler.MAX_LIMIT + 1);
    Assert.assertThrows("There should be a validation exception", IllegalArgumentException.class,
        () -> {
          provider.handler.validate(provider.build());
        });
  }

  @Test(dataProvider = "allOptions")
  public <B, O> void testOptionsValidationLimitUnset(OptionsProvider<B, O> provider)
      throws Exception {
    provider.setRequiredOpts();
    try {
      provider.handler.validate(provider.build());
    } catch (IllegalArgumentException e) {
      Assert.fail("There should be no validation exception.", e);
    }
  }

  @Test(dataProvider = "viewLikeOptions")
  public <B, O> void testValidationExceptionForKeys(OptionsProvider<B, O> provider)
      throws Exception {
    provider.setRequiredOpts();
    provider.set("keys", List.of("key1", "key2"));
    Assert.assertThrows("There should be a validation exception", IllegalArgumentException.class,
        () -> {
          provider.handler.validate(provider.build());
        });
  }

  public void testValidationExceptionForFacetedSearch(String optionName, Object optionValue)
      throws Exception {
    OptionsProvider<PostSearchOptions.Builder, PostSearchOptions> provider =
        SEARCH_OPTS_WRAPPER.newProvider();
    provider.setRequiredOpts();
    provider.set(optionName, optionValue);
    Assert.assertThrows("There should be a validation exception", IllegalArgumentException.class,
        () -> {
          provider.handler.validate(provider.build());
        });
  }

}
