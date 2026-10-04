package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Point;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class PolyLine extends Line {
    public static final int e_PolyLineDimension = 1;
    public static final int e_PolygonCloud = 0;
    public static final int e_PolygonDimension = 2;
    public static final int e_Unknown = 3;

    static native long Create(long j, long j2);

    static native int GetIntentName(long j);

    static native int GetVertexCount(long j);

    static native double GetVertexx(long j, int i);

    static native double GetVertexy(long j, int i);

    static native void SetIntentName(long j, int i);

    static native void SetVertex(long j, int i, double d, double d2);

    public PolyLine(Obj obj) {
        super(obj);
    }

    public PolyLine() {
    }

    PolyLine(long j, Object obj) {
        super(j, obj);
    }

    public PolyLine(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static PolyLine create(Doc doc, Rect rect) throws PDFNetException {
        PolyLine polyLine = new PolyLine(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return polyLine;
    }

    public int getVertexCount() throws PDFNetException {
        return GetVertexCount(__GetHandle());
    }

    public Point getVertex(int i) throws PDFNetException {
        return new Point(GetVertexx(__GetHandle(), i), GetVertexy(__GetHandle(), i));
    }

    public void setVertex(int i, Point point) throws PDFNetException {
        SetVertex(__GetHandle(), i, point.f2001x, point.f2002y);
    }

    public int getIntentName() throws PDFNetException {
        return GetIntentName(__GetHandle());
    }

    public void setIntentName(int i) throws PDFNetException {
        SetIntentName(__GetHandle(), i);
    }
}
