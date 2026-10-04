package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Point;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Ink extends Markup {
    static native long Create(long j, long j2);

    static native boolean Erase(long j, double d, double d2, double d3, double d4, double d5);

    static native boolean ErasePaths(long j, double d, double d2, double d3, double d4, double d5);

    static native boolean ErasePoints(long j, long j2, double d, double d2, double d3, double d4, double d5);

    static native double[] GetBezierControlPoints(double[] dArr);

    static native int GetBlendMode(long j);

    static native boolean GetHighlightIntent(long j);

    static native int GetPathCount(long j);

    static native int GetPointCount(long j, int i);

    static native double GetPointx(long j, int i, int i2);

    static native double GetPointy(long j, int i, int i2);

    static native boolean GetSmoothing(long j);

    static native void SetBlendMode(long j, int i);

    static native void SetHighlightIntent(long j, boolean z);

    static native void SetPoint(long j, int i, int i2, double d, double d2);

    static native void SetSmoothing(long j, boolean z);

    public enum BlendMode {
        COMPATIBLE(0),
        NORMAL(1),
        MULTIPLY(2),
        SCREEN(3),
        DIFFERENCE(4),
        DARKEN(5),
        LIGHTEN(6),
        COLOR_DODGE(7),
        COLOR_BURN(8),
        EXCLUSION(9),
        HARD_LIGHT(10),
        OVERLAY(11),
        SOFT_LIGHT(12),
        LUMINOSITY(13),
        HUE(14),
        SATURATION(15),
        COLOR(16);


        /* JADX INFO: renamed from: a */
        private final int f2104a;

        BlendMode(int i) {
            this.f2104a = i;
        }

        public final int getValue() {
            return this.f2104a;
        }
    }

    public Ink(Obj obj) {
        super(obj);
    }

    public Ink() {
    }

    private Ink(long j, Object obj) {
        super(j, obj);
    }

    public Ink(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Ink create(Doc doc, Rect rect) throws PDFNetException {
        Ink ink = new Ink(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return ink;
    }

    public int getPathCount() throws PDFNetException {
        return GetPathCount(__GetHandle());
    }

    public int getPointCount(int i) throws PDFNetException {
        return GetPointCount(__GetHandle(), i);
    }

    public Point GetPoint(int i, int i2) throws PDFNetException {
        return new Point(GetPointx(__GetHandle(), i, i2), GetPointy(__GetHandle(), i, i2));
    }

    public void setPoint(int i, int i2, Point point) throws PDFNetException {
        SetPoint(__GetHandle(), i, i2, point.f2001x, point.f2002y);
    }

    public boolean erase(Point point, Point point2, double d) throws PDFNetException {
        return Erase(__GetHandle(), point.f2001x, point.f2002y, point2.f2001x, point2.f2002y, d);
    }

    public boolean erasePaths(Point point, Point point2, double d) throws PDFNetException {
        return ErasePaths(__GetHandle(), point.f2001x, point.f2002y, point2.f2001x, point2.f2002y, d);
    }

    public static boolean erasePoints(Obj obj, Rect rect, Point point, Point point2, double d) throws PDFNetException {
        boolean zErasePoints = ErasePoints(obj.__GetHandle(), rect.__GetHandle(), point.f2001x, point.f2002y, point2.f2001x, point2.f2002y, d);
        ReachabilityHelper.ensureReachable(obj);
        ReachabilityHelper.ensureReachable(rect);
        return zErasePoints;
    }

    public boolean getSmoothing() throws PDFNetException {
        return GetSmoothing(__GetHandle());
    }

    public void setSmoothing(boolean z) throws PDFNetException {
        SetSmoothing(__GetHandle(), z);
    }

    public int getBlendMode() throws PDFNetException {
        return GetBlendMode(__GetHandle());
    }

    public void setBlendMode(BlendMode blendMode) throws PDFNetException {
        SetBlendMode(__GetHandle(), blendMode.getValue());
    }

    public static double[] getBezierControlPoints(double[] dArr) throws PDFNetException {
        return GetBezierControlPoints(dArr);
    }

    public boolean getHighlightIntent() throws PDFNetException {
        return GetHighlightIntent(__GetHandle());
    }

    public void setHighlightIntent(boolean z) throws PDFNetException {
        SetHighlightIntent(__GetHandle(), z);
    }
}
