package com.example.nestordev.contactos_consumo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.nestordev.contactos_consumo.Network.VolleySingleton;
import com.example.nestordev.contactos_consumo.R;
import com.example.nestordev.contactos_consumo.util.Constants;
import com.example.nestordev.contactos_consumo.util.Utils;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();
    }

    private void getData() {
        Utils.showLoading(this, Constants.PLEASE_WAIT);
        VolleySingleton.getinstance(getApplicationContext()).addToRequestQueue(
                new JsonArrayRequest(Request.Method.GET,
                        Constants.URL_BASE, null, new com.android.volley.Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        Utils.dismissDialog();
                        Log.d("RESPONSE", "--> " + response);

                    }
                },
                        new com.android.volley.Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Utils.dismissDialog();
                                Utils.showMesaje(getApplicationContext(), Constants.ERROR);
                            }
                        })
        );
    }
}
