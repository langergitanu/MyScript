package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class CADModule {
    static native boolean IsModuleAvailable();

    private CADModule() {
    }

    public static boolean isModuleAvailable() throws PDFNetException {
        return IsModuleAvailable();
    }
}
