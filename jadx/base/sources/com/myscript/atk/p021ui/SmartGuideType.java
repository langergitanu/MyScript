package com.myscript.atk.p021ui;

/* JADX INFO: loaded from: classes4.dex */
public enum SmartGuideType {
    None,
    Text,
    Shape,
    Multi,
    TextAndShape;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SmartGuideType swigToEnum(int i) {
        SmartGuideType[] smartGuideTypeArr = (SmartGuideType[]) SmartGuideType.class.getEnumConstants();
        if (i < smartGuideTypeArr.length && i >= 0) {
            SmartGuideType smartGuideType = smartGuideTypeArr[i];
            if (smartGuideType.swigValue == i) {
                return smartGuideType;
            }
        }
        for (SmartGuideType smartGuideType2 : smartGuideTypeArr) {
            if (smartGuideType2.swigValue == i) {
                return smartGuideType2;
            }
        }
        throw new IllegalArgumentException("No enum " + SmartGuideType.class + " with value " + i);
    }

    SmartGuideType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SmartGuideType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SmartGuideType(SmartGuideType smartGuideType) {
        int i = smartGuideType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
