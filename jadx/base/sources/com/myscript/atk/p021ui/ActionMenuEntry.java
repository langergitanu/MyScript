package com.myscript.atk.p021ui;

/* JADX INFO: loaded from: classes4.dex */
public enum ActionMenuEntry {
    CREATE_OBJECT,
    CREATE_SECTION,
    SPACE_MANAGEMENT,
    ADD_OBJECT,
    FITTO,
    RELOAD,
    CUT,
    COPY,
    COPY_AS,
    COPY_AS_TEXT,
    COPY_AS_DRAWING,
    COPY_AS_MATH,
    COPY_AS_DIAGRAM,
    GROUP_AS,
    GROUP_AS_TEXT,
    GROUP_AS_MATH,
    GROUP_AS_SHAPE,
    GROUP_AS_DRAWING,
    PASTE,
    REMOVE,
    CONVERT,
    CONVERT_AS,
    CONVERT_TEXT,
    CONVERT_MATH,
    SOLVE,
    RESIZE,
    LEARN,
    CROP,
    STYLES,
    STYLES_BOLD,
    STYLES_UNDERLINE,
    STYLES_DOUBLE_UNDERLINE,
    STYLES_STRIKE_THROUGH,
    STYLES_HIGHLIGHT,
    INDENT,
    INDENT_DECREASE,
    INDENT_INCREASE,
    LIST,
    LIST_DOT,
    LIST_NUMBER,
    LIST_CHECK_MARK,
    LIST_NONE,
    CLOSE,
    PDF_PAGE_INSERT,
    PDF_PAGE_DUPLICATE,
    PDF_PAGE_REMOVE,
    PDF_PAGE_MOVE_UP,
    PDF_PAGE_MOVE_DOWN,
    PDF_PAGE_MANAGE,
    AI,
    AI_SUMMARIZE,
    AI_EXPLAIN,
    AI_CHAT,
    AI_QUIZ;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static ActionMenuEntry swigToEnum(int i) {
        ActionMenuEntry[] actionMenuEntryArr = (ActionMenuEntry[]) ActionMenuEntry.class.getEnumConstants();
        if (i < actionMenuEntryArr.length && i >= 0) {
            ActionMenuEntry actionMenuEntry = actionMenuEntryArr[i];
            if (actionMenuEntry.swigValue == i) {
                return actionMenuEntry;
            }
        }
        for (ActionMenuEntry actionMenuEntry2 : actionMenuEntryArr) {
            if (actionMenuEntry2.swigValue == i) {
                return actionMenuEntry2;
            }
        }
        throw new IllegalArgumentException("No enum " + ActionMenuEntry.class + " with value " + i);
    }

    ActionMenuEntry() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    ActionMenuEntry(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    ActionMenuEntry(ActionMenuEntry actionMenuEntry) {
        int i = actionMenuEntry.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
