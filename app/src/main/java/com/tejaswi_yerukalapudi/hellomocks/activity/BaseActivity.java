package com.tejaswi_yerukalapudi.hellomocks.activity;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.tejaswi_yerukalapudi.hellomocks.core.CustomApplication;
import com.tejaswi_yerukalapudi.hellomocks.R;
import com.tejaswi_yerukalapudi.hellomocks.models.Session;

public class BaseActivity extends Activity {

    protected Session mSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSession = ((CustomApplication)getApplication()).getCurrentSession();
        if (mSession == null) {
            // User has logged out, we shouldn't show this any more.
            // Handle this in the real app
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
