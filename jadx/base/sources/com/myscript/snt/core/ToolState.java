package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public enum ToolState {
    Unselected,
    Selected,
    Paused;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static ToolState swigToEnum(int i) {
        ToolState[] toolStateArr = (ToolState[]) ToolState.class.getEnumConstants();
        if (i < toolStateArr.length && i >= 0) {
            ToolState toolState = toolStateArr[i];
            if (toolState.swigValue == i) {
                return toolState;
            }
        }
        for (ToolState toolState2 : toolStateArr) {
            if (toolState2.swigValue == i) {
                return toolState2;
            }
        }
        throw new IllegalArgumentException("No enum " + ToolState.class + " with value " + i);
    }

    ToolState() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    ToolState(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    ToolState(ToolState toolState) {
        int i = toolState.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
