package com.pdftron.pdf;

/* JADX INFO: loaded from: classes7.dex */
public class TextRange implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f2071a;

    static native void Delete(long j);

    static native int GetPageNumber(long j);

    static native double[] GetQuads(long j);

    static native String GetText(long j);

    static native String GetTextAfter(long j, int i);

    static native String GetTextBefore(long j, int i);

    static native long TextRangeCreate();

    public TextRange() {
        this.f2071a = TextRangeCreate();
    }

    public void destroy() {
        long j = this.f2071a;
        if (j != 0) {
            Delete(j);
            this.f2071a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public int getPageNumber() {
        return GetPageNumber(this.f2071a);
    }

    public double[] getQuads() {
        return GetQuads(this.f2071a);
    }

    public String getText() {
        return GetText(this.f2071a);
    }

    public String getTextBefore(int i) {
        return GetTextBefore(this.f2071a, i);
    }

    public String getTextAfter(int i) {
        return GetTextAfter(this.f2071a, i);
    }

    TextRange(long j, Object obj) {
        this.f2071a = j;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        destroy();
    }
}
