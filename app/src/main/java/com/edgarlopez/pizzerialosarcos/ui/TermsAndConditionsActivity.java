package com.edgarlopez.pizzerialosarcos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.edgarlopez.pizzerialosarcos.R;

public class TermsAndConditionsActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAcept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        getSupportActionBar().hide();

        findViews();
        events();
    }

    private void findViews() {
        btnAcept = findViewById(R.id.buttonAcept);
    }

    private void events() {
        btnAcept.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.buttonAcept:
                goToRegister();
                break;
        }
    }

    private void goToRegister() {
        Intent i = new Intent(TermsAndConditionsActivity.this, RegisterActivity.class);
        startActivity(i);
    }
}
