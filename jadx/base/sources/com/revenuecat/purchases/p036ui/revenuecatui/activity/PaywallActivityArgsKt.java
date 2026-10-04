package com.revenuecat.purchases.p036ui.revenuecatui.activity;

import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: compiled from: PaywallActivityArgs.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"DEFAULT_DISPLAY_DISMISS_BUTTON", "", "defaultEdgeToEdge", "getDefaultEdgeToEdge", "()Z", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallActivityArgsKt {
    public static final boolean DEFAULT_DISPLAY_DISMISS_BUTTON = true;
    private static final boolean defaultEdgeToEdge;

    static {
        defaultEdgeToEdge = Build.VERSION.SDK_INT >= 35;
    }

    public static final boolean getDefaultEdgeToEdge() {
        return defaultEdgeToEdge;
    }
}
