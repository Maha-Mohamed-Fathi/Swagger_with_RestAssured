package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import reader.Reader;

import java.io.IOException;
import java.util.Properties;

public class DeleteNotExistBrand {

    public static Properties Brands;
    public static Response deleteBrand(String brandID) throws IOException {
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
                .delete();
        return response;
    }
}
