package com.myscript.nebo.common;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.format.DateFormat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.GoogleApiAvailability;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes3.dex */
public class CommonUtils {
    public static final String APPLICATION_IS_ACTIVE_PEN_MODE_KEY = "APPLICATION_IS_ACTIVE_PEN_MODE_KEY";
    public static final String APPLICATION_IS_PEN_KEY = "APPLICATION_IS_PEN_KEY";
    public static final String COMMON_PREFERENCES_NAME = "common::prefs";

    public static void saveActivePenMode(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(COMMON_PREFERENCES_NAME, 0);
        if (sharedPreferences.contains(APPLICATION_IS_ACTIVE_PEN_MODE_KEY) && sharedPreferences.getBoolean(APPLICATION_IS_ACTIVE_PEN_MODE_KEY, false) == z) {
            return;
        }
        sharedPreferences.edit().putBoolean(APPLICATION_IS_ACTIVE_PEN_MODE_KEY, z).commit();
    }

    public static boolean isActivePenModeAlreadyChosen(Context context) {
        return context.getSharedPreferences(COMMON_PREFERENCES_NAME, 0).contains(APPLICATION_IS_ACTIVE_PEN_MODE_KEY);
    }

    public static boolean isActivePenMode(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(COMMON_PREFERENCES_NAME, 0);
        return sharedPreferences.contains(APPLICATION_IS_ACTIVE_PEN_MODE_KEY) && sharedPreferences.getBoolean(APPLICATION_IS_ACTIVE_PEN_MODE_KEY, isPenUsed(context));
    }

    public static void savePenUsed(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(COMMON_PREFERENCES_NAME, 0);
        if (sharedPreferences.contains(APPLICATION_IS_PEN_KEY) && sharedPreferences.getBoolean(APPLICATION_IS_PEN_KEY, false) == z) {
            return;
        }
        sharedPreferences.edit().putBoolean(APPLICATION_IS_PEN_KEY, z).commit();
    }

    public static boolean isPenUsed(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(COMMON_PREFERENCES_NAME, 0);
        return sharedPreferences.contains(APPLICATION_IS_PEN_KEY) && sharedPreferences.getBoolean(APPLICATION_IS_PEN_KEY, false);
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static String formatTimestampToString(Context context, long j) {
        SimpleDateFormat simpleDateFormat;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        long j2 = j / 1000;
        gregorianCalendar.setTimeInMillis(j2);
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 0);
        gregorianCalendar.set(14, 0);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(System.currentTimeMillis());
        gregorianCalendar2.set(11, 0);
        gregorianCalendar2.set(12, 0);
        gregorianCalendar2.set(13, 0);
        gregorianCalendar2.set(14, 0);
        long timeInMillis = (gregorianCalendar2.getTimeInMillis() - gregorianCalendar.getTimeInMillis()) / 86400000;
        boolean zIs24HourFormat = DateFormat.is24HourFormat(context);
        Resources resources = context.getResources();
        if (timeInMillis < 1) {
            simpleDateFormat = new SimpleDateFormat(resources.getString(zIs24HourFormat ? C6183R.string.dms_date_format_today_24h : C6183R.string.dms_date_format_today_12h));
        } else if (timeInMillis < 2) {
            simpleDateFormat = new SimpleDateFormat(resources.getString(zIs24HourFormat ? C6183R.string.dms_date_format_yesterday_24h : C6183R.string.dms_date_format_yesterday));
        } else if (timeInMillis < 7) {
            simpleDateFormat = new SimpleDateFormat(resources.getString(zIs24HourFormat ? C6183R.string.dms_date_format_week_24h : C6183R.string.dms_date_format_week));
        } else {
            simpleDateFormat = new SimpleDateFormat(resources.getString(C6183R.string.dms_date_format_general));
        }
        return simpleDateFormat.format(new Date(j2));
    }

    public static String formatTimestampToSimpleDateString(Context context, long j) {
        long j2 = j / 1000;
        new GregorianCalendar().setTimeInMillis(j2);
        return new SimpleDateFormat(context.getResources().getString(C6183R.string.dms_date_format_general)).format(new Date(j2));
    }

    public static String getHumanReadableByteCount(long j, boolean z) {
        int i = z ? 1000 : 1024;
        long jAbs = j == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(j);
        long j2 = i;
        if (jAbs < j2) {
            return j + " B";
        }
        double d = i;
        int iLog = (int) (Math.log(jAbs) / Math.log(d));
        long jCeil = (long) Math.ceil(Math.pow(d, iLog) * (d - 0.05d));
        if (iLog < 6) {
            if (jAbs >= jCeil - ((long) ((4095 & jCeil) == 3328 ? 51 : 0))) {
                iLog++;
            }
        }
        String str = (z ? "kMGTPE" : "KMGTPE").charAt(iLog - 1) + (z ? "" : CmcdData.OBJECT_TYPE_INIT_SEGMENT);
        if (iLog > 4) {
            j /= j2;
            iLog--;
        }
        return String.format("%.1f %sB", Double.valueOf(j / Math.pow(d, iLog)), str);
    }

    public static boolean isGooglePlayServiceAvailable(Activity activity) {
        return isGooglePlayServiceAvailable(activity, -1);
    }

    public static boolean isGooglePlayServiceAvailable(Activity activity, int i) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(activity);
        if (iIsGooglePlayServicesAvailable == 0) {
            return true;
        }
        if (!googleApiAvailability.isUserResolvableError(iIsGooglePlayServicesAvailable) || i == -1) {
            return false;
        }
        googleApiAvailability.getErrorDialog(activity, iIsGooglePlayServicesAvailable, i).show();
        return false;
    }
}
