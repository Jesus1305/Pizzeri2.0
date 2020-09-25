package com.edgarlopez.pizzerialosarcos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.edgarlopez.pizzerialosarcos.CarritoActivity;
import com.edgarlopez.pizzerialosarcos.ConexionSQLitehelper;
import com.edgarlopez.pizzerialosarcos.FindActivity;
import com.edgarlopez.pizzerialosarcos.ListItemActivity;
import com.edgarlopez.pizzerialosarcos.R;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin, btnSignIn, btnGuest,btnTest,btnFind,btnmostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().hide();

        findViews();
        events();
        ConexionSQLitehelper conn=new ConexionSQLitehelper(this,"db_items",null,1);
    }

    private void findViews() {
        btnGuest = findViewById(R.id.buttonGuest);
        btnLogin = findViewById(R.id.buttonLogin);
        btnSignIn = findViewById(R.id.buttonSignIn);
        btnTest=findViewById(R.id.test);
        btnFind=findViewById(R.id.btnfind);
        btnmostrar=findViewById(R.id.mostrarbtn);
    }

    private void events() {
        btnGuest.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
        btnTest.setOnClickListener(this);
        btnFind.setOnClickListener(this);
        btnmostrar.setOnClickListener(this);

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
            case R.id.test:
                goTest();
                break;
            case R.id.btnfind:
                goToFind();
                break;
            case R.id.mostrarbtn:
                goTomostrar();
                break;
        }
    }

    private void goTomostrar() {
        Intent i = new Intent(WelcomeActivity.this, ListItemActivity.class);
        startActivity(i);
    }

    private void goToMenu() {
        Intent i = new Intent(WelcomeActivity.this, MenuNavigationActivity.class);
        startActivity(i);
    }
    private void goTest() {
        Intent i = new Intent(WelcomeActivity.this, CarritoActivity.class);
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
    private void goToFind(){
        Intent i = new Intent(WelcomeActivity.this, FindActivity.class);
        startActivity(i);
    }
}
