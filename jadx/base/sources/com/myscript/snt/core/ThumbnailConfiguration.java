package com.myscript.snt.core;

import com.myscript.atk.core.IColorInversionPolicy;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class ThumbnailConfiguration {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ThumbnailConfiguration(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ThumbnailConfiguration thumbnailConfiguration) {
        if (thumbnailConfiguration == null) {
            return 0L;
        }
        return thumbnailConfiguration.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_ThumbnailConfiguration(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setWidth(float f) {
        NeboEngineJNI.ThumbnailConfiguration_width_set(this.swigCPtr, this, f);
    }

    public float getWidth() {
        return NeboEngineJNI.ThumbnailConfiguration_width_get(this.swigCPtr, this);
    }

    public void setHeight(float f) {
        NeboEngineJNI.ThumbnailConfiguration_height_set(this.swigCPtr, this, f);
    }

    public float getHeight() {
        return NeboEngineJNI.ThumbnailConfiguration_height_get(this.swigCPtr, this);
    }

    public void setFileExtension(String str) {
        NeboEngineJNI.ThumbnailConfiguration_fileExtension_set(this.swigCPtr, this, str.getBytes());
    }

    public String getFileExtension() {
        return new String(NeboEngineJNI.ThumbnailConfiguration_fileExtension_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setColorInversionPolicy(SWIGTYPE_p_atk__core__ColorInversionPolicy sWIGTYPE_p_atk__core__ColorInversionPolicy) {
        NeboEngineJNI.ThumbnailConfiguration_colorInversionPolicy_set(this.swigCPtr, this, SWIGTYPE_p_atk__core__ColorInversionPolicy.getCPtr(sWIGTYPE_p_atk__core__ColorInversionPolicy));
    }

    public SWIGTYPE_p_atk__core__ColorInversionPolicy getColorInversionPolicy() {
        long jThumbnailConfiguration_colorInversionPolicy_get = NeboEngineJNI.ThumbnailConfiguration_colorInversionPolicy_get(this.swigCPtr, this);
        if (jThumbnailConfiguration_colorInversionPolicy_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_atk__core__ColorInversionPolicy(jThumbnailConfiguration_colorInversionPolicy_get, true);
    }

    public ThumbnailConfiguration() {
        this(NeboEngineJNI.new_ThumbnailConfiguration__SWIG_0(), true);
    }

    public ThumbnailConfiguration(float f, float f2, String str) {
        this(NeboEngineJNI.new_ThumbnailConfiguration__SWIG_1(f, f2, str.getBytes()), true);
    }

    public ThumbnailConfiguration(float f, float f2, String str, IColorInversionPolicy iColorInversionPolicy) {
        this(NeboEngineJNI.new_ThumbnailConfiguration__SWIG_2(f, f2, str.getBytes(), iColorInversionPolicy), true);
    }
}
