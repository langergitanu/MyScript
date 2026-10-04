package com.pdftron.crypto;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class RSASSAPSSParams extends AlgorithmParams {
    static native long Create();

    static native long CreateFromAlgoIdAndSaltLen(long j, int i);

    static native long GetDigestAlgorithm(long j);

    static native long GetMaskGenAlgorithm(long j);

    static native int GetSaltLength(long j);

    static native int GetTrailerField(long j);

    static native void SetDigestAlgorithm(long j, long j2);

    static native void SetMaskGenAlgorithm(long j, long j2);

    static native void SetSaltLength(long j, int i);

    static native void SetTrailerField(long j, int i);

    public AlgorithmIdentifier getDigestAlgorithm() throws PDFNetException {
        return new AlgorithmIdentifier(GetDigestAlgorithm(__GetHandle()));
    }

    public AlgorithmIdentifier getMaskGenAlgorithm() throws PDFNetException {
        return new AlgorithmIdentifier(GetMaskGenAlgorithm(__GetHandle()));
    }

    public int getSaltLength() throws PDFNetException {
        return GetSaltLength(__GetHandle());
    }

    public int getTrailerField() throws PDFNetException {
        return GetTrailerField(__GetHandle());
    }

    public void setDigestAlgorithm(AlgorithmIdentifier algorithmIdentifier) throws PDFNetException {
        SetDigestAlgorithm(__GetHandle(), algorithmIdentifier.__GetHandle());
        ReachabilityHelper.ensureReachable(algorithmIdentifier);
    }

    public void setMaskGenAlgorithm(AlgorithmIdentifier algorithmIdentifier) throws PDFNetException {
        SetMaskGenAlgorithm(__GetHandle(), algorithmIdentifier.__GetHandle());
        ReachabilityHelper.ensureReachable(algorithmIdentifier);
    }

    public void setSaltLength(int i) throws PDFNetException {
        SetSaltLength(__GetHandle(), i);
    }

    public void setTrailerField(int i) throws PDFNetException {
        SetTrailerField(__GetHandle(), i);
    }

    public RSASSAPSSParams() throws PDFNetException {
        super(Create());
    }

    public RSASSAPSSParams(AlgorithmIdentifier algorithmIdentifier, int i) throws PDFNetException {
        super(CreateFromAlgoIdAndSaltLen(algorithmIdentifier.__GetHandle(), i));
        ReachabilityHelper.ensureReachable(algorithmIdentifier);
    }
}
