package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.common.PDFNetIterator;

/* JADX INFO: loaded from: classes7.dex */
public class FieldIterator extends PDFNetIterator<Field> {

    /* JADX INFO: renamed from: a */
    private Object f1543a;

    @Override // com.pdftron.common.PDFNetIterator, java.util.Iterator
    public Field next() {
        try {
            return new Field(PDFNetIterator.Next(this.impl), this);
        } catch (PDFNetException unused) {
            return null;
        }
    }

    @Override // com.pdftron.common.PDFNetIterator
    public Object clone() {
        return new FieldIterator(Clone(this.impl), this.f1543a);
    }

    FieldIterator(long j, Object obj) {
        this.impl = j;
        this.f1543a = obj;
    }
}
