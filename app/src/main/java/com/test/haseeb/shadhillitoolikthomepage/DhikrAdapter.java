package com.test.haseeb.shadhillitoolikthomepage;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class DhikrAdapter extends ArrayAdapter<String> {

    String[] titleArray;
    String[] subtitleArray;


    public DhikrAdapter(Context context, String[]values, String[] subtitles) {
        super(context, R.layout.row_layout_2, values);
        this.titleArray=values;
        this.subtitleArray=subtitles;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.row_layout_2,
                parent, false);



        TextView theTextView = (TextView) theView.findViewById(R.id.textview1);
        TextView textView2 = (TextView) theView.findViewById(R.id.textview2);

        theTextView.setText(titleArray[position]);
        textView2.setText(subtitleArray[position]);

        ImageView theImageView = (ImageView) theView.findViewById(R.id.imageview1);
        theImageView.setImageResource(R.drawable.actionbar);

        return theView;
    }
}