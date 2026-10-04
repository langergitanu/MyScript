package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum SortCriteria {
    NAME,
    MODIFICATION_DATE;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SortCriteria swigToEnum(int i) {
        SortCriteria[] sortCriteriaArr = (SortCriteria[]) SortCriteria.class.getEnumConstants();
        if (i < sortCriteriaArr.length && i >= 0) {
            SortCriteria sortCriteria = sortCriteriaArr[i];
            if (sortCriteria.swigValue == i) {
                return sortCriteria;
            }
        }
        for (SortCriteria sortCriteria2 : sortCriteriaArr) {
            if (sortCriteria2.swigValue == i) {
                return sortCriteria2;
            }
        }
        throw new IllegalArgumentException("No enum " + SortCriteria.class + " with value " + i);
    }

    SortCriteria() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SortCriteria(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SortCriteria(SortCriteria sortCriteria) {
        int i = sortCriteria.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
