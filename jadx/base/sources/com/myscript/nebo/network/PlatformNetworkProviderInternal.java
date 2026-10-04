package com.myscript.nebo.network;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import androidx.media3.common.MimeTypes;
import com.myscript.nebo.network.NetworkProviderInternal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlatformNetworkProviderInternal.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/network/PlatformNetworkProviderInternal;", "Lcom/myscript/nebo/network/NetworkProviderInternal;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "networkChangedCallbacks", "", "Lcom/myscript/nebo/network/NetworkProviderInternal$Callback;", "connManagerNetworkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "notifyNetworkChange", "", "hasNetwork", "", "registerNetworkChanges", "callback", "unregisterNetworkChanges", "isNetworkWithoutCharges", "hasInternetAccess", "isNetworkType", "networkType", "", "getActiveNetworkInfo", "Landroid/net/NetworkInfo;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PlatformNetworkProviderInternal implements NetworkProviderInternal {
    public static final int $stable = 8;
    private final Application application;
    private final ConnectivityManager.NetworkCallback connManagerNetworkCallback;
    private final List<NetworkProviderInternal.Callback> networkChangedCallbacks;

    public PlatformNetworkProviderInternal(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.networkChangedCallbacks = new ArrayList();
        this.connManagerNetworkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.myscript.nebo.network.PlatformNetworkProviderInternal$connManagerNetworkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                this.this$0.notifyNetworkChange(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                this.this$0.notifyNetworkChange(false);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyNetworkChange(boolean hasNetwork) {
        ArrayList arrayList;
        synchronized (this.networkChangedCallbacks) {
            arrayList = new ArrayList(this.networkChangedCallbacks);
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((NetworkProviderInternal.Callback) it.next()).onNetworkChanged(hasNetwork);
        }
    }

    @Override // com.myscript.nebo.network.NetworkProviderInternal
    public void registerNetworkChanges(NetworkProviderInternal.Callback callback) {
        boolean zIsEmpty;
        ConnectivityManager connectivityManager;
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this.networkChangedCallbacks) {
            zIsEmpty = this.networkChangedCallbacks.isEmpty();
            this.networkChangedCallbacks.add(callback);
        }
        if (!zIsEmpty || (connectivityManager = (ConnectivityManager) this.application.getSystemService(ConnectivityManager.class)) == null) {
            return;
        }
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(16).build(), this.connManagerNetworkCallback);
    }

    @Override // com.myscript.nebo.network.NetworkProviderInternal
    public void unregisterNetworkChanges(NetworkProviderInternal.Callback callback) {
        boolean zIsEmpty;
        ConnectivityManager connectivityManager;
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this.networkChangedCallbacks) {
            this.networkChangedCallbacks.remove(callback);
            zIsEmpty = this.networkChangedCallbacks.isEmpty();
            Unit unit = Unit.INSTANCE;
        }
        if (!zIsEmpty || (connectivityManager = (ConnectivityManager) this.application.getSystemService(ConnectivityManager.class)) == null) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(this.connManagerNetworkCallback);
    }

    @Override // com.myscript.nebo.network.NetworkProviderInternal
    public boolean isNetworkWithoutCharges() {
        return isNetworkType(1) || isNetworkType(9);
    }

    @Override // com.myscript.nebo.network.NetworkProviderInternal
    public boolean hasInternetAccess() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnected();
        }
        return false;
    }

    private final boolean isNetworkType(int networkType) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == networkType;
    }

    private final NetworkInfo getActiveNetworkInfo() {
        return ((ConnectivityManager) this.application.getSystemService(ConnectivityManager.class)).getActiveNetworkInfo();
    }
}
