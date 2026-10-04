package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutItemStroke extends LayoutItem {
    private transient long swigCPtr;

    public LayoutItemStroke(long j, boolean z) {
        super(ATKCoreJNI.LayoutItemStroke_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(LayoutItemStroke layoutItemStroke) {
        if (layoutItemStroke == null) {
            return 0L;
        }
        return layoutItemStroke.swigCPtr;
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
                ATKCoreJNI.delete_LayoutItemStroke(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public long getTimestamp() {
        return ATKCoreJNI.LayoutItemStroke_getTimestamp(this.swigCPtr, this);
    }

    public boolean isFirstPointIncluded() {
        return ATKCoreJNI.LayoutItemStroke_isFirstPointIncluded(this.swigCPtr, this);
    }

    public boolean isLastPointIncluded() {
        return ATKCoreJNI.LayoutItemStroke_isLastPointIncluded(this.swigCPtr, this);
    }

    public boolean isFirstPointPenDown() {
        return ATKCoreJNI.LayoutItemStroke_isFirstPointPenDown(this.swigCPtr, this);
    }

    public boolean isLastPointPenUp() {
        return ATKCoreJNI.LayoutItemStroke_isLastPointPenUp(this.swigCPtr, this);
    }

    public int getSampleCount() {
        return ATKCoreJNI.LayoutItemStroke_getSampleCount(this.swigCPtr, this);
    }

    public InkStyle getStyle() {
        return new InkStyle(ATKCoreJNI.LayoutItemStroke_getStyle(this.swigCPtr, this), true);
    }

    public String getClasses() {
        return new String(ATKCoreJNI.LayoutItemStroke_getClasses(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String getOverrideStyle() {
        return new String(ATKCoreJNI.LayoutItemStroke_getOverrideStyle(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public InkStroke getInkStroke() {
        return new InkStroke(ATKCoreJNI.LayoutItemStroke_getInkStroke(this.swigCPtr, this), true);
    }

    public boolean renderWithNextItem() {
        return ATKCoreJNI.LayoutItemStroke_renderWithNextItem(this.swigCPtr, this);
    }

    public LayoutItemStroke(InkStroke inkStroke, SWIGTYPE_p_myscript__document__Layout sWIGTYPE_p_myscript__document__Layout, String str, String str2) {
        this(ATKCoreJNI.new_LayoutItemStroke(InkStroke.getCPtr(inkStroke), inkStroke, SWIGTYPE_p_myscript__document__Layout.getCPtr(sWIGTYPE_p_myscript__document__Layout), str.getBytes(), str2.getBytes()), true);
    }

    public Path getPath() {
        return new Path(ATKCoreJNI.LayoutItemStroke_getPath(this.swigCPtr, this), true);
    }
}
