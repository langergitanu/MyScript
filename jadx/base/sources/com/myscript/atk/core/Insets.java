package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class Insets {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Insets(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Insets insets) {
        if (insets == null) {
            return 0L;
        }
        return insets.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Insets(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setTop(float f) {
        ATKCoreJNI.Insets_top_set(this.swigCPtr, this, f);
    }

    public float getTop() {
        return ATKCoreJNI.Insets_top_get(this.swigCPtr, this);
    }

    public void setLeft(float f) {
        ATKCoreJNI.Insets_left_set(this.swigCPtr, this, f);
    }

    public float getLeft() {
        return ATKCoreJNI.Insets_left_get(this.swigCPtr, this);
    }

    public void setBottom(float f) {
        ATKCoreJNI.Insets_bottom_set(this.swigCPtr, this, f);
    }

    public float getBottom() {
        return ATKCoreJNI.Insets_bottom_get(this.swigCPtr, this);
    }

    public void setRight(float f) {
        ATKCoreJNI.Insets_right_set(this.swigCPtr, this, f);
    }

    public float getRight() {
        return ATKCoreJNI.Insets_right_get(this.swigCPtr, this);
    }

    public Insets() {
        this(ATKCoreJNI.new_Insets__SWIG_0(), true);
    }

    public Insets(float f, float f2, float f3, float f4) {
        this(ATKCoreJNI.new_Insets__SWIG_1(f, f2, f3, f4), true);
    }

    public Insets mapped(Transform transform) {
        return new Insets(ATKCoreJNI.Insets_mapped(this.swigCPtr, this, Transform.getCPtr(transform), transform), true);
    }
}
