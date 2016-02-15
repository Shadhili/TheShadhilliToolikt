package com.test.haseeb.shadhillitoolikthomepage;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;


public class DhikrActivity extends AppCompatActivity {

    private Toolbar toolbar;                              // Declaring the Toolbar Object
    String[] Titles;
    String[] Subtitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhikr);
        Resources res=getResources();
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setSubtitle("Litanies of the Shadhili Way");

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Titles = res.getStringArray(R.array.dhikrtitles);
        Subtitles = res.getStringArray(R.array.dhikrsubtitles);

        ListAdapter theAdapter = new DhikrAdapter(this, Titles, Subtitles);
        final ListView dhikrlist  = (ListView) findViewById(R.id.dhikrlist);
        dhikrlist.setAdapter(theAdapter);
        dhikrlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> AdapterView, View view, int position, long id) {


                if (position == 0) {
                    Intent myIntent = new Intent(getApplicationContext(), latifactivity.class);
                    startActivity(myIntent);
                }
                if (position == 1) {
                    Intent myIntent = new Intent(getApplicationContext(), WirdActivity.class);
                    startActivity(myIntent);
                }
                if (position == 2) {
                    Intent myIntent = new Intent(getApplicationContext(), hasbunallahactivity.class);
                    startActivity(myIntent);
                }
                if (position == 3) {
                    Intent myIntent = new Intent(getApplicationContext(), hizbbahractivity.class);
                    startActivity(myIntent);
                }
                if (position == 4) {
                    Intent myIntent = new Intent(getApplicationContext(), nasractivity.class);
                    startActivity(myIntent);
                }
                if (position == 5) {
                    Intent myIntent = new Intent(getApplicationContext(), mashishactivity.class);
                    startActivity(myIntent);
                }
                if (position == 6) {
                    Intent myIntent = new Intent(getApplicationContext(), yaqoutiyaactivity.class);
                    startActivity(myIntent);
                }

            }
        });

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id == android.R.id.home) {
            Intent parentIntent1 = new Intent(this,DhikrActivity.class);
            startActivity(parentIntent1);


        }

        return super.onOptionsItemSelected(item);

    }


}

