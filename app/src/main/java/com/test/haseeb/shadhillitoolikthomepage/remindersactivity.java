package com.test.haseeb.shadhillitoolikthomepage;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.view.View.OnClickListener;

import com.parse.ParsePush;

/**
 * Created by Haseeb on 14/01/2016.
 */
public class remindersactivity extends Activity implements OnClickListener {
    CheckBox checkbox1;
    CheckBox checkbox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);
        checkbox1 = (CheckBox) findViewById(R.id.checkbox);
        checkbox1.setOnClickListener(this);
        checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkbox2.setOnClickListener(this);
        loadSavedPreferences();
    }


    private void loadSavedPreferences(){
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        boolean checkboxValue = sharedPreferences.getBoolean("CheckBox_Value", false);
        if (checkboxValue) {
            checkbox1.setChecked(true);
        } else {
            checkbox1.setChecked(false);
        }
        boolean checkboxValue2 = sharedPreferences.getBoolean("CheckBox_Value2", false);
        if (checkboxValue2) {
            checkbox2.setChecked(true);
        } else {
            checkbox2.setChecked(false);
        }
    }

    private void savePreferences(String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    @Override
    public void onClick(View v) {
        savePreferences("CheckBox_Value", checkbox1.isChecked());

        if (checkbox1.isChecked()) {

            ParsePush.subscribeInBackground("WirdEvening");
        }
        else {
            ParsePush.unsubscribeInBackground("WirdEvening");

        }
        savePreferences("CheckBox_Value2", checkbox2.isChecked());
        if (checkbox2.isChecked()) {

            ParsePush.subscribeInBackground("WirdMorning");
        }
        else {
            ParsePush.unsubscribeInBackground("WirdMorning");

        }

    }


}
