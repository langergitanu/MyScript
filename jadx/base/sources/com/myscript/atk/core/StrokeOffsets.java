package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class StrokeOffsets {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public StrokeOffsets(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(StrokeOffsets strokeOffsets) {
        if (strokeOffsets == null) {
            return 0L;
        }
        return strokeOffsets.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_StrokeOffsets(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setFromBegin(long j) {
        ATKCoreJNI.StrokeOffsets_fromBegin_set(this.swigCPtr, this, j);
    }

    public long getFromBegin() {
        return ATKCoreJNI.StrokeOffsets_fromBegin_get(this.swigCPtr, this);
    }

    public void setToEnd(long j) {
        ATKCoreJNI.StrokeOffsets_toEnd_set(this.swigCPtr, this, j);
    }

    public long getToEnd() {
        return ATKCoreJNI.StrokeOffsets_toEnd_get(this.swigCPtr, this);
    }

    public void setBeginInterpolation(float f) {
        ATKCoreJNI.StrokeOffsets_beginInterpolation_set(this.swigCPtr, this, f);
    }

    public float getBeginInterpolation() {
        return ATKCoreJNI.StrokeOffsets_beginInterpolation_get(this.swigCPtr, this);
    }

    public void setEndInterpolation(float f) {
        ATKCoreJNI.StrokeOffsets_endInterpolation_set(this.swigCPtr, this, f);
    }

    public float getEndInterpolation() {
        return ATKCoreJNI.StrokeOffsets_endInterpolation_get(this.swigCPtr, this);
    }

    public StrokeOffsets() {
        this(ATKCoreJNI.new_StrokeOffsets(), true);
    }
}
