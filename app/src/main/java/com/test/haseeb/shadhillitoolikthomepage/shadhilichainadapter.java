package com.test.haseeb.shadhillitoolikthomepage;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class shadhilichainadapter extends ArrayAdapter<String> {
    private AssetManager assets;

    Typeface font = Typeface.createFromAsset(getContext().getAssets(),
            "fonts/trado.ttf");
    Typeface font2 = Typeface.createFromAsset(getContext().getAssets(),
            "fonts/JaghbUni-Rom.ttf");

    String[] titleArray;
    String[] descriptionArray;
    int[] headerimg = {R.drawable.schead};
    int[] footerimg = {R.drawable.scfooter};


    public shadhilichainadapter(Context context, String[] titles, String[] desc, int[] hd, int[] ft) {
        super(context, R.layout.row_layout_4, R.id.textview2,titles);
        this.titleArray=titles;
        this.descriptionArray=desc;
        this.headerimg=hd;
        this.footerimg=ft;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {





        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.row_layout_4, parent, false);
        View imageview = theInflater.inflate(R.layout.header, parent, false);

        ImageView header = (ImageView) imageview.findViewById(R.id.schead);
        ImageView footer = (ImageView) imageview.findViewById(R.id.scfooter);


        TextView Arabic = (TextView) theView.findViewById(R.id.textview2);
        TextView Translation = (TextView) theView.findViewById(R.id.translation);


        Arabic.setText(titleArray[position]);
        Translation.setText(descriptionArray[position]);

        Arabic.setTypeface(font);
        Translation.setTypeface(font2);


        String text =descriptionArray[position];
        Translation.setText(Html.fromHtml(text));
        return theView;


    }




}