package com.myscript.nebo.dms.edit_new_folder;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: FolderEditorViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorAction;", "", "<init>", "(Ljava/lang/String;I)V", "CREATE", "EDIT", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FolderEditorAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FolderEditorAction[] $VALUES;
    public static final FolderEditorAction CREATE = new FolderEditorAction("CREATE", 0);
    public static final FolderEditorAction EDIT = new FolderEditorAction("EDIT", 1);

    private static final /* synthetic */ FolderEditorAction[] $values() {
        return new FolderEditorAction[]{CREATE, EDIT};
    }

    public static EnumEntries<FolderEditorAction> getEntries() {
        return $ENTRIES;
    }

    public static FolderEditorAction valueOf(String str) {
        return (FolderEditorAction) Enum.valueOf(FolderEditorAction.class, str);
    }

    public static FolderEditorAction[] values() {
        return (FolderEditorAction[]) $VALUES.clone();
    }

    private FolderEditorAction(String str, int i) {
    }

    static {
        FolderEditorAction[] folderEditorActionArr$values = $values();
        $VALUES = folderEditorActionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(folderEditorActionArr$values);
    }
}
