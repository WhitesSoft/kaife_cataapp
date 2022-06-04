package com.darksoft.kaife_cataapp.ui.sign_in;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.darksoft.kaife_cataapp.MainActivity;
import com.darksoft.kaife_cataapp.databinding.ActivitySignInBinding;
import com.darksoft.kaife_cataapp.ui.sign_in_phone.SignInPhoneActivity;
import com.darksoft.kaife_cataapp.ui.sign_up.SignUpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        buttons();

    }

    private void buttons() {

        binding.btnSignIn.setOnClickListener(v -> {
            signIn();
        });

        binding.btnPhone.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignInPhoneActivity.class);
            startActivity(intent);
        });

        binding.textSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        });
    }

    private void signIn() {

        if (validar()){
            String email = binding.etEmailPhone.getText().toString().trim();
            String password = binding.etPassword.getText().toString().trim();

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(SignInActivity.this, "Verifique sus datos.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

    }

    private boolean validar() {
        boolean retorno = true;

        String email = binding.etEmailPhone.getText().toString().trim();
        String password = binding.etPassword.getText().toString().trim();

        if (email.isEmpty()) {
            binding.etEmailPhone.setError("Debe ingresar correo electronico o un teléfono");
            retorno = false;
        }
        if (password.isEmpty()) {
            binding.etPassword.setError("Debe ingresar una contraseña");
            retorno = false;
        }
        if (password.length() < 6) {
            binding.etPassword.setError("Debe ingresar una contraseña mayor a 6 caracteres");
            retorno = false;
        }


        return retorno;
    }
}