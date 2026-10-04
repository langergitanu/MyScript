package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum FileLogLevel {
    None,
    Lean,
    Full,
    Excessive;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static FileLogLevel swigToEnum(int i) {
        FileLogLevel[] fileLogLevelArr = (FileLogLevel[]) FileLogLevel.class.getEnumConstants();
        if (i < fileLogLevelArr.length && i >= 0) {
            FileLogLevel fileLogLevel = fileLogLevelArr[i];
            if (fileLogLevel.swigValue == i) {
                return fileLogLevel;
            }
        }
        for (FileLogLevel fileLogLevel2 : fileLogLevelArr) {
            if (fileLogLevel2.swigValue == i) {
                return fileLogLevel2;
            }
        }
        throw new IllegalArgumentException("No enum " + FileLogLevel.class + " with value " + i);
    }

    FileLogLevel() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    FileLogLevel(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    FileLogLevel(FileLogLevel fileLogLevel) {
        int i = fileLogLevel.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
