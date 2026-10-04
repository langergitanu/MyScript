package com.pdftron.sdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class NameTree {

    /* JADX INFO: renamed from: a */
    private long f2176a;

    /* JADX INFO: renamed from: b */
    private Object f2177b;

    static native long Create(long j, String str);

    static native void Erase(long j, long j2);

    static native void Erase(long j, byte[] bArr);

    static native long Find(long j, String str);

    static native long GetIterator(long j);

    static native long GetIterator(long j, byte[] bArr);

    static native long GetValue(long j, byte[] bArr);

    static native boolean IsValid(long j);

    static native void Put(long j, byte[] bArr, long j2);

    public static NameTree create(Doc doc, String str) throws PDFNetException {
        NameTree nameTree = new NameTree(Create(doc.impl, str), doc);
        ReachabilityHelper.ensureReachable(doc);
        return nameTree;
    }

    public static NameTree find(Doc doc, String str) throws PDFNetException {
        NameTree nameTree = new NameTree(Find(doc.impl, str), doc);
        ReachabilityHelper.ensureReachable(doc);
        return nameTree;
    }

    public NameTree(Obj obj) {
        this.f2176a = obj.f2180a;
        this.f2177b = obj.f2181b;
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f2176a);
    }

    public NameTreeIterator getIterator(byte[] bArr) throws PDFNetException {
        return new NameTreeIterator(GetIterator(this.f2176a, bArr), this.f2177b);
    }

    public Obj getValue(byte[] bArr) throws PDFNetException {
        return Obj.__Create(GetValue(this.f2176a, bArr), this.f2177b);
    }

    public NameTreeIterator getIterator() throws PDFNetException {
        return new NameTreeIterator(GetIterator(this.f2176a), this.f2177b);
    }

    public void put(byte[] bArr, Obj obj) throws PDFNetException {
        Put(this.f2176a, bArr, obj.f2180a);
        ReachabilityHelper.ensureReachable(obj);
    }

    public void erase(byte[] bArr) throws PDFNetException {
        Erase(this.f2176a, bArr);
    }

    public void erase(DictIterator dictIterator) throws PDFNetException {
        Erase(this.f2176a, dictIterator.f2173a);
        ReachabilityHelper.ensureReachable(dictIterator);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.f2176a, this.f2177b);
    }

    private NameTree(long j, Object obj) {
        this.f2176a = j;
        this.f2177b = obj;
    }
}
