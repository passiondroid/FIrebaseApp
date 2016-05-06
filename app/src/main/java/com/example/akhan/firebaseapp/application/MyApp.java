package com.example.akhan.firebaseapp.application;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by akhan on 5/3/2016.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
