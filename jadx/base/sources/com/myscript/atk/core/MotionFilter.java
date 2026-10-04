package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class MotionFilter {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MotionFilter(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(MotionFilter motionFilter) {
        if (motionFilter == null) {
            return 0L;
        }
        return motionFilter.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_MotionFilter(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void reset() {
        ATKCoreJNI.MotionFilter_reset(this.swigCPtr, this);
    }

    public void update(double d, double d2) {
        ATKCoreJNI.MotionFilter_update(this.swigCPtr, this, d, d2);
    }

    public boolean isReady() {
        return ATKCoreJNI.MotionFilter_isReady(this.swigCPtr, this);
    }

    public long getIterations() {
        return ATKCoreJNI.MotionFilter_getIterations(this.swigCPtr, this);
    }

    public long getIterationDelta() {
        return ATKCoreJNI.MotionFilter_getIterationDelta(this.swigCPtr, this);
    }

    public DVector2 getLastPosition() {
        return new DVector2(ATKCoreJNI.MotionFilter_getLastPosition(this.swigCPtr, this), false);
    }

    public SWIGTYPE_p_std__dequeT_atk__core__DVector2_t getLastPositions() {
        return new SWIGTYPE_p_std__dequeT_atk__core__DVector2_t(ATKCoreJNI.MotionFilter_getLastPositions(this.swigCPtr, this), false);
    }

    public double getVelocity(double d) {
        return ATKCoreJNI.MotionFilter_getVelocity(this.swigCPtr, this, d);
    }

    public double getAcceleration(double d) {
        return ATKCoreJNI.MotionFilter_getAcceleration(this.swigCPtr, this, d);
    }

    public double getJank(double d, double d2) {
        return ATKCoreJNI.MotionFilter_getJank(this.swigCPtr, this, d, d2);
    }

    public double getCurvature(double d) {
        return ATKCoreJNI.MotionFilter_getCurvature(this.swigCPtr, this, d);
    }

    public double getContinuity(double d) {
        return ATKCoreJNI.MotionFilter_getContinuity(this.swigCPtr, this, d);
    }

    public DVector2 getPredictionVelocity(double d) {
        return new DVector2(ATKCoreJNI.MotionFilter_getPredictionVelocity(this.swigCPtr, this, d), true);
    }

    public MotionFilter() {
        this(ATKCoreJNI.new_MotionFilter(), true);
    }
}
