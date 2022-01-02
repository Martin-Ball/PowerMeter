package com.example.powermeter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView textprogressbarten;
    private TextView textprogressbarcorr;
    private float maintenval = 100;
    private float maincorrval = 1;

    // seteo de configuraciones de ProgressBar
    CircularProgressBar circularProgressBarTen;
    CircularProgressBar circularProgressBarCorr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        textprogressbarten = (TextView) findViewById(R.id.texttensionmain);
        textprogressbarcorr = (TextView) findViewById(R.id.textcorrmain);

        circularProgressBarTen = findViewById(R.id.circularProgressBarTen);
        circularProgressBarCorr = findViewById(R.id.circularProgressBarCorr);

        //metodo de configuracion de circulo de progreso
        setConfigCircle();

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
                    //declaro strings
                    final String maintenval2 = dataSnapshot.child("tension").getValue().toString();
                    final String maincorrval2 = dataSnapshot.child("corriente").getValue().toString();

                    //convierto de strings a enteros
                    maintenval =  Float.parseFloat(maintenval2);
                    maincorrval = Float.parseFloat(maincorrval2);

                    //seteo strings en textos
                    textprogressbarten.setText(formato1.format(maintenval) +" V");
                    textprogressbarcorr.setText(formato1.format(maincorrval) +" A");

                    // seteo de progreso con animacion
                    circularProgressBarTen.setProgressWithAnimation(maintenval, (long) 1000); // =1s
                    circularProgressBarCorr.setProgressWithAnimation(maincorrval, (long) 1000); // =1s

                    //metodo para cambiar el color del circulo
                    setColorCircle(maintenval,maincorrval);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    private void setConfigCircle() {
        // Seteo maximo
        circularProgressBarTen.setProgressMax(500);
        circularProgressBarCorr.setProgressMax(40);


        // gradiente de color
        circularProgressBarTen.setProgressBarColorStart(Color.GRAY);
        circularProgressBarCorr.setProgressBarColorStart(Color.GRAY);


        circularProgressBarTen.setProgressBarColorDirection(CircularProgressBar.GradientDirection.LEFT_TO_RIGHT);
        circularProgressBarCorr.setProgressBarColorDirection(CircularProgressBar.GradientDirection.LEFT_TO_RIGHT);

        // Set background ProgressBar Color
        circularProgressBarTen.setBackgroundProgressBarColor(Color.WHITE);
        circularProgressBarCorr.setBackgroundProgressBarColor(Color.WHITE);

        // Set Width
        circularProgressBarTen.setProgressBarWidth(20); // in DP
        circularProgressBarTen.setBackgroundProgressBarWidth(0); // in DP

        circularProgressBarCorr.setProgressBarWidth(20); // in DP
        circularProgressBarCorr.setBackgroundProgressBarWidth(0); // in DP

        // Other
        circularProgressBarTen.setRoundBorder(false);
        circularProgressBarTen.setStartAngle(-110);
        circularProgressBarTen.setProgressDirection(CircularProgressBar.ProgressDirection.TO_RIGHT);

        circularProgressBarCorr.setRoundBorder(false);
        circularProgressBarCorr.setStartAngle(-110);
        circularProgressBarCorr.setProgressDirection(CircularProgressBar.ProgressDirection.TO_RIGHT);
    }

    private void setColorCircle(float maintenval, float maincorrval) {
        // Color de barra segun valores de tension
        if (maintenval >= 0 && maintenval <= 200)
        {
            circularProgressBarTen.setProgressBarColorEnd(Color.RED);
        }
        else if (maintenval > 200 && maintenval <= 240)
        {
            circularProgressBarTen.setProgressBarColorEnd(Color.GREEN);
        }
        else
        {
            circularProgressBarTen.setProgressBarColorEnd(Color.RED);
        }

        //Color de barra segun valores de corriente

        if (maincorrval >= 0 && maincorrval <= 15)
        {
            circularProgressBarCorr.setProgressBarColorEnd(Color.GREEN);
        }
        else if (maincorrval > 15 && maincorrval <= 24)
        {
            circularProgressBarCorr.setProgressBarColorEnd(Color.YELLOW);
        }
        else
        {
            circularProgressBarCorr.setProgressBarColorEnd(Color.RED);
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //redireccion del menu
        switch(id)
        {
            case R.id.Potencia:    startPotencia();
                                        break;
            case R.id.Tensión:    startTension();
                                        break;
            case R.id.Corriente:    startCorriente();
                                        break;
            case R.id.Costos:    startCostos();
                                        break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //ir a actividad potencia
    private void startPotencia() {
        Intent poten = new Intent(this, Potencia.class);
        startActivity(poten);
    }

    //ir a actividad tensión
    private void startTension() {
        Intent tension = new Intent(this, Tension.class);
        startActivity(tension);
    }

    //ir a actividad corriente
    private void startCorriente() {
        Intent corriente = new Intent(this, Corriente.class);
        startActivity(corriente);
    }

    //ir a actividad costos
    private void startCostos() {
        Intent costos = new Intent(this, Costos.class);
        startActivity(costos);
    }

}
