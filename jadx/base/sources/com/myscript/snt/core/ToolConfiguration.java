package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class ToolConfiguration extends ToolProperty {
    private transient long swigCPtr;

    public ToolConfiguration(long j, boolean z) {
        super(NeboEngineJNI.ToolConfiguration_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(ToolConfiguration toolConfiguration) {
        if (toolConfiguration == null) {
            return 0L;
        }
        return toolConfiguration.swigCPtr;
    }

    @Override // com.myscript.snt.core.ToolProperty
    protected void finalize() {
        delete();
    }

    @Override // com.myscript.snt.core.ToolProperty
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_ToolConfiguration(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ToolConfiguration)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return nativeEquals((ToolConfiguration) obj);
    }

    public ToolConfiguration() {
        this(NeboEngineJNI.new_ToolConfiguration__SWIG_0(), true);
    }

    public ToolConfiguration(ToolType toolType) {
        this(NeboEngineJNI.new_ToolConfiguration__SWIG_1(toolType.swigValue()), true);
    }

    public ToolConfiguration(ToolType toolType, int i) {
        this(NeboEngineJNI.new_ToolConfiguration__SWIG_2(toolType.swigValue(), i), true);
    }

    public ToolConfiguration(ToolType toolType, int i, float f, SWIGTYPE_p_std__mapT_std__string_std__string_t sWIGTYPE_p_std__mapT_std__string_std__string_t) {
        this(NeboEngineJNI.new_ToolConfiguration__SWIG_3(toolType.swigValue(), i, f, SWIGTYPE_p_std__mapT_std__string_std__string_t.getCPtr(sWIGTYPE_p_std__mapT_std__string_std__string_t)), true);
    }

    public ToolConfiguration(ToolType toolType, int i, float f) {
        this(NeboEngineJNI.new_ToolConfiguration__SWIG_4(toolType.swigValue(), i, f), true);
    }

    public String to_string() {
        return new String(NeboEngineJNI.ToolConfiguration_to_string(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setType(ToolType toolType) {
        NeboEngineJNI.ToolConfiguration_type_set(this.swigCPtr, this, toolType.swigValue());
    }

    public ToolType getType() {
        return ToolType.swigToEnum(NeboEngineJNI.ToolConfiguration_type_get(this.swigCPtr, this));
    }

    public void setState(ToolState toolState) {
        NeboEngineJNI.ToolConfiguration_state_set(this.swigCPtr, this, toolState.swigValue());
    }

    public ToolState getState() {
        return ToolState.swigToEnum(NeboEngineJNI.ToolConfiguration_state_get(this.swigCPtr, this));
    }

    public int hashCode() {
        return NeboEngineJNI.ToolConfiguration_hashCode(this.swigCPtr, this);
    }

    public boolean nativeEquals(ToolConfiguration toolConfiguration) {
        return NeboEngineJNI.ToolConfiguration_nativeEquals(this.swigCPtr, this, getCPtr(toolConfiguration), toolConfiguration);
    }

    public String toString() {
        return new String(NeboEngineJNI.ToolConfiguration_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
