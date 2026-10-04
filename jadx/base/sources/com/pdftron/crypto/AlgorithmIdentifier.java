package com.pdftron.crypto;

import com.pdftron.common.PDFNetException;
import com.pdftron.crypto.ObjectIdentifier;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class AlgorithmIdentifier implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1385a;

    static native long CreateFromDigestAlgorithm(int i);

    static native long CreateFromDigestAlgorithmAndParams(int i, long j);

    static native long CreateFromObjectIdentifier(long j);

    static native long CreateFromObjectIdentifierAndParams(long j, long j2);

    static native long CreateFromPredefined(int i);

    static native long CreateFromPredefinedAndParams(int i, long j);

    static native void Destroy(long j);

    public void destroy() throws PDFNetException {
        long j = this.f1385a;
        if (j != 0) {
            Destroy(j);
            this.f1385a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public AlgorithmIdentifier(long j) {
        this.f1385a = j;
    }

    public AlgorithmIdentifier(ObjectIdentifier.Predefined predefined) throws PDFNetException {
        this.f1385a = CreateFromPredefined(predefined.getValue());
    }

    public AlgorithmIdentifier(ObjectIdentifier objectIdentifier) throws PDFNetException {
        this.f1385a = CreateFromObjectIdentifier(objectIdentifier.__GetHandle());
        ReachabilityHelper.ensureReachable(objectIdentifier);
    }

    public AlgorithmIdentifier(DigestAlgorithm digestAlgorithm) throws PDFNetException {
        this.f1385a = CreateFromDigestAlgorithm(digestAlgorithm.value);
    }

    public AlgorithmIdentifier(ObjectIdentifier.Predefined predefined, AlgorithmParams algorithmParams) throws PDFNetException {
        this.f1385a = CreateFromPredefinedAndParams(predefined.getValue(), algorithmParams.__GetHandle());
        ReachabilityHelper.ensureReachable(algorithmParams);
    }

    public AlgorithmIdentifier(ObjectIdentifier objectIdentifier, AlgorithmParams algorithmParams) throws PDFNetException {
        this.f1385a = CreateFromObjectIdentifierAndParams(objectIdentifier.__GetHandle(), algorithmParams.__GetHandle());
        ReachabilityHelper.ensureReachable(objectIdentifier);
        ReachabilityHelper.ensureReachable(algorithmParams);
    }

    public AlgorithmIdentifier(DigestAlgorithm digestAlgorithm, AlgorithmParams algorithmParams) throws PDFNetException {
        this.f1385a = CreateFromDigestAlgorithmAndParams(digestAlgorithm.value, algorithmParams.__GetHandle());
        ReachabilityHelper.ensureReachable(algorithmParams);
    }

    public long __GetHandle() {
        return this.f1385a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
