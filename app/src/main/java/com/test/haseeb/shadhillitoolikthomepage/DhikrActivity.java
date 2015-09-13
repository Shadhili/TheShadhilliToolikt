package com.test.haseeb.shadhillitoolikthomepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;


public class DhikrActivity extends ActionBarActivity {

    private Toolbar toolbar;                              // Declaring the Toolbar Object


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhikr);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);                   // Setting toolbar as the ActionBar with setSupportActionBar() call




        final String[] Features = {"Wird ul 'Aam", "Hizb ul Bahr", "Hizb ul Nasr", "HasbunAllaah", "Dalail al Khayrat", "Astaghfar", "Selawat", "Tahlil"};

        ListAdapter theAdapter = new DhikrAdapter(this, Features);
        final ListView dhikrlist  = (ListView) findViewById(R.id.dhikrlist);
        dhikrlist.setAdapter(theAdapter);
        dhikrlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> AdapterView, View view, int position, long id) {


                if (position == 0) {
                    Intent myIntent = new Intent(getApplicationContext(), WirdActivity.class);
                    startActivity(myIntent);
                }


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dhikr, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }


}

