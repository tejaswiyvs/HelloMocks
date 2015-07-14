package com.tejaswi_yerukalapudi.hellomocks.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.tejaswi_yerukalapudi.hellomocks.R;
import com.tejaswi_yerukalapudi.hellomocks.lib.helper.Helper;
import com.tejaswi_yerukalapudi.hellomocks.models.Appointment;

import java.util.List;

/**
 * Created by Teja on 7/10/15.
 */
public class UpcomingAppointmentsAdapter extends ArrayAdapter<Appointment> {

    private Context mCtx;

    public UpcomingAppointmentsAdapter(Context ctx, List<Appointment> appointmentList) {
        super(ctx, R.layout.view_appointment_row_new, appointmentList);
        this.mCtx = ctx;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.view_appointment_row_new, parent, false);
        }

        final Appointment appointment = getItem(pos);

        TextView apptDateTxt = (TextView) view.findViewById(R.id.appointmentCellApptDateTxt);
        TextView apptMonthTxt = (TextView) view.findViewById(R.id.appointmentCellApptMonthTxt);
        TextView apptTimeTxt = (TextView) view.findViewById(R.id.appointmentCellApptTimeTxt);
        TextView physicianInfoTxt = (TextView) view.findViewById(R.id.appointmentCellPhysicianInfoTxt);
        TextView childNameTxt = (TextView) view.findViewById(R.id.appointmentCellPersonNameTxt);
        TextView appointmentTypeTxt = (TextView) view.findViewById(R.id.appointmentCellAppointmentTypeTxt);

        Button startCallBtn = (Button) view.findViewById(R.id.appointmentCellStartCallBtn);
        Button cancelApptBtn = (Button) view.findViewById(R.id.appointmentCellCancelBtn);

        apptMonthTxt.setText(Helper.getMonth(appointment.getAppointmentDate()));
        apptDateTxt.setText(Helper.getDate(appointment.getAppointmentDate()));
        apptTimeTxt.setText(Helper.getTime(appointment.getAppointmentDate()));
        appointmentTypeTxt.setText(appointment.getAppointmentType());
        physicianInfoTxt.setText(appointment.getPhysicianInfo());

        if (appointment.getPerson() != null) {
            childNameTxt.setText(appointment.getPerson().getFirstName());
        }

        if (Helper.isNow(appointment.getAppointmentDate())) {
            startCallBtn.setVisibility(View.VISIBLE);
            startCallBtn.setEnabled(true);
            startCallBtn.setTag(pos);
            startCallBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (int) v.getTag();
                    Helper.showToast(getContext(), "Start Call button clicked");
                }
            });
        }
        else {
            startCallBtn.setVisibility(View.GONE);
            startCallBtn.setEnabled(false);
        }

        cancelApptBtn.setTag(pos);
        cancelApptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle appointment cancel
                Helper.showToast(getContext(), "Cancel appointment clicked: ");
            }
        });

        return view;
    }

}
