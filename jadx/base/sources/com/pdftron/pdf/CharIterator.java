package com.pdftron.pdf;

import com.pdftron.common.PDFNetIterator;

/* JADX INFO: loaded from: classes7.dex */
public class CharIterator extends PDFNetIterator<CharData> {

    /* JADX INFO: renamed from: a */
    private Object f1457a;

    @Override // com.pdftron.common.PDFNetIterator, java.util.Iterator
    public CharData next() {
        return new CharData(PDFNetIterator.Next(this.impl), this);
    }

    @Override // com.pdftron.common.PDFNetIterator
    public Object clone() {
        return new CharIterator(Clone(this.impl), this.f1457a);
    }

    CharIterator(long j, Object obj) {
        this.impl = j;
        this.f1457a = obj;
    }
}
