package com.aula51.bqtoguideproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aula51.bqtoguideproject.Application.MyApplication;
import com.aula51.bqtoguideproject.Models.SitioTuristico;
import com.aula51.bqtoguideproject.R;
import com.google.firebase.database.DatabaseReference;

public class AgregarSitio extends AppCompatActivity {

    EditText et_nombresitio;
    Button btn_guardar;
    Bundle bundle;
    String modalidad;
    DatabaseReference mRef;
    SitioTuristico sitio;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_sitio);

        bundle = getIntent().getExtras();
        modalidad = bundle.getString("modalidad");

        et_nombresitio = (EditText) findViewById(R.id.et_nombresitio);
        btn_guardar = (Button) findViewById(R.id.btn_guardar);

        MyApplication app = (MyApplication) getApplicationContext();
        mRef = app.getFirebaseReference();

        sitio = new SitioTuristico();

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sitio.setNombre(et_nombresitio.getText().toString());
                mRef.child("NombreSitios").child(modalidad).push().setValue(sitio.getNombre());

                intent = new Intent(AgregarSitio.this, ListaSitios.class );
                intent.putExtra("modalidad",modalidad);
                startActivity(intent);
            }
        });
    }
}
