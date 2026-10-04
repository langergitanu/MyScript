package com.revenuecat.purchases.p036ui.revenuecatui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallMode.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"isFullScreen", "", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;)Z", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallModeKt {
    public static final boolean isFullScreen(PaywallMode paywallMode) {
        Intrinsics.checkNotNullParameter(paywallMode, "<this>");
        return paywallMode == PaywallMode.FULL_SCREEN;
    }
}
