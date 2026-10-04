package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class CharData {

    /* JADX INFO: renamed from: a */
    long f1456a;

    static native long GetCharCode(long j);

    static native byte[] GetCharData(long j);

    static native double GetGlyphX(long j);

    static native double GetGlyphY(long j);

    public long getCharCode() throws PDFNetException {
        return GetCharCode(this.f1456a);
    }

    public double getGlyphX() throws PDFNetException {
        return GetGlyphX(this.f1456a);
    }

    public double getGlyphY() throws PDFNetException {
        return GetGlyphY(this.f1456a);
    }

    public byte[] getCharData() throws PDFNetException {
        return GetCharData(this.f1456a);
    }

    CharData(long j, Object obj) {
        this.f1456a = j;
    }
}
