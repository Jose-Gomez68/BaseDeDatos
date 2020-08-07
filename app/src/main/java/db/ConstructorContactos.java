package db;

import android.content.ContentValues;
import android.content.Context;

import com.example.basededatos.BaseDatos;
import com.example.basededatos.ConstanteBaseDatos;
import com.example.basededatos.ListaMascotas;
import com.example.basededatos.R;

import java.util.ArrayList;

public class ConstructorContactos {

    private static final int LIKE = 1;// va tener siempre el uno por que es un like por cada clic al bton
    private Context context;
    public ConstructorContactos(Context context){
        this.context = context;
    }

    public ArrayList<ListaMascotas> obtenerDatos(){

       /*ArrayList<ListaMascotas> listaMascotas = new ArrayList<> ();
        listaMascotas.add ( new ListaMascotas ( "Perro", R.drawable.perrito, "1","hahaha" ) );
        listaMascotas.add ( new ListaMascotas ( "Gato", R.drawable.gatito, "6","bababa" ) );
        listaMascotas.add ( new ListaMascotas ( "Ardilla", R.drawable.ardillita, "5","bvbbv" ) );
        listaMascotas.add ( new ListaMascotas ( "Conejo", R.drawable.conejo, "1","nmnmnm" ) );
            return listaMascotas;*/
        BaseDatos db = new BaseDatos ( context );
        insertarContactos ( db );
        return  db.obtenerTodosLosContactos ();

    }

    public void insertarContactos ( BaseDatos db ){
        ContentValues contentValues = new ContentValues (  );
        contentValues.put ( ConstanteBaseDatos.TABLE_CONTACTOS_NOMBRE, "PERRO" );
        contentValues.put ( ConstanteBaseDatos.TABLE_CONTACTOS_DESCRIPCION, "ES EL MEJOR AMIGO DEL HOMBRE" );
        contentValues.put ( ConstanteBaseDatos.TABLE_CONTACTOS_FOTO, R.drawable.perrito );
        db.insertarContactos ( contentValues );

        contentValues.put ( ConstanteBaseDatos.TABLE_CONTACTOS_NOMBRE, "GATO" );
        contentValues.put ( ConstanteBaseDatos.TABLE_CONTACTOS_DESCRIPCION, "LA MASCOTA MAS LIMPIA DE TODAS" );
        contentValues.put ( ConstanteBaseDatos.TABLE_CONTACTOS_FOTO, R.drawable.gatito );
        db.insertarContactos ( contentValues );

        contentValues.put ( ConstanteBaseDatos.TABLE_CONTACTOS_NOMBRE, "ARDILLA" );
        contentValues.put ( ConstanteBaseDatos.TABLE_CONTACTOS_DESCRIPCION, "EL MEJOR TRAPADOR DE ARBOLES ES MUY PEQUEÑO Y DOCIL" );
        contentValues.put ( ConstanteBaseDatos.TABLE_CONTACTOS_FOTO, R.drawable.ardillita );
        db.insertarContactos ( contentValues );

        contentValues.put ( ConstanteBaseDatos.TABLE_CONTACTOS_NOMBRE, "CONEJO" );
        contentValues.put ( ConstanteBaseDatos.TABLE_CONTACTOS_DESCRIPCION, "EL ANIMALITO QUE SIEMPRE BRINCA Y ES MUY PEQUEÑO" );
        contentValues.put ( ConstanteBaseDatos.TABLE_CONTACTOS_FOTO, R.drawable.conejo );
        db.insertarContactos ( contentValues );

    }

    public void darLikeContacto(ListaMascotas listaMascotas){

        BaseDatos db = new BaseDatos ( context );
        ContentValues contentValues = new ContentValues ();
        //en la primera es como obtenermos el id de mi lista de mascotas
        contentValues.put ( ConstanteBaseDatos.TABLE_LIKES_ID_CONTACTO, listaMascotas.getId ());
        //se crea una variable constante final del like = 1, porcada clic al boton es un like
        contentValues.put ( ConstanteBaseDatos.TABLE_LIKES_NUMLIKE, 1 );
        db.insertarLikeContacto ( contentValues );
        db.close ();
    }

    public int obtenerLikesContacto (ListaMascotas listaMascotas) {
        BaseDatos db = new BaseDatos ( context );

        return db.obtenerLikesContacto ( listaMascotas );
    }

   /* public int obtener descripcion (ListaMascotas listaMascotas {
        BaseDatos db = new BaseDatos ( context );
        return db.
    }*/

}
