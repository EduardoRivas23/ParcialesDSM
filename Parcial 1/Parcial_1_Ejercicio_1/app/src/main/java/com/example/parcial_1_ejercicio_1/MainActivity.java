package com.example.parcial_1_ejercicio_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txt1;
    private EditText txt2;
    private EditText txt3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (EditText) findViewById(R.id.txt_A);
        txt2 = (EditText) findViewById(R.id.txt_B);
        txt3 = (EditText) findViewById(R.id.txt_C);

    }


    public void Calcular(View view) {

        String string_txt1 = txt1.getText().toString();
        String string_txt2 = txt2.getText().toString();
        String string_txt3 = txt3.getText().toString();

        double b = Double.parseDouble(string_txt2);
        double a = Double.parseDouble(string_txt1);
        double c = Double.parseDouble(string_txt3);
        double raiz;
        double Resultado1 = 0;
        double Resultado2 = 0;
        raiz= Math.pow(b,2)-4*a*c; //calculo raiz
        if (raiz < 0){
            Toast toastMessage = Toast.makeText(this,"La operacion no se puede Relaisar la operacion ",Toast.LENGTH_LONG);
            toastMessage.show();
        } else{
            Resultado1 = (-b+Math.sqrt(raiz))/(2*a); //continuacion formula
            Resultado2 = (-b-Math.sqrt(raiz))/(2*a);
        }



      //Resultado =-b + Math.sqrt(Math.pow(b,2)-4*a*c/2*a); prueba

        Intent i = new Intent(this, MainActivity2.class);

        i.putExtra("Total1", String.valueOf(Resultado1));
        i.putExtra("Total2", String.valueOf(Resultado2));
        startActivity(i);





    }


}

