package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Watermark extends Annot {
    static native long Create(long j, long j2);

    public Watermark(Obj obj) {
        super(obj);
    }

    public Watermark() {
    }

    private Watermark(long j, Object obj) {
        super(j, obj);
    }

    public Watermark(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Watermark create(Doc doc, Rect rect) throws PDFNetException {
        Watermark watermark = new Watermark(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return watermark;
    }
}
