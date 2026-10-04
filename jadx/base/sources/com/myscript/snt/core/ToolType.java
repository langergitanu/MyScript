package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public enum ToolType {
    None,
    Pen,
    Eraser,
    Lasso,
    Keyboard,
    InteractionTool,
    Highlighter,
    LaserPointer;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static ToolType swigToEnum(int i) {
        ToolType[] toolTypeArr = (ToolType[]) ToolType.class.getEnumConstants();
        if (i < toolTypeArr.length && i >= 0) {
            ToolType toolType = toolTypeArr[i];
            if (toolType.swigValue == i) {
                return toolType;
            }
        }
        for (ToolType toolType2 : toolTypeArr) {
            if (toolType2.swigValue == i) {
                return toolType2;
            }
        }
        throw new IllegalArgumentException("No enum " + ToolType.class + " with value " + i);
    }

    ToolType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    ToolType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    ToolType(ToolType toolType) {
        int i = toolType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
