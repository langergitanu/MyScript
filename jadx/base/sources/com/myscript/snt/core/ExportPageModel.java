package com.myscript.snt.core;

import com.myscript.atk.core.BackgroundPattern;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class ExportPageModel {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ExportPageModel(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ExportPageModel exportPageModel) {
        if (exportPageModel == null) {
            return 0L;
        }
        return exportPageModel.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_ExportPageModel(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setSerializedPageKey(String str) {
        NeboEngineJNI.ExportPageModel_serializedPageKey_set(this.swigCPtr, this, str.getBytes());
    }

    public String getSerializedPageKey() {
        return new String(NeboEngineJNI.ExportPageModel_serializedPageKey_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setTitle(String str) {
        NeboEngineJNI.ExportPageModel_title_set(this.swigCPtr, this, str.getBytes());
    }

    public String getTitle() {
        return new String(NeboEngineJNI.ExportPageModel_title_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setBackgroundColor(int i) {
        NeboEngineJNI.ExportPageModel_backgroundColor_set(this.swigCPtr, this, i);
    }

    public int getBackgroundColor() {
        return NeboEngineJNI.ExportPageModel_backgroundColor_get(this.swigCPtr, this);
    }

    public void setBackgroundPattern(BackgroundPattern backgroundPattern) {
        NeboEngineJNI.ExportPageModel_backgroundPattern_set(this.swigCPtr, this, backgroundPattern.swigValue());
    }

    public BackgroundPattern getBackgroundPattern() {
        return BackgroundPattern.swigToEnum(NeboEngineJNI.ExportPageModel_backgroundPattern_get(this.swigCPtr, this));
    }

    public void setContentType(String str) {
        NeboEngineJNI.ExportPageModel_contentType_set(this.swigCPtr, this, str.getBytes());
    }

    public String getContentType() {
        return new String(NeboEngineJNI.ExportPageModel_contentType_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setWidth(float f) {
        NeboEngineJNI.ExportPageModel_width_set(this.swigCPtr, this, f);
    }

    public float getWidth() {
        return NeboEngineJNI.ExportPageModel_width_get(this.swigCPtr, this);
    }

    public void setHeight(float f) {
        NeboEngineJNI.ExportPageModel_height_set(this.swigCPtr, this, f);
    }

    public float getHeight() {
        return NeboEngineJNI.ExportPageModel_height_get(this.swigCPtr, this);
    }

    public void setCorrupted(boolean z) {
        NeboEngineJNI.ExportPageModel_corrupted_set(this.swigCPtr, this, z);
    }

    public boolean getCorrupted() {
        return NeboEngineJNI.ExportPageModel_corrupted_get(this.swigCPtr, this);
    }

    public ExportPageModel() {
        this(NeboEngineJNI.new_ExportPageModel(), true);
    }
}
