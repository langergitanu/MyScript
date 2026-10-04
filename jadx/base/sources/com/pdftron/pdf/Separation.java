package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class Separation {

    /* JADX INFO: renamed from: a */
    private byte[] f2045a;

    /* JADX INFO: renamed from: b */
    private String f2046b;

    /* JADX INFO: renamed from: c */
    private byte f2047c;

    /* JADX INFO: renamed from: d */
    private byte f2048d;

    /* JADX INFO: renamed from: e */
    private byte f2049e;

    /* JADX INFO: renamed from: f */
    private byte f2050f;

    public Separation(String str, byte[] bArr, byte b, byte b2, byte b3, byte b4) {
        this.f2046b = str;
        this.f2045a = bArr;
        this.f2047c = b;
        this.f2048d = b2;
        this.f2049e = b3;
        this.f2050f = b4;
    }

    /* JADX INFO: renamed from: C */
    public byte m1492C() throws PDFNetException {
        return this.f2047c;
    }

    /* JADX INFO: renamed from: M */
    public byte m1494M() throws PDFNetException {
        return this.f2048d;
    }

    /* JADX INFO: renamed from: Y */
    public byte m1495Y() throws PDFNetException {
        return this.f2049e;
    }

    /* JADX INFO: renamed from: K */
    public byte m1493K() throws PDFNetException {
        return this.f2050f;
    }

    public int getDataSize() throws PDFNetException {
        return this.f2045a.length;
    }

    public String getSeparationName() throws PDFNetException {
        return this.f2046b;
    }

    public byte[] getData() throws PDFNetException {
        return this.f2045a;
    }
}
