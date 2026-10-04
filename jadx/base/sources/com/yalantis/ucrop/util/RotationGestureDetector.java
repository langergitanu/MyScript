package com.yalantis.ucrop.util;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes8.dex */
public class RotationGestureDetector {
    private static final int INVALID_POINTER_INDEX = -1;

    /* JADX INFO: renamed from: fX */
    private float f2302fX;

    /* JADX INFO: renamed from: fY */
    private float f2303fY;
    private float mAngle;
    private boolean mIsFirstTouch;
    private OnRotationGestureListener mListener;
    private int mPointerIndex1 = -1;
    private int mPointerIndex2 = -1;

    /* JADX INFO: renamed from: sX */
    private float f2304sX;

    /* JADX INFO: renamed from: sY */
    private float f2305sY;

    public interface OnRotationGestureListener {
        boolean onRotation(RotationGestureDetector rotationGestureDetector);
    }

    public static class SimpleOnRotationGestureListener implements OnRotationGestureListener {
        @Override // com.yalantis.ucrop.util.RotationGestureDetector.OnRotationGestureListener
        public boolean onRotation(RotationGestureDetector rotationGestureDetector) {
            return false;
        }
    }

    public RotationGestureDetector(OnRotationGestureListener onRotationGestureListener) {
        this.mListener = onRotationGestureListener;
    }

    public float getAngle() {
        return this.mAngle;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        RotationGestureDetector rotationGestureDetector;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2304sX = motionEvent.getX();
            this.f2305sY = motionEvent.getY();
            this.mPointerIndex1 = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
            this.mAngle = 0.0f;
            this.mIsFirstTouch = true;
        } else if (actionMasked == 1) {
            this.mPointerIndex1 = -1;
        } else if (actionMasked != 2) {
            if (actionMasked == 5) {
                this.f2302fX = motionEvent.getX();
                this.f2303fY = motionEvent.getY();
                this.mPointerIndex2 = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                this.mAngle = 0.0f;
                this.mIsFirstTouch = true;
            } else if (actionMasked == 6) {
                this.mPointerIndex2 = -1;
            }
        } else if (this.mPointerIndex1 != -1 && this.mPointerIndex2 != -1 && motionEvent.getPointerCount() > this.mPointerIndex2) {
            float x = motionEvent.getX(this.mPointerIndex1);
            float y = motionEvent.getY(this.mPointerIndex1);
            float x2 = motionEvent.getX(this.mPointerIndex2);
            float y2 = motionEvent.getY(this.mPointerIndex2);
            if (this.mIsFirstTouch) {
                this.mAngle = 0.0f;
                this.mIsFirstTouch = false;
                rotationGestureDetector = this;
            } else {
                calculateAngleBetweenLines(this.f2302fX, this.f2303fY, this.f2304sX, this.f2305sY, x2, y2, x, y);
                rotationGestureDetector = this;
            }
            OnRotationGestureListener onRotationGestureListener = rotationGestureDetector.mListener;
            if (onRotationGestureListener != null) {
                onRotationGestureListener.onRotation(this);
            }
            rotationGestureDetector.f2302fX = x2;
            rotationGestureDetector.f2303fY = y2;
            rotationGestureDetector.f2304sX = x;
            rotationGestureDetector.f2305sY = y;
        }
        return true;
    }

    private float calculateAngleBetweenLines(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return calculateAngleDelta((float) Math.toDegrees((float) Math.atan2(f2 - f4, f - f3)), (float) Math.toDegrees((float) Math.atan2(f6 - f8, f5 - f7)));
    }

    private float calculateAngleDelta(float f, float f2) {
        float f3 = (f2 % 360.0f) - (f % 360.0f);
        this.mAngle = f3;
        if (f3 < -180.0f) {
            this.mAngle = f3 + 360.0f;
        } else if (f3 > 180.0f) {
            this.mAngle = f3 - 360.0f;
        }
        return this.mAngle;
    }
}
