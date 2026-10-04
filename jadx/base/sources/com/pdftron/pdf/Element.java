package com.pdftron.pdf;

import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.struct.SElement;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Element {
    public static final int e_form = 9;
    public static final int e_group_begin = 10;
    public static final int e_group_end = 11;
    public static final int e_image = 6;
    public static final int e_inline_image = 7;
    public static final int e_marked_content_begin = 12;
    public static final int e_marked_content_end = 13;
    public static final int e_marked_content_point = 14;
    public static final int e_null = 0;
    public static final int e_path = 1;
    public static final int e_shading = 8;
    public static final int e_text = 3;
    public static final int e_text_begin = 2;
    public static final int e_text_end = 5;
    public static final int e_text_new_line = 4;

    /* JADX INFO: renamed from: a */
    long f1533a;

    /* JADX INFO: renamed from: b */
    private Object f1534b;

    /* JADX INFO: renamed from: c */
    private Object f1535c;

    static native long GetBBox(long j);

    static native int GetBitsPerComponent(long j);

    static native long GetCTM(long j);

    static native long GetCharIterator(long j);

    static native int GetComponentNum(long j);

    static native long GetDecodeArray(long j);

    static native long GetGState(long j);

    static native long GetImageColorSpace(long j);

    static native long GetImageData(long j);

    static native int GetImageDataSize(long j);

    static native int GetImageHeight(long j);

    static native int GetImageRenderingIntent(long j);

    static native int GetImageWidth(long j);

    static native long GetMCPropertyDict(long j);

    static native long GetMCTag(long j);

    static native long GetMask(long j);

    static native double[] GetNewTextLineOffset(long j);

    static native long GetParentStructElement(long j);

    static native double[] GetPathPoints(long j);

    static native byte[] GetPathTypes(long j);

    static native double GetPosAdjustment(long j);

    static native long GetShading(long j);

    static native int GetStructMCID(long j);

    static native byte[] GetTextData(long j);

    static native double GetTextLength(long j);

    static native long GetTextMatrix(long j);

    static native String GetTextString(long j);

    static native int GetType(long j);

    static native long GetXObject(long j);

    static native boolean HasTextMatrix(long j);

    static native boolean IsClipWindingFill(long j);

    static native boolean IsClippingPath(long j);

    static native boolean IsFilled(long j);

    static native boolean IsImageInterpolate(long j);

    static native boolean IsImageMask(long j);

    static native boolean IsOCVisible(long j);

    static native boolean IsStroked(long j);

    static native boolean IsWindingFill(long j);

    static native void SetClipWindingFill(long j, boolean z);

    static native void SetNewTextLineOffset(long j, double d, double d2);

    static native void SetPathClip(long j, boolean z);

    static native void SetPathFill(long j, boolean z);

    static native void SetPathPoints(long j, double[] dArr);

    static native void SetPathStroke(long j, boolean z);

    static native void SetPathTypes(long j, byte[] bArr);

    static native void SetPosAdjustment(long j, double d);

    static native void SetTextData(long j, byte[] bArr);

    static native void SetTextMatrix(long j, double d, double d2, double d3, double d4, double d5, double d6);

    static native void SetTextMatrix(long j, long j2);

    static native void SetWindingFill(long j, boolean z);

    static native void UpdateTextMetrics(long j);

    public int getType() throws PDFNetException {
        return GetType(this.f1533a);
    }

    public GState getGState() throws PDFNetException {
        return new GState(GetGState(this.f1533a), this.f1534b, this.f1535c);
    }

    public Matrix2D getCTM() throws PDFNetException {
        return Matrix2D.__Create(GetCTM(this.f1533a));
    }

    public Rect getBBox() throws PDFNetException {
        long jGetBBox = GetBBox(this.f1533a);
        if (jGetBBox == 0) {
            return null;
        }
        return new Rect(jGetBBox);
    }

    public SElement getParentStructElement() throws PDFNetException {
        return SElement.__Create(GetParentStructElement(this.f1533a), this);
    }

    public int getStructMCID() throws PDFNetException {
        return GetStructMCID(this.f1533a);
    }

    public boolean isOCVisible() throws PDFNetException {
        return IsOCVisible(this.f1533a);
    }

    public boolean isClippingPath() throws PDFNetException {
        return IsClippingPath(this.f1533a);
    }

    public PathData getPathData() throws PDFNetException {
        return new PathData(true, GetPathTypes(this.f1533a), GetPathPoints(this.f1533a));
    }

    public boolean isStroked() throws PDFNetException {
        return IsStroked(this.f1533a);
    }

    public boolean isFilled() throws PDFNetException {
        return IsFilled(this.f1533a);
    }

    public boolean isWindingFill() throws PDFNetException {
        return IsWindingFill(this.f1533a);
    }

    public boolean isClipWindingFill() throws PDFNetException {
        return IsClipWindingFill(this.f1533a);
    }

    public void setPathClip(boolean z) throws PDFNetException {
        SetPathClip(this.f1533a, z);
    }

    public void setPathData(PathData pathData) throws PDFNetException {
        SetPathPoints(this.f1533a, pathData.getPoints());
        SetPathTypes(this.f1533a, pathData.getOperators());
    }

    public void setPathStroke(boolean z) throws PDFNetException {
        SetPathStroke(this.f1533a, z);
    }

    public void setPathFill(boolean z) throws PDFNetException {
        SetPathFill(this.f1533a, z);
    }

    public void setWindingFill(boolean z) throws PDFNetException {
        SetWindingFill(this.f1533a, z);
    }

    public void setClipWindingFill(boolean z) throws PDFNetException {
        SetClipWindingFill(this.f1533a, z);
    }

    public Obj getXObject() throws PDFNetException {
        return Obj.__Create(GetXObject(this.f1533a), this.f1535c);
    }

    public Filter getImageData() throws PDFNetException {
        return Filter.__Create(GetImageData(this.f1533a), null);
    }

    public int getImageDataSize() throws PDFNetException {
        return GetImageDataSize(this.f1533a);
    }

    public ColorSpace getImageColorSpace() throws PDFNetException {
        return ColorSpace.__Create(GetImageColorSpace(this.f1533a), this.f1535c);
    }

    public int getImageWidth() throws PDFNetException {
        return GetImageWidth(this.f1533a);
    }

    public int getImageHeight() throws PDFNetException {
        return GetImageHeight(this.f1533a);
    }

    public Obj getDecodeArray() throws PDFNetException {
        return Obj.__Create(GetDecodeArray(this.f1533a), this.f1535c);
    }

    public int getBitsPerComponent() throws PDFNetException {
        return GetBitsPerComponent(this.f1533a);
    }

    public int getComponentNum() throws PDFNetException {
        return GetComponentNum(this.f1533a);
    }

    public boolean isImageMask() throws PDFNetException {
        return IsImageMask(this.f1533a);
    }

    public boolean isImageInterpolate() throws PDFNetException {
        return IsImageInterpolate(this.f1533a);
    }

    public Obj getMask() throws PDFNetException {
        return Obj.__Create(GetMask(this.f1533a), this.f1535c);
    }

    public int getImageRenderingIntent() throws PDFNetException {
        return GetImageRenderingIntent(this.f1533a);
    }

    public String getTextString() throws PDFNetException {
        return GetTextString(this.f1533a);
    }

    public byte[] getTextData() throws PDFNetException {
        return GetTextData(this.f1533a);
    }

    public Matrix2D getTextMatrix() throws PDFNetException {
        return Matrix2D.__Create(GetTextMatrix(this.f1533a));
    }

    public CharIterator getCharIterator() throws PDFNetException {
        return new CharIterator(GetCharIterator(this.f1533a), this.f1534b);
    }

    public double getTextLength() throws PDFNetException {
        return GetTextLength(this.f1533a);
    }

    public double getPosAdjustment() throws PDFNetException {
        return GetPosAdjustment(this.f1533a);
    }

    public double[] getNewTextLineOffset() throws PDFNetException {
        return GetNewTextLineOffset(this.f1533a);
    }

    public boolean hasTextMatrix() throws PDFNetException {
        return HasTextMatrix(this.f1533a);
    }

    public void setTextData(byte[] bArr) throws PDFNetException {
        SetTextData(this.f1533a, bArr);
    }

    public void setTextMatrix(Matrix2D matrix2D) throws PDFNetException {
        SetTextMatrix(this.f1533a, matrix2D.__GetHandle());
        ReachabilityHelper.ensureReachable(matrix2D);
    }

    public void setTextMatrix(double d, double d2, double d3, double d4, double d5, double d6) throws PDFNetException {
        SetTextMatrix(this.f1533a, d, d2, d3, d4, d5, d6);
    }

    public void setPosAdjustment(double d) throws PDFNetException {
        SetPosAdjustment(this.f1533a, d);
    }

    public void updateTextMetrics() throws PDFNetException {
        UpdateTextMetrics(this.f1533a);
    }

    public void setNewTextLineOffset(double d, double d2) throws PDFNetException {
        SetNewTextLineOffset(this.f1533a, d, d2);
    }

    public Shading getShading() throws PDFNetException {
        return Shading.m1496a(GetShading(this.f1533a), this.f1535c);
    }

    public Obj getMCPropertyDict() throws PDFNetException {
        return Obj.__Create(GetMCPropertyDict(this.f1533a), this.f1535c);
    }

    public Obj getMCTag() throws PDFNetException {
        return Obj.__Create(GetMCTag(this.f1533a), this.f1535c);
    }

    Element(long j, Object obj, Object obj2) {
        this.f1533a = j;
        this.f1534b = obj;
        this.f1535c = obj2;
    }
}
