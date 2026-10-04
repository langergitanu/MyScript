package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutItemGuide extends LayoutItem {
    private transient long swigCPtr;

    public LayoutItemGuide(long j, boolean z) {
        super(ATKCoreJNI.LayoutItemGuide_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(LayoutItemGuide layoutItemGuide) {
        if (layoutItemGuide == null) {
            return 0L;
        }
        return layoutItemGuide.swigCPtr;
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
                ATKCoreJNI.delete_LayoutItemGuide(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public InkStyle getStyle() {
        return new InkStyle(ATKCoreJNI.LayoutItemGuide_getStyle(this.swigCPtr, this), true);
    }

    public String getClasses() {
        return new String(ATKCoreJNI.LayoutItemGuide_getClasses(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String getOverrideStyle() {
        return new String(ATKCoreJNI.LayoutItemGuide_getOverrideStyle(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String getContentGuideId() {
        return new String(ATKCoreJNI.LayoutItemGuide_getContentGuideId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public GuideData getData() {
        return new GuideData(ATKCoreJNI.LayoutItemGuide_getData(this.swigCPtr, this), true);
    }

    public void setLineRange(int i, int i2) {
        ATKCoreJNI.LayoutItemGuide_setLineRange(this.swigCPtr, this, i, i2);
    }

    public LayoutItemGuide(String str, GuideData guideData, GuidePositioning guidePositioning, SWIGTYPE_p_myscript__document__Layout sWIGTYPE_p_myscript__document__Layout, String str2) {
        this(ATKCoreJNI.new_LayoutItemGuide__SWIG_0(str.getBytes(), GuideData.getCPtr(guideData), guideData, GuidePositioning.getCPtr(guidePositioning), guidePositioning, SWIGTYPE_p_myscript__document__Layout.getCPtr(sWIGTYPE_p_myscript__document__Layout), str2.getBytes()), true);
    }

    public LayoutItemGuide(String str, GuideData guideData, GuidePositioning guidePositioning, SWIGTYPE_p_myscript__document__Layout sWIGTYPE_p_myscript__document__Layout, String str2, String str3) {
        this(ATKCoreJNI.new_LayoutItemGuide__SWIG_1(str.getBytes(), GuideData.getCPtr(guideData), guideData, GuidePositioning.getCPtr(guidePositioning), guidePositioning, SWIGTYPE_p_myscript__document__Layout.getCPtr(sWIGTYPE_p_myscript__document__Layout), str2.getBytes(), str3.getBytes()), true);
    }
}
