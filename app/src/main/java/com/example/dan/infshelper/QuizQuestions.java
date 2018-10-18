package com.example.dan.infshelper;

public class QuizQuestions extends QuizActivity {
    public Question[] questions = new Question[5];

    public void fundamentalsQuiz() {
        questions[0] = new Question(R.string.q1_1, true);
        questions[1] = new Question(R.string.q1_2, false);
        questions[2] = new Question(R.string.q1_3, false);
        questions[3] = new Question(R.string.q1_4, true);
        questions[4] = new Question(R.string.q1_5, true);
    }
    public void inheritanceQuiz() {
        questions[0] = new Question(R.string.q2_1, true);
        questions[1] = new Question(R.string.q2_2, true);
        questions[2] = new Question(R.string.q2_3, true);
        questions[3] = new Question(R.string.q2_4, false);
        questions[4] = new Question(R.string.q2_5, false);
    }
    public void polyQuiz() {
        questions[0] = new Question(R.string.q3_1, false);
        questions[1] = new Question(R.string.q3_2, true);
        questions[2] = new Question(R.string.q3_3, false);
        questions[3] = new Question(R.string.q3_4, false);
        questions[4] = new Question(R.string.q3_5, true);
    }
    public void javafxQuiz() {
        questions[0] = new Question(R.string.q4_1, true);
        questions[1] = new Question(R.string.q4_2, false);
        questions[2] = new Question(R.string.q4_3, true);
        questions[3] = new Question(R.string.q4_4, false);
        questions[4] = new Question(R.string.q4_5, false);
    }
    public void exceptionQuiz() {
        questions[0] = new Question(R.string.q5_1, false);
        questions[1] = new Question(R.string.q5_2, true);
        questions[2] = new Question(R.string.q5_3, false);
        questions[3] = new Question(R.string.q5_4, true);
        questions[4] = new Question(R.string.q5_5, true);
    }
    public void eventQuiz() {
        questions[0] = new Question(R.string.q6_1, true);
        questions[1] = new Question(R.string.q6_2, false);
        questions[2] = new Question(R.string.q6_3, false);
        questions[3] = new Question(R.string.q6_4, true);
        questions[4] = new Question(R.string.q6_5, true);
    }
    public void databaseQuiz() {
        questions[0] = new Question(R.string.q7_1, true);
        questions[1] = new Question(R.string.q7_2, false);
        questions[2] = new Question(R.string.q7_3, false);
        questions[3] = new Question(R.string.q7_4, true);
        questions[4] = new Question(R.string.q7_5, false);
    }
    public void reviewQuiz() {
        questions[0] = new Question(R.string.q8_1, true);
        questions[1] = new Question(R.string.q8_2, true);
        questions[2] = new Question(R.string.q8_3, false);
        questions[3] = new Question(R.string.q8_4, true);
        questions[4] = new Question(R.string.q8_5, false);
    }
}
