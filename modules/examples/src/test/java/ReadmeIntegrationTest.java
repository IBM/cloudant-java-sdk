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

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadmeIntegrationTest {

  @BeforeClass
  void resetWiremockScenarios() throws Exception {
    String wiremockUrl = System.getenv("WIREMOCK_URL");
    Assert.assertNotNull(wiremockUrl, "WIREMOCK_URL environment variable should be set.");
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create(wiremockUrl + "/__admin/scenarios/reset"))
      .timeout(Duration.ofMinutes(1))
      .header("Content-Type", "application/json")
      .POST(BodyPublishers.ofString("{}"))
      .build();
    HttpResponse<Void> response = client.send(request, BodyHandlers.discarding());
    Assert.assertEquals(response.statusCode(), 200, "Resetting wiremock scenarios should receive status 200.");
  }

  void runTest(Runnable test, String pathToExpectedOutputFile) throws Exception {
    String expectedOutput = new String(
        Files.readAllBytes(new File(pathToExpectedOutputFile).toPath()), StandardCharsets.UTF_8);
    PrintStream originalStdOut = System.out;
    String capturedOutput = null;
    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream capturedStdOut =
            new PrintStream(new BufferedOutputStream(out), true, StandardCharsets.UTF_8)) {
      System.setOut(capturedStdOut);
      test.run();
      capturedOutput = out.toString(StandardCharsets.UTF_8);
    } finally {
      System.setOut(originalStdOut);
    }
    Assert.assertEquals(capturedOutput, expectedOutput);
  }

  @Test
  void createDbAndDocFirstTime() throws Exception {
    runTest(() -> CreateDbAndDoc.main(new String[0]), "output/CreateDbAndDoc.txt");
  }

  @Test(dependsOnMethods = {"createDbAndDocFirstTime"})
  void getDocumentFromOrdersDatabase() throws Exception {
    runTest(() -> GetInfoFromExistingDatabase.main(new String[0]),
        "output/GetInfoFromExistingDatabase.txt");
  }

  @Test(dependsOnMethods = {"getDocumentFromOrdersDatabase"})
  void updateDocFirstTime() throws Exception {
    runTest(() -> UpdateDoc.main(new String[0]), "output/UpdateDoc.txt");
  }

  @Test(dependsOnMethods = {"updateDocFirstTime"})
  void updateDocSecondTime() throws Exception {
    runTest(() -> UpdateDoc.main(new String[0]), "output/UpdateDoc2.txt");
  }

  @Test(dependsOnMethods = {"updateDocSecondTime"})
  void deleteExistingDoc() throws Exception {
    runTest(() -> DeleteDoc.main(new String[0]), "output/DeleteDoc.txt");
  }

  @Test(dependsOnMethods = {"deleteExistingDoc"})
  void deleteNonExistantDoc() throws Exception {
    runTest(() -> DeleteDoc.main(new String[0]), "output/DeleteDoc2.txt");
  }

}
