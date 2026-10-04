package com.myscript.nebo.network;

import kotlin.Metadata;

/* JADX INFO: compiled from: NeboNetworkStateRepositoryImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\nJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&¨\u0006\u000bÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/network/NetworkProviderInternal;", "", "registerNetworkChanges", "", "callback", "Lcom/myscript/nebo/network/NetworkProviderInternal$Callback;", "unregisterNetworkChanges", "hasInternetAccess", "", "isNetworkWithoutCharges", "Callback", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface NetworkProviderInternal {

    /* JADX INFO: compiled from: NeboNetworkStateRepositoryImpl.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/network/NetworkProviderInternal$Callback;", "", "onNetworkChanged", "", "hasInternet", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Callback {
        void onNetworkChanged(boolean hasInternet);
    }

    boolean hasInternetAccess();

    boolean isNetworkWithoutCharges();

    void registerNetworkChanges(Callback callback);

    void unregisterNetworkChanges(Callback callback);
}
