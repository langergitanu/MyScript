package com.myscript.nebo.purchase;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: IPurchaseProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/purchase/PurchaseErrorKind;", "", "<init>", "(Ljava/lang/String;I)V", "BillingUnavailable", "Network", "Other", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PurchaseErrorKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PurchaseErrorKind[] $VALUES;
    public static final PurchaseErrorKind BillingUnavailable = new PurchaseErrorKind("BillingUnavailable", 0);
    public static final PurchaseErrorKind Network = new PurchaseErrorKind("Network", 1);
    public static final PurchaseErrorKind Other = new PurchaseErrorKind("Other", 2);

    private static final /* synthetic */ PurchaseErrorKind[] $values() {
        return new PurchaseErrorKind[]{BillingUnavailable, Network, Other};
    }

    public static EnumEntries<PurchaseErrorKind> getEntries() {
        return $ENTRIES;
    }

    public static PurchaseErrorKind valueOf(String str) {
        return (PurchaseErrorKind) Enum.valueOf(PurchaseErrorKind.class, str);
    }

    public static PurchaseErrorKind[] values() {
        return (PurchaseErrorKind[]) $VALUES.clone();
    }

    static {
        PurchaseErrorKind[] purchaseErrorKindArr$values = $values();
        $VALUES = purchaseErrorKindArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(purchaseErrorKindArr$values);
    }

    private PurchaseErrorKind(String str, int i) {
    }
}
