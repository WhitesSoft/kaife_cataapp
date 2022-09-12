package com.darksoft.kaife_cataapp.ui.sign_in_phone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.darksoft.kaife_cataapp.MainActivity;
import com.darksoft.kaife_cataapp.databinding.ActivitySignInPhoneBinding;
import com.darksoft.kaife_cataapp.ui.register_user_phone.RegisterUserPhoneActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class SignInPhoneActivity extends AppCompatActivity {

    private static ActivitySignInPhoneBinding binding;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    PhoneAuthCredential credential;
    private String mVerificationId;
    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        buttons();

    }

    private void buttons() {

        binding.back.setOnClickListener(v -> {
            finish();
        });

        binding.btnSendCode.setOnClickListener(v -> {

            number = binding.etPhone.getText().toString().trim();
            if (!number.isEmpty()){
                startPhoneNumberVerification("+57" + number);

                binding.btnSendCode.setVisibility(View.INVISIBLE);
                binding.loading.setVisibility(View.VISIBLE);

                new Handler().postDelayed(() -> {
                    binding.btnSendCode.setVisibility(View.VISIBLE);
                    binding.loading.setVisibility(View.INVISIBLE);
                },60000);

            }else {
                Toast.makeText(SignInPhoneActivity.this, "Debe ingresar un número de teléfono", Toast.LENGTH_SHORT).show();
            }

        });

        binding.btnVerify.setOnClickListener(v -> {

            String code = binding.etVerify.getText().toString().trim();

            if (code.isEmpty())
                Toast.makeText(this, "Ingrese el código enviado a su teléfono", Toast.LENGTH_SHORT).show();
            else{

                binding.loadingVerify.setVisibility(View.VISIBLE);
                binding.btnVerify.setVisibility(View.INVISIBLE);

                credential = PhoneAuthProvider.getCredential(mVerificationId, code);
                signInWithPhoneAuthCredential(credential);

                new Handler().postDelayed(() -> {
                    binding.loadingVerify.setVisibility(View.INVISIBLE);
                    binding.btnVerify.setVisibility(View.VISIBLE);
                },60000);

            }

        });
    }

    private void startPhoneNumberVerification(String phoneNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        mAuth.setLanguageCode(Locale.getDefault().getLanguage());
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {

                        Toast.makeText(SignInPhoneActivity.this, "Verificación completa", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignInPhoneActivity.this, RegisterUserPhoneActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(SignInPhoneActivity.this, "Verificación fallida, " +
                                "intente nuevamente", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private final PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {

        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {

            Toast.makeText(SignInPhoneActivity.this, "Ingrese un número correcto", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCodeSent(@NonNull String verificationId,
                @NonNull PhoneAuthProvider.ForceResendingToken token) {

            //Save to verificationID
            mVerificationId = verificationId;
        }

    };
}