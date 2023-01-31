package models;

import org.json.JSONArray;
import org.json.JSONObject;
import services.jsonReaderClass;

import java.util.ArrayList;
import java.util.List;

public class province {
    public static void cerca(String regione) {
        JSONArray jsonArrayProvince = jsonReaderClass.jsonReader("jsons/province.json");
        List<String> listaProvince = new ArrayList<String>();

        for (Object provinceObj : jsonArrayProvince) {

            JSONObject provinceJson = (JSONObject) provinceObj;

            if (((String) provinceJson.get("regione")).toLowerCase().equals(regione))
                listaProvince.add(((String) provinceJson.get("nome")));

        } System.out.println(listaProvince);
    }
}
