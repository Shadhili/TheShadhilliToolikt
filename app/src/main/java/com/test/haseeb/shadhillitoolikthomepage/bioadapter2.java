package com.test.haseeb.shadhillitoolikthomepage;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class bioadapter2 extends ArrayAdapter<String> {
    private AssetManager assets;

    Typeface font = Typeface.createFromAsset(getContext().getAssets(),
            "fonts/trado.ttf");
    Typeface font2 = Typeface.createFromAsset(getContext().getAssets(),
            "fonts/JaghbUni-Rom.ttf");

    String[] bioArray;




    public bioadapter2(Context context, String[] titles) {
        super(context, R.layout.row_layout_bio2, R.id.textview2,titles);
        this.bioArray=titles;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {





        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.row_layout_bio, parent, false);

        TextView Biography = (TextView) theView.findViewById(R.id.bio_content);

        Biography.setText(bioArray[position]);
        Biography.setTypeface(font2);

        String text =bioArray[position];
        Biography.setText(Html.fromHtml(text));
        Biography.setAutoLinkMask(Linkify.WEB_URLS);
        return theView;


    }




}