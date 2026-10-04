package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class SemiAxis {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SemiAxis(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SemiAxis semiAxis) {
        if (semiAxis == null) {
            return 0L;
        }
        return semiAxis.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_SemiAxis(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public SemiAxis() {
        this(ATKCoreJNI.new_SemiAxis__SWIG_0(), true);
    }

    public SemiAxis(Axis axis, float f, boolean z) {
        this(ATKCoreJNI.new_SemiAxis__SWIG_1(axis.swigValue(), f, z), true);
    }

    public void setAxis(Axis axis) {
        ATKCoreJNI.SemiAxis_axis_set(this.swigCPtr, this, axis.swigValue());
    }

    public Axis getAxis() {
        return Axis.swigToEnum(ATKCoreJNI.SemiAxis_axis_get(this.swigCPtr, this));
    }

    public void setBound(float f) {
        ATKCoreJNI.SemiAxis_bound_set(this.swigCPtr, this, f);
    }

    public float getBound() {
        return ATKCoreJNI.SemiAxis_bound_get(this.swigCPtr, this);
    }

    public void setBeforeBound(boolean z) {
        ATKCoreJNI.SemiAxis_beforeBound_set(this.swigCPtr, this, z);
    }

    public boolean getBeforeBound() {
        return ATKCoreJNI.SemiAxis_beforeBound_get(this.swigCPtr, this);
    }

    public boolean isUndefined() {
        return ATKCoreJNI.SemiAxis_isUndefined(this.swigCPtr, this);
    }

    public boolean isDefined() {
        return ATKCoreJNI.SemiAxis_isDefined(this.swigCPtr, this);
    }
}
