package com.example.quizzappproject;

    /*====== Made by Majlo on 11.03.2019 ======*/
    /*===== Edited by Majlo on 18.03.2019 =====*/

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button answer1, answer2, answer3, answer4;

    TextView wynik, question;

    private Questions mQuestions = new Questions();

    private String mAnswer;
    private int mWynik = 0;
    private int ile = 0;
    private int mQuestionLenght = mQuestions.mQuestions.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        wynik = (TextView) findViewById(R.id.wynik);
        question = (TextView) findViewById(R.id.question);

        wynik.setText("Wynik: " + mWynik);

    updateQuestions(r.nextInt(mQuestionLenght));

        answer1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(answer1.getText() == mAnswer){
                    mWynik++;
                    ile++;
                    if (ile == 6){
                        gameOver();
                    }
                    wynik.setText("Wynik: " + mWynik);
                    updateQuestions(r.nextInt(mQuestionLenght));
                } else {
                    updateQuestions(r.nextInt(mQuestionLenght));
                    ile++;
                    if (ile == 6){
                        gameOver();
                    }
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(answer2.getText() == mAnswer){
                    mWynik++;
                    ile++;
                    if (ile == 6){
                        gameOver();
                    }
                    wynik.setText("Wynik: " + mWynik);
                    updateQuestions(r.nextInt(mQuestionLenght));
                } else {
                    updateQuestions(r.nextInt(mQuestionLenght));
                    ile++;
                    if (ile == 6){
                        gameOver();
                    }
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(answer3.getText() == mAnswer){
                    mWynik++;
                    ile++;
                    if (ile == 6){
                        gameOver();
                    }
                    wynik.setText("Wynik: " + mWynik);
                    updateQuestions(r.nextInt(mQuestionLenght));
                } else {
                    updateQuestions(r.nextInt(mQuestionLenght));
                    ile++;
                    if (ile == 6){
                        gameOver();
                    }
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(answer4.getText() == mAnswer){
                    mWynik++;
                    ile++;
                    if (ile == 6){
                        gameOver();
                    }
                    wynik.setText("Wynik: " + mWynik);
                    updateQuestions(r.nextInt(mQuestionLenght));
                } else {
                    updateQuestions(r.nextInt(mQuestionLenght));
                    ile++;
                    if (ile == 6){
                        gameOver();
                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
       // }

        return super.onOptionsItemSelected(item);
    }

    private void updateQuestions(int num){
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswers(num);
    }

    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        final AlertDialog.Builder builder = alertDialogBuilder
                .setMessage("Gratulujemy! Twój wynik to: " + mWynik + " na 6 punktów.")
                .setCancelable(false)
                .setPositiveButton("Nowa Gra",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        })
                .setNegativeButton("Wyjście",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
