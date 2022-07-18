package com.seleniummaster.maganto.utility;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class StaticMethods {
    public static String getFieldFromJson(String fileName, String key)
    {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            Map<?, ?> map = gson.fromJson(reader, Map.class);
            String data = map.get(key).toString();
            return data;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return "Failed";
    }
}
