package com.example.shital.numrush;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.media.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import android.widget.ProgressBar;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    ImageView img, wrong, right;
    ProgressBar p, p1;

    int x, y, z, x1, y1, score = 0, z1;
    String[] randOpr = {"+","-","*","/"};
    //int c = 0, q1 = 0, q2 = 0, q3 = 0;
    int c = 0, d = 0, e = 0, f = 0, q1 = 0, q2 = 0, q3 = 0, q4 = 0, q5 = 0, q6 = 0, q7 = 0, q8 = 0, q9 = 0, q10 = 0, q11 = 0, q12 = 0;
    String operator, s1, s2;
    //TextView myTextView;
    //int count=0;
    Button b1, b2, b3, b4, btn7, btn8, btn9, btn10;
    Button[] bu = {b1, b2, b3, b4};
    TextView  times, op, demo, sc;
    int value, v, v1, result;
    Integer[] num = {value, v, v1, result};
    static String getRandom(String[] arr) { // code for getting random operator from *, -. +, /
        Random gen = new Random();
        int rdm = gen.nextInt(arr.length);
        return arr[rdm];
    }
    void resetAllNow(){
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        q1 = 0;
        q2 = 0;
        q3 = 0;
        q4 = 0;
        q5 = 0;
        q6 = 0;
        q7 = 0;
        q8 = 0;
        q9 = 0;
        q10 = 0;
        q11 = 0;
        q12 = 0;

    }


    //main random numbers generation code function
    public void fun(){
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        b1.startAnimation(myAnim);
        b2.startAnimation(myAnim);
        b3.startAnimation(myAnim);
        b4.startAnimation(myAnim);

        display1();
wrong.setVisibility(View.INVISIBLE);
        right.setVisibility(View.INVISIBLE);
        //random value calculate for 4 buttons
        Random rand = new Random();
        value = rand.nextInt(20);
        //  b1.setText(""+value);
        int min = 15;
        int max = 20;
        Random r = new Random();
        v = r.nextInt(max - min + 1) + min;
        //b2.setText(""+v);
        int min1 = 1;
        int max1 = 10;
        Random r1 = new Random();
        v1 = r1.nextInt(max1 - min1 + 1) + min1;
        //b3.setText(""+v1);

        Random rand1 = new Random();
        //  result = rand1.nextInt(10)+1;
        sc = (TextView) findViewById(R.id.score) ;
        // set random operator on screen
        operator = getRandom(randOpr);
        op = (TextView) findViewById(R.id.textView) ;
        op.setText(operator);

        //filelist contains 4 buttons
        ArrayList<Button> fileList = new ArrayList<Button>();
        fileList.add(b1);
        fileList.add(b2);
        fileList.add(b3);
        fileList.add(b4);
        //shuffling buttons
        Collections.shuffle(fileList);
        // calculate result

        //randomly setting numbers to buttons
        ArrayList<Integer> file = new ArrayList<Integer>();
        file.add(value);
        file.add(v);
        file.add(v1);
        // file.add(result);
        Collections.shuffle(file);
        Collections.shuffle(file);
        //String s1 = String.valueOf(num[0])
        int x =  file.get(0);
        int y = file.get(1);
        try {
            if (operator == "+") {
                result = x + y;
            }
            else if (operator == "-") {
                result = x - y;
            }
            else if (operator == "*") {
                result = x * y;
            }
            else if(operator == "/"){
                result = x / y;
            }
        }
        catch (Exception e){
            Log.e("error", e.getMessage());
        }

        fileList.get(0).setText(file.get(0).toString());
        fileList.get(1).setText(file.get(1).toString());
        fileList.get(2).setText(file.get(2).toString());
        fileList.get(3).setText(""+result);

    }//function fun() ends here.


