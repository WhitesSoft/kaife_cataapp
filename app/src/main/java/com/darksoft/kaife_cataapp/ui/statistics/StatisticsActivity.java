package com.darksoft.kaife_cataapp.ui.statistics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import com.darksoft.kaife_cataapp.databinding.ActivityStatisticsBinding;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Objects;

public class StatisticsActivity extends AppCompatActivity {

    private ActivityStatisticsBinding binding;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private ArrayList<BarEntry> femenino = new ArrayList<>();
    private ArrayList<BarEntry> masculino = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStatisticsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences preferences = getSharedPreferences("generos", MODE_PRIVATE);
        String female = preferences.getString("femenino", "NO");

        binding.back.setOnClickListener(v ->{
            System.out.println(female);
            finish();
        });

        getData();
        loadData();
    }

    private void loadData() {
        BarDataSet barDataSet1 = new BarDataSet(femenino, "Femenino");
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet1.setValueTextColor(Color.BLACK);
        barDataSet1.setValueTextSize(16f);

        BarDataSet barDataSet2 = new BarDataSet(masculino, "Masculino");
        barDataSet2.setColor(Color.BLUE);
        barDataSet2.setValueTextColor(Color.BLACK);
        barDataSet2.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet1, barDataSet2);
        binding.chart1.setData(barData);
        binding.chart1.getDescription().setEnabled(false);
    }

    private void getData(){

        SharedPreferences preferences = getSharedPreferences("genero", MODE_PRIVATE);
        ArrayList<String> global = new ArrayList<>();

        db.collection("Respuestas").get().addOnSuccessListener(task -> {

            for (DocumentSnapshot document: task){
                String valor = document.getString("genero");
                global.add(valor);
            }

            int male = 0, female = 0;
            for (int i = 0; i < global.size(); i++){
                if (Objects.equals(global.get(i), "femenino"))
                    female++;
                if (Objects.equals(global.get(i), "masculino"))
                    male++;
            }

//            femenino.add(new BarEntry(2, female));
//            masculino.add(new BarEntry(4, male));

            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("femenino", female);
            editor.putInt("masculino", male);
            editor.commit();

        });

        int female = preferences.getInt("femenino", 0);
        int male = preferences.getInt("masculino", 0);

        femenino.add(new BarEntry(2, female));
        masculino.add(new BarEntry(4, male));

    }

    @Override
    public void onBackPressed() {

        SharedPreferences preferences = getSharedPreferences("genero", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("masculino");
        editor.remove("femenino");
        editor.commit();

        finish();
    }
}