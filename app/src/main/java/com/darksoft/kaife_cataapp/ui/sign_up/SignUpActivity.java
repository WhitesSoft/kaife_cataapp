package com.darksoft.kaife_cataapp.ui.sign_up;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import com.darksoft.kaife_cataapp.databinding.ActivitySignUpBinding;
import com.darksoft.kaife_cataapp.ui.sign_in.SignInActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;

public class SignUpActivity extends AppCompatActivity {

    private static ActivitySignUpBinding binding;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    private final Calendar calendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


        buttons();
    }

    private void buttons(){

        binding.back.setOnClickListener(v -> {
            finish();
        });

        binding.etDate.setOnClickListener(v -> {
            new DatePickerDialog(this, date, calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        binding.btnRegister.setOnClickListener(v -> {
            registerUser();
        });

        binding.textSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        });
    }

    private void registerUser(){

        if (validar()){

            String uid = UUID.randomUUID().toString();
            String name = binding.etName.getText().toString().trim();
            String surname = binding.etSurname.getText().toString().trim();
            String email = binding.etEmail.getText().toString().trim();
            String password = binding.etPassword.getText().toString().trim();
            String date = binding.etDate.getText().toString().trim();

            boolean isNumeric =  email.matches("[+-]?\\d*(\\.\\d+)?");
            if (isNumeric)
                email = email + "@gmail.com";

            HashMap<String, String> datos = new HashMap<>();
            datos.put("uid", uid);
            datos.put("name", name);
            datos.put("surname", surname);
            datos.put("email", email);
            datos.put("password", password);
            datos.put("date", date);

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(SignUpActivity.this, "Cuenta creada correctamente.", Toast.LENGTH_SHORT).show();
                                db.collection("Users").document(uid).set(datos);

                                finish();
                            } else {
                                Toast.makeText(SignUpActivity.this, "No se pudo crear la cuenta.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }



    }

    private boolean validar() {
        boolean retorno = true;

        String name = binding.etName.getText().toString().trim();
        String surname = binding.etSurname.getText().toString().trim();
        String email = binding.etEmail.getText().toString().trim();
        String password = binding.etPassword.getText().toString().trim();
        String date = binding.etDate.getText().toString().trim();

        if (name.isEmpty()) {
            binding.etName.setError("Debe ingresar un nombre");
            retorno = false;
        }
        if (surname.isEmpty()) {
            binding.etSurname.setError("Debe ingresar un apellido");
            retorno = false;
        }
        if (email.isEmpty()) {
            binding.etEmail.setError("Debe ingresar correo electronico o un teléfono");
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
        if (date.isEmpty()) {
            binding.etDate.setError("Debe ingresar su fecha de nacimiento");
            retorno = false;
        }

        return retorno;
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            updateCalendar();

        }

        private void updateCalendar(){
            String format = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.US);

            binding.etDate.setText(simpleDateFormat.format(calendar.getTime()));
        }
    };

}