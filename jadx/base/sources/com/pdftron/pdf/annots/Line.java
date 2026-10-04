package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Point;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Line extends Markup {
    public static final int e_Butt = 5;
    public static final int e_Circle = 1;
    public static final int e_ClosedArrow = 4;
    public static final int e_Diamond = 2;
    public static final int e_Inline = 0;
    public static final int e_LineArrow = 0;
    public static final int e_LineDimension = 1;
    public static final int e_None = 9;
    public static final int e_OpenArrow = 3;
    public static final int e_RClosedArrow = 7;
    public static final int e_ROpenArrow = 6;
    public static final int e_Slash = 8;
    public static final int e_Square = 0;
    public static final int e_Top = 1;
    public static final int e_Unknown = 10;
    public static final int e_null = 2;

    static native long Create(long j, long j2);

    static native int GetCaptionPosition(long j);

    static native double GetEndPointx(long j);

    static native double GetEndPointy(long j);

    static native int GetEndStyle(long j);

    static native int GetIntentType(long j);

    static native double GetLeaderLineExtensionLength(long j);

    static native double GetLeaderLineLength(long j);

    static native double GetLeaderLineOffset(long j);

    static native boolean GetShowCaption(long j);

    static native double GetStartPointx(long j);

    static native double GetStartPointy(long j);

    static native int GetStartStyle(long j);

    static native double GetTextHOffset(long j);

    static native double GetTextVOffset(long j);

    static native void SetCapPos(long j, int i);

    static native void SetEndPoint(long j, double d, double d2);

    static native void SetEndStyle(long j, int i);

    static native void SetIntentType(long j, int i);

    static native void SetLeaderLineExtensionLength(long j, double d);

    static native void SetLeaderLineLength(long j, double d);

    static native void SetLeaderLineOffset(long j, double d);

    static native void SetShowCaption(long j, boolean z);

    static native void SetStartPoint(long j, double d, double d2);

    static native void SetStartStyle(long j, int i);

    static native void SetTextHOffset(long j, double d);

    static native void SetTextVOffset(long j, double d);

    public Line(Obj obj) {
        super(obj);
    }

    public Line() {
    }

    Line(long j, Object obj) {
        super(j, obj);
    }

    public Line(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Line create(Doc doc, Rect rect) throws PDFNetException {
        Line line = new Line(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return line;
    }

    public Point getStartPoint() throws PDFNetException {
        return new Point(GetStartPointx(__GetHandle()), GetStartPointy(__GetHandle()));
    }

    public void setStartPoint(Point point) throws PDFNetException {
        SetStartPoint(__GetHandle(), point.f2001x, point.f2002y);
    }

    public Point getEndPoint() throws PDFNetException {
        return new Point(GetEndPointx(__GetHandle()), GetEndPointy(__GetHandle()));
    }

    public void setEndPoint(Point point) throws PDFNetException {
        SetEndPoint(__GetHandle(), point.f2001x, point.f2002y);
    }

    public int getStartStyle() throws PDFNetException {
        return GetStartStyle(__GetHandle());
    }

    public void setStartStyle(int i) throws PDFNetException {
        SetStartStyle(__GetHandle(), i);
    }

    public int getEndStyle() throws PDFNetException {
        return GetEndStyle(__GetHandle());
    }

    public void setEndStyle(int i) throws PDFNetException {
        SetEndStyle(__GetHandle(), i);
    }

    public double getLeaderLineLength() throws PDFNetException {
        return GetLeaderLineLength(__GetHandle());
    }

    public void setLeaderLineLength(double d) throws PDFNetException {
        SetLeaderLineLength(__GetHandle(), d);
    }

    public double getLeaderLineExtensionLength() throws PDFNetException {
        return GetLeaderLineExtensionLength(__GetHandle());
    }

    public void setLeaderLineExtensionLength(double d) throws PDFNetException {
        SetLeaderLineExtensionLength(__GetHandle(), d);
    }

    public boolean getShowCaption() throws PDFNetException {
        return GetShowCaption(__GetHandle());
    }

    public void setShowCaption(boolean z) throws PDFNetException {
        SetShowCaption(__GetHandle(), z);
    }

    public int getIntentType() throws PDFNetException {
        return GetIntentType(__GetHandle());
    }

    public void setIntentType(int i) throws PDFNetException {
        SetIntentType(__GetHandle(), i);
    }

    public double getLeaderLineOffset() throws PDFNetException {
        return GetLeaderLineOffset(__GetHandle());
    }

    public void setLeaderLineOffset(double d) throws PDFNetException {
        SetLeaderLineOffset(__GetHandle(), d);
    }

    public int getCaptionPosition() throws PDFNetException {
        return GetCaptionPosition(__GetHandle());
    }

    public void setCaptionPosition(int i) throws PDFNetException {
        SetCapPos(__GetHandle(), i);
    }

    public double getTextHOffset() throws PDFNetException {
        return GetTextHOffset(__GetHandle());
    }

    public void setTextHOffset(double d) throws PDFNetException {
        SetTextHOffset(__GetHandle(), d);
    }

    public double getTextVOffset() throws PDFNetException {
        return GetTextVOffset(__GetHandle());
    }

    public void setTextVOffset(double d) throws PDFNetException {
        SetTextVOffset(__GetHandle(), d);
    }
}
