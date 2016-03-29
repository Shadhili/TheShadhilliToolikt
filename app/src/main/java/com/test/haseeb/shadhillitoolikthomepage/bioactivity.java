package com.test.haseeb.shadhillitoolikthomepage;


import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class bioactivity extends AppCompatActivity {

    String[] Biography;
    public int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);
        Resources res = getResources();
        Biography = res.getStringArray(R.array.chapters);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        myToolbar.setSubtitle("The Founder of the Shadhili Way");

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListAdapter theAdapter = new bioadapter2(this, Biography);
        final ListView wirdlist = (ListView) findViewById(R.id.biolist);
        wirdlist.setAdapter(theAdapter);
        registerForContextMenu(wirdlist);
        ListAdapter listAdapter = wirdlist.getAdapter();

        ImageView a = new ImageView(this);
        a.setImageResource(R.drawable.bio1);
        wirdlist.addHeaderView(a, null, false);
        a.setScaleType(ImageView.ScaleType.FIT_START);
        a.setAdjustViewBounds(true);

        ImageView b = new ImageView(this);
        b.setImageResource(R.drawable.gmsbtn);
        wirdlist.addFooterView(b);
        b.setScaleType(ImageView.ScaleType.FIT_START);
        b.setAdjustViewBounds(true);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("http://www.greenmountainschool.org"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });


        wirdlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> AdapterView, View view, int position, long id) {


                if (position == 1) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc1.class);
                    startActivity(myIntent);
                }
                if (position == 2) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc2.class);
                    startActivity(myIntent);
                }
                if (position == 3) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc3.class);
                    startActivity(myIntent);
                }
                if (position == 4) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc4.class);
                    startActivity(myIntent);
                }
                if (position == 5) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc5.class);
                    startActivity(myIntent);
                }
                if (position == 6) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc6.class);
                    startActivity(myIntent);
                }
                if (position == 7) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc7.class);
                    startActivity(myIntent);
                }
                if (position == 8) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc8.class);
                    startActivity(myIntent);
                }
                if (position == 9) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc9.class);
                    startActivity(myIntent);
                }
                if (position == 10) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc10.class);
                    startActivity(myIntent);
                }
                if (position == 11) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc11.class);
                    startActivity(myIntent);
                }
                if (position == 12) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc12.class);
                    startActivity(myIntent);
                }
                if (position == 13) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc13.class);
                    startActivity(myIntent);
                }
                if (position == 14) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc14.class);
                    startActivity(myIntent);
                }
                if (position == 15) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc15.class);
                    startActivity(myIntent);
                }
                if (position == 16) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc16.class);
                    startActivity(myIntent);
                }
                if (position == 17) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc17.class);
                    startActivity(myIntent);
                }
                if (position == 18) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc18.class);
                    startActivity(myIntent);
                }
                if (position == 19) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc19.class);
                    startActivity(myIntent);
                }
                if (position == 20) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc20.class);
                    startActivity(myIntent);
                }
                if (position == 21) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc21.class);
                    startActivity(myIntent);
                }
                if (position == 22) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc22.class);
                    startActivity(myIntent);
                }
                if (position == 23) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc23.class);
                    startActivity(myIntent);
                }
                if (position == 24) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc24.class);
                    startActivity(myIntent);
                }
                if (position == 25) {
                    Intent myIntent = new Intent(getApplicationContext(), bioactivityc25.class);
                    startActivity(myIntent);
                }


            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent parentIntent1 = new Intent(this,DhikrActivity.class);
            startActivity(parentIntent1);

        }
        return super.onOptionsItemSelected(item);
    }


    }