package com.test.haseeb.shadhillitoolikthomepage;


import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class shadhilichainactivity extends AppCompatActivity {

    String[] Arabic;
    String[] Translation;
    int[] headerimg = {R.drawable.schead};
    int[] footerimg = {R.drawable.scfooter};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadhilichain);
        Resources res=getResources();
        Arabic=res.getStringArray(R.array.shadhilichainarabic);
        Translation = res.getStringArray(R.array.shadhilichainenglish);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        myToolbar.setSubtitle("The Golden Chain of the Shadhili Way");

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListAdapter theAdapter = new shadhilichainadapter(this, Arabic, Translation, headerimg, footerimg);
        final ListView mylist  = (ListView) findViewById(R.id.shadhilichainlist);
        View header = getLayoutInflater().inflate(R.layout.header, null, false);
        View footer = getLayoutInflater().inflate(R.layout.footer, null, false);

        mylist.addHeaderView(header);
        mylist.addFooterView(footer);
        mylist.setAdapter(theAdapter);
        registerForContextMenu(mylist);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if (v.getId() == R.id.shadhilichainlist) {

            String[] menuItems = getResources().getStringArray(R.array.menu3);
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

        if (item.getItemId() == 0) {


            int menuItemIndex = item.getItemId();
            String[] menuItems = getResources().getStringArray(R.array.menu3);
            String menuItemName = menuItems[menuItemIndex];

            ClipData clip = ClipData.newPlainText("simple text", listItemName1);
            clipboard.setPrimaryClip(clip);

            LayoutInflater mInflater = getLayoutInflater();
            final View mLayout = mInflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));
            final TextView mText = (TextView) mLayout.findViewById(R.id.toast_text);
            Toast mToast = new Toast(getApplicationContext());
            mText.setText("English Copied");
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setView(mLayout);
            mToast.show();
        }
        if (item.getItemId() == 1) {
            int menuItemIndex = item.getItemId();
            String[] menuItems = getResources().getStringArray(R.array.menu);
            String menuItemName = menuItems[menuItemIndex];

            ClipData clip3 = ClipData.newPlainText("simple text", listItemName2);
            clipboard.setPrimaryClip(clip3);

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

            ClipData clip4 = ClipData.newPlainText("simple text", listItemName2 + System.getProperty ("line.separator") + listItemName1 + System.getProperty ("line.separator"));
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
}







