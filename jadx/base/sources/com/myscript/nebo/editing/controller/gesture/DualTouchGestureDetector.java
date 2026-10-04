package com.myscript.nebo.editing.controller.gesture;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes7.dex */
public class DualTouchGestureDetector {
    private static final int DOUBLE_TAP_MIN_TIME = 40;
    private static final int DUAL_TOUCH_CANCELED_MSG = 3;
    private static final int DUAL_TOUCH_LONG_PRESS_MSG = 1;
    private static final int DUAL_TOUCH_TAP_MSG = 2;
    private static final int PIXEL_PER_MILLISECONDS = 1000;
    protected static final int SECOND_TOUCH_TIMEOUT = 200;
    private boolean mAlwaysInTapRegion;
    private final PointerInfo mCurrentPointer;
    private boolean mDeferConfirmDualTouch;
    private boolean mDeferConfirmDualTouchSingleTap;
    private final int mDoubleTapSlopSquare;
    private final PointerInfo mDownPointer;
    private MotionEvent mDualTouchDownEvent;
    private MotionEvent mDualTouchUpEvent;
    private long mFirstDownEventTime;
    private final GestureHandler mHandler;
    private boolean mInDualTouchLongPress;
    private boolean mIsDualTouchDoubleTapping;
    private MotionEvent mIsDualTouchDoubleTappingEvent;
    private final OnDualTouchGestureListener mListener;
    private final int mMaximumFlingVelocity;
    private final int mMinimumFlingVelocity;
    private final PointerInfo mPreviousPointer;
    private boolean mStillDualTouchDown;
    private final PointerInfo mTempoFirstDownPointer;
    private final PointerInfo mTempoSecondDownPointer;
    private final int mTouchSlopSquare;
    private VelocityTracker mVelocityTracker;
    private static final int LONG_PRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();

    public interface OnDualTouchGestureListener {
        boolean onDualTouchDoubleTapEnd(MotionEvent motionEvent);

        boolean onDualTouchDoubleTapMove(MotionEvent motionEvent);

        boolean onDualTouchDoubleTapStart(MotionEvent motionEvent);

        boolean onDualTouchDown(MotionEvent motionEvent);

        boolean onDualTouchFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        boolean onDualTouchLongPressEnd(MotionEvent motionEvent);

        boolean onDualTouchLongPressMove(MotionEvent motionEvent);

        void onDualTouchLongPressStart(MotionEvent motionEvent);

        boolean onDualTouchScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        void onDualTouchSingleTapConfirmed(MotionEvent motionEvent);

        boolean onDualTouchSingleTapUp(MotionEvent motionEvent);
    }

