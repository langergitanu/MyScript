package com.pdftron.pdf;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import com.pdftron.pdf.C6963b;
import com.pdftron.pdf.ImageCache;

/* JADX INFO: renamed from: com.pdftron.pdf.c */
/* JADX INFO: loaded from: classes7.dex */
final class C6964c {

    /* JADX INFO: renamed from: a */
    private SparseArray<ImageCache.C69301> f2111a = new SparseArray<>();

    C6964c() {
    }

    /* JADX INFO: renamed from: a */
    final int m1507a() {
        return this.f2111a.size();
    }

    /* JADX INFO: renamed from: b */
    final int[] m1511b() {
        int size = this.f2111a.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.f2111a.keyAt(i);
        }
        return iArr;
    }

    /* JADX INFO: renamed from: a */
    final ImageCache.C69301 m1509a(int i) {
        return this.f2111a.get(i);
    }

    /* JADX INFO: renamed from: a */
    final Bitmap m1508a(int i, Bitmap bitmap, Rect rect, Rect rect2) {
        ImageCache.C69301 c69301 = new ImageCache.C69301();
        try {
            c69301.f1574a = bitmap;
            c69301.f1575b = rect;
            c69301.f1576c = rect2;
            this.f2111a.put(i, c69301);
        } catch (Exception unused) {
        } catch (OutOfMemoryError unused2) {
            ImageCache.m1160a().m1164b();
            C6963b.a.f2110a.m1505b();
            if (PDFViewCtrl.f1640b) {
                PDFViewCtrl.m1239a(4, "Don't add thumb " + i + " due to out of memory", PDFViewCtrl.m1230a(false));
            } else {
                Log.e("PDFNet", "Don't add thumb " + i + " due to out of memory");
            }
            c69301.f1574a = null;
        }
        return c69301.f1574a;
    }

    /* JADX INFO: renamed from: b */
    final void m1510b(int i) {
        ImageCache.C69301 c69301 = this.f2111a.get(i);
        if (c69301 != null) {
            ImageCache.m1160a().m1162a(c69301.f1574a);
        }
        this.f2111a.remove(i);
    }

    /* JADX INFO: renamed from: c */
    final void m1512c() {
        ImageCache imageCacheM1160a = ImageCache.m1160a();
        if (imageCacheM1160a.m1165c()) {
            int size = this.f2111a.size();
            for (int i = 0; i < size; i++) {
                imageCacheM1160a.m1162a(this.f2111a.valueAt(i).f1574a);
            }
        }
        this.f2111a.clear();
    }
}
