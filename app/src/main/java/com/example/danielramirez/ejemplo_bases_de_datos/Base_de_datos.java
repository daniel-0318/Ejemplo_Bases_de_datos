package com.example.danielramirez.ejemplo_bases_de_datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Ramirez on 8/02/2016.
 */


/**
 * TODA CLASE VAYA A IMPLEMENTAR UNA  BASE DE DATOS DEBE EXTENDER DE SQLiteOpenHelper
 */

public class Base_de_datos extends SQLiteOpenHelper {

    /**
     * Constructor por defecto para SQLiteOpenHelper solo el contexto y se le pasa
     * al super el contexto, <el nombre que queremos para la BD>, cursos (en este caso null), y la version de la BD
     */
    public Base_de_datos(Context context) {
        super(context, "Base_de_datos", null, 1);
    }


    /**
     * Oncreate se llamara solo sila base de datos no existe aun, si existe una base de datos no se llamara
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE tabla1( nombre VARCHAR, num INTEGER, PRIMARY KEY(num) )");

    }

    /**
     * Se llamara automaticamente si se detecta una nueva version de la base de datos
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //Metodo para agregar datos
    public void ingresar_datos(Integer num, String nombre) {

        SQLiteDatabase db = getWritableDatabase();
        try {
            db.execSQL("INSERT INTO tabla1 VALUES(" +
                    "'" + nombre + "'" + ", " + num + ")");
            db.close();
            System.out.println("*********" + nombre + " "+ num);
        } catch (Exception e) {
            System.out.println("************Error al insertar************");
            e.printStackTrace();
        }

    }


    //metodo para leer los datos

    /**
     * Al leer de la base de datos nos devolvera un vector gerico
     * utilizando un objecto SQLiteDatabase usando la funcion de getReadableDatabase(), ya que solo leeremos
     * para ello hacemos uso de un Cursos y de rawQuery para poder pasarle una consulta generica
     * luego nos movemos por el cursos y se le añadimos los datos al vector que devolveremos
     */
    public List<String> leer_datos() {

        List<String> resultado = new ArrayList<String>();
        SQLiteDatabase db = getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery("SELECT nombre, num FROM tabla1", null, null);
            /**Nos aseguramos de que existe al menos un registro*/


            while (cursor.moveToNext()) {

                resultado.add(cursor.getString(0) + " " + cursor.getInt(1));
                System.out.println("***********  " + cursor.getString(0) + "****" + cursor.getInt(1));

            }


            cursor.close();
            db.close();
        } catch (Exception e) {
            System.out.println("******************Error al leer los *******");
            e.printStackTrace();
        }

        return resultado;

    }
}
