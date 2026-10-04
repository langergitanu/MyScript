package com.pdftron.pdf;

import android.graphics.Bitmap;
import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.BitmapHelper;
import com.pdftron.helpers.Graphics;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.ocg.Context;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class PDFDraw extends AbstractC6968g implements AutoCloseable {
    public static final int e_bgr = 3;
    public static final int e_bgra = 1;
    public static final int e_gray = 4;
    public static final int e_gray_alpha = 5;
    public static final int e_postprocess_invert = 1;
    public static final int e_postprocess_none = 0;
    public static final int e_rgb = 2;
    public static final int e_rgba = 0;

    /* JADX INFO: renamed from: a */
    private long f1629a;

    /* JADX INFO: renamed from: d */
    private long f1630d;

    /* JADX INFO: renamed from: e */
    private Bitmap f1631e;

    static native void Destroy(long j, long j2);

    static native void DestroyProcData(long j);

    static native void Export(long j, long j2, String str, String str2, long j3);

    static native long[] GetBitmap(long j, long j2);

    static native Separation[] GetSeparationBitmaps(long j, long j2);

    static native long PDFDrawCreate(double d);

    static native void SetAntiAliasing(long j, boolean z);

    static native void SetCaching(long j, boolean z);

    static native void SetClipRect(long j, long j2);

    static native void SetColorPostProcessMode(long j, int i);

    static native void SetDPI(long j, double d);

    static native void SetDataBuf(long j, long j2, int[] iArr);

    static native void SetDataBufByte(long j, long j2, byte[] bArr);

    static native void SetDefaultPageColor(long j, byte b, byte b2, byte b3);

    static native void SetDrawAnnotations(long j, boolean z);

    static native long SetErrorReportProc(long j, ErrorReportProc errorReportProc, Object obj);

    static native void SetFlipYAxis(long j, boolean z);

    static native void SetGamma(long j, double d);

    static native void SetHighlightFields(long j, boolean z);

    static native void SetImageSize(long j, int i, int i2, boolean z);

    static native void SetImageSmoothing(long j, boolean z, boolean z2);

    static native void SetOCGContext(long j, long j2);

    static native void SetOverprint(long j, int i);

    static native void SetPageBox(long j, int i);

    static native void SetPageTransparent(long j, boolean z);

    static native void SetPathHinting(long j, boolean z);

    static native void SetPrintMode(long j, boolean z);

    static native void SetRasterizerType(long j, int i);

    static native void SetRotate(long j, int i);

    static native void SetThinLineAdjustment(long j, boolean z, boolean z2);

    public PDFDraw() throws PDFNetException {
        this.f1631e = null;
        this.f1629a = PDFDrawCreate(92.0d);
        this.f1630d = 0L;
        clearList();
    }

    public PDFDraw(double d) throws PDFNetException {
        this.f1631e = null;
        this.f1629a = PDFDrawCreate(d);
        this.f1630d = 0L;
        clearList();
    }

    @Override // com.pdftron.pdf.AbstractC6968g, com.pdftron.pdf.__Delete
    public void destroy() throws PDFNetException {
        long j = this.f1629a;
        if (j != 0) {
            Destroy(j, this.f1630d);
            this.f1629a = 0L;
        }
    }

    @Override // com.pdftron.pdf.AbstractC6968g
    protected void finalize() throws Throwable {
        destroy();
    }

    public void setRasterizerType(int i) throws PDFNetException {
        SetRasterizerType(this.f1629a, i);
    }

    public void setDPI(double d) throws PDFNetException {
        SetDPI(this.f1629a, d);
    }

    public void setImageSize(int i, int i2) throws PDFNetException {
        SetImageSize(this.f1629a, i, i2, true);
    }

    public void setImageSize(int i, int i2, boolean z) throws PDFNetException {
        SetImageSize(this.f1629a, i, i2, z);
    }

    public void setPageBox(int i) throws PDFNetException {
        SetPageBox(this.f1629a, i);
    }

    public void setClipRect(Rect rect) throws PDFNetException {
        SetClipRect(this.f1629a, rect.f2037a);
        ReachabilityHelper.ensureReachable(rect);
    }

    public void setFlipYAxis(boolean z) throws PDFNetException {
        SetFlipYAxis(this.f1629a, z);
    }

    public void setRotate(int i) throws PDFNetException {
        SetRotate(this.f1629a, i);
    }

    public void setDrawAnnotations(boolean z) throws PDFNetException {
        SetDrawAnnotations(this.f1629a, z);
    }

    public void setHighlightFields(boolean z) {
        SetHighlightFields(this.f1629a, z);
    }

    public void setAntiAliasing(boolean z) throws PDFNetException {
        SetAntiAliasing(this.f1629a, z);
    }

    public void setPathHinting(boolean z) throws PDFNetException {
        SetPathHinting(this.f1629a, z);
    }

    public void setThinLineAdjustment(boolean z, boolean z2) {
        SetThinLineAdjustment(this.f1629a, z, z2);
    }

    public void setImageSmoothing() throws PDFNetException {
        SetImageSmoothing(this.f1629a, true, false);
    }

    public void setImageSmoothing(boolean z) throws PDFNetException {
        SetImageSmoothing(this.f1629a, z, false);
    }

    public void setImageSmoothing(boolean z, boolean z2) throws PDFNetException {
        SetImageSmoothing(this.f1629a, z, z2);
    }

    public void setCaching() throws PDFNetException {
        SetCaching(this.f1629a, true);
    }

    public void setCaching(boolean z) throws PDFNetException {
        SetCaching(this.f1629a, z);
    }

    public void setGamma(double d) throws PDFNetException {
        SetGamma(this.f1629a, d);
    }

    public void setOCGContext(Context context) throws PDFNetException {
        if (context == null) {
            SetOCGContext(this.f1629a, 0L);
        } else {
            SetOCGContext(this.f1629a, context.__GetHandle());
            ReachabilityHelper.ensureReachable(context);
        }
    }

    public void setPrintMode(boolean z) throws PDFNetException {
        SetPrintMode(this.f1629a, z);
    }

    public void setDefaultPageColor(byte b, byte b2, byte b3) throws PDFNetException {
        SetDefaultPageColor(this.f1629a, b, b2, b3);
    }

    public void setPageTransparent(boolean z) throws PDFNetException {
        SetPageTransparent(this.f1629a, z);
    }

    public void setColorPostProcessMode(int i) {
        SetColorPostProcessMode(this.f1629a, i);
    }

    public void setOverprint(int i) throws PDFNetException {
        SetOverprint(this.f1629a, i);
    }

    public void export(Page page, String str) throws PDFNetException {
        Export(this.f1629a, page.f1990a, str, "PNG", 0L);
        ReachabilityHelper.ensureReachable(page);
    }

    public void export(Page page, String str, String str2) throws PDFNetException {
        Export(this.f1629a, page.f1990a, str, str2, 0L);
        ReachabilityHelper.ensureReachable(page);
    }

    public void export(Page page, String str, String str2, Obj obj) throws PDFNetException {
        Export(this.f1629a, page.f1990a, str, str2, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(page);
        ReachabilityHelper.ensureReachable(obj);
    }

    public Bitmap getBitmap(Page page) {
        return getBitmap(page, null);
    }

    public Bitmap getBitmap(Page page, Bitmap.Config config) {
        long[] jArrGetBitmap = GetBitmap(this.f1629a, page.f1990a);
        ReachabilityHelper.ensureReachable(page);
        long j = jArrGetBitmap[0];
        int i = (int) jArrGetBitmap[1];
        int i2 = (int) jArrGetBitmap[2];
        if (i * i2 == 0) {
            return null;
        }
        BitmapHelper.CustomBitmap customBitmap = new BitmapHelper.CustomBitmap(i, i2, config);
        SetDataBuf(this.f1629a, j, customBitmap.bitmapArray);
        customBitmap.create();
        return customBitmap.bitmap;
    }

    public byte[] getByteBuffer(Page page) {
        long[] jArrGetBitmap = GetBitmap(this.f1629a, page.f1990a);
        ReachabilityHelper.ensureReachable(page);
        long j = jArrGetBitmap[0];
        byte[] bArr = new byte[((int) jArrGetBitmap[2]) * ((int) jArrGetBitmap[3])];
        SetDataBufByte(this.f1629a, j, bArr);
        return bArr;
    }

    public class IntBufferData {
        public int[] data;
        public int width = 0;
        public int height = 0;
        public int stride = 0;

        public IntBufferData(PDFDraw pDFDraw) {
        }
    }

    public IntBufferData getIntBuffer(Page page) {
        long[] jArrGetBitmap = GetBitmap(this.f1629a, page.f1990a);
        ReachabilityHelper.ensureReachable(page);
        long j = jArrGetBitmap[0];
        IntBufferData intBufferData = new IntBufferData(this);
        intBufferData.width = (int) jArrGetBitmap[1];
        intBufferData.height = (int) jArrGetBitmap[2];
        intBufferData.stride = (int) jArrGetBitmap[3];
        intBufferData.data = new int[intBufferData.width * intBufferData.height];
        SetDataBuf(this.f1629a, j, intBufferData.data);
        return intBufferData;
    }

    public void drawInRect(Graphics graphics, Page page, int i, int i2, int i3, int i4) {
        Bitmap bitmap = getBitmap(page, null);
        this.f1631e = bitmap;
        BitmapHelper.drawInRect(bitmap, graphics, i3, i4);
    }

    public void setErrorReportProc(ErrorReportProc errorReportProc, Object obj) throws PDFNetException {
        long j = this.f1630d;
        if (j != 0) {
            DestroyProcData(j);
        }
        this.f1630d = SetErrorReportProc(this.f1629a, errorReportProc, obj);
    }

    public Separation[] getSeparationBitmaps(Page page) throws PDFNetException {
        Separation[] separationArrGetSeparationBitmaps = GetSeparationBitmaps(this.f1629a, page.f1990a);
        ReachabilityHelper.ensureReachable(page);
        return separationArrGetSeparationBitmaps;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
