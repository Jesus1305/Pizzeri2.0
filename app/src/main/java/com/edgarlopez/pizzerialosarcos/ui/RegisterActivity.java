package com.edgarlopez.pizzerialosarcos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.edgarlopez.pizzerialosarcos.R;
import com.edgarlopez.pizzerialosarcos.Constantes;
import com.edgarlopez.pizzerialosarcos.common.SharedPreferencesManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etLastName, etEmail;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        findViews();
        events();
    }

    private void findViews() {
        etName = findViewById(R.id.editTextName);
        etLastName = findViewById(R.id.editTextLastName);
        etEmail = findViewById(R.id.editTextEmail);
        btnNext = findViewById(R.id.buttonNext);
    }

    private void events() {
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.buttonNext:
                goToRegisterNumber();
                break;
        }
    }

    private void goToRegisterNumber() {
        String name = etName.getText().toString();
        String lastName = etLastName.getText().toString();
        String email = etEmail.getText().toString();

        if (name.isEmpty()) {
            etName.setError("El nombre es requerido");
        } else if (lastName.isEmpty()) {
            etLastName.setError("El apellido es requerido");
        } else if (isEmailValid(email) == false) {
            etEmail.setError("El formato del e-mail es incorrecto");
        } else {
            SharedPreferencesManager.setSomeStringValue(Constantes.PREF_NAME, name);
            SharedPreferencesManager.setSomeStringValue(Constantes.PREF_LASTNAME, lastName);
            SharedPreferencesManager.setSomeStringValue(Constantes.PREF_EMAIL, email);

            Intent i = new Intent(RegisterActivity.this, RegisterNumberActivity.class);
            startActivity(i);
        }
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
