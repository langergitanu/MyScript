package com.myscript.nebo.freemium;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: InAppPurchaseController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/freemium/InAppProduct;", "", "id", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "UnlimitedPages", "Lifetime", "ReferencePrice", "FakeInApp", "freemium_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InAppProduct {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InAppProduct[] $VALUES;
    private final String id;
    public static final InAppProduct UnlimitedPages = new InAppProduct("UnlimitedPages", 0, "com.myscript.nebo.fullpack");
    public static final InAppProduct Lifetime = new InAppProduct("Lifetime", 1, "msnotes_standard_lifetime");
    public static final InAppProduct ReferencePrice = new InAppProduct("ReferencePrice", 2, "com.myscript.nebo.pricereference");
    public static final InAppProduct FakeInApp = new InAppProduct("FakeInApp", 3, "com.myscript.nebo.dev");

    private static final /* synthetic */ InAppProduct[] $values() {
        return new InAppProduct[]{UnlimitedPages, Lifetime, ReferencePrice, FakeInApp};
    }

    public static EnumEntries<InAppProduct> getEntries() {
        return $ENTRIES;
    }

    public static InAppProduct valueOf(String str) {
        return (InAppProduct) Enum.valueOf(InAppProduct.class, str);
    }

    public static InAppProduct[] values() {
        return (InAppProduct[]) $VALUES.clone();
    }

    private InAppProduct(String str, int i, String str2) {
        this.id = str2;
    }

    public final String getId() {
        return this.id;
    }

    static {
        InAppProduct[] inAppProductArr$values = $values();
        $VALUES = inAppProductArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(inAppProductArr$values);
    }
}
