package com.pdftron.pdf.ocg;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.PDFDoc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Group {

    /* JADX INFO: renamed from: a */
    long f2155a;

    /* JADX INFO: renamed from: b */
    private Object f2156b;

    static native long Create(long j, String str);

    static native boolean GetCurrentState(long j, long j2);

    static native boolean GetInitialState(long j, long j2);

    static native long GetIntent(long j);

    static native String GetName(long j);

    static native boolean HasUsage(long j);

    static native boolean IsLocked(long j, long j2);

    static native boolean IsValid(long j);

    static native void SetCurrentState(long j, long j2, boolean z);

    static native void SetInitialState(long j, long j2, boolean z);

    static native void SetIntent(long j, long j2);

    static native void SetLocked(long j, long j2, boolean z);

    static native void SetName(long j, String str);

    public static Group create(PDFDoc pDFDoc, String str) throws PDFNetException {
        return new Group(Create(pDFDoc.__GetHandle(), str), pDFDoc);
    }

    public Group(Obj obj) {
        this.f2155a = obj.__GetHandle();
        this.f2156b = obj.__GetRefHandle();
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f2155a);
    }

    public String getName() throws PDFNetException {
        return GetName(this.f2155a);
    }

    public void setName(String str) throws PDFNetException {
        SetName(this.f2155a, str);
    }

    public boolean getCurrentState(Context context) throws PDFNetException {
        boolean zGetCurrentState = GetCurrentState(this.f2155a, context.f2152a);
        ReachabilityHelper.ensureReachable(context);
        return zGetCurrentState;
    }

    public void setCurrentState(Context context, boolean z) throws PDFNetException {
        SetCurrentState(this.f2155a, context.f2152a, z);
        ReachabilityHelper.ensureReachable(context);
    }

    public boolean getInitialState(Config config) throws PDFNetException {
        boolean zGetInitialState = GetInitialState(this.f2155a, config.f2150a);
        ReachabilityHelper.ensureReachable(config);
        return zGetInitialState;
    }

    public void setInitialState(Config config, boolean z) throws PDFNetException {
        SetInitialState(this.f2155a, config.f2150a, z);
        ReachabilityHelper.ensureReachable(config);
    }

    public Obj getIntent() throws PDFNetException {
        return Obj.__Create(GetIntent(this.f2155a), this.f2156b);
    }

    public void setIntent(Obj obj) throws PDFNetException {
        SetIntent(this.f2155a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public boolean isLocked(Config config) throws PDFNetException {
        boolean zIsLocked = IsLocked(this.f2155a, config.f2150a);
        ReachabilityHelper.ensureReachable(config);
        return zIsLocked;
    }

    public void setLocked(Config config, boolean z) throws PDFNetException {
        SetLocked(this.f2155a, config.f2150a, z);
        ReachabilityHelper.ensureReachable(config);
    }

    public boolean hasUsage() throws PDFNetException {
        return HasUsage(this.f2155a);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(this.f2155a, this.f2156b);
    }

    public static Group __Create(long j, Object obj) {
        return new Group(j, obj);
    }

    private Group(long j, Object obj) {
        this.f2155a = j;
        this.f2156b = obj;
    }
}
