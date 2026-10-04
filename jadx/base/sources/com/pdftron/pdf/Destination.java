package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Destination {
    public static final int e_Fit = 1;
    public static final int e_FitB = 5;
    public static final int e_FitBH = 6;
    public static final int e_FitBV = 7;
    public static final int e_FitH = 2;
    public static final int e_FitR = 4;
    public static final int e_FitV = 3;
    public static final int e_XYZ = 0;

    /* JADX INFO: renamed from: a */
    long f1516a;

    /* JADX INFO: renamed from: b */
    Object f1517b;

    static native long Create(long j);

    static native long CreateFit(long j);

    static native long CreateFitB(long j);

    static native long CreateFitBH(long j, double d);

    static native long CreateFitBV(long j, double d);

    static native long CreateFitH(long j, double d);

    static native long CreateFitR(long j, double d, double d2, double d3, double d4);

    static native long CreateFitV(long j, double d);

    static native long CreateXYZ(long j, double d, double d2, double d3);

    static native long GetExplicitDestObj(long j);

    static native int GetFitType(long j);

    static native long GetPage(long j);

    static native boolean IsValid(long j);

    static native void SetPage(long j, long j2);

    public static Destination createXYZ(Page page, double d, double d2, double d3) throws PDFNetException {
        Destination destination = new Destination(CreateXYZ(page.f1990a, d, d2, d3), page.f1991b);
        ReachabilityHelper.ensureReachable(page);
        return destination;
    }

    public static Destination createFit(Page page) throws PDFNetException {
        Destination destination = new Destination(CreateFit(page.f1990a), page.f1991b);
        ReachabilityHelper.ensureReachable(page);
        return destination;
    }

    public static Destination createFitH(Page page, double d) throws PDFNetException {
        Destination destination = new Destination(CreateFitH(page.f1990a, d), page.f1991b);
        ReachabilityHelper.ensureReachable(page);
        return destination;
    }

    public static Destination createFitV(Page page, double d) throws PDFNetException {
        Destination destination = new Destination(CreateFitV(page.f1990a, d), page.f1991b);
        ReachabilityHelper.ensureReachable(page);
        return destination;
    }

    public static Destination createFitR(Page page, double d, double d2, double d3, double d4) throws PDFNetException {
        Destination destination = new Destination(CreateFitR(page.f1990a, d, d2, d3, d4), page.f1991b);
        ReachabilityHelper.ensureReachable(page);
        return destination;
    }

    public static Destination createFitB(Page page) throws PDFNetException {
        Destination destination = new Destination(CreateFitB(page.f1990a), page.f1991b);
        ReachabilityHelper.ensureReachable(page);
        return destination;
    }

    public static Destination createFitBH(Page page, double d) throws PDFNetException {
        Destination destination = new Destination(CreateFitBH(page.f1990a, d), page.f1991b);
        ReachabilityHelper.ensureReachable(page);
        return destination;
    }

    public static Destination createFitBV(Page page, double d) throws PDFNetException {
        Destination destination = new Destination(CreateFitBV(page.f1990a, d), page.f1991b);
        ReachabilityHelper.ensureReachable(page);
        return destination;
    }

    public Destination(Obj obj) {
        this.f1516a = Create(obj.__GetHandle());
        this.f1517b = obj.__GetRefHandle();
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f1516a);
    }

    public int getFitType() throws PDFNetException {
        return GetFitType(this.f1516a);
    }

    public Page getPage() throws PDFNetException {
        return new Page(GetPage(this.f1516a), this.f1517b);
    }

    public void setPage(Page page) throws PDFNetException {
        SetPage(this.f1516a, page.f1990a);
        ReachabilityHelper.ensureReachable(page);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.f1516a, this.f1517b);
    }

    public Obj getExplicitDestObj() throws PDFNetException {
        return Obj.__Create(GetExplicitDestObj(this.f1516a), this.f1517b);
    }

    Destination(long j, Object obj) {
        this.f1516a = j;
        this.f1517b = obj;
    }
}
