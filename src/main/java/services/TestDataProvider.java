package services;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;

public class TestDataProvider {

    public JsonObject getObjectFromFile(String fileName){
        try {
            Reader reader = new InputStreamReader(new FileInputStream(fileName));
            JsonParser parser = new JsonParser();
            return (JsonObject) parser.parse(reader);
        } catch (FileNotFoundException e) {
            throw new AssertionError( "Cant find file with name: " + fileName);
        }
    }
}
