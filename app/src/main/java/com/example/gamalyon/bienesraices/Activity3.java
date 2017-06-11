package com.example.gamalyon.bienesraices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import Entities.Proyecto;

public class Activity3 extends AppCompatActivity {

    TextView Tv1,Tv2,Tv3,Tv4,Tv5,Tv6,Tv7,Tv8,Tv9,Tv10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Intent i=getIntent();
        Proyecto elProyecto=(Proyecto)i.getExtras().getSerializable("resultados");
        Tv1=(TextView) findViewById(R.id.textView6);
        Tv2=(TextView) findViewById(R.id.textView7);
        Tv3=(TextView) findViewById(R.id.textView8);
        Tv4=(TextView) findViewById(R.id.textView9);
        Tv5=(TextView) findViewById(R.id.textView10);
        Tv6=(TextView) findViewById(R.id.textView11);
        Tv7=(TextView) findViewById(R.id.textView12);
        Tv8=(TextView) findViewById(R.id.textView13);
        Tv9=(TextView) findViewById(R.id.textView14);
        Tv10=(TextView) findViewById(R.id.textView15);

        Tv1.setText("El proyecto es "+elProyecto.getNombreProyecto());
        String TipoProyecto=elProyecto.getTipoProyecto()==1? "casa":"departamento";
        Tv2.setText("El bien de raíz es:"+TipoProyecto);
        Tv3.setText("La dimensión "+String.valueOf(elProyecto.getDimensiones()));
        Tv4.setText("El valor de UF "+String.valueOf(((int) elProyecto.getValorUF())));
        Tv5.setText("El dscto en verde es: "+String.valueOf((int) elProyecto.getDesctoEnVerde()));
        Tv6.setText("El dscto por banco BCA"+String.valueOf((int) elProyecto.getDescuentosBco()));
        Tv7.setText("El valor neto de la propiedad es :"+String.valueOf((int) elProyecto.getValorNeto()));
        Tv8.setText("El valor total es :"+String.valueOf((int) elProyecto.getValorTotal()));

    }
}
