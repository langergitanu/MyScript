package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public enum ListItemType {
    NONE(0),
    BULLET,
    BULLET_ORDER_BY_LETTER,
    BULLET_ORDER_BY_NUMBER,
    CHECK,
    LIST_CLOSE;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static ListItemType swigToEnum(int i) {
        ListItemType[] listItemTypeArr = (ListItemType[]) ListItemType.class.getEnumConstants();
        if (i < listItemTypeArr.length && i >= 0) {
            ListItemType listItemType = listItemTypeArr[i];
            if (listItemType.swigValue == i) {
                return listItemType;
            }
        }
        for (ListItemType listItemType2 : listItemTypeArr) {
            if (listItemType2.swigValue == i) {
                return listItemType2;
            }
        }
        throw new IllegalArgumentException("No enum " + ListItemType.class + " with value " + i);
    }

    ListItemType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    ListItemType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    ListItemType(ListItemType listItemType) {
        int i = listItemType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
