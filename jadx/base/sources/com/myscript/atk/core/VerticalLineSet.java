package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class VerticalLineSet {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public VerticalLineSet(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(VerticalLineSet verticalLineSet) {
        if (verticalLineSet == null) {
            return 0L;
        }
        return verticalLineSet.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_VerticalLineSet(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public float getX0() {
        return ATKCoreJNI.VerticalLineSet_x0_get(this.swigCPtr, this);
    }

    public float getDx() {
        return ATKCoreJNI.VerticalLineSet_dx_get(this.swigCPtr, this);
    }

    public int getCount() {
        return ATKCoreJNI.VerticalLineSet_count_get(this.swigCPtr, this);
    }

    public int getFirst() {
        return ATKCoreJNI.VerticalLineSet_first_get(this.swigCPtr, this);
    }

    public float getY1() {
        return ATKCoreJNI.VerticalLineSet_y1_get(this.swigCPtr, this);
    }

    public float getY2() {
        return ATKCoreJNI.VerticalLineSet_y2_get(this.swigCPtr, this);
    }

    public VerticalLineSet(float f, float f2, int i, int i2, float f3, float f4) {
        this(ATKCoreJNI.new_VerticalLineSet(f, f2, i, i2, f3, f4), true);
    }
}
