package tests;

import io.cucumber.java.en.And;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import pages.CreateBrand;
import pages.GetSpecificBrand;
import reader.Reader;

import java.io.IOException;
import java.util.Properties;

public class getSpecificBrandStepdefs {

    public static String actualBrandName,expectedBrandName,actualResponseError;
    public static Properties Brands;
    public static int actualStatusCode;
    GetSpecificBrand getSpecificBrand = new GetSpecificBrand();


    @And("Send a GET request specific with {string}")
    public void sendAGETRequestSpecificWith(String brandID) throws IOException {
        getSpecificBrand.getSpecificBrandByID(brandID);
        actualStatusCode= (getSpecificBrand.getSpecificBrandByID(brandID)).getStatusCode();
        actualBrandName= getSpecificBrand.getBrandName(brandID);
        JsonPath path = new JsonPath(getSpecificBrand.getSpecificBrandByID(brandID).asString());
        actualResponseError = path.getString("error");
    }

    @And("Ensure that response status code is {string}")
    public void ensureThatResponseStatusCodeIs(String statusCode) {
        Assert.assertEquals(String.valueOf(actualStatusCode),statusCode);
    }

    @And("Validate that the brand's name matches the expected value")
    public void validateThatTheBrandSNameMatchesTheExpectedValue() throws IOException {
        Brands= Reader.setProperties();
        expectedBrandName= Brands.getProperty("brandName");
        Assert.assertEquals(actualBrandName,expectedBrandName);

    }

    @And("Validate API returns error with {string}when attempting to retrieve brand that doesn't exist")
    public void validateAPIReturnsErrorWithWhenAttemptingToRetrieveBrandThatDoesnTExist(String responseErrorMessage) {
       Assert.assertEquals(actualResponseError,responseErrorMessage);
    }


}
