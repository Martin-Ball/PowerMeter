package com.example.powermeter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;

public class Potencia extends AppCompatActivity {

    private GraphView graphHora;
    private GraphView graphDia;
    private GraphView graphMes;
    private DataPoint[] hora;
    private DataPoint[] dia;
    private DataPoint[] mes;
    private TextView pot_cons_hora;
    private TextView pot_cons_dia;
    private TextView pot_cons_mes;
    private float pot_hor_total;
    private float pot_dia_total;
    private float pot_mes_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potencia);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //activar la flecha hacia atras toolbar

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //listener de flecha hacia atras

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        // Defino textview para hora, dia, mes
        pot_cons_hora = (TextView) findViewById(R.id.potxHora);
        pot_cons_dia = (TextView) findViewById(R.id.potxDia);
        pot_cons_mes = (TextView) findViewById(R.id.potxMes);


        // Defino los objetos graficas

        graphHora = (GraphView) findViewById(R.id.graphHora);
        graphDia = (GraphView) findViewById(R.id.graphDia);
        graphMes = (GraphView) findViewById(R.id.graphMes);

        //limito cantidad de decimales
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');

        final DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);


        // Leer datos de firebase para grafica hora
        DatabaseReference databaseHora = FirebaseDatabase.getInstance().getReference();

        databaseHora.child("grafica_hora").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {

                // carga de datos en arreglo
                if (dataSnapshot.exists())
                {

                    hora = new DataPoint[60];
                    pot_hor_total = 0;

                    for (int i=0; i<=59; i++)
                    {
                        //busco valor en firebase
                        final String por_min = dataSnapshot.child(Integer.toString(i)).getValue().toString();
                        //convierto a entero
                        final float xminuto = Float.parseFloat(por_min)/1000;
                        //guardo datapoint
                        hora[i] = new DataPoint(i, xminuto);
                        pot_hor_total = pot_hor_total + xminuto;
                    }
                    LineGraphSeries<DataPoint> arregloHora = new LineGraphSeries<>(hora);
                    //configuro grafica
                    configGraphHora(arregloHora, graphHora, 60);
                    //paso serie a la grafica
                    graphHora.addSeries(arregloHora);
                    pot_cons_hora.setText(formato1.format(pot_hor_total) + " KW");

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Leer datos de firebase para grafica dia
        DatabaseReference databaseDia = FirebaseDatabase.getInstance().getReference();

        databaseDia.child("grafica_dia").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {

                // carga de datos en arreglo
                if (dataSnapshot.exists())
                {

                    dia = new DataPoint[24];
                    pot_dia_total = 0;

                    for (int i=0; i<=23; i++)
                    {
                        //busco valor en firebase
                        final String por_hora = dataSnapshot.child(Integer.toString(i)).getValue().toString();
                        //convierto a entero
                        final float xhora = Float.parseFloat(por_hora)/1000;
                        //guardo datapoint
                        dia[i] = new DataPoint(i, xhora);
                        pot_dia_total = pot_dia_total + xhora;
                    }
                    LineGraphSeries<DataPoint> arregloDia = new LineGraphSeries<>(dia);
                    //configuro grafica
                    configGraphDia(arregloDia, graphDia, 25);
                    //paso serie a la grafica
                    graphDia.addSeries(arregloDia);
                    pot_cons_dia.setText(formato1.format(pot_dia_total) + " KW");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Leer datos de firebase para grafica dia
        DatabaseReference databaseMes = FirebaseDatabase.getInstance().getReference();

        databaseMes.child("grafica_mes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {

                // carga de datos en arreglo
                if (dataSnapshot.exists())
                {

                    mes = new DataPoint[31];
                    pot_mes_total = 0;

                    for (int i=0; i<=30; i++)
                    {
                        //busco valor en firebase
                        final String por_dia = dataSnapshot.child(Integer.toString(i)).getValue().toString();
                        //convierto a entero
                        final float xdia = Float.parseFloat(por_dia)/1000;
                        //guardo datapoint
                        mes[i] = new DataPoint(i, xdia);
                        pot_mes_total = pot_mes_total + xdia;
                    }
                    LineGraphSeries<DataPoint> arregloMes = new LineGraphSeries<>(mes);
                    //configuro grafica
                    configGraphMes(arregloMes, graphMes, 32);
                    //paso serie a la grafica
                    graphMes.addSeries(arregloMes);
                    pot_cons_mes.setText(formato1.format(pot_mes_total) + " KW");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void configGraphMes(LineGraphSeries<DataPoint> arregloMes, GraphView graphMes, int i2) {
        // Seteo valor maximo en eje x

        graphMes.getViewport().setXAxisBoundsManual(true);
        graphMes.getViewport().setMinX(0);
        graphMes.getViewport().setMaxX(i2);

        // Habilito la expansión en eje x
        graphMes.getViewport().setScalable(true);

        arregloMes.setDrawBackground(true);
        arregloMes.setBackgroundColor(R.color.colorGraficas);
        arregloMes.setColor(R.color.colorLineas);
        arregloMes.setDrawDataPoints(true);
    }

    private void configGraphDia(LineGraphSeries<DataPoint> arregloDia, GraphView graphDia, int max) {
        // Seteo valor maximo en eje x

        graphDia.getViewport().setXAxisBoundsManual(true);
        graphDia.getViewport().setMinX(0);
        graphDia.getViewport().setMaxX(24);

        // Habilito la expansión en eje x
        graphDia.getViewport().setScalable(true);

        arregloDia.setDrawBackground(true);
        arregloDia.setBackgroundColor(R.color.colorGraficas);
        arregloDia.setColor(R.color.colorLineas);
        arregloDia.setDrawDataPoints(true);
    }

    public void configGraphHora(LineGraphSeries<DataPoint> arregloHora, GraphView graphHora, int max) {
        // Seteo valor maximo en eje x
        graphHora.getViewport().setXAxisBoundsManual(true);
        graphHora.getViewport().setMinX(0);
        graphHora.getViewport().setMaxX(max);

        // Habilito la expansión en eje x
        graphHora.getViewport().setScalable(true);


        arregloHora.setDrawBackground(true);
        arregloHora.setBackgroundColor(R.color.colorGraficas);
        arregloHora.setColor(R.color.colorLineas);
        arregloHora.setDrawDataPoints(true);
    }
}

