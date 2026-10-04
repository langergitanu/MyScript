package com.pdftron.pdf.struct;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class STree {

    /* JADX INFO: renamed from: a */
    private long f2171a;

    /* JADX INFO: renamed from: b */
    private Object f2172b;

    static native long GetClassMap(long j);

    static native long GetElement(long j, String str);

    static native long GetElement(long j, byte[] bArr);

    static native long GetKid(long j, int i);

    static native int GetNumKids(long j);

    static native long GetRoleMap(long j);

    static native boolean IsValid(long j);

    public STree(Obj obj) {
        this.f2171a = obj.__GetHandle();
        this.f2172b = obj.__GetRefHandle();
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f2171a);
    }

    public int getNumKids() throws PDFNetException {
        return GetNumKids(this.f2171a);
    }

    public SElement getKid(int i) throws PDFNetException {
        return new SElement(GetKid(this.f2171a, i), this.f2172b);
    }

    public SElement getElement(String str) throws PDFNetException {
        return new SElement(GetElement(this.f2171a, str), this.f2172b);
    }

    public SElement getElement(byte[] bArr) throws PDFNetException {
        return new SElement(GetElement(this.f2171a, bArr), this.f2172b);
    }

    public RoleMap getRoleMap() throws PDFNetException {
        return new RoleMap(GetRoleMap(this.f2171a), this.f2172b);
    }

    public ClassMap getClassMap() throws PDFNetException {
        return new ClassMap(GetClassMap(this.f2171a), this.f2172b);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(this.f2171a, this.f2172b);
    }

    public static STree __Create(long j, Object obj) {
        return new STree(j, obj);
    }

    STree(long j, Object obj) {
        this.f2171a = j;
        this.f2172b = obj;
    }
}
