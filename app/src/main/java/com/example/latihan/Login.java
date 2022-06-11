package com.example.latihan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    TextView reg;
    boolean passwordVisible;
    private EditText inputUsername, inputPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tvData1 = (TextView) findViewById(R.id.username);
        tvData1.setText(getIntent().getStringExtra("dataUsername"));
        TextView tvData2 = (TextView) findViewById(R.id.password);
        tvData2.setText(getIntent().getStringExtra("dataPassword"));

        mAuth = FirebaseAuth.getInstance();

        inputUsername = findViewById(R.id.username);
        inputPassword = findViewById(R.id.password);

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

        Button btnLogin = findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = getIntent().getStringExtra("dataEmail");
                String username = inputUsername.getText().toString();
                String password = inputPassword.getText().toString();

                if (username.equals("")){
                    Toast.makeText(Login.this, "Silahkan input username", Toast.LENGTH_SHORT).show();

                } else if (password.length() < 6){
                    Toast.makeText(Login.this, "Silahkan input password minimal 6 karakter", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(Login.this, "Login Berhasil.",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    intent.putExtra("dataUsername", username);
                    intent.putExtra("dataEmail", email);
                    startActivity(intent);

                }
            }
        });

        reg = (TextView) findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });

    }


}