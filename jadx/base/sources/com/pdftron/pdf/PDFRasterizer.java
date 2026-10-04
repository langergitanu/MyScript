package com.pdftron.pdf;

import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.ocg.Context;

/* JADX INFO: loaded from: classes7.dex */
public class PDFRasterizer implements AutoCloseable {
    public static final int e_postprocess_gradient_map = 2;
    public static final int e_postprocess_invert = 1;
    public static final int e_postprocess_night_mode = 3;
    public static final int e_postprocess_none = 0;

    /* JADX INFO: renamed from: a */
    private long f1636a = PDFRasterizerCreate();

    /* JADX INFO: renamed from: b */
    private long f1637b = PDFRasterizerCreateCancelFlag();

    static native void Destroy(long j, long j2);

    static native int GetColorPostProcessMode(long j);

    static native long PDFRasterizerCreate();

    static native long PDFRasterizerCreateCancelFlag();

    static native void Rasterize(long j, long j2, byte[] bArr, int i, int i2, int i3, int i4, boolean z, long j3, long j4);

    static native Separation[] RasterizeSeparations(long j, long j2, int i, int i2, long j3, long j4, long j5);

    static native void RasterizeToIntBuffer(long j, long j2, int[] iArr, int i, int i2, boolean z, long j3, long j4, long j5, long j6);

    static native void SetAntiAliasing(long j, boolean z);

    static native void SetCaching(long j, boolean z);

    static native void SetCancel(long j, boolean z);

    static native void SetColorPostProcessColors(long j, int i, int i2);

    static native void SetColorPostProcessMapFile(long j, long j2);

    static native void SetColorPostProcessMode(long j, int i);

    static native void SetDrawAnnotations(long j, boolean z);

    static native void SetGamma(long j, double d);

    static native void SetHighlightFields(long j, boolean z);

    static native void SetImageSmoothing(long j, boolean z, boolean z2);

    static native void SetOCGContext(long j, long j2);

    static native void SetOverprint(long j, int i);

    static native void SetPathHinting(long j, boolean z);

    static native void SetPrintMode(long j, boolean z);

    static native void SetThinLineAdjustment(long j, boolean z, boolean z2);

    public void destroy() throws PDFNetException {
        long j = this.f1636a;
        if (j == 0 && this.f1637b == 0) {
            return;
        }
        Destroy(j, this.f1637b);
        this.f1636a = 0L;
        this.f1637b = 0L;
    }

    public void setAntiAliasing(boolean z) throws PDFNetException {
        SetAntiAliasing(this.f1636a, z);
    }

    public void setCancel(boolean z) throws PDFNetException {
        SetCancel(this.f1637b, z);
    }

    public void setPathHinting(boolean z) throws PDFNetException {
        SetPathHinting(this.f1636a, z);
    }

    public void setDrawAnnotations(boolean z) throws PDFNetException {
        SetDrawAnnotations(this.f1636a, z);
    }

    public void setHighlightFields(boolean z) {
        SetHighlightFields(this.f1636a, z);
    }

    public void setThinLineAdjustment(boolean z, boolean z2) {
        SetThinLineAdjustment(this.f1636a, z, z2);
    }

    public void setImageSmoothing() throws PDFNetException {
        SetImageSmoothing(this.f1636a, true, false);
    }

    public void setImageSmoothing(boolean z) throws PDFNetException {
        SetImageSmoothing(this.f1636a, z, false);
    }

    public void setImageSmoothing(boolean z, boolean z2) throws PDFNetException {
        SetImageSmoothing(this.f1636a, z, z2);
    }

    public void setCaching() throws PDFNetException {
        SetCaching(this.f1636a, true);
    }

    public void setCaching(boolean z) throws PDFNetException {
        SetCaching(this.f1636a, z);
    }

    public void setGamma(double d) throws PDFNetException {
        SetGamma(this.f1636a, d);
    }

    public void setOCGContext(Context context) throws PDFNetException {
        if (context == null) {
            SetOCGContext(this.f1636a, 0L);
        } else {
            SetOCGContext(this.f1636a, context.__GetHandle());
            ReachabilityHelper.ensureReachable(context);
        }
    }

    public void setPrintMode(boolean z) throws PDFNetException {
        SetPrintMode(this.f1636a, z);
    }

    public void setOverprint(int i) throws PDFNetException {
        SetOverprint(this.f1636a, i);
    }

    public void setColorPostProcessMode(int i) {
        SetColorPostProcessMode(this.f1636a, i);
    }

    public void setColorPostProcessColors(int i, int i2) throws PDFNetException {
        SetColorPostProcessColors(this.f1636a, i, i2);
    }

    public void setColorPostProcessMapFile(Filter filter) throws PDFNetException {
        SetColorPostProcessMapFile(this.f1636a, filter.__GetHandle());
        ReachabilityHelper.ensureReachable(filter);
    }

    public int getColorPostProcessMode() {
        return GetColorPostProcessMode(this.f1636a);
    }

    public void rasterize(Page page, int[] iArr, int i, int i2, boolean z, Matrix2D matrix2D, Rect rect) throws PDFNetException {
        RasterizeToIntBuffer(this.f1636a, page.f1990a, iArr, i, i2, z, matrix2D.__GetHandle(), rect == null ? 0L : rect.f2037a, 0L, this.f1637b);
        ReachabilityHelper.ensureReachable(page);
        ReachabilityHelper.ensureReachable(matrix2D);
        ReachabilityHelper.ensureReachable(rect);
    }

    public byte[] rasterize(Page page, int i, int i2, int i3, int i4, boolean z, Matrix2D matrix2D, Rect rect) throws PDFNetException {
        byte[] bArr = new byte[i * i2 * i4];
        Rasterize(this.f1636a, page.f1990a, bArr, i, i2, i3, i4, z, matrix2D.__GetHandle(), rect == null ? 0L : rect.f2037a);
        ReachabilityHelper.ensureReachable(page);
        ReachabilityHelper.ensureReachable(matrix2D);
        ReachabilityHelper.ensureReachable(rect);
        return bArr;
    }

    public Separation[] rasterizeSeparations(Page page, int i, int i2, Matrix2D matrix2D, Rect rect, boolean z) throws PDFNetException {
        setCancel(z);
        Separation[] separationArrRasterizeSeparations = RasterizeSeparations(this.f1636a, page.f1990a, i, i2, matrix2D.__GetHandle(), rect == null ? 0L : rect.f2037a, this.f1637b);
        ReachabilityHelper.ensureReachable(page);
        ReachabilityHelper.ensureReachable(matrix2D);
        ReachabilityHelper.ensureReachable(rect);
        return separationArrRasterizeSeparations;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
