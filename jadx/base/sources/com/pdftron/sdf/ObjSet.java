package com.pdftron.sdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class ObjSet implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f2182a = Create();

    static native long Create();

    static native long CreateArray(long j);

    static native long CreateBool(long j, boolean z);

    static native long CreateDict(long j);

    static native long CreateFromJson(long j, String str);

    static native long CreateName(long j, String str);

    static native long CreateNull(long j);

    static native long CreateNumber(long j, double d);

    static native long CreateString(long j, String str);

    static native void Destroy(long j);

    public void destroy() {
        long j = this.f2182a;
        if (j != 0) {
            Destroy(j);
            this.f2182a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public Obj createName(String str) throws PDFNetException {
        return Obj.__Create(CreateName(this.f2182a, str), this);
    }

    public Obj createArray() throws PDFNetException {
        return Obj.__Create(CreateArray(this.f2182a), this);
    }

    public Obj createBool(boolean z) throws PDFNetException {
        return Obj.__Create(CreateBool(this.f2182a, z), this);
    }

    public Obj createDict() throws PDFNetException {
        return Obj.__Create(CreateDict(this.f2182a), this);
    }

    public Obj createNull() throws PDFNetException {
        return Obj.__Create(CreateNull(this.f2182a), this);
    }

    public Obj createNumber(double d) throws PDFNetException {
        return Obj.__Create(CreateNumber(this.f2182a, d), this);
    }

    public Obj createString(String str) throws PDFNetException {
        return Obj.__Create(CreateString(this.f2182a, str), this);
    }

    public Obj createFromJson(String str) throws PDFNetException {
        return Obj.__Create(CreateFromJson(this.f2182a, str), this);
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
