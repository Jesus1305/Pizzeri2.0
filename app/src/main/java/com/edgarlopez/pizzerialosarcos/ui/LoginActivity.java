package com.edgarlopez.pizzerialosarcos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.edgarlopez.pizzerialosarcos.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.kaopiz.kprogresshud.KProgressHUD;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;

    EditText etEmail, etPassword;
    TextView tvRegisterAccount, tvRestorePassword;
    Button btnContinue;

    String email, password;

    KProgressHUD hud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();

        findViews();
        events();
    }

    private void findViews() {
        etEmail = findViewById(R.id.editTextLoginEmail);
        etPassword = findViewById(R.id.editTextLoginPassword);
        tvRegisterAccount = findViewById(R.id.textViewRegisterAccount);
        tvRestorePassword = findViewById(R.id.textViewRestorePassword);
        btnContinue = findViewById(R.id.buttonContinue);

        hud = KProgressHUD.create(LoginActivity.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);
    }

    private void events() {
        tvRegisterAccount.setOnClickListener(this);
        tvRestorePassword.setOnClickListener(this);
        btnContinue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.textViewRegisterAccount:
                goToRegisterActivity();
                break;
            case R.id.textViewRestorePassword:
                goToVerificationCode();
                break;
            case R.id.buttonContinue:
                login();
                break;
        }
    }

    private void goToRegisterActivity() {
        Intent i = new Intent(LoginActivity.this, TermsAndConditionsActivity.class);
        startActivity(i);
    }

    private void goToVerificationCode() {
        
    }

    private void login() {
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();

        if (email.isEmpty()) {
            etEmail.setError("El e-mail es requerido");
        } else if (password.isEmpty()) {
            etPassword.setError("La contraseña es requerida");
        } else {
            hud.show();
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            hud.dismiss();
                            if (task.isSuccessful()) {
                                Intent i = new Intent(LoginActivity.this, MenuNavigationActivity.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}
