package com.example.login_signup_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextView btn;

    private EditText inputUsername, inputPassword, inputConfirmPassword, inputEmail;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn = findViewById(R.id.textViewSigIn);
        btn.setOnClickListener(view -> startActivity(new Intent(RegisterActivity.this, LoginActivity.class)));

        inputUsername = findViewById(R.id.inputUsernameRegister);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPasswordRegister);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(view -> checkCredentials());
    }

    private void checkCredentials() {
        String username = inputUsername.getText().toString();
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        String confirmPassword = inputConfirmPassword.getText().toString();

        if (username.isEmpty() || username.length() < 7) {
            showError(inputUsername, "Username is not valid");
        } else if (!email.contains("@")) {
            showError(inputEmail, "Email is not valid");
        } else if (password.isEmpty() || password.length() < 6) {
            showError(inputPassword, "Password must be at least 6 characters");
        } else if (confirmPassword.isEmpty() || !confirmPassword.equals(password)) {
            showError(inputConfirmPassword, "Password and confirm password do not match");
        } else {
            Toast.makeText(RegisterActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}