package org.ejml.dense.fixed;

import org.ejml.data.FMatrix6;
import org.ejml.data.FMatrix6x6;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_FDF6 {
    public static void add(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62, FMatrix6x6 fMatrix6x63) {
        fMatrix6x63.a11 = fMatrix6x6.a11 + fMatrix6x62.a11;
        fMatrix6x63.a12 = fMatrix6x6.a12 + fMatrix6x62.a12;
        fMatrix6x63.a13 = fMatrix6x6.a13 + fMatrix6x62.a13;
        fMatrix6x63.a14 = fMatrix6x6.a14 + fMatrix6x62.a14;
        fMatrix6x63.a15 = fMatrix6x6.a15 + fMatrix6x62.a15;
        fMatrix6x63.a16 = fMatrix6x6.a16 + fMatrix6x62.a16;
        fMatrix6x63.a21 = fMatrix6x6.a21 + fMatrix6x62.a21;
        fMatrix6x63.a22 = fMatrix6x6.a22 + fMatrix6x62.a22;
        fMatrix6x63.a23 = fMatrix6x6.a23 + fMatrix6x62.a23;
        fMatrix6x63.a24 = fMatrix6x6.a24 + fMatrix6x62.a24;
        fMatrix6x63.a25 = fMatrix6x6.a25 + fMatrix6x62.a25;
        fMatrix6x63.a26 = fMatrix6x6.a26 + fMatrix6x62.a26;
        fMatrix6x63.a31 = fMatrix6x6.a31 + fMatrix6x62.a31;
        fMatrix6x63.a32 = fMatrix6x6.a32 + fMatrix6x62.a32;
        fMatrix6x63.a33 = fMatrix6x6.a33 + fMatrix6x62.a33;
        fMatrix6x63.a34 = fMatrix6x6.a34 + fMatrix6x62.a34;
        fMatrix6x63.a35 = fMatrix6x6.a35 + fMatrix6x62.a35;
        fMatrix6x63.a36 = fMatrix6x6.a36 + fMatrix6x62.a36;
        fMatrix6x63.a41 = fMatrix6x6.a41 + fMatrix6x62.a41;
        fMatrix6x63.a42 = fMatrix6x6.a42 + fMatrix6x62.a42;
        fMatrix6x63.a43 = fMatrix6x6.a43 + fMatrix6x62.a43;
        fMatrix6x63.a44 = fMatrix6x6.a44 + fMatrix6x62.a44;
        fMatrix6x63.a45 = fMatrix6x6.a45 + fMatrix6x62.a45;
        fMatrix6x63.a46 = fMatrix6x6.a46 + fMatrix6x62.a46;
        fMatrix6x63.a51 = fMatrix6x6.a51 + fMatrix6x62.a51;
        fMatrix6x63.a52 = fMatrix6x6.a52 + fMatrix6x62.a52;
        fMatrix6x63.a53 = fMatrix6x6.a53 + fMatrix6x62.a53;
        fMatrix6x63.a54 = fMatrix6x6.a54 + fMatrix6x62.a54;
        fMatrix6x63.a55 = fMatrix6x6.a55 + fMatrix6x62.a55;
        fMatrix6x63.a56 = fMatrix6x6.a56 + fMatrix6x62.a56;
        fMatrix6x63.a61 = fMatrix6x6.a61 + fMatrix6x62.a61;
        fMatrix6x63.a62 = fMatrix6x6.a62 + fMatrix6x62.a62;
        fMatrix6x63.a63 = fMatrix6x6.a63 + fMatrix6x62.a63;
        fMatrix6x63.a64 = fMatrix6x6.a64 + fMatrix6x62.a64;
        fMatrix6x63.a65 = fMatrix6x6.a65 + fMatrix6x62.a65;
        fMatrix6x63.a66 = fMatrix6x6.a66 + fMatrix6x62.a66;
    }

    public static void add(FMatrix6 fMatrix6, FMatrix6 fMatrix62, FMatrix6 fMatrix63) {
        fMatrix63.f2432a1 = fMatrix6.f2432a1 + fMatrix62.f2432a1;
        fMatrix63.f2433a2 = fMatrix6.f2433a2 + fMatrix62.f2433a2;
        fMatrix63.f2434a3 = fMatrix6.f2434a3 + fMatrix62.f2434a3;
        fMatrix63.f2435a4 = fMatrix6.f2435a4 + fMatrix62.f2435a4;
        fMatrix63.f2436a5 = fMatrix6.f2436a5 + fMatrix62.f2436a5;
        fMatrix63.f2437a6 = fMatrix6.f2437a6 + fMatrix62.f2437a6;
    }

    public static void addEquals(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62) {
        fMatrix6x6.a11 += fMatrix6x62.a11;
        fMatrix6x6.a12 += fMatrix6x62.a12;
        fMatrix6x6.a13 += fMatrix6x62.a13;
        fMatrix6x6.a14 += fMatrix6x62.a14;
        fMatrix6x6.a15 += fMatrix6x62.a15;
        fMatrix6x6.a16 += fMatrix6x62.a16;
        fMatrix6x6.a21 += fMatrix6x62.a21;
        fMatrix6x6.a22 += fMatrix6x62.a22;
        fMatrix6x6.a23 += fMatrix6x62.a23;
        fMatrix6x6.a24 += fMatrix6x62.a24;
        fMatrix6x6.a25 += fMatrix6x62.a25;
        fMatrix6x6.a26 += fMatrix6x62.a26;
        fMatrix6x6.a31 += fMatrix6x62.a31;
        fMatrix6x6.a32 += fMatrix6x62.a32;
        fMatrix6x6.a33 += fMatrix6x62.a33;
        fMatrix6x6.a34 += fMatrix6x62.a34;
        fMatrix6x6.a35 += fMatrix6x62.a35;
        fMatrix6x6.a36 += fMatrix6x62.a36;
        fMatrix6x6.a41 += fMatrix6x62.a41;
        fMatrix6x6.a42 += fMatrix6x62.a42;
        fMatrix6x6.a43 += fMatrix6x62.a43;
        fMatrix6x6.a44 += fMatrix6x62.a44;
        fMatrix6x6.a45 += fMatrix6x62.a45;
        fMatrix6x6.a46 += fMatrix6x62.a46;
        fMatrix6x6.a51 += fMatrix6x62.a51;
        fMatrix6x6.a52 += fMatrix6x62.a52;
        fMatrix6x6.a53 += fMatrix6x62.a53;
        fMatrix6x6.a54 += fMatrix6x62.a54;
        fMatrix6x6.a55 += fMatrix6x62.a55;
        fMatrix6x6.a56 += fMatrix6x62.a56;
        fMatrix6x6.a61 += fMatrix6x62.a61;
        fMatrix6x6.a62 += fMatrix6x62.a62;
        fMatrix6x6.a63 += fMatrix6x62.a63;
        fMatrix6x6.a64 += fMatrix6x62.a64;
        fMatrix6x6.a65 += fMatrix6x62.a65;
        fMatrix6x6.a66 += fMatrix6x62.a66;
    }

    public static void addEquals(FMatrix6 fMatrix6, FMatrix6 fMatrix62) {
        fMatrix6.f2432a1 += fMatrix62.f2432a1;
        fMatrix6.f2433a2 += fMatrix62.f2433a2;
        fMatrix6.f2434a3 += fMatrix62.f2434a3;
        fMatrix6.f2435a4 += fMatrix62.f2435a4;
        fMatrix6.f2436a5 += fMatrix62.f2436a5;
        fMatrix6.f2437a6 += fMatrix62.f2437a6;
    }

    public static void subtract(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62, FMatrix6x6 fMatrix6x63) {
        fMatrix6x63.a11 = fMatrix6x6.a11 - fMatrix6x62.a11;
        fMatrix6x63.a12 = fMatrix6x6.a12 - fMatrix6x62.a12;
        fMatrix6x63.a13 = fMatrix6x6.a13 - fMatrix6x62.a13;
        fMatrix6x63.a14 = fMatrix6x6.a14 - fMatrix6x62.a14;
        fMatrix6x63.a15 = fMatrix6x6.a15 - fMatrix6x62.a15;
        fMatrix6x63.a16 = fMatrix6x6.a16 - fMatrix6x62.a16;
        fMatrix6x63.a21 = fMatrix6x6.a21 - fMatrix6x62.a21;
        fMatrix6x63.a22 = fMatrix6x6.a22 - fMatrix6x62.a22;
        fMatrix6x63.a23 = fMatrix6x6.a23 - fMatrix6x62.a23;
        fMatrix6x63.a24 = fMatrix6x6.a24 - fMatrix6x62.a24;
        fMatrix6x63.a25 = fMatrix6x6.a25 - fMatrix6x62.a25;
        fMatrix6x63.a26 = fMatrix6x6.a26 - fMatrix6x62.a26;
        fMatrix6x63.a31 = fMatrix6x6.a31 - fMatrix6x62.a31;
        fMatrix6x63.a32 = fMatrix6x6.a32 - fMatrix6x62.a32;
        fMatrix6x63.a33 = fMatrix6x6.a33 - fMatrix6x62.a33;
        fMatrix6x63.a34 = fMatrix6x6.a34 - fMatrix6x62.a34;
        fMatrix6x63.a35 = fMatrix6x6.a35 - fMatrix6x62.a35;
        fMatrix6x63.a36 = fMatrix6x6.a36 - fMatrix6x62.a36;
        fMatrix6x63.a41 = fMatrix6x6.a41 - fMatrix6x62.a41;
        fMatrix6x63.a42 = fMatrix6x6.a42 - fMatrix6x62.a42;
        fMatrix6x63.a43 = fMatrix6x6.a43 - fMatrix6x62.a43;
        fMatrix6x63.a44 = fMatrix6x6.a44 - fMatrix6x62.a44;
        fMatrix6x63.a45 = fMatrix6x6.a45 - fMatrix6x62.a45;
        fMatrix6x63.a46 = fMatrix6x6.a46 - fMatrix6x62.a46;
        fMatrix6x63.a51 = fMatrix6x6.a51 - fMatrix6x62.a51;
        fMatrix6x63.a52 = fMatrix6x6.a52 - fMatrix6x62.a52;
        fMatrix6x63.a53 = fMatrix6x6.a53 - fMatrix6x62.a53;
        fMatrix6x63.a54 = fMatrix6x6.a54 - fMatrix6x62.a54;
        fMatrix6x63.a55 = fMatrix6x6.a55 - fMatrix6x62.a55;
        fMatrix6x63.a56 = fMatrix6x6.a56 - fMatrix6x62.a56;
        fMatrix6x63.a61 = fMatrix6x6.a61 - fMatrix6x62.a61;
        fMatrix6x63.a62 = fMatrix6x6.a62 - fMatrix6x62.a62;
        fMatrix6x63.a63 = fMatrix6x6.a63 - fMatrix6x62.a63;
        fMatrix6x63.a64 = fMatrix6x6.a64 - fMatrix6x62.a64;
        fMatrix6x63.a65 = fMatrix6x6.a65 - fMatrix6x62.a65;
        fMatrix6x63.a66 = fMatrix6x6.a66 - fMatrix6x62.a66;
    }

    public static void subtract(FMatrix6 fMatrix6, FMatrix6 fMatrix62, FMatrix6 fMatrix63) {
        fMatrix63.f2432a1 = fMatrix6.f2432a1 - fMatrix62.f2432a1;
        fMatrix63.f2433a2 = fMatrix6.f2433a2 - fMatrix62.f2433a2;
        fMatrix63.f2434a3 = fMatrix6.f2434a3 - fMatrix62.f2434a3;
        fMatrix63.f2435a4 = fMatrix6.f2435a4 - fMatrix62.f2435a4;
        fMatrix63.f2436a5 = fMatrix6.f2436a5 - fMatrix62.f2436a5;
        fMatrix63.f2437a6 = fMatrix6.f2437a6 - fMatrix62.f2437a6;
    }

    public static void subtractEquals(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62) {
        fMatrix6x6.a11 -= fMatrix6x62.a11;
        fMatrix6x6.a12 -= fMatrix6x62.a12;
        fMatrix6x6.a13 -= fMatrix6x62.a13;
        fMatrix6x6.a14 -= fMatrix6x62.a14;
        fMatrix6x6.a15 -= fMatrix6x62.a15;
        fMatrix6x6.a16 -= fMatrix6x62.a16;
        fMatrix6x6.a21 -= fMatrix6x62.a21;
        fMatrix6x6.a22 -= fMatrix6x62.a22;
        fMatrix6x6.a23 -= fMatrix6x62.a23;
        fMatrix6x6.a24 -= fMatrix6x62.a24;
        fMatrix6x6.a25 -= fMatrix6x62.a25;
        fMatrix6x6.a26 -= fMatrix6x62.a26;
        fMatrix6x6.a31 -= fMatrix6x62.a31;
        fMatrix6x6.a32 -= fMatrix6x62.a32;
        fMatrix6x6.a33 -= fMatrix6x62.a33;
        fMatrix6x6.a34 -= fMatrix6x62.a34;
        fMatrix6x6.a35 -= fMatrix6x62.a35;
        fMatrix6x6.a36 -= fMatrix6x62.a36;
        fMatrix6x6.a41 -= fMatrix6x62.a41;
        fMatrix6x6.a42 -= fMatrix6x62.a42;
        fMatrix6x6.a43 -= fMatrix6x62.a43;
        fMatrix6x6.a44 -= fMatrix6x62.a44;
        fMatrix6x6.a45 -= fMatrix6x62.a45;
        fMatrix6x6.a46 -= fMatrix6x62.a46;
        fMatrix6x6.a51 -= fMatrix6x62.a51;
        fMatrix6x6.a52 -= fMatrix6x62.a52;
        fMatrix6x6.a53 -= fMatrix6x62.a53;
        fMatrix6x6.a54 -= fMatrix6x62.a54;
        fMatrix6x6.a55 -= fMatrix6x62.a55;
        fMatrix6x6.a56 -= fMatrix6x62.a56;
        fMatrix6x6.a61 -= fMatrix6x62.a61;
        fMatrix6x6.a62 -= fMatrix6x62.a62;
        fMatrix6x6.a63 -= fMatrix6x62.a63;
        fMatrix6x6.a64 -= fMatrix6x62.a64;
        fMatrix6x6.a65 -= fMatrix6x62.a65;
        fMatrix6x6.a66 -= fMatrix6x62.a66;
    }

    public static void subtractEquals(FMatrix6 fMatrix6, FMatrix6 fMatrix62) {
        fMatrix6.f2432a1 -= fMatrix62.f2432a1;
        fMatrix6.f2433a2 -= fMatrix62.f2433a2;
        fMatrix6.f2434a3 -= fMatrix62.f2434a3;
        fMatrix6.f2435a4 -= fMatrix62.f2435a4;
        fMatrix6.f2436a5 -= fMatrix62.f2436a5;
        fMatrix6.f2437a6 -= fMatrix62.f2437a6;
    }

    public static void transpose(FMatrix6x6 fMatrix6x6) {
        float f = fMatrix6x6.a12;
        fMatrix6x6.a12 = fMatrix6x6.a21;
        fMatrix6x6.a21 = f;
        float f2 = fMatrix6x6.a13;
        fMatrix6x6.a13 = fMatrix6x6.a31;
        fMatrix6x6.a31 = f2;
        float f3 = fMatrix6x6.a14;
        fMatrix6x6.a14 = fMatrix6x6.a41;
        fMatrix6x6.a41 = f3;
        float f4 = fMatrix6x6.a15;
        fMatrix6x6.a15 = fMatrix6x6.a51;
        fMatrix6x6.a51 = f4;
        float f5 = fMatrix6x6.a16;
        fMatrix6x6.a16 = fMatrix6x6.a61;
        fMatrix6x6.a61 = f5;
        float f6 = fMatrix6x6.a23;
        fMatrix6x6.a23 = fMatrix6x6.a32;
        fMatrix6x6.a32 = f6;
        float f7 = fMatrix6x6.a24;
        fMatrix6x6.a24 = fMatrix6x6.a42;
        fMatrix6x6.a42 = f7;
        float f8 = fMatrix6x6.a25;
        fMatrix6x6.a25 = fMatrix6x6.a52;
        fMatrix6x6.a52 = f8;
        float f9 = fMatrix6x6.a26;
        fMatrix6x6.a26 = fMatrix6x6.a62;
        fMatrix6x6.a62 = f9;
        float f10 = fMatrix6x6.a34;
        fMatrix6x6.a34 = fMatrix6x6.a43;
        fMatrix6x6.a43 = f10;
        float f11 = fMatrix6x6.a35;
        fMatrix6x6.a35 = fMatrix6x6.a53;
        fMatrix6x6.a53 = f11;
        float f12 = fMatrix6x6.a36;
        fMatrix6x6.a36 = fMatrix6x6.a63;
        fMatrix6x6.a63 = f12;
        float f13 = fMatrix6x6.a45;
        fMatrix6x6.a45 = fMatrix6x6.a54;
        fMatrix6x6.a54 = f13;
        float f14 = fMatrix6x6.a46;
        fMatrix6x6.a46 = fMatrix6x6.a64;
        fMatrix6x6.a64 = f14;
        float f15 = fMatrix6x6.a56;
        fMatrix6x6.a56 = fMatrix6x6.a65;
        fMatrix6x6.a65 = f15;
    }

    public static FMatrix6x6 transpose(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62) {
        if (fMatrix6x6 == null) {
            fMatrix6x6 = new FMatrix6x6();
        }
        fMatrix6x62.a11 = fMatrix6x6.a11;
        fMatrix6x62.a12 = fMatrix6x6.a21;
        fMatrix6x62.a13 = fMatrix6x6.a31;
        fMatrix6x62.a14 = fMatrix6x6.a41;
        fMatrix6x62.a15 = fMatrix6x6.a51;
        fMatrix6x62.a16 = fMatrix6x6.a61;
        fMatrix6x62.a21 = fMatrix6x6.a12;
        fMatrix6x62.a22 = fMatrix6x6.a22;
        fMatrix6x62.a23 = fMatrix6x6.a32;
        fMatrix6x62.a24 = fMatrix6x6.a42;
        fMatrix6x62.a25 = fMatrix6x6.a52;
        fMatrix6x62.a26 = fMatrix6x6.a62;
        fMatrix6x62.a31 = fMatrix6x6.a13;
        fMatrix6x62.a32 = fMatrix6x6.a23;
        fMatrix6x62.a33 = fMatrix6x6.a33;
        fMatrix6x62.a34 = fMatrix6x6.a43;
        fMatrix6x62.a35 = fMatrix6x6.a53;
        fMatrix6x62.a36 = fMatrix6x6.a63;
        fMatrix6x62.a41 = fMatrix6x6.a14;
        fMatrix6x62.a42 = fMatrix6x6.a24;
        fMatrix6x62.a43 = fMatrix6x6.a34;
        fMatrix6x62.a44 = fMatrix6x6.a44;
        fMatrix6x62.a45 = fMatrix6x6.a54;
        fMatrix6x62.a46 = fMatrix6x6.a64;
        fMatrix6x62.a51 = fMatrix6x6.a15;
        fMatrix6x62.a52 = fMatrix6x6.a25;
        fMatrix6x62.a53 = fMatrix6x6.a35;
        fMatrix6x62.a54 = fMatrix6x6.a45;
        fMatrix6x62.a55 = fMatrix6x6.a55;
        fMatrix6x62.a56 = fMatrix6x6.a65;
        fMatrix6x62.a61 = fMatrix6x6.a16;
        fMatrix6x62.a62 = fMatrix6x6.a26;
        fMatrix6x62.a63 = fMatrix6x6.a36;
        fMatrix6x62.a64 = fMatrix6x6.a46;
        fMatrix6x62.a65 = fMatrix6x6.a56;
        fMatrix6x62.a66 = fMatrix6x6.a66;
        return fMatrix6x62;
    }

    public static void mult(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62, FMatrix6x6 fMatrix6x63) {
        fMatrix6x63.a11 = (fMatrix6x6.a11 * fMatrix6x62.a11) + (fMatrix6x6.a12 * fMatrix6x62.a21) + (fMatrix6x6.a13 * fMatrix6x62.a31) + (fMatrix6x6.a14 * fMatrix6x62.a41) + (fMatrix6x6.a15 * fMatrix6x62.a51) + (fMatrix6x6.a16 * fMatrix6x62.a61);
        fMatrix6x63.a12 = (fMatrix6x6.a11 * fMatrix6x62.a12) + (fMatrix6x6.a12 * fMatrix6x62.a22) + (fMatrix6x6.a13 * fMatrix6x62.a32) + (fMatrix6x6.a14 * fMatrix6x62.a42) + (fMatrix6x6.a15 * fMatrix6x62.a52) + (fMatrix6x6.a16 * fMatrix6x62.a62);
        fMatrix6x63.a13 = (fMatrix6x6.a11 * fMatrix6x62.a13) + (fMatrix6x6.a12 * fMatrix6x62.a23) + (fMatrix6x6.a13 * fMatrix6x62.a33) + (fMatrix6x6.a14 * fMatrix6x62.a43) + (fMatrix6x6.a15 * fMatrix6x62.a53) + (fMatrix6x6.a16 * fMatrix6x62.a63);
        fMatrix6x63.a14 = (fMatrix6x6.a11 * fMatrix6x62.a14) + (fMatrix6x6.a12 * fMatrix6x62.a24) + (fMatrix6x6.a13 * fMatrix6x62.a34) + (fMatrix6x6.a14 * fMatrix6x62.a44) + (fMatrix6x6.a15 * fMatrix6x62.a54) + (fMatrix6x6.a16 * fMatrix6x62.a64);
        fMatrix6x63.a15 = (fMatrix6x6.a11 * fMatrix6x62.a15) + (fMatrix6x6.a12 * fMatrix6x62.a25) + (fMatrix6x6.a13 * fMatrix6x62.a35) + (fMatrix6x6.a14 * fMatrix6x62.a45) + (fMatrix6x6.a15 * fMatrix6x62.a55) + (fMatrix6x6.a16 * fMatrix6x62.a65);
        fMatrix6x63.a16 = (fMatrix6x6.a11 * fMatrix6x62.a16) + (fMatrix6x6.a12 * fMatrix6x62.a26) + (fMatrix6x6.a13 * fMatrix6x62.a36) + (fMatrix6x6.a14 * fMatrix6x62.a46) + (fMatrix6x6.a15 * fMatrix6x62.a56) + (fMatrix6x6.a16 * fMatrix6x62.a66);
        fMatrix6x63.a21 = (fMatrix6x6.a21 * fMatrix6x62.a11) + (fMatrix6x6.a22 * fMatrix6x62.a21) + (fMatrix6x6.a23 * fMatrix6x62.a31) + (fMatrix6x6.a24 * fMatrix6x62.a41) + (fMatrix6x6.a25 * fMatrix6x62.a51) + (fMatrix6x6.a26 * fMatrix6x62.a61);
        fMatrix6x63.a22 = (fMatrix6x6.a21 * fMatrix6x62.a12) + (fMatrix6x6.a22 * fMatrix6x62.a22) + (fMatrix6x6.a23 * fMatrix6x62.a32) + (fMatrix6x6.a24 * fMatrix6x62.a42) + (fMatrix6x6.a25 * fMatrix6x62.a52) + (fMatrix6x6.a26 * fMatrix6x62.a62);
        fMatrix6x63.a23 = (fMatrix6x6.a21 * fMatrix6x62.a13) + (fMatrix6x6.a22 * fMatrix6x62.a23) + (fMatrix6x6.a23 * fMatrix6x62.a33) + (fMatrix6x6.a24 * fMatrix6x62.a43) + (fMatrix6x6.a25 * fMatrix6x62.a53) + (fMatrix6x6.a26 * fMatrix6x62.a63);
        fMatrix6x63.a24 = (fMatrix6x6.a21 * fMatrix6x62.a14) + (fMatrix6x6.a22 * fMatrix6x62.a24) + (fMatrix6x6.a23 * fMatrix6x62.a34) + (fMatrix6x6.a24 * fMatrix6x62.a44) + (fMatrix6x6.a25 * fMatrix6x62.a54) + (fMatrix6x6.a26 * fMatrix6x62.a64);
        fMatrix6x63.a25 = (fMatrix6x6.a21 * fMatrix6x62.a15) + (fMatrix6x6.a22 * fMatrix6x62.a25) + (fMatrix6x6.a23 * fMatrix6x62.a35) + (fMatrix6x6.a24 * fMatrix6x62.a45) + (fMatrix6x6.a25 * fMatrix6x62.a55) + (fMatrix6x6.a26 * fMatrix6x62.a65);
        fMatrix6x63.a26 = (fMatrix6x6.a21 * fMatrix6x62.a16) + (fMatrix6x6.a22 * fMatrix6x62.a26) + (fMatrix6x6.a23 * fMatrix6x62.a36) + (fMatrix6x6.a24 * fMatrix6x62.a46) + (fMatrix6x6.a25 * fMatrix6x62.a56) + (fMatrix6x6.a26 * fMatrix6x62.a66);
        fMatrix6x63.a31 = (fMatrix6x6.a31 * fMatrix6x62.a11) + (fMatrix6x6.a32 * fMatrix6x62.a21) + (fMatrix6x6.a33 * fMatrix6x62.a31) + (fMatrix6x6.a34 * fMatrix6x62.a41) + (fMatrix6x6.a35 * fMatrix6x62.a51) + (fMatrix6x6.a36 * fMatrix6x62.a61);
        fMatrix6x63.a32 = (fMatrix6x6.a31 * fMatrix6x62.a12) + (fMatrix6x6.a32 * fMatrix6x62.a22) + (fMatrix6x6.a33 * fMatrix6x62.a32) + (fMatrix6x6.a34 * fMatrix6x62.a42) + (fMatrix6x6.a35 * fMatrix6x62.a52) + (fMatrix6x6.a36 * fMatrix6x62.a62);
        fMatrix6x63.a33 = (fMatrix6x6.a31 * fMatrix6x62.a13) + (fMatrix6x6.a32 * fMatrix6x62.a23) + (fMatrix6x6.a33 * fMatrix6x62.a33) + (fMatrix6x6.a34 * fMatrix6x62.a43) + (fMatrix6x6.a35 * fMatrix6x62.a53) + (fMatrix6x6.a36 * fMatrix6x62.a63);
        fMatrix6x63.a34 = (fMatrix6x6.a31 * fMatrix6x62.a14) + (fMatrix6x6.a32 * fMatrix6x62.a24) + (fMatrix6x6.a33 * fMatrix6x62.a34) + (fMatrix6x6.a34 * fMatrix6x62.a44) + (fMatrix6x6.a35 * fMatrix6x62.a54) + (fMatrix6x6.a36 * fMatrix6x62.a64);
        fMatrix6x63.a35 = (fMatrix6x6.a31 * fMatrix6x62.a15) + (fMatrix6x6.a32 * fMatrix6x62.a25) + (fMatrix6x6.a33 * fMatrix6x62.a35) + (fMatrix6x6.a34 * fMatrix6x62.a45) + (fMatrix6x6.a35 * fMatrix6x62.a55) + (fMatrix6x6.a36 * fMatrix6x62.a65);
        fMatrix6x63.a36 = (fMatrix6x6.a31 * fMatrix6x62.a16) + (fMatrix6x6.a32 * fMatrix6x62.a26) + (fMatrix6x6.a33 * fMatrix6x62.a36) + (fMatrix6x6.a34 * fMatrix6x62.a46) + (fMatrix6x6.a35 * fMatrix6x62.a56) + (fMatrix6x6.a36 * fMatrix6x62.a66);
        fMatrix6x63.a41 = (fMatrix6x6.a41 * fMatrix6x62.a11) + (fMatrix6x6.a42 * fMatrix6x62.a21) + (fMatrix6x6.a43 * fMatrix6x62.a31) + (fMatrix6x6.a44 * fMatrix6x62.a41) + (fMatrix6x6.a45 * fMatrix6x62.a51) + (fMatrix6x6.a46 * fMatrix6x62.a61);
        fMatrix6x63.a42 = (fMatrix6x6.a41 * fMatrix6x62.a12) + (fMatrix6x6.a42 * fMatrix6x62.a22) + (fMatrix6x6.a43 * fMatrix6x62.a32) + (fMatrix6x6.a44 * fMatrix6x62.a42) + (fMatrix6x6.a45 * fMatrix6x62.a52) + (fMatrix6x6.a46 * fMatrix6x62.a62);
        fMatrix6x63.a43 = (fMatrix6x6.a41 * fMatrix6x62.a13) + (fMatrix6x6.a42 * fMatrix6x62.a23) + (fMatrix6x6.a43 * fMatrix6x62.a33) + (fMatrix6x6.a44 * fMatrix6x62.a43) + (fMatrix6x6.a45 * fMatrix6x62.a53) + (fMatrix6x6.a46 * fMatrix6x62.a63);
        fMatrix6x63.a44 = (fMatrix6x6.a41 * fMatrix6x62.a14) + (fMatrix6x6.a42 * fMatrix6x62.a24) + (fMatrix6x6.a43 * fMatrix6x62.a34) + (fMatrix6x6.a44 * fMatrix6x62.a44) + (fMatrix6x6.a45 * fMatrix6x62.a54) + (fMatrix6x6.a46 * fMatrix6x62.a64);
        fMatrix6x63.a45 = (fMatrix6x6.a41 * fMatrix6x62.a15) + (fMatrix6x6.a42 * fMatrix6x62.a25) + (fMatrix6x6.a43 * fMatrix6x62.a35) + (fMatrix6x6.a44 * fMatrix6x62.a45) + (fMatrix6x6.a45 * fMatrix6x62.a55) + (fMatrix6x6.a46 * fMatrix6x62.a65);
        fMatrix6x63.a46 = (fMatrix6x6.a41 * fMatrix6x62.a16) + (fMatrix6x6.a42 * fMatrix6x62.a26) + (fMatrix6x6.a43 * fMatrix6x62.a36) + (fMatrix6x6.a44 * fMatrix6x62.a46) + (fMatrix6x6.a45 * fMatrix6x62.a56) + (fMatrix6x6.a46 * fMatrix6x62.a66);
        fMatrix6x63.a51 = (fMatrix6x6.a51 * fMatrix6x62.a11) + (fMatrix6x6.a52 * fMatrix6x62.a21) + (fMatrix6x6.a53 * fMatrix6x62.a31) + (fMatrix6x6.a54 * fMatrix6x62.a41) + (fMatrix6x6.a55 * fMatrix6x62.a51) + (fMatrix6x6.a56 * fMatrix6x62.a61);
        fMatrix6x63.a52 = (fMatrix6x6.a51 * fMatrix6x62.a12) + (fMatrix6x6.a52 * fMatrix6x62.a22) + (fMatrix6x6.a53 * fMatrix6x62.a32) + (fMatrix6x6.a54 * fMatrix6x62.a42) + (fMatrix6x6.a55 * fMatrix6x62.a52) + (fMatrix6x6.a56 * fMatrix6x62.a62);
        fMatrix6x63.a53 = (fMatrix6x6.a51 * fMatrix6x62.a13) + (fMatrix6x6.a52 * fMatrix6x62.a23) + (fMatrix6x6.a53 * fMatrix6x62.a33) + (fMatrix6x6.a54 * fMatrix6x62.a43) + (fMatrix6x6.a55 * fMatrix6x62.a53) + (fMatrix6x6.a56 * fMatrix6x62.a63);
        fMatrix6x63.a54 = (fMatrix6x6.a51 * fMatrix6x62.a14) + (fMatrix6x6.a52 * fMatrix6x62.a24) + (fMatrix6x6.a53 * fMatrix6x62.a34) + (fMatrix6x6.a54 * fMatrix6x62.a44) + (fMatrix6x6.a55 * fMatrix6x62.a54) + (fMatrix6x6.a56 * fMatrix6x62.a64);
        fMatrix6x63.a55 = (fMatrix6x6.a51 * fMatrix6x62.a15) + (fMatrix6x6.a52 * fMatrix6x62.a25) + (fMatrix6x6.a53 * fMatrix6x62.a35) + (fMatrix6x6.a54 * fMatrix6x62.a45) + (fMatrix6x6.a55 * fMatrix6x62.a55) + (fMatrix6x6.a56 * fMatrix6x62.a65);
        fMatrix6x63.a56 = (fMatrix6x6.a51 * fMatrix6x62.a16) + (fMatrix6x6.a52 * fMatrix6x62.a26) + (fMatrix6x6.a53 * fMatrix6x62.a36) + (fMatrix6x6.a54 * fMatrix6x62.a46) + (fMatrix6x6.a55 * fMatrix6x62.a56) + (fMatrix6x6.a56 * fMatrix6x62.a66);
        fMatrix6x63.a61 = (fMatrix6x6.a61 * fMatrix6x62.a11) + (fMatrix6x6.a62 * fMatrix6x62.a21) + (fMatrix6x6.a63 * fMatrix6x62.a31) + (fMatrix6x6.a64 * fMatrix6x62.a41) + (fMatrix6x6.a65 * fMatrix6x62.a51) + (fMatrix6x6.a66 * fMatrix6x62.a61);
        fMatrix6x63.a62 = (fMatrix6x6.a61 * fMatrix6x62.a12) + (fMatrix6x6.a62 * fMatrix6x62.a22) + (fMatrix6x6.a63 * fMatrix6x62.a32) + (fMatrix6x6.a64 * fMatrix6x62.a42) + (fMatrix6x6.a65 * fMatrix6x62.a52) + (fMatrix6x6.a66 * fMatrix6x62.a62);
        fMatrix6x63.a63 = (fMatrix6x6.a61 * fMatrix6x62.a13) + (fMatrix6x6.a62 * fMatrix6x62.a23) + (fMatrix6x6.a63 * fMatrix6x62.a33) + (fMatrix6x6.a64 * fMatrix6x62.a43) + (fMatrix6x6.a65 * fMatrix6x62.a53) + (fMatrix6x6.a66 * fMatrix6x62.a63);
        fMatrix6x63.a64 = (fMatrix6x6.a61 * fMatrix6x62.a14) + (fMatrix6x6.a62 * fMatrix6x62.a24) + (fMatrix6x6.a63 * fMatrix6x62.a34) + (fMatrix6x6.a64 * fMatrix6x62.a44) + (fMatrix6x6.a65 * fMatrix6x62.a54) + (fMatrix6x6.a66 * fMatrix6x62.a64);
        fMatrix6x63.a65 = (fMatrix6x6.a61 * fMatrix6x62.a15) + (fMatrix6x6.a62 * fMatrix6x62.a25) + (fMatrix6x6.a63 * fMatrix6x62.a35) + (fMatrix6x6.a64 * fMatrix6x62.a45) + (fMatrix6x6.a65 * fMatrix6x62.a55) + (fMatrix6x6.a66 * fMatrix6x62.a65);
        fMatrix6x63.a66 = (fMatrix6x6.a61 * fMatrix6x62.a16) + (fMatrix6x6.a62 * fMatrix6x62.a26) + (fMatrix6x6.a63 * fMatrix6x62.a36) + (fMatrix6x6.a64 * fMatrix6x62.a46) + (fMatrix6x6.a65 * fMatrix6x62.a56) + (fMatrix6x6.a66 * fMatrix6x62.a66);
    }

    public static void multTransA(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62, FMatrix6x6 fMatrix6x63) {
        fMatrix6x63.a11 = (fMatrix6x6.a11 * fMatrix6x62.a11) + (fMatrix6x6.a21 * fMatrix6x62.a21) + (fMatrix6x6.a31 * fMatrix6x62.a31) + (fMatrix6x6.a41 * fMatrix6x62.a41) + (fMatrix6x6.a51 * fMatrix6x62.a51) + (fMatrix6x6.a61 * fMatrix6x62.a61);
        fMatrix6x63.a12 = (fMatrix6x6.a11 * fMatrix6x62.a12) + (fMatrix6x6.a21 * fMatrix6x62.a22) + (fMatrix6x6.a31 * fMatrix6x62.a32) + (fMatrix6x6.a41 * fMatrix6x62.a42) + (fMatrix6x6.a51 * fMatrix6x62.a52) + (fMatrix6x6.a61 * fMatrix6x62.a62);
        fMatrix6x63.a13 = (fMatrix6x6.a11 * fMatrix6x62.a13) + (fMatrix6x6.a21 * fMatrix6x62.a23) + (fMatrix6x6.a31 * fMatrix6x62.a33) + (fMatrix6x6.a41 * fMatrix6x62.a43) + (fMatrix6x6.a51 * fMatrix6x62.a53) + (fMatrix6x6.a61 * fMatrix6x62.a63);
        fMatrix6x63.a14 = (fMatrix6x6.a11 * fMatrix6x62.a14) + (fMatrix6x6.a21 * fMatrix6x62.a24) + (fMatrix6x6.a31 * fMatrix6x62.a34) + (fMatrix6x6.a41 * fMatrix6x62.a44) + (fMatrix6x6.a51 * fMatrix6x62.a54) + (fMatrix6x6.a61 * fMatrix6x62.a64);
        fMatrix6x63.a15 = (fMatrix6x6.a11 * fMatrix6x62.a15) + (fMatrix6x6.a21 * fMatrix6x62.a25) + (fMatrix6x6.a31 * fMatrix6x62.a35) + (fMatrix6x6.a41 * fMatrix6x62.a45) + (fMatrix6x6.a51 * fMatrix6x62.a55) + (fMatrix6x6.a61 * fMatrix6x62.a65);
        fMatrix6x63.a16 = (fMatrix6x6.a11 * fMatrix6x62.a16) + (fMatrix6x6.a21 * fMatrix6x62.a26) + (fMatrix6x6.a31 * fMatrix6x62.a36) + (fMatrix6x6.a41 * fMatrix6x62.a46) + (fMatrix6x6.a51 * fMatrix6x62.a56) + (fMatrix6x6.a61 * fMatrix6x62.a66);
        fMatrix6x63.a21 = (fMatrix6x6.a12 * fMatrix6x62.a11) + (fMatrix6x6.a22 * fMatrix6x62.a21) + (fMatrix6x6.a32 * fMatrix6x62.a31) + (fMatrix6x6.a42 * fMatrix6x62.a41) + (fMatrix6x6.a52 * fMatrix6x62.a51) + (fMatrix6x6.a62 * fMatrix6x62.a61);
        fMatrix6x63.a22 = (fMatrix6x6.a12 * fMatrix6x62.a12) + (fMatrix6x6.a22 * fMatrix6x62.a22) + (fMatrix6x6.a32 * fMatrix6x62.a32) + (fMatrix6x6.a42 * fMatrix6x62.a42) + (fMatrix6x6.a52 * fMatrix6x62.a52) + (fMatrix6x6.a62 * fMatrix6x62.a62);
        fMatrix6x63.a23 = (fMatrix6x6.a12 * fMatrix6x62.a13) + (fMatrix6x6.a22 * fMatrix6x62.a23) + (fMatrix6x6.a32 * fMatrix6x62.a33) + (fMatrix6x6.a42 * fMatrix6x62.a43) + (fMatrix6x6.a52 * fMatrix6x62.a53) + (fMatrix6x6.a62 * fMatrix6x62.a63);
        fMatrix6x63.a24 = (fMatrix6x6.a12 * fMatrix6x62.a14) + (fMatrix6x6.a22 * fMatrix6x62.a24) + (fMatrix6x6.a32 * fMatrix6x62.a34) + (fMatrix6x6.a42 * fMatrix6x62.a44) + (fMatrix6x6.a52 * fMatrix6x62.a54) + (fMatrix6x6.a62 * fMatrix6x62.a64);
        fMatrix6x63.a25 = (fMatrix6x6.a12 * fMatrix6x62.a15) + (fMatrix6x6.a22 * fMatrix6x62.a25) + (fMatrix6x6.a32 * fMatrix6x62.a35) + (fMatrix6x6.a42 * fMatrix6x62.a45) + (fMatrix6x6.a52 * fMatrix6x62.a55) + (fMatrix6x6.a62 * fMatrix6x62.a65);
        fMatrix6x63.a26 = (fMatrix6x6.a12 * fMatrix6x62.a16) + (fMatrix6x6.a22 * fMatrix6x62.a26) + (fMatrix6x6.a32 * fMatrix6x62.a36) + (fMatrix6x6.a42 * fMatrix6x62.a46) + (fMatrix6x6.a52 * fMatrix6x62.a56) + (fMatrix6x6.a62 * fMatrix6x62.a66);
        fMatrix6x63.a31 = (fMatrix6x6.a13 * fMatrix6x62.a11) + (fMatrix6x6.a23 * fMatrix6x62.a21) + (fMatrix6x6.a33 * fMatrix6x62.a31) + (fMatrix6x6.a43 * fMatrix6x62.a41) + (fMatrix6x6.a53 * fMatrix6x62.a51) + (fMatrix6x6.a63 * fMatrix6x62.a61);
        fMatrix6x63.a32 = (fMatrix6x6.a13 * fMatrix6x62.a12) + (fMatrix6x6.a23 * fMatrix6x62.a22) + (fMatrix6x6.a33 * fMatrix6x62.a32) + (fMatrix6x6.a43 * fMatrix6x62.a42) + (fMatrix6x6.a53 * fMatrix6x62.a52) + (fMatrix6x6.a63 * fMatrix6x62.a62);
        fMatrix6x63.a33 = (fMatrix6x6.a13 * fMatrix6x62.a13) + (fMatrix6x6.a23 * fMatrix6x62.a23) + (fMatrix6x6.a33 * fMatrix6x62.a33) + (fMatrix6x6.a43 * fMatrix6x62.a43) + (fMatrix6x6.a53 * fMatrix6x62.a53) + (fMatrix6x6.a63 * fMatrix6x62.a63);
        fMatrix6x63.a34 = (fMatrix6x6.a13 * fMatrix6x62.a14) + (fMatrix6x6.a23 * fMatrix6x62.a24) + (fMatrix6x6.a33 * fMatrix6x62.a34) + (fMatrix6x6.a43 * fMatrix6x62.a44) + (fMatrix6x6.a53 * fMatrix6x62.a54) + (fMatrix6x6.a63 * fMatrix6x62.a64);
        fMatrix6x63.a35 = (fMatrix6x6.a13 * fMatrix6x62.a15) + (fMatrix6x6.a23 * fMatrix6x62.a25) + (fMatrix6x6.a33 * fMatrix6x62.a35) + (fMatrix6x6.a43 * fMatrix6x62.a45) + (fMatrix6x6.a53 * fMatrix6x62.a55) + (fMatrix6x6.a63 * fMatrix6x62.a65);
        fMatrix6x63.a36 = (fMatrix6x6.a13 * fMatrix6x62.a16) + (fMatrix6x6.a23 * fMatrix6x62.a26) + (fMatrix6x6.a33 * fMatrix6x62.a36) + (fMatrix6x6.a43 * fMatrix6x62.a46) + (fMatrix6x6.a53 * fMatrix6x62.a56) + (fMatrix6x6.a63 * fMatrix6x62.a66);
        fMatrix6x63.a41 = (fMatrix6x6.a14 * fMatrix6x62.a11) + (fMatrix6x6.a24 * fMatrix6x62.a21) + (fMatrix6x6.a34 * fMatrix6x62.a31) + (fMatrix6x6.a44 * fMatrix6x62.a41) + (fMatrix6x6.a54 * fMatrix6x62.a51) + (fMatrix6x6.a64 * fMatrix6x62.a61);
        fMatrix6x63.a42 = (fMatrix6x6.a14 * fMatrix6x62.a12) + (fMatrix6x6.a24 * fMatrix6x62.a22) + (fMatrix6x6.a34 * fMatrix6x62.a32) + (fMatrix6x6.a44 * fMatrix6x62.a42) + (fMatrix6x6.a54 * fMatrix6x62.a52) + (fMatrix6x6.a64 * fMatrix6x62.a62);
        fMatrix6x63.a43 = (fMatrix6x6.a14 * fMatrix6x62.a13) + (fMatrix6x6.a24 * fMatrix6x62.a23) + (fMatrix6x6.a34 * fMatrix6x62.a33) + (fMatrix6x6.a44 * fMatrix6x62.a43) + (fMatrix6x6.a54 * fMatrix6x62.a53) + (fMatrix6x6.a64 * fMatrix6x62.a63);
        fMatrix6x63.a44 = (fMatrix6x6.a14 * fMatrix6x62.a14) + (fMatrix6x6.a24 * fMatrix6x62.a24) + (fMatrix6x6.a34 * fMatrix6x62.a34) + (fMatrix6x6.a44 * fMatrix6x62.a44) + (fMatrix6x6.a54 * fMatrix6x62.a54) + (fMatrix6x6.a64 * fMatrix6x62.a64);
        fMatrix6x63.a45 = (fMatrix6x6.a14 * fMatrix6x62.a15) + (fMatrix6x6.a24 * fMatrix6x62.a25) + (fMatrix6x6.a34 * fMatrix6x62.a35) + (fMatrix6x6.a44 * fMatrix6x62.a45) + (fMatrix6x6.a54 * fMatrix6x62.a55) + (fMatrix6x6.a64 * fMatrix6x62.a65);
        fMatrix6x63.a46 = (fMatrix6x6.a14 * fMatrix6x62.a16) + (fMatrix6x6.a24 * fMatrix6x62.a26) + (fMatrix6x6.a34 * fMatrix6x62.a36) + (fMatrix6x6.a44 * fMatrix6x62.a46) + (fMatrix6x6.a54 * fMatrix6x62.a56) + (fMatrix6x6.a64 * fMatrix6x62.a66);
        fMatrix6x63.a51 = (fMatrix6x6.a15 * fMatrix6x62.a11) + (fMatrix6x6.a25 * fMatrix6x62.a21) + (fMatrix6x6.a35 * fMatrix6x62.a31) + (fMatrix6x6.a45 * fMatrix6x62.a41) + (fMatrix6x6.a55 * fMatrix6x62.a51) + (fMatrix6x6.a65 * fMatrix6x62.a61);
        fMatrix6x63.a52 = (fMatrix6x6.a15 * fMatrix6x62.a12) + (fMatrix6x6.a25 * fMatrix6x62.a22) + (fMatrix6x6.a35 * fMatrix6x62.a32) + (fMatrix6x6.a45 * fMatrix6x62.a42) + (fMatrix6x6.a55 * fMatrix6x62.a52) + (fMatrix6x6.a65 * fMatrix6x62.a62);
        fMatrix6x63.a53 = (fMatrix6x6.a15 * fMatrix6x62.a13) + (fMatrix6x6.a25 * fMatrix6x62.a23) + (fMatrix6x6.a35 * fMatrix6x62.a33) + (fMatrix6x6.a45 * fMatrix6x62.a43) + (fMatrix6x6.a55 * fMatrix6x62.a53) + (fMatrix6x6.a65 * fMatrix6x62.a63);
        fMatrix6x63.a54 = (fMatrix6x6.a15 * fMatrix6x62.a14) + (fMatrix6x6.a25 * fMatrix6x62.a24) + (fMatrix6x6.a35 * fMatrix6x62.a34) + (fMatrix6x6.a45 * fMatrix6x62.a44) + (fMatrix6x6.a55 * fMatrix6x62.a54) + (fMatrix6x6.a65 * fMatrix6x62.a64);
        fMatrix6x63.a55 = (fMatrix6x6.a15 * fMatrix6x62.a15) + (fMatrix6x6.a25 * fMatrix6x62.a25) + (fMatrix6x6.a35 * fMatrix6x62.a35) + (fMatrix6x6.a45 * fMatrix6x62.a45) + (fMatrix6x6.a55 * fMatrix6x62.a55) + (fMatrix6x6.a65 * fMatrix6x62.a65);
        fMatrix6x63.a56 = (fMatrix6x6.a15 * fMatrix6x62.a16) + (fMatrix6x6.a25 * fMatrix6x62.a26) + (fMatrix6x6.a35 * fMatrix6x62.a36) + (fMatrix6x6.a45 * fMatrix6x62.a46) + (fMatrix6x6.a55 * fMatrix6x62.a56) + (fMatrix6x6.a65 * fMatrix6x62.a66);
        fMatrix6x63.a61 = (fMatrix6x6.a16 * fMatrix6x62.a11) + (fMatrix6x6.a26 * fMatrix6x62.a21) + (fMatrix6x6.a36 * fMatrix6x62.a31) + (fMatrix6x6.a46 * fMatrix6x62.a41) + (fMatrix6x6.a56 * fMatrix6x62.a51) + (fMatrix6x6.a66 * fMatrix6x62.a61);
        fMatrix6x63.a62 = (fMatrix6x6.a16 * fMatrix6x62.a12) + (fMatrix6x6.a26 * fMatrix6x62.a22) + (fMatrix6x6.a36 * fMatrix6x62.a32) + (fMatrix6x6.a46 * fMatrix6x62.a42) + (fMatrix6x6.a56 * fMatrix6x62.a52) + (fMatrix6x6.a66 * fMatrix6x62.a62);
        fMatrix6x63.a63 = (fMatrix6x6.a16 * fMatrix6x62.a13) + (fMatrix6x6.a26 * fMatrix6x62.a23) + (fMatrix6x6.a36 * fMatrix6x62.a33) + (fMatrix6x6.a46 * fMatrix6x62.a43) + (fMatrix6x6.a56 * fMatrix6x62.a53) + (fMatrix6x6.a66 * fMatrix6x62.a63);
        fMatrix6x63.a64 = (fMatrix6x6.a16 * fMatrix6x62.a14) + (fMatrix6x6.a26 * fMatrix6x62.a24) + (fMatrix6x6.a36 * fMatrix6x62.a34) + (fMatrix6x6.a46 * fMatrix6x62.a44) + (fMatrix6x6.a56 * fMatrix6x62.a54) + (fMatrix6x6.a66 * fMatrix6x62.a64);
        fMatrix6x63.a65 = (fMatrix6x6.a16 * fMatrix6x62.a15) + (fMatrix6x6.a26 * fMatrix6x62.a25) + (fMatrix6x6.a36 * fMatrix6x62.a35) + (fMatrix6x6.a46 * fMatrix6x62.a45) + (fMatrix6x6.a56 * fMatrix6x62.a55) + (fMatrix6x6.a66 * fMatrix6x62.a65);
        fMatrix6x63.a66 = (fMatrix6x6.a16 * fMatrix6x62.a16) + (fMatrix6x6.a26 * fMatrix6x62.a26) + (fMatrix6x6.a36 * fMatrix6x62.a36) + (fMatrix6x6.a46 * fMatrix6x62.a46) + (fMatrix6x6.a56 * fMatrix6x62.a56) + (fMatrix6x6.a66 * fMatrix6x62.a66);
    }

    public static void multTransAB(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62, FMatrix6x6 fMatrix6x63) {
        fMatrix6x63.a11 = (fMatrix6x6.a11 * fMatrix6x62.a11) + (fMatrix6x6.a21 * fMatrix6x62.a12) + (fMatrix6x6.a31 * fMatrix6x62.a13) + (fMatrix6x6.a41 * fMatrix6x62.a14) + (fMatrix6x6.a51 * fMatrix6x62.a15) + (fMatrix6x6.a61 * fMatrix6x62.a16);
        fMatrix6x63.a12 = (fMatrix6x6.a11 * fMatrix6x62.a21) + (fMatrix6x6.a21 * fMatrix6x62.a22) + (fMatrix6x6.a31 * fMatrix6x62.a23) + (fMatrix6x6.a41 * fMatrix6x62.a24) + (fMatrix6x6.a51 * fMatrix6x62.a25) + (fMatrix6x6.a61 * fMatrix6x62.a26);
        fMatrix6x63.a13 = (fMatrix6x6.a11 * fMatrix6x62.a31) + (fMatrix6x6.a21 * fMatrix6x62.a32) + (fMatrix6x6.a31 * fMatrix6x62.a33) + (fMatrix6x6.a41 * fMatrix6x62.a34) + (fMatrix6x6.a51 * fMatrix6x62.a35) + (fMatrix6x6.a61 * fMatrix6x62.a36);
        fMatrix6x63.a14 = (fMatrix6x6.a11 * fMatrix6x62.a41) + (fMatrix6x6.a21 * fMatrix6x62.a42) + (fMatrix6x6.a31 * fMatrix6x62.a43) + (fMatrix6x6.a41 * fMatrix6x62.a44) + (fMatrix6x6.a51 * fMatrix6x62.a45) + (fMatrix6x6.a61 * fMatrix6x62.a46);
        fMatrix6x63.a15 = (fMatrix6x6.a11 * fMatrix6x62.a51) + (fMatrix6x6.a21 * fMatrix6x62.a52) + (fMatrix6x6.a31 * fMatrix6x62.a53) + (fMatrix6x6.a41 * fMatrix6x62.a54) + (fMatrix6x6.a51 * fMatrix6x62.a55) + (fMatrix6x6.a61 * fMatrix6x62.a56);
        fMatrix6x63.a16 = (fMatrix6x6.a11 * fMatrix6x62.a61) + (fMatrix6x6.a21 * fMatrix6x62.a62) + (fMatrix6x6.a31 * fMatrix6x62.a63) + (fMatrix6x6.a41 * fMatrix6x62.a64) + (fMatrix6x6.a51 * fMatrix6x62.a65) + (fMatrix6x6.a61 * fMatrix6x62.a66);
        fMatrix6x63.a21 = (fMatrix6x6.a12 * fMatrix6x62.a11) + (fMatrix6x6.a22 * fMatrix6x62.a12) + (fMatrix6x6.a32 * fMatrix6x62.a13) + (fMatrix6x6.a42 * fMatrix6x62.a14) + (fMatrix6x6.a52 * fMatrix6x62.a15) + (fMatrix6x6.a62 * fMatrix6x62.a16);
        fMatrix6x63.a22 = (fMatrix6x6.a12 * fMatrix6x62.a21) + (fMatrix6x6.a22 * fMatrix6x62.a22) + (fMatrix6x6.a32 * fMatrix6x62.a23) + (fMatrix6x6.a42 * fMatrix6x62.a24) + (fMatrix6x6.a52 * fMatrix6x62.a25) + (fMatrix6x6.a62 * fMatrix6x62.a26);
        fMatrix6x63.a23 = (fMatrix6x6.a12 * fMatrix6x62.a31) + (fMatrix6x6.a22 * fMatrix6x62.a32) + (fMatrix6x6.a32 * fMatrix6x62.a33) + (fMatrix6x6.a42 * fMatrix6x62.a34) + (fMatrix6x6.a52 * fMatrix6x62.a35) + (fMatrix6x6.a62 * fMatrix6x62.a36);
        fMatrix6x63.a24 = (fMatrix6x6.a12 * fMatrix6x62.a41) + (fMatrix6x6.a22 * fMatrix6x62.a42) + (fMatrix6x6.a32 * fMatrix6x62.a43) + (fMatrix6x6.a42 * fMatrix6x62.a44) + (fMatrix6x6.a52 * fMatrix6x62.a45) + (fMatrix6x6.a62 * fMatrix6x62.a46);
        fMatrix6x63.a25 = (fMatrix6x6.a12 * fMatrix6x62.a51) + (fMatrix6x6.a22 * fMatrix6x62.a52) + (fMatrix6x6.a32 * fMatrix6x62.a53) + (fMatrix6x6.a42 * fMatrix6x62.a54) + (fMatrix6x6.a52 * fMatrix6x62.a55) + (fMatrix6x6.a62 * fMatrix6x62.a56);
        fMatrix6x63.a26 = (fMatrix6x6.a12 * fMatrix6x62.a61) + (fMatrix6x6.a22 * fMatrix6x62.a62) + (fMatrix6x6.a32 * fMatrix6x62.a63) + (fMatrix6x6.a42 * fMatrix6x62.a64) + (fMatrix6x6.a52 * fMatrix6x62.a65) + (fMatrix6x6.a62 * fMatrix6x62.a66);
        fMatrix6x63.a31 = (fMatrix6x6.a13 * fMatrix6x62.a11) + (fMatrix6x6.a23 * fMatrix6x62.a12) + (fMatrix6x6.a33 * fMatrix6x62.a13) + (fMatrix6x6.a43 * fMatrix6x62.a14) + (fMatrix6x6.a53 * fMatrix6x62.a15) + (fMatrix6x6.a63 * fMatrix6x62.a16);
        fMatrix6x63.a32 = (fMatrix6x6.a13 * fMatrix6x62.a21) + (fMatrix6x6.a23 * fMatrix6x62.a22) + (fMatrix6x6.a33 * fMatrix6x62.a23) + (fMatrix6x6.a43 * fMatrix6x62.a24) + (fMatrix6x6.a53 * fMatrix6x62.a25) + (fMatrix6x6.a63 * fMatrix6x62.a26);
        fMatrix6x63.a33 = (fMatrix6x6.a13 * fMatrix6x62.a31) + (fMatrix6x6.a23 * fMatrix6x62.a32) + (fMatrix6x6.a33 * fMatrix6x62.a33) + (fMatrix6x6.a43 * fMatrix6x62.a34) + (fMatrix6x6.a53 * fMatrix6x62.a35) + (fMatrix6x6.a63 * fMatrix6x62.a36);
        fMatrix6x63.a34 = (fMatrix6x6.a13 * fMatrix6x62.a41) + (fMatrix6x6.a23 * fMatrix6x62.a42) + (fMatrix6x6.a33 * fMatrix6x62.a43) + (fMatrix6x6.a43 * fMatrix6x62.a44) + (fMatrix6x6.a53 * fMatrix6x62.a45) + (fMatrix6x6.a63 * fMatrix6x62.a46);
        fMatrix6x63.a35 = (fMatrix6x6.a13 * fMatrix6x62.a51) + (fMatrix6x6.a23 * fMatrix6x62.a52) + (fMatrix6x6.a33 * fMatrix6x62.a53) + (fMatrix6x6.a43 * fMatrix6x62.a54) + (fMatrix6x6.a53 * fMatrix6x62.a55) + (fMatrix6x6.a63 * fMatrix6x62.a56);
        fMatrix6x63.a36 = (fMatrix6x6.a13 * fMatrix6x62.a61) + (fMatrix6x6.a23 * fMatrix6x62.a62) + (fMatrix6x6.a33 * fMatrix6x62.a63) + (fMatrix6x6.a43 * fMatrix6x62.a64) + (fMatrix6x6.a53 * fMatrix6x62.a65) + (fMatrix6x6.a63 * fMatrix6x62.a66);
        fMatrix6x63.a41 = (fMatrix6x6.a14 * fMatrix6x62.a11) + (fMatrix6x6.a24 * fMatrix6x62.a12) + (fMatrix6x6.a34 * fMatrix6x62.a13) + (fMatrix6x6.a44 * fMatrix6x62.a14) + (fMatrix6x6.a54 * fMatrix6x62.a15) + (fMatrix6x6.a64 * fMatrix6x62.a16);
        fMatrix6x63.a42 = (fMatrix6x6.a14 * fMatrix6x62.a21) + (fMatrix6x6.a24 * fMatrix6x62.a22) + (fMatrix6x6.a34 * fMatrix6x62.a23) + (fMatrix6x6.a44 * fMatrix6x62.a24) + (fMatrix6x6.a54 * fMatrix6x62.a25) + (fMatrix6x6.a64 * fMatrix6x62.a26);
        fMatrix6x63.a43 = (fMatrix6x6.a14 * fMatrix6x62.a31) + (fMatrix6x6.a24 * fMatrix6x62.a32) + (fMatrix6x6.a34 * fMatrix6x62.a33) + (fMatrix6x6.a44 * fMatrix6x62.a34) + (fMatrix6x6.a54 * fMatrix6x62.a35) + (fMatrix6x6.a64 * fMatrix6x62.a36);
        fMatrix6x63.a44 = (fMatrix6x6.a14 * fMatrix6x62.a41) + (fMatrix6x6.a24 * fMatrix6x62.a42) + (fMatrix6x6.a34 * fMatrix6x62.a43) + (fMatrix6x6.a44 * fMatrix6x62.a44) + (fMatrix6x6.a54 * fMatrix6x62.a45) + (fMatrix6x6.a64 * fMatrix6x62.a46);
        fMatrix6x63.a45 = (fMatrix6x6.a14 * fMatrix6x62.a51) + (fMatrix6x6.a24 * fMatrix6x62.a52) + (fMatrix6x6.a34 * fMatrix6x62.a53) + (fMatrix6x6.a44 * fMatrix6x62.a54) + (fMatrix6x6.a54 * fMatrix6x62.a55) + (fMatrix6x6.a64 * fMatrix6x62.a56);
        fMatrix6x63.a46 = (fMatrix6x6.a14 * fMatrix6x62.a61) + (fMatrix6x6.a24 * fMatrix6x62.a62) + (fMatrix6x6.a34 * fMatrix6x62.a63) + (fMatrix6x6.a44 * fMatrix6x62.a64) + (fMatrix6x6.a54 * fMatrix6x62.a65) + (fMatrix6x6.a64 * fMatrix6x62.a66);
        fMatrix6x63.a51 = (fMatrix6x6.a15 * fMatrix6x62.a11) + (fMatrix6x6.a25 * fMatrix6x62.a12) + (fMatrix6x6.a35 * fMatrix6x62.a13) + (fMatrix6x6.a45 * fMatrix6x62.a14) + (fMatrix6x6.a55 * fMatrix6x62.a15) + (fMatrix6x6.a65 * fMatrix6x62.a16);
        fMatrix6x63.a52 = (fMatrix6x6.a15 * fMatrix6x62.a21) + (fMatrix6x6.a25 * fMatrix6x62.a22) + (fMatrix6x6.a35 * fMatrix6x62.a23) + (fMatrix6x6.a45 * fMatrix6x62.a24) + (fMatrix6x6.a55 * fMatrix6x62.a25) + (fMatrix6x6.a65 * fMatrix6x62.a26);
        fMatrix6x63.a53 = (fMatrix6x6.a15 * fMatrix6x62.a31) + (fMatrix6x6.a25 * fMatrix6x62.a32) + (fMatrix6x6.a35 * fMatrix6x62.a33) + (fMatrix6x6.a45 * fMatrix6x62.a34) + (fMatrix6x6.a55 * fMatrix6x62.a35) + (fMatrix6x6.a65 * fMatrix6x62.a36);
        fMatrix6x63.a54 = (fMatrix6x6.a15 * fMatrix6x62.a41) + (fMatrix6x6.a25 * fMatrix6x62.a42) + (fMatrix6x6.a35 * fMatrix6x62.a43) + (fMatrix6x6.a45 * fMatrix6x62.a44) + (fMatrix6x6.a55 * fMatrix6x62.a45) + (fMatrix6x6.a65 * fMatrix6x62.a46);
        fMatrix6x63.a55 = (fMatrix6x6.a15 * fMatrix6x62.a51) + (fMatrix6x6.a25 * fMatrix6x62.a52) + (fMatrix6x6.a35 * fMatrix6x62.a53) + (fMatrix6x6.a45 * fMatrix6x62.a54) + (fMatrix6x6.a55 * fMatrix6x62.a55) + (fMatrix6x6.a65 * fMatrix6x62.a56);
        fMatrix6x63.a56 = (fMatrix6x6.a15 * fMatrix6x62.a61) + (fMatrix6x6.a25 * fMatrix6x62.a62) + (fMatrix6x6.a35 * fMatrix6x62.a63) + (fMatrix6x6.a45 * fMatrix6x62.a64) + (fMatrix6x6.a55 * fMatrix6x62.a65) + (fMatrix6x6.a65 * fMatrix6x62.a66);
        fMatrix6x63.a61 = (fMatrix6x6.a16 * fMatrix6x62.a11) + (fMatrix6x6.a26 * fMatrix6x62.a12) + (fMatrix6x6.a36 * fMatrix6x62.a13) + (fMatrix6x6.a46 * fMatrix6x62.a14) + (fMatrix6x6.a56 * fMatrix6x62.a15) + (fMatrix6x6.a66 * fMatrix6x62.a16);
        fMatrix6x63.a62 = (fMatrix6x6.a16 * fMatrix6x62.a21) + (fMatrix6x6.a26 * fMatrix6x62.a22) + (fMatrix6x6.a36 * fMatrix6x62.a23) + (fMatrix6x6.a46 * fMatrix6x62.a24) + (fMatrix6x6.a56 * fMatrix6x62.a25) + (fMatrix6x6.a66 * fMatrix6x62.a26);
        fMatrix6x63.a63 = (fMatrix6x6.a16 * fMatrix6x62.a31) + (fMatrix6x6.a26 * fMatrix6x62.a32) + (fMatrix6x6.a36 * fMatrix6x62.a33) + (fMatrix6x6.a46 * fMatrix6x62.a34) + (fMatrix6x6.a56 * fMatrix6x62.a35) + (fMatrix6x6.a66 * fMatrix6x62.a36);
        fMatrix6x63.a64 = (fMatrix6x6.a16 * fMatrix6x62.a41) + (fMatrix6x6.a26 * fMatrix6x62.a42) + (fMatrix6x6.a36 * fMatrix6x62.a43) + (fMatrix6x6.a46 * fMatrix6x62.a44) + (fMatrix6x6.a56 * fMatrix6x62.a45) + (fMatrix6x6.a66 * fMatrix6x62.a46);
        fMatrix6x63.a65 = (fMatrix6x6.a16 * fMatrix6x62.a51) + (fMatrix6x6.a26 * fMatrix6x62.a52) + (fMatrix6x6.a36 * fMatrix6x62.a53) + (fMatrix6x6.a46 * fMatrix6x62.a54) + (fMatrix6x6.a56 * fMatrix6x62.a55) + (fMatrix6x6.a66 * fMatrix6x62.a56);
        fMatrix6x63.a66 = (fMatrix6x6.a16 * fMatrix6x62.a61) + (fMatrix6x6.a26 * fMatrix6x62.a62) + (fMatrix6x6.a36 * fMatrix6x62.a63) + (fMatrix6x6.a46 * fMatrix6x62.a64) + (fMatrix6x6.a56 * fMatrix6x62.a65) + (fMatrix6x6.a66 * fMatrix6x62.a66);
    }

    public static void multTransB(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62, FMatrix6x6 fMatrix6x63) {
        fMatrix6x63.a11 = (fMatrix6x6.a11 * fMatrix6x62.a11) + (fMatrix6x6.a12 * fMatrix6x62.a12) + (fMatrix6x6.a13 * fMatrix6x62.a13) + (fMatrix6x6.a14 * fMatrix6x62.a14) + (fMatrix6x6.a15 * fMatrix6x62.a15) + (fMatrix6x6.a16 * fMatrix6x62.a16);
        fMatrix6x63.a12 = (fMatrix6x6.a11 * fMatrix6x62.a21) + (fMatrix6x6.a12 * fMatrix6x62.a22) + (fMatrix6x6.a13 * fMatrix6x62.a23) + (fMatrix6x6.a14 * fMatrix6x62.a24) + (fMatrix6x6.a15 * fMatrix6x62.a25) + (fMatrix6x6.a16 * fMatrix6x62.a26);
        fMatrix6x63.a13 = (fMatrix6x6.a11 * fMatrix6x62.a31) + (fMatrix6x6.a12 * fMatrix6x62.a32) + (fMatrix6x6.a13 * fMatrix6x62.a33) + (fMatrix6x6.a14 * fMatrix6x62.a34) + (fMatrix6x6.a15 * fMatrix6x62.a35) + (fMatrix6x6.a16 * fMatrix6x62.a36);
        fMatrix6x63.a14 = (fMatrix6x6.a11 * fMatrix6x62.a41) + (fMatrix6x6.a12 * fMatrix6x62.a42) + (fMatrix6x6.a13 * fMatrix6x62.a43) + (fMatrix6x6.a14 * fMatrix6x62.a44) + (fMatrix6x6.a15 * fMatrix6x62.a45) + (fMatrix6x6.a16 * fMatrix6x62.a46);
        fMatrix6x63.a15 = (fMatrix6x6.a11 * fMatrix6x62.a51) + (fMatrix6x6.a12 * fMatrix6x62.a52) + (fMatrix6x6.a13 * fMatrix6x62.a53) + (fMatrix6x6.a14 * fMatrix6x62.a54) + (fMatrix6x6.a15 * fMatrix6x62.a55) + (fMatrix6x6.a16 * fMatrix6x62.a56);
        fMatrix6x63.a16 = (fMatrix6x6.a11 * fMatrix6x62.a61) + (fMatrix6x6.a12 * fMatrix6x62.a62) + (fMatrix6x6.a13 * fMatrix6x62.a63) + (fMatrix6x6.a14 * fMatrix6x62.a64) + (fMatrix6x6.a15 * fMatrix6x62.a65) + (fMatrix6x6.a16 * fMatrix6x62.a66);
        fMatrix6x63.a21 = (fMatrix6x6.a21 * fMatrix6x62.a11) + (fMatrix6x6.a22 * fMatrix6x62.a12) + (fMatrix6x6.a23 * fMatrix6x62.a13) + (fMatrix6x6.a24 * fMatrix6x62.a14) + (fMatrix6x6.a25 * fMatrix6x62.a15) + (fMatrix6x6.a26 * fMatrix6x62.a16);
        fMatrix6x63.a22 = (fMatrix6x6.a21 * fMatrix6x62.a21) + (fMatrix6x6.a22 * fMatrix6x62.a22) + (fMatrix6x6.a23 * fMatrix6x62.a23) + (fMatrix6x6.a24 * fMatrix6x62.a24) + (fMatrix6x6.a25 * fMatrix6x62.a25) + (fMatrix6x6.a26 * fMatrix6x62.a26);
        fMatrix6x63.a23 = (fMatrix6x6.a21 * fMatrix6x62.a31) + (fMatrix6x6.a22 * fMatrix6x62.a32) + (fMatrix6x6.a23 * fMatrix6x62.a33) + (fMatrix6x6.a24 * fMatrix6x62.a34) + (fMatrix6x6.a25 * fMatrix6x62.a35) + (fMatrix6x6.a26 * fMatrix6x62.a36);
        fMatrix6x63.a24 = (fMatrix6x6.a21 * fMatrix6x62.a41) + (fMatrix6x6.a22 * fMatrix6x62.a42) + (fMatrix6x6.a23 * fMatrix6x62.a43) + (fMatrix6x6.a24 * fMatrix6x62.a44) + (fMatrix6x6.a25 * fMatrix6x62.a45) + (fMatrix6x6.a26 * fMatrix6x62.a46);
        fMatrix6x63.a25 = (fMatrix6x6.a21 * fMatrix6x62.a51) + (fMatrix6x6.a22 * fMatrix6x62.a52) + (fMatrix6x6.a23 * fMatrix6x62.a53) + (fMatrix6x6.a24 * fMatrix6x62.a54) + (fMatrix6x6.a25 * fMatrix6x62.a55) + (fMatrix6x6.a26 * fMatrix6x62.a56);
        fMatrix6x63.a26 = (fMatrix6x6.a21 * fMatrix6x62.a61) + (fMatrix6x6.a22 * fMatrix6x62.a62) + (fMatrix6x6.a23 * fMatrix6x62.a63) + (fMatrix6x6.a24 * fMatrix6x62.a64) + (fMatrix6x6.a25 * fMatrix6x62.a65) + (fMatrix6x6.a26 * fMatrix6x62.a66);
        fMatrix6x63.a31 = (fMatrix6x6.a31 * fMatrix6x62.a11) + (fMatrix6x6.a32 * fMatrix6x62.a12) + (fMatrix6x6.a33 * fMatrix6x62.a13) + (fMatrix6x6.a34 * fMatrix6x62.a14) + (fMatrix6x6.a35 * fMatrix6x62.a15) + (fMatrix6x6.a36 * fMatrix6x62.a16);
        fMatrix6x63.a32 = (fMatrix6x6.a31 * fMatrix6x62.a21) + (fMatrix6x6.a32 * fMatrix6x62.a22) + (fMatrix6x6.a33 * fMatrix6x62.a23) + (fMatrix6x6.a34 * fMatrix6x62.a24) + (fMatrix6x6.a35 * fMatrix6x62.a25) + (fMatrix6x6.a36 * fMatrix6x62.a26);
        fMatrix6x63.a33 = (fMatrix6x6.a31 * fMatrix6x62.a31) + (fMatrix6x6.a32 * fMatrix6x62.a32) + (fMatrix6x6.a33 * fMatrix6x62.a33) + (fMatrix6x6.a34 * fMatrix6x62.a34) + (fMatrix6x6.a35 * fMatrix6x62.a35) + (fMatrix6x6.a36 * fMatrix6x62.a36);
        fMatrix6x63.a34 = (fMatrix6x6.a31 * fMatrix6x62.a41) + (fMatrix6x6.a32 * fMatrix6x62.a42) + (fMatrix6x6.a33 * fMatrix6x62.a43) + (fMatrix6x6.a34 * fMatrix6x62.a44) + (fMatrix6x6.a35 * fMatrix6x62.a45) + (fMatrix6x6.a36 * fMatrix6x62.a46);
        fMatrix6x63.a35 = (fMatrix6x6.a31 * fMatrix6x62.a51) + (fMatrix6x6.a32 * fMatrix6x62.a52) + (fMatrix6x6.a33 * fMatrix6x62.a53) + (fMatrix6x6.a34 * fMatrix6x62.a54) + (fMatrix6x6.a35 * fMatrix6x62.a55) + (fMatrix6x6.a36 * fMatrix6x62.a56);
        fMatrix6x63.a36 = (fMatrix6x6.a31 * fMatrix6x62.a61) + (fMatrix6x6.a32 * fMatrix6x62.a62) + (fMatrix6x6.a33 * fMatrix6x62.a63) + (fMatrix6x6.a34 * fMatrix6x62.a64) + (fMatrix6x6.a35 * fMatrix6x62.a65) + (fMatrix6x6.a36 * fMatrix6x62.a66);
        fMatrix6x63.a41 = (fMatrix6x6.a41 * fMatrix6x62.a11) + (fMatrix6x6.a42 * fMatrix6x62.a12) + (fMatrix6x6.a43 * fMatrix6x62.a13) + (fMatrix6x6.a44 * fMatrix6x62.a14) + (fMatrix6x6.a45 * fMatrix6x62.a15) + (fMatrix6x6.a46 * fMatrix6x62.a16);
        fMatrix6x63.a42 = (fMatrix6x6.a41 * fMatrix6x62.a21) + (fMatrix6x6.a42 * fMatrix6x62.a22) + (fMatrix6x6.a43 * fMatrix6x62.a23) + (fMatrix6x6.a44 * fMatrix6x62.a24) + (fMatrix6x6.a45 * fMatrix6x62.a25) + (fMatrix6x6.a46 * fMatrix6x62.a26);
        fMatrix6x63.a43 = (fMatrix6x6.a41 * fMatrix6x62.a31) + (fMatrix6x6.a42 * fMatrix6x62.a32) + (fMatrix6x6.a43 * fMatrix6x62.a33) + (fMatrix6x6.a44 * fMatrix6x62.a34) + (fMatrix6x6.a45 * fMatrix6x62.a35) + (fMatrix6x6.a46 * fMatrix6x62.a36);
        fMatrix6x63.a44 = (fMatrix6x6.a41 * fMatrix6x62.a41) + (fMatrix6x6.a42 * fMatrix6x62.a42) + (fMatrix6x6.a43 * fMatrix6x62.a43) + (fMatrix6x6.a44 * fMatrix6x62.a44) + (fMatrix6x6.a45 * fMatrix6x62.a45) + (fMatrix6x6.a46 * fMatrix6x62.a46);
        fMatrix6x63.a45 = (fMatrix6x6.a41 * fMatrix6x62.a51) + (fMatrix6x6.a42 * fMatrix6x62.a52) + (fMatrix6x6.a43 * fMatrix6x62.a53) + (fMatrix6x6.a44 * fMatrix6x62.a54) + (fMatrix6x6.a45 * fMatrix6x62.a55) + (fMatrix6x6.a46 * fMatrix6x62.a56);
        fMatrix6x63.a46 = (fMatrix6x6.a41 * fMatrix6x62.a61) + (fMatrix6x6.a42 * fMatrix6x62.a62) + (fMatrix6x6.a43 * fMatrix6x62.a63) + (fMatrix6x6.a44 * fMatrix6x62.a64) + (fMatrix6x6.a45 * fMatrix6x62.a65) + (fMatrix6x6.a46 * fMatrix6x62.a66);
        fMatrix6x63.a51 = (fMatrix6x6.a51 * fMatrix6x62.a11) + (fMatrix6x6.a52 * fMatrix6x62.a12) + (fMatrix6x6.a53 * fMatrix6x62.a13) + (fMatrix6x6.a54 * fMatrix6x62.a14) + (fMatrix6x6.a55 * fMatrix6x62.a15) + (fMatrix6x6.a56 * fMatrix6x62.a16);
        fMatrix6x63.a52 = (fMatrix6x6.a51 * fMatrix6x62.a21) + (fMatrix6x6.a52 * fMatrix6x62.a22) + (fMatrix6x6.a53 * fMatrix6x62.a23) + (fMatrix6x6.a54 * fMatrix6x62.a24) + (fMatrix6x6.a55 * fMatrix6x62.a25) + (fMatrix6x6.a56 * fMatrix6x62.a26);
        fMatrix6x63.a53 = (fMatrix6x6.a51 * fMatrix6x62.a31) + (fMatrix6x6.a52 * fMatrix6x62.a32) + (fMatrix6x6.a53 * fMatrix6x62.a33) + (fMatrix6x6.a54 * fMatrix6x62.a34) + (fMatrix6x6.a55 * fMatrix6x62.a35) + (fMatrix6x6.a56 * fMatrix6x62.a36);
        fMatrix6x63.a54 = (fMatrix6x6.a51 * fMatrix6x62.a41) + (fMatrix6x6.a52 * fMatrix6x62.a42) + (fMatrix6x6.a53 * fMatrix6x62.a43) + (fMatrix6x6.a54 * fMatrix6x62.a44) + (fMatrix6x6.a55 * fMatrix6x62.a45) + (fMatrix6x6.a56 * fMatrix6x62.a46);
        fMatrix6x63.a55 = (fMatrix6x6.a51 * fMatrix6x62.a51) + (fMatrix6x6.a52 * fMatrix6x62.a52) + (fMatrix6x6.a53 * fMatrix6x62.a53) + (fMatrix6x6.a54 * fMatrix6x62.a54) + (fMatrix6x6.a55 * fMatrix6x62.a55) + (fMatrix6x6.a56 * fMatrix6x62.a56);
        fMatrix6x63.a56 = (fMatrix6x6.a51 * fMatrix6x62.a61) + (fMatrix6x6.a52 * fMatrix6x62.a62) + (fMatrix6x6.a53 * fMatrix6x62.a63) + (fMatrix6x6.a54 * fMatrix6x62.a64) + (fMatrix6x6.a55 * fMatrix6x62.a65) + (fMatrix6x6.a56 * fMatrix6x62.a66);
        fMatrix6x63.a61 = (fMatrix6x6.a61 * fMatrix6x62.a11) + (fMatrix6x6.a62 * fMatrix6x62.a12) + (fMatrix6x6.a63 * fMatrix6x62.a13) + (fMatrix6x6.a64 * fMatrix6x62.a14) + (fMatrix6x6.a65 * fMatrix6x62.a15) + (fMatrix6x6.a66 * fMatrix6x62.a16);
        fMatrix6x63.a62 = (fMatrix6x6.a61 * fMatrix6x62.a21) + (fMatrix6x6.a62 * fMatrix6x62.a22) + (fMatrix6x6.a63 * fMatrix6x62.a23) + (fMatrix6x6.a64 * fMatrix6x62.a24) + (fMatrix6x6.a65 * fMatrix6x62.a25) + (fMatrix6x6.a66 * fMatrix6x62.a26);
        fMatrix6x63.a63 = (fMatrix6x6.a61 * fMatrix6x62.a31) + (fMatrix6x6.a62 * fMatrix6x62.a32) + (fMatrix6x6.a63 * fMatrix6x62.a33) + (fMatrix6x6.a64 * fMatrix6x62.a34) + (fMatrix6x6.a65 * fMatrix6x62.a35) + (fMatrix6x6.a66 * fMatrix6x62.a36);
        fMatrix6x63.a64 = (fMatrix6x6.a61 * fMatrix6x62.a41) + (fMatrix6x6.a62 * fMatrix6x62.a42) + (fMatrix6x6.a63 * fMatrix6x62.a43) + (fMatrix6x6.a64 * fMatrix6x62.a44) + (fMatrix6x6.a65 * fMatrix6x62.a45) + (fMatrix6x6.a66 * fMatrix6x62.a46);
        fMatrix6x63.a65 = (fMatrix6x6.a61 * fMatrix6x62.a51) + (fMatrix6x6.a62 * fMatrix6x62.a52) + (fMatrix6x6.a63 * fMatrix6x62.a53) + (fMatrix6x6.a64 * fMatrix6x62.a54) + (fMatrix6x6.a65 * fMatrix6x62.a55) + (fMatrix6x6.a66 * fMatrix6x62.a56);
        fMatrix6x63.a66 = (fMatrix6x6.a61 * fMatrix6x62.a61) + (fMatrix6x6.a62 * fMatrix6x62.a62) + (fMatrix6x6.a63 * fMatrix6x62.a63) + (fMatrix6x6.a64 * fMatrix6x62.a64) + (fMatrix6x6.a65 * fMatrix6x62.a65) + (fMatrix6x6.a66 * fMatrix6x62.a66);
    }

    public static void multAdd(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62, FMatrix6x6 fMatrix6x63) {
        fMatrix6x63.a11 += (fMatrix6x6.a11 * fMatrix6x62.a11) + (fMatrix6x6.a12 * fMatrix6x62.a21) + (fMatrix6x6.a13 * fMatrix6x62.a31) + (fMatrix6x6.a14 * fMatrix6x62.a41) + (fMatrix6x6.a15 * fMatrix6x62.a51) + (fMatrix6x6.a16 * fMatrix6x62.a61);
        fMatrix6x63.a12 += (fMatrix6x6.a11 * fMatrix6x62.a12) + (fMatrix6x6.a12 * fMatrix6x62.a22) + (fMatrix6x6.a13 * fMatrix6x62.a32) + (fMatrix6x6.a14 * fMatrix6x62.a42) + (fMatrix6x6.a15 * fMatrix6x62.a52) + (fMatrix6x6.a16 * fMatrix6x62.a62);
        fMatrix6x63.a13 += (fMatrix6x6.a11 * fMatrix6x62.a13) + (fMatrix6x6.a12 * fMatrix6x62.a23) + (fMatrix6x6.a13 * fMatrix6x62.a33) + (fMatrix6x6.a14 * fMatrix6x62.a43) + (fMatrix6x6.a15 * fMatrix6x62.a53) + (fMatrix6x6.a16 * fMatrix6x62.a63);
        fMatrix6x63.a14 += (fMatrix6x6.a11 * fMatrix6x62.a14) + (fMatrix6x6.a12 * fMatrix6x62.a24) + (fMatrix6x6.a13 * fMatrix6x62.a34) + (fMatrix6x6.a14 * fMatrix6x62.a44) + (fMatrix6x6.a15 * fMatrix6x62.a54) + (fMatrix6x6.a16 * fMatrix6x62.a64);
        fMatrix6x63.a15 += (fMatrix6x6.a11 * fMatrix6x62.a15) + (fMatrix6x6.a12 * fMatrix6x62.a25) + (fMatrix6x6.a13 * fMatrix6x62.a35) + (fMatrix6x6.a14 * fMatrix6x62.a45) + (fMatrix6x6.a15 * fMatrix6x62.a55) + (fMatrix6x6.a16 * fMatrix6x62.a65);
        fMatrix6x63.a16 += (fMatrix6x6.a11 * fMatrix6x62.a16) + (fMatrix6x6.a12 * fMatrix6x62.a26) + (fMatrix6x6.a13 * fMatrix6x62.a36) + (fMatrix6x6.a14 * fMatrix6x62.a46) + (fMatrix6x6.a15 * fMatrix6x62.a56) + (fMatrix6x6.a16 * fMatrix6x62.a66);
        fMatrix6x63.a21 += (fMatrix6x6.a21 * fMatrix6x62.a11) + (fMatrix6x6.a22 * fMatrix6x62.a21) + (fMatrix6x6.a23 * fMatrix6x62.a31) + (fMatrix6x6.a24 * fMatrix6x62.a41) + (fMatrix6x6.a25 * fMatrix6x62.a51) + (fMatrix6x6.a26 * fMatrix6x62.a61);
        fMatrix6x63.a22 += (fMatrix6x6.a21 * fMatrix6x62.a12) + (fMatrix6x6.a22 * fMatrix6x62.a22) + (fMatrix6x6.a23 * fMatrix6x62.a32) + (fMatrix6x6.a24 * fMatrix6x62.a42) + (fMatrix6x6.a25 * fMatrix6x62.a52) + (fMatrix6x6.a26 * fMatrix6x62.a62);
        fMatrix6x63.a23 += (fMatrix6x6.a21 * fMatrix6x62.a13) + (fMatrix6x6.a22 * fMatrix6x62.a23) + (fMatrix6x6.a23 * fMatrix6x62.a33) + (fMatrix6x6.a24 * fMatrix6x62.a43) + (fMatrix6x6.a25 * fMatrix6x62.a53) + (fMatrix6x6.a26 * fMatrix6x62.a63);
        fMatrix6x63.a24 += (fMatrix6x6.a21 * fMatrix6x62.a14) + (fMatrix6x6.a22 * fMatrix6x62.a24) + (fMatrix6x6.a23 * fMatrix6x62.a34) + (fMatrix6x6.a24 * fMatrix6x62.a44) + (fMatrix6x6.a25 * fMatrix6x62.a54) + (fMatrix6x6.a26 * fMatrix6x62.a64);
        fMatrix6x63.a25 += (fMatrix6x6.a21 * fMatrix6x62.a15) + (fMatrix6x6.a22 * fMatrix6x62.a25) + (fMatrix6x6.a23 * fMatrix6x62.a35) + (fMatrix6x6.a24 * fMatrix6x62.a45) + (fMatrix6x6.a25 * fMatrix6x62.a55) + (fMatrix6x6.a26 * fMatrix6x62.a65);
        fMatrix6x63.a26 += (fMatrix6x6.a21 * fMatrix6x62.a16) + (fMatrix6x6.a22 * fMatrix6x62.a26) + (fMatrix6x6.a23 * fMatrix6x62.a36) + (fMatrix6x6.a24 * fMatrix6x62.a46) + (fMatrix6x6.a25 * fMatrix6x62.a56) + (fMatrix6x6.a26 * fMatrix6x62.a66);
        fMatrix6x63.a31 += (fMatrix6x6.a31 * fMatrix6x62.a11) + (fMatrix6x6.a32 * fMatrix6x62.a21) + (fMatrix6x6.a33 * fMatrix6x62.a31) + (fMatrix6x6.a34 * fMatrix6x62.a41) + (fMatrix6x6.a35 * fMatrix6x62.a51) + (fMatrix6x6.a36 * fMatrix6x62.a61);
        fMatrix6x63.a32 += (fMatrix6x6.a31 * fMatrix6x62.a12) + (fMatrix6x6.a32 * fMatrix6x62.a22) + (fMatrix6x6.a33 * fMatrix6x62.a32) + (fMatrix6x6.a34 * fMatrix6x62.a42) + (fMatrix6x6.a35 * fMatrix6x62.a52) + (fMatrix6x6.a36 * fMatrix6x62.a62);
        fMatrix6x63.a33 += (fMatrix6x6.a31 * fMatrix6x62.a13) + (fMatrix6x6.a32 * fMatrix6x62.a23) + (fMatrix6x6.a33 * fMatrix6x62.a33) + (fMatrix6x6.a34 * fMatrix6x62.a43) + (fMatrix6x6.a35 * fMatrix6x62.a53) + (fMatrix6x6.a36 * fMatrix6x62.a63);
        fMatrix6x63.a34 += (fMatrix6x6.a31 * fMatrix6x62.a14) + (fMatrix6x6.a32 * fMatrix6x62.a24) + (fMatrix6x6.a33 * fMatrix6x62.a34) + (fMatrix6x6.a34 * fMatrix6x62.a44) + (fMatrix6x6.a35 * fMatrix6x62.a54) + (fMatrix6x6.a36 * fMatrix6x62.a64);
        fMatrix6x63.a35 += (fMatrix6x6.a31 * fMatrix6x62.a15) + (fMatrix6x6.a32 * fMatrix6x62.a25) + (fMatrix6x6.a33 * fMatrix6x62.a35) + (fMatrix6x6.a34 * fMatrix6x62.a45) + (fMatrix6x6.a35 * fMatrix6x62.a55) + (fMatrix6x6.a36 * fMatrix6x62.a65);
        fMatrix6x63.a36 += (fMatrix6x6.a31 * fMatrix6x62.a16) + (fMatrix6x6.a32 * fMatrix6x62.a26) + (fMatrix6x6.a33 * fMatrix6x62.a36) + (fMatrix6x6.a34 * fMatrix6x62.a46) + (fMatrix6x6.a35 * fMatrix6x62.a56) + (fMatrix6x6.a36 * fMatrix6x62.a66);
        fMatrix6x63.a41 += (fMatrix6x6.a41 * fMatrix6x62.a11) + (fMatrix6x6.a42 * fMatrix6x62.a21) + (fMatrix6x6.a43 * fMatrix6x62.a31) + (fMatrix6x6.a44 * fMatrix6x62.a41) + (fMatrix6x6.a45 * fMatrix6x62.a51) + (fMatrix6x6.a46 * fMatrix6x62.a61);
        fMatrix6x63.a42 += (fMatrix6x6.a41 * fMatrix6x62.a12) + (fMatrix6x6.a42 * fMatrix6x62.a22) + (fMatrix6x6.a43 * fMatrix6x62.a32) + (fMatrix6x6.a44 * fMatrix6x62.a42) + (fMatrix6x6.a45 * fMatrix6x62.a52) + (fMatrix6x6.a46 * fMatrix6x62.a62);
        fMatrix6x63.a43 += (fMatrix6x6.a41 * fMatrix6x62.a13) + (fMatrix6x6.a42 * fMatrix6x62.a23) + (fMatrix6x6.a43 * fMatrix6x62.a33) + (fMatrix6x6.a44 * fMatrix6x62.a43) + (fMatrix6x6.a45 * fMatrix6x62.a53) + (fMatrix6x6.a46 * fMatrix6x62.a63);
        fMatrix6x63.a44 += (fMatrix6x6.a41 * fMatrix6x62.a14) + (fMatrix6x6.a42 * fMatrix6x62.a24) + (fMatrix6x6.a43 * fMatrix6x62.a34) + (fMatrix6x6.a44 * fMatrix6x62.a44) + (fMatrix6x6.a45 * fMatrix6x62.a54) + (fMatrix6x6.a46 * fMatrix6x62.a64);
        fMatrix6x63.a45 += (fMatrix6x6.a41 * fMatrix6x62.a15) + (fMatrix6x6.a42 * fMatrix6x62.a25) + (fMatrix6x6.a43 * fMatrix6x62.a35) + (fMatrix6x6.a44 * fMatrix6x62.a45) + (fMatrix6x6.a45 * fMatrix6x62.a55) + (fMatrix6x6.a46 * fMatrix6x62.a65);
        fMatrix6x63.a46 += (fMatrix6x6.a41 * fMatrix6x62.a16) + (fMatrix6x6.a42 * fMatrix6x62.a26) + (fMatrix6x6.a43 * fMatrix6x62.a36) + (fMatrix6x6.a44 * fMatrix6x62.a46) + (fMatrix6x6.a45 * fMatrix6x62.a56) + (fMatrix6x6.a46 * fMatrix6x62.a66);
        fMatrix6x63.a51 += (fMatrix6x6.a51 * fMatrix6x62.a11) + (fMatrix6x6.a52 * fMatrix6x62.a21) + (fMatrix6x6.a53 * fMatrix6x62.a31) + (fMatrix6x6.a54 * fMatrix6x62.a41) + (fMatrix6x6.a55 * fMatrix6x62.a51) + (fMatrix6x6.a56 * fMatrix6x62.a61);
        fMatrix6x63.a52 += (fMatrix6x6.a51 * fMatrix6x62.a12) + (fMatrix6x6.a52 * fMatrix6x62.a22) + (fMatrix6x6.a53 * fMatrix6x62.a32) + (fMatrix6x6.a54 * fMatrix6x62.a42) + (fMatrix6x6.a55 * fMatrix6x62.a52) + (fMatrix6x6.a56 * fMatrix6x62.a62);
        fMatrix6x63.a53 += (fMatrix6x6.a51 * fMatrix6x62.a13) + (fMatrix6x6.a52 * fMatrix6x62.a23) + (fMatrix6x6.a53 * fMatrix6x62.a33) + (fMatrix6x6.a54 * fMatrix6x62.a43) + (fMatrix6x6.a55 * fMatrix6x62.a53) + (fMatrix6x6.a56 * fMatrix6x62.a63);
        fMatrix6x63.a54 += (fMatrix6x6.a51 * fMatrix6x62.a14) + (fMatrix6x6.a52 * fMatrix6x62.a24) + (fMatrix6x6.a53 * fMatrix6x62.a34) + (fMatrix6x6.a54 * fMatrix6x62.a44) + (fMatrix6x6.a55 * fMatrix6x62.a54) + (fMatrix6x6.a56 * fMatrix6x62.a64);
        fMatrix6x63.a55 += (fMatrix6x6.a51 * fMatrix6x62.a15) + (fMatrix6x6.a52 * fMatrix6x62.a25) + (fMatrix6x6.a53 * fMatrix6x62.a35) + (fMatrix6x6.a54 * fMatrix6x62.a45) + (fMatrix6x6.a55 * fMatrix6x62.a55) + (fMatrix6x6.a56 * fMatrix6x62.a65);
        fMatrix6x63.a56 += (fMatrix6x6.a51 * fMatrix6x62.a16) + (fMatrix6x6.a52 * fMatrix6x62.a26) + (fMatrix6x6.a53 * fMatrix6x62.a36) + (fMatrix6x6.a54 * fMatrix6x62.a46) + (fMatrix6x6.a55 * fMatrix6x62.a56) + (fMatrix6x6.a56 * fMatrix6x62.a66);
        fMatrix6x63.a61 += (fMatrix6x6.a61 * fMatrix6x62.a11) + (fMatrix6x6.a62 * fMatrix6x62.a21) + (fMatrix6x6.a63 * fMatrix6x62.a31) + (fMatrix6x6.a64 * fMatrix6x62.a41) + (fMatrix6x6.a65 * fMatrix6x62.a51) + (fMatrix6x6.a66 * fMatrix6x62.a61);
        fMatrix6x63.a62 += (fMatrix6x6.a61 * fMatrix6x62.a12) + (fMatrix6x6.a62 * fMatrix6x62.a22) + (fMatrix6x6.a63 * fMatrix6x62.a32) + (fMatrix6x6.a64 * fMatrix6x62.a42) + (fMatrix6x6.a65 * fMatrix6x62.a52) + (fMatrix6x6.a66 * fMatrix6x62.a62);
        fMatrix6x63.a63 += (fMatrix6x6.a61 * fMatrix6x62.a13) + (fMatrix6x6.a62 * fMatrix6x62.a23) + (fMatrix6x6.a63 * fMatrix6x62.a33) + (fMatrix6x6.a64 * fMatrix6x62.a43) + (fMatrix6x6.a65 * fMatrix6x62.a53) + (fMatrix6x6.a66 * fMatrix6x62.a63);
        fMatrix6x63.a64 += (fMatrix6x6.a61 * fMatrix6x62.a14) + (fMatrix6x6.a62 * fMatrix6x62.a24) + (fMatrix6x6.a63 * fMatrix6x62.a34) + (fMatrix6x6.a64 * fMatrix6x62.a44) + (fMatrix6x6.a65 * fMatrix6x62.a54) + (fMatrix6x6.a66 * fMatrix6x62.a64);
        fMatrix6x63.a65 += (fMatrix6x6.a61 * fMatrix6x62.a15) + (fMatrix6x6.a62 * fMatrix6x62.a25) + (fMatrix6x6.a63 * fMatrix6x62.a35) + (fMatrix6x6.a64 * fMatrix6x62.a45) + (fMatrix6x6.a65 * fMatrix6x62.a55) + (fMatrix6x6.a66 * fMatrix6x62.a65);
        fMatrix6x63.a66 += (fMatrix6x6.a61 * fMatrix6x62.a16) + (fMatrix6x6.a62 * fMatrix6x62.a26) + (fMatrix6x6.a63 * fMatrix6x62.a36) + (fMatrix6x6.a64 * fMatrix6x62.a46) + (fMatrix6x6.a65 * fMatrix6x62.a56) + (fMatrix6x6.a66 * fMatrix6x62.a66);
    }

    public static void multAddTransA(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62, FMatrix6x6 fMatrix6x63) {
        fMatrix6x63.a11 += (fMatrix6x6.a11 * fMatrix6x62.a11) + (fMatrix6x6.a21 * fMatrix6x62.a21) + (fMatrix6x6.a31 * fMatrix6x62.a31) + (fMatrix6x6.a41 * fMatrix6x62.a41) + (fMatrix6x6.a51 * fMatrix6x62.a51) + (fMatrix6x6.a61 * fMatrix6x62.a61);
        fMatrix6x63.a12 += (fMatrix6x6.a11 * fMatrix6x62.a12) + (fMatrix6x6.a21 * fMatrix6x62.a22) + (fMatrix6x6.a31 * fMatrix6x62.a32) + (fMatrix6x6.a41 * fMatrix6x62.a42) + (fMatrix6x6.a51 * fMatrix6x62.a52) + (fMatrix6x6.a61 * fMatrix6x62.a62);
        fMatrix6x63.a13 += (fMatrix6x6.a11 * fMatrix6x62.a13) + (fMatrix6x6.a21 * fMatrix6x62.a23) + (fMatrix6x6.a31 * fMatrix6x62.a33) + (fMatrix6x6.a41 * fMatrix6x62.a43) + (fMatrix6x6.a51 * fMatrix6x62.a53) + (fMatrix6x6.a61 * fMatrix6x62.a63);
        fMatrix6x63.a14 += (fMatrix6x6.a11 * fMatrix6x62.a14) + (fMatrix6x6.a21 * fMatrix6x62.a24) + (fMatrix6x6.a31 * fMatrix6x62.a34) + (fMatrix6x6.a41 * fMatrix6x62.a44) + (fMatrix6x6.a51 * fMatrix6x62.a54) + (fMatrix6x6.a61 * fMatrix6x62.a64);
        fMatrix6x63.a15 += (fMatrix6x6.a11 * fMatrix6x62.a15) + (fMatrix6x6.a21 * fMatrix6x62.a25) + (fMatrix6x6.a31 * fMatrix6x62.a35) + (fMatrix6x6.a41 * fMatrix6x62.a45) + (fMatrix6x6.a51 * fMatrix6x62.a55) + (fMatrix6x6.a61 * fMatrix6x62.a65);
        fMatrix6x63.a16 += (fMatrix6x6.a11 * fMatrix6x62.a16) + (fMatrix6x6.a21 * fMatrix6x62.a26) + (fMatrix6x6.a31 * fMatrix6x62.a36) + (fMatrix6x6.a41 * fMatrix6x62.a46) + (fMatrix6x6.a51 * fMatrix6x62.a56) + (fMatrix6x6.a61 * fMatrix6x62.a66);
        fMatrix6x63.a21 += (fMatrix6x6.a12 * fMatrix6x62.a11) + (fMatrix6x6.a22 * fMatrix6x62.a21) + (fMatrix6x6.a32 * fMatrix6x62.a31) + (fMatrix6x6.a42 * fMatrix6x62.a41) + (fMatrix6x6.a52 * fMatrix6x62.a51) + (fMatrix6x6.a62 * fMatrix6x62.a61);
        fMatrix6x63.a22 += (fMatrix6x6.a12 * fMatrix6x62.a12) + (fMatrix6x6.a22 * fMatrix6x62.a22) + (fMatrix6x6.a32 * fMatrix6x62.a32) + (fMatrix6x6.a42 * fMatrix6x62.a42) + (fMatrix6x6.a52 * fMatrix6x62.a52) + (fMatrix6x6.a62 * fMatrix6x62.a62);
        fMatrix6x63.a23 += (fMatrix6x6.a12 * fMatrix6x62.a13) + (fMatrix6x6.a22 * fMatrix6x62.a23) + (fMatrix6x6.a32 * fMatrix6x62.a33) + (fMatrix6x6.a42 * fMatrix6x62.a43) + (fMatrix6x6.a52 * fMatrix6x62.a53) + (fMatrix6x6.a62 * fMatrix6x62.a63);
        fMatrix6x63.a24 += (fMatrix6x6.a12 * fMatrix6x62.a14) + (fMatrix6x6.a22 * fMatrix6x62.a24) + (fMatrix6x6.a32 * fMatrix6x62.a34) + (fMatrix6x6.a42 * fMatrix6x62.a44) + (fMatrix6x6.a52 * fMatrix6x62.a54) + (fMatrix6x6.a62 * fMatrix6x62.a64);
        fMatrix6x63.a25 += (fMatrix6x6.a12 * fMatrix6x62.a15) + (fMatrix6x6.a22 * fMatrix6x62.a25) + (fMatrix6x6.a32 * fMatrix6x62.a35) + (fMatrix6x6.a42 * fMatrix6x62.a45) + (fMatrix6x6.a52 * fMatrix6x62.a55) + (fMatrix6x6.a62 * fMatrix6x62.a65);
        fMatrix6x63.a26 += (fMatrix6x6.a12 * fMatrix6x62.a16) + (fMatrix6x6.a22 * fMatrix6x62.a26) + (fMatrix6x6.a32 * fMatrix6x62.a36) + (fMatrix6x6.a42 * fMatrix6x62.a46) + (fMatrix6x6.a52 * fMatrix6x62.a56) + (fMatrix6x6.a62 * fMatrix6x62.a66);
        fMatrix6x63.a31 += (fMatrix6x6.a13 * fMatrix6x62.a11) + (fMatrix6x6.a23 * fMatrix6x62.a21) + (fMatrix6x6.a33 * fMatrix6x62.a31) + (fMatrix6x6.a43 * fMatrix6x62.a41) + (fMatrix6x6.a53 * fMatrix6x62.a51) + (fMatrix6x6.a63 * fMatrix6x62.a61);
        fMatrix6x63.a32 += (fMatrix6x6.a13 * fMatrix6x62.a12) + (fMatrix6x6.a23 * fMatrix6x62.a22) + (fMatrix6x6.a33 * fMatrix6x62.a32) + (fMatrix6x6.a43 * fMatrix6x62.a42) + (fMatrix6x6.a53 * fMatrix6x62.a52) + (fMatrix6x6.a63 * fMatrix6x62.a62);
        fMatrix6x63.a33 += (fMatrix6x6.a13 * fMatrix6x62.a13) + (fMatrix6x6.a23 * fMatrix6x62.a23) + (fMatrix6x6.a33 * fMatrix6x62.a33) + (fMatrix6x6.a43 * fMatrix6x62.a43) + (fMatrix6x6.a53 * fMatrix6x62.a53) + (fMatrix6x6.a63 * fMatrix6x62.a63);
        fMatrix6x63.a34 += (fMatrix6x6.a13 * fMatrix6x62.a14) + (fMatrix6x6.a23 * fMatrix6x62.a24) + (fMatrix6x6.a33 * fMatrix6x62.a34) + (fMatrix6x6.a43 * fMatrix6x62.a44) + (fMatrix6x6.a53 * fMatrix6x62.a54) + (fMatrix6x6.a63 * fMatrix6x62.a64);
        fMatrix6x63.a35 += (fMatrix6x6.a13 * fMatrix6x62.a15) + (fMatrix6x6.a23 * fMatrix6x62.a25) + (fMatrix6x6.a33 * fMatrix6x62.a35) + (fMatrix6x6.a43 * fMatrix6x62.a45) + (fMatrix6x6.a53 * fMatrix6x62.a55) + (fMatrix6x6.a63 * fMatrix6x62.a65);
        fMatrix6x63.a36 += (fMatrix6x6.a13 * fMatrix6x62.a16) + (fMatrix6x6.a23 * fMatrix6x62.a26) + (fMatrix6x6.a33 * fMatrix6x62.a36) + (fMatrix6x6.a43 * fMatrix6x62.a46) + (fMatrix6x6.a53 * fMatrix6x62.a56) + (fMatrix6x6.a63 * fMatrix6x62.a66);
        fMatrix6x63.a41 += (fMatrix6x6.a14 * fMatrix6x62.a11) + (fMatrix6x6.a24 * fMatrix6x62.a21) + (fMatrix6x6.a34 * fMatrix6x62.a31) + (fMatrix6x6.a44 * fMatrix6x62.a41) + (fMatrix6x6.a54 * fMatrix6x62.a51) + (fMatrix6x6.a64 * fMatrix6x62.a61);
        fMatrix6x63.a42 += (fMatrix6x6.a14 * fMatrix6x62.a12) + (fMatrix6x6.a24 * fMatrix6x62.a22) + (fMatrix6x6.a34 * fMatrix6x62.a32) + (fMatrix6x6.a44 * fMatrix6x62.a42) + (fMatrix6x6.a54 * fMatrix6x62.a52) + (fMatrix6x6.a64 * fMatrix6x62.a62);
        fMatrix6x63.a43 += (fMatrix6x6.a14 * fMatrix6x62.a13) + (fMatrix6x6.a24 * fMatrix6x62.a23) + (fMatrix6x6.a34 * fMatrix6x62.a33) + (fMatrix6x6.a44 * fMatrix6x62.a43) + (fMatrix6x6.a54 * fMatrix6x62.a53) + (fMatrix6x6.a64 * fMatrix6x62.a63);
        fMatrix6x63.a44 += (fMatrix6x6.a14 * fMatrix6x62.a14) + (fMatrix6x6.a24 * fMatrix6x62.a24) + (fMatrix6x6.a34 * fMatrix6x62.a34) + (fMatrix6x6.a44 * fMatrix6x62.a44) + (fMatrix6x6.a54 * fMatrix6x62.a54) + (fMatrix6x6.a64 * fMatrix6x62.a64);
        fMatrix6x63.a45 += (fMatrix6x6.a14 * fMatrix6x62.a15) + (fMatrix6x6.a24 * fMatrix6x62.a25) + (fMatrix6x6.a34 * fMatrix6x62.a35) + (fMatrix6x6.a44 * fMatrix6x62.a45) + (fMatrix6x6.a54 * fMatrix6x62.a55) + (fMatrix6x6.a64 * fMatrix6x62.a65);
        fMatrix6x63.a46 += (fMatrix6x6.a14 * fMatrix6x62.a16) + (fMatrix6x6.a24 * fMatrix6x62.a26) + (fMatrix6x6.a34 * fMatrix6x62.a36) + (fMatrix6x6.a44 * fMatrix6x62.a46) + (fMatrix6x6.a54 * fMatrix6x62.a56) + (fMatrix6x6.a64 * fMatrix6x62.a66);
        fMatrix6x63.a51 += (fMatrix6x6.a15 * fMatrix6x62.a11) + (fMatrix6x6.a25 * fMatrix6x62.a21) + (fMatrix6x6.a35 * fMatrix6x62.a31) + (fMatrix6x6.a45 * fMatrix6x62.a41) + (fMatrix6x6.a55 * fMatrix6x62.a51) + (fMatrix6x6.a65 * fMatrix6x62.a61);
        fMatrix6x63.a52 += (fMatrix6x6.a15 * fMatrix6x62.a12) + (fMatrix6x6.a25 * fMatrix6x62.a22) + (fMatrix6x6.a35 * fMatrix6x62.a32) + (fMatrix6x6.a45 * fMatrix6x62.a42) + (fMatrix6x6.a55 * fMatrix6x62.a52) + (fMatrix6x6.a65 * fMatrix6x62.a62);
        fMatrix6x63.a53 += (fMatrix6x6.a15 * fMatrix6x62.a13) + (fMatrix6x6.a25 * fMatrix6x62.a23) + (fMatrix6x6.a35 * fMatrix6x62.a33) + (fMatrix6x6.a45 * fMatrix6x62.a43) + (fMatrix6x6.a55 * fMatrix6x62.a53) + (fMatrix6x6.a65 * fMatrix6x62.a63);
        fMatrix6x63.a54 += (fMatrix6x6.a15 * fMatrix6x62.a14) + (fMatrix6x6.a25 * fMatrix6x62.a24) + (fMatrix6x6.a35 * fMatrix6x62.a34) + (fMatrix6x6.a45 * fMatrix6x62.a44) + (fMatrix6x6.a55 * fMatrix6x62.a54) + (fMatrix6x6.a65 * fMatrix6x62.a64);
        fMatrix6x63.a55 += (fMatrix6x6.a15 * fMatrix6x62.a15) + (fMatrix6x6.a25 * fMatrix6x62.a25) + (fMatrix6x6.a35 * fMatrix6x62.a35) + (fMatrix6x6.a45 * fMatrix6x62.a45) + (fMatrix6x6.a55 * fMatrix6x62.a55) + (fMatrix6x6.a65 * fMatrix6x62.a65);
        fMatrix6x63.a56 += (fMatrix6x6.a15 * fMatrix6x62.a16) + (fMatrix6x6.a25 * fMatrix6x62.a26) + (fMatrix6x6.a35 * fMatrix6x62.a36) + (fMatrix6x6.a45 * fMatrix6x62.a46) + (fMatrix6x6.a55 * fMatrix6x62.a56) + (fMatrix6x6.a65 * fMatrix6x62.a66);
        fMatrix6x63.a61 += (fMatrix6x6.a16 * fMatrix6x62.a11) + (fMatrix6x6.a26 * fMatrix6x62.a21) + (fMatrix6x6.a36 * fMatrix6x62.a31) + (fMatrix6x6.a46 * fMatrix6x62.a41) + (fMatrix6x6.a56 * fMatrix6x62.a51) + (fMatrix6x6.a66 * fMatrix6x62.a61);
        fMatrix6x63.a62 += (fMatrix6x6.a16 * fMatrix6x62.a12) + (fMatrix6x6.a26 * fMatrix6x62.a22) + (fMatrix6x6.a36 * fMatrix6x62.a32) + (fMatrix6x6.a46 * fMatrix6x62.a42) + (fMatrix6x6.a56 * fMatrix6x62.a52) + (fMatrix6x6.a66 * fMatrix6x62.a62);
        fMatrix6x63.a63 += (fMatrix6x6.a16 * fMatrix6x62.a13) + (fMatrix6x6.a26 * fMatrix6x62.a23) + (fMatrix6x6.a36 * fMatrix6x62.a33) + (fMatrix6x6.a46 * fMatrix6x62.a43) + (fMatrix6x6.a56 * fMatrix6x62.a53) + (fMatrix6x6.a66 * fMatrix6x62.a63);
        fMatrix6x63.a64 += (fMatrix6x6.a16 * fMatrix6x62.a14) + (fMatrix6x6.a26 * fMatrix6x62.a24) + (fMatrix6x6.a36 * fMatrix6x62.a34) + (fMatrix6x6.a46 * fMatrix6x62.a44) + (fMatrix6x6.a56 * fMatrix6x62.a54) + (fMatrix6x6.a66 * fMatrix6x62.a64);
        fMatrix6x63.a65 += (fMatrix6x6.a16 * fMatrix6x62.a15) + (fMatrix6x6.a26 * fMatrix6x62.a25) + (fMatrix6x6.a36 * fMatrix6x62.a35) + (fMatrix6x6.a46 * fMatrix6x62.a45) + (fMatrix6x6.a56 * fMatrix6x62.a55) + (fMatrix6x6.a66 * fMatrix6x62.a65);
        fMatrix6x63.a66 += (fMatrix6x6.a16 * fMatrix6x62.a16) + (fMatrix6x6.a26 * fMatrix6x62.a26) + (fMatrix6x6.a36 * fMatrix6x62.a36) + (fMatrix6x6.a46 * fMatrix6x62.a46) + (fMatrix6x6.a56 * fMatrix6x62.a56) + (fMatrix6x6.a66 * fMatrix6x62.a66);
    }

    public static void multAddTransAB(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62, FMatrix6x6 fMatrix6x63) {
        fMatrix6x63.a11 += (fMatrix6x6.a11 * fMatrix6x62.a11) + (fMatrix6x6.a21 * fMatrix6x62.a12) + (fMatrix6x6.a31 * fMatrix6x62.a13) + (fMatrix6x6.a41 * fMatrix6x62.a14) + (fMatrix6x6.a51 * fMatrix6x62.a15) + (fMatrix6x6.a61 * fMatrix6x62.a16);
        fMatrix6x63.a12 += (fMatrix6x6.a11 * fMatrix6x62.a21) + (fMatrix6x6.a21 * fMatrix6x62.a22) + (fMatrix6x6.a31 * fMatrix6x62.a23) + (fMatrix6x6.a41 * fMatrix6x62.a24) + (fMatrix6x6.a51 * fMatrix6x62.a25) + (fMatrix6x6.a61 * fMatrix6x62.a26);
        fMatrix6x63.a13 += (fMatrix6x6.a11 * fMatrix6x62.a31) + (fMatrix6x6.a21 * fMatrix6x62.a32) + (fMatrix6x6.a31 * fMatrix6x62.a33) + (fMatrix6x6.a41 * fMatrix6x62.a34) + (fMatrix6x6.a51 * fMatrix6x62.a35) + (fMatrix6x6.a61 * fMatrix6x62.a36);
        fMatrix6x63.a14 += (fMatrix6x6.a11 * fMatrix6x62.a41) + (fMatrix6x6.a21 * fMatrix6x62.a42) + (fMatrix6x6.a31 * fMatrix6x62.a43) + (fMatrix6x6.a41 * fMatrix6x62.a44) + (fMatrix6x6.a51 * fMatrix6x62.a45) + (fMatrix6x6.a61 * fMatrix6x62.a46);
        fMatrix6x63.a15 += (fMatrix6x6.a11 * fMatrix6x62.a51) + (fMatrix6x6.a21 * fMatrix6x62.a52) + (fMatrix6x6.a31 * fMatrix6x62.a53) + (fMatrix6x6.a41 * fMatrix6x62.a54) + (fMatrix6x6.a51 * fMatrix6x62.a55) + (fMatrix6x6.a61 * fMatrix6x62.a56);
        fMatrix6x63.a16 += (fMatrix6x6.a11 * fMatrix6x62.a61) + (fMatrix6x6.a21 * fMatrix6x62.a62) + (fMatrix6x6.a31 * fMatrix6x62.a63) + (fMatrix6x6.a41 * fMatrix6x62.a64) + (fMatrix6x6.a51 * fMatrix6x62.a65) + (fMatrix6x6.a61 * fMatrix6x62.a66);
        fMatrix6x63.a21 += (fMatrix6x6.a12 * fMatrix6x62.a11) + (fMatrix6x6.a22 * fMatrix6x62.a12) + (fMatrix6x6.a32 * fMatrix6x62.a13) + (fMatrix6x6.a42 * fMatrix6x62.a14) + (fMatrix6x6.a52 * fMatrix6x62.a15) + (fMatrix6x6.a62 * fMatrix6x62.a16);
        fMatrix6x63.a22 += (fMatrix6x6.a12 * fMatrix6x62.a21) + (fMatrix6x6.a22 * fMatrix6x62.a22) + (fMatrix6x6.a32 * fMatrix6x62.a23) + (fMatrix6x6.a42 * fMatrix6x62.a24) + (fMatrix6x6.a52 * fMatrix6x62.a25) + (fMatrix6x6.a62 * fMatrix6x62.a26);
        fMatrix6x63.a23 += (fMatrix6x6.a12 * fMatrix6x62.a31) + (fMatrix6x6.a22 * fMatrix6x62.a32) + (fMatrix6x6.a32 * fMatrix6x62.a33) + (fMatrix6x6.a42 * fMatrix6x62.a34) + (fMatrix6x6.a52 * fMatrix6x62.a35) + (fMatrix6x6.a62 * fMatrix6x62.a36);
        fMatrix6x63.a24 += (fMatrix6x6.a12 * fMatrix6x62.a41) + (fMatrix6x6.a22 * fMatrix6x62.a42) + (fMatrix6x6.a32 * fMatrix6x62.a43) + (fMatrix6x6.a42 * fMatrix6x62.a44) + (fMatrix6x6.a52 * fMatrix6x62.a45) + (fMatrix6x6.a62 * fMatrix6x62.a46);
        fMatrix6x63.a25 += (fMatrix6x6.a12 * fMatrix6x62.a51) + (fMatrix6x6.a22 * fMatrix6x62.a52) + (fMatrix6x6.a32 * fMatrix6x62.a53) + (fMatrix6x6.a42 * fMatrix6x62.a54) + (fMatrix6x6.a52 * fMatrix6x62.a55) + (fMatrix6x6.a62 * fMatrix6x62.a56);
        fMatrix6x63.a26 += (fMatrix6x6.a12 * fMatrix6x62.a61) + (fMatrix6x6.a22 * fMatrix6x62.a62) + (fMatrix6x6.a32 * fMatrix6x62.a63) + (fMatrix6x6.a42 * fMatrix6x62.a64) + (fMatrix6x6.a52 * fMatrix6x62.a65) + (fMatrix6x6.a62 * fMatrix6x62.a66);
        fMatrix6x63.a31 += (fMatrix6x6.a13 * fMatrix6x62.a11) + (fMatrix6x6.a23 * fMatrix6x62.a12) + (fMatrix6x6.a33 * fMatrix6x62.a13) + (fMatrix6x6.a43 * fMatrix6x62.a14) + (fMatrix6x6.a53 * fMatrix6x62.a15) + (fMatrix6x6.a63 * fMatrix6x62.a16);
        fMatrix6x63.a32 += (fMatrix6x6.a13 * fMatrix6x62.a21) + (fMatrix6x6.a23 * fMatrix6x62.a22) + (fMatrix6x6.a33 * fMatrix6x62.a23) + (fMatrix6x6.a43 * fMatrix6x62.a24) + (fMatrix6x6.a53 * fMatrix6x62.a25) + (fMatrix6x6.a63 * fMatrix6x62.a26);
        fMatrix6x63.a33 += (fMatrix6x6.a13 * fMatrix6x62.a31) + (fMatrix6x6.a23 * fMatrix6x62.a32) + (fMatrix6x6.a33 * fMatrix6x62.a33) + (fMatrix6x6.a43 * fMatrix6x62.a34) + (fMatrix6x6.a53 * fMatrix6x62.a35) + (fMatrix6x6.a63 * fMatrix6x62.a36);
        fMatrix6x63.a34 += (fMatrix6x6.a13 * fMatrix6x62.a41) + (fMatrix6x6.a23 * fMatrix6x62.a42) + (fMatrix6x6.a33 * fMatrix6x62.a43) + (fMatrix6x6.a43 * fMatrix6x62.a44) + (fMatrix6x6.a53 * fMatrix6x62.a45) + (fMatrix6x6.a63 * fMatrix6x62.a46);
        fMatrix6x63.a35 += (fMatrix6x6.a13 * fMatrix6x62.a51) + (fMatrix6x6.a23 * fMatrix6x62.a52) + (fMatrix6x6.a33 * fMatrix6x62.a53) + (fMatrix6x6.a43 * fMatrix6x62.a54) + (fMatrix6x6.a53 * fMatrix6x62.a55) + (fMatrix6x6.a63 * fMatrix6x62.a56);
        fMatrix6x63.a36 += (fMatrix6x6.a13 * fMatrix6x62.a61) + (fMatrix6x6.a23 * fMatrix6x62.a62) + (fMatrix6x6.a33 * fMatrix6x62.a63) + (fMatrix6x6.a43 * fMatrix6x62.a64) + (fMatrix6x6.a53 * fMatrix6x62.a65) + (fMatrix6x6.a63 * fMatrix6x62.a66);
        fMatrix6x63.a41 += (fMatrix6x6.a14 * fMatrix6x62.a11) + (fMatrix6x6.a24 * fMatrix6x62.a12) + (fMatrix6x6.a34 * fMatrix6x62.a13) + (fMatrix6x6.a44 * fMatrix6x62.a14) + (fMatrix6x6.a54 * fMatrix6x62.a15) + (fMatrix6x6.a64 * fMatrix6x62.a16);
        fMatrix6x63.a42 += (fMatrix6x6.a14 * fMatrix6x62.a21) + (fMatrix6x6.a24 * fMatrix6x62.a22) + (fMatrix6x6.a34 * fMatrix6x62.a23) + (fMatrix6x6.a44 * fMatrix6x62.a24) + (fMatrix6x6.a54 * fMatrix6x62.a25) + (fMatrix6x6.a64 * fMatrix6x62.a26);
        fMatrix6x63.a43 += (fMatrix6x6.a14 * fMatrix6x62.a31) + (fMatrix6x6.a24 * fMatrix6x62.a32) + (fMatrix6x6.a34 * fMatrix6x62.a33) + (fMatrix6x6.a44 * fMatrix6x62.a34) + (fMatrix6x6.a54 * fMatrix6x62.a35) + (fMatrix6x6.a64 * fMatrix6x62.a36);
        fMatrix6x63.a44 += (fMatrix6x6.a14 * fMatrix6x62.a41) + (fMatrix6x6.a24 * fMatrix6x62.a42) + (fMatrix6x6.a34 * fMatrix6x62.a43) + (fMatrix6x6.a44 * fMatrix6x62.a44) + (fMatrix6x6.a54 * fMatrix6x62.a45) + (fMatrix6x6.a64 * fMatrix6x62.a46);
        fMatrix6x63.a45 += (fMatrix6x6.a14 * fMatrix6x62.a51) + (fMatrix6x6.a24 * fMatrix6x62.a52) + (fMatrix6x6.a34 * fMatrix6x62.a53) + (fMatrix6x6.a44 * fMatrix6x62.a54) + (fMatrix6x6.a54 * fMatrix6x62.a55) + (fMatrix6x6.a64 * fMatrix6x62.a56);
        fMatrix6x63.a46 += (fMatrix6x6.a14 * fMatrix6x62.a61) + (fMatrix6x6.a24 * fMatrix6x62.a62) + (fMatrix6x6.a34 * fMatrix6x62.a63) + (fMatrix6x6.a44 * fMatrix6x62.a64) + (fMatrix6x6.a54 * fMatrix6x62.a65) + (fMatrix6x6.a64 * fMatrix6x62.a66);
        fMatrix6x63.a51 += (fMatrix6x6.a15 * fMatrix6x62.a11) + (fMatrix6x6.a25 * fMatrix6x62.a12) + (fMatrix6x6.a35 * fMatrix6x62.a13) + (fMatrix6x6.a45 * fMatrix6x62.a14) + (fMatrix6x6.a55 * fMatrix6x62.a15) + (fMatrix6x6.a65 * fMatrix6x62.a16);
        fMatrix6x63.a52 += (fMatrix6x6.a15 * fMatrix6x62.a21) + (fMatrix6x6.a25 * fMatrix6x62.a22) + (fMatrix6x6.a35 * fMatrix6x62.a23) + (fMatrix6x6.a45 * fMatrix6x62.a24) + (fMatrix6x6.a55 * fMatrix6x62.a25) + (fMatrix6x6.a65 * fMatrix6x62.a26);
        fMatrix6x63.a53 += (fMatrix6x6.a15 * fMatrix6x62.a31) + (fMatrix6x6.a25 * fMatrix6x62.a32) + (fMatrix6x6.a35 * fMatrix6x62.a33) + (fMatrix6x6.a45 * fMatrix6x62.a34) + (fMatrix6x6.a55 * fMatrix6x62.a35) + (fMatrix6x6.a65 * fMatrix6x62.a36);
        fMatrix6x63.a54 += (fMatrix6x6.a15 * fMatrix6x62.a41) + (fMatrix6x6.a25 * fMatrix6x62.a42) + (fMatrix6x6.a35 * fMatrix6x62.a43) + (fMatrix6x6.a45 * fMatrix6x62.a44) + (fMatrix6x6.a55 * fMatrix6x62.a45) + (fMatrix6x6.a65 * fMatrix6x62.a46);
        fMatrix6x63.a55 += (fMatrix6x6.a15 * fMatrix6x62.a51) + (fMatrix6x6.a25 * fMatrix6x62.a52) + (fMatrix6x6.a35 * fMatrix6x62.a53) + (fMatrix6x6.a45 * fMatrix6x62.a54) + (fMatrix6x6.a55 * fMatrix6x62.a55) + (fMatrix6x6.a65 * fMatrix6x62.a56);
        fMatrix6x63.a56 += (fMatrix6x6.a15 * fMatrix6x62.a61) + (fMatrix6x6.a25 * fMatrix6x62.a62) + (fMatrix6x6.a35 * fMatrix6x62.a63) + (fMatrix6x6.a45 * fMatrix6x62.a64) + (fMatrix6x6.a55 * fMatrix6x62.a65) + (fMatrix6x6.a65 * fMatrix6x62.a66);
        fMatrix6x63.a61 += (fMatrix6x6.a16 * fMatrix6x62.a11) + (fMatrix6x6.a26 * fMatrix6x62.a12) + (fMatrix6x6.a36 * fMatrix6x62.a13) + (fMatrix6x6.a46 * fMatrix6x62.a14) + (fMatrix6x6.a56 * fMatrix6x62.a15) + (fMatrix6x6.a66 * fMatrix6x62.a16);
        fMatrix6x63.a62 += (fMatrix6x6.a16 * fMatrix6x62.a21) + (fMatrix6x6.a26 * fMatrix6x62.a22) + (fMatrix6x6.a36 * fMatrix6x62.a23) + (fMatrix6x6.a46 * fMatrix6x62.a24) + (fMatrix6x6.a56 * fMatrix6x62.a25) + (fMatrix6x6.a66 * fMatrix6x62.a26);
        fMatrix6x63.a63 += (fMatrix6x6.a16 * fMatrix6x62.a31) + (fMatrix6x6.a26 * fMatrix6x62.a32) + (fMatrix6x6.a36 * fMatrix6x62.a33) + (fMatrix6x6.a46 * fMatrix6x62.a34) + (fMatrix6x6.a56 * fMatrix6x62.a35) + (fMatrix6x6.a66 * fMatrix6x62.a36);
        fMatrix6x63.a64 += (fMatrix6x6.a16 * fMatrix6x62.a41) + (fMatrix6x6.a26 * fMatrix6x62.a42) + (fMatrix6x6.a36 * fMatrix6x62.a43) + (fMatrix6x6.a46 * fMatrix6x62.a44) + (fMatrix6x6.a56 * fMatrix6x62.a45) + (fMatrix6x6.a66 * fMatrix6x62.a46);
        fMatrix6x63.a65 += (fMatrix6x6.a16 * fMatrix6x62.a51) + (fMatrix6x6.a26 * fMatrix6x62.a52) + (fMatrix6x6.a36 * fMatrix6x62.a53) + (fMatrix6x6.a46 * fMatrix6x62.a54) + (fMatrix6x6.a56 * fMatrix6x62.a55) + (fMatrix6x6.a66 * fMatrix6x62.a56);
        fMatrix6x63.a66 += (fMatrix6x6.a16 * fMatrix6x62.a61) + (fMatrix6x6.a26 * fMatrix6x62.a62) + (fMatrix6x6.a36 * fMatrix6x62.a63) + (fMatrix6x6.a46 * fMatrix6x62.a64) + (fMatrix6x6.a56 * fMatrix6x62.a65) + (fMatrix6x6.a66 * fMatrix6x62.a66);
    }

    public static void multAddTransB(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62, FMatrix6x6 fMatrix6x63) {
        fMatrix6x63.a11 += (fMatrix6x6.a11 * fMatrix6x62.a11) + (fMatrix6x6.a12 * fMatrix6x62.a12) + (fMatrix6x6.a13 * fMatrix6x62.a13) + (fMatrix6x6.a14 * fMatrix6x62.a14) + (fMatrix6x6.a15 * fMatrix6x62.a15) + (fMatrix6x6.a16 * fMatrix6x62.a16);
        fMatrix6x63.a12 += (fMatrix6x6.a11 * fMatrix6x62.a21) + (fMatrix6x6.a12 * fMatrix6x62.a22) + (fMatrix6x6.a13 * fMatrix6x62.a23) + (fMatrix6x6.a14 * fMatrix6x62.a24) + (fMatrix6x6.a15 * fMatrix6x62.a25) + (fMatrix6x6.a16 * fMatrix6x62.a26);
        fMatrix6x63.a13 += (fMatrix6x6.a11 * fMatrix6x62.a31) + (fMatrix6x6.a12 * fMatrix6x62.a32) + (fMatrix6x6.a13 * fMatrix6x62.a33) + (fMatrix6x6.a14 * fMatrix6x62.a34) + (fMatrix6x6.a15 * fMatrix6x62.a35) + (fMatrix6x6.a16 * fMatrix6x62.a36);
        fMatrix6x63.a14 += (fMatrix6x6.a11 * fMatrix6x62.a41) + (fMatrix6x6.a12 * fMatrix6x62.a42) + (fMatrix6x6.a13 * fMatrix6x62.a43) + (fMatrix6x6.a14 * fMatrix6x62.a44) + (fMatrix6x6.a15 * fMatrix6x62.a45) + (fMatrix6x6.a16 * fMatrix6x62.a46);
        fMatrix6x63.a15 += (fMatrix6x6.a11 * fMatrix6x62.a51) + (fMatrix6x6.a12 * fMatrix6x62.a52) + (fMatrix6x6.a13 * fMatrix6x62.a53) + (fMatrix6x6.a14 * fMatrix6x62.a54) + (fMatrix6x6.a15 * fMatrix6x62.a55) + (fMatrix6x6.a16 * fMatrix6x62.a56);
        fMatrix6x63.a16 += (fMatrix6x6.a11 * fMatrix6x62.a61) + (fMatrix6x6.a12 * fMatrix6x62.a62) + (fMatrix6x6.a13 * fMatrix6x62.a63) + (fMatrix6x6.a14 * fMatrix6x62.a64) + (fMatrix6x6.a15 * fMatrix6x62.a65) + (fMatrix6x6.a16 * fMatrix6x62.a66);
        fMatrix6x63.a21 += (fMatrix6x6.a21 * fMatrix6x62.a11) + (fMatrix6x6.a22 * fMatrix6x62.a12) + (fMatrix6x6.a23 * fMatrix6x62.a13) + (fMatrix6x6.a24 * fMatrix6x62.a14) + (fMatrix6x6.a25 * fMatrix6x62.a15) + (fMatrix6x6.a26 * fMatrix6x62.a16);
        fMatrix6x63.a22 += (fMatrix6x6.a21 * fMatrix6x62.a21) + (fMatrix6x6.a22 * fMatrix6x62.a22) + (fMatrix6x6.a23 * fMatrix6x62.a23) + (fMatrix6x6.a24 * fMatrix6x62.a24) + (fMatrix6x6.a25 * fMatrix6x62.a25) + (fMatrix6x6.a26 * fMatrix6x62.a26);
        fMatrix6x63.a23 += (fMatrix6x6.a21 * fMatrix6x62.a31) + (fMatrix6x6.a22 * fMatrix6x62.a32) + (fMatrix6x6.a23 * fMatrix6x62.a33) + (fMatrix6x6.a24 * fMatrix6x62.a34) + (fMatrix6x6.a25 * fMatrix6x62.a35) + (fMatrix6x6.a26 * fMatrix6x62.a36);
        fMatrix6x63.a24 += (fMatrix6x6.a21 * fMatrix6x62.a41) + (fMatrix6x6.a22 * fMatrix6x62.a42) + (fMatrix6x6.a23 * fMatrix6x62.a43) + (fMatrix6x6.a24 * fMatrix6x62.a44) + (fMatrix6x6.a25 * fMatrix6x62.a45) + (fMatrix6x6.a26 * fMatrix6x62.a46);
        fMatrix6x63.a25 += (fMatrix6x6.a21 * fMatrix6x62.a51) + (fMatrix6x6.a22 * fMatrix6x62.a52) + (fMatrix6x6.a23 * fMatrix6x62.a53) + (fMatrix6x6.a24 * fMatrix6x62.a54) + (fMatrix6x6.a25 * fMatrix6x62.a55) + (fMatrix6x6.a26 * fMatrix6x62.a56);
        fMatrix6x63.a26 += (fMatrix6x6.a21 * fMatrix6x62.a61) + (fMatrix6x6.a22 * fMatrix6x62.a62) + (fMatrix6x6.a23 * fMatrix6x62.a63) + (fMatrix6x6.a24 * fMatrix6x62.a64) + (fMatrix6x6.a25 * fMatrix6x62.a65) + (fMatrix6x6.a26 * fMatrix6x62.a66);
        fMatrix6x63.a31 += (fMatrix6x6.a31 * fMatrix6x62.a11) + (fMatrix6x6.a32 * fMatrix6x62.a12) + (fMatrix6x6.a33 * fMatrix6x62.a13) + (fMatrix6x6.a34 * fMatrix6x62.a14) + (fMatrix6x6.a35 * fMatrix6x62.a15) + (fMatrix6x6.a36 * fMatrix6x62.a16);
        fMatrix6x63.a32 += (fMatrix6x6.a31 * fMatrix6x62.a21) + (fMatrix6x6.a32 * fMatrix6x62.a22) + (fMatrix6x6.a33 * fMatrix6x62.a23) + (fMatrix6x6.a34 * fMatrix6x62.a24) + (fMatrix6x6.a35 * fMatrix6x62.a25) + (fMatrix6x6.a36 * fMatrix6x62.a26);
        fMatrix6x63.a33 += (fMatrix6x6.a31 * fMatrix6x62.a31) + (fMatrix6x6.a32 * fMatrix6x62.a32) + (fMatrix6x6.a33 * fMatrix6x62.a33) + (fMatrix6x6.a34 * fMatrix6x62.a34) + (fMatrix6x6.a35 * fMatrix6x62.a35) + (fMatrix6x6.a36 * fMatrix6x62.a36);
        fMatrix6x63.a34 += (fMatrix6x6.a31 * fMatrix6x62.a41) + (fMatrix6x6.a32 * fMatrix6x62.a42) + (fMatrix6x6.a33 * fMatrix6x62.a43) + (fMatrix6x6.a34 * fMatrix6x62.a44) + (fMatrix6x6.a35 * fMatrix6x62.a45) + (fMatrix6x6.a36 * fMatrix6x62.a46);
        fMatrix6x63.a35 += (fMatrix6x6.a31 * fMatrix6x62.a51) + (fMatrix6x6.a32 * fMatrix6x62.a52) + (fMatrix6x6.a33 * fMatrix6x62.a53) + (fMatrix6x6.a34 * fMatrix6x62.a54) + (fMatrix6x6.a35 * fMatrix6x62.a55) + (fMatrix6x6.a36 * fMatrix6x62.a56);
        fMatrix6x63.a36 += (fMatrix6x6.a31 * fMatrix6x62.a61) + (fMatrix6x6.a32 * fMatrix6x62.a62) + (fMatrix6x6.a33 * fMatrix6x62.a63) + (fMatrix6x6.a34 * fMatrix6x62.a64) + (fMatrix6x6.a35 * fMatrix6x62.a65) + (fMatrix6x6.a36 * fMatrix6x62.a66);
        fMatrix6x63.a41 += (fMatrix6x6.a41 * fMatrix6x62.a11) + (fMatrix6x6.a42 * fMatrix6x62.a12) + (fMatrix6x6.a43 * fMatrix6x62.a13) + (fMatrix6x6.a44 * fMatrix6x62.a14) + (fMatrix6x6.a45 * fMatrix6x62.a15) + (fMatrix6x6.a46 * fMatrix6x62.a16);
        fMatrix6x63.a42 += (fMatrix6x6.a41 * fMatrix6x62.a21) + (fMatrix6x6.a42 * fMatrix6x62.a22) + (fMatrix6x6.a43 * fMatrix6x62.a23) + (fMatrix6x6.a44 * fMatrix6x62.a24) + (fMatrix6x6.a45 * fMatrix6x62.a25) + (fMatrix6x6.a46 * fMatrix6x62.a26);
        fMatrix6x63.a43 += (fMatrix6x6.a41 * fMatrix6x62.a31) + (fMatrix6x6.a42 * fMatrix6x62.a32) + (fMatrix6x6.a43 * fMatrix6x62.a33) + (fMatrix6x6.a44 * fMatrix6x62.a34) + (fMatrix6x6.a45 * fMatrix6x62.a35) + (fMatrix6x6.a46 * fMatrix6x62.a36);
        fMatrix6x63.a44 += (fMatrix6x6.a41 * fMatrix6x62.a41) + (fMatrix6x6.a42 * fMatrix6x62.a42) + (fMatrix6x6.a43 * fMatrix6x62.a43) + (fMatrix6x6.a44 * fMatrix6x62.a44) + (fMatrix6x6.a45 * fMatrix6x62.a45) + (fMatrix6x6.a46 * fMatrix6x62.a46);
        fMatrix6x63.a45 += (fMatrix6x6.a41 * fMatrix6x62.a51) + (fMatrix6x6.a42 * fMatrix6x62.a52) + (fMatrix6x6.a43 * fMatrix6x62.a53) + (fMatrix6x6.a44 * fMatrix6x62.a54) + (fMatrix6x6.a45 * fMatrix6x62.a55) + (fMatrix6x6.a46 * fMatrix6x62.a56);
        fMatrix6x63.a46 += (fMatrix6x6.a41 * fMatrix6x62.a61) + (fMatrix6x6.a42 * fMatrix6x62.a62) + (fMatrix6x6.a43 * fMatrix6x62.a63) + (fMatrix6x6.a44 * fMatrix6x62.a64) + (fMatrix6x6.a45 * fMatrix6x62.a65) + (fMatrix6x6.a46 * fMatrix6x62.a66);
        fMatrix6x63.a51 += (fMatrix6x6.a51 * fMatrix6x62.a11) + (fMatrix6x6.a52 * fMatrix6x62.a12) + (fMatrix6x6.a53 * fMatrix6x62.a13) + (fMatrix6x6.a54 * fMatrix6x62.a14) + (fMatrix6x6.a55 * fMatrix6x62.a15) + (fMatrix6x6.a56 * fMatrix6x62.a16);
        fMatrix6x63.a52 += (fMatrix6x6.a51 * fMatrix6x62.a21) + (fMatrix6x6.a52 * fMatrix6x62.a22) + (fMatrix6x6.a53 * fMatrix6x62.a23) + (fMatrix6x6.a54 * fMatrix6x62.a24) + (fMatrix6x6.a55 * fMatrix6x62.a25) + (fMatrix6x6.a56 * fMatrix6x62.a26);
        fMatrix6x63.a53 += (fMatrix6x6.a51 * fMatrix6x62.a31) + (fMatrix6x6.a52 * fMatrix6x62.a32) + (fMatrix6x6.a53 * fMatrix6x62.a33) + (fMatrix6x6.a54 * fMatrix6x62.a34) + (fMatrix6x6.a55 * fMatrix6x62.a35) + (fMatrix6x6.a56 * fMatrix6x62.a36);
        fMatrix6x63.a54 += (fMatrix6x6.a51 * fMatrix6x62.a41) + (fMatrix6x6.a52 * fMatrix6x62.a42) + (fMatrix6x6.a53 * fMatrix6x62.a43) + (fMatrix6x6.a54 * fMatrix6x62.a44) + (fMatrix6x6.a55 * fMatrix6x62.a45) + (fMatrix6x6.a56 * fMatrix6x62.a46);
        fMatrix6x63.a55 += (fMatrix6x6.a51 * fMatrix6x62.a51) + (fMatrix6x6.a52 * fMatrix6x62.a52) + (fMatrix6x6.a53 * fMatrix6x62.a53) + (fMatrix6x6.a54 * fMatrix6x62.a54) + (fMatrix6x6.a55 * fMatrix6x62.a55) + (fMatrix6x6.a56 * fMatrix6x62.a56);
        fMatrix6x63.a56 += (fMatrix6x6.a51 * fMatrix6x62.a61) + (fMatrix6x6.a52 * fMatrix6x62.a62) + (fMatrix6x6.a53 * fMatrix6x62.a63) + (fMatrix6x6.a54 * fMatrix6x62.a64) + (fMatrix6x6.a55 * fMatrix6x62.a65) + (fMatrix6x6.a56 * fMatrix6x62.a66);
        fMatrix6x63.a61 += (fMatrix6x6.a61 * fMatrix6x62.a11) + (fMatrix6x6.a62 * fMatrix6x62.a12) + (fMatrix6x6.a63 * fMatrix6x62.a13) + (fMatrix6x6.a64 * fMatrix6x62.a14) + (fMatrix6x6.a65 * fMatrix6x62.a15) + (fMatrix6x6.a66 * fMatrix6x62.a16);
        fMatrix6x63.a62 += (fMatrix6x6.a61 * fMatrix6x62.a21) + (fMatrix6x6.a62 * fMatrix6x62.a22) + (fMatrix6x6.a63 * fMatrix6x62.a23) + (fMatrix6x6.a64 * fMatrix6x62.a24) + (fMatrix6x6.a65 * fMatrix6x62.a25) + (fMatrix6x6.a66 * fMatrix6x62.a26);
        fMatrix6x63.a63 += (fMatrix6x6.a61 * fMatrix6x62.a31) + (fMatrix6x6.a62 * fMatrix6x62.a32) + (fMatrix6x6.a63 * fMatrix6x62.a33) + (fMatrix6x6.a64 * fMatrix6x62.a34) + (fMatrix6x6.a65 * fMatrix6x62.a35) + (fMatrix6x6.a66 * fMatrix6x62.a36);
        fMatrix6x63.a64 += (fMatrix6x6.a61 * fMatrix6x62.a41) + (fMatrix6x6.a62 * fMatrix6x62.a42) + (fMatrix6x6.a63 * fMatrix6x62.a43) + (fMatrix6x6.a64 * fMatrix6x62.a44) + (fMatrix6x6.a65 * fMatrix6x62.a45) + (fMatrix6x6.a66 * fMatrix6x62.a46);
        fMatrix6x63.a65 += (fMatrix6x6.a61 * fMatrix6x62.a51) + (fMatrix6x6.a62 * fMatrix6x62.a52) + (fMatrix6x6.a63 * fMatrix6x62.a53) + (fMatrix6x6.a64 * fMatrix6x62.a54) + (fMatrix6x6.a65 * fMatrix6x62.a55) + (fMatrix6x6.a66 * fMatrix6x62.a56);
        fMatrix6x63.a66 += (fMatrix6x6.a61 * fMatrix6x62.a61) + (fMatrix6x6.a62 * fMatrix6x62.a62) + (fMatrix6x6.a63 * fMatrix6x62.a63) + (fMatrix6x6.a64 * fMatrix6x62.a64) + (fMatrix6x6.a65 * fMatrix6x62.a65) + (fMatrix6x6.a66 * fMatrix6x62.a66);
    }

    public static void mult(FMatrix6x6 fMatrix6x6, FMatrix6 fMatrix6, FMatrix6 fMatrix62) {
        fMatrix62.f2432a1 = (fMatrix6x6.a11 * fMatrix6.f2432a1) + (fMatrix6x6.a12 * fMatrix6.f2433a2) + (fMatrix6x6.a13 * fMatrix6.f2434a3) + (fMatrix6x6.a14 * fMatrix6.f2435a4) + (fMatrix6x6.a15 * fMatrix6.f2436a5) + (fMatrix6x6.a16 * fMatrix6.f2437a6);
        fMatrix62.f2433a2 = (fMatrix6x6.a21 * fMatrix6.f2432a1) + (fMatrix6x6.a22 * fMatrix6.f2433a2) + (fMatrix6x6.a23 * fMatrix6.f2434a3) + (fMatrix6x6.a24 * fMatrix6.f2435a4) + (fMatrix6x6.a25 * fMatrix6.f2436a5) + (fMatrix6x6.a26 * fMatrix6.f2437a6);
        fMatrix62.f2434a3 = (fMatrix6x6.a31 * fMatrix6.f2432a1) + (fMatrix6x6.a32 * fMatrix6.f2433a2) + (fMatrix6x6.a33 * fMatrix6.f2434a3) + (fMatrix6x6.a34 * fMatrix6.f2435a4) + (fMatrix6x6.a35 * fMatrix6.f2436a5) + (fMatrix6x6.a36 * fMatrix6.f2437a6);
        fMatrix62.f2435a4 = (fMatrix6x6.a41 * fMatrix6.f2432a1) + (fMatrix6x6.a42 * fMatrix6.f2433a2) + (fMatrix6x6.a43 * fMatrix6.f2434a3) + (fMatrix6x6.a44 * fMatrix6.f2435a4) + (fMatrix6x6.a45 * fMatrix6.f2436a5) + (fMatrix6x6.a46 * fMatrix6.f2437a6);
        fMatrix62.f2436a5 = (fMatrix6x6.a51 * fMatrix6.f2432a1) + (fMatrix6x6.a52 * fMatrix6.f2433a2) + (fMatrix6x6.a53 * fMatrix6.f2434a3) + (fMatrix6x6.a54 * fMatrix6.f2435a4) + (fMatrix6x6.a55 * fMatrix6.f2436a5) + (fMatrix6x6.a56 * fMatrix6.f2437a6);
        fMatrix62.f2437a6 = (fMatrix6x6.a61 * fMatrix6.f2432a1) + (fMatrix6x6.a62 * fMatrix6.f2433a2) + (fMatrix6x6.a63 * fMatrix6.f2434a3) + (fMatrix6x6.a64 * fMatrix6.f2435a4) + (fMatrix6x6.a65 * fMatrix6.f2436a5) + (fMatrix6x6.a66 * fMatrix6.f2437a6);
    }

    public static void mult(FMatrix6 fMatrix6, FMatrix6x6 fMatrix6x6, FMatrix6 fMatrix62) {
        fMatrix62.f2432a1 = (fMatrix6.f2432a1 * fMatrix6x6.a11) + (fMatrix6.f2433a2 * fMatrix6x6.a21) + (fMatrix6.f2434a3 * fMatrix6x6.a31) + (fMatrix6.f2435a4 * fMatrix6x6.a41) + (fMatrix6.f2436a5 * fMatrix6x6.a51) + (fMatrix6.f2437a6 * fMatrix6x6.a61);
        fMatrix62.f2433a2 = (fMatrix6.f2432a1 * fMatrix6x6.a12) + (fMatrix6.f2433a2 * fMatrix6x6.a22) + (fMatrix6.f2434a3 * fMatrix6x6.a32) + (fMatrix6.f2435a4 * fMatrix6x6.a42) + (fMatrix6.f2436a5 * fMatrix6x6.a52) + (fMatrix6.f2437a6 * fMatrix6x6.a62);
        fMatrix62.f2434a3 = (fMatrix6.f2432a1 * fMatrix6x6.a13) + (fMatrix6.f2433a2 * fMatrix6x6.a23) + (fMatrix6.f2434a3 * fMatrix6x6.a33) + (fMatrix6.f2435a4 * fMatrix6x6.a43) + (fMatrix6.f2436a5 * fMatrix6x6.a53) + (fMatrix6.f2437a6 * fMatrix6x6.a63);
        fMatrix62.f2435a4 = (fMatrix6.f2432a1 * fMatrix6x6.a14) + (fMatrix6.f2433a2 * fMatrix6x6.a24) + (fMatrix6.f2434a3 * fMatrix6x6.a34) + (fMatrix6.f2435a4 * fMatrix6x6.a44) + (fMatrix6.f2436a5 * fMatrix6x6.a54) + (fMatrix6.f2437a6 * fMatrix6x6.a64);
        fMatrix62.f2436a5 = (fMatrix6.f2432a1 * fMatrix6x6.a15) + (fMatrix6.f2433a2 * fMatrix6x6.a25) + (fMatrix6.f2434a3 * fMatrix6x6.a35) + (fMatrix6.f2435a4 * fMatrix6x6.a45) + (fMatrix6.f2436a5 * fMatrix6x6.a55) + (fMatrix6.f2437a6 * fMatrix6x6.a65);
        fMatrix62.f2437a6 = (fMatrix6.f2432a1 * fMatrix6x6.a16) + (fMatrix6.f2433a2 * fMatrix6x6.a26) + (fMatrix6.f2434a3 * fMatrix6x6.a36) + (fMatrix6.f2435a4 * fMatrix6x6.a46) + (fMatrix6.f2436a5 * fMatrix6x6.a56) + (fMatrix6.f2437a6 * fMatrix6x6.a66);
    }

    public static float dot(FMatrix6 fMatrix6, FMatrix6 fMatrix62) {
        return (fMatrix6.f2432a1 * fMatrix62.f2432a1) + (fMatrix6.f2433a2 * fMatrix62.f2433a2) + (fMatrix6.f2434a3 * fMatrix62.f2434a3) + (fMatrix6.f2435a4 * fMatrix62.f2435a4) + (fMatrix6.f2436a5 * fMatrix62.f2436a5) + (fMatrix6.f2437a6 * fMatrix62.f2437a6);
    }

    public static void setIdentity(FMatrix6x6 fMatrix6x6) {
        fMatrix6x6.a11 = 1.0f;
        fMatrix6x6.a21 = 0.0f;
        fMatrix6x6.a31 = 0.0f;
        fMatrix6x6.a41 = 0.0f;
        fMatrix6x6.a51 = 0.0f;
        fMatrix6x6.a61 = 0.0f;
        fMatrix6x6.a12 = 0.0f;
        fMatrix6x6.a22 = 1.0f;
        fMatrix6x6.a32 = 0.0f;
        fMatrix6x6.a42 = 0.0f;
        fMatrix6x6.a52 = 0.0f;
        fMatrix6x6.a62 = 0.0f;
        fMatrix6x6.a13 = 0.0f;
        fMatrix6x6.a23 = 0.0f;
        fMatrix6x6.a33 = 1.0f;
        fMatrix6x6.a43 = 0.0f;
        fMatrix6x6.a53 = 0.0f;
        fMatrix6x6.a63 = 0.0f;
        fMatrix6x6.a14 = 0.0f;
        fMatrix6x6.a24 = 0.0f;
        fMatrix6x6.a34 = 0.0f;
        fMatrix6x6.a44 = 1.0f;
        fMatrix6x6.a54 = 0.0f;
        fMatrix6x6.a64 = 0.0f;
        fMatrix6x6.a15 = 0.0f;
        fMatrix6x6.a25 = 0.0f;
        fMatrix6x6.a35 = 0.0f;
        fMatrix6x6.a45 = 0.0f;
        fMatrix6x6.a55 = 1.0f;
        fMatrix6x6.a65 = 0.0f;
        fMatrix6x6.a16 = 0.0f;
        fMatrix6x6.a26 = 0.0f;
        fMatrix6x6.a36 = 0.0f;
        fMatrix6x6.a46 = 0.0f;
        fMatrix6x6.a56 = 0.0f;
        fMatrix6x6.a66 = 1.0f;
    }

    public static float trace(FMatrix6x6 fMatrix6x6) {
        return fMatrix6x6.a11 + fMatrix6x6.a22 + fMatrix6x6.a33 + fMatrix6x6.a44 + fMatrix6x6.a55 + fMatrix6x6.a66;
    }

    public static void diag(FMatrix6x6 fMatrix6x6, FMatrix6 fMatrix6) {
        fMatrix6.f2432a1 = fMatrix6x6.a11;
        fMatrix6.f2433a2 = fMatrix6x6.a22;
        fMatrix6.f2434a3 = fMatrix6x6.a33;
        fMatrix6.f2435a4 = fMatrix6x6.a44;
        fMatrix6.f2436a5 = fMatrix6x6.a55;
        fMatrix6.f2437a6 = fMatrix6x6.a66;
    }

    public static float elementMax(FMatrix6x6 fMatrix6x6) {
        float f = fMatrix6x6.a11;
        if (fMatrix6x6.a12 > f) {
            f = fMatrix6x6.a12;
        }
        if (fMatrix6x6.a13 > f) {
            f = fMatrix6x6.a13;
        }
        if (fMatrix6x6.a14 > f) {
            f = fMatrix6x6.a14;
        }
        if (fMatrix6x6.a15 > f) {
            f = fMatrix6x6.a15;
        }
        if (fMatrix6x6.a16 > f) {
            f = fMatrix6x6.a16;
        }
        if (fMatrix6x6.a21 > f) {
            f = fMatrix6x6.a21;
        }
        if (fMatrix6x6.a22 > f) {
            f = fMatrix6x6.a22;
        }
        if (fMatrix6x6.a23 > f) {
            f = fMatrix6x6.a23;
        }
        if (fMatrix6x6.a24 > f) {
            f = fMatrix6x6.a24;
        }
        if (fMatrix6x6.a25 > f) {
            f = fMatrix6x6.a25;
        }
        if (fMatrix6x6.a26 > f) {
            f = fMatrix6x6.a26;
        }
        if (fMatrix6x6.a31 > f) {
            f = fMatrix6x6.a31;
        }
        if (fMatrix6x6.a32 > f) {
            f = fMatrix6x6.a32;
        }
        if (fMatrix6x6.a33 > f) {
            f = fMatrix6x6.a33;
        }
        if (fMatrix6x6.a34 > f) {
            f = fMatrix6x6.a34;
        }
        if (fMatrix6x6.a35 > f) {
            f = fMatrix6x6.a35;
        }
        if (fMatrix6x6.a36 > f) {
            f = fMatrix6x6.a36;
        }
        if (fMatrix6x6.a41 > f) {
            f = fMatrix6x6.a41;
        }
        if (fMatrix6x6.a42 > f) {
            f = fMatrix6x6.a42;
        }
        if (fMatrix6x6.a43 > f) {
            f = fMatrix6x6.a43;
        }
        if (fMatrix6x6.a44 > f) {
            f = fMatrix6x6.a44;
        }
        if (fMatrix6x6.a45 > f) {
            f = fMatrix6x6.a45;
        }
        if (fMatrix6x6.a46 > f) {
            f = fMatrix6x6.a46;
        }
        if (fMatrix6x6.a51 > f) {
            f = fMatrix6x6.a51;
        }
        if (fMatrix6x6.a52 > f) {
            f = fMatrix6x6.a52;
        }
        if (fMatrix6x6.a53 > f) {
            f = fMatrix6x6.a53;
        }
        if (fMatrix6x6.a54 > f) {
            f = fMatrix6x6.a54;
        }
        if (fMatrix6x6.a55 > f) {
            f = fMatrix6x6.a55;
        }
        if (fMatrix6x6.a56 > f) {
            f = fMatrix6x6.a56;
        }
        if (fMatrix6x6.a61 > f) {
            f = fMatrix6x6.a61;
        }
        if (fMatrix6x6.a62 > f) {
            f = fMatrix6x6.a62;
        }
        if (fMatrix6x6.a63 > f) {
            f = fMatrix6x6.a63;
        }
        if (fMatrix6x6.a64 > f) {
            f = fMatrix6x6.a64;
        }
        if (fMatrix6x6.a65 > f) {
            f = fMatrix6x6.a65;
        }
        return fMatrix6x6.a66 > f ? fMatrix6x6.a66 : f;
    }

    public static float elementMax(FMatrix6 fMatrix6) {
        float f = fMatrix6.f2432a1;
        if (fMatrix6.f2433a2 > f) {
            f = fMatrix6.f2433a2;
        }
        if (fMatrix6.f2434a3 > f) {
            f = fMatrix6.f2434a3;
        }
        if (fMatrix6.f2435a4 > f) {
            f = fMatrix6.f2435a4;
        }
        if (fMatrix6.f2436a5 > f) {
            f = fMatrix6.f2436a5;
        }
        return fMatrix6.f2437a6 > f ? fMatrix6.f2437a6 : f;
    }

    public static float elementMaxAbs(FMatrix6x6 fMatrix6x6) {
        float fAbs = Math.abs(fMatrix6x6.a11);
        float fAbs2 = Math.abs(fMatrix6x6.a12);
        if (fAbs2 > fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix6x6.a13);
        if (fAbs3 > fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix6x6.a14);
        if (fAbs4 > fAbs) {
            fAbs = fAbs4;
        }
        float fAbs5 = Math.abs(fMatrix6x6.a15);
        if (fAbs5 > fAbs) {
            fAbs = fAbs5;
        }
        float fAbs6 = Math.abs(fMatrix6x6.a16);
        if (fAbs6 > fAbs) {
            fAbs = fAbs6;
        }
        float fAbs7 = Math.abs(fMatrix6x6.a21);
        if (fAbs7 > fAbs) {
            fAbs = fAbs7;
        }
        float fAbs8 = Math.abs(fMatrix6x6.a22);
        if (fAbs8 > fAbs) {
            fAbs = fAbs8;
        }
        float fAbs9 = Math.abs(fMatrix6x6.a23);
        if (fAbs9 > fAbs) {
            fAbs = fAbs9;
        }
        float fAbs10 = Math.abs(fMatrix6x6.a24);
        if (fAbs10 > fAbs) {
            fAbs = fAbs10;
        }
        float fAbs11 = Math.abs(fMatrix6x6.a25);
        if (fAbs11 > fAbs) {
            fAbs = fAbs11;
        }
        float fAbs12 = Math.abs(fMatrix6x6.a26);
        if (fAbs12 > fAbs) {
            fAbs = fAbs12;
        }
        float fAbs13 = Math.abs(fMatrix6x6.a31);
        if (fAbs13 > fAbs) {
            fAbs = fAbs13;
        }
        float fAbs14 = Math.abs(fMatrix6x6.a32);
        if (fAbs14 > fAbs) {
            fAbs = fAbs14;
        }
        float fAbs15 = Math.abs(fMatrix6x6.a33);
        if (fAbs15 > fAbs) {
            fAbs = fAbs15;
        }
        float fAbs16 = Math.abs(fMatrix6x6.a34);
        if (fAbs16 > fAbs) {
            fAbs = fAbs16;
        }
        float fAbs17 = Math.abs(fMatrix6x6.a35);
        if (fAbs17 > fAbs) {
            fAbs = fAbs17;
        }
        float fAbs18 = Math.abs(fMatrix6x6.a36);
        if (fAbs18 > fAbs) {
            fAbs = fAbs18;
        }
        float fAbs19 = Math.abs(fMatrix6x6.a41);
        if (fAbs19 > fAbs) {
            fAbs = fAbs19;
        }
        float fAbs20 = Math.abs(fMatrix6x6.a42);
        if (fAbs20 > fAbs) {
            fAbs = fAbs20;
        }
        float fAbs21 = Math.abs(fMatrix6x6.a43);
        if (fAbs21 > fAbs) {
            fAbs = fAbs21;
        }
        float fAbs22 = Math.abs(fMatrix6x6.a44);
        if (fAbs22 > fAbs) {
            fAbs = fAbs22;
        }
        float fAbs23 = Math.abs(fMatrix6x6.a45);
        if (fAbs23 > fAbs) {
            fAbs = fAbs23;
        }
        float fAbs24 = Math.abs(fMatrix6x6.a46);
        if (fAbs24 > fAbs) {
            fAbs = fAbs24;
        }
        float fAbs25 = Math.abs(fMatrix6x6.a51);
        if (fAbs25 > fAbs) {
            fAbs = fAbs25;
        }
        float fAbs26 = Math.abs(fMatrix6x6.a52);
        if (fAbs26 > fAbs) {
            fAbs = fAbs26;
        }
        float fAbs27 = Math.abs(fMatrix6x6.a53);
        if (fAbs27 > fAbs) {
            fAbs = fAbs27;
        }
        float fAbs28 = Math.abs(fMatrix6x6.a54);
        if (fAbs28 > fAbs) {
            fAbs = fAbs28;
        }
        float fAbs29 = Math.abs(fMatrix6x6.a55);
        if (fAbs29 > fAbs) {
            fAbs = fAbs29;
        }
        float fAbs30 = Math.abs(fMatrix6x6.a56);
        if (fAbs30 > fAbs) {
            fAbs = fAbs30;
        }
        float fAbs31 = Math.abs(fMatrix6x6.a61);
        if (fAbs31 > fAbs) {
            fAbs = fAbs31;
        }
        float fAbs32 = Math.abs(fMatrix6x6.a62);
        if (fAbs32 > fAbs) {
            fAbs = fAbs32;
        }
        float fAbs33 = Math.abs(fMatrix6x6.a63);
        if (fAbs33 > fAbs) {
            fAbs = fAbs33;
        }
        float fAbs34 = Math.abs(fMatrix6x6.a64);
        if (fAbs34 > fAbs) {
            fAbs = fAbs34;
        }
        float fAbs35 = Math.abs(fMatrix6x6.a65);
        if (fAbs35 > fAbs) {
            fAbs = fAbs35;
        }
        float fAbs36 = Math.abs(fMatrix6x6.a66);
        return fAbs36 > fAbs ? fAbs36 : fAbs;
    }

    public static float elementMaxAbs(FMatrix6 fMatrix6) {
        float fAbs = Math.abs(fMatrix6.f2432a1);
        float fAbs2 = Math.abs(fMatrix6.f2433a2);
        if (fAbs2 > fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix6.f2433a2);
        if (fAbs3 > fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix6.f2434a3);
        if (fAbs4 > fAbs) {
            fAbs = fAbs4;
        }
        float fAbs5 = Math.abs(fMatrix6.f2435a4);
        if (fAbs5 > fAbs) {
            fAbs = fAbs5;
        }
        float fAbs6 = Math.abs(fMatrix6.f2436a5);
        if (fAbs6 > fAbs) {
            fAbs = fAbs6;
        }
        float fAbs7 = Math.abs(fMatrix6.f2437a6);
        return fAbs7 > fAbs ? fAbs7 : fAbs;
    }

    public static float elementMin(FMatrix6x6 fMatrix6x6) {
        float f = fMatrix6x6.a11;
        if (fMatrix6x6.a12 < f) {
            f = fMatrix6x6.a12;
        }
        if (fMatrix6x6.a13 < f) {
            f = fMatrix6x6.a13;
        }
        if (fMatrix6x6.a14 < f) {
            f = fMatrix6x6.a14;
        }
        if (fMatrix6x6.a15 < f) {
            f = fMatrix6x6.a15;
        }
        if (fMatrix6x6.a16 < f) {
            f = fMatrix6x6.a16;
        }
        if (fMatrix6x6.a21 < f) {
            f = fMatrix6x6.a21;
        }
        if (fMatrix6x6.a22 < f) {
            f = fMatrix6x6.a22;
        }
        if (fMatrix6x6.a23 < f) {
            f = fMatrix6x6.a23;
        }
        if (fMatrix6x6.a24 < f) {
            f = fMatrix6x6.a24;
        }
        if (fMatrix6x6.a25 < f) {
            f = fMatrix6x6.a25;
        }
        if (fMatrix6x6.a26 < f) {
            f = fMatrix6x6.a26;
        }
        if (fMatrix6x6.a31 < f) {
            f = fMatrix6x6.a31;
        }
        if (fMatrix6x6.a32 < f) {
            f = fMatrix6x6.a32;
        }
        if (fMatrix6x6.a33 < f) {
            f = fMatrix6x6.a33;
        }
        if (fMatrix6x6.a34 < f) {
            f = fMatrix6x6.a34;
        }
        if (fMatrix6x6.a35 < f) {
            f = fMatrix6x6.a35;
        }
        if (fMatrix6x6.a36 < f) {
            f = fMatrix6x6.a36;
        }
        if (fMatrix6x6.a41 < f) {
            f = fMatrix6x6.a41;
        }
        if (fMatrix6x6.a42 < f) {
            f = fMatrix6x6.a42;
        }
        if (fMatrix6x6.a43 < f) {
            f = fMatrix6x6.a43;
        }
        if (fMatrix6x6.a44 < f) {
            f = fMatrix6x6.a44;
        }
        if (fMatrix6x6.a45 < f) {
            f = fMatrix6x6.a45;
        }
        if (fMatrix6x6.a46 < f) {
            f = fMatrix6x6.a46;
        }
        if (fMatrix6x6.a51 < f) {
            f = fMatrix6x6.a51;
        }
        if (fMatrix6x6.a52 < f) {
            f = fMatrix6x6.a52;
        }
        if (fMatrix6x6.a53 < f) {
            f = fMatrix6x6.a53;
        }
        if (fMatrix6x6.a54 < f) {
            f = fMatrix6x6.a54;
        }
        if (fMatrix6x6.a55 < f) {
            f = fMatrix6x6.a55;
        }
        if (fMatrix6x6.a56 < f) {
            f = fMatrix6x6.a56;
        }
        if (fMatrix6x6.a61 < f) {
            f = fMatrix6x6.a61;
        }
        if (fMatrix6x6.a62 < f) {
            f = fMatrix6x6.a62;
        }
        if (fMatrix6x6.a63 < f) {
            f = fMatrix6x6.a63;
        }
        if (fMatrix6x6.a64 < f) {
            f = fMatrix6x6.a64;
        }
        if (fMatrix6x6.a65 < f) {
            f = fMatrix6x6.a65;
        }
        return fMatrix6x6.a66 < f ? fMatrix6x6.a66 : f;
    }

    public static float elementMin(FMatrix6 fMatrix6) {
        float f = fMatrix6.f2432a1;
        if (fMatrix6.f2433a2 < f) {
            f = fMatrix6.f2433a2;
        }
        if (fMatrix6.f2434a3 < f) {
            f = fMatrix6.f2434a3;
        }
        if (fMatrix6.f2435a4 < f) {
            f = fMatrix6.f2435a4;
        }
        if (fMatrix6.f2436a5 < f) {
            f = fMatrix6.f2436a5;
        }
        return fMatrix6.f2437a6 < f ? fMatrix6.f2437a6 : f;
    }

    public static float elementMinAbs(FMatrix6x6 fMatrix6x6) {
        float fAbs = Math.abs(fMatrix6x6.a11);
        float fAbs2 = Math.abs(fMatrix6x6.a12);
        if (fAbs2 < fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix6x6.a13);
        if (fAbs3 < fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix6x6.a14);
        if (fAbs4 < fAbs) {
            fAbs = fAbs4;
        }
        float fAbs5 = Math.abs(fMatrix6x6.a15);
        if (fAbs5 < fAbs) {
            fAbs = fAbs5;
        }
        float fAbs6 = Math.abs(fMatrix6x6.a16);
        if (fAbs6 < fAbs) {
            fAbs = fAbs6;
        }
        float fAbs7 = Math.abs(fMatrix6x6.a21);
        if (fAbs7 < fAbs) {
            fAbs = fAbs7;
        }
        float fAbs8 = Math.abs(fMatrix6x6.a22);
        if (fAbs8 < fAbs) {
            fAbs = fAbs8;
        }
        float fAbs9 = Math.abs(fMatrix6x6.a23);
        if (fAbs9 < fAbs) {
            fAbs = fAbs9;
        }
        float fAbs10 = Math.abs(fMatrix6x6.a24);
        if (fAbs10 < fAbs) {
            fAbs = fAbs10;
        }
        float fAbs11 = Math.abs(fMatrix6x6.a25);
        if (fAbs11 < fAbs) {
            fAbs = fAbs11;
        }
        float fAbs12 = Math.abs(fMatrix6x6.a26);
        if (fAbs12 < fAbs) {
            fAbs = fAbs12;
        }
        float fAbs13 = Math.abs(fMatrix6x6.a31);
        if (fAbs13 < fAbs) {
            fAbs = fAbs13;
        }
        float fAbs14 = Math.abs(fMatrix6x6.a32);
        if (fAbs14 < fAbs) {
            fAbs = fAbs14;
        }
        float fAbs15 = Math.abs(fMatrix6x6.a33);
        if (fAbs15 < fAbs) {
            fAbs = fAbs15;
        }
        float fAbs16 = Math.abs(fMatrix6x6.a34);
        if (fAbs16 < fAbs) {
            fAbs = fAbs16;
        }
        float fAbs17 = Math.abs(fMatrix6x6.a35);
        if (fAbs17 < fAbs) {
            fAbs = fAbs17;
        }
        float fAbs18 = Math.abs(fMatrix6x6.a36);
        if (fAbs18 < fAbs) {
            fAbs = fAbs18;
        }
        float fAbs19 = Math.abs(fMatrix6x6.a41);
        if (fAbs19 < fAbs) {
            fAbs = fAbs19;
        }
        float fAbs20 = Math.abs(fMatrix6x6.a42);
        if (fAbs20 < fAbs) {
            fAbs = fAbs20;
        }
        float fAbs21 = Math.abs(fMatrix6x6.a43);
        if (fAbs21 < fAbs) {
            fAbs = fAbs21;
        }
        float fAbs22 = Math.abs(fMatrix6x6.a44);
        if (fAbs22 < fAbs) {
            fAbs = fAbs22;
        }
        float fAbs23 = Math.abs(fMatrix6x6.a45);
        if (fAbs23 < fAbs) {
            fAbs = fAbs23;
        }
        float fAbs24 = Math.abs(fMatrix6x6.a46);
        if (fAbs24 < fAbs) {
            fAbs = fAbs24;
        }
        float fAbs25 = Math.abs(fMatrix6x6.a51);
        if (fAbs25 < fAbs) {
            fAbs = fAbs25;
        }
        float fAbs26 = Math.abs(fMatrix6x6.a52);
        if (fAbs26 < fAbs) {
            fAbs = fAbs26;
        }
        float fAbs27 = Math.abs(fMatrix6x6.a53);
        if (fAbs27 < fAbs) {
            fAbs = fAbs27;
        }
        float fAbs28 = Math.abs(fMatrix6x6.a54);
        if (fAbs28 < fAbs) {
            fAbs = fAbs28;
        }
        float fAbs29 = Math.abs(fMatrix6x6.a55);
        if (fAbs29 < fAbs) {
            fAbs = fAbs29;
        }
        float fAbs30 = Math.abs(fMatrix6x6.a56);
        if (fAbs30 < fAbs) {
            fAbs = fAbs30;
        }
        float fAbs31 = Math.abs(fMatrix6x6.a61);
        if (fAbs31 < fAbs) {
            fAbs = fAbs31;
        }
        float fAbs32 = Math.abs(fMatrix6x6.a62);
        if (fAbs32 < fAbs) {
            fAbs = fAbs32;
        }
        float fAbs33 = Math.abs(fMatrix6x6.a63);
        if (fAbs33 < fAbs) {
            fAbs = fAbs33;
        }
        float fAbs34 = Math.abs(fMatrix6x6.a64);
        if (fAbs34 < fAbs) {
            fAbs = fAbs34;
        }
        float fAbs35 = Math.abs(fMatrix6x6.a65);
        if (fAbs35 < fAbs) {
            fAbs = fAbs35;
        }
        float fAbs36 = Math.abs(fMatrix6x6.a66);
        return fAbs36 < fAbs ? fAbs36 : fAbs;
    }

    public static float elementMinAbs(FMatrix6 fMatrix6) {
        float fAbs = Math.abs(fMatrix6.f2432a1);
        float fAbs2 = Math.abs(fMatrix6.f2432a1);
        if (fAbs2 < fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix6.f2433a2);
        if (fAbs3 < fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix6.f2434a3);
        if (fAbs4 < fAbs) {
            fAbs = fAbs4;
        }
        float fAbs5 = Math.abs(fMatrix6.f2435a4);
        if (fAbs5 < fAbs) {
            fAbs = fAbs5;
        }
        float fAbs6 = Math.abs(fMatrix6.f2436a5);
        if (fAbs6 < fAbs) {
            fAbs = fAbs6;
        }
        float fAbs7 = Math.abs(fMatrix6.f2437a6);
        return fAbs7 < fAbs ? fAbs7 : fAbs;
    }

    public static void elementMult(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62) {
        fMatrix6x6.a11 *= fMatrix6x62.a11;
        fMatrix6x6.a12 *= fMatrix6x62.a12;
        fMatrix6x6.a13 *= fMatrix6x62.a13;
        fMatrix6x6.a14 *= fMatrix6x62.a14;
        fMatrix6x6.a15 *= fMatrix6x62.a15;
        fMatrix6x6.a16 *= fMatrix6x62.a16;
        fMatrix6x6.a21 *= fMatrix6x62.a21;
        fMatrix6x6.a22 *= fMatrix6x62.a22;
        fMatrix6x6.a23 *= fMatrix6x62.a23;
        fMatrix6x6.a24 *= fMatrix6x62.a24;
        fMatrix6x6.a25 *= fMatrix6x62.a25;
        fMatrix6x6.a26 *= fMatrix6x62.a26;
        fMatrix6x6.a31 *= fMatrix6x62.a31;
        fMatrix6x6.a32 *= fMatrix6x62.a32;
        fMatrix6x6.a33 *= fMatrix6x62.a33;
        fMatrix6x6.a34 *= fMatrix6x62.a34;
        fMatrix6x6.a35 *= fMatrix6x62.a35;
        fMatrix6x6.a36 *= fMatrix6x62.a36;
        fMatrix6x6.a41 *= fMatrix6x62.a41;
        fMatrix6x6.a42 *= fMatrix6x62.a42;
        fMatrix6x6.a43 *= fMatrix6x62.a43;
        fMatrix6x6.a44 *= fMatrix6x62.a44;
        fMatrix6x6.a45 *= fMatrix6x62.a45;
        fMatrix6x6.a46 *= fMatrix6x62.a46;
        fMatrix6x6.a51 *= fMatrix6x62.a51;
        fMatrix6x6.a52 *= fMatrix6x62.a52;
        fMatrix6x6.a53 *= fMatrix6x62.a53;
        fMatrix6x6.a54 *= fMatrix6x62.a54;
        fMatrix6x6.a55 *= fMatrix6x62.a55;
        fMatrix6x6.a56 *= fMatrix6x62.a56;
        fMatrix6x6.a61 *= fMatrix6x62.a61;
        fMatrix6x6.a62 *= fMatrix6x62.a62;
        fMatrix6x6.a63 *= fMatrix6x62.a63;
        fMatrix6x6.a64 *= fMatrix6x62.a64;
        fMatrix6x6.a65 *= fMatrix6x62.a65;
        fMatrix6x6.a66 *= fMatrix6x62.a66;
    }

    public static void elementMult(FMatrix6 fMatrix6, FMatrix6 fMatrix62) {
        fMatrix6.f2432a1 *= fMatrix62.f2432a1;
        fMatrix6.f2433a2 *= fMatrix62.f2433a2;
        fMatrix6.f2434a3 *= fMatrix62.f2434a3;
        fMatrix6.f2435a4 *= fMatrix62.f2435a4;
        fMatrix6.f2436a5 *= fMatrix62.f2436a5;
        fMatrix6.f2437a6 *= fMatrix62.f2437a6;
    }

    public static void elementMult(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62, FMatrix6x6 fMatrix6x63) {
        fMatrix6x63.a11 = fMatrix6x6.a11 * fMatrix6x62.a11;
        fMatrix6x63.a12 = fMatrix6x6.a12 * fMatrix6x62.a12;
        fMatrix6x63.a13 = fMatrix6x6.a13 * fMatrix6x62.a13;
        fMatrix6x63.a14 = fMatrix6x6.a14 * fMatrix6x62.a14;
        fMatrix6x63.a15 = fMatrix6x6.a15 * fMatrix6x62.a15;
        fMatrix6x63.a16 = fMatrix6x6.a16 * fMatrix6x62.a16;
        fMatrix6x63.a21 = fMatrix6x6.a21 * fMatrix6x62.a21;
        fMatrix6x63.a22 = fMatrix6x6.a22 * fMatrix6x62.a22;
        fMatrix6x63.a23 = fMatrix6x6.a23 * fMatrix6x62.a23;
        fMatrix6x63.a24 = fMatrix6x6.a24 * fMatrix6x62.a24;
        fMatrix6x63.a25 = fMatrix6x6.a25 * fMatrix6x62.a25;
        fMatrix6x63.a26 = fMatrix6x6.a26 * fMatrix6x62.a26;
        fMatrix6x63.a31 = fMatrix6x6.a31 * fMatrix6x62.a31;
        fMatrix6x63.a32 = fMatrix6x6.a32 * fMatrix6x62.a32;
        fMatrix6x63.a33 = fMatrix6x6.a33 * fMatrix6x62.a33;
        fMatrix6x63.a34 = fMatrix6x6.a34 * fMatrix6x62.a34;
        fMatrix6x63.a35 = fMatrix6x6.a35 * fMatrix6x62.a35;
        fMatrix6x63.a36 = fMatrix6x6.a36 * fMatrix6x62.a36;
        fMatrix6x63.a41 = fMatrix6x6.a41 * fMatrix6x62.a41;
        fMatrix6x63.a42 = fMatrix6x6.a42 * fMatrix6x62.a42;
        fMatrix6x63.a43 = fMatrix6x6.a43 * fMatrix6x62.a43;
        fMatrix6x63.a44 = fMatrix6x6.a44 * fMatrix6x62.a44;
        fMatrix6x63.a45 = fMatrix6x6.a45 * fMatrix6x62.a45;
        fMatrix6x63.a46 = fMatrix6x6.a46 * fMatrix6x62.a46;
        fMatrix6x63.a51 = fMatrix6x6.a51 * fMatrix6x62.a51;
        fMatrix6x63.a52 = fMatrix6x6.a52 * fMatrix6x62.a52;
        fMatrix6x63.a53 = fMatrix6x6.a53 * fMatrix6x62.a53;
        fMatrix6x63.a54 = fMatrix6x6.a54 * fMatrix6x62.a54;
        fMatrix6x63.a55 = fMatrix6x6.a55 * fMatrix6x62.a55;
        fMatrix6x63.a56 = fMatrix6x6.a56 * fMatrix6x62.a56;
        fMatrix6x63.a61 = fMatrix6x6.a61 * fMatrix6x62.a61;
        fMatrix6x63.a62 = fMatrix6x6.a62 * fMatrix6x62.a62;
        fMatrix6x63.a63 = fMatrix6x6.a63 * fMatrix6x62.a63;
        fMatrix6x63.a64 = fMatrix6x6.a64 * fMatrix6x62.a64;
        fMatrix6x63.a65 = fMatrix6x6.a65 * fMatrix6x62.a65;
        fMatrix6x63.a66 = fMatrix6x6.a66 * fMatrix6x62.a66;
    }

    public static void elementMult(FMatrix6 fMatrix6, FMatrix6 fMatrix62, FMatrix6 fMatrix63) {
        fMatrix63.f2432a1 = fMatrix6.f2432a1 * fMatrix62.f2432a1;
        fMatrix63.f2433a2 = fMatrix6.f2433a2 * fMatrix62.f2433a2;
        fMatrix63.f2434a3 = fMatrix6.f2434a3 * fMatrix62.f2434a3;
        fMatrix63.f2435a4 = fMatrix6.f2435a4 * fMatrix62.f2435a4;
        fMatrix63.f2436a5 = fMatrix6.f2436a5 * fMatrix62.f2436a5;
        fMatrix63.f2437a6 = fMatrix6.f2437a6 * fMatrix62.f2437a6;
    }

    public static void elementDiv(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62) {
        fMatrix6x6.a11 /= fMatrix6x62.a11;
        fMatrix6x6.a12 /= fMatrix6x62.a12;
        fMatrix6x6.a13 /= fMatrix6x62.a13;
        fMatrix6x6.a14 /= fMatrix6x62.a14;
        fMatrix6x6.a15 /= fMatrix6x62.a15;
        fMatrix6x6.a16 /= fMatrix6x62.a16;
        fMatrix6x6.a21 /= fMatrix6x62.a21;
        fMatrix6x6.a22 /= fMatrix6x62.a22;
        fMatrix6x6.a23 /= fMatrix6x62.a23;
        fMatrix6x6.a24 /= fMatrix6x62.a24;
        fMatrix6x6.a25 /= fMatrix6x62.a25;
        fMatrix6x6.a26 /= fMatrix6x62.a26;
        fMatrix6x6.a31 /= fMatrix6x62.a31;
        fMatrix6x6.a32 /= fMatrix6x62.a32;
        fMatrix6x6.a33 /= fMatrix6x62.a33;
        fMatrix6x6.a34 /= fMatrix6x62.a34;
        fMatrix6x6.a35 /= fMatrix6x62.a35;
        fMatrix6x6.a36 /= fMatrix6x62.a36;
        fMatrix6x6.a41 /= fMatrix6x62.a41;
        fMatrix6x6.a42 /= fMatrix6x62.a42;
        fMatrix6x6.a43 /= fMatrix6x62.a43;
        fMatrix6x6.a44 /= fMatrix6x62.a44;
        fMatrix6x6.a45 /= fMatrix6x62.a45;
        fMatrix6x6.a46 /= fMatrix6x62.a46;
        fMatrix6x6.a51 /= fMatrix6x62.a51;
        fMatrix6x6.a52 /= fMatrix6x62.a52;
        fMatrix6x6.a53 /= fMatrix6x62.a53;
        fMatrix6x6.a54 /= fMatrix6x62.a54;
        fMatrix6x6.a55 /= fMatrix6x62.a55;
        fMatrix6x6.a56 /= fMatrix6x62.a56;
        fMatrix6x6.a61 /= fMatrix6x62.a61;
        fMatrix6x6.a62 /= fMatrix6x62.a62;
        fMatrix6x6.a63 /= fMatrix6x62.a63;
        fMatrix6x6.a64 /= fMatrix6x62.a64;
        fMatrix6x6.a65 /= fMatrix6x62.a65;
        fMatrix6x6.a66 /= fMatrix6x62.a66;
    }

    public static void elementDiv(FMatrix6 fMatrix6, FMatrix6 fMatrix62) {
        fMatrix6.f2432a1 /= fMatrix62.f2432a1;
        fMatrix6.f2433a2 /= fMatrix62.f2433a2;
        fMatrix6.f2434a3 /= fMatrix62.f2434a3;
        fMatrix6.f2435a4 /= fMatrix62.f2435a4;
        fMatrix6.f2436a5 /= fMatrix62.f2436a5;
        fMatrix6.f2437a6 /= fMatrix62.f2437a6;
    }

    public static void elementDiv(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62, FMatrix6x6 fMatrix6x63) {
        fMatrix6x63.a11 = fMatrix6x6.a11 / fMatrix6x62.a11;
        fMatrix6x63.a12 = fMatrix6x6.a12 / fMatrix6x62.a12;
        fMatrix6x63.a13 = fMatrix6x6.a13 / fMatrix6x62.a13;
        fMatrix6x63.a14 = fMatrix6x6.a14 / fMatrix6x62.a14;
        fMatrix6x63.a15 = fMatrix6x6.a15 / fMatrix6x62.a15;
        fMatrix6x63.a16 = fMatrix6x6.a16 / fMatrix6x62.a16;
        fMatrix6x63.a21 = fMatrix6x6.a21 / fMatrix6x62.a21;
        fMatrix6x63.a22 = fMatrix6x6.a22 / fMatrix6x62.a22;
        fMatrix6x63.a23 = fMatrix6x6.a23 / fMatrix6x62.a23;
        fMatrix6x63.a24 = fMatrix6x6.a24 / fMatrix6x62.a24;
        fMatrix6x63.a25 = fMatrix6x6.a25 / fMatrix6x62.a25;
        fMatrix6x63.a26 = fMatrix6x6.a26 / fMatrix6x62.a26;
        fMatrix6x63.a31 = fMatrix6x6.a31 / fMatrix6x62.a31;
        fMatrix6x63.a32 = fMatrix6x6.a32 / fMatrix6x62.a32;
        fMatrix6x63.a33 = fMatrix6x6.a33 / fMatrix6x62.a33;
        fMatrix6x63.a34 = fMatrix6x6.a34 / fMatrix6x62.a34;
        fMatrix6x63.a35 = fMatrix6x6.a35 / fMatrix6x62.a35;
        fMatrix6x63.a36 = fMatrix6x6.a36 / fMatrix6x62.a36;
        fMatrix6x63.a41 = fMatrix6x6.a41 / fMatrix6x62.a41;
        fMatrix6x63.a42 = fMatrix6x6.a42 / fMatrix6x62.a42;
        fMatrix6x63.a43 = fMatrix6x6.a43 / fMatrix6x62.a43;
        fMatrix6x63.a44 = fMatrix6x6.a44 / fMatrix6x62.a44;
        fMatrix6x63.a45 = fMatrix6x6.a45 / fMatrix6x62.a45;
        fMatrix6x63.a46 = fMatrix6x6.a46 / fMatrix6x62.a46;
        fMatrix6x63.a51 = fMatrix6x6.a51 / fMatrix6x62.a51;
        fMatrix6x63.a52 = fMatrix6x6.a52 / fMatrix6x62.a52;
        fMatrix6x63.a53 = fMatrix6x6.a53 / fMatrix6x62.a53;
        fMatrix6x63.a54 = fMatrix6x6.a54 / fMatrix6x62.a54;
        fMatrix6x63.a55 = fMatrix6x6.a55 / fMatrix6x62.a55;
        fMatrix6x63.a56 = fMatrix6x6.a56 / fMatrix6x62.a56;
        fMatrix6x63.a61 = fMatrix6x6.a61 / fMatrix6x62.a61;
        fMatrix6x63.a62 = fMatrix6x6.a62 / fMatrix6x62.a62;
        fMatrix6x63.a63 = fMatrix6x6.a63 / fMatrix6x62.a63;
        fMatrix6x63.a64 = fMatrix6x6.a64 / fMatrix6x62.a64;
        fMatrix6x63.a65 = fMatrix6x6.a65 / fMatrix6x62.a65;
        fMatrix6x63.a66 = fMatrix6x6.a66 / fMatrix6x62.a66;
    }

    public static void elementDiv(FMatrix6 fMatrix6, FMatrix6 fMatrix62, FMatrix6 fMatrix63) {
        fMatrix63.f2432a1 = fMatrix6.f2432a1 / fMatrix62.f2432a1;
        fMatrix63.f2433a2 = fMatrix6.f2433a2 / fMatrix62.f2433a2;
        fMatrix63.f2434a3 = fMatrix6.f2434a3 / fMatrix62.f2434a3;
        fMatrix63.f2435a4 = fMatrix6.f2435a4 / fMatrix62.f2435a4;
        fMatrix63.f2436a5 = fMatrix6.f2436a5 / fMatrix62.f2436a5;
        fMatrix63.f2437a6 = fMatrix6.f2437a6 / fMatrix62.f2437a6;
    }

    public static void scale(float f, FMatrix6x6 fMatrix6x6) {
        fMatrix6x6.a11 *= f;
        fMatrix6x6.a12 *= f;
        fMatrix6x6.a13 *= f;
        fMatrix6x6.a14 *= f;
        fMatrix6x6.a15 *= f;
        fMatrix6x6.a16 *= f;
        fMatrix6x6.a21 *= f;
        fMatrix6x6.a22 *= f;
        fMatrix6x6.a23 *= f;
        fMatrix6x6.a24 *= f;
        fMatrix6x6.a25 *= f;
        fMatrix6x6.a26 *= f;
        fMatrix6x6.a31 *= f;
        fMatrix6x6.a32 *= f;
        fMatrix6x6.a33 *= f;
        fMatrix6x6.a34 *= f;
        fMatrix6x6.a35 *= f;
        fMatrix6x6.a36 *= f;
        fMatrix6x6.a41 *= f;
        fMatrix6x6.a42 *= f;
        fMatrix6x6.a43 *= f;
        fMatrix6x6.a44 *= f;
        fMatrix6x6.a45 *= f;
        fMatrix6x6.a46 *= f;
        fMatrix6x6.a51 *= f;
        fMatrix6x6.a52 *= f;
        fMatrix6x6.a53 *= f;
        fMatrix6x6.a54 *= f;
        fMatrix6x6.a55 *= f;
        fMatrix6x6.a56 *= f;
        fMatrix6x6.a61 *= f;
        fMatrix6x6.a62 *= f;
        fMatrix6x6.a63 *= f;
        fMatrix6x6.a64 *= f;
        fMatrix6x6.a65 *= f;
        fMatrix6x6.a66 *= f;
    }

    public static void scale(float f, FMatrix6 fMatrix6) {
        fMatrix6.f2432a1 *= f;
        fMatrix6.f2433a2 *= f;
        fMatrix6.f2434a3 *= f;
        fMatrix6.f2435a4 *= f;
        fMatrix6.f2436a5 *= f;
        fMatrix6.f2437a6 *= f;
    }

    public static void scale(float f, FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62) {
        fMatrix6x62.a11 = fMatrix6x6.a11 * f;
        fMatrix6x62.a12 = fMatrix6x6.a12 * f;
        fMatrix6x62.a13 = fMatrix6x6.a13 * f;
        fMatrix6x62.a14 = fMatrix6x6.a14 * f;
        fMatrix6x62.a15 = fMatrix6x6.a15 * f;
        fMatrix6x62.a16 = fMatrix6x6.a16 * f;
        fMatrix6x62.a21 = fMatrix6x6.a21 * f;
        fMatrix6x62.a22 = fMatrix6x6.a22 * f;
        fMatrix6x62.a23 = fMatrix6x6.a23 * f;
        fMatrix6x62.a24 = fMatrix6x6.a24 * f;
        fMatrix6x62.a25 = fMatrix6x6.a25 * f;
        fMatrix6x62.a26 = fMatrix6x6.a26 * f;
        fMatrix6x62.a31 = fMatrix6x6.a31 * f;
        fMatrix6x62.a32 = fMatrix6x6.a32 * f;
        fMatrix6x62.a33 = fMatrix6x6.a33 * f;
        fMatrix6x62.a34 = fMatrix6x6.a34 * f;
        fMatrix6x62.a35 = fMatrix6x6.a35 * f;
        fMatrix6x62.a36 = fMatrix6x6.a36 * f;
        fMatrix6x62.a41 = fMatrix6x6.a41 * f;
        fMatrix6x62.a42 = fMatrix6x6.a42 * f;
        fMatrix6x62.a43 = fMatrix6x6.a43 * f;
        fMatrix6x62.a44 = fMatrix6x6.a44 * f;
        fMatrix6x62.a45 = fMatrix6x6.a45 * f;
        fMatrix6x62.a46 = fMatrix6x6.a46 * f;
        fMatrix6x62.a51 = fMatrix6x6.a51 * f;
        fMatrix6x62.a52 = fMatrix6x6.a52 * f;
        fMatrix6x62.a53 = fMatrix6x6.a53 * f;
        fMatrix6x62.a54 = fMatrix6x6.a54 * f;
        fMatrix6x62.a55 = fMatrix6x6.a55 * f;
        fMatrix6x62.a56 = fMatrix6x6.a56 * f;
        fMatrix6x62.a61 = fMatrix6x6.a61 * f;
        fMatrix6x62.a62 = fMatrix6x6.a62 * f;
        fMatrix6x62.a63 = fMatrix6x6.a63 * f;
        fMatrix6x62.a64 = fMatrix6x6.a64 * f;
        fMatrix6x62.a65 = fMatrix6x6.a65 * f;
        fMatrix6x62.a66 = fMatrix6x6.a66 * f;
    }

    public static void scale(float f, FMatrix6 fMatrix6, FMatrix6 fMatrix62) {
        fMatrix62.f2432a1 = fMatrix6.f2432a1 * f;
        fMatrix62.f2433a2 = fMatrix6.f2433a2 * f;
        fMatrix62.f2434a3 = fMatrix6.f2434a3 * f;
        fMatrix62.f2435a4 = fMatrix6.f2435a4 * f;
        fMatrix62.f2436a5 = fMatrix6.f2436a5 * f;
        fMatrix62.f2437a6 = fMatrix6.f2437a6 * f;
    }

    public static void divide(FMatrix6x6 fMatrix6x6, float f) {
        fMatrix6x6.a11 /= f;
        fMatrix6x6.a12 /= f;
        fMatrix6x6.a13 /= f;
        fMatrix6x6.a14 /= f;
        fMatrix6x6.a15 /= f;
        fMatrix6x6.a16 /= f;
        fMatrix6x6.a21 /= f;
        fMatrix6x6.a22 /= f;
        fMatrix6x6.a23 /= f;
        fMatrix6x6.a24 /= f;
        fMatrix6x6.a25 /= f;
        fMatrix6x6.a26 /= f;
        fMatrix6x6.a31 /= f;
        fMatrix6x6.a32 /= f;
        fMatrix6x6.a33 /= f;
        fMatrix6x6.a34 /= f;
        fMatrix6x6.a35 /= f;
        fMatrix6x6.a36 /= f;
        fMatrix6x6.a41 /= f;
        fMatrix6x6.a42 /= f;
        fMatrix6x6.a43 /= f;
        fMatrix6x6.a44 /= f;
        fMatrix6x6.a45 /= f;
        fMatrix6x6.a46 /= f;
        fMatrix6x6.a51 /= f;
        fMatrix6x6.a52 /= f;
        fMatrix6x6.a53 /= f;
        fMatrix6x6.a54 /= f;
        fMatrix6x6.a55 /= f;
        fMatrix6x6.a56 /= f;
        fMatrix6x6.a61 /= f;
        fMatrix6x6.a62 /= f;
        fMatrix6x6.a63 /= f;
        fMatrix6x6.a64 /= f;
        fMatrix6x6.a65 /= f;
        fMatrix6x6.a66 /= f;
    }

    public static void divide(FMatrix6 fMatrix6, float f) {
        fMatrix6.f2432a1 /= f;
        fMatrix6.f2433a2 /= f;
        fMatrix6.f2434a3 /= f;
        fMatrix6.f2435a4 /= f;
        fMatrix6.f2436a5 /= f;
        fMatrix6.f2437a6 /= f;
    }

    public static void divide(FMatrix6x6 fMatrix6x6, float f, FMatrix6x6 fMatrix6x62) {
        fMatrix6x62.a11 = fMatrix6x6.a11 / f;
        fMatrix6x62.a12 = fMatrix6x6.a12 / f;
        fMatrix6x62.a13 = fMatrix6x6.a13 / f;
        fMatrix6x62.a14 = fMatrix6x6.a14 / f;
        fMatrix6x62.a15 = fMatrix6x6.a15 / f;
        fMatrix6x62.a16 = fMatrix6x6.a16 / f;
        fMatrix6x62.a21 = fMatrix6x6.a21 / f;
        fMatrix6x62.a22 = fMatrix6x6.a22 / f;
        fMatrix6x62.a23 = fMatrix6x6.a23 / f;
        fMatrix6x62.a24 = fMatrix6x6.a24 / f;
        fMatrix6x62.a25 = fMatrix6x6.a25 / f;
        fMatrix6x62.a26 = fMatrix6x6.a26 / f;
        fMatrix6x62.a31 = fMatrix6x6.a31 / f;
        fMatrix6x62.a32 = fMatrix6x6.a32 / f;
        fMatrix6x62.a33 = fMatrix6x6.a33 / f;
        fMatrix6x62.a34 = fMatrix6x6.a34 / f;
        fMatrix6x62.a35 = fMatrix6x6.a35 / f;
        fMatrix6x62.a36 = fMatrix6x6.a36 / f;
        fMatrix6x62.a41 = fMatrix6x6.a41 / f;
        fMatrix6x62.a42 = fMatrix6x6.a42 / f;
        fMatrix6x62.a43 = fMatrix6x6.a43 / f;
        fMatrix6x62.a44 = fMatrix6x6.a44 / f;
        fMatrix6x62.a45 = fMatrix6x6.a45 / f;
        fMatrix6x62.a46 = fMatrix6x6.a46 / f;
        fMatrix6x62.a51 = fMatrix6x6.a51 / f;
        fMatrix6x62.a52 = fMatrix6x6.a52 / f;
        fMatrix6x62.a53 = fMatrix6x6.a53 / f;
        fMatrix6x62.a54 = fMatrix6x6.a54 / f;
        fMatrix6x62.a55 = fMatrix6x6.a55 / f;
        fMatrix6x62.a56 = fMatrix6x6.a56 / f;
        fMatrix6x62.a61 = fMatrix6x6.a61 / f;
        fMatrix6x62.a62 = fMatrix6x6.a62 / f;
        fMatrix6x62.a63 = fMatrix6x6.a63 / f;
        fMatrix6x62.a64 = fMatrix6x6.a64 / f;
        fMatrix6x62.a65 = fMatrix6x6.a65 / f;
        fMatrix6x62.a66 = fMatrix6x6.a66 / f;
    }

    public static void divide(FMatrix6 fMatrix6, float f, FMatrix6 fMatrix62) {
        fMatrix62.f2432a1 = fMatrix6.f2432a1 / f;
        fMatrix62.f2433a2 = fMatrix6.f2433a2 / f;
        fMatrix62.f2434a3 = fMatrix6.f2434a3 / f;
        fMatrix62.f2435a4 = fMatrix6.f2435a4 / f;
        fMatrix62.f2436a5 = fMatrix6.f2436a5 / f;
        fMatrix62.f2437a6 = fMatrix6.f2437a6 / f;
    }

    public static void changeSign(FMatrix6x6 fMatrix6x6) {
        fMatrix6x6.a11 = -fMatrix6x6.a11;
        fMatrix6x6.a12 = -fMatrix6x6.a12;
        fMatrix6x6.a13 = -fMatrix6x6.a13;
        fMatrix6x6.a14 = -fMatrix6x6.a14;
        fMatrix6x6.a15 = -fMatrix6x6.a15;
        fMatrix6x6.a16 = -fMatrix6x6.a16;
        fMatrix6x6.a21 = -fMatrix6x6.a21;
        fMatrix6x6.a22 = -fMatrix6x6.a22;
        fMatrix6x6.a23 = -fMatrix6x6.a23;
        fMatrix6x6.a24 = -fMatrix6x6.a24;
        fMatrix6x6.a25 = -fMatrix6x6.a25;
        fMatrix6x6.a26 = -fMatrix6x6.a26;
        fMatrix6x6.a31 = -fMatrix6x6.a31;
        fMatrix6x6.a32 = -fMatrix6x6.a32;
        fMatrix6x6.a33 = -fMatrix6x6.a33;
        fMatrix6x6.a34 = -fMatrix6x6.a34;
        fMatrix6x6.a35 = -fMatrix6x6.a35;
        fMatrix6x6.a36 = -fMatrix6x6.a36;
        fMatrix6x6.a41 = -fMatrix6x6.a41;
        fMatrix6x6.a42 = -fMatrix6x6.a42;
        fMatrix6x6.a43 = -fMatrix6x6.a43;
        fMatrix6x6.a44 = -fMatrix6x6.a44;
        fMatrix6x6.a45 = -fMatrix6x6.a45;
        fMatrix6x6.a46 = -fMatrix6x6.a46;
        fMatrix6x6.a51 = -fMatrix6x6.a51;
        fMatrix6x6.a52 = -fMatrix6x6.a52;
        fMatrix6x6.a53 = -fMatrix6x6.a53;
        fMatrix6x6.a54 = -fMatrix6x6.a54;
        fMatrix6x6.a55 = -fMatrix6x6.a55;
        fMatrix6x6.a56 = -fMatrix6x6.a56;
        fMatrix6x6.a61 = -fMatrix6x6.a61;
        fMatrix6x6.a62 = -fMatrix6x6.a62;
        fMatrix6x6.a63 = -fMatrix6x6.a63;
        fMatrix6x6.a64 = -fMatrix6x6.a64;
        fMatrix6x6.a65 = -fMatrix6x6.a65;
        fMatrix6x6.a66 = -fMatrix6x6.a66;
    }

    public static void changeSign(FMatrix6 fMatrix6) {
        fMatrix6.f2432a1 = -fMatrix6.f2432a1;
        fMatrix6.f2433a2 = -fMatrix6.f2433a2;
        fMatrix6.f2434a3 = -fMatrix6.f2434a3;
        fMatrix6.f2435a4 = -fMatrix6.f2435a4;
        fMatrix6.f2436a5 = -fMatrix6.f2436a5;
        fMatrix6.f2437a6 = -fMatrix6.f2437a6;
    }

    public static void fill(FMatrix6x6 fMatrix6x6, float f) {
        fMatrix6x6.a11 = f;
        fMatrix6x6.a12 = f;
        fMatrix6x6.a13 = f;
        fMatrix6x6.a14 = f;
        fMatrix6x6.a15 = f;
        fMatrix6x6.a16 = f;
        fMatrix6x6.a21 = f;
        fMatrix6x6.a22 = f;
        fMatrix6x6.a23 = f;
        fMatrix6x6.a24 = f;
        fMatrix6x6.a25 = f;
        fMatrix6x6.a26 = f;
        fMatrix6x6.a31 = f;
        fMatrix6x6.a32 = f;
        fMatrix6x6.a33 = f;
        fMatrix6x6.a34 = f;
        fMatrix6x6.a35 = f;
        fMatrix6x6.a36 = f;
        fMatrix6x6.a41 = f;
        fMatrix6x6.a42 = f;
        fMatrix6x6.a43 = f;
        fMatrix6x6.a44 = f;
        fMatrix6x6.a45 = f;
        fMatrix6x6.a46 = f;
        fMatrix6x6.a51 = f;
        fMatrix6x6.a52 = f;
        fMatrix6x6.a53 = f;
        fMatrix6x6.a54 = f;
        fMatrix6x6.a55 = f;
        fMatrix6x6.a56 = f;
        fMatrix6x6.a61 = f;
        fMatrix6x6.a62 = f;
        fMatrix6x6.a63 = f;
        fMatrix6x6.a64 = f;
        fMatrix6x6.a65 = f;
        fMatrix6x6.a66 = f;
    }

    public static void fill(FMatrix6 fMatrix6, float f) {
        fMatrix6.f2432a1 = f;
        fMatrix6.f2433a2 = f;
        fMatrix6.f2434a3 = f;
        fMatrix6.f2435a4 = f;
        fMatrix6.f2436a5 = f;
        fMatrix6.f2437a6 = f;
    }

    public static FMatrix6 extractRow(FMatrix6x6 fMatrix6x6, int i, FMatrix6 fMatrix6) {
        if (fMatrix6 == null) {
            fMatrix6 = new FMatrix6();
        }
        if (i == 0) {
            fMatrix6.f2432a1 = fMatrix6x6.a11;
            fMatrix6.f2433a2 = fMatrix6x6.a12;
            fMatrix6.f2434a3 = fMatrix6x6.a13;
            fMatrix6.f2435a4 = fMatrix6x6.a14;
            fMatrix6.f2436a5 = fMatrix6x6.a15;
            fMatrix6.f2437a6 = fMatrix6x6.a16;
            return fMatrix6;
        }
        if (i == 1) {
            fMatrix6.f2432a1 = fMatrix6x6.a21;
            fMatrix6.f2433a2 = fMatrix6x6.a22;
            fMatrix6.f2434a3 = fMatrix6x6.a23;
            fMatrix6.f2435a4 = fMatrix6x6.a24;
            fMatrix6.f2436a5 = fMatrix6x6.a25;
            fMatrix6.f2437a6 = fMatrix6x6.a26;
            return fMatrix6;
        }
        if (i == 2) {
            fMatrix6.f2432a1 = fMatrix6x6.a31;
            fMatrix6.f2433a2 = fMatrix6x6.a32;
            fMatrix6.f2434a3 = fMatrix6x6.a33;
            fMatrix6.f2435a4 = fMatrix6x6.a34;
            fMatrix6.f2436a5 = fMatrix6x6.a35;
            fMatrix6.f2437a6 = fMatrix6x6.a36;
            return fMatrix6;
        }
        if (i == 3) {
            fMatrix6.f2432a1 = fMatrix6x6.a41;
            fMatrix6.f2433a2 = fMatrix6x6.a42;
            fMatrix6.f2434a3 = fMatrix6x6.a43;
            fMatrix6.f2435a4 = fMatrix6x6.a44;
            fMatrix6.f2436a5 = fMatrix6x6.a45;
            fMatrix6.f2437a6 = fMatrix6x6.a46;
            return fMatrix6;
        }
        if (i == 4) {
            fMatrix6.f2432a1 = fMatrix6x6.a51;
            fMatrix6.f2433a2 = fMatrix6x6.a52;
            fMatrix6.f2434a3 = fMatrix6x6.a53;
            fMatrix6.f2435a4 = fMatrix6x6.a54;
            fMatrix6.f2436a5 = fMatrix6x6.a55;
            fMatrix6.f2437a6 = fMatrix6x6.a56;
            return fMatrix6;
        }
        if (i == 5) {
            fMatrix6.f2432a1 = fMatrix6x6.a61;
            fMatrix6.f2433a2 = fMatrix6x6.a62;
            fMatrix6.f2434a3 = fMatrix6x6.a63;
            fMatrix6.f2435a4 = fMatrix6x6.a64;
            fMatrix6.f2436a5 = fMatrix6x6.a65;
            fMatrix6.f2437a6 = fMatrix6x6.a66;
            return fMatrix6;
        }
        throw new IllegalArgumentException("Out of bounds row.  row = " + i);
    }

    public static FMatrix6 extractColumn(FMatrix6x6 fMatrix6x6, int i, FMatrix6 fMatrix6) {
        if (fMatrix6 == null) {
            fMatrix6 = new FMatrix6();
        }
        if (i == 0) {
            fMatrix6.f2432a1 = fMatrix6x6.a11;
            fMatrix6.f2433a2 = fMatrix6x6.a21;
            fMatrix6.f2434a3 = fMatrix6x6.a31;
            fMatrix6.f2435a4 = fMatrix6x6.a41;
            fMatrix6.f2436a5 = fMatrix6x6.a51;
            fMatrix6.f2437a6 = fMatrix6x6.a61;
            return fMatrix6;
        }
        if (i == 1) {
            fMatrix6.f2432a1 = fMatrix6x6.a12;
            fMatrix6.f2433a2 = fMatrix6x6.a22;
            fMatrix6.f2434a3 = fMatrix6x6.a32;
            fMatrix6.f2435a4 = fMatrix6x6.a42;
            fMatrix6.f2436a5 = fMatrix6x6.a52;
            fMatrix6.f2437a6 = fMatrix6x6.a62;
            return fMatrix6;
        }
        if (i == 2) {
            fMatrix6.f2432a1 = fMatrix6x6.a13;
            fMatrix6.f2433a2 = fMatrix6x6.a23;
            fMatrix6.f2434a3 = fMatrix6x6.a33;
            fMatrix6.f2435a4 = fMatrix6x6.a43;
            fMatrix6.f2436a5 = fMatrix6x6.a53;
            fMatrix6.f2437a6 = fMatrix6x6.a63;
            return fMatrix6;
        }
        if (i == 3) {
            fMatrix6.f2432a1 = fMatrix6x6.a14;
            fMatrix6.f2433a2 = fMatrix6x6.a24;
            fMatrix6.f2434a3 = fMatrix6x6.a34;
            fMatrix6.f2435a4 = fMatrix6x6.a44;
            fMatrix6.f2436a5 = fMatrix6x6.a54;
            fMatrix6.f2437a6 = fMatrix6x6.a64;
            return fMatrix6;
        }
        if (i == 4) {
            fMatrix6.f2432a1 = fMatrix6x6.a15;
            fMatrix6.f2433a2 = fMatrix6x6.a25;
            fMatrix6.f2434a3 = fMatrix6x6.a35;
            fMatrix6.f2435a4 = fMatrix6x6.a45;
            fMatrix6.f2436a5 = fMatrix6x6.a55;
            fMatrix6.f2437a6 = fMatrix6x6.a65;
            return fMatrix6;
        }
        if (i == 5) {
            fMatrix6.f2432a1 = fMatrix6x6.a16;
            fMatrix6.f2433a2 = fMatrix6x6.a26;
            fMatrix6.f2434a3 = fMatrix6x6.a36;
            fMatrix6.f2435a4 = fMatrix6x6.a46;
            fMatrix6.f2436a5 = fMatrix6x6.a56;
            fMatrix6.f2437a6 = fMatrix6x6.a66;
            return fMatrix6;
        }
        throw new IllegalArgumentException("Out of bounds column.  column = " + i);
    }
}
