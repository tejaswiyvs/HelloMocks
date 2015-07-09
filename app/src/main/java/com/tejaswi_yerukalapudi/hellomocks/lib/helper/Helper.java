package com.tejaswi_yerukalapudi.hellomocks.lib.helper;

import android.content.Context;
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
}
