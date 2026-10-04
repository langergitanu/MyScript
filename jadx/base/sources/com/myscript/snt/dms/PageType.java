package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum PageType {
    TextDocument,
    RawContent,
    PDF;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static PageType swigToEnum(int i) {
        PageType[] pageTypeArr = (PageType[]) PageType.class.getEnumConstants();
        if (i < pageTypeArr.length && i >= 0) {
            PageType pageType = pageTypeArr[i];
            if (pageType.swigValue == i) {
                return pageType;
            }
        }
        for (PageType pageType2 : pageTypeArr) {
            if (pageType2.swigValue == i) {
                return pageType2;
            }
        }
        throw new IllegalArgumentException("No enum " + PageType.class + " with value " + i);
    }

    PageType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    PageType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    PageType(PageType pageType) {
        int i = pageType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
