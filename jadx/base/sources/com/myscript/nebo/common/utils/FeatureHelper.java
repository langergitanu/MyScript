package com.myscript.nebo.common.utils;

import android.content.Context;
import android.content.DialogInterface;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.nebo.common.C6183R;

/* JADX INFO: loaded from: classes3.dex */
public final class FeatureHelper {
    private FeatureHelper() {
    }

    public static boolean checkFeatureAvailable(Context context, int i) {
        if (context.getResources().getBoolean(i)) {
            return true;
        }
        displayFeatureNotAvailable(context);
        return false;
    }

    public static void displayFeatureNotAvailable(Context context) {
        new MaterialAlertDialogBuilder(context).setMessage(C6183R.string.dialog_feature_not_available_message).setPositiveButton(C6183R.string.dialog_ok, (DialogInterface.OnClickListener) null).show();
    }
}
