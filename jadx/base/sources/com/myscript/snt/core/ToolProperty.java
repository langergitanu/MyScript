package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class ToolProperty {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ToolProperty(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ToolProperty toolProperty) {
        if (toolProperty == null) {
            return 0L;
        }
        return toolProperty.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_ToolProperty(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public ToolProperty() {
        this(NeboEngineJNI.new_ToolProperty__SWIG_0(), true);
    }

    public ToolProperty(int i) {
        this(NeboEngineJNI.new_ToolProperty__SWIG_1(i), true);
    }

    public ToolProperty(int i, float f, SWIGTYPE_p_std__mapT_std__string_std__string_t sWIGTYPE_p_std__mapT_std__string_std__string_t) {
        this(NeboEngineJNI.new_ToolProperty__SWIG_2(i, f, SWIGTYPE_p_std__mapT_std__string_std__string_t.getCPtr(sWIGTYPE_p_std__mapT_std__string_std__string_t)), true);
    }

    public ToolProperty(int i, float f) {
        this(NeboEngineJNI.new_ToolProperty__SWIG_3(i, f), true);
    }

    public void setProperty(String str, String str2) {
        NeboEngineJNI.ToolProperty_setProperty(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public String getProperty(String str) {
        return new String(NeboEngineJNI.ToolProperty_getProperty(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    public void setColor(int i) {
        NeboEngineJNI.ToolProperty_setColor(this.swigCPtr, this, i);
    }

    public void setThicknessRatio(float f) {
        NeboEngineJNI.ToolProperty_setThicknessRatio(this.swigCPtr, this, f);
    }

    public float getThicknessRatio() {
        return NeboEngineJNI.ToolProperty_getThicknessRatio(this.swigCPtr, this);
    }

    public void setPressureSensitivity(float f) {
        NeboEngineJNI.ToolProperty_setPressureSensitivity(this.swigCPtr, this, f);
    }

    public float getPressureSensitivity() {
        return NeboEngineJNI.ToolProperty_getPressureSensitivity(this.swigCPtr, this);
    }

    public void setProperties(SWIGTYPE_p_std__mapT_std__string_std__string_t sWIGTYPE_p_std__mapT_std__string_std__string_t) {
        NeboEngineJNI.ToolProperty_properties_set(this.swigCPtr, this, SWIGTYPE_p_std__mapT_std__string_std__string_t.getCPtr(sWIGTYPE_p_std__mapT_std__string_std__string_t));
    }

    public SWIGTYPE_p_std__mapT_std__string_std__string_t getProperties() {
        return new SWIGTYPE_p_std__mapT_std__string_std__string_t(NeboEngineJNI.ToolProperty_properties_get(this.swigCPtr, this), true);
    }

    public int getColor2() {
        return NeboEngineJNI.ToolProperty_getColor2(this.swigCPtr, this);
    }
}
