package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class Reflow implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f2040a;

    static native void Destroy(long j);

    static native String GetAnnot(long j, String str);

    static native String GetHtml(long j);

    static native String SetAnnot(long j, String str);

    static native void SetCustomStyles(long j, String str);

    static native void SetDoNotReflowTextOverImages(long j, boolean z);

    static native void SetFontOverrideName(long j, String str);

    static native void SetHTMLOutputTextMarkup(long j, boolean z);

    static native void SetHideBackgroundImages(long j, boolean z);

    static native void SetHideImagesUnderInvisibleText(long j, boolean z);

    static native void SetHideImagesUnderText(long j, boolean z);

    static native void SetIncludeBBoxForRecognizedZones(long j, boolean z);

    static native void SetIncludeImages(long j, boolean z);

    static native void SetMessageWhenNoReflowContent(long j, String str);

    static native void SetMessageWhenReflowFailed(long j, String str);

    public void destroy() throws PDFNetException {
        long j = this.f2040a;
        if (j != 0) {
            Destroy(j);
            this.f2040a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public Reflow(long j) {
        this.f2040a = j;
    }

    public String getHtml() throws PDFNetException {
        return GetHtml(this.f2040a);
    }

    public String getAnnot(String str) throws PDFNetException {
        return GetAnnot(this.f2040a, str);
    }

    public String setAnnot(String str) throws PDFNetException {
        return SetAnnot(this.f2040a, str);
    }

    public void setIncludeImages(boolean z) throws PDFNetException {
        SetIncludeImages(this.f2040a, z);
    }

    public void setHTMLOutputTextMarkup(boolean z) throws PDFNetException {
        SetHTMLOutputTextMarkup(this.f2040a, z);
    }

    public void setMessageWhenNoReflowContent(String str) throws PDFNetException {
        SetMessageWhenNoReflowContent(this.f2040a, str);
    }

    public void setMessageWhenReflowFailed(String str) throws PDFNetException {
        SetMessageWhenReflowFailed(this.f2040a, str);
    }

    public void setHideBackgroundImages(boolean z) throws PDFNetException {
        SetHideBackgroundImages(this.f2040a, z);
    }

    public void setHideImagesUnderText(boolean z) throws PDFNetException {
        SetHideImagesUnderText(this.f2040a, z);
    }

    public void setHideImagesUnderInvisibleText(boolean z) throws PDFNetException {
        SetHideImagesUnderInvisibleText(this.f2040a, z);
    }

    public void setDoNotReflowTextOverImages(boolean z) throws PDFNetException {
        SetDoNotReflowTextOverImages(this.f2040a, z);
    }

    public void setFontOverrideName(String str) throws PDFNetException {
        SetFontOverrideName(this.f2040a, str);
    }

    public void setCustomStyles(String str) throws PDFNetException {
        SetCustomStyles(this.f2040a, str);
    }

    public void setIncludeBBoxForRecognizedZones(boolean z) throws PDFNetException {
        SetIncludeBBoxForRecognizedZones(this.f2040a, z);
    }

    public long __GetHandle() {
        return this.f2040a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
