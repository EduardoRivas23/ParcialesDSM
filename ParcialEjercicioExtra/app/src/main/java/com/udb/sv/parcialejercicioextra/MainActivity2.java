package com.udb.sv.parcialejercicioextra;

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

        DT1=(TextView)findViewById(R.id.lbl_salario);
        DT2=(TextView)findViewById(R.id.lbl_nuevo_salario);


        DT1.setText("Salario anterior: "+datos.getString("Salario"));
        DT2.setText("Salario nuevo: "+datos.getString("NewSalario"));
    }
}