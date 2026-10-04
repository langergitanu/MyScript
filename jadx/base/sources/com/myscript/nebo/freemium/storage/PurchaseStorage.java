package com.myscript.nebo.freemium.storage;

import com.myscript.nebo.freemium.InAppProduct;
import kotlin.Metadata;

/* JADX INFO: compiled from: PurchaseSecuredStorage.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\rÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/freemium/storage/PurchaseStorage;", "", "store", "", "productId", "", "purchaseToken", "get", "product", "Lcom/myscript/nebo/freemium/InAppProduct;", "has", "", "remove", "freemium_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface PurchaseStorage {
    String get(InAppProduct product);

    boolean has(InAppProduct product);

    void remove(InAppProduct product);

    void store(String productId, String purchaseToken);
}
