package com.automationcalling.javaUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class PropsLoader {

    public Properties prop;
    private static final Logger LOG = Logger.getLogger(PropsLoader.class.getName());

    public void loadProperty(String propFile)
    {
        File file = new File(propFile);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            LOG.severe("File Not Found"+e.getMessage());
        }
        prop = new Properties();
        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            LOG.severe("Problem in Loading File"+e.getMessage());
        }
    }


}
