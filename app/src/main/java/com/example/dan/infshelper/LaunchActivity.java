package com.example.dan.infshelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;

public class LaunchActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_launch);


        ImageView loadImg = findViewById(R.id.imageView);
        // Find the root view
        View root = loadImg.getRootView();

        // Set the color
        root.setBackgroundColor(getResources().getColor(android.R.color.white));
        ConstraintLayout fullPage = findViewById(R.id.fullLayout);
        fullPage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
                startActivity(intent);
                return true;//always return true to consume event
            }
        });
        try {
            Glide.with(this)
                    .load(R.raw.loading_icon)
                    .into(new DrawableImageViewTarget(loadImg) {
                        @Override public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            if (resource instanceof GifDrawable) {
                                ((GifDrawable)resource).setLoopCount(1);
                            }
                            super.onResourceReady(resource, transition);
                        }
                    });
        } catch(NullPointerException e) {
            System.out.println("Didn't load");
        }

    }
}
