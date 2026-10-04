package com.myscript.nebo.help;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ServiceConnection.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/help/ServiceConnection;", "Landroidx/browser/customtabs/CustomTabsServiceConnection;", "connectionCallback", "Lcom/myscript/nebo/help/ServiceConnectionCallback;", "<init>", "(Lcom/myscript/nebo/help/ServiceConnectionCallback;)V", "Ljava/lang/ref/WeakReference;", "onCustomTabsServiceConnected", "", "name", "Landroid/content/ComponentName;", "client", "Landroidx/browser/customtabs/CustomTabsClient;", "onServiceDisconnected", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ServiceConnection extends CustomTabsServiceConnection {
    public static final int $stable = 8;
    private final WeakReference<ServiceConnectionCallback> connectionCallback;

    public ServiceConnection(ServiceConnectionCallback connectionCallback) {
        Intrinsics.checkNotNullParameter(connectionCallback, "connectionCallback");
        this.connectionCallback = new WeakReference<>(connectionCallback);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(client, "client");
        ServiceConnectionCallback serviceConnectionCallback = this.connectionCallback.get();
        if (serviceConnectionCallback != null) {
            serviceConnectionCallback.onServiceConnected(client);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        Intrinsics.checkNotNullParameter(name, "name");
        ServiceConnectionCallback serviceConnectionCallback = this.connectionCallback.get();
        if (serviceConnectionCallback != null) {
            serviceConnectionCallback.onServiceDisconnected();
        }
    }
}
