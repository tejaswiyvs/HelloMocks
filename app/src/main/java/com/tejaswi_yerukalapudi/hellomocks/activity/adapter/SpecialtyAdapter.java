package com.tejaswi_yerukalapudi.hellomocks.activity.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tejaswi_yerukalapudi.hellomocks.R;
import com.tejaswi_yerukalapudi.hellomocks.lib.helper.Helper;
import com.tejaswi_yerukalapudi.hellomocks.models.Person;

import java.util.List;

/**
 * Created by Teja on 7/10/15.
 */
public class SpecialtyAdapter extends ArrayAdapter<CharSequence> {

    public SpecialtyAdapter(Context context, List<CharSequence> specialties) {
        super(context, R.layout.view_spinner_specialty, specialties);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewHelper(position, convertView, parent, false);
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getViewHelper(position, convertView, parent, true);
    }

    public View getViewHelper(int position, View convertView, ViewGroup parent, boolean dropDown) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.view_spinner_specialty, parent, false);
        String specialty = getItem(position).toString();
        TextView name = (TextView) row.findViewById(R.id.specialtySpinnerNameTxt);
        ImageView dropDownImg = (ImageView) row.findViewById(R.id.specialtySpinnerDropdownBtn);
        name.setText(specialty);
        if (dropDown) {
            dropDownImg.setVisibility(View.GONE);
        }
        return row;
    }
}
