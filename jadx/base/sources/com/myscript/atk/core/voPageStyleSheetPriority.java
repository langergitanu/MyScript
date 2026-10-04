package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voPageStyleSheetPriority {
    PAGE_STYLESHEET_PRIORITY_LOW(0),
    PAGE_STYLESHEET_PRIORITY_HIGH;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voPageStyleSheetPriority swigToEnum(int i) {
        voPageStyleSheetPriority[] vopagestylesheetpriorityArr = (voPageStyleSheetPriority[]) voPageStyleSheetPriority.class.getEnumConstants();
        if (i < vopagestylesheetpriorityArr.length && i >= 0) {
            voPageStyleSheetPriority vopagestylesheetpriority = vopagestylesheetpriorityArr[i];
            if (vopagestylesheetpriority.swigValue == i) {
                return vopagestylesheetpriority;
            }
        }
        for (voPageStyleSheetPriority vopagestylesheetpriority2 : vopagestylesheetpriorityArr) {
            if (vopagestylesheetpriority2.swigValue == i) {
                return vopagestylesheetpriority2;
            }
        }
        throw new IllegalArgumentException("No enum " + voPageStyleSheetPriority.class + " with value " + i);
    }

    voPageStyleSheetPriority() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voPageStyleSheetPriority(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voPageStyleSheetPriority(voPageStyleSheetPriority vopagestylesheetpriority) {
        int i = vopagestylesheetpriority.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
