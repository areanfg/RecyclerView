package com.example.a988.seccion06;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Contacto> contactos;
    Contacto C13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Generamos datos
        contactos = new ArrayList<Contacto>();

        Contacto C1 = new Contacto("Oscar Outumuro",636835483,R.drawable.outo);
        Contacto C2 = new Contacto("David Aramburu",677052487,android.R.drawable.alert_dark_frame);
        Contacto C3 = new Contacto("Guillermo Areán",640295311,android.R.drawable.alert_dark_frame);
        Contacto C4 = new Contacto("José Manuel García",680513086,android.R.drawable.alert_dark_frame);
        Contacto C5 = new Contacto("Oscar Outumuro",636835483,R.drawable.outo);
        Contacto C6 = new Contacto("David Aramburu",677052487,android.R.drawable.alert_dark_frame);
        Contacto C7 = new Contacto("Guillermo Areán",640295311,android.R.drawable.alert_dark_frame);
        Contacto C8 = new Contacto("José Manuel García",680513086,android.R.drawable.alert_dark_frame);
        Contacto C9 = new Contacto("Oscar Outumuro",636835483,R.drawable.outo);
        Contacto C10 = new Contacto("David Aramburu",677052487,android.R.drawable.alert_dark_frame);
        Contacto C11 = new Contacto("Guillermo Areán",640295311,android.R.drawable.alert_dark_frame);
        Contacto C12 = new Contacto("José Manuel García",680513086,android.R.drawable.alert_dark_frame);
        C13 = new Contacto("Parrulo",680513086,android.R.drawable.alert_dark_frame);

        contactos.add(C1);
        contactos.add(C2);
        contactos.add(C3);
        contactos.add(C4);
        contactos.add(C5);
        contactos.add(C6);
        contactos.add(C7);
        contactos.add(C8);
        contactos.add(C9);
        contactos.add(C10);
        contactos.add(C11);
        contactos.add(C12);

        //Instanciamos el recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        registerForContextMenu(recyclerView);
        //Aquí pillamos un LayoutManager determinado y se lo pasamos al recycler
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Definimos el adapter
        adapter = new MyAdapter(contactos, new MyAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(Contacto contacto) {
                Toast.makeText(MainActivity.this, contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
        //adapter = new MyAdapter(datos);

        //le pasamos el adaptador al recycler
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.añadir:
                contactos.add(C13);
                adapter.notifyDataSetChanged();
                return true;
            case R.id.eliminar:
                contactos.remove(contactos.get(contactos.size()-1));
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}