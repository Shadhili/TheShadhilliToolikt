package com.test.haseeb.shadhillitoolikthomepage;


import android.app.Activity;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class WirdActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wird);

        TextView tv=(TextView)findViewById(R.id.wirdtext);

        tv.setMovementMethod(new ScrollingMovementMethod());

        Typeface tf = ArabicUtilities.face;
        tv.setTypeface(tf);



        final MediaPlayer mp = MediaPlayer.create(this, R.raw.wird);

        Button playwird = (Button) findViewById(R.id.playwird);
        playwird.performClick();
        playwird.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                mp.start();
            }


        });
        ImageButton pausewird = (ImageButton) findViewById(R.id.pausewird);

        pausewird.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                mp.pause();

            }



        });}}