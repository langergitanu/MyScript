package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Point;
import com.pdftron.pdf.QuadPoint;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class TextMarkup extends Markup {
    static native int GetQuadPointCount(long j);

    static native double GetQuadPointp1x(long j, int i);

    static native double GetQuadPointp1y(long j, int i);

    static native double GetQuadPointp2x(long j, int i);

    static native double GetQuadPointp2y(long j, int i);

    static native double GetQuadPointp3x(long j, int i);

    static native double GetQuadPointp3y(long j, int i);

    static native double GetQuadPointp4x(long j, int i);

    static native double GetQuadPointp4y(long j, int i);

    static native void SetQuadPoint(long j, int i, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8);

    public TextMarkup(Obj obj) {
        super(obj);
    }

    public TextMarkup() {
    }

    TextMarkup(long j, Object obj) {
        super(j, obj);
    }

    public TextMarkup(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
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
