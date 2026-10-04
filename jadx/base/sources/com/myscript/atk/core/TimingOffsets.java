package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class TimingOffsets {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public TimingOffsets(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(TimingOffsets timingOffsets) {
        if (timingOffsets == null) {
            return 0L;
        }
        return timingOffsets.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_TimingOffsets(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setFromBegin(long j) {
        ATKCoreJNI.TimingOffsets_fromBegin_set(this.swigCPtr, this, j);
    }

    public long getFromBegin() {
        return ATKCoreJNI.TimingOffsets_fromBegin_get(this.swigCPtr, this);
    }

    public void setToEnd(long j) {
        ATKCoreJNI.TimingOffsets_toEnd_set(this.swigCPtr, this, j);
    }

    public long getToEnd() {
        return ATKCoreJNI.TimingOffsets_toEnd_get(this.swigCPtr, this);
    }

    public TimingOffsets() {
        this(ATKCoreJNI.new_TimingOffsets(), true);
    }
}
