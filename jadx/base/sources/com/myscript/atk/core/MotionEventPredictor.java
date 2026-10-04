package com.myscript.atk.core;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MotionEventPredictor {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MotionEventPredictor(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(MotionEventPredictor motionEventPredictor) {
        if (motionEventPredictor == null) {
            return 0L;
        }
        return motionEventPredictor.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_MotionEventPredictor(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setWritingModeParams(double d, double d2, long j, long j2) {
        ATKCoreJNI.MotionEventPredictor_setWritingModeParams(this.swigCPtr, this, d, d2, j, j2);
    }

    public long getPointerId() {
        return ATKCoreJNI.MotionEventPredictor_getPointerId(this.swigCPtr, this);
    }

    public void setPointerId(long j) {
        ATKCoreJNI.MotionEventPredictor_setPointerId(this.swigCPtr, this, j);
    }

    public long getNumIterations() {
        return ATKCoreJNI.MotionEventPredictor_getNumIterations(this.swigCPtr, this);
    }

    public void reset() {
        ATKCoreJNI.MotionEventPredictor_reset(this.swigCPtr, this);
    }

    public void record(MotionEvent motionEvent) {
        ATKCoreJNI.MotionEventPredictor_record(this.swigCPtr, this, MotionEvent.getCPtr(motionEvent), motionEvent);
    }

    public List<MotionEvent> predict(long j) {
        return new SWIGVectorMotionEvent(ATKCoreJNI.MotionEventPredictor_predict(this.swigCPtr, this, j), true);
    }

    public MotionEventPredictor() {
        this(ATKCoreJNI.new_MotionEventPredictor(), true);
    }
}
