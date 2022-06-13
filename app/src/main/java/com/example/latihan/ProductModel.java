package com.example.latihan;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductModel implements Parcelable {

    private String name;
    private String price;
    private String kondisi;
    private String weight;
    private String stock;
    private String desc;
    private int img;

    public ProductModel(String name, String price, String kondisi, String weight, String stock, String desc, int img) {
        this.name = name;
        this.price = price;
        this.kondisi = kondisi;
        this.weight = weight;
        this.stock = stock;
        this.desc = desc;
        this.img = img;
    }

    protected ProductModel(Parcel in) {
        name = in.readString();
        price = in.readString();
        kondisi = in.readString();
        weight = in.readString();
        stock = in.readString();
        desc = in.readString();
        img = in.readInt();
    }

    public static final Creator<ProductModel> CREATOR = new Creator<ProductModel>() {
        @Override
        public ProductModel createFromParcel(Parcel in) {
            return new ProductModel(in);
        }

        @Override
        public ProductModel[] newArray(int size) {
            return new ProductModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getKondisi() {
        return kondisi;
    }

    public String getWeight() {
        return weight;
    }

    public String getStock() {
        return stock;
    }

    public String getDesc() {
        return desc;
    }

    public int getImg() {
        return img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(price);
        dest.writeString(kondisi);
        dest.writeString(weight);
        dest.writeString(stock);
        dest.writeString(desc);
        dest.writeInt(img);
    }
}
