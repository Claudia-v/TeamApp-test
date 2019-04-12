package com.claudia.teamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button todolist, quiz, calendar, graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todolist = findViewById(R.id.todolistButton);
        quiz = findViewById(R.id.quizButton);
        calendar = findViewById(R.id.calendarButton);
        graph = findViewById(R.id.graphButton);

        todolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent todolist_intent = new Intent(MainActivity.this, ToDoActivity.class);
                startActivity(todolist_intent);
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quiz_intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(quiz_intent);
            }
        });

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calendar_intent = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(calendar_intent);
            }
        });

        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent graph_intent = new Intent(MainActivity.this, GraphActivity.class);
                startActivity(graph_intent);
            }
        });
    }
}
