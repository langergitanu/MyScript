package com.pdftron.pdf.struct;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class AttrObj {

    /* JADX INFO: renamed from: a */
    private long f2161a;

    /* JADX INFO: renamed from: b */
    private Object f2162b;

    static native String GetOwner(long j);

    public AttrObj(Obj obj) {
        this.f2161a = obj.__GetHandle();
        this.f2162b = obj.__GetRefHandle();
    }

    public String getOwner() throws PDFNetException {
        return GetOwner(this.f2161a);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.f2161a, this.f2162b);
    }
}
