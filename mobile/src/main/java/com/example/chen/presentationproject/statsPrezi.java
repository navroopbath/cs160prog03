package com.example.chen.presentationproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class statsPrezi extends AppCompatActivity {

    private ImageButton statsImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_stats_prezi);
        statsImage = (ImageButton) findViewById(R.id.statspageone);
        Intent statIntent = getIntent();
        statsImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent goToHome = new Intent(statsPrezi.this, MenuActivity.class);
                statsPrezi.this.startActivity(goToHome);
                return true;
            }
        });
    }

}