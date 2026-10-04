package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Doc;

/* JADX INFO: loaded from: classes7.dex */
public class PrintToPdfModule {
    static native boolean IsModuleAvailable();

    static native void PrintToPdf(long j, String str, long j2);

    private PrintToPdfModule() {
    }

    public static boolean isModuleAvailable() throws PDFNetException {
        return IsModuleAvailable();
    }

    public static void printToPdf(Doc doc, String str, PrintToPdfOptions printToPdfOptions) throws PDFNetException {
        PrintToPdf(doc.__GetHandle(), str, printToPdfOptions.mo1134a());
        ReachabilityHelper.ensureReachable(printToPdfOptions);
        ReachabilityHelper.ensureReachable(doc);
    }
}
