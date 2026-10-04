package com.pdftron.layout;

import com.pdftron.common.PDFNetException;
import com.pdftron.pdf.PDFDoc;

/* JADX INFO: loaded from: classes7.dex */
public class FlowDocument implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1421a = Create();

    static native long AddList(long j) throws PDFNetException;

    static native long AddParagraph(long j) throws PDFNetException;

    static native long AddTable(long j) throws PDFNetException;

    static native long Create() throws PDFNetException;

    static native void Destroy(long j) throws PDFNetException;

    static native long GetBody(long j) throws PDFNetException;

    static native long PaginateToPDF(long j) throws PDFNetException;

    static native void SetDefaultMargins(long j, double d, double d2, double d3, double d4) throws PDFNetException;

    static native void SetDefaultPageSize(long j, double d, double d2) throws PDFNetException;

    public void destroy() throws PDFNetException {
        long j = this.f1421a;
        if (j != 0) {
            Destroy(j);
            this.f1421a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public Paragraph addParagraph() throws PDFNetException {
        return new Paragraph(AddParagraph(this.f1421a));
    }

    public Paragraph addParagraph(String str) throws PDFNetException {
        Paragraph paragraph = new Paragraph(AddParagraph(this.f1421a));
        paragraph.addText(str);
        return paragraph;
    }

    public Table addTable() throws PDFNetException {
        return new Table(AddTable(this.f1421a));
    }

    public List addList() throws PDFNetException {
        return new List(AddList(this.f1421a));
    }

    public void setDefaultMargins(double d, double d2, double d3, double d4) throws PDFNetException {
        SetDefaultMargins(this.f1421a, d, d2, d3, d4);
    }

    public void setDefaultPageSize(double d, double d2) throws PDFNetException {
        SetDefaultPageSize(this.f1421a, d, d2);
    }

    public PDFDoc paginateToPDF() throws PDFNetException {
        return PDFDoc.__Create(PaginateToPDF(this.f1421a));
    }

    public ContentNode getBody() throws PDFNetException {
        return new ContentNode(GetBody(this.f1421a));
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
