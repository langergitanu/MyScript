package com.myscript.nebo.editing.impl.keyboard.cursor;

import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.myscript.nebo.editing.C6421R;
import com.myscript.nebo.editing.impl.keyboard.cursor.SelectionCursorManager;

/* JADX INFO: loaded from: classes7.dex */
class InsertionHandleView extends HandleView {
    private static final boolean DBG = false;
    private static final int DELAY_BEFORE_HANDLE_FADES_OUT = 4000;
    private static final String TAG = "InsertionHandleView";
    private boolean mCursorMoved;
    private final Runnable mHider;
    private final Handler mHiderHandler;
    private int mSelectionStart;

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    protected int getHorizontalGravity(boolean z) {
        return 1;
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    HandleView getOtherSelectionHandle() {
        return null;
    }

    public InsertionHandleView(View view, Drawable drawable, SelectionCursorManager selectionCursorManager) {
        super(view, drawable, drawable, C6421R.id.insertion_handle, selectionCursorManager);
        this.mCursorMoved = false;
        this.mSelectionStart = 0;
        this.mHiderHandler = new Handler(Looper.getMainLooper());
        this.mHider = new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.cursor.InsertionHandleView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        hide();
        finishContextualMenu();
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    public void show() {
        super.show();
        forceRepaint();
        hideAfterDelay();
    }

    private void hideAfterDelay() {
        removeHiderCallback();
        this.mHiderHandler.postDelayed(this.mHider, 4000L);
    }

    private void removeHiderCallback() {
        this.mHiderHandler.removeCallbacks(this.mHider);
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    protected int getHotspotX(Drawable drawable, boolean z) {
        return drawable.getIntrinsicWidth() / 2;
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    public PointF getCurrentCursorPosition() {
        return this.mSelectionCursorManager.getInputModel().getGraphicalCursorStart();
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    public void updateSelection(float f, float f2) {
        if (!isScrolling()) {
            this.mSelectionCursorManager.setCursorPosition(f, f2, SelectionCursorManager.CursorType.CURSOR_TYPE_LEFT);
        } else {
            this.mLastIgnoredX = f;
            this.mLastIgnoredY = f2;
            this.mLastIgnoredHandle = SelectionCursorManager.CursorType.CURSOR_TYPE_LEFT;
        }
        if (!this.mIsContextualMenuShown || this.mCursorMoved) {
            return;
        }
        post(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.cursor.InsertionHandleView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showContextualMenu();
            }
        });
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    void onHandleMoved() {
        super.onHandleMoved();
        removeHiderCallback();
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    public void onDetached() {
        super.onDetached();
        removeHiderCallback();
        this.mPositionListener.removeSubscriber(this);
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mCursorMoved = false;
            this.mSelectionStart = getSelectionStart();
            this.mWasContextualMenuShown = this.mIsContextualMenuShown;
            finishContextualMenu();
            updateMagnifier(SelectionCursorManager.CursorPosition.START);
            return zOnTouchEvent;
        }
        if (actionMasked == 1) {
            hideAfterDelay();
            dismissMagnifier();
            if (!this.mCursorMoved) {
                if (this.mWasContextualMenuShown) {
                    finishContextualMenu();
                    return zOnTouchEvent;
                }
                showContextualMenu();
                return zOnTouchEvent;
            }
            if (this.mWasContextualMenuShown) {
                showContextualMenu();
            }
        } else {
            if (actionMasked == 2) {
                if (this.mSelectionStart != getSelectionStart()) {
                    this.mCursorMoved = true;
                }
                updateMagnifier(SelectionCursorManager.CursorPosition.START);
                return zOnTouchEvent;
            }
            if (actionMasked == 3) {
                hideAfterDelay();
                dismissMagnifier();
                return zOnTouchEvent;
            }
        }
        return zOnTouchEvent;
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    protected SelectionCursorManager.CursorPosition getCursorPosition() {
        return SelectionCursorManager.CursorPosition.START;
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView
    public float getHorizontal() {
        return positionFromStartTop().x;
    }
}
