package com.myscript.nebo.dms.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SelectionState.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/model/SelectionState;", "", "<init>", "(Ljava/lang/String;I)V", "UNSELECTED", "SELECTED", "NOT_SELECTABLE", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SelectionState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SelectionState[] $VALUES;
    public static final SelectionState UNSELECTED = new SelectionState("UNSELECTED", 0);
    public static final SelectionState SELECTED = new SelectionState("SELECTED", 1);
    public static final SelectionState NOT_SELECTABLE = new SelectionState("NOT_SELECTABLE", 2);

    private static final /* synthetic */ SelectionState[] $values() {
        return new SelectionState[]{UNSELECTED, SELECTED, NOT_SELECTABLE};
    }

    public static EnumEntries<SelectionState> getEntries() {
        return $ENTRIES;
    }

    public static SelectionState valueOf(String str) {
        return (SelectionState) Enum.valueOf(SelectionState.class, str);
    }

    public static SelectionState[] values() {
        return (SelectionState[]) $VALUES.clone();
    }

    private SelectionState(String str, int i) {
    }

    static {
        SelectionState[] selectionStateArr$values = $values();
        $VALUES = selectionStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(selectionStateArr$values);
    }
}
