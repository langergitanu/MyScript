package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Action;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Point;
import com.pdftron.pdf.QuadPoint;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Link extends Annot {
    public static final int e_invert = 1;
    public static final int e_none = 0;
    public static final int e_outline = 2;
    public static final int e_push = 3;

    static native long Create(long j, long j2);

    static native long Create(long j, long j2, long j3);

    static native long GetAction(long j);

    static native int GetHighlightingMode(long j);

    static native int GetQuadPointCount(long j);

    static native double GetQuadPointp1x(long j, int i);

    static native double GetQuadPointp1y(long j, int i);

    static native double GetQuadPointp2x(long j, int i);

    static native double GetQuadPointp2y(long j, int i);

    static native double GetQuadPointp3x(long j, int i);

    static native double GetQuadPointp3y(long j, int i);

    static native double GetQuadPointp4x(long j, int i);

    static native double GetQuadPointp4y(long j, int i);

    static native void RemoveAction(long j);

    static native void SetAction(long j, long j2);

    static native void SetHighlightingMode(long j, int i);

    static native void SetQuadPoint(long j, int i, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8);

    public Link(Obj obj) {
        super(obj);
    }

    public Link() {
    }

    public Link(long j, Object obj) {
        super(j, obj);
    }

    public Link(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Link create(Doc doc, Rect rect) throws PDFNetException {
        Link link = new Link(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return link;
    }

    public static Link create(Doc doc, Rect rect, Action action) throws PDFNetException {
        Link link = new Link(Create(doc.__GetHandle(), rect.__GetHandle(), action.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        ReachabilityHelper.ensureReachable(action);
        return link;
    }

    public void removeAction() throws PDFNetException {
        RemoveAction(__GetHandle());
    }

    public Action getAction() throws PDFNetException {
        return Action.__Create(GetAction(__GetHandle()), __GetRefHandle());
    }

    public void setAction(Action action) throws PDFNetException {
        SetAction(__GetHandle(), action.__GetHandle());
    }

    public int getHighlightingMode() throws PDFNetException {
        return GetHighlightingMode(__GetHandle());
    }

    public void setHighlightingMode(int i) throws PDFNetException {
        SetHighlightingMode(__GetHandle(), i);
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
}
