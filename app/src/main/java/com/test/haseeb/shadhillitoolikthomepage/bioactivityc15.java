package com.test.haseeb.shadhillitoolikthomepage;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class bioactivityc15 extends AppCompatActivity {

    String[] Biography;
    public int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);
        Resources res = getResources();
        Biography = res.getStringArray(R.array.biographyc15);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setSubtitle(R.string.c15);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListAdapter theAdapter = new bioadapter(this, Biography);
        final ListView wirdlist = (ListView) findViewById(R.id.biolist);
        wirdlist.setAdapter(theAdapter);
        registerForContextMenu(wirdlist);
        ListAdapter listAdapter = wirdlist.getAdapter();
        ImageView a = new ImageView(this);
        a.setImageResource(R.drawable.bio1);
        wirdlist.addHeaderView(a, null, false);
        a.setScaleType(ImageView.ScaleType.FIT_START);
        a.setAdjustViewBounds(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent parentIntent1 = new Intent(this,DhikrActivity.class);
            startActivity(parentIntent1);

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // Get the info on which item was selected
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        // Retrieve the position at where you long pressed
        position = info.position;

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
        String listItemName1 = Biography[info.position-1];
        ListView wirdlist = (ListView) findViewById(R.id.biolist);
        LayoutInflater mInflater = getLayoutInflater();
        final View mLayout = mInflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));
        final TextView mText = (TextView) mLayout.findViewById(R.id.toast_text);
        Toast mToast = new Toast(getApplicationContext());
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.setView(mLayout);

        if (item.getItemId() == 0) {


            int menuItemIndex = item.getItemId();
            String[] menuItems = getResources().getStringArray(R.array.menu2);
            String menuItemName = menuItems[menuItemIndex];

            ClipData clip = ClipData.newPlainText("simple text", listItemName1);
            clipboard.setPrimaryClip(clip);

            mText.setText("Text Copied");
            mToast.show();
        }

        return true;

    }

    }