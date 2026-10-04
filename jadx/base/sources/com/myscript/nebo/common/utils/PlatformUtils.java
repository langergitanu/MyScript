package com.myscript.nebo.common.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.webkit.URLUtil;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.myscript.nebo.common.C6183R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class PlatformUtils {
    private PlatformUtils() {
    }

    public static String[] permissionsToRequest(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean checkAndAskForPermissions(Activity activity, String[] strArr, int i) {
        String[] strArrPermissionsToRequest = permissionsToRequest(activity, strArr);
        if (strArrPermissionsToRequest.length == 0) {
            return true;
        }
        ActivityCompat.requestPermissions(activity, strArrPermissionsToRequest, i);
        return false;
    }

    public static void openPlayStore(Context context) {
        if (context == null) {
            return;
        }
        openPlayStore(context, context.getApplicationContext().getPackageName());
    }

    public static void openPlayStore(Context context, String str) {
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getPlayStoreURL(str))));
        }
    }

    public static String getPlayStoreURL(String str) {
        return "https://play.google.com/store/apps/details?id=" + str;
    }

    public static boolean isPackageInstalled(String str, Context context) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean openUrl(Context context, int i) {
        return openUrl(context, context.getString(i));
    }

    public static boolean openUrl(Context context, String str) {
        Resources resources = context.getResources();
        if (!URLUtil.isValidUrl(str)) {
            Log.e("PlatformUtils", "Url is not valid");
        }
        Intent data = new Intent("android.intent.action.VIEW").setData(Uri.parse(str));
        if (data.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(data);
            return true;
        }
        Toast.makeText(context, resources.getString(C6183R.string.error_no_app_installed_to_open_url), 0).show();
        return false;
    }

    public static String getVersion(Context context, int i) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName + "." + i;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }
}
