package com.myscript.atk.p021ui;

/* JADX INFO: loaded from: classes4.dex */
public enum MenuType {
    NONE,
    SMARTGUIDE,
    EDIT_MENU;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static MenuType swigToEnum(int i) {
        MenuType[] menuTypeArr = (MenuType[]) MenuType.class.getEnumConstants();
        if (i < menuTypeArr.length && i >= 0) {
            MenuType menuType = menuTypeArr[i];
            if (menuType.swigValue == i) {
                return menuType;
            }
        }
        for (MenuType menuType2 : menuTypeArr) {
            if (menuType2.swigValue == i) {
                return menuType2;
            }
        }
        throw new IllegalArgumentException("No enum " + MenuType.class + " with value " + i);
    }

    MenuType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    MenuType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    MenuType(MenuType menuType) {
        int i = menuType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
