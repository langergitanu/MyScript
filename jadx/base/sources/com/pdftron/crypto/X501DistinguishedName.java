package com.pdftron.crypto;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class X501DistinguishedName implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1393a;

    static native void Destroy(long j);

    static native long[] GetAllAttributesAndValues(long j);

    static native String[] GetStringValuesForAttribute(long j, long j2);

    static native boolean HasAttribute(long j, long j2);

    public void destroy() throws PDFNetException {
        long j = this.f1393a;
        if (j != 0) {
            Destroy(j);
            this.f1393a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public X501DistinguishedName(long j) {
        this.f1393a = j;
    }

    public boolean hasAttribute(ObjectIdentifier objectIdentifier) throws PDFNetException {
        boolean zHasAttribute = HasAttribute(this.f1393a, objectIdentifier.__GetHandle());
        ReachabilityHelper.ensureReachable(objectIdentifier);
        return zHasAttribute;
    }

    public String[] getStringValuesForAttribute(ObjectIdentifier objectIdentifier) throws PDFNetException {
        String[] strArrGetStringValuesForAttribute = GetStringValuesForAttribute(this.f1393a, objectIdentifier.__GetHandle());
        ReachabilityHelper.ensureReachable(objectIdentifier);
        return strArrGetStringValuesForAttribute;
    }

    public X501AttributeTypeAndValue[] getAllAttributesAndValues() throws PDFNetException {
        long[] jArrGetAllAttributesAndValues = GetAllAttributesAndValues(this.f1393a);
        X501AttributeTypeAndValue[] x501AttributeTypeAndValueArr = new X501AttributeTypeAndValue[jArrGetAllAttributesAndValues.length];
        for (int i = 0; i < jArrGetAllAttributesAndValues.length; i++) {
            x501AttributeTypeAndValueArr[i] = new X501AttributeTypeAndValue(jArrGetAllAttributesAndValues[i]);
        }
        return x501AttributeTypeAndValueArr;
    }

    public long __GetHandle() {
        return this.f1393a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
