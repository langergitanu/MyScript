package com.myscript.nebo.help;

import androidx.browser.customtabs.CustomTabsClient;
import kotlin.Metadata;

/* JADX INFO: compiled from: ServiceConnection.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/help/ServiceConnectionCallback;", "", "onServiceConnected", "", "client", "Landroidx/browser/customtabs/CustomTabsClient;", "onServiceDisconnected", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ServiceConnectionCallback {
    void onServiceConnected(CustomTabsClient client);

    void onServiceDisconnected();
}
