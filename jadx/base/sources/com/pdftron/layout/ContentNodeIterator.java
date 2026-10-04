package com.pdftron.layout;

import com.pdftron.common.PDFNetIterator;

/* JADX INFO: loaded from: classes7.dex */
public class ContentNodeIterator extends PDFNetIterator<ContentElement> {

    /* JADX INFO: renamed from: a */
    private Object f1420a;

    @Override // com.pdftron.common.PDFNetIterator, java.util.Iterator
    public ContentElement next() {
        return new ContentElement(PDFNetIterator.NextD(this.impl));
    }

    @Override // com.pdftron.common.PDFNetIterator
    public Object clone() {
        return new ContentNodeIterator(PDFNetIterator.Clone(this.impl), this.f1420a);
    }

    ContentNodeIterator(long j, Object obj) {
        this.impl = j;
        this.f1420a = obj;
    }
}
