package com.test.haseeb.shadhillitoolikthomepage;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class yaqoutiyaactivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yaqoutiya);
        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // this is data fro recycler view
        ItemData itemsData[] = { new ItemData("",R.drawable.y1),
                new ItemData("",R.drawable.y2),
                new ItemData("",R.drawable.y3),
                new ItemData("",R.drawable.y4),
                new ItemData("",R.drawable.y5),
                new ItemData("",R.drawable.y6),
                new ItemData("",R.drawable.y7),
                new ItemData("",R.drawable.y8)

        };

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 3. create an adapter
        yaqoutiyaadapter mAdapter = new yaqoutiyaadapter(itemsData);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.yaqoutiya);

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



        });}}