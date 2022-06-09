package com.darksoft.kaife_cataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.darksoft.kaife_cataapp.databinding.ActivityMainBinding;
import com.darksoft.kaife_cataapp.ui.answers.AnswersActivity;
import com.darksoft.kaife_cataapp.ui.graphics.GraphicsActivity;
import com.darksoft.kaife_cataapp.ui.quizz_global.QuizzGlobalActivity;
import com.darksoft.kaife_cataapp.ui.sign_in.SignInActivity;
import com.darksoft.kaife_cataapp.ui.statistics.StatisticsActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        buttons();
    }

    private void buttons() {
        binding.btnQuizz.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizzGlobalActivity.class);
            startActivity(intent);
        });

        binding.btnAnswers.setOnClickListener(v -> {
            Intent intent = new Intent(this, AnswersActivity.class);
            startActivity(intent);
        });

        binding.btnGraphics.setOnClickListener(v -> {
            Intent intent = new Intent(this, GraphicsActivity.class);
            startActivity(intent);
        });

        binding.btnStatistics.setOnClickListener(v -> {
            Intent intent = new Intent(this, StatisticsActivity.class);
            startActivity(intent);
        });

        binding.signOut.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}