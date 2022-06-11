package com.example.latihan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Product extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterRecyclerView adapterRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ProductModel> data;

    TextView category;
    ImageView notif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        TextView tvData1 = (TextView) findViewById(R.id.toolbar_title);
        tvData1.setText(getIntent().getStringExtra("dataKategori"));

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        String category = tvData1.getText().toString();

        data = new ArrayList<>();
        if (category.equals("Paper")){
            for (int i = 0; i < ProductItem.product_name_papper.length; i++){
                data.add(new ProductModel(
                        ProductItem.product_name_papper[i],
                        ProductItem.product_price_papper[i],
                        ProductItem.product_img_papper[i]
                ));
            }
        }else if (category.equals("Leather")){
            for (int i = 0; i < ProductItem.product_name_leather.length; i++){
                data.add(new ProductModel(
                        ProductItem.product_name_leather[i],
                        ProductItem.product_price_leather[i],
                        ProductItem.product_img_leather[i]
                ));
            }
        }else if (category.equals("Fabric")){
            for (int i = 0; i < ProductItem.product_name_fabric.length; i++){
                data.add(new ProductModel(
                        ProductItem.product_name_fabric[i],
                        ProductItem.product_price_fabric[i],
                        ProductItem.product_img_fabric[i]
                ));
            }
        }else if (category.equals("Embroidery")){
            for (int i = 0; i < ProductItem.product_name_embroidery.length; i++){
                data.add(new ProductModel(
                        ProductItem.product_name_embroidery[i],
                        ProductItem.product_price_embroidery[i],
                        ProductItem.product_img_embroidery[i]
                ));
            }
        }else if (category.equals("Ceramic")){
            for (int i = 0; i < ProductItem.product_name_ceramic.length; i++){
                data.add(new ProductModel(
                        ProductItem.product_name_ceramic[i],
                        ProductItem.product_price_ceramic[i],
                        ProductItem.product_img_ceramic[i]
                ));
            }
        }

        adapterRecyclerView = new AdapterRecyclerView(data);
        recyclerView.setAdapter(adapterRecyclerView);

        notif = (ImageView) findViewById(R.id.notifikasi);
        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Product.this, Notifikasi.class);
                startActivity(intent);
            }
        });

    }
}