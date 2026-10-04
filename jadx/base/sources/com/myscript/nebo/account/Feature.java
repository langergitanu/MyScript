package com.myscript.nebo.account;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: UserProfileManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/account/Feature;", "", "<init>", "(Ljava/lang/String;I)V", "UnlimitedPages", "CloudSync", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Feature {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Feature[] $VALUES;
    public static final Feature UnlimitedPages = new Feature("UnlimitedPages", 0);
    public static final Feature CloudSync = new Feature("CloudSync", 1);

    private static final /* synthetic */ Feature[] $values() {
        return new Feature[]{UnlimitedPages, CloudSync};
    }

    public static EnumEntries<Feature> getEntries() {
        return $ENTRIES;
    }

    public static Feature valueOf(String str) {
        return (Feature) Enum.valueOf(Feature.class, str);
    }

    public static Feature[] values() {
        return (Feature[]) $VALUES.clone();
    }

    private Feature(String str, int i) {
    }

    static {
        Feature[] featureArr$values = $values();
        $VALUES = featureArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(featureArr$values);
    }
}
