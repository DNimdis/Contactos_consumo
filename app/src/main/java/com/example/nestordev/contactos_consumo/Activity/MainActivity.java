package com.example.nestordev.contactos_consumo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.nestordev.contactos_consumo.Adapter.MyAdapter;
import com.example.nestordev.contactos_consumo.Models.User;
import com.example.nestordev.contactos_consumo.Network.VolleySingleton;
import com.example.nestordev.contactos_consumo.R;
import com.example.nestordev.contactos_consumo.util.Constants;
import com.example.nestordev.contactos_consumo.util.Utils;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Gson gson = new Gson();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        getData();
    }

    private void initComponents() {
        recyclerView = (RecyclerView) findViewById(R.id.contenView);
        lManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lManager);

    }

    private void getData() {
        Utils.showLoading(this, Constants.PLEASE_WAIT);
        VolleySingleton.getinstance(getApplicationContext()).addToRequestQueue(
                new JsonArrayRequest(Request.Method.GET,
                        Constants.URL_BASE, null, new com.android.volley.Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {


                        Log.d("RESPONSE", "--> " + response);
                        User[] usuarios = gson.fromJson(response != null ? response.toString() : null, User[].class);

                        ArrayList<User> users = new ArrayList<>(Arrays.asList(usuarios));

                        adapter = new MyAdapter(MainActivity.this, users);
                        recyclerView.setAdapter(adapter);
                        Utils.dismissDialog();

                    }
                }, new com.android.volley.Response.ErrorListener() {

                   @Override
                   public void onErrorResponse(VolleyError error) {
                       Utils.dismissDialog();
                       Utils.showMesaje(getApplicationContext(), Constants.ERROR);
                       }
                })
        );
    }

}
