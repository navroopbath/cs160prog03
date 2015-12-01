package com.example.chen.presentationproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class timer extends AppCompatActivity {

    private GestureDetectorCompat detectSwipe;
    private ImageButton hubImage;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_timer);
        Intent hubIntent = getIntent();
        hubImage = (ImageButton) findViewById(R.id.preziHub);
        gestureDetector = new GestureDetector(this, new MyGestureDetector());
        gestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        };
        hubImage.setOnTouchListener(gestureListener);
    }

    class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent ev) {
            String movementDetected =ev.toString();
            Toast.makeText(getApplicationContext(), "Going to Stats Now", Toast.LENGTH_LONG).show();
            Intent goToStats = new Intent(timer.this, statsPrezi.class);
            timer.this.startActivity(goToStats);
            return true;
        }
    }

}