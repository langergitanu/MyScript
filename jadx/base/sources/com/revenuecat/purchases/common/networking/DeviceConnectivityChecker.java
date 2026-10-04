package com.revenuecat.purchases.common.networking;

import android.content.Context;
import android.net.ConnectivityManager;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceConnectivityChecker.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/DeviceConnectivityChecker;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "applicationContext", "kotlin.jvm.PlatformType", "isDeviceOffline", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class DeviceConnectivityChecker {
    private final Context applicationContext;

    public DeviceConnectivityChecker(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.applicationContext = context.getApplicationContext();
    }

    public final boolean isDeviceOffline() {
        try {
            Object systemService = this.applicationContext.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager == null) {
                return false;
            }
            return connectivityManager.getActiveNetwork() == null;
        } catch (RuntimeException e) {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Could not determine device connectivity, assuming online: " + e);
            }
            return false;
        }
    }
}
