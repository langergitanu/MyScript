package com.myscript.nebo.help;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomTabsHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/help/CustomTabsHelper;", "", "<init>", "()V", "TAG", "", "ACTION_CUSTOM_TABS_CONNECTION", "WELL_FORMED_SAMPLE_URL", "packageNameToUse", "getPackageNameToUse", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "hasSpecializedHandlerIntents", "", "intent", "Landroid/content/Intent;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CustomTabsHelper {
    private static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
    private static final String TAG = "CustomTabsHelper";
    private static final String WELL_FORMED_SAMPLE_URL = "https://www.google.com";
    private static String packageNameToUse;
    public static final CustomTabsHelper INSTANCE = new CustomTabsHelper();
    public static final int $stable = 8;

    private CustomTabsHelper() {
    }

    public final String getPackageNameToUse(Context context) {
        ActivityInfo activityInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = packageNameToUse;
        if (str != null) {
            return str;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(WELL_FORMED_SAMPLE_URL));
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
        String str2 = null;
        String str3 = (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) ? null : activityInfo.packageName;
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction("android.support.customtabs.action.CustomTabsService");
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            String str4 = packageManager.resolveService(intent2, 0) != null ? resolveInfo.activityInfo.packageName : null;
            if (str4 != null) {
                arrayList.add(str4);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            String str5 = str3;
            str2 = (str5 == null || str5.length() == 0 || hasSpecializedHandlerIntents(context, intent) || !arrayList2.contains(str3)) ? (String) arrayList2.get(0) : str3;
        }
        packageNameToUse = str2;
        return str2;
    }

    private final boolean hasSpecializedHandlerIntents(Context context, Intent intent) {
        IntentFilter intentFilter;
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
            Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
            if (listQueryIntentActivities.isEmpty()) {
                return false;
            }
            List<ResolveInfo> list = listQueryIntentActivities;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            for (ResolveInfo resolveInfo : list) {
                if (resolveInfo.activityInfo != null && ((intentFilter = resolveInfo.filter) == null || intentFilter.countDataAuthorities() != 0)) {
                    if (resolveInfo.filter.countDataPaths() != 0) {
                        return true;
                    }
                }
            }
            return false;
        } catch (RuntimeException e) {
            Log.e(TAG, "Error while getting specialized handlers", e);
            return false;
        }
    }
}
