package com.myscript.atk.core;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SinglePointerPredictor {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SinglePointerPredictor(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SinglePointerPredictor singlePointerPredictor) {
        if (singlePointerPredictor == null) {
            return 0L;
        }
        return singlePointerPredictor.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_SinglePointerPredictor(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public SinglePointerPredictor() {
        this(ATKCoreJNI.new_SinglePointerPredictor(), true);
    }

    public void initStrokePrediction() {
        ATKCoreJNI.SinglePointerPredictor_initStrokePrediction(this.swigCPtr, this);
    }

    public void setWritingModeParams(double d, double d2, long j, long j2) {
        ATKCoreJNI.SinglePointerPredictor_setWritingModeParams(this.swigCPtr, this, d, d2, j, j2);
    }

    public long getPointerId() {
        return ATKCoreJNI.SinglePointerPredictor_getPointerId(this.swigCPtr, this);
    }

    public void setPointerId(long j) {
        ATKCoreJNI.SinglePointerPredictor_setPointerId(this.swigCPtr, this, j);
    }

    public long getNumIterations() {
        return ATKCoreJNI.SinglePointerPredictor_getNumIterations(this.swigCPtr, this);
    }

    public void update(double d, double d2, long j) {
        ATKCoreJNI.SinglePointerPredictor_update(this.swigCPtr, this, d, d2, j);
    }

    public void setReportRate(long j) {
        ATKCoreJNI.SinglePointerPredictor_setReportRate(this.swigCPtr, this, j);
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        ATKCoreJNI.SinglePointerPredictor_onTouchEvent(this.swigCPtr, this, MotionEvent.getCPtr(motionEvent), motionEvent);
    }

    public List<MotionEvent> predict(long j) {
        return new SWIGVectorMotionEvent(ATKCoreJNI.SinglePointerPredictor_predict(this.swigCPtr, this, j), true);
    }
}
