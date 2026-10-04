package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voListBulletSeparator {
    LIST_SEPARATOR_NONE,
    LIST_SEPARATOR_DOT,
    LIST_SEPARATOR_DASH,
    LIST_SEPARATOR_RIGHT_PARENTHESIS,
    LIST_SEPARATOR_FULLWIDTH_RIGHT_PARENTHESIS,
    LIST_SEPARATOR_IDEOGRAPHIC_COMMA,
    LIST_SEPARATOR_PAREN_SURROUND,
    LIST_SEPARATOR_ASIAN_PAREN_SURROUND;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voListBulletSeparator swigToEnum(int i) {
        voListBulletSeparator[] volistbulletseparatorArr = (voListBulletSeparator[]) voListBulletSeparator.class.getEnumConstants();
        if (i < volistbulletseparatorArr.length && i >= 0) {
            voListBulletSeparator volistbulletseparator = volistbulletseparatorArr[i];
            if (volistbulletseparator.swigValue == i) {
                return volistbulletseparator;
            }
        }
        for (voListBulletSeparator volistbulletseparator2 : volistbulletseparatorArr) {
            if (volistbulletseparator2.swigValue == i) {
                return volistbulletseparator2;
            }
        }
        throw new IllegalArgumentException("No enum " + voListBulletSeparator.class + " with value " + i);
    }

    voListBulletSeparator() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voListBulletSeparator(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voListBulletSeparator(voListBulletSeparator volistbulletseparator) {
        int i = volistbulletseparator.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
