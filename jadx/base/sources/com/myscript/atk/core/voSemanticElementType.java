package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voSemanticElementType {
    SEMANTIC_ELEMENT_TYPE_ERR(-1),
    SEMANTIC_ELEMENT_TYPE_STRUCTURE(0),
    SEMANTIC_ELEMENT_TYPE_TEXT_ITEM,
    SEMANTIC_ELEMENT_TYPE_LIST_ITEM,
    SEMANTIC_ELEMENT_TYPE_DIVIDER;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voSemanticElementType swigToEnum(int i) {
        voSemanticElementType[] vosemanticelementtypeArr = (voSemanticElementType[]) voSemanticElementType.class.getEnumConstants();
        if (i < vosemanticelementtypeArr.length && i >= 0) {
            voSemanticElementType vosemanticelementtype = vosemanticelementtypeArr[i];
            if (vosemanticelementtype.swigValue == i) {
                return vosemanticelementtype;
            }
        }
        for (voSemanticElementType vosemanticelementtype2 : vosemanticelementtypeArr) {
            if (vosemanticelementtype2.swigValue == i) {
                return vosemanticelementtype2;
            }
        }
        throw new IllegalArgumentException("No enum " + voSemanticElementType.class + " with value " + i);
    }

    voSemanticElementType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voSemanticElementType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voSemanticElementType(voSemanticElementType vosemanticelementtype) {
        int i = vosemanticelementtype.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
