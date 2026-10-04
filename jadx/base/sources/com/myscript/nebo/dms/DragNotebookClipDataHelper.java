package com.myscript.nebo.dms;

import android.content.ClipData;
import com.myscript.snt.core.NotebookKey;

/* JADX INFO: loaded from: classes7.dex */
public final class DragNotebookClipDataHelper {
    public static final String DRAG_NOTEBOOK_MIME = "application/vnd.nebo_notebook";

    public static ClipData getNotebookClipData(NotebookKey notebookKey) {
        return new ClipData(notebookKey.serialize(), new String[]{DRAG_NOTEBOOK_MIME}, new ClipData.Item(notebookKey.serialize()));
    }

    public static NotebookKey getNotebookPath(ClipData clipData) {
        if (clipData == null || clipData.getItemCount() != 1) {
            return null;
        }
        return NotebookKey.deserialize(clipData.getItemAt(0).getText().toString());
    }
}
