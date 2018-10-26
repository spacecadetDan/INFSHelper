package com.example.dan.infshelper;

import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {

    private static final String TAG = "ScoreActivity";

    DatabaseHelper mDatabaseHelper;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Display a back button in top left
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListView = findViewById(R.id._scoreList);
        mDatabaseHelper = new DatabaseHelper(this);
        //Populate list and display scores
        populateListView();

    }

    private void populateListView() {
        Log.d(TAG, "populateListView Displaying database scores in list");

        //get the data and append to a list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            //get the value from the database in column 1
            //then add it to the ArrayList
            String scoreText = data.getString(1) + "/5 " + data.getString(2);
            listData.add(scoreText);
        }

        //create list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, R.layout.list_style_text, R.id.list_content, listData);
        mListView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        //return to the MainActivity
        super.onBackPressed();
        //horizontal transition
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button and return to MainActivity
            case android.R.id.home:
                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
