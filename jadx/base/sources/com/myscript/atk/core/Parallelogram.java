package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class Parallelogram {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Parallelogram(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Parallelogram parallelogram) {
        if (parallelogram == null) {
            return 0L;
        }
        return parallelogram.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Parallelogram(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setX(float f) {
        ATKCoreJNI.Parallelogram_x_set(this.swigCPtr, this, f);
    }

    public float getX() {
        return ATKCoreJNI.Parallelogram_x_get(this.swigCPtr, this);
    }

    public void setY(float f) {
        ATKCoreJNI.Parallelogram_y_set(this.swigCPtr, this, f);
    }

    public float getY() {
        return ATKCoreJNI.Parallelogram_y_get(this.swigCPtr, this);
    }

    public void setUx(float f) {
        ATKCoreJNI.Parallelogram_ux_set(this.swigCPtr, this, f);
    }

    public float getUx() {
        return ATKCoreJNI.Parallelogram_ux_get(this.swigCPtr, this);
    }

    public void setUy(float f) {
        ATKCoreJNI.Parallelogram_uy_set(this.swigCPtr, this, f);
    }

    public float getUy() {
        return ATKCoreJNI.Parallelogram_uy_get(this.swigCPtr, this);
    }

    public void setVx(float f) {
        ATKCoreJNI.Parallelogram_vx_set(this.swigCPtr, this, f);
    }

    public float getVx() {
        return ATKCoreJNI.Parallelogram_vx_get(this.swigCPtr, this);
    }

    public void setVy(float f) {
        ATKCoreJNI.Parallelogram_vy_set(this.swigCPtr, this, f);
    }

    public float getVy() {
        return ATKCoreJNI.Parallelogram_vy_get(this.swigCPtr, this);
    }

    public Parallelogram() {
        this(ATKCoreJNI.new_Parallelogram(), true);
    }
}
