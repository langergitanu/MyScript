package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public class ToolbarController {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ToolbarController(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ToolbarController toolbarController) {
        if (toolbarController == null) {
            return 0L;
        }
        return toolbarController.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_ToolbarController(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public ToolbarController(String str, boolean z, boolean z2) {
        this(NeboEngineJNI.new_ToolbarController__SWIG_0(str.getBytes(), z, z2), true);
    }

    public ToolbarController(String str, boolean z) {
        this(NeboEngineJNI.new_ToolbarController__SWIG_1(str.getBytes(), z), true);
    }

    public ToolbarController(String str) {
        this(NeboEngineJNI.new_ToolbarController__SWIG_2(str.getBytes()), true);
    }

    public static ToolbarConfiguration getDefaultToolbarConfiguration(String str, boolean z, ToolConfiguration toolConfiguration, boolean z2, boolean z3) {
        return new ToolbarConfiguration(NeboEngineJNI.ToolbarController_getDefaultToolbarConfiguration__SWIG_0(str.getBytes(), z, ToolConfiguration.getCPtr(toolConfiguration), toolConfiguration, z2, z3), true);
    }

    public static ToolbarConfiguration getDefaultToolbarConfiguration(String str, boolean z, ToolConfiguration toolConfiguration, boolean z2) {
        return new ToolbarConfiguration(NeboEngineJNI.ToolbarController_getDefaultToolbarConfiguration__SWIG_1(str.getBytes(), z, ToolConfiguration.getCPtr(toolConfiguration), toolConfiguration, z2), true);
    }

    public static ToolbarConfiguration getDefaultToolbarConfiguration(String str, boolean z, ToolConfiguration toolConfiguration) {
        return new ToolbarConfiguration(NeboEngineJNI.ToolbarController_getDefaultToolbarConfiguration__SWIG_2(str.getBytes(), z, ToolConfiguration.getCPtr(toolConfiguration), toolConfiguration), true);
    }

    public void applyToolConfiguration(ToolConfiguration toolConfiguration) {
        NeboEngineJNI.ToolbarController_applyToolConfiguration(this.swigCPtr, this, ToolConfiguration.getCPtr(toolConfiguration), toolConfiguration);
    }

    public ToolbarConfiguration getToolbarConfiguration() {
        return new ToolbarConfiguration(NeboEngineJNI.ToolbarController_getToolbarConfiguration(this.swigCPtr, this), true);
    }

    public void setTool(ToolType toolType) {
        NeboEngineJNI.ToolbarController_setTool(this.swigCPtr, this, toolType.swigValue());
    }

    public void setColor(int i) {
        NeboEngineJNI.ToolbarController_setColor(this.swigCPtr, this, i);
    }

    public void setThicknessRatio(float f) {
        NeboEngineJNI.ToolbarController_setThicknessRatio(this.swigCPtr, this, f);
    }

    public void setPressureSensitivity(float f) {
        NeboEngineJNI.ToolbarController_setPressureSensitivity(this.swigCPtr, this, f);
    }

    public void setCurrentTool(SWIGTYPE_p_std__shared_ptrT_atk__core__Tool_t sWIGTYPE_p_std__shared_ptrT_atk__core__Tool_t) {
        NeboEngineJNI.ToolbarController_setCurrentTool(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_atk__core__Tool_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__Tool_t));
    }

    public SWIGTYPE_p_std__shared_ptrT_atk__core__Tool_t currentTool() {
        return new SWIGTYPE_p_std__shared_ptrT_atk__core__Tool_t(NeboEngineJNI.ToolbarController_currentTool(this.swigCPtr, this), true);
    }

    public void setPaused(boolean z) {
        NeboEngineJNI.ToolbarController_setPaused(this.swigCPtr, this, z);
    }

    public ToolConfiguration toolConfiguration(ToolType toolType) {
        return new ToolConfiguration(NeboEngineJNI.ToolbarController_toolConfiguration(this.swigCPtr, this, toolType.swigValue()), true);
    }

    public void enableActivePen(boolean z) {
        NeboEngineJNI.ToolbarController_enableActivePen(this.swigCPtr, this, z);
    }

    public boolean isActivePenModeEnabled() {
        return NeboEngineJNI.ToolbarController_isActivePenModeEnabled(this.swigCPtr, this);
    }

    public ToolType defaultToolType() {
        return ToolType.swigToEnum(NeboEngineJNI.ToolbarController_defaultToolType(this.swigCPtr, this));
    }

    public void setReadOnly(boolean z) {
        NeboEngineJNI.ToolbarController_setReadOnly(this.swigCPtr, this, z);
    }

    public static SWIGTYPE_p_atk__core__Tool__Kind toolTypeToToolKind(ToolType toolType) {
        return new SWIGTYPE_p_atk__core__Tool__Kind(NeboEngineJNI.ToolbarController_toolTypeToToolKind(toolType.swigValue()), true);
    }

    public static ToolType toolKindToToolType(SWIGTYPE_p_atk__core__Tool__Kind sWIGTYPE_p_atk__core__Tool__Kind) {
        return ToolType.swigToEnum(NeboEngineJNI.ToolbarController_toolKindToToolType(SWIGTYPE_p_atk__core__Tool__Kind.getCPtr(sWIGTYPE_p_atk__core__Tool__Kind)));
    }

    public void selectToolKind(SWIGTYPE_p_atk__core__Tool__Kind sWIGTYPE_p_atk__core__Tool__Kind) {
        NeboEngineJNI.ToolbarController_selectToolKind(this.swigCPtr, this, SWIGTYPE_p_atk__core__Tool__Kind.getCPtr(sWIGTYPE_p_atk__core__Tool__Kind));
    }
}
