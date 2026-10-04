package com.pdftron.filters;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class ZStandardCompressor {

    /* JADX INFO: renamed from: a */
    private long f1414a;

    private static native String CompressAsBase85(long j, String str);

    private static native long Create(byte[] bArr, int i);

    private static native String DecompressBase85(long j, String str);

    public ZStandardCompressor(byte[] bArr, int i) throws PDFNetException {
        this.f1414a = Create(bArr, i);
    }

    public String compressAsBase85(String str) throws PDFNetException {
        return CompressAsBase85(this.f1414a, str);
    }

    public String decompressBase85(String str) throws PDFNetException {
        return DecompressBase85(this.f1414a, str);
    }
}
