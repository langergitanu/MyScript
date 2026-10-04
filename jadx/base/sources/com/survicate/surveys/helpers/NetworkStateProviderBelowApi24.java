package com.survicate.surveys.helpers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkStateProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0005*\u0001\f\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\nH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0010"}, m1599d2 = {"Lcom/survicate/surveys/helpers/NetworkStateProviderBelowApi24;", "Lcom/survicate/surveys/helpers/NetworkStateProvider;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "networkObservable", "Lcom/survicate/surveys/helpers/Observable;", "", "connectivityReceiver", "com/survicate/surveys/helpers/NetworkStateProviderBelowApi24$connectivityReceiver$1", "Lcom/survicate/surveys/helpers/NetworkStateProviderBelowApi24$connectivityReceiver$1;", "isNetworkAvailable", "observeNetworkChanges", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class NetworkStateProviderBelowApi24 implements NetworkStateProvider {
    private final ConnectivityManager connectivityManager;
    private final NetworkStateProviderBelowApi24$connectivityReceiver$1 connectivityReceiver;
    private final Observable<Boolean> networkObservable;

    /* JADX WARN: Type inference failed for: r0v6, types: [com.survicate.surveys.helpers.NetworkStateProviderBelowApi24$connectivityReceiver$1] */
    public NetworkStateProviderBelowApi24(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        this.connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        this.networkObservable = new Observable<>();
        ?? r0 = new BroadcastReceiver() { // from class: com.survicate.surveys.helpers.NetworkStateProviderBelowApi24$connectivityReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                this.this$0.networkObservable.notifyObservers(Boolean.valueOf(this.this$0.getIsNetworkAvailable()));
            }
        };
        this.connectivityReceiver = r0;
        context.registerReceiver((BroadcastReceiver) r0, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // com.survicate.surveys.helpers.NetworkStateProvider
    /* JADX INFO: renamed from: isNetworkAvailable */
    public boolean getIsNetworkAvailable() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = this.connectivityManager;
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnectedOrConnecting();
    }

    @Override // com.survicate.surveys.helpers.NetworkStateProvider
    public Observable<Boolean> observeNetworkChanges() {
        return this.networkObservable;
    }
}
