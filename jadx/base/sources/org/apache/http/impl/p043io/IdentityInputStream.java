package org.apache.http.impl.p043io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.p044io.BufferInfo;
import org.apache.http.p044io.SessionInputBuffer;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes7.dex */
public class IdentityInputStream extends InputStream {
    private boolean closed = false;

    /* JADX INFO: renamed from: in */
    private final SessionInputBuffer f2379in;

    public IdentityInputStream(SessionInputBuffer sessionInputBuffer) {
        this.f2379in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        SessionInputBuffer sessionInputBuffer = this.f2379in;
        if (sessionInputBuffer instanceof BufferInfo) {
            return ((BufferInfo) sessionInputBuffer).length();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed) {
            return -1;
        }
        return this.f2379in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            return -1;
        }
        return this.f2379in.read(bArr, i, i2);
    }
}
