package com.example.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    TextView tv_username;
    TextView tv_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView tvData1 = (TextView) findViewById(R.id.tv_name);
        tvData1.setText(getIntent().getStringExtra("dataUsername"));

        TextView tvData2 = (TextView) findViewById(R.id.username);
        tvData2.setText(getIntent().getStringExtra("dataUsername"));

        TextView tvData3 = (TextView) findViewById(R.id.email);
        tvData3.setText(getIntent().getStringExtra("dataEmail"));

        TextView tvData4 = (TextView) findViewById(R.id.phone);
        tvData4.setText(getIntent().getStringExtra("dataPhone"));

        TextView tvData5 = (TextView) findViewById(R.id.address);
        tvData5.setText(getIntent().getStringExtra("dataLocation"));

        TextView tvData6 = (TextView) findViewById(R.id.instagram);
        tvData6.setText(getIntent().getStringExtra("dataInstagram"));

        tv_username = findViewById(R.id.username);
        tv_email = findViewById(R.id.email);

        Button btnLogin = findViewById(R.id.btnedit);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = tv_username.getText().toString();
                String email = tv_email.getText().toString();

                Intent intent = new Intent(Profile.this, EditProfile.class);
                intent.putExtra("dataUsername", username);
                intent.putExtra("dataEmail", email);
                startActivity(intent);
            }
        });
    }
}