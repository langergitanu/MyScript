package com.myscript.nebo.account.backend;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: NeboBackend.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/CachePolicy;", "", "<init>", "(Ljava/lang/String;I)V", "FromCacheIfOffline", "FromCacheIfAvailable", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CachePolicy {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CachePolicy[] $VALUES;
    public static final CachePolicy FromCacheIfOffline = new CachePolicy("FromCacheIfOffline", 0);
    public static final CachePolicy FromCacheIfAvailable = new CachePolicy("FromCacheIfAvailable", 1);

    private static final /* synthetic */ CachePolicy[] $values() {
        return new CachePolicy[]{FromCacheIfOffline, FromCacheIfAvailable};
    }

    public static EnumEntries<CachePolicy> getEntries() {
        return $ENTRIES;
    }

    public static CachePolicy valueOf(String str) {
        return (CachePolicy) Enum.valueOf(CachePolicy.class, str);
    }

    public static CachePolicy[] values() {
        return (CachePolicy[]) $VALUES.clone();
    }

    private CachePolicy(String str, int i) {
    }

    static {
        CachePolicy[] cachePolicyArr$values = $values();
        $VALUES = cachePolicyArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(cachePolicyArr$values);
    }
}
