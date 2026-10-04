package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.common.PDFNetIterator;

/* JADX INFO: loaded from: classes7.dex */
public class DigitalSignatureFieldIterator extends PDFNetIterator<DigitalSignatureField> {

    /* JADX INFO: renamed from: a */
    private Object f1527a;

    @Override // com.pdftron.common.PDFNetIterator, java.util.Iterator
    public DigitalSignatureField next() {
        try {
            return new DigitalSignatureField(PDFNetIterator.Next(this.impl), this);
        } catch (PDFNetException unused) {
            return null;
        }
    }

    @Override // com.pdftron.common.PDFNetIterator
    public Object clone() {
        return new DigitalSignatureFieldIterator(Clone(this.impl), this.f1527a);
    }

    DigitalSignatureFieldIterator(long j, Object obj) {
        this.impl = j;
        this.f1527a = obj;
    }
}
