package com.example.nestordev.contactos_consumo.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nestordev.contactos_consumo.Models.User;
import com.example.nestordev.contactos_consumo.R;
import com.example.nestordev.contactos_consumo.util.Utils;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Activity context;
    private ArrayList<User> items;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        private TextView txtUserName;
        private TextView txtUserEmail;
        private TextView txtUserPhone;
        private ImageView userImage;



        public MyViewHolder(View v) {
            super(v);
            txtUserName = (TextView) v.findViewById(R.id.userName);
            txtUserEmail = (TextView) v.findViewById(R.id.userEmail);
            txtUserPhone = (TextView) v.findViewById(R.id.userPhone);
            userImage = (ImageView) v.findViewById(R.id.userImage);
        }
    }

    public MyAdapter(Activity context, ArrayList<User> items) {
        this.items = items; //-> Recibe la variable en el constructor
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contact_row, viewGroup, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder( MyViewHolder viewHolder, final int i) {

        viewHolder.txtUserName.setText(items.get(i).username + " " + items.get(i).lastName);
        viewHolder.txtUserEmail.setText(items.get(i).email);
        viewHolder.txtUserPhone.setText(items.get(i).telephone);
        Utils.loadImage(context, items.get(0).image, viewHolder.userImage);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.showMesaje(context, "Has seleccionado a " + items.get(i).username);
            }
        });

        //Tarea: 17/04/2018
        //TODO: Obligatorio
        /**
         * Que al mantener presionado, salga un dialogo preguntando si se desea o no eliminar el contacto
         * AL presionar si, debera eliminar el contacto del listado del Recycler
         * En caso contrario, el dialogo debe de ocultarse
         */

        //TODO: Opcional
        /**
         * AL presionar sobre un contacto, este debe de abrir la aplicacion de llamadas e iinicar la llamada,
         * con el numero que tiene asignado
         */

    }

}
