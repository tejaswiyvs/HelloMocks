package com.tejaswi_yerukalapudi.hellomocks.lib.helper;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.text.method.DateTimeKeyListener;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tejaswi_yerukalapudi.hellomocks.R;
import com.tejaswi_yerukalapudi.hellomocks.core.CustomApplication;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.datatype.Duration;

/**
 *
 * Collection of static helper methods.
 *
 * Created by teja on 7/9/15.
 */
public class Helper {
    private static final String TIME_FORMAT = "hh:mm a";
    private static Context ctx = CustomApplication.getContext();

    public static void showToast(Context ctx, String message) {
        Toast t = Toast.makeText(ctx, message, Toast.LENGTH_SHORT);
        t.show();
    }

    public static int getHeightForDp(ViewGroup parent, float dp) {
        DisplayMetrics metrics = parent.getResources().getDisplayMetrics();
        float fpixels = metrics.density * dp;
        return (int)(fpixels + 0.5f);
    }

    public static String getFullName(String firstName, String lastName) {
        StringBuffer result = new StringBuffer();
        boolean flag = false;
        if (lastName != null && !lastName.isEmpty()) {
            result.append(lastName);
            flag = true;
        }
        if (firstName != null && !firstName.isEmpty()) {
            if (flag) {
                result.append(", ");
            }
            result.append(firstName);
        }

        return result.toString();
    }

    public static boolean isNow(Date date) {
        DateTime jodaDate = new DateTime(date);
        DateTime start = jodaDate.minusMinutes(15);
        DateTime end = jodaDate.plusMinutes(10);
        Interval interval = new Interval(start, end);
        return interval.contains(new DateTime());
    }

    public static String getMonth(Date date) {
        if (date == null) return "";
        DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM");
        return formatter.print(new DateTime(date));
    }

    public static String getDate(Date date) {
        if (date == null) return "";
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd");
        return formatter.print(new DateTime(date));
    }

    public static String getTime(Date date) {
        if (date == null) return "";
        DateTimeFormatter formatter = DateTimeFormat.forPattern(TIME_FORMAT);
        return formatter.print(new DateTime(date));
    }
}
