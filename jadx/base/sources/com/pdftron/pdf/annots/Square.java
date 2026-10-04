package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Square extends Markup {
    static native long Create(long j, long j2);

    public Square(Obj obj) {
        super(obj);
    }

    public Square() {
    }

    private Square(long j, Object obj) {
        super(j, obj);
    }

    public Square(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Square create(Doc doc, Rect rect) throws PDFNetException {
        Square square = new Square(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return square;
    }
}
