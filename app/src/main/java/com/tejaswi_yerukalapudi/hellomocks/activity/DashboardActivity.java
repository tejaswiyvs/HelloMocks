package com.tejaswi_yerukalapudi.hellomocks.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.tejaswi_yerukalapudi.hellomocks.R;
import com.tejaswi_yerukalapudi.hellomocks.lib.helper.Helper;
import com.tejaswi_yerukalapudi.hellomocks.models.Appointment;


public class DashboardActivity extends ActionBarActivity {

    private ListView mUpcomingAppointmentsListView;
    private ListView mNotesListView;
    private Spinner mChildPickerSpinner;
    private Spinner mSpecialtyPickerSpinner;
    private ArrayAdapter<Appointment> mUpcomingAppointmentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        this.bindUi();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void searchPhysiciansBtnClicked(View v) {
        Helper.showToast(this, "Search Physicians Clicked");
    }

    // Helpers
    private void bindUi() {
        this.mChildPickerSpinner = (Spinner) findViewById(R.id.dashboardChildPickerSpinner);
        this.mSpecialtyPickerSpinner = (Spinner) findViewById(R.id.dashboardSpecialtyPickerSpinner);
        this.mUpcomingAppointmentsListView = (ListView) findViewById(R.id.dashboardAppointmentList);
        this.mNotesListView = (ListView) findViewById(R.id.dashboardNotesList);
    }
}