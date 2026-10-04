package com.myscript.atk.text;

/* JADX INFO: loaded from: classes4.dex */
public enum StyleType {
    NONE(0),
    NORMAL(1),
    BOLD(2),
    UNDERLINE(4),
    DOUBLE_UNDERLINE(8),
    STRIKE_THROUGH(16),
    HIGHLIGHT(32),
    H1(64),
    H2(128),
    H3(256),
    UNORDERED_LIST(512),
    ORDERED_LIST(1024),
    CHECK_LIST(2048),
    MIXED_LIST(4096),
    EMPHASIS_1(8192),
    EMPHASIS_2(16384),
    ALL(32767);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static StyleType swigToEnum(int i) {
        StyleType[] styleTypeArr = (StyleType[]) StyleType.class.getEnumConstants();
        if (i < styleTypeArr.length && i >= 0) {
            StyleType styleType = styleTypeArr[i];
            if (styleType.swigValue == i) {
                return styleType;
            }
        }
        for (StyleType styleType2 : styleTypeArr) {
            if (styleType2.swigValue == i) {
                return styleType2;
            }
        }
        throw new IllegalArgumentException("No enum " + StyleType.class + " with value " + i);
    }

    StyleType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    StyleType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    StyleType(StyleType styleType) {
        int i = styleType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
