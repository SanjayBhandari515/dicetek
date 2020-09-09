package axiom.pages;

import axiom.utils.properties.ConfigFileReader;
import io.restassured.http.ContentType;

import java.util.Properties;

public class AdvancedPage {

    public final String acceptTypeJson ="application/json";
    public ContentType contentTypeJson = ContentType.JSON;

    public String readConfig(String name){
        String value = setConfigPath(getClass().getSimpleName()).getProperty(name);
        return value;
    }

    private Properties setConfigPath(String fileName){
        Properties prop = null;
        String location = getClass().getCanonicalName();

        if(location.contains("Module1")) {
            prop = ConfigFileReader.getInstance("Module1\\" + fileName + ".properties");
        }
        if(location.contains("Module2")) {
            prop = ConfigFileReader.getInstance("Module2\\" + fileName + ".properties");
        }
        return prop;
    }
}
