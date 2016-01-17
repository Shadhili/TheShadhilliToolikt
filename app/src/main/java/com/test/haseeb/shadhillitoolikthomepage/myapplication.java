package com.test.haseeb.shadhillitoolikthomepage;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParsePush;

/**
 * Created by Haseeb on 14/01/2016.
 */
public class myapplication extends android.app.Application {


    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "froHxAVu9cNArGo3acLl7G7udg546o2SrioCwa9W", "FCQhZ07xQ4FAxoSvBfzMIkqxhoeU6cZE8C5xXDA9");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }

}
