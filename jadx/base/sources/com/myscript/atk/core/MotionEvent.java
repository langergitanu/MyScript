package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class MotionEvent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MotionEvent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0L;
        }
        return motionEvent.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_MotionEvent(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setX(double d) {
        ATKCoreJNI.MotionEvent_x_set(this.swigCPtr, this, d);
    }

    public double getX() {
        return ATKCoreJNI.MotionEvent_x_get(this.swigCPtr, this);
    }

    public void setY(double d) {
        ATKCoreJNI.MotionEvent_y_set(this.swigCPtr, this, d);
    }

    public double getY() {
        return ATKCoreJNI.MotionEvent_y_get(this.swigCPtr, this);
    }

    public void setT(long j) {
        ATKCoreJNI.MotionEvent_t_set(this.swigCPtr, this, j);
    }

    public long getT() {
        return ATKCoreJNI.MotionEvent_t_get(this.swigCPtr, this);
    }

    public MotionEvent() {
        this(ATKCoreJNI.new_MotionEvent(), true);
    }
}
