package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class LayerIterator {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public LayerIterator(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(LayerIterator layerIterator) {
        if (layerIterator == null) {
            return 0L;
        }
        return layerIterator.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_LayerIterator(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isAtEnd() {
        return ATKCoreJNI.LayerIterator_isAtEnd(this.swigCPtr, this);
    }

    public void next() {
        ATKCoreJNI.LayerIterator_next(this.swigCPtr, this);
    }

    public String getId() {
        return new String(ATKCoreJNI.LayerIterator_getId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public long getBackgroundColor() {
        return ATKCoreJNI.LayerIterator_getBackgroundColor(this.swigCPtr, this);
    }

    public void setBackgroundColor(int i) {
        ATKCoreJNI.LayerIterator_setBackgroundColor(this.swigCPtr, this, i);
    }

    public void remove() {
        ATKCoreJNI.LayerIterator_remove(this.swigCPtr, this);
    }

    public int getItemCount() {
        return ATKCoreJNI.LayerIterator_getItemCount(this.swigCPtr, this);
    }

    public LayoutItemIterator getItems() {
        return new LayoutItemIterator(ATKCoreJNI.LayerIterator_getItems(this.swigCPtr, this), true);
    }

    public Extent getExtent() {
        return new Extent(ATKCoreJNI.LayerIterator_getExtent(this.swigCPtr, this), true);
    }
}
