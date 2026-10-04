package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class BarcodeModule {
    static native void ExtractBarcodes(long j, String str, long j2);

    static native String ExtractBarcodesAsString(long j, long j2);

    static native boolean IsModuleAvailable();

    private BarcodeModule() {
    }

    public static boolean isModuleAvailable() throws PDFNetException {
        return IsModuleAvailable();
    }

    public static void extractBarcodes(PDFDoc pDFDoc, String str, BarcodeOptions barcodeOptions) throws PDFNetException {
        if (barcodeOptions == null) {
            barcodeOptions = new BarcodeOptions();
        }
        ExtractBarcodes(pDFDoc.__GetHandle(), str, barcodeOptions.mo1134a());
        ReachabilityHelper.ensureReachable(barcodeOptions);
        ReachabilityHelper.ensureReachable(pDFDoc);
    }

    public static void extractBarcodes(PDFDoc pDFDoc, String str) throws PDFNetException {
        extractBarcodes(pDFDoc, str, null);
    }

    public static String extractBarcodesAsString(PDFDoc pDFDoc, BarcodeOptions barcodeOptions) throws PDFNetException {
        if (barcodeOptions == null) {
            barcodeOptions = new BarcodeOptions();
        }
        String strExtractBarcodesAsString = ExtractBarcodesAsString(pDFDoc.__GetHandle(), barcodeOptions.mo1134a());
        ReachabilityHelper.ensureReachable(barcodeOptions);
        ReachabilityHelper.ensureReachable(pDFDoc);
        return strExtractBarcodesAsString;
    }

    public static String extractBarcodesAsString(PDFDoc pDFDoc) throws PDFNetException {
        return extractBarcodesAsString(pDFDoc, null);
    }
}
