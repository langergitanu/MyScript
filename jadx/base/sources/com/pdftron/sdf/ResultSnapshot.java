package com.pdftron.sdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class ResultSnapshot implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f2183a;

    static native long CurrentState(long j);

    static native void Destroy(long j);

    static native boolean IsNullTransition(long j);

    static native boolean IsOk(long j);

    static native long PreviousState(long j);

    public void destroy() throws PDFNetException {
        long j = this.f2183a;
        if (j != 0) {
            Destroy(j);
            this.f2183a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public ResultSnapshot(long j) {
        this.f2183a = j;
    }

    public DocSnapshot currentState() throws PDFNetException {
        return new DocSnapshot(CurrentState(this.f2183a));
    }

    public DocSnapshot previousState() throws PDFNetException {
        return new DocSnapshot(PreviousState(this.f2183a));
    }

    public boolean isOk() throws PDFNetException {
        return IsOk(this.f2183a);
    }

    public boolean isNullTransition() throws PDFNetException {
        return IsNullTransition(this.f2183a);
    }

    public long __GetHandle() {
        return this.f2183a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
