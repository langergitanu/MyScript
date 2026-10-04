package com.myscript.nebo.common.view;

import android.os.Handler;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import com.myscript.nebo.common.utils.TouchUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ViewHolderTouchDelegate implements View.OnTouchListener, View.OnDragListener {
    private static final int DRAG_DELAY_MS = 500;
    private static final boolean IS_DRAG_LISTENER = false;
    private static final int LONG_PRESS_DELAY_MS = 800;
    private String mDragDataMimeType;
    private Object mDraggedId;
    private Object mId;
    private boolean mIsSelected;
    private View mItemView;
    private Listener mListener;
    private boolean mIsDragging = false;
    private boolean mIsLongPressed = false;
    private boolean mIsRightClicked = false;
    private boolean mShoudIgnoreNextCancel = false;
    private final Handler mTouchHandler = new Handler();
    private final Runnable mLongClickRunnable = new Runnable() { // from class: com.myscript.nebo.common.view.ViewHolderTouchDelegate$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0();
        }
    };
    private final Runnable mDragRunnable = new Runnable() { // from class: com.myscript.nebo.common.view.ViewHolderTouchDelegate$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$1();
        }
    };

    public interface Listener {
        boolean isDragConfirmed();

        boolean isDragging();

        void onContextClick(View view, int i, int i2);

        boolean onDragStarted(View view);

        void onSelectedChanged(boolean z, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        Object obj = this.mDraggedId;
        if (obj != null) {
            longPress(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        startDrag();
        startLongClickTimer();
    }

    public ViewHolderTouchDelegate(View view, String str, Listener listener) {
        this.mItemView = view;
        this.mListener = listener;
        this.mDragDataMimeType = str;
        view.setOnTouchListener(this);
    }

    public void bind(Object obj, boolean z) {
        this.mId = obj;
        this.mIsSelected = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        if (TouchUtils.isRightClick(motionEvent)) {
            view.getLocationInWindow(new int[2]);
            this.mListener.onContextClick(view, (int) (r0[0] + motionEvent.getX()), (int) (r0[1] + motionEvent.getY()));
            this.mIsRightClicked = true;
            return true;
        }
        if (motionEvent.getAction() == 0) {
            startDragTimer();
            startLongClickTimer();
            view.setPressed(true);
            return true;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (motionEvent.getAction() == 3) {
                synchronized (this) {
                    if (this.mShoudIgnoreNextCancel) {
                        this.mShoudIgnoreNextCancel = false;
                        z = false;
                    } else {
                        z = true;
                    }
                }
            } else {
                z = true;
            }
            if (z) {
                stopDragging();
                synchronized (this) {
                    z2 = (this.mIsRightClicked || this.mIsLongPressed || motionEvent.getAction() != 1) ? false : true;
                    this.mIsRightClicked = false;
                    this.mIsLongPressed = false;
                    this.mShoudIgnoreNextCancel = false;
                }
                if (z2) {
                    view.performClick();
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        Object obj;
        int action = dragEvent.getAction();
        boolean z = false;
        if (action == 1) {
            return dragEvent.getClipDescription() != null && this.mId.equals(view.getTag()) && dragEvent.getClipDescription().hasMimeType(this.mDragDataMimeType);
        }
        if (action == 6) {
            stopDragging();
        } else {
            if (action == 3) {
                synchronized (this) {
                    if (this.mIsLongPressed && !this.mIsSelected) {
                        z = true;
                    }
                }
                stopDragging();
                if (z && (obj = this.mId) != null) {
                    longPress(obj);
                }
                return true;
            }
            if (action == 4) {
                stopDragging();
            }
        }
        return false;
    }

    private void stopDragging() {
        boolean z;
        stopLongClickTimer();
        stopDragTimer();
        this.mItemView.setPressed(false);
        synchronized (this) {
            z = this.mIsDragging;
        }
        if (z) {
            synchronized (this) {
                this.mIsDragging = false;
                this.mIsRightClicked = false;
                this.mIsLongPressed = false;
                this.mShoudIgnoreNextCancel = false;
            }
        }
    }

    private void startLongClickTimer() {
        this.mTouchHandler.removeCallbacks(this.mLongClickRunnable);
        this.mTouchHandler.postDelayed(this.mLongClickRunnable, 800L);
    }

    public void stopLongClickTimer() {
        this.mTouchHandler.removeCallbacks(this.mLongClickRunnable);
    }

    private void startDragTimer() {
        this.mTouchHandler.removeCallbacks(this.mDragRunnable);
        this.mTouchHandler.postDelayed(this.mDragRunnable, 500L);
    }

    private void stopDragTimer() {
        this.mTouchHandler.removeCallbacks(this.mDragRunnable);
    }

    private void longPress(Object obj) {
        synchronized (this) {
            this.mIsLongPressed = true;
        }
        if (this.mListener.isDragConfirmed()) {
            return;
        }
        updateSelection(obj);
    }

    private void startDrag() {
        this.mDraggedId = this.mId;
        boolean zOnDragStarted = this.mListener.onDragStarted(this.mItemView);
        synchronized (this) {
            this.mIsLongPressed = true;
            this.mIsDragging = zOnDragStarted;
            this.mShoudIgnoreNextCancel = zOnDragStarted;
        }
    }

    public void updateSelection(Object obj) {
        if (obj != null) {
            boolean z = !this.mIsSelected;
            this.mIsSelected = z;
            this.mListener.onSelectedChanged(z, obj);
        }
    }

    public void onDragStopped() {
        if (!this.mIsSelected) {
            this.mTouchHandler.removeCallbacks(this.mLongClickRunnable);
            Object obj = this.mDraggedId;
            if (obj != null) {
                longPress(obj);
            }
        }
        this.mDraggedId = null;
    }
}
