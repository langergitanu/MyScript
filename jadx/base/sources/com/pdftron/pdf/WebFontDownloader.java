package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class WebFontDownloader {
    static native void ClearCache();

    static native void DisableDownloads();

    static native void EnableDownloads();

    static native boolean IsAvailable();

    static native void PreCacheAsync();

    static native void SetCustomWebFontURL(String str);

    private WebFontDownloader() {
    }

    public static boolean isAvailable() throws PDFNetException {
        return IsAvailable();
    }

    public static void enableDownloads() throws PDFNetException {
        EnableDownloads();
    }

    public static void disableDownloads() throws PDFNetException {
        DisableDownloads();
    }

    public static void preCacheAsync() throws PDFNetException {
        PreCacheAsync();
    }

    public static void clearCache() throws PDFNetException {
        ClearCache();
    }

    public static void setCustomWebFontURL(String str) throws PDFNetException {
        SetCustomWebFontURL(str);
    }
}
