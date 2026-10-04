package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class ToolbarConfiguration {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ToolbarConfiguration(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ToolbarConfiguration toolbarConfiguration) {
        if (toolbarConfiguration == null) {
            return 0L;
        }
        return toolbarConfiguration.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_ToolbarConfiguration(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ToolbarConfiguration)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return nativeEquals((ToolbarConfiguration) obj);
    }

    public ToolbarConfiguration() {
        this(NeboEngineJNI.new_ToolbarConfiguration__SWIG_0(), true);
    }

    public ToolbarConfiguration(String str) {
        this(NeboEngineJNI.new_ToolbarConfiguration__SWIG_1(str.getBytes()), true);
    }

    public ToolbarConfiguration(String str, int i) {
        this(NeboEngineJNI.new_ToolbarConfiguration__SWIG_2(str.getBytes(), i), true);
    }

    public boolean isPaused() {
        return NeboEngineJNI.ToolbarConfiguration_isPaused(this.swigCPtr, this);
    }

    public ToolType getSelectedToolType() {
        return ToolType.swigToEnum(NeboEngineJNI.ToolbarConfiguration_getSelectedToolType(this.swigCPtr, this));
    }

    public String to_string() {
        return new String(NeboEngineJNI.ToolbarConfiguration_to_string(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setSelectedColor(int i) {
        NeboEngineJNI.ToolbarConfiguration_selectedColor_set(this.swigCPtr, this, i);
    }

    public int getSelectedColor() {
        return NeboEngineJNI.ToolbarConfiguration_selectedColor_get(this.swigCPtr, this);
    }

    public void setContentType(String str) {
        NeboEngineJNI.ToolbarConfiguration_contentType_set(this.swigCPtr, this, str.getBytes());
    }

    public String getContentType() {
        return new String(NeboEngineJNI.ToolbarConfiguration_contentType_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setAvailableTools(SWIGVectorToolConfiguration sWIGVectorToolConfiguration) {
        SWIGVectorToolConfiguration sWIGVectorToolConfiguration2 = new SWIGVectorToolConfiguration(sWIGVectorToolConfiguration);
        NeboEngineJNI.ToolbarConfiguration_availableTools_set(this.swigCPtr, this, SWIGVectorToolConfiguration.getCPtr(sWIGVectorToolConfiguration2), sWIGVectorToolConfiguration2);
    }

    public SWIGVectorToolConfiguration getAvailableTools() {
        long jToolbarConfiguration_availableTools_get = NeboEngineJNI.ToolbarConfiguration_availableTools_get(this.swigCPtr, this);
        if (jToolbarConfiguration_availableTools_get == 0) {
            return null;
        }
        return new SWIGVectorToolConfiguration(jToolbarConfiguration_availableTools_get, false);
    }

    public int hashCode() {
        return NeboEngineJNI.ToolbarConfiguration_hashCode(this.swigCPtr, this);
    }

    public boolean nativeEquals(ToolbarConfiguration toolbarConfiguration) {
        return NeboEngineJNI.ToolbarConfiguration_nativeEquals(this.swigCPtr, this, getCPtr(toolbarConfiguration), toolbarConfiguration);
    }

    public String toString() {
        return new String(NeboEngineJNI.ToolbarConfiguration_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
