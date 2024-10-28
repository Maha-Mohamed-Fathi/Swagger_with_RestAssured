package tests;

import io.cucumber.java.en.And;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import pages.UpdateNotExistBrand;
import java.io.IOException;

public class updateNotExistBrandStepdefs {

    public static int actualStatusCode;
    public static String actualResponseError;
    UpdateNotExistBrand updateNotExistBrand = new UpdateNotExistBrand();
    @And("Send a Put request specific with {string} and {string}")
    public void sendAPutRequestSpecificWithAnd(String brandID, String brandName) throws IOException {
        updateNotExistBrand.updateBrand(brandID,brandName);
        JsonPath path = new JsonPath(updateNotExistBrand.updateBrand(brandID,brandName).asString());
        actualStatusCode =  updateNotExistBrand.updateBrand(brandID,brandName).getStatusCode();
        actualResponseError = path.getString("error");
    }

    @And("Ensure that the response status code is {string} for update brand")
    public void ensureThatTheResponseStatusCodeIsForUpdateBrand(String statusCode) {
        Assert.assertEquals(String.valueOf(actualStatusCode),statusCode);

    }

    @And("Validate that the API throws an error when attempting to update brand not exist return error {string}")
    public void validateThatTheAPIThrowsAnErrorWhenAttemptingToUpdateBrandNotExistReturnError(String responseErrorMessage) {
        Assert.assertEquals(actualResponseError,responseErrorMessage);

    }
}
