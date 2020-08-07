package VistaDel_db_MainActivity;

import com.example.basededatos.AdapterDatos;
import com.example.basededatos.ListaMascotas;

import java.util.ArrayList;

public interface IRecyclerView  {

    public void generarLinerLayoutGrid();

    public AdapterDatos crearAdaptador(ArrayList<ListaMascotas> listaMascotas);

    public  void  inicializarAdaptadorRV (AdapterDatos adapter);

}
