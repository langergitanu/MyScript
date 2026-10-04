package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum VO_TEXT_STRUCTURE_PRIVATE_TPROP {
    TEXT_STRUCTURE_DISABLE(1337),
    TEXT_STRUCTURE_GEOMETRY(42),
    TEXT_STRUCTURE_ENABLE_ARBITRARY_REFLOW(51914),
    TEXT_STRUCTURE_INDENT_MODE(219540062),
    TEXT_STRUCTURE_LINEBREAK_MODE(233811181);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static VO_TEXT_STRUCTURE_PRIVATE_TPROP swigToEnum(int i) {
        VO_TEXT_STRUCTURE_PRIVATE_TPROP[] vo_text_structure_private_tpropArr = (VO_TEXT_STRUCTURE_PRIVATE_TPROP[]) VO_TEXT_STRUCTURE_PRIVATE_TPROP.class.getEnumConstants();
        if (i < vo_text_structure_private_tpropArr.length && i >= 0) {
            VO_TEXT_STRUCTURE_PRIVATE_TPROP vo_text_structure_private_tprop = vo_text_structure_private_tpropArr[i];
            if (vo_text_structure_private_tprop.swigValue == i) {
                return vo_text_structure_private_tprop;
            }
        }
        for (VO_TEXT_STRUCTURE_PRIVATE_TPROP vo_text_structure_private_tprop2 : vo_text_structure_private_tpropArr) {
            if (vo_text_structure_private_tprop2.swigValue == i) {
                return vo_text_structure_private_tprop2;
            }
        }
        throw new IllegalArgumentException("No enum " + VO_TEXT_STRUCTURE_PRIVATE_TPROP.class + " with value " + i);
    }

    VO_TEXT_STRUCTURE_PRIVATE_TPROP() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    VO_TEXT_STRUCTURE_PRIVATE_TPROP(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    VO_TEXT_STRUCTURE_PRIVATE_TPROP(VO_TEXT_STRUCTURE_PRIVATE_TPROP vo_text_structure_private_tprop) {
        int i = vo_text_structure_private_tprop.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
