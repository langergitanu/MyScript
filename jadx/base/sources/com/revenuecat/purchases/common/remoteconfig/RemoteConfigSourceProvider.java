package com.revenuecat.purchases.common.remoteconfig;

import com.revenuecat.purchases.common.remoteconfig.RemoteConfigSourceHandle;
import kotlin.Metadata;

/* JADX INFO: compiled from: RemoteConfigSourceProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceProvider;", "", "clear", "", "currentAPISource", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle;", "getCurrent", "purpose", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle$Purpose;", "reportUnhealthy", "handle", "restart", "restartIfExhausted", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface RemoteConfigSourceProvider {
    default void clear() {
    }

    RemoteConfigSourceHandle getCurrent(RemoteConfigSourceHandle.Purpose purpose);

    void reportUnhealthy(RemoteConfigSourceHandle handle);

    void restart(RemoteConfigSourceHandle.Purpose purpose);

    boolean restartIfExhausted(RemoteConfigSourceHandle.Purpose purpose);

    /* JADX INFO: compiled from: RemoteConfigSourceProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static RemoteConfigSourceHandle currentAPISource(RemoteConfigSourceProvider remoteConfigSourceProvider) {
            return RemoteConfigSourceProvider.super.currentAPISource();
        }

        @Deprecated
        public static void clear(RemoteConfigSourceProvider remoteConfigSourceProvider) {
            RemoteConfigSourceProvider.super.clear();
        }
    }

    default RemoteConfigSourceHandle currentAPISource() {
        return getCurrent(RemoteConfigSourceHandle.Purpose.API);
    }
}
