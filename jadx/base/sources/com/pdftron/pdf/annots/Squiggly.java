package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Squiggly extends TextMarkup {
    static native long Create(long j, long j2);

    public Squiggly(Obj obj) {
        super(obj);
    }

    private Squiggly(long j, Object obj) {
        super(j, obj);
    }

    public Squiggly(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Squiggly create(Doc doc, Rect rect) throws PDFNetException {
        Squiggly squiggly = new Squiggly(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return squiggly;
    }
}
