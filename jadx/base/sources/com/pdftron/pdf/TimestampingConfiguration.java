package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class TimestampingConfiguration implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f2073a;

    static native long Create(String str);

    static native void Destroy(long j);

    static native void SetTimestampAuthorityServerPassword(long j, String str);

    static native void SetTimestampAuthorityServerURL(long j, String str);

    static native void SetTimestampAuthorityServerUsername(long j, String str);

    static native void SetUseNonce(long j, boolean z);

    static native long TestConfiguration(long j, long j2);

    public void destroy() throws PDFNetException {
        long j = this.f2073a;
        if (j != 0) {
            Destroy(j);
            this.f2073a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public TimestampingConfiguration(long j) {
        this.f2073a = j;
    }

    public TimestampingConfiguration(String str) throws PDFNetException {
        this.f2073a = Create(str);
    }

    public void setTimestampAuthorityServerURL(String str) throws PDFNetException {
        SetTimestampAuthorityServerURL(this.f2073a, str);
    }

    public void setTimestampAuthorityServerUsername(String str) throws PDFNetException {
        SetTimestampAuthorityServerUsername(this.f2073a, str);
    }

    public void setTimestampAuthorityServerPassword(String str) throws PDFNetException {
        SetTimestampAuthorityServerPassword(this.f2073a, str);
    }

    public void setUseNonce(boolean z) throws PDFNetException {
        SetUseNonce(this.f2073a, z);
    }

    public TimestampingResult testConfiguration(VerificationOptions verificationOptions) throws PDFNetException {
        TimestampingResult timestampingResult = new TimestampingResult(TestConfiguration(this.f2073a, verificationOptions.__GetHandle()));
        ReachabilityHelper.ensureReachable(verificationOptions);
        return timestampingResult;
    }

    public long __GetHandle() {
        return this.f2073a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
