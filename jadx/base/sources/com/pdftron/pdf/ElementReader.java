package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.ocg.Context;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class ElementReader extends AbstractC6968g implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private Object f1536a;

    static native void Begin1(long j, long j2);

    static native void Begin2(long j, long j2, long j3);

    static native void BeginStm1(long j, long j2);

    static native void BeginStm2(long j, long j2, long j3);

    static native void BeginStm3(long j, long j2, long j3, long j4);

    static native void ClearChangeList(long j);

    static native long Current(long j);

    static native void Destroy(long j);

    static native long ElementReaderCreate();

    static native boolean End(long j);

    static native void FormBegin(long j);

    static native long GetChangesIterator(long j);

    static native long GetColorSpace(long j, String str);

    static native long GetExtGState(long j, String str);

    static native long GetFont(long j, String str);

    static native long GetPattern(long j, String str);

    static native long GetShading(long j, String str);

    static native long GetXObject(long j, String str);

    static native boolean IsChanged(long j, int i);

    static native long Next(long j);

    static native void PatternBegin(long j, boolean z, boolean z2);

    static native void Type3FontBegin(long j, long j2, long j3);

    public ElementReader() throws PDFNetException {
        this.f2149c = ElementReaderCreate();
        this.f1536a = null;
        clearList();
    }

    @Override // com.pdftron.pdf.AbstractC6968g, com.pdftron.pdf.__Delete
    public void destroy() throws PDFNetException {
        if (this.f2149c != 0) {
            Destroy(this.f2149c);
            this.f2149c = 0L;
        }
    }

    public void begin(Page page) throws PDFNetException {
        Begin1(this.f2149c, page.f1990a);
        this.f1536a = page.f1991b;
    }

    public void begin(Page page, Context context) throws PDFNetException {
        Begin2(this.f2149c, page.f1990a, context.__GetHandle());
        this.f1536a = page.f1991b;
    }

    public void begin(Obj obj) throws PDFNetException {
        BeginStm1(this.f2149c, obj.__GetHandle());
        this.f1536a = obj.__GetRefHandle();
    }

    public void begin(Obj obj, Obj obj2) throws PDFNetException {
        BeginStm2(this.f2149c, obj.__GetHandle(), obj2.__GetHandle());
        this.f1536a = obj.__GetRefHandle();
        ReachabilityHelper.ensureReachable(obj2);
    }

    public void begin(Obj obj, Obj obj2, Context context) throws PDFNetException {
        BeginStm3(this.f2149c, obj.__GetHandle(), obj2.__GetHandle(), context.__GetHandle());
        this.f1536a = obj.__GetRefHandle();
        ReachabilityHelper.ensureReachable(obj2);
    }

    public Element next() throws PDFNetException {
        long jNext = Next(this.f2149c);
        if (jNext != 0) {
            return new Element(jNext, this, this.f1536a);
        }
        return null;
    }

    public Element current() throws PDFNetException {
        long jCurrent = Current(this.f2149c);
        if (jCurrent != 0) {
            return new Element(jCurrent, this, this.f1536a);
        }
        return null;
    }

    public void formBegin() throws PDFNetException {
        FormBegin(this.f2149c);
    }

    public void patternBegin(boolean z, boolean z2) throws PDFNetException {
        PatternBegin(this.f2149c, z, z2);
    }

    public void patternBegin(boolean z) throws PDFNetException {
        PatternBegin(this.f2149c, z, false);
    }

    public void type3FontBegin(CharData charData, Obj obj) throws PDFNetException {
        if (obj != null) {
            Type3FontBegin(this.f2149c, charData.f1456a, obj.__GetHandle());
            ReachabilityHelper.ensureReachable(obj);
        } else {
            Type3FontBegin(this.f2149c, charData.f1456a, 0L);
        }
        ReachabilityHelper.ensureReachable(charData);
    }

    public void type3FontBegin(CharData charData) throws PDFNetException {
        Type3FontBegin(this.f2149c, charData.f1456a, 0L);
        ReachabilityHelper.ensureReachable(charData);
    }

    public boolean end() throws PDFNetException {
        return End(this.f2149c);
    }

    public GSChangesIterator getChangesIterator() throws PDFNetException {
        return new GSChangesIterator(GetChangesIterator(this.f2149c), this.f1536a);
    }

    public boolean isChanged(int i) throws PDFNetException {
        return IsChanged(this.f2149c, i);
    }

    public void clearChangeList() throws PDFNetException {
        ClearChangeList(this.f2149c);
    }

    public Obj getFont(String str) throws PDFNetException {
        return Obj.__Create(GetFont(this.f2149c, str), this.f1536a);
    }

    public Obj getXObject(String str) {
        return Obj.__Create(GetXObject(this.f2149c, str), this.f1536a);
    }

    public Obj getShading(String str) {
        return Obj.__Create(GetShading(this.f2149c, str), this.f1536a);
    }

    public Obj getColorSpace(String str) {
        return Obj.__Create(GetColorSpace(this.f2149c, str), this.f1536a);
    }

    public Obj getPattern(String str) {
        return Obj.__Create(GetPattern(this.f2149c, str), this.f1536a);
    }

    public Obj getExtGState(String str) {
        return Obj.__Create(GetExtGState(this.f2149c, str), this.f1536a);
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
