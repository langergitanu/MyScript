package com.revenuecat.purchases.common.remoteconfig;

import kotlin.Metadata;

/* JADX INFO: compiled from: RemoteConfigCommitListener.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigCommitListener;", "", "onConfigCommitted", "", "generation", "", "onConfigInvalidated", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface RemoteConfigCommitListener {
    void onConfigCommitted(int generation);

    default void onConfigInvalidated(int generation) {
    }

    /* JADX INFO: compiled from: RemoteConfigCommitListener.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onConfigInvalidated(RemoteConfigCommitListener remoteConfigCommitListener, int i) {
            RemoteConfigCommitListener.super.onConfigInvalidated(i);
        }
    }
}
