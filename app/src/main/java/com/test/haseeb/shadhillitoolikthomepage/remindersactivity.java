package com.test.haseeb.shadhillitoolikthomepage;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParsePush;

import java.sql.Time;

/**
 * Created by Haseeb on 14/01/2016.
 */
public class remindersactivity extends AppCompatActivity implements OnClickListener, AdapterView.OnItemSelectedListener {
    CheckBox checkbox1;
    CheckBox checkbox2;
    CheckBox checkbox3;
    CheckBox checkbox0;
    private Spinner dropdown;
    String[] Timezone;
    private Toolbar toolbar;                              // Declaring the Toolbar Object
    LinearLayout reminderlayout;
    String WirdMorning;
    String WirdEvening;
    String HizbBahr;
    String dropdownvisibility;
    TextView parseid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setSubtitle("Reminders for Awrad");

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Resources res=getResources();

        checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkbox1.setOnClickListener(this);
        checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkbox2.setOnClickListener(this);
        checkbox3 = (CheckBox) findViewById(R.id.checkbox3);
        checkbox3.setOnClickListener(this);
        checkbox0 = (CheckBox) findViewById(R.id.remindercheckbox1);
        checkbox0.setOnClickListener(this);
        reminderlayout = (LinearLayout)findViewById(R.id.remindercontainer);
        dropdown = (Spinner)findViewById(R.id.spinner1);
        Timezone=res.getStringArray(R.array.timezone);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(remindersactivity.this,
                android.R.layout.simple_spinner_item,Timezone);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);

        if (checkbox0.isChecked()) {

            dropdown.setVisibility(View.VISIBLE);
        }
        else {
            dropdown.setVisibility(View.GONE);
            reminderlayout.setVisibility(View.GONE);
        }


        WirdMorning = "WirdMorning";
        WirdEvening =  "WirdEvening";
        HizbBahr =  "HizbBahr";
        dropdownvisibility = "";
        loadSavedPreferences();



    }
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        dropdown.getSelectedItemPosition();
        if (position >0) {
            reminderlayout.setVisibility(View.VISIBLE);
        }
        else {
            reminderlayout.setVisibility(View.GONE);
        }
        savePreferences("spinnerSelection", dropdown.isSelected());


        switch (position) {
            case 0:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (checkbox1.isChecked() || checkbox2.isChecked () || checkbox3.isChecked())   {
                    checkbox1.setChecked(false);
                    checkbox2.setChecked(false);
                    checkbox3.setChecked(false);
                }
                else {
                   //do nothing
                }

                break;
            case 1: {
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position == 1) {
                    WirdMorning = "UTC00";
                } else {
                    WirdMorning = "";
                }
            }
                break;
            case 2:
                checkbox1.setChecked(false);
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position == 2) {
                    WirdMorning = "UTC+01";
                } else {
                    WirdMorning = "";
                }

                break;
            case 3:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==3) {
                    ParsePush.subscribeInBackground("UTC+02");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC+02");
                }
                break;
            case 4:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==4) {
                    ParsePush.subscribeInBackground("UTC+03");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC+03");
                }
                break;
            case 5:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==5) {
                    ParsePush.subscribeInBackground("UTC+04");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC+04");
                }
                break;
            case 6:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==6) {
                    ParsePush.subscribeInBackground("UTC+05");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC+05");
                }
                break;
            case 7:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==7) {
                    ParsePush.subscribeInBackground("UTC+06");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC+06");
                }
                break;
            case 8:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==8) {
                    ParsePush.subscribeInBackground("UTC+07");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC+07");
                }
                break;
            case 9:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==9) {
                    ParsePush.subscribeInBackground("UTC+08");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC+08");
                }
                break;
            case 10:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==10) {
                    ParsePush.subscribeInBackground("UTC+09");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC+09");
                }
                break;
            case 11:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==11) {
                    ParsePush.subscribeInBackground("UTC+10");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC+10");
                }
                break;
            case 12:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==12) {
                    ParsePush.subscribeInBackground("UTC+11");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC+11");
                }
                break;
            case 13:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==13) {
                    ParsePush.subscribeInBackground("UTC+12");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC+12");
                }
                break;
            case 14:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==14) {
                    ParsePush.subscribeInBackground("UTC-01");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC-01");
                }
                break;
            case 15:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==15) {
                    ParsePush.subscribeInBackground("UTC-02");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC-02");
                }
                break;
            case 16:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==16) {
                    ParsePush.subscribeInBackground("UTC-03");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC-03");
                }
                break;
            case 17:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==17) {
                    ParsePush.subscribeInBackground("UTC-04");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC-04");
                }
                break;
            case 18:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==18) {
                    ParsePush.subscribeInBackground("UTC-05");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC-05");
                }
                break;
            case 19:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==19) {
                    ParsePush.subscribeInBackground("UTC-06");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC-06");
                }
                break;
            case 20:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==20) {
                    ParsePush.subscribeInBackground("UTC-07");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC-07");
                }
                break;
            case 21:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==21) {
                    ParsePush.subscribeInBackground("UTC-08");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC-08");
                }
                break;
            case 22:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==22) {
                    ParsePush.subscribeInBackground("UTC-09");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC-09");
                }
                break;
            case 23:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==23) {
                    ParsePush.subscribeInBackground("UTC-10");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC-10");
                }
                break;
            case 24:
                savePreferences("spinnerSelection", dropdown.isSelected());
                if (position==24) {
                    ParsePush.subscribeInBackground("UTC-11");
                }
                else {
                    ParsePush.unsubscribeInBackground("UTC-11");
                }
                break;

                    }
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
        boolean checkboxValue3 = sharedPreferences.getBoolean("CheckBox_Value3", false);
        if (checkboxValue3) {
            checkbox3.setChecked(true);
        } else {
            checkbox3.setChecked(false);
        }
        boolean checkboxValue0 = sharedPreferences.getBoolean("CheckBox_Value0", false);
        if (checkboxValue0) {
            checkbox0.setChecked(true);
        } else {
            checkbox0.setChecked(false);
        }

        dropdown.setSelection(sharedPreferences.getInt("spinnerSelection", 0));

    }

    private void savePreferences(String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
//removed   editor commit from this line
        int selectedPosition = dropdown.getSelectedItemPosition();
        editor.putInt("spinnerSelection", selectedPosition);
        editor.commit();
    }

    @Override
    public void onClick(View v) {


        savePreferences("CheckBox_Value", checkbox1.isChecked());

        if (checkbox1.isChecked()) {

            ParsePush.subscribeInBackground(WirdMorning);
        }
        else {
            ParsePush.unsubscribeInBackground(WirdMorning);

        }
        savePreferences("CheckBox_Value2", checkbox2.isChecked());
        if (checkbox2.isChecked()) {

            ParsePush.subscribeInBackground(WirdEvening);
        }
        else {
            ParsePush.unsubscribeInBackground(WirdEvening);

        }
        savePreferences("CheckBox_Value3", checkbox3.isChecked());
        if (checkbox3.isChecked()) {

            ParsePush.subscribeInBackground(HizbBahr);
        }
        else {
            ParsePush.unsubscribeInBackground(HizbBahr);

        }
        savePreferences("CheckBox_Value0", checkbox0.isChecked());
        if (checkbox0.isChecked()) {

            dropdown.setVisibility(View.VISIBLE);
        }
        else {
            dropdown.setVisibility(View.GONE);
            reminderlayout.setVisibility(View.GONE);


        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent parentIntent1 = new Intent(this,DhikrActivity.class);
            startActivity(parentIntent1);
        }

        switch(item.getItemId())
        {
            case R.id.preferences:
            {
                Intent intent = new Intent();
                intent.setClassName(this, "com.test.haseeb.shadhillitoolikthomepage.MyPreferenceActivity");
                startActivity(intent);
                return true;
            }
        }



        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

}
