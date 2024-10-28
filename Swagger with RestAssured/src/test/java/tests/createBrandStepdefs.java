package tests;

import io.cucumber.java.en.And;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import pages.CreateBrand;
import reader.Reader;
import java.io.IOException;
import java.util.Properties;

public class createBrandStepdefs {

    public static int actualStatusCode;
    public static String actualResponseError;
    public static Properties Brands;
    public static String sentBrandName;
    CreateBrand createBrand = new CreateBrand();

    @And("Send a Post request specific with {string}")
    public void sendAPostRequestSpecificWith(String brandName) throws IOException {
        Brands= Reader.setProperties();
        sentBrandName= Brands.getProperty(brandName);
        createBrand.createDuplicatedBrand(brandName);
        JsonPath path = new JsonPath(createBrand.createDuplicatedBrand(brandName).asString());
        actualStatusCode =  createBrand.createDuplicatedBrand(brandName).getStatusCode();
        actualResponseError = path.getString("error");
    }

    @And("Ensure that the response status code is {string}")
    public void ensureThatTheResponseStatusCodeIs(String statusCode) {
        Assert.assertEquals(String.valueOf(actualStatusCode),statusCode);
    }

    @And("Validate that the API prevents the creation of duplicate brand entries and return error {string}")
    public void validateThatTheAPIPreventsTheCreationOfDuplicateBrandEntriesAndReturnError(String responseErrorMessage) {
        Assert.assertEquals(actualResponseError,sentBrandName+" "+responseErrorMessage);
    }




}
