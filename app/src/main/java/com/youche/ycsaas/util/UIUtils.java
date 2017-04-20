package com.youche.ycsaas.util;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by SuChangz on 2017/4/19.
 * Desc
 */

public class UIUtils {

    private static ProgressDialog sProgressDialog;

    public static void showLoading(Context context, String message) {
        if (sProgressDialog == null) {
            sProgressDialog = new ProgressDialog(context);
            sProgressDialog.setMessage(message);
        }
        if (!sProgressDialog.isShowing()) {
            sProgressDialog.show();
        }
    }

    public static void dismissLoading(Context context) {
        if (sProgressDialog != null && sProgressDialog.isShowing()) {
            sProgressDialog.dismiss();
            sProgressDialog = null;
        }
    }
}
