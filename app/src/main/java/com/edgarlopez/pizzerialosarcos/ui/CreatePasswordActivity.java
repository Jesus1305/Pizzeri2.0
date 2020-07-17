package com.edgarlopez.pizzerialosarcos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edgarlopez.pizzerialosarcos.R;
import com.edgarlopez.pizzerialosarcos.common.Constantes;
import com.edgarlopez.pizzerialosarcos.common.SharedPreferencesManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.HashMap;
import java.util.Map;

public class CreatePasswordActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    FirebaseUser currentUser;

    EditText etPassword, etVerifyPassword;
    Button btnRegister;
    
    String password, verifyPassword, email, name, lastName;

    KProgressHUD hud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        findViews();
        events();
    }

    private void findViews() {
        currentUser = mAuth.getCurrentUser();

        etPassword = findViewById(R.id.editTextPassword);
        etVerifyPassword = findViewById(R.id.editTextVerifyPassword);
        btnRegister = findViewById(R.id.buttonRegister);

        hud = KProgressHUD.create(CreatePasswordActivity.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);

        email = SharedPreferencesManager.getSomeStringValue(Constantes.PREF_EMAIL);
        name = SharedPreferencesManager.getSomeStringValue(Constantes.PREF_NAME);
        lastName = SharedPreferencesManager.getSomeStringValue(Constantes.PREF_LASTNAME);
    }

    private void events() {
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        password = etPassword.getText().toString();
        verifyPassword = etVerifyPassword.getText().toString();

        if (password.isEmpty()) {
            etPassword.setError("La contraseña no puede estar vacía");
        } else if (!password.equals(verifyPassword)) {
            etVerifyPassword.setError("Las contraseñas no coinciden, vuelvelo a intentar");
        } else {
            hud.show();
            currentUser.updatePassword(password).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    hud.dismiss();
                    if (task.isSuccessful()) {
                        currentUser.updateEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(name + " " + lastName)
                                            .build();

                                    currentUser.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                String clientName = currentUser.getDisplayName();
                                                String clientID = currentUser.getPhoneNumber();

                                                Map<String, Object> docData = new HashMap<>();
                                                docData.put("clientName", clientName);
                                                docData.put("streaks", 0);
                                                docData.put("baned", false);

                                                db.collection("users").document(clientID)
                                                        .set(docData)
                                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                            @Override
                                                            public void onSuccess(Void aVoid) {
                                                                Intent i = new Intent(CreatePasswordActivity.this, MenuNavigationActivity.class);
                                                                startActivity(i);
                                                                finish();
                                                            }
                                                        })
                                                        .addOnFailureListener(new OnFailureListener() {
                                                            @Override
                                                            public void onFailure(@NonNull Exception e) {
                                                                Toast.makeText(CreatePasswordActivity.this, e.getLocalizedMessage() , Toast.LENGTH_SHORT).show();
                                                            }
                                                        });
                                            } else {
                                                Toast.makeText(CreatePasswordActivity.this, task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                } else {
                                    Toast.makeText(CreatePasswordActivity.this, task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        Toast.makeText(CreatePasswordActivity.this, task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
