package com.pdftron.pdf.ocg;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.PDFDoc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Config {

    /* JADX INFO: renamed from: a */
    long f2150a;

    /* JADX INFO: renamed from: b */
    Object f2151b;

    static native long Create(long j, boolean z);

    static native String GetCreator(long j);

    static native String GetInitBaseState(long j);

    static native long GetInitOffStates(long j);

    static native long GetInitOnStates(long j);

    static native long GetIntent(long j);

    static native long GetLockedOCGs(long j);

    static native String GetName(long j);

    static native long GetOrder(long j);

    static native long GetRBGroups(long j);

    static native void SetCreator(long j, String str);

    static native void SetInitBaseState(long j, String str);

    static native void SetInitOffStates(long j, long j2);

    static native void SetInitOnStates(long j, long j2);

    static native void SetIntent(long j, long j2);

    static native void SetLockedOCGs(long j, long j2);

    static native void SetName(long j, String str);

    static native void SetOrder(long j, long j2);

    static native void SetRBGroups(long j, long j2);

    public static Config create(PDFDoc pDFDoc, boolean z) throws PDFNetException {
        return new Config(Create(pDFDoc.__GetHandle(), z), pDFDoc);
    }

    public boolean IsValid() {
        return this.f2150a != 0;
    }

    public Config(Obj obj) {
        this.f2150a = obj.__GetHandle();
        this.f2151b = obj.__GetRefHandle();
    }

    public Obj getOrder() throws PDFNetException {
        return Obj.__Create(GetOrder(this.f2150a), this.f2151b);
    }

    public void setOrder(Obj obj) throws PDFNetException {
        SetOrder(this.f2150a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public String getName() throws PDFNetException {
        return GetName(this.f2150a);
    }

    public void setName(String str) throws PDFNetException {
        SetName(this.f2150a, str);
    }

    public String getCreator() throws PDFNetException {
        return GetCreator(this.f2150a);
    }

    public void setCreator(String str) throws PDFNetException {
        SetCreator(this.f2150a, str);
    }

    public String getInitBaseState() throws PDFNetException {
        return GetInitBaseState(this.f2150a);
    }

    public Obj getInitOnStates() throws PDFNetException {
        return Obj.__Create(GetInitOnStates(this.f2150a), this.f2151b);
    }

    public Obj getInitOffStates() throws PDFNetException {
        return Obj.__Create(GetInitOffStates(this.f2150a), this.f2151b);
    }

    public void setInitBaseState(String str) throws PDFNetException {
        SetInitBaseState(this.f2150a, str);
    }

    public void setInitOnStates(Obj obj) throws PDFNetException {
        SetInitOnStates(this.f2150a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public void setInitOffStates(Obj obj) throws PDFNetException {
        SetInitOffStates(this.f2150a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public Obj getIntent() throws PDFNetException {
        return Obj.__Create(GetIntent(this.f2150a), this.f2151b);
    }

    public void setIntent(Obj obj) throws PDFNetException {
        SetIntent(this.f2150a, obj.__GetHandle());
    }

    public Obj getLockedOCGs() throws PDFNetException {
        return Obj.__Create(GetLockedOCGs(this.f2150a), this.f2151b);
    }

    public void setLockedOCGs(Obj obj) throws PDFNetException {
        SetLockedOCGs(this.f2150a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public Obj getRBGroups() throws PDFNetException {
        return Obj.__Create(GetRBGroups(this.f2150a), this.f2151b);
    }

    public void setRBGroups(Obj obj) throws PDFNetException {
        SetRBGroups(this.f2150a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(this.f2150a, this.f2151b);
    }

    private Config(long j, Object obj) {
        this.f2150a = j;
        this.f2151b = obj;
    }

    public static Config __Create(long j, Object obj) {
        if (j == 0) {
            return null;
        }
        return new Config(j, obj);
    }
}
