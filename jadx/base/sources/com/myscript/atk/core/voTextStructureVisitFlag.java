package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voTextStructureVisitFlag {
    TEXT_STRUCTURE_VISIT_FLAG_NONE(0),
    TEXT_STRUCTURE_VISIT_FLAG_BULLET_CONSISTENCY(1),
    TEXT_STRUCTURE_VISIT_FLAG_NO_TEXT_IN_LIST(2),
    TEXT_STRUCTURE_VISIT_FLAG_DEDENT_TEXT_STOPS_LISTS(4),
    TEXT_STRUCTURE_VISIT_FLAG_NO_LIST(8);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voTextStructureVisitFlag swigToEnum(int i) {
        voTextStructureVisitFlag[] votextstructurevisitflagArr = (voTextStructureVisitFlag[]) voTextStructureVisitFlag.class.getEnumConstants();
        if (i < votextstructurevisitflagArr.length && i >= 0) {
            voTextStructureVisitFlag votextstructurevisitflag = votextstructurevisitflagArr[i];
            if (votextstructurevisitflag.swigValue == i) {
                return votextstructurevisitflag;
            }
        }
        for (voTextStructureVisitFlag votextstructurevisitflag2 : votextstructurevisitflagArr) {
            if (votextstructurevisitflag2.swigValue == i) {
                return votextstructurevisitflag2;
            }
        }
        throw new IllegalArgumentException("No enum " + voTextStructureVisitFlag.class + " with value " + i);
    }

    voTextStructureVisitFlag() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voTextStructureVisitFlag(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voTextStructureVisitFlag(voTextStructureVisitFlag votextstructurevisitflag) {
        int i = votextstructurevisitflag.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
