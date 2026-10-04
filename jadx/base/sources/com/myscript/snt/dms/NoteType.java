package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum NoteType {
    Board,
    Document,
    Notebook,
    PDF;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static NoteType swigToEnum(int i) {
        NoteType[] noteTypeArr = (NoteType[]) NoteType.class.getEnumConstants();
        if (i < noteTypeArr.length && i >= 0) {
            NoteType noteType = noteTypeArr[i];
            if (noteType.swigValue == i) {
                return noteType;
            }
        }
        for (NoteType noteType2 : noteTypeArr) {
            if (noteType2.swigValue == i) {
                return noteType2;
            }
        }
        throw new IllegalArgumentException("No enum " + NoteType.class + " with value " + i);
    }

    NoteType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    NoteType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    NoteType(NoteType noteType) {
        int i = noteType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
