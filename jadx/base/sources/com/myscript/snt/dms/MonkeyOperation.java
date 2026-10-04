package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum MonkeyOperation {
    CREATE_COLLECTION(0),
    CREATE_NOTEBOOK,
    CREATE_PAGE_CONTAINER,
    CREATE_PAGE,
    DELETE_COLLECTION,
    DELETE_NOTEBOOK,
    DELETE_PAGE,
    RENAME_COLLECTION,
    RENAME_NOTEBOOK,
    RENAME_PAGE,
    MOVE_NOTEBOOK,
    MOVE_PAGE,
    EDIT_PAGE,
    ADD_ATTACHMENT,
    RESET_PAGE_UUID,
    REFRESH,
    SYNC,
    DELETE_COLLECTION_PERMANENTLY,
    DELETE_NOTEBOOK_PERMANENTLY,
    DELETE_PAGE_PERMANENTLY,
    RESTORE_COLLECTION,
    RESTORE_NOTEBOOK,
    RESTORE_PAGE;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static MonkeyOperation swigToEnum(int i) {
        MonkeyOperation[] monkeyOperationArr = (MonkeyOperation[]) MonkeyOperation.class.getEnumConstants();
        if (i < monkeyOperationArr.length && i >= 0) {
            MonkeyOperation monkeyOperation = monkeyOperationArr[i];
            if (monkeyOperation.swigValue == i) {
                return monkeyOperation;
            }
        }
        for (MonkeyOperation monkeyOperation2 : monkeyOperationArr) {
            if (monkeyOperation2.swigValue == i) {
                return monkeyOperation2;
            }
        }
        throw new IllegalArgumentException("No enum " + MonkeyOperation.class + " with value " + i);
    }

    MonkeyOperation() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    MonkeyOperation(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    MonkeyOperation(MonkeyOperation monkeyOperation) {
        int i = monkeyOperation.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
