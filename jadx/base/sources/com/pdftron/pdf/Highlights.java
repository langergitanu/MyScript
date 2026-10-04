package com.pdftron.pdf;

import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class Highlights implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    long f1566a;

    /* JADX INFO: renamed from: b */
    Object f1567b;

    static native void Add(long j, long j2);

    static native void Begin(long j, long j2);

    static native void Clear(long j);

    static native void Delete(long j);

    static native int GetCurrentPageNumber(long j);

    static native double[] GetCurrentQuads(long j);

    static native long GetCurrentTextRange(long j);

    static native boolean HasNext(long j);

    static native long HighlightsCreate();

    static native void Load(long j, String str);

    static native void Next(long j);

    static native void Save(long j, String str);

    static native String SaveToString(long j);

    public Highlights() {
        this.f1567b = null;
        this.f1566a = HighlightsCreate();
    }

    public void destroy() {
        long j = this.f1566a;
        if (j != 0) {
            Delete(j);
            this.f1566a = 0L;
            this.f1567b = null;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public void load(String str) {
        Load(this.f1566a, str);
    }

    public void save(String str) {
        Save(this.f1566a, str);
    }

    public String saveToString() {
        return SaveToString(this.f1566a);
    }

    public void add(Highlights highlights) {
        Add(this.f1566a, highlights.f1566a);
        ReachabilityHelper.ensureReachable(highlights);
    }

    public void clear() {
        Clear(this.f1566a);
    }

    public void begin(PDFDoc pDFDoc) {
        Begin(this.f1566a, pDFDoc.__GetHandle());
        ReachabilityHelper.ensureReachable(pDFDoc);
    }

    public boolean hasNext() {
        return HasNext(this.f1566a);
    }

    public void next() {
        Next(this.f1566a);
    }

    public int getCurrentPageNumber() {
        return GetCurrentPageNumber(this.f1566a);
    }

    public double[] getCurrentQuads() {
        return GetCurrentQuads(this.f1566a);
    }

    public TextRange getCurrentTextRange() {
        return new TextRange(GetCurrentTextRange(this.f1566a), this.f1567b);
    }

    public Highlights(long j) {
        this.f1567b = null;
        this.f1566a = j;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        destroy();
    }
}
