package com.example.latihan;

public class ProductModel {

    private String name, price;
    private int img;

    public ProductModel(String name, String price, int img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getImg() {
        return img;
    }
}
