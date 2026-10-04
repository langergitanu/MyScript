package com.pdftron.filters;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class ASCII85Encode extends Filter {
    static native long ASCII85EncodeCreate(long j, long j2, long j3);

    public ASCII85Encode(Filter filter) throws PDFNetException {
        super(ASCII85EncodeCreate(filter != null ? filter.impl : 0L, 72L, 256L), null);
        if (filter != null) {
            filter.attached = this;
        }
    }

    public ASCII85Encode(Filter filter, long j) throws PDFNetException {
        super(ASCII85EncodeCreate(filter != null ? filter.impl : 0L, j, 256L), null);
        if (filter != null) {
            filter.attached = this;
        }
    }

    public ASCII85Encode(Filter filter, long j, long j2) throws PDFNetException {
        super(ASCII85EncodeCreate(filter != null ? filter.impl : 0L, j, j2), null);
        if (filter != null) {
            filter.attached = this;
        }
    }
}
