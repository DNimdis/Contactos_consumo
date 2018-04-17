package com.example.nestordev.contactos_consumo.Network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    private static  VolleySingleton singleton;
    private RequestQueue requestQueue;
    private static Context contexto;

    private VolleySingleton(Context contexto) {
        VolleySingleton.contexto = contexto;
        requestQueue = getRequestQueue();

    }

    public static  synchronized  VolleySingleton getinstance(Context contexto){
        if (singleton == null){
            singleton = new VolleySingleton(contexto.getApplicationContext());

        }

        return  singleton;
    }

    private RequestQueue getRequestQueue(){
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(contexto.getApplicationContext());
        }

        return  requestQueue;
    }

    public <T> void  addToRequestQueue(Request<T> req){

        getRequestQueue().add(req);
    }

}
