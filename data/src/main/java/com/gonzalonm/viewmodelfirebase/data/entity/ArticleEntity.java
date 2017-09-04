package com.gonzalonm.viewmodelfirebase.data.entity;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class ArticleEntity {
    
    private String name;
    private String imageUrl;
    private int price;

    public ArticleEntity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
