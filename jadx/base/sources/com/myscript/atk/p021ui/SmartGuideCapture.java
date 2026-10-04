package com.myscript.atk.p021ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.MotionEventCompat;

/* JADX INFO: loaded from: classes4.dex */
public class SmartGuideCapture extends FrameLayout {
    private boolean mDispatchPenDown;
    private boolean mDownDispatched;
    private View mEditingView;
    private float mMaxDiffX;
    private float mMaxDiffY;
    private Point mPenDown;
    private boolean mShouldDispatch;
    private SmartGuide mSmartGuide;

    public SmartGuideCapture(Context context) {
        super(context);
        this.mMaxDiffY = 0.0f;
        this.mMaxDiffX = 0.0f;
        this.mShouldDispatch = true;
        this.mDispatchPenDown = false;
        this.mDownDispatched = false;
    }

    public SmartGuideCapture(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxDiffY = 0.0f;
        this.mMaxDiffX = 0.0f;
        this.mShouldDispatch = true;
        this.mDispatchPenDown = false;
        this.mDownDispatched = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            penDown(motionEvent);
        } else if (actionMasked == 1) {
            penUp();
        } else if (actionMasked == 2) {
            penMove(motionEvent);
        }
        if (this.mShouldDispatch) {
            super.dispatchTouchEvent(motionEvent);
        } else {
            getGlobalVisibleRect(new Rect());
            this.mEditingView.getGlobalVisibleRect(new Rect());
            motionEvent.setLocation((r0.left - r3.left) + motionEvent.getX(), (r0.top - r3.top) + motionEvent.getY());
            if (this.mDispatchPenDown && !this.mDownDispatched) {
                motionEvent.setAction(0);
                this.mDispatchPenDown = false;
                this.mDownDispatched = true;
                this.mEditingView.onTouchEvent(motionEvent);
            }
            this.mEditingView.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 1) {
            this.mDownDispatched = false;
        }
        return true;
    }

    private boolean penDown(MotionEvent motionEvent) {
        this.mShouldDispatch = true;
        this.mPenDown = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        return false;
    }

    private boolean penMove(MotionEvent motionEvent) {
        getLocationOnScreen(new int[2]);
        float fAbs = Math.abs(this.mPenDown.x - motionEvent.getX());
        float fAbs2 = Math.abs(this.mPenDown.y - motionEvent.getY());
        this.mMaxDiffY = Math.max(fAbs2, this.mMaxDiffY);
        this.mMaxDiffX = Math.max(fAbs, this.mMaxDiffX);
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (((fAbs < 10.0f && fAbs2 > 10.0f && this.mMaxDiffX < 50.0f) || (fAbs > 10.0f && this.mMaxDiffX < 50.0f && fAbs2 > 10.0f)) && motionEvent.getToolType(action) == 2) {
            this.mDispatchPenDown = true;
            this.mShouldDispatch = false;
        }
        return false;
    }

    private boolean penUp() {
        this.mMaxDiffY = 0.0f;
        this.mMaxDiffX = 0.0f;
        return false;
    }

    public void setParentViews(SmartGuide smartGuide, View view) {
        this.mSmartGuide = smartGuide;
        this.mEditingView = view;
    }
}
