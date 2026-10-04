package com.myscript.nebo.editing.impl.keyboard.cursor;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.myscript.nebo.editing.C6421R;
import com.myscript.nebo.editing.impl.keyboard.cursor.HandleView;
import com.myscript.nebo.editing.impl.keyboard.cursor.SelectionHandleView;

/* JADX INFO: loaded from: classes7.dex */
public class SelectionModifierCursorController {
    private final SelectionHandleView mEndHandle;
    private final SelectionHandleView mStartHandle;
    private boolean mWasMenuDisplayed = false;

    SelectionModifierCursorController(View view, SelectionCursorManager selectionCursorManager) {
        Context context = view.getContext();
        Resources.Theme theme = context.getTheme();
        Resources resources = context.getResources();
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(R.attr.textSelectHandleLeft, typedValue, true);
        Drawable drawable = ResourcesCompat.getDrawable(resources, typedValue.resourceId, theme);
        theme.resolveAttribute(R.attr.textSelectHandleRight, typedValue, true);
        Drawable drawable2 = ResourcesCompat.getDrawable(resources, typedValue.resourceId, theme);
        this.mStartHandle = new SelectionHandleView(view, drawable, drawable2, C6421R.id.selection_start_handle, selectionCursorManager, this, SelectionHandleView.HandleType.HANDLE_TYPE_SELECTION_START);
        this.mEndHandle = new SelectionHandleView(view, drawable2, drawable, C6421R.id.selection_end_handle, selectionCursorManager, this, SelectionHandleView.HandleType.HANDLE_TYPE_SELECTION_END);
    }

    public void show() {
        this.mStartHandle.show();
        this.mEndHandle.show();
        if (this.mWasMenuDisplayed) {
            this.mStartHandle.showContextualMenu();
            this.mWasMenuDisplayed = false;
        }
    }

    public void hide(boolean z) {
        this.mWasMenuDisplayed = z;
        this.mStartHandle.hide();
        this.mEndHandle.hide();
    }

    boolean isActive() {
        return this.mStartHandle.isShowing();
    }

    HandleView getStartHandle() {
        return this.mStartHandle;
    }

    HandleView getEndHandle() {
        return this.mEndHandle;
    }

    boolean isDraggingHandle() {
        return this.mStartHandle.isDragging() || this.mStartHandle.isScrolling() || this.mEndHandle.isDragging() || this.mEndHandle.isScrolling();
    }

    public void setDraggingListener(HandleView.IDraggingListener iDraggingListener) {
        this.mStartHandle.setDraggingListener(iDraggingListener);
        this.mEndHandle.setDraggingListener(iDraggingListener);
    }

    boolean isScrollingUsingHandle() {
        return getStartHandle().isScrolling() || getEndHandle().isScrolling();
    }

    void swapCursors() {
        if (this.mStartHandle.isDragging() || this.mEndHandle.isDragging()) {
            this.mStartHandle.toggleCursorSwapped();
            this.mEndHandle.toggleCursorSwapped();
        }
    }

    void setCursorsSwapped(boolean z) {
        this.mStartHandle.setCursorSwapped(z);
        this.mEndHandle.setCursorSwapped(z);
    }

    boolean cursorsSwapped() {
        if (this.mStartHandle.isDragging() || this.mEndHandle.isDragging()) {
            return this.mStartHandle.cursorSwapped() || this.mEndHandle.cursorSwapped();
        }
        return false;
    }
}
