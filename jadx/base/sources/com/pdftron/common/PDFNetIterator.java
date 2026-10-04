package com.pdftron.common;

import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
public abstract class PDFNetIterator<T> implements AutoCloseable, Cloneable, Iterator {
    protected long impl;

    protected static native long Clone(long j);

    static native void Destroy(long j);

    static native boolean HasNext(long j);

    protected static native long Next(long j);

    protected static native long NextD(long j);

    public abstract Object clone();

    @Override // java.util.Iterator
    public abstract T next();

    @Override // java.util.Iterator
    public void remove() {
    }

    public void Destroy() throws PDFNetException {
        Destroy(this.impl);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return HasNext(this.impl);
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        Destroy();
    }
}
