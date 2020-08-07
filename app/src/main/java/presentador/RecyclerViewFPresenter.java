package presentador;

import android.content.Context;

import com.example.basededatos.ListaMascotas;

import java.util.ArrayList;

import VistaDel_db_MainActivity.IRecyclerView;
import db.ConstructorContactos;

public class RecyclerViewFPresenter implements IRecyclerViewFPresenter {

    private IRecyclerView iRecyclerView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<ListaMascotas> listaMascotas;

    public RecyclerViewFPresenter(IRecyclerView iRecyclerView, Context context) {
        this.iRecyclerView = iRecyclerView;
        this.context = context;
        obtenerContactosBaseDatos ();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos ( context );
        listaMascotas = constructorContactos.obtenerDatos ();
        mostrarContactosRV ();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerView.inicializarAdaptadorRV ( iRecyclerView.crearAdaptador ( listaMascotas ) );
        iRecyclerView.generarLinerLayoutGrid ();

    }
}
