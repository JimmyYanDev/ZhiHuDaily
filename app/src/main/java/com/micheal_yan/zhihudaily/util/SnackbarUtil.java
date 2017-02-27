package com.micheal_yan.zhihudaily.util;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by micheal-yan on 2017/2/27.
 */

public class SnackbarUtil {

    public static void show(View view, String msg){
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }

    public static void showLong(View view, String msg){
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }
}
