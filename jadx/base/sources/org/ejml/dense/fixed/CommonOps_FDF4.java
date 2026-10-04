package org.ejml.dense.fixed;

import org.ejml.data.FMatrix4;
import org.ejml.data.FMatrix4x4;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_FDF4 {
    public static void add(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42, FMatrix4x4 fMatrix4x43) {
        fMatrix4x43.a11 = fMatrix4x4.a11 + fMatrix4x42.a11;
        fMatrix4x43.a12 = fMatrix4x4.a12 + fMatrix4x42.a12;
        fMatrix4x43.a13 = fMatrix4x4.a13 + fMatrix4x42.a13;
        fMatrix4x43.a14 = fMatrix4x4.a14 + fMatrix4x42.a14;
        fMatrix4x43.a21 = fMatrix4x4.a21 + fMatrix4x42.a21;
        fMatrix4x43.a22 = fMatrix4x4.a22 + fMatrix4x42.a22;
        fMatrix4x43.a23 = fMatrix4x4.a23 + fMatrix4x42.a23;
        fMatrix4x43.a24 = fMatrix4x4.a24 + fMatrix4x42.a24;
        fMatrix4x43.a31 = fMatrix4x4.a31 + fMatrix4x42.a31;
        fMatrix4x43.a32 = fMatrix4x4.a32 + fMatrix4x42.a32;
        fMatrix4x43.a33 = fMatrix4x4.a33 + fMatrix4x42.a33;
        fMatrix4x43.a34 = fMatrix4x4.a34 + fMatrix4x42.a34;
        fMatrix4x43.a41 = fMatrix4x4.a41 + fMatrix4x42.a41;
        fMatrix4x43.a42 = fMatrix4x4.a42 + fMatrix4x42.a42;
        fMatrix4x43.a43 = fMatrix4x4.a43 + fMatrix4x42.a43;
        fMatrix4x43.a44 = fMatrix4x4.a44 + fMatrix4x42.a44;
    }

    public static void add(FMatrix4 fMatrix4, FMatrix4 fMatrix42, FMatrix4 fMatrix43) {
        fMatrix43.f2423a1 = fMatrix4.f2423a1 + fMatrix42.f2423a1;
        fMatrix43.f2424a2 = fMatrix4.f2424a2 + fMatrix42.f2424a2;
        fMatrix43.f2425a3 = fMatrix4.f2425a3 + fMatrix42.f2425a3;
        fMatrix43.f2426a4 = fMatrix4.f2426a4 + fMatrix42.f2426a4;
    }

    public static void addEquals(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42) {
        fMatrix4x4.a11 += fMatrix4x42.a11;
        fMatrix4x4.a12 += fMatrix4x42.a12;
        fMatrix4x4.a13 += fMatrix4x42.a13;
        fMatrix4x4.a14 += fMatrix4x42.a14;
        fMatrix4x4.a21 += fMatrix4x42.a21;
        fMatrix4x4.a22 += fMatrix4x42.a22;
        fMatrix4x4.a23 += fMatrix4x42.a23;
        fMatrix4x4.a24 += fMatrix4x42.a24;
        fMatrix4x4.a31 += fMatrix4x42.a31;
        fMatrix4x4.a32 += fMatrix4x42.a32;
        fMatrix4x4.a33 += fMatrix4x42.a33;
        fMatrix4x4.a34 += fMatrix4x42.a34;
        fMatrix4x4.a41 += fMatrix4x42.a41;
        fMatrix4x4.a42 += fMatrix4x42.a42;
        fMatrix4x4.a43 += fMatrix4x42.a43;
        fMatrix4x4.a44 += fMatrix4x42.a44;
    }

    public static void addEquals(FMatrix4 fMatrix4, FMatrix4 fMatrix42) {
        fMatrix4.f2423a1 += fMatrix42.f2423a1;
        fMatrix4.f2424a2 += fMatrix42.f2424a2;
        fMatrix4.f2425a3 += fMatrix42.f2425a3;
        fMatrix4.f2426a4 += fMatrix42.f2426a4;
    }

    public static void subtract(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42, FMatrix4x4 fMatrix4x43) {
        fMatrix4x43.a11 = fMatrix4x4.a11 - fMatrix4x42.a11;
        fMatrix4x43.a12 = fMatrix4x4.a12 - fMatrix4x42.a12;
        fMatrix4x43.a13 = fMatrix4x4.a13 - fMatrix4x42.a13;
        fMatrix4x43.a14 = fMatrix4x4.a14 - fMatrix4x42.a14;
        fMatrix4x43.a21 = fMatrix4x4.a21 - fMatrix4x42.a21;
        fMatrix4x43.a22 = fMatrix4x4.a22 - fMatrix4x42.a22;
        fMatrix4x43.a23 = fMatrix4x4.a23 - fMatrix4x42.a23;
        fMatrix4x43.a24 = fMatrix4x4.a24 - fMatrix4x42.a24;
        fMatrix4x43.a31 = fMatrix4x4.a31 - fMatrix4x42.a31;
        fMatrix4x43.a32 = fMatrix4x4.a32 - fMatrix4x42.a32;
        fMatrix4x43.a33 = fMatrix4x4.a33 - fMatrix4x42.a33;
        fMatrix4x43.a34 = fMatrix4x4.a34 - fMatrix4x42.a34;
        fMatrix4x43.a41 = fMatrix4x4.a41 - fMatrix4x42.a41;
        fMatrix4x43.a42 = fMatrix4x4.a42 - fMatrix4x42.a42;
        fMatrix4x43.a43 = fMatrix4x4.a43 - fMatrix4x42.a43;
        fMatrix4x43.a44 = fMatrix4x4.a44 - fMatrix4x42.a44;
    }

    public static void subtract(FMatrix4 fMatrix4, FMatrix4 fMatrix42, FMatrix4 fMatrix43) {
        fMatrix43.f2423a1 = fMatrix4.f2423a1 - fMatrix42.f2423a1;
        fMatrix43.f2424a2 = fMatrix4.f2424a2 - fMatrix42.f2424a2;
        fMatrix43.f2425a3 = fMatrix4.f2425a3 - fMatrix42.f2425a3;
        fMatrix43.f2426a4 = fMatrix4.f2426a4 - fMatrix42.f2426a4;
    }

    public static void subtractEquals(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42) {
        fMatrix4x4.a11 -= fMatrix4x42.a11;
        fMatrix4x4.a12 -= fMatrix4x42.a12;
        fMatrix4x4.a13 -= fMatrix4x42.a13;
        fMatrix4x4.a14 -= fMatrix4x42.a14;
        fMatrix4x4.a21 -= fMatrix4x42.a21;
        fMatrix4x4.a22 -= fMatrix4x42.a22;
        fMatrix4x4.a23 -= fMatrix4x42.a23;
        fMatrix4x4.a24 -= fMatrix4x42.a24;
        fMatrix4x4.a31 -= fMatrix4x42.a31;
        fMatrix4x4.a32 -= fMatrix4x42.a32;
        fMatrix4x4.a33 -= fMatrix4x42.a33;
        fMatrix4x4.a34 -= fMatrix4x42.a34;
        fMatrix4x4.a41 -= fMatrix4x42.a41;
        fMatrix4x4.a42 -= fMatrix4x42.a42;
        fMatrix4x4.a43 -= fMatrix4x42.a43;
        fMatrix4x4.a44 -= fMatrix4x42.a44;
    }

    public static void subtractEquals(FMatrix4 fMatrix4, FMatrix4 fMatrix42) {
        fMatrix4.f2423a1 -= fMatrix42.f2423a1;
        fMatrix4.f2424a2 -= fMatrix42.f2424a2;
        fMatrix4.f2425a3 -= fMatrix42.f2425a3;
        fMatrix4.f2426a4 -= fMatrix42.f2426a4;
    }

    public static void transpose(FMatrix4x4 fMatrix4x4) {
        float f = fMatrix4x4.a12;
        fMatrix4x4.a12 = fMatrix4x4.a21;
        fMatrix4x4.a21 = f;
        float f2 = fMatrix4x4.a13;
        fMatrix4x4.a13 = fMatrix4x4.a31;
        fMatrix4x4.a31 = f2;
        float f3 = fMatrix4x4.a14;
        fMatrix4x4.a14 = fMatrix4x4.a41;
        fMatrix4x4.a41 = f3;
        float f4 = fMatrix4x4.a23;
        fMatrix4x4.a23 = fMatrix4x4.a32;
        fMatrix4x4.a32 = f4;
        float f5 = fMatrix4x4.a24;
        fMatrix4x4.a24 = fMatrix4x4.a42;
        fMatrix4x4.a42 = f5;
        float f6 = fMatrix4x4.a34;
        fMatrix4x4.a34 = fMatrix4x4.a43;
        fMatrix4x4.a43 = f6;
    }

    public static FMatrix4x4 transpose(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42) {
        if (fMatrix4x4 == null) {
            fMatrix4x4 = new FMatrix4x4();
        }
        fMatrix4x42.a11 = fMatrix4x4.a11;
        fMatrix4x42.a12 = fMatrix4x4.a21;
        fMatrix4x42.a13 = fMatrix4x4.a31;
        fMatrix4x42.a14 = fMatrix4x4.a41;
        fMatrix4x42.a21 = fMatrix4x4.a12;
        fMatrix4x42.a22 = fMatrix4x4.a22;
        fMatrix4x42.a23 = fMatrix4x4.a32;
        fMatrix4x42.a24 = fMatrix4x4.a42;
        fMatrix4x42.a31 = fMatrix4x4.a13;
        fMatrix4x42.a32 = fMatrix4x4.a23;
        fMatrix4x42.a33 = fMatrix4x4.a33;
        fMatrix4x42.a34 = fMatrix4x4.a43;
        fMatrix4x42.a41 = fMatrix4x4.a14;
        fMatrix4x42.a42 = fMatrix4x4.a24;
        fMatrix4x42.a43 = fMatrix4x4.a34;
        fMatrix4x42.a44 = fMatrix4x4.a44;
        return fMatrix4x42;
    }

    public static void mult(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42, FMatrix4x4 fMatrix4x43) {
        fMatrix4x43.a11 = (fMatrix4x4.a11 * fMatrix4x42.a11) + (fMatrix4x4.a12 * fMatrix4x42.a21) + (fMatrix4x4.a13 * fMatrix4x42.a31) + (fMatrix4x4.a14 * fMatrix4x42.a41);
        fMatrix4x43.a12 = (fMatrix4x4.a11 * fMatrix4x42.a12) + (fMatrix4x4.a12 * fMatrix4x42.a22) + (fMatrix4x4.a13 * fMatrix4x42.a32) + (fMatrix4x4.a14 * fMatrix4x42.a42);
        fMatrix4x43.a13 = (fMatrix4x4.a11 * fMatrix4x42.a13) + (fMatrix4x4.a12 * fMatrix4x42.a23) + (fMatrix4x4.a13 * fMatrix4x42.a33) + (fMatrix4x4.a14 * fMatrix4x42.a43);
        fMatrix4x43.a14 = (fMatrix4x4.a11 * fMatrix4x42.a14) + (fMatrix4x4.a12 * fMatrix4x42.a24) + (fMatrix4x4.a13 * fMatrix4x42.a34) + (fMatrix4x4.a14 * fMatrix4x42.a44);
        fMatrix4x43.a21 = (fMatrix4x4.a21 * fMatrix4x42.a11) + (fMatrix4x4.a22 * fMatrix4x42.a21) + (fMatrix4x4.a23 * fMatrix4x42.a31) + (fMatrix4x4.a24 * fMatrix4x42.a41);
        fMatrix4x43.a22 = (fMatrix4x4.a21 * fMatrix4x42.a12) + (fMatrix4x4.a22 * fMatrix4x42.a22) + (fMatrix4x4.a23 * fMatrix4x42.a32) + (fMatrix4x4.a24 * fMatrix4x42.a42);
        fMatrix4x43.a23 = (fMatrix4x4.a21 * fMatrix4x42.a13) + (fMatrix4x4.a22 * fMatrix4x42.a23) + (fMatrix4x4.a23 * fMatrix4x42.a33) + (fMatrix4x4.a24 * fMatrix4x42.a43);
        fMatrix4x43.a24 = (fMatrix4x4.a21 * fMatrix4x42.a14) + (fMatrix4x4.a22 * fMatrix4x42.a24) + (fMatrix4x4.a23 * fMatrix4x42.a34) + (fMatrix4x4.a24 * fMatrix4x42.a44);
        fMatrix4x43.a31 = (fMatrix4x4.a31 * fMatrix4x42.a11) + (fMatrix4x4.a32 * fMatrix4x42.a21) + (fMatrix4x4.a33 * fMatrix4x42.a31) + (fMatrix4x4.a34 * fMatrix4x42.a41);
        fMatrix4x43.a32 = (fMatrix4x4.a31 * fMatrix4x42.a12) + (fMatrix4x4.a32 * fMatrix4x42.a22) + (fMatrix4x4.a33 * fMatrix4x42.a32) + (fMatrix4x4.a34 * fMatrix4x42.a42);
        fMatrix4x43.a33 = (fMatrix4x4.a31 * fMatrix4x42.a13) + (fMatrix4x4.a32 * fMatrix4x42.a23) + (fMatrix4x4.a33 * fMatrix4x42.a33) + (fMatrix4x4.a34 * fMatrix4x42.a43);
        fMatrix4x43.a34 = (fMatrix4x4.a31 * fMatrix4x42.a14) + (fMatrix4x4.a32 * fMatrix4x42.a24) + (fMatrix4x4.a33 * fMatrix4x42.a34) + (fMatrix4x4.a34 * fMatrix4x42.a44);
        fMatrix4x43.a41 = (fMatrix4x4.a41 * fMatrix4x42.a11) + (fMatrix4x4.a42 * fMatrix4x42.a21) + (fMatrix4x4.a43 * fMatrix4x42.a31) + (fMatrix4x4.a44 * fMatrix4x42.a41);
        fMatrix4x43.a42 = (fMatrix4x4.a41 * fMatrix4x42.a12) + (fMatrix4x4.a42 * fMatrix4x42.a22) + (fMatrix4x4.a43 * fMatrix4x42.a32) + (fMatrix4x4.a44 * fMatrix4x42.a42);
        fMatrix4x43.a43 = (fMatrix4x4.a41 * fMatrix4x42.a13) + (fMatrix4x4.a42 * fMatrix4x42.a23) + (fMatrix4x4.a43 * fMatrix4x42.a33) + (fMatrix4x4.a44 * fMatrix4x42.a43);
        fMatrix4x43.a44 = (fMatrix4x4.a41 * fMatrix4x42.a14) + (fMatrix4x4.a42 * fMatrix4x42.a24) + (fMatrix4x4.a43 * fMatrix4x42.a34) + (fMatrix4x4.a44 * fMatrix4x42.a44);
    }

    public static void multTransA(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42, FMatrix4x4 fMatrix4x43) {
        fMatrix4x43.a11 = (fMatrix4x4.a11 * fMatrix4x42.a11) + (fMatrix4x4.a21 * fMatrix4x42.a21) + (fMatrix4x4.a31 * fMatrix4x42.a31) + (fMatrix4x4.a41 * fMatrix4x42.a41);
        fMatrix4x43.a12 = (fMatrix4x4.a11 * fMatrix4x42.a12) + (fMatrix4x4.a21 * fMatrix4x42.a22) + (fMatrix4x4.a31 * fMatrix4x42.a32) + (fMatrix4x4.a41 * fMatrix4x42.a42);
        fMatrix4x43.a13 = (fMatrix4x4.a11 * fMatrix4x42.a13) + (fMatrix4x4.a21 * fMatrix4x42.a23) + (fMatrix4x4.a31 * fMatrix4x42.a33) + (fMatrix4x4.a41 * fMatrix4x42.a43);
        fMatrix4x43.a14 = (fMatrix4x4.a11 * fMatrix4x42.a14) + (fMatrix4x4.a21 * fMatrix4x42.a24) + (fMatrix4x4.a31 * fMatrix4x42.a34) + (fMatrix4x4.a41 * fMatrix4x42.a44);
        fMatrix4x43.a21 = (fMatrix4x4.a12 * fMatrix4x42.a11) + (fMatrix4x4.a22 * fMatrix4x42.a21) + (fMatrix4x4.a32 * fMatrix4x42.a31) + (fMatrix4x4.a42 * fMatrix4x42.a41);
        fMatrix4x43.a22 = (fMatrix4x4.a12 * fMatrix4x42.a12) + (fMatrix4x4.a22 * fMatrix4x42.a22) + (fMatrix4x4.a32 * fMatrix4x42.a32) + (fMatrix4x4.a42 * fMatrix4x42.a42);
        fMatrix4x43.a23 = (fMatrix4x4.a12 * fMatrix4x42.a13) + (fMatrix4x4.a22 * fMatrix4x42.a23) + (fMatrix4x4.a32 * fMatrix4x42.a33) + (fMatrix4x4.a42 * fMatrix4x42.a43);
        fMatrix4x43.a24 = (fMatrix4x4.a12 * fMatrix4x42.a14) + (fMatrix4x4.a22 * fMatrix4x42.a24) + (fMatrix4x4.a32 * fMatrix4x42.a34) + (fMatrix4x4.a42 * fMatrix4x42.a44);
        fMatrix4x43.a31 = (fMatrix4x4.a13 * fMatrix4x42.a11) + (fMatrix4x4.a23 * fMatrix4x42.a21) + (fMatrix4x4.a33 * fMatrix4x42.a31) + (fMatrix4x4.a43 * fMatrix4x42.a41);
        fMatrix4x43.a32 = (fMatrix4x4.a13 * fMatrix4x42.a12) + (fMatrix4x4.a23 * fMatrix4x42.a22) + (fMatrix4x4.a33 * fMatrix4x42.a32) + (fMatrix4x4.a43 * fMatrix4x42.a42);
        fMatrix4x43.a33 = (fMatrix4x4.a13 * fMatrix4x42.a13) + (fMatrix4x4.a23 * fMatrix4x42.a23) + (fMatrix4x4.a33 * fMatrix4x42.a33) + (fMatrix4x4.a43 * fMatrix4x42.a43);
        fMatrix4x43.a34 = (fMatrix4x4.a13 * fMatrix4x42.a14) + (fMatrix4x4.a23 * fMatrix4x42.a24) + (fMatrix4x4.a33 * fMatrix4x42.a34) + (fMatrix4x4.a43 * fMatrix4x42.a44);
        fMatrix4x43.a41 = (fMatrix4x4.a14 * fMatrix4x42.a11) + (fMatrix4x4.a24 * fMatrix4x42.a21) + (fMatrix4x4.a34 * fMatrix4x42.a31) + (fMatrix4x4.a44 * fMatrix4x42.a41);
        fMatrix4x43.a42 = (fMatrix4x4.a14 * fMatrix4x42.a12) + (fMatrix4x4.a24 * fMatrix4x42.a22) + (fMatrix4x4.a34 * fMatrix4x42.a32) + (fMatrix4x4.a44 * fMatrix4x42.a42);
        fMatrix4x43.a43 = (fMatrix4x4.a14 * fMatrix4x42.a13) + (fMatrix4x4.a24 * fMatrix4x42.a23) + (fMatrix4x4.a34 * fMatrix4x42.a33) + (fMatrix4x4.a44 * fMatrix4x42.a43);
        fMatrix4x43.a44 = (fMatrix4x4.a14 * fMatrix4x42.a14) + (fMatrix4x4.a24 * fMatrix4x42.a24) + (fMatrix4x4.a34 * fMatrix4x42.a34) + (fMatrix4x4.a44 * fMatrix4x42.a44);
    }

    public static void multTransAB(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42, FMatrix4x4 fMatrix4x43) {
        fMatrix4x43.a11 = (fMatrix4x4.a11 * fMatrix4x42.a11) + (fMatrix4x4.a21 * fMatrix4x42.a12) + (fMatrix4x4.a31 * fMatrix4x42.a13) + (fMatrix4x4.a41 * fMatrix4x42.a14);
        fMatrix4x43.a12 = (fMatrix4x4.a11 * fMatrix4x42.a21) + (fMatrix4x4.a21 * fMatrix4x42.a22) + (fMatrix4x4.a31 * fMatrix4x42.a23) + (fMatrix4x4.a41 * fMatrix4x42.a24);
        fMatrix4x43.a13 = (fMatrix4x4.a11 * fMatrix4x42.a31) + (fMatrix4x4.a21 * fMatrix4x42.a32) + (fMatrix4x4.a31 * fMatrix4x42.a33) + (fMatrix4x4.a41 * fMatrix4x42.a34);
        fMatrix4x43.a14 = (fMatrix4x4.a11 * fMatrix4x42.a41) + (fMatrix4x4.a21 * fMatrix4x42.a42) + (fMatrix4x4.a31 * fMatrix4x42.a43) + (fMatrix4x4.a41 * fMatrix4x42.a44);
        fMatrix4x43.a21 = (fMatrix4x4.a12 * fMatrix4x42.a11) + (fMatrix4x4.a22 * fMatrix4x42.a12) + (fMatrix4x4.a32 * fMatrix4x42.a13) + (fMatrix4x4.a42 * fMatrix4x42.a14);
        fMatrix4x43.a22 = (fMatrix4x4.a12 * fMatrix4x42.a21) + (fMatrix4x4.a22 * fMatrix4x42.a22) + (fMatrix4x4.a32 * fMatrix4x42.a23) + (fMatrix4x4.a42 * fMatrix4x42.a24);
        fMatrix4x43.a23 = (fMatrix4x4.a12 * fMatrix4x42.a31) + (fMatrix4x4.a22 * fMatrix4x42.a32) + (fMatrix4x4.a32 * fMatrix4x42.a33) + (fMatrix4x4.a42 * fMatrix4x42.a34);
        fMatrix4x43.a24 = (fMatrix4x4.a12 * fMatrix4x42.a41) + (fMatrix4x4.a22 * fMatrix4x42.a42) + (fMatrix4x4.a32 * fMatrix4x42.a43) + (fMatrix4x4.a42 * fMatrix4x42.a44);
        fMatrix4x43.a31 = (fMatrix4x4.a13 * fMatrix4x42.a11) + (fMatrix4x4.a23 * fMatrix4x42.a12) + (fMatrix4x4.a33 * fMatrix4x42.a13) + (fMatrix4x4.a43 * fMatrix4x42.a14);
        fMatrix4x43.a32 = (fMatrix4x4.a13 * fMatrix4x42.a21) + (fMatrix4x4.a23 * fMatrix4x42.a22) + (fMatrix4x4.a33 * fMatrix4x42.a23) + (fMatrix4x4.a43 * fMatrix4x42.a24);
        fMatrix4x43.a33 = (fMatrix4x4.a13 * fMatrix4x42.a31) + (fMatrix4x4.a23 * fMatrix4x42.a32) + (fMatrix4x4.a33 * fMatrix4x42.a33) + (fMatrix4x4.a43 * fMatrix4x42.a34);
        fMatrix4x43.a34 = (fMatrix4x4.a13 * fMatrix4x42.a41) + (fMatrix4x4.a23 * fMatrix4x42.a42) + (fMatrix4x4.a33 * fMatrix4x42.a43) + (fMatrix4x4.a43 * fMatrix4x42.a44);
        fMatrix4x43.a41 = (fMatrix4x4.a14 * fMatrix4x42.a11) + (fMatrix4x4.a24 * fMatrix4x42.a12) + (fMatrix4x4.a34 * fMatrix4x42.a13) + (fMatrix4x4.a44 * fMatrix4x42.a14);
        fMatrix4x43.a42 = (fMatrix4x4.a14 * fMatrix4x42.a21) + (fMatrix4x4.a24 * fMatrix4x42.a22) + (fMatrix4x4.a34 * fMatrix4x42.a23) + (fMatrix4x4.a44 * fMatrix4x42.a24);
        fMatrix4x43.a43 = (fMatrix4x4.a14 * fMatrix4x42.a31) + (fMatrix4x4.a24 * fMatrix4x42.a32) + (fMatrix4x4.a34 * fMatrix4x42.a33) + (fMatrix4x4.a44 * fMatrix4x42.a34);
        fMatrix4x43.a44 = (fMatrix4x4.a14 * fMatrix4x42.a41) + (fMatrix4x4.a24 * fMatrix4x42.a42) + (fMatrix4x4.a34 * fMatrix4x42.a43) + (fMatrix4x4.a44 * fMatrix4x42.a44);
    }

    public static void multTransB(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42, FMatrix4x4 fMatrix4x43) {
        fMatrix4x43.a11 = (fMatrix4x4.a11 * fMatrix4x42.a11) + (fMatrix4x4.a12 * fMatrix4x42.a12) + (fMatrix4x4.a13 * fMatrix4x42.a13) + (fMatrix4x4.a14 * fMatrix4x42.a14);
        fMatrix4x43.a12 = (fMatrix4x4.a11 * fMatrix4x42.a21) + (fMatrix4x4.a12 * fMatrix4x42.a22) + (fMatrix4x4.a13 * fMatrix4x42.a23) + (fMatrix4x4.a14 * fMatrix4x42.a24);
        fMatrix4x43.a13 = (fMatrix4x4.a11 * fMatrix4x42.a31) + (fMatrix4x4.a12 * fMatrix4x42.a32) + (fMatrix4x4.a13 * fMatrix4x42.a33) + (fMatrix4x4.a14 * fMatrix4x42.a34);
        fMatrix4x43.a14 = (fMatrix4x4.a11 * fMatrix4x42.a41) + (fMatrix4x4.a12 * fMatrix4x42.a42) + (fMatrix4x4.a13 * fMatrix4x42.a43) + (fMatrix4x4.a14 * fMatrix4x42.a44);
        fMatrix4x43.a21 = (fMatrix4x4.a21 * fMatrix4x42.a11) + (fMatrix4x4.a22 * fMatrix4x42.a12) + (fMatrix4x4.a23 * fMatrix4x42.a13) + (fMatrix4x4.a24 * fMatrix4x42.a14);
        fMatrix4x43.a22 = (fMatrix4x4.a21 * fMatrix4x42.a21) + (fMatrix4x4.a22 * fMatrix4x42.a22) + (fMatrix4x4.a23 * fMatrix4x42.a23) + (fMatrix4x4.a24 * fMatrix4x42.a24);
        fMatrix4x43.a23 = (fMatrix4x4.a21 * fMatrix4x42.a31) + (fMatrix4x4.a22 * fMatrix4x42.a32) + (fMatrix4x4.a23 * fMatrix4x42.a33) + (fMatrix4x4.a24 * fMatrix4x42.a34);
        fMatrix4x43.a24 = (fMatrix4x4.a21 * fMatrix4x42.a41) + (fMatrix4x4.a22 * fMatrix4x42.a42) + (fMatrix4x4.a23 * fMatrix4x42.a43) + (fMatrix4x4.a24 * fMatrix4x42.a44);
        fMatrix4x43.a31 = (fMatrix4x4.a31 * fMatrix4x42.a11) + (fMatrix4x4.a32 * fMatrix4x42.a12) + (fMatrix4x4.a33 * fMatrix4x42.a13) + (fMatrix4x4.a34 * fMatrix4x42.a14);
        fMatrix4x43.a32 = (fMatrix4x4.a31 * fMatrix4x42.a21) + (fMatrix4x4.a32 * fMatrix4x42.a22) + (fMatrix4x4.a33 * fMatrix4x42.a23) + (fMatrix4x4.a34 * fMatrix4x42.a24);
        fMatrix4x43.a33 = (fMatrix4x4.a31 * fMatrix4x42.a31) + (fMatrix4x4.a32 * fMatrix4x42.a32) + (fMatrix4x4.a33 * fMatrix4x42.a33) + (fMatrix4x4.a34 * fMatrix4x42.a34);
        fMatrix4x43.a34 = (fMatrix4x4.a31 * fMatrix4x42.a41) + (fMatrix4x4.a32 * fMatrix4x42.a42) + (fMatrix4x4.a33 * fMatrix4x42.a43) + (fMatrix4x4.a34 * fMatrix4x42.a44);
        fMatrix4x43.a41 = (fMatrix4x4.a41 * fMatrix4x42.a11) + (fMatrix4x4.a42 * fMatrix4x42.a12) + (fMatrix4x4.a43 * fMatrix4x42.a13) + (fMatrix4x4.a44 * fMatrix4x42.a14);
        fMatrix4x43.a42 = (fMatrix4x4.a41 * fMatrix4x42.a21) + (fMatrix4x4.a42 * fMatrix4x42.a22) + (fMatrix4x4.a43 * fMatrix4x42.a23) + (fMatrix4x4.a44 * fMatrix4x42.a24);
        fMatrix4x43.a43 = (fMatrix4x4.a41 * fMatrix4x42.a31) + (fMatrix4x4.a42 * fMatrix4x42.a32) + (fMatrix4x4.a43 * fMatrix4x42.a33) + (fMatrix4x4.a44 * fMatrix4x42.a34);
        fMatrix4x43.a44 = (fMatrix4x4.a41 * fMatrix4x42.a41) + (fMatrix4x4.a42 * fMatrix4x42.a42) + (fMatrix4x4.a43 * fMatrix4x42.a43) + (fMatrix4x4.a44 * fMatrix4x42.a44);
    }

    public static void multAdd(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42, FMatrix4x4 fMatrix4x43) {
        fMatrix4x43.a11 += (fMatrix4x4.a11 * fMatrix4x42.a11) + (fMatrix4x4.a12 * fMatrix4x42.a21) + (fMatrix4x4.a13 * fMatrix4x42.a31) + (fMatrix4x4.a14 * fMatrix4x42.a41);
        fMatrix4x43.a12 += (fMatrix4x4.a11 * fMatrix4x42.a12) + (fMatrix4x4.a12 * fMatrix4x42.a22) + (fMatrix4x4.a13 * fMatrix4x42.a32) + (fMatrix4x4.a14 * fMatrix4x42.a42);
        fMatrix4x43.a13 += (fMatrix4x4.a11 * fMatrix4x42.a13) + (fMatrix4x4.a12 * fMatrix4x42.a23) + (fMatrix4x4.a13 * fMatrix4x42.a33) + (fMatrix4x4.a14 * fMatrix4x42.a43);
        fMatrix4x43.a14 += (fMatrix4x4.a11 * fMatrix4x42.a14) + (fMatrix4x4.a12 * fMatrix4x42.a24) + (fMatrix4x4.a13 * fMatrix4x42.a34) + (fMatrix4x4.a14 * fMatrix4x42.a44);
        fMatrix4x43.a21 += (fMatrix4x4.a21 * fMatrix4x42.a11) + (fMatrix4x4.a22 * fMatrix4x42.a21) + (fMatrix4x4.a23 * fMatrix4x42.a31) + (fMatrix4x4.a24 * fMatrix4x42.a41);
        fMatrix4x43.a22 += (fMatrix4x4.a21 * fMatrix4x42.a12) + (fMatrix4x4.a22 * fMatrix4x42.a22) + (fMatrix4x4.a23 * fMatrix4x42.a32) + (fMatrix4x4.a24 * fMatrix4x42.a42);
        fMatrix4x43.a23 += (fMatrix4x4.a21 * fMatrix4x42.a13) + (fMatrix4x4.a22 * fMatrix4x42.a23) + (fMatrix4x4.a23 * fMatrix4x42.a33) + (fMatrix4x4.a24 * fMatrix4x42.a43);
        fMatrix4x43.a24 += (fMatrix4x4.a21 * fMatrix4x42.a14) + (fMatrix4x4.a22 * fMatrix4x42.a24) + (fMatrix4x4.a23 * fMatrix4x42.a34) + (fMatrix4x4.a24 * fMatrix4x42.a44);
        fMatrix4x43.a31 += (fMatrix4x4.a31 * fMatrix4x42.a11) + (fMatrix4x4.a32 * fMatrix4x42.a21) + (fMatrix4x4.a33 * fMatrix4x42.a31) + (fMatrix4x4.a34 * fMatrix4x42.a41);
        fMatrix4x43.a32 += (fMatrix4x4.a31 * fMatrix4x42.a12) + (fMatrix4x4.a32 * fMatrix4x42.a22) + (fMatrix4x4.a33 * fMatrix4x42.a32) + (fMatrix4x4.a34 * fMatrix4x42.a42);
        fMatrix4x43.a33 += (fMatrix4x4.a31 * fMatrix4x42.a13) + (fMatrix4x4.a32 * fMatrix4x42.a23) + (fMatrix4x4.a33 * fMatrix4x42.a33) + (fMatrix4x4.a34 * fMatrix4x42.a43);
        fMatrix4x43.a34 += (fMatrix4x4.a31 * fMatrix4x42.a14) + (fMatrix4x4.a32 * fMatrix4x42.a24) + (fMatrix4x4.a33 * fMatrix4x42.a34) + (fMatrix4x4.a34 * fMatrix4x42.a44);
        fMatrix4x43.a41 += (fMatrix4x4.a41 * fMatrix4x42.a11) + (fMatrix4x4.a42 * fMatrix4x42.a21) + (fMatrix4x4.a43 * fMatrix4x42.a31) + (fMatrix4x4.a44 * fMatrix4x42.a41);
        fMatrix4x43.a42 += (fMatrix4x4.a41 * fMatrix4x42.a12) + (fMatrix4x4.a42 * fMatrix4x42.a22) + (fMatrix4x4.a43 * fMatrix4x42.a32) + (fMatrix4x4.a44 * fMatrix4x42.a42);
        fMatrix4x43.a43 += (fMatrix4x4.a41 * fMatrix4x42.a13) + (fMatrix4x4.a42 * fMatrix4x42.a23) + (fMatrix4x4.a43 * fMatrix4x42.a33) + (fMatrix4x4.a44 * fMatrix4x42.a43);
        fMatrix4x43.a44 += (fMatrix4x4.a41 * fMatrix4x42.a14) + (fMatrix4x4.a42 * fMatrix4x42.a24) + (fMatrix4x4.a43 * fMatrix4x42.a34) + (fMatrix4x4.a44 * fMatrix4x42.a44);
    }

    public static void multAddTransA(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42, FMatrix4x4 fMatrix4x43) {
        fMatrix4x43.a11 += (fMatrix4x4.a11 * fMatrix4x42.a11) + (fMatrix4x4.a21 * fMatrix4x42.a21) + (fMatrix4x4.a31 * fMatrix4x42.a31) + (fMatrix4x4.a41 * fMatrix4x42.a41);
        fMatrix4x43.a12 += (fMatrix4x4.a11 * fMatrix4x42.a12) + (fMatrix4x4.a21 * fMatrix4x42.a22) + (fMatrix4x4.a31 * fMatrix4x42.a32) + (fMatrix4x4.a41 * fMatrix4x42.a42);
        fMatrix4x43.a13 += (fMatrix4x4.a11 * fMatrix4x42.a13) + (fMatrix4x4.a21 * fMatrix4x42.a23) + (fMatrix4x4.a31 * fMatrix4x42.a33) + (fMatrix4x4.a41 * fMatrix4x42.a43);
        fMatrix4x43.a14 += (fMatrix4x4.a11 * fMatrix4x42.a14) + (fMatrix4x4.a21 * fMatrix4x42.a24) + (fMatrix4x4.a31 * fMatrix4x42.a34) + (fMatrix4x4.a41 * fMatrix4x42.a44);
        fMatrix4x43.a21 += (fMatrix4x4.a12 * fMatrix4x42.a11) + (fMatrix4x4.a22 * fMatrix4x42.a21) + (fMatrix4x4.a32 * fMatrix4x42.a31) + (fMatrix4x4.a42 * fMatrix4x42.a41);
        fMatrix4x43.a22 += (fMatrix4x4.a12 * fMatrix4x42.a12) + (fMatrix4x4.a22 * fMatrix4x42.a22) + (fMatrix4x4.a32 * fMatrix4x42.a32) + (fMatrix4x4.a42 * fMatrix4x42.a42);
        fMatrix4x43.a23 += (fMatrix4x4.a12 * fMatrix4x42.a13) + (fMatrix4x4.a22 * fMatrix4x42.a23) + (fMatrix4x4.a32 * fMatrix4x42.a33) + (fMatrix4x4.a42 * fMatrix4x42.a43);
        fMatrix4x43.a24 += (fMatrix4x4.a12 * fMatrix4x42.a14) + (fMatrix4x4.a22 * fMatrix4x42.a24) + (fMatrix4x4.a32 * fMatrix4x42.a34) + (fMatrix4x4.a42 * fMatrix4x42.a44);
        fMatrix4x43.a31 += (fMatrix4x4.a13 * fMatrix4x42.a11) + (fMatrix4x4.a23 * fMatrix4x42.a21) + (fMatrix4x4.a33 * fMatrix4x42.a31) + (fMatrix4x4.a43 * fMatrix4x42.a41);
        fMatrix4x43.a32 += (fMatrix4x4.a13 * fMatrix4x42.a12) + (fMatrix4x4.a23 * fMatrix4x42.a22) + (fMatrix4x4.a33 * fMatrix4x42.a32) + (fMatrix4x4.a43 * fMatrix4x42.a42);
        fMatrix4x43.a33 += (fMatrix4x4.a13 * fMatrix4x42.a13) + (fMatrix4x4.a23 * fMatrix4x42.a23) + (fMatrix4x4.a33 * fMatrix4x42.a33) + (fMatrix4x4.a43 * fMatrix4x42.a43);
        fMatrix4x43.a34 += (fMatrix4x4.a13 * fMatrix4x42.a14) + (fMatrix4x4.a23 * fMatrix4x42.a24) + (fMatrix4x4.a33 * fMatrix4x42.a34) + (fMatrix4x4.a43 * fMatrix4x42.a44);
        fMatrix4x43.a41 += (fMatrix4x4.a14 * fMatrix4x42.a11) + (fMatrix4x4.a24 * fMatrix4x42.a21) + (fMatrix4x4.a34 * fMatrix4x42.a31) + (fMatrix4x4.a44 * fMatrix4x42.a41);
        fMatrix4x43.a42 += (fMatrix4x4.a14 * fMatrix4x42.a12) + (fMatrix4x4.a24 * fMatrix4x42.a22) + (fMatrix4x4.a34 * fMatrix4x42.a32) + (fMatrix4x4.a44 * fMatrix4x42.a42);
        fMatrix4x43.a43 += (fMatrix4x4.a14 * fMatrix4x42.a13) + (fMatrix4x4.a24 * fMatrix4x42.a23) + (fMatrix4x4.a34 * fMatrix4x42.a33) + (fMatrix4x4.a44 * fMatrix4x42.a43);
        fMatrix4x43.a44 += (fMatrix4x4.a14 * fMatrix4x42.a14) + (fMatrix4x4.a24 * fMatrix4x42.a24) + (fMatrix4x4.a34 * fMatrix4x42.a34) + (fMatrix4x4.a44 * fMatrix4x42.a44);
    }

    public static void multAddTransAB(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42, FMatrix4x4 fMatrix4x43) {
        fMatrix4x43.a11 += (fMatrix4x4.a11 * fMatrix4x42.a11) + (fMatrix4x4.a21 * fMatrix4x42.a12) + (fMatrix4x4.a31 * fMatrix4x42.a13) + (fMatrix4x4.a41 * fMatrix4x42.a14);
        fMatrix4x43.a12 += (fMatrix4x4.a11 * fMatrix4x42.a21) + (fMatrix4x4.a21 * fMatrix4x42.a22) + (fMatrix4x4.a31 * fMatrix4x42.a23) + (fMatrix4x4.a41 * fMatrix4x42.a24);
        fMatrix4x43.a13 += (fMatrix4x4.a11 * fMatrix4x42.a31) + (fMatrix4x4.a21 * fMatrix4x42.a32) + (fMatrix4x4.a31 * fMatrix4x42.a33) + (fMatrix4x4.a41 * fMatrix4x42.a34);
        fMatrix4x43.a14 += (fMatrix4x4.a11 * fMatrix4x42.a41) + (fMatrix4x4.a21 * fMatrix4x42.a42) + (fMatrix4x4.a31 * fMatrix4x42.a43) + (fMatrix4x4.a41 * fMatrix4x42.a44);
        fMatrix4x43.a21 += (fMatrix4x4.a12 * fMatrix4x42.a11) + (fMatrix4x4.a22 * fMatrix4x42.a12) + (fMatrix4x4.a32 * fMatrix4x42.a13) + (fMatrix4x4.a42 * fMatrix4x42.a14);
        fMatrix4x43.a22 += (fMatrix4x4.a12 * fMatrix4x42.a21) + (fMatrix4x4.a22 * fMatrix4x42.a22) + (fMatrix4x4.a32 * fMatrix4x42.a23) + (fMatrix4x4.a42 * fMatrix4x42.a24);
        fMatrix4x43.a23 += (fMatrix4x4.a12 * fMatrix4x42.a31) + (fMatrix4x4.a22 * fMatrix4x42.a32) + (fMatrix4x4.a32 * fMatrix4x42.a33) + (fMatrix4x4.a42 * fMatrix4x42.a34);
        fMatrix4x43.a24 += (fMatrix4x4.a12 * fMatrix4x42.a41) + (fMatrix4x4.a22 * fMatrix4x42.a42) + (fMatrix4x4.a32 * fMatrix4x42.a43) + (fMatrix4x4.a42 * fMatrix4x42.a44);
        fMatrix4x43.a31 += (fMatrix4x4.a13 * fMatrix4x42.a11) + (fMatrix4x4.a23 * fMatrix4x42.a12) + (fMatrix4x4.a33 * fMatrix4x42.a13) + (fMatrix4x4.a43 * fMatrix4x42.a14);
        fMatrix4x43.a32 += (fMatrix4x4.a13 * fMatrix4x42.a21) + (fMatrix4x4.a23 * fMatrix4x42.a22) + (fMatrix4x4.a33 * fMatrix4x42.a23) + (fMatrix4x4.a43 * fMatrix4x42.a24);
        fMatrix4x43.a33 += (fMatrix4x4.a13 * fMatrix4x42.a31) + (fMatrix4x4.a23 * fMatrix4x42.a32) + (fMatrix4x4.a33 * fMatrix4x42.a33) + (fMatrix4x4.a43 * fMatrix4x42.a34);
        fMatrix4x43.a34 += (fMatrix4x4.a13 * fMatrix4x42.a41) + (fMatrix4x4.a23 * fMatrix4x42.a42) + (fMatrix4x4.a33 * fMatrix4x42.a43) + (fMatrix4x4.a43 * fMatrix4x42.a44);
        fMatrix4x43.a41 += (fMatrix4x4.a14 * fMatrix4x42.a11) + (fMatrix4x4.a24 * fMatrix4x42.a12) + (fMatrix4x4.a34 * fMatrix4x42.a13) + (fMatrix4x4.a44 * fMatrix4x42.a14);
        fMatrix4x43.a42 += (fMatrix4x4.a14 * fMatrix4x42.a21) + (fMatrix4x4.a24 * fMatrix4x42.a22) + (fMatrix4x4.a34 * fMatrix4x42.a23) + (fMatrix4x4.a44 * fMatrix4x42.a24);
        fMatrix4x43.a43 += (fMatrix4x4.a14 * fMatrix4x42.a31) + (fMatrix4x4.a24 * fMatrix4x42.a32) + (fMatrix4x4.a34 * fMatrix4x42.a33) + (fMatrix4x4.a44 * fMatrix4x42.a34);
        fMatrix4x43.a44 += (fMatrix4x4.a14 * fMatrix4x42.a41) + (fMatrix4x4.a24 * fMatrix4x42.a42) + (fMatrix4x4.a34 * fMatrix4x42.a43) + (fMatrix4x4.a44 * fMatrix4x42.a44);
    }

    public static void multAddTransB(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42, FMatrix4x4 fMatrix4x43) {
        fMatrix4x43.a11 += (fMatrix4x4.a11 * fMatrix4x42.a11) + (fMatrix4x4.a12 * fMatrix4x42.a12) + (fMatrix4x4.a13 * fMatrix4x42.a13) + (fMatrix4x4.a14 * fMatrix4x42.a14);
        fMatrix4x43.a12 += (fMatrix4x4.a11 * fMatrix4x42.a21) + (fMatrix4x4.a12 * fMatrix4x42.a22) + (fMatrix4x4.a13 * fMatrix4x42.a23) + (fMatrix4x4.a14 * fMatrix4x42.a24);
        fMatrix4x43.a13 += (fMatrix4x4.a11 * fMatrix4x42.a31) + (fMatrix4x4.a12 * fMatrix4x42.a32) + (fMatrix4x4.a13 * fMatrix4x42.a33) + (fMatrix4x4.a14 * fMatrix4x42.a34);
        fMatrix4x43.a14 += (fMatrix4x4.a11 * fMatrix4x42.a41) + (fMatrix4x4.a12 * fMatrix4x42.a42) + (fMatrix4x4.a13 * fMatrix4x42.a43) + (fMatrix4x4.a14 * fMatrix4x42.a44);
        fMatrix4x43.a21 += (fMatrix4x4.a21 * fMatrix4x42.a11) + (fMatrix4x4.a22 * fMatrix4x42.a12) + (fMatrix4x4.a23 * fMatrix4x42.a13) + (fMatrix4x4.a24 * fMatrix4x42.a14);
        fMatrix4x43.a22 += (fMatrix4x4.a21 * fMatrix4x42.a21) + (fMatrix4x4.a22 * fMatrix4x42.a22) + (fMatrix4x4.a23 * fMatrix4x42.a23) + (fMatrix4x4.a24 * fMatrix4x42.a24);
        fMatrix4x43.a23 += (fMatrix4x4.a21 * fMatrix4x42.a31) + (fMatrix4x4.a22 * fMatrix4x42.a32) + (fMatrix4x4.a23 * fMatrix4x42.a33) + (fMatrix4x4.a24 * fMatrix4x42.a34);
        fMatrix4x43.a24 += (fMatrix4x4.a21 * fMatrix4x42.a41) + (fMatrix4x4.a22 * fMatrix4x42.a42) + (fMatrix4x4.a23 * fMatrix4x42.a43) + (fMatrix4x4.a24 * fMatrix4x42.a44);
        fMatrix4x43.a31 += (fMatrix4x4.a31 * fMatrix4x42.a11) + (fMatrix4x4.a32 * fMatrix4x42.a12) + (fMatrix4x4.a33 * fMatrix4x42.a13) + (fMatrix4x4.a34 * fMatrix4x42.a14);
        fMatrix4x43.a32 += (fMatrix4x4.a31 * fMatrix4x42.a21) + (fMatrix4x4.a32 * fMatrix4x42.a22) + (fMatrix4x4.a33 * fMatrix4x42.a23) + (fMatrix4x4.a34 * fMatrix4x42.a24);
        fMatrix4x43.a33 += (fMatrix4x4.a31 * fMatrix4x42.a31) + (fMatrix4x4.a32 * fMatrix4x42.a32) + (fMatrix4x4.a33 * fMatrix4x42.a33) + (fMatrix4x4.a34 * fMatrix4x42.a34);
        fMatrix4x43.a34 += (fMatrix4x4.a31 * fMatrix4x42.a41) + (fMatrix4x4.a32 * fMatrix4x42.a42) + (fMatrix4x4.a33 * fMatrix4x42.a43) + (fMatrix4x4.a34 * fMatrix4x42.a44);
        fMatrix4x43.a41 += (fMatrix4x4.a41 * fMatrix4x42.a11) + (fMatrix4x4.a42 * fMatrix4x42.a12) + (fMatrix4x4.a43 * fMatrix4x42.a13) + (fMatrix4x4.a44 * fMatrix4x42.a14);
        fMatrix4x43.a42 += (fMatrix4x4.a41 * fMatrix4x42.a21) + (fMatrix4x4.a42 * fMatrix4x42.a22) + (fMatrix4x4.a43 * fMatrix4x42.a23) + (fMatrix4x4.a44 * fMatrix4x42.a24);
        fMatrix4x43.a43 += (fMatrix4x4.a41 * fMatrix4x42.a31) + (fMatrix4x4.a42 * fMatrix4x42.a32) + (fMatrix4x4.a43 * fMatrix4x42.a33) + (fMatrix4x4.a44 * fMatrix4x42.a34);
        fMatrix4x43.a44 += (fMatrix4x4.a41 * fMatrix4x42.a41) + (fMatrix4x4.a42 * fMatrix4x42.a42) + (fMatrix4x4.a43 * fMatrix4x42.a43) + (fMatrix4x4.a44 * fMatrix4x42.a44);
    }

    public static void mult(FMatrix4x4 fMatrix4x4, FMatrix4 fMatrix4, FMatrix4 fMatrix42) {
        fMatrix42.f2423a1 = (fMatrix4x4.a11 * fMatrix4.f2423a1) + (fMatrix4x4.a12 * fMatrix4.f2424a2) + (fMatrix4x4.a13 * fMatrix4.f2425a3) + (fMatrix4x4.a14 * fMatrix4.f2426a4);
        fMatrix42.f2424a2 = (fMatrix4x4.a21 * fMatrix4.f2423a1) + (fMatrix4x4.a22 * fMatrix4.f2424a2) + (fMatrix4x4.a23 * fMatrix4.f2425a3) + (fMatrix4x4.a24 * fMatrix4.f2426a4);
        fMatrix42.f2425a3 = (fMatrix4x4.a31 * fMatrix4.f2423a1) + (fMatrix4x4.a32 * fMatrix4.f2424a2) + (fMatrix4x4.a33 * fMatrix4.f2425a3) + (fMatrix4x4.a34 * fMatrix4.f2426a4);
        fMatrix42.f2426a4 = (fMatrix4x4.a41 * fMatrix4.f2423a1) + (fMatrix4x4.a42 * fMatrix4.f2424a2) + (fMatrix4x4.a43 * fMatrix4.f2425a3) + (fMatrix4x4.a44 * fMatrix4.f2426a4);
    }

    public static void mult(FMatrix4 fMatrix4, FMatrix4x4 fMatrix4x4, FMatrix4 fMatrix42) {
        fMatrix42.f2423a1 = (fMatrix4.f2423a1 * fMatrix4x4.a11) + (fMatrix4.f2424a2 * fMatrix4x4.a21) + (fMatrix4.f2425a3 * fMatrix4x4.a31) + (fMatrix4.f2426a4 * fMatrix4x4.a41);
        fMatrix42.f2424a2 = (fMatrix4.f2423a1 * fMatrix4x4.a12) + (fMatrix4.f2424a2 * fMatrix4x4.a22) + (fMatrix4.f2425a3 * fMatrix4x4.a32) + (fMatrix4.f2426a4 * fMatrix4x4.a42);
        fMatrix42.f2425a3 = (fMatrix4.f2423a1 * fMatrix4x4.a13) + (fMatrix4.f2424a2 * fMatrix4x4.a23) + (fMatrix4.f2425a3 * fMatrix4x4.a33) + (fMatrix4.f2426a4 * fMatrix4x4.a43);
        fMatrix42.f2426a4 = (fMatrix4.f2423a1 * fMatrix4x4.a14) + (fMatrix4.f2424a2 * fMatrix4x4.a24) + (fMatrix4.f2425a3 * fMatrix4x4.a34) + (fMatrix4.f2426a4 * fMatrix4x4.a44);
    }

    public static float dot(FMatrix4 fMatrix4, FMatrix4 fMatrix42) {
        return (fMatrix4.f2423a1 * fMatrix42.f2423a1) + (fMatrix4.f2424a2 * fMatrix42.f2424a2) + (fMatrix4.f2425a3 * fMatrix42.f2425a3) + (fMatrix4.f2426a4 * fMatrix42.f2426a4);
    }

    public static void setIdentity(FMatrix4x4 fMatrix4x4) {
        fMatrix4x4.a11 = 1.0f;
        fMatrix4x4.a21 = 0.0f;
        fMatrix4x4.a31 = 0.0f;
        fMatrix4x4.a41 = 0.0f;
        fMatrix4x4.a12 = 0.0f;
        fMatrix4x4.a22 = 1.0f;
        fMatrix4x4.a32 = 0.0f;
        fMatrix4x4.a42 = 0.0f;
        fMatrix4x4.a13 = 0.0f;
        fMatrix4x4.a23 = 0.0f;
        fMatrix4x4.a33 = 1.0f;
        fMatrix4x4.a43 = 0.0f;
        fMatrix4x4.a14 = 0.0f;
        fMatrix4x4.a24 = 0.0f;
        fMatrix4x4.a34 = 0.0f;
        fMatrix4x4.a44 = 1.0f;
    }

    public static boolean invert(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42) {
        float fElementMaxAbs = 1.0f / elementMaxAbs(fMatrix4x4);
        float f = fMatrix4x4.a11 * fElementMaxAbs;
        float f2 = fMatrix4x4.a12 * fElementMaxAbs;
        float f3 = fMatrix4x4.a13 * fElementMaxAbs;
        float f4 = fMatrix4x4.a14 * fElementMaxAbs;
        float f5 = fMatrix4x4.a21 * fElementMaxAbs;
        float f6 = fMatrix4x4.a22 * fElementMaxAbs;
        float f7 = fMatrix4x4.a23 * fElementMaxAbs;
        float f8 = fMatrix4x4.a24 * fElementMaxAbs;
        float f9 = fMatrix4x4.a31 * fElementMaxAbs;
        float f10 = fMatrix4x4.a32 * fElementMaxAbs;
        float f11 = fMatrix4x4.a33 * fElementMaxAbs;
        float f12 = fMatrix4x4.a34 * fElementMaxAbs;
        float f13 = fMatrix4x4.a41 * fElementMaxAbs;
        float f14 = fMatrix4x4.a42 * fElementMaxAbs;
        float f15 = fMatrix4x4.a43 * fElementMaxAbs;
        float f16 = fMatrix4x4.a44 * fElementMaxAbs;
        float f17 = (f11 * f16) - (f12 * f15);
        float f18 = (f10 * f16) - (f12 * f14);
        float f19 = (f10 * f15) - (f11 * f14);
        float f20 = ((f6 * f17) - (f7 * f18)) + (f8 * f19);
        float f21 = (f9 * f16) - (f12 * f13);
        float f22 = (f9 * f15) - (f11 * f13);
        float f23 = -(((f5 * f17) - (f7 * f21)) + (f8 * f22));
        float f24 = (f9 * f14) - (f10 * f13);
        float f25 = ((f5 * f18) - (f6 * f21)) + (f8 * f24);
        float f26 = -(((f5 * f19) - (f6 * f22)) + (f7 * f24));
        float f27 = -(((f2 * f17) - (f3 * f18)) + (f4 * f19));
        float f28 = ((f17 * f) - (f3 * f21)) + (f4 * f22);
        float f29 = -(((f18 * f) - (f21 * f2)) + (f4 * f24));
        float f30 = ((f19 * f) - (f22 * f2)) + (f24 * f3);
        float f31 = (f7 * f16) - (f8 * f15);
        float f32 = (f6 * f16) - (f8 * f14);
        float f33 = (f6 * f15) - (f7 * f14);
        float f34 = ((f2 * f31) - (f3 * f32)) + (f4 * f33);
        float f35 = (f5 * f16) - (f8 * f13);
        float f36 = (f15 * f5) - (f7 * f13);
        float f37 = -(((f31 * f) - (f3 * f35)) + (f4 * f36));
        float f38 = (f14 * f5) - (f13 * f6);
        float f39 = ((f32 * f) - (f35 * f2)) + (f4 * f38);
        float f40 = -(((f33 * f) - (f36 * f2)) + (f38 * f3));
        float f41 = (f7 * f12) - (f8 * f11);
        float f42 = (f6 * f12) - (f8 * f10);
        float f43 = (f6 * f11) - (f7 * f10);
        float f44 = -(((f2 * f41) - (f3 * f42)) + (f4 * f43));
        float f45 = (f12 * f5) - (f8 * f9);
        float f46 = (f11 * f5) - (f7 * f9);
        float f47 = ((f41 * f) - (f3 * f45)) + (f4 * f46);
        float f48 = (f5 * f10) - (f6 * f9);
        float f49 = -(((f42 * f) - (f45 * f2)) + (f4 * f48));
        float f50 = ((f43 * f) - (f46 * f2)) + (f48 * f3);
        float f51 = ((((f * f20) + (f2 * f23)) + (f3 * f25)) + (f4 * f26)) / fElementMaxAbs;
        fMatrix4x42.a11 = f20 / f51;
        fMatrix4x42.a12 = f27 / f51;
        fMatrix4x42.a13 = f34 / f51;
        fMatrix4x42.a14 = f44 / f51;
        fMatrix4x42.a21 = f23 / f51;
        fMatrix4x42.a22 = f28 / f51;
        fMatrix4x42.a23 = f37 / f51;
        fMatrix4x42.a24 = f47 / f51;
        fMatrix4x42.a31 = f25 / f51;
        fMatrix4x42.a32 = f29 / f51;
        fMatrix4x42.a33 = f39 / f51;
        fMatrix4x42.a34 = f49 / f51;
        fMatrix4x42.a41 = f26 / f51;
        fMatrix4x42.a42 = f30 / f51;
        fMatrix4x42.a43 = f40 / f51;
        fMatrix4x42.a44 = f50 / f51;
        return (Float.isNaN(f51) || Float.isInfinite(f51)) ? false : true;
    }

    public static float det(FMatrix4x4 fMatrix4x4) {
        float f = fMatrix4x4.a22;
        float f2 = fMatrix4x4.a23;
        float f3 = fMatrix4x4.a24;
        float f4 = fMatrix4x4.a32;
        float f5 = fMatrix4x4.a33;
        float f6 = fMatrix4x4.a34;
        float f7 = fMatrix4x4.a42;
        float f8 = fMatrix4x4.a43;
        float f9 = fMatrix4x4.a44;
        float f10 = (f5 * f9) - (f6 * f8);
        float f11 = (fMatrix4x4.a11 * (((f * f10) - (((f4 * f9) - (f6 * f7)) * f2)) + (((f4 * f8) - (f7 * f5)) * f3))) + 0.0f;
        float f12 = fMatrix4x4.a21;
        float f13 = fMatrix4x4.a31;
        float f14 = fMatrix4x4.a41;
        float f15 = (f13 * f9) - (f6 * f14);
        float f16 = f11 - (fMatrix4x4.a12 * (((f10 * f12) - (f2 * f15)) + (((f8 * f13) - (f5 * f14)) * f3)));
        float f17 = fMatrix4x4.a22;
        float f18 = fMatrix4x4.a32;
        float f19 = fMatrix4x4.a42;
        float f20 = (((f9 * f18) - (f6 * f19)) * f12) - (f15 * f17);
        float f21 = (f13 * f19) - (f18 * f14);
        float f22 = f16 + (fMatrix4x4.a13 * (f20 + (f3 * f21)));
        float f23 = fMatrix4x4.a23;
        float f24 = fMatrix4x4.a33;
        float f25 = fMatrix4x4.a43;
        return f22 - (fMatrix4x4.a14 * (((f12 * ((f18 * f25) - (f19 * f24))) - (f17 * ((f13 * f25) - (f24 * f14)))) + (f23 * f21)));
    }

    public static float trace(FMatrix4x4 fMatrix4x4) {
        return fMatrix4x4.a11 + fMatrix4x4.a22 + fMatrix4x4.a33 + fMatrix4x4.a44;
    }

    public static void diag(FMatrix4x4 fMatrix4x4, FMatrix4 fMatrix4) {
        fMatrix4.f2423a1 = fMatrix4x4.a11;
        fMatrix4.f2424a2 = fMatrix4x4.a22;
        fMatrix4.f2425a3 = fMatrix4x4.a33;
        fMatrix4.f2426a4 = fMatrix4x4.a44;
    }

    public static float elementMax(FMatrix4x4 fMatrix4x4) {
        float f = fMatrix4x4.a11;
        if (fMatrix4x4.a12 > f) {
            f = fMatrix4x4.a12;
        }
        if (fMatrix4x4.a13 > f) {
            f = fMatrix4x4.a13;
        }
        if (fMatrix4x4.a14 > f) {
            f = fMatrix4x4.a14;
        }
        if (fMatrix4x4.a21 > f) {
            f = fMatrix4x4.a21;
        }
        if (fMatrix4x4.a22 > f) {
            f = fMatrix4x4.a22;
        }
        if (fMatrix4x4.a23 > f) {
            f = fMatrix4x4.a23;
        }
        if (fMatrix4x4.a24 > f) {
            f = fMatrix4x4.a24;
        }
        if (fMatrix4x4.a31 > f) {
            f = fMatrix4x4.a31;
        }
        if (fMatrix4x4.a32 > f) {
            f = fMatrix4x4.a32;
        }
        if (fMatrix4x4.a33 > f) {
            f = fMatrix4x4.a33;
        }
        if (fMatrix4x4.a34 > f) {
            f = fMatrix4x4.a34;
        }
        if (fMatrix4x4.a41 > f) {
            f = fMatrix4x4.a41;
        }
        if (fMatrix4x4.a42 > f) {
            f = fMatrix4x4.a42;
        }
        if (fMatrix4x4.a43 > f) {
            f = fMatrix4x4.a43;
        }
        return fMatrix4x4.a44 > f ? fMatrix4x4.a44 : f;
    }

    public static float elementMax(FMatrix4 fMatrix4) {
        float f = fMatrix4.f2423a1;
        if (fMatrix4.f2424a2 > f) {
            f = fMatrix4.f2424a2;
        }
        if (fMatrix4.f2425a3 > f) {
            f = fMatrix4.f2425a3;
        }
        return fMatrix4.f2426a4 > f ? fMatrix4.f2426a4 : f;
    }

    public static float elementMaxAbs(FMatrix4x4 fMatrix4x4) {
        float fAbs = Math.abs(fMatrix4x4.a11);
        float fAbs2 = Math.abs(fMatrix4x4.a12);
        if (fAbs2 > fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix4x4.a13);
        if (fAbs3 > fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix4x4.a14);
        if (fAbs4 > fAbs) {
            fAbs = fAbs4;
        }
        float fAbs5 = Math.abs(fMatrix4x4.a21);
        if (fAbs5 > fAbs) {
            fAbs = fAbs5;
        }
        float fAbs6 = Math.abs(fMatrix4x4.a22);
        if (fAbs6 > fAbs) {
            fAbs = fAbs6;
        }
        float fAbs7 = Math.abs(fMatrix4x4.a23);
        if (fAbs7 > fAbs) {
            fAbs = fAbs7;
        }
        float fAbs8 = Math.abs(fMatrix4x4.a24);
        if (fAbs8 > fAbs) {
            fAbs = fAbs8;
        }
        float fAbs9 = Math.abs(fMatrix4x4.a31);
        if (fAbs9 > fAbs) {
            fAbs = fAbs9;
        }
        float fAbs10 = Math.abs(fMatrix4x4.a32);
        if (fAbs10 > fAbs) {
            fAbs = fAbs10;
        }
        float fAbs11 = Math.abs(fMatrix4x4.a33);
        if (fAbs11 > fAbs) {
            fAbs = fAbs11;
        }
        float fAbs12 = Math.abs(fMatrix4x4.a34);
        if (fAbs12 > fAbs) {
            fAbs = fAbs12;
        }
        float fAbs13 = Math.abs(fMatrix4x4.a41);
        if (fAbs13 > fAbs) {
            fAbs = fAbs13;
        }
        float fAbs14 = Math.abs(fMatrix4x4.a42);
        if (fAbs14 > fAbs) {
            fAbs = fAbs14;
        }
        float fAbs15 = Math.abs(fMatrix4x4.a43);
        if (fAbs15 > fAbs) {
            fAbs = fAbs15;
        }
        float fAbs16 = Math.abs(fMatrix4x4.a44);
        return fAbs16 > fAbs ? fAbs16 : fAbs;
    }

    public static float elementMaxAbs(FMatrix4 fMatrix4) {
        float fAbs = Math.abs(fMatrix4.f2423a1);
        float fAbs2 = Math.abs(fMatrix4.f2424a2);
        if (fAbs2 > fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix4.f2424a2);
        if (fAbs3 > fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix4.f2425a3);
        if (fAbs4 > fAbs) {
            fAbs = fAbs4;
        }
        float fAbs5 = Math.abs(fMatrix4.f2426a4);
        return fAbs5 > fAbs ? fAbs5 : fAbs;
    }

    public static float elementMin(FMatrix4x4 fMatrix4x4) {
        float f = fMatrix4x4.a11;
        if (fMatrix4x4.a12 < f) {
            f = fMatrix4x4.a12;
        }
        if (fMatrix4x4.a13 < f) {
            f = fMatrix4x4.a13;
        }
        if (fMatrix4x4.a14 < f) {
            f = fMatrix4x4.a14;
        }
        if (fMatrix4x4.a21 < f) {
            f = fMatrix4x4.a21;
        }
        if (fMatrix4x4.a22 < f) {
            f = fMatrix4x4.a22;
        }
        if (fMatrix4x4.a23 < f) {
            f = fMatrix4x4.a23;
        }
        if (fMatrix4x4.a24 < f) {
            f = fMatrix4x4.a24;
        }
        if (fMatrix4x4.a31 < f) {
            f = fMatrix4x4.a31;
        }
        if (fMatrix4x4.a32 < f) {
            f = fMatrix4x4.a32;
        }
        if (fMatrix4x4.a33 < f) {
            f = fMatrix4x4.a33;
        }
        if (fMatrix4x4.a34 < f) {
            f = fMatrix4x4.a34;
        }
        if (fMatrix4x4.a41 < f) {
            f = fMatrix4x4.a41;
        }
        if (fMatrix4x4.a42 < f) {
            f = fMatrix4x4.a42;
        }
        if (fMatrix4x4.a43 < f) {
            f = fMatrix4x4.a43;
        }
        return fMatrix4x4.a44 < f ? fMatrix4x4.a44 : f;
    }

    public static float elementMin(FMatrix4 fMatrix4) {
        float f = fMatrix4.f2423a1;
        if (fMatrix4.f2424a2 < f) {
            f = fMatrix4.f2424a2;
        }
        if (fMatrix4.f2425a3 < f) {
            f = fMatrix4.f2425a3;
        }
        return fMatrix4.f2426a4 < f ? fMatrix4.f2426a4 : f;
    }

    public static float elementMinAbs(FMatrix4x4 fMatrix4x4) {
        float fAbs = Math.abs(fMatrix4x4.a11);
        float fAbs2 = Math.abs(fMatrix4x4.a12);
        if (fAbs2 < fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix4x4.a13);
        if (fAbs3 < fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix4x4.a14);
        if (fAbs4 < fAbs) {
            fAbs = fAbs4;
        }
        float fAbs5 = Math.abs(fMatrix4x4.a21);
        if (fAbs5 < fAbs) {
            fAbs = fAbs5;
        }
        float fAbs6 = Math.abs(fMatrix4x4.a22);
        if (fAbs6 < fAbs) {
            fAbs = fAbs6;
        }
        float fAbs7 = Math.abs(fMatrix4x4.a23);
        if (fAbs7 < fAbs) {
            fAbs = fAbs7;
        }
        float fAbs8 = Math.abs(fMatrix4x4.a24);
        if (fAbs8 < fAbs) {
            fAbs = fAbs8;
        }
        float fAbs9 = Math.abs(fMatrix4x4.a31);
        if (fAbs9 < fAbs) {
            fAbs = fAbs9;
        }
        float fAbs10 = Math.abs(fMatrix4x4.a32);
        if (fAbs10 < fAbs) {
            fAbs = fAbs10;
        }
        float fAbs11 = Math.abs(fMatrix4x4.a33);
        if (fAbs11 < fAbs) {
            fAbs = fAbs11;
        }
        float fAbs12 = Math.abs(fMatrix4x4.a34);
        if (fAbs12 < fAbs) {
            fAbs = fAbs12;
        }
        float fAbs13 = Math.abs(fMatrix4x4.a41);
        if (fAbs13 < fAbs) {
            fAbs = fAbs13;
        }
        float fAbs14 = Math.abs(fMatrix4x4.a42);
        if (fAbs14 < fAbs) {
            fAbs = fAbs14;
        }
        float fAbs15 = Math.abs(fMatrix4x4.a43);
        if (fAbs15 < fAbs) {
            fAbs = fAbs15;
        }
        float fAbs16 = Math.abs(fMatrix4x4.a44);
        return fAbs16 < fAbs ? fAbs16 : fAbs;
    }

    public static float elementMinAbs(FMatrix4 fMatrix4) {
        float fAbs = Math.abs(fMatrix4.f2423a1);
        float fAbs2 = Math.abs(fMatrix4.f2423a1);
        if (fAbs2 < fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix4.f2424a2);
        if (fAbs3 < fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix4.f2425a3);
        if (fAbs4 < fAbs) {
            fAbs = fAbs4;
        }
        float fAbs5 = Math.abs(fMatrix4.f2426a4);
        return fAbs5 < fAbs ? fAbs5 : fAbs;
    }

    public static void elementMult(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42) {
        fMatrix4x4.a11 *= fMatrix4x42.a11;
        fMatrix4x4.a12 *= fMatrix4x42.a12;
        fMatrix4x4.a13 *= fMatrix4x42.a13;
        fMatrix4x4.a14 *= fMatrix4x42.a14;
        fMatrix4x4.a21 *= fMatrix4x42.a21;
        fMatrix4x4.a22 *= fMatrix4x42.a22;
        fMatrix4x4.a23 *= fMatrix4x42.a23;
        fMatrix4x4.a24 *= fMatrix4x42.a24;
        fMatrix4x4.a31 *= fMatrix4x42.a31;
        fMatrix4x4.a32 *= fMatrix4x42.a32;
        fMatrix4x4.a33 *= fMatrix4x42.a33;
        fMatrix4x4.a34 *= fMatrix4x42.a34;
        fMatrix4x4.a41 *= fMatrix4x42.a41;
        fMatrix4x4.a42 *= fMatrix4x42.a42;
        fMatrix4x4.a43 *= fMatrix4x42.a43;
        fMatrix4x4.a44 *= fMatrix4x42.a44;
    }

    public static void elementMult(FMatrix4 fMatrix4, FMatrix4 fMatrix42) {
        fMatrix4.f2423a1 *= fMatrix42.f2423a1;
        fMatrix4.f2424a2 *= fMatrix42.f2424a2;
        fMatrix4.f2425a3 *= fMatrix42.f2425a3;
        fMatrix4.f2426a4 *= fMatrix42.f2426a4;
    }

    public static void elementMult(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42, FMatrix4x4 fMatrix4x43) {
        fMatrix4x43.a11 = fMatrix4x4.a11 * fMatrix4x42.a11;
        fMatrix4x43.a12 = fMatrix4x4.a12 * fMatrix4x42.a12;
        fMatrix4x43.a13 = fMatrix4x4.a13 * fMatrix4x42.a13;
        fMatrix4x43.a14 = fMatrix4x4.a14 * fMatrix4x42.a14;
        fMatrix4x43.a21 = fMatrix4x4.a21 * fMatrix4x42.a21;
        fMatrix4x43.a22 = fMatrix4x4.a22 * fMatrix4x42.a22;
        fMatrix4x43.a23 = fMatrix4x4.a23 * fMatrix4x42.a23;
        fMatrix4x43.a24 = fMatrix4x4.a24 * fMatrix4x42.a24;
        fMatrix4x43.a31 = fMatrix4x4.a31 * fMatrix4x42.a31;
        fMatrix4x43.a32 = fMatrix4x4.a32 * fMatrix4x42.a32;
        fMatrix4x43.a33 = fMatrix4x4.a33 * fMatrix4x42.a33;
        fMatrix4x43.a34 = fMatrix4x4.a34 * fMatrix4x42.a34;
        fMatrix4x43.a41 = fMatrix4x4.a41 * fMatrix4x42.a41;
        fMatrix4x43.a42 = fMatrix4x4.a42 * fMatrix4x42.a42;
        fMatrix4x43.a43 = fMatrix4x4.a43 * fMatrix4x42.a43;
        fMatrix4x43.a44 = fMatrix4x4.a44 * fMatrix4x42.a44;
    }

    public static void elementMult(FMatrix4 fMatrix4, FMatrix4 fMatrix42, FMatrix4 fMatrix43) {
        fMatrix43.f2423a1 = fMatrix4.f2423a1 * fMatrix42.f2423a1;
        fMatrix43.f2424a2 = fMatrix4.f2424a2 * fMatrix42.f2424a2;
        fMatrix43.f2425a3 = fMatrix4.f2425a3 * fMatrix42.f2425a3;
        fMatrix43.f2426a4 = fMatrix4.f2426a4 * fMatrix42.f2426a4;
    }

    public static void elementDiv(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42) {
        fMatrix4x4.a11 /= fMatrix4x42.a11;
        fMatrix4x4.a12 /= fMatrix4x42.a12;
        fMatrix4x4.a13 /= fMatrix4x42.a13;
        fMatrix4x4.a14 /= fMatrix4x42.a14;
        fMatrix4x4.a21 /= fMatrix4x42.a21;
        fMatrix4x4.a22 /= fMatrix4x42.a22;
        fMatrix4x4.a23 /= fMatrix4x42.a23;
        fMatrix4x4.a24 /= fMatrix4x42.a24;
        fMatrix4x4.a31 /= fMatrix4x42.a31;
        fMatrix4x4.a32 /= fMatrix4x42.a32;
        fMatrix4x4.a33 /= fMatrix4x42.a33;
        fMatrix4x4.a34 /= fMatrix4x42.a34;
        fMatrix4x4.a41 /= fMatrix4x42.a41;
        fMatrix4x4.a42 /= fMatrix4x42.a42;
        fMatrix4x4.a43 /= fMatrix4x42.a43;
        fMatrix4x4.a44 /= fMatrix4x42.a44;
    }

    public static void elementDiv(FMatrix4 fMatrix4, FMatrix4 fMatrix42) {
        fMatrix4.f2423a1 /= fMatrix42.f2423a1;
        fMatrix4.f2424a2 /= fMatrix42.f2424a2;
        fMatrix4.f2425a3 /= fMatrix42.f2425a3;
        fMatrix4.f2426a4 /= fMatrix42.f2426a4;
    }

    public static void elementDiv(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42, FMatrix4x4 fMatrix4x43) {
        fMatrix4x43.a11 = fMatrix4x4.a11 / fMatrix4x42.a11;
        fMatrix4x43.a12 = fMatrix4x4.a12 / fMatrix4x42.a12;
        fMatrix4x43.a13 = fMatrix4x4.a13 / fMatrix4x42.a13;
        fMatrix4x43.a14 = fMatrix4x4.a14 / fMatrix4x42.a14;
        fMatrix4x43.a21 = fMatrix4x4.a21 / fMatrix4x42.a21;
        fMatrix4x43.a22 = fMatrix4x4.a22 / fMatrix4x42.a22;
        fMatrix4x43.a23 = fMatrix4x4.a23 / fMatrix4x42.a23;
        fMatrix4x43.a24 = fMatrix4x4.a24 / fMatrix4x42.a24;
        fMatrix4x43.a31 = fMatrix4x4.a31 / fMatrix4x42.a31;
        fMatrix4x43.a32 = fMatrix4x4.a32 / fMatrix4x42.a32;
        fMatrix4x43.a33 = fMatrix4x4.a33 / fMatrix4x42.a33;
        fMatrix4x43.a34 = fMatrix4x4.a34 / fMatrix4x42.a34;
        fMatrix4x43.a41 = fMatrix4x4.a41 / fMatrix4x42.a41;
        fMatrix4x43.a42 = fMatrix4x4.a42 / fMatrix4x42.a42;
        fMatrix4x43.a43 = fMatrix4x4.a43 / fMatrix4x42.a43;
        fMatrix4x43.a44 = fMatrix4x4.a44 / fMatrix4x42.a44;
    }

    public static void elementDiv(FMatrix4 fMatrix4, FMatrix4 fMatrix42, FMatrix4 fMatrix43) {
        fMatrix43.f2423a1 = fMatrix4.f2423a1 / fMatrix42.f2423a1;
        fMatrix43.f2424a2 = fMatrix4.f2424a2 / fMatrix42.f2424a2;
        fMatrix43.f2425a3 = fMatrix4.f2425a3 / fMatrix42.f2425a3;
        fMatrix43.f2426a4 = fMatrix4.f2426a4 / fMatrix42.f2426a4;
    }

    public static void scale(float f, FMatrix4x4 fMatrix4x4) {
        fMatrix4x4.a11 *= f;
        fMatrix4x4.a12 *= f;
        fMatrix4x4.a13 *= f;
        fMatrix4x4.a14 *= f;
        fMatrix4x4.a21 *= f;
        fMatrix4x4.a22 *= f;
        fMatrix4x4.a23 *= f;
        fMatrix4x4.a24 *= f;
        fMatrix4x4.a31 *= f;
        fMatrix4x4.a32 *= f;
        fMatrix4x4.a33 *= f;
        fMatrix4x4.a34 *= f;
        fMatrix4x4.a41 *= f;
        fMatrix4x4.a42 *= f;
        fMatrix4x4.a43 *= f;
        fMatrix4x4.a44 *= f;
    }

    public static void scale(float f, FMatrix4 fMatrix4) {
        fMatrix4.f2423a1 *= f;
        fMatrix4.f2424a2 *= f;
        fMatrix4.f2425a3 *= f;
        fMatrix4.f2426a4 *= f;
    }

    public static void scale(float f, FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42) {
        fMatrix4x42.a11 = fMatrix4x4.a11 * f;
        fMatrix4x42.a12 = fMatrix4x4.a12 * f;
        fMatrix4x42.a13 = fMatrix4x4.a13 * f;
        fMatrix4x42.a14 = fMatrix4x4.a14 * f;
        fMatrix4x42.a21 = fMatrix4x4.a21 * f;
        fMatrix4x42.a22 = fMatrix4x4.a22 * f;
        fMatrix4x42.a23 = fMatrix4x4.a23 * f;
        fMatrix4x42.a24 = fMatrix4x4.a24 * f;
        fMatrix4x42.a31 = fMatrix4x4.a31 * f;
        fMatrix4x42.a32 = fMatrix4x4.a32 * f;
        fMatrix4x42.a33 = fMatrix4x4.a33 * f;
        fMatrix4x42.a34 = fMatrix4x4.a34 * f;
        fMatrix4x42.a41 = fMatrix4x4.a41 * f;
        fMatrix4x42.a42 = fMatrix4x4.a42 * f;
        fMatrix4x42.a43 = fMatrix4x4.a43 * f;
        fMatrix4x42.a44 = fMatrix4x4.a44 * f;
    }

    public static void scale(float f, FMatrix4 fMatrix4, FMatrix4 fMatrix42) {
        fMatrix42.f2423a1 = fMatrix4.f2423a1 * f;
        fMatrix42.f2424a2 = fMatrix4.f2424a2 * f;
        fMatrix42.f2425a3 = fMatrix4.f2425a3 * f;
        fMatrix42.f2426a4 = fMatrix4.f2426a4 * f;
    }

    public static void divide(FMatrix4x4 fMatrix4x4, float f) {
        fMatrix4x4.a11 /= f;
        fMatrix4x4.a12 /= f;
        fMatrix4x4.a13 /= f;
        fMatrix4x4.a14 /= f;
        fMatrix4x4.a21 /= f;
        fMatrix4x4.a22 /= f;
        fMatrix4x4.a23 /= f;
        fMatrix4x4.a24 /= f;
        fMatrix4x4.a31 /= f;
        fMatrix4x4.a32 /= f;
        fMatrix4x4.a33 /= f;
        fMatrix4x4.a34 /= f;
        fMatrix4x4.a41 /= f;
        fMatrix4x4.a42 /= f;
        fMatrix4x4.a43 /= f;
        fMatrix4x4.a44 /= f;
    }

    public static void divide(FMatrix4 fMatrix4, float f) {
        fMatrix4.f2423a1 /= f;
        fMatrix4.f2424a2 /= f;
        fMatrix4.f2425a3 /= f;
        fMatrix4.f2426a4 /= f;
    }

    public static void divide(FMatrix4x4 fMatrix4x4, float f, FMatrix4x4 fMatrix4x42) {
        fMatrix4x42.a11 = fMatrix4x4.a11 / f;
        fMatrix4x42.a12 = fMatrix4x4.a12 / f;
        fMatrix4x42.a13 = fMatrix4x4.a13 / f;
        fMatrix4x42.a14 = fMatrix4x4.a14 / f;
        fMatrix4x42.a21 = fMatrix4x4.a21 / f;
        fMatrix4x42.a22 = fMatrix4x4.a22 / f;
        fMatrix4x42.a23 = fMatrix4x4.a23 / f;
        fMatrix4x42.a24 = fMatrix4x4.a24 / f;
        fMatrix4x42.a31 = fMatrix4x4.a31 / f;
        fMatrix4x42.a32 = fMatrix4x4.a32 / f;
        fMatrix4x42.a33 = fMatrix4x4.a33 / f;
        fMatrix4x42.a34 = fMatrix4x4.a34 / f;
        fMatrix4x42.a41 = fMatrix4x4.a41 / f;
        fMatrix4x42.a42 = fMatrix4x4.a42 / f;
        fMatrix4x42.a43 = fMatrix4x4.a43 / f;
        fMatrix4x42.a44 = fMatrix4x4.a44 / f;
    }

    public static void divide(FMatrix4 fMatrix4, float f, FMatrix4 fMatrix42) {
        fMatrix42.f2423a1 = fMatrix4.f2423a1 / f;
        fMatrix42.f2424a2 = fMatrix4.f2424a2 / f;
        fMatrix42.f2425a3 = fMatrix4.f2425a3 / f;
        fMatrix42.f2426a4 = fMatrix4.f2426a4 / f;
    }

    public static void changeSign(FMatrix4x4 fMatrix4x4) {
        fMatrix4x4.a11 = -fMatrix4x4.a11;
        fMatrix4x4.a12 = -fMatrix4x4.a12;
        fMatrix4x4.a13 = -fMatrix4x4.a13;
        fMatrix4x4.a14 = -fMatrix4x4.a14;
        fMatrix4x4.a21 = -fMatrix4x4.a21;
        fMatrix4x4.a22 = -fMatrix4x4.a22;
        fMatrix4x4.a23 = -fMatrix4x4.a23;
        fMatrix4x4.a24 = -fMatrix4x4.a24;
        fMatrix4x4.a31 = -fMatrix4x4.a31;
        fMatrix4x4.a32 = -fMatrix4x4.a32;
        fMatrix4x4.a33 = -fMatrix4x4.a33;
        fMatrix4x4.a34 = -fMatrix4x4.a34;
        fMatrix4x4.a41 = -fMatrix4x4.a41;
        fMatrix4x4.a42 = -fMatrix4x4.a42;
        fMatrix4x4.a43 = -fMatrix4x4.a43;
        fMatrix4x4.a44 = -fMatrix4x4.a44;
    }

    public static void changeSign(FMatrix4 fMatrix4) {
        fMatrix4.f2423a1 = -fMatrix4.f2423a1;
        fMatrix4.f2424a2 = -fMatrix4.f2424a2;
        fMatrix4.f2425a3 = -fMatrix4.f2425a3;
        fMatrix4.f2426a4 = -fMatrix4.f2426a4;
    }

    public static void fill(FMatrix4x4 fMatrix4x4, float f) {
        fMatrix4x4.a11 = f;
        fMatrix4x4.a12 = f;
        fMatrix4x4.a13 = f;
        fMatrix4x4.a14 = f;
        fMatrix4x4.a21 = f;
        fMatrix4x4.a22 = f;
        fMatrix4x4.a23 = f;
        fMatrix4x4.a24 = f;
        fMatrix4x4.a31 = f;
        fMatrix4x4.a32 = f;
        fMatrix4x4.a33 = f;
        fMatrix4x4.a34 = f;
        fMatrix4x4.a41 = f;
        fMatrix4x4.a42 = f;
        fMatrix4x4.a43 = f;
        fMatrix4x4.a44 = f;
    }

    public static void fill(FMatrix4 fMatrix4, float f) {
        fMatrix4.f2423a1 = f;
        fMatrix4.f2424a2 = f;
        fMatrix4.f2425a3 = f;
        fMatrix4.f2426a4 = f;
    }

    public static FMatrix4 extractRow(FMatrix4x4 fMatrix4x4, int i, FMatrix4 fMatrix4) {
        if (fMatrix4 == null) {
            fMatrix4 = new FMatrix4();
        }
        if (i == 0) {
            fMatrix4.f2423a1 = fMatrix4x4.a11;
            fMatrix4.f2424a2 = fMatrix4x4.a12;
            fMatrix4.f2425a3 = fMatrix4x4.a13;
            fMatrix4.f2426a4 = fMatrix4x4.a14;
            return fMatrix4;
        }
        if (i == 1) {
            fMatrix4.f2423a1 = fMatrix4x4.a21;
            fMatrix4.f2424a2 = fMatrix4x4.a22;
            fMatrix4.f2425a3 = fMatrix4x4.a23;
            fMatrix4.f2426a4 = fMatrix4x4.a24;
            return fMatrix4;
        }
        if (i == 2) {
            fMatrix4.f2423a1 = fMatrix4x4.a31;
            fMatrix4.f2424a2 = fMatrix4x4.a32;
            fMatrix4.f2425a3 = fMatrix4x4.a33;
            fMatrix4.f2426a4 = fMatrix4x4.a34;
            return fMatrix4;
        }
        if (i == 3) {
            fMatrix4.f2423a1 = fMatrix4x4.a41;
            fMatrix4.f2424a2 = fMatrix4x4.a42;
            fMatrix4.f2425a3 = fMatrix4x4.a43;
            fMatrix4.f2426a4 = fMatrix4x4.a44;
            return fMatrix4;
        }
        throw new IllegalArgumentException("Out of bounds row.  row = " + i);
    }

    public static FMatrix4 extractColumn(FMatrix4x4 fMatrix4x4, int i, FMatrix4 fMatrix4) {
        if (fMatrix4 == null) {
            fMatrix4 = new FMatrix4();
        }
        if (i == 0) {
            fMatrix4.f2423a1 = fMatrix4x4.a11;
            fMatrix4.f2424a2 = fMatrix4x4.a21;
            fMatrix4.f2425a3 = fMatrix4x4.a31;
            fMatrix4.f2426a4 = fMatrix4x4.a41;
            return fMatrix4;
        }
        if (i == 1) {
            fMatrix4.f2423a1 = fMatrix4x4.a12;
            fMatrix4.f2424a2 = fMatrix4x4.a22;
            fMatrix4.f2425a3 = fMatrix4x4.a32;
            fMatrix4.f2426a4 = fMatrix4x4.a42;
            return fMatrix4;
        }
        if (i == 2) {
            fMatrix4.f2423a1 = fMatrix4x4.a13;
            fMatrix4.f2424a2 = fMatrix4x4.a23;
            fMatrix4.f2425a3 = fMatrix4x4.a33;
            fMatrix4.f2426a4 = fMatrix4x4.a43;
            return fMatrix4;
        }
        if (i == 3) {
            fMatrix4.f2423a1 = fMatrix4x4.a14;
            fMatrix4.f2424a2 = fMatrix4x4.a24;
            fMatrix4.f2425a3 = fMatrix4x4.a34;
            fMatrix4.f2426a4 = fMatrix4x4.a44;
            return fMatrix4;
        }
        throw new IllegalArgumentException("Out of bounds column.  column = " + i);
    }
}
