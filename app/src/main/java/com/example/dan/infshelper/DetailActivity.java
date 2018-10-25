package com.example.dan.infshelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class DetailActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {
    public static final String TOPIC_ID = "";
    private int topicID = -1;
    private static String src = "";
    public YouTubePlayerSupportFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Display a back button in top left
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity.TOPIC_ID);
        topicID = Integer.parseInt(message);

        Topic topic = Array.getTopicById(topicID);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.resultText);
        TextView descView = findViewById(R.id.descText);
        //For developer to check the correct information has been parsed to this activity
        System.out.println("Topic ID, name and degree " + topic.getId() + " " + topic.getName());
        //set the ID to parse in intent as the topic ID
        final int parseID = topic.getId();
        textView.setText(topic.getName());
        descView.setText(topic.getDesc());
        //create YouTube video fragment
        frag = (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.youtube_fragment);
        //get video reference from topic array dependent on what topic was selected
        src = topic.getVid();
        //initialise the video
        frag.initialize(DeveloperKey.DEVELOPER_KEY, this);

        //quiz launch button
        Button quiz = findViewById(R.id.quizLaunch);
        quiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, QuizActivity.class);
                //parse topic ID so quiz knows what questions to show
                intent.putExtra(TOPIC_ID, parseID + "");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        //set player as default and load the video
        youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
        youTubePlayer.loadVideo(src);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        // YouTube error handling
        String errorMessage = youTubeInitializationResult.toString();
        Toast.makeText(getApplicationContext(), "YouTube failed to load", Toast.LENGTH_LONG).show();
        Log.d("errorMessage:", errorMessage);
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
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}