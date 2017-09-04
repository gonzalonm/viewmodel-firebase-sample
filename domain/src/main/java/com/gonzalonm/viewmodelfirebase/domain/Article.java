package com.gonzalonm.viewmodelfirebase.domain;

public class Article {

    private String name;
    private String imageUrl;
    private int price;

    public Article() {
        // Default constructor required for calls to DataSnapshot
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
