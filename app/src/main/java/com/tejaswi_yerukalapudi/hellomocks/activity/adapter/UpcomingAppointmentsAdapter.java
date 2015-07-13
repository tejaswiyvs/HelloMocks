package com.tejaswi_yerukalapudi.hellomocks.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.tejaswi_yerukalapudi.hellomocks.R;
import com.tejaswi_yerukalapudi.hellomocks.models.Appointment;

import java.util.List;

/**
 * Created by Teja on 7/10/15.
 */
public class UpcomingAppointmentsAdapter extends ArrayAdapter<Appointment> {

    public UpcomingAppointmentsAdapter(Context ctx, List<Appointment> appointmentList) {
        super(ctx, android.R.layout.simple_list_item_1, appointmentList);
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.itemlistrow, null);
        }

        Item p = getItem(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.id);
            TextView tt2 = (TextView) v.findViewById(R.id.categoryId);
            TextView tt3 = (TextView) v.findViewById(R.id.description);

            if (tt1 != null) {
                tt1.setText(p.getId());
            }

            if (tt2 != null) {
                tt2.setText(p.getCategory().getId());
            }

            if (tt3 != null) {
                tt3.setText(p.getDescription());
            }
        }

        return v;
    }
}
