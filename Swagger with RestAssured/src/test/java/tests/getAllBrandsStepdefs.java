package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pages.GetAllBrands;

import java.io.IOException;


public class getAllBrandsStepdefs {

    Boolean secondEntryIsEmpty = false;
    GetAllBrands getAllBrands = new GetAllBrands();

    @Given("Swagger API")
    public void swaggerAPI() {

    }

    @And("Send a GET request to the brands endpoint")
    public void sendAGETRequestToTheBrandsEndpoint()  {
        getAllBrands.getAllBrands();
    }

    @And("Ensure the response status code is {string}")
    public void ensureTheResponseStatusCodeIs(String statusCode) {
        Assert.assertEquals(String.valueOf(getAllBrands.getAllBrands().getStatusCode()),statusCode);
    }

    @And("Check that the list of brands has more than one entry")
    public void checkThatTheListOfBrandsHasMoreThanOneEntry()  {
        Assert.assertEquals(getAllBrands.checkNumberOfEntriesMoreThanOne(),secondEntryIsEmpty);
    }

    @And("Validate that each brand object contains _id and name properties")
    public void validateThatEachBrandObjectContains_idAndNameProperties()  {
        Assert.assertEquals(getAllBrands.getNumberOfIDs(),getAllBrands.getNumberOfNames());
    }
}
