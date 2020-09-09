package axiom.utils.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\axiom\\properties\\";

    public static Properties getInstance(String path){
        Properties prop = new Properties();
        synchronized (lock) {
            try {
                prop.load(new FileInputStream(propertyFilePath + path));
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }
}
