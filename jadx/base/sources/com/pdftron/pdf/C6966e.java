package com.pdftron.pdf;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: renamed from: com.pdftron.pdf.e */
/* JADX INFO: loaded from: classes7.dex */
final class C6966e {

    /* JADX INFO: renamed from: a */
    int f2126a;

    /* JADX INFO: renamed from: b */
    boolean f2127b;

    /* JADX INFO: renamed from: c */
    int f2128c;

    /* JADX INFO: renamed from: d */
    private SparseArray<a> f2129d = new SparseArray<>();

    /* JADX INFO: renamed from: e */
    private SparseArray<b> f2130e = new SparseArray<>();

    /* JADX INFO: renamed from: f */
    private SparseArray<b> f2131f = new SparseArray<>();

    /* JADX INFO: renamed from: com.pdftron.pdf.e$b */
    class b {

        /* JADX INFO: renamed from: a */
        HashMap<C6965d, C6965d> f2133a = new HashMap<>();

        /* JADX INFO: renamed from: b */
        int f2134b;

        b() {
            this.f2134b = C6966e.this.f2126a;
        }
    }

    /* JADX INFO: renamed from: a */
    final boolean m1522a(int i) {
        if (i - this.f2128c < 0) {
            return false;
        }
        this.f2128c = i;
        return true;
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.e$a */
    class a {

        /* JADX INFO: renamed from: a */
        private int f2132a;

        a(C6966e c6966e, int i) {
            this.f2132a = i;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof a) && this.f2132a == ((a) obj).f2132a;
        }

        public final int hashCode() {
            return this.f2132a;
        }
    }

    C6966e() {
    }

    /* JADX INFO: renamed from: c */
    private b m1514c(int i, int i2) {
        if (i2 == 1) {
            if (this.f2131f.get(i) == null) {
                this.f2131f.put(i, new b());
            }
            return this.f2131f.get(i);
        }
        if (this.f2130e.get(i) == null) {
            this.f2130e.put(i, new b());
        }
        return this.f2130e.get(i);
    }

    /* JADX INFO: renamed from: b */
    final void m1525b(int i) {
        if (this.f2129d.get(i) == null) {
            this.f2129d.put(i, new a(this, i));
        }
    }

    /* JADX INFO: renamed from: c */
    final a m1527c(int i) {
        return this.f2129d.get(i);
    }

    /* JADX INFO: renamed from: a */
    final boolean m1521a() {
        return m1528d(2);
    }

    /* JADX INFO: renamed from: d */
    final boolean m1528d(int i) {
        if (i == 0) {
            return m1513a(this.f2130e);
        }
        if (i == 1) {
            return m1513a(this.f2131f);
        }
        return m1513a(this.f2130e) && m1513a(this.f2131f);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1513a(SparseArray<b> sparseArray) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            if (!sparseArray.get(sparseArray.keyAt(i)).f2133a.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    final void m1524b() {
        m1529e(2);
    }

    /* JADX INFO: renamed from: e */
    final void m1529e(int i) {
        ImageCache imageCacheM1160a = ImageCache.m1160a();
        if (i == 0 || i == 2) {
            if (imageCacheM1160a.m1165c()) {
                int size = this.f2130e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Iterator<C6965d> it = this.f2130e.get(this.f2130e.keyAt(i2)).f2133a.values().iterator();
                    while (it.hasNext()) {
                        imageCacheM1160a.m1162a(it.next().f2115d);
                    }
                }
            }
            this.f2130e.clear();
        }
        if (i == 1 || i == 2) {
            if (imageCacheM1160a.m1165c()) {
                int size2 = this.f2131f.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Iterator<C6965d> it2 = this.f2131f.get(this.f2131f.keyAt(i3)).f2133a.values().iterator();
                    while (it2.hasNext()) {
                        imageCacheM1160a.m1162a(it2.next().f2115d);
                    }
                }
            }
            this.f2131f.clear();
        }
        this.f2129d.clear();
    }

