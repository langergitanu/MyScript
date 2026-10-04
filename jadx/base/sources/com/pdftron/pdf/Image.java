package com.pdftron.pdf;

import android.graphics.Bitmap;
import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.filters.FilterReader;
import com.pdftron.filters.FilterWriter;
import com.pdftron.helpers.BitmapHelper;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Image {
    public static final int e_ascii_hex = 6;
    public static final int e_flate = 3;
    public static final int e_g3 = 4;
    public static final int e_g4 = 5;
    public static final int e_jp2 = 2;
    public static final int e_jpeg = 1;
    public static final int e_none = 0;

    /* JADX INFO: renamed from: a */
    long f1568a;

    /* JADX INFO: renamed from: b */
    Object f1569b;

    static native long Create(long j, long j2, int i, int i2, int i3, long j3, int i4);

    static native long Create(long j, long j2, int i, int i2, int i3, long j3, long j4);

    static native long Create(long j, long j2, long j3);

    static native long Create(long j, String str, long j2);

    static native long Create(long j, byte[] bArr, int i, int i2, int i3, long j2, int i4);

    static native long Create(long j, byte[] bArr, int i, int i2, int i3, long j2, long j3);

    static native long Create(long j, byte[] bArr, long j2);

    static native long Create(long j, int[] iArr, int i, int i2);

    static native long CreateImageMask(long j, long j2, int i, int i2, long j3);

    static native long CreateImageMask(long j, byte[] bArr, int i, int i2, long j2);

    static native long CreateSoftMask(long j, long j2, int i, int i2, int i3, long j3);

    static native long CreateSoftMask(long j, byte[] bArr, int i, int i2, int i3, long j2);

    static native int Export(long j, long j2);

    static native int Export(long j, String str);

    static native void ExportAsPng(long j, long j2);

    static native void ExportAsPng(long j, String str);

    static native void ExportAsTiff(long j, long j2);

    static native void ExportAsTiff(long j, String str);

    static native int GetBitsPerComponent(long j);

    static native int GetComponentNum(long j);

    static native long GetDecodeArray(long j);

    static native long GetImageColorSpace(long j);

    static native long GetImageData(long j);

    static native int GetImageDataSize(long j);

    static native int GetImageHeight(long j);

    static native int GetImageRenderingIntent(long j);

    static native int GetImageWidth(long j);

    static native long GetMask(long j);

    static native int[] GetRawImageData(long j);

    static native long GetSoftMask(long j);

    static native boolean IsImageInterpolate(long j);

    static native boolean IsImageMask(long j);

    static native boolean IsValid(long j);

    static native void SetMask(long j, long j2);

    static native void SetMaskObj(long j, long j2);

    static native void SetSoftMask(long j, long j2);

    public static Image create(Doc doc, String str) throws PDFNetException {
        return new Image(Create(doc.__GetHandle(), str, 0L), doc);
    }

    public static Image create(Doc doc, String str, Obj obj) throws PDFNetException {
        Image image = new Image(Create(doc.__GetHandle(), str, obj.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(obj);
        return image;
    }

    public static Image create(Doc doc, byte[] bArr, int i, int i2, int i3, ColorSpace colorSpace) throws PDFNetException {
        Image image = new Image(Create(doc.__GetHandle(), bArr, i, i2, i3, colorSpace.f1459a, 0L), doc);
        ReachabilityHelper.ensureReachable(colorSpace);
        return image;
    }

    public static Image create(Doc doc, byte[] bArr, int i, int i2, int i3, ColorSpace colorSpace, Obj obj) throws PDFNetException {
        Image image = new Image(Create(doc.__GetHandle(), bArr, i, i2, i3, colorSpace.f1459a, obj.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(colorSpace);
        ReachabilityHelper.ensureReachable(obj);
        return image;
    }

    public static Image create(Doc doc, byte[] bArr) throws PDFNetException {
        return new Image(Create(doc.__GetHandle(), bArr, 0L), doc);
    }

    public static Image create(Doc doc, byte[] bArr, Obj obj) throws PDFNetException {
        Image image = new Image(Create(doc.__GetHandle(), bArr, obj.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(obj);
        return image;
    }

    public static Image create(Doc doc, Filter filter) throws PDFNetException {
        Image image = new Image(Create(doc.__GetHandle(), filter.__GetHandle(), 0L), doc);
        filter.__SetRefHandle(image);
        return image;
    }

    public static Image create(Doc doc, Filter filter, Obj obj) throws PDFNetException {
        Image image = new Image(Create(doc.__GetHandle(), filter.__GetHandle(), obj.__GetHandle()), doc);
        filter.__SetRefHandle(image);
        ReachabilityHelper.ensureReachable(obj);
        return image;
    }

    public static Image create(Doc doc, FilterReader filterReader, int i, int i2, int i3, ColorSpace colorSpace) throws PDFNetException {
        Image image = new Image(Create(doc.__GetHandle(), filterReader.__GetHandle(), i, i2, i3, colorSpace.f1459a, 0L), doc);
        ReachabilityHelper.ensureReachable(colorSpace);
        ReachabilityHelper.ensureReachable(filterReader);
        return image;
    }

    public static Image create(Doc doc, FilterReader filterReader, int i, int i2, int i3, ColorSpace colorSpace, Obj obj) throws PDFNetException {
        Image image = new Image(Create(doc.__GetHandle(), filterReader.__GetHandle(), i, i2, i3, colorSpace.f1459a, obj.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(colorSpace);
        ReachabilityHelper.ensureReachable(filterReader);
        ReachabilityHelper.ensureReachable(obj);
        return image;
    }

    public static Image createImageMask(Doc doc, byte[] bArr, int i, int i2) throws PDFNetException {
        return new Image(CreateImageMask(doc.__GetHandle(), bArr, i, i2, 0L), doc);
    }

    public static Image createImageMask(Doc doc, byte[] bArr, int i, int i2, Obj obj) throws PDFNetException {
        Image image = new Image(CreateImageMask(doc.__GetHandle(), bArr, i, i2, obj.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(obj);
        return image;
    }

    public static Image createImageMask(Doc doc, FilterReader filterReader, int i, int i2) throws PDFNetException {
        Image image = new Image(CreateImageMask(doc.__GetHandle(), filterReader.__GetHandle(), i, i2, 0L), doc);
        ReachabilityHelper.ensureReachable(filterReader);
        return image;
    }

    public static Image createImageMask(Doc doc, FilterReader filterReader, int i, int i2, Obj obj) throws PDFNetException {
        Image image = new Image(CreateImageMask(doc.__GetHandle(), filterReader.__GetHandle(), i, i2, obj.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(filterReader);
        ReachabilityHelper.ensureReachable(obj);
        return image;
    }

    public static Image createSoftMask(Doc doc, byte[] bArr, int i, int i2, int i3) throws PDFNetException {
        return new Image(CreateSoftMask(doc.__GetHandle(), bArr, i, i2, i3, 0L), doc);
    }

    public static Image createSoftMask(Doc doc, byte[] bArr, int i, int i2, int i3, Obj obj) throws PDFNetException {
        Image image = new Image(CreateSoftMask(doc.__GetHandle(), bArr, i, i2, i3, obj.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(obj);
        return image;
    }

    public static Image createSoftMask(Doc doc, FilterReader filterReader, int i, int i2, int i3) throws PDFNetException {
        Image image = new Image(CreateSoftMask(doc.__GetHandle(), filterReader.__GetHandle(), i, i2, i3, 0L), doc);
        ReachabilityHelper.ensureReachable(filterReader);
        return image;
    }

    public static Image createSoftMask(Doc doc, FilterReader filterReader, int i, int i2, int i3, Obj obj) throws PDFNetException {
        Image image = new Image(CreateSoftMask(doc.__GetHandle(), filterReader.__GetHandle(), i, i2, i3, obj.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(filterReader);
        ReachabilityHelper.ensureReachable(obj);
        return image;
    }

    public static Image create(Doc doc, byte[] bArr, int i, int i2, int i3, ColorSpace colorSpace, int i4) throws PDFNetException {
        Image image = new Image(Create(doc.__GetHandle(), bArr, i, i2, i3, colorSpace.f1459a, i4), doc);
        ReachabilityHelper.ensureReachable(colorSpace);
        return image;
    }

    public static Image create(Doc doc, FilterReader filterReader, int i, int i2, int i3, ColorSpace colorSpace, int i4) throws PDFNetException {
        Image image = new Image(Create(doc.__GetHandle(), filterReader.__GetHandle(), i, i2, i3, colorSpace.f1459a, i4), doc);
        ReachabilityHelper.ensureReachable(colorSpace);
        ReachabilityHelper.ensureReachable(filterReader);
        return image;
    }

    public static Image create(Doc doc, Bitmap bitmap) throws PDFNetException, InterruptedException {
        int height = BitmapHelper.getHeight(bitmap);
        int width = BitmapHelper.getWidth(bitmap);
        int i = width * height;
        if (i <= 0) {
            return null;
        }
        int[] iArr = new int[i];
        BitmapHelper.createArrayFromBitmap(bitmap, iArr, width, height);
        return new Image(Create(doc.__GetHandle(), iArr, width, height), doc);
    }

    public Bitmap getBitmap() throws PDFNetException {
        return BitmapHelper.getBitmap(GetRawImageData(this.f1568a));
    }

    public Image(Obj obj) {
        this.f1568a = obj.__GetHandle();
        this.f1569b = obj.__GetRefHandle();
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.f1568a, this.f1569b);
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f1568a);
    }

    public Filter getImageData() throws PDFNetException {
        return Filter.__Create(GetImageData(this.f1568a), null);
    }

    public int getImageDataSize() throws PDFNetException {
        return GetImageDataSize(this.f1568a);
    }

    public ColorSpace getImageColorSpace() throws PDFNetException {
        return ColorSpace.__Create(GetImageColorSpace(this.f1568a), this.f1569b);
    }

    public int getImageWidth() throws PDFNetException {
        return GetImageWidth(this.f1568a);
    }

    public int getImageHeight() throws PDFNetException {
        return GetImageHeight(this.f1568a);
    }

    public Obj getDecodeArray() throws PDFNetException {
        return Obj.__Create(GetDecodeArray(this.f1568a), this.f1569b);
    }

    public int getBitsPerComponent() throws PDFNetException {
        return GetBitsPerComponent(this.f1568a);
    }

    public int getComponentNum() throws PDFNetException {
        return GetComponentNum(this.f1568a);
    }

    public boolean isImageMask() throws PDFNetException {
        return IsImageMask(this.f1568a);
    }

    public boolean isImageInterpolate() throws PDFNetException {
        return IsImageInterpolate(this.f1568a);
    }

    public Obj getMask() throws PDFNetException {
        return Obj.__Create(GetMask(this.f1568a), this.f1569b);
    }

    public void setMask(Image image) throws PDFNetException {
        SetMask(this.f1568a, image.f1568a);
        ReachabilityHelper.ensureReachable(image);
    }

    public void setMask(Obj obj) throws PDFNetException {
        SetMaskObj(this.f1568a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public Obj getSoftMask() throws PDFNetException {
        return Obj.__Create(GetSoftMask(this.f1568a), this.f1569b);
    }

    public void setSoftMask(Image image) throws PDFNetException {
        SetSoftMask(this.f1568a, image.f1568a);
        ReachabilityHelper.ensureReachable(image);
    }

    public int getImageRenderingIntent() throws PDFNetException {
        return GetImageRenderingIntent(this.f1568a);
    }

    public int export(String str) throws PDFNetException {
        return Export(this.f1568a, str);
    }

    public int export(FilterWriter filterWriter) throws PDFNetException {
        int iExport = Export(this.f1568a, filterWriter.__GetHandle());
        ReachabilityHelper.ensureReachable(filterWriter);
        return iExport;
    }

    public void exportAsTiff(String str) throws PDFNetException {
        ExportAsTiff(this.f1568a, str);
    }

    public void exportAsTiff(FilterWriter filterWriter) throws PDFNetException {
        ExportAsTiff(this.f1568a, filterWriter.__GetHandle());
        ReachabilityHelper.ensureReachable(filterWriter);
    }

    public void exportAsPng(String str) throws PDFNetException {
        ExportAsPng(this.f1568a, str);
    }

    public void exportAsPng(FilterWriter filterWriter) throws PDFNetException {
        ExportAsPng(this.f1568a, filterWriter.__GetHandle());
        ReachabilityHelper.ensureReachable(filterWriter);
    }

    public long __GetHandle() {
        return this.f1568a;
    }

    private Image(long j, Object obj) {
        this.f1568a = j;
        this.f1569b = obj;
    }

    public static class Compat {
        public static int[] GetRawImageData(long j) {
            return Image.GetRawImageData(j);
        }
    }
}
