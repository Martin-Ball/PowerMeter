package com.example.powermeter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;

public class Costos extends AppCompatActivity {

    private TextView textocostokw;
    private TextView textokwconsumidos;
    private TextView textocostototal;
    private TextView fecha;
    private float[] textMes;
    private float consumo_mensual = 0;
    private int diaact, mesact, anioact;
    private float costoxkw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textocostokw = (TextView) findViewById(R.id.costoKW);
        textokwconsumidos = (TextView) findViewById(R.id.kwconsumidos);
        textocostototal = (TextView) findViewById(R.id.costotot);
        fecha = (TextView) findViewById(R.id.fecha);


        //activar la flecha hacia atras toolbar

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //redireccion a main activity

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        Calendar mes = Calendar.getInstance();
        diaact = mes.get(Calendar.DAY_OF_MONTH); //dia actual (entero)
        mesact = mes.get(Calendar.MONTH) + 1; //mes actual (entero)
        anioact = mes.get(Calendar.YEAR); //año actual (entero)

        fecha.setText(" La fecha usada es:  " + Integer.toString(diaact) +
                    "/" + Integer.toString(mesact) + "/" + Integer.toString(anioact));

        //limito cantidad de decimales
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');

        final DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);

        // Leer datos de firebase para grafica dia
        DatabaseReference databaseMes = FirebaseDatabase.getInstance().getReference();

        databaseMes.child("grafica_mes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // carga de datos en arreglo
                if (dataSnapshot.exists()) {

                    textMes = new float[31];

                    for (int i=0; i<=30; i++)
                    {
                        textMes [i] = 0;
                    }
                    consumo_mensual = 0;

                    final String costokw = dataSnapshot.child("costokw").getValue().toString();

                    for (int i = 0; i <= 30; i++) {
                        //busco valor en firebase
                        final String por_dia = dataSnapshot.child(Integer.toString(i)).getValue().toString();
                        //convierto a entero
                        final float xdia = Float.parseFloat(por_dia)/1000;
                        //guardo en arreglo
                        textMes [i] = xdia;
                        consumo_mensual = consumo_mensual + xdia;
                        //convierto a float para darle formato
                        costoxkw = Float.parseFloat(costokw);
                    }

                    final float costotot = (consumo_mensual / (diaact))* costoxkw;

                    textocostokw.setText(" $ " + formato1.format(costoxkw));
                    textokwconsumidos.setText(formato1.format(consumo_mensual) + " KW");
                    textocostototal.setText(" $ " + formato1.format(costotot));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}