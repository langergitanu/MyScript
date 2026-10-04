package com.myscript.nebo.dms;

import android.content.ClipData;
import com.myscript.snt.core.PageKey;

/* JADX INFO: loaded from: classes7.dex */
public final class DragPageClipDataHelper {
    public static final String DRAG_PAGE_MIME = "application/vnd.nebo_page";
    private static final int NUMBER_CLIP_ITEMS = 1;

    private DragPageClipDataHelper() {
    }

    public static ClipData getPageClipData(PageKey pageKey) {
        return new ClipData(pageKey.toString(), new String[]{DRAG_PAGE_MIME}, new ClipData.Item(pageKey.serialize()));
    }

    public static PageKey getPageKey(ClipData clipData) {
        if (clipData == null || clipData.getItemCount() != 1) {
            return null;
        }
        return PageKey.deserialize(clipData.getItemAt(0).getText().toString());
    }
}
