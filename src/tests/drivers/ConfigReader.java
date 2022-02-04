package tests.drivers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    static Properties properties;


    static {
        String path="Configuration.properties";//path du driver à utiliser
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getProperty(String key){

        String value=properties.getProperty(key);
        return value;
    }
}
