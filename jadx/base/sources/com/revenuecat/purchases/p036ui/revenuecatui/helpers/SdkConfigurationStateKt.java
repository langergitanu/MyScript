package com.revenuecat.purchases.p036ui.revenuecatui.helpers;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesConfiguration;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkConfigurationState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0000\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"SDK_CONFIG_EXTRA", "", "restoreSdkConfigurationIfNeeded", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "savedInstanceState", "Landroid/os/Bundle;", "saveSdkConfiguration", "outState", "getSdkConfigurationState", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/SdkConfigurationState;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class SdkConfigurationStateKt {
    private static final String SDK_CONFIG_EXTRA = "sdk_config_args";

    private static final SdkConfigurationState getSdkConfigurationState(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 33) {
            return (SdkConfigurationState) bundle.getParcelable(SDK_CONFIG_EXTRA, SdkConfigurationState.class);
        }
        return (SdkConfigurationState) bundle.getParcelable(SDK_CONFIG_EXTRA);
    }

    public static final void saveSdkConfiguration(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        if (Purchases.INSTANCE.isConfigured()) {
            outState.putParcelable(SDK_CONFIG_EXTRA, SdkConfigurationState.INSTANCE.from(Purchases.INSTANCE.getSharedInstance().getCurrentConfiguration()));
        }
    }

    public static final void restoreSdkConfigurationIfNeeded(Context context, Bundle bundle) {
        SdkConfigurationState sdkConfigurationState;
        Intrinsics.checkNotNullParameter(context, "context");
        if (bundle == null || (sdkConfigurationState = getSdkConfigurationState(bundle)) == null) {
            return;
        }
        PurchasesConfiguration configuration = sdkConfigurationState.toConfiguration(context);
        if (Purchases.INSTANCE.isConfigured()) {
            if (Intrinsics.areEqual(Purchases.INSTANCE.getSharedInstance().getCurrentConfiguration(), configuration)) {
                Logger.INSTANCE.m1586i("Skipping Purchases reconfiguration, configuration is unchanged.");
                return;
            } else {
                Logger.INSTANCE.m1586i("Purchases already configured with different parameters; not reconfiguring.");
                return;
            }
        }
        Purchases.INSTANCE.configure(configuration);
    }
}
