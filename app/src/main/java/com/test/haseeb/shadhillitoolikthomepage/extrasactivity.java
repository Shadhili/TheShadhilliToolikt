package com.test.haseeb.shadhillitoolikthomepage;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class extrasactivity extends AppCompatActivity {

    String[] Titles;
    String[] Subtitles;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras);
        Resources res = getResources();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        myToolbar.setSubtitle("Extra Features");

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        Titles = res.getStringArray(R.array.extratitles);
        Subtitles = res.getStringArray(R.array.extrasubtitles);

        ListAdapter theAdapter = new MyAdapter(this, Titles, Subtitles);
        ListView homelist  = (ListView) findViewById(R.id.extralist);
        homelist.setAdapter(theAdapter);
        homelist.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> AdapterView, View view, int position, long id) {
                if (position == 0)
                {Intent myIntent = new Intent(getApplicationContext(), ismjalaalactivity.class);
                    startActivity(myIntent);}

            }

    });}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent parentIntent1 = new Intent(this,HomeActivity.class);
            startActivity(parentIntent1);

        }
        return super.onOptionsItemSelected(item);
    }



}