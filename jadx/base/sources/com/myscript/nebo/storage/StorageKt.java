package com.myscript.nebo.storage;

import android.os.Bundle;
import kotlin.Metadata;

/* JADX INFO: compiled from: Storage.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m1599d2 = {"getStorageAnalytics", "Landroid/os/Bundle;", "isPopup", "", "availableSpace", "", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StorageKt {
    public static final Bundle getStorageAnalytics(boolean z, long j) {
        String str;
        int i = (int) (j / ((long) 1000000));
        if (i < 10) {
            str = "0-10";
        } else if (i < 50) {
            str = "10-50";
        } else if (i < 100) {
            str = "50-100";
        } else if (i < 300) {
            str = "100-300";
        } else if (i < 500) {
            str = "300-500";
        } else {
            str = "500+";
        }
        Bundle bundle = new Bundle();
        bundle.putString("notification_type", z ? "popup" : "banner");
        bundle.putInt("storage_value", i);
        bundle.putString("storage_bucket", str);
        return bundle;
    }
}
