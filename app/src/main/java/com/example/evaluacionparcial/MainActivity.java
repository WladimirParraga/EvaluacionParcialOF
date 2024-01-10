package com.example.evaluacionparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;



public class MainActivity extends AppCompatActivity implements Asynchtask {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String, String> datos2 = new HashMap<String, String>();
        WebService ws= new WebService("http://www.geognos.com/api/en/countries/info/all.json",
                datos2, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }
    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Paises> listapaises = new ArrayList<Paises>();
        JSONObject response = new JSONObject(result);
        JSONObject resultsObject = response.getJSONObject("Results");
        listapaises = Paises.JsonObjectsBuild(resultsObject);
        AdaptadorPaises adaptadorPais = new AdaptadorPaises(this, listapaises);
        ListView lstOpciones = (ListView) findViewById(R.id.lstlista1);
        lstOpciones.setAdapter(adaptadorPais);
    }
}