package com.example.akhan.firebaseapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.akhan.firebaseapp.adapter.ChannelRecyclerAdapter;
import com.example.akhan.firebaseapp.model.Category;
import com.example.akhan.firebaseapp.util.FirebaseParser;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private ImageView categoryIV;
    private List<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String url = getIntent().getStringExtra("URL");

        categoryIV = (ImageView)findViewById(R.id.categoryIV);
        Glide.with(this)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(android.R.color.darker_gray)
                .crossFade()
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        categoryIV.setImageDrawable(resource);
                    }
                });

        executeFirebase();
    }

    private void executeFirebase() {
        System.out.println("========================== Executing Firebase ===================== ");
        Firebase myFirebaseRef = new Firebase("https://bollywood-movies.firebaseio.com/category/Comedy");
        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println("Firebase ===================== "+snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
                FirebaseParser.getComedyList(snapshot);

            }
            @Override public void onCancelled(FirebaseError error) { }
        });

    }
}
