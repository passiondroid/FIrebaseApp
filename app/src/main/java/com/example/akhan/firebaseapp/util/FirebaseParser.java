package com.example.akhan.firebaseapp.util;

import com.example.akhan.firebaseapp.model.Comedy;
import com.example.akhan.firebaseapp.model.Post;
import com.firebase.client.DataSnapshot;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akhan on 5/6/2016.
 */
public class FirebaseParser {

    public static List<Comedy> getComedyList(DataSnapshot snapshot){
        ArrayList<Comedy> comedyList = new ArrayList<>();
        for (DataSnapshot postSnapshot: snapshot.getChildren()) {
            Comedy comedy = new Comedy();
            for (DataSnapshot comedynapshot : snapshot.getChildren()) {
                for (DataSnapshot snapshot1 : comedynapshot.getChildren()) {
                    ArrayList<Post> postList = new ArrayList<>();
                    System.out.println("comedynapshot========= " + postSnapshot.getKey());
                    if (snapshot1.getKey().equals("title")) {
                        comedy.setTitle(snapshot1.getValue().toString());
                        System.out.println("title========= " + postSnapshot.getKey());
                    } else if (snapshot1.getKey().equals("image_link")) {
                        comedy.setImage_link(snapshot1.getValue().toString());
                        System.out.println("image_link========= " + postSnapshot.getKey());
                    } else if (snapshot1.getKey().equals("Posts")) {
                        Post post = snapshot1.getValue(Post.class);
                        postList.add(post);
                        System.out.println("post========= " + post.toString());
                    }
                    comedy.setPosts(postList);
                }
                comedyList.add(comedy);
            }
        }
        return comedyList;
    }
}
