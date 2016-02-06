package com.test.haseeb.shadhillitoolikthomepage;


import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class latifactivity extends AppCompatActivity {
    private Toolbar toolbar;                              // Declaring the Toolbar Object

    MediaPlayer mp;
    String[] Arabic;
    String[] Transliteration;
    String[] Translation;
    String[] Number;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latif);
        Resources res=getResources();
        Arabic=res.getStringArray(R.array.latifarabic);
        Transliteration=res.getStringArray(R.array.latiftransliteration);
        Translation=res.getStringArray(R.array.latiftranslation);
        Number=res.getStringArray(R.array.latifnumber);
        LayoutInflater mInflater = getLayoutInflater();
        final View mLayout = mInflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));
        final TextView mText = (TextView) mLayout.findViewById(R.id.toast_text);





        mp = MediaPlayer.create(this, R.raw.latif);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setSubtitle("The Most Subtle");

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        ListAdapter theAdapter = new latifadapter(this, Arabic, Transliteration, Translation, Number);
        final ListView latiflist  = (ListView) findViewById(R.id.latiflist);
        latiflist.setAdapter(theAdapter);
        registerForContextMenu(latiflist);
        ListAdapter listAdapter = latiflist.getAdapter();
        ImageView a = new ImageView(this);
        a.setImageResource(R.drawable.l1);
        latiflist.addHeaderView(a, null, false);
        ImageView b = new ImageView(this);
        b.setImageResource(R.drawable.scfooter);
        latiflist.addFooterView(b, null, false);
        registerForContextMenu(latiflist);
        a.setScaleType(ImageView.ScaleType.FIT_START);
        a.setAdjustViewBounds(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bahrtitle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LayoutInflater mInflater = getLayoutInflater();
        final View mLayout = mInflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));
        final TextView mText = (TextView) mLayout.findViewById(R.id.toast_text);

        if (item.getItemId() == R.id.action_play) {

            mp.start();
            Toast mToast = new Toast(getApplicationContext());
            mText.setText("Playing");
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setView(mLayout);
            mToast.show();

        }
        if (item.getItemId() == R.id.action_pause) {
            mp.pause();
            Toast mToast = new Toast(getApplicationContext());
            mText.setText("Paused");
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setView(mLayout);
            mToast.show();
        }

        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent parentIntent1 = new Intent(this,DhikrActivity.class);
            startActivity(parentIntent1);
            mp.stop();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);



        if (v.getId() == R.id.latiflist) {

            String[] menuItems = getResources().getStringArray(R.array.menu);
            for (int i = 0; i<menuItems.length; i++) {
                menu.add(Menu.NONE, i, i, menuItems[i]);
            }
        }}

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        String listItemName1 = Translation[info.position-1];
        String listItemName2 = Arabic[info.position-1];
        String listItemName3 = Transliteration[info.position-1];


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
    protected void onDestroy() {


        super.onDestroy();
        mp.stop();

    }



}







