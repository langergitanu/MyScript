package com.pdftron.common;

/* JADX INFO: loaded from: classes7.dex */
public class ByteRange {

    /* JADX INFO: renamed from: a */
    private int f1381a;

    /* JADX INFO: renamed from: b */
    private int f1382b;

    public ByteRange(int i, int i2) {
        this.f1381a = i;
        this.f1382b = i2;
    }

    public int getStartOffset() throws PDFNetException {
        return this.f1381a;
    }

    public int getEndOffset() throws PDFNetException {
        return this.f1381a + this.f1382b;
    }

    public int getSize() throws PDFNetException {
        return this.f1382b;
    }
}
