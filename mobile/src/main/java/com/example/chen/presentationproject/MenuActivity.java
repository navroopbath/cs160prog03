package com.example.chen.presentationproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private ImageButton menuImage;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menuImage = (ImageButton) findViewById(R.id.menuImage);
        gestureDetector = new GestureDetector(this, new MyGestureDetector());
        gestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        };
        menuImage.setOnTouchListener(gestureListener);
    }

    class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent ev) {
            String movementDetected =ev.toString();
            Toast.makeText(getApplicationContext(), "Going to Edit Now", Toast.LENGTH_LONG).show();
            Intent goToEdit = new Intent(MenuActivity.this, EditPrezi.class);
            MenuActivity.this.startActivity(goToEdit);
            return true;
        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                    return false;
                // right to left swipe
                if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    Toast.makeText(MenuActivity.this, "Left Swipe", Toast.LENGTH_SHORT).show();
                    Intent goToStats = new Intent(MenuActivity.this, statsPrezi.class);
                    MenuActivity.this.startActivity(goToStats);
                }  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    Toast.makeText(MenuActivity.this, "Right Swipe", Toast.LENGTH_SHORT).show();
                    Intent goToTimer = new Intent(MenuActivity.this, timer.class);
                    MenuActivity.this.startActivity(goToTimer);
                }
            } catch (Exception e) {
                // nothing
            }
            return false;
        }
    }
}
