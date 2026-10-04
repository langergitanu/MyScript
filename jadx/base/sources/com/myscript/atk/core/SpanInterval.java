package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class SpanInterval {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SpanInterval(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SpanInterval spanInterval) {
        if (spanInterval == null) {
            return 0L;
        }
        return spanInterval.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_SpanInterval(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public SpanInterval(int i, int i2) {
        this(ATKCoreJNI.new_SpanInterval(i, i2), true);
    }

    public void setBeginCharPosition(int i) {
        ATKCoreJNI.SpanInterval_beginCharPosition_set(this.swigCPtr, this, i);
    }

    public int getBeginCharPosition() {
        return ATKCoreJNI.SpanInterval_beginCharPosition_get(this.swigCPtr, this);
    }

    public void setEndCharPosition(int i) {
        ATKCoreJNI.SpanInterval_endCharPosition_set(this.swigCPtr, this, i);
    }

    public int getEndCharPosition() {
        return ATKCoreJNI.SpanInterval_endCharPosition_get(this.swigCPtr, this);
    }
}
