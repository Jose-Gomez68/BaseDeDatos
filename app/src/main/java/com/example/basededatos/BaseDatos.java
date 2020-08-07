package com.example.basededatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    //CREO UNA CLASE DONDE DEFINO EL NOMBRE DE MIS BASE DE DATOS UNA CLASE ONSTANTE
    public BaseDatos(@Nullable Context context) {
        super ( context, ConstanteBaseDatos.DATABASE_NAME, null, ConstanteBaseDatos.DATABASE_VERSION );
        this.context = context;
    }

    //EN ESTE METODO CREAREMOS LAS TABLAS DE LAS BASE DE DATOS
    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaContacto = "CREATE TABLE "+ ConstanteBaseDatos.TABLE_CONTACTOS +
                "("+ ConstanteBaseDatos.TABLE_CONTACTOS_ID      + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstanteBaseDatos.TABLE_CONTACTOS_NOMBRE       + " TEXT," +
                ConstanteBaseDatos.TABLE_CONTACTOS_DESCRIPCION  + " TEXT," +
                ConstanteBaseDatos.TABLE_CONTACTOS_FOTO         + " INTEGER" +
                ")";

        String queryCrearTablaLikesContacto = " CREATE TABLE " + ConstanteBaseDatos.TABLE_LIKES + "(" +
                ConstanteBaseDatos.TABLE_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstanteBaseDatos.TABLE_LIKES_ID_CONTACTO + " INTEGER," +
                ConstanteBaseDatos.TABLE_LIKES_NUMLIKE + " INTEGER," +
                " FOREIGN KEY (" + ConstanteBaseDatos.TABLE_LIKES_ID_CONTACTO + ")" +
                " REFERENCES " + ConstanteBaseDatos.TABLE_CONTACTOS + "(" + ConstanteBaseDatos.TABLE_CONTACTOS_ID + ")"
                +")";

        db.execSQL ( queryCrearTablaContacto );
        db.execSQL ( queryCrearTablaLikesContacto );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL ( "DROP TABLE IF EXISTS contacto " );
        db.execSQL ( "DROP TABLE IF EXISTS likes" );
        onCreate ( db );

    }

    public ArrayList<ListaMascotas> obtenerTodosLosContactos () {

        ArrayList<ListaMascotas> listaMascotas = new ArrayList<> ( );

        String consultaContact = "SELECT *FROM " + ConstanteBaseDatos.TABLE_CONTACTOS;
        SQLiteDatabase db = this.getWritableDatabase ();
        Cursor registros = db.rawQuery ( consultaContact,null );

        while (registros.moveToNext ()){
            ListaMascotas contactoActual = new ListaMascotas (  );
            contactoActual.setId ( registros.getInt ( 0 ) );
            contactoActual.setNombre ( registros.getString ( 1 ) );
            contactoActual.setDescrip ( registros.getString ( 2 ) );
            contactoActual.setImagenn ( registros.getInt ( 3 ) );

           /* String queryLikes = "SELECT COUNT " + " ( " + ConstanteBaseDatos.TABLE_LIKES_NUMLIKE + ") AS LIKES " +
                    " FROM " + ConstanteBaseDatos.TABLE_LIKES +
                    " WHERE " + ConstanteBaseDatos.TABLE_LIKES_ID_CONTACTO + " = " + contactoActual.getId ();
            Cursor registrosLikes = db.rawQuery (queryLikes, null);
            if (registrosLikes.moveToNext ()){
                contactoActual.setContadorLike ( registrosLikes.getInt ( 2 ) );
            }else {
                contactoActual.setContadorLike ( 0 );
            }*/

                listaMascotas.add ( contactoActual );
        }

        db.close ();
        return listaMascotas;

    }

    public void insertarContactos (ContentValues contentValues) {

        SQLiteDatabase db = this.getWritableDatabase ();
        db.insert ( ConstanteBaseDatos.TABLE_CONTACTOS,null, contentValues );
        db.close ();

    }

    public void insertarLikeContacto(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase ();
        db.insert ( ConstanteBaseDatos.TABLE_LIKES, null, contentValues );
        db.close ();
    }

    public int  obtenerLikesContacto ( ListaMascotas listaMascotas ) {

        int likes = 0;

        String query = "SELECT COUNT " + " ( " + ConstanteBaseDatos.TABLE_LIKES_NUMLIKE + ")" +
                " FROM " + ConstanteBaseDatos.TABLE_LIKES +
                " WHERE " + ConstanteBaseDatos.TABLE_LIKES_ID_CONTACTO + " = " + listaMascotas.getId ();
        SQLiteDatabase db = this.getWritableDatabase ();
        Cursor registros = db.rawQuery ( query, null );
        if ( registros.moveToNext () ) {
            likes = registros.getInt ( 0 );

        }

        db.close ();
        return likes;

    }

}
