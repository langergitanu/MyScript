package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum DMSFilter {
    ALL,
    ACTIVE,
    TRASH;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static DMSFilter swigToEnum(int i) {
        DMSFilter[] dMSFilterArr = (DMSFilter[]) DMSFilter.class.getEnumConstants();
        if (i < dMSFilterArr.length && i >= 0) {
            DMSFilter dMSFilter = dMSFilterArr[i];
            if (dMSFilter.swigValue == i) {
                return dMSFilter;
            }
        }
        for (DMSFilter dMSFilter2 : dMSFilterArr) {
            if (dMSFilter2.swigValue == i) {
                return dMSFilter2;
            }
        }
        throw new IllegalArgumentException("No enum " + DMSFilter.class + " with value " + i);
    }

    DMSFilter() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    DMSFilter(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    DMSFilter(DMSFilter dMSFilter) {
        int i = dMSFilter.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
