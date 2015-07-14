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
import com.tejaswi_yerukalapudi.hellomocks.models.AppointmentStatus;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Teja on 7/10/15.
 */
public class NotesAdapter extends ArrayAdapter<Appointment> {

    public NotesAdapter(Context ctx, List<Appointment> appointmentList) {
        super(ctx, R.layout.view_note_row, appointmentList);
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.view_note_row, parent, false);
        }

        final Appointment appointment = getItem(pos);

        ImageView appointmentStatusImg = (ImageView) view.findViewById(R.id.noteCellAppointmentStatusImg);
        TextView patientNameTxt = (TextView) view.findViewById(R.id.noteCellPatientNameTxt);
        TextView appointmentTimeTxt = (TextView) view.findViewById(R.id.noteCellAppointmentTimeTxt);
        TextView physicianNameTxt = (TextView) view.findViewById(R.id.notesCellPhysicianNameTxt);
        Button consultSummaryBtn = (Button) view.findViewById(R.id.noteCellConsultSummaryBtn);

        // We should never have an appointment with status scheduled in the completed appointment list.
        AppointmentStatus status = appointment.getAppointmentStatus();
        if (status == AppointmentStatus.UNKNOWN || status == AppointmentStatus.SCHEDULED) {
            appointmentStatusImg.setImageResource(R.drawable.appointment_scheduled);
        }
        else if (status == AppointmentStatus.CANCELLED) {
            appointmentStatusImg.setImageResource(R.drawable.appointment_cancelled);
        }
        else if (status == AppointmentStatus.COMPLETED) {
            appointmentStatusImg.setImageResource(R.drawable.appointment_completed);
        }

        if (appointment.getPerson() != null) {
            patientNameTxt.setText(appointment.getPerson().getFullName());
        }

        return view;
    }

}
