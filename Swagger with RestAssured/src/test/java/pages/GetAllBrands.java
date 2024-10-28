package pages;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.List;

public class GetAllBrands {
    public static int statusCode , numberOfBrandIDs ,numberOfBrandNames;
    public static Response getAllBrands() {

        String baseURL = "https://practice-react.sdetunicorns.com";
        String basePath = "/api/test/brands";
        Response response = RestAssured
                .given()
                .baseUri(baseURL)
                .basePath(basePath)
                .when()
                .get();
        return response;
    }

    public static Boolean checkNumberOfEntriesMoreThanOne()  {
        JsonPath path = new JsonPath(getAllBrands().asString());
        Boolean secondEntry = path.getString("[1]").isEmpty();
        return secondEntry;
    }
    public static int getNumberOfIDs ()  {
        JsonPath path = new JsonPath(getAllBrands().asString());
        List<String> allIDsInBrands = path.getList("_id");
        numberOfBrandIDs = allIDsInBrands.size();
        return numberOfBrandIDs;
    }
    public static int getNumberOfNames ()  {
        JsonPath path = new JsonPath(getAllBrands().asString());
        List<String> allNamesInBrands = path.getList("name");
        numberOfBrandNames = allNamesInBrands.size();
        return numberOfBrandNames;
    }
}
