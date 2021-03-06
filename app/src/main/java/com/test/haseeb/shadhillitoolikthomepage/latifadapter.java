package com.test.haseeb.shadhillitoolikthomepage;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class latifadapter extends ArrayAdapter<String> {
    private AssetManager assets;

    Typeface font = Typeface.createFromAsset(getContext().getAssets(),
            "fonts/trado.ttf");
    Typeface font2 = Typeface.createFromAsset(getContext().getAssets(),
            "fonts/JaghbUni-Rom.ttf");

    String[] titleArray;
    String[] descriptionArray;
    String[] subtitleArray;
    String[] numberArray;



    public latifadapter(Context context, String[] titles, String[] desc,String[] sub,String[] num) {
        super(context, R.layout.row_layout_3, R.id.textview2,titles);
        this.titleArray=titles;
        this.descriptionArray=desc;
        this.subtitleArray=sub;
        this.numberArray=num;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {





        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.row_layout_3, parent, false);

        TextView Arabic = (TextView) theView.findViewById(R.id.textview2);
        TextView Transliteration = (TextView) theView.findViewById(R.id.transliteration);
        TextView Translation = (TextView) theView.findViewById(R.id.translation);
        TextView Number = (TextView) theView.findViewById(R.id.number);

        Arabic.setText(titleArray[position]);
        Transliteration.setText(descriptionArray[position]);
        Translation.setText(subtitleArray[position]);
        Number.setText(numberArray[position]);

        Arabic.setTypeface(font);
        Transliteration.setTypeface(font2);
        Translation.setTypeface(font2);
        Number.setTypeface(font2);


        String text =subtitleArray[position];
        Translation.setText(Html.fromHtml(text));
        return theView;


    }




}