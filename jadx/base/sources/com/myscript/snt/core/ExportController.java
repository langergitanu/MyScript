package com.myscript.snt.core;

import com.myscript.atk.core.ICancelableTaskProgressCallback;
import com.myscript.atk.core.Json;
import com.myscript.atk.core.MimeType;
import com.myscript.atk.core.SWIGVectorString;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ExportController {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ExportController(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ExportController exportController) {
        if (exportController == null) {
            return 0L;
        }
        return exportController.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_ExportController(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setExportDelegate(IExportControllerDelegate iExportControllerDelegate) {
        NeboEngineJNI.ExportController_setExportDelegate(this.swigCPtr, this, iExportControllerDelegate);
    }

    public void setNeboExporter(SWIGTYPE_p_std__shared_ptrT_snt__NeboExporter_t sWIGTYPE_p_std__shared_ptrT_snt__NeboExporter_t) {
        NeboEngineJNI.ExportController_setNeboExporter(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_snt__NeboExporter_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_snt__NeboExporter_t));
    }

    public void setExtraNeboMetadata(Json json) {
        NeboEngineJNI.ExportController_setExtraNeboMetadata(this.swigCPtr, this, Json.getCPtr(json), json);
    }

    public void setDefaultLang(String str) {
        NeboEngineJNI.ExportController_setDefaultLang(this.swigCPtr, this, str.getBytes());
    }

    public ExportOptions exportOptions() {
        return new ExportOptions(NeboEngineJNI.ExportController_exportOptions(this.swigCPtr, this), true);
    }

    public void setWatermarkData(String str, String str2) {
        NeboEngineJNI.ExportController_setWatermarkData(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public void setExportMimeType(MimeType mimeType) {
        NeboEngineJNI.ExportController_setExportMimeType(this.swigCPtr, this, mimeType.swigValue());
    }

    public void includeAnnotations(boolean z) {
        NeboEngineJNI.ExportController_includeAnnotations(this.swigCPtr, this, z);
    }

    public void flatten(boolean z) {
        NeboEngineJNI.ExportController_flatten(this.swigCPtr, this, z);
    }

    public void includeBackgroundColor(boolean z) {
        NeboEngineJNI.ExportController_includeBackgroundColor(this.swigCPtr, this, z);
    }

    public void includeBackgroundPattern(boolean z) {
        NeboEngineJNI.ExportController_includeBackgroundPattern(this.swigCPtr, this, z);
    }

    public void setPdfPageIndexesFilter(List<Integer> list) {
        SWIGVectorColors sWIGVectorColors = new SWIGVectorColors(list);
        NeboEngineJNI.ExportController_setPdfPageIndexesFilter(this.swigCPtr, this, SWIGVectorColors.getCPtr(sWIGVectorColors), sWIGVectorColors);
    }

    public void combineAsOneDocument(boolean z) {
        NeboEngineJNI.ExportController_combineAsOneDocument(this.swigCPtr, this, z);
    }

    public void setName(String str) {
        NeboEngineJNI.ExportController_setName(this.swigCPtr, this, str.getBytes());
    }

    public String filename() {
        return new String(NeboEngineJNI.ExportController_filename(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void includeEmptyPages(boolean z) {
        NeboEngineJNI.ExportController_includeEmptyPages(this.swigCPtr, this, z);
    }

    public long pagesToExportCount() {
        return NeboEngineJNI.ExportController_pagesToExportCount(this.swigCPtr, this);
    }

    public List<String> makeExport(String str, ICancelableTaskProgressCallback iCancelableTaskProgressCallback) {
        return new SWIGVectorString(NeboEngineJNI.ExportController_makeExport(this.swigCPtr, this, str.getBytes(), iCancelableTaskProgressCallback), true);
    }

    public List<String> exportAllToText(ICancelableTaskProgressCallback iCancelableTaskProgressCallback) {
        return new SWIGVectorString(NeboEngineJNI.ExportController_exportAllToText(this.swigCPtr, this, iCancelableTaskProgressCallback), true);
    }

    public List<String> makeExport2(String str) {
        return new SWIGVectorString(NeboEngineJNI.ExportController_makeExport2(this.swigCPtr, this, str.getBytes()), true);
    }
}
