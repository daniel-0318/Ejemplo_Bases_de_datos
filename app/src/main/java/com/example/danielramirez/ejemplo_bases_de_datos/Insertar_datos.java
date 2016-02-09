package com.example.danielramirez.ejemplo_bases_de_datos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insertar_datos extends AppCompatActivity {


    EditText numero;
    EditText nombre;

    Base_de_datos db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_datos);

        numero = (EditText) findViewById(R.id.editText);
        nombre = (EditText) findViewById(R.id.editText2);
        db = new Base_de_datos(getApplicationContext());

        Button boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llenar_datos();
                Toast.makeText(getApplication(), "Añadido correctamente, supongo", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        Button boton2 = (Button) findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                comprobacion();
            }
        });

    }

    public EditText getNumero() {
        return numero;
    }

    public void setNumero(EditText numero) {
        this.numero = numero;
    }

    public EditText getNombre() {
        return nombre;
    }

    public void setNombre(EditText nombre) {
        this.nombre = nombre;
    }


    public void llenar_datos(){

        Integer num = Integer.parseInt(getNumero().getText().toString());
        String nom = getNombre().getText().toString();

        db.ingresar_datos(num,nom);

    }


    public  void comprobacion(){
        Integer num = Integer.parseInt(getNumero().getText().toString());
        String nom = getNombre().getText().toString();
        Toast.makeText(getApplicationContext(),nom + "  "+num, Toast.LENGTH_LONG).show();

    }
}
