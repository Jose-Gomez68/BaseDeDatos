package com.example.basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Detalle_Mascota extends AppCompatActivity {

    private TextView des;
    Bundle datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_detalle__mascota );

        des = (TextView) findViewById ( R.id.Descrp );
        datos = getIntent ().getExtras ();
        String de = datos.getString ( "descrip" );
        des.setText ( de );

    }
}
