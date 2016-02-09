package com.example.danielramirez.ejemplo_bases_de_datos;

import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton boton;
    ListView lista;
    Base_de_datos db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Base_de_datos(this);

        /**definciendo la ListView, el arrayAdapter que tendra adentro y dandoselo al ListView*/
        lista = (ListView) findViewById(R.id.listView);
        lista.setEmptyView(findViewById(R.id.textView)); /**Aca le indico a lista que si esta vacia que mensaje debe de mostrar, de lo contrario no se muestra*/

        List<String> listita = new ArrayList<String>();  /**esta sera la lista que se le pasara al adapter para que muestre*/
        listita = db.leer_datos(); /**Trayendo el objecto List con todos los datos consultados*/
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listita);
        lista.setAdapter(adaptador);

        boton = (FloatingActionButton) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), Insertar_datos.class);
                startActivity(i);

            }
        });


    }
}
