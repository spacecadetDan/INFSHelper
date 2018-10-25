package com.example.dan.infshelper;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuizQuestions {
    //Separate arrays for each topic section, so that quiz activity can load dynamic quizzes
    public Question[] questionArray = new Question[5];

    public void fundamentalsQuiz() {
        questionArray[0] = new Question(R.string.q1_1, true);
        questionArray[1] = new Question(R.string.q1_2, false);
        questionArray[2] = new Question(R.string.q1_3, false);
        questionArray[3] = new Question(R.string.q1_4, true);
        questionArray[4] = new Question(R.string.q1_5, true);
    }

    public void inheritanceQuiz() {
        questionArray[0] = new Question(R.string.q2_1, true);
        questionArray[1] = new Question(R.string.q2_2, true);
        questionArray[2] = new Question(R.string.q2_3, true);
        questionArray[3] = new Question(R.string.q2_4, false);
        questionArray[4] = new Question(R.string.q2_5, false);
    }

    public void polyQuiz() {
        questionArray[0] = new Question(R.string.q3_1, false);
        questionArray[1] = new Question(R.string.q3_2, true);
        questionArray[2] = new Question(R.string.q3_3, false);
        questionArray[3] = new Question(R.string.q3_4, false);
        questionArray[4] = new Question(R.string.q3_5, true);
    }

    public void javafxQuiz() {
        questionArray[0] = new Question(R.string.q4_1, true);
        questionArray[1] = new Question(R.string.q4_2, false);
        questionArray[2] = new Question(R.string.q4_3, true);
        questionArray[3] = new Question(R.string.q4_4, false);
        questionArray[4] = new Question(R.string.q4_5, false);
    }

    public void exceptionQuiz() {
        questionArray[0] = new Question(R.string.q5_1, false);
        questionArray[1] = new Question(R.string.q5_2, true);
        questionArray[2] = new Question(R.string.q5_3, false);
        questionArray[3] = new Question(R.string.q5_4, true);
        questionArray[4] = new Question(R.string.q5_5, true);
    }

    public void eventQuiz() {
        questionArray[0] = new Question(R.string.q6_1, true);
        questionArray[1] = new Question(R.string.q6_2, false);
        questionArray[2] = new Question(R.string.q6_3, false);
        questionArray[3] = new Question(R.string.q6_4, true);
        questionArray[4] = new Question(R.string.q6_5, true);
    }

    public void databaseQuiz() {
        questionArray[0] = new Question(R.string.q7_1, true);
        questionArray[1] = new Question(R.string.q7_2, false);
        questionArray[2] = new Question(R.string.q7_3, false);
        questionArray[3] = new Question(R.string.q7_4, true);
        questionArray[4] = new Question(R.string.q7_5, false);
    }

    public void reviewQuiz() {
        questionArray[0] = new Question(R.string.q8_1, true);
        questionArray[1] = new Question(R.string.q8_2, true);
        questionArray[2] = new Question(R.string.q8_3, false);
        questionArray[3] = new Question(R.string.q8_4, true);
        questionArray[4] = new Question(R.string.q8_5, false);
    }

    // Implementing an array order shuffle
    public static void shuffleArray(Question[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Question a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

}
