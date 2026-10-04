package com.pdftron.common;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Point;

/* JADX INFO: loaded from: classes7.dex */
public class Matrix2D implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1383a;

    static native void Concat(long j, double d, double d2, double d3, double d4, double d5, double d6);

    static native void Destroy(long j);

    static native boolean Equals(long j, long j2);

    static native int HashCode(long j);

    static native long Inverse(long j);

    static native long Matrix2DCreate(double d, double d2, double d3, double d4, double d5, double d6);

    static native double[] Mult(long j, double d, double d2);

    static native long Multiply(long j, long j2);

    static native void PostTranslate(long j, double d, double d2);

    static native void PreTranslate(long j, double d, double d2);

    static native long RotationMatrix(double d);

    static native void Scale(long j, double d, double d2);

    static native void Set(long j, double d, double d2, double d3, double d4, double d5, double d6);

    static native void Translate(long j, double d, double d2);

    static native double getA(long j);

    static native double getB(long j);

    static native double getC(long j);

    static native double getD(long j);

    static native double getH(long j);

    static native double getV(long j);

    static native void setA(long j, double d);

    static native void setB(long j, double d);

    static native void setC(long j, double d);

    static native void setD(long j, double d);

    static native void setH(long j, double d);

    static native void setV(long j, double d);

    public double getA() throws PDFNetException {
        return getA(this.f1383a);
    }

    public void setA(double d) throws PDFNetException {
        setA(this.f1383a, d);
    }

    public double getB() throws PDFNetException {
        return getB(this.f1383a);
    }

    public void setB(double d) throws PDFNetException {
        setB(this.f1383a, d);
    }

    public double getC() throws PDFNetException {
        return getC(this.f1383a);
    }

    public void setC(double d) throws PDFNetException {
        setC(this.f1383a, d);
    }

    public double getD() throws PDFNetException {
        return getD(this.f1383a);
    }

    public void setD(double d) throws PDFNetException {
        setD(this.f1383a, d);
    }

    public double getH() throws PDFNetException {
        return getH(this.f1383a);
    }

    public void setH(double d) throws PDFNetException {
        setH(this.f1383a, d);
    }

    public double getV() throws PDFNetException {
        return getV(this.f1383a);
    }

    public void setV(double d) throws PDFNetException {
        setV(this.f1383a, d);
    }

    public Matrix2D() throws PDFNetException {
        this.f1383a = Matrix2DCreate(1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public Matrix2D(double d, double d2, double d3, double d4, double d5, double d6) throws PDFNetException {
        this.f1383a = Matrix2DCreate(d, d2, d3, d4, d5, d6);
    }

    public void set(double d, double d2, double d3, double d4, double d5, double d6) throws PDFNetException {
        Set(this.f1383a, d, d2, d3, d4, d5, d6);
    }

    public void concat(double d, double d2, double d3, double d4, double d5, double d6) throws PDFNetException {
        Concat(this.f1383a, d, d2, d3, d4, d5, d6);
    }

    public Matrix2D multiply(Matrix2D matrix2D) throws PDFNetException {
        return new Matrix2D(Multiply(this.f1383a, matrix2D.f1383a));
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        boolean zEquals = Equals(this.f1383a, ((Matrix2D) obj).f1383a);
        ReachabilityHelper.ensureReachable(obj);
        return zEquals;
    }

    public int hashCode() {
        return HashCode(this.f1383a);
    }

    public Point multPoint(double d, double d2) throws PDFNetException {
        double[] dArrMult = Mult(this.f1383a, d, d2);
        return new Point(dArrMult[0], dArrMult[1]);
    }

    public Matrix2D inverse() throws PDFNetException {
        return new Matrix2D(Inverse(this.f1383a));
    }

    public Matrix2D translate(double d, double d2) throws PDFNetException {
        Translate(this.f1383a, d, d2);
        return this;
    }

    public Matrix2D preTranslate(double d, double d2) {
        PreTranslate(this.f1383a, d, d2);
        return this;
    }

    public Matrix2D postTranslate(double d, double d2) {
        PostTranslate(this.f1383a, d, d2);
        return this;
    }

    public Matrix2D scale(double d, double d2) throws PDFNetException {
        Scale(this.f1383a, d, d2);
        return this;
    }

    public static Matrix2D zeroMatrix() throws PDFNetException {
        return new Matrix2D(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public static Matrix2D identityMatrix() throws PDFNetException {
        return new Matrix2D();
    }

    public static Matrix2D rotationMatrix(double d) throws PDFNetException {
        return new Matrix2D(RotationMatrix(d));
    }

    public void destroy() throws PDFNetException {
        long j = this.f1383a;
        if (j != 0) {
            Destroy(j);
            this.f1383a = 0L;
        }
    }

    private Matrix2D(long j) {
        this.f1383a = j;
    }

    public static Matrix2D __Create(long j) {
        return new Matrix2D(j);
    }

    public long __GetHandle() {
        return this.f1383a;
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
