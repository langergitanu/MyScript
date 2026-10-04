package com.pdftron.filters;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class FilterReader implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    long f1407a;

    /* JADX INFO: renamed from: b */
    private Filter f1408b;

    static native void AttachFilter(long j, long j2);

    static native long Count(long j);

    static native void Destroy(long j);

    static native long FilterReaderCreate();

    static native long FilterReaderCreate(long j);

    static native void Flush(long j);

    static native void FlushAll(long j);

    static native int Get(long j);

    static native int Peek(long j);

    static native long Read(long j, byte[] bArr);

    static native void Seek(long j, long j2, int i);

    static native long Tell(long j);

    public FilterReader() throws PDFNetException {
        this.f1407a = FilterReaderCreate();
        this.f1408b = null;
    }

    public FilterReader(Filter filter) throws PDFNetException {
        this.f1407a = FilterReaderCreate(filter.impl);
        this.f1408b = filter;
    }

    protected void finalize() throws PDFNetException {
        destroy();
    }

    public void destroy() throws PDFNetException {
        long j = this.f1407a;
        if (j != 0) {
            Destroy(j);
            this.f1407a = 0L;
        }
    }

    public int get() throws PDFNetException {
        return Get(this.f1407a);
    }

    public int peek() throws PDFNetException {
        return Peek(this.f1407a);
    }

    public long read(byte[] bArr) throws PDFNetException {
        return Read(this.f1407a, bArr);
    }

    public void attachFilter(Filter filter) throws PDFNetException {
        this.f1408b = filter;
        AttachFilter(this.f1407a, filter.impl);
        ReachabilityHelper.ensureReachable(filter);
    }

    public Filter getAttachedFilter() throws PDFNetException {
        return this.f1408b;
    }

    public void seek(long j, int i) throws PDFNetException {
        Seek(this.f1407a, j, i);
    }

    public long tell() throws PDFNetException {
        return Tell(this.f1407a);
    }

    public long count() throws PDFNetException {
        return Count(this.f1407a);
    }

    public void flush() throws PDFNetException {
        Flush(this.f1407a);
    }

    public void flushAll() throws PDFNetException {
        FlushAll(this.f1407a);
    }

    public long __GetHandle() {
        return this.f1407a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
