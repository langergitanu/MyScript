package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Polygon extends PolyLine {
    static native long Create(long j, long j2);

    public Polygon() {
    }

    public Polygon(Annot annot) throws PDFNetException {
        super(annot);
    }

    public Polygon(Obj obj) {
        super(obj);
    }

    private Polygon(long j, Object obj) {
        super(j, obj);
    }

    public static Polygon create(Doc doc, Rect rect) throws PDFNetException {
        Polygon polygon = new Polygon(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return polygon;
    }
}
