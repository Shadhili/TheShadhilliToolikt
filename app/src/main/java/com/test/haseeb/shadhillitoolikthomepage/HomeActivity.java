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

public class HomeActivity extends ActionBarActivity { /* When using Appcombat support library
                                                         you need to extend Main Activity to
                                                         ActionBarActivity.
                                                      */


    private Toolbar toolbar;                              // Declaring the Toolbar Object


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);                   // Setting toolbar as the ActionBar with setSupportActionBar() call





        String[] Features = {"Awrad", "Reminders", "Introduction to the Shadhili Way", "The Shadhili Chain", "Biography of Imam Hasan As-Shadhili", "Feedback"};

        ListAdapter theAdapter = new MyAdapter(this, Features);
        ListView homelist  = (ListView) findViewById(R.id.homelist);
        homelist.setAdapter(theAdapter);
        homelist.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                                                    @Override
                                                    public void onItemClick(AdapterView<?> AdapterView, View view, int position, long id) {

                                                        if (position == 0)
                                                        {
                                                            Intent myIntent = new Intent(getApplicationContext(), DhikrActivity.class);
                                                            startActivity(myIntent);
                                                        }






                                                    }
                                                });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
