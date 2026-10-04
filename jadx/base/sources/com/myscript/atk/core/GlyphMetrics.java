package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class GlyphMetrics {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GlyphMetrics(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(GlyphMetrics glyphMetrics) {
        if (glyphMetrics == null) {
            return 0L;
        }
        return glyphMetrics.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_GlyphMetrics(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setBoundingBox(Rectangle rectangle) {
        ATKCoreJNI.GlyphMetrics_boundingBox_set(this.swigCPtr, this, Rectangle.getCPtr(rectangle), rectangle);
    }

    public Rectangle getBoundingBox() {
        long jGlyphMetrics_boundingBox_get = ATKCoreJNI.GlyphMetrics_boundingBox_get(this.swigCPtr, this);
        if (jGlyphMetrics_boundingBox_get == 0) {
            return null;
        }
        return new Rectangle(jGlyphMetrics_boundingBox_get, false);
    }

    public void setLeftSideBearing(float f) {
        ATKCoreJNI.GlyphMetrics_leftSideBearing_set(this.swigCPtr, this, f);
    }

    public float getLeftSideBearing() {
        return ATKCoreJNI.GlyphMetrics_leftSideBearing_get(this.swigCPtr, this);
    }

    public void setRightSideBearing(float f) {
        ATKCoreJNI.GlyphMetrics_rightSideBearing_set(this.swigCPtr, this, f);
    }

    public float getRightSideBearing() {
        return ATKCoreJNI.GlyphMetrics_rightSideBearing_get(this.swigCPtr, this);
    }

    public void setLabelSize(long j) {
        ATKCoreJNI.GlyphMetrics_labelSize_set(this.swigCPtr, this, j);
    }

    public long getLabelSize() {
        return ATKCoreJNI.GlyphMetrics_labelSize_get(this.swigCPtr, this);
    }

    public GlyphMetrics() {
        this(ATKCoreJNI.new_GlyphMetrics(), true);
    }
}
