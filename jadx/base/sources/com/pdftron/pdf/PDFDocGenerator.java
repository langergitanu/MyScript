package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class PDFDocGenerator {
    static native long GenerateBlankPaperDoc(double d, double d2, double d3, double d4, double d5);

    static native long GenerateDottedPaperDoc(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10);

    static native long GenerateGraphPaperDoc(double d, double d2, double d3, double d4, double d5, int i, double d6, double d7, double d8, double d9, double d10, double d11);

    static native long GenerateGridPaperDoc(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10);

    static native long GenerateIsometricDottedPaperDoc(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10);

    static native long GenerateLinedPaperDoc(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19);

    static native long GenerateMusicPaperDoc(double d, double d2, double d3, int i, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11);

    private PDFDocGenerator() {
    }

    public static PDFDoc generateBlankPaperDoc(double d, double d2, double d3, double d4, double d5) throws PDFNetException {
        return PDFDoc.__Create(GenerateBlankPaperDoc(d, d2, d3, d4, d5));
    }

    public static PDFDoc generateGridPaperDoc(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) throws PDFNetException {
        return PDFDoc.__Create(GenerateGridPaperDoc(d, d2, d3, d4, d5, d6, d7, d8, d9, d10));
    }

    public static PDFDoc generateLinedPaperDoc(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19) throws PDFNetException {
        return PDFDoc.__Create(GenerateLinedPaperDoc(d, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17, d18, d19));
    }

    public static PDFDoc generateGraphPaperDoc(double d, double d2, double d3, double d4, double d5, int i, double d6, double d7, double d8, double d9, double d10, double d11) throws PDFNetException {
        return PDFDoc.__Create(GenerateGraphPaperDoc(d, d2, d3, d4, d5, i, d6, d7, d8, d9, d10, d11));
    }

    public static PDFDoc generateMusicPaperDoc(double d, double d2, double d3, int i, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11) throws PDFNetException {
        return PDFDoc.__Create(GenerateMusicPaperDoc(d, d2, d3, i, d4, d5, d6, d7, d8, d9, d10, d11));
    }

    public static PDFDoc generateDottedPaperDoc(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        return PDFDoc.__Create(GenerateDottedPaperDoc(d, d2, d3, d4, d5, d6, d7, d8, d9, d10));
    }

    public static PDFDoc generateIsometricDottedPaperDoc(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        return PDFDoc.__Create(GenerateIsometricDottedPaperDoc(d, d2, d3, d4, d5, d6, d7, d8, d9, d10));
    }
}
