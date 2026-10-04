package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class ContentEdit {
    static native void Begin(long j);

    static native void End();

    static native String RunXML(String str);

    private ContentEdit() {
    }

    public static void begin(PDFDoc pDFDoc) throws PDFNetException {
        Begin(pDFDoc.__GetHandle());
        ReachabilityHelper.ensureReachable(pDFDoc);
    }

    public static String runXML(String str) throws PDFNetException {
        return RunXML(str);
    }

    public static void end() throws PDFNetException {
        End();
    }
}
