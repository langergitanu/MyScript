package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class DVector2 {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DVector2(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DVector2 dVector2) {
        if (dVector2 == null) {
            return 0L;
        }
        return dVector2.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_DVector2(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setX(double d) {
        ATKCoreJNI.DVector2_x_set(this.swigCPtr, this, d);
    }

    public double getX() {
        return ATKCoreJNI.DVector2_x_get(this.swigCPtr, this);
    }

    public void setY(double d) {
        ATKCoreJNI.DVector2_y_set(this.swigCPtr, this, d);
    }

    public double getY() {
        return ATKCoreJNI.DVector2_y_get(this.swigCPtr, this);
    }

    public DVector2() {
        this(ATKCoreJNI.new_DVector2__SWIG_0(), true);
    }

    public DVector2(double d, double d2) {
        this(ATKCoreJNI.new_DVector2__SWIG_1(d, d2), true);
    }

    public double magnitude() {
        return ATKCoreJNI.DVector2_magnitude(this.swigCPtr, this);
    }

    public void set(double d, double d2) {
        ATKCoreJNI.DVector2_set__SWIG_0(this.swigCPtr, this, d, d2);
    }

    public void set(DVector2 dVector2) {
        ATKCoreJNI.DVector2_set__SWIG_1(this.swigCPtr, this, getCPtr(dVector2), dVector2);
    }
}
