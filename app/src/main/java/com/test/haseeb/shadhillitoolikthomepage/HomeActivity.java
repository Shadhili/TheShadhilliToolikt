package com.test.haseeb.shadhillitoolikthomepage;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class HomeActivity extends ActionBarActivity { /* When using Appcombat support library
                                                         you need to extend Main Activity to
                                                         ActionBarActivity.
                                                      */


    private Toolbar toolbar;                              // Declaring the Toolbar Object
    String[] Titles;
    String[] Subtitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);                   // Setting toolbar as the ActionBar with setSupportActionBar() call
        Resources res=getResources();





        Titles = res.getStringArray(R.array.hometitles);
        Subtitles = res.getStringArray(R.array.homesubtitles);

        ListAdapter theAdapter = new MyAdapter(this, Titles, Subtitles);
        ListView homelist  = (ListView) findViewById(R.id.homelist);
        homelist.setAdapter(theAdapter);
        homelist.setOnItemClickListener( new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> AdapterView, View view, int position, long id) {
        if (position == 0)
            {Intent myIntent = new Intent(getApplicationContext(), DhikrActivity.class);
            startActivity(myIntent);}
        if (position == 1)
            {Intent myIntent = new Intent(getApplicationContext(), introductionactivity.class);
            startActivity(myIntent);}
        if (position == 2)
        {Intent myIntent = new Intent(getApplicationContext(), bioactivity.class);
            startActivity(myIntent);}
        if (position == 3)
            {Intent myIntent = new Intent(getApplicationContext(), shadhilichainactivity.class);
            startActivity(myIntent);}
        if (position == 4)
            {Intent myIntent = new Intent(getApplicationContext(), MyPreferenceActivity.class);
                startActivity(myIntent);}
        if (position == 5)
            {Intent myIntent = new Intent(getApplicationContext(), extrasactivity.class);
            startActivity(myIntent);}
        if (position == 6)
            {Intent myIntent = new Intent(getApplicationContext(), feedbackactivity.class);
            startActivity(myIntent);}
                }
                });

    }







}
