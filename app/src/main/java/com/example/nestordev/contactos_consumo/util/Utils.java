package com.example.nestordev.contactos_consumo.util;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.nestordev.contactos_consumo.Models.User;
import com.example.nestordev.contactos_consumo.R;

import java.util.ArrayList;

public class Utils {

    public static ProgressDialog pDialog;
    private  static  boolean bandera;

    public static void showMesaje(Context contexto, String mensage){

        Toast.makeText(contexto,mensage ,Toast.LENGTH_SHORT).show();
    }

    public static Boolean showMesajeConfirm(final Context contexto, String mensage ){


        final AlertDialog.Builder builder = new AlertDialog.Builder(contexto);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                bandera = true;

            }
        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();

                bandera = false;
            }
        }).setMessage(mensage).setTitle(R.string.app_delete_title)
                .setCancelable(true);

        AlertDialog alert = builder.create();
                    alert.show();

        return  bandera;

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

    public static void loadImage(Context context, String imageToLoad, ImageView imvShow) {
        //Se asigna la imagen al imageview
        //pbCargando.setVisibility(View.VISIBLE);
        Glide.with(context)
                .load(imageToLoad)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                }).into(imvShow);
    }

}
