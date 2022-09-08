package com.darksoft.kaife_cataapp.ui.answers_after_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.darksoft.kaife_cataapp.R;
import com.darksoft.kaife_cataapp.databinding.ActivityAnswersAfterQuizzBinding;

public class AnswersAfterQuizzActivity extends AppCompatActivity {

    private ActivityAnswersAfterQuizzBinding binding;
    private static String respuesta = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnswersAfterQuizzBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       cargarRespuesta();

        binding.exit.setOnClickListener(v -> {
            finish();
        });
    }

    private void cargarRespuesta() {

        Bundle extras = getIntent().getExtras();

        respuesta = extras.getString("respuesta");

        if(respuesta.equals("11")){
            binding.res11.setText(R.string.respuesta_11);
            binding.res11.setTextColor(Color.parseColor("#BEAA41"));
        }

        if(respuesta.equals("12")){
            binding.res11.setText(R.string.respuesta_12);
            binding.res11.setTextColor(Color.parseColor("#BEAA41"));
        }

        if(respuesta.equals("21")){
            binding.res11.setText(R.string.respuesta_21);
            binding.res11.setTextColor(Color.RED);
        }

        if(respuesta.equals("22")){
            binding.res11.setText(R.string.respuesta_22);
            binding.res11.setTextColor(Color.RED);
        }

        if(respuesta.equals("31")){
            binding.res11.setText(R.string.respuesta_31);
            binding.res11.setTextColor(Color.BLUE);
        }

        if(respuesta.equals("32")){
            binding.res11.setText(R.string.respuesta_32);
            binding.res11.setTextColor(Color.BLUE);
        }

        if(respuesta.equals("41")){
            binding.res11.setText(R.string.respuesta_41);
            binding.res11.setTextColor(Color.GRAY);
        }

        if(respuesta.equals("42")){
            binding.res11.setText(R.string.respuesta_42);
            binding.res11.setTextColor(Color.GRAY);
        }

        if(respuesta.equals("51")){
            binding.res11.setText(R.string.respuesta_51);
            binding.res11.setTextColor(Color.MAGENTA);
        }

        if(respuesta.equals("52")){
            binding.res11.setText(R.string.respuesta_52);
            binding.res11.setTextColor(Color.MAGENTA);
        }

        if(respuesta.equals("61")){
            binding.res11.setText(R.string.respuesta_61);
            binding.res11.setTextColor(Color.BLACK);
        }

        if(respuesta.equals("62")){
            binding.res11.setText(R.string.respuesta_62);
            binding.res11.setTextColor(Color.BLACK);
        }

        if(respuesta.equals("71")){
            binding.res11.setText(R.string.respuesta_71);
            binding.res11.setTextColor(Color.RED);
        }

        if(respuesta.equals("81")){
            binding.res11.setText(R.string.respuesta_81);
            binding.res11.setTextColor(Color.parseColor("#BEAA41"));
        }

        if(respuesta.equals("91")){
            binding.res11.setText(R.string.respuesta_91);
            binding.res11.setTextColor(Color.parseColor("#b66833"));
        }

        if(respuesta.equals("101")){
            binding.res11.setText(R.string.respuesta_101);
            binding.res11.setTextColor(Color.parseColor("#f5dc5a"));
        }

        if(respuesta.equals("111")){
            binding.res11.setText(R.string.respuesta_111);
            binding.res11.setTextColor(Color.parseColor("#4f71ab"));
        }

        if(respuesta.equals("121")){
            binding.res11.setText(R.string.respuesta_121);
            binding.res11.setTextColor(Color.parseColor("#BEAA41"));
        }

    }
}