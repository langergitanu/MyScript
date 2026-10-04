package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class ImageParameter {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ImageParameter(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ImageParameter imageParameter) {
        if (imageParameter == null) {
            return 0L;
        }
        return imageParameter.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_ImageParameter(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setFilePath(String str) {
        NeboEngineJNI.ImageParameter_filePath_set(this.swigCPtr, this, str.getBytes());
    }

    public String getFilePath() {
        return new String(NeboEngineJNI.ImageParameter_filePath_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setMimeType(String str) {
        NeboEngineJNI.ImageParameter_mimeType_set(this.swigCPtr, this, str.getBytes());
    }

    public String getMimeType() {
        return new String(NeboEngineJNI.ImageParameter_mimeType_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public ImageParameter() {
        this(NeboEngineJNI.new_ImageParameter(), true);
    }
}
