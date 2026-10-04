package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
public class TempDoc extends PDFDoc {
    public TempDoc() throws PDFNetException {
    }

    public TempDoc(Filter filter) throws PDFNetException {
        super(filter);
    }

    public TempDoc(InputStream inputStream) throws PDFNetException, IOException {
        this(inputStream, 1048576);
    }

    public TempDoc(InputStream inputStream, int i) throws PDFNetException, IOException {
        super(inputStream, i);
    }

    public void invalidate() {
        this.impl = 0L;
    }
}
