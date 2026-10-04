package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class ColorSpace {
    public static final int e_cal_gray = 3;
    public static final int e_cal_rgb = 4;
    public static final int e_device_cmyk = 2;
    public static final int e_device_gray = 0;
    public static final int e_device_n = 10;
    public static final int e_device_rgb = 1;
    public static final int e_icc = 6;
    public static final int e_indexed = 7;
    public static final int e_lab = 5;
    public static final int e_null = 11;
    public static final int e_pattern = 8;
    public static final int e_separation = 9;

    /* JADX INFO: renamed from: a */
    long f1459a;

    /* JADX INFO: renamed from: b */
    private Object f1460b;

    static native long Convert2CMYK(long j, long j2);

    static native long Convert2Gray(long j, long j2);

    static native long Convert2RGB(long j, long j2);

    static native long CreateDeviceCMYKL();

    static native long CreateDeviceGrayL();

    static native long CreateDeviceRGBL();

    static native long CreateICCFromBuffer(long j, byte[] bArr);

    static native long CreateICCFromFile(long j, String str);

    static native long CreateICCFromFilter(long j, long j2);

    static native long CreatePatternL();

    static native long GetAlternateColorSpace(long j);

    static native long GetBaseColor(long j, byte b);

    static native long GetBaseColorSpace(long j);

    static native int GetComponentNum(int i, long j);

    static native int GetComponentNum(long j);

    static native byte[] GetLookupTable(long j);

    static native long GetTintFunction(long j);

    static native int GetType(long j);

    static native int GetTypeStatic(long j);

    static native void InitColor(long j, long j2);

    static native void InitComponentRanges(long j, double[] dArr, double[] dArr2);

    static native boolean IsAll(long j);

    static native boolean IsNone(long j);

    public static ColorSpace createDeviceGray() throws PDFNetException {
        return __Create(CreateDeviceGrayL(), null);
    }

    public static ColorSpace createDeviceRGB() throws PDFNetException {
        return __Create(CreateDeviceRGBL(), null);
    }

    public static ColorSpace createDeviceCMYK() throws PDFNetException {
        return __Create(CreateDeviceCMYKL(), null);
    }

    public static ColorSpace createPattern() throws PDFNetException {
        return __Create(CreatePatternL(), null);
    }

    public static ColorSpace createICCFromFile(Doc doc, String str) throws PDFNetException {
        ColorSpace colorSpace__Create = __Create(CreateICCFromFile(doc.__GetHandle(), str), null);
        ReachabilityHelper.ensureReachable(doc);
        return colorSpace__Create;
    }

    public static ColorSpace createICCFromFilter(Doc doc, Filter filter) throws PDFNetException {
        ColorSpace colorSpace__Create = __Create(CreateICCFromFilter(doc.__GetHandle(), filter.__GetHandle()), null);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(filter);
        return colorSpace__Create;
    }

    public static ColorSpace createICCFromBuffer(Doc doc, byte[] bArr) throws PDFNetException {
        ColorSpace colorSpace__Create = __Create(CreateICCFromBuffer(doc.__GetHandle(), bArr), null);
        ReachabilityHelper.ensureReachable(doc);
        return colorSpace__Create;
    }

    public ColorSpace(Obj obj) {
        this.f1459a = obj.__GetHandle();
        this.f1460b = obj.__GetRefHandle();
    }

    public static int getComponentNum(int i, Obj obj) throws PDFNetException {
        int iGetComponentNum = GetComponentNum(i, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
        return iGetComponentNum;
    }

    public static int getType(Obj obj) throws PDFNetException {
        int iGetTypeStatic = GetTypeStatic(obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
        return iGetTypeStatic;
    }

    public int getType() throws PDFNetException {
        return GetType(this.f1459a);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.f1459a, this.f1460b);
    }

    public int getComponentNum() throws PDFNetException {
        return GetComponentNum(this.f1459a);
    }

    public void initColor(ColorPt colorPt) throws PDFNetException {
        InitColor(this.f1459a, colorPt.f1458a);
        ReachabilityHelper.ensureReachable(colorPt);
    }

    public void initComponentRanges(double[] dArr, double[] dArr2) throws PDFNetException {
        int componentNum = getComponentNum();
        if (componentNum != dArr.length || componentNum != dArr2.length) {
            throw new PDFNetException("", 0L, "", "", "Error: Arrays passed to InitComponentRanges must have a length\nequal to the number of components in the ColorSpace.");
        }
        InitComponentRanges(this.f1459a, dArr, dArr2);
    }

    public ColorPt convert2Gray(ColorPt colorPt) throws PDFNetException {
        ColorPt colorPt2 = new ColorPt(Convert2Gray(this.f1459a, colorPt.f1458a));
        ReachabilityHelper.ensureReachable(colorPt);
        return colorPt2;
    }

    public ColorPt convert2RGB(ColorPt colorPt) throws PDFNetException {
        ColorPt colorPt2 = new ColorPt(Convert2RGB(this.f1459a, colorPt.f1458a));
        ReachabilityHelper.ensureReachable(colorPt);
        return colorPt2;
    }

    public ColorPt convert2CMYK(ColorPt colorPt) throws PDFNetException {
        ColorPt colorPt2 = new ColorPt(Convert2CMYK(this.f1459a, colorPt.f1458a));
        ReachabilityHelper.ensureReachable(colorPt);
        return colorPt2;
    }

    public ColorSpace getAlternateColorSpace() throws PDFNetException {
        return __Create(GetAlternateColorSpace(this.f1459a), this.f1460b);
    }

    public ColorSpace getBaseColorSpace() throws PDFNetException {
        return __Create(GetBaseColorSpace(this.f1459a), this.f1460b);
    }

    public byte[] getLookupTable() throws PDFNetException {
        return GetLookupTable(this.f1459a);
    }

    public ColorPt getBaseColor(byte b) throws PDFNetException {
        return new ColorPt(GetBaseColor(this.f1459a, b));
    }

    public Function getTintFunction() throws PDFNetException {
        return Function.m1159a(GetTintFunction(this.f1459a), this.f1460b);
    }

    public boolean isAll() throws PDFNetException {
        return IsAll(this.f1459a);
    }

    public boolean isNone() throws PDFNetException {
        return IsNone(this.f1459a);
    }

    private ColorSpace(long j, Object obj) {
        this.f1459a = j;
        this.f1460b = obj;
    }

    public static ColorSpace __Create(long j, Object obj) {
        if (j == 0) {
            return null;
        }
        return new ColorSpace(j, obj);
    }
}
