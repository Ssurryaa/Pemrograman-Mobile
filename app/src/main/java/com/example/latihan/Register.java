package com.example.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void login(View view) {
        Intent intent = new Intent(Register.this,Login.class);
        startActivity(intent);
    }
    public void register(View view) {
        Intent intent = new Intent(Register.this,Login.class);
        startActivity(intent);
    }
}