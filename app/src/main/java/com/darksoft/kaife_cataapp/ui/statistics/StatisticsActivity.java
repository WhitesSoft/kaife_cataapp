package com.darksoft.kaife_cataapp.ui.statistics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.darksoft.kaife_cataapp.databinding.ActivityStatisticsBinding;

public class StatisticsActivity extends AppCompatActivity {

    private static ActivityStatisticsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStatisticsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}