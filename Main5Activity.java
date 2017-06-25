package com.example.shital.numrush;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.VideoView;

public class Main5Activity extends AppCompatActivity {
    VideoView v;
    ImageView i, i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main5);
        i = (ImageView)findViewById(R.id.imageView5) ;
        i1 = (ImageView)findViewById(R.id.imageView6) ;
        v = (VideoView) findViewById(R.id.videoView1);String uriPath2 = "android.resource://com.example.shital.numrush/"+R.raw.newgame;
        Uri uri2 = Uri.parse(uriPath2);
        v.setVideoURI(uri2);
        v.requestFocus();
        v.start();
        final Animation myAni = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolato = new MyBounceInterpolator(0.2, 20);
        myAni.setInterpolator(interpolato);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.st);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.strt);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.startAnimation(myAni);
                VideoView mVideoView2 = (VideoView) findViewById(R.id.videoView1);
// VideoView mVideoView = new VideoView(this);
                String uriPath = "android.resource://com.example.shital.numrush/" + R.raw.newgame;
                Uri uri2 = Uri.parse(uriPath);
                mVideoView2.setVideoURI(uri2);
                mVideoView2.requestFocus();
                mVideoView2.start();
                mp.start();
                //Intent inte = new Intent(Main3Activity.this, Main2Activity.class);
                //startActivity(inte);
               // AppExit();
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i1.startAnimation(myAni);
                mp.start();
                Intent inte = new Intent(Main5Activity.this, Main4Activity.class);
                startActivity(inte);
                //AppExit();
            }
        });
    }


}
