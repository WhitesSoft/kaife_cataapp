package com.darksoft.kaife_cataapp.ui.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.darksoft.kaife_cataapp.R;
import com.darksoft.kaife_cataapp.databinding.ActivityQuizzBinding;
import com.darksoft.kaife_cataapp.ui.answers_after_quizz.AnswersAfterQuizzActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class QuizzActivity extends AppCompatActivity {

    private static ActivityQuizzBinding binding;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    private int p1Answer1 = 0, p1Answer2  = 0, p1Answer3  = 0, p1Answer4  = 0, p1Answer5  = 0, p1Answer6  = 0; //Pregunta1
    private int p2Answer1 = 0, p2Answer2  = 0, p2Answer3  = 0, p2Answer4  = 0, p2Answer5  = 0, p2Answer6  = 0; //Pregunta2
    private int p3Answer1 = 0, p3Answer2  = 0, p3Answer3  = 0, p3Answer4  = 0, p3Answer5  = 0, p3Answer6  = 0; //Pregunta3
    private int p4Answer1 = 0, p4Answer2  = 0, p4Answer3  = 0, p4Answer4  = 0; //Pregunta4
    private int p5Answer1 = 0, p5Answer2  = 0, p5Answer3  = 0, p5Answer4  = 0; //Pregunta5
    private int p6Answer1 = 0, p6Answer2  = 0, p6Answer3  = 0; //Pregunta6
    private int p7Answer1 = 0, p7Answer2  = 0; //Pregunta7

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizzBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        buttons();
    }

    private void buttons() {

        binding.submitReplies.setOnClickListener(v -> {
            submitData();
        });

        binding.back.setOnClickListener(v -> {
            finish();
        });

        binding.exit.setOnClickListener(v -> {
            finish();
        });
    }

    private void submitData() {
        
        if (validar()){

            question1();
            question2();
            question3();
            question4();
            question5();
            question6();
            question7();

            SharedPreferences preferences = getSharedPreferences("genero", MODE_PRIVATE);
            String genero = preferences.getString("genero", "NOEXISTE");


            //Si existe guardado algo en el sharedPreferences entra
            if (!genero.equals("NOEXISTE")){
                HashMap<String, String>  data = new HashMap<>();
                data.put("id", user.getUid());
                data.put("genero", genero);
                data.put("pregunta1", answer1());
                data.put("pregunta2", answer2());
                data.put("pregunta3", answer3());
                data.put("pregunta4", answer4());
                data.put("pregunta5", answer5());
                data.put("pregunta6", answer6());
                data.put("pregunta7", answer7());

                Toast.makeText(this, "Se enviarion sus respuestas.", Toast.LENGTH_SHORT).show();
                calcularRespuesta();
                db.collection("Respuestas").document(user.getUid()).set(data);
                //startActivity(new Intent(this, AnswersAfterQuizzActivity.class));
                finish();
            }else {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                db.collection("Usuarios").document(user.getEmail()).get().addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        DocumentSnapshot document = task.getResult();

                        String generoo = document.getString("genero");

                        HashMap<String, String>  data = new HashMap<>();
                        data.put("id", user.getUid());
                        data.put("genero", generoo);
                        data.put("pregunta1", answer1());
                        data.put("pregunta2", answer2());
                        data.put("pregunta3", answer3());
                        data.put("pregunta4", answer4());
                        data.put("pregunta5", answer5());
                        data.put("pregunta6", answer6());
                        data.put("pregunta7", answer7());

                        Toast.makeText(this, "Se enviarion sus respuestas.", Toast.LENGTH_SHORT).show();
                        calcularRespuesta();
                        db.collection("Respuestas").document(user.getUid()).set(data);
                        //startActivity(new Intent(this, AnswersAfterQuizzActivity.class));
                        finish();

                    }
                });


            }


        }else {
            Toast.makeText(this, "Debe responder todas las preguntas", Toast.LENGTH_SHORT).show();
        }
        
    }

    private void calcularRespuesta(){

        if(answer1().equals("1") && answer2().equals("1") && answer3().equals("3") && answer4().equals("2")
                && answer5().equals("2") && answer6().equals("2") && answer7().equals("1")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "11");
            startActivity(intent);
        }

        if(answer1().equals("1") && answer2().equals("1") && answer3().equals("3") && answer4().equals("2")
                && answer5().equals("2") && answer6().equals("2") && answer7().equals("2")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "12");
            startActivity(intent);
        }

        if(answer1().equals("3") && answer2().equals("5") && answer3().equals("4") && answer4().equals("2")
                && answer5().equals("2") && answer6().equals("1") && answer7().equals("1")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "21");
            startActivity(intent);
        }

        if(answer1().equals("3") && answer2().equals("5") && answer3().equals("4") && answer4().equals("2")
                && answer5().equals("2") && answer6().equals("1") && answer7().equals("2")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "22");
            startActivity(intent);
        }

        if(answer1().equals("6") && answer2().equals("3") && answer3().equals("6") && answer4().equals("2")
                && answer5().equals("2") && answer6().equals("3") && answer7().equals("1")){

            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "31");
            startActivity(intent);
        }

        if(answer1().equals("6") && answer2().equals("3") && answer3().equals("6") && answer4().equals("2")
                && answer5().equals("2") && answer6().equals("3") && answer7().equals("2")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "32");
            startActivity(intent);
        }

        if(answer1().equals("2") && answer2().equals("4") && answer3().equals("4") && answer4().equals("1")
                && answer5().equals("2") && answer6().equals("2") && answer7().equals("1")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "41");
            startActivity(intent);
        }

        if(answer1().equals("2") && answer2().equals("4") && answer3().equals("4") && answer4().equals("1")
                && answer5().equals("2") && answer6().equals("2") && answer7().equals("1")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "42");
            startActivity(intent);
        }

        if(answer1().equals("4") && answer2().equals("6") && answer3().equals("5") && answer4().equals("3")
                && answer5().equals("1") && answer6().equals("2") && answer7().equals("1")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "51");
            startActivity(intent);
        }

        if(answer1().equals("4") && answer2().equals("6") && answer3().equals("5") && answer4().equals("3")
                && answer5().equals("1") && answer6().equals("2") && answer7().equals("2")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "52");
            startActivity(intent);
        }

        if(answer1().equals("5") && answer2().equals("4") && answer3().equals("2") && answer4().equals("2")
                && answer5().equals("3") && answer6().equals("1") && answer7().equals("1")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "61");
            startActivity(intent);
        }

        if(answer1().equals("5") && answer2().equals("4") && answer3().equals("2") && answer4().equals("2")
                && answer5().equals("3") && answer6().equals("1") && answer7().equals("2")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "62");
            startActivity(intent);
        }

        if(answer1().equals("1") && answer2().equals("1") && answer3().equals("1") && answer4().equals("1")
                && answer5().equals("1") && answer6().equals("1") && answer7().equals("1")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "71");
            startActivity(intent);
        }

        if(answer1().equals("2") && answer2().equals("2") && answer3().equals("2") && answer4().equals("2")
                && answer5().equals("2") && answer6().equals("2") && answer7().equals("2")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "81");
            startActivity(intent);
        }

        if(answer1().equals("3") && answer2().equals("3") && answer3().equals("3") && answer4().equals("3")
                && answer5().equals("3") && answer6().equals("3") && answer7().equals("1")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "91");
            startActivity(intent);
        }

        if(answer1().equals("4") && answer2().equals("4") && answer3().equals("4") && answer4().equals("4")
                && answer5().equals("4") && answer6().equals("1") && answer7().equals("2")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "101");
            startActivity(intent);
        }

        if(answer1().equals("5") && answer2().equals("5") && answer3().equals("5") && answer4().equals("1")
                && answer5().equals("1") && answer6().equals("2") && answer7().equals("1")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "111");
            startActivity(intent);
        }

        if(answer1().equals("6") && answer2().equals("6") && answer3().equals("6") && answer4().equals("2")
                && answer5().equals("2") && answer6().equals("3") && answer7().equals("2")){
            Intent intent = new Intent(this, AnswersAfterQuizzActivity.class);
            intent.putExtra("respuesta", "121");
            startActivity(intent);
        }




    }

    //Aumentamos en 1 la variable para saber que respondio
    private void question1() {
        if(binding.l1rb1.isChecked())
            p1Answer1++;
        if(binding.l1rb2.isChecked())
            p1Answer2++;
        if(binding.l1rb3.isChecked())
            p1Answer3++;
        if(binding.l1rb4.isChecked())
            p1Answer4++;
        if(binding.l1rb5.isChecked())
            p1Answer5++;
        if(binding.l1rb6.isChecked())
            p1Answer6++;
    }

    private void question2() {
        if(binding.l2rb1.isChecked())
            p2Answer1++;
        if(binding.l2rb2.isChecked())
            p2Answer2++;
        if(binding.l2rb3.isChecked())
            p2Answer3++;
        if(binding.l2rb4.isChecked())
            p2Answer4++;
        if(binding.l2rb5.isChecked())
            p2Answer5++;
        if(binding.l2rb6.isChecked())
            p2Answer6++;
    }

    private void question3() {
        if(binding.l3rb1.isChecked())
            p3Answer1++;
        if(binding.l3rb2.isChecked())
            p3Answer2++;
        if(binding.l3rb3.isChecked())
            p3Answer3++;
        if(binding.l3rb4.isChecked())
            p3Answer4++;
        if(binding.l3rb5.isChecked())
            p3Answer5++;
        if(binding.l3rb6.isChecked())
            p3Answer6++;
    }

    private void question4() {
        if(binding.l4rb1.isChecked())
            p4Answer1++;
        if(binding.l4rb2.isChecked())
            p4Answer2++;
        if(binding.l4rb3.isChecked())
            p4Answer3++;
        if(binding.l4rb4.isChecked())
            p4Answer4++;
    }

    private void question5() {
        if(binding.l5rb1.isChecked())
            p5Answer1++;
        if(binding.l5rb2.isChecked())
            p5Answer2++;
        if(binding.l5rb3.isChecked())
            p5Answer3++;
        if(binding.l5rb4.isChecked())
            p5Answer4++;
    }

    private void question6() {
        if(binding.l6rb1.isChecked())
            p6Answer1++;
        if(binding.l6rb2.isChecked())
            p6Answer2++;
        if(binding.l6rb3.isChecked())
            p6Answer3++;
    }

    private void question7() {
        if(binding.l7rb1.isChecked())
            p7Answer1++;
        if(binding.l7rb2.isChecked())
            p7Answer2++;
    }

    //Obtenemos las respuestas
    private String answer1(){
        if (p1Answer1 != 0)
            return "1";
        if (p1Answer2 != 0)
            return "2";
        if (p1Answer3 != 0)
            return "3";
        if (p1Answer4 != 0)
            return "4";
        if (p1Answer5 != 0)
            return "5";
        if (p1Answer6 != 0)
            return "6";
        return "0";
    }

    private String answer2(){
        if (p2Answer1 != 0)
            return "1";
        if (p2Answer2 != 0)
            return "2";
        if (p2Answer3 != 0)
            return "3";
        if (p2Answer4 != 0)
            return "4";
        if (p2Answer5 != 0)
            return "5";
        if (p2Answer6 != 0)
            return "6";
        return "0";
    }

    private String answer3(){
        if (p3Answer1 != 0)
            return "1";
        if (p3Answer2 != 0)
            return "2";
        if (p3Answer3 != 0)
            return "3";
        if (p3Answer4 != 0)
            return "4";
        if (p3Answer5 != 0)
            return "5";
        if (p3Answer6 != 0)
            return "6";
        return "0";
    }

    private String answer4(){
        if (p4Answer1 != 0)
            return "1";
        if (p4Answer2 != 0)
            return "2";
        if (p4Answer3 != 0)
            return "3";
        if (p4Answer4 != 0)
            return "4";
        return "0";
    }

    private String answer5(){
        if (p5Answer1 != 0)
            return "1";
        if (p5Answer2 != 0)
            return "2";
        if (p5Answer3 != 0)
            return "3";
        if (p5Answer4 != 0)
            return "4";
        return "0";
    }

    private String answer6(){
        if (p6Answer1 != 0)
            return "1";
        if (p6Answer2 != 0)
            return "2";
        if (p6Answer3 != 0)
            return "3";
        return "0";
    }

    private String answer7(){
        if (p7Answer1 != 0)
            return "1";
        if (p7Answer2 != 0)
            return "2";
        return "0";
    }

    //Validamos que responda todas las preguntas
    private boolean validar() {
        boolean retorno = true;

        if(!binding.l1rb1.isChecked() && !binding.l1rb2.isChecked() && !binding.l1rb3.isChecked() && !binding.l1rb4.isChecked()
                && !binding.l1rb5.isChecked() && !binding.l1rb6.isChecked()){
            retorno = false;
        }
        if(!binding.l2rb1.isChecked() && !binding.l2rb2.isChecked() && !binding.l2rb3.isChecked() && !binding.l2rb4.isChecked()
                && !binding.l2rb5.isChecked() && !binding.l2rb6.isChecked()){
            retorno = false;
        }
        if(!binding.l3rb1.isChecked() && !binding.l3rb2.isChecked() && !binding.l3rb3.isChecked() && !binding.l3rb4.isChecked()
                && !binding.l3rb5.isChecked() && !binding.l3rb6.isChecked()){
            retorno = false;
        }
        if(!binding.l4rb1.isChecked() && !binding.l4rb2.isChecked() && !binding.l4rb3.isChecked() && !binding.l4rb4.isChecked()){
            retorno = false;
        }
        if(!binding.l5rb1.isChecked() && !binding.l5rb2.isChecked() && !binding.l5rb3.isChecked() && !binding.l5rb4.isChecked()){
            retorno = false;
        }
        if(!binding.l6rb1.isChecked() && !binding.l6rb2.isChecked() && !binding.l6rb3.isChecked()){
            retorno = false;
        }
        if(!binding.l7rb1.isChecked() && !binding.l7rb2.isChecked()){
            retorno = false;
        }

        return retorno;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}