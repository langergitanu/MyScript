package com.revenuecat.purchases.p036ui.revenuecatui.helpers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TestTag.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/TestTag;", "", "()V", "PURCHASE_BUTTON_TAG", "", "selectButtonTestTag", "packageId", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class TestTag {
    public static final int $stable = 0;
    public static final TestTag INSTANCE = new TestTag();
    public static final String PURCHASE_BUTTON_TAG = "PurchaseButton";

    private TestTag() {
    }

    public final String selectButtonTestTag(String packageId) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        return "SelectButton_" + packageId;
    }
}
