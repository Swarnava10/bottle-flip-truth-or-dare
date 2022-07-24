package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView bottle;
    public Random random = new Random();
    private int lastdir = 0;
    private boolean isspinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottle = findViewById(R.id.bottle);
    }


    public void spinbottle(View v) {
        if (!isspinning) {
            int newDir = random.nextInt(1800);
            float pivotx =bottle.getWidth()/2;
            float pivoty =bottle.getHeight()/2;
            Animation rotate = new RotateAnimation(lastdir, newDir, pivotx, pivoty);
            rotate.setDuration(2500);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    isspinning=true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    isspinning=false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            lastdir = newDir;
            bottle.startAnimation(rotate);


        }
    }
}
