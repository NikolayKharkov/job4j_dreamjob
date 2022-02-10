package ru.job4j.dream.model;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class Property {
    private final static Properties PROPERTY = new Properties();

    public static String getPhotoStorage() throws IOException {
        FileReader reader = new FileReader("filesStorage.properties");
        PROPERTY.load(reader);
        return PROPERTY.getProperty("usersPhoto");
    }
}