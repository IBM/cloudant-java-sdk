/**
 * © Copyright IBM Corporation 2022. All Rights Reserved.
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

package com.ibm.cloud.cloudant.features;

import com.ibm.cloud.cloudant.features.ChangesFollower.Mode;
import com.ibm.cloud.cloudant.v1.model.PostChangesOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Tests for ChangesOptionsHelper.
 * Parameterized with either valid or invalid option sets.
 */
public class ChangesOptionsHelperTest {

    @DataProvider(name = "validOptions")
    Object[][] getValidOptionsDataProvider() {
        return TestOptions.filteredValuesAsDataProvider(TestOptions::valid);
    }

    @DataProvider(name = "validOptionsBothModes")
    Iterator<Object[]> getValidOptionsAndModesDataProvider() {
        List<Object[]> options = new ArrayList<>();
        for (Mode mode : Mode.values()) {
            for (Object[] opts : getValidOptionsDataProvider()) {
                // Add the valid opts
                List<Object> modeOpts= new ArrayList<>(Arrays.asList(opts));
                // Add the mode
                modeOpts.add(mode);
                options.add(modeOpts.toArray(new Object[modeOpts.size()]));
            }
        }
        return options.iterator();
    }

    @DataProvider(name = "invalidOptions")
    Object[][] getInvalidOptionsDataProvider() {
        return TestOptions.filteredValuesAsDataProvider(o -> !o.valid());
    }

    @Test(dataProvider = "validOptionsBothModes")
    void testCloneOptions(String name, TestOptions opts, Mode mode) {
        PostChangesOptions expected = opts.getExpectedOptions(mode);
        Assert.assertNotNull(expected);
        PostChangesOptions cloned = ChangesOptionsHelper.cloneOptions(expected);
        // Can't use assertNotSame in testng 7.4 because https://github.com/cbeust/testng/issues/2486
        Assert.assertFalse(cloned == expected, "The clone should not be the original options object.");
        Assert.assertEquals(cloned, expected, "The clone should equal the original options object.");
    }

    @Test(dataProvider = "validOptionsBothModes")
    void testCloneOptionsWithNewLimit(String name, TestOptions opts, Mode mode) {
        Long newLimit = 50L;
        PostChangesOptions original = opts.getOptions();
        PostChangesOptions expected = opts.getExpectedOptionsBuilder(mode).limit(newLimit).build();
        PostChangesOptions newLimitOpts = ChangesOptionsHelper.cloneOptionsWithModeAndNewLimit(original, mode, newLimit);
        // Can't use assertNotSame in testng 7.4 because https://github.com/cbeust/testng/issues/2486
        Assert.assertFalse(newLimitOpts == original, "The clone should not be the original options object.");
        Assert.assertNotEquals(newLimitOpts, original, "The clone should not equal the original options object.");
        Assert.assertEquals(newLimitOpts.limit(), newLimit, "The clone should have the correct new limit.");
        Assert.assertEquals(newLimitOpts, expected, "The clone should equal the expected options object.");
    }

    @Test(dataProvider = "validOptions")
    void testCloneOptionsWithNewSince(String name, TestOptions opts) {
        String newSince = "9876-alotofcharactersthatarenotreallyrandom";
        PostChangesOptions original = opts.getOptions();
        PostChangesOptions expected = opts.getExpectedOptionsBuilder(null).since(newSince).build();
        PostChangesOptions newSinceOpts = ChangesOptionsHelper.cloneOptionsWithNewSince(original, newSince);
        // Can't use assertNotSame in testng 7.4 because https://github.com/cbeust/testng/issues/2486
        Assert.assertFalse(newSinceOpts == original, "The clone should not be the original options object.");
        Assert.assertNotEquals(newSinceOpts, original, "The clone should not equal the original options object.");
        Assert.assertEquals(newSinceOpts.since(), newSince, "The clone should have the correct new since.");
        Assert.assertEquals(newSinceOpts, expected, "The clone should equal the expected options object.");
    }

    @Test(dataProvider = "validOptions")
    void testValidateOptionsValidCases(String name, TestOptions opts) {
        try {
            ChangesOptionsHelper.validateOptions(opts.getOptions());
        } catch (IllegalArgumentException e) {
            Assert.fail("There should be no illegal argument exception.", e);
        }
        // No exception expected
    }

    @Test(dataProvider = "invalidOptions")
    void testValidateOptionsInvalidCases(String name, TestOptions opts) {
        IllegalArgumentException e = Assert.expectThrows(IllegalArgumentException.class, () -> {
            ChangesOptionsHelper.validateOptions(opts.getOptions());
        });
        // Assert message switch
        String msg = e.getMessage();
        String optionName = "TEST_VAR_UNSET";
        switch(opts) {
            case DESCENDING:
                optionName = "descending";
                break;
            case FEED:
                optionName = "feed";
                break;
            case HEARTBEAT:
                optionName = "heartbeat";
                break;
            case LAST_EVENT_ID:
                optionName = "lastEventId";
                break;
            case TIMEOUT:
                optionName = "timeout";
                break;
            case NONE:
                // This is a special case for the required parameter "db"
                Assert.assertEquals(msg, "db cannot be empty");
                // don't break, return to avoid single message assertion case.
                return;
            case MULTI_INVALID:
                Assert.assertEquals(msg, String.format(
                "The options 'descending', 'feed', 'heartbeat', 'lastEventId', 'timeout' are invalid when using %s.",
                        ChangesFollower.class.getSimpleName()),
            "The error message should be correct.");
                // don't break, return to avoid single message assertion case.
                return;
            // Invalid filters
            case DOC_IDS:
            case DOC_ID_FILTER:
                optionName = "filter=_doc_ids";
                break;
            case DDOC_FILTER:
                optionName = "filter=foo/bar";
                break;
            case DESIGN_FILTER:
                optionName = "filter=_design";
                break;
            case VIEW:
            case VIEW_FILTER:
                optionName = "filter=_view";
                break;
            // Default is to fail for an unknown invalid option
            default:
                Assert.assertFalse(opts.valid(), "Should only be testing invalid cases.");
                Assert.fail("Invalid options case not implemented: " + opts.name());
                break;
        }
        Assert.assertEquals(msg, 
            String.format("The option '%s' is invalid when using %s.", optionName, ChangesFollower.class.getSimpleName()),
            "The error message should be correct.");
    }

    @Test
    void testNoDbOption() {
        Assert.assertThrows("There should be a validation exception with no database option.",
        IllegalArgumentException.class, () ->
            TestOptions.NONE.getBuilder().build()
        );
    }
}
