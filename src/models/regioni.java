package models;

import org.json.JSONArray;
import org.json.JSONObject;
import services.jsonReaderClass;

import java.util.ArrayList;
import java.util.List;

public class regioni {
    public static void cerca(String inputUtente) {
        boolean risultatoTrovato = false;

        if (inputUtente.contains(",") && !inputUtente.equals(",")) { // SE REGIONE, CAPOLUOGO OTTIENI COMUNI
            String[] arrayRegioneCapoluogo = inputUtente.toLowerCase().replaceAll("\\s+", "").split(",");
            comuni.cerca(arrayRegioneCapoluogo);
            risultatoTrovato = true;
        }

        // Apre il json attraverso il servizio jsonReaderClass
        JSONArray jsonArrayRegioni = jsonReaderClass.jsonReader("jsons/regioni.json");
        List<String> listaRegioni = new ArrayList<String>();

        if (!inputUtente.equals("")) {
            for (Object regioneObj : jsonArrayRegioni) {
                // convertiamo ogni oggetto generico nell'iterazione in un JSONObject
                // che da accesso ai metodi per selezionare i valori delle proprietà
                JSONObject jsonObject = (JSONObject) regioneObj;
                // (string) serve a trasformare un elemento del jsonObject in stringa così da utilizzare i metodi
                // delle stringhe su di esso
                if (((String) jsonObject.get("nome")).equalsIgnoreCase(inputUtente)) { // SE CORRISPONDENZA
                    province.cerca(inputUtente);
                    risultatoTrovato = true;
                    break;
                } else if (((String) jsonObject.get("nome")).toLowerCase().contains(inputUtente.toLowerCase())) { // SE CONTIENE
                    System.out.println((String) jsonObject.get("nome"));
                    risultatoTrovato = true; // stampa solo le occorrenze
                }
            }

            if (!risultatoTrovato) System.out.println("Nessun Risultato");

        } else { // LISTA REGIONI
            for (Object regioneObj : jsonArrayRegioni) {
                JSONObject jsonObject = (JSONObject) regioneObj;
                listaRegioni.add(((String) jsonObject.get("nome")));
            }
            System.out.println(listaRegioni);
        }

    }

}
