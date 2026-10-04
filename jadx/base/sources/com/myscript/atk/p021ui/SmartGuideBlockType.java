package com.myscript.atk.p021ui;

/* JADX INFO: loaded from: classes4.dex */
public enum SmartGuideBlockType {
    None,
    Text,
    Diagram,
    Math,
    Sketch,
    Draft;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SmartGuideBlockType swigToEnum(int i) {
        SmartGuideBlockType[] smartGuideBlockTypeArr = (SmartGuideBlockType[]) SmartGuideBlockType.class.getEnumConstants();
        if (i < smartGuideBlockTypeArr.length && i >= 0) {
            SmartGuideBlockType smartGuideBlockType = smartGuideBlockTypeArr[i];
            if (smartGuideBlockType.swigValue == i) {
                return smartGuideBlockType;
            }
        }
        for (SmartGuideBlockType smartGuideBlockType2 : smartGuideBlockTypeArr) {
            if (smartGuideBlockType2.swigValue == i) {
                return smartGuideBlockType2;
            }
        }
        throw new IllegalArgumentException("No enum " + SmartGuideBlockType.class + " with value " + i);
    }

    SmartGuideBlockType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SmartGuideBlockType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SmartGuideBlockType(SmartGuideBlockType smartGuideBlockType) {
        int i = smartGuideBlockType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
