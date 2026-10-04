package com.pdftron.pdf;

import com.pdftron.filters.Filter;

/* JADX INFO: loaded from: classes7.dex */
public class DocumentPreviewCache {
    static native void CancelAllRequests();

    static native void CancelRequest(String str);

    static native void ClearCache();

    static native void CreateBitmapWithID(String str, long j, int i, int i2, PreviewHandler previewHandler, Object obj);

    static native void CreateBitmapWithIDFilter(String str, long j, int i, int i2, PreviewHandler previewHandler, Object obj);

    static native void GetBitmapWithID(String str, int i, int i2, PreviewHandler previewHandler, Object obj);

    static native void GetBitmapWithIDFilter(String str, long j, int i, int i2, PreviewHandler previewHandler, Object obj);

    static native void GetBitmapWithPath(String str, int i, int i2, PreviewHandler previewHandler, Object obj);

    static native void Initialize(long j, double d);

    static native void IrrelevantChangeMade(String str);

    public static void initialize(long j, double d) {
        Initialize(j, d);
    }

    public static void getBitmapWithPath(String str, int i, int i2, PreviewHandler previewHandler, Object obj) {
        GetBitmapWithPath(str, i, i2, previewHandler, obj);
    }

    public static void getBitmapWithID(String str, int i, int i2, PreviewHandler previewHandler, Object obj) {
        GetBitmapWithID(str, i, i2, previewHandler, obj);
    }

    public static void getBitmapWithID(String str, Filter filter, int i, int i2, PreviewHandler previewHandler, Object obj) {
        GetBitmapWithIDFilter(str, filter.__GetHandle(), i, i2, previewHandler, obj);
    }

    public static void createBitmapWithID(String str, PDFDoc pDFDoc, int i, int i2, PreviewHandler previewHandler, Object obj) {
        CreateBitmapWithID(str, pDFDoc.__GetHandle(), i, i2, previewHandler, obj);
    }

    public static void createBitmapWithID(String str, Filter filter, int i, int i2, PreviewHandler previewHandler, Object obj) {
        CreateBitmapWithIDFilter(str, filter.__GetHandle(), i, i2, previewHandler, obj);
    }

    public static void cancelAllRequests() {
        CancelAllRequests();
    }

    public static void cancelRequest(String str) {
        CancelRequest(str);
    }

    public static void irrelevantChangeMade(String str) {
        IrrelevantChangeMade(str);
    }

    public static void clearCache() {
        ClearCache();
    }
}