/*public void test(){
   final Handler handler = new Handler();
    Timer t = new Timer();
    t.schedule(new TimerTask() {
        @Override
        public void run() {
            handler.post(new Runnable(){
                @Override
                public void run() {
                    fun();

                }
            });
        }
    },5000);
}*/
public void correct(){
    final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
    MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
    myAnim.setInterpolator(interpolator);
    btn7.startAnimation(myAnim);
    btn8.startAnimation(myAnim);
    btn9.startAnimation(myAnim);

    right.setVisibility(View.VISIBLE);
    final MediaPlayer m = MediaPlayer.create(this, R.raw.crct);
    m.start();
}
    public void incorrect(){
        wrong.setVisibility(View.VISIBLE);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        wrong.startAnimation(myAnim);

        final MediaPlayer m1 = MediaPlayer.create(this, R.raw.inco);
        m1.start();
    }
public void display(){

    new CountDownTimer(1000, 1000) { // 5000 = 5 sec

        public void onTick(long millisUntilFinished) {
            wrong.setImageResource(R.drawable.wrong_50_1_50);
        }

        public void onFinish() {
            wrong.setVisibility(View.INVISIBLE);
        }
    }.start();
}

    public void display1(){

        new CountDownTimer(1000, 1000) { // 5000 = 5 sec

            public void onTick(long millisUntilFinished) {
                right.setImageResource(R.drawable.r3_50);
            }

            public void onFinish() {
                wrong.setVisibility(View.INVISIBLE);
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        img = (ImageView) findViewById(R.id.imageButton6);
        final Animation myAni = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolato = new MyBounceInterpolator(0.2, 20);
        myAni.setInterpolator(interpolato);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.strt);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp1.start();
                img.startAnimation(myAni);
                //Toast.makeText(getApplicationContext(),"game started", Toast.LENGTH_SHORT);
                Intent inte = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(inte);
            }
        });

        btn7= (Button) findViewById(R.id.button7);
        btn8= (Button) findViewById(R.id.button8);
        btn9= (Button) findViewById(R.id.button6);
       //btn10 = (Button) findViewById(R.id.button9);
        b2= (Button) findViewById(R.id.button3);
        b1= (Button) findViewById(R.id.button2);
        b3= (Button) findViewById(R.id.button4);
        b4= (Button) findViewById(R.id.button5);
        p = (ProgressBar) findViewById(R.id.progressbar);
        p1 = (ProgressBar ) findViewById(R.id.circularProgressBar);
        demo = (TextView) findViewById(R.id.textView15);
       wrong = (ImageView) findViewById(R.id.imageView4);
        right = (ImageView) findViewById(R.id.imageView2);


        // setting a score
        Bundle bundle1 = getIntent().getExtras();

