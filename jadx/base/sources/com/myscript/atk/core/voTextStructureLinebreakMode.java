package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voTextStructureLinebreakMode {
    TEXT_STRUCTURE_LINEBREAK_MODE_LEGACY,
    TEXT_STRUCTURE_LINEBREAK_MODE_REFLOW_ONE,
    TEXT_STRUCTURE_LINEBREAK_MODE_REFLOW_ONE_AND_GAP,
    TEXT_STRUCTURE_LINEBREAK_MODE_REFLOW_ONE_AND_MIN_GAP,
    TEXT_STRUCTURE_LINEBREAK_MODE_REFLOW_ONE_AND_MIN_GAP2,
    TEXT_STRUCTURE_LINEBREAK_MODE_REFLOW_ONE_AND_MIN_GAP22,
    TEXT_STRUCTURE_LINEBREAK_MODE_NOBREAK,
    TEXT_STRUCTURE_LINEBREAK_MODE_ALLBREAK;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voTextStructureLinebreakMode swigToEnum(int i) {
        voTextStructureLinebreakMode[] votextstructurelinebreakmodeArr = (voTextStructureLinebreakMode[]) voTextStructureLinebreakMode.class.getEnumConstants();
        if (i < votextstructurelinebreakmodeArr.length && i >= 0) {
            voTextStructureLinebreakMode votextstructurelinebreakmode = votextstructurelinebreakmodeArr[i];
            if (votextstructurelinebreakmode.swigValue == i) {
                return votextstructurelinebreakmode;
            }
        }
        for (voTextStructureLinebreakMode votextstructurelinebreakmode2 : votextstructurelinebreakmodeArr) {
            if (votextstructurelinebreakmode2.swigValue == i) {
                return votextstructurelinebreakmode2;
            }
        }
        throw new IllegalArgumentException("No enum " + voTextStructureLinebreakMode.class + " with value " + i);
    }

    voTextStructureLinebreakMode() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voTextStructureLinebreakMode(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voTextStructureLinebreakMode(voTextStructureLinebreakMode votextstructurelinebreakmode) {
        int i = votextstructurelinebreakmode.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
