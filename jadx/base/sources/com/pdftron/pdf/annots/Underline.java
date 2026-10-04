package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Underline extends TextMarkup {
    static native long Create(long j, long j2);

    public Underline(Obj obj) {
        super(obj);
    }

    public Underline() {
    }

    private Underline(long j, Object obj) {
        super(j, obj);
    }

    public Underline(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Underline create(Doc doc, Rect rect) throws PDFNetException {
        Underline underline = new Underline(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return underline;
    }
}
