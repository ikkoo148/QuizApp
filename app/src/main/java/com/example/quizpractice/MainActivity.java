package com.example.quizpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] questions = {"1. Python was developed by james gosling",
            "2. Python is a programming language.",
            "3. python was introduce in 1991 ",
            "4. Python was introduced by Sun Micro-system.",
            "5. Python is simple and easy to learn.",
            "6. Python is hard language due to complex syntax.",
            "7. Python was developed by guido van rossum.",
            "8. Python is taught at school level in India.",
            "9. Python is used in Machine Learning.",
            "10. Is python a dynamic programming language "};

    private final boolean[] answer = {false,true,true,false,true,false,true,false,true,true};
    private int score = 0;
    TextView question;
    Button yes;
    Button no;

    private int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.textView2);
        question.setText(questions[index]);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if the array is not going out of bounds
                if(index<=questions.length-1) {
                    if (answer[index]) {
                        score++;
                    }
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + questions.length, Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again. Thankyou", Toast.LENGTH_SHORT).show();
                }

            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if the array is not going out of bounds
                if(index<=questions.length-1) {
                    if (!answer[index]) {
                        score++;
                    }
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is: " + score, Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again. Thankyou", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}