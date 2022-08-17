package com.example.login_signup_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    private EditText inputUsername, inputPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView btn = findViewById(R.id.textViewSigUp);
        btn.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));

        inputUsername = findViewById(R.id.inputUsernameRegister);
        inputPassword = findViewById(R.id.inputLoginPassword);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(view -> checkCredentials());

        Button btnGoogle = findViewById(R.id.btnGoogle);
        Button btnFacebook = findViewById(R.id.btnFacebook);

        btnFacebook.setOnClickListener(view -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"))));
        btnGoogle.setOnClickListener(view -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))));

        TextView forgotPassword = findViewById(R.id.forgotPassword);

//        forgotPassword.setOnClickListener(view -> Toast.makeText(LoginActivity.this, "Relax & try to remember your password, please!!", Toast.LENGTH_SHORT).show());


    }

    private void checkCredentials() {
        String username = inputUsername.getText().toString();
        String password = inputPassword.getText().toString();

        if (username.isEmpty()) {
            showError(inputUsername, "Username is not empty");
        } else if (password.isEmpty()) {
            showError(inputPassword, "Password must be at least 6 characters");
        } else {
            if (username.equals("admin") && password.equals("admin")) {
                Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
            } else {
                Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}