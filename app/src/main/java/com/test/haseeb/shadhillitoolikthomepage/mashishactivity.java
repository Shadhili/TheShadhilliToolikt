package com.test.haseeb.shadhillitoolikthomepage;


import android.app.Activity;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class mashishactivity extends Activity {

    MediaPlayer mp;
    String[] Arabic;
    String[] Transliteration;
    String[] Translation;
    String[] Number;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mashish);
        Resources res=getResources();
        Arabic=res.getStringArray(R.array.mashisharabic);
        Transliteration=res.getStringArray(R.array.mashishtransliteration);
        Translation=res.getStringArray(R.array.mashishtranslation);
        LayoutInflater mInflater = getLayoutInflater();
        final View mLayout = mInflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));
        final TextView mText = (TextView) mLayout.findViewById(R.id.toast_text);





        mp = MediaPlayer.create(this, R.raw.mashish);



        Button playwird = (Button) findViewById(R.id.playwird);
        playwird.performClick();
        playwird.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                mp.start();
                Toast mToast = new Toast(getApplicationContext());
                mText.setText("Playing");
                mToast.setDuration(Toast.LENGTH_SHORT);
                mToast.setView(mLayout);
                mToast.show();
            }


        });
        ImageButton pausewird = (ImageButton) findViewById(R.id.pausewird);

        pausewird.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                mp.pause();
                Toast mToast = new Toast(getApplicationContext());
                mText.setText("Paused");
                mToast.setDuration(Toast.LENGTH_SHORT);
                mToast.setView(mLayout);
                mToast.show();
            }


        });


        ListAdapter theAdapter = new mashishadapter(this, Arabic, Transliteration, Translation);
        final ListView mashishlist  = (ListView) findViewById(R.id.mashishlist);
        mashishlist.setAdapter(theAdapter);






    }

    @Override
    protected void onDestroy() {


        super.onDestroy();
        mp.stop();

    }



}







