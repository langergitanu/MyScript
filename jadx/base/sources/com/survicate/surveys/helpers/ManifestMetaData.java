package com.survicate.surveys.helpers;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManifestMetaData.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0014\u0010\t\u001a\u00020\n*\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/helpers/ManifestMetaData;", "", "<init>", "()V", "obtainOrNull", "", SubscriberAttributeKt.JSON_NAME_KEY, WebViewMessageType.CONTEXT, "Landroid/content/Context;", "getApplicationInfoCompat", "Landroid/content/pm/ApplicationInfo;", "flags", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ManifestMetaData {
    public static final ManifestMetaData INSTANCE = new ManifestMetaData();

    private ManifestMetaData() {
    }

    @JvmStatic
    public static final String obtainOrNull(String key, Context context) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = INSTANCE.getApplicationInfoCompat(context, 128).metaData;
        if (bundle != null) {
            return bundle.getString(key);
        }
        return null;
    }

    private final ApplicationInfo getApplicationInfoCompat(Context context, int i) throws PackageManager.NameNotFoundException {
        if (Build.VERSION.SDK_INT >= 33) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(i));
            Intrinsics.checkNotNull(applicationInfo);
            return applicationInfo;
        }
        ApplicationInfo applicationInfo2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), i);
        Intrinsics.checkNotNull(applicationInfo2);
        return applicationInfo2;
    }
}
