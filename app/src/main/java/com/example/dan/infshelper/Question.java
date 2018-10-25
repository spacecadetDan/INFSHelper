package com.example.dan.infshelper;


public class Question {
    private int textResID;
    private boolean answerTrue;
    //describe parameters for a question
    public Question(int stringReference, boolean answer) {
        textResID = stringReference;
        answerTrue = answer;
    }
    //return question
    public int getTextResID() {
        return textResID;
    }
    //return answer of question
    public boolean getAnswerTrue() {
        return answerTrue;
    }


}
