package com.pdftron.pdf.struct;

import com.pdftron.common.PDFNetException;
import com.pdftron.pdf.Page;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class ContentItem implements AutoCloseable {
    public static final int e_MCID = 1;
    public static final int e_MCR = 0;
    public static final int e_OBJR = 2;
    public static final int e_Unknown = 3;

    /* JADX INFO: renamed from: a */
    private long f2165a;

    /* JADX INFO: renamed from: b */
    private Object f2166b;

    static native void Destroy(long j);

    static native long GetContainingStm(long j);

    static native int GetMCID(long j);

    static native long GetPage(long j);

    static native long GetParent(long j);

    static native long GetRefObj(long j);

    static native long GetSDFObj(long j);

    static native long GetStmOwner(long j);

    static native int GetType(long j);

    public void destroy() throws PDFNetException {
        long j = this.f2165a;
        if (j != 0) {
            Destroy(j);
            this.f2165a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public int getType() throws PDFNetException {
        return GetType(this.f2165a);
    }

    public SElement getParent() throws PDFNetException {
        return new SElement(GetParent(this.f2165a), this.f2166b);
    }

    public Page getPage() throws PDFNetException {
        return Page.__Create(GetPage(this.f2165a), this.f2166b);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(GetSDFObj(this.f2165a), this.f2166b);
    }

    public int getMCID() throws PDFNetException {
        return GetMCID(this.f2165a);
    }

    public Obj getContainingStm() throws PDFNetException {
        return Obj.__Create(GetContainingStm(this.f2165a), this.f2166b);
    }

    public Obj getStmOwner() throws PDFNetException {
        return Obj.__Create(GetStmOwner(this.f2165a), this.f2166b);
    }

    public Obj getRefObj() throws PDFNetException {
        return Obj.__Create(GetRefObj(this.f2165a), this.f2166b);
    }

    ContentItem(long j, Object obj) {
        this.f2165a = j;
        this.f2166b = obj;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
