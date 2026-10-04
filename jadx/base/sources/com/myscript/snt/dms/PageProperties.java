package com.myscript.snt.dms;

import com.myscript.atk.core.BackgroundPattern;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class PageProperties {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public PageProperties(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(PageProperties pageProperties) {
        if (pageProperties == null) {
            return 0L;
        }
        return pageProperties.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_PageProperties(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public PageProperties(String str, float f, float f2, long j, BackgroundPattern backgroundPattern, boolean z) {
        this(NeboDMSJNI.new_PageProperties__SWIG_0(str.getBytes(), f, f2, j, backgroundPattern.swigValue(), z), true);
    }

    public PageProperties(String str, float f, float f2, long j, BackgroundPattern backgroundPattern) {
        this(NeboDMSJNI.new_PageProperties__SWIG_1(str.getBytes(), f, f2, j, backgroundPattern.swigValue()), true);
    }

    public PageProperties(String str, float f, float f2, long j) {
        this(NeboDMSJNI.new_PageProperties__SWIG_2(str.getBytes(), f, f2, j), true);
    }

    public PageProperties(String str, float f, float f2) {
        this(NeboDMSJNI.new_PageProperties__SWIG_3(str.getBytes(), f, f2), true);
    }

    public PageProperties(String str, float f) {
        this(NeboDMSJNI.new_PageProperties__SWIG_4(str.getBytes(), f), true);
    }

    public PageProperties(String str) {
        this(NeboDMSJNI.new_PageProperties__SWIG_5(str.getBytes()), true);
    }

    public PageProperties() {
        this(NeboDMSJNI.new_PageProperties__SWIG_6(), true);
    }

    public void setPageId(String str) {
        NeboDMSJNI.PageProperties_pageId_set(this.swigCPtr, this, str.getBytes());
    }

    public String getPageId() {
        return new String(NeboDMSJNI.PageProperties_pageId_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setWidth(float f) {
        NeboDMSJNI.PageProperties_width_set(this.swigCPtr, this, f);
    }

    public float getWidth() {
        return NeboDMSJNI.PageProperties_width_get(this.swigCPtr, this);
    }

    public void setHeight(float f) {
        NeboDMSJNI.PageProperties_height_set(this.swigCPtr, this, f);
    }

    public float getHeight() {
        return NeboDMSJNI.PageProperties_height_get(this.swigCPtr, this);
    }

    public void setBackgroundPattern(BackgroundPattern backgroundPattern) {
        NeboDMSJNI.PageProperties_backgroundPattern_set(this.swigCPtr, this, backgroundPattern.swigValue());
    }

    public BackgroundPattern getBackgroundPattern() {
        return BackgroundPattern.swigToEnum(NeboDMSJNI.PageProperties_backgroundPattern_get(this.swigCPtr, this));
    }

    public void setIsCorrupted(boolean z) {
        NeboDMSJNI.PageProperties_isCorrupted_set(this.swigCPtr, this, z);
    }

    public boolean getIsCorrupted() {
        return NeboDMSJNI.PageProperties_isCorrupted_get(this.swigCPtr, this);
    }

    public int getBackgroundColor() {
        return NeboDMSJNI.PageProperties_getBackgroundColor(this.swigCPtr, this);
    }
}
