package com.darksoft.kaife_cataapp.ui.register_user_phone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.darksoft.kaife_cataapp.MainActivity;
import com.darksoft.kaife_cataapp.databinding.ActivityRegisterUserPhoneBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;

public class RegisterUserPhoneActivity extends AppCompatActivity {

    private static ActivityRegisterUserPhoneBinding binding;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private int female = 0, male = 0;
    private final Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterUserPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


        buttons();
    }

    private void buttons() {

        binding.etDate.setOnClickListener(v -> {
            new DatePickerDialog(this, date, calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        binding.btnNext.setOnClickListener(v -> {
            registerUser();
        });

    }

    private void registerUser() {

        if (validar()) {

            checkGenero();

            binding.btnNext.setVisibility(View.INVISIBLE);
            binding.loading.setVisibility(View.VISIBLE);

            String uid = UUID.randomUUID().toString();
            String name = binding.etName.getText().toString().trim();
            String surname = binding.etSurname.getText().toString().trim();
            String date = binding.etDate.getText().toString().trim();

            HashMap<String, String> datos = new HashMap<>();
            datos.put("uid", uid);
            datos.put("name", name);
            datos.put("surname", surname);
            datos.put("date", date);
            datos.put("genero", genero());

            SharedPreferences preferences = getSharedPreferences("genero", MODE_PRIVATE);

            Toast.makeText(RegisterUserPhoneActivity.this, "Cuenta creada correctamente.", Toast.LENGTH_SHORT).show();
            db.collection("Usuarios").document(uid).set(datos).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {

                    //Guardamos el valor del genero
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("genero", genero());
                    editor.commit();

                    Intent intent = new Intent(RegisterUserPhoneActivity.this, MainActivity.class);
                    startActivity(intent);

                    finish();
                } else {
                    binding.btnNext.setVisibility(View.VISIBLE);
                    binding.loading.setVisibility(View.INVISIBLE);
                    Toast.makeText(RegisterUserPhoneActivity.this, "No se pudo crear la cuenta.", Toast.LENGTH_SHORT).show();
                }
            });

        }


    }

    private void checkGenero(){
        if (binding.btnMale.isChecked())
            male++;
        if (binding.btnFemale.isChecked())
            female++;
    }

    private String genero() {
        if (male != 0)
            return "masculino";
        if (female != 0)
            return "femenino";
        return "0";
    }

    private boolean validar() {
        boolean retorno = true;

        String name = binding.etName.getText().toString().trim();
        String surname = binding.etSurname.getText().toString().trim();
        String date = binding.etDate.getText().toString().trim();

        if (name.isEmpty()) {
            binding.etName.setError("Debe ingresar un nombre");
            retorno = false;
        }
        if (surname.isEmpty()) {
            binding.etSurname.setError("Debe ingresar un apellido");
            retorno = false;
        }
        if (date.isEmpty()) {
            binding.etDate.setError("Debe ingresar su fecha de nacimiento");
            retorno = false;
        }
        if (!binding.btnFemale.isChecked() && !binding.btnMale.isChecked()){
            binding.tGenero.setError("Debe seleccionar un género");
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

        private void updateCalendar() {
            String format = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.US);

            binding.etDate.setText(simpleDateFormat.format(calendar.getTime()));
        }
    };

}