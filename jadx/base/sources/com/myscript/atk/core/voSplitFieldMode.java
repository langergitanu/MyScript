package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voSplitFieldMode {
    SPLITFIELD_TRIM_NONOBSERVABLES_AT_CURSOR,
    SPLITFIELD_REMOVE_LINEFEED_AT_CURSOR,
    SPLITFIELD_USE_RAW_INTERVAL;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voSplitFieldMode swigToEnum(int i) {
        voSplitFieldMode[] vosplitfieldmodeArr = (voSplitFieldMode[]) voSplitFieldMode.class.getEnumConstants();
        if (i < vosplitfieldmodeArr.length && i >= 0) {
            voSplitFieldMode vosplitfieldmode = vosplitfieldmodeArr[i];
            if (vosplitfieldmode.swigValue == i) {
                return vosplitfieldmode;
            }
        }
        for (voSplitFieldMode vosplitfieldmode2 : vosplitfieldmodeArr) {
            if (vosplitfieldmode2.swigValue == i) {
                return vosplitfieldmode2;
            }
        }
        throw new IllegalArgumentException("No enum " + voSplitFieldMode.class + " with value " + i);
    }

    voSplitFieldMode() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voSplitFieldMode(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voSplitFieldMode(voSplitFieldMode vosplitfieldmode) {
        int i = vosplitfieldmode.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
