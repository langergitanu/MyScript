package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class MotionPredictionParams {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MotionPredictionParams(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(MotionPredictionParams motionPredictionParams) {
        if (motionPredictionParams == null) {
            return 0L;
        }
        return motionPredictionParams.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_MotionPredictionParams(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setEnabled(boolean z) {
        ATKCoreJNI.MotionPredictionParams_enabled_set(this.swigCPtr, this, z);
    }

    public boolean getEnabled() {
        return ATKCoreJNI.MotionPredictionParams_enabled_get(this.swigCPtr, this);
    }

    public void setShowPredictionInRed(boolean z) {
        ATKCoreJNI.MotionPredictionParams_showPredictionInRed_set(this.swigCPtr, this, z);
    }

    public boolean getShowPredictionInRed() {
        return ATKCoreJNI.MotionPredictionParams_showPredictionInRed_get(this.swigCPtr, this);
    }

    public void setDurationMs(long j) {
        ATKCoreJNI.MotionPredictionParams_durationMs_set(this.swigCPtr, this, j);
    }

    public long getDurationMs() {
        return ATKCoreJNI.MotionPredictionParams_durationMs_get(this.swigCPtr, this);
    }

    public void setWritingModeFactor(double d) {
        ATKCoreJNI.MotionPredictionParams_writingModeFactor_set(this.swigCPtr, this, d);
    }

    public double getWritingModeFactor() {
        return ATKCoreJNI.MotionPredictionParams_writingModeFactor_get(this.swigCPtr, this);
    }

    public void setWritingModeLength(double d) {
        ATKCoreJNI.MotionPredictionParams_writingModeLength_set(this.swigCPtr, this, d);
    }

    public double getWritingModeLength() {
        return ATKCoreJNI.MotionPredictionParams_writingModeLength_get(this.swigCPtr, this);
    }

    public void setWritingModeMinCount(long j) {
        ATKCoreJNI.MotionPredictionParams_writingModeMinCount_set(this.swigCPtr, this, j);
    }

    public long getWritingModeMinCount() {
        return ATKCoreJNI.MotionPredictionParams_writingModeMinCount_get(this.swigCPtr, this);
    }

    public void setWritingModeMaxCount(long j) {
        ATKCoreJNI.MotionPredictionParams_writingModeMaxCount_set(this.swigCPtr, this, j);
    }

    public long getWritingModeMaxCount() {
        return ATKCoreJNI.MotionPredictionParams_writingModeMaxCount_get(this.swigCPtr, this);
    }

    public MotionPredictionParams() {
        this(ATKCoreJNI.new_MotionPredictionParams(), true);
    }
}
