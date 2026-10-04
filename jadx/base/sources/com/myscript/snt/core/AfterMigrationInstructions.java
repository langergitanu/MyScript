package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public enum AfterMigrationInstructions {
    ;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static AfterMigrationInstructions swigToEnum(int i) {
        AfterMigrationInstructions[] afterMigrationInstructionsArr = (AfterMigrationInstructions[]) AfterMigrationInstructions.class.getEnumConstants();
        if (i < afterMigrationInstructionsArr.length && i >= 0) {
            AfterMigrationInstructions afterMigrationInstructions = afterMigrationInstructionsArr[i];
            if (afterMigrationInstructions.swigValue == i) {
                return afterMigrationInstructions;
            }
        }
        for (AfterMigrationInstructions afterMigrationInstructions2 : afterMigrationInstructionsArr) {
            if (afterMigrationInstructions2.swigValue == i) {
                return afterMigrationInstructions2;
            }
        }
        throw new IllegalArgumentException("No enum " + AfterMigrationInstructions.class + " with value " + i);
    }

    AfterMigrationInstructions() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    AfterMigrationInstructions(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    AfterMigrationInstructions(AfterMigrationInstructions afterMigrationInstructions) {
        int i = afterMigrationInstructions.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
