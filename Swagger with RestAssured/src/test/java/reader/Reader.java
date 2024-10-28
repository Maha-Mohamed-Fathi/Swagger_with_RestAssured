package reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Reader {

    private static String brandsPath ="resources/config/Brands.properties";

    public static Properties setProperties() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream;
        inputStream = new FileInputStream(brandsPath);
        configProperties.load(inputStream);
        return configProperties;
    }

}
