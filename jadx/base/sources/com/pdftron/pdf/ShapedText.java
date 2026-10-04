package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class ShapedText implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f2053a;

    static native void Destroy(long j);

    static native int GetFailureReason(long j);

    static native int GetGlyph(long j, int i);

    static native double GetGlyphXPos(long j, int i);

    static native double GetGlyphYPos(long j, int i);

    static native int GetNumGlyphs(long j);

    static native double GetScale(long j);

    static native int GetShapingStatus(long j);

    static native String GetText(long j);

    public class ShapingStatus {
        public static final int e_full_shaping = 0;
        public static final int e_no_shaping = 2;
        public static final int e_partial_shaping = 1;

        public ShapingStatus(ShapedText shapedText) {
        }
    }

    public class FailureReason {
        public static final int e_font_data_not_found = 3;
        public static final int e_no_failure = 0;
        public static final int e_not_index_encoded = 2;
        public static final int e_unsupported_font_type = 1;

        public FailureReason(ShapedText shapedText) {
        }
    }

    public void destroy() throws PDFNetException {
        long j = this.f2053a;
        if (j != 0) {
            Destroy(j);
            this.f2053a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public ShapedText(long j) {
        this.f2053a = j;
    }

    public double getScale() throws PDFNetException {
        return GetScale(this.f2053a);
    }

    public int getShapingStatus() throws PDFNetException {
        return GetShapingStatus(this.f2053a);
    }

    public int getFailureReason() throws PDFNetException {
        return GetFailureReason(this.f2053a);
    }

    public String getText() throws PDFNetException {
        return GetText(this.f2053a);
    }

    public int getNumGlyphs() throws PDFNetException {
        return GetNumGlyphs(this.f2053a);
    }

    public int getGlyph(int i) throws PDFNetException {
        return GetGlyph(this.f2053a, i);
    }

    public double getGlyphXPos(int i) throws PDFNetException {
        return GetGlyphXPos(this.f2053a, i);
    }

    public double getGlyphYPos(int i) throws PDFNetException {
        return GetGlyphYPos(this.f2053a, i);
    }

    public long __GetHandle() {
        return this.f2053a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
