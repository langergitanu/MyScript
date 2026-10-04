package com.myscript.nebo.dms.cloud.common.utils;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public class ProgressOutputStream extends OutputStream {
    private int mCompleted = 0;
    private ProgressListener mListener;
    private long mTotalSize;
    private OutputStream mUnderlying;

    public interface ProgressListener {
        void progress(long j, long j2);
    }

    public ProgressOutputStream(long j, OutputStream outputStream, ProgressListener progressListener) {
        this.mUnderlying = outputStream;
        this.mListener = progressListener;
        this.mTotalSize = j;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.mUnderlying.write(bArr, i, i2);
        track(i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.mUnderlying.write(bArr);
        track(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.mUnderlying.write(i);
        track(1);
    }

    private void track(int i) {
        int i2 = this.mCompleted + i;
        this.mCompleted = i2;
        this.mListener.progress(i2, this.mTotalSize);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OutputStream outputStream = this.mUnderlying;
        if (outputStream != null) {
            outputStream.close();
        }
        super.close();
    }
}
