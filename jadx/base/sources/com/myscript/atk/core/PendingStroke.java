package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class PendingStroke {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public PendingStroke(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(PendingStroke pendingStroke) {
        if (pendingStroke == null) {
            return 0L;
        }
        return pendingStroke.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_PendingStroke(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public PendingStroke(int i, InkStroke inkStroke, String str, String str2, InkStyle inkStyle, Extent extent, PointerType pointerType, ButtonType buttonType, int i2, String str3, SWIGTYPE_p_myscript__ink__InkStrokeId sWIGTYPE_p_myscript__ink__InkStrokeId, long j) {
        this(ATKCoreJNI.new_PendingStroke__SWIG_0(i, InkStroke.getCPtr(inkStroke), inkStroke, str.getBytes(), str2.getBytes(), InkStyle.getCPtr(inkStyle), inkStyle, Extent.getCPtr(extent), pointerType.swigValue(), buttonType.swigValue(), i2, str3.getBytes(), SWIGTYPE_p_myscript__ink__InkStrokeId.getCPtr(sWIGTYPE_p_myscript__ink__InkStrokeId), j), true);
    }

    public PendingStroke(int i, InkStroke inkStroke, String str, String str2, InkStyle inkStyle, Extent extent, PointerType pointerType, ButtonType buttonType, int i2, String str3, SWIGTYPE_p_myscript__ink__InkStrokeId sWIGTYPE_p_myscript__ink__InkStrokeId) {
        this(ATKCoreJNI.new_PendingStroke__SWIG_1(i, InkStroke.getCPtr(inkStroke), inkStroke, str.getBytes(), str2.getBytes(), InkStyle.getCPtr(inkStyle), inkStyle, Extent.getCPtr(extent), pointerType.swigValue(), buttonType.swigValue(), i2, str3.getBytes(), SWIGTYPE_p_myscript__ink__InkStrokeId.getCPtr(sWIGTYPE_p_myscript__ink__InkStrokeId)), true);
    }

    public PendingStroke(int i, InkStroke inkStroke, String str, String str2, InkStyle inkStyle, Extent extent, PointerType pointerType, ButtonType buttonType, int i2, String str3) {
        this(ATKCoreJNI.new_PendingStroke__SWIG_2(i, InkStroke.getCPtr(inkStroke), inkStroke, str.getBytes(), str2.getBytes(), InkStyle.getCPtr(inkStyle), inkStyle, Extent.getCPtr(extent), pointerType.swigValue(), buttonType.swigValue(), i2, str3.getBytes()), true);
    }

    public PendingStroke(int i, InkStroke inkStroke, String str, String str2, InkStyle inkStyle, Extent extent, PointerType pointerType, ButtonType buttonType, int i2) {
        this(ATKCoreJNI.new_PendingStroke__SWIG_3(i, InkStroke.getCPtr(inkStroke), inkStroke, str.getBytes(), str2.getBytes(), InkStyle.getCPtr(inkStyle), inkStyle, Extent.getCPtr(extent), pointerType.swigValue(), buttonType.swigValue(), i2), true);
    }

    public PendingStroke(PendingStroke pendingStroke) {
        this(ATKCoreJNI.new_PendingStroke__SWIG_4(getCPtr(pendingStroke), pendingStroke), true);
    }

    public PendingStroke(SWIGTYPE_p_std__shared_ptrT_atk__core__PendingStroke_t sWIGTYPE_p_std__shared_ptrT_atk__core__PendingStroke_t) {
        this(ATKCoreJNI.new_PendingStroke__SWIG_5(SWIGTYPE_p_std__shared_ptrT_atk__core__PendingStroke_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__PendingStroke_t)), true);
    }

    public void discard() {
        ATKCoreJNI.PendingStroke_discard(this.swigCPtr, this);
    }

    public int getInkSamplerIndex() {
        return ATKCoreJNI.PendingStroke_inkSamplerIndex_get(this.swigCPtr, this);
    }

    public void setPendingStrokeId(long j) {
        ATKCoreJNI.PendingStroke_pendingStrokeId_set(this.swigCPtr, this, j);
    }

    public long getPendingStrokeId() {
        return ATKCoreJNI.PendingStroke_pendingStrokeId_get(this.swigCPtr, this);
    }

    public void setStroke(InkStroke inkStroke) {
        ATKCoreJNI.PendingStroke_stroke_set(this.swigCPtr, this, InkStroke.getCPtr(inkStroke), inkStroke);
    }

    public InkStroke getStroke() {
        long jPendingStroke_stroke_get = ATKCoreJNI.PendingStroke_stroke_get(this.swigCPtr, this);
        if (jPendingStroke_stroke_get == 0) {
            return null;
        }
        return new InkStroke(jPendingStroke_stroke_get, false);
    }

    public void setStyleSelector(String str) {
        ATKCoreJNI.PendingStroke_styleSelector_set(this.swigCPtr, this, str.getBytes());
    }

    public String getStyleSelector() {
        return new String(ATKCoreJNI.PendingStroke_styleSelector_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setOverrideStyle(String str) {
        ATKCoreJNI.PendingStroke_overrideStyle_set(this.swigCPtr, this, str.getBytes());
    }

    public String getOverrideStyle() {
        return new String(ATKCoreJNI.PendingStroke_overrideStyle_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setStyle(InkStyle inkStyle) {
        ATKCoreJNI.PendingStroke_style_set(this.swigCPtr, this, InkStyle.getCPtr(inkStyle), inkStyle);
    }

    public InkStyle getStyle() {
        long jPendingStroke_style_get = ATKCoreJNI.PendingStroke_style_get(this.swigCPtr, this);
        if (jPendingStroke_style_get == 0) {
            return null;
        }
        return new InkStyle(jPendingStroke_style_get, false);
    }

    public void setExtentOffset(float f) {
        ATKCoreJNI.PendingStroke_extentOffset_set(this.swigCPtr, this, f);
    }

    public float getExtentOffset() {
        return ATKCoreJNI.PendingStroke_extentOffset_get(this.swigCPtr, this);
    }

    public void setType(PointerType pointerType) {
        ATKCoreJNI.PendingStroke_type_set(this.swigCPtr, this, pointerType.swigValue());
    }

    public PointerType getType() {
        return PointerType.swigToEnum(ATKCoreJNI.PendingStroke_type_get(this.swigCPtr, this));
    }

    public void setButton(ButtonType buttonType) {
        ATKCoreJNI.PendingStroke_button_set(this.swigCPtr, this, buttonType.swigValue());
    }

    public ButtonType getButton() {
        return ButtonType.swigToEnum(ATKCoreJNI.PendingStroke_button_get(this.swigCPtr, this));
    }

    public void setPointerId(int i) {
        ATKCoreJNI.PendingStroke_pointerId_set(this.swigCPtr, this, i);
    }

    public int getPointerId() {
        return ATKCoreJNI.PendingStroke_pointerId_get(this.swigCPtr, this);
    }

    public void setInkStrokeId(SWIGTYPE_p_myscript__ink__InkStrokeId sWIGTYPE_p_myscript__ink__InkStrokeId) {
        ATKCoreJNI.PendingStroke_inkStrokeId_set(this.swigCPtr, this, SWIGTYPE_p_myscript__ink__InkStrokeId.getCPtr(sWIGTYPE_p_myscript__ink__InkStrokeId));
    }

    public SWIGTYPE_p_myscript__ink__InkStrokeId getInkStrokeId() {
        long jPendingStroke_inkStrokeId_get = ATKCoreJNI.PendingStroke_inkStrokeId_get(this.swigCPtr, this);
        if (jPendingStroke_inkStrokeId_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_myscript__ink__InkStrokeId(jPendingStroke_inkStrokeId_get, false);
    }

    public void setStrokeState(PendingStrokeState pendingStrokeState) {
        ATKCoreJNI.PendingStroke_strokeState_set(this.swigCPtr, this, pendingStrokeState.swigValue());
    }

    public PendingStrokeState getStrokeState() {
        return PendingStrokeState.swigToEnum(ATKCoreJNI.PendingStroke_strokeState_get(this.swigCPtr, this));
    }

    public void setLayer(String str) {
        ATKCoreJNI.PendingStroke_layer_set(this.swigCPtr, this, str.getBytes());
    }

    public String getLayer() {
        return new String(ATKCoreJNI.PendingStroke_layer_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setCaptureView(SWIGTYPE_p_std__weak_ptrT_atk__core__CaptureView_t sWIGTYPE_p_std__weak_ptrT_atk__core__CaptureView_t) {
        ATKCoreJNI.PendingStroke_captureView_set(this.swigCPtr, this, SWIGTYPE_p_std__weak_ptrT_atk__core__CaptureView_t.getCPtr(sWIGTYPE_p_std__weak_ptrT_atk__core__CaptureView_t));
    }

    public SWIGTYPE_p_std__weak_ptrT_atk__core__CaptureView_t getCaptureView() {
        long jPendingStroke_captureView_get = ATKCoreJNI.PendingStroke_captureView_get(this.swigCPtr, this);
        if (jPendingStroke_captureView_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__weak_ptrT_atk__core__CaptureView_t(jPendingStroke_captureView_get, false);
    }

    public void setSyncRefreshWithTemporaries(boolean z) {
        ATKCoreJNI.PendingStroke_syncRefreshWithTemporaries_set(this.swigCPtr, this, z);
    }

    public boolean getSyncRefreshWithTemporaries() {
        return ATKCoreJNI.PendingStroke_syncRefreshWithTemporaries_get(this.swigCPtr, this);
    }
}
