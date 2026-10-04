package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum SharePageVisibility {
    NONE,
    PUBLIC,
    PRIVATE,
    DISABLE;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SharePageVisibility swigToEnum(int i) {
        SharePageVisibility[] sharePageVisibilityArr = (SharePageVisibility[]) SharePageVisibility.class.getEnumConstants();
        if (i < sharePageVisibilityArr.length && i >= 0) {
            SharePageVisibility sharePageVisibility = sharePageVisibilityArr[i];
            if (sharePageVisibility.swigValue == i) {
                return sharePageVisibility;
            }
        }
        for (SharePageVisibility sharePageVisibility2 : sharePageVisibilityArr) {
            if (sharePageVisibility2.swigValue == i) {
                return sharePageVisibility2;
            }
        }
        throw new IllegalArgumentException("No enum " + SharePageVisibility.class + " with value " + i);
    }

    SharePageVisibility() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SharePageVisibility(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SharePageVisibility(SharePageVisibility sharePageVisibility) {
        int i = sharePageVisibility.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
