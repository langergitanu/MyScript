package org.ejml.dense.fixed;

import org.ejml.data.FMatrix3;
import org.ejml.data.FMatrix3x3;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_FDF3 {
    public static void add(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32, FMatrix3x3 fMatrix3x33) {
        fMatrix3x33.a11 = fMatrix3x3.a11 + fMatrix3x32.a11;
        fMatrix3x33.a12 = fMatrix3x3.a12 + fMatrix3x32.a12;
        fMatrix3x33.a13 = fMatrix3x3.a13 + fMatrix3x32.a13;
        fMatrix3x33.a21 = fMatrix3x3.a21 + fMatrix3x32.a21;
        fMatrix3x33.a22 = fMatrix3x3.a22 + fMatrix3x32.a22;
        fMatrix3x33.a23 = fMatrix3x3.a23 + fMatrix3x32.a23;
        fMatrix3x33.a31 = fMatrix3x3.a31 + fMatrix3x32.a31;
        fMatrix3x33.a32 = fMatrix3x3.a32 + fMatrix3x32.a32;
        fMatrix3x33.a33 = fMatrix3x3.a33 + fMatrix3x32.a33;
    }

    public static void add(FMatrix3 fMatrix3, FMatrix3 fMatrix32, FMatrix3 fMatrix33) {
        fMatrix33.f2420a1 = fMatrix3.f2420a1 + fMatrix32.f2420a1;
        fMatrix33.f2421a2 = fMatrix3.f2421a2 + fMatrix32.f2421a2;
        fMatrix33.f2422a3 = fMatrix3.f2422a3 + fMatrix32.f2422a3;
    }

    public static void addEquals(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32) {
        fMatrix3x3.a11 += fMatrix3x32.a11;
        fMatrix3x3.a12 += fMatrix3x32.a12;
        fMatrix3x3.a13 += fMatrix3x32.a13;
        fMatrix3x3.a21 += fMatrix3x32.a21;
        fMatrix3x3.a22 += fMatrix3x32.a22;
        fMatrix3x3.a23 += fMatrix3x32.a23;
        fMatrix3x3.a31 += fMatrix3x32.a31;
        fMatrix3x3.a32 += fMatrix3x32.a32;
        fMatrix3x3.a33 += fMatrix3x32.a33;
    }

    public static void addEquals(FMatrix3 fMatrix3, FMatrix3 fMatrix32) {
        fMatrix3.f2420a1 += fMatrix32.f2420a1;
        fMatrix3.f2421a2 += fMatrix32.f2421a2;
        fMatrix3.f2422a3 += fMatrix32.f2422a3;
    }

    public static void subtract(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32, FMatrix3x3 fMatrix3x33) {
        fMatrix3x33.a11 = fMatrix3x3.a11 - fMatrix3x32.a11;
        fMatrix3x33.a12 = fMatrix3x3.a12 - fMatrix3x32.a12;
        fMatrix3x33.a13 = fMatrix3x3.a13 - fMatrix3x32.a13;
        fMatrix3x33.a21 = fMatrix3x3.a21 - fMatrix3x32.a21;
        fMatrix3x33.a22 = fMatrix3x3.a22 - fMatrix3x32.a22;
        fMatrix3x33.a23 = fMatrix3x3.a23 - fMatrix3x32.a23;
        fMatrix3x33.a31 = fMatrix3x3.a31 - fMatrix3x32.a31;
        fMatrix3x33.a32 = fMatrix3x3.a32 - fMatrix3x32.a32;
        fMatrix3x33.a33 = fMatrix3x3.a33 - fMatrix3x32.a33;
    }

    public static void subtract(FMatrix3 fMatrix3, FMatrix3 fMatrix32, FMatrix3 fMatrix33) {
        fMatrix33.f2420a1 = fMatrix3.f2420a1 - fMatrix32.f2420a1;
        fMatrix33.f2421a2 = fMatrix3.f2421a2 - fMatrix32.f2421a2;
        fMatrix33.f2422a3 = fMatrix3.f2422a3 - fMatrix32.f2422a3;
    }

    public static void subtractEquals(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32) {
        fMatrix3x3.a11 -= fMatrix3x32.a11;
        fMatrix3x3.a12 -= fMatrix3x32.a12;
        fMatrix3x3.a13 -= fMatrix3x32.a13;
        fMatrix3x3.a21 -= fMatrix3x32.a21;
        fMatrix3x3.a22 -= fMatrix3x32.a22;
        fMatrix3x3.a23 -= fMatrix3x32.a23;
        fMatrix3x3.a31 -= fMatrix3x32.a31;
        fMatrix3x3.a32 -= fMatrix3x32.a32;
        fMatrix3x3.a33 -= fMatrix3x32.a33;
    }

    public static void subtractEquals(FMatrix3 fMatrix3, FMatrix3 fMatrix32) {
        fMatrix3.f2420a1 -= fMatrix32.f2420a1;
        fMatrix3.f2421a2 -= fMatrix32.f2421a2;
        fMatrix3.f2422a3 -= fMatrix32.f2422a3;
    }

    public static void transpose(FMatrix3x3 fMatrix3x3) {
        float f = fMatrix3x3.a12;
        fMatrix3x3.a12 = fMatrix3x3.a21;
        fMatrix3x3.a21 = f;
        float f2 = fMatrix3x3.a13;
        fMatrix3x3.a13 = fMatrix3x3.a31;
        fMatrix3x3.a31 = f2;
        float f3 = fMatrix3x3.a23;
        fMatrix3x3.a23 = fMatrix3x3.a32;
        fMatrix3x3.a32 = f3;
    }

    public static FMatrix3x3 transpose(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32) {
        if (fMatrix3x3 == null) {
            fMatrix3x3 = new FMatrix3x3();
        }
        fMatrix3x32.a11 = fMatrix3x3.a11;
        fMatrix3x32.a12 = fMatrix3x3.a21;
        fMatrix3x32.a13 = fMatrix3x3.a31;
        fMatrix3x32.a21 = fMatrix3x3.a12;
        fMatrix3x32.a22 = fMatrix3x3.a22;
        fMatrix3x32.a23 = fMatrix3x3.a32;
        fMatrix3x32.a31 = fMatrix3x3.a13;
        fMatrix3x32.a32 = fMatrix3x3.a23;
        fMatrix3x32.a33 = fMatrix3x3.a33;
        return fMatrix3x32;
    }

    public static void mult(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32, FMatrix3x3 fMatrix3x33) {
        fMatrix3x33.a11 = (fMatrix3x3.a11 * fMatrix3x32.a11) + (fMatrix3x3.a12 * fMatrix3x32.a21) + (fMatrix3x3.a13 * fMatrix3x32.a31);
        fMatrix3x33.a12 = (fMatrix3x3.a11 * fMatrix3x32.a12) + (fMatrix3x3.a12 * fMatrix3x32.a22) + (fMatrix3x3.a13 * fMatrix3x32.a32);
        fMatrix3x33.a13 = (fMatrix3x3.a11 * fMatrix3x32.a13) + (fMatrix3x3.a12 * fMatrix3x32.a23) + (fMatrix3x3.a13 * fMatrix3x32.a33);
        fMatrix3x33.a21 = (fMatrix3x3.a21 * fMatrix3x32.a11) + (fMatrix3x3.a22 * fMatrix3x32.a21) + (fMatrix3x3.a23 * fMatrix3x32.a31);
        fMatrix3x33.a22 = (fMatrix3x3.a21 * fMatrix3x32.a12) + (fMatrix3x3.a22 * fMatrix3x32.a22) + (fMatrix3x3.a23 * fMatrix3x32.a32);
        fMatrix3x33.a23 = (fMatrix3x3.a21 * fMatrix3x32.a13) + (fMatrix3x3.a22 * fMatrix3x32.a23) + (fMatrix3x3.a23 * fMatrix3x32.a33);
        fMatrix3x33.a31 = (fMatrix3x3.a31 * fMatrix3x32.a11) + (fMatrix3x3.a32 * fMatrix3x32.a21) + (fMatrix3x3.a33 * fMatrix3x32.a31);
        fMatrix3x33.a32 = (fMatrix3x3.a31 * fMatrix3x32.a12) + (fMatrix3x3.a32 * fMatrix3x32.a22) + (fMatrix3x3.a33 * fMatrix3x32.a32);
        fMatrix3x33.a33 = (fMatrix3x3.a31 * fMatrix3x32.a13) + (fMatrix3x3.a32 * fMatrix3x32.a23) + (fMatrix3x3.a33 * fMatrix3x32.a33);
    }

    public static void multTransA(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32, FMatrix3x3 fMatrix3x33) {
        fMatrix3x33.a11 = (fMatrix3x3.a11 * fMatrix3x32.a11) + (fMatrix3x3.a21 * fMatrix3x32.a21) + (fMatrix3x3.a31 * fMatrix3x32.a31);
        fMatrix3x33.a12 = (fMatrix3x3.a11 * fMatrix3x32.a12) + (fMatrix3x3.a21 * fMatrix3x32.a22) + (fMatrix3x3.a31 * fMatrix3x32.a32);
        fMatrix3x33.a13 = (fMatrix3x3.a11 * fMatrix3x32.a13) + (fMatrix3x3.a21 * fMatrix3x32.a23) + (fMatrix3x3.a31 * fMatrix3x32.a33);
        fMatrix3x33.a21 = (fMatrix3x3.a12 * fMatrix3x32.a11) + (fMatrix3x3.a22 * fMatrix3x32.a21) + (fMatrix3x3.a32 * fMatrix3x32.a31);
        fMatrix3x33.a22 = (fMatrix3x3.a12 * fMatrix3x32.a12) + (fMatrix3x3.a22 * fMatrix3x32.a22) + (fMatrix3x3.a32 * fMatrix3x32.a32);
        fMatrix3x33.a23 = (fMatrix3x3.a12 * fMatrix3x32.a13) + (fMatrix3x3.a22 * fMatrix3x32.a23) + (fMatrix3x3.a32 * fMatrix3x32.a33);
        fMatrix3x33.a31 = (fMatrix3x3.a13 * fMatrix3x32.a11) + (fMatrix3x3.a23 * fMatrix3x32.a21) + (fMatrix3x3.a33 * fMatrix3x32.a31);
        fMatrix3x33.a32 = (fMatrix3x3.a13 * fMatrix3x32.a12) + (fMatrix3x3.a23 * fMatrix3x32.a22) + (fMatrix3x3.a33 * fMatrix3x32.a32);
        fMatrix3x33.a33 = (fMatrix3x3.a13 * fMatrix3x32.a13) + (fMatrix3x3.a23 * fMatrix3x32.a23) + (fMatrix3x3.a33 * fMatrix3x32.a33);
    }

    public static void multTransAB(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32, FMatrix3x3 fMatrix3x33) {
        fMatrix3x33.a11 = (fMatrix3x3.a11 * fMatrix3x32.a11) + (fMatrix3x3.a21 * fMatrix3x32.a12) + (fMatrix3x3.a31 * fMatrix3x32.a13);
        fMatrix3x33.a12 = (fMatrix3x3.a11 * fMatrix3x32.a21) + (fMatrix3x3.a21 * fMatrix3x32.a22) + (fMatrix3x3.a31 * fMatrix3x32.a23);
        fMatrix3x33.a13 = (fMatrix3x3.a11 * fMatrix3x32.a31) + (fMatrix3x3.a21 * fMatrix3x32.a32) + (fMatrix3x3.a31 * fMatrix3x32.a33);
        fMatrix3x33.a21 = (fMatrix3x3.a12 * fMatrix3x32.a11) + (fMatrix3x3.a22 * fMatrix3x32.a12) + (fMatrix3x3.a32 * fMatrix3x32.a13);
        fMatrix3x33.a22 = (fMatrix3x3.a12 * fMatrix3x32.a21) + (fMatrix3x3.a22 * fMatrix3x32.a22) + (fMatrix3x3.a32 * fMatrix3x32.a23);
        fMatrix3x33.a23 = (fMatrix3x3.a12 * fMatrix3x32.a31) + (fMatrix3x3.a22 * fMatrix3x32.a32) + (fMatrix3x3.a32 * fMatrix3x32.a33);
        fMatrix3x33.a31 = (fMatrix3x3.a13 * fMatrix3x32.a11) + (fMatrix3x3.a23 * fMatrix3x32.a12) + (fMatrix3x3.a33 * fMatrix3x32.a13);
        fMatrix3x33.a32 = (fMatrix3x3.a13 * fMatrix3x32.a21) + (fMatrix3x3.a23 * fMatrix3x32.a22) + (fMatrix3x3.a33 * fMatrix3x32.a23);
        fMatrix3x33.a33 = (fMatrix3x3.a13 * fMatrix3x32.a31) + (fMatrix3x3.a23 * fMatrix3x32.a32) + (fMatrix3x3.a33 * fMatrix3x32.a33);
    }

    public static void multTransB(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32, FMatrix3x3 fMatrix3x33) {
        fMatrix3x33.a11 = (fMatrix3x3.a11 * fMatrix3x32.a11) + (fMatrix3x3.a12 * fMatrix3x32.a12) + (fMatrix3x3.a13 * fMatrix3x32.a13);
        fMatrix3x33.a12 = (fMatrix3x3.a11 * fMatrix3x32.a21) + (fMatrix3x3.a12 * fMatrix3x32.a22) + (fMatrix3x3.a13 * fMatrix3x32.a23);
        fMatrix3x33.a13 = (fMatrix3x3.a11 * fMatrix3x32.a31) + (fMatrix3x3.a12 * fMatrix3x32.a32) + (fMatrix3x3.a13 * fMatrix3x32.a33);
        fMatrix3x33.a21 = (fMatrix3x3.a21 * fMatrix3x32.a11) + (fMatrix3x3.a22 * fMatrix3x32.a12) + (fMatrix3x3.a23 * fMatrix3x32.a13);
        fMatrix3x33.a22 = (fMatrix3x3.a21 * fMatrix3x32.a21) + (fMatrix3x3.a22 * fMatrix3x32.a22) + (fMatrix3x3.a23 * fMatrix3x32.a23);
        fMatrix3x33.a23 = (fMatrix3x3.a21 * fMatrix3x32.a31) + (fMatrix3x3.a22 * fMatrix3x32.a32) + (fMatrix3x3.a23 * fMatrix3x32.a33);
        fMatrix3x33.a31 = (fMatrix3x3.a31 * fMatrix3x32.a11) + (fMatrix3x3.a32 * fMatrix3x32.a12) + (fMatrix3x3.a33 * fMatrix3x32.a13);
        fMatrix3x33.a32 = (fMatrix3x3.a31 * fMatrix3x32.a21) + (fMatrix3x3.a32 * fMatrix3x32.a22) + (fMatrix3x3.a33 * fMatrix3x32.a23);
        fMatrix3x33.a33 = (fMatrix3x3.a31 * fMatrix3x32.a31) + (fMatrix3x3.a32 * fMatrix3x32.a32) + (fMatrix3x3.a33 * fMatrix3x32.a33);
    }

    public static void multAdd(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32, FMatrix3x3 fMatrix3x33) {
        fMatrix3x33.a11 += (fMatrix3x3.a11 * fMatrix3x32.a11) + (fMatrix3x3.a12 * fMatrix3x32.a21) + (fMatrix3x3.a13 * fMatrix3x32.a31);
        fMatrix3x33.a12 += (fMatrix3x3.a11 * fMatrix3x32.a12) + (fMatrix3x3.a12 * fMatrix3x32.a22) + (fMatrix3x3.a13 * fMatrix3x32.a32);
        fMatrix3x33.a13 += (fMatrix3x3.a11 * fMatrix3x32.a13) + (fMatrix3x3.a12 * fMatrix3x32.a23) + (fMatrix3x3.a13 * fMatrix3x32.a33);
        fMatrix3x33.a21 += (fMatrix3x3.a21 * fMatrix3x32.a11) + (fMatrix3x3.a22 * fMatrix3x32.a21) + (fMatrix3x3.a23 * fMatrix3x32.a31);
        fMatrix3x33.a22 += (fMatrix3x3.a21 * fMatrix3x32.a12) + (fMatrix3x3.a22 * fMatrix3x32.a22) + (fMatrix3x3.a23 * fMatrix3x32.a32);
        fMatrix3x33.a23 += (fMatrix3x3.a21 * fMatrix3x32.a13) + (fMatrix3x3.a22 * fMatrix3x32.a23) + (fMatrix3x3.a23 * fMatrix3x32.a33);
        fMatrix3x33.a31 += (fMatrix3x3.a31 * fMatrix3x32.a11) + (fMatrix3x3.a32 * fMatrix3x32.a21) + (fMatrix3x3.a33 * fMatrix3x32.a31);
        fMatrix3x33.a32 += (fMatrix3x3.a31 * fMatrix3x32.a12) + (fMatrix3x3.a32 * fMatrix3x32.a22) + (fMatrix3x3.a33 * fMatrix3x32.a32);
        fMatrix3x33.a33 += (fMatrix3x3.a31 * fMatrix3x32.a13) + (fMatrix3x3.a32 * fMatrix3x32.a23) + (fMatrix3x3.a33 * fMatrix3x32.a33);
    }

    public static void multAddTransA(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32, FMatrix3x3 fMatrix3x33) {
        fMatrix3x33.a11 += (fMatrix3x3.a11 * fMatrix3x32.a11) + (fMatrix3x3.a21 * fMatrix3x32.a21) + (fMatrix3x3.a31 * fMatrix3x32.a31);
        fMatrix3x33.a12 += (fMatrix3x3.a11 * fMatrix3x32.a12) + (fMatrix3x3.a21 * fMatrix3x32.a22) + (fMatrix3x3.a31 * fMatrix3x32.a32);
        fMatrix3x33.a13 += (fMatrix3x3.a11 * fMatrix3x32.a13) + (fMatrix3x3.a21 * fMatrix3x32.a23) + (fMatrix3x3.a31 * fMatrix3x32.a33);
        fMatrix3x33.a21 += (fMatrix3x3.a12 * fMatrix3x32.a11) + (fMatrix3x3.a22 * fMatrix3x32.a21) + (fMatrix3x3.a32 * fMatrix3x32.a31);
        fMatrix3x33.a22 += (fMatrix3x3.a12 * fMatrix3x32.a12) + (fMatrix3x3.a22 * fMatrix3x32.a22) + (fMatrix3x3.a32 * fMatrix3x32.a32);
        fMatrix3x33.a23 += (fMatrix3x3.a12 * fMatrix3x32.a13) + (fMatrix3x3.a22 * fMatrix3x32.a23) + (fMatrix3x3.a32 * fMatrix3x32.a33);
        fMatrix3x33.a31 += (fMatrix3x3.a13 * fMatrix3x32.a11) + (fMatrix3x3.a23 * fMatrix3x32.a21) + (fMatrix3x3.a33 * fMatrix3x32.a31);
        fMatrix3x33.a32 += (fMatrix3x3.a13 * fMatrix3x32.a12) + (fMatrix3x3.a23 * fMatrix3x32.a22) + (fMatrix3x3.a33 * fMatrix3x32.a32);
        fMatrix3x33.a33 += (fMatrix3x3.a13 * fMatrix3x32.a13) + (fMatrix3x3.a23 * fMatrix3x32.a23) + (fMatrix3x3.a33 * fMatrix3x32.a33);
    }

    public static void multAddTransAB(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32, FMatrix3x3 fMatrix3x33) {
        fMatrix3x33.a11 += (fMatrix3x3.a11 * fMatrix3x32.a11) + (fMatrix3x3.a21 * fMatrix3x32.a12) + (fMatrix3x3.a31 * fMatrix3x32.a13);
        fMatrix3x33.a12 += (fMatrix3x3.a11 * fMatrix3x32.a21) + (fMatrix3x3.a21 * fMatrix3x32.a22) + (fMatrix3x3.a31 * fMatrix3x32.a23);
        fMatrix3x33.a13 += (fMatrix3x3.a11 * fMatrix3x32.a31) + (fMatrix3x3.a21 * fMatrix3x32.a32) + (fMatrix3x3.a31 * fMatrix3x32.a33);
        fMatrix3x33.a21 += (fMatrix3x3.a12 * fMatrix3x32.a11) + (fMatrix3x3.a22 * fMatrix3x32.a12) + (fMatrix3x3.a32 * fMatrix3x32.a13);
        fMatrix3x33.a22 += (fMatrix3x3.a12 * fMatrix3x32.a21) + (fMatrix3x3.a22 * fMatrix3x32.a22) + (fMatrix3x3.a32 * fMatrix3x32.a23);
        fMatrix3x33.a23 += (fMatrix3x3.a12 * fMatrix3x32.a31) + (fMatrix3x3.a22 * fMatrix3x32.a32) + (fMatrix3x3.a32 * fMatrix3x32.a33);
        fMatrix3x33.a31 += (fMatrix3x3.a13 * fMatrix3x32.a11) + (fMatrix3x3.a23 * fMatrix3x32.a12) + (fMatrix3x3.a33 * fMatrix3x32.a13);
        fMatrix3x33.a32 += (fMatrix3x3.a13 * fMatrix3x32.a21) + (fMatrix3x3.a23 * fMatrix3x32.a22) + (fMatrix3x3.a33 * fMatrix3x32.a23);
        fMatrix3x33.a33 += (fMatrix3x3.a13 * fMatrix3x32.a31) + (fMatrix3x3.a23 * fMatrix3x32.a32) + (fMatrix3x3.a33 * fMatrix3x32.a33);
    }

    public static void multAddTransB(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32, FMatrix3x3 fMatrix3x33) {
        fMatrix3x33.a11 += (fMatrix3x3.a11 * fMatrix3x32.a11) + (fMatrix3x3.a12 * fMatrix3x32.a12) + (fMatrix3x3.a13 * fMatrix3x32.a13);
        fMatrix3x33.a12 += (fMatrix3x3.a11 * fMatrix3x32.a21) + (fMatrix3x3.a12 * fMatrix3x32.a22) + (fMatrix3x3.a13 * fMatrix3x32.a23);
        fMatrix3x33.a13 += (fMatrix3x3.a11 * fMatrix3x32.a31) + (fMatrix3x3.a12 * fMatrix3x32.a32) + (fMatrix3x3.a13 * fMatrix3x32.a33);
        fMatrix3x33.a21 += (fMatrix3x3.a21 * fMatrix3x32.a11) + (fMatrix3x3.a22 * fMatrix3x32.a12) + (fMatrix3x3.a23 * fMatrix3x32.a13);
        fMatrix3x33.a22 += (fMatrix3x3.a21 * fMatrix3x32.a21) + (fMatrix3x3.a22 * fMatrix3x32.a22) + (fMatrix3x3.a23 * fMatrix3x32.a23);
        fMatrix3x33.a23 += (fMatrix3x3.a21 * fMatrix3x32.a31) + (fMatrix3x3.a22 * fMatrix3x32.a32) + (fMatrix3x3.a23 * fMatrix3x32.a33);
        fMatrix3x33.a31 += (fMatrix3x3.a31 * fMatrix3x32.a11) + (fMatrix3x3.a32 * fMatrix3x32.a12) + (fMatrix3x3.a33 * fMatrix3x32.a13);
        fMatrix3x33.a32 += (fMatrix3x3.a31 * fMatrix3x32.a21) + (fMatrix3x3.a32 * fMatrix3x32.a22) + (fMatrix3x3.a33 * fMatrix3x32.a23);
        fMatrix3x33.a33 += (fMatrix3x3.a31 * fMatrix3x32.a31) + (fMatrix3x3.a32 * fMatrix3x32.a32) + (fMatrix3x3.a33 * fMatrix3x32.a33);
    }

    public static void mult(FMatrix3x3 fMatrix3x3, FMatrix3 fMatrix3, FMatrix3 fMatrix32) {
        fMatrix32.f2420a1 = (fMatrix3x3.a11 * fMatrix3.f2420a1) + (fMatrix3x3.a12 * fMatrix3.f2421a2) + (fMatrix3x3.a13 * fMatrix3.f2422a3);
        fMatrix32.f2421a2 = (fMatrix3x3.a21 * fMatrix3.f2420a1) + (fMatrix3x3.a22 * fMatrix3.f2421a2) + (fMatrix3x3.a23 * fMatrix3.f2422a3);
        fMatrix32.f2422a3 = (fMatrix3x3.a31 * fMatrix3.f2420a1) + (fMatrix3x3.a32 * fMatrix3.f2421a2) + (fMatrix3x3.a33 * fMatrix3.f2422a3);
    }

    public static void mult(FMatrix3 fMatrix3, FMatrix3x3 fMatrix3x3, FMatrix3 fMatrix32) {
        fMatrix32.f2420a1 = (fMatrix3.f2420a1 * fMatrix3x3.a11) + (fMatrix3.f2421a2 * fMatrix3x3.a21) + (fMatrix3.f2422a3 * fMatrix3x3.a31);
        fMatrix32.f2421a2 = (fMatrix3.f2420a1 * fMatrix3x3.a12) + (fMatrix3.f2421a2 * fMatrix3x3.a22) + (fMatrix3.f2422a3 * fMatrix3x3.a32);
        fMatrix32.f2422a3 = (fMatrix3.f2420a1 * fMatrix3x3.a13) + (fMatrix3.f2421a2 * fMatrix3x3.a23) + (fMatrix3.f2422a3 * fMatrix3x3.a33);
    }

    public static float dot(FMatrix3 fMatrix3, FMatrix3 fMatrix32) {
        return (fMatrix3.f2420a1 * fMatrix32.f2420a1) + (fMatrix3.f2421a2 * fMatrix32.f2421a2) + (fMatrix3.f2422a3 * fMatrix32.f2422a3);
    }

    public static void setIdentity(FMatrix3x3 fMatrix3x3) {
        fMatrix3x3.a11 = 1.0f;
        fMatrix3x3.a21 = 0.0f;
        fMatrix3x3.a31 = 0.0f;
        fMatrix3x3.a12 = 0.0f;
        fMatrix3x3.a22 = 1.0f;
        fMatrix3x3.a32 = 0.0f;
        fMatrix3x3.a13 = 0.0f;
        fMatrix3x3.a23 = 0.0f;
        fMatrix3x3.a33 = 1.0f;
    }

    public static boolean invert(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32) {
        float fElementMaxAbs = 1.0f / elementMaxAbs(fMatrix3x3);
        float f = fMatrix3x3.a11 * fElementMaxAbs;
        float f2 = fMatrix3x3.a12 * fElementMaxAbs;
        float f3 = fMatrix3x3.a13 * fElementMaxAbs;
        float f4 = fMatrix3x3.a21 * fElementMaxAbs;
        float f5 = fMatrix3x3.a22 * fElementMaxAbs;
        float f6 = fMatrix3x3.a23 * fElementMaxAbs;
        float f7 = fMatrix3x3.a31 * fElementMaxAbs;
        float f8 = fMatrix3x3.a32 * fElementMaxAbs;
        float f9 = fMatrix3x3.a33 * fElementMaxAbs;
        float f10 = (f5 * f9) - (f6 * f8);
        float f11 = -((f4 * f9) - (f6 * f7));
        float f12 = (f4 * f8) - (f5 * f7);
        float f13 = -((f2 * f9) - (f3 * f8));
        float f14 = (f9 * f) - (f3 * f7);
        float f15 = -((f8 * f) - (f7 * f2));
        float f16 = (f2 * f6) - (f3 * f5);
        float f17 = -((f6 * f) - (f3 * f4));
        float f18 = (f5 * f) - (f4 * f2);
        float f19 = (((f * f10) + (f2 * f11)) + (f3 * f12)) / fElementMaxAbs;
        fMatrix3x32.a11 = f10 / f19;
        fMatrix3x32.a12 = f13 / f19;
        fMatrix3x32.a13 = f16 / f19;
        fMatrix3x32.a21 = f11 / f19;
        fMatrix3x32.a22 = f14 / f19;
        fMatrix3x32.a23 = f17 / f19;
        fMatrix3x32.a31 = f12 / f19;
        fMatrix3x32.a32 = f15 / f19;
        fMatrix3x32.a33 = f18 / f19;
        return (Float.isNaN(f19) || Float.isInfinite(f19)) ? false : true;
    }

    public static float det(FMatrix3x3 fMatrix3x3) {
        return ((fMatrix3x3.a11 * ((fMatrix3x3.a22 * fMatrix3x3.a33) - (fMatrix3x3.a23 * fMatrix3x3.a32))) - (fMatrix3x3.a12 * ((fMatrix3x3.a21 * fMatrix3x3.a33) - (fMatrix3x3.a23 * fMatrix3x3.a31)))) + (fMatrix3x3.a13 * ((fMatrix3x3.a21 * fMatrix3x3.a32) - (fMatrix3x3.a31 * fMatrix3x3.a22)));
    }

    public static float trace(FMatrix3x3 fMatrix3x3) {
        return fMatrix3x3.a11 + fMatrix3x3.a22 + fMatrix3x3.a33;
    }

    public static void diag(FMatrix3x3 fMatrix3x3, FMatrix3 fMatrix3) {
        fMatrix3.f2420a1 = fMatrix3x3.a11;
        fMatrix3.f2421a2 = fMatrix3x3.a22;
        fMatrix3.f2422a3 = fMatrix3x3.a33;
    }

    public static float elementMax(FMatrix3x3 fMatrix3x3) {
        float f = fMatrix3x3.a11;
        if (fMatrix3x3.a12 > f) {
            f = fMatrix3x3.a12;
        }
        if (fMatrix3x3.a13 > f) {
            f = fMatrix3x3.a13;
        }
        if (fMatrix3x3.a21 > f) {
            f = fMatrix3x3.a21;
        }
        if (fMatrix3x3.a22 > f) {
            f = fMatrix3x3.a22;
        }
        if (fMatrix3x3.a23 > f) {
            f = fMatrix3x3.a23;
        }
        if (fMatrix3x3.a31 > f) {
            f = fMatrix3x3.a31;
        }
        if (fMatrix3x3.a32 > f) {
            f = fMatrix3x3.a32;
        }
        return fMatrix3x3.a33 > f ? fMatrix3x3.a33 : f;
    }

    public static float elementMax(FMatrix3 fMatrix3) {
        float f = fMatrix3.f2420a1;
        if (fMatrix3.f2421a2 > f) {
            f = fMatrix3.f2421a2;
        }
        return fMatrix3.f2422a3 > f ? fMatrix3.f2422a3 : f;
    }

    public static float elementMaxAbs(FMatrix3x3 fMatrix3x3) {
        float fAbs = Math.abs(fMatrix3x3.a11);
        float fAbs2 = Math.abs(fMatrix3x3.a12);
        if (fAbs2 > fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix3x3.a13);
        if (fAbs3 > fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix3x3.a21);
        if (fAbs4 > fAbs) {
            fAbs = fAbs4;
        }
        float fAbs5 = Math.abs(fMatrix3x3.a22);
        if (fAbs5 > fAbs) {
            fAbs = fAbs5;
        }
        float fAbs6 = Math.abs(fMatrix3x3.a23);
        if (fAbs6 > fAbs) {
            fAbs = fAbs6;
        }
        float fAbs7 = Math.abs(fMatrix3x3.a31);
        if (fAbs7 > fAbs) {
            fAbs = fAbs7;
        }
        float fAbs8 = Math.abs(fMatrix3x3.a32);
        if (fAbs8 > fAbs) {
            fAbs = fAbs8;
        }
        float fAbs9 = Math.abs(fMatrix3x3.a33);
        return fAbs9 > fAbs ? fAbs9 : fAbs;
    }

    public static float elementMaxAbs(FMatrix3 fMatrix3) {
        float fAbs = Math.abs(fMatrix3.f2420a1);
        float fAbs2 = Math.abs(fMatrix3.f2421a2);
        if (fAbs2 > fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix3.f2421a2);
        if (fAbs3 > fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix3.f2422a3);
        return fAbs4 > fAbs ? fAbs4 : fAbs;
    }

    public static float elementMin(FMatrix3x3 fMatrix3x3) {
        float f = fMatrix3x3.a11;
        if (fMatrix3x3.a12 < f) {
            f = fMatrix3x3.a12;
        }
        if (fMatrix3x3.a13 < f) {
            f = fMatrix3x3.a13;
        }
        if (fMatrix3x3.a21 < f) {
            f = fMatrix3x3.a21;
        }
        if (fMatrix3x3.a22 < f) {
            f = fMatrix3x3.a22;
        }
        if (fMatrix3x3.a23 < f) {
            f = fMatrix3x3.a23;
        }
        if (fMatrix3x3.a31 < f) {
            f = fMatrix3x3.a31;
        }
        if (fMatrix3x3.a32 < f) {
            f = fMatrix3x3.a32;
        }
        return fMatrix3x3.a33 < f ? fMatrix3x3.a33 : f;
    }

    public static float elementMin(FMatrix3 fMatrix3) {
        float f = fMatrix3.f2420a1;
        if (fMatrix3.f2421a2 < f) {
            f = fMatrix3.f2421a2;
        }
        return fMatrix3.f2422a3 < f ? fMatrix3.f2422a3 : f;
    }

    public static float elementMinAbs(FMatrix3x3 fMatrix3x3) {
        float fAbs = Math.abs(fMatrix3x3.a11);
        float fAbs2 = Math.abs(fMatrix3x3.a12);
        if (fAbs2 < fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix3x3.a13);
        if (fAbs3 < fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix3x3.a21);
        if (fAbs4 < fAbs) {
            fAbs = fAbs4;
        }
        float fAbs5 = Math.abs(fMatrix3x3.a22);
        if (fAbs5 < fAbs) {
            fAbs = fAbs5;
        }
        float fAbs6 = Math.abs(fMatrix3x3.a23);
        if (fAbs6 < fAbs) {
            fAbs = fAbs6;
        }
        float fAbs7 = Math.abs(fMatrix3x3.a31);
        if (fAbs7 < fAbs) {
            fAbs = fAbs7;
        }
        float fAbs8 = Math.abs(fMatrix3x3.a32);
        if (fAbs8 < fAbs) {
            fAbs = fAbs8;
        }
        float fAbs9 = Math.abs(fMatrix3x3.a33);
        return fAbs9 < fAbs ? fAbs9 : fAbs;
    }

    public static float elementMinAbs(FMatrix3 fMatrix3) {
        float fAbs = Math.abs(fMatrix3.f2420a1);
        float fAbs2 = Math.abs(fMatrix3.f2420a1);
        if (fAbs2 < fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix3.f2421a2);
        if (fAbs3 < fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix3.f2422a3);
        return fAbs4 < fAbs ? fAbs4 : fAbs;
    }

    public static void elementMult(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32) {
        fMatrix3x3.a11 *= fMatrix3x32.a11;
        fMatrix3x3.a12 *= fMatrix3x32.a12;
        fMatrix3x3.a13 *= fMatrix3x32.a13;
        fMatrix3x3.a21 *= fMatrix3x32.a21;
        fMatrix3x3.a22 *= fMatrix3x32.a22;
        fMatrix3x3.a23 *= fMatrix3x32.a23;
        fMatrix3x3.a31 *= fMatrix3x32.a31;
        fMatrix3x3.a32 *= fMatrix3x32.a32;
        fMatrix3x3.a33 *= fMatrix3x32.a33;
    }

    public static void elementMult(FMatrix3 fMatrix3, FMatrix3 fMatrix32) {
        fMatrix3.f2420a1 *= fMatrix32.f2420a1;
        fMatrix3.f2421a2 *= fMatrix32.f2421a2;
        fMatrix3.f2422a3 *= fMatrix32.f2422a3;
    }

    public static void elementMult(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32, FMatrix3x3 fMatrix3x33) {
        fMatrix3x33.a11 = fMatrix3x3.a11 * fMatrix3x32.a11;
        fMatrix3x33.a12 = fMatrix3x3.a12 * fMatrix3x32.a12;
        fMatrix3x33.a13 = fMatrix3x3.a13 * fMatrix3x32.a13;
        fMatrix3x33.a21 = fMatrix3x3.a21 * fMatrix3x32.a21;
        fMatrix3x33.a22 = fMatrix3x3.a22 * fMatrix3x32.a22;
        fMatrix3x33.a23 = fMatrix3x3.a23 * fMatrix3x32.a23;
        fMatrix3x33.a31 = fMatrix3x3.a31 * fMatrix3x32.a31;
        fMatrix3x33.a32 = fMatrix3x3.a32 * fMatrix3x32.a32;
        fMatrix3x33.a33 = fMatrix3x3.a33 * fMatrix3x32.a33;
    }

    public static void elementMult(FMatrix3 fMatrix3, FMatrix3 fMatrix32, FMatrix3 fMatrix33) {
        fMatrix33.f2420a1 = fMatrix3.f2420a1 * fMatrix32.f2420a1;
        fMatrix33.f2421a2 = fMatrix3.f2421a2 * fMatrix32.f2421a2;
        fMatrix33.f2422a3 = fMatrix3.f2422a3 * fMatrix32.f2422a3;
    }

    public static void elementDiv(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32) {
        fMatrix3x3.a11 /= fMatrix3x32.a11;
        fMatrix3x3.a12 /= fMatrix3x32.a12;
        fMatrix3x3.a13 /= fMatrix3x32.a13;
        fMatrix3x3.a21 /= fMatrix3x32.a21;
        fMatrix3x3.a22 /= fMatrix3x32.a22;
        fMatrix3x3.a23 /= fMatrix3x32.a23;
        fMatrix3x3.a31 /= fMatrix3x32.a31;
        fMatrix3x3.a32 /= fMatrix3x32.a32;
        fMatrix3x3.a33 /= fMatrix3x32.a33;
    }

    public static void elementDiv(FMatrix3 fMatrix3, FMatrix3 fMatrix32) {
        fMatrix3.f2420a1 /= fMatrix32.f2420a1;
        fMatrix3.f2421a2 /= fMatrix32.f2421a2;
        fMatrix3.f2422a3 /= fMatrix32.f2422a3;
    }

    public static void elementDiv(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32, FMatrix3x3 fMatrix3x33) {
        fMatrix3x33.a11 = fMatrix3x3.a11 / fMatrix3x32.a11;
        fMatrix3x33.a12 = fMatrix3x3.a12 / fMatrix3x32.a12;
        fMatrix3x33.a13 = fMatrix3x3.a13 / fMatrix3x32.a13;
        fMatrix3x33.a21 = fMatrix3x3.a21 / fMatrix3x32.a21;
        fMatrix3x33.a22 = fMatrix3x3.a22 / fMatrix3x32.a22;
        fMatrix3x33.a23 = fMatrix3x3.a23 / fMatrix3x32.a23;
        fMatrix3x33.a31 = fMatrix3x3.a31 / fMatrix3x32.a31;
        fMatrix3x33.a32 = fMatrix3x3.a32 / fMatrix3x32.a32;
        fMatrix3x33.a33 = fMatrix3x3.a33 / fMatrix3x32.a33;
    }

    public static void elementDiv(FMatrix3 fMatrix3, FMatrix3 fMatrix32, FMatrix3 fMatrix33) {
        fMatrix33.f2420a1 = fMatrix3.f2420a1 / fMatrix32.f2420a1;
        fMatrix33.f2421a2 = fMatrix3.f2421a2 / fMatrix32.f2421a2;
        fMatrix33.f2422a3 = fMatrix3.f2422a3 / fMatrix32.f2422a3;
    }

    public static void scale(float f, FMatrix3x3 fMatrix3x3) {
        fMatrix3x3.a11 *= f;
        fMatrix3x3.a12 *= f;
        fMatrix3x3.a13 *= f;
        fMatrix3x3.a21 *= f;
        fMatrix3x3.a22 *= f;
        fMatrix3x3.a23 *= f;
        fMatrix3x3.a31 *= f;
        fMatrix3x3.a32 *= f;
        fMatrix3x3.a33 *= f;
    }

    public static void scale(float f, FMatrix3 fMatrix3) {
        fMatrix3.f2420a1 *= f;
        fMatrix3.f2421a2 *= f;
        fMatrix3.f2422a3 *= f;
    }

    public static void scale(float f, FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32) {
        fMatrix3x32.a11 = fMatrix3x3.a11 * f;
        fMatrix3x32.a12 = fMatrix3x3.a12 * f;
        fMatrix3x32.a13 = fMatrix3x3.a13 * f;
        fMatrix3x32.a21 = fMatrix3x3.a21 * f;
        fMatrix3x32.a22 = fMatrix3x3.a22 * f;
        fMatrix3x32.a23 = fMatrix3x3.a23 * f;
        fMatrix3x32.a31 = fMatrix3x3.a31 * f;
        fMatrix3x32.a32 = fMatrix3x3.a32 * f;
        fMatrix3x32.a33 = fMatrix3x3.a33 * f;
    }

    public static void scale(float f, FMatrix3 fMatrix3, FMatrix3 fMatrix32) {
        fMatrix32.f2420a1 = fMatrix3.f2420a1 * f;
        fMatrix32.f2421a2 = fMatrix3.f2421a2 * f;
        fMatrix32.f2422a3 = fMatrix3.f2422a3 * f;
    }

    public static void divide(FMatrix3x3 fMatrix3x3, float f) {
        fMatrix3x3.a11 /= f;
        fMatrix3x3.a12 /= f;
        fMatrix3x3.a13 /= f;
        fMatrix3x3.a21 /= f;
        fMatrix3x3.a22 /= f;
        fMatrix3x3.a23 /= f;
        fMatrix3x3.a31 /= f;
        fMatrix3x3.a32 /= f;
        fMatrix3x3.a33 /= f;
    }

    public static void divide(FMatrix3 fMatrix3, float f) {
        fMatrix3.f2420a1 /= f;
        fMatrix3.f2421a2 /= f;
        fMatrix3.f2422a3 /= f;
    }

    public static void divide(FMatrix3x3 fMatrix3x3, float f, FMatrix3x3 fMatrix3x32) {
        fMatrix3x32.a11 = fMatrix3x3.a11 / f;
        fMatrix3x32.a12 = fMatrix3x3.a12 / f;
        fMatrix3x32.a13 = fMatrix3x3.a13 / f;
        fMatrix3x32.a21 = fMatrix3x3.a21 / f;
        fMatrix3x32.a22 = fMatrix3x3.a22 / f;
        fMatrix3x32.a23 = fMatrix3x3.a23 / f;
        fMatrix3x32.a31 = fMatrix3x3.a31 / f;
        fMatrix3x32.a32 = fMatrix3x3.a32 / f;
        fMatrix3x32.a33 = fMatrix3x3.a33 / f;
    }

    public static void divide(FMatrix3 fMatrix3, float f, FMatrix3 fMatrix32) {
        fMatrix32.f2420a1 = fMatrix3.f2420a1 / f;
        fMatrix32.f2421a2 = fMatrix3.f2421a2 / f;
        fMatrix32.f2422a3 = fMatrix3.f2422a3 / f;
    }

    public static void changeSign(FMatrix3x3 fMatrix3x3) {
        fMatrix3x3.a11 = -fMatrix3x3.a11;
        fMatrix3x3.a12 = -fMatrix3x3.a12;
        fMatrix3x3.a13 = -fMatrix3x3.a13;
        fMatrix3x3.a21 = -fMatrix3x3.a21;
        fMatrix3x3.a22 = -fMatrix3x3.a22;
        fMatrix3x3.a23 = -fMatrix3x3.a23;
        fMatrix3x3.a31 = -fMatrix3x3.a31;
        fMatrix3x3.a32 = -fMatrix3x3.a32;
        fMatrix3x3.a33 = -fMatrix3x3.a33;
    }

    public static void changeSign(FMatrix3 fMatrix3) {
        fMatrix3.f2420a1 = -fMatrix3.f2420a1;
        fMatrix3.f2421a2 = -fMatrix3.f2421a2;
        fMatrix3.f2422a3 = -fMatrix3.f2422a3;
    }

    public static void fill(FMatrix3x3 fMatrix3x3, float f) {
        fMatrix3x3.a11 = f;
        fMatrix3x3.a12 = f;
        fMatrix3x3.a13 = f;
        fMatrix3x3.a21 = f;
        fMatrix3x3.a22 = f;
        fMatrix3x3.a23 = f;
        fMatrix3x3.a31 = f;
        fMatrix3x3.a32 = f;
        fMatrix3x3.a33 = f;
    }

    public static void fill(FMatrix3 fMatrix3, float f) {
        fMatrix3.f2420a1 = f;
        fMatrix3.f2421a2 = f;
        fMatrix3.f2422a3 = f;
    }

    public static FMatrix3 extractRow(FMatrix3x3 fMatrix3x3, int i, FMatrix3 fMatrix3) {
        if (fMatrix3 == null) {
            fMatrix3 = new FMatrix3();
        }
        if (i == 0) {
            fMatrix3.f2420a1 = fMatrix3x3.a11;
            fMatrix3.f2421a2 = fMatrix3x3.a12;
            fMatrix3.f2422a3 = fMatrix3x3.a13;
            return fMatrix3;
        }
        if (i == 1) {
            fMatrix3.f2420a1 = fMatrix3x3.a21;
            fMatrix3.f2421a2 = fMatrix3x3.a22;
            fMatrix3.f2422a3 = fMatrix3x3.a23;
            return fMatrix3;
        }
        if (i == 2) {
            fMatrix3.f2420a1 = fMatrix3x3.a31;
            fMatrix3.f2421a2 = fMatrix3x3.a32;
            fMatrix3.f2422a3 = fMatrix3x3.a33;
            return fMatrix3;
        }
        throw new IllegalArgumentException("Out of bounds row.  row = " + i);
    }

    public static FMatrix3 extractColumn(FMatrix3x3 fMatrix3x3, int i, FMatrix3 fMatrix3) {
        if (fMatrix3 == null) {
            fMatrix3 = new FMatrix3();
        }
        if (i == 0) {
            fMatrix3.f2420a1 = fMatrix3x3.a11;
            fMatrix3.f2421a2 = fMatrix3x3.a21;
            fMatrix3.f2422a3 = fMatrix3x3.a31;
            return fMatrix3;
        }
        if (i == 1) {
            fMatrix3.f2420a1 = fMatrix3x3.a12;
            fMatrix3.f2421a2 = fMatrix3x3.a22;
            fMatrix3.f2422a3 = fMatrix3x3.a32;
            return fMatrix3;
        }
        if (i == 2) {
            fMatrix3.f2420a1 = fMatrix3x3.a13;
            fMatrix3.f2421a2 = fMatrix3x3.a23;
            fMatrix3.f2422a3 = fMatrix3x3.a33;
            return fMatrix3;
        }
        throw new IllegalArgumentException("Out of bounds column.  column = " + i);
    }
}
