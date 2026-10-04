package com.pdftron.pdf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class ColorPt implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    long f1458a;

    static native long ColorPtCreate(double d, double d2, double d3, double d4);

    static native void Destroy(long j);

    static native boolean Equals(long j, long j2);

    static native double Get(long j, int i);

    static native int HashCode(long j);

    static native void Set(long j, double d, double d2, double d3, double d4);

    static native void Set(long j, int i, double d);

    static native void SetColorantNum(long j, int i);

    public ColorPt() throws PDFNetException {
        this.f1458a = ColorPtCreate(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public ColorPt(double d, double d2, double d3) throws PDFNetException {
        this.f1458a = ColorPtCreate(d, d2, d3, 1.0d);
    }

    public ColorPt(double d, double d2, double d3, double d4) throws PDFNetException {
        this.f1458a = ColorPtCreate(d, d2, d3, d4);
    }

    public void destroy() throws PDFNetException {
        long j = this.f1458a;
        if (j != 0) {
            Destroy(j);
            this.f1458a = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        return Equals(this.f1458a, ((ColorPt) obj).f1458a);
    }

    public int hashCode() {
        return HashCode(this.f1458a);
    }

    public void set() throws PDFNetException {
        Set(this.f1458a, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public void set(double d, double d2, double d3, double d4) throws PDFNetException {
        Set(this.f1458a, d, d2, d3, d4);
    }

    public void set(int i, double d) throws PDFNetException {
        Set(this.f1458a, i, d);
    }

    public double get(int i) throws PDFNetException {
        return Get(this.f1458a, i);
    }

    public void setColorantNum(int i) throws PDFNetException {
        SetColorantNum(this.f1458a, i);
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    ColorPt(long j) {
        this.f1458a = j;
    }

    public static ColorPt __Create(long j) {
        if (j == 0) {
            return null;
        }
        return new ColorPt(j);
    }

    public long __GetHandle() {
        return this.f1458a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
