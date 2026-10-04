package com.pdftron.pdf;

/* JADX INFO: loaded from: classes7.dex */
public class ReflowProcessor {
    static native void CancelAllRequests();

    static native void CancelRequest(long j);

    static native void ClearCache();

    static native void GetReflow(long j, RequestHandler requestHandler, Object obj);

    static native void Initialize();

    static native boolean IsInitialized();

    static native void SetNoReflowContent(String str);

    static native void SetReflowFailedContent(String str);

    public static void initialize() {
        Initialize();
    }

    public static void initialize(String str, String str2) {
        Initialize();
        SetNoReflowContent(str);
        SetReflowFailedContent(str2);
    }

    public static boolean isInitialized() {
        return IsInitialized();
    }

    public static void cancelAllRequests() {
        CancelAllRequests();
    }

    public static void cancelRequest(Page page) {
        CancelRequest(page.__GetHandle());
    }

    public static void clearCache() {
        ClearCache();
    }

    public static void getReflow(Page page, RequestHandler requestHandler, Object obj) {
        GetReflow(page.__GetHandle(), requestHandler, obj);
    }

    public static void setNoReflowContent(String str) {
        SetNoReflowContent(str);
    }

    public static void setReflowFailedContent(String str) {
        SetReflowFailedContent(str);
    }
}
