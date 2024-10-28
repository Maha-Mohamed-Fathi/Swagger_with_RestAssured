package pages;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import reader.Reader;
import java.io.IOException;
import java.util.Properties;

public class GetSpecificBrand {

    public static Properties Brands;
    public static Response getSpecificBrandByID(String brandID) throws IOException {
        String baseURI = "https://practice-react.sdetunicorns.com";
        String basePath = "/api/test/brands/";
        String sentBrandID;
        Brands= Reader.setProperties();
        sentBrandID= Brands.getProperty(brandID);
        Response response = RestAssured
                .given()
                .baseUri(baseURI)
                .basePath(basePath+sentBrandID)
                .when()
                .get();
        return response;
    }

    public static String getBrandName (String brandID) throws IOException {
        String brandName;
        JsonPath path = new JsonPath(getSpecificBrandByID(brandID).asString());
        brandName = path.getString("name");
        return brandName;
    }

}
