package com.example.dan.infshelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.dan.infshelper.Database.getTopicArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView lv = (ListView) findViewById(R.id.dynamicList);

        ArrayAdapter<Topic> arrayAdapter = new ArrayAdapter<Topic>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                getTopicArrayList());
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                Topic selectedItem = (Topic) parent.getItemAtPosition(position);
                intent.putExtra(EXTRA_MESSAGE, selectedItem.getDegree());
                startActivity(intent);
                overridePendingTransition(R.anim.enter, R.anim.exit);


            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Click on a topic of interest", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
