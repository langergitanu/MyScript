package com.myscript.snt.core;

import com.myscript.atk.core.MimeType;
import com.myscript.atk.core.SWIGVectorMimeType;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class ExportOptions {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ExportOptions(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ExportOptions exportOptions) {
        if (exportOptions == null) {
            return 0L;
        }
        return exportOptions.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_ExportOptions(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setAvailableMimeTypes(SWIGVectorMimeType sWIGVectorMimeType) {
        SWIGVectorMimeType sWIGVectorMimeType2 = new SWIGVectorMimeType(sWIGVectorMimeType);
        NeboEngineJNI.ExportOptions_availableMimeTypes_set(this.swigCPtr, this, SWIGVectorMimeType.getCPtr(sWIGVectorMimeType2), sWIGVectorMimeType2);
    }

    public SWIGVectorMimeType getAvailableMimeTypes() {
        long jExportOptions_availableMimeTypes_get = NeboEngineJNI.ExportOptions_availableMimeTypes_get(this.swigCPtr, this);
        if (jExportOptions_availableMimeTypes_get == 0) {
            return null;
        }
        return new SWIGVectorMimeType(jExportOptions_availableMimeTypes_get, false);
    }

    public void setName(String str) {
        NeboEngineJNI.ExportOptions_name_set(this.swigCPtr, this, str.getBytes());
    }

    public String getName() {
        return new String(NeboEngineJNI.ExportOptions_name_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setCurrentMimeType(MimeType mimeType) {
        NeboEngineJNI.ExportOptions_currentMimeType_set(this.swigCPtr, this, mimeType.swigValue());
    }

    public MimeType getCurrentMimeType() {
        return MimeType.swigToEnum(NeboEngineJNI.ExportOptions_currentMimeType_get(this.swigCPtr, this));
    }

    public void setIncludeAnnotations(OptionState optionState) {
        NeboEngineJNI.ExportOptions_includeAnnotations_set(this.swigCPtr, this, optionState.swigValue());
    }

    public OptionState getIncludeAnnotations() {
        return OptionState.swigToEnum(NeboEngineJNI.ExportOptions_includeAnnotations_get(this.swigCPtr, this));
    }

    public void setFlatten(OptionState optionState) {
        NeboEngineJNI.ExportOptions_flatten_set(this.swigCPtr, this, optionState.swigValue());
    }

    public OptionState getFlatten() {
        return OptionState.swigToEnum(NeboEngineJNI.ExportOptions_flatten_get(this.swigCPtr, this));
    }

    public void setCombineAsOneDocument(OptionState optionState) {
        NeboEngineJNI.ExportOptions_combineAsOneDocument_set(this.swigCPtr, this, optionState.swigValue());
    }

    public OptionState getCombineAsOneDocument() {
        return OptionState.swigToEnum(NeboEngineJNI.ExportOptions_combineAsOneDocument_get(this.swigCPtr, this));
    }

    public void setNameOption(OptionState optionState) {
        NeboEngineJNI.ExportOptions_nameOption_set(this.swigCPtr, this, optionState.swigValue());
    }

    public OptionState getNameOption() {
        return OptionState.swigToEnum(NeboEngineJNI.ExportOptions_nameOption_get(this.swigCPtr, this));
    }

    public void setIncludeBackgroundColor(OptionState optionState) {
        NeboEngineJNI.ExportOptions_includeBackgroundColor_set(this.swigCPtr, this, optionState.swigValue());
    }

    public OptionState getIncludeBackgroundColor() {
        return OptionState.swigToEnum(NeboEngineJNI.ExportOptions_includeBackgroundColor_get(this.swigCPtr, this));
    }

    public void setIncludeBackgroundPattern(OptionState optionState) {
        NeboEngineJNI.ExportOptions_includeBackgroundPattern_set(this.swigCPtr, this, optionState.swigValue());
    }

    public OptionState getIncludeBackgroundPattern() {
        return OptionState.swigToEnum(NeboEngineJNI.ExportOptions_includeBackgroundPattern_get(this.swigCPtr, this));
    }

    public void setPdfPageIndexesFilter(SWIGTYPE_p_std__unordered_setT_int_t sWIGTYPE_p_std__unordered_setT_int_t) {
        NeboEngineJNI.ExportOptions_pdfPageIndexesFilter_set(this.swigCPtr, this, SWIGTYPE_p_std__unordered_setT_int_t.getCPtr(sWIGTYPE_p_std__unordered_setT_int_t));
    }

    public SWIGTYPE_p_std__unordered_setT_int_t getPdfPageIndexesFilter() {
        return new SWIGTYPE_p_std__unordered_setT_int_t(NeboEngineJNI.ExportOptions_pdfPageIndexesFilter_get(this.swigCPtr, this), true);
    }

    public ExportOptions() {
        this(NeboEngineJNI.new_ExportOptions(), true);
    }
}
