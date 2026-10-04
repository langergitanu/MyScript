package com.myscript.nebo.crash;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.myscript.nebo.crash.CrashInfo;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CrashHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u001a(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007\u001a\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t\u001a\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u001a\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\b\u001a\u00020\t\u001a\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m1599d2 = {"CRASH_INFO_LIST", "", "CRASH_LIST_SIZE", "", "CRASH_INTERVAL_MINUTES", "MINUTES_TO_MILLIS", "addCrash", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "pageKey", "Lcom/myscript/snt/core/PageKey;", "shouldReset", "", "reset", "clearCrashList", "saveCrashList", "value", "", "Lcom/myscript/nebo/crash/CrashInfo;", "getCrashList", "isIntervalSmallerThanExpected", "timestampMillis1", "", "timestampMillis2", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CrashHandler {
    private static final String CRASH_INFO_LIST = "crash_info_list";
    private static final int CRASH_INTERVAL_MINUTES = 2;
    private static final int CRASH_LIST_SIZE = 3;
    private static final int MINUTES_TO_MILLIS = 60000;

    public static final void addCrash(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        addCrash$default(context, null, null, 6, null);
    }

    public static final void addCrash(Context context, NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        addCrash$default(context, notebookKey, null, 4, null);
    }

    public static /* synthetic */ void addCrash$default(Context context, NotebookKey notebookKey, PageKey pageKey, int i, Object obj) {
        if ((i & 2) != 0) {
            notebookKey = null;
        }
        if ((i & 4) != 0) {
            pageKey = null;
        }
        addCrash(context, notebookKey, pageKey);
    }

    public static final void addCrash(Context context, NotebookKey notebookKey, PageKey pageKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        CrashInfo crashInfo = new CrashInfo(notebookKey, pageKey, System.currentTimeMillis());
        List<CrashInfo> crashList = getCrashList(context);
        ArrayList arrayList = new ArrayList();
        for (Object obj : crashList) {
            if (isIntervalSmallerThanExpected(((CrashInfo) obj).getTimestamp(), crashInfo.getTimestamp())) {
                arrayList.add(obj);
            }
        }
        saveCrashList(context, CollectionsKt.plus((Collection<? extends CrashInfo>) arrayList, crashInfo));
    }

    public static final boolean shouldReset(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<CrashInfo> crashList = getCrashList(context);
        ArrayList arrayList = new ArrayList();
        for (Object obj : crashList) {
            if (isIntervalSmallerThanExpected(jCurrentTimeMillis, ((CrashInfo) obj).getTimestamp())) {
                arrayList.add(obj);
            }
        }
        return arrayList.size() >= 3;
    }

    public static final void reset(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        clearCrashList(context);
    }

    public static final void clearCrashList(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.remove(CRASH_INFO_LIST);
        editorEdit.apply();
    }

    public static final void saveCrashList(Context context, List<CrashInfo> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (list == null) {
            clearCrashList(context);
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        List<CrashInfo> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((CrashInfo) it.next()).serialize());
        }
        editorEdit.putStringSet(CRASH_INFO_LIST, CollectionsKt.toHashSet(arrayList));
        editorEdit.apply();
    }

    public static final List<CrashInfo> getCrashList(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set<String> stringSet = PreferenceManager.getDefaultSharedPreferences(context).getStringSet(CRASH_INFO_LIST, null);
        if (stringSet != null) {
            Set<String> set = stringSet;
            CrashInfo.Companion companion = CrashInfo.INSTANCE;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                arrayList.add(companion.deserialize((String) it.next()));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    private static final boolean isIntervalSmallerThanExpected(long j, long j2) {
        return Math.abs(j - j2) < 120000;
    }
}
