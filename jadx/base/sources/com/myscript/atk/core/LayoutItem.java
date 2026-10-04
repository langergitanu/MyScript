package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutItem {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public LayoutItem(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(LayoutItem layoutItem) {
        if (layoutItem == null) {
            return 0L;
        }
        return layoutItem.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_LayoutItem(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public Extent getExtent() {
        return new Extent(ATKCoreJNI.LayoutItem_getExtent(this.swigCPtr, this), true);
    }

    public String getId() {
        return new String(ATKCoreJNI.LayoutItem_getId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public Extent getRawExtent() {
        return new Extent(ATKCoreJNI.LayoutItem_getRawExtent(this.swigCPtr, this), true);
    }
}
