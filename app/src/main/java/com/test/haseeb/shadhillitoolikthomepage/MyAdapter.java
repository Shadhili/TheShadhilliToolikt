package com.test.haseeb.shadhillitoolikthomepage;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class MyAdapter extends ArrayAdapter<String> {
    public MyAdapter(Context context, String[]values) {
        super(context, R.layout.row_layout_2, values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.row_layout_2,
                parent, false);


        String feature = getItem(position);

        TextView theTextView = (TextView) theView.findViewById(R.id.textview1);

        theTextView.setText(feature);

        ImageView theImageView = (ImageView) theView.findViewById(R.id.imageview1);

        theImageView.setImageResource(R.drawable.actionbar);

        return theView;
    }
}