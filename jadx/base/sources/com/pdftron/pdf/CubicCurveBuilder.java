package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class CubicCurveBuilder implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1487a;

    static native void AddSourcePoint(long j, double d, double d2);

    static native void Destroy(long j);

    static native double GetCubicXCoord(long j, int i);

    static native double GetCubicYCoord(long j, int i);

    static native int NumCubicPoints(long j);

    static native int NumSourcePoints(long j);

    public void destroy() throws PDFNetException {
        long j = this.f1487a;
        if (j != 0) {
            Destroy(j);
            this.f1487a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public CubicCurveBuilder(long j) {
        this.f1487a = j;
    }

    public int numSourcePoints() throws PDFNetException {
        return NumSourcePoints(this.f1487a);
    }

    public void addSourcePoint(double d, double d2) throws PDFNetException {
        AddSourcePoint(this.f1487a, d, d2);
    }

    public int numCubicPoints() throws PDFNetException {
        return NumCubicPoints(this.f1487a);
    }

    public double getCubicXCoord(int i) throws PDFNetException {
        return GetCubicXCoord(this.f1487a, i);
    }

    public double getCubicYCoord(int i) throws PDFNetException {
        return GetCubicYCoord(this.f1487a, i);
    }

    public long __GetHandle() {
        return this.f1487a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
