package com.example.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        Intent intent = new Intent(Login.this,MainActivity.class);
        startActivity(intent);
    }

    public void register(View view) {
        Intent intent = new Intent(Login.this,Register.class);
        startActivity(intent);
    }
}