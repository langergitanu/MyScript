package com.pdftron.pdf;

import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class PatternColor {
    public static final int e_colored_tiling_pattern = 1;
    public static final int e_constant_spacing = 0;
    public static final int e_constant_spacing_fast_fill = 2;
    public static final int e_no_distortion = 1;
    public static final int e_null = 3;
    public static final int e_shading = 2;
    public static final int e_uncolored_tiling_pattern = 0;

    /* JADX INFO: renamed from: a */
    long f1999a;

    /* JADX INFO: renamed from: b */
    private Object f2000b;

    static native long GetBBox(long j);

    static native long GetMatrix(long j);

    static native long GetShading(long j);

    static native int GetTilingType(long j);

    static native int GetType(long j);

    static native int GetTypeObj(long j);

    static native double GetXStep(long j);

    static native double GetYStep(long j);

    public PatternColor(Obj obj) {
        this.f1999a = obj.__GetHandle();
        this.f2000b = obj.__GetRefHandle();
    }

    public static int getType(Obj obj) throws PDFNetException {
        int iGetTypeObj = GetTypeObj(obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
        return iGetTypeObj;
    }

    public int getType() throws PDFNetException {
        return GetType(this.f1999a);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(this.f1999a, this.f2000b);
    }

    public Matrix2D getMatrix() throws PDFNetException {
        return Matrix2D.__Create(GetMatrix(this.f1999a));
    }

    public Shading getShading() throws PDFNetException {
        return Shading.m1496a(GetShading(this.f1999a), this.f2000b);
    }

    public int getTilingType() throws PDFNetException {
        return GetTilingType(this.f1999a);
    }

    public Rect getBBox() throws PDFNetException {
        return new Rect(GetBBox(this.f1999a));
    }

    public double getXStep() throws PDFNetException {
        return GetXStep(this.f1999a);
    }

    public double getYStep() throws PDFNetException {
        return GetYStep(this.f1999a);
    }

    /* JADX INFO: renamed from: a */
    static PatternColor m1467a(long j, Object obj) {
        if (j != 0) {
            return new PatternColor(j, obj);
        }
        return null;
    }

    private PatternColor(long j, Object obj) {
        this.f1999a = j;
        this.f2000b = obj;
    }
}
