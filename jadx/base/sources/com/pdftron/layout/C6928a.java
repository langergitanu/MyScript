package com.pdftron.layout;

/* JADX INFO: renamed from: com.pdftron.layout.a */
/* JADX INFO: loaded from: classes7.dex */
final class C6928a {
    /* JADX INFO: renamed from: a */
    static void m1133a(int i, int i2, int i3) throws IllegalArgumentException {
        if (i < 0 || i > 255) {
            throw new IllegalArgumentException("red must be between 0 and 255");
        }
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("green must be between 0 and 255");
        }
        if (i3 < 0 || i3 > 255) {
            throw new IllegalArgumentException("blue must be between 0 and 255");
        }
    }
}
