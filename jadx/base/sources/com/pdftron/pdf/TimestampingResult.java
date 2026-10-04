package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class TimestampingResult implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f2074a;

    static native void Destroy(long j);

    static native byte[] GetData(long j);

    static native long GetResponseVerificationResult(long j);

    static native boolean GetStatus(long j);

    static native String GetString(long j);

    static native boolean HasResponseVerificationResult(long j);

    public void destroy() throws PDFNetException {
        long j = this.f2074a;
        if (j != 0) {
            Destroy(j);
            this.f2074a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public TimestampingResult(long j) {
        this.f2074a = j;
    }

    public boolean getStatus() throws PDFNetException {
        return GetStatus(this.f2074a);
    }

    public String getString() throws PDFNetException {
        return GetString(this.f2074a);
    }

    public boolean hasResponseVerificationResult() throws PDFNetException {
        return HasResponseVerificationResult(this.f2074a);
    }

    public EmbeddedTimestampVerificationResult getResponseVerificationResult() throws PDFNetException {
        return new EmbeddedTimestampVerificationResult(GetResponseVerificationResult(this.f2074a));
    }

    public byte[] getData() throws PDFNetException {
        return GetData(this.f2074a);
    }

    public long __GetHandle() {
        return this.f2074a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
