package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Popup extends Annot {
    static native long Create(long j, long j2);

    static native long GetParent(long j);

    static native boolean IsOpen(long j);

    static native void SetOpen(long j, boolean z);

    static native void SetParent(long j, long j2);

    public Popup(Obj obj) {
        super(obj);
    }

    public Popup() {
    }

    Popup(long j, Object obj) {
        super(j, obj);
    }

    public Popup(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Popup create(Doc doc, Rect rect) throws PDFNetException {
        Popup popup = new Popup(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return popup;
    }

    public Annot getParent() throws PDFNetException {
        return __Create(GetParent(__GetHandle()), __GetRefHandle());
    }

    public void setParent(Annot annot) throws PDFNetException {
        SetParent(__GetHandle(), annot.__GetHandle());
        ReachabilityHelper.ensureReachable(annot);
    }

    public boolean isOpen() throws PDFNetException {
        return IsOpen(__GetHandle());
    }

    public void setOpen(boolean z) throws PDFNetException {
        SetOpen(__GetHandle(), z);
    }
}
