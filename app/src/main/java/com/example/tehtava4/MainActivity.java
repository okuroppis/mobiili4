package com.example.tehtava4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RequestQueue queue;
    private Button button;
    private ListView lista;
    private adapteri adapter;
    private static final String ENDPOINT = "https://jsonplaceholder.typicode.com/posts ";
    private List<luokka> luokka;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        luokka = new ArrayList<luokka>();



        this.lista = findViewById(R.id.lista);
        this.button = findViewById(R.id.button1);
        this.queue = Volley.newRequestQueue(this);
        adapter = new adapteri(this,R.layout.layoutti, luokka);
        lista.setAdapter(adapter);



        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonArrayRequest request = new JsonArrayRequest(ENDPOINT, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        luokka luokka;
                        ArrayList<luokka> lista = new ArrayList<luokka>();

                        Type listantyyppi = new TypeToken<ArrayList<luokka>>(){}.getType();
                        Gson gson = new Gson();

                        lista = gson.fromJson(response.toString(), listantyyppi);

                        adapter.addAll(lista);


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.toString();

                    }
                });

                queue.add(request);
                button.setVisibility(View.GONE);

            }

        });






    }


}
