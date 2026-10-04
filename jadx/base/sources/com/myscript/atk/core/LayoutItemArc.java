package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutItemArc extends LayoutItem {
    private transient long swigCPtr;

    public LayoutItemArc(long j, boolean z) {
        super(ATKCoreJNI.LayoutItemArc_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(LayoutItemArc layoutItemArc) {
        if (layoutItemArc == null) {
            return 0L;
        }
        return layoutItemArc.swigCPtr;
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
                ATKCoreJNI.delete_LayoutItemArc(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public EndpointEllipticArc getEndPointParametrization() {
        return new EndpointEllipticArc(ATKCoreJNI.LayoutItemArc_getEndPointParametrization(this.swigCPtr, this), true);
    }

    public CenterEllipticArc getCenterParametrization() {
        return new CenterEllipticArc(ATKCoreJNI.LayoutItemArc_getCenterParametrization(this.swigCPtr, this), true);
    }

    public InkDecorationType getFirstDecoration() {
        return InkDecorationType.swigToEnum(ATKCoreJNI.LayoutItemArc_getFirstDecoration(this.swigCPtr, this));
    }

    public InkDecorationType getLastDecoration() {
        return InkDecorationType.swigToEnum(ATKCoreJNI.LayoutItemArc_getLastDecoration(this.swigCPtr, this));
    }

    public InkStyle getStyle() {
        return new InkStyle(ATKCoreJNI.LayoutItemArc_getStyle(this.swigCPtr, this), true);
    }

    public String getClasses() {
        return new String(ATKCoreJNI.LayoutItemArc_getClasses(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String getOverrideStyle() {
        return new String(ATKCoreJNI.LayoutItemArc_getOverrideStyle(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean renderWithNextItem() {
        return ATKCoreJNI.LayoutItemArc_renderWithNextItem(this.swigCPtr, this);
    }

    public LayoutItemArc(SWIGTYPE_p_myscript__ink__ArcPrimitive sWIGTYPE_p_myscript__ink__ArcPrimitive, SWIGTYPE_p_myscript__document__Layout sWIGTYPE_p_myscript__document__Layout, String str, String str2) {
        this(ATKCoreJNI.new_LayoutItemArc(SWIGTYPE_p_myscript__ink__ArcPrimitive.getCPtr(sWIGTYPE_p_myscript__ink__ArcPrimitive), SWIGTYPE_p_myscript__document__Layout.getCPtr(sWIGTYPE_p_myscript__document__Layout), str.getBytes(), str2.getBytes()), true);
    }

    public Path getPath() {
        return new Path(ATKCoreJNI.LayoutItemArc_getPath(this.swigCPtr, this), true);
    }
}
