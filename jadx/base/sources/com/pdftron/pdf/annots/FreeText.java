package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.ColorPt;
import com.pdftron.pdf.Point;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class FreeText extends Markup {
    public static final int e_FreeText = 0;
    public static final int e_FreeTextCallout = 1;
    public static final int e_FreeTextTypeWriter = 2;
    public static final int e_Unknown = 3;

    static native long Create(long j, long j2);

    static native double GetCalloutLinePoint1x(long j);

    static native double GetCalloutLinePoint1y(long j);

    static native double GetCalloutLinePoint2x(long j);

    static native double GetCalloutLinePoint2y(long j);

    static native double GetCalloutLinePoint3x(long j);

    static native double GetCalloutLinePoint3y(long j);

    static native String GetDefaultAppearance(long j);

    static native int GetEndingStyle(long j);

    static native double GetFontSize(long j);

    static native int GetIntentName(long j);

    static native long GetLineColor(long j);

    static native int GetLineColorCompNum(long j);

    static native int GetQuaddingFormat(long j);

    static native long GetTextColor(long j);

    static native int GetTextColorCompNum(long j);

    static native void SetCalloutLinePoints(long j, double d, double d2, double d3, double d4);

    static native void SetCalloutLinePoints(long j, double d, double d2, double d3, double d4, double d5, double d6);

    static native void SetDefaultAppearance(long j, String str);

    static native void SetEndingStyle(long j, int i);

    static native void SetEndingStyle(long j, String str);

    static native void SetFontName(long j, String str);

    static native void SetFontSize(long j, double d);

    static native void SetIntentName(long j, int i);

    static native void SetLineColor(long j, long j2, int i);

    static native void SetQuaddingFormat(long j, int i);

    static native void SetTextColor(long j, long j2, int i);

    public FreeText(Obj obj) {
        super(obj);
    }

    public FreeText() {
    }

    private FreeText(long j, Object obj) {
        super(j, obj);
    }

    public FreeText(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static FreeText create(Doc doc, Rect rect) throws PDFNetException {
        FreeText freeText = new FreeText(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return freeText;
    }

    public String getDefaultAppearance() throws PDFNetException {
        return GetDefaultAppearance(__GetHandle());
    }

    public void setDefaultAppearance(String str) throws PDFNetException {
        SetDefaultAppearance(__GetHandle(), str);
    }

    public int getQuaddingFormat() throws PDFNetException {
        return GetQuaddingFormat(__GetHandle());
    }

    public void setQuaddingFormat(int i) throws PDFNetException {
        SetQuaddingFormat(__GetHandle(), i);
    }

    public Point getCalloutLinePoint1() throws PDFNetException {
        return new Point(GetCalloutLinePoint1x(__GetHandle()), GetCalloutLinePoint1y(__GetHandle()));
    }

    public Point getCalloutLinePoint2() throws PDFNetException {
        return new Point(GetCalloutLinePoint2x(__GetHandle()), GetCalloutLinePoint2y(__GetHandle()));
    }

    public Point getCalloutLinePoint3() throws PDFNetException {
        return new Point(GetCalloutLinePoint3x(__GetHandle()), GetCalloutLinePoint3y(__GetHandle()));
    }

    public void setCalloutLinePoints(Point point, Point point2, Point point3) throws PDFNetException {
        SetCalloutLinePoints(__GetHandle(), point.f2001x, point.f2002y, point2.f2001x, point2.f2002y, point3.f2001x, point3.f2002y);
    }

    public void setCalloutLinePoints(Point point, Point point2) throws PDFNetException {
        SetCalloutLinePoints(__GetHandle(), point.f2001x, point.f2002y, point2.f2001x, point2.f2002y);
    }

    public int getIntentName() throws PDFNetException {
        return GetIntentName(__GetHandle());
    }

    public void setIntentName(int i) throws PDFNetException {
        SetIntentName(__GetHandle(), i);
    }

    public int getEndingStyle() throws PDFNetException {
        return GetEndingStyle(__GetHandle());
    }

    public void setEndingStyle(int i) throws PDFNetException {
        SetEndingStyle(__GetHandle(), i);
    }

    public void setEndingStyle(String str) throws PDFNetException {
        SetEndingStyle(__GetHandle(), str);
    }

    public void setTextColor(ColorPt colorPt, int i) throws PDFNetException {
        SetTextColor(__GetHandle(), colorPt.__GetHandle(), i);
        ReachabilityHelper.ensureReachable(colorPt);
    }

    public ColorPt getTextColor() throws PDFNetException {
        return ColorPt.__Create(GetTextColor(__GetHandle()));
    }

    public int getTextColorCompNum() throws PDFNetException {
        return GetTextColorCompNum(__GetHandle());
    }

    public void setLineColor(ColorPt colorPt, int i) throws PDFNetException {
        SetLineColor(__GetHandle(), colorPt.__GetHandle(), i);
        ReachabilityHelper.ensureReachable(colorPt);
    }

    public ColorPt getLineColor() throws PDFNetException {
        return ColorPt.__Create(GetLineColor(__GetHandle()));
    }

    public int getLineColorCompNum() throws PDFNetException {
        return GetLineColorCompNum(__GetHandle());
    }

    public void setFontName(String str) throws PDFNetException {
        SetFontName(__GetHandle(), str);
    }

    public void setFontSize(double d) throws PDFNetException {
        SetFontSize(__GetHandle(), d);
    }

    public double getFontSize() throws PDFNetException {
        return GetFontSize(__GetHandle());
    }
}
