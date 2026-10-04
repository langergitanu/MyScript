package com.pdftron.filters;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class FlateEncode extends Filter {
    static native long Create(long j, int i, long j2);

    public FlateEncode(Filter filter) throws PDFNetException {
        super(Create(filter != null ? filter.impl : 0L, -1, 256L), null);
        if (filter != null) {
            filter.attached = this;
        }
    }

    public FlateEncode(Filter filter, int i) throws PDFNetException {
        super(Create(filter != null ? filter.impl : 0L, i, 256L), null);
        if (filter != null) {
            filter.attached = this;
        }
    }

    public FlateEncode(Filter filter, int i, long j) throws PDFNetException {
        super(Create(filter != null ? filter.impl : 0L, i, j), null);
        if (filter != null) {
            filter.attached = this;
        }
    }
}
