package com.myscript.nebo.clipboard;

import android.provider.OpenableColumns;

/* JADX INFO: loaded from: classes3.dex */
public class ClipboardContentContract {

    public static final class FileEntry implements OpenableColumns {
        static final int COL_DISPLAY_NAME = 0;
        static final int COL_PATH = 2;
        static final int COL_SIZE = 1;
        public static final String PATH = "_path";
        public static final String[] FILE_COLUMNS = {"_display_name", "_size", PATH};
    }
}
