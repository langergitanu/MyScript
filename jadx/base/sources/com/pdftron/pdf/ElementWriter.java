package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class ElementWriter extends AbstractC6968g implements AutoCloseable {
    public static final int e_overlay = 1;
    public static final int e_replacement = 2;
    public static final int e_underlay = 0;

    /* JADX INFO: renamed from: a */
    private long f1537a = ElementWriterCreate();

    /* JADX INFO: renamed from: d */
    private Object f1538d = null;

    static native void Begin(long j, long j2, int i, boolean z, boolean z2, long j3);

    static native void Begin(long j, long j2, boolean z);

    static native void BeginObj(long j, long j2, boolean z, long j3);

    static native void Destroy(long j);

    static native long ElementWriterCreate();

    static native long End(long j);

    static native void Flush(long j);

    static native void SetDefaultGState(long j, long j2);

    static native void WriteBuffer(long j, byte[] bArr);

    static native void WriteElement(long j, long j2);

    static native void WriteGStateChanges(long j, long j2);

    static native void WritePlacedElement(long j, long j2);

    static native void WriteString(long j, String str);

    @Override // com.pdftron.pdf.AbstractC6968g, com.pdftron.pdf.__Delete
    public void destroy() throws PDFNetException {
        long j = this.f1537a;
        if (j != 0) {
            Destroy(j);
            this.f1537a = 0L;
        }
    }

    public void begin(Page page) throws PDFNetException {
        Begin(this.f1537a, page.f1990a, 1, true, true, 0L);
        this.f1538d = page.f1991b;
    }

    public void begin(Page page, int i) throws PDFNetException {
        Begin(this.f1537a, page.f1990a, i, true, true, 0L);
        this.f1538d = page.f1991b;
    }

    public void begin(Page page, int i, boolean z) throws PDFNetException {
        Begin(this.f1537a, page.f1990a, i, z, true, 0L);
        this.f1538d = page.f1991b;
    }

    public void begin(Page page, int i, boolean z, boolean z2) throws PDFNetException {
        Begin(this.f1537a, page.f1990a, i, z, z2, 0L);
        this.f1538d = page.f1991b;
    }

    public void begin(Page page, int i, boolean z, boolean z2, Obj obj) throws PDFNetException {
        Begin(this.f1537a, page.f1990a, i, z, z2, obj.__GetHandle());
        this.f1538d = page.f1991b;
        ReachabilityHelper.ensureReachable(obj);
    }

    public void begin(Obj obj) throws PDFNetException {
        BeginObj(this.f1537a, obj.__GetHandle(), true, 0L);
        this.f1538d = obj;
    }

    public void begin(Obj obj, boolean z) throws PDFNetException {
        BeginObj(this.f1537a, obj.__GetHandle(), z, 0L);
        this.f1538d = obj;
    }

    public void begin(Obj obj, boolean z, Obj obj2) throws PDFNetException {
        BeginObj(this.f1537a, obj.__GetHandle(), z, obj2.__GetHandle());
        this.f1538d = obj;
        ReachabilityHelper.ensureReachable(obj2);
    }

    public void begin(Doc doc) throws PDFNetException {
        Begin(this.f1537a, doc.__GetHandle(), true);
        this.f1538d = doc;
    }

    public void begin(Doc doc, boolean z) throws PDFNetException {
        Begin(this.f1537a, doc.__GetHandle(), z);
        this.f1538d = doc;
    }

    public Obj end() throws PDFNetException {
        return Obj.__Create(End(this.f1537a), this.f1538d);
    }

    public void writeElement(Element element) throws PDFNetException {
        WriteElement(this.f1537a, element.f1533a);
        ReachabilityHelper.ensureReachable(element);
    }

    public void writePlacedElement(Element element) throws PDFNetException {
        WritePlacedElement(this.f1537a, element.f1533a);
        ReachabilityHelper.ensureReachable(element);
    }

    public void flush() throws PDFNetException {
        Flush(this.f1537a);
    }

    public void writeBuffer(byte[] bArr) throws PDFNetException {
        WriteBuffer(this.f1537a, bArr);
    }

    public void writeString(String str) throws PDFNetException {
        WriteString(this.f1537a, str);
    }

    public void writeGStateChanges(Element element) throws PDFNetException {
        WriteGStateChanges(this.f1537a, element.f1533a);
        ReachabilityHelper.ensureReachable(element);
    }

    public void setDefaultGState(ElementReader elementReader) throws PDFNetException {
        SetDefaultGState(this.f1537a, elementReader.f2149c);
        ReachabilityHelper.ensureReachable(elementReader);
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
