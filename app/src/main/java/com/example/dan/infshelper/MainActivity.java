package com.example.dan.infshelper;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.dan.infshelper.Array.getTopicArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    //user ID needs to be parsed in intents as a string
    public static final String TOPIC_ID = "";
    public static DatabaseHelper mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //list of topics from topic array
        ListView lv = findViewById(R.id.dynamicList);
        ArrayAdapter<Topic> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                //retrieve the array
                getTopicArrayList());
        //adapt listview to array
        lv.setAdapter(arrayAdapter);
        //set a listener on each item in list
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                //get the topic that was clicked from the activity
                Topic selectedItem = (Topic) parent.getItemAtPosition(position);
                //send the topic ID to the detail activity
                intent.putExtra(TOPIC_ID, selectedItem.getId() + "");
                startActivity(intent);
                //add a horizontal slide transition
                overridePendingTransition(R.anim.enter, R.anim.exit);


            }
        });
        mDatabaseHelper = new DatabaseHelper(this);
        generateScoreTotal();
        //help/assistance button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Navigate to score list
                Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(intent);
            }
        });
    }
    private void generateScoreTotal() {
        Log.d(TAG, "generateScoreTotal: Displaying database scores as total");

        //get the data and append to a list
        Cursor data = mDatabaseHelper.getData();
        int total = 0;
        while (data.moveToNext()) {
            //get the value from the database in column 1
            //then add it to the ArrayList
            int scoreText = Integer.parseInt(data.getString(1));
            total = total + scoreText;
        }
        String totalString = "Score: " + total + " / 40";
        TextView scoreList = findViewById(R.id.scoreText);
        scoreList.setText(totalString);

    }

}
