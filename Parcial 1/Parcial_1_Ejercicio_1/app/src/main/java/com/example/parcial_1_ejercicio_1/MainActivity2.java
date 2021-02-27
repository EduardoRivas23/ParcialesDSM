package com.example.parcial_1_ejercicio_1;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView DT1;
   private TextView DT2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle datos=getIntent().getExtras();

        DT1=(TextView)findViewById(R.id.lbl_resul1);
        DT2=(TextView)findViewById(R.id.lbl_resul2);



        DT1.setText("El Resultado usando signo positivo es: "+datos.getString("Total1"));
        DT2.setText("El Resultado usando signo negativo es: "+datos.getString("Total2"));

    }
}