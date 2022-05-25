package com.example.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Product extends AppCompatActivity {

    ImageView notif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        TextView tvData1 = (TextView) findViewById(R.id.toolbar_title);
        tvData1.setText(getIntent().getStringExtra("dataKategori"));

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