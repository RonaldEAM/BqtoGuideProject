package com.aula51.bqtoguideproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.aula51.bqtoguideproject.Application.MyApplication;
import com.aula51.bqtoguideproject.Models.SitioTuristico;
import com.aula51.bqtoguideproject.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListaSitios extends AppCompatActivity {

    Bundle bundle;
    String modalidad;
    ListView lv_sitios;
    ArrayList<String> sitios;
    ArrayAdapter<String> arrayAdapter;
    DatabaseReference mRef;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sitios);

        bundle = getIntent().getExtras();
        modalidad = bundle.getString("modalidad");

        MyApplication app = (MyApplication) getApplicationContext();
        mRef = app.getFirebaseReference();

        lv_sitios = (ListView) findViewById(R.id.lv_sitios);
        sitios = new ArrayList<>();


        mRef.child("NombreSitios").child(modalidad).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                sitios.add(dataSnapshot.getValue().toString());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                sitios.add(dataSnapshot.getValue().toString());
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        arrayAdapter = new ArrayAdapter<>(ListaSitios.this, android.R.layout.simple_list_item_1, sitios);
        lv_sitios.setAdapter(arrayAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ListaSitios.this, AgregarSitio.class );
                intent.putExtra("modalidad",modalidad);
                startActivity(intent);
            }
        });
    }


}
