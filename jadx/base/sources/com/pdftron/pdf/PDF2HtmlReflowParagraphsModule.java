package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class PDF2HtmlReflowParagraphsModule {
    static native boolean IsModuleAvailable();

    private PDF2HtmlReflowParagraphsModule() {
    }

    public static boolean isModuleAvailable() throws PDFNetException {
        return IsModuleAvailable();
    }
}
