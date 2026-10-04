package com.myscript.nebo.dms;

import android.content.ClipData;
import android.graphics.Point;
import android.view.View;
import com.myscript.nebo.common.view.CustomDragShadowBuilder;

/* JADX INFO: loaded from: classes7.dex */
public final class NotebookDragShadowBuilder extends CustomDragShadowBuilder {
    public static boolean startDrag(View view, ClipData clipData, Point point) {
        return CustomDragShadowBuilder.startDrag(view, clipData, new NotebookDragShadowBuilder(view, point));
    }

    private NotebookDragShadowBuilder(View view, Point point) {
        super(view, point);
    }
}
