package com.myscript.nebo.editing.impl.keyboard.cursor;

import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.myscript.nebo.editing.impl.keyboard.InputModel;
import com.myscript.nebo.editing.impl.keyboard.cursor.SelectionCursorManager;

/* JADX INFO: loaded from: classes7.dex */
class SelectionHandleView extends HandleView {
    private static final boolean DBG = false;
    private static final String TAG = "SelectionHandleView";
    private final HandleType mHandleType;
    private final SelectionModifierCursorController mSelectionController;

    public enum HandleType {
        HANDLE_TYPE_SELECTION_START,
        HANDLE_TYPE_SELECTION_END
    }

    public SelectionHandleView(View view, Drawable drawable, Drawable drawable2, int i, SelectionCursorManager selectionCursorManager, SelectionModifierCursorController selectionModifierCursorController, HandleType handleType) {
        super(view, drawable, drawable2, i, selectionCursorManager);
        this.mHandleType = handleType;
        this.mSelectionController = selectionModifierCursorController;
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    protected boolean isStartHandle() {
        return this.mHandleType == HandleType.HANDLE_TYPE_SELECTION_START;
    }

    public void toggleCursorSwapped() {
        this.mSwapped = !this.mSwapped;
    }

    public void setCursorSwapped(boolean z) {
        this.mSwapped = z;
    }

    public boolean cursorSwapped() {
        return this.mSwapped;
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    protected int getHotspotX(Drawable drawable, boolean z) {
        if (z == isStartHandle()) {
            return drawable.getIntrinsicWidth() / 4;
        }
        return (drawable.getIntrinsicWidth() * 3) / 4;
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    protected int getHorizontalGravity(boolean z) {
        return z == isStartHandle() ? 3 : 5;
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    public PointF getCurrentCursorPosition() {
        InputModel inputModel = this.mSelectionCursorManager.getInputModel();
        return isStartHandle() ? inputModel.getGraphicalCursorStart() : inputModel.getGraphicalCursorEnd();
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    HandleView getOtherSelectionHandle() {
        return isStartHandle() ? this.mSelectionController.getEndHandle() : this;
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    protected void updateSelection(float f, float f2) {
        if (!isScrolling()) {
            if (this.mSwapped) {
                this.mSelectionCursorManager.setCursorPosition(f, f2, isStartHandle() ? SelectionCursorManager.CursorType.CURSOR_TYPE_RIGHT : SelectionCursorManager.CursorType.CURSOR_TYPE_LEFT);
            } else {
                this.mSelectionCursorManager.setCursorPosition(f, f2, isStartHandle() ? SelectionCursorManager.CursorType.CURSOR_TYPE_LEFT : SelectionCursorManager.CursorType.CURSOR_TYPE_RIGHT);
            }
        } else {
            this.mLastIgnoredX = f;
            this.mLastIgnoredY = f2;
            if (this.mSwapped) {
                this.mLastIgnoredHandle = isStartHandle() ? SelectionCursorManager.CursorType.CURSOR_TYPE_RIGHT : SelectionCursorManager.CursorType.CURSOR_TYPE_LEFT;
            } else {
                this.mLastIgnoredHandle = isStartHandle() ? SelectionCursorManager.CursorType.CURSOR_TYPE_LEFT : SelectionCursorManager.CursorType.CURSOR_TYPE_RIGHT;
            }
        }
        updateDrawable();
        if (this.mIsContextualMenuShown) {
            post(new SelectionHandleView$$ExternalSyntheticLambda0(this));
        }
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    public float getHorizontal() {
        return (isStartHandle() ? positionFromStartTop() : positionFromEndTop()).x;
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    public void show() {
        super.show();
        forceRepaint();
        if (!isStartHandle() || isShown()) {
            return;
        }
        post(new SelectionHandleView$$ExternalSyntheticLambda0(this));
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            finishContextualMenu();
        } else {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return zOnTouchEvent;
                    }
                }
            }
            dismissMagnifier();
            showContextualMenu();
            return zOnTouchEvent;
        }
        updateMagnifier(getCursorPosition());
        return zOnTouchEvent;
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    protected SelectionCursorManager.CursorPosition getCursorPosition() {
        if (this.mHandleType == (this.mSwapped ? HandleType.HANDLE_TYPE_SELECTION_END : HandleType.HANDLE_TYPE_SELECTION_START)) {
            return SelectionCursorManager.CursorPosition.START;
        }
        return SelectionCursorManager.CursorPosition.END;
    }
}
