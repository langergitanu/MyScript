package com.pdftron.pdf;

/* JADX INFO: loaded from: classes7.dex */
public class PathData {
    public static final int e_closepath = 6;
    public static final int e_conicto = 4;
    public static final int e_cubicto = 3;
    public static final int e_lineto = 2;
    public static final int e_moveto = 1;
    public static final int e_rect = 5;

    /* JADX INFO: renamed from: a */
    private byte[] f1996a;

    /* JADX INFO: renamed from: b */
    private double[] f1997b;

    /* JADX INFO: renamed from: c */
    private boolean f1998c;

    public PathData(boolean z, byte[] bArr, double[] dArr) {
        this.f1996a = bArr;
        this.f1998c = z;
        this.f1997b = dArr;
    }

    public void setOperators(byte[] bArr) {
        this.f1996a = bArr;
    }

    public void setPoints(double[] dArr) {
        this.f1997b = dArr;
    }

    public byte[] getOperators() {
        return this.f1996a;
    }

    public double[] getPoints() {
        return this.f1997b;
    }

    public boolean isDefined() {
        return this.f1998c;
    }
}
