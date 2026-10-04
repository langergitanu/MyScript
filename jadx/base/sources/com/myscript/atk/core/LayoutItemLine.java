package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutItemLine extends LayoutItem {
    private transient long swigCPtr;

    public LayoutItemLine(long j, boolean z) {
        super(ATKCoreJNI.LayoutItemLine_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(LayoutItemLine layoutItemLine) {
        if (layoutItemLine == null) {
            return 0L;
        }
        return layoutItemLine.swigCPtr;
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
                ATKCoreJNI.delete_LayoutItemLine(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public long getTimestamp() {
        return ATKCoreJNI.LayoutItemLine_getTimestamp(this.swigCPtr, this);
    }

    public boolean isFirstPointIncluded() {
        return ATKCoreJNI.LayoutItemLine_isFirstPointIncluded(this.swigCPtr, this);
    }

    public boolean isLastPointIncluded() {
        return ATKCoreJNI.LayoutItemLine_isLastPointIncluded(this.swigCPtr, this);
    }

    public boolean isFirstPointPenDown() {
        return ATKCoreJNI.LayoutItemLine_isFirstPointPenDown(this.swigCPtr, this);
    }

    public boolean isLastPointPenUp() {
        return ATKCoreJNI.LayoutItemLine_isLastPointPenUp(this.swigCPtr, this);
    }

    public int getSampleCount() {
        return ATKCoreJNI.LayoutItemLine_getSampleCount(this.swigCPtr, this);
    }

    public LineSegment getLineSegment() {
        return new LineSegment(ATKCoreJNI.LayoutItemLine_getLineSegment(this.swigCPtr, this), true);
    }

    public InkDecorationType getFirstDecoration() {
        return InkDecorationType.swigToEnum(ATKCoreJNI.LayoutItemLine_getFirstDecoration(this.swigCPtr, this));
    }

    public InkDecorationType getLastDecoration() {
        return InkDecorationType.swigToEnum(ATKCoreJNI.LayoutItemLine_getLastDecoration(this.swigCPtr, this));
    }

    public InkStyle getStyle() {
        return new InkStyle(ATKCoreJNI.LayoutItemLine_getStyle(this.swigCPtr, this), true);
    }

    public String getClasses() {
        return new String(ATKCoreJNI.LayoutItemLine_getClasses(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String getOverrideStyle() {
        return new String(ATKCoreJNI.LayoutItemLine_getOverrideStyle(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean renderWithNextItem() {
        return ATKCoreJNI.LayoutItemLine_renderWithNextItem(this.swigCPtr, this);
    }

    public LayoutItemLine(SWIGTYPE_p_myscript__ink__LinePrimitive sWIGTYPE_p_myscript__ink__LinePrimitive, SWIGTYPE_p_myscript__document__Layout sWIGTYPE_p_myscript__document__Layout, String str, String str2) {
        this(ATKCoreJNI.new_LayoutItemLine(SWIGTYPE_p_myscript__ink__LinePrimitive.getCPtr(sWIGTYPE_p_myscript__ink__LinePrimitive), SWIGTYPE_p_myscript__document__Layout.getCPtr(sWIGTYPE_p_myscript__document__Layout), str.getBytes(), str2.getBytes()), true);
    }

    public Path getPath() {
        return new Path(ATKCoreJNI.LayoutItemLine_getPath(this.swigCPtr, this), true);
    }
}
