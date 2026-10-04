package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum JournalEvent {
    OPEN_PAGE,
    SAVE_PAGE,
    CLOSE_PAGE;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static JournalEvent swigToEnum(int i) {
        JournalEvent[] journalEventArr = (JournalEvent[]) JournalEvent.class.getEnumConstants();
        if (i < journalEventArr.length && i >= 0) {
            JournalEvent journalEvent = journalEventArr[i];
            if (journalEvent.swigValue == i) {
                return journalEvent;
            }
        }
        for (JournalEvent journalEvent2 : journalEventArr) {
            if (journalEvent2.swigValue == i) {
                return journalEvent2;
            }
        }
        throw new IllegalArgumentException("No enum " + JournalEvent.class + " with value " + i);
    }

    JournalEvent() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    JournalEvent(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    JournalEvent(JournalEvent journalEvent) {
        int i = journalEvent.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
