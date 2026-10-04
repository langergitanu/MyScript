package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voTextStructureBoundary {
    TEXT_STRUCTURE_BOUNDARY_BLOCK,
    TEXT_STRUCTURE_BOUNDARY_BULLET,
    TEXT_STRUCTURE_BOUNDARY_INDENT,
    TEXT_STRUCTURE_BOUNDARY_DEDENT,
    TEXT_STRUCTURE_BOUNDARY_RELATIVE_INDENT,
    TEXT_STRUCTURE_BOUNDARY_RELATIVE_DEDENT,
    TEXT_STRUCTURE_BOUNDARY_FIELD,
    TEXT_STRUCTURE_BOUNDARY_SCOPE,
    TEXT_STRUCTURE_BOUNDARY_PARENT_SCOPE;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voTextStructureBoundary swigToEnum(int i) {
        voTextStructureBoundary[] votextstructureboundaryArr = (voTextStructureBoundary[]) voTextStructureBoundary.class.getEnumConstants();
        if (i < votextstructureboundaryArr.length && i >= 0) {
            voTextStructureBoundary votextstructureboundary = votextstructureboundaryArr[i];
            if (votextstructureboundary.swigValue == i) {
                return votextstructureboundary;
            }
        }
        for (voTextStructureBoundary votextstructureboundary2 : votextstructureboundaryArr) {
            if (votextstructureboundary2.swigValue == i) {
                return votextstructureboundary2;
            }
        }
        throw new IllegalArgumentException("No enum " + voTextStructureBoundary.class + " with value " + i);
    }

    voTextStructureBoundary() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voTextStructureBoundary(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voTextStructureBoundary(voTextStructureBoundary votextstructureboundary) {
        int i = votextstructureboundary.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
