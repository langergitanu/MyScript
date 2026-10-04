package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum BackgroundPattern {
    NONE(0),
    GRID,
    LINES,
    DOTS;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static BackgroundPattern swigToEnum(int i) {
        BackgroundPattern[] backgroundPatternArr = (BackgroundPattern[]) BackgroundPattern.class.getEnumConstants();
        if (i < backgroundPatternArr.length && i >= 0) {
            BackgroundPattern backgroundPattern = backgroundPatternArr[i];
            if (backgroundPattern.swigValue == i) {
                return backgroundPattern;
            }
        }
        for (BackgroundPattern backgroundPattern2 : backgroundPatternArr) {
            if (backgroundPattern2.swigValue == i) {
                return backgroundPattern2;
            }
        }
        throw new IllegalArgumentException("No enum " + BackgroundPattern.class + " with value " + i);
    }

    BackgroundPattern() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    BackgroundPattern(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    BackgroundPattern(BackgroundPattern backgroundPattern) {
        int i = backgroundPattern.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
