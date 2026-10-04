package com.myscript.nebo.whatsnew;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: CrossSellFilter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/CrossSellOrigin;", "", "origin", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getOrigin", "()Ljava/lang/String;", "MathConversion", "SessionThreshold", "Repeat30d", "Repeat60d", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CrossSellOrigin {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CrossSellOrigin[] $VALUES;
    private final String origin;
    public static final CrossSellOrigin MathConversion = new CrossSellOrigin("MathConversion", 0, "math_conversion");
    public static final CrossSellOrigin SessionThreshold = new CrossSellOrigin("SessionThreshold", 1, "session_threshold");
    public static final CrossSellOrigin Repeat30d = new CrossSellOrigin("Repeat30d", 2, "30d_repeat");
    public static final CrossSellOrigin Repeat60d = new CrossSellOrigin("Repeat60d", 3, "60d_repeat");

    private static final /* synthetic */ CrossSellOrigin[] $values() {
        return new CrossSellOrigin[]{MathConversion, SessionThreshold, Repeat30d, Repeat60d};
    }

    public static EnumEntries<CrossSellOrigin> getEntries() {
        return $ENTRIES;
    }

    public static CrossSellOrigin valueOf(String str) {
        return (CrossSellOrigin) Enum.valueOf(CrossSellOrigin.class, str);
    }

    public static CrossSellOrigin[] values() {
        return (CrossSellOrigin[]) $VALUES.clone();
    }

    private CrossSellOrigin(String str, int i, String str2) {
        this.origin = str2;
    }

    public final String getOrigin() {
        return this.origin;
    }

    static {
        CrossSellOrigin[] crossSellOriginArr$values = $values();
        $VALUES = crossSellOriginArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(crossSellOriginArr$values);
    }
}
