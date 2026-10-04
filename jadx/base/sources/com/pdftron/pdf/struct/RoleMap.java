package com.pdftron.pdf.struct;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class RoleMap {

    /* JADX INFO: renamed from: a */
    private long f2167a;

    /* JADX INFO: renamed from: b */
    private Object f2168b;

    static native String GetDirectMap(long j, String str);

    static native boolean IsValid(long j);

    public RoleMap(Obj obj) {
        this.f2167a = obj.__GetHandle();
        this.f2168b = obj.__GetRefHandle();
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f2167a);
    }

    public String getDirectMap(String str) throws PDFNetException {
        return GetDirectMap(this.f2167a, str);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.f2167a, this.f2168b);
    }

    RoleMap(long j, Object obj) {
        this.f2167a = j;
        this.f2168b = obj;
    }
}
