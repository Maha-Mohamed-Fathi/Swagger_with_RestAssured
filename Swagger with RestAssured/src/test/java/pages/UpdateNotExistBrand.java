package pages;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import reader.Reader;

import java.io.IOException;
import java.util.Properties;

public class UpdateNotExistBrand {

    public static Properties Brands;
    public static String sentBrandName;

    public static Response updateBrand(String brandID,String brandName) throws IOException {
        String baseURI = "https://practice-react.sdetunicorns.com";
        String basePath = "/api/test/brands/";
        JSONObject requestParams = new JSONObject();

        String sentBrandID;
        Brands= Reader.setProperties();
        sentBrandID= Brands.getProperty(brandID);
        sentBrandName = Brands.getProperty(brandName);
        Response response = RestAssured
                .given()
                .baseUri(baseURI)
                .basePath(basePath+sentBrandID)
                .config(RestAssured.config()
                        .encoderConfig(EncoderConfig.encoderConfig()
                                .encodeContentTypeAs("x-www-form-urlencoded",
                                        ContentType.URLENC)))
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("name", sentBrandName)
                .when()
                .put();
        return response;
    }

}
