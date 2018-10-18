package com.example.dan.infshelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.*;
import android.view.View;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";
    public Question[] quizArray = new Question[5];
    private Button trueButton;
    private Button falseButton;
    private Button backButton;
    public int score;
    public int i = 0;
    public boolean isTrue;
    private TextView question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        android.support.v7.widget.Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        final String message = intent.getStringExtra(DetailActivity.EXTRA_MESSAGE);
        QuizQuestions questions = new QuizQuestions();
        quizArray = questions.questions;
        questions.eventQuiz();
        question = findViewById(R.id.textView2);
        question.setText(quizArray[i].getmTextResID());
        isTrue = quizArray[i].getmAnswerTrue();
        backButton = findViewById(R.id.backButton);
        trueButton = findViewById(R.id.trueButton);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i >= quizArray.length) {
                    onFinish();
                } else {
                    if (isTrue) {
                        Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_LONG).show();
                        score++;
                    } else {
                        Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_LONG).show();
                    }
                    try {
                        if(i == quizArray.length) {
                            onFinish();
                        } else {
                            i++;
                            isTrue = quizArray[i].getmAnswerTrue();
                            question.setText(quizArray[i].getmTextResID());
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                        onFinish();
                    }

                }
            }
        });
        falseButton = findViewById(R.id.falseButton);

        falseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!isTrue) {
                    Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_LONG).show();
                    score++;
                } else {
                    Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_LONG).show();
                }

                try {
                    if(i == quizArray.length) {
                        onFinish();
                    } else {
                        i++;
                        isTrue = quizArray[i].getmAnswerTrue();
                        question.setText(quizArray[i].getmTextResID());
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    onFinish();
                }
            }

        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(QuizActivity.this, MainActivity.class);
                backIntent.putExtra(EXTRA_MESSAGE, message);
                startActivity(backIntent);
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
            }
        });
    }

    private void onFinish() {
        question.setText("Game over! You scored: " + score);
        falseButton.setVisibility(View.INVISIBLE);
        trueButton.setVisibility(View.INVISIBLE);
        backButton.setVisibility(View.VISIBLE);
    }

}
