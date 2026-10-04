package com.pdftron.pdf.ocg;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class Context {
    public static final int e_AllOC = 1;
    public static final int e_NoOC = 2;
    public static final int e_VisibleOC = 0;

    /* JADX INFO: renamed from: a */
    long f2152a;

    /* JADX INFO: renamed from: b */
    private Object f2153b;

    /* JADX INFO: renamed from: c */
    private boolean f2154c;

    static native long ContextCreateCfg(long j);

    static native long ContextCreateCtx(long j);

    static native void Destroy(long j);

    static native int GetOCMode(long j);

    static native boolean GetState(long j, long j2);

    static native void ResetStates(long j, boolean z);

    static native void SetNonOCDrawing(long j, boolean z);

    static native void SetOCDrawMode(long j, int i);

    static native void SetState(long j, long j2, boolean z);

    public Context(Context context) throws PDFNetException {
        this.f2154c = true;
        this.f2152a = ContextCreateCtx(context.f2152a);
        this.f2153b = context.f2153b;
        this.f2154c = true;
    }

    public Context(Config config) throws PDFNetException {
        this.f2154c = true;
        this.f2152a = ContextCreateCfg(config.f2150a);
        this.f2153b = config.f2151b;
        this.f2154c = true;
    }

    protected void finalize() throws Throwable {
        if (this.f2154c) {
            Destroy(this.f2152a);
        }
        this.f2152a = 0L;
        this.f2153b = null;
    }

    public boolean getState(Group group) throws PDFNetException {
        boolean zGetState = GetState(this.f2152a, group.f2155a);
        ReachabilityHelper.ensureReachable(group);
        return zGetState;
    }

    public void setState(Group group, boolean z) throws PDFNetException {
        SetState(this.f2152a, group.f2155a, z);
        ReachabilityHelper.ensureReachable(group);
    }

    public void resetStates(boolean z) throws PDFNetException {
        ResetStates(this.f2152a, z);
    }

    public void setNonOCDrawing(boolean z) throws PDFNetException {
        SetNonOCDrawing(this.f2152a, z);
    }

    public void setOCDrawMode(int i) throws PDFNetException {
        SetOCDrawMode(this.f2152a, i);
    }

    public int getOCMode() throws PDFNetException {
        return GetOCMode(this.f2152a);
    }

    public long __GetHandle() {
        return this.f2152a;
    }

    private Context(long j, Object obj) {
        this.f2152a = j;
        this.f2153b = obj;
        this.f2154c = false;
    }

    public static Context __Create(long j, Object obj) {
        if (j == 0) {
            return null;
        }
        return new Context(j, obj);
    }
}
