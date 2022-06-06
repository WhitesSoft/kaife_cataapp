package com.darksoft.kaife_cataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.darksoft.kaife_cataapp.databinding.ActivityMainBinding;
import com.darksoft.kaife_cataapp.model.AnswerModel;
import com.darksoft.kaife_cataapp.ui.quizz.QuizzActivity;
import com.darksoft.kaife_cataapp.ui.sign_in.SignInActivity;
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

        answer1();

        buttons();
    }

    private void answer1() {

        //SetupPieChart
        binding.pieChart.setDrawHoleEnabled(true);
        binding.pieChart.setUsePercentValues(true);
        binding.pieChart.setEntryLabelTextSize(12);
        binding.pieChart.setEntryLabelColor(Color.BLACK);
        binding.pieChart.setCenterText("Kaife_cataAPP");
        binding.pieChart.setCenterTextSize(24);
        binding.pieChart.getDescription().setEnabled(false);

        Legend legend = binding.pieChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setEnabled(true);


        ArrayList<String> datos = new ArrayList<>();

        //GetData
        db.collection("Respuestas").get().addOnSuccessListener(queryDocumentSnapshots -> {
            ArrayList<AnswerModel> answers = new ArrayList<>();
            for (QueryDocumentSnapshot document : queryDocumentSnapshots) {

                String valor = document.getString("pregunta1");

                datos.add(valor);

                Toast.makeText(this, valor, Toast.LENGTH_SHORT).show();

                AnswerModel model = document.toObject(AnswerModel.class);

                model.setPregunta1(model.getPregunta1());
                model.setPregunta2(model.getPregunta2());
                model.setPregunta3(model.getPregunta3());
                model.setPregunta4(model.getPregunta4());
                model.setPregunta5(model.getPregunta5());
                model.setPregunta6(model.getPregunta6());
                model.setPregunta7(model.getPregunta7());

                answers.add(model);

            }

            System.out.println(datos);

            float pregunta1 = 0, pregunta2 = 0, pregunta3 = 0, pregunta4 = 0, pregunta5 = 0, pregunta6 = 0, pregunta7 = 0;
            for(int i = 0; i < datos.size(); i++){
                if (Objects.equals(datos.get(i), "1"))
                    pregunta1++;
            }

            System.out.println(pregunta1);


            //loadPieChartData
            ArrayList<PieEntry> entries = new ArrayList<>();
            entries.add(new PieEntry(pregunta1, "Leguminoso"));
            entries.add(new PieEntry(pregunta2, "Cebolla"));
            entries.add(new PieEntry(pregunta3, "Baya"));
            entries.add(new PieEntry(pregunta4, "Citrico"));
            entries.add(new PieEntry(pregunta5, "Fragante"));
            entries.add(new PieEntry(pregunta6, "Floral"));


            ArrayList<Integer> colors = new ArrayList<>();
            for (int color : ColorTemplate.MATERIAL_COLORS) {
                colors.add(color);
            }

            for (int color : ColorTemplate.VORDIPLOM_COLORS) {
                colors.add(color);
            }

            PieDataSet dataSet = new PieDataSet(entries, "Respuestas");
            dataSet.setColors(colors);

            PieData data = new PieData(dataSet);
            data.setDrawValues(true);
            data.setValueFormatter(new PercentFormatter(binding.pieChart));
            data.setValueTextSize(12f);
            data.setValueTextColor(Color.BLACK);

            binding.pieChart.setData(data);
            binding.pieChart.invalidate();
            binding.pieChart.animateY(1400, Easing.EaseInOutQuad);

        });

    }

    private void setupPieChart() {

        binding.pieChart.setDrawHoleEnabled(true);
        binding.pieChart.setUsePercentValues(true);
        binding.pieChart.setEntryLabelTextSize(12);
        binding.pieChart.setEntryLabelColor(Color.BLACK);
        binding.pieChart.setCenterText("PREGUNTA 1");
        binding.pieChart.setCenterTextSize(24);
        binding.pieChart.getDescription().setEnabled(false);

        Legend legend = binding.pieChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setEnabled(true);

    }

    private void loadPieChartData() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(13, "Opcion a"));
        entries.add(new PieEntry(3f, "2"));
        entries.add(new PieEntry(1.25f, "3"));

        ArrayList<Integer> colors = new ArrayList<>();
        for (int color : ColorTemplate.MATERIAL_COLORS) {
            colors.add(color);
        }

        for (int color : ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color);
        }

        PieDataSet dataSet = new PieDataSet(entries, "Respuestas");
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(binding.pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        binding.pieChart.setData(data);
        binding.pieChart.invalidate();
        binding.pieChart.animateY(1400, Easing.EaseInOutQuad);

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