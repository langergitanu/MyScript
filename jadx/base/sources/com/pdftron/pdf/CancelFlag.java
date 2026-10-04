package com.pdftron.pdf;

/* JADX INFO: loaded from: classes7.dex */
public class CancelFlag {

    /* JADX INFO: renamed from: a */
    private long f1455a = Create();

    static native long Create();

    static native void Destroy(long j);

    static native void Set(long j, boolean z);

    public void set(boolean z) {
        Set(this.f1455a, z);
    }

    public void destroy() {
        Destroy(this.f1455a);
    }

    public long __GetHandle() {
        return this.f1455a;
    }
}
