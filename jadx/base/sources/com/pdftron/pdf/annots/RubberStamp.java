package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class RubberStamp extends Markup {
    public static final int e_Approved = 0;
    public static final int e_AsIs = 3;
    public static final int e_Confidential = 6;
    public static final int e_Departmental = 9;
    public static final int e_Draft = 13;
    public static final int e_Experimental = 1;
    public static final int e_Expired = 4;
    public static final int e_Final = 7;
    public static final int e_ForComment = 10;
    public static final int e_ForPublicRelease = 12;
    public static final int e_NotApproved = 2;
    public static final int e_NotForPublicRelease = 5;
    public static final int e_Sold = 8;
    public static final int e_TopSecret = 11;
    public static final int e_Unknown = 14;

    static native long Create(long j, long j2);

    static native long CreateCustom(long j, long j2, long j3);

    static native int GetIcon(long j);

    static native String GetIconName(long j);

    static native void SetIcon(long j, int i);

    static native void SetIcon(long j, String str);

    static native void SetOpacity(long j, double d);

    public RubberStamp(Obj obj) {
        super(obj);
    }

    public RubberStamp() {
    }

    private RubberStamp(long j, Object obj) {
        super(j, obj);
    }

    public RubberStamp(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static RubberStamp create(Doc doc, Rect rect) throws PDFNetException {
        RubberStamp rubberStamp = new RubberStamp(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return rubberStamp;
    }

    public static RubberStamp createCustom(Doc doc, Rect rect, Obj obj) throws PDFNetException {
        RubberStamp rubberStamp = new RubberStamp(CreateCustom(doc.__GetHandle(), rect.__GetHandle(), obj.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        ReachabilityHelper.ensureReachable(obj);
        return rubberStamp;
    }

    public int getIcon() throws PDFNetException {
        return GetIcon(__GetHandle());
    }

    public void SetIcon(int i) throws PDFNetException {
        SetIcon(__GetHandle(), i);
    }

    public String getIconName() throws PDFNetException {
        return GetIconName(__GetHandle());
    }

    public void setIcon(String str) throws PDFNetException {
        SetIcon(__GetHandle(), str);
    }

    public void SetOpacity(double d) {
        SetOpacity(__GetHandle(), d);
    }
}
