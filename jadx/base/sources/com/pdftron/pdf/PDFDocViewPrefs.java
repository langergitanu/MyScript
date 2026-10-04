package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class PDFDocViewPrefs {
    public static final int e_CenterWindow = 4;
    public static final int e_Default = 0;
    public static final int e_DisplayDocTitle = 5;
    public static final int e_FitWindow = 3;
    public static final int e_FullScreen = 3;
    public static final int e_HideMenubar = 1;
    public static final int e_HideToolbar = 0;
    public static final int e_HideWindowUI = 2;
    public static final int e_OneColumn = 2;
    public static final int e_SinglePage = 1;
    public static final int e_TwoColumnLeft = 3;
    public static final int e_TwoColumnRight = 4;
    public static final int e_TwoPageLeft = 5;
    public static final int e_TwoPageRight = 6;
    public static final int e_UseAttachments = 5;
    public static final int e_UseBookmarks = 2;
    public static final int e_UseNone = 0;
    public static final int e_UseOC = 4;
    public static final int e_UseThumbs = 1;

    /* JADX INFO: renamed from: a */
    private long f1627a;

    /* JADX INFO: renamed from: b */
    private Object f1628b;

    static native boolean GetDirection(long j);

    static native int GetLayoutMode(long j);

    static native int GetNonFullScreenPageMode(long j);

    static native int GetPageMode(long j);

    static native boolean GetPref(long j, int i);

    static native int GetPrintArea(long j);

    static native int GetPrintClip(long j);

    static native int GetViewArea(long j);

    static native int GetViewClip(long j);

    static native void SetDirection(long j, boolean z);

    static native void SetInitialPage(long j, long j2);

    static native void SetLayoutMode(long j, int i);

    static native void SetNonFullScreenPageMode(long j, int i);

    static native void SetPageMode(long j, int i);

    static native void SetPref(long j, int i, boolean z);

    static native void SetPrintArea(long j, int i);

    static native void SetPrintClip(long j, int i);

    static native void SetViewArea(long j, int i);

    static native void SetViewClip(long j, int i);

    public void setInitialPage(Destination destination) throws PDFNetException {
        SetInitialPage(this.f1627a, destination.f1516a);
        ReachabilityHelper.ensureReachable(destination);
    }

    public void setPageMode(int i) throws PDFNetException {
        SetPageMode(this.f1627a, i);
    }

    public int getPageMode() throws PDFNetException {
        return GetPageMode(this.f1627a);
    }

    public void setLayoutMode(int i) throws PDFNetException {
        SetLayoutMode(this.f1627a, i);
    }

    public int getLayoutMode() throws PDFNetException {
        return GetLayoutMode(this.f1627a);
    }

    public void setPref(int i, boolean z) throws PDFNetException {
        SetPref(this.f1627a, i, z);
    }

    public boolean getPref(int i) throws PDFNetException {
        return GetPref(this.f1627a, i);
    }

    public void setNonFullScreenPageMode(int i) throws PDFNetException {
        SetNonFullScreenPageMode(this.f1627a, i);
    }

    public int getNonFullScreenPageMode() throws PDFNetException {
        return GetNonFullScreenPageMode(this.f1627a);
    }

    public void setDirection(boolean z) throws PDFNetException {
        SetDirection(this.f1627a, z);
    }

    public boolean getDirection() throws PDFNetException {
        return GetDirection(this.f1627a);
    }

    public void setViewArea(int i) throws PDFNetException {
        SetViewArea(this.f1627a, i);
    }

    public int getViewArea() throws PDFNetException {
        return GetViewArea(this.f1627a);
    }

    public void setViewClip(int i) throws PDFNetException {
        SetViewClip(this.f1627a, i);
    }

    public int getViewClip() throws PDFNetException {
        return GetViewClip(this.f1627a);
    }

    public void setPrintArea(int i) throws PDFNetException {
        SetPrintArea(this.f1627a, i);
    }

    public int getPrintArea() throws PDFNetException {
        return GetPrintArea(this.f1627a);
    }

    public void setPrintClip(int i) throws PDFNetException {
        SetPrintClip(this.f1627a, i);
    }

    public int getPrintClip() throws PDFNetException {
        return GetPrintClip(this.f1627a);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.f1627a, this.f1628b);
    }

    public PDFDocViewPrefs(Obj obj) {
        this.f1627a = obj.__GetHandle();
        this.f1628b = obj.__GetRefHandle();
    }

    PDFDocViewPrefs(long j, Object obj) {
        this.f1627a = j;
        this.f1628b = obj;
    }
}
