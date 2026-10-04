package com.pdftron.layout;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class ContentNode extends ContentElement {
    static native long GetContentNodeIterator(long j) throws PDFNetException;

    ContentNode(long j) {
        super(j);
    }

    public ContentNodeIterator getContentNodeIterator() throws PDFNetException {
        return new ContentNodeIterator(GetContentNodeIterator(this.mImpl), this);
    }
}
