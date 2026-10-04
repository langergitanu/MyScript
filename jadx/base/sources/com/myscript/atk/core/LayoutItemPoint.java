package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutItemPoint extends LayoutItem {
    private transient long swigCPtr;

    public LayoutItemPoint(long j, boolean z) {
        super(ATKCoreJNI.LayoutItemPoint_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(LayoutItemPoint layoutItemPoint) {
        if (layoutItemPoint == null) {
            return 0L;
        }
        return layoutItemPoint.swigCPtr;
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
                ATKCoreJNI.delete_LayoutItemPoint(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public long getTimestamp() {
        return ATKCoreJNI.LayoutItemPoint_getTimestamp(this.swigCPtr, this);
    }

    public boolean isFirstPointIncluded() {
        return ATKCoreJNI.LayoutItemPoint_isFirstPointIncluded(this.swigCPtr, this);
    }

    public boolean isLastPointIncluded() {
        return ATKCoreJNI.LayoutItemPoint_isLastPointIncluded(this.swigCPtr, this);
    }

    public boolean isFirstPointPenDown() {
        return ATKCoreJNI.LayoutItemPoint_isFirstPointPenDown(this.swigCPtr, this);
    }

    public boolean isLastPointPenUp() {
        return ATKCoreJNI.LayoutItemPoint_isLastPointPenUp(this.swigCPtr, this);
    }

    public int getSampleCount() {
        return ATKCoreJNI.LayoutItemPoint_getSampleCount(this.swigCPtr, this);
    }

    public Point getPoint() {
        return new Point(ATKCoreJNI.LayoutItemPoint_getPoint(this.swigCPtr, this), true);
    }

    public InkStyle getStyle() {
        return new InkStyle(ATKCoreJNI.LayoutItemPoint_getStyle(this.swigCPtr, this), true);
    }

    public String getClasses() {
        return new String(ATKCoreJNI.LayoutItemPoint_getClasses(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String getOverrideStyle() {
        return new String(ATKCoreJNI.LayoutItemPoint_getOverrideStyle(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean renderWithNextItem() {
        return ATKCoreJNI.LayoutItemPoint_renderWithNextItem(this.swigCPtr, this);
    }

    public LayoutItemPoint(SWIGTYPE_p_myscript__ink__PointPrimitive sWIGTYPE_p_myscript__ink__PointPrimitive, SWIGTYPE_p_myscript__document__Layout sWIGTYPE_p_myscript__document__Layout, String str, String str2) {
        this(ATKCoreJNI.new_LayoutItemPoint(SWIGTYPE_p_myscript__ink__PointPrimitive.getCPtr(sWIGTYPE_p_myscript__ink__PointPrimitive), SWIGTYPE_p_myscript__document__Layout.getCPtr(sWIGTYPE_p_myscript__document__Layout), str.getBytes(), str2.getBytes()), true);
    }

    public Path getPath() {
        return new Path(ATKCoreJNI.LayoutItemPoint_getPath(this.swigCPtr, this), true);
    }
}
