package com.example.powermeter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

public class Corriente extends AppCompatActivity {

    private float valoragujacorr = 0;
    private GaugeView gaugeViewCorr;
    private TextView corriente;
    private TextView estadocorr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corriente);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        corriente = (TextView) findViewById(R.id.textocorriente);
        estadocorr = (TextView) findViewById(R.id.estadocorr);

        //habilitar flecha hacia atras toolbar

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        //gauge

        gaugeViewCorr = (GaugeView) findViewById(R.id.gauge_view);
        gaugeViewCorr.setShowRangeValues(true);

        estadocorr.setText("Sin consumo");
        corriente.setText("0");

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
                    final String valorcorr2 = dataSnapshot.child("corriente").getValue().toString();

                    //convierto string a entero
                    valoragujacorr = Float.parseFloat(valorcorr2);

                    //setear texto tensión igual al de aguja
                    corriente.setText("   Corriente actual:   " + formato1.format(valoragujacorr) + " A");

                    //seteo valor de aguja en metodo
                    setValorAguja(valoragujacorr, estadocorr, gaugeViewCorr);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        //redireccion a main activity
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });    }

    private void setValorAguja(float valoragujacorr, TextView estadocorr, GaugeView gaugeViewCorr) {
        if (valoragujacorr < 10)
        {
            estadocorr.setText("   Consumo:  Bajo");
            gaugeViewCorr.setTargetValue(valoragujacorr);
        }
        else if (valoragujacorr >= 10 && valoragujacorr < 24)
        {
            estadocorr.setText("   Consumo:  Normal");
            gaugeViewCorr.setTargetValue(valoragujacorr);
        }
        else if (valoragujacorr >= 24 && valoragujacorr < 31)
        {
            estadocorr.setText("   Consumo:  Alto");
            gaugeViewCorr.setTargetValue(valoragujacorr);
        }
        else if(valoragujacorr >= 35)
        {
            estadocorr.setText("   Consumo:  Fuera de rango");
            gaugeViewCorr.setTargetValue(0);
        }
    }

}
