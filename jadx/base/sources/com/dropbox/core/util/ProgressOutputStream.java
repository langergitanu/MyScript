package com.dropbox.core.util;

import com.dropbox.core.util.IOUtil;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public class ProgressOutputStream extends OutputStream {
    private long completed;
    private IOUtil.ProgressListener listener;
    private OutputStream underlying;

    public ProgressOutputStream(OutputStream outputStream) {
        this.underlying = outputStream;
        this.completed = 0L;
    }

    public ProgressOutputStream(OutputStream outputStream, IOUtil.ProgressListener progressListener) {
        this(outputStream);
        this.listener = progressListener;
    }

    public void setListener(IOUtil.ProgressListener progressListener) {
        this.listener = progressListener;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.underlying.write(bArr, i, i2);
        track(i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.underlying.write(bArr);
        track(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.underlying.write(i);
        track(1);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.underlying.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.underlying.close();
    }

    private void track(int i) {
        long j = this.completed + ((long) i);
        this.completed = j;
        IOUtil.ProgressListener progressListener = this.listener;
        if (progressListener != null) {
            progressListener.onProgress(j);
        }
    }
}
