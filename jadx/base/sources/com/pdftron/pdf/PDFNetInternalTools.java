package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class PDFNetInternalTools {

    /* JADX INFO: renamed from: a */
    private static AnalyticsHandlerCallback f1634a = null;

    /* JADX INFO: renamed from: b */
    private static AssertHandlerCallback f1635b = null;
    public static final int e_callback = 2;
    public static final int e_console = 3;
    public static final int e_debug = 1;
    public static final int e_debugger = 0;
    public static final int e_disabled = 6;
    public static final int e_disk = 1;
    public static final int e_error = 4;
    public static final int e_fatal = 5;
    public static final int e_info = 2;
    public static final int e_trace = 0;
    public static final int e_warning = 3;

    static native boolean CheckDocIntegrity(long j);

    static native boolean ConfigureLogFromJsonString(String str);

    static native void DisableLogBackend(int i);

    static native boolean EnableLogBackend(int i);

    static native String GetDefaultConfigFile();

    static native String GetPDFViewTileSummary();

    static native boolean IsLogSystemAvailable();

    static native void LogMessage(int i, String str, String str2, int i2);

    static native void LogStreamMessage(int i, String str, String str2, String str3, int i2);

    static native String RunUniversalConversionTests(String str);

    static native void SetAnalyticsHandler(AnalyticsHandlerCallback analyticsHandlerCallback);

    static native void SetAssertHandler(AssertHandlerCallback assertHandlerCallback);

    static native void SetCutoffLogThreshold(int i);

    static native void SetDefaultLogThreshold(int i);

    static native boolean SetLogFileName(String str);

    static native boolean SetLogLocation(String str, String str2);

    static native void SetThresholdForLogStream(String str, int i);

    private PDFNetInternalTools() {
    }

    public static boolean isLogSystemAvailable() throws PDFNetException {
        return IsLogSystemAvailable();
    }

    public static boolean configureLogFromJsonString(String str) throws PDFNetException {
        return ConfigureLogFromJsonString(str);
    }

    public static String getDefaultConfigFile() throws PDFNetException {
        return GetDefaultConfigFile();
    }

    public static String runUniversalConversionTests(String str) throws PDFNetException {
        return RunUniversalConversionTests(str);
    }

    public static void logMessage(int i, String str, String str2, int i2) throws PDFNetException {
        LogMessage(i, str, str2, i2);
    }

    public static void logStreamMessage(int i, String str, String str2, String str3, int i2) throws PDFNetException {
        LogStreamMessage(i, str, str2, str3, i2);
    }

    public static boolean setLogLocation(String str, String str2) throws PDFNetException {
        return SetLogLocation(str, str2);
    }

    public static boolean setLogFileName(String str) throws PDFNetException {
        return SetLogFileName(str);
    }

    public static void setThresholdForLogStream(String str, int i) throws PDFNetException {
        SetThresholdForLogStream(str, i);
    }

    public static void setDefaultLogThreshold(int i) throws PDFNetException {
        SetDefaultLogThreshold(i);
    }

    public static void setCutoffLogThreshold(int i) throws PDFNetException {
        SetCutoffLogThreshold(i);
    }

    public static boolean enableLogBackend(int i) throws PDFNetException {
        return EnableLogBackend(i);
    }

    public static void disableLogBackend(int i) throws PDFNetException {
        DisableLogBackend(i);
    }

    public static void setAnalyticsHandler(AnalyticsHandlerCallback analyticsHandlerCallback) throws PDFNetException {
        f1634a = analyticsHandlerCallback;
        SetAnalyticsHandler(analyticsHandlerCallback);
    }

    public static void setAssertHandler(AssertHandlerCallback assertHandlerCallback) throws PDFNetException {
        f1635b = assertHandlerCallback;
        SetAssertHandler(assertHandlerCallback);
    }

    public static String getPDFViewTileSummary() throws PDFNetException {
        return GetPDFViewTileSummary();
    }

    public static boolean checkDocIntegrity(PDFDoc pDFDoc) throws PDFNetException {
        boolean zCheckDocIntegrity = CheckDocIntegrity(pDFDoc.__GetHandle());
        ReachabilityHelper.ensureReachable(pDFDoc);
        return zCheckDocIntegrity;
    }
}
