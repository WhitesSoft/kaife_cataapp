package com.darksoft.kaife_cataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.darksoft.kaife_cataapp.databinding.ActivityMainBinding;
import com.darksoft.kaife_cataapp.model.AnswerModel;
import com.darksoft.kaife_cataapp.ui.graphics.GraphicsActivity;
import com.darksoft.kaife_cataapp.ui.quizz.QuizzActivity;
import com.darksoft.kaife_cataapp.ui.sign_in.SignInActivity;
import com.darksoft.kaife_cataapp.ui.statistics.StatisticsActivity;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadUser();
        buttons();
    }

    private void loadUser() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        binding.id.setText(user.getUid());
    }

    private void buttons() {
        binding.btnQuizz.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizzActivity.class);
            startActivity(intent);
        });

        binding.btnAnswers.setOnClickListener(v -> {
            Toast.makeText(this, "respuestas(falta)", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(this, QuizzActivity.class);
//            startActivity(intent);
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