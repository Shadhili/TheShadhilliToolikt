package com.test.haseeb.shadhillitoolikthomepage;


import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

public class shadhilichainactivity extends Activity {

    String[] Arabic;
    String[] Translation;
    int[] headerimg = {R.drawable.schead};
    int[] footerimg = {R.drawable.scfooter};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadhilichain);
        Resources res=getResources();
        Arabic=res.getStringArray(R.array.shadhilichainarabic);
        Translation = res.getStringArray(R.array.shadhilichainenglish);

        ListAdapter theAdapter = new shadhilichainadapter(this, Arabic, Translation, headerimg, footerimg);
        final ListView mylist  = (ListView) findViewById(R.id.shadhilichainlist);
        View header = getLayoutInflater().inflate(R.layout.header, null);
        View footer = getLayoutInflater().inflate(R.layout.footer, null);
        mylist.addHeaderView(header);
        mylist.addFooterView(footer);
        mylist.setAdapter(theAdapter);
    }




}







