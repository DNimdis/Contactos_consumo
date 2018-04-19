package com.example.nestordev.contactos_consumo.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nestordev.contactos_consumo.DiffCallback_Reload.UserDiffCallback;
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
    public void onBindViewHolder(final MyViewHolder viewHolder, final int i) {

        viewHolder.txtUserName.setText(items.get(i).username + " " + items.get(i).lastName);
        viewHolder.txtUserEmail.setText(items.get(i).email);
        viewHolder.txtUserPhone.setText(items.get(i).telephone);
        Utils.loadImage(context, items.get(0).image, viewHolder.userImage);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.showMesaje(context, "Has seleccionado a " +"\n" +items.get(i).username);
            }
        });


        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

              //boolean resultado = Utils.showMesajeConfirm(context,"¿Estas seguro de eliminar este usuario?"+"\n"+items.get(i).username);
              //  Log.d("remove", "onLongClick: "+resultado);

              //  if (resultado){
              //      items.remove(items.get(i));
              //      updateUserListItems(items);
              //  }
              //return resultado;
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        User toDelete = items.get(viewHolder.getAdapterPosition());
                        items.remove(toDelete);
                        notifyDataSetChanged();


                    }
                }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                    }
                }).setMessage("Deseas eliminar al usuario?").setTitle("Confirmacion")
                        .setCancelable(true);

                AlertDialog alert = builder.create();
                alert.show();

                return false;
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

    public void updateUserListItems(ArrayList<User> users) {



        final UserDiffCallback diffCallback = new UserDiffCallback(this.items, users);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback, false);

        //this.items.clear();
        //this.items.addAll(users);
        diffResult.dispatchUpdatesTo(this);
        this.notifyDataSetChanged();

    }



}
