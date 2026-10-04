package com.dropbox.core;

import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.ProgressOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public class DbxDownloader<R> implements Closeable {
    private final InputStream body;
    private boolean closed;
    private final String contentType;
    private final R result;

    public DbxDownloader(R r, InputStream inputStream, String str) {
        this.result = r;
        this.body = inputStream;
        this.contentType = str;
        this.closed = false;
    }

    public DbxDownloader(R r, InputStream inputStream) {
        this(r, inputStream, null);
    }

    public R getResult() {
        return this.result;
    }

    public String getContentType() {
        return this.contentType;
    }

    public InputStream getInputStream() {
        assertOpen();
        return this.body;
    }

    public R download(OutputStream outputStream) throws DbxException, IOException {
        try {
            try {
                IOUtil.copyStreamToStream(getInputStream(), outputStream);
                close();
                return this.result;
            } catch (IOUtil.WriteException e) {
                throw e.getCause();
            } catch (IOException e2) {
                throw new NetworkIOException(e2);
            }
        } catch (Throwable th) {
            close();
            throw th;
        }
    }

    public R download(OutputStream outputStream, IOUtil.ProgressListener progressListener) throws DbxException, IOException {
        return download(new ProgressOutputStream(outputStream, progressListener));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        IOUtil.closeQuietly(this.body);
        this.closed = true;
    }

    private void assertOpen() {
        if (this.closed) {
            throw new IllegalStateException("This downloader is already closed.");
        }
    }
}
