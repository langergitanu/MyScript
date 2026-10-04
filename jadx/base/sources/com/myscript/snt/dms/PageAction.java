package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum PageAction {
    UNSUPPORTED,
    CREATE_PAGE,
    DUPLICATE_PAGE,
    DELETE_PAGE,
    MOVE_PAGE_UP,
    MOVE_PAGE_DOWN,
    CONFIGURE_BACKGROUND,
    CHANGE_PAGE_SIZE,
    MANAGE_PAGE;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static PageAction swigToEnum(int i) {
        PageAction[] pageActionArr = (PageAction[]) PageAction.class.getEnumConstants();
        if (i < pageActionArr.length && i >= 0) {
            PageAction pageAction = pageActionArr[i];
            if (pageAction.swigValue == i) {
                return pageAction;
            }
        }
        for (PageAction pageAction2 : pageActionArr) {
            if (pageAction2.swigValue == i) {
                return pageAction2;
            }
        }
        throw new IllegalArgumentException("No enum " + PageAction.class + " with value " + i);
    }

    PageAction() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    PageAction(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    PageAction(PageAction pageAction) {
        int i = pageAction.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
