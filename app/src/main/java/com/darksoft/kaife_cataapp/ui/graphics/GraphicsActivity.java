package com.darksoft.kaife_cataapp.ui.graphics;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.darksoft.kaife_cataapp.databinding.ActivityGraphicsBinding;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Objects;

public class GraphicsActivity extends AppCompatActivity {

    private ActivityGraphicsBinding binding;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGraphicsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        answer1();
        answer2();
        answer3();
        answer4();
        answer5();
        answer6();
        answer7();
    }

    private void answer1() {

        //SetupPieChart
        binding.pieChart1.setDrawHoleEnabled(true);
        binding.pieChart1.setUsePercentValues(true);
        binding.pieChart1.setEntryLabelTextSize(12);
        binding.pieChart1.setEntryLabelColor(Color.BLACK);
        binding.pieChart1.setCenterText("Pregunta 1");
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
                String valor = document.getString("pregunta1");
                datos.add(valor);
            }

            System.out.println(datos);

            float pregunta1 = 0, pregunta2 = 0, pregunta3 = 0, pregunta4 = 0, pregunta5 = 0, pregunta6 = 0;
            for(int i = 0; i < datos.size(); i++){
                if (Objects.equals(datos.get(i), "1"))
                    pregunta1++;
                if (Objects.equals(datos.get(i), "2"))
                    pregunta2++;
                if (Objects.equals(datos.get(i), "3"))
                    pregunta3++;
                if (Objects.equals(datos.get(i), "4"))
                    pregunta4++;
                if (Objects.equals(datos.get(i), "5"))
                    pregunta5++;
                if (Objects.equals(datos.get(i), "6"))
                    pregunta6++;
            }

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
            data.setValueFormatter(new PercentFormatter(binding.pieChart1));
            data.setValueTextSize(12f);
            data.setValueTextColor(Color.BLACK);

            binding.pieChart1.setData(data);
            binding.pieChart1.invalidate();
            binding.pieChart1.animateY(1400, Easing.EaseInOutQuad);

        });

    }

    private void answer2() {

        //SetupPieChart
        binding.pieChart2.setDrawHoleEnabled(true);
        binding.pieChart2.setUsePercentValues(true);
        binding.pieChart2.setEntryLabelTextSize(12);
        binding.pieChart2.setEntryLabelColor(Color.BLACK);
        binding.pieChart2.setCenterText("Pregunta 2");
        binding.pieChart2.setCenterTextSize(24);
        binding.pieChart2.getDescription().setEnabled(false);

        Legend legend = binding.pieChart2.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setEnabled(true);


        ArrayList<String> datos = new ArrayList<>();

        //GetData
        db.collection("Respuestas").get().addOnSuccessListener(queryDocumentSnapshots -> {
            for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                String valor = document.getString("pregunta2");
                datos.add(valor);
            }

            System.out.println(datos);

            float pregunta1 = 0, pregunta2 = 0, pregunta3 = 0, pregunta4 = 0, pregunta5 = 0, pregunta6 = 0;
            for(int i = 0; i < datos.size(); i++){
                if (Objects.equals(datos.get(i), "1"))
                    pregunta1++;
                if (Objects.equals(datos.get(i), "2"))
                    pregunta2++;
                if (Objects.equals(datos.get(i), "3"))
                    pregunta3++;
                if (Objects.equals(datos.get(i), "4"))
                    pregunta4++;
                if (Objects.equals(datos.get(i), "5"))
                    pregunta5++;
                if (Objects.equals(datos.get(i), "6"))
                    pregunta6++;
            }

            //loadPieChartData
            ArrayList<PieEntry> entries = new ArrayList<>();
            entries.add(new PieEntry(pregunta1, "Nuez"));
            entries.add(new PieEntry(pregunta2, "Malta"));
            entries.add(new PieEntry(pregunta3, "Dulce"));
            entries.add(new PieEntry(pregunta4, "Jarabe"));
            entries.add(new PieEntry(pregunta5, "Achocolatado"));
            entries.add(new PieEntry(pregunta6, "Vainilla"));


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
            data.setValueFormatter(new PercentFormatter(binding.pieChart2));
            data.setValueTextSize(12f);
            data.setValueTextColor(Color.BLACK);

            binding.pieChart2.setData(data);
            binding.pieChart2.invalidate();
            binding.pieChart2.animateY(1400, Easing.EaseInOutQuad);

        });

    }

    private void answer3() {

        //SetupPieChart
        binding.pieChart3.setDrawHoleEnabled(true);
        binding.pieChart3.setUsePercentValues(true);
        binding.pieChart3.setEntryLabelTextSize(12);
        binding.pieChart3.setEntryLabelColor(Color.BLACK);
        binding.pieChart3.setCenterText("Pregunta 3");
        binding.pieChart3.setCenterTextSize(24);
        binding.pieChart3.getDescription().setEnabled(false);

        Legend legend = binding.pieChart3.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setEnabled(true);


        ArrayList<String> datos = new ArrayList<>();

        //GetData
        db.collection("Respuestas").get().addOnSuccessListener(queryDocumentSnapshots -> {
            for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                String valor = document.getString("pregunta3");
                datos.add(valor);
            }

            System.out.println(datos);

            float pregunta1 = 0, pregunta2 = 0, pregunta3 = 0, pregunta4 = 0, pregunta5 = 0, pregunta6 = 0;
            for(int i = 0; i < datos.size(); i++){
                if (Objects.equals(datos.get(i), "1"))
                    pregunta1++;
                if (Objects.equals(datos.get(i), "2"))
                    pregunta2++;
                if (Objects.equals(datos.get(i), "3"))
                    pregunta3++;
                if (Objects.equals(datos.get(i), "4"))
                    pregunta4++;
                if (Objects.equals(datos.get(i), "5"))
                    pregunta5++;
                if (Objects.equals(datos.get(i), "6"))
                    pregunta6++;
            }

            //loadPieChartData
            ArrayList<PieEntry> entries = new ArrayList<>();
            entries.add(new PieEntry(pregunta1, "Ceniza"));
            entries.add(new PieEntry(pregunta2, "Ahumado"));
            entries.add(new PieEntry(pregunta3, "Agudo"));
            entries.add(new PieEntry(pregunta4, "Cálido"));
            entries.add(new PieEntry(pregunta5, "Medicinal"));
            entries.add(new PieEntry(pregunta6, "Reinoso"));


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
            data.setValueFormatter(new PercentFormatter(binding.pieChart3));
            data.setValueTextSize(12f);
            data.setValueTextColor(Color.BLACK);

            binding.pieChart3.setData(data);
            binding.pieChart3.invalidate();
            binding.pieChart3.animateY(1400, Easing.EaseInOutQuad);

        });

    }

    private void answer4() {

        //SetupPieChart
        binding.pieChart4.setDrawHoleEnabled(true);
        binding.pieChart4.setUsePercentValues(true);
        binding.pieChart4.setEntryLabelTextSize(12);
        binding.pieChart4.setEntryLabelColor(Color.BLACK);
        binding.pieChart4.setCenterText("Pregunta 4");
        binding.pieChart4.setCenterTextSize(24);
        binding.pieChart4.getDescription().setEnabled(false);

        Legend legend = binding.pieChart4.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setEnabled(true);


        ArrayList<String> datos = new ArrayList<>();

        //GetData
        db.collection("Respuestas").get().addOnSuccessListener(queryDocumentSnapshots -> {
            for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                String valor = document.getString("pregunta4");
                datos.add(valor);
            }

            System.out.println(datos);

            float pregunta1 = 0, pregunta2 = 0, pregunta3 = 0, pregunta4 = 0;
            for(int i = 0; i < datos.size(); i++){
                if (Objects.equals(datos.get(i), "1"))
                    pregunta1++;
                if (Objects.equals(datos.get(i), "2"))
                    pregunta2++;
                if (Objects.equals(datos.get(i), "3"))
                    pregunta3++;
                if (Objects.equals(datos.get(i), "4"))
                    pregunta4++;
            }

            //loadPieChartData
            ArrayList<PieEntry> entries = new ArrayList<>();
            entries.add(new PieEntry(pregunta1, "Ácido"));
            entries.add(new PieEntry(pregunta2, "Dulce"));
            entries.add(new PieEntry(pregunta3, "Salado"));
            entries.add(new PieEntry(pregunta4, "Amargo"));

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
            data.setValueFormatter(new PercentFormatter(binding.pieChart4));
            data.setValueTextSize(12f);
            data.setValueTextColor(Color.BLACK);

            binding.pieChart4.setData(data);
            binding.pieChart4.invalidate();
            binding.pieChart4.animateY(1400, Easing.EaseInOutQuad);

        });

    }

    private void answer5() {

        //SetupPieChart
        binding.pieChart5.setDrawHoleEnabled(true);
        binding.pieChart5.setUsePercentValues(true);
        binding.pieChart5.setEntryLabelTextSize(12);
        binding.pieChart5.setEntryLabelColor(Color.BLACK);
        binding.pieChart5.setCenterText("Pregunta 5");
        binding.pieChart5.setCenterTextSize(24);
        binding.pieChart5.getDescription().setEnabled(false);

        Legend legend = binding.pieChart5.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setEnabled(true);


        ArrayList<String> datos = new ArrayList<>();

        //GetData
        db.collection("Respuestas").get().addOnSuccessListener(queryDocumentSnapshots -> {
            for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                String valor = document.getString("pregunta5");
                datos.add(valor);
            }

            System.out.println(datos);

            float pregunta1 = 0, pregunta2 = 0, pregunta3 = 0, pregunta4 = 0;
            for(int i = 0; i < datos.size(); i++){
                if (Objects.equals(datos.get(i), "1"))
                    pregunta1++;
                if (Objects.equals(datos.get(i), "2"))
                    pregunta2++;
                if (Objects.equals(datos.get(i), "3"))
                    pregunta3++;
                if (Objects.equals(datos.get(i), "4"))
                    pregunta4++;
            }

            //loadPieChartData
            ArrayList<PieEntry> entries = new ArrayList<>();
            entries.add(new PieEntry(pregunta1, "Ácido"));
            entries.add(new PieEntry(pregunta2, "Dulce"));
            entries.add(new PieEntry(pregunta3, "Salado"));
            entries.add(new PieEntry(pregunta4, "Amargo"));

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
            data.setValueFormatter(new PercentFormatter(binding.pieChart5));
            data.setValueTextSize(12f);
            data.setValueTextColor(Color.BLACK);

            binding.pieChart5.setData(data);
            binding.pieChart5.invalidate();
            binding.pieChart5.animateY(1400, Easing.EaseInOutQuad);

        });

    }

    private void answer6() {

        //SetupPieChart
        binding.pieChart6.setDrawHoleEnabled(true);
        binding.pieChart6.setUsePercentValues(true);
        binding.pieChart6.setEntryLabelTextSize(12);
        binding.pieChart6.setEntryLabelColor(Color.BLACK);
        binding.pieChart6.setCenterText("Pregunta 6");
        binding.pieChart6.setCenterTextSize(24);
        binding.pieChart6.getDescription().setEnabled(false);

        Legend legend = binding.pieChart6.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setEnabled(true);


        ArrayList<String> datos = new ArrayList<>();

        //GetData
        db.collection("Respuestas").get().addOnSuccessListener(queryDocumentSnapshots -> {
            for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                String valor = document.getString("pregunta6");
                datos.add(valor);
            }

            System.out.println(datos);

            float pregunta1 = 0, pregunta2 = 0, pregunta3 = 0;
            for(int i = 0; i < datos.size(); i++){
                if (Objects.equals(datos.get(i), "1"))
                    pregunta1++;
                if (Objects.equals(datos.get(i), "2"))
                    pregunta2++;
                if (Objects.equals(datos.get(i), "3"))
                    pregunta3++;
            }

            //loadPieChartData
            ArrayList<PieEntry> entries = new ArrayList<>();
            entries.add(new PieEntry(pregunta1, "Grueso/mantecoso"));
            entries.add(new PieEntry(pregunta2, "Liso"));
            entries.add(new PieEntry(pregunta3, "Delgado/acuoso"));

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
            data.setValueFormatter(new PercentFormatter(binding.pieChart6));
            data.setValueTextSize(12f);
            data.setValueTextColor(Color.BLACK);

            binding.pieChart6.setData(data);
            binding.pieChart6.invalidate();
            binding.pieChart6.animateY(1400, Easing.EaseInOutQuad);

        });

    }

    private void answer7() {

        //SetupPieChart
        binding.pieChart7.setDrawHoleEnabled(true);
        binding.pieChart7.setUsePercentValues(true);
        binding.pieChart7.setEntryLabelTextSize(12);
        binding.pieChart7.setEntryLabelColor(Color.BLACK);
        binding.pieChart7.setCenterText("Pregunta 7");
        binding.pieChart7.setCenterTextSize(24);
        binding.pieChart7.getDescription().setEnabled(false);

        Legend legend = binding.pieChart7.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setEnabled(true);


        ArrayList<String> datos = new ArrayList<>();

        //GetData
        db.collection("Respuestas").get().addOnSuccessListener(queryDocumentSnapshots -> {
            for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                String valor = document.getString("pregunta7");
                datos.add(valor);
            }

            System.out.println(datos);

            float pregunta1 = 0, pregunta2 = 0;
            for(int i = 0; i < datos.size(); i++){
                if (Objects.equals(datos.get(i), "1"))
                    pregunta1++;
                if (Objects.equals(datos.get(i), "2"))
                    pregunta2++;
            }

            //loadPieChartData
            ArrayList<PieEntry> entries = new ArrayList<>();
            entries.add(new PieEntry(pregunta1, "Pesado"));
            entries.add(new PieEntry(pregunta2, "Ligero"));

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
            data.setValueFormatter(new PercentFormatter(binding.pieChart7));
            data.setValueTextSize(12f);
            data.setValueTextColor(Color.BLACK);

            binding.pieChart7.setData(data);
            binding.pieChart7.invalidate();
            binding.pieChart7.animateY(1400, Easing.EaseInOutQuad);

        });

    }


    @Override
    public void onBackPressed() {
        finish();
    }
}