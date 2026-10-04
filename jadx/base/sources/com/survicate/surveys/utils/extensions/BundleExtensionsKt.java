package com.survicate.surveys.utils.extensions;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BundleExtensions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a(\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003¨\u0006\t"}, m1599d2 = {"getParcelableCompat", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "Landroid/os/Bundle;", SubscriberAttributeKt.JSON_NAME_KEY, "", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "mergeWith", "other", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BundleExtensionsKt {
    public static final /* synthetic */ <T extends Parcelable> T getParcelableCompat(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) bundle.getParcelable(key, Parcelable.class);
        }
        T t = (T) bundle.getParcelable(key);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final Bundle mergeWith(Bundle bundle, Bundle other) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putAll(other);
        return bundle2;
    }
}
