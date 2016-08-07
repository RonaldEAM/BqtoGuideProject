package com.aula51.bqtoguideproject.Application;

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Rocketron on 07-08-2016.
 */
public class MyApplication extends Application {

    DatabaseReference dbRef;

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        dbRef = FirebaseDatabase.getInstance().getReference();
    }

    public DatabaseReference getFirebaseReference() {
        return dbRef;
    }
}
