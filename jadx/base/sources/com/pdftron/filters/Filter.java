package com.pdftron.filters;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class Filter implements AutoCloseable {
    protected Filter attached;
    protected long impl;
    protected Object ref;

    static native void AttachFilter(long j, long j2);

    static native boolean CanSeek(long j);

    static native long CreateInputIterator(long j);

    static native void Destroy(long j);

    static native void Flush(long j);

    static native void FlushAll(long j);

    static native long GetAttachedFilter(long j);

    static native String GetDecodeName(long j);

    static native String GetFilePath(long j);

    static native String GetName(long j);

    static native long GetSourceFilter(long j);

    static native boolean IsInputFilter(long j);

    static native long ReleaseAttachedFilter(long j);

    static native void Seek(long j, long j2, int i);

    static native void SetStreamLength(long j, long j2);

    static native long Size(long j);

    static native long Tell(long j);

    static native void WriteToFile(long j, String str, boolean z);

    public void destroy() throws PDFNetException {
        if (this.attached == null && this.ref == null) {
            long j = this.impl;
            if (j != 0) {
                Destroy(j);
                this.impl = 0L;
            }
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public void attachFilter(Filter filter) throws PDFNetException {
        if (filter != null) {
            AttachFilter(this.impl, filter.impl);
            filter.attached = this;
        }
    }

    public Filter releaseAttachedFilter() throws PDFNetException {
        long jReleaseAttachedFilter = ReleaseAttachedFilter(this.impl);
        if (jReleaseAttachedFilter == 0) {
            return null;
        }
        return new Filter(jReleaseAttachedFilter, null);
    }

    public Filter getAttachedFilter() throws PDFNetException {
        return new Filter(GetAttachedFilter(this.impl), this);
    }

    public Filter getSourceFilter() throws PDFNetException {
        long jGetSourceFilter = GetSourceFilter(this.impl);
        Filter filter = this;
        while (true) {
            Filter filter2 = filter.attached;
            if (filter2 == null) {
                return new Filter(jGetSourceFilter, filter);
            }
            filter = filter2;
        }
    }

    public String getName() throws PDFNetException {
        return GetName(this.impl);
    }

    public String getDecodeName() throws PDFNetException {
        return GetDecodeName(this.impl);
    }

    public void setStreamLength(long j) throws PDFNetException {
        SetStreamLength(this.impl, j);
    }

    public void flush() throws PDFNetException {
        Flush(this.impl);
    }

    public void flushAll() throws PDFNetException {
        FlushAll(this.impl);
    }

    public boolean isInputFilter() throws PDFNetException {
        return IsInputFilter(this.impl);
    }

    public boolean canSeek() throws PDFNetException {
        return CanSeek(this.impl);
    }

    public void seek(long j, int i) throws PDFNetException {
        Seek(this.impl, j, i);
    }

    public long size() throws PDFNetException {
        return Size(this.impl);
    }

    public long tell() throws PDFNetException {
        return Tell(this.impl);
    }

    public Filter createInputIterator() throws PDFNetException {
        return new Filter(CreateInputIterator(this.impl), null);
    }

    public String getFilePath() throws PDFNetException {
        return GetFilePath(this.impl);
    }

    public void writeToFile(String str, boolean z) {
        WriteToFile(this.impl, str, z);
    }

    protected Filter(long j, Filter filter) {
        this.impl = j;
        this.attached = filter;
    }

    public static Filter __Create(long j, Filter filter) {
        return new Filter(j, filter);
    }

    public long __GetHandle() {
        return this.impl;
    }

    public void __SetRefHandle(Object obj) {
        this.ref = obj;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
