package com.example.akhan.firebaseapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.akhan.firebaseapp.adapter.ChannelRecyclerAdapter;
import com.example.akhan.firebaseapp.interfaces.OnItemClickListener;
import com.example.akhan.firebaseapp.model.Category;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener, View.OnClickListener {

    private RecyclerView recyclerView;
    private ChannelRecyclerAdapter channelRecyclerAdapter;
    private ImageView category1,category2,category3,category4;
    private List<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        category1 = (ImageView)findViewById(R.id.category1);
        category2 = (ImageView)findViewById(R.id.category2);
        category3 = (ImageView)findViewById(R.id.category3);
        category4 = (ImageView)findViewById(R.id.category4);
        category1.setOnClickListener(this);
        category2.setOnClickListener(this);
        category3.setOnClickListener(this);
        category4.setOnClickListener(this);

        showImagesViaGlide();

        //recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
       /* Firebase myFirebaseRef = new Firebase("https://bollywood-movies.firebaseio.com/category");
        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println("Firebase ===================== "+snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
                categories = new ArrayList<Category>();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    System.out.println("category name ========= " +postSnapshot.getKey());
                    Category category = postSnapshot.getValue(Category.class);
                    category.setName(postSnapshot.getKey());
                    System.out.println(category.getShow1() + " - " + category.getShow2());
                    categories.add(category);
                }
                channelRecyclerAdapter = new ChannelRecyclerAdapter(MainActivity.this,categories);
                channelRecyclerAdapter.setOnItemClickListener(MainActivity.this);
                recyclerView.setAdapter(channelRecyclerAdapter);
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
                recyclerView.setHasFixedSize(true);

                System.out.println("categories =========" +categories.toString());
            }
            @Override public void onCancelled(FirebaseError error) { }
        });*/
    }

    private void showImagesViaGlide() {
        Glide.with(this)
                .load("http://dailymovie.news/wp-content/uploads/2016/02/1456454720.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(android.R.color.darker_gray)
                .crossFade()
                .into(category1);

        Glide.with(this)
                .load("http://www.albanian-riviera.net/wp-content/uploads/solo_travel22.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(android.R.color.darker_gray)
                .crossFade()
                .into(category2);

        Glide.with(this)
                .load("http://www.ndtv.com/cooks/images/pizza-junk-food-600.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(android.R.color.darker_gray)
                .crossFade()
                .into(category3);

        Glide.with(this)
                .load("http://cdn.instantshift.com/media/uploads/2015/06/social-media-tips-for-business.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(android.R.color.darker_gray)
                .crossFade()
                .into(category4);

    }

    @Override
    @TargetApi(16)
    public void onItemClick(View itemView, int position) {
        Intent intent = new Intent(this, CategoryActivity.class);
        // Pass data object in the bundle and populate details activity.
        intent.putExtra("URL", categories.get(position).getImage());
        ImageView imageView = (ImageView)itemView.findViewById(R.id.categoryIV);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, (View)imageView, "category");
        startActivity(intent, options.toBundle());
    }

    @Override
    @TargetApi(16)
    public void onClick(View v) {
        Intent intent = new Intent(this, CategoryActivity.class);
        String url = "";
        if(v.getId()==R.id.category1){
            url = "http://dailymovie.news/wp-content/uploads/2016/02/1456454720.jpg";
        }else if(v.getId()==R.id.category2){
            url = "http://www.albanian-riviera.net/wp-content/uploads/solo_travel22.jpg";
        }else if(v.getId()==R.id.category3){
            url = "http://www.ndtv.com/cooks/images/pizza-junk-food-600.jpg";
        }else if(v.getId()==R.id.category4){
            url = "http://cdn.instantshift.com/media/uploads/2015/06/social-media-tips-for-business.jpg";
        }
        intent.putExtra("URL", url);
        //ImageView imageView = (ImageView)itemView.findViewById(R.id.categoryIV);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, v, "category");
        startActivity(intent, options.toBundle());
    }
}
