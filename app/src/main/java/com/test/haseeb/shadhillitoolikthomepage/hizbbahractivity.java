package com.test.haseeb.shadhillitoolikthomepage;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class hizbbahractivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hizbbahractivity);
        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // this is data fro recycler view
        ItemData itemsData[] = { new ItemData("",R.drawable.hb1),
                new ItemData("",R.drawable.hb2),
                new ItemData("",R.drawable.hb3),
                new ItemData("",R.drawable.hb4),
                new ItemData("",R.drawable.hb5),
                new ItemData("",R.drawable.hb6),
                new ItemData("",R.drawable.hb7),
                new ItemData("",R.drawable.hb8),
                new ItemData("",R.drawable.hb9),
                new ItemData("",R.drawable.hb10)


        };

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 3. create an adapter
        bahradapter mAdapter = new bahradapter(itemsData);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.bahr);

        Button playwird = (Button) findViewById(R.id.playwird);
        playwird.performClick();
        playwird.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                mp.start();
            }


        });
        Button pausewird = (Button) findViewById(R.id.pausewird);
        pausewird.performClick();
        pausewird.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                mp.pause();

            }



        });}}