    /* JADX INFO: renamed from: a */
    final void m1517a(int i, int i2) {
        b bVarM1514c = m1514c(i, i2);
        ImageCache imageCacheM1160a = ImageCache.m1160a();
        if (imageCacheM1160a.m1165c()) {
            Iterator<C6965d> it = bVarM1514c.f2133a.values().iterator();
            while (it.hasNext()) {
                imageCacheM1160a.m1162a(it.next().f2115d);
            }
        }
        bVarM1514c.f2133a.clear();
        bVarM1514c.f2134b = C6966e.this.f2126a;
    }

    /* JADX INFO: renamed from: a */
    final void m1518a(int i, long j, int i2, int i3) {
        b bVarM1514c = m1514c(i, i3);
        C6965d c6965dM1515a = m1515a(i, j, i3);
        if (c6965dM1515a != null) {
            bVarM1514c.f2133a.remove(c6965dM1515a);
            ImageCache.m1160a().m1162a(c6965dM1515a.f2115d);
            c6965dM1515a.f2115d = null;
            c6965dM1515a.f2125n = null;
            return;
        }
        if (i3 == 0) {
            C6965d c6965d = new C6965d(i, j, i3);
            c6965d.f2113b = -1;
            c6965d.f2114c = -1;
            c6965d.f2120i = true;
            c6965d.f2121j = i2;
            bVarM1514c.f2133a.put(c6965d, c6965d);
        }
    }

    /* JADX INFO: renamed from: c */
    final int m1526c() {
        int size = this.f2130e.size();
        int size2 = 0;
        for (int i = 0; i < size; i++) {
            size2 += this.f2130e.get(this.f2130e.keyAt(i)).f2133a.size();
        }
        return size2;
    }

    /* JADX INFO: renamed from: a */
    final C6965d m1515a(int i, long j, int i2) {
        if (i2 == 1) {
            b bVar = this.f2131f.get(i);
            if (bVar == null || bVar.f2133a == null) {
                return null;
            }
            return bVar.f2133a.get(new C6965d(i, j, i2));
        }
        b bVar2 = this.f2130e.get(i);
        if (bVar2 == null || bVar2.f2133a == null) {
            return null;
        }
        return bVar2.f2133a.get(new C6965d(i, j, i2));
    }

    /* JADX INFO: renamed from: b */
    final Collection<C6965d> m1523b(int i, int i2) {
        return m1514c(i, i2).f2133a.values();
    }

