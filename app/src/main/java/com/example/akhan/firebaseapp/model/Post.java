package com.example.akhan.firebaseapp.model;

/**
 * Created by akhan on 5/6/2016.
 */
public class Post {

    private String image;
    private String link;
    private String title;

    public Post() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "image : "+image+", link : "+link+", title "+title;
    }
}
