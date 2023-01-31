package services;

import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.IOException;

public class jsonReaderClass {
    public static JSONArray jsonReader(String url) {
        JSONArray jsonArray = null;

        try {
            FileReader reader = new FileReader(url);
            jsonArray = new JSONArray(new JSONTokener(reader));
            reader.close();
        } catch (IOException ioe) {
            System.out.println("Problema nella lettura del file: " + ioe.getMessage());
        }
        return jsonArray;
    }
}
