package com.claudia.teamapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    Button button1, button2, button3, button4, button5;
    TextView t1_question, timer;
    int total = 1;
    int correct = 0;
    int wrong = 0;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        t1_question = findViewById(R.id.questionsTxt);
        timer = findViewById(R.id.timerTxt);

        updateQuestion();
        reverseTimer(30, timer);

    }

    public void updateQuestion(){
        total++;
        if (total > 3){

            Intent intent = new Intent(QuizActivity.this, QuizResultActivity.class);
            intent.putExtra("total", String.valueOf(total));
            intent.putExtra("correct", String.valueOf(correct));
            intent.putExtra("incorrect", String.valueOf(wrong));
            startActivity(intent);

        }
        else{

            reference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    final Question question = dataSnapshot.getValue(Question.class);

                    t1_question.setText(question.getQuestion());
                    button1.setText(question.getOption1());
                    button2.setText(question.getOption2());
                    button3.setText(question.getOption3());
                    button4.setText(question.getOption4());
                    button5.setText(question.getOption5());


                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(button1.getText().toString().equals(question.getAnswer())){
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        button1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                            else{

                                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                wrong++;
                                button1.setBackgroundColor(Color.RED);


                                if (button2.getText().toString().equals(question.getAnswer())){
                                    button2.setBackgroundColor(Color.GREEN);
                                }
                                else if(button3.getText().toString().equals(question.getAnswer())){
                                    button3.setBackgroundColor(Color.GREEN);
                                }
                                else if(button4.getText().toString().equals(question.getAnswer())){
                                    button4.setBackgroundColor(Color.GREEN);
                                }
                                else if(button5.getText().toString().equals(question.getAnswer())){
                                    button5.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        button1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button5.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 1500);

                            }
                        }
                    });


                    button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(button2.getText().toString().equals(question.getAnswer())){
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        button1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                            else{

                                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                wrong++;
                                button2.setBackgroundColor(Color.RED);


                                if (button1.getText().toString().equals(question.getAnswer())){
                                    button1.setBackgroundColor(Color.GREEN);
                                }
                                else if(button3.getText().toString().equals(question.getAnswer())){
                                    button3.setBackgroundColor(Color.GREEN);
                                }
                                else if(button4.getText().toString().equals(question.getAnswer())){
                                    button4.setBackgroundColor(Color.GREEN);
                                }
                                else if(button5.getText().toString().equals(question.getAnswer())){
                                    button5.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        button1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button5.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 1500);

                            }
                        }
                    });

                    button3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(button3.getText().toString().equals(question.getAnswer())){
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        button1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                            else{

                                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                wrong++;
                                button3.setBackgroundColor(Color.RED);


                                if (button1.getText().toString().equals(question.getAnswer())){
                                    button1.setBackgroundColor(Color.GREEN);
                                }
                                else if(button2.getText().toString().equals(question.getAnswer())){
                                    button2.setBackgroundColor(Color.GREEN);
                                }
                                else if(button4.getText().toString().equals(question.getAnswer())){
                                    button4.setBackgroundColor(Color.GREEN);
                                }
                                else if(button5.getText().toString().equals(question.getAnswer())){
                                    button5.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        button1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button5.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 1500);

                            }
                        }
                    });

                    button4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(button4.getText().toString().equals(question.getAnswer())){
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        button1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                            else{

                                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                wrong++;
                                button4.setBackgroundColor(Color.RED);


                                if (button1.getText().toString().equals(question.getAnswer())){
                                    button1.setBackgroundColor(Color.GREEN);
                                }
                                else if(button2.getText().toString().equals(question.getAnswer())){
                                    button2.setBackgroundColor(Color.GREEN);
                                }
                                else if(button3.getText().toString().equals(question.getAnswer())){
                                    button3.setBackgroundColor(Color.GREEN);
                                }
                                else if(button5.getText().toString().equals(question.getAnswer())){
                                    button5.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        button1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button5.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 1500);

                            }
                        }
                    });


                    button5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(button5.getText().toString().equals(question.getAnswer())){
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        button1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                            else{

                                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                wrong++;
                                button5.setBackgroundColor(Color.RED);


                                if (button1.getText().toString().equals(question.getAnswer())){
                                    button1.setBackgroundColor(Color.GREEN);
                                }
                                else if(button3.getText().toString().equals(question.getAnswer())){
                                    button3.setBackgroundColor(Color.GREEN);
                                }
                                else if(button4.getText().toString().equals(question.getAnswer())){
                                    button4.setBackgroundColor(Color.GREEN);
                                }
                                else if(button2.getText().toString().equals(question.getAnswer())){
                                    button2.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        button1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        button5.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 1500);

                            }
                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
    }


    public void reverseTimer(int seconds, final TextView tv){
        new CountDownTimer(seconds * 1000+1000, 1000){


            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d", minutes) + " : " + String.format("%02d", seconds));
            }

            @Override
            public void onFinish() {
                tv.setText("Completed");
                Intent intent = new Intent(QuizActivity.this, QuizResultActivity.class);
                intent.putExtra("total", String.valueOf(total));
                intent.putExtra("correct", String.valueOf(correct));
                intent.putExtra("incorrect", String.valueOf(wrong));
                startActivity(intent);
            }
        }.start();
    }
}
