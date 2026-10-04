package com.myscript.android.utils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntentExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a\u001a\u0010\u0007\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002¨\u0006\n"}, m1599d2 = {"getParcelableWorkaround", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "Landroid/content/Intent;", SubscriberAttributeKt.JSON_NAME_KEY, "", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/os/Parcelable;", "putParcelableWorkaround", "", "value", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class IntentExt {
    public static final <T extends Parcelable> T getParcelableWorkaround(Intent intent, String key) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleExtra = intent.getBundleExtra(key);
        if (bundleExtra != null) {
            return (T) bundleExtra.getParcelable(key);
        }
        return null;
    }

    public static final void putParcelableWorkaround(Intent intent, String key, Parcelable value) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Bundle bundle = new Bundle();
        bundle.putParcelable(key, value);
        intent.putExtra(key, bundle);
    }
}
