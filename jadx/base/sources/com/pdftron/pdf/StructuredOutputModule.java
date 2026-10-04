package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class StructuredOutputModule {
    static native boolean IsModuleAvailable();

    private StructuredOutputModule() {
    }

    public static boolean isModuleAvailable() throws PDFNetException {
        return IsModuleAvailable();
    }
}
