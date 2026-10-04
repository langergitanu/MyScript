package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutItemDecoration extends LayoutItem {
    private transient long swigCPtr;

    public LayoutItemDecoration(long j, boolean z) {
        super(ATKCoreJNI.LayoutItemDecoration_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(LayoutItemDecoration layoutItemDecoration) {
        if (layoutItemDecoration == null) {
            return 0L;
        }
        return layoutItemDecoration.swigCPtr;
    }

    @Override // com.myscript.atk.core.LayoutItem
    protected void finalize() {
        delete();
    }

    @Override // com.myscript.atk.core.LayoutItem
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_LayoutItemDecoration(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public InkStyle getStyle() {
        return new InkStyle(ATKCoreJNI.LayoutItemDecoration_getStyle(this.swigCPtr, this), true);
    }

    public String getClasses() {
        return new String(ATKCoreJNI.LayoutItemDecoration_getClasses(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String getOverrideStyle() {
        return new String(ATKCoreJNI.LayoutItemDecoration_getOverrideStyle(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public int getPointCount() {
        return ATKCoreJNI.LayoutItemDecoration_getPointCount(this.swigCPtr, this);
    }

    public DecorationType getDecorationType() {
        return DecorationType.swigToEnum(ATKCoreJNI.LayoutItemDecoration_getDecorationType(this.swigCPtr, this));
    }

    public Path getPath() {
        return new Path(ATKCoreJNI.LayoutItemDecoration_getPath(this.swigCPtr, this), true);
    }
}
