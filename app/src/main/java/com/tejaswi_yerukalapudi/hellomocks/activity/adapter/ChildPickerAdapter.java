package com.tejaswi_yerukalapudi.hellomocks.activity.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tejaswi_yerukalapudi.hellomocks.lib.helper.Helper;
import com.tejaswi_yerukalapudi.hellomocks.models.Person;

import java.util.List;

/**
 * Created by Teja on 7/10/15.
 */
public class ChildPickerAdapter extends ArrayAdapter<Person> {

    public ChildPickerAdapter(Context context, List<Person> personList) {
        super(context, android.R.layout.simple_spinner_item, personList);
    }

    public TextView getView(int position, View convertView, ViewGroup parent) {
        TextView v = getViewHelper(position, convertView, parent);
        v.setHeight(Helper.getHeightForDp(parent, 50.0f));
        return v;
    }

    public TextView getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView v = getViewHelper(position, convertView, parent);
        v.setHeight(Helper.getHeightForDp(parent, 50.0f));
        return v;
    }

    private TextView getViewHelper(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) super.getView(position, convertView, parent);
        Person p = this.getItem(position);
        textView.setText(p.getFullName());
        return textView;
    }
}
