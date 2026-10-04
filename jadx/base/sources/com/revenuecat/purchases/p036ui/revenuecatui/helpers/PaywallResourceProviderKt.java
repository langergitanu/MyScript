package com.revenuecat.purchases.p036ui.revenuecatui.helpers;

import android.content.Context;
import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallResourceProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0000¨\u0006\t"}, m1599d2 = {"applicationName", "", "Landroid/content/Context;", "getResourceEntryNameOrNull", "Landroid/content/res/Resources;", "resourceId", "", "toResourceProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallResourceProviderKt {
    public static final ResourceProvider toResourceProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return new PaywallResourceProvider(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String applicationName(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getResourceEntryNameOrNull(Resources resources, int i) {
        try {
            return resources.getResourceEntryName(i);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }
}
