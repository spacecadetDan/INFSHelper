package com.example.dan.infshelper;


public class Question {
    private int mTextResID;
    private boolean mAnswerTrue;

    public Question(int stringReference, boolean answer) {
        mTextResID = stringReference;
        mAnswerTrue = answer;
    }

    public int getmTextResID() {
        return mTextResID;
    }

    public boolean getmAnswerTrue() {
        return mAnswerTrue;
    }

    public void setmTextResID(int id) {
        id = mTextResID;
    }

    public void setmAnswerTrue(boolean answer) {
        answer = mAnswerTrue;
    }

}
