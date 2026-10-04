package com.dropbox.core.util;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public class CountingOutputStream extends OutputStream {
    private long bytesWritten = 0;
    private final OutputStream out;

    public CountingOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    public long getBytesWritten() {
        return this.bytesWritten;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.bytesWritten++;
        this.out.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.bytesWritten += (long) bArr.length;
        this.out.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.bytesWritten += (long) i2;
        this.out.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw new UnsupportedOperationException("You aren't allowed to call close() on this object.");
    }
}
