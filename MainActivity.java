package com.example.shital.numrush;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   // ImageView ima;
    ImageView imgbutton, ima;
    TextView best;
    int res;
    
    private static final String IMAGEVIEW_TAG = "Android Logo";
    public void AppExit()
    {

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
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.st);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.strt);
        final Animation myAni = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolato = new MyBounceInterpolator(0.2, 20);
        myAni.setInterpolator(interpolato);
        setContentView(R.layout.activity_main);
        imgbutton = (ImageView) findViewById(R.id.imageButton2);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
    mp1.start();
                imgbutton.startAnimation(myAni);
                AppExit();
            }
        });
        best = (TextView)findViewById(R.id.textView10);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("com.example.numrush.MyPref", 0); // 0 - for private mode
        //SharedPreferences.Editor editor = pref.edit();

        res = pref.getInt("key_name", 0);
        best.setText(Integer.toString(res));


        ima = (ImageView) findViewById(R.id.imageButton3);
        ima.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"game started", Toast.LENGTH_SHORT);

                mp.start();
                ima.startAnimation(myAni);
                Intent inte = new Intent(MainActivity.this, Main4Activity.class);
                startActivity(inte);
            }
        });

// Sets the tag
        ima.setTag(IMAGEVIEW_TAG);

    }
}
