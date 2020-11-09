package com.example.miscontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import com.example.miscontactos.pojo.Contacto;
import com.example.miscontactos.DetalleContacto;
import com.example.miscontactos.R;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {
    ArrayList<Contacto> contactos= new ArrayList<Contacto>();
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos=contactos;
        this.activity=activity;
    }

    /*Le va a dar vida a cardView
      Inflar el layout y lo pasara al viewholder para que el obtenga los views */
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);

        return new ContactoViewHolder(v);
    }

    /* Asocia cada elemento de la lista con cada view*/
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        Contacto contacto= contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCv.setText(contacto.getTelefono());
        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(activity, DetalleContacto.class);
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a "+contacto.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

    }
    /*Cantidad de elementos que contiene mi lista*/
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCv;
        private ImageButton btnLike;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto      =(ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV   =(TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCv =(TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike      =(ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
