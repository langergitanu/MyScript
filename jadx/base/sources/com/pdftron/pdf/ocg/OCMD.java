package com.pdftron.pdf.ocg;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.PDFDoc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class OCMD {
    public static final int e_AllOff = 3;
    public static final int e_AllOn = 0;
    public static final int e_AnyOff = 2;
    public static final int e_AnyOn = 1;

    /* JADX INFO: renamed from: a */
    private long f2157a;

    /* JADX INFO: renamed from: b */
    private Object f2158b;

    static native long Create(long j, long j2, int i);

    static native long GetOCGs(long j);

    static native long GetVisibilityExpression(long j);

    static native int GetVisibilityPolicy(long j);

    static native boolean IsValid(long j);

    static native void SetVisibilityPolicy(long j, int i);

    public static OCMD create(PDFDoc pDFDoc, Obj obj, int i) throws PDFNetException {
        OCMD ocmd = new OCMD(Create(pDFDoc.__GetHandle(), obj.__GetHandle(), i), pDFDoc);
        ReachabilityHelper.ensureReachable(obj);
        return ocmd;
    }

    public OCMD(Obj obj) {
        this.f2157a = obj.__GetHandle();
        this.f2158b = obj.__GetRefHandle();
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f2157a);
    }

    public Obj getOCGs() throws PDFNetException {
        return Obj.__Create(GetOCGs(this.f2157a), this.f2158b);
    }

    public int getVisibilityPolicy() throws PDFNetException {
        return GetVisibilityPolicy(this.f2157a);
    }

    public void setVisibilityPolicy(int i) throws PDFNetException {
        SetVisibilityPolicy(this.f2157a, i);
    }

    public Obj getVisibilityExpression() throws PDFNetException {
        return Obj.__Create(GetVisibilityExpression(this.f2157a), this.f2158b);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(this.f2157a, this.f2158b);
    }

    public static OCMD __Create(long j, Object obj) {
        return new OCMD(j, obj);
    }

    private OCMD(long j, Object obj) {
        this.f2157a = j;
        this.f2158b = obj;
    }
}
