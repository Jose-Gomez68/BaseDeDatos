package com.example.basededatos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import VistaDel_db_MainActivity.IRecyclerView;
import presentador.IRecyclerViewFPresenter;
import presentador.RecyclerViewFPresenter;

public class MainActivity extends AppCompatActivity implements IRecyclerView {

    private RecyclerView recycler;
    private ArrayList<ListaMascotas> listaMascotas;
    private IRecyclerViewFPresenter presenter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );


        recycler = (RecyclerView) findViewById(R.id.RecyclerMostrar);
        presenter = new  RecyclerViewFPresenter (this, getBaseContext ());

    }

    @Override
    public void generarLinerLayoutGrid() {

        recycler.setLayoutManager ( new GridLayoutManager ( this, 1 ) );
        /*LinearLayoutManager manager = new LinearLayoutManager ( this );
        recycler.setLayoutManager ( manager );
        recycler.setHasFixedSize ( true );*/
    }

    @Override
    public AdapterDatos crearAdaptador(final ArrayList<ListaMascotas> listaMascotas) {

        final AdapterDatos adapter = new AdapterDatos ( listaMascotas );
    //metodo clic para seleccionar uno de la lista
        adapter.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText( getApplicationContext (), "Diste like a a la lista"+ listaMascotas.get ( recycler.getChildAdapterPosition ( v ) ).getNombre (),
                        Toast.LENGTH_SHORT).show();
                Intent Detalle = new Intent ( getApplicationContext () , Detalle_Mascota.class );
                Detalle.putExtra ( "id",listaMascotas.get ( recycler.getChildAdapterPosition ( v ) ).getId () );
                Detalle.putExtra ( "descrip", listaMascotas.get ( recycler.getChildAdapterPosition ( v ) ).getDescrip () );
                startActivity ( Detalle );
            }
        } );

        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(AdapterDatos adapter) {
        //aqui podria ir el clic en la lista
        recycler.setAdapter ( adapter );
        //listaDatos = new ArrayList<ListaMascotas> ();

    }
}
