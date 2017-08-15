// Copyright 2015 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package dfp.axis.v201708.creativeservice;

import com.beust.jcommander.Parameter;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.ads.common.lib.utils.examples.CodeSampleParams;
import com.google.api.ads.dfp.axis.factory.DfpServices;
import com.google.api.ads.dfp.axis.utils.v201708.StatementBuilder;
import com.google.api.ads.dfp.axis.v201708.Creative;
import com.google.api.ads.dfp.axis.v201708.CreativePage;
import com.google.api.ads.dfp.axis.v201708.CreativeServiceInterface;
import com.google.api.ads.dfp.axis.v201708.HasDestinationUrlCreative;
import com.google.api.ads.dfp.lib.client.DfpSession;
import com.google.api.ads.dfp.lib.utils.examples.ArgumentNames;
import com.google.api.client.auth.oauth2.Credential;
import com.google.common.collect.Iterables;
import java.util.Arrays;

/**
 * This example updates the creative destination URL. To determine which
 * creatives exist, run GetAllCreatives.java.
 *
 * Credentials and properties in {@code fromFile()} are pulled from the
 * "ads.properties" file. See README for more info.
 */
public class UpdateCreatives {

  private static class UpdateCreativesParams extends CodeSampleParams {
    @Parameter(names = ArgumentNames.CREATIVE_ID, required = true,
        description = "The ID of the creative to update.")
    private Long creativeId;
  }

  public static void runExample(DfpServices dfpServices, DfpSession session, long creativeId)
      throws Exception {
    // Get the CreativeService.
    CreativeServiceInterface creativeService =
        dfpServices.get(session, CreativeServiceInterface.class);

    // Create a statement to only select a single creative by ID.
    StatementBuilder statementBuilder = new StatementBuilder()
        .where("id = :id")
        .orderBy("id ASC")
        .limit(1)
        .withBindVariableValue("id", creativeId);
      
    // Get the creative.
    CreativePage page =
        creativeService.getCreativesByStatement(statementBuilder.toStatement());
      
    Creative creative = Iterables.getOnlyElement(Arrays.asList(page.getResults()));

    // Only update the destination URL if it has one.
    if (creative instanceof HasDestinationUrlCreative) {
      HasDestinationUrlCreative hasDestinationUrlCreative = (HasDestinationUrlCreative) creative;

      // Update the destination URL of the creative.
      hasDestinationUrlCreative.setDestinationUrl("http://news.google.com");

      // Update the creative on the server.
      Creative[] creatives = creativeService.updateCreatives(new Creative[] {creative});

      for (Creative updatedCreative : creatives) {
        System.out.printf(
            "Creative with ID %d and name '%s' was updated.%n",
            updatedCreative.getId(), updatedCreative.getName());
      }
    } else {
      System.out.println("No creatives were updated.");
    }
  }

  public static void main(String[] args) throws Exception {
    // Generate a refreshable OAuth2 credential.
    Credential oAuth2Credential = new OfflineCredentials.Builder()
        .forApi(Api.DFP)
        .fromFile()
        .build()
        .generateCredential();

    // Construct a DfpSession.
    DfpSession session = new DfpSession.Builder()
        .fromFile()
        .withOAuth2Credential(oAuth2Credential)
        .build();

    DfpServices dfpServices = new DfpServices();

    UpdateCreativesParams params = new UpdateCreativesParams();
    if (!params.parseArguments(args)) {
      // Either pass the required parameters for this example on the command line, or insert them
      // into the code here. See the parameter class definition above for descriptions.
      params.creativeId = Long.parseLong("INSERT_CREATIVE_ID_HERE");
    }

    runExample(dfpServices, session, params.creativeId);
  }
}
