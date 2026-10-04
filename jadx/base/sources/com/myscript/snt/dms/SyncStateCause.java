package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum SyncStateCause {
    FROM_PAGE_STATE(0),
    V2_CLOUD_ONLY_RESTORE_FROM_CLOUD,
    V2_CLOUD_ONLY_OBJECT_DELETED_LOCALLY,
    V2_CLOUD_ONLY_OBJECT_LOCAL_MISSING,
    V2_CLOUD_ONLY_FROM_PAGE_STATE,
    V1_LOCAL_CLOUD_ONLY,
    V1_MODIFIED_LOCALLY,
    V1_MODIFIED_ON_CLOUD,
    V1_OBJECT_LOCAL_MISSING,
    V2_NOT_INITIALIZED,
    V2_INVALID_CLOUD_EVENT,
    V2_DELETED_ON_CLOUD,
    V2_MODIFIED_LOCALLY,
    V2_DELETED_LOCALLY,
    V2_MODIFIED_ON_CLOUD,
    V2_LOCAL_CLOUD_ONLY,
    V2_FROM_PAGE_STATE,
    V2_ATTACHMENT_MISSING_ON_CLOUD,
    V2_INCONSISTENT_SIGNATURE,
    V2_CLOUD_REVISION_NOT_FOUND_IN_HISTORY,
    V2_LOCAL_REVISION_NOT_FOUND_IN_HISTORY,
    V2_LOCAL_PARENT_UPDATED,
    V2_CLOUD_PARENT_UPDATED,
    V2_LOCAL_CONTENT_UPDATED,
    V2_CLOUD_CONTENT_UPDATED,
    V2_LOCAL_METADATA_UPDATED,
    V2_CLOUD_METADATA_UPDATED,
    V2_LOCAL_TRASH_UPDATED,
    V2_CLOUD_TRASH_UPDATED,
    V2_LOCAL_RESTORED,
    V2_CLOUD_RESTORED;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SyncStateCause swigToEnum(int i) {
        SyncStateCause[] syncStateCauseArr = (SyncStateCause[]) SyncStateCause.class.getEnumConstants();
        if (i < syncStateCauseArr.length && i >= 0) {
            SyncStateCause syncStateCause = syncStateCauseArr[i];
            if (syncStateCause.swigValue == i) {
                return syncStateCause;
            }
        }
        for (SyncStateCause syncStateCause2 : syncStateCauseArr) {
            if (syncStateCause2.swigValue == i) {
                return syncStateCause2;
            }
        }
        throw new IllegalArgumentException("No enum " + SyncStateCause.class + " with value " + i);
    }

    SyncStateCause() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SyncStateCause(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SyncStateCause(SyncStateCause syncStateCause) {
        int i = syncStateCause.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
