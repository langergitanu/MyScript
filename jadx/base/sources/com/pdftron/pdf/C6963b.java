package com.pdftron.pdf;

/* JADX INFO: renamed from: com.pdftron.pdf.b */
/* JADX INFO: loaded from: classes7.dex */
final class C6963b {

    /* JADX INFO: renamed from: a */
    private final Object f2107a;

    /* JADX INFO: renamed from: b */
    private android.graphics.Rect[] f2108b;

    /* JADX INFO: renamed from: c */
    private int f2109c;

    /* synthetic */ C6963b(byte b) {
        this();
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.b$a */
    static class a {

        /* JADX INFO: renamed from: a */
        private static final C6963b f2110a = new C6963b(0);
    }

    private C6963b() {
        this.f2107a = new Object();
        this.f2108b = new android.graphics.Rect[4096];
    }

    /* JADX INFO: renamed from: a */
    public final android.graphics.Rect m1502a() {
        synchronized (this.f2107a) {
            int i = this.f2109c;
            if (i > 0) {
                int i2 = i - 1;
                android.graphics.Rect[] rectArr = this.f2108b;
                android.graphics.Rect rect = rectArr[i2];
                rectArr[i2] = null;
                this.f2109c = i - 1;
                if (rect == null) {
                    rect = new android.graphics.Rect();
                }
                return rect;
            }
            return new android.graphics.Rect();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1504a(android.graphics.Rect rect) {
        if (rect == null) {
            return;
        }
        rect.set(0, 0, 0, 0);
        synchronized (this.f2107a) {
            if (this.f2108b == null) {
                this.f2108b = new android.graphics.Rect[4096];
            }
            int i = this.f2109c;
            if (i < 4096) {
                this.f2108b[i] = rect;
                this.f2109c = i + 1;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1503a(int i) {
        int i2 = this.f2109c;
        if (64 > 4096 - i2) {
            i = 4096 - i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            m1504a(new android.graphics.Rect());
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1505b() {
        synchronized (this.f2107a) {
            this.f2108b = null;
            this.f2109c = 0;
        }
    }
}
