package com.example.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Transaksi extends AppCompatActivity {

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        TextView tvNama1 = (TextView) findViewById(R.id.tv_nama);
        tvNama1.setText(getIntent().getStringExtra("dataNama"));

        TextView tvHarga1 = (TextView) findViewById(R.id.tv_harga);
        tvHarga1.setText(getIntent().getStringExtra("dataHarga"));

        TextView tvPesanan1 = (TextView) findViewById(R.id.tv_qty);
        tvPesanan1.setText(getIntent().getStringExtra("dataPesanan"));

        btnBack= (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = getIntent().getStringExtra("dataNama");
                String harga = getIntent().getStringExtra("dataHarga");
                String pesanan = getIntent().getStringExtra("dataPesanan");
                String username = getIntent().getStringExtra("dataUsername");
                String email = getIntent().getStringExtra("dataEmail");
                String phone = getIntent().getStringExtra("dataPhone");
                String loc = getIntent().getStringExtra("dataLocation");
                String ig = getIntent().getStringExtra("dataInstagram");

                Intent intent = new Intent(Transaksi.this, MainActivity.class);
                intent.putExtra("dataNama", nama);
                intent.putExtra("dataHarga", harga);
                intent.putExtra("dataPesanan", pesanan);
                intent.putExtra("dataUsername", username);
                intent.putExtra("dataEmail", email);
                intent.putExtra("dataPhone", phone);
                intent.putExtra("dataLocation", loc);
                intent.putExtra("dataInstagram", ig);
                startActivity(intent);
            }
        });

    }

}