package com.claudia.teamapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class QuizResultActivity extends AppCompatActivity {

    TextView t1, t2, t3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizresult);

        t1 = findViewById(R.id.textView4);
        t2 = findViewById(R.id.textView5);
        t3 = findViewById(R.id.textView6);

        Intent intent = getIntent();

        String questions = intent.getStringExtra("total");
        String correct = intent.getStringExtra("correct");
        String wrong = intent.getStringExtra("incorrect");

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);
    }
}
