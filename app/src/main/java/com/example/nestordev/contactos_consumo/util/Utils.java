package com.example.nestordev.contactos_consumo.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

public class Utils {

    public static ProgressDialog pDialog;

    public static void showMesaje(Context contexto, String mensage){

        Toast.makeText(contexto,mensage ,Toast.LENGTH_SHORT).show();
    }


    public static void showLoading(Context contexto, String mensage){
        pDialog = new ProgressDialog(contexto);
        pDialog.setMessage(mensage);
        pDialog.setCancelable(false);
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDialog.show();
    }

    public  static void  dismissDialog(){

        if (pDialog != null && pDialog.isShowing())
            pDialog.dismiss();
    }


}
