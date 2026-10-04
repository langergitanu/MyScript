package com.pdftron.pdf;

import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Shading {
    public static final int e_axial_shading = 1;
    public static final int e_coons_shading = 5;
    public static final int e_free_gouraud_shading = 3;
    public static final int e_function_shading = 0;
    public static final int e_lattice_gouraud_shading = 4;
    public static final int e_null = 7;
    public static final int e_radial_shading = 2;
    public static final int e_tensor_shading = 6;

    /* JADX INFO: renamed from: a */
    long f2051a;

    /* JADX INFO: renamed from: b */
    Object f2052b;

    static native boolean GetAntialias(long j);

    static native long GetBBox(long j);

    static native long GetBackground(long j);

    static native long GetBaseColorSpace(long j);

    static native long GetColor(long j, double d);

    static native long GetColor(long j, double d, double d2);

    static native double[] GetCoords(long j);

    static native double[] GetCoordsRadial(long j);

    static native double[] GetDomain(long j);

    static native long GetMatrix(long j);

    static native double GetParamEnd(long j);

    static native double GetParamStart(long j);

    static native int GetType(long j);

    static native int GetTypeStatic(long j);

    static native boolean HasBBox(long j);

    static native boolean HasBackground(long j);

    static native boolean IsExtendEnd(long j);

    static native boolean IsExtendStart(long j);

    public Shading(Obj obj) {
        this.f2051a = obj.__GetHandle();
        this.f2052b = obj.__GetRefHandle();
    }

    public static int getType(Obj obj) throws PDFNetException {
        int iGetTypeStatic = GetTypeStatic(obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
        return iGetTypeStatic;
    }

    public int getType() throws PDFNetException {
        return GetType(this.f2051a);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.f2051a, this.f2052b);
    }

    public ColorSpace getBaseColorSpace() throws PDFNetException {
        return ColorSpace.__Create(GetBaseColorSpace(this.f2051a), this.f2052b);
    }

    public boolean hasBBox() throws PDFNetException {
        return HasBBox(this.f2051a);
    }

    public Rect getBBox() throws PDFNetException {
        return new Rect(GetBBox(this.f2051a));
    }

    public boolean hasBackground() throws PDFNetException {
        return HasBackground(this.f2051a);
    }

    public ColorPt getBackground() throws PDFNetException {
        return new ColorPt(GetBackground(this.f2051a));
    }

    public boolean getAntialias() throws PDFNetException {
        return GetAntialias(this.f2051a);
    }

    public double getParamStart() throws PDFNetException {
        return GetParamStart(this.f2051a);
    }

    public double getParamEnd() throws PDFNetException {
        return GetParamEnd(this.f2051a);
    }

    public boolean isExtendStart() throws PDFNetException {
        return IsExtendStart(this.f2051a);
    }

    public boolean isExtendEnd() throws PDFNetException {
        return IsExtendEnd(this.f2051a);
    }

    public ColorPt getColor(double d) throws PDFNetException {
        return new ColorPt(GetColor(this.f2051a, d));
    }

    public double[] getCoords() throws PDFNetException {
        return GetCoords(this.f2051a);
    }

    public double[] getCoordsRadial() throws PDFNetException {
        return GetCoordsRadial(this.f2051a);
    }

    public double[] getDomain() throws PDFNetException {
        return GetDomain(this.f2051a);
    }

    public Matrix2D getMatrix() throws PDFNetException {
        return Matrix2D.__Create(GetMatrix(this.f2051a));
    }

    public ColorPt getColor(double d, double d2) throws PDFNetException {
        return new ColorPt(GetColor(this.f2051a, d, d2));
    }

    private Shading(long j, Object obj) {
        this.f2051a = j;
        this.f2052b = obj;
    }

    /* JADX INFO: renamed from: a */
    static Shading m1496a(long j, Object obj) {
        if (j == 0) {
            return null;
        }
        return new Shading(j, obj);
    }
}
