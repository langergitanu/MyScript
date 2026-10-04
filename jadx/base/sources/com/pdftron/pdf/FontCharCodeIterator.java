package com.pdftron.pdf;

import com.pdftron.common.PDFNetIterator;

/* JADX INFO: loaded from: classes7.dex */
public class FontCharCodeIterator extends PDFNetIterator<Long> {

    /* JADX INFO: renamed from: a */
    private Object f1558a;

    @Override // com.pdftron.common.PDFNetIterator, java.util.Iterator
    public Long next() {
        return new Long(PDFNetIterator.NextD(this.impl));
    }

    @Override // com.pdftron.common.PDFNetIterator
    public Object clone() {
        return new FontCharCodeIterator(PDFNetIterator.Clone(this.impl), this.f1558a);
    }

    FontCharCodeIterator(long j, Object obj) {
        this.impl = j;
        this.f1558a = obj;
    }
}