//Extract the data…
        String stuff = bundle1.getString("");
        demo.setText(stuff);

        fun();


        // setting onclicklisteners
        b1.setOnClickListener(this);
        b4.setOnClickListener(this);

        b3.setOnClickListener(this);
        b2.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);









        // the timer
        times = (TextView) findViewById(R.id.timers);
        times.setText("00:02:00");
        // A timer of 60 seconds to play for, with an interval of 1 second (1000 milliseconds)
        p.setProgress(100);
        CounterClass timer = new CounterClass(60000, 1000);
        p1.setProgress(100);
        timer.start();




    }
    public class CounterClass extends CountDownTimer { //class for time calculation

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }
        @Override

        public void onFinish() {
            Intent inte = new Intent(Main2Activity.this, Main3Activity.class);
            startActivity(inte);
            p.setProgress(0);
            times.setText("Time is up");
            Intent i = new Intent(Main2Activity.this, Main3Activity.class);
            //AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete);
            String getrec=sc.getText().toString();

//Create the bundle
            Bundle bundle = new Bundle();

//Add your data to bundle
            bundle.putString("", getrec);

//Add the bundle to the intent
            i.putExtras(bundle);

//Fire that second activity
            startActivity(i);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            int progress = (int) (millisUntilFinished/600);
            p.setProgress(progress);
            p1.setProgress(progress);
            // TODO Auto-generated method stub
            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);
            //textCounter.setText(String.valueOf(millisUntilFinished));

        }
    }

    @Override
    public void onClick(View vi) { // onclick action
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.clk);
        mp.start();
        switch (vi.getId()) {
// setting values to above 3 buttons
            case R.id.button2:
                // do your code

                final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                b1.startAnimation(myAnim);

                c++;

               // final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
                //b1.startAnimation(myAnim);
                if(c == 1) {
                    int temp = Integer.parseInt(b1.getText().toString()) ;
                    if (TextUtils.isEmpty(btn7.getText())) {
                        btn7.setText(b1.getText());
                        //b1.setBackgroundColor(Color.GRAY);
                        q1 = 1;

                    } else if (TextUtils.isEmpty(btn8.getText())) {
                        if(operator == "/" && temp == 0){
                            btn8.setText("");
                            break;
                        }
                        btn8.setText(b1.getText());
                        //b1.setBackgroundColor(Color.GRAY);
                        q2 = 1;

                    } else {
                        btn9.setText(b1.getText());
                        //b1.setBackgroundColor(Color.GRAY);
                        //btn10.setText(b1.getText());
                        q3 = 1;
                        x1 = Integer.parseInt(btn7.getText().toString());
                        y1 = Integer.parseInt(btn8.getText().toString());
                        z = Integer.parseInt(btn9.getText().toString());
                        if (operator == "+") {
                            z1 = x1 + y1;
                            if (z == z1) {
                                correct();
                                display1();
                                score++;
                                sc.setText("" + score);

                                resetAllNow();
                                btn7.setText("");
                                btn8.setText("");
                                //test();
                                fun();
                                btn9.setText("");

                            } else {
                                incorrect();
                                resetAllNow();
                                display();
                                btn7.setText("");
                                btn8.setText("");
                                btn9.setText("");
                            }

                            //btn9.setText("" + z);
                        } else if (operator == "-") {
                            z1 = x1 - y1;
                            if (z == z1) {
                                correct();
                                display1();
                                score++;
                                sc.setText("" + score);
                                resetAllNow();
                                btn7.setText("");
                                btn8.setText("");
                                //test();
                                fun();
                                btn9.setText("");
                            } else {
                                incorrect();
                                resetAllNow();
                                display();
                                btn7.setText("");
                                btn8.setText("");
                                btn9.setText("");
                            }

                        } else if (operator == "*") {
                            z1 = x1 * y1;
                            if (z == z1) {
                                score++;
                                correct();
                                display1();
                                sc.setText("" + score);
                                resetAllNow();

                                btn7.setText("");
                                btn8.setText("");
                               // test();
                                fun();
                                btn9.setText("");
                            } else {
                                incorrect();
                                btn9.setHighlightColor(204);
                                resetAllNow();
                                display();
                                btn7.setText("");
                                btn8.setText("");
                                btn9.setText("");
                            }

                        } else {
                            z1 = x1 / y1;
                            if (z == z1) {
                                correct();
                                display1();
                                score++;
                                sc.setText("" + score);
                                resetAllNow();
                                btn7.setText("");
                                btn8.setText("");
                                //test();
                                fun();
                                btn9.setText("");
                            } else {
                                incorrect();
                                btn9.setHighlightColor(204);
                                resetAllNow();
                                display();
                                btn7.setText("");
                                btn8.setText("");
                                btn9.setText("");
                            }

                        }
                    }
              }else if (c == 2){
                    c = 0;
                    if(q1 == 1){
                        q1 = 0;
                        btn7.setText("");
                    }
                    else if(q2 == 1){
                        q2 = 0;
                        btn8.setText("");
                    }
                    else if(q3 == 1){
                        q3 = 0;
                        btn9.setText("");
                    }
                  //  c = 0;

                }
                break;

            case R.id.button5:
               // final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.clk);
              ///  mp1.start();
                final Animation myAnim1 = AnimationUtils.loadAnimation(this, R.anim.bounce);
                MyBounceInterpolator interpolator1 = new MyBounceInterpolator(0.2, 20);
                myAnim1.setInterpolator(interpolator1);
                b4.startAnimation(myAnim1);
                d++;
                int temp1 = Integer.parseInt(b4.getText().toString()) ;
                if (d == 1) {
                // do your code
                if(TextUtils.isEmpty(btn7.getText())){
                    btn7.setText(b4.getText());
                    q4 = 1;
                }
                else if (TextUtils.isEmpty(btn8.getText())){
                    if(operator == "/" && temp1 == 0){
                        btn8.setText("");
                        break;
                    }
                    btn8.setText(b4.getText());
                    q5 = 1;
                }
                else{
                    btn9.setText(b4.getText());
                    q6 = 1;
                    x1 = Integer.parseInt(btn7.getText().toString());
                    y1 = Integer.parseInt(btn8.getText().toString());
                    z = Integer.parseInt(btn9.getText().toString());
                    if (operator == "+") {
                        z1 = x1 + y1;
                        if(z == z1){
                            correct();
                            display1();
                            score++;
                            sc.setText(""+score);
                            resetAllNow();

                            btn7.setText("");
                            btn8.setText("");
                           // test();
                            fun();
                            btn9.setText("");
                        }
                        else{
                            incorrect();
                            resetAllNow();
                            display();
                            btn7.setText("");
                            btn8.setText("");
                            btn9.setText("");
                        }


                    } else if (operator == "-") {
                        z1 = x1 - y1;
                        if(z == z1){
                            correct();
                            display1();
                            score++;
                            sc.setText(""+score);
                            resetAllNow();

                            btn7.setText("");
                            btn8.setText("");
//test();
                            fun();
                            btn9.setText("");

                        }
                        else{
                            incorrect();
                            btn9.setHighlightColor(204);
                            resetAllNow();
                            display();
                            btn7.setText("");
                            btn8.setText("");
                            btn9.setText("");
                        }
                        //btn9.setText("" + z);
                    } else if (operator == "*") {
                        z1 = x1 * y1;
                        if(z == z1){
                            correct();
                            display1();
                            score++;
                            sc.setText(""+score);
                            resetAllNow();

                            btn7.setText("");
                            btn8.setText("");
//test();
                            fun();
                            btn9.setText("");
                        }
                        else{
                            incorrect();
                            btn9.setHighlightColor(204);
                            resetAllNow();
                            display();
                            btn7.setText("");
                            btn8.setText("");
                            btn9.setText("");
                        }

                    } else {
                        z1 = x1 / y1;
                        if(z == z1){
                            correct();
                            display1();
                            score++;
                            sc.setText(""+score);
                            resetAllNow();

                            btn7.setText("");
                            btn8.setText("");
//test();
                            fun();
                            btn9.setText("");
                            //btn9.setBackgroundColor(153);
                        }
                        else{
                            incorrect();
                            btn9.setHighlightColor(204);
                            resetAllNow();
                            display();
                            btn7.setText("");
                            btn8.setText("");
                            btn9.setText("");
                        }

                    }
                }
                } else if(d == 2){
                    if(q4 == 1){
                        q4 = 0;
                        btn7.setText("");
                    }
                    else if(q5 == 1){
                        q5 = 0;
                        btn8.setText("");
                    }
                    else if(q6 == 1){
                        q6 = 0;
                        btn9.setText("");
                    }
                    d = 0;

                }
                break;

            case R.id.button4:
              //  final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.clk);
              //  mp2.start();
                final Animation myAnim2 = AnimationUtils.loadAnimation(this, R.anim.bounce);
                MyBounceInterpolator interpolator2 = new MyBounceInterpolator(0.2, 20);
                myAnim2.setInterpolator(interpolator2);
                b3.startAnimation(myAnim2);
                e++;
                int temp2 = Integer.parseInt(b3.getText().toString()) ;
                if(e == 1) {
                if(TextUtils.isEmpty(btn7.getText())){
                    btn7.setText(b3.getText());
                    //demo = (TextView)findViewById(R.id.textView6);
                    //demo.setText(b3.getText());
                    q7 = 1;
                }
                else if (TextUtils.isEmpty(btn8.getText())){
                    if(operator == "/" && temp2 == 0){
                        btn8.setText("");
                        break;
                    }
                    btn8.setText(b3.getText());
                    //demo = (TextView)findViewById(R.id.textView6);
                    //demo.setText(b3.getText());
                    q8 = 1;

                }
                else{
                    btn9.setText(b3.getText());
                    q9 = 1;
                    x1 = Integer.parseInt(btn7.getText().toString());
                    y1 = Integer.parseInt(btn8.getText().toString());
                    z = Integer.parseInt(btn9.getText().toString());
                    if (operator == "+") {
                        z1 = x1 + y1;
                        if(z == z1){
                            correct();
                            display1();
                            score++;
                            sc.setText(""+score);
                            resetAllNow();

                            btn7.setText("");
                            btn8.setText("");
//test();
                            fun();
                            btn9.setText("");
                        }
                        else{
                            incorrect();
                            btn9.setHighlightColor(204);
                            resetAllNow();
                            display();
                            btn7.setText("");
                            btn8.setText("");
                            btn9.setText("");
                        }


                    } else if (operator == "-") {
                        z1 = x1 - y1;
                        if(z == z1){
                            correct();
                            display1();
                            score++;
                            sc.setText(""+score);
                            resetAllNow();

                            btn7.setText("");
                            btn8.setText("");
//test();
                            fun();
                            btn9.setText("");
                            //btn9.setBackgroundColor(153);
                        }
                        else{
                            incorrect();
                            btn9.setHighlightColor(204);
                            resetAllNow();
                            display();
                            btn7.setText("");
                            btn8.setText("");
                            btn9.setText("");
                        }
                        //btn9.setText("" + z);
                    } else if (operator == "*") {
                        z1 = x1 * y1;
                        if(z == z1){
                            correct();
                            display1();
                            score++;
                            sc.setText(""+score);
                            resetAllNow();

                            btn7.setText("");
                            btn8.setText("");
//test();
                            fun();
                            btn9.setText("");
                        }
                        else{
                            incorrect();
                            btn9.setHighlightColor(204);
                            resetAllNow();
                            display();
                            btn7.setText("");
                            btn8.setText("");
                            btn9.setText("");
                        }
                        //btn9.setText("" + z);
                    } else {
                        z1 = x1 / y1;
                        if(z == z1){
                            correct();
                            display1();
                            score++;
                            sc.setText(""+score);
                            resetAllNow();

                            btn7.setText("");
                            btn8.setText("");
//test();
                            fun();
                            btn9.setText("");
                            //btn9.setBackgroundColor(153);
                        }
                        else{
                            incorrect();
                            btn9.setHighlightColor(204);
                            resetAllNow();
                            display();
                            btn7.setText("");
                            btn8.setText("");
                            btn9.setText("");
                        }
                        //btn9.setText("" + z);
                    }
                }
                }else if(e == 2){
                    if(q7 == 1){
                        q7 = 0;
                        btn7.setText("");
                    }
                    else if(q8 == 1){
                        q8 = 0;
                        btn8.setText("");
                    }
                    else if(q9 == 1){
                        q9 = 0;
                        btn9.setText("");
                    }
                    e = 0;
                }
                break;

            case R.id.button3:
                //final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.clk);
                //mp3.start();
                final Animation myAnim3 = AnimationUtils.loadAnimation(this, R.anim.bounce);
                MyBounceInterpolator interpolator3 = new MyBounceInterpolator(0.2, 20);
                myAnim3.setInterpolator(interpolator3);
                b2.startAnimation(myAnim3);
                f++;
                int temp3 = Integer.parseInt(b2.getText().toString()) ;
                if(f == 1) {
                // do your code
                if(TextUtils.isEmpty(btn7.getText())){
                    btn7.setText(b2.getText());
                    q10 = 1;
                }
                else if (TextUtils.isEmpty(btn8.getText())){
                    if(operator == "/" && temp3 == 0){
                        btn8.setText("");
                        break;
                    }
                    btn8.setText(b2.getText());
                    q11 = 1;

                }
                else{
                    btn9.setText(b2.getText());
                    q12 = 1;
                    x1 = Integer.parseInt(btn7.getText().toString());
                    y1 = Integer.parseInt(btn8.getText().toString());
                    z = Integer.parseInt(btn9.getText().toString());
                    if (operator == "+") {
                        z1 = x1 + y1;
                        if(z == z1){
                            correct();
                            display1();
                            score++;
                            sc.setText(""+score);
                            resetAllNow();

                            btn7.setText("");
                            btn8.setText("");
//test();
                            fun();
                            btn9.setText("");
                            //btn9.setBackgroundColor(153);
                        }
                        else{
                            incorrect();
                            btn9.setHighlightColor(204);
                            resetAllNow();
                            display();
                            btn7.setText("");
                            btn8.setText("");
                            btn9.setText("");
                        }

                        //btn9.setText("" + z);
                    } else if (operator == "-") {
                        z1 = x1 - y1;
                        if(z == z1){
                            correct();
                            display1();
                            score++;
                            sc.setText(""+score);
                            resetAllNow();

                            btn7.setText("");
                            btn8.setText("");
//test();
                            fun();
                            btn9.setText("");
                            //btn9.setBackgroundColor(153);
                        }
                        else{
                            incorrect();
                            btn9.setHighlightColor(204);
                            resetAllNow();
                            display();
                            btn7.setText("");
                            btn8.setText("");
                            btn9.setText("");
                        }
                        //btn9.setText("" + z);
                    } else if (operator == "*") {
                        z1 = x1 * y1;
                        if(z == z1){
                            correct();
                            display1();
                            score++;
                            sc.setText(""+score);
                            resetAllNow();

                            btn7.setText("");
                            btn8.setText("");
//test();
                            fun();
                            btn9.setText("");
                            //btn9.setBackgroundColor(153);
                        }
                        else{
                            incorrect();
                            btn9.setHighlightColor(204);
                            resetAllNow();
                            display();
                            btn7.setText("");
                            btn8.setText("");
                            btn9.setText("");
                        }
                        //btn9.setText("" + z);
                    } else {
                        z1 = x1 / y1;
                        if(z == z1){
                            correct();
                            display1();
                            score++;
                            sc.setText(""+score);
                            resetAllNow();
                            btn7.setText("");
                            btn8.setText("");
//test();
                            fun();
                            btn9.setText("");
                            //btn9.setBackgroundColor(153);
                        }
                        else{
                            incorrect();
                            btn9.setHighlightColor(204);
                            resetAllNow();
                            display();
                            btn7.setText("");
                            btn8.setText("");
                            btn9.setText("");
                        }
                        //btn9.setText("" + z);
                    }
                }
                }else if(f == 2){
                    if(q10 == 1){
                        q10 = 0;
                        btn7.setText("");
                    }
                    else if(q11 == 1){
                        q11 = 0;
                        btn8.setText("");
                    }
                    else if(q12 == 1){
                        q12 = 0;
                        btn9.setText("");
                    }
                    f = 0;
                }
                break;
            case R.id.button7:
                //final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.clk);
               // mp4.start();
                final Animation myAnim4 = AnimationUtils.loadAnimation(this, R.anim.bounce);
                MyBounceInterpolator interpolator4 = new MyBounceInterpolator(0.2, 20);
                myAnim4.setInterpolator(interpolator4);
                btn7.startAnimation(myAnim4);
                if(!(TextUtils.isEmpty(btn7.getText()))) {
                    btn7.setText("");
                }
                break;
            case R.id.button8:
              //  final MediaPlayer mp5 = MediaPlayer.create(this, R.raw.clk);
              //  mp5.start();
                final Animation myAnim5 = AnimationUtils.loadAnimation(this, R.anim.bounce);
                MyBounceInterpolator interpolator5 = new MyBounceInterpolator(0.2, 20);
                myAnim5.setInterpolator(interpolator5);
                btn8.startAnimation(myAnim5);
                if(!(TextUtils.isEmpty(btn8.getText()))) {
                    btn8.setText("");
                }
                break;
            case R.id.button6:
              //  final MediaPlayer mp6 = MediaPlayer.create(this, R.raw.clk);
              //  mp6.start();
                final Animation myAnim6 = AnimationUtils.loadAnimation(this, R.anim.bounce);
                MyBounceInterpolator interpolator6 = new MyBounceInterpolator(0.2, 20);
                myAnim6.setInterpolator(interpolator6);
                btn9.startAnimation(myAnim6);
                            btn9.setText("");
                            btn7.setText("");
                            btn8.setText("");
                           // resetAllNow();
                break;
            default:
                break;
        }


    }
}
