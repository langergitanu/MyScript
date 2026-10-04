package com.myscript.nebo.rating;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: PreRatingFilter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/rating/PreRatingFilterAction;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "LOVE_IT", "NEEDS_REWORK", "LATER", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PreRatingFilterAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PreRatingFilterAction[] $VALUES;
    public static final PreRatingFilterAction NONE = new PreRatingFilterAction("NONE", 0);
    public static final PreRatingFilterAction LOVE_IT = new PreRatingFilterAction("LOVE_IT", 1);
    public static final PreRatingFilterAction NEEDS_REWORK = new PreRatingFilterAction("NEEDS_REWORK", 2);
    public static final PreRatingFilterAction LATER = new PreRatingFilterAction("LATER", 3);

    private static final /* synthetic */ PreRatingFilterAction[] $values() {
        return new PreRatingFilterAction[]{NONE, LOVE_IT, NEEDS_REWORK, LATER};
    }

    public static EnumEntries<PreRatingFilterAction> getEntries() {
        return $ENTRIES;
    }

    public static PreRatingFilterAction valueOf(String str) {
        return (PreRatingFilterAction) Enum.valueOf(PreRatingFilterAction.class, str);
    }

    public static PreRatingFilterAction[] values() {
        return (PreRatingFilterAction[]) $VALUES.clone();
    }

    private PreRatingFilterAction(String str, int i) {
    }

    static {
        PreRatingFilterAction[] preRatingFilterActionArr$values = $values();
        $VALUES = preRatingFilterActionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(preRatingFilterActionArr$values);
    }
}
