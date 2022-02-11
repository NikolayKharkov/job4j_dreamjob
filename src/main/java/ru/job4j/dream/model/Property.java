package ru.job4j.dream.model;

import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Property {
    private final static Properties PROPERTY = new Properties();

    private static void init() {
        try (InputStream in = Config.class.getClassLoader()
                .getResourceAsStream("filesStorage.properties")) {
            PROPERTY.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String returnValue(String key) throws IOException {
        init();
        return PROPERTY.getProperty(key);
    }
}