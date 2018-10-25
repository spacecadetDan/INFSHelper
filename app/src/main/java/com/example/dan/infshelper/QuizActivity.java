package com.example.dan.infshelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";
    public Question[] quizArray = new Question[5];
    public int score;
    public int i = 0;
    public boolean isTrue;
    public QuizQuestions questions = new QuizQuestions();
    public Topic topic;
    private Button trueButton;
    private Button falseButton;
    private Button backButton;
    private TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        //retrieve parsed user ID string
        final String message = intent.getStringExtra(DetailActivity.TOPIC_ID);
        //set user ID as an int again
        int topicID = Integer.parseInt(message);

        System.out.println("user id is" + topicID);
        //retrieve list of topics by ID
        topic = Array.getTopicById(topicID);
        if (topicID == 1) {
            questions.fundamentalsQuiz();
        } else if (topicID == 2) {
            questions.inheritanceQuiz();
        } else if (topicID == 3) {
            questions.polyQuiz();
        } else if (topicID == 4) {
            questions.javafxQuiz();
        } else if (topicID == 5) {
            questions.exceptionQuiz();
        } else if (topicID == 6) {
            questions.eventQuiz();
        } else if (topicID == 7) {
            questions.databaseQuiz();
        } else if (topicID == 8) {
            questions.reviewQuiz();
        }
        //randomise order of questions
        questions.shuffleArray(questions.questionArray);
        //load array
        quizArray = questions.questionArray;

        question = findViewById(R.id.textView2);
        //set the question text
        question.setText(quizArray[i].getTextResID());
        //get the answers from array
        isTrue = quizArray[i].getAnswerTrue();
        backButton = findViewById(R.id.backButton);
        trueButton = findViewById(R.id.trueButton);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if the answer is true and display a toast appropriately
                if (isTrue) {
                    Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_LONG).show();
                    score++;
                } else {
                    Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_LONG).show();
                }
                //try and catch the end of the quiz, since the length of the array will have been exceeded
                try {
                    if (i == quizArray.length) {
                        onFinish();
                    } else {
                        i++;
                        isTrue = quizArray[i].getAnswerTrue();
                        question.setText(quizArray[i].getTextResID());
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    onFinish();
                }
            }
        });
        falseButton = findViewById(R.id.falseButton);

        falseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //check if the answer is false and display a toast appropriately
                if (!isTrue) {
                    Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_LONG).show();
                    score++;
                } else {
                    Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_LONG).show();
                }
                //try and catch the end of the quiz, since the length of the array will have been exceeded
                try {
                    if (i == quizArray.length) {
                        onFinish();
                    } else {
                        i++;
                        isTrue = quizArray[i].getAnswerTrue();
                        question.setText(quizArray[i].getTextResID());
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
                //intent to return to the main activity
                Intent backIntent = new Intent(QuizActivity.this, MainActivity.class);
                backIntent.putExtra(EXTRA_MESSAGE, message);
                startActivity(backIntent);
                //horizontal transition animation
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
            }
        });
    }

    private void onFinish() {
        //provide dynamic "finished" text
        if (score == 5) {
            question.setText("WOOHOO!!! PERFECT SCORE: " + score + "/5 for " + topic.getName());
        } else if (score >= 3) {
            question.setText("Nice work! You scored: " + score + "/5 for " + topic.getName());
        } else if (score == 0) {
            question.setText("Wow you scored " + score + "/5 for " + topic.getName() + "...better get back to revising");
        } else {
            question.setText("Uh oh... you only scored " + score + "/5 for " + topic.getName());
        }
        //remove the true/false buttons and replace with a back button
        falseButton.setVisibility(View.INVISIBLE);
        trueButton.setVisibility(View.INVISIBLE);
        backButton.setVisibility(View.VISIBLE);
    }
}
