package com.dropbox.core;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class NoThrowOutputStream extends OutputStream {
    private long bytesWritten = 0;
    private final OutputStream underlying;

    public NoThrowOutputStream(OutputStream outputStream) {
        this.underlying = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("don't call close()");
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        try {
            this.underlying.flush();
        } catch (IOException e) {
            throw new HiddenException(this, e);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        try {
            this.bytesWritten += (long) i2;
            this.underlying.write(bArr, i, i2);
        } catch (IOException e) {
            throw new HiddenException(this, e);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        try {
            this.bytesWritten += (long) bArr.length;
            this.underlying.write(bArr);
        } catch (IOException e) {
            throw new HiddenException(this, e);
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        try {
            this.bytesWritten++;
            this.underlying.write(i);
        } catch (IOException e) {
            throw new HiddenException(this, e);
        }
    }

    public static final class HiddenException extends RuntimeException {
        public static final long serialVersionUID = 0;
        public final NoThrowOutputStream owner;

        public HiddenException(NoThrowOutputStream noThrowOutputStream, IOException iOException) {
            super(iOException);
            this.owner = noThrowOutputStream;
        }

        @Override // java.lang.Throwable
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    public long getBytesWritten() {
        return this.bytesWritten;
    }
}
