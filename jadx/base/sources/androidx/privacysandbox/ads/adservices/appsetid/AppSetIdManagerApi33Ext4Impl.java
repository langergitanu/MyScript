package androidx.privacysandbox.ads.adservices.appsetid;

import android.content.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppSetIdManagerApi33Ext4Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManagerApi33Ext4Impl;", "Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManagerImplCommon;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "ads-adservices_release"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class AppSetIdManagerApi33Ext4Impl extends AppSetIdManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    public AppSetIdManagerApi33Ext4Impl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService((Class<Object>) android.adservices.appsetid.AppSetIdManager.class);
        Intrinsics.checkNotNullExpressionValue(systemService, "context.getSystemService…SetIdManager::class.java)");
        super((android.adservices.appsetid.AppSetIdManager) systemService);
    }
}
