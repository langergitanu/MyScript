package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class IntInterval {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public IntInterval(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(IntInterval intInterval) {
        if (intInterval == null) {
            return 0L;
        }
        return intInterval.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_IntInterval(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setBegin(int i) {
        ATKCoreJNI.IntInterval_begin_set(this.swigCPtr, this, i);
    }

    public int getBegin() {
        return ATKCoreJNI.IntInterval_begin_get(this.swigCPtr, this);
    }

    public void setEnd(int i) {
        ATKCoreJNI.IntInterval_end_set(this.swigCPtr, this, i);
    }

    public int getEnd() {
        return ATKCoreJNI.IntInterval_end_get(this.swigCPtr, this);
    }

    public IntInterval() {
        this(ATKCoreJNI.new_IntInterval__SWIG_0(), true);
    }

    public IntInterval(int i, int i2) {
        this(ATKCoreJNI.new_IntInterval__SWIG_1(i, i2), true);
    }
}
