package com.example.akhan.firebaseapp.model;

import java.util.List;

/**
 * Created by akhan on 5/6/2016.
 */
public class Comedy {

    private String title;
    private String image_link;
    private List<Post> posts;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
