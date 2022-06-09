package com.darksoft.kaife_cataapp.ui.answers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.darksoft.kaife_cataapp.databinding.ActivityAnswersBinding;

public class AnswersActivity extends AppCompatActivity {

    private static ActivityAnswersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnswersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.back.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}