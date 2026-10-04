package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Highlight extends TextMarkup {
    static native long Create(long j, long j2);

    public Highlight(Obj obj) {
        super(obj);
    }

    public Highlight() {
    }

    private Highlight(long j, Object obj) {
        super(j, obj);
    }

    public Highlight(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Highlight create(Doc doc, Rect rect) throws PDFNetException {
        Highlight highlight = new Highlight(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return highlight;
    }
}
