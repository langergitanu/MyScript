package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class StrikeOut extends TextMarkup {
    static native long Create(long j, long j2);

    public StrikeOut(Obj obj) {
        super(obj);
    }

    private StrikeOut(long j, Object obj) {
        super(j, obj);
    }

    public StrikeOut(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static StrikeOut create(Doc doc, Rect rect) throws PDFNetException {
        StrikeOut strikeOut = new StrikeOut(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return strikeOut;
    }
}
