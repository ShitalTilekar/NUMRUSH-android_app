package com.example.shital.numrush;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    Button b, b1;
    EditText et;
    String msg;

    ImageView i, i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        b = (Button) findViewById(R.id.button);
     //   b1 = (Button) findViewById(R.id.button1);
        et = (EditText) findViewById(R.id.editText);
i = (ImageView) findViewById(R.id.imageView10);
        i1 = (ImageView) findViewById(R.id.imageView12);
       /* v = (VideoView) findViewById(R.id.videoView1);String uriPath2 = "android.resource://com.example.shital.numrush/"+R.raw.movie;
        Uri uri2 = Uri.parse(uriPath2);
        v.setVideoURI(uri2);
        v.requestFocus();
        v.start();*/
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.st);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.strt);
        final Animation myAni = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolato = new MyBounceInterpolator(0.2, 20);
        myAni.setInterpolator(interpolato);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"game started", Toast.LENGTH_SHORT);

                mp.start();
                b.startAnimation(myAni);
                /*SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
                editor.putString("text", et.getText().toString());
                editor.commit();*/


                   // Toast.makeText(getApplicationContext(), "Enter name please", Toast.LENGTH_SHORT).show();


                if(!TextUtils.isEmpty(et.getText())) {

                    Intent inte = new Intent(Main4Activity.this, Main2Activity.class);
                    msg = et.getText().toString();
                    //AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete);
                    String getrec=et.getText().toString();

//Create the bundle
                    Bundle bundle1 = new Bundle();

//Add your data to bundle
                    bundle1.putString("", getrec);

//Add the bundle to the intent
                    inte.putExtras(bundle1);

                    startActivity(inte);
                    Toast.makeText(getApplicationContext(), "welcome "+msg, Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Please enter your name", Toast.LENGTH_SHORT).show();

            }
        });
        /*b1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoView mVideoView2 = (VideoView) findViewById(R.id.videoView1);
// VideoView mVideoView = new VideoView(this);
                String uriPath = "android.resource://com.example.shital.numrush/" + R.raw.movie;
                Uri uri2 = Uri.parse(uriPath);
                mVideoView2.setVideoURI(uri2);
                mVideoView2.requestFocus();
                mVideoView2.start();
            }
        });*/
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.startAnimation(myAni);
                mp.start();
                Intent in = new Intent(Main4Activity.this, Main5Activity.class);
                startActivity(in);
                //AppExit();
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i1.startAnimation(myAni);
                mp.start();
                Intent in = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(in);
                //AppExit();
            }
        });
    }
}
