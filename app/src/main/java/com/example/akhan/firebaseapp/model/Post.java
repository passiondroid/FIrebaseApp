package com.example.akhan.firebaseapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by akhan on 5/6/2016.
 */
public class Post implements Parcelable {

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

    protected Post(Parcel in) {
        image = in.readString();
        link = in.readString();
        title = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
        dest.writeString(link);
        dest.writeString(title);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };
}