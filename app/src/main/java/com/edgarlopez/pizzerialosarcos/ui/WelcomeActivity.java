package com.edgarlopez.pizzerialosarcos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.edgarlopez.pizzerialosarcos.R;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin, btnSignIn, btnGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().hide();

        findViews();
        events();
    }

    private void findViews() {
        btnGuest = findViewById(R.id.buttonGuest);
        btnLogin = findViewById(R.id.buttonLogin);
        btnSignIn = findViewById(R.id.buttonSignIn);
    }

    private void events() {
        btnGuest.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.buttonGuest:
                goToMenu();
                break;
            case R.id.buttonLogin:
                goToLogin();
                break;
            case R.id.buttonSignIn:
                goToSignIn();
                break;
        }
    }

    private void goToMenu() {
        Intent i = new Intent(WelcomeActivity.this, MenuNavigationActivity.class);
        startActivity(i);
    }

    private void goToLogin() {
        Intent i = new Intent(WelcomeActivity.this, LoginActivity.class);
        startActivity(i);
    }

    private void goToSignIn() {
        Intent i = new Intent(WelcomeActivity.this, TermsAndConditionsActivity.class);
        startActivity(i);
    }
}
