package com.tejaswi_yerukalapudi.hellomocks.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.tejaswi_yerukalapudi.hellomocks.R;
import com.tejaswi_yerukalapudi.hellomocks.activity.adapter.ChildPickerAdapter;
import com.tejaswi_yerukalapudi.hellomocks.activity.adapter.UpcomingAppointmentsAdapter;
import com.tejaswi_yerukalapudi.hellomocks.lib.helper.Helper;
import com.tejaswi_yerukalapudi.hellomocks.models.Appointment;
import com.tejaswi_yerukalapudi.hellomocks.models.Person;
import com.tejaswi_yerukalapudi.hellomocks.models.User;

import java.util.List;


public class DashboardActivity extends BaseActivity {

    private ListView mUpcomingAppointmentsListView;
    private ListView mNotesListView;
    private Spinner mChildPickerSpinner;
    private Spinner mSpecialtyPickerSpinner;
    private Button mSearchBtn;

    private ArrayAdapter<Person> mChildPickerAdapter;
    private ArrayAdapter<CharSequence> mSpecialtyPickerAdapter;
    private ArrayAdapter<Appointment> mUpcomingAppointmentsAdapter;

    private User mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        this.bindUi();
        this.mCurrentUser = this.mSession.getCurrentUser();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
        this.setupChildPickerSpinner();
        this.setupSpecialtySpinner();
        this.setupUpcomingAppointmentsList();
        this.mNotesListView = (ListView) findViewById(R.id.dashboardNotesList);
        this.mSearchBtn = (Button) findViewById(R.id.dashboardSearchBtn);
    }

    private void setupChildPickerSpinner() {
        this.mChildPickerSpinner = (Spinner) findViewById(R.id.dashboardChildPickerSpinner);
        List<Person> children = this.mSession.getCurrentUser().getChildren();
        if (children == null || children.size() == 0) {
            return;
        }
        this.mChildPickerAdapter = new ChildPickerAdapter(this, children);
        this.mChildPickerSpinner.setAdapter(this.mChildPickerAdapter);
    }

    private void setupSpecialtySpinner() {
        this.mSpecialtyPickerSpinner = (Spinner) findViewById(R.id.dashboardSpecialtyPickerSpinner);
        this.mSpecialtyPickerAdapter = ArrayAdapter.createFromResource(this, R.array.specialties, android.R.layout.simple_spinner_item);
        this.mSpecialtyPickerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.mSpecialtyPickerSpinner.setAdapter(this.mSpecialtyPickerAdapter);
    }

    private void setupUpcomingAppointmentsList() {
        this.mUpcomingAppointmentsListView = (ListView) findViewById(R.id.dashboardAppointmentList);
        this.mUpcomingAppointmentsAdapter = new UpcomingAppointmentsAdapter(this, this.mCurrentUser.getUpcomingAppointments());
        this.mUpcomingAppointmentsListView.setAdapter(this.mUpcomingAppointmentsAdapter);
    }
}