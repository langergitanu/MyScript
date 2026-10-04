package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum VO_INK_T {
    InkStrokeFormat(3100),
    InkStrokeFormatBuilder,
    InkStroke,
    InkStrokeBuilder,
    Ink,
    InkIntervals,
    InkSegment,
    InkSelection,
    InkTagIterator,
    Glyph,
    ArcPrimitive,
    LinePrimitive;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static VO_INK_T swigToEnum(int i) {
        VO_INK_T[] vo_ink_tArr = (VO_INK_T[]) VO_INK_T.class.getEnumConstants();
        if (i < vo_ink_tArr.length && i >= 0) {
            VO_INK_T vo_ink_t = vo_ink_tArr[i];
            if (vo_ink_t.swigValue == i) {
                return vo_ink_t;
            }
        }
        for (VO_INK_T vo_ink_t2 : vo_ink_tArr) {
            if (vo_ink_t2.swigValue == i) {
                return vo_ink_t2;
            }
        }
        throw new IllegalArgumentException("No enum " + VO_INK_T.class + " with value " + i);
    }

    VO_INK_T() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    VO_INK_T(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    VO_INK_T(VO_INK_T vo_ink_t) {
        int i = vo_ink_t.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
