package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum SharePageManagerTaskKind {
    SHARE_PAGE,
    SHARED_LIST_PAGES,
    SHARED_PAGE_INFOS,
    SHARED_PAGE_MODIFIED,
    SHARED_PAGE_RENAMED,
    SHARED_PAGE_PAGEKEY_RESETED,
    SHARED_DOCUMENT_DELETED,
    SHARED_DOCUMENT_MODIFIED,
    SHARE_PAGE_DONE,
    DISABLE_SHARE_PAGE,
    REMOVE_PAGE_SHARED,
    CHANGE_VISIBILITY_PAGE_SHARED,
    UPDATE_USER_PAGE_SHARED,
    REMOVE_USER_PAGE_SHARED,
    ADD_USERS_PAGE_SHARED;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SharePageManagerTaskKind swigToEnum(int i) {
        SharePageManagerTaskKind[] sharePageManagerTaskKindArr = (SharePageManagerTaskKind[]) SharePageManagerTaskKind.class.getEnumConstants();
        if (i < sharePageManagerTaskKindArr.length && i >= 0) {
            SharePageManagerTaskKind sharePageManagerTaskKind = sharePageManagerTaskKindArr[i];
            if (sharePageManagerTaskKind.swigValue == i) {
                return sharePageManagerTaskKind;
            }
        }
        for (SharePageManagerTaskKind sharePageManagerTaskKind2 : sharePageManagerTaskKindArr) {
            if (sharePageManagerTaskKind2.swigValue == i) {
                return sharePageManagerTaskKind2;
            }
        }
        throw new IllegalArgumentException("No enum " + SharePageManagerTaskKind.class + " with value " + i);
    }

    SharePageManagerTaskKind() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SharePageManagerTaskKind(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SharePageManagerTaskKind(SharePageManagerTaskKind sharePageManagerTaskKind) {
        int i = sharePageManagerTaskKind.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
