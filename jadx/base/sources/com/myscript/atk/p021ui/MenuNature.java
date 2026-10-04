package com.myscript.atk.p021ui;

/* JADX INFO: loaded from: classes4.dex */
public enum MenuNature {
    UNDEFINED(0),
    TAP,
    LASSO,
    INLINE,
    LONG_PRESS;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static MenuNature swigToEnum(int i) {
        MenuNature[] menuNatureArr = (MenuNature[]) MenuNature.class.getEnumConstants();
        if (i < menuNatureArr.length && i >= 0) {
            MenuNature menuNature = menuNatureArr[i];
            if (menuNature.swigValue == i) {
                return menuNature;
            }
        }
        for (MenuNature menuNature2 : menuNatureArr) {
            if (menuNature2.swigValue == i) {
                return menuNature2;
            }
        }
        throw new IllegalArgumentException("No enum " + MenuNature.class + " with value " + i);
    }

    MenuNature() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    MenuNature(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    MenuNature(MenuNature menuNature) {
        int i = menuNature.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
