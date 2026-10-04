package com.pdftron.pdf;

import android.graphics.RectF;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* JADX INFO: renamed from: com.pdftron.pdf.f */
/* JADX INFO: loaded from: classes7.dex */
final class C6967f {

    /* JADX INFO: renamed from: b */
    private int f2137b;

    /* JADX INFO: renamed from: c */
    private int f2138c;

    /* JADX INFO: renamed from: k */
    private long f2146k;

    /* JADX INFO: renamed from: d */
    private boolean f2139d = true;

    /* JADX INFO: renamed from: e */
    private RectF f2140e = new RectF();

    /* JADX INFO: renamed from: f */
    private RectF f2141f = new RectF();

    /* JADX INFO: renamed from: g */
    private RectF f2142g = new RectF();

    /* JADX INFO: renamed from: h */
    private SparseArray<RectF> f2143h = new SparseArray<>();

    /* JADX INFO: renamed from: i */
    private SparseArray<RectF> f2144i = new SparseArray<>();

    /* JADX INFO: renamed from: j */
    private SparseArray<RectF> f2145j = new SparseArray<>();

    /* JADX INFO: renamed from: a */
    private Interpolator f2136a = new DecelerateInterpolator();

    C6967f(int i) {
        this.f2137b = i;
        this.f2138c = i + 500;
    }

    /* JADX INFO: renamed from: a */
    final void m1534a(boolean z) {
        this.f2139d = true;
    }

    /* JADX INFO: renamed from: a */
    final boolean m1535a() {
        return this.f2139d;
    }

    /* JADX INFO: renamed from: b */
    final int m1536b() {
        int i = 0;
        if (this.f2139d) {
            return 0;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f2146k;
        if (jElapsedRealtime >= this.f2138c) {
            this.f2139d = true;
            this.f2142g.set(this.f2141f);
            m1531a(this.f2144i, this.f2145j);
            return 2;
        }
        int i2 = this.f2137b;
        if (jElapsedRealtime >= i2) {
            this.f2142g.set(this.f2141f);
            m1531a(this.f2144i, this.f2145j);
            return 1;
        }
        float f = jElapsedRealtime / i2;
        this.f2142g.set(this.f2140e.left + ((this.f2141f.left - this.f2140e.left) * this.f2136a.getInterpolation(f)), this.f2140e.top + ((this.f2141f.top - this.f2140e.top) * this.f2136a.getInterpolation(f)), this.f2140e.right + ((this.f2141f.right - this.f2140e.right) * this.f2136a.getInterpolation(f)), this.f2140e.bottom + ((this.f2141f.bottom - this.f2140e.bottom) * this.f2136a.getInterpolation(f)));
        if (this.f2144i.size() < this.f2143h.size()) {
            while (i < this.f2144i.size()) {
                int iKeyAt = this.f2144i.keyAt(i);
                int iIndexOfKey = this.f2143h.indexOfKey(iKeyAt);
                if (iIndexOfKey >= 0) {
                    RectF rectFValueAt = this.f2143h.valueAt(iIndexOfKey);
                    RectF rectFValueAt2 = this.f2144i.valueAt(i);
                    this.f2145j.put(iKeyAt, new RectF(rectFValueAt.left - ((rectFValueAt.left - rectFValueAt2.left) * this.f2136a.getInterpolation(f)), rectFValueAt.top - ((rectFValueAt.top - rectFValueAt2.top) * this.f2136a.getInterpolation(f)), rectFValueAt.right - ((rectFValueAt.right - rectFValueAt2.right) * this.f2136a.getInterpolation(f)), rectFValueAt.bottom - ((rectFValueAt.bottom - rectFValueAt2.bottom) * this.f2136a.getInterpolation(f))));
                }
                i++;
            }
        } else {
            while (i < this.f2143h.size()) {
                int iKeyAt2 = this.f2143h.keyAt(i);
                int iIndexOfKey2 = this.f2144i.indexOfKey(iKeyAt2);
                if (iIndexOfKey2 >= 0) {
                    RectF rectFValueAt3 = this.f2143h.valueAt(i);
                    RectF rectFValueAt4 = this.f2144i.valueAt(iIndexOfKey2);
                    this.f2145j.put(iKeyAt2, new RectF(rectFValueAt3.left - ((rectFValueAt3.left - rectFValueAt4.left) * this.f2136a.getInterpolation(f)), rectFValueAt3.top - ((rectFValueAt3.top - rectFValueAt4.top) * this.f2136a.getInterpolation(f)), rectFValueAt3.right - ((rectFValueAt3.right - rectFValueAt4.right) * this.f2136a.getInterpolation(f)), rectFValueAt3.bottom - ((rectFValueAt3.bottom - rectFValueAt4.bottom) * this.f2136a.getInterpolation(f))));
                }
                i++;
            }
        }
        return 1;
    }

    /* JADX INFO: renamed from: c */
    final SparseArray<RectF> m1537c() {
        return this.f2145j;
    }

    /* JADX INFO: renamed from: a */
    private static void m1531a(SparseArray<RectF> sparseArray, SparseArray<RectF> sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        for (int i = 0; i < sparseArray2.size(); i++) {
            int iIndexOfKey = sparseArray.indexOfKey(sparseArray2.keyAt(i));
            if (iIndexOfKey >= 0) {
                sparseArray2.put(sparseArray2.keyAt(i), sparseArray.valueAt(iIndexOfKey));
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m1532b(SparseArray<RectF> sparseArray, SparseArray<RectF> sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        sparseArray2.clear();
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
        }
    }

    /* JADX INFO: renamed from: a */
    final void m1533a(RectF rectF, RectF rectF2, SparseArray<RectF> sparseArray, SparseArray<RectF> sparseArray2) {
        this.f2139d = true;
        this.f2140e = new RectF();
        this.f2141f = new RectF();
        this.f2142g = new RectF();
        this.f2143h.clear();
        this.f2144i.clear();
        this.f2145j.clear();
        this.f2146k = SystemClock.elapsedRealtime();
        this.f2139d = false;
        this.f2140e.set(rectF);
        this.f2141f.set(rectF2);
        m1532b(sparseArray, this.f2143h);
        m1532b(sparseArray2, this.f2144i);
    }
}
