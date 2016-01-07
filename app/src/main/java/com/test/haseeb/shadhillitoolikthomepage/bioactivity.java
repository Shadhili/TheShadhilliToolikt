package com.test.haseeb.shadhillitoolikthomepage;


import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class bioactivity extends Activity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);
        Resources res=getResources();

        final TextView bioText = (TextView) findViewById(R.id.biocontent);
        Typeface font2 = Typeface.createFromAsset(getAssets(),"fonts/JaghbUni-Rom.ttf");
        bioText.setTypeface(font2);






    }




}







