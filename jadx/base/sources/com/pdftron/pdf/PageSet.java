package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class PageSet implements AutoCloseable {
    public static final int e_all = 0;
    public static final int e_even = 2;
    public static final int e_odd = 1;

    /* JADX INFO: renamed from: a */
    long f1995a;

    static native void AddPage(long j, int i);

    static native void AddRange(long j, int i, int i2);

    static native void AddRange(long j, int i, int i2, int i3);

    static native void Destroy(long j);

    static native long PageSetCreate();

    static native long PageSetCreate(int i);

    static native long PageSetCreate(int i, int i2);

    static native long PageSetCreate(int i, int i2, int i3);

    public PageSet() {
        this.f1995a = PageSetCreate();
    }

    public PageSet(int i) {
        this.f1995a = PageSetCreate(i);
    }

    public PageSet(int i, int i2) {
        this.f1995a = PageSetCreate(i, i2);
    }

    public PageSet(int i, int i2, int i3) {
        this.f1995a = PageSetCreate(i, i2, i3);
    }

    public void destroy() throws PDFNetException {
        long j = this.f1995a;
        if (j != 0) {
            Destroy(j);
            this.f1995a = 0L;
        }
    }

    public void addPage(int i) {
        AddPage(this.f1995a, i);
    }

    public void addRange(int i, int i2) {
        AddRange(this.f1995a, i, i2);
    }

    public void addRange(int i, int i2, int i3) {
        AddRange(this.f1995a, i, i2, i3);
    }

    public long __GetHandle() {
        return this.f1995a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
