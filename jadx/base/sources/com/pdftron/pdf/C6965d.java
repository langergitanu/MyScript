package com.pdftron.pdf;

import android.graphics.Bitmap;

/* JADX INFO: renamed from: com.pdftron.pdf.d */
/* JADX INFO: loaded from: classes7.dex */
final class C6965d {

    /* JADX INFO: renamed from: a */
    long f2112a;

    /* JADX INFO: renamed from: b */
    int f2113b;

    /* JADX INFO: renamed from: c */
    int f2114c;

    /* JADX INFO: renamed from: d */
    Bitmap f2115d;

    /* JADX INFO: renamed from: e */
    int f2116e;

    /* JADX INFO: renamed from: f */
    int f2117f;

    /* JADX INFO: renamed from: g */
    int f2118g;

    /* JADX INFO: renamed from: h */
    int f2119h;

    /* JADX INFO: renamed from: i */
    boolean f2120i;

    /* JADX INFO: renamed from: j */
    int f2121j;

    /* JADX INFO: renamed from: k */
    int f2122k;

    /* JADX INFO: renamed from: l */
    boolean f2123l;

    /* JADX INFO: renamed from: m */
    int f2124m;

    /* JADX INFO: renamed from: n */
    CurvePainter f2125n;

    C6965d() {
        this.f2112a = -1L;
        this.f2113b = 0;
        this.f2114c = 0;
        this.f2115d = null;
        this.f2116e = 0;
        this.f2117f = 0;
        this.f2120i = false;
        this.f2121j = 0;
    }

    C6965d(int i, long j, int i2) {
        this.f2112a = j;
        this.f2113b = 0;
        this.f2114c = 0;
        this.f2115d = null;
        this.f2116e = 0;
        this.f2117f = 0;
        this.f2120i = false;
        this.f2121j = 0;
        this.f2122k = i2;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C6965d) && this.f2112a == ((C6965d) obj).f2112a;
    }

    public final int hashCode() {
        long j = this.f2112a;
        return (int) (j ^ (j >>> 32));
    }
}
