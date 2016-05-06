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
            System.out.println("snapshot========= " + postSnapshot.getKey());
            Comedy comedy = new Comedy();
            for (DataSnapshot comedynapshot : postSnapshot.getChildren()) {
                ArrayList<Post> postList = new ArrayList<>();
                if (comedynapshot.getKey().equals("title")) {
                    comedy.setTitle(comedynapshot.getValue().toString());
                    System.out.println("title========= " + comedynapshot.getValue().toString());
                } else if (comedynapshot.getKey().equals("image_link")) {
                    comedy.setImage_link(comedynapshot.getValue().toString());
                    System.out.println("image_link========= " + comedynapshot.getValue().toString());
                } else if (comedynapshot.getKey().equals("Posts")) {
                    for (DataSnapshot postsSnapshot : comedynapshot.getChildren()) {
                        Post post = postsSnapshot.getValue(Post.class);
                        postList.add(post);
                        System.out.println("post========= " + post.toString());
                    }
                }
                comedy.setPosts(postList);
            }
            comedyList.add(comedy);
        }
        return comedyList;
    }
}
