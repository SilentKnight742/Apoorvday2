package com.mitwpu.apoorvday2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity implements Runnable{
ImageView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.iv1);
        Animation an= AnimationUtils.loadAnimation(this, R.anim.sca_anim);
        tv1.startAnimation(an);
        MediaPlayer mp=MediaPlayer.create(this, R.raw.song);
        mp.start();
        Handler h = new Handler();
        h.postDelayed(this, 12000);
    }

    @Override
    public void run() {
        Intent in = new Intent(this, HomeActivity.class);
        startActivity(in);
    }

}