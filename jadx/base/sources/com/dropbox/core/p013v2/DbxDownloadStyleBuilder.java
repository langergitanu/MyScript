package com.dropbox.core.p013v2;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.http.HttpRequestor;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DbxDownloadStyleBuilder<R> {
    private Long start = null;
    private Long length = null;

    public abstract DbxDownloader<R> start() throws DbxException;

    protected DbxDownloadStyleBuilder() {
    }

    protected List<HttpRequestor.Header> getHeaders() {
        if (this.start == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        String str = String.format("bytes=%d-", Long.valueOf(this.start.longValue()));
        if (this.length != null) {
            str = str + Long.toString((this.start.longValue() + this.length.longValue()) - 1);
        }
        arrayList.add(new HttpRequestor.Header("Range", str));
        return arrayList;
    }

    public DbxDownloadStyleBuilder<R> range(long j, long j2) {
        if (j < 0) {
            throw new IllegalArgumentException("start must be non-negative");
        }
        if (j2 < 1) {
            throw new IllegalArgumentException("length must be positive");
        }
        this.start = Long.valueOf(j);
        this.length = Long.valueOf(j2);
        return this;
    }

    public DbxDownloadStyleBuilder<R> range(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("start must be non-negative");
        }
        this.start = Long.valueOf(j);
        this.length = null;
        return this;
    }

    public R download(OutputStream outputStream) throws DbxException, IOException {
        return start().download(outputStream);
    }
}
