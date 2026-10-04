package com.pdftron.pdf;

import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class ElementBuilder extends AbstractC6968g implements AutoCloseable {
    static native void ArcTo(long j, double d, double d2, double d3, double d4, double d5, double d6);

    static native void ArcTo(long j, double d, double d2, double d3, boolean z, boolean z2, double d4, double d5);

    static native void ClosePath(long j);

    static native long CreateEllipse(long j, double d, double d2, double d3, double d4);

    static native long CreateForm(long j, long j2);

    static native long CreateForm(long j, long j2, long j3);

    static native long CreateFormObj(long j, long j2);

    static native long CreateGroupBegin(long j);

    static native long CreateGroupEnd(long j);

    static native long CreateImage(long j, long j2);

    static native long CreateImage(long j, long j2, double d, double d2, double d3, double d4);

    static native long CreateImage(long j, long j2, long j3);

    static native long CreateMarkedContentBegin(long j, String str, long j2);

    static native long CreateMarkedContentBeginInlineProperties(long j, String str);

    static native long CreateMarkedContentEnd(long j);

    static native long CreateMarkedContentPoint(long j, String str, long j2);

    static native long CreateMarkedContentPointInlineProperties(long j, String str);

    static native long CreatePath(long j, double[] dArr, byte[] bArr);

    static native long CreateRect(long j, double d, double d2, double d3, double d4);

    static native long CreateShading(long j, long j2);

    static native long CreateShapedTextRun(long j, long j2);

    static native long CreateTextBegin(long j);

    static native long CreateTextBegin(long j, long j2, double d);

    static native long CreateTextEnd(long j);

    static native long CreateTextNewLine(long j);

    static native long CreateTextNewLine(long j, double d, double d2);

    static native long CreateTextRun(long j, String str);

    static native long CreateTextRun(long j, String str, long j2, double d);

    static native long CreateUnicodeTextRun(long j, String str);

    static native void CurveTo(long j, double d, double d2, double d3, double d4, double d5, double d6);

    static native void Destroy(long j);

    static native long ElementBuilderCreate();

    static native void Ellipse(long j, double d, double d2, double d3, double d4);

    static native void LineTo(long j, double d, double d2);

    static native void MoveTo(long j, double d, double d2);

    static native void PathBegin(long j);

    static native long PathEnd(long j);

    static native void Rect(long j, double d, double d2, double d3, double d4);

    static native void Reset(long j, long j2);

    public ElementBuilder() throws PDFNetException {
        this.f2149c = ElementBuilderCreate();
        clearList();
    }

    @Override // com.pdftron.pdf.AbstractC6968g, com.pdftron.pdf.__Delete
    public void destroy() throws PDFNetException {
        if (this.f2149c != 0) {
            Destroy(this.f2149c);
            this.f2149c = 0L;
        }
    }

    public void reset() throws PDFNetException {
        Reset(this.f2149c, 0L);
    }

    public void reset(GState gState) throws PDFNetException {
        Reset(this.f2149c, gState.f1562a);
        ReachabilityHelper.ensureReachable(gState);
    }

    public Element createImage(Image image) throws PDFNetException {
        return new Element(CreateImage(this.f2149c, image.f1568a), this, image.f1569b);
    }

    public Element createImage(Image image, Matrix2D matrix2D) throws PDFNetException {
        Element element = new Element(CreateImage(this.f2149c, image.f1568a, matrix2D.__GetHandle()), this, image.f1569b);
        ReachabilityHelper.ensureReachable(matrix2D);
        return element;
    }

    public Element createImage(Image image, double d, double d2, double d3, double d4) throws PDFNetException {
        return new Element(CreateImage(this.f2149c, image.f1568a, d, d2, d3, d4), this, image.f1569b);
    }

    public Element createGroupBegin() throws PDFNetException {
        return new Element(CreateGroupBegin(this.f2149c), this, null);
    }

    public Element createGroupEnd() throws PDFNetException {
        return new Element(CreateGroupEnd(this.f2149c), this, null);
    }

    public Element createShading(Shading shading) throws PDFNetException {
        return new Element(CreateShading(this.f2149c, shading.f2051a), this, shading.f2052b);
    }

    public Element createForm(Obj obj) throws PDFNetException {
        Element element = new Element(CreateFormObj(this.f2149c, obj.__GetHandle()), this, obj.__GetRefHandle());
        ReachabilityHelper.ensureReachable(obj);
        return element;
    }

    public Element createForm(Page page) throws PDFNetException {
        return new Element(CreateForm(this.f2149c, page.f1990a), this, page.f1991b);
    }

    public Element createForm(Page page, PDFDoc pDFDoc) throws PDFNetException {
        Element element = new Element(CreateForm(this.f2149c, page.f1990a, pDFDoc.__GetHandle()), this, pDFDoc);
        ReachabilityHelper.ensureReachable(page);
        return element;
    }

    public Element createTextBegin(Font font, double d) throws PDFNetException {
        return new Element(CreateTextBegin(this.f2149c, font.f1556a, d), this, font.f1557b);
    }

    public Element createTextBegin() throws PDFNetException {
        return new Element(CreateTextBegin(this.f2149c), this, null);
    }

    public Element createTextEnd() throws PDFNetException {
        return new Element(CreateTextEnd(this.f2149c), this, null);
    }

    public Element createTextRun(String str, Font font, double d) throws PDFNetException {
        return new Element(CreateTextRun(this.f2149c, str, font.f1556a, d), this, font.f1557b);
    }

    public Element createTextRun(String str) throws PDFNetException {
        return new Element(CreateTextRun(this.f2149c, str), this, null);
    }

    public Element createUnicodeTextRun(String str) throws PDFNetException {
        return new Element(CreateUnicodeTextRun(this.f2149c, str), this, null);
    }

    public Element createShapedTextRun(ShapedText shapedText) throws PDFNetException {
        Element element = new Element(CreateShapedTextRun(this.f2149c, shapedText.__GetHandle()), this, null);
        ReachabilityHelper.ensureReachable(shapedText);
        return element;
    }

    public Element createTextNewLine(double d, double d2) throws PDFNetException {
        return new Element(CreateTextNewLine(this.f2149c, d, d2), this, null);
    }

    public Element createTextNewLine() throws PDFNetException {
        return new Element(CreateTextNewLine(this.f2149c), this, null);
    }

    public Element createPath(double[] dArr, byte[] bArr) throws PDFNetException {
        return new Element(CreatePath(this.f2149c, dArr, bArr), this, null);
    }

    public Element createRect(double d, double d2, double d3, double d4) throws PDFNetException {
        return new Element(CreateRect(this.f2149c, d, d2, d3, d4), this, null);
    }

    public Element createEllipse(double d, double d2, double d3, double d4) throws PDFNetException {
        return new Element(CreateEllipse(this.f2149c, d, d2, d3, d4), this, null);
    }

    public void pathBegin() throws PDFNetException {
        PathBegin(this.f2149c);
    }

    public Element pathEnd() throws PDFNetException {
        return new Element(PathEnd(this.f2149c), this, null);
    }

    public void rect(double d, double d2, double d3, double d4) throws PDFNetException {
        Rect(this.f2149c, d, d2, d3, d4);
    }

    public void moveTo(double d, double d2) throws PDFNetException {
        MoveTo(this.f2149c, d, d2);
    }

    public void lineTo(double d, double d2) throws PDFNetException {
        LineTo(this.f2149c, d, d2);
    }

    public void curveTo(double d, double d2, double d3, double d4, double d5, double d6) throws PDFNetException {
        CurveTo(this.f2149c, d, d2, d3, d4, d5, d6);
    }

    public void arcTo(double d, double d2, double d3, double d4, double d5, double d6) throws PDFNetException {
        ArcTo(this.f2149c, d, d2, d3, d4, d5, d6);
    }

    public void arcTo(double d, double d2, double d3, boolean z, boolean z2, double d4, double d5) throws PDFNetException {
        ArcTo(this.f2149c, d, d2, d3, z, z2, d4, d5);
    }

    public void ellipse(double d, double d2, double d3, double d4) throws PDFNetException {
        Ellipse(this.f2149c, d, d2, d3, d4);
    }

    public void closePath() throws PDFNetException {
        ClosePath(this.f2149c);
    }

    public Element createMarkedContentBeginInlineProperties(String str) throws PDFNetException {
        return new Element(CreateMarkedContentBeginInlineProperties(this.f2149c, str), this, null);
    }

    public Element createMarkedContentBegin(String str, Obj obj) throws PDFNetException {
        Element element = new Element(CreateMarkedContentBegin(this.f2149c, str, obj.__GetHandle()), this, null);
        ReachabilityHelper.ensureReachable(obj);
        return element;
    }

    public Element createMarkedContentEnd() throws PDFNetException {
        return new Element(CreateMarkedContentEnd(this.f2149c), this, null);
    }

    public Element createMarkedContentPointInlineProperties(String str) throws PDFNetException {
        return new Element(CreateMarkedContentPointInlineProperties(this.f2149c, str), this, null);
    }

    public Element createMarkedContentPoint(String str, Obj obj) throws PDFNetException {
        Element element = new Element(CreateMarkedContentPoint(this.f2149c, str, obj.__GetHandle()), this, null);
        ReachabilityHelper.ensureReachable(obj);
        return element;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
