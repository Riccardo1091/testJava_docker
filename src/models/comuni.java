package models;

import org.json.JSONArray;
import org.json.JSONObject;
import services.jsonReaderClass;

import java.util.ArrayList;
import java.util.List;

public class comuni {
    public static void cerca(String[] arrayRegioneCapoluogo) {
        JSONArray jsonArrayComuni = jsonReaderClass.jsonReader("jsons/comuni.json");
        List<String> listaComuni = new ArrayList<>();

        for (Object comuneObj : jsonArrayComuni) {

            JSONObject provinceJson = (JSONObject) comuneObj;

            if (
                ((String) ((JSONObject) provinceJson.get("regione")).get("nome")).toLowerCase().equals(arrayRegioneCapoluogo[0]) &&
                ((String) ((JSONObject) provinceJson.get("provincia")).get("nome")).toLowerCase().equals(arrayRegioneCapoluogo[1])
            )
                listaComuni.add(((String) provinceJson.get("nome")));

        } System.out.println(listaComuni);
    }
}
