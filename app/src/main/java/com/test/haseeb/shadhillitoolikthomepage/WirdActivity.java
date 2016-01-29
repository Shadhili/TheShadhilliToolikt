package com.test.haseeb.shadhillitoolikthomepage;


import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class WirdActivity extends Activity {

    MediaPlayer mp;
    String[] Arabic;
    String[] Transliteration;
    String[] Translation;
    String[] Number;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wird);
        Resources res = getResources();
        Arabic = res.getStringArray(R.array.wirdarabic);
        Transliteration = res.getStringArray(R.array.wirdtransliteration);
        Translation = res.getStringArray(R.array.wirdtranslation);
        Number = res.getStringArray(R.array.wirdnumber);

        LayoutInflater mInflater = getLayoutInflater();
        final View mLayout = mInflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));
        final TextView mText = (TextView) mLayout.findViewById(R.id.toast_text);


        mp = MediaPlayer.create(this, R.raw.wird);


        Button playwird = (Button) findViewById(R.id.playwird);
        playwird.performClick();
        playwird.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                mp.start();

                Toast mToast = new Toast(getApplicationContext());
                mText.setText("Playing");
                mToast.setDuration(Toast.LENGTH_SHORT);
                mToast.setView(mLayout);
                mToast.show();
            }


        });
        ImageButton pausewird = (ImageButton) findViewById(R.id.pausewird);

        pausewird.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                mp.pause();
                Toast mToast = new Toast(getApplicationContext());
                mText.setText("Paused");
                mToast.setDuration(Toast.LENGTH_SHORT);
                mToast.setView(mLayout);
                mToast.show();
            }


        });


        ListAdapter theAdapter = new Wirdadapter(this, Arabic, Transliteration, Translation, Number);
        final ListView wirdlist = (ListView) findViewById(R.id.wirdlist);
        wirdlist.setAdapter(theAdapter);
        registerForContextMenu(wirdlist);
        ListAdapter listAdapter = wirdlist.getAdapter();

    }




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if (v.getId() == R.id.wirdlist) {

            String[] menuItems = getResources().getStringArray(R.array.menu);
            for (int i = 0; i<menuItems.length; i++) {
                menu.add(Menu.NONE, i, i, menuItems[i]);
        }

    }}


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        String listItemName1 = Translation[info.position];
        String listItemName2 = Arabic[info.position];
        String listItemName3 = Transliteration[info.position];


        if (item.getItemId() == 0) {


            int menuItemIndex = item.getItemId();
            String[] menuItems = getResources().getStringArray(R.array.menu);
            String menuItemName = menuItems[menuItemIndex];

            ClipData clip = ClipData.newPlainText("simple text", listItemName1);
            clipboard.setPrimaryClip(clip);

            LayoutInflater mInflater = getLayoutInflater();
            final View mLayout = mInflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));
            final TextView mText = (TextView) mLayout.findViewById(R.id.toast_text);
            Toast mToast = new Toast(getApplicationContext());
            mText.setText("Translation Copied");
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setView(mLayout);
            mToast.show();
        }
        if (item.getItemId() == 1) {
            int menuItemIndex = item.getItemId();
            String[] menuItems = getResources().getStringArray(R.array.menu);
            String menuItemName = menuItems[menuItemIndex];

            ClipData clip2 = ClipData.newPlainText("simple text", listItemName2);
            clipboard.setPrimaryClip(clip2);

            LayoutInflater mInflater = getLayoutInflater();
            final View mLayout = mInflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));
            final TextView mText = (TextView) mLayout.findViewById(R.id.toast_text);
            Toast mToast = new Toast(getApplicationContext());
            mText.setText("Arabic Copied");
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setView(mLayout);
            mToast.show();
        }
        if (item.getItemId() == 2) {
            int menuItemIndex = item.getItemId();
            String[] menuItems = getResources().getStringArray(R.array.menu);
            String menuItemName = menuItems[menuItemIndex];

            ClipData clip3 = ClipData.newPlainText("simple text", listItemName3);
            clipboard.setPrimaryClip(clip3);

            LayoutInflater mInflater = getLayoutInflater();
            final View mLayout = mInflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));
            final TextView mText = (TextView) mLayout.findViewById(R.id.toast_text);
            Toast mToast = new Toast(getApplicationContext());
            mText.setText("Transliteration Copied");
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setView(mLayout);
            mToast.show();
        }
        if (item.getItemId() == 3) {
            int menuItemIndex = item.getItemId();
            String[] menuItems = getResources().getStringArray(R.array.menu);
            String menuItemName = menuItems[menuItemIndex];

            ClipData clip4 = ClipData.newPlainText("simple text", listItemName2 + System.getProperty ("line.separator") + listItemName1 + System.getProperty ("line.separator") + listItemName3);
            clipboard.setPrimaryClip(clip4);

            LayoutInflater mInflater = getLayoutInflater();
            final View mLayout = mInflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));
            final TextView mText = (TextView) mLayout.findViewById(R.id.toast_text);
            Toast mToast = new Toast(getApplicationContext());
            mText.setText("All Copied");
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setView(mLayout);
            mToast.show();
        }
        return true;

        }




    @Override
 protected void onDestroy () {


        super.onDestroy();
        mp.stop();

    }}







