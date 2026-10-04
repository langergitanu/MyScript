package com.myscript.snt.core;

import com.myscript.atk.core.ViewTransform;

/* JADX INFO: loaded from: classes7.dex */
public class DisplayContext {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DisplayContext(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DisplayContext displayContext) {
        if (displayContext == null) {
            return 0L;
        }
        return displayContext.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_DisplayContext(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setHasAnimations(boolean z) {
        NeboEngineJNI.DisplayContext_hasAnimations_set(this.swigCPtr, this, z);
    }

    public boolean getHasAnimations() {
        return NeboEngineJNI.DisplayContext_hasAnimations_get(this.swigCPtr, this);
    }

    public void setHasDisplay(boolean z) {
        NeboEngineJNI.DisplayContext_hasDisplay_set(this.swigCPtr, this, z);
    }

    public boolean getHasDisplay() {
        return NeboEngineJNI.DisplayContext_hasDisplay_get(this.swigCPtr, this);
    }

    public void setUsesTiles(boolean z) {
        NeboEngineJNI.DisplayContext_usesTiles_set(this.swigCPtr, this, z);
    }

    public boolean getUsesTiles() {
        return NeboEngineJNI.DisplayContext_usesTiles_get(this.swigCPtr, this);
    }

    public void setMaxThreads(short s) {
        NeboEngineJNI.DisplayContext_maxThreads_set(this.swigCPtr, this, s);
    }

    public short getMaxThreads() {
        return NeboEngineJNI.DisplayContext_maxThreads_get(this.swigCPtr, this);
    }

    public void setHasPlatformTiles(boolean z) {
        NeboEngineJNI.DisplayContext_hasPlatformTiles_set(this.swigCPtr, this, z);
    }

    public boolean getHasPlatformTiles() {
        return NeboEngineJNI.DisplayContext_hasPlatformTiles_get(this.swigCPtr, this);
    }

    public void setIsVerticalOnly(boolean z) {
        NeboEngineJNI.DisplayContext_isVerticalOnly_set(this.swigCPtr, this, z);
    }

    public boolean getIsVerticalOnly() {
        return NeboEngineJNI.DisplayContext_isVerticalOnly_get(this.swigCPtr, this);
    }

    public void setNeedGridBackground(boolean z) {
        NeboEngineJNI.DisplayContext_needGridBackground_set(this.swigCPtr, this, z);
    }

    public boolean getNeedGridBackground() {
        return NeboEngineJNI.DisplayContext_needGridBackground_get(this.swigCPtr, this);
    }

    public DisplayContext(ViewTransform viewTransform, boolean z, boolean z2, boolean z3, boolean z4, short s, boolean z5, boolean z6, boolean z7) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_0(ViewTransform.getCPtr(viewTransform), viewTransform, z, z2, z3, z4, s, z5, z6, z7), true);
    }

    public DisplayContext(ViewTransform viewTransform, boolean z, boolean z2, boolean z3, boolean z4, short s, boolean z5, boolean z6) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_1(ViewTransform.getCPtr(viewTransform), viewTransform, z, z2, z3, z4, s, z5, z6), true);
    }

    public DisplayContext(ViewTransform viewTransform, boolean z, boolean z2, boolean z3, boolean z4, short s, boolean z5) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_2(ViewTransform.getCPtr(viewTransform), viewTransform, z, z2, z3, z4, s, z5), true);
    }

    public DisplayContext(ViewTransform viewTransform, boolean z, boolean z2, boolean z3, boolean z4, short s) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_3(ViewTransform.getCPtr(viewTransform), viewTransform, z, z2, z3, z4, s), true);
    }

    public DisplayContext(ViewTransform viewTransform, boolean z, boolean z2, boolean z3, boolean z4) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_4(ViewTransform.getCPtr(viewTransform), viewTransform, z, z2, z3, z4), true);
    }

    public DisplayContext(ViewTransform viewTransform, boolean z, boolean z2, boolean z3) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_5(ViewTransform.getCPtr(viewTransform), viewTransform, z, z2, z3), true);
    }

    public DisplayContext(ViewTransform viewTransform, boolean z, boolean z2) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_6(ViewTransform.getCPtr(viewTransform), viewTransform, z, z2), true);
    }

    public DisplayContext(ViewTransform viewTransform, boolean z) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_7(ViewTransform.getCPtr(viewTransform), viewTransform, z), true);
    }

    public DisplayContext(ViewTransform viewTransform) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_8(ViewTransform.getCPtr(viewTransform), viewTransform), true);
    }

    public DisplayContext(float f, float f2, boolean z, boolean z2, boolean z3, boolean z4, short s, boolean z5) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_9(f, f2, z, z2, z3, z4, s, z5), true);
    }

    public DisplayContext(float f, float f2, boolean z, boolean z2, boolean z3, boolean z4, short s) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_10(f, f2, z, z2, z3, z4, s), true);
    }

    public DisplayContext(float f, float f2, boolean z, boolean z2, boolean z3, boolean z4) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_11(f, f2, z, z2, z3, z4), true);
    }

    public DisplayContext(float f, float f2, boolean z, boolean z2, boolean z3) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_12(f, f2, z, z2, z3), true);
    }

    public DisplayContext(float f, float f2, boolean z, boolean z2) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_13(f, f2, z, z2), true);
    }

    public DisplayContext(float f, float f2, boolean z) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_14(f, f2, z), true);
    }

    public DisplayContext(float f, float f2) {
        this(NeboEngineJNI.new_DisplayContext__SWIG_15(f, f2), true);
    }
}
