package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class HorizontalLineSet {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public HorizontalLineSet(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(HorizontalLineSet horizontalLineSet) {
        if (horizontalLineSet == null) {
            return 0L;
        }
        return horizontalLineSet.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_HorizontalLineSet(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public float getY0() {
        return ATKCoreJNI.HorizontalLineSet_y0_get(this.swigCPtr, this);
    }

    public float getDy() {
        return ATKCoreJNI.HorizontalLineSet_dy_get(this.swigCPtr, this);
    }

    public int getCount() {
        return ATKCoreJNI.HorizontalLineSet_count_get(this.swigCPtr, this);
    }

    public int getFirst() {
        return ATKCoreJNI.HorizontalLineSet_first_get(this.swigCPtr, this);
    }

    public float getX1() {
        return ATKCoreJNI.HorizontalLineSet_x1_get(this.swigCPtr, this);
    }

    public float getX2() {
        return ATKCoreJNI.HorizontalLineSet_x2_get(this.swigCPtr, this);
    }

    public HorizontalLineSet(float f, float f2, int i, int i2, float f3, float f4) {
        this(ATKCoreJNI.new_HorizontalLineSet(f, f2, i, i2, f3, f4), true);
    }
}
