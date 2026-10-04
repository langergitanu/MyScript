package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class GlyphLines {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GlyphLines(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(GlyphLines glyphLines) {
        if (glyphLines == null) {
            return 0L;
        }
        return glyphLines.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_GlyphLines(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setBaseline(float f) {
        ATKCoreJNI.GlyphLines_baseline_set(this.swigCPtr, this, f);
    }

    public float getBaseline() {
        return ATKCoreJNI.GlyphLines_baseline_get(this.swigCPtr, this);
    }

    public void setX_height(float f) {
        ATKCoreJNI.GlyphLines_x_height_set(this.swigCPtr, this, f);
    }

    public float getX_height() {
        return ATKCoreJNI.GlyphLines_x_height_get(this.swigCPtr, this);
    }

    public GlyphLines() {
        this(ATKCoreJNI.new_GlyphLines(), true);
    }
}
