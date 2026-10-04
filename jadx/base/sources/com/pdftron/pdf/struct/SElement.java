package com.pdftron.pdf.struct;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class SElement implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f2169a;

    /* JADX INFO: renamed from: b */
    private Object f2170b;

    static native void Destroy(long j);

    static native String GetActualText(long j);

    static native String GetAlt(long j);

    static native long GetAsContentItem(long j, int i);

    static native long GetAsStructElem(long j, int i);

    static native long GetID(long j);

    static native int GetNumKids(long j);

    static native long GetParent(long j);

    static native long GetSDFObj(long j);

    static native long GetStructTreeRoot(long j);

    static native String GetTitle(long j);

    static native String GetType(long j);

    static native boolean HasActualText(long j);

    static native boolean HasAlt(long j);

    static native boolean HasTitle(long j);

    static native boolean IsContentItem(long j, int i);

    static native boolean IsValid(long j);

    static native long SElementCreate(long j);

    public SElement() throws PDFNetException {
        this.f2169a = SElementCreate(0L);
    }

    public SElement(Obj obj) throws PDFNetException {
        this.f2169a = SElementCreate(obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f2169a);
    }

    public String getType() throws PDFNetException {
        return GetType(this.f2169a);
    }

    public int getNumKids() throws PDFNetException {
        return GetNumKids(this.f2169a);
    }

    public boolean isContentItem(int i) throws PDFNetException {
        return IsContentItem(this.f2169a, i);
    }

    public ContentItem getAsContentItem(int i) throws PDFNetException {
        return new ContentItem(GetAsContentItem(this.f2169a, i), this.f2170b);
    }

    public SElement getAsStructElem(int i) throws PDFNetException {
        return new SElement(GetAsStructElem(this.f2169a, i), this.f2170b);
    }

    public SElement getParent() throws PDFNetException {
        return new SElement(GetParent(this.f2169a), this.f2170b);
    }

    public STree getStructTreeRoot() throws PDFNetException {
        return new STree(GetStructTreeRoot(this.f2169a), this.f2170b);
    }

    public boolean hasTitle() throws PDFNetException {
        return HasTitle(this.f2169a);
    }

    public String getTitle() throws PDFNetException {
        return GetTitle(this.f2169a);
    }

    public Obj getID() throws PDFNetException {
        return Obj.__Create(GetID(this.f2169a), this.f2170b);
    }

    public boolean hasActualText() throws PDFNetException {
        return HasActualText(this.f2169a);
    }

    public String getActualText() throws PDFNetException {
        return GetActualText(this.f2169a);
    }

    public boolean hasAlt() throws PDFNetException {
        return HasAlt(this.f2169a);
    }

    public String getAlt() throws PDFNetException {
        return GetAlt(this.f2169a);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(GetSDFObj(this.f2169a), this.f2170b);
    }

    public void destroy() throws PDFNetException {
        long j = this.f2169a;
        if (j != 0) {
            Destroy(j);
            this.f2169a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public static SElement __Create(long j, Object obj) {
        return new SElement(j, obj);
    }

    SElement(long j, Object obj) {
        this.f2169a = j;
        this.f2170b = obj;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
