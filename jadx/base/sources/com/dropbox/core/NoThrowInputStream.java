package com.dropbox.core;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class NoThrowInputStream extends InputStream {
    private long bytesRead = 0;
    private final InputStream underlying;

    public NoThrowInputStream(InputStream inputStream) {
        this.underlying = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("don't call close()");
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            this.bytesRead++;
            return this.underlying.read();
        } catch (IOException e) {
            throw new HiddenException(e);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            int i3 = this.underlying.read(bArr, i, i2);
            this.bytesRead += (long) i3;
            return i3;
        } catch (IOException e) {
            throw new HiddenException(e);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            int i = this.underlying.read(bArr);
            this.bytesRead += (long) i;
            return i;
        } catch (IOException e) {
            throw new HiddenException(e);
        }
    }

    public static final class HiddenException extends RuntimeException {
        private static final long serialVersionUID = 0;

        public HiddenException(IOException iOException) {
            super(iOException);
        }

        @Override // java.lang.Throwable
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    public long getBytesRead() {
        return this.bytesRead;
    }
}
