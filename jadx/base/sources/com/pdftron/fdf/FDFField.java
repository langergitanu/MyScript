package com.pdftron.fdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class FDFField implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1397a;

    /* JADX INFO: renamed from: b */
    private Object f1398b;

    static native void Destroy(long j);

    static native long FDFFieldCreate(long j, long j2);

    static native long FindAttribute(long j, String str);

    static native String GetName(long j);

    static native String GetPartialName(long j);

    static native long GetSDFObj(long j);

    static native long GetValue(long j);

    static native void SetValue(long j, long j2);

    public FDFField(Obj obj, Obj obj2) throws PDFNetException {
        this.f1397a = FDFFieldCreate(obj.__GetHandle(), obj2.__GetHandle());
        this.f1398b = obj.__GetRefHandle();
        ReachabilityHelper.ensureReachable(obj);
        ReachabilityHelper.ensureReachable(obj2);
    }

    public void destroy() throws PDFNetException {
        long j = this.f1397a;
        if (j != 0) {
            Destroy(j);
            this.f1397a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public Obj getValue() throws PDFNetException {
        return Obj.__Create(GetValue(this.f1397a), this.f1398b);
    }

    public void setValue(Obj obj) throws PDFNetException {
        SetValue(this.f1397a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public String getName() throws PDFNetException {
        return GetName(this.f1397a);
    }

    public String getPartialName() throws PDFNetException {
        return GetPartialName(this.f1397a);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(GetSDFObj(this.f1397a), this.f1398b);
    }

    public Obj findAttribute(String str) throws PDFNetException {
        return Obj.__Create(FindAttribute(this.f1397a, str), this.f1398b);
    }

    FDFField(long j, Object obj) {
        this.f1397a = j;
        this.f1398b = obj;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
