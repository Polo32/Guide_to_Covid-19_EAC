package com.llodu.covid19guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=3000;
    Animation mtop_anim, mbottom_anim;
    ImageView mcovi_img;
    TextView mtxt_title, mtxt_descrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //closing the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        mtop_anim= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        mbottom_anim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        mcovi_img= findViewById(R.id.codi_pic);
        mtxt_title= findViewById(R.id.txt_title);
        mtxt_descrip= findViewById(R.id.txt_titleDesc);

        mcovi_img.setAnimation(mtop_anim);
        mtxt_title.setAnimation(mbottom_anim);
        mtxt_descrip.setAnimation(mbottom_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);


    }
}