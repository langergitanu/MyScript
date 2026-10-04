package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutItemIterator {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public LayoutItemIterator(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(LayoutItemIterator layoutItemIterator) {
        if (layoutItemIterator == null) {
            return 0L;
        }
        return layoutItemIterator.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_LayoutItemIterator(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isAtEnd() {
        return ATKCoreJNI.LayoutItemIterator_isAtEnd(this.swigCPtr, this);
    }

    public void next() {
        ATKCoreJNI.LayoutItemIterator_next(this.swigCPtr, this);
    }

    public Extent getExtent() {
        return new Extent(ATKCoreJNI.LayoutItemIterator_getExtent(this.swigCPtr, this), true);
    }

    public LayoutItemIterator(LayoutItemIterator layoutItemIterator) {
        this(ATKCoreJNI.new_LayoutItemIterator__SWIG_0(getCPtr(layoutItemIterator), layoutItemIterator), true);
    }
}
