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

    public static String getSimpleDateTime(Date date) {
        if (date == null) { return ""; }

        if (Helper.isNow(date)) {
            return ctx.getString(R.string.now);
        }
        else if (Helper.isToday(date)) {
            return ctx.getString(R.string.today);
        }
        else if (Helper.isYesterday(date)) {
            return ctx.getString(R.string.yesterday);
        }
        else {
            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd MMM");
            DateTime dt = new DateTime(date);
            return formatter.print(dt);
        }
    }

    public static String getSimpleDateDescriptor(Date date) {
        if (date == null) { return ""; }
        DateTime jodaDate = new DateTime(date);
        DateTimeFormatter formatter;
        if (Helper.isNow(date)) {
            DateTime now = new DateTime();
            Minutes minsBetween = Minutes.minutesBetween(new DateTime(), jodaDate);
            formatter = DateTimeFormat.forPattern("KK:mm a");
            if (now.isAfter(jodaDate)) {
                return minsBetween.getMinutes() + " " + ctx.getString(R.string.minsLater) + " " + formatter.print(jodaDate);
            }
            else {
                return minsBetween.getMinutes() + " " + ctx.getString(R.string.minsAgo) + " " + formatter.print(jodaDate);
            }
        }
        else if (Helper.isToday(date) || Helper.isYesterday(date)) {
            formatter = DateTimeFormat.forPattern("DD MMM - KK:mm a");
            return formatter.print(jodaDate);
        }
        else {
            formatter = DateTimeFormat.forPattern("E - KK:mm a");
            return formatter.print(jodaDate);
        }
    }

    // A certain threshold of time defined as "Now".
    // Currently defined as fifteen minutes before or 5 mins after the date.
    public static boolean isNow(Date date) {
        DateTime hourAgo = new DateTime().minusMinutes(15);
        DateTime hourAfter = new DateTime().plusMinutes(5);
        Interval today = new Interval(hourAgo, hourAfter);
        return today.contains(new DateTime(date));
    }

    private static boolean isToday(Date date) {
        Interval today = new Interval(DateTime.now().withTimeAtStartOfDay(), Days.ONE);
        return today.contains(new DateTime(date));
    }

    private static boolean isYesterday(Date date) {
        DateTime yesterday = DateTime.now().minusDays(1);
        Interval yesterdayInterval = new Interval(yesterday.withTimeAtStartOfDay(), Days.ONE);
        return yesterdayInterval.contains(new DateTime(date));
    }
}
