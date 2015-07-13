package com.tejaswi_yerukalapudi.hellomocks.lib.helper;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 *
 * Collection of static helper methods.
 *
 * Created by teja on 7/9/15.
 */
public class Helper {
    public static void showToast(Context ctx, String message) {
        Toast t = Toast.makeText(ctx, message, Toast.LENGTH_SHORT);
        t.show();
    }

    public static int getHeightForDp(ViewGroup parent, float dp) {
        DisplayMetrics metrics = parent.getResources().getDisplayMetrics();
        float fpixels = metrics.density * dp;
        return (int)(fpixels + 0.5f);
    }
}
