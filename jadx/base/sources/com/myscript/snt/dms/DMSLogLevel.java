package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum DMSLogLevel {
    INFO,
    WARNING,
    ERR;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static DMSLogLevel swigToEnum(int i) {
        DMSLogLevel[] dMSLogLevelArr = (DMSLogLevel[]) DMSLogLevel.class.getEnumConstants();
        if (i < dMSLogLevelArr.length && i >= 0) {
            DMSLogLevel dMSLogLevel = dMSLogLevelArr[i];
            if (dMSLogLevel.swigValue == i) {
                return dMSLogLevel;
            }
        }
        for (DMSLogLevel dMSLogLevel2 : dMSLogLevelArr) {
            if (dMSLogLevel2.swigValue == i) {
                return dMSLogLevel2;
            }
        }
        throw new IllegalArgumentException("No enum " + DMSLogLevel.class + " with value " + i);
    }

    DMSLogLevel() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    DMSLogLevel(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    DMSLogLevel(DMSLogLevel dMSLogLevel) {
        int i = dMSLogLevel.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
