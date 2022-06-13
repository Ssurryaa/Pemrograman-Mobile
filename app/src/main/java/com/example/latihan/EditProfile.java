package com.example.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditProfile extends AppCompatActivity {

    EditText tv_username;
    EditText tv_email;
    EditText tv_phone;
    EditText tv_location;
    EditText tv_instagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        TextView tvData1 = (TextView) findViewById(R.id.tv_name);
        tvData1.setText(getIntent().getStringExtra("dataUsername"));

        TextView tvData2 = (TextView) findViewById(R.id.username);
        tvData2.setText(getIntent().getStringExtra("dataUsername"));

        TextView tvData3 = (TextView) findViewById(R.id.email);
        tvData3.setText(getIntent().getStringExtra("dataEmail"));

        tv_username = findViewById(R.id.username);
        tv_email = findViewById(R.id.email);
        tv_phone = findViewById(R.id.phone);
        tv_location = findViewById(R.id.address);
        tv_instagram = findViewById(R.id.instagram);

        Button btnLogin = findViewById(R.id.btnsave);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = tv_username.getText().toString();
                String email = tv_email.getText().toString();
                String location = tv_phone.getText().toString();
                String phone = tv_location.getText().toString();
                String instagram = tv_instagram.getText().toString();

                Intent intent = new Intent(EditProfile.this, MainActivity.class);
                intent.putExtra("dataUsername", username);
                intent.putExtra("dataEmail", email);
                intent.putExtra("dataPhone", location);
                intent.putExtra("dataLocation", phone);
                intent.putExtra("dataInstagram", instagram);
                startActivity(intent);
            }
        });
    }
}