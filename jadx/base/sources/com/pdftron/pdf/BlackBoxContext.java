package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class BlackBoxContext {
    public static final int e_failure = 2;
    public static final int e_incomplete = 1;
    public static final int e_success = 0;

    /* JADX INFO: renamed from: a */
    private long f1448a;

    static native void Destroy(long j);

    static native String DoOperation(long j, String str);

    static native long GetDoc(long j);

    public synchronized void dispose() throws PDFNetException {
        long j = this.f1448a;
        if (j != 0) {
            Destroy(j);
            this.f1448a = 0L;
        }
    }

    public BlackBoxContext(long j) {
        this.f1448a = j;
    }

    public String doOperation(String str) throws PDFNetException {
        return DoOperation(this.f1448a, str);
    }

    public PDFDoc getDoc() throws PDFNetException {
        return PDFDoc.__Create(GetDoc(this.f1448a));
    }

    public long __GetHandle() {
        return this.f1448a;
    }
}
