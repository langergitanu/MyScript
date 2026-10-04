package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;

/* JADX INFO: loaded from: classes7.dex */
public class Movie extends Annot {
    static native long Create(long j, long j2);

    static native String GetTitle(long j);

    static native boolean IsToBePlayed(long j);

    static native void SetTitle(long j, String str);

    static native void SetToBePlayed(long j, boolean z);

    Movie() {
    }

    private Movie(long j, Object obj) {
        super(j, obj);
    }

    public Movie(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Movie create(Doc doc, Rect rect) throws PDFNetException {
        Movie movie = new Movie(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return movie;
    }

    public String getTitle() throws PDFNetException {
        return GetTitle(__GetHandle());
    }

    public void setTitle(String str) throws PDFNetException {
        SetTitle(__GetHandle(), str);
    }

    public boolean isToBePlayed() throws PDFNetException {
        return IsToBePlayed(__GetHandle());
    }

    public void setToBePlayed(boolean z) throws PDFNetException {
        SetToBePlayed(__GetHandle(), z);
    }
}
