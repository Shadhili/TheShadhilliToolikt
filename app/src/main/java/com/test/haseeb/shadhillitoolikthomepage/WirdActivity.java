package com.test.haseeb.shadhillitoolikthomepage;


import android.app.Activity;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

public class WirdActivity extends Activity {

MediaPlayer mp;
    String[] Arabic;
    String[] Transliteration;
    String[] Translation;
    String[] Number;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wird);
        Resources res=getResources();
        Arabic=res.getStringArray(R.array.wirdarabic);
        Transliteration=res.getStringArray(R.array.wirdtransliteration);
        Translation=res.getStringArray(R.array.wirdtranslation);
        Number=res.getStringArray(R.array.wirdnumber);





        mp = MediaPlayer.create(this, R.raw.wird);



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


        });


        ListAdapter theAdapter = new Wirdadapter(this, Arabic, Transliteration, Translation, Number);
        final ListView wirdlist  = (ListView) findViewById(R.id.wirdlist);
        wirdlist.setAdapter(theAdapter);






        }

    @Override
    protected void onDestroy() {


        super.onDestroy();
        mp.stop();

    }



}







