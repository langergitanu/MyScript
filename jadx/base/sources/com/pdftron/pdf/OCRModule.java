package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class OCRModule {
    static native void ApplyOCRJsonToPDF(long j, String str);

    static native void ApplyOCRXmlToPDF(long j, String str);

    static native String GetOCRJsonFromImage(long j, String str, long j2);

    static native String GetOCRJsonFromPDF(long j, long j2);

    static native String GetOCRXmlFromImage(long j, String str, long j2);

    static native String GetOCRXmlFromPDF(long j, long j2);

    static native void ImageToPDF(long j, String str, long j2);

    static native boolean IsIRISModuleAvailable();

    static native boolean IsModuleAvailable();

    static native void ProcessPDF(long j, long j2);

    private OCRModule() {
    }

    public static boolean isModuleAvailable() throws PDFNetException {
        return IsModuleAvailable();
    }

    public static boolean isIRISModuleAvailable() throws PDFNetException {
        return IsIRISModuleAvailable();
    }

    public static void imageToPDF(PDFDoc pDFDoc, String str, OCROptions oCROptions) throws PDFNetException {
        ImageToPDF(pDFDoc == null ? 0L : pDFDoc.__GetHandle(), str, oCROptions != null ? oCROptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(oCROptions);
    }

    public static void processPDF(PDFDoc pDFDoc, OCROptions oCROptions) throws PDFNetException {
        ProcessPDF(pDFDoc == null ? 0L : pDFDoc.__GetHandle(), oCROptions != null ? oCROptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(oCROptions);
    }

    public static String getOCRJsonFromImage(PDFDoc pDFDoc, String str, OCROptions oCROptions) throws PDFNetException {
        String strGetOCRJsonFromImage = GetOCRJsonFromImage(pDFDoc == null ? 0L : pDFDoc.__GetHandle(), str, oCROptions != null ? oCROptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(oCROptions);
        return strGetOCRJsonFromImage;
    }

    public static String getOCRJsonFromPDF(PDFDoc pDFDoc, OCROptions oCROptions) throws PDFNetException {
        String strGetOCRJsonFromPDF = GetOCRJsonFromPDF(pDFDoc == null ? 0L : pDFDoc.__GetHandle(), oCROptions != null ? oCROptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(oCROptions);
        return strGetOCRJsonFromPDF;
    }

    public static void applyOCRJsonToPDF(PDFDoc pDFDoc, String str) throws PDFNetException {
        ApplyOCRJsonToPDF(pDFDoc == null ? 0L : pDFDoc.__GetHandle(), str);
        ReachabilityHelper.ensureReachable(pDFDoc);
    }

    public static String getOCRXmlFromImage(PDFDoc pDFDoc, String str, OCROptions oCROptions) throws PDFNetException {
        String strGetOCRXmlFromImage = GetOCRXmlFromImage(pDFDoc == null ? 0L : pDFDoc.__GetHandle(), str, oCROptions != null ? oCROptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(oCROptions);
        return strGetOCRXmlFromImage;
    }

    public static String getOCRXmlFromPDF(PDFDoc pDFDoc, OCROptions oCROptions) throws PDFNetException {
        String strGetOCRXmlFromPDF = GetOCRXmlFromPDF(pDFDoc == null ? 0L : pDFDoc.__GetHandle(), oCROptions != null ? oCROptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(oCROptions);
        return strGetOCRXmlFromPDF;
    }

    public static void applyOCRXmlToPDF(PDFDoc pDFDoc, String str) throws PDFNetException {
        ApplyOCRXmlToPDF(pDFDoc == null ? 0L : pDFDoc.__GetHandle(), str);
        ReachabilityHelper.ensureReachable(pDFDoc);
    }
}
