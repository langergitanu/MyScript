package com.myscript.nebo.freemium;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InAppPurchaseController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m1599d2 = {"productFromProductId", "Lcom/myscript/nebo/freemium/InAppProduct;", "", "freemium_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InAppPurchaseControllerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final InAppProduct productFromProductId(String str) {
        if (Intrinsics.areEqual(str, InAppProduct.UnlimitedPages.getId())) {
            return InAppProduct.UnlimitedPages;
        }
        return null;
    }
}