    public static class SimpleDualTouchGestureListener implements OnDualTouchGestureListener {
        @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
        public boolean onDualTouchDoubleTapEnd(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
        public boolean onDualTouchDoubleTapMove(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
        public boolean onDualTouchDoubleTapStart(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
        public boolean onDualTouchDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
        public boolean onDualTouchFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
        public boolean onDualTouchLongPressEnd(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
        public boolean onDualTouchLongPressMove(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
        public void onDualTouchLongPressStart(MotionEvent motionEvent) {
        }

        @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
        public boolean onDualTouchScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
        public void onDualTouchSingleTapConfirmed(MotionEvent motionEvent) {
        }

        @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
        public boolean onDualTouchSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    private class GestureHandler extends Handler {
        GestureHandler() {
        }

        GestureHandler(Handler handler) {
            super(handler.getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                DualTouchGestureDetector.this.dispatchDualTouchLongPress();
                return;
            }
            if (i != 2) {
                if (i == 3) {
                    DualTouchGestureDetector.this.cancelDualTouch();
                    return;
                }
                throw new RuntimeException("Unknown message" + message);
            }
            if (!DualTouchGestureDetector.this.mStillDualTouchDown && !DualTouchGestureDetector.this.mDeferConfirmDualTouch) {
                DualTouchGestureDetector.this.mListener.onDualTouchSingleTapConfirmed(DualTouchGestureDetector.this.mDualTouchDownEvent);
            } else {
                DualTouchGestureDetector.this.mDeferConfirmDualTouchSingleTap = true;
            }
        }
    }

    private static class PointerInfo {
        float centerX;
        float centerY;
        float deltaX;
        float deltaY;
        float pressure;

        /* JADX INFO: renamed from: x0 */
        float f1367x0;

        /* JADX INFO: renamed from: x1 */
        float f1368x1;

        /* JADX INFO: renamed from: y0 */
        float f1369y0;

        /* JADX INFO: renamed from: y1 */
        float f1370y1;

        private PointerInfo() {
        }
    }

    public DualTouchGestureDetector(Context context, OnDualTouchGestureListener onDualTouchGestureListener) {
        this(context, onDualTouchGestureListener, null);
    }

    public DualTouchGestureDetector(Context context, OnDualTouchGestureListener onDualTouchGestureListener, Handler handler) {
        this.mDownPointer = new PointerInfo();
        this.mCurrentPointer = new PointerInfo();
        this.mPreviousPointer = new PointerInfo();
        this.mTempoFirstDownPointer = new PointerInfo();
        this.mTempoSecondDownPointer = new PointerInfo();
        if (handler != null) {
            this.mHandler = new GestureHandler(handler);
        } else {
            this.mHandler = new GestureHandler();
        }
        this.mListener = onDualTouchGestureListener;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
        this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
        this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
        this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnDualTouchFling;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        boolean zOnDualTouchDoubleTapStart = false;
        if (actionMasked == 0) {
            this.mFirstDownEventTime = motionEvent.getDownTime();
            if (this.mStillDualTouchDown) {
                resetState();
            }
        } else {
            if (actionMasked == 1) {
                if (this.mDeferConfirmDualTouch) {
                    this.mHandler.removeMessages(3);
                    if (this.mInDualTouchLongPress) {
                        this.mHandler.removeMessages(2);
                        this.mInDualTouchLongPress = false;
                        zOnDualTouchFling = this.mListener.onDualTouchLongPressEnd(motionEvent);
                    } else if (this.mIsDualTouchDoubleTapping) {
                        zOnDualTouchFling = this.mListener.onDualTouchDoubleTapEnd(this.mIsDualTouchDoubleTappingEvent);
                    } else if (this.mAlwaysInTapRegion) {
                        zOnDualTouchFling = this.mListener.onDualTouchSingleTapUp(motionEvent);
                        if (this.mDeferConfirmDualTouchSingleTap) {
                            this.mListener.onDualTouchSingleTapConfirmed(motionEvent);
                        }
                    } else {
                        int pointerId = motionEvent.getPointerId(0);
                        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                        float xVelocity = this.mVelocityTracker.getXVelocity(pointerId);
                        float yVelocity = this.mVelocityTracker.getYVelocity(pointerId);
                        zOnDualTouchFling = (Math.abs(xVelocity) > ((float) this.mMinimumFlingVelocity) || Math.abs(yVelocity) > ((float) this.mMinimumFlingVelocity)) ? this.mListener.onDualTouchFling(this.mDualTouchDownEvent, motionEvent, xVelocity, yVelocity) : false;
                    }
                    MotionEvent motionEvent3 = this.mDualTouchUpEvent;
                    if (motionEvent3 != null) {
                        motionEvent3.recycle();
                    }
                    this.mDualTouchUpEvent = MotionEvent.obtain(motionEvent);
                } else {
                    zOnDualTouchFling = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.mVelocityTracker = null;
                }
                this.mDeferConfirmDualTouch = false;
                this.mDeferConfirmDualTouchSingleTap = false;
                this.mIsDualTouchDoubleTapping = false;
                this.mIsDualTouchDoubleTappingEvent = null;
                return zOnDualTouchFling;
            }
            if (actionMasked == 2) {
                if (this.mStillDualTouchDown) {
                    if (motionEvent.getPointerCount() < 2) {
                        resetState();
                        return false;
                    }
                    updatePointerInfo(this.mCurrentPointer, motionEvent);
                    if (this.mInDualTouchLongPress) {
                        return this.mListener.onDualTouchLongPressMove(motionEvent);
                    }
                    if (this.mIsDualTouchDoubleTapping) {
                        return this.mListener.onDualTouchDoubleTapMove(motionEvent);
                    }
                    if (this.mAlwaysInTapRegion) {
                        if (isInSameSpot(this.mDownPointer, this.mCurrentPointer, this.mTouchSlopSquare)) {
                            return true;
                        }
                        boolean zHandleDualTouchMove = handleDualTouchMove(this.mDualTouchDownEvent, motionEvent, true);
                        this.mAlwaysInTapRegion = false;
                        this.mHandler.removeMessages(2);
                        this.mHandler.removeMessages(1);
                        return zHandleDualTouchMove;
                    }
                    return handleDualTouchMove(this.mDualTouchDownEvent, motionEvent, false);
                }
            } else {
                if (actionMasked == 3) {
                    cancelDualTouch();
                    return false;
                }
                if (actionMasked == 5) {
                    if (!this.mStillDualTouchDown && motionEvent.getEventTime() - this.mFirstDownEventTime < 200) {
                        resetState();
                        this.mStillDualTouchDown = true;
                        this.mAlwaysInTapRegion = true;
                        boolean zHasMessages = this.mHandler.hasMessages(2);
                        if (zHasMessages) {
                            this.mHandler.removeMessages(2);
                        }
                        MotionEvent motionEvent4 = this.mDualTouchDownEvent;
                        if (motionEvent4 != null && (motionEvent2 = this.mDualTouchUpEvent) != null && zHasMessages && isConsideredDoubleTap(motionEvent4, motionEvent2, motionEvent)) {
                            this.mIsDualTouchDoubleTapping = true;
                            MotionEvent motionEvent5 = this.mIsDualTouchDoubleTappingEvent;
                            if (motionEvent5 != null) {
                                motionEvent5.recycle();
                            }
                            this.mIsDualTouchDoubleTappingEvent = MotionEvent.obtain(motionEvent);
                            zOnDualTouchDoubleTapStart = this.mListener.onDualTouchDoubleTapStart(this.mDualTouchDownEvent);
                        } else {
                            this.mHandler.sendEmptyMessageDelayed(2, DOUBLE_TAP_TIMEOUT);
                        }
                        updatePointerInfo(this.mCurrentPointer, motionEvent);
                        storePointerInfo(this.mPreviousPointer, this.mCurrentPointer);
                        storePointerInfo(this.mDownPointer, this.mCurrentPointer);
                        MotionEvent motionEvent6 = this.mDualTouchDownEvent;
                        if (motionEvent6 != null) {
                            motionEvent6.recycle();
                        }
                        this.mDualTouchDownEvent = MotionEvent.obtain(motionEvent);
                        if (this.mIsDualTouchDoubleTapping) {
                            return zOnDualTouchDoubleTapStart;
                        }
                        this.mHandler.removeMessages(1);
                        this.mHandler.sendEmptyMessageAtTime(1, this.mDualTouchDownEvent.getDownTime() + ((long) LONG_PRESS_TIMEOUT));
                        return this.mListener.onDualTouchDown(motionEvent) | zOnDualTouchDoubleTapStart;
                    }
                    cancelDualTouch();
                    return false;
                }
                if (actionMasked == 6 && this.mStillDualTouchDown) {
                    this.mStillDualTouchDown = false;
                    this.mDeferConfirmDualTouch = true;
                    this.mHandler.removeMessages(1);
                    this.mHandler.sendEmptyMessageAtTime(3, motionEvent.getEventTime() + 200);
                    updatePointerInfo(this.mCurrentPointer, motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(actionIndex);
                    float xVelocity2 = this.mVelocityTracker.getXVelocity(pointerId2);
                    float yVelocity2 = this.mVelocityTracker.getYVelocity(pointerId2);
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i = 0; i < pointerCount; i++) {
                        if (i != actionIndex) {
                            int pointerId3 = motionEvent.getPointerId(i);
                            if ((this.mVelocityTracker.getXVelocity(pointerId3) * xVelocity2) + (this.mVelocityTracker.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                                this.mVelocityTracker.clear();
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private static void updatePointerInfo(PointerInfo pointerInfo, MotionEvent motionEvent) {
        float x = motionEvent.getX(0);
        float y = motionEvent.getY(0);
        float x2 = motionEvent.getX(1);
        float y2 = motionEvent.getY(1);
        float pressure = motionEvent.getPressure(motionEvent.getActionIndex());
        pointerInfo.f1367x0 = x;
        pointerInfo.f1368x1 = x2;
        pointerInfo.f1369y0 = y;
        pointerInfo.f1370y1 = y2;
        pointerInfo.centerX = (x + x2) / 2.0f;
        pointerInfo.centerY = (y + y2) / 2.0f;
        pointerInfo.deltaX = x2 - x;
        pointerInfo.deltaY = y2 - y;
        pointerInfo.pressure = pressure;
    }

    private static void storePointerInfo(PointerInfo pointerInfo, PointerInfo pointerInfo2) {
        pointerInfo.f1367x0 = pointerInfo2.f1367x0;
        pointerInfo.f1368x1 = pointerInfo2.f1368x1;
        pointerInfo.f1369y0 = pointerInfo2.f1369y0;
        pointerInfo.f1370y1 = pointerInfo2.f1370y1;
        pointerInfo.centerX = pointerInfo2.centerX;
        pointerInfo.centerY = pointerInfo2.centerY;
        pointerInfo.deltaX = pointerInfo2.deltaX;
        pointerInfo.deltaY = pointerInfo2.deltaY;
        pointerInfo.pressure = pointerInfo2.pressure;
    }

    private boolean handleDualTouchMove(MotionEvent motionEvent, MotionEvent motionEvent2, boolean z) {
        float f = this.mPreviousPointer.centerX - this.mCurrentPointer.centerX;
        float f2 = this.mPreviousPointer.centerY - this.mCurrentPointer.centerY;
        if (!z && Math.abs(f) < 1.0f && Math.abs(f2) < 1.0f) {
            return true;
        }
        boolean zOnDualTouchScroll = this.mListener.onDualTouchScroll(motionEvent, motionEvent2, f, f2);
        storePointerInfo(this.mPreviousPointer, this.mCurrentPointer);
        return zOnDualTouchScroll;
    }

    private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        long eventTime = motionEvent3.getEventTime() - motionEvent2.getEventTime();
        if (eventTime > DOUBLE_TAP_TIMEOUT || eventTime < 40 || motionEvent.getPointerCount() != motionEvent3.getPointerCount()) {
            return false;
        }
        updatePointerInfo(this.mTempoFirstDownPointer, motionEvent);
        updatePointerInfo(this.mTempoSecondDownPointer, motionEvent3);
        return isInSameSpot(this.mTempoFirstDownPointer, this.mTempoSecondDownPointer, this.mDoubleTapSlopSquare);
    }

    private static boolean isInSameSpot(PointerInfo pointerInfo, PointerInfo pointerInfo2, int i) {
        int i2 = (int) (pointerInfo2.centerX - pointerInfo.centerX);
        int i3 = (int) (pointerInfo2.centerY - pointerInfo.centerY);
        int i4 = (i2 * i2) + (i3 * i3);
        int iAbs = (int) (Math.abs(pointerInfo2.deltaX) - Math.abs(pointerInfo.deltaX));
        int iAbs2 = (int) (Math.abs(pointerInfo2.deltaY) - Math.abs(pointerInfo.deltaY));
        return i4 <= i && ((iAbs * iAbs) + (iAbs2 * iAbs2)) * 2 <= i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchDualTouchLongPress() {
        this.mHandler.removeMessages(2);
        this.mDeferConfirmDualTouchSingleTap = false;
        this.mInDualTouchLongPress = true;
        this.mListener.onDualTouchLongPressStart(this.mDualTouchDownEvent);
    }

    private void resetState() {
        this.mStillDualTouchDown = false;
        this.mDeferConfirmDualTouch = false;
        this.mDeferConfirmDualTouchSingleTap = false;
        this.mIsDualTouchDoubleTapping = false;
        this.mIsDualTouchDoubleTappingEvent = null;
        if (this.mInDualTouchLongPress) {
            this.mInDualTouchLongPress = false;
            this.mListener.onDualTouchLongPressEnd(null);
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelDualTouch() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        resetState();
    }
}
