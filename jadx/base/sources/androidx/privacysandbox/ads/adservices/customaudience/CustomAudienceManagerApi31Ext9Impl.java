package androidx.privacysandbox.ads.adservices.customaudience;

import android.content.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomAudienceManagerApi31Ext9Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudienceManagerApi31Ext9Impl;", "Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudienceManagerImplCommon;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "ads-adservices_release"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CustomAudienceManagerApi31Ext9Impl extends CustomAudienceManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    public CustomAudienceManagerApi31Ext9Impl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        android.adservices.customaudience.CustomAudienceManager customAudienceManager = android.adservices.customaudience.CustomAudienceManager.get(context);
        Intrinsics.checkNotNullExpressionValue(customAudienceManager, "get(context)");
        super(customAudienceManager);
    }
}
