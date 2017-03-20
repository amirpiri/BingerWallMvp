package com.amir.bingerwallmvp.data;

import java.util.ArrayList;

/**
 * Created by amir on 3/19/17.
 */

public class Post {
    private ArrayList<Image> images;

    public Post(ArrayList<Image> images) {
        this.images = images;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }
}

