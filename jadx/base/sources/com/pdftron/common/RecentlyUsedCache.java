package com.pdftron.common;

import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.PDFDoc;

/* JADX INFO: loaded from: classes7.dex */
public class RecentlyUsedCache {

    /* JADX INFO: renamed from: a */
    private static volatile boolean f1384a = false;

    static native void AccessDocument(String str);

    static native void AccessDocument(String str, long j);

    static native String GetBitmapPathIfExists(String str);

    static native void InitializeRecentlyUsedCache(long j, long j2, double d);

    static native void RemoveDocument(String str);

    static native void RenameDocument(String str, String str2);

    static native void ResetCache();

    public static boolean hasBeenInitialized() {
        return f1384a;
    }

    public static void removeDocument(String str) {
        RemoveDocument(str);
    }

    public static void renameDocument(String str, String str2) {
        RenameDocument(str, str2);
    }

    public static void accessDocument(String str) {
        AccessDocument(str);
    }

    public static void accessDocument(String str, PDFDoc pDFDoc) {
        AccessDocument(str, pDFDoc.__GetHandle());
        ReachabilityHelper.ensureReachable(pDFDoc);
    }

    public static String getBitmapPathIfExists(String str) {
        return GetBitmapPathIfExists(str);
    }

    public static void resetCache() {
        ResetCache();
    }

    public static void initializeRecentlyUsedCache(long j, long j2, double d) throws PDFNetException {
        f1384a = true;
        InitializeRecentlyUsedCache(j, j2, d);
    }
}
