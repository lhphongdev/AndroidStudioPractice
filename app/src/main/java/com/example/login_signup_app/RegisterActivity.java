package com.example.login_signup_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView btn = findViewById(R.id.textViewSigIn);
        btn.setOnClickListener(view -> startActivity(new Intent(RegisterActivity.this, LoginActivity.class)));

        TextView username = findViewById(R.id.inputUsernameRegister);
        TextView email = findViewById(R.id.inputEmail);
        TextView password = findViewById(R.id.inputPasswordRegister);
        TextView confirmPassword = findViewById(R.id.inputConfirmPassword);

        Button btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!username.getText().toString().equals("") && !email.getText().toString().equals("") && !password.getText().toString().equals("") && !confirmPassword.getText().toString().equals("")) {
                    if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
                        Toast.makeText(RegisterActivity.this, "Password and confirm password do not match!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }

                } else {
                    Toast.makeText(RegisterActivity.this, "Enter all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}