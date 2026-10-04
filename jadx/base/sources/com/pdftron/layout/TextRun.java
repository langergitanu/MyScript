package com.pdftron.layout;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class TextRun extends ContentElement {
    static native String GetText(long j) throws PDFNetException;

    static native void SetText(long j, String str) throws PDFNetException;

    TextRun(long j) {
        super(j);
    }

    public void setText(String str) throws PDFNetException {
        SetText(this.mImpl, str);
    }

    public String getText() throws PDFNetException {
        return GetText(this.mImpl);
    }
}
