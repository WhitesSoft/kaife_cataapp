package com.darksoft.kaife_cataapp.ui.answers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.darksoft.kaife_cataapp.databinding.ActivityAnswersBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class AnswersActivity extends AppCompatActivity {

    private ActivityAnswersBinding binding;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnswersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.back.setOnClickListener(v -> {
            finish();
        });

        loadDataQuestion1();
        loadDataQuestion2();
        loadDataQuestion3();
        loadDataQuestion4();
        loadDataQuestion5();
        loadDataQuestion6();
        loadDataQuestion7();

    }

    private void loadDataQuestion1() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Respuestas").document(user.getUid()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();

                String pregunta1 = document.getString("pregunta1");

                binding.res1.setText(pregunta1);

                //respuesta 1
                if (pregunta1.equals("1") || pregunta1.equals("2") || pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res11.setVisibility(View.VISIBLE);

                //respuesta 2
                if (pregunta1.equals("3") || pregunta1.equals("4") || pregunta1.equals("6"))
                    binding.res12.setVisibility(View.VISIBLE);

                //respuesta 3
                if (pregunta1.equals("1") || pregunta1.equals("2") || pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res13.setVisibility(View.VISIBLE);

                //respuesta 4
                if (pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res14.setVisibility(View.VISIBLE);

                //respuesta 5
                if (pregunta1.equals("4") || pregunta1.equals("6"))
                    binding.res15.setVisibility(View.VISIBLE);


            }
        });


    }

    private void loadDataQuestion2() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Respuestas").document(user.getUid()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();

                String pregunta1 = document.getString("pregunta1");

                binding.res1.setText(pregunta1);

                //respuesta 1
                if (pregunta1.equals("1") || pregunta1.equals("2") || pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res11.setVisibility(View.VISIBLE);

                //respuesta 2
                if (pregunta1.equals("3") || pregunta1.equals("4") || pregunta1.equals("6"))
                    binding.res12.setVisibility(View.VISIBLE);

                //respuesta 3
                if (pregunta1.equals("1") || pregunta1.equals("2") || pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res13.setVisibility(View.VISIBLE);

                //respuesta 4
                if (pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res14.setVisibility(View.VISIBLE);

                //respuesta 5
                if (pregunta1.equals("4") || pregunta1.equals("6"))
                    binding.res15.setVisibility(View.VISIBLE);


            }
        });


    }

    private void loadDataQuestion3() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Respuestas").document(user.getUid()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();

                String pregunta1 = document.getString("pregunta1");

                binding.res1.setText(pregunta1);

                //respuesta 1
                if (pregunta1.equals("1") || pregunta1.equals("2") || pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res11.setVisibility(View.VISIBLE);

                //respuesta 2
                if (pregunta1.equals("3") || pregunta1.equals("4") || pregunta1.equals("6"))
                    binding.res12.setVisibility(View.VISIBLE);

                //respuesta 3
                if (pregunta1.equals("1") || pregunta1.equals("2") || pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res13.setVisibility(View.VISIBLE);

                //respuesta 4
                if (pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res14.setVisibility(View.VISIBLE);

                //respuesta 5
                if (pregunta1.equals("4") || pregunta1.equals("6"))
                    binding.res15.setVisibility(View.VISIBLE);


            }
        });


    }

    private void loadDataQuestion4() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Respuestas").document(user.getUid()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();

                String pregunta1 = document.getString("pregunta1");

                binding.res1.setText(pregunta1);

                //respuesta 1
                if (pregunta1.equals("1") || pregunta1.equals("2") || pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res11.setVisibility(View.VISIBLE);

                //respuesta 2
                if (pregunta1.equals("3") || pregunta1.equals("4") || pregunta1.equals("6"))
                    binding.res12.setVisibility(View.VISIBLE);

                //respuesta 3
                if (pregunta1.equals("1") || pregunta1.equals("2") || pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res13.setVisibility(View.VISIBLE);

                //respuesta 4
                if (pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res14.setVisibility(View.VISIBLE);

                //respuesta 5
                if (pregunta1.equals("4") || pregunta1.equals("6"))
                    binding.res15.setVisibility(View.VISIBLE);


            }
        });


    }

    private void loadDataQuestion5() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Respuestas").document(user.getUid()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();

                String pregunta1 = document.getString("pregunta1");

                binding.res1.setText(pregunta1);

                //respuesta 1
                if (pregunta1.equals("1") || pregunta1.equals("2") || pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res11.setVisibility(View.VISIBLE);

                //respuesta 2
                if (pregunta1.equals("3") || pregunta1.equals("4") || pregunta1.equals("6"))
                    binding.res12.setVisibility(View.VISIBLE);

                //respuesta 3
                if (pregunta1.equals("1") || pregunta1.equals("2") || pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res13.setVisibility(View.VISIBLE);

                //respuesta 4
                if (pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res14.setVisibility(View.VISIBLE);

                //respuesta 5
                if (pregunta1.equals("4") || pregunta1.equals("6"))
                    binding.res15.setVisibility(View.VISIBLE);


            }
        });


    }

    private void loadDataQuestion6() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Respuestas").document(user.getUid()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();

                String pregunta1 = document.getString("pregunta1");

                binding.res1.setText(pregunta1);

                //respuesta 1
                if (pregunta1.equals("1") || pregunta1.equals("2") || pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res11.setVisibility(View.VISIBLE);

                //respuesta 2
                if (pregunta1.equals("3") || pregunta1.equals("4") || pregunta1.equals("6"))
                    binding.res12.setVisibility(View.VISIBLE);

                //respuesta 3
                if (pregunta1.equals("1") || pregunta1.equals("2") || pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res13.setVisibility(View.VISIBLE);

                //respuesta 4
                if (pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res14.setVisibility(View.VISIBLE);

                //respuesta 5
                if (pregunta1.equals("4") || pregunta1.equals("6"))
                    binding.res15.setVisibility(View.VISIBLE);


            }
        });


    }

    private void loadDataQuestion7() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Respuestas").document(user.getUid()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();

                String pregunta1 = document.getString("pregunta1");

                binding.res1.setText(pregunta1);

                //respuesta 1
                if (pregunta1.equals("1") || pregunta1.equals("2") || pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res11.setVisibility(View.VISIBLE);

                //respuesta 2
                if (pregunta1.equals("3") || pregunta1.equals("4") || pregunta1.equals("6"))
                    binding.res12.setVisibility(View.VISIBLE);

                //respuesta 3
                if (pregunta1.equals("1") || pregunta1.equals("2") || pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res13.setVisibility(View.VISIBLE);

                //respuesta 4
                if (pregunta1.equals("3") || pregunta1.equals("5"))
                    binding.res14.setVisibility(View.VISIBLE);

                //respuesta 5
                if (pregunta1.equals("4") || pregunta1.equals("6"))
                    binding.res15.setVisibility(View.VISIBLE);


            }
        });


    }

    @Override
    public void onBackPressed() {
        finish();
    }
}