package com.example.parcial_1_ejercicio_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText editTextVotos;
    Button btnenviar;

    TextView txtVotos, txtprimero, txtsegundo, txttercero, txtcuarto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextVotos = findViewById(R.id.editTextVotos);

        txtVotos = findViewById(R.id.txttotal);
        txtprimero = findViewById(R.id.txtprimer);
        txtsegundo = findViewById(R.id.txtsegundo);
        txttercero = findViewById(R.id.txttercero);
        txtcuarto = findViewById(R.id.txtcuarto);
        btnenviar = findViewById(R.id.btncontar);
        btnenviar.setOnClickListener(v -> {
            txtVotos.setText("");
            txtprimero.setText("");
            txtsegundo.setText("");
            txttercero.setText("");
            txtcuarto.setText("");

            calculate();
        });
    }

    private void calculate() {
        if(!editTextVotos.getText().equals("")) {
            boolean validacion = true;
            String separacionDatos = editTextVotos.getText().toString();
            String[] votos = separacionDatos.split(",");
            if (validacion) {
                Integer totalVotos;
                Integer[] candVotos = new Integer[]{0, 0, 0, 0};
                String[] candidatos = new String[]{"Candidato 1", "Candidato 2", "Candidato 3", "Candidato 4"};

                for (String vot : votos) {
                    if (Integer.parseInt(vot.trim()) == 1) {
                        candVotos[0]++;
                    } else if (Integer.parseInt(vot.trim()) == 2) {
                        candVotos[1]++;
                    } else if (Integer.parseInt(vot.trim()) == 3) {
                        candVotos[2]++;
                    } else if (Integer.parseInt(vot.trim()) == 4) {
                        candVotos[3]++;
                    }
                }

                for (int i = 0; i < 4; i++) {
                    for (int j = i; j < 4; j++) {
                        if (candVotos[i] < candVotos[j]) {
                            int value = candVotos[i];
                            candVotos[i] = candVotos[j];
                            candVotos[j] = value;

                            String text = candidatos[i];
                            candidatos[i] = candidatos[j];
                            candidatos[j] = text;
                        }
                    }
                }
                totalVotos = candVotos[0] + candVotos[1] + candVotos[2] + candVotos[3];
                txtVotos.setText(String.valueOf(totalVotos));
                String uno = candidatos[0] + " -> " + candVotos[0] + "Votos  (" + calcular_porcentaje(candVotos[0], totalVotos) + "%)";
                txtprimero.setText(uno);
                String dos = candidatos[1] + " ->" + candVotos[1] + "Votos (" + calcular_porcentaje(candVotos[1], totalVotos) + "%)";
                txtsegundo.setText(dos);
                String tres = candidatos[2] + " -> " + candVotos[2] + "Votos (" + calcular_porcentaje(candVotos[2], totalVotos) + "%)";
                txttercero.setText(tres);
                String cuatro = candidatos[3] + " -> " + candVotos[3] + "Votos (" + calcular_porcentaje(candVotos[3], totalVotos) + "%)";
                txtcuarto.setText(cuatro);

            }
        }
    }

    public double calcular_porcentaje(Integer votos, Integer totalVotos) {
        double calpor = votos * 100.0 / totalVotos;
        double calporfinal = Math.round(calpor * 100.0) / 100.0;
        return calporfinal;
    }
}



