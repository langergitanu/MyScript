package com.pdftron.layout;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class TextStyledElement extends ContentElement {
    static native String GetFontFace(long j) throws PDFNetException;

    static native double GetFontSize(long j) throws PDFNetException;

    static native boolean IsBold(long j) throws PDFNetException;

    static native boolean IsItalic(long j) throws PDFNetException;

    public static native void SetBackgroundColor(long j, int i, int i2, int i3) throws PDFNetException;

    static native void SetBold(long j, boolean z) throws PDFNetException;

    static native void SetFontFace(long j, String str) throws PDFNetException;

    static native void SetFontSize(long j, double d) throws PDFNetException;

    static native void SetItalic(long j, boolean z) throws PDFNetException;

    static native void SetTextColor(long j, int i, int i2, int i3) throws PDFNetException;

    TextStyledElement(long j) {
        super(j);
    }

    public void setFontFace(String str) throws PDFNetException {
        SetFontFace(this.mImpl, str);
    }

    public String getFontFace() throws PDFNetException {
        return GetFontFace(this.mImpl);
    }

    public void setFontSize(double d) throws PDFNetException {
        SetFontSize(this.mImpl, d);
    }

    public double getFontSize() throws PDFNetException {
        return GetFontSize(this.mImpl);
    }

    public void setItalic(boolean z) throws PDFNetException {
        SetItalic(this.mImpl, z);
    }

    public boolean isItalic() throws PDFNetException {
        return IsItalic(this.mImpl);
    }

    public void setBold(boolean z) throws PDFNetException {
        SetBold(this.mImpl, z);
    }

    public boolean isBold() throws PDFNetException {
        return IsBold(this.mImpl);
    }

    public void setTextColor(int i, int i2, int i3) throws PDFNetException, IllegalArgumentException {
        C6928a.m1133a(i, i2, i3);
        SetTextColor(this.mImpl, i, i2, i3);
    }

    public void setBackgroundColor(int i, int i2, int i3) throws PDFNetException {
        SetBackgroundColor(this.mImpl, i, i2, i3);
    }
}
