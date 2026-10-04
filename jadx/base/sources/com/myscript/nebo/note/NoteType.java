package com.myscript.nebo.note;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: NoteCreationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/note/NoteType;", "", "<init>", "(Ljava/lang/String;I)V", "Notebook", "Board", "Document", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NoteType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NoteType[] $VALUES;
    public static final NoteType Notebook = new NoteType("Notebook", 0);
    public static final NoteType Board = new NoteType("Board", 1);
    public static final NoteType Document = new NoteType("Document", 2);

    private static final /* synthetic */ NoteType[] $values() {
        return new NoteType[]{Notebook, Board, Document};
    }

    public static EnumEntries<NoteType> getEntries() {
        return $ENTRIES;
    }

    public static NoteType valueOf(String str) {
        return (NoteType) Enum.valueOf(NoteType.class, str);
    }

    public static NoteType[] values() {
        return (NoteType[]) $VALUES.clone();
    }

    private NoteType(String str, int i) {
    }

    static {
        NoteType[] noteTypeArr$values = $values();
        $VALUES = noteTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(noteTypeArr$values);
    }
}
