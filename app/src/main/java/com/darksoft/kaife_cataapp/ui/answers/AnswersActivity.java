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

                String pregunta2 = document.getString("pregunta2");

                binding.res2.setText(pregunta2);

                //respuesta 1
                if (pregunta2.equals("2") || pregunta2.equals("3"))
                    binding.res21.setVisibility(View.VISIBLE);

                //respuesta 2
                if (pregunta2.equals("2") || pregunta2.equals("3") || pregunta2.equals("5") || pregunta2.equals("6"))
                    binding.res22.setVisibility(View.VISIBLE);

                //respuesta 3
                if (pregunta2.equals("2") || pregunta2.equals("4"))
                    binding.res23.setVisibility(View.VISIBLE);

                //respuesta 4
                if (pregunta2.equals("5") || pregunta2.equals("6"))
                    binding.res24.setVisibility(View.VISIBLE);

                //respuesta 5
                if (pregunta2.equals("2"))
                    binding.res25.setVisibility(View.VISIBLE);


            }
        });


    }

    private void loadDataQuestion3() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Respuestas").document(user.getUid()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();

                String pregunta3 = document.getString("pregunta3");

                binding.res3.setText(pregunta3);

                //respuesta 1
                if (pregunta3.equals("3") || pregunta3.equals("5") || pregunta3.equals("6"))
                    binding.res31.setVisibility(View.VISIBLE);

                //respuesta 2
                if (pregunta3.equals("4") || pregunta3.equals("5") || pregunta3.equals("6"))
                    binding.res32.setVisibility(View.VISIBLE);

                //respuesta 3
                if (pregunta3.equals("3") || pregunta3.equals("4") || pregunta3.equals("5") || pregunta3.equals("6"))
                    binding.res33.setVisibility(View.VISIBLE);

                //respuesta 4
                if (pregunta3.equals("4") || pregunta3.equals("6"))
                    binding.res34.setVisibility(View.VISIBLE);

                //respuesta 5
                if (pregunta3.equals("3") || pregunta3.equals("4") || pregunta3.equals("5"))
                    binding.res35.setVisibility(View.VISIBLE);


            }
        });


    }

    private void loadDataQuestion4() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Respuestas").document(user.getUid()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();

                String pregunta4 = document.getString("pregunta4");

                binding.res4.setText(pregunta4);

                //respuesta 1
                if (pregunta4.equals("2") || pregunta4.equals("3"))
                    binding.res41.setVisibility(View.VISIBLE);

                //respuesta 2
                if (pregunta4.equals("3") || pregunta4.equals("4") || pregunta4.equals("6"))
                    binding.res42.setVisibility(View.VISIBLE);

                //respuesta 3
                if (pregunta4.equals("1") || pregunta4.equals("2") || pregunta4.equals("3") || pregunta4.equals("5"))
                    binding.res43.setVisibility(View.VISIBLE);

                //respuesta 4
                if (pregunta4.equals("3") || pregunta4.equals("5"))
                    binding.res44.setVisibility(View.VISIBLE);

                //respuesta 5
                if (pregunta4.equals("4") || pregunta4.equals("6"))
                    binding.res45.setVisibility(View.VISIBLE);


            }
        });


    }

    private void loadDataQuestion5() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Respuestas").document(user.getUid()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();

                String pregunta5 = document.getString("pregunta5");

                binding.res5.setText(pregunta5);

                //respuesta 1
                if (pregunta5.equals("2") || pregunta5.equals("3"))
                    binding.res51.setVisibility(View.VISIBLE);

                //respuesta 2
                if (pregunta5.equals("1") || pregunta5.equals("2"))
                    binding.res52.setVisibility(View.VISIBLE);

                //respuesta 3
                if (pregunta5.equals("2"))
                    binding.res53.setVisibility(View.VISIBLE);

                //respuesta 4
                if (pregunta5.equals("3") || pregunta5.equals("4"))
                    binding.res54.setVisibility(View.VISIBLE);

                //respuesta 5
                if (pregunta5.equals("1"))
                    binding.res55.setVisibility(View.VISIBLE);


            }
        });


    }

    private void loadDataQuestion6() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Respuestas").document(user.getUid()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();

                String pregunta6 = document.getString("pregunta6");

                binding.res6.setText(pregunta6);

                //respuesta 1
                if (pregunta6.equals("2"))
                    binding.res61.setVisibility(View.VISIBLE);

                //respuesta 2
                if (pregunta6.equals("2"))
                    binding.res62.setVisibility(View.VISIBLE);

                //respuesta 3
                if (pregunta6.equals("3"))
                    binding.res63.setVisibility(View.VISIBLE);

                //respuesta 4
                if (pregunta6.equals("2"))
                    binding.res64.setVisibility(View.VISIBLE);

                //respuesta 5
                if (pregunta6.equals("2"))
                    binding.res65.setVisibility(View.VISIBLE);


            }
        });


    }

    private void loadDataQuestion7() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Respuestas").document(user.getUid()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();

                String pregunta7 = document.getString("pregunta7");

                binding.res7.setText(pregunta7);

                //respuesta 1
                if (pregunta7.equals("1"))
                    binding.res71.setVisibility(View.VISIBLE);

                //respuesta 2
                if (pregunta7.equals("1"))
                    binding.res72.setVisibility(View.VISIBLE);

                //respuesta 3
                if (pregunta7.equals("1"))
                    binding.res73.setVisibility(View.VISIBLE);

                //respuesta 4
                if (pregunta7.equals("1"))
                    binding.res74.setVisibility(View.VISIBLE);

                //respuesta 5
                if (pregunta7.equals("1"))
                    binding.res75.setVisibility(View.VISIBLE);


            }
        });


    }

    @Override
    public void onBackPressed() {
        finish();
    }
}