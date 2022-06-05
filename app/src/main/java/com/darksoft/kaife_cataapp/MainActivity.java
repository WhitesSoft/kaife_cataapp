package com.darksoft.kaife_cataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.darksoft.kaife_cataapp.databinding.ActivityMainBinding;
import com.darksoft.kaife_cataapp.ui.quizz.QuizzActivity;
import com.darksoft.kaife_cataapp.ui.sign_in.SignInActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

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

       // db.collection("User").document()

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        binding.id.setText(user.getUid());


    }

    private void buttons() {
        binding.btnQuizz.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizzActivity.class);
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