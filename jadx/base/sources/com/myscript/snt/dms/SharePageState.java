package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum SharePageState {
    UP_TO_DATE,
    SHARING,
    UPLOADING,
    OUTDATED,
    DELETED,
    UNPUBLISHED,
    REFRESHING;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SharePageState swigToEnum(int i) {
        SharePageState[] sharePageStateArr = (SharePageState[]) SharePageState.class.getEnumConstants();
        if (i < sharePageStateArr.length && i >= 0) {
            SharePageState sharePageState = sharePageStateArr[i];
            if (sharePageState.swigValue == i) {
                return sharePageState;
            }
        }
        for (SharePageState sharePageState2 : sharePageStateArr) {
            if (sharePageState2.swigValue == i) {
                return sharePageState2;
            }
        }
        throw new IllegalArgumentException("No enum " + SharePageState.class + " with value " + i);
    }

    SharePageState() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SharePageState(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SharePageState(SharePageState sharePageState) {
        int i = sharePageState.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
