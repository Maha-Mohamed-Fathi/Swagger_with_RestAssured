package tests;

import io.cucumber.java.en.And;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import pages.DeleteNotExistBrand;

import java.io.IOException;

public class deleteNotExistStepdefs {

    public static int actualStatusCode;
    public static String actualResponseError;
    DeleteNotExistBrand deleteNotExistBrand = new DeleteNotExistBrand();

    @And("Send a Delete request specific with {string}")
    public void sendADeleteRequestSpecificWith(String brandID) throws IOException {
        deleteNotExistBrand.deleteBrand(brandID);
        JsonPath path = new JsonPath( deleteNotExistBrand.deleteBrand(brandID).asString());
        actualStatusCode =  deleteNotExistBrand.deleteBrand(brandID).getStatusCode();
        actualResponseError = path.getString("error");
    }

    @And("Ensure that response status code is {string} for delete not exist brand")
    public void ensureThatResponseStatusCodeIsForDeleteNotExistBrand(String statusCode) {
        Assert.assertEquals(String.valueOf(actualStatusCode),statusCode);

    }

    @And("Validate that the API throws an error when attempting to delete brand not exist return error {string}")
    public void validateThatTheAPIThrowsAnErrorWhenAttemptingToDeleteBrandNotExistReturnError(String responseErrorMessage) {
        Assert.assertEquals(actualResponseError,responseErrorMessage);

    }
}
