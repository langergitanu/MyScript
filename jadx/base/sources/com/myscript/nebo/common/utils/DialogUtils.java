package com.myscript.nebo.common.utils;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogUtils {
    private DialogUtils() {
    }

    public static Intent createCustomChooser(Intent intent, String str, Intent[] intentArr, PackageManager packageManager) {
        ArrayList arrayList = new ArrayList();
        for (Intent intent2 : intentArr) {
            addAppInChooser(arrayList, getItemListPackageNames(intent, packageManager), intent2, packageManager);
        }
        LabeledIntent[] labeledIntentArr = (LabeledIntent[]) arrayList.toArray(new LabeledIntent[arrayList.size()]);
        Intent intentCreateChooser = Intent.createChooser(intent, str);
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", labeledIntentArr);
        return intentCreateChooser;
    }

    public static ArrayList<String> getItemListPackageNames(Intent intent, PackageManager packageManager) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 0).iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().activityInfo.packageName);
        }
        return arrayList;
    }

    private static boolean isPackageInList(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static void addAppInChooser(List<LabeledIntent> list, ArrayList<String> arrayList, Intent intent, PackageManager packageManager) {
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            if (!isPackageInList(resolveInfo.activityInfo.packageName, (String[]) arrayList.toArray(new String[arrayList.size()]))) {
                list.add(new LabeledIntent(intent, resolveInfo.activityInfo.packageName, resolveInfo.loadLabel(packageManager), resolveInfo.icon));
            }
        }
    }
}
