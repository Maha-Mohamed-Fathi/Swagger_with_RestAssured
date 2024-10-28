package pages;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import reader.Reader;

import java.io.IOException;
import java.util.Properties;

public class CreateBrand {

    public static Properties Brands;
    public static String sentBrandName;

    public static Response createDuplicatedBrand(String brandName) throws IOException {
        String baseURI = "https://practice-react.sdetunicorns.com";
        String basePath = "/api/test/brands/";
        JSONObject requestParams = new JSONObject();

        Brands = Reader.setProperties();
        sentBrandName = Brands.getProperty(brandName);
        requestParams.put("name", "Test Brand 5804");
        Response response = RestAssured
                .given()
                .baseUri(baseURI)
                .basePath(basePath)
                .config(RestAssured.config()
                        .encoderConfig(EncoderConfig.encoderConfig()
                                .encodeContentTypeAs("x-www-form-urlencoded",
                                        ContentType.URLENC)))
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("name", sentBrandName)
                .when()
                .post();
        return response;
    }

}
