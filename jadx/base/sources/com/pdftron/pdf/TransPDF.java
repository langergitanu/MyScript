package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class TransPDF {
    static native int ApplyXLIFF(long j, String str, long j2);

    static native int ApplyXLIFFWithFilter(long j, long j2, long j3);

    static native int ExtractXLIFF(long j, String str, long j2);

    static native int ExtractXLIFFWithFilter(long j, long j2, long j3);

    private TransPDF() {
    }

    public static void extractXLIFFWithFilter(PDFDoc pDFDoc, Filter filter, TransPDFOptions transPDFOptions) throws PDFNetException {
        if (transPDFOptions == null) {
            transPDFOptions = new TransPDFOptions();
        }
        ExtractXLIFFWithFilter(pDFDoc.__GetHandle(), filter.__GetHandle(), transPDFOptions.mo1134a());
        ReachabilityHelper.ensureReachable(filter);
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(transPDFOptions);
    }

    public static void extractXLIFFWithFilter(PDFDoc pDFDoc, Filter filter) throws PDFNetException {
        extractXLIFFWithFilter(pDFDoc, filter, null);
    }

    public static void applyXLIFFWithFilter(PDFDoc pDFDoc, Filter filter, TransPDFOptions transPDFOptions) throws PDFNetException {
        if (transPDFOptions == null) {
            transPDFOptions = new TransPDFOptions();
        }
        ApplyXLIFFWithFilter(pDFDoc.__GetHandle(), filter.__GetHandle(), transPDFOptions.mo1134a());
        ReachabilityHelper.ensureReachable(filter);
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(transPDFOptions);
    }

    public static void applyXLIFFWithFilter(PDFDoc pDFDoc, Filter filter) throws PDFNetException {
        applyXLIFFWithFilter(pDFDoc, filter, null);
    }

    public static void extractXLIFF(PDFDoc pDFDoc, String str, TransPDFOptions transPDFOptions) throws PDFNetException {
        if (transPDFOptions == null) {
            transPDFOptions = new TransPDFOptions();
        }
        ExtractXLIFF(pDFDoc.__GetHandle(), str, transPDFOptions.mo1134a());
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(transPDFOptions);
        ReachabilityHelper.ensureReachable(str);
    }

    public static void extractXLIFF(PDFDoc pDFDoc, String str) throws PDFNetException {
        extractXLIFF(pDFDoc, str, null);
    }

    public static void applyXLIFF(PDFDoc pDFDoc, String str, TransPDFOptions transPDFOptions) throws PDFNetException {
        if (transPDFOptions == null) {
            transPDFOptions = new TransPDFOptions();
        }
        ApplyXLIFF(pDFDoc.__GetHandle(), str, transPDFOptions.mo1134a());
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(transPDFOptions);
    }

    public static void applyXLIFF(PDFDoc pDFDoc, String str) throws PDFNetException {
        applyXLIFF(pDFDoc, str, null);
    }
}
