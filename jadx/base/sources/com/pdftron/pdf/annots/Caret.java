package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Caret extends Markup {
    static native long Create(long j, long j2);

    static native String GetSymbol(long j);

    static native void SetSymbol(long j, String str);

    public Caret(Obj obj) {
        super(obj);
    }

    public Caret() {
    }

    private Caret(long j, Object obj) {
        super(j, obj);
    }

    public Caret(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Caret create(Doc doc, Rect rect) throws PDFNetException {
        Caret caret = new Caret(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return caret;
    }

    public String getSymbol() throws PDFNetException {
        return GetSymbol(__GetHandle());
    }

    public void setSymbol(String str) throws PDFNetException {
        SetSymbol(__GetHandle(), str);
    }
}
