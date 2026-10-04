package com.pdftron.pdf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.DoubleRectangle2D;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Rect implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    long f2037a;

    static native void Attach(long j, long j2);

    static native boolean Contains(long j, double d, double d2);

    static native void Destroy(long j);

    static native boolean Equals(long j, long j2);

    static native double[] Get(long j);

    static native double GetX1(long j);

    static native double GetX2(long j);

    static native double GetY1(long j);

    static native double GetY2(long j);

    static native int HashCode(long j);

    static native double Height(long j);

    static native void Inflate(long j, double d);

    static native void Inflate(long j, double d, double d2);

    static native boolean IntersectRect(long j, long j2, long j3);

    static native void Normalize(long j);

    static native long RectCreate(double d, double d2, double d3, double d4);

    static native long RectCreate(long j);

    static native void Set(long j, double d, double d2, double d3, double d4);

    static native void SetX1(long j, double d);

    static native void SetX2(long j, double d);

    static native void SetY1(long j, double d);

    static native void SetY2(long j, double d);

    static native boolean Update(long j, long j2);

    static native double Width(long j);

    public Rect() throws PDFNetException {
        this.f2037a = RectCreate(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public Rect(Obj obj) throws PDFNetException {
        this.f2037a = RectCreate(obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public Rect(double d, double d2, double d3, double d4) throws PDFNetException {
        this.f2037a = RectCreate(d, d2, d3, d4);
    }

    public Rect(DoubleRectangle2D doubleRectangle2D) throws PDFNetException {
        this.f2037a = RectCreate(doubleRectangle2D.f1418x, doubleRectangle2D.f1419y, doubleRectangle2D.f1418x + doubleRectangle2D.width, doubleRectangle2D.f1419y + doubleRectangle2D.height);
    }

    Rect(long j) {
        this.f2037a = j;
    }

    public static Rect __Create(long j) {
        if (j == 0) {
            return null;
        }
        return new Rect(j);
    }

    public long __GetHandle() {
        return this.f2037a;
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        boolean zEquals = Equals(this.f2037a, ((Rect) obj).f2037a);
        ReachabilityHelper.ensureReachable(obj);
        return zEquals;
    }

    public int hashCode() {
        return HashCode(this.f2037a);
    }

    public void attach(Obj obj) throws PDFNetException {
        Attach(this.f2037a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public boolean update() throws PDFNetException {
        return Update(this.f2037a, 0L);
    }

    public boolean update(Obj obj) throws PDFNetException {
        boolean zUpdate = Update(this.f2037a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
        return zUpdate;
    }

    public double[] get() throws PDFNetException {
        return Get(this.f2037a);
    }

    public void set(double d, double d2, double d3, double d4) throws PDFNetException {
        Set(this.f2037a, d, d2, d3, d4);
    }

    public void set(DoubleRectangle2D doubleRectangle2D) throws PDFNetException {
        Set(this.f2037a, doubleRectangle2D.f1418x, doubleRectangle2D.f1419y, doubleRectangle2D.f1418x + doubleRectangle2D.width, doubleRectangle2D.f1419y + doubleRectangle2D.height);
    }

    public double getWidth() throws PDFNetException {
        return Width(this.f2037a);
    }

    public double getHeight() throws PDFNetException {
        return Height(this.f2037a);
    }

    public boolean contains(double d, double d2) throws PDFNetException {
        return Contains(this.f2037a, d, d2);
    }

    public boolean intersectRect(Rect rect, Rect rect2) throws PDFNetException {
        boolean zIntersectRect = IntersectRect(this.f2037a, rect.f2037a, rect2.f2037a);
        ReachabilityHelper.ensureReachable(rect);
        ReachabilityHelper.ensureReachable(rect2);
        return zIntersectRect;
    }

    public void normalize() throws PDFNetException {
        Normalize(this.f2037a);
    }

    public void inflate(double d) {
        Inflate(this.f2037a, d);
    }

    public void inflate(double d, double d2) {
        Inflate(this.f2037a, d, d2);
    }

    public void destroy() {
        long j = this.f2037a;
        if (j != 0) {
            Destroy(j);
            this.f2037a = 0L;
        }
    }

    public DoubleRectangle2D getRectangle() throws PDFNetException {
        double[] dArrGet = Get(this.f2037a);
        double d = dArrGet[0];
        double d2 = dArrGet[1];
        return new DoubleRectangle2D(d, d2, dArrGet[2] - d, dArrGet[3] - d2);
    }

    public double getX1() throws PDFNetException {
        return GetX1(this.f2037a);
    }

    public double getY1() throws PDFNetException {
        return GetY1(this.f2037a);
    }

    public double getX2() throws PDFNetException {
        return GetX2(this.f2037a);
    }

    public double getY2() throws PDFNetException {
        return GetY2(this.f2037a);
    }

    public void setX1(double d) throws PDFNetException {
        SetX1(this.f2037a, d);
    }

    public void setY1(double d) throws PDFNetException {
        SetY1(this.f2037a, d);
    }

    public void setX2(double d) throws PDFNetException {
        SetX2(this.f2037a, d);
    }

    public void setY2(double d) throws PDFNetException {
        SetY2(this.f2037a, d);
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
