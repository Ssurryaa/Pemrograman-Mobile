package com.example.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Transaksi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        TextView tvNama1 = (TextView) findViewById(R.id.tv_nama);
        tvNama1.setText(getIntent().getStringExtra("dataNama"));

        TextView tvHarga1 = (TextView) findViewById(R.id.tv_harga);
        tvHarga1.setText(getIntent().getStringExtra("dataHarga"));

    }
}