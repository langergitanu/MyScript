package com.pdftron.sdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class DictIterator implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    long f2173a;

    /* JADX INFO: renamed from: b */
    private Object f2174b;

    static native void Destroy(long j);

    static native boolean HasCurrent(long j);

    static native long Key(long j);

    static native void Next(long j);

    static native long Value(long j);

    public void destroy() throws PDFNetException {
        long j = this.f2173a;
        if (j != 0) {
            Destroy(j);
            this.f2173a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public void next() throws PDFNetException {
        Next(this.f2173a);
    }

    public Obj key() throws PDFNetException {
        return Obj.__Create(Key(this.f2173a), this.f2174b);
    }

    public Obj value() throws PDFNetException {
        return Obj.__Create(Value(this.f2173a), this.f2174b);
    }

    public boolean hasNext() throws PDFNetException {
        return HasCurrent(this.f2173a);
    }

    public boolean hasCurrent() throws PDFNetException {
        return HasCurrent(this.f2173a);
    }

    DictIterator(long j, Object obj) {
        this.f2173a = j;
        this.f2174b = obj;
    }

    public long __GetHandle() {
        return this.f2173a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
