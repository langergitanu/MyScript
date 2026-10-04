package com.revenuecat.purchases.common.events;

import kotlin.Metadata;

/* JADX INFO: compiled from: FeatureEvent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/FeatureEvent;", "", "isPriorityEvent", "", "()Z", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface FeatureEvent {
    default boolean isPriorityEvent() {
        return false;
    }

    /* JADX INFO: compiled from: FeatureEvent.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isPriorityEvent(FeatureEvent featureEvent) {
            return FeatureEvent.super.isPriorityEvent();
        }
    }
}
