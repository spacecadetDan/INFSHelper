package com.example.dan.infshelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.dan.infshelper.Array.getTopicArrayList;

public class MainActivity extends AppCompatActivity {
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

}
