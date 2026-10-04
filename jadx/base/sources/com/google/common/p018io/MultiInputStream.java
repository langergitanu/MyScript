package com.google.common.p018io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
final class MultiInputStream extends InputStream {

    /* JADX INFO: renamed from: in */
    private InputStream f1064in;

    /* JADX INFO: renamed from: it */
    private Iterator<? extends ByteSource> f1065it;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public MultiInputStream(Iterator<? extends ByteSource> it) throws IOException {
        this.f1065it = (Iterator) Preconditions.checkNotNull(it);
        advance();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f1064in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f1064in = null;
            }
        }
    }

    private void advance() throws IOException {
        close();
        if (this.f1065it.hasNext()) {
            this.f1064in = this.f1065it.next().openStream();
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.f1064in;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f1064in;
            if (inputStream == null) {
                return -1;
            }
            int i = inputStream.read();
            if (i != -1) {
                return i;
            }
            advance();
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        Preconditions.checkNotNull(b);
        while (true) {
            InputStream inputStream = this.f1064in;
            if (inputStream == null) {
                return -1;
            }
            int i = inputStream.read(b, off, len);
            if (i != -1) {
                return i;
            }
            advance();
        }
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        InputStream inputStream = this.f1064in;
        if (inputStream == null || n <= 0) {
            return 0L;
        }
        long jSkip = inputStream.skip(n);
        if (jSkip != 0) {
            return jSkip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.f1064in.skip(n - 1) + 1;
    }
}
