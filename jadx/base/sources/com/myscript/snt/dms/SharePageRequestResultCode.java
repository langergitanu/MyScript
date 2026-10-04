package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum SharePageRequestResultCode {
    OK(0),
    GENERIC_ERROR(100),
    NOT_OWNER_ERROR(101),
    NOT_FOUND_ERROR(102);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SharePageRequestResultCode swigToEnum(int i) {
        SharePageRequestResultCode[] sharePageRequestResultCodeArr = (SharePageRequestResultCode[]) SharePageRequestResultCode.class.getEnumConstants();
        if (i < sharePageRequestResultCodeArr.length && i >= 0) {
            SharePageRequestResultCode sharePageRequestResultCode = sharePageRequestResultCodeArr[i];
            if (sharePageRequestResultCode.swigValue == i) {
                return sharePageRequestResultCode;
            }
        }
        for (SharePageRequestResultCode sharePageRequestResultCode2 : sharePageRequestResultCodeArr) {
            if (sharePageRequestResultCode2.swigValue == i) {
                return sharePageRequestResultCode2;
            }
        }
        throw new IllegalArgumentException("No enum " + SharePageRequestResultCode.class + " with value " + i);
    }

    SharePageRequestResultCode() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SharePageRequestResultCode(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SharePageRequestResultCode(SharePageRequestResultCode sharePageRequestResultCode) {
        int i = sharePageRequestResultCode.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
