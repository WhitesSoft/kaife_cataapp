package com.darksoft.kaife_cataapp.ui.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.darksoft.kaife_cataapp.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    private static ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}