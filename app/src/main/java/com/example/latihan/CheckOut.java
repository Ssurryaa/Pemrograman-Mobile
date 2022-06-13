package com.example.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CheckOut extends AppCompatActivity {

    TextView qty, name, price;
    TextView subTotal;
    Button btnCheckOut;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        TextView tvNama1 = (TextView) findViewById(R.id.tv_nama);
        tvNama1.setText(getIntent().getStringExtra("dataNama"));

        TextView tvHarga1 = (TextView) findViewById(R.id.tv_harga);
        tvHarga1.setText(getIntent().getStringExtra("dataHarga"));

        TextView tvHarga2 = (TextView) findViewById(R.id.subTotal);
        tvHarga2.setText(getIntent().getStringExtra("dataHarga"));

        TextView tvUsername5 = (TextView) findViewById(R.id.username);
        tvUsername5.setText(getIntent().getStringExtra("dataUsername"));

        TextView tvEmail5 = (TextView) findViewById(R.id.email);
        tvEmail5.setText(getIntent().getStringExtra("dataEmail"));

        TextView tvPhone5 = (TextView) findViewById(R.id.phone);
        tvPhone5.setText(getIntent().getStringExtra("dataPhone"));

        TextView tvLocation5 = (TextView) findViewById(R.id.address);
        tvLocation5.setText(getIntent().getStringExtra("dataLocation"));

        name = (TextView) findViewById(R.id.tv_nama);
        price = (TextView) findViewById(R.id.tv_harga);
        qty = (TextView) findViewById(R.id.qty);
        subTotal = (TextView) findViewById(R.id.subTotal);

        btnCheckOut= (Button) findViewById(R.id.btnCheckOut);
        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = name.getText().toString();
                String harga = subTotal.getText().toString();
                String pesanan = qty.getText().toString();
                String username = getIntent().getStringExtra("dataUsername");
                String email = getIntent().getStringExtra("dataEmail");
                String phone = getIntent().getStringExtra("dataPhone");
                String loc = getIntent().getStringExtra("dataLocation");
                String ig = getIntent().getStringExtra("dataInstagram");

                Toast.makeText(CheckOut.this, "Your order on process...",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(CheckOut.this, Transaksi.class);
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

    public void plus(View view) {
        count++;
        qty.setText(""+count);

        int qtyy=Integer.parseInt(qty.getText().toString());
        int pricee=Integer.parseInt(price.getText().toString());

        int price = qtyy * pricee;

        subTotal.setText(Integer.toString(price));
    }

    public void mines(View view) {
        if (count > 1) {
            count--;
            qty.setText(""+count);

            int qtyy=Integer.parseInt(qty.getText().toString());
            int pricee=Integer.parseInt(price.getText().toString());

            int price = qtyy * pricee;

            subTotal.setText(Integer.toString(price));
        }
    }
}