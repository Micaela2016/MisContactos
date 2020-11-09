package com.example.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.miscontactos.adapter.ContactoAdaptador;
import com.example.miscontactos.pojo.Contacto;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);
        listaContactos.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager((this));
        llm.setOrientation(LinearLayoutManager.VERTICAL);



        /*              Para forma de GridLayout
         *       GridLayoutManager glm= new GridLayoutManager(this, 2);
         *       listaContactos.setLayoutManager(glm);
         *
         **/

        listaContactos.setLayoutManager(llm);//Para que el objeto se comporte como un linear layout

        inicializarListaContactos();
        inicializarAdaptador();
    }


    public void inicializarListaContactos() {
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.persona1, "Micaela Orellano", "154284505", "miqa.orellano@gmail.com"));
        contactos.add(new Contacto(R.drawable.persona2, "Mirta Ortiz", "154183506", "mirta.ortiz@gmail.com"));
        contactos.add(new Contacto(R.drawable.persona3, "Agostina Orellano", "154241051", "agos.orellano@gmail.com"));
        contactos.add(new Contacto(R.drawable.persona4, "Sky Alaska", "2914136290", "skyalaska@gmail.com"));

    }

    public void inicializarAdaptador() {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }






}


