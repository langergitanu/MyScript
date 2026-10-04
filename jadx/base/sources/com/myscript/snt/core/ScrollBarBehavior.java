package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public class ScrollBarBehavior {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ScrollBarBehavior(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ScrollBarBehavior scrollBarBehavior) {
        if (scrollBarBehavior == null) {
            return 0L;
        }
        return scrollBarBehavior.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_ScrollBarBehavior(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setIsVerticalScrollAllowed(boolean z) {
        NeboEngineJNI.ScrollBarBehavior_isVerticalScrollAllowed_set(this.swigCPtr, this, z);
    }

    public boolean getIsVerticalScrollAllowed() {
        return NeboEngineJNI.ScrollBarBehavior_isVerticalScrollAllowed_get(this.swigCPtr, this);
    }

    public void setIsHorizontalScrollAllowed(boolean z) {
        NeboEngineJNI.ScrollBarBehavior_isHorizontalScrollAllowed_set(this.swigCPtr, this, z);
    }

    public boolean getIsHorizontalScrollAllowed() {
        return NeboEngineJNI.ScrollBarBehavior_isHorizontalScrollAllowed_get(this.swigCPtr, this);
    }

    public void setIsZoomAllowed(boolean z) {
        NeboEngineJNI.ScrollBarBehavior_isZoomAllowed_set(this.swigCPtr, this, z);
    }

    public boolean getIsZoomAllowed() {
        return NeboEngineJNI.ScrollBarBehavior_isZoomAllowed_get(this.swigCPtr, this);
    }

    public void setMinZoom(float f) {
        NeboEngineJNI.ScrollBarBehavior_minZoom_set(this.swigCPtr, this, f);
    }

    public float getMinZoom() {
        return NeboEngineJNI.ScrollBarBehavior_minZoom_get(this.swigCPtr, this);
    }

    public void setMaxZoom(float f) {
        NeboEngineJNI.ScrollBarBehavior_maxZoom_set(this.swigCPtr, this, f);
    }

    public float getMaxZoom() {
        return NeboEngineJNI.ScrollBarBehavior_maxZoom_get(this.swigCPtr, this);
    }

    public ScrollBarBehavior() {
        this(NeboEngineJNI.new_ScrollBarBehavior(), true);
    }
}
