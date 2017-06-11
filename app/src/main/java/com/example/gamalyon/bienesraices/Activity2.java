package com.example.gamalyon.bienesraices;

import android.content.Context;
import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import Entities.BienRaiz;
import Entities.Proyecto;


public class Activity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    RadioButton rB1;
    RadioButton rB2;
    CheckBox chckB;
    CheckBox chckB2;
    Spinner spn1;
    Spinner spn2;
    RadioGroup rg;
    String[] proyectos;
    String[] modelos;
    boolean dsctoVerde;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        rB1=(RadioButton) findViewById(R.id.radioButton);
        rB2=(RadioButton) findViewById(R.id.radioButton2);
        rg=(RadioGroup) findViewById(R.id.rg);
        chckB=(CheckBox) findViewById(R.id.checkBox3);
        spn1=(Spinner) findViewById(R.id.spinner2);
        spn2=(Spinner) findViewById(R.id.spinner3);
        spn1.setOnItemSelectedListener(this);
        spn2.setOnItemSelectedListener(this);

        ArrayAdapter ArrAdapt;

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                spn1=(Spinner) findViewById(R.id.spinner2);
                spn2=(Spinner) findViewById(R.id.spinner3);
                if (checkedId == R.id.radioButton) {
                    ArrayAdapter ArrAdapt;
                    proyectos=new String[]{"Seleccione","Condominio Los almendros(en verde) ", "Condominio Los pinos ", "Condominio Villa alegre"};
                    ArrAdapt=new ArrayAdapter<String>(group.getContext(),android.R.layout.simple_list_item_1,proyectos);
                    spn1.setAdapter(ArrAdapt);

                } else if (checkedId == R.id.radioButton2){
                    ArrayAdapter ArrAdapt;
                    proyectos=new String[]{"Seleccione","Edificio Las Rosas", "Edificio Quelé(en verde)", "Edificio Los cisnes"};
                    ArrAdapt=new ArrayAdapter<String>(group.getContext(),android.R.layout.simple_list_item_1,proyectos);
                    spn1.setAdapter(ArrAdapt);
                }
                spn1.setVisibility(View.VISIBLE);

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        parent.getId();
        if(parent.getId()==R.id.spinner2)
        {
            if(rB1.isChecked())
            {
                if (position>0) {
                    ArrayAdapter ArrAdapt;
                    modelos = new String[]{"selecciona ","110 m2=valor:3200-UF", "130 m2=valor:3800-UF", "170 m2=valor:4100-UF"};
                    ArrAdapt = new ArrayAdapter<String>(spn1.getContext(), android.R.layout.simple_list_item_1, modelos);
                    spn2.setAdapter(ArrAdapt);
                    spn2.setVisibility(View.VISIBLE);
                }
            }
            else
            {
                if(position>0) {
                    ArrayAdapter ArrAdapt;
                    modelos = new String[]{"selecciona","100 m2=valor:1000-UF", "120 m2=valor:1200-UF"};
                    ArrAdapt = new ArrayAdapter<String>(spn1.getContext(), android.R.layout.simple_list_item_1, modelos);
                    spn2.setAdapter(ArrAdapt);
                    spn2.setVisibility(View.VISIBLE);

                }
            }

        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calcular(View view)
    {
        if(spn1!=null && spn2!=null ) {

            if(spn1.getSelectedItemPosition()>0 && spn2.getSelectedItemPosition()>0) {


                BienRaiz elBienRaiz = new BienRaiz();
                int tipoPro = rB1.isSelected() == true ? 1 : 2;
                elBienRaiz.elBienRaiz = new Proyecto();
                elBienRaiz.elBienRaiz.setTipoProyecto(tipoPro);
                elBienRaiz.elBienRaiz.setNombreProyecto(spn1.getSelectedItem().toString());
                String datosCadena = spn2.getSelectedItem().toString();
                String[] datosSeparados = datosCadena.split(" ");
                elBienRaiz.elBienRaiz.setDimensiones(Double.parseDouble(datosSeparados[0]));
                String valorUF = datosSeparados[1].substring(9, (datosSeparados[1].length() - 3));
                elBienRaiz.elBienRaiz.setValorUF(Double.parseDouble(valorUF));
                Double valorNeto = elBienRaiz.uF * Double.parseDouble(valorUF);
                elBienRaiz.elBienRaiz.setValorNeto(valorNeto);
                if (elBienRaiz.elBienRaiz.getTipoProyecto() == 1) {
                    dsctoVerde = spn1.getSelectedItemPosition() == 1 ? true : false;


                } else {
                    dsctoVerde = spn1.getSelectedItemPosition() == 2 ? true : false;
                }

                Proyecto elproyecto = elBienRaiz.creaCalculos(elBienRaiz.elBienRaiz, dsctoVerde, chckB.isChecked() ? true : false);
                Intent i = new Intent(this, Activity3.class);
                i.putExtra("resultados", elproyecto);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this,"seleccione valores en las listas desplegables",Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this,"seleccione valores en las listas desplegables",Toast.LENGTH_SHORT).show();
        }
    }
}
