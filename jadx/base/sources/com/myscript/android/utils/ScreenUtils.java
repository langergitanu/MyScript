package com.myscript.android.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class ScreenUtils {
    private static final Pattern CHROME_OS_R7X_PATTERN = Pattern.compile("^R7[0-3]-(.+)");

    private ScreenUtils() {
    }

    public static int dpToPx(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, getFixedDisplayMetrics(context));
    }

    public static int pxToDp(Context context, int i) {
        return (int) (i / getFixedDisplayMetrics(context).density);
    }

    public static float mmToPx(Context context, float f) {
        return TypedValue.applyDimension(5, f, getFixedDisplayMetrics(context));
    }

    public static float pxToMm(Context context, float f) {
        return f / TypedValue.applyDimension(5, 1.0f, getFixedDisplayMetrics(context));
    }

    public static DisplayMetrics getFixedDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (!isDpiReliable(context)) {
            float f = (((displayMetrics.scaledDensity * 16.0f) * 3.0f) * 25.4f) / 10.0f;
            displayMetrics.xdpi = f;
            displayMetrics.ydpi = f;
        }
        return displayMetrics;
    }

    private static boolean isDpiReliable(Context context) {
        if (Build.VERSION.SDK_INT == 26 && checkDeXEnabled(context)) {
            return false;
        }
        return (isChromeOS(context) && isDpiBuggyForChromeOSVersion(Build.ID)) ? false : true;
    }

    public static boolean isDpiBuggyForChromeOSVersion(String str) {
        return CHROME_OS_R7X_PATTERN.matcher(str).matches();
    }

    public static boolean checkDeXEnabled(Context context) {
        Configuration configuration;
        Class<?> cls;
        try {
            configuration = context.getResources().getConfiguration();
            cls = configuration.getClass();
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException unused) {
        }
        return cls.getField("SEM_DESKTOP_MODE_ENABLED").getInt(cls) == cls.getField("semDesktopModeEnabled").getInt(configuration);
    }

    public static boolean isChromeOS(Context context) {
        return context.getPackageManager().hasSystemFeature("org.chromium.arc");
    }
}
