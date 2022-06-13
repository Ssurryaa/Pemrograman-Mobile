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
            for (int i = 0; i < ProductItem.product_name_paper.length; i++){
                data.add(new ProductModel(
                        ProductItem.product_name_paper[i],
                        ProductItem.product_price_paper[i],
                        ProductItem.product_kondisi_paper[i],
                        ProductItem.product_weight_paper[i],
                        ProductItem.product_stock_paper[i],
                        ProductItem.product_desc_paper[i],
                        ProductItem.product_img_paper[i]
                ));
            }
        }else if (category.equals("Leather")){
            for (int i = 0; i < ProductItem.product_name_leather.length; i++){
                data.add(new ProductModel(
                        ProductItem.product_name_leather[i],
                        ProductItem.product_price_leather[i],
                        ProductItem.product_kondisi_leather[i],
                        ProductItem.product_weight_leather[i],
                        ProductItem.product_stock_leather[i],
                        ProductItem.product_desc_leather[i],
                        ProductItem.product_img_leather[i]
                ));
            }
        }else if (category.equals("Fabric")){
            for (int i = 0; i < ProductItem.product_name_fabric.length; i++){
                data.add(new ProductModel(
                        ProductItem.product_name_fabric[i],
                        ProductItem.product_price_fabric[i],
                        ProductItem.product_kondisi_fabric[i],
                        ProductItem.product_weight_fabric[i],
                        ProductItem.product_stock_fabric[i],
                        ProductItem.product_desc_fabric[i],
                        ProductItem.product_img_fabric[i]
                ));
            }
        }else if (category.equals("Embroidery")){
            for (int i = 0; i < ProductItem.product_name_embroidery.length; i++){
                data.add(new ProductModel(
                        ProductItem.product_name_embroidery[i],
                        ProductItem.product_price_embroidery[i],
                        ProductItem.product_kondisi_embroidery[i],
                        ProductItem.product_weight_embroidery[i],
                        ProductItem.product_stock_embroidery[i],
                        ProductItem.product_desc_embroidery[i],
                        ProductItem.product_img_embroidery[i]
                ));
            }
        }else if (category.equals("Ceramic")){
            for (int i = 0; i < ProductItem.product_name_ceramic.length; i++){
                data.add(new ProductModel(
                        ProductItem.product_name_ceramic[i],
                        ProductItem.product_price_ceramic[i],
                        ProductItem.product_kondisi_ceramic[i],
                        ProductItem.product_weight_ceramic[i],
                        ProductItem.product_stock_ceramic[i],
                        ProductItem.product_desc_ceramic[i],
                        ProductItem.product_img_ceramic[i]
                ));
            }
        }

        adapterRecyclerView = new AdapterRecyclerView(data);
        recyclerView.setAdapter(adapterRecyclerView);

        adapterRecyclerView.setOnItemClickCallback(new AdapterRecyclerView.OnItemClickCallback() {
            @Override
            public void onItemClicked(ProductModel productModel) {
                String username = getIntent().getStringExtra("dataUsername");
                String email = getIntent().getStringExtra("dataEmail");
                String phone = getIntent().getStringExtra("dataPhone");
                String loc = getIntent().getStringExtra("dataLocation");
                String ig = getIntent().getStringExtra("dataInstagram");

                Intent intent = new Intent(Product.this, DetailProduk.class);
                intent.putExtra(DetailProduk.ITEM_EXTRA, productModel);
                intent.putExtra("dataUsername", username);
                intent.putExtra("dataEmail", email);
                intent.putExtra("dataPhone", phone);
                intent.putExtra("dataLocation", loc);
                intent.putExtra("dataInstagram", ig);
                startActivity(intent);
            }
        });

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