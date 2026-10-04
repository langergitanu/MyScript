package com.myscript.nebo.common.debug;

import kotlin.Metadata;

/* JADX INFO: compiled from: UOCView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m1599d2 = {"countToPercent", "", "count", "", "max", "INFINITY_CHAR", "", "common_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UOCViewKt {
    private static final String INFINITY_CHAR = "∞";

    /* JADX INFO: Access modifiers changed from: private */
    public static final float countToPercent(long j, long j2) {
        if (j2 == 0) {
            return 0.0f;
        }
        return j / j2;
    }
}
