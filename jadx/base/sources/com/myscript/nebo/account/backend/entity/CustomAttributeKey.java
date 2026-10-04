package com.myscript.nebo.account.backend.entity;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: InApp.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/entity/CustomAttributeKey;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "PurchaseState", "ProductId", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CustomAttributeKey {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CustomAttributeKey[] $VALUES;
    private final String key;
    public static final CustomAttributeKey PurchaseState = new CustomAttributeKey("PurchaseState", 0, "purchaseState");
    public static final CustomAttributeKey ProductId = new CustomAttributeKey("ProductId", 1, "productId");

    private static final /* synthetic */ CustomAttributeKey[] $values() {
        return new CustomAttributeKey[]{PurchaseState, ProductId};
    }

    public static EnumEntries<CustomAttributeKey> getEntries() {
        return $ENTRIES;
    }

    public static CustomAttributeKey valueOf(String str) {
        return (CustomAttributeKey) Enum.valueOf(CustomAttributeKey.class, str);
    }

    public static CustomAttributeKey[] values() {
        return (CustomAttributeKey[]) $VALUES.clone();
    }

    private CustomAttributeKey(String str, int i, String str2) {
        this.key = str2;
    }

    public final String getKey() {
        return this.key;
    }

    static {
        CustomAttributeKey[] customAttributeKeyArr$values = $values();
        $VALUES = customAttributeKeyArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(customAttributeKeyArr$values);
    }
}
