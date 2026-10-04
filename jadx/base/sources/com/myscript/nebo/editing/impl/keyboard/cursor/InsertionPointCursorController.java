package com.myscript.nebo.editing.impl.keyboard.cursor;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.myscript.nebo.editing.impl.keyboard.cursor.HandleView;

/* JADX INFO: loaded from: classes7.dex */
public class InsertionPointCursorController {
    private final InsertionHandleView mHandle;
    private boolean mWasMenuDisplayed = false;

    InsertionPointCursorController(View view, SelectionCursorManager selectionCursorManager) {
        Context context = view.getContext();
        Resources.Theme theme = context.getTheme();
        Resources resources = context.getResources();
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(R.attr.textSelectHandle, typedValue, true);
        this.mHandle = new InsertionHandleView(view, ResourcesCompat.getDrawable(resources, typedValue.resourceId, theme), selectionCursorManager);
    }

    public void show() {
        this.mHandle.show();
        if (this.mWasMenuDisplayed) {
            this.mHandle.showContextualMenu();
            this.mWasMenuDisplayed = false;
        }
    }

    public void hide(boolean z) {
        this.mWasMenuDisplayed = z;
        this.mHandle.hide();
    }

    InsertionHandleView getHandle() {
        return this.mHandle;
    }

    boolean isActive() {
        return this.mHandle.isShowing();
    }

    void invalidateHandle() {
        this.mHandle.invalidate();
    }

    boolean isDraggingHandle() {
        InsertionHandleView handle = getHandle();
        if (handle != null) {
            return handle.isDragging() || handle.isScrolling();
        }
        return false;
    }

    public void setDraggingListener(HandleView.IDraggingListener iDraggingListener) {
        this.mHandle.setDraggingListener(iDraggingListener);
    }

    boolean isScrollingUsingHandle() {
        InsertionHandleView handle = getHandle();
        return handle != null && handle.isScrolling();
    }
}
