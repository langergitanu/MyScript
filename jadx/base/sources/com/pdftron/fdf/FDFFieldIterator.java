package com.pdftron.fdf;

import com.pdftron.common.PDFNetIterator;

/* JADX INFO: loaded from: classes7.dex */
public class FDFFieldIterator extends PDFNetIterator<FDFField> {

    /* JADX INFO: renamed from: a */
    private Object f1399a;

    @Override // com.pdftron.common.PDFNetIterator, java.util.Iterator
    public FDFField next() {
        return new FDFField(Next(this.impl), this);
    }

    @Override // com.pdftron.common.PDFNetIterator
    public Object clone() {
        return new FDFFieldIterator(Clone(this.impl), this.f1399a);
    }

    FDFFieldIterator(long j, Object obj) {
        this.impl = j;
        this.f1399a = obj;
    }
}
