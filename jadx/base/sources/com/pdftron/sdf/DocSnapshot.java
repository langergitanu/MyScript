package com.pdftron.sdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class DocSnapshot implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f2175a;

    static native void Destroy(long j);

    static native boolean Equals(long j, long j2);

    static native int GetHash(long j);

    static native boolean IsValid(long j);

    public void destroy() throws PDFNetException {
        long j = this.f2175a;
        if (j != 0) {
            Destroy(j);
            this.f2175a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public DocSnapshot(long j) {
        this.f2175a = j;
    }

    public int getHash() throws PDFNetException {
        return GetHash(this.f2175a);
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f2175a);
    }

    public boolean equals(DocSnapshot docSnapshot) throws PDFNetException {
        boolean zEquals = Equals(this.f2175a, docSnapshot.__GetHandle());
        ReachabilityHelper.ensureReachable(docSnapshot);
        return zEquals;
    }

    public long __GetHandle() {
        return this.f2175a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
