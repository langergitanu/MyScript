package com.pdftron.sdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class PDFTronCustomSecurityHandler extends SecurityHandler {
    static native long Create(int i);

    public PDFTronCustomSecurityHandler(int i) throws PDFNetException {
        super(Create(i), (Object) null);
    }
}
