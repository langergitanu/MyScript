package com.pdftron.pdf;

import com.pdftron.common.PDFNetIterator;

/* JADX INFO: loaded from: classes7.dex */
public class PageIterator extends PDFNetIterator<Page> {

    /* JADX INFO: renamed from: a */
    private Object f1992a;

    @Override // com.pdftron.common.PDFNetIterator, java.util.Iterator
    public Page next() {
        return new Page(PDFNetIterator.NextD(this.impl), this.f1992a);
    }

    @Override // com.pdftron.common.PDFNetIterator
    public Object clone() {
        return new PageIterator(PDFNetIterator.Clone(this.impl), this.f1992a);
    }

    PageIterator(long j, Object obj) {
        this.impl = j;
        this.f1992a = obj;
    }

    /* JADX INFO: renamed from: a */
    final long m1466a() {
        return this.impl;
    }
}
