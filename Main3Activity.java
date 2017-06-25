package com.example.shital.numrush;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.content.SharedPreferences;

public class Main3Activity extends AppCompatActivity {
    ImageView i1, i2;
    TextView yourscore, bestscore, demo;
    int res = 0, temp;
    public void AppExit() {

        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    /*int pid = android.os.Process.myPid();=====> use this if you want to kill your activity. But its not a good one to do.
    android.os.Process.killProcess(pid);*/

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        yourscore = (TextView) findViewById(R.id.textView11);
        bestscore = (TextView) findViewById(R.id.textView12);
        demo = (TextView) findViewById(R.id.textView16);

        // setting a score
        Bundle bundle = getIntent().getExtras();

//Extract the data…
        String stuff = bundle.getString("");
        yourscore.setText(stuff);
        temp = Integer.parseInt(yourscore.getText().toString());
        final Animation myAni = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolato = new MyBounceInterpolator(0.2, 20);
        myAni.setInterpolator(interpolato);

        /*if(temp > res){
            res = temp;
        }

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("key_name", res);

        res = pref.getInt("key_name", Integer.parseInt(null));
bestscore.setText(Integer.toString(res));*/


        //home button
        i1 = (ImageView) findViewById(R.id.imageView8);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.strt);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp1.start();
                i1.startAnimation(myAni);
                //Toast.makeText(getApplicationContext(),"game started", Toast.LENGTH_SHORT);
                Intent inte = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(inte);
            }
        });

        //new game button
        i2 = (ImageView) findViewById(R.id.imageView3);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.st);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i2.startAnimation(myAni);
                mp.start();
                //Intent inte = new Intent(Main3Activity.this, Main2Activity.class);
                //startActivity(inte);
                AppExit();
            }
        });

        SharedPreferences pref = getApplicationContext().getSharedPreferences("com.example.numrush.MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        res = pref.getInt("key_name", 0);

        if(temp > res){
            res = temp;
        }
        editor.putInt("key_name", res);
        editor.commit();
        bestscore.setText(Integer.toString(res));
    }

}
