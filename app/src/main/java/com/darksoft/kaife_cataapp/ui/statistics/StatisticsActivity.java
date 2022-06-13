package com.darksoft.kaife_cataapp.ui.statistics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import com.darksoft.kaife_cataapp.databinding.ActivityStatisticsBinding;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Objects;

public class StatisticsActivity extends AppCompatActivity {

    private ActivityStatisticsBinding binding;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStatisticsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.back.setOnClickListener(v ->{
            finish();
        });

        loadData();
    }

    private void loadData(){
        //SetupPieChart
        binding.pieChart1.setDrawHoleEnabled(true);
        binding.pieChart1.setUsePercentValues(true);
        binding.pieChart1.setEntryLabelTextSize(12);
        binding.pieChart1.setEntryLabelColor(Color.BLACK);
        binding.pieChart1.setCenterText("Género");
        binding.pieChart1.setCenterTextSize(24);
        binding.pieChart1.getDescription().setEnabled(false);

        Legend legend = binding.pieChart1.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setEnabled(true);

        ArrayList<String> datos = new ArrayList<>();

        //GetData
        db.collection("Respuestas").get().addOnSuccessListener(queryDocumentSnapshots -> {
            for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                String valor = document.getString("genero");
                datos.add(valor);
            }

            int female = 0, male = 0;
            for(int i = 0; i < datos.size(); i++){
                if (Objects.equals(datos.get(i), "femenino"))
                    female++;
                if (Objects.equals(datos.get(i), "masculino"))
                    male++;
            }

            binding.tAllAnswersFemenino.setText(String.valueOf(female));
            binding.tAllAnswersMasculino.setText(String.valueOf(male));

            //loadPieChartData
            ArrayList<PieEntry> entries = new ArrayList<>();
            entries.add(new PieEntry(female, "Femenino"));
            entries.add(new PieEntry(male, "Masculino"));

            ArrayList<Integer> colors = new ArrayList<>();
            for (int color : ColorTemplate.MATERIAL_COLORS) {
                colors.add(color);
            }

            for (int color : ColorTemplate.PASTEL_COLORS) {
                colors.add(color);
            }

            PieDataSet dataSet = new PieDataSet(entries, "Respuestas");
            dataSet.setColors(colors);

            PieData data = new PieData(dataSet);
            data.setDrawValues(true);
            data.setValueFormatter(new PercentFormatter(binding.pieChart1));
            data.setValueTextSize(12f);
            data.setValueTextColor(Color.BLACK);

            binding.pieChart1.setData(data);
            binding.pieChart1.invalidate();
            binding.pieChart1.animateY(1400, Easing.EaseInOutQuad);

        });


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