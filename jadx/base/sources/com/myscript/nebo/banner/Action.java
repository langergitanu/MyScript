package com.myscript.nebo.banner;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Banners.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/banner/Action;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY", "SECONDARY", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Action {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Action[] $VALUES;
    public static final Action PRIMARY = new Action("PRIMARY", 0);
    public static final Action SECONDARY = new Action("SECONDARY", 1);

    private static final /* synthetic */ Action[] $values() {
        return new Action[]{PRIMARY, SECONDARY};
    }

    public static EnumEntries<Action> getEntries() {
        return $ENTRIES;
    }

    public static Action valueOf(String str) {
        return (Action) Enum.valueOf(Action.class, str);
    }

    public static Action[] values() {
        return (Action[]) $VALUES.clone();
    }

    private Action(String str, int i) {
    }

    static {
        Action[] actionArr$values = $values();
        $VALUES = actionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(actionArr$values);
    }
}
