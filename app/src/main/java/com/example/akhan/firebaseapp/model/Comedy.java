package com.example.akhan.firebaseapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akhan on 5/6/2016.
 */
public class Comedy implements Parcelable {

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

    public Comedy() {
    }

    protected Comedy(Parcel in) {
        title = in.readString();
        image_link = in.readString();
        if (in.readByte() == 0x01) {
            posts = new ArrayList<Post>();
            in.readList(posts, Post.class.getClassLoader());
        } else {
            posts = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(image_link);
        if (posts == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(posts);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Comedy> CREATOR = new Parcelable.Creator<Comedy>() {
        @Override
        public Comedy createFromParcel(Parcel in) {
            return new Comedy(in);
        }

        @Override
        public Comedy[] newArray(int size) {
            return new Comedy[size];
        }
    };
}