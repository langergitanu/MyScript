package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Point;
import com.pdftron.pdf.QuadPoint;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Redaction extends Markup {
    public static final int e_Centered = 1;
    public static final int e_LeftJustified = 0;
    public static final int e_None = 3;
    public static final int e_RightJustified = 2;

    static native long Create(long j, long j2);

    static native long GetAppFormXO(long j);

    static native String GetOverlayText(long j);

    static native String GetOverlayTextAppearance(long j);

    static native int GetQuadForm(long j);

    static native int GetQuadPointCount(long j);

    static native double GetQuadPointp1x(long j, int i);

    static native double GetQuadPointp1y(long j, int i);

    static native double GetQuadPointp2x(long j, int i);

    static native double GetQuadPointp2y(long j, int i);

    static native double GetQuadPointp3x(long j, int i);

    static native double GetQuadPointp3y(long j, int i);

    static native double GetQuadPointp4x(long j, int i);

    static native double GetQuadPointp4y(long j, int i);

    static native boolean GetUseRepeat(long j);

    static native void SetAppFormXO(long j, long j2);

    static native void SetOverlayText(long j, String str);

    static native void SetOverlayTextAppearance(long j, String str);

    static native void SetOverlayTextFont(long j, String str);

    static native void SetOverlayTextFontSize(long j, double d);

    static native void SetQuadForm(long j, int i);

    static native void SetQuadPoint(long j, int i, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8);

    static native void SetUseRepeat(long j, boolean z);

    public Redaction(Obj obj) {
        super(obj);
    }

    public Redaction() {
    }

    private Redaction(long j, Object obj) {
        super(j, obj);
    }

    public Redaction(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Redaction create(Doc doc, Rect rect) throws PDFNetException {
        Redaction redaction = new Redaction(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return redaction;
    }

    public int getQuadPointCount() throws PDFNetException {
        return GetQuadPointCount(__GetHandle());
    }

    public QuadPoint getQuadPoint(int i) throws PDFNetException {
        return new QuadPoint(new Point(GetQuadPointp1x(__GetHandle(), i), GetQuadPointp1y(__GetHandle(), i)), new Point(GetQuadPointp2x(__GetHandle(), i), GetQuadPointp2y(__GetHandle(), i)), new Point(GetQuadPointp3x(__GetHandle(), i), GetQuadPointp3y(__GetHandle(), i)), new Point(GetQuadPointp4x(__GetHandle(), i), GetQuadPointp4y(__GetHandle(), i)));
    }

    public void setQuadPoint(int i, QuadPoint quadPoint) throws PDFNetException {
        SetQuadPoint(__GetHandle(), i, quadPoint.f2033p1.f2001x, quadPoint.f2033p1.f2002y, quadPoint.f2034p2.f2001x, quadPoint.f2034p2.f2002y, quadPoint.f2035p3.f2001x, quadPoint.f2035p3.f2002y, quadPoint.f2036p4.f2001x, quadPoint.f2036p4.f2002y);
    }

    public Obj getAppFormXO() throws PDFNetException {
        return Obj.__Create(GetAppFormXO(__GetHandle()), __GetRefHandle());
    }

    public void setAppFormXO(Obj obj) throws PDFNetException {
        SetAppFormXO(__GetHandle(), obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public String getOverlayText() throws PDFNetException {
        return GetOverlayText(__GetHandle());
    }

    public void setOverlayText(String str) throws PDFNetException {
        SetOverlayText(__GetHandle(), str);
    }

    public boolean getUseRepeat() throws PDFNetException {
        return GetUseRepeat(__GetHandle());
    }

    public void setUseRepeat(boolean z) throws PDFNetException {
        SetUseRepeat(__GetHandle(), z);
    }

    public String getOverlayTextAppearance() throws PDFNetException {
        return GetOverlayTextAppearance(__GetHandle());
    }

    public void setOverlayTextAppearance(String str) throws PDFNetException {
        SetOverlayTextAppearance(__GetHandle(), str);
    }

    public void SetOverlayTextFont(String str) throws PDFNetException {
        SetOverlayTextFont(__GetHandle(), str);
    }

    public void SetOverlayTextFontSize(double d) throws PDFNetException {
        SetOverlayTextFontSize(__GetHandle(), d);
    }

    public int getQuadForm() throws PDFNetException {
        return GetQuadForm(__GetHandle());
    }

    public void setQuadForm(int i) throws PDFNetException {
        SetQuadForm(__GetHandle(), i);
    }
}
