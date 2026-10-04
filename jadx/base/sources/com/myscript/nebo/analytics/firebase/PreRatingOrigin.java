package com.myscript.nebo.analytics.firebase;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: NeboFirebaseEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/analytics/firebase/PreRatingOrigin;", "", "origin", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getOrigin", "()Ljava/lang/String;", "SessionThreshold", "PaywallPurchase", "analytics_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PreRatingOrigin {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PreRatingOrigin[] $VALUES;
    private final String origin;
    public static final PreRatingOrigin SessionThreshold = new PreRatingOrigin("SessionThreshold", 0, "session_threshold");
    public static final PreRatingOrigin PaywallPurchase = new PreRatingOrigin("PaywallPurchase", 1, "paywall_purchase");

    private static final /* synthetic */ PreRatingOrigin[] $values() {
        return new PreRatingOrigin[]{SessionThreshold, PaywallPurchase};
    }

    public static EnumEntries<PreRatingOrigin> getEntries() {
        return $ENTRIES;
    }

    public static PreRatingOrigin valueOf(String str) {
        return (PreRatingOrigin) Enum.valueOf(PreRatingOrigin.class, str);
    }

    public static PreRatingOrigin[] values() {
        return (PreRatingOrigin[]) $VALUES.clone();
    }

    private PreRatingOrigin(String str, int i, String str2) {
        this.origin = str2;
    }

    public final String getOrigin() {
        return this.origin;
    }

    static {
        PreRatingOrigin[] preRatingOriginArr$values = $values();
        $VALUES = preRatingOriginArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(preRatingOriginArr$values);
    }
}
