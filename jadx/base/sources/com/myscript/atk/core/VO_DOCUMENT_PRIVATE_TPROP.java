package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum VO_DOCUMENT_PRIVATE_TPROP {
    DOCUMENT_REPACKING(2331848);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static VO_DOCUMENT_PRIVATE_TPROP swigToEnum(int i) {
        VO_DOCUMENT_PRIVATE_TPROP[] vo_document_private_tpropArr = (VO_DOCUMENT_PRIVATE_TPROP[]) VO_DOCUMENT_PRIVATE_TPROP.class.getEnumConstants();
        if (i < vo_document_private_tpropArr.length && i >= 0) {
            VO_DOCUMENT_PRIVATE_TPROP vo_document_private_tprop = vo_document_private_tpropArr[i];
            if (vo_document_private_tprop.swigValue == i) {
                return vo_document_private_tprop;
            }
        }
        for (VO_DOCUMENT_PRIVATE_TPROP vo_document_private_tprop2 : vo_document_private_tpropArr) {
            if (vo_document_private_tprop2.swigValue == i) {
                return vo_document_private_tprop2;
            }
        }
        throw new IllegalArgumentException("No enum " + VO_DOCUMENT_PRIVATE_TPROP.class + " with value " + i);
    }

    VO_DOCUMENT_PRIVATE_TPROP() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    VO_DOCUMENT_PRIVATE_TPROP(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    VO_DOCUMENT_PRIVATE_TPROP(VO_DOCUMENT_PRIVATE_TPROP vo_document_private_tprop) {
        int i = vo_document_private_tprop.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
