package com.test.haseeb.shadhillitoolikthomepage;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.util.Log;
import android.view.View;

import com.parse.ParsePush;

/**
 * Created by haseeb on 07/02/16.
 */
public class MyPreferenceFragment extends PreferenceFragment {

    ListPreference timezone;
    CheckBoxPreference checkbox2;
    CheckBoxPreference checkbox3;
    CheckBoxPreference checkbox4;
    String WirdMorning;
    String WirdEvening;
    String HizbBahr;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.fragment_preference);


        WirdMorning = "WirdMorning";
        WirdEvening =  "WirdEvening";
        HizbBahr =  "HizbBahr";
        timezone = (ListPreference)findPreference("timezonepref");
        Preference.OnPreferenceClickListener listener = new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                if (checkbox2.isChecked()) {
                    ParsePush.subscribeInBackground(WirdMorning);
                }
                else {
                    ParsePush.unsubscribeInBackground(WirdMorning);
                }
                if (checkbox3.isChecked()) {
                    ParsePush.subscribeInBackground(WirdEvening);
                }
                else {
                    ParsePush.unsubscribeInBackground(WirdEvening);
                }
                if (checkbox4.isChecked()) {
                    ParsePush.subscribeInBackground(HizbBahr);
                }
                else {
                    ParsePush.unsubscribeInBackground(HizbBahr);
                }
                return false;
            }
        };
        checkbox2 = (CheckBoxPreference)findPreference("checkBoxPref2");
        checkbox2.setOnPreferenceClickListener(listener);
        checkbox3 = (CheckBoxPreference) findPreference("checkBoxPref3");
        checkbox3.setOnPreferenceClickListener(listener);
        checkbox4 = (CheckBoxPreference) findPreference("checkBoxPref4");
        checkbox4.setOnPreferenceClickListener(listener);

        timezone.setOnPreferenceChangeListener(new
       Preference.OnPreferenceChangeListener() {
           public boolean onPreferenceChange(Preference preference, Object newValue) {
               final String val = newValue.toString();
               int index = timezone.findIndexOfValue(val);

               if (index == 1) {
                   WirdMorning = "WirdMorningUTC00";
                   WirdEvening =  "WirdEveningUTC00";
                   HizbBahr =  "HizbBahrUTC00";
               } else {
                   }
               if (index == 2) {
                   WirdMorning = "WirdMorningUTC01";
                   WirdEvening =  "WirdEveningUTC01";
                   HizbBahr =  "HizbBahrUTC01";
               } else {
               }
               if (index == 3) {
                   WirdMorning = "WirdMorningUTC02";
                   WirdEvening =  "WirdEveningUTC02";
                   HizbBahr =  "HizbBahrUTC02";
               } else {
               }
               if (index == 4) {
                   WirdMorning = "WirdMorningUTC03";
                   WirdEvening =  "WirdEveningUTC03";
                   HizbBahr =  "HizbBahrUTC03";
               } else {
               }
               if (index == 5) {
                   WirdMorning = "WirdMorningUTC04";
                   WirdEvening =  "WirdEveningUTC04";
                   HizbBahr =  "HizbBahrUTC04";
               } else {
               }
               if (index == 6) {
                   WirdMorning = "WirdMorningUTC05";
                   WirdEvening =  "WirdEveningUTC05";
                   HizbBahr =  "HizbBahrUTC05";
               } else {
               }
               if (index == 7) {
                   WirdMorning = "WirdMorningUTC06";
                   WirdEvening =  "WirdEveningUTC06";
                   HizbBahr =  "HizbBahrUTC06";
               } else {
               }
               if (index == 8) {
                   WirdMorning = "WirdMorningUTC07";
                   WirdEvening =  "WirdEveningUTC07";
                   HizbBahr =  "HizbBahrUTC07";
               } else {
               }
               if (index == 9) {
                   WirdMorning = "WirdMorningUTC08";
                   WirdEvening =  "WirdEveningUTC08";
                   HizbBahr =  "HizbBahrUTC08";
               } else {
               }
               if (index == 10) {
                   WirdMorning = "WirdMorningUTC09";
                   WirdEvening =  "WirdEveningUTC09";
                   HizbBahr =  "HizbBahrUTC09";
               } else {
               }
               if (index == 11) {
                   WirdMorning = "WirdMorningUTC10";
                   WirdEvening =  "WirdEveningUTC10";
                   HizbBahr =  "HizbBahrUTC10";
               } else {
               }
               if (index == 12) {
                   WirdMorning = "WirdMorningUTC11";
                   WirdEvening =  "WirdEveningUTC11";
                   HizbBahr =  "HizbBahrUTC11";
               } else {
               }
               if (index == 13) {
                   WirdMorning = "WirdMorningUTC12";
                   WirdEvening =  "WirdEveningUTC12";
                   HizbBahr =  "HizbBahrUTC12";
               } else {
               }
               if (index == 14) {
                   WirdMorning = "WirdMorningUTCN01";
                   WirdEvening =  "WirdEveningUTCN01";
                   HizbBahr =  "HizbBahrUTCN01";
               } else {
               }
               if (index == 15) {
                   WirdMorning = "WirdMorningUTCN02";
                   WirdEvening =  "WirdEveningUTCN02";
                   HizbBahr =  "HizbBahrUTCN02";
               } else {
               }
               if (index == 16) {
                   WirdMorning = "WirdMorningUTCN03";
                   WirdEvening =  "WirdEveningUTCN03";
                   HizbBahr =  "HizbBahrUTCN03";
               } else {
               }
               if (index == 17) {
                   WirdMorning = "WirdMorningUTCN04";
                   WirdEvening =  "WirdEveningUTCN04";
                   HizbBahr =  "HizbBahrUTCN04";
               } else {
               }
               if (index == 18) {
                   WirdMorning = "WirdMorningUTCN05";
                   WirdEvening =  "WirdEveningUTCN05";
                   HizbBahr =  "HizbBahrUTCN05";
               } else {
               }
               if (index == 19) {
                   WirdMorning = "WirdMorningUTCN06";
                   WirdEvening =  "WirdEveningUTCN06";
                   HizbBahr =  "HizbBahrUTCN06";
               } else {
               }
               if (index == 20) {
                   WirdMorning = "WirdMorningUTCN07";
                   WirdEvening =  "WirdEveningUTCN07";
                   HizbBahr =  "HizbBahrUTCN07";
               } else {
               }
               if (index == 21) {
                   WirdMorning = "WirdMorningUTCN08";
                   WirdEvening =  "WirdEveningUTCN08";
                   HizbBahr =  "HizbBahrUTCN08";
               } else {
               }
               if (index == 22) {
                   WirdMorning = "WirdMorningUTCN09";
                   WirdEvening =  "WirdEveningUTCN09";
                   HizbBahr =  "HizbBahrUTCN09";
               } else {
               }
               if (index == 23) {
                   WirdMorning = "WirdMorningUTCN10";
                   WirdEvening =  "WirdEveningUTCN10";
                   HizbBahr =  "HizbBahrUTCN10";
               } else {
               }
               if (index == 24) {
                   WirdMorning = "WirdMorningUTCN11";
                   WirdEvening =  "WirdEveningUTCN11";
                   HizbBahr =  "HizbBahrUTCN11";
               } else {
               }





               return true;
           }
       });
    }}


