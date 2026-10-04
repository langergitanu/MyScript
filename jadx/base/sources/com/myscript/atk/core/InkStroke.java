package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class InkStroke {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public InkStroke(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(InkStroke inkStroke) {
        if (inkStroke == null) {
            return 0L;
        }
        return inkStroke.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_InkStroke(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public long getTimestamp() {
        return ATKCoreJNI.InkStroke_getTimestamp(this.swigCPtr, this);
    }

    public boolean isFirstPointIncluded() {
        return ATKCoreJNI.InkStroke_isFirstPointIncluded(this.swigCPtr, this);
    }

    public boolean isLastPointIncluded() {
        return ATKCoreJNI.InkStroke_isLastPointIncluded(this.swigCPtr, this);
    }

    public boolean isFirstPointPenDown() {
        return ATKCoreJNI.InkStroke_isFirstPointPenDown(this.swigCPtr, this);
    }

    public boolean isLastPointPenUp() {
        return ATKCoreJNI.InkStroke_isLastPointPenUp(this.swigCPtr, this);
    }

    public int getSampleCount() {
        return ATKCoreJNI.InkStroke_getSampleCount(this.swigCPtr, this);
    }

    public boolean isPointArrayCompatible() {
        return ATKCoreJNI.InkStroke_isPointArrayCompatible(this.swigCPtr, this);
    }

    public Point getPointArray() {
        return new Point(ATKCoreJNI.InkStroke_getPointArray(this.swigCPtr, this), true);
    }

    public boolean isFloatArrayCompatible(int i) {
        return ATKCoreJNI.InkStroke_isFloatArrayCompatible(this.swigCPtr, this, i);
    }

    public boolean isInt32ArrayCompatible(int i) {
        return ATKCoreJNI.InkStroke_isInt32ArrayCompatible(this.swigCPtr, this, i);
    }

    public boolean isInt64ArrayCompatible(int i) {
        return ATKCoreJNI.InkStroke_isInt64ArrayCompatible(this.swigCPtr, this, i);
    }

    public InkStroke(InkStroke inkStroke) {
        this(ATKCoreJNI.new_InkStroke__SWIG_0(getCPtr(inkStroke), inkStroke), true);
    }

    public Path getPath() {
        return new Path(ATKCoreJNI.InkStroke_getPath(this.swigCPtr, this), true);
    }
}
