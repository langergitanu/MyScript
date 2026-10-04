package com.pdftron.sdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class NumberTree {

    /* JADX INFO: renamed from: a */
    private long f2178a;

    /* JADX INFO: renamed from: b */
    private Object f2179b;

    static native void Erase(long j, long j2);

    static native void EraseIt(long j, long j2);

    static native long GetIterator(long j);

    static native long GetIterator(long j, long j2);

    static native long GetValue(long j, long j2);

    static native void Put(long j, long j2, long j3);

    public NumberTree(Obj obj) {
        this.f2178a = obj.f2180a;
        this.f2179b = obj.f2181b;
    }

    public boolean isValid() throws PDFNetException {
        return this.f2178a != 0;
    }

    public DictIterator getIterator(long j) throws PDFNetException {
        return new NumberTreeIterator(GetIterator(this.f2178a, j), this.f2179b);
    }

    public Obj getValue(long j) throws PDFNetException {
        return Obj.__Create(GetValue(this.f2178a, j), this.f2179b);
    }

    public DictIterator getIterator() throws PDFNetException {
        return new NumberTreeIterator(GetIterator(this.f2178a), this.f2179b);
    }

    public void put(long j, Obj obj) throws PDFNetException {
        Put(this.f2178a, j, obj.f2180a);
        ReachabilityHelper.ensureReachable(obj);
    }

    public void erase(long j) throws PDFNetException {
        Erase(this.f2178a, j);
    }

    public void erase(DictIterator dictIterator) throws PDFNetException {
        EraseIt(this.f2178a, dictIterator.f2173a);
        ReachabilityHelper.ensureReachable(dictIterator);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.f2178a, this.f2179b);
    }
}
