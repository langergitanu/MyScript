package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum SharePageUserRight {
    DISABLE,
    READ;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SharePageUserRight swigToEnum(int i) {
        SharePageUserRight[] sharePageUserRightArr = (SharePageUserRight[]) SharePageUserRight.class.getEnumConstants();
        if (i < sharePageUserRightArr.length && i >= 0) {
            SharePageUserRight sharePageUserRight = sharePageUserRightArr[i];
            if (sharePageUserRight.swigValue == i) {
                return sharePageUserRight;
            }
        }
        for (SharePageUserRight sharePageUserRight2 : sharePageUserRightArr) {
            if (sharePageUserRight2.swigValue == i) {
                return sharePageUserRight2;
            }
        }
        throw new IllegalArgumentException("No enum " + SharePageUserRight.class + " with value " + i);
    }

    SharePageUserRight() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SharePageUserRight(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SharePageUserRight(SharePageUserRight sharePageUserRight) {
        int i = sharePageUserRight.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
