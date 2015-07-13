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

    public UpcomingAppointmentsAdapter(Context ctx, List<Appointment> appointmentList) {
        super(ctx, R.layout.view_appointment_row, appointmentList);
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.view_appointment_row, parent, false);
        }

        final Appointment appointment = getItem(pos);

        TextView apptTimeTxt = (TextView) view.findViewById(R.id.appointmentCellTimeLbl);
        TextView apptTimeDescTxt = (TextView) view.findViewById(R.id.appointmentCellTimeDescriptionLbl);
        TextView physicianInfoTxt = (TextView) view.findViewById(R.id.appointmentCellPhysicianInfoLbl);
        TextView childNameTxt = (TextView) view.findViewById(R.id.appointmentCellPersonNameLbl);
        ImageView profilePicImg = (ImageView) view.findViewById(R.id.appointmentCellPatientImg);
        Button startCallBtn = (Button) view.findViewById(R.id.appointmentCellStartCallBtn);
        ImageButton cancelApptBtn = (ImageButton) view.findViewById(R.id.appointmentCellCancelAppointmentButton);

        apptTimeTxt.setText(appointment.getSimpleAppointmentTime());
        apptTimeDescTxt.setText(appointment.getAppointmentTimeDescription());
        physicianInfoTxt.setText(appointment.getPhysicianInfo());
        if (appointment.getPerson() != null) {
            childNameTxt.setText(appointment.getPerson().getFirstName());
        }
        if (appointment.getPerson() != null && appointment.getPerson().getPicture() != 0) {
            profilePicImg.setImageResource(appointment.getPerson().getPicture());
        }

        if (Helper.isNow(appointment.getAppointmentDate())) {
            startCallBtn.setVisibility(View.VISIBLE);
            startCallBtn.setEnabled(true);
            startCallBtn.setTag(pos);
            startCallBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (int) v.getTag();
                    // Handle start call
                    Helper.showToast(getContext(), "Call button clicked for appt: " + appointment.getSimpleAppointmentTime() + " " + appointment.getAppointmentTimeDescription());
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
                Helper.showToast(getContext(), "Cancel appointment clicked for appt: " + appointment.getSimpleAppointmentTime() + " " + appointment.getAppointmentTimeDescription());
            }
        });

        return view;
    }

}
