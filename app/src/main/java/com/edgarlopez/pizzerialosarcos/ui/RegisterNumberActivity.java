package com.edgarlopez.pizzerialosarcos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.edgarlopez.pizzerialosarcos.R;
import com.edgarlopez.pizzerialosarcos.common.Constantes;
import com.edgarlopez.pizzerialosarcos.common.SharedPreferencesManager;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.concurrent.TimeUnit;

public class RegisterNumberActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private FirebaseAuth mAuth;

    Spinner spinner;
    EditText etphoneNumber;
    Button btnNext;
    String prefix = "+52";
    String phoneNumber;

    KProgressHUD hud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_number);

        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();

        findViews();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        events();
    }

    private void findViews() {
        spinner = findViewById(R.id.spinnerCountry);
        etphoneNumber = findViewById(R.id.editTextPhoneNumber);
        btnNext = findViewById(R.id.buttonNextA);

        hud = KProgressHUD.create(RegisterNumberActivity.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);
    }

    private void events() {
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0)
            prefix = "+52";
        else
            prefix = "+1";
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if (etphoneNumber.length() == 10) {
            phoneNumber = prefix + etphoneNumber.getText().toString();
            sendVerificationCode(phoneNumber);
        } else {
            etphoneNumber.setError("El número de teléfono introducido es incorrecto");
        }
    }

    private void sendVerificationCode(String mobile) {
        hud.show();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mobile,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallbacks);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            hud.dismiss();
            Toast.makeText(RegisterNumberActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

        }

        @Override
        public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(verificationId, forceResendingToken);
            hud.dismiss();

            SharedPreferencesManager.setSomeStringValue(Constantes.PREF_PHONENUMBER, phoneNumber);
            SharedPreferencesManager.setSomeStringValue(Constantes.PREF_VERIFICATIONID, verificationId);

            Intent i = new Intent(RegisterNumberActivity.this, VerificationCodeActivity.class);
            startActivity(i);
        }
    };
}
