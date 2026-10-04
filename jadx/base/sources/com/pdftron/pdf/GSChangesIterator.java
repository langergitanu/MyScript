package com.pdftron.pdf;

import com.pdftron.common.PDFNetIterator;

/* JADX INFO: loaded from: classes7.dex */
public class GSChangesIterator extends PDFNetIterator<Integer> {

    /* JADX INFO: renamed from: a */
    private Object f1561a;

    @Override // com.pdftron.common.PDFNetIterator, java.util.Iterator
    public Integer next() {
        return new Integer((int) PDFNetIterator.NextD(this.impl));
    }

    @Override // com.pdftron.common.PDFNetIterator
    public Object clone() {
        return new GSChangesIterator(PDFNetIterator.Clone(this.impl), this.f1561a);
    }

    GSChangesIterator(long j, Object obj) {
        this.impl = j;
        this.f1561a = obj;
    }
}
