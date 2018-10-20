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
    public static final String USER_ID = "";
    private int userID = -1;
    private static String src = "";
    public YouTubePlayerSupportFragment frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity.USER_ID);
        userID = Integer.parseInt(message);

        Topic topic = Array.getTopicById(userID);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.resultText);
        TextView descView = findViewById(R.id.descText);
        System.out.println("Topic ID, name and degree "+topic.getId()+" "+topic.getName());
        final int parseID = topic.getId();
        textView.setText(topic.getName());
        descView.setText(topic.getDesc());

        frag = (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.youtube_fragment);
        src=topic.getVid();
        frag.initialize(DeveloperKey.DEVELOPER_KEY, this);

        Button quiz = findViewById(R.id.quizLaunch);
            quiz.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DetailActivity.this, QuizActivity.class);
                    intent.putExtra(USER_ID, parseID + "");
                    startActivity(intent);
                }
            });
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {


            youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
            youTubePlayer.loadVideo(src);

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        // YouTube error
        String errorMessage = youTubeInitializationResult.toString();
        Toast.makeText(getApplicationContext(), "YouTube failed to load", Toast.LENGTH_LONG).show();
        Log.d("errorMessage:", errorMessage);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}