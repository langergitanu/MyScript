package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class GlyphSlices {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GlyphSlices(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(GlyphSlices glyphSlices) {
        if (glyphSlices == null) {
            return 0L;
        }
        return glyphSlices.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_GlyphSlices(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setLeft(float f) {
        ATKCoreJNI.GlyphSlices_left_set(this.swigCPtr, this, f);
    }

    public float getLeft() {
        return ATKCoreJNI.GlyphSlices_left_get(this.swigCPtr, this);
    }

    public void setRight(float f) {
        ATKCoreJNI.GlyphSlices_right_set(this.swigCPtr, this, f);
    }

    public float getRight() {
        return ATKCoreJNI.GlyphSlices_right_get(this.swigCPtr, this);
    }

    public void setTop(float f) {
        ATKCoreJNI.GlyphSlices_top_set(this.swigCPtr, this, f);
    }

    public float getTop() {
        return ATKCoreJNI.GlyphSlices_top_get(this.swigCPtr, this);
    }

    public void setBottom(float f) {
        ATKCoreJNI.GlyphSlices_bottom_set(this.swigCPtr, this, f);
    }

    public float getBottom() {
        return ATKCoreJNI.GlyphSlices_bottom_get(this.swigCPtr, this);
    }

    public GlyphSlices() {
        this(ATKCoreJNI.new_GlyphSlices(), true);
    }
}
