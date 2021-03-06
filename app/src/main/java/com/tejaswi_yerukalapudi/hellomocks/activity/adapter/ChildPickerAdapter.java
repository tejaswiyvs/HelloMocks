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
public class ChildPickerAdapter extends ArrayAdapter<Person> {

    public ChildPickerAdapter(Context context, List<Person> personList) {
        super(context, R.layout.view_spinner_person, personList);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewHelper(position, convertView, parent, false);
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getViewHelper(position, convertView, parent, true);
    }

    public View getViewHelper(int position, View convertView, ViewGroup parent, boolean dropDown) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.view_spinner_person, parent, false);
        Person p = getItem(position);
        TextView name = (TextView) row.findViewById(R.id.personSpinnerNameTxt);
        ImageView profilePictureImg = (ImageView) row.findViewById(R.id.personSpinnerProfilePictureImg);
        ImageView dropDownImg = (ImageView) row.findViewById(R.id.personSpinnerDropDownImgButton);
        name.setText(p.getFullName());
        profilePictureImg.setImageResource(p.getPicture());
        if (dropDown) {
            dropDownImg.setVisibility(View.GONE);
        }
        return row;
    }
}
