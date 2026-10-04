package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voListBulletKind {
    LIST_BULLET_KIND_NONE,
    LIST_BULLET_KIND_BULLET,
    LIST_BULLET_KIND_NUMBER,
    LIST_BULLET_KIND_LETTER,
    LIST_BULLET_KIND_CHECK;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voListBulletKind swigToEnum(int i) {
        voListBulletKind[] volistbulletkindArr = (voListBulletKind[]) voListBulletKind.class.getEnumConstants();
        if (i < volistbulletkindArr.length && i >= 0) {
            voListBulletKind volistbulletkind = volistbulletkindArr[i];
            if (volistbulletkind.swigValue == i) {
                return volistbulletkind;
            }
        }
        for (voListBulletKind volistbulletkind2 : volistbulletkindArr) {
            if (volistbulletkind2.swigValue == i) {
                return volistbulletkind2;
            }
        }
        throw new IllegalArgumentException("No enum " + voListBulletKind.class + " with value " + i);
    }

    voListBulletKind() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voListBulletKind(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voListBulletKind(voListBulletKind volistbulletkind) {
        int i = volistbulletkind.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
