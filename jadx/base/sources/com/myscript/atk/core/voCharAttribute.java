package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voCharAttribute {
    CHAR_ATTRIBUTE_EXTERNAL_ITEM(1024),
    CHAR_ATTRIBUTE_INTERNAL_ITEM(2048),
    CHAR_ATTRIBUTE_SPACE(4096),
    CHAR_ATTRIBUTE_LINE_FEED(8192),
    CHAR_ATTRIBUTE_SOFT_HYPHEN(16384),
    CHAR_ATTRIBUTE_ZERO_WIDTH_NON_JOINER(32768),
    CHAR_ATTRIBUTE_PUNCTUATION(65536),
    CHAR_ATTRIBUTE_CHINESE_JAPANESE(262144),
    CHAR_ATTRIBUTE_KOREAN(524288),
    CHAR_ATTRIBUTE_NON_OBSERVABLE(2097152),
    CHAR_ATTRIBUTE_GLYPH(16777216);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voCharAttribute swigToEnum(int i) {
        voCharAttribute[] vocharattributeArr = (voCharAttribute[]) voCharAttribute.class.getEnumConstants();
        if (i < vocharattributeArr.length && i >= 0) {
            voCharAttribute vocharattribute = vocharattributeArr[i];
            if (vocharattribute.swigValue == i) {
                return vocharattribute;
            }
        }
        for (voCharAttribute vocharattribute2 : vocharattributeArr) {
            if (vocharattribute2.swigValue == i) {
                return vocharattribute2;
            }
        }
        throw new IllegalArgumentException("No enum " + voCharAttribute.class + " with value " + i);
    }

    voCharAttribute() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voCharAttribute(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voCharAttribute(voCharAttribute vocharattribute) {
        int i = vocharattribute.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
