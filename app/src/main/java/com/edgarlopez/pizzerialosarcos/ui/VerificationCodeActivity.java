package com.edgarlopez.pizzerialosarcos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.edgarlopez.pizzerialosarcos.R;
import com.edgarlopez.pizzerialosarcos.Constantes;
import com.edgarlopez.pizzerialosarcos.common.SharedPreferencesManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.kaopiz.kprogresshud.KProgressHUD;

public class VerificationCodeActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;

    String phoneNumber, verificationCode, verificationId;

    TextView tvPhoneNumber;
    EditText etVerificationCode;
    Button btnNext;

    KProgressHUD hud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);

        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();

        findViews();
        events();
    }

    private void findViews() {
        tvPhoneNumber = findViewById(R.id.textViewPhoneNumber);
        etVerificationCode = findViewById(R.id.editTextVerificationCode);
        btnNext = findViewById(R.id.buttonNextB);

        hud = KProgressHUD.create(VerificationCodeActivity.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);

        verificationId = SharedPreferencesManager.getSomeStringValue(Constantes.PREF_VERIFICATIONID);
        phoneNumber = SharedPreferencesManager.getSomeStringValue(Constantes.PREF_PHONENUMBER);
        tvPhoneNumber.setText("Enviado a " + phoneNumber);

        mostrarDialogo();
    }

    private void events() {
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        verificationCode = etVerificationCode.getText().toString();

        if (verificationCode.isEmpty()) {
            etVerificationCode.setError("El código de verificación es obligatorio");
        } else {
            hud.show();
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, verificationCode);
            mAuth.signInWithCredential(credential)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                hud.dismiss();
                                Intent i = new Intent(VerificationCodeActivity.this, CreatePasswordActivity.class);
                                startActivity(i);
                            } else {
                                hud.dismiss();
                                // Sign in failed, display a message and update the UI
                                Log.w("TAG", "signInWithCredential:failure", task.getException());
                                if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                    // The verification code entered was invalid
                                    Toast.makeText(VerificationCodeActivity.this, "El código de verificación introducido no es valido", Toast.LENGTH_LONG).show();
                                }
                            }

                        }
                    });
        }
    }

    private void mostrarDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(VerificationCodeActivity.this);

        builder.setMessage("En breve recibiras un código de seguridad para verificar tu número")
                .setTitle("Código de verificación enviado");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();

        dialog.show();
    }
}
