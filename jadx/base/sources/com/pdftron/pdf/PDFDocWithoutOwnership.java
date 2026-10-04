package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
public class PDFDocWithoutOwnership extends PDFDoc {
    public PDFDocWithoutOwnership() throws PDFNetException {
    }

    public PDFDocWithoutOwnership(Filter filter) throws PDFNetException {
        super(filter);
    }

    public PDFDocWithoutOwnership(InputStream inputStream) throws PDFNetException, IOException {
        this(inputStream, 1048576);
    }

    public PDFDocWithoutOwnership(InputStream inputStream, int i) throws PDFNetException, IOException {
        super(inputStream, i);
    }

    @Override // com.pdftron.pdf.PDFDoc
    protected void finalize() throws Throwable {
        try {
            this.impl = 0L;
        } finally {
            super.finalize();
        }
    }

    private PDFDocWithoutOwnership(long j) {
        super(j);
    }

    public static PDFDocWithoutOwnership __Create(long j) {
        return new PDFDocWithoutOwnership(j);
    }
}
