package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voSelectionExtentMode {
    SELECTION_EXTENT_PRECISE_STYLING,
    SELECTION_EXTENT_APPROXIMATE_STYLING,
    SELECTION_EXTENT_NO_STYLING;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voSelectionExtentMode swigToEnum(int i) {
        voSelectionExtentMode[] voselectionextentmodeArr = (voSelectionExtentMode[]) voSelectionExtentMode.class.getEnumConstants();
        if (i < voselectionextentmodeArr.length && i >= 0) {
            voSelectionExtentMode voselectionextentmode = voselectionextentmodeArr[i];
            if (voselectionextentmode.swigValue == i) {
                return voselectionextentmode;
            }
        }
        for (voSelectionExtentMode voselectionextentmode2 : voselectionextentmodeArr) {
            if (voselectionextentmode2.swigValue == i) {
                return voselectionextentmode2;
            }
        }
        throw new IllegalArgumentException("No enum " + voSelectionExtentMode.class + " with value " + i);
    }

    voSelectionExtentMode() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voSelectionExtentMode(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voSelectionExtentMode(voSelectionExtentMode voselectionextentmode) {
        int i = voselectionextentmode.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
