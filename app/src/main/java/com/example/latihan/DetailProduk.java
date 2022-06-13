package com.example.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialog;


public class DetailProduk extends AppCompatActivity {

    Toolbar toolbar;
    ImageView sharebutton;
    Button buybutton;
    ImageView chatbutton;
    TextView tv_nama1, tv_harga1;
    ImageView imageView;

    public static final String ITEM_EXTRA = "item_extra";

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

        ImageView img_produk = findViewById(R.id.image);
        TextView product_name = findViewById(R.id.tv_nama);
        TextView product_price = findViewById(R.id.tv_harga);
        TextView product_kondisi = findViewById(R.id.tv_sku);
        TextView product_weight = findViewById(R.id.tv_berat);
        TextView product_stock = findViewById(R.id.tv_stok);
        TextView product_desc = findViewById(R.id.tv_deskripsi);

        ProductModel productModel = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (productModel != null){
            Glide.with(this)
                    .load(productModel.getImg())
                    .into(img_produk);
            product_name.setText(productModel.getName());
            product_price.setText(productModel.getPrice());
            product_kondisi.setText(productModel.getKondisi());
            product_weight.setText(productModel.getWeight());
            product_stock.setText(productModel.getStock());
            product_desc.setText(productModel.getDesc());
        }

        sharebutton= (ImageView) findViewById(R.id.btn_share);
        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent=new Intent(android.content.Intent. ACTION_SEND);
                shareIntent.setType ("text/plain");
                shareIntent.putExtra(Intent. EXTRA_SUBJECT, "Insert Subject here");
                String app_url="Temukan produk menarik di StarCraft. Dapatkan sekarang juga di StarCraft! https://pqrs.my.id";
                shareIntent.putExtra(android.content.Intent. EXTRA_TEXT, app_url);
                startActivity(Intent.createChooser (shareIntent, "Share via"));
                Toast.makeText(DetailProduk.this, "Share...", Toast.LENGTH_SHORT).show();
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
                String username = getIntent().getStringExtra("dataUsername");
                String email = getIntent().getStringExtra("dataEmail");
                String phone = getIntent().getStringExtra("dataPhone");
                String loc = getIntent().getStringExtra("dataLocation");
                String ig = getIntent().getStringExtra("dataInstagram");

                Intent intent = new Intent(DetailProduk.this, CheckOut.class);
                intent.putExtra("dataNama", nama);
                intent.putExtra("dataHarga", harga);
                intent.putExtra("dataUsername", username);
                intent.putExtra("dataEmail", email);
                intent.putExtra("dataPhone", phone);
                intent.putExtra("dataLocation", loc);
                intent.putExtra("dataInstagram", ig);
                startActivity(intent);
            }
        });

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

}