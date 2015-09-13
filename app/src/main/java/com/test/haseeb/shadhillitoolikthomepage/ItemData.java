package com.test.haseeb.shadhillitoolikthomepage;

/**
 * Created by Haseeb on 24/06/2015.
 */

public class ItemData {


    private String title;
    private int imageUrl;

    public ItemData(String title,int imageUrl){

        this.title = title;
        this.imageUrl = imageUrl;
    }



    public int getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }
    // getters & setters
}