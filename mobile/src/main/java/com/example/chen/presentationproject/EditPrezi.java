package com.example.chen.presentationproject;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class EditPrezi extends AppCompatActivity {

    private ImageButton editPreziImage;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_edit_prezi);
        editPreziImage = (ImageButton) findViewById(R.id.editPrezi);
        Intent preziIntent = getIntent();
        gestureDetector = new GestureDetector(this, new MyGestureDetector());
        gestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        };
        editPreziImage.setOnTouchListener(gestureListener);
    }

    class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent ev) {
            String movementDetected =ev.toString();
            Toast.makeText(getApplicationContext(), "Going to Timer Now", Toast.LENGTH_LONG).show();
            Intent goToTimer = new Intent(EditPrezi.this, type.class);
            EditPrezi.this.startActivity(goToTimer);
            return true;
        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                    return false;
                // right to left swipe
                if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    Toast.makeText(EditPrezi.this, "Left Swipe", Toast.LENGTH_SHORT).show();
                    Intent goToMenu = new Intent(EditPrezi.this, MenuActivity.class);
                    EditPrezi.this.startActivity(goToMenu);
                }
            } catch (Exception e) {
                // nothing
            }
            return false;
        }
    }

}

