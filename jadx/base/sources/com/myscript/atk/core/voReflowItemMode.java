package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voReflowItemMode {
    REFLOW_ITEM_AUTO_MODE,
    REFLOW_ITEM_WORD_MODE,
    REFLOW_ITEM_CHAR_MODE;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voReflowItemMode swigToEnum(int i) {
        voReflowItemMode[] voreflowitemmodeArr = (voReflowItemMode[]) voReflowItemMode.class.getEnumConstants();
        if (i < voreflowitemmodeArr.length && i >= 0) {
            voReflowItemMode voreflowitemmode = voreflowitemmodeArr[i];
            if (voreflowitemmode.swigValue == i) {
                return voreflowitemmode;
            }
        }
        for (voReflowItemMode voreflowitemmode2 : voreflowitemmodeArr) {
            if (voreflowitemmode2.swigValue == i) {
                return voreflowitemmode2;
            }
        }
        throw new IllegalArgumentException("No enum " + voReflowItemMode.class + " with value " + i);
    }

    voReflowItemMode() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voReflowItemMode(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voReflowItemMode(voReflowItemMode voreflowitemmode) {
        int i = voreflowitemmode.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
