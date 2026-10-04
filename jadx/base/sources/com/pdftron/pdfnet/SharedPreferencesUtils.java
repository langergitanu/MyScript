package com.pdftron.pdfnet;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* JADX INFO: loaded from: classes7.dex */
class SharedPreferencesUtils {
    private static final String KEY_PREF_TRIAL_KEY = "pref_pdftron_trial_key";

    SharedPreferencesUtils() {
    }

    static SharedPreferences getDefaultSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
    }

    static String getTrialKey(Context context) {
        return getDefaultSharedPreferences(context).getString(KEY_PREF_TRIAL_KEY, null);
    }

    static void setTrialKey(Context context, String str) {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(context).edit();
        editorEdit.putString(KEY_PREF_TRIAL_KEY, str);
        editorEdit.apply();
    }
}
