package com.example.quizzappproject;

    /*====== Made by Majlo on 11.03.2019 ======*/
    /*===== Edited by Majlo on 18.03.2019 =====*/
    /*===== Edited by Majlo on 31.03.2019 =====*/
    /*===== Edited by Majlo on 7.04.2019 ======*/

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button answer1, answer2, answer3, answer4;

    TextView wynik, question, countdownText;

    private CountDownTimer mCountDownTimer;

    private long timeLeftInMilliseconds = 30000; //30 sekund
    private boolean timerRunning;

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

        countdownText = (TextView) findViewById(R.id.countdownText);

        wynik.setText("Wynik: " + mWynik);

    updateQuestions(r.nextInt(mQuestionLenght));

        answer1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
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

    private void updateQuestions(int num){
        startTimer();
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswers(num);
    }

    public void startTimer(){
        mCountDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinish) {
                timeLeftInMilliseconds = millisUntilFinish;
                updateTimer();
            }

            @Override
            public void onFinish(){
                timerRunning=false;
                gameOver();
            }
        }.start();
        timerRunning = true;
    }

    public void stopTimer(){
        mCountDownTimer.cancel();
        timerRunning = false;
    }

    public void updateTimer(){
        int minutes = (int) (timeLeftInMilliseconds / 1000) / 60;
        int seconds = (int) (timeLeftInMilliseconds / 1000) % 60;

        String timeLeftText;

        timeLeftText = "" + minutes;
        timeLeftText += ":";

        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;

        countdownText.setText(timeLeftText);
    }



    public void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        final AlertDialog.Builder builder = alertDialogBuilder
                .setMessage("Gratulujemy! Twój wynik to: " + mWynik + " na 6 punktów.")
                .setCancelable(false)
                .setPositiveButton("Nowa Gra",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
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
