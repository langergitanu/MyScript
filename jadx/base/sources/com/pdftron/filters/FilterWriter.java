package com.pdftron.filters;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class FilterWriter implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private Filter f1409a;

    /* JADX INFO: renamed from: b */
    private long f1410b;

    static native void AttachFilter(long j, long j2);

    static native long Count(long j);

    static native void Destroy(long j);

    static native long FilterWriterCreate();

    static native long FilterWriterCreate(long j);

    static native void Flush(long j);

    static native void FlushAll(long j);

    static native void Seek(long j, long j2, int i);

    static native long Tell(long j);

    static native long WriteBuffer(long j, byte[] bArr);

    static native void WriteFilter(long j, long j2);

    static native void WriteInt(long j, int i);

    static native void WriteLine(long j, String str);

    static native void WriteString(long j, String str);

    static native void WriteUChar(long j, byte b);

    public void destroy() throws PDFNetException {
        long j = this.f1410b;
        if (j != 0) {
            Destroy(j);
            this.f1410b = 0L;
        }
    }

    protected void finalize() throws PDFNetException {
        destroy();
    }

    public FilterWriter() throws PDFNetException {
        this.f1410b = FilterWriterCreate();
        this.f1409a = null;
    }

    public FilterWriter(Filter filter) throws PDFNetException {
        this.f1410b = FilterWriterCreate(filter.impl);
        this.f1409a = filter;
    }

    public void writeUChar(byte b) throws PDFNetException {
        WriteUChar(this.f1410b, b);
    }

    public void writeInt(int i) throws PDFNetException {
        WriteInt(this.f1410b, i);
    }

    public void writeString(String str) throws PDFNetException {
        WriteString(this.f1410b, str);
    }

    public void writeFilter(FilterReader filterReader) throws PDFNetException {
        WriteFilter(this.f1410b, filterReader.f1407a);
        ReachabilityHelper.ensureReachable(filterReader);
    }

    public void writeLine(String str) throws PDFNetException {
        WriteLine(this.f1410b, str);
    }

    public long writeBuffer(byte[] bArr) throws PDFNetException {
        return WriteBuffer(this.f1410b, bArr);
    }

    public void attachFilter(Filter filter) throws PDFNetException {
        AttachFilter(this.f1410b, filter.impl);
        this.f1409a = filter;
    }

    public Filter getAttachedFilter() throws PDFNetException {
        return this.f1409a;
    }

    public void seek(long j, int i) throws PDFNetException {
        Seek(this.f1410b, j, i);
    }

    public long tell() throws PDFNetException {
        return Tell(this.f1410b);
    }

    public long count() throws PDFNetException {
        return Count(this.f1410b);
    }

    public void flush() throws PDFNetException {
        Flush(this.f1410b);
    }

    public void flushAll() throws PDFNetException {
        FlushAll(this.f1410b);
    }

    public long __GetHandle() {
        return this.f1410b;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
