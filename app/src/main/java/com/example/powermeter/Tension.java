package com.example.powermeter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ntt.customgaugeview.library.GaugeView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Tension extends AppCompatActivity {

    private float valortension = 0;

    private TextView tension;
    private TextView estadot;
    private GaugeView gaugeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tension);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tension = (TextView) findViewById(R.id.textotension);
        estadot = (TextView) findViewById(R.id.estadoten);

        //habilitar flecha hacia atras toolbar

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //gauge

        gaugeView = (GaugeView) findViewById(R.id.gauge_view);
        gaugeView.setShowRangeValues(true);

        //si no hay tension al iniciar
        estadot.setText("Sin tensión");
        tension.setText("0");

        //limito cantidad de decimales
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');

        final DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);


        // Leer datos de firebase
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();

        database.child("pot_main").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                {
                    //creo string para leer firebase
                    final String valortension2 = dataSnapshot.child("tension").getValue().toString();

                    //convierto string a entero
                    valortension = Float.parseFloat(valortension2);

                    //setear texto tensión igual al de aguja
                    tension.setText(" Tensión actual:  " + formato1.format(valortension) + "  V");


                    //seteo valor de aguja en metodo
                    setAguja(valortension,gaugeView);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //redireccion a main activity

        FloatingActionButton fab2 = findViewById(R.id.fab3);
        fab2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }

        });
    }

    private void setAguja(float valortension, GaugeView gaugeView) {

        if (valortension < 200)
        {
            estadot.setText(" Estado tension: Baja tensión");
            gaugeView.setTargetValue(valortension);
        }
        else if (valortension >= 200 && valortension < 240)
        {
            estadot.setText(" Estado tension: Tension normal");
            gaugeView.setTargetValue(valortension);
        }
        else if (valortension >= 240 && valortension < 290)
        {
            estadot.setText(" Estado tension: Alta tension");
            gaugeView.setTargetValue(valortension);
        }
        else if (valortension >= 290)
        {
            estadot.setText(" Estado tension: Fuera de rango");
            gaugeView.setTargetValue(0);
        }
    }
}
