package com.wbl1.util1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil1 {
    //we are keeping it static so it can be accessed easily outside
    public static final Properties prop  = new Properties();

    public ConfigUtil1(String fileName){
         //we are creating object for properties class.
        try {
            prop.load(new FileInputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getProperty(String key){
        return prop.getProperty(key); // we are giving the key which is in config.util file
    }
}
