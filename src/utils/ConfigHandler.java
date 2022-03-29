package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static java.lang.System.exit;

public class ConfigHandler {
    private static Properties properties;

    public static void loadConfig(String path) {
        if (properties != null) return;

        try {
            String configFilePath = path;
            FileInputStream propsInput = new FileInputStream(configFilePath);

            properties = new Properties();
            properties.load(propsInput);

            propsInput.close();

//            System.out.println(getConfigProperty("DB_NAME"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            exit(-1);
        } catch (IOException e) {
            e.printStackTrace();
            exit(-1);
        }
    }

    public static String getConfigProperty(String property) {
        return properties.getProperty(property);
    }
}
