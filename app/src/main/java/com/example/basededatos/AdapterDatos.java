package com.example.basededatos;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import db.ConstructorContactos;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> implements View.OnClickListener {

    //ArrayList<ListaMascotas> listaDatos;
    ArrayList<ListaMascotas> listaDatos = new ArrayList<ListaMascotas>();
    private View.OnClickListener listener;// para clic en lista y lleva el implement onclic
    private Activity activity;
    private Context context;

    public AdapterDatos(ArrayList<ListaMascotas> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @NonNull
    @Override
    public AdapterDatos.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.item_list,null,false );
        View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.cardviewrecycler,null,false );

        view.setOnClickListener ( this ); // para clic en lista

        return new ViewHolderDatos ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterDatos.ViewHolderDatos holder, final int position) {

        final ListaMascotas listaMascotas = listaDatos.get ( position );


        holder.btnLike.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                //Toast toast = new Toast.makeText (  , "Diste like a ", Toast.LENGTH_SHORT).show ();

                Toast.makeText(v.getContext(), "Diste like a "+ listaDatos.get ( position ).getNombre (),
                        Toast.LENGTH_SHORT).show();

                ConstructorContactos constructorContactos = new ConstructorContactos ( context );
                constructorContactos.darLikeContacto ( listaMascotas );
                holder.contadorLike.setText ( constructorContactos.obtenerLikesContacto ( listaMascotas ) );
            }
        } );
        //holder.asignarDatos(listaDatos.get ( position ));

        holder.nomb.setText ( listaDatos.get ( position ).getNombre () );
        holder.img.setImageResource ( listaDatos.get ( position ).getImagenn () );
       // holder.Descrp.setText ( listaDatos.get ( position ).getDescrip () );
        holder.contadorLike.setText ( String.valueOf ( listaDatos.get ( position ).getContadorLike () ) + " LIKES" );

    }

    @Override
    public int getItemCount() {
        //return (listaDatos == null) ? 0 : listaDatos.size();
        return listaDatos.size ();

    }

    public void setOnClickListener (View.OnClickListener listener){
        // para clic en lista
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        //para clic en lista
        if (listener!=null){
            listener.onClick ( v );
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView nomb;
        ImageView img;
        TextView contadorLike;
        ImageButton btnLike;
        TextView Descrp;

        public ViewHolderDatos(@NonNull View itemView) {
            super ( itemView );
            //dato = (TextView) itemView.findViewById ( R.id.idDato );
            nomb = (TextView) itemView.findViewById ( R.id.TxV1 );
            img = (ImageView) itemView.findViewById ( R.id.imgVer );
            contadorLike = (TextView) itemView.findViewById ( R.id.ContadorLike );
            btnLike = (ImageButton) itemView.findViewById ( R.id.ImgHuesoLike );
            Descrp = (TextView) itemView.findViewById ( R.id.Descrp );

        }

    }

}
