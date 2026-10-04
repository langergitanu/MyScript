package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voTextSructureIndentMode {
    TEXT_STRUCTURE_INDENT_MODE_DYNAMIC(0),
    TEXT_STRUCTURE_INDENT_MODE_STATIC,
    TEXT_STRUCTURE_INDENT_MODE_STATIC_ML;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voTextSructureIndentMode swigToEnum(int i) {
        voTextSructureIndentMode[] votextsructureindentmodeArr = (voTextSructureIndentMode[]) voTextSructureIndentMode.class.getEnumConstants();
        if (i < votextsructureindentmodeArr.length && i >= 0) {
            voTextSructureIndentMode votextsructureindentmode = votextsructureindentmodeArr[i];
            if (votextsructureindentmode.swigValue == i) {
                return votextsructureindentmode;
            }
        }
        for (voTextSructureIndentMode votextsructureindentmode2 : votextsructureindentmodeArr) {
            if (votextsructureindentmode2.swigValue == i) {
                return votextsructureindentmode2;
            }
        }
        throw new IllegalArgumentException("No enum " + voTextSructureIndentMode.class + " with value " + i);
    }

    voTextSructureIndentMode() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voTextSructureIndentMode(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voTextSructureIndentMode(voTextSructureIndentMode votextsructureindentmode) {
        int i = votextsructureindentmode.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
