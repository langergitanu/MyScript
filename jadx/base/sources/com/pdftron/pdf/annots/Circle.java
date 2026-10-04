package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Circle extends Markup {
    static native long Create(long j, long j2);

    public Circle(Obj obj) {
        super(obj);
    }

    public Circle() {
    }

    private Circle(long j, Object obj) {
        super(j, obj);
    }

    public Circle(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Circle create(Doc doc, Rect rect) throws PDFNetException {
        Circle circle = new Circle(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return circle;
    }
}
