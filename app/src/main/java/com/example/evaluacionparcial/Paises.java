package com.example.evaluacionparcial;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class Paises {
    String Nombre;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getUrlLogo() {
        return UrlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        UrlLogo = urlLogo;
    }

    String UrlLogo;

    public Paises(String countryCode, JSONObject countryData) throws JSONException {
        Nombre = countryData.getString("Name");
        UrlLogo = "http://www.geognos.com/api/en/countries/flag/" + countryCode + ".png";
    }

    public static ArrayList<Paises> JsonObjectsBuild(JSONObject datos) throws JSONException {
        ArrayList<Paises> listapais = new ArrayList<>();
        Iterator<String> keys = datos.keys();
        while (keys.hasNext()) {
            String countryCode = keys.next();
            JSONObject countryData = datos.getJSONObject(countryCode);
            listapais.add(new Paises(countryCode, countryData));
        }
        return listapais;
    }
}