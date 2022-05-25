package com.example.latihan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    TextView log;
    boolean passwordVisible;
    private FirebaseAuth mAuth;
    private EditText inputUsername, inputEmail, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        log = (TextView) findViewById(R.id.haveAccount);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this,Login.class));
            }
        });

        inputUsername = findViewById(R.id.regisUsername);
        inputEmail = findViewById(R.id.regisEmail);
        inputPassword = findViewById(R.id.regisPassword);

        inputPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Right=2;
                if (event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=inputPassword.getRight()-inputPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=inputPassword.getSelectionEnd();
                        if(passwordVisible){
                            inputPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_visibility_off_24, 0);
                            inputPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;

                        }else{
                            inputPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24, 0);
                            inputPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        inputPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        Button btnDaftar = findViewById(R.id.buttondaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = inputUsername.getText().toString();
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                if (username.equals("")) {
                    Toast.makeText(Register.this, "Silahkan isi username Anda",
                            Toast.LENGTH_SHORT).show();

                } else if (!(Patterns.EMAIL_ADDRESS.matcher(email).matches())){
                    Toast.makeText(Register.this, "Alamat email tidak valid", Toast.LENGTH_SHORT).show();

                } else if (email.equals("")) {
                    Toast.makeText(Register.this, "Silahkan isi email Anda",
                            Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    Toast.makeText(Register.this, "Silahkan isi password minimal 6 karakter",
                            Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(Register.this, "Registrasi Berhasil. Silahkan Login",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, Login.class);
                    intent.putExtra("dataEmail", email);
                    intent.putExtra("dataPassword", password);
                    startActivity(intent);
                }

            }
        });
    }


}