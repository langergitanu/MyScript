package com.survicate.surveys.helpers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkStateProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\f\u0010\u0017\u001a\u00020\u000b*\u00020\u0013H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/helpers/NetworkStateProviderFromApi24;", "Lcom/survicate/surveys/helpers/NetworkStateProvider;", "Landroid/net/ConnectivityManager$NetworkCallback;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "networkObservable", "Lcom/survicate/surveys/helpers/Observable;", "", "mainHandler", "Landroid/os/Handler;", "isNetworkAvailable", "observeNetworkChanges", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "updateNetworkState", "isAvailable", "hasInternetCapability", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class NetworkStateProviderFromApi24 extends ConnectivityManager.NetworkCallback implements NetworkStateProvider {
    private final ConnectivityManager connectivityManager;
    private boolean isNetworkAvailable;
    private final Handler mainHandler;
    private final Observable<Boolean> networkObservable;

    public NetworkStateProviderFromApi24(Context context) {
        Network activeNetwork;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        this.connectivityManager = connectivityManager;
        this.networkObservable = new Observable<>();
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.isNetworkAvailable = (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null) ? false : hasInternetCapability(activeNetwork);
        if (connectivityManager != null) {
            connectivityManager.registerDefaultNetworkCallback(this);
        }
    }

    @Override // com.survicate.surveys.helpers.NetworkStateProvider
    /* JADX INFO: renamed from: isNetworkAvailable, reason: from getter */
    public boolean getIsNetworkAvailable() {
        return this.isNetworkAvailable;
    }

    @Override // com.survicate.surveys.helpers.NetworkStateProvider
    public Observable<Boolean> observeNetworkChanges() {
        return this.networkObservable;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onAvailable(network);
        updateNetworkState(true);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onLost(network);
        updateNetworkState(false);
    }

    private final void updateNetworkState(final boolean isAvailable) {
        if (this.isNetworkAvailable == isAvailable) {
            return;
        }
        this.isNetworkAvailable = isAvailable;
        this.mainHandler.post(new Runnable() { // from class: com.survicate.surveys.helpers.NetworkStateProviderFromApi24$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NetworkStateProviderFromApi24.updateNetworkState$lambda$0(this.f$0, isAvailable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateNetworkState$lambda$0(NetworkStateProviderFromApi24 networkStateProviderFromApi24, boolean z) {
        networkStateProviderFromApi24.networkObservable.notifyObservers(Boolean.valueOf(z));
    }

    private final boolean hasInternetCapability(Network network) {
        ConnectivityManager connectivityManager = this.connectivityManager;
        NetworkCapabilities networkCapabilities = connectivityManager != null ? connectivityManager.getNetworkCapabilities(network) : null;
        return networkCapabilities != null && networkCapabilities.hasCapability(12);
    }
}
