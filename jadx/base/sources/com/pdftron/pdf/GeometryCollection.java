package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class GeometryCollection implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1565a;

    static native void Destroy(long j);

    static native double[] SnapToNearest(long j, double d, double d2, int i);

    static native double[] SnapToNearestPixel(long j, double d, double d2, double d3, int i);

    public class SnappingMode {
        public static final int e_default_snap_mode = 14;
        public static final int e_line_intersection = 4;
        public static final int e_line_midpoint = 2;
        public static final int e_path_endpoint = 8;
        public static final int e_point_on_line = 1;

        public SnappingMode(GeometryCollection geometryCollection) {
        }
    }

    public void destroy() throws PDFNetException {
        long j = this.f1565a;
        if (j != 0) {
            Destroy(j);
            this.f1565a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public GeometryCollection(long j) {
        this.f1565a = j;
    }

    public Point snapToNearest(double d, double d2, int i) throws PDFNetException {
        return new Point(SnapToNearest(this.f1565a, d, d2, i));
    }

    public Point snapToNearestPixel(double d, double d2, double d3, int i) throws PDFNetException {
        return new Point(SnapToNearestPixel(this.f1565a, d, d2, d3, i));
    }

    public long __GetHandle() {
        return this.f1565a;
    }

    public static GeometryCollection __Create(long j) {
        return new GeometryCollection(j);
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
