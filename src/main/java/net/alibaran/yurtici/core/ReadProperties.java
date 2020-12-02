package net.alibaran.yurtici.core;
import java.io.*;
import java.util.*;

public class ReadProperties {

    private String servicePath;
    private String xmlPath;

    Properties prop = null;

    public ReadProperties() throws IOException {
        InputStream propertiesIs = this.getClass().getClassLoader().getResourceAsStream("META-INF/endpoint.properties");
        prop = new Properties();
        prop.load(propertiesIs);
        this.servicePath = this.prop.getProperty("service-path");
        this.xmlPath = this.prop.getProperty("xml-path");
    }

    public String getServicePath() {
        return servicePath;
    }

    public String getXmlPath() {
        return this.xmlPath;
    }
}
