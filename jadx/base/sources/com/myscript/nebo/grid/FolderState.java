package com.myscript.nebo.grid;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/grid/FolderState;", "", "<init>", "(Ljava/lang/String;I)V", "Loading", "Loaded", "Updating", "Unloaded", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FolderState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FolderState[] $VALUES;
    public static final FolderState Loading = new FolderState("Loading", 0);
    public static final FolderState Loaded = new FolderState("Loaded", 1);
    public static final FolderState Updating = new FolderState("Updating", 2);
    public static final FolderState Unloaded = new FolderState("Unloaded", 3);

    private static final /* synthetic */ FolderState[] $values() {
        return new FolderState[]{Loading, Loaded, Updating, Unloaded};
    }

    public static EnumEntries<FolderState> getEntries() {
        return $ENTRIES;
    }

    public static FolderState valueOf(String str) {
        return (FolderState) Enum.valueOf(FolderState.class, str);
    }

    public static FolderState[] values() {
        return (FolderState[]) $VALUES.clone();
    }

    private FolderState(String str, int i) {
    }

    static {
        FolderState[] folderStateArr$values = $values();
        $VALUES = folderStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(folderStateArr$values);
    }
}
