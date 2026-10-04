package com.revenuecat.purchases.common;

import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.events.BackendEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StorePlatform.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"platformName", "", "Lcom/revenuecat/purchases/Store;", "getPlatformName", "(Lcom/revenuecat/purchases/Store;)Ljava/lang/String;", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class StorePlatformKt {

    /* JADX INFO: compiled from: StorePlatform.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.AMAZON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String getPlatformName(Store store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        if (WhenMappings.$EnumSwitchMapping$0[store.ordinal()] == 1) {
            return "amazon";
        }
        return BackendEvent.Workflows.Context.WORKFLOW_CONTEXT_PLATFORM;
    }
}
