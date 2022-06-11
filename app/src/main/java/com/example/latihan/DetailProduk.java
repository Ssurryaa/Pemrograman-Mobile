package com.example.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomsheet.BottomSheetDialog;


public class DetailProduk extends AppCompatActivity {

    Toolbar toolbar;
    ImageView sharebutton;
    Button buybutton;
    ImageView chatbutton;
    TextView tv_nama1, tv_harga1;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produk);

        imageView = findViewById(R.id.image);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int resId = bundle.getInt("dataImage");
            imageView.setImageResource(resId);
        }

        TextView tvNama1 = (TextView) findViewById(R.id.tv_nama);
        tvNama1.setText(getIntent().getStringExtra("dataNama"));

        TextView tvHarga1 = (TextView) findViewById(R.id.tv_harga);
        tvHarga1.setText(getIntent().getStringExtra("dataHarga"));

        TextView tvSku1 = (TextView) findViewById(R.id.tv_sku);
        tvSku1.setText(getIntent().getStringExtra("dataSku"));

        TextView tvBerat1 = (TextView) findViewById(R.id.tv_berat);
        tvBerat1.setText(getIntent().getStringExtra("dataBerat"));

        TextView tvStok1 = (TextView) findViewById(R.id.tv_stok);
        tvStok1.setText(getIntent().getStringExtra("dataStok"));

        TextView tvDeskripsi1 = (TextView) findViewById(R.id.tv_deskripsi);
        tvDeskripsi1.setText(getIntent().getStringExtra("dataDeskripsi"));

        tv_nama1 = findViewById(R.id.tv_nama);
        tv_harga1 = findViewById(R.id.tv_harga);

        sharebutton= (ImageView) findViewById(R.id.btn_share);
        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        DetailProduk.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.layout_share,
                                (LinearLayout)findViewById(R.id.layout_share)
                        );

                bottomSheetView.findViewById(R.id.btnshare).setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent shareIntent=new Intent(android.content.Intent. ACTION_SEND);
                        shareIntent.setType ("text/plain");
                        shareIntent.putExtra(Intent. EXTRA_SUBJECT, "Insert Subject here");
                        String app_url="Temukan produk menarik di StarCraft. Dapatkan sekarang juga di StarCraft! https://pqrs.my.id";
                        shareIntent.putExtra(android.content.Intent. EXTRA_TEXT, app_url);
                        startActivity(Intent.createChooser (shareIntent, "Share via"));
                        Toast.makeText(DetailProduk.this, "Share...", Toast.LENGTH_SHORT).show();
                    }
                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });

        chatbutton= (ImageView) findViewById(R.id.chat);
        chatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProduk.this, Chat.class);
                startActivity(intent);
            }
        });

        buybutton= (Button) findViewById(R.id.btnBuy);
        buybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = tv_nama1.getText().toString();
                String harga = tv_harga1.getText().toString();
                Intent intent = new Intent(DetailProduk.this, Transaksi.class);
                intent.putExtra("dataNama", nama);
                intent.putExtra("dataHarga", harga);
                startActivity(intent);
            }
        });

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void showOrder(View view) {
        displayToast(getString(R.string.order));
    }
}