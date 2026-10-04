package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum CloudErrorType {
    NONE(0),
    INVALID_ARGUMENT(1),
    NOT_FOUND(2),
    ALREADY_EXISTS(3),
    ACTION_FAILED(4),
    ACTION_CANCELED(5),
    UNSUPPORTED_CLOUD_VERSION(6);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static CloudErrorType swigToEnum(int i) {
        CloudErrorType[] cloudErrorTypeArr = (CloudErrorType[]) CloudErrorType.class.getEnumConstants();
        if (i < cloudErrorTypeArr.length && i >= 0) {
            CloudErrorType cloudErrorType = cloudErrorTypeArr[i];
            if (cloudErrorType.swigValue == i) {
                return cloudErrorType;
            }
        }
        for (CloudErrorType cloudErrorType2 : cloudErrorTypeArr) {
            if (cloudErrorType2.swigValue == i) {
                return cloudErrorType2;
            }
        }
        throw new IllegalArgumentException("No enum " + CloudErrorType.class + " with value " + i);
    }

    CloudErrorType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    CloudErrorType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    CloudErrorType(CloudErrorType cloudErrorType) {
        int i = cloudErrorType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
