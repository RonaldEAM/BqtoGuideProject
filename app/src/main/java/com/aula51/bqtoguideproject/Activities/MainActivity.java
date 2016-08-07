package com.aula51.bqtoguideproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aula51.bqtoguideproject.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_parquesnaturales;
    Button btn_parquesartificiales;
    Button btn_centroscomerciales;
    Button btn_plazas;
    Button btn_restaurantes;
    Button btn_realidadaumentada;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_parquesnaturales = (Button) findViewById(R.id.btn_parquesnaturales);
        btn_parquesartificiales = (Button) findViewById(R.id.btn_parquesartificiales);
        btn_centroscomerciales = (Button) findViewById(R.id.btn_centroscomerciales);
        btn_plazas = (Button) findViewById(R.id.btn_plazas);
        btn_restaurantes = (Button) findViewById(R.id.btn_restaurantes);
        btn_realidadaumentada = (Button) findViewById(R.id.btn_realidadaumentada);

        btn_parquesnaturales.setOnClickListener(this);
        btn_parquesartificiales.setOnClickListener(this);
        btn_centroscomerciales.setOnClickListener(this);
        btn_plazas.setOnClickListener(this);
        btn_restaurantes.setOnClickListener(this);
        btn_realidadaumentada.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_parquesnaturales:
                intent = new Intent(MainActivity.this, ListaSitios.class );
                intent.putExtra("modalidad","parquesnaturales");
                startActivity(intent);
                break;
            case R.id.btn_parquesartificiales:
                intent = new Intent(MainActivity.this, ListaSitios.class );
                intent.putExtra("modalidad","parquesartificiales");
                startActivity(intent);
                break;
            case R.id.btn_centroscomerciales:
                intent = new Intent(MainActivity.this, ListaSitios.class );
                intent.putExtra("modalidad","centroscomerciales");
                startActivity(intent);
                break;
            case R.id.btn_plazas:
                intent = new Intent(MainActivity.this, ListaSitios.class );
                intent.putExtra("modalidad","plazas");
                startActivity(intent);
                break;
            case R.id.btn_restaurantes:
                intent = new Intent(MainActivity.this, ListaSitios.class );
                intent.putExtra("modalidad","restaurantes");
                startActivity(intent);
                break;
            case R.id.btn_realidadaumentada:
                break;
        }
    }
}
