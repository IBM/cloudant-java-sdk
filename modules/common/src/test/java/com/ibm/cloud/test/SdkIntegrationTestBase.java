/**
 * © Copyright IBM Corporation 2020, 2023. All Rights Reserved.
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

package com.ibm.cloud.test;

import java.io.File;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * This class provides common functionality used by integration tests.
 */
public abstract class SdkIntegrationTestBase {

    // Default behavior is to skip tests, unless we have a valid config file.
    protected boolean skipTests = true;

    private File configFile = null;

    /**
     * Returns true if and only if test methods within the subclass should be skipped due to
     * lack of an external configuration file.
     * @return
     */
    protected boolean skipTests() {
        return skipTests;
    }


    /**
     * Each subclass must implement this method in order to provide the name of the
     * testcase's config file.
     * @return the name of the config file associated with the testcase
     */
    public abstract String getConfigFilename();

    /**
     * Perform the necessary setup steps to ensure that the java core will be able to
     * detect the presence of a credentials file if the testcase requests that one be loaded and used.
     * This function is also responsible for setting the "skipTests" flag appropriately based on whether or
     * not the specified config file exists.
     *
     * @throws Exception
     * @throws InterruptedException
     */
    @BeforeClass
    public void setUpConfig() throws Exception, InterruptedException {
        // Determine if the tests within the subclass should be skipped,
        // based on whether or not the config file exists.
        configFile = new File(getConfigFilename());
        if (!configFile.exists()) {
            skipTests = true;
            System.out.println(
                    String.format(">>> Configuration file %s not found, skipping tests.",
                            configFile.getCanonicalPath()));
        } else {
            skipTests = false;

            // Set the system property to point to the config file.
            System.setProperty("IBM_CREDENTIALS_FILE", getConfigFilename());
        }
    }

    @BeforeMethod
    public void shouldSkipTest() {
        if (skipTests()) {
            throw new SkipException("Skipping test...");
        }
    }
}
