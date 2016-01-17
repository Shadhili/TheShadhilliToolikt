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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class bioactivity extends Activity {

    MediaPlayer mp;
    String[] Biography;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);
        Resources res = getResources();
        Biography = res.getStringArray(R.array.biography);

        LayoutInflater mInflater = getLayoutInflater();
        final View mLayout = mInflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));
        final TextView mText = (TextView) mLayout.findViewById(R.id.toast_text);


        ListAdapter theAdapter = new bioadapter(this, Biography);
        final ListView wirdlist = (ListView) findViewById(R.id.biolist);
        wirdlist.setAdapter(theAdapter);
        registerForContextMenu(wirdlist);
        ListAdapter listAdapter = wirdlist.getAdapter();}




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if (v.getId() == R.id.biolist) {

            String[] menuItems = getResources().getStringArray(R.array.menu2);
            for (int i = 0; i<menuItems.length; i++) {
                menu.add(Menu.NONE, i, i, menuItems[i]);
            }

        }}


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        String listItemName1 = Biography[info.position];


        if (item.getItemId() == 0) {


            int menuItemIndex = item.getItemId();
            String[] menuItems = getResources().getStringArray(R.array.menu2);
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

        return true;

    }




    }







