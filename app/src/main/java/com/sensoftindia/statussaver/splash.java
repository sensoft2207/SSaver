package com.sensoftindia.statussaver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class splash extends AppCompatActivity {

    LinearLayout iv_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splashscreen);

        iv_logo =(LinearLayout) findViewById(R.id.iv_logo);

        Animation pulse = AnimationUtils.loadAnimation(this, R.anim.pulse_anim_logo);
        iv_logo.startAnimation(pulse);

        Thread my_thread=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        my_thread.start();


    }
}
