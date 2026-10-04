package com.pdftron.pdf.struct;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class ClassMap {

    /* JADX INFO: renamed from: a */
    private long f2163a;

    /* JADX INFO: renamed from: b */
    private Object f2164b;

    static native boolean IsValid(long j);

    public ClassMap(Obj obj) {
        this.f2163a = obj.__GetHandle();
        this.f2164b = obj.__GetRefHandle();
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f2163a);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.f2163a, this.f2164b);
    }

    ClassMap(long j, Object obj) {
        this.f2163a = j;
        this.f2164b = obj;
    }
}
