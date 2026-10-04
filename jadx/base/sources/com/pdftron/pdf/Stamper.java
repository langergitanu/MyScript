package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class Stamper implements AutoCloseable {
    public static final int e_absolute_size = 2;
    public static final int e_align_center = 0;
    public static final int e_align_left = -1;
    public static final int e_align_right = 1;
    public static final int e_font_size = 3;
    public static final int e_horizontal_center = 0;
    public static final int e_horizontal_left = -1;
    public static final int e_horizontal_right = 1;
    public static final int e_relative_scale = 1;
    public static final int e_vertical_bottom = -1;
    public static final int e_vertical_center = 0;
    public static final int e_vertical_top = 1;

    /* JADX INFO: renamed from: a */
    private long f2054a;

    static native void DeleteStamps(long j, long j2);

    static native void Destroy(long j);

    static native boolean HasStamps(long j, long j2);

    static native void SetAlignment(long j, int i, int i2);

    static native void SetAsAnnotation(long j, boolean z);

    static native void SetAsBackground(long j, boolean z);

    static native void SetFont(long j, long j2);

    static native void SetFontColor(long j, long j2);

    static native void SetOpacity(long j, double d);

    static native void SetPosition(long j, double d, double d2);

    static native void SetPosition(long j, double d, double d2, boolean z);

    static native void SetRotation(long j, double d);

    static native void SetSize(long j, int i, double d, double d2);

    static native void SetTextAlignment(long j, int i);

    static native void ShowsOnPrint(long j, boolean z);

    static native void ShowsOnScreen(long j, boolean z);

    static native void StampImage(long j, long j2, long j3, long j4);

    static native void StampPage(long j, long j2, long j3, long j4);

    static native void StampText(long j, long j2, String str, long j3);

    static native long StamperCreate(int i, double d, double d2);

    public Stamper(int i, double d, double d2) {
        this.f2054a = StamperCreate(i, d, d2);
    }

    public void destroy() {
        long j = this.f2054a;
        if (j != 0) {
            Destroy(j);
            this.f2054a = 0L;
        }
    }

    public void stampImage(PDFDoc pDFDoc, Image image, PageSet pageSet) {
        StampImage(this.f2054a, pDFDoc.__GetHandle(), image.f1568a, pageSet.f1995a);
        ReachabilityHelper.ensureReachable(image);
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(pageSet);
    }

    public void stampPage(PDFDoc pDFDoc, Page page, PageSet pageSet) {
        StampPage(this.f2054a, pDFDoc.__GetHandle(), page.f1990a, pageSet.f1995a);
        ReachabilityHelper.ensureReachable(page);
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(pageSet);
    }

    public void stampText(PDFDoc pDFDoc, String str, PageSet pageSet) {
        StampText(this.f2054a, pDFDoc.__GetHandle(), str, pageSet.f1995a);
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(pageSet);
    }

    public void setFont(Font font) {
        SetFont(this.f2054a, font.f1556a);
        ReachabilityHelper.ensureReachable(font);
    }

    public void setFontColor(ColorPt colorPt) {
        SetFontColor(this.f2054a, colorPt.f1458a);
        ReachabilityHelper.ensureReachable(colorPt);
    }

    public void setOpacity(double d) {
        SetOpacity(this.f2054a, d);
    }

    public void setRotation(double d) {
        SetRotation(this.f2054a, d);
    }

    public void setAsBackground(boolean z) {
        SetAsBackground(this.f2054a, z);
    }

    public void setAsAnnotation(boolean z) {
        SetAsAnnotation(this.f2054a, z);
    }

    public void showsOnScreen(boolean z) {
        ShowsOnScreen(this.f2054a, z);
    }

    public void showsOnPrint(boolean z) {
        ShowsOnPrint(this.f2054a, z);
    }

    public void setPosition(double d, double d2) {
        SetPosition(this.f2054a, d, d2);
    }

    public void setPosition(double d, double d2, boolean z) {
        SetPosition(this.f2054a, d, d2, z);
    }

    public void setAlignment(int i, int i2) {
        SetAlignment(this.f2054a, i, i2);
    }

    public void setTextAlignment(int i) {
        SetTextAlignment(this.f2054a, i);
    }

    public void setSize(int i, double d, double d2) {
        SetSize(this.f2054a, i, d, d2);
    }

    public static void deleteStamps(PDFDoc pDFDoc, PageSet pageSet) {
        DeleteStamps(pDFDoc.__GetHandle(), pageSet.f1995a);
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(pageSet);
    }

    public static boolean hasStamps(PDFDoc pDFDoc, PageSet pageSet) {
        boolean zHasStamps = HasStamps(pDFDoc.__GetHandle(), pageSet.f1995a);
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(pageSet);
        return zHasStamps;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