    /* JADX INFO: renamed from: f */
    final Collection<C6965d> m1530f(int i) {
        ArrayList arrayList = new ArrayList(m1514c(i, 1).f2133a.values());
        Collections.sort(arrayList, new Comparator<C6965d>(this) { // from class: com.pdftron.pdf.e.1
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(C6965d c6965d, C6965d c6965d2) {
                return c6965d.f2124m - c6965d2.f2124m;
            }
        });
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0113  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final C6965d m1516a(long j, int i, long j2, long j3, int i2, int i3, int i4, int i5, Bitmap bitmap, CurvePainter curvePainter, int i6, int i7, boolean z, int i8) {
        C6965d c6965d;
        C6965d c6965dM1515a;
        b bVarM1514c = m1514c(i, i7);
        ImageCache imageCacheM1160a = ImageCache.m1160a();
        if (i7 == 1) {
            if (!m1522a(i6)) {
                return null;
            }
        } else {
            if (i7 == 0) {
                c6965d = null;
                if (i6 - bVarM1514c.f2134b < 0) {
                    imageCacheM1160a.m1162a(bitmap);
                    if (PDFViewCtrl.f1639a) {
                        Log.e("TILES", "Evicting tile since it's sequence number is too low");
                    }
                    return null;
                }
            }
            if (i >= 0 || j < 0) {
                c6965dM1515a = c6965d;
            } else {
                c6965dM1515a = m1515a(i, j, i7);
                if (c6965dM1515a != null && c6965dM1515a.f2120i) {
                    int i9 = i6 - c6965dM1515a.f2121j;
                    m1518a(i, j, i6, i7);
                    if (i9 < 0) {
                        imageCacheM1160a.m1162a(bitmap);
                        return c6965d;
                    }
                    c6965dM1515a = c6965d;
                }
            }
            if (c6965dM1515a != null) {
                imageCacheM1160a.m1162a(c6965dM1515a.f2115d);
            }
            if (c6965dM1515a == null && c6965dM1515a.f2114c == i5 && c6965dM1515a.f2113b == i4) {
                c6965dM1515a.f2116e = i2;
                c6965dM1515a.f2117f = i3;
                c6965dM1515a.f2113b = i4;
                c6965dM1515a.f2114c = i5;
                if (bitmap != null) {
                    c6965dM1515a.f2115d = bitmap;
                    if (c6965dM1515a.f2122k == 1) {
                        c6965dM1515a.f2125n = curvePainter;
                    }
                    c6965dM1515a.f2118g = (int) (j2 + 0.5d);
                    c6965dM1515a.f2119h = (int) (j3 + 0.5d);
                } else if (curvePainter != null) {
                    c6965dM1515a.f2115d = c6965d;
                    c6965dM1515a.f2125n = curvePainter;
                    c6965dM1515a.f2113b = (int) (j2 + 0.5d);
                    c6965dM1515a.f2114c = (int) (j3 + 0.5d);
                }
                c6965dM1515a.f2122k = i7;
                c6965dM1515a.f2123l = z;
                c6965dM1515a.f2124m = i8;
                return c6965dM1515a;
            }
            C6965d c6965d2 = new C6965d(i, j, i7);
            c6965d2.f2116e = i2;
            c6965d2.f2117f = i3;
            c6965d2.f2113b = i4;
            c6965d2.f2114c = i5;
            if (bitmap == null) {
                c6965d2.f2115d = bitmap;
                if (c6965d2.f2122k == 1) {
                    c6965d2.f2125n = curvePainter;
                }
                c6965d2.f2118g = (int) (j2 + 0.5d);
                c6965d2.f2119h = (int) (j3 + 0.5d);
            } else if (curvePainter != null) {
                c6965d2.f2115d = null;
                c6965d2.f2125n = curvePainter;
                c6965d2.f2113b = (int) (j2 + 0.5d);
                c6965d2.f2114c = (int) (j3 + 0.5d);
            }
            c6965d2.f2122k = i7;
            c6965d2.f2123l = z;
            c6965d2.f2124m = i8;
            bVarM1514c.f2133a.put(c6965d2, c6965d2);
            if (i7 == 1) {
                Log.d("annotlayer", "put tile: w:" + c6965d2.f2113b + " h:" + c6965d2.f2114c);
            }
            return c6965d2;
        }
        c6965d = null;
        if (i >= 0) {
            c6965dM1515a = c6965d;
        }
        if (c6965dM1515a != null) {
        }
        if (c6965dM1515a == null) {
        }
        C6965d c6965d22 = new C6965d(i, j, i7);
        c6965d22.f2116e = i2;
        c6965d22.f2117f = i3;
        c6965d22.f2113b = i4;
        c6965d22.f2114c = i5;
        if (bitmap == null) {
        }
        c6965d22.f2122k = i7;
        c6965d22.f2123l = z;
        c6965d22.f2124m = i8;
        bVarM1514c.f2133a.put(c6965d22, c6965d22);
        if (i7 == 1) {
        }
        return c6965d22;
    }

    /* JADX INFO: renamed from: a */
    final void m1520a(long j, int i, long j2, long j3, int i2, int i3, int i4, int i5) {
        C6965d c6965dM1515a;
        if (i < 0 || j < 0 || (c6965dM1515a = m1515a(i, j, 1)) == null) {
            return;
        }
        c6965dM1515a.f2116e = i2;
        c6965dM1515a.f2117f = i3;
        c6965dM1515a.f2118g = (int) (j2 + 0.5d);
        c6965dM1515a.f2119h = (int) (j3 + 0.5d);
        c6965dM1515a.f2113b = i4;
        c6965dM1515a.f2114c = i5;
        m1514c(i, 1).f2133a.put(c6965dM1515a, c6965dM1515a);
    }

    /* JADX INFO: renamed from: a */
    final void m1519a(long j, int i, int i2) {
        C6965d c6965dM1515a;
        if (i < 0 || j < 0 || (c6965dM1515a = m1515a(i, j, 1)) == null) {
            return;
        }
        c6965dM1515a.f2124m = i2;
        m1514c(i, 1).f2133a.put(c6965dM1515a, c6965dM1515a);
    }
}
