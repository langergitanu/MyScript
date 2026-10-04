package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class ContentReplacer implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1461a = ContentReplacerCreate();

    static native void AddImage(long j, long j2, long j3);

    static native void AddString(long j, String str, String str2);

    static native void AddText(long j, long j2, String str);

    static native long ContentReplacerCreate();

    static native void ContentReplacerDestroy(long j);

    static native void Process(long j, long j2);

    static native void SetMatchStrings(long j, String str, String str2);

    public void addImage(Rect rect, Obj obj) throws PDFNetException {
        AddImage(this.f1461a, rect.f2037a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(rect);
        ReachabilityHelper.ensureReachable(obj);
    }

    public void addText(Rect rect, String str) throws PDFNetException {
        AddText(this.f1461a, rect.f2037a, str);
        ReachabilityHelper.ensureReachable(rect);
    }

    public void addString(String str, String str2) throws PDFNetException {
        AddString(this.f1461a, str, str2);
    }

    public void setMatchStrings(String str, String str2) throws PDFNetException {
        SetMatchStrings(this.f1461a, str, str2);
    }

    public void process(Page page) throws PDFNetException {
        Process(this.f1461a, page.f1990a);
        ReachabilityHelper.ensureReachable(page);
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public void destroy() {
        long j = this.f1461a;
        if (j != 0) {
            ContentReplacerDestroy(j);
            this.f1461a = 0L;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
