package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum SharePageListenerTask {
    SHARE,
    SHARED_LIST,
    ADD_USER,
    UPDATE_USER,
    REMOVE_USER,
    CHANGE_VISIBILITY,
    DELETE_SHARE,
    DISABLE_SHARE,
    CHANGE_PAGE_STATE,
    CHANGE_UPLOAD_PROGRESS;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SharePageListenerTask swigToEnum(int i) {
        SharePageListenerTask[] sharePageListenerTaskArr = (SharePageListenerTask[]) SharePageListenerTask.class.getEnumConstants();
        if (i < sharePageListenerTaskArr.length && i >= 0) {
            SharePageListenerTask sharePageListenerTask = sharePageListenerTaskArr[i];
            if (sharePageListenerTask.swigValue == i) {
                return sharePageListenerTask;
            }
        }
        for (SharePageListenerTask sharePageListenerTask2 : sharePageListenerTaskArr) {
            if (sharePageListenerTask2.swigValue == i) {
                return sharePageListenerTask2;
            }
        }
        throw new IllegalArgumentException("No enum " + SharePageListenerTask.class + " with value " + i);
    }

    SharePageListenerTask() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SharePageListenerTask(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SharePageListenerTask(SharePageListenerTask sharePageListenerTask) {
        int i = sharePageListenerTask.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
