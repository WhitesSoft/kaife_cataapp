package com.darksoft.kaife_cataapp.ui.quizz_global;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.darksoft.kaife_cataapp.databinding.ActivityQuizzGlobalBinding;
import com.darksoft.kaife_cataapp.ui.quizz.QuizzActivity;

public class QuizzGlobalActivity extends AppCompatActivity {

    private static ActivityQuizzGlobalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizzGlobalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        buttons();
    }

    private void buttons() {
        binding.image1.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizzActivity.class);
            startActivity(intent);
        });
        binding.image2.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizzActivity.class);
            startActivity(intent);
        });
        binding.back.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}