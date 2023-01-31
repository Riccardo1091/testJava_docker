package services;

import org.json.JSONArray;
import org.json.JSONObject;

public class stringBuilderClass {
    public static String stringBuilder(JSONArray arrayJson, String tipo, String elemento) {
        // Stringbuilder permette di costruire una stringa personalizzata, viene trattata come una sorta di array
        // In questa fase non è una stringa pura
        StringBuilder stringBuilder = new StringBuilder();

        for (Object obj : arrayJson) {
            // convertiamo ogni oggetto generico nell'iterazione in un JSONObject
            // che da accesso ai metodi per selezionare i valori delle proprietà
            JSONObject jsonObject = (JSONObject) obj;

            if (tipo.equals("regioni"))
                stringBuilder.append(jsonObject.get("nome")).append(", ");

            else if (tipo.equals("province"))
                if (((String) jsonObject.get("regione")).equalsIgnoreCase(elemento))
                    stringBuilder.append(jsonObject.get("nome")).append(", ");

        }

        // Dopo aver composto la stringa la riportiamo allo stato di stringa pura
        String stringa = stringBuilder.toString();

        // Rimuove l'ultima virgola creando una sotto stringa senza gli ultimi due caratteri ", "
        stringa = stringa.substring(0, stringa.length() - 2);

        //System.out.println(stringa);

        return stringa;
    }
}
