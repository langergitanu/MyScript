package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class ViewChangeCollection implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    long f2099a;

    static native void Destroy(long j);

    static native long ViewChangeCollectionCreate();

    public ViewChangeCollection() throws PDFNetException {
        this.f2099a = ViewChangeCollectionCreate();
    }

    public void destroy() throws PDFNetException {
        long j = this.f2099a;
        if (j != 0) {
            Destroy(j);
            this.f2099a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    ViewChangeCollection(long j) {
        this.f2099a = j;
    }

    public static ViewChangeCollection __Create(long j) {
        return new ViewChangeCollection(j);
    }

    public long __GetHandle() {
        return this.f2099a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
