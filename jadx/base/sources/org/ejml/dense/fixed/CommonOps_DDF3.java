package org.ejml.dense.fixed;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrix3;
import org.ejml.data.DMatrix3x3;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_DDF3 {
    public static void add(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32, DMatrix3x3 dMatrix3x33) {
        dMatrix3x33.a11 = dMatrix3x3.a11 + dMatrix3x32.a11;
        dMatrix3x33.a12 = dMatrix3x3.a12 + dMatrix3x32.a12;
        dMatrix3x33.a13 = dMatrix3x3.a13 + dMatrix3x32.a13;
        dMatrix3x33.a21 = dMatrix3x3.a21 + dMatrix3x32.a21;
        dMatrix3x33.a22 = dMatrix3x3.a22 + dMatrix3x32.a22;
        dMatrix3x33.a23 = dMatrix3x3.a23 + dMatrix3x32.a23;
        dMatrix3x33.a31 = dMatrix3x3.a31 + dMatrix3x32.a31;
        dMatrix3x33.a32 = dMatrix3x3.a32 + dMatrix3x32.a32;
        dMatrix3x33.a33 = dMatrix3x3.a33 + dMatrix3x32.a33;
    }

    public static void add(DMatrix3 dMatrix3, DMatrix3 dMatrix32, DMatrix3 dMatrix33) {
        dMatrix33.f2399a1 = dMatrix3.f2399a1 + dMatrix32.f2399a1;
        dMatrix33.f2400a2 = dMatrix3.f2400a2 + dMatrix32.f2400a2;
        dMatrix33.f2401a3 = dMatrix3.f2401a3 + dMatrix32.f2401a3;
    }

    public static void addEquals(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32) {
        dMatrix3x3.a11 += dMatrix3x32.a11;
        dMatrix3x3.a12 += dMatrix3x32.a12;
        dMatrix3x3.a13 += dMatrix3x32.a13;
        dMatrix3x3.a21 += dMatrix3x32.a21;
        dMatrix3x3.a22 += dMatrix3x32.a22;
        dMatrix3x3.a23 += dMatrix3x32.a23;
        dMatrix3x3.a31 += dMatrix3x32.a31;
        dMatrix3x3.a32 += dMatrix3x32.a32;
        dMatrix3x3.a33 += dMatrix3x32.a33;
    }

    public static void addEquals(DMatrix3 dMatrix3, DMatrix3 dMatrix32) {
        dMatrix3.f2399a1 += dMatrix32.f2399a1;
        dMatrix3.f2400a2 += dMatrix32.f2400a2;
        dMatrix3.f2401a3 += dMatrix32.f2401a3;
    }

    public static void subtract(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32, DMatrix3x3 dMatrix3x33) {
        dMatrix3x33.a11 = dMatrix3x3.a11 - dMatrix3x32.a11;
        dMatrix3x33.a12 = dMatrix3x3.a12 - dMatrix3x32.a12;
        dMatrix3x33.a13 = dMatrix3x3.a13 - dMatrix3x32.a13;
        dMatrix3x33.a21 = dMatrix3x3.a21 - dMatrix3x32.a21;
        dMatrix3x33.a22 = dMatrix3x3.a22 - dMatrix3x32.a22;
        dMatrix3x33.a23 = dMatrix3x3.a23 - dMatrix3x32.a23;
        dMatrix3x33.a31 = dMatrix3x3.a31 - dMatrix3x32.a31;
        dMatrix3x33.a32 = dMatrix3x3.a32 - dMatrix3x32.a32;
        dMatrix3x33.a33 = dMatrix3x3.a33 - dMatrix3x32.a33;
    }

    public static void subtract(DMatrix3 dMatrix3, DMatrix3 dMatrix32, DMatrix3 dMatrix33) {
        dMatrix33.f2399a1 = dMatrix3.f2399a1 - dMatrix32.f2399a1;
        dMatrix33.f2400a2 = dMatrix3.f2400a2 - dMatrix32.f2400a2;
        dMatrix33.f2401a3 = dMatrix3.f2401a3 - dMatrix32.f2401a3;
    }

    public static void subtractEquals(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32) {
        dMatrix3x3.a11 -= dMatrix3x32.a11;
        dMatrix3x3.a12 -= dMatrix3x32.a12;
        dMatrix3x3.a13 -= dMatrix3x32.a13;
        dMatrix3x3.a21 -= dMatrix3x32.a21;
        dMatrix3x3.a22 -= dMatrix3x32.a22;
        dMatrix3x3.a23 -= dMatrix3x32.a23;
        dMatrix3x3.a31 -= dMatrix3x32.a31;
        dMatrix3x3.a32 -= dMatrix3x32.a32;
        dMatrix3x3.a33 -= dMatrix3x32.a33;
    }

    public static void subtractEquals(DMatrix3 dMatrix3, DMatrix3 dMatrix32) {
        dMatrix3.f2399a1 -= dMatrix32.f2399a1;
        dMatrix3.f2400a2 -= dMatrix32.f2400a2;
        dMatrix3.f2401a3 -= dMatrix32.f2401a3;
    }

    public static void transpose(DMatrix3x3 dMatrix3x3) {
        double d = dMatrix3x3.a12;
        dMatrix3x3.a12 = dMatrix3x3.a21;
        dMatrix3x3.a21 = d;
        double d2 = dMatrix3x3.a13;
        dMatrix3x3.a13 = dMatrix3x3.a31;
        dMatrix3x3.a31 = d2;
        double d3 = dMatrix3x3.a23;
        dMatrix3x3.a23 = dMatrix3x3.a32;
        dMatrix3x3.a32 = d3;
    }

    public static DMatrix3x3 transpose(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32) {
        if (dMatrix3x3 == null) {
            dMatrix3x3 = new DMatrix3x3();
        }
        dMatrix3x32.a11 = dMatrix3x3.a11;
        dMatrix3x32.a12 = dMatrix3x3.a21;
        dMatrix3x32.a13 = dMatrix3x3.a31;
        dMatrix3x32.a21 = dMatrix3x3.a12;
        dMatrix3x32.a22 = dMatrix3x3.a22;
        dMatrix3x32.a23 = dMatrix3x3.a32;
        dMatrix3x32.a31 = dMatrix3x3.a13;
        dMatrix3x32.a32 = dMatrix3x3.a23;
        dMatrix3x32.a33 = dMatrix3x3.a33;
        return dMatrix3x32;
    }

    public static void mult(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32, DMatrix3x3 dMatrix3x33) {
        dMatrix3x33.a11 = (dMatrix3x3.a11 * dMatrix3x32.a11) + (dMatrix3x3.a12 * dMatrix3x32.a21) + (dMatrix3x3.a13 * dMatrix3x32.a31);
        dMatrix3x33.a12 = (dMatrix3x3.a11 * dMatrix3x32.a12) + (dMatrix3x3.a12 * dMatrix3x32.a22) + (dMatrix3x3.a13 * dMatrix3x32.a32);
        dMatrix3x33.a13 = (dMatrix3x3.a11 * dMatrix3x32.a13) + (dMatrix3x3.a12 * dMatrix3x32.a23) + (dMatrix3x3.a13 * dMatrix3x32.a33);
        dMatrix3x33.a21 = (dMatrix3x3.a21 * dMatrix3x32.a11) + (dMatrix3x3.a22 * dMatrix3x32.a21) + (dMatrix3x3.a23 * dMatrix3x32.a31);
        dMatrix3x33.a22 = (dMatrix3x3.a21 * dMatrix3x32.a12) + (dMatrix3x3.a22 * dMatrix3x32.a22) + (dMatrix3x3.a23 * dMatrix3x32.a32);
        dMatrix3x33.a23 = (dMatrix3x3.a21 * dMatrix3x32.a13) + (dMatrix3x3.a22 * dMatrix3x32.a23) + (dMatrix3x3.a23 * dMatrix3x32.a33);
        dMatrix3x33.a31 = (dMatrix3x3.a31 * dMatrix3x32.a11) + (dMatrix3x3.a32 * dMatrix3x32.a21) + (dMatrix3x3.a33 * dMatrix3x32.a31);
        dMatrix3x33.a32 = (dMatrix3x3.a31 * dMatrix3x32.a12) + (dMatrix3x3.a32 * dMatrix3x32.a22) + (dMatrix3x3.a33 * dMatrix3x32.a32);
        dMatrix3x33.a33 = (dMatrix3x3.a31 * dMatrix3x32.a13) + (dMatrix3x3.a32 * dMatrix3x32.a23) + (dMatrix3x3.a33 * dMatrix3x32.a33);
    }

    public static void multTransA(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32, DMatrix3x3 dMatrix3x33) {
        dMatrix3x33.a11 = (dMatrix3x3.a11 * dMatrix3x32.a11) + (dMatrix3x3.a21 * dMatrix3x32.a21) + (dMatrix3x3.a31 * dMatrix3x32.a31);
        dMatrix3x33.a12 = (dMatrix3x3.a11 * dMatrix3x32.a12) + (dMatrix3x3.a21 * dMatrix3x32.a22) + (dMatrix3x3.a31 * dMatrix3x32.a32);
        dMatrix3x33.a13 = (dMatrix3x3.a11 * dMatrix3x32.a13) + (dMatrix3x3.a21 * dMatrix3x32.a23) + (dMatrix3x3.a31 * dMatrix3x32.a33);
        dMatrix3x33.a21 = (dMatrix3x3.a12 * dMatrix3x32.a11) + (dMatrix3x3.a22 * dMatrix3x32.a21) + (dMatrix3x3.a32 * dMatrix3x32.a31);
        dMatrix3x33.a22 = (dMatrix3x3.a12 * dMatrix3x32.a12) + (dMatrix3x3.a22 * dMatrix3x32.a22) + (dMatrix3x3.a32 * dMatrix3x32.a32);
        dMatrix3x33.a23 = (dMatrix3x3.a12 * dMatrix3x32.a13) + (dMatrix3x3.a22 * dMatrix3x32.a23) + (dMatrix3x3.a32 * dMatrix3x32.a33);
        dMatrix3x33.a31 = (dMatrix3x3.a13 * dMatrix3x32.a11) + (dMatrix3x3.a23 * dMatrix3x32.a21) + (dMatrix3x3.a33 * dMatrix3x32.a31);
        dMatrix3x33.a32 = (dMatrix3x3.a13 * dMatrix3x32.a12) + (dMatrix3x3.a23 * dMatrix3x32.a22) + (dMatrix3x3.a33 * dMatrix3x32.a32);
        dMatrix3x33.a33 = (dMatrix3x3.a13 * dMatrix3x32.a13) + (dMatrix3x3.a23 * dMatrix3x32.a23) + (dMatrix3x3.a33 * dMatrix3x32.a33);
    }

    public static void multTransAB(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32, DMatrix3x3 dMatrix3x33) {
        dMatrix3x33.a11 = (dMatrix3x3.a11 * dMatrix3x32.a11) + (dMatrix3x3.a21 * dMatrix3x32.a12) + (dMatrix3x3.a31 * dMatrix3x32.a13);
        dMatrix3x33.a12 = (dMatrix3x3.a11 * dMatrix3x32.a21) + (dMatrix3x3.a21 * dMatrix3x32.a22) + (dMatrix3x3.a31 * dMatrix3x32.a23);
        dMatrix3x33.a13 = (dMatrix3x3.a11 * dMatrix3x32.a31) + (dMatrix3x3.a21 * dMatrix3x32.a32) + (dMatrix3x3.a31 * dMatrix3x32.a33);
        dMatrix3x33.a21 = (dMatrix3x3.a12 * dMatrix3x32.a11) + (dMatrix3x3.a22 * dMatrix3x32.a12) + (dMatrix3x3.a32 * dMatrix3x32.a13);
        dMatrix3x33.a22 = (dMatrix3x3.a12 * dMatrix3x32.a21) + (dMatrix3x3.a22 * dMatrix3x32.a22) + (dMatrix3x3.a32 * dMatrix3x32.a23);
        dMatrix3x33.a23 = (dMatrix3x3.a12 * dMatrix3x32.a31) + (dMatrix3x3.a22 * dMatrix3x32.a32) + (dMatrix3x3.a32 * dMatrix3x32.a33);
        dMatrix3x33.a31 = (dMatrix3x3.a13 * dMatrix3x32.a11) + (dMatrix3x3.a23 * dMatrix3x32.a12) + (dMatrix3x3.a33 * dMatrix3x32.a13);
        dMatrix3x33.a32 = (dMatrix3x3.a13 * dMatrix3x32.a21) + (dMatrix3x3.a23 * dMatrix3x32.a22) + (dMatrix3x3.a33 * dMatrix3x32.a23);
        dMatrix3x33.a33 = (dMatrix3x3.a13 * dMatrix3x32.a31) + (dMatrix3x3.a23 * dMatrix3x32.a32) + (dMatrix3x3.a33 * dMatrix3x32.a33);
    }

    public static void multTransB(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32, DMatrix3x3 dMatrix3x33) {
        dMatrix3x33.a11 = (dMatrix3x3.a11 * dMatrix3x32.a11) + (dMatrix3x3.a12 * dMatrix3x32.a12) + (dMatrix3x3.a13 * dMatrix3x32.a13);
        dMatrix3x33.a12 = (dMatrix3x3.a11 * dMatrix3x32.a21) + (dMatrix3x3.a12 * dMatrix3x32.a22) + (dMatrix3x3.a13 * dMatrix3x32.a23);
        dMatrix3x33.a13 = (dMatrix3x3.a11 * dMatrix3x32.a31) + (dMatrix3x3.a12 * dMatrix3x32.a32) + (dMatrix3x3.a13 * dMatrix3x32.a33);
        dMatrix3x33.a21 = (dMatrix3x3.a21 * dMatrix3x32.a11) + (dMatrix3x3.a22 * dMatrix3x32.a12) + (dMatrix3x3.a23 * dMatrix3x32.a13);
        dMatrix3x33.a22 = (dMatrix3x3.a21 * dMatrix3x32.a21) + (dMatrix3x3.a22 * dMatrix3x32.a22) + (dMatrix3x3.a23 * dMatrix3x32.a23);
        dMatrix3x33.a23 = (dMatrix3x3.a21 * dMatrix3x32.a31) + (dMatrix3x3.a22 * dMatrix3x32.a32) + (dMatrix3x3.a23 * dMatrix3x32.a33);
        dMatrix3x33.a31 = (dMatrix3x3.a31 * dMatrix3x32.a11) + (dMatrix3x3.a32 * dMatrix3x32.a12) + (dMatrix3x3.a33 * dMatrix3x32.a13);
        dMatrix3x33.a32 = (dMatrix3x3.a31 * dMatrix3x32.a21) + (dMatrix3x3.a32 * dMatrix3x32.a22) + (dMatrix3x3.a33 * dMatrix3x32.a23);
        dMatrix3x33.a33 = (dMatrix3x3.a31 * dMatrix3x32.a31) + (dMatrix3x3.a32 * dMatrix3x32.a32) + (dMatrix3x3.a33 * dMatrix3x32.a33);
    }

    public static void multAdd(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32, DMatrix3x3 dMatrix3x33) {
        dMatrix3x33.a11 += (dMatrix3x3.a11 * dMatrix3x32.a11) + (dMatrix3x3.a12 * dMatrix3x32.a21) + (dMatrix3x3.a13 * dMatrix3x32.a31);
        dMatrix3x33.a12 += (dMatrix3x3.a11 * dMatrix3x32.a12) + (dMatrix3x3.a12 * dMatrix3x32.a22) + (dMatrix3x3.a13 * dMatrix3x32.a32);
        dMatrix3x33.a13 += (dMatrix3x3.a11 * dMatrix3x32.a13) + (dMatrix3x3.a12 * dMatrix3x32.a23) + (dMatrix3x3.a13 * dMatrix3x32.a33);
        dMatrix3x33.a21 += (dMatrix3x3.a21 * dMatrix3x32.a11) + (dMatrix3x3.a22 * dMatrix3x32.a21) + (dMatrix3x3.a23 * dMatrix3x32.a31);
        dMatrix3x33.a22 += (dMatrix3x3.a21 * dMatrix3x32.a12) + (dMatrix3x3.a22 * dMatrix3x32.a22) + (dMatrix3x3.a23 * dMatrix3x32.a32);
        dMatrix3x33.a23 += (dMatrix3x3.a21 * dMatrix3x32.a13) + (dMatrix3x3.a22 * dMatrix3x32.a23) + (dMatrix3x3.a23 * dMatrix3x32.a33);
        dMatrix3x33.a31 += (dMatrix3x3.a31 * dMatrix3x32.a11) + (dMatrix3x3.a32 * dMatrix3x32.a21) + (dMatrix3x3.a33 * dMatrix3x32.a31);
        dMatrix3x33.a32 += (dMatrix3x3.a31 * dMatrix3x32.a12) + (dMatrix3x3.a32 * dMatrix3x32.a22) + (dMatrix3x3.a33 * dMatrix3x32.a32);
        dMatrix3x33.a33 += (dMatrix3x3.a31 * dMatrix3x32.a13) + (dMatrix3x3.a32 * dMatrix3x32.a23) + (dMatrix3x3.a33 * dMatrix3x32.a33);
    }

    public static void multAddTransA(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32, DMatrix3x3 dMatrix3x33) {
        dMatrix3x33.a11 += (dMatrix3x3.a11 * dMatrix3x32.a11) + (dMatrix3x3.a21 * dMatrix3x32.a21) + (dMatrix3x3.a31 * dMatrix3x32.a31);
        dMatrix3x33.a12 += (dMatrix3x3.a11 * dMatrix3x32.a12) + (dMatrix3x3.a21 * dMatrix3x32.a22) + (dMatrix3x3.a31 * dMatrix3x32.a32);
        dMatrix3x33.a13 += (dMatrix3x3.a11 * dMatrix3x32.a13) + (dMatrix3x3.a21 * dMatrix3x32.a23) + (dMatrix3x3.a31 * dMatrix3x32.a33);
        dMatrix3x33.a21 += (dMatrix3x3.a12 * dMatrix3x32.a11) + (dMatrix3x3.a22 * dMatrix3x32.a21) + (dMatrix3x3.a32 * dMatrix3x32.a31);
        dMatrix3x33.a22 += (dMatrix3x3.a12 * dMatrix3x32.a12) + (dMatrix3x3.a22 * dMatrix3x32.a22) + (dMatrix3x3.a32 * dMatrix3x32.a32);
        dMatrix3x33.a23 += (dMatrix3x3.a12 * dMatrix3x32.a13) + (dMatrix3x3.a22 * dMatrix3x32.a23) + (dMatrix3x3.a32 * dMatrix3x32.a33);
        dMatrix3x33.a31 += (dMatrix3x3.a13 * dMatrix3x32.a11) + (dMatrix3x3.a23 * dMatrix3x32.a21) + (dMatrix3x3.a33 * dMatrix3x32.a31);
        dMatrix3x33.a32 += (dMatrix3x3.a13 * dMatrix3x32.a12) + (dMatrix3x3.a23 * dMatrix3x32.a22) + (dMatrix3x3.a33 * dMatrix3x32.a32);
        dMatrix3x33.a33 += (dMatrix3x3.a13 * dMatrix3x32.a13) + (dMatrix3x3.a23 * dMatrix3x32.a23) + (dMatrix3x3.a33 * dMatrix3x32.a33);
    }

    public static void multAddTransAB(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32, DMatrix3x3 dMatrix3x33) {
        dMatrix3x33.a11 += (dMatrix3x3.a11 * dMatrix3x32.a11) + (dMatrix3x3.a21 * dMatrix3x32.a12) + (dMatrix3x3.a31 * dMatrix3x32.a13);
        dMatrix3x33.a12 += (dMatrix3x3.a11 * dMatrix3x32.a21) + (dMatrix3x3.a21 * dMatrix3x32.a22) + (dMatrix3x3.a31 * dMatrix3x32.a23);
        dMatrix3x33.a13 += (dMatrix3x3.a11 * dMatrix3x32.a31) + (dMatrix3x3.a21 * dMatrix3x32.a32) + (dMatrix3x3.a31 * dMatrix3x32.a33);
        dMatrix3x33.a21 += (dMatrix3x3.a12 * dMatrix3x32.a11) + (dMatrix3x3.a22 * dMatrix3x32.a12) + (dMatrix3x3.a32 * dMatrix3x32.a13);
        dMatrix3x33.a22 += (dMatrix3x3.a12 * dMatrix3x32.a21) + (dMatrix3x3.a22 * dMatrix3x32.a22) + (dMatrix3x3.a32 * dMatrix3x32.a23);
        dMatrix3x33.a23 += (dMatrix3x3.a12 * dMatrix3x32.a31) + (dMatrix3x3.a22 * dMatrix3x32.a32) + (dMatrix3x3.a32 * dMatrix3x32.a33);
        dMatrix3x33.a31 += (dMatrix3x3.a13 * dMatrix3x32.a11) + (dMatrix3x3.a23 * dMatrix3x32.a12) + (dMatrix3x3.a33 * dMatrix3x32.a13);
        dMatrix3x33.a32 += (dMatrix3x3.a13 * dMatrix3x32.a21) + (dMatrix3x3.a23 * dMatrix3x32.a22) + (dMatrix3x3.a33 * dMatrix3x32.a23);
        dMatrix3x33.a33 += (dMatrix3x3.a13 * dMatrix3x32.a31) + (dMatrix3x3.a23 * dMatrix3x32.a32) + (dMatrix3x3.a33 * dMatrix3x32.a33);
    }

    public static void multAddTransB(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32, DMatrix3x3 dMatrix3x33) {
        dMatrix3x33.a11 += (dMatrix3x3.a11 * dMatrix3x32.a11) + (dMatrix3x3.a12 * dMatrix3x32.a12) + (dMatrix3x3.a13 * dMatrix3x32.a13);
        dMatrix3x33.a12 += (dMatrix3x3.a11 * dMatrix3x32.a21) + (dMatrix3x3.a12 * dMatrix3x32.a22) + (dMatrix3x3.a13 * dMatrix3x32.a23);
        dMatrix3x33.a13 += (dMatrix3x3.a11 * dMatrix3x32.a31) + (dMatrix3x3.a12 * dMatrix3x32.a32) + (dMatrix3x3.a13 * dMatrix3x32.a33);
        dMatrix3x33.a21 += (dMatrix3x3.a21 * dMatrix3x32.a11) + (dMatrix3x3.a22 * dMatrix3x32.a12) + (dMatrix3x3.a23 * dMatrix3x32.a13);
        dMatrix3x33.a22 += (dMatrix3x3.a21 * dMatrix3x32.a21) + (dMatrix3x3.a22 * dMatrix3x32.a22) + (dMatrix3x3.a23 * dMatrix3x32.a23);
        dMatrix3x33.a23 += (dMatrix3x3.a21 * dMatrix3x32.a31) + (dMatrix3x3.a22 * dMatrix3x32.a32) + (dMatrix3x3.a23 * dMatrix3x32.a33);
        dMatrix3x33.a31 += (dMatrix3x3.a31 * dMatrix3x32.a11) + (dMatrix3x3.a32 * dMatrix3x32.a12) + (dMatrix3x3.a33 * dMatrix3x32.a13);
        dMatrix3x33.a32 += (dMatrix3x3.a31 * dMatrix3x32.a21) + (dMatrix3x3.a32 * dMatrix3x32.a22) + (dMatrix3x3.a33 * dMatrix3x32.a23);
        dMatrix3x33.a33 += (dMatrix3x3.a31 * dMatrix3x32.a31) + (dMatrix3x3.a32 * dMatrix3x32.a32) + (dMatrix3x3.a33 * dMatrix3x32.a33);
    }

    public static void mult(DMatrix3x3 dMatrix3x3, DMatrix3 dMatrix3, DMatrix3 dMatrix32) {
        dMatrix32.f2399a1 = (dMatrix3x3.a11 * dMatrix3.f2399a1) + (dMatrix3x3.a12 * dMatrix3.f2400a2) + (dMatrix3x3.a13 * dMatrix3.f2401a3);
        dMatrix32.f2400a2 = (dMatrix3x3.a21 * dMatrix3.f2399a1) + (dMatrix3x3.a22 * dMatrix3.f2400a2) + (dMatrix3x3.a23 * dMatrix3.f2401a3);
        dMatrix32.f2401a3 = (dMatrix3x3.a31 * dMatrix3.f2399a1) + (dMatrix3x3.a32 * dMatrix3.f2400a2) + (dMatrix3x3.a33 * dMatrix3.f2401a3);
    }

    public static void mult(DMatrix3 dMatrix3, DMatrix3x3 dMatrix3x3, DMatrix3 dMatrix32) {
        dMatrix32.f2399a1 = (dMatrix3.f2399a1 * dMatrix3x3.a11) + (dMatrix3.f2400a2 * dMatrix3x3.a21) + (dMatrix3.f2401a3 * dMatrix3x3.a31);
        dMatrix32.f2400a2 = (dMatrix3.f2399a1 * dMatrix3x3.a12) + (dMatrix3.f2400a2 * dMatrix3x3.a22) + (dMatrix3.f2401a3 * dMatrix3x3.a32);
        dMatrix32.f2401a3 = (dMatrix3.f2399a1 * dMatrix3x3.a13) + (dMatrix3.f2400a2 * dMatrix3x3.a23) + (dMatrix3.f2401a3 * dMatrix3x3.a33);
    }

    public static double dot(DMatrix3 dMatrix3, DMatrix3 dMatrix32) {
        return (dMatrix3.f2399a1 * dMatrix32.f2399a1) + (dMatrix3.f2400a2 * dMatrix32.f2400a2) + (dMatrix3.f2401a3 * dMatrix32.f2401a3);
    }

    public static void setIdentity(DMatrix3x3 dMatrix3x3) {
        dMatrix3x3.a11 = 1.0d;
        dMatrix3x3.a21 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix3x3.a31 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix3x3.a12 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix3x3.a22 = 1.0d;
        dMatrix3x3.a32 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix3x3.a13 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix3x3.a23 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix3x3.a33 = 1.0d;
    }

    public static boolean invert(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32) {
        double dElementMaxAbs = 1.0d / elementMaxAbs(dMatrix3x3);
        double d = dMatrix3x3.a11 * dElementMaxAbs;
        double d2 = dMatrix3x3.a12 * dElementMaxAbs;
        double d3 = dMatrix3x3.a13 * dElementMaxAbs;
        double d4 = dMatrix3x3.a21 * dElementMaxAbs;
        double d5 = dMatrix3x3.a22 * dElementMaxAbs;
        double d6 = dMatrix3x3.a23 * dElementMaxAbs;
        double d7 = dMatrix3x3.a31 * dElementMaxAbs;
        double d8 = dMatrix3x3.a32 * dElementMaxAbs;
        double d9 = dMatrix3x3.a33 * dElementMaxAbs;
        double d10 = (d5 * d9) - (d6 * d8);
        double d11 = -((d4 * d9) - (d6 * d7));
        double d12 = (d4 * d8) - (d5 * d7);
        double d13 = -((d2 * d9) - (d3 * d8));
        double d14 = (d * d9) - (d3 * d7);
        double d15 = -((d8 * d) - (d7 * d2));
        double d16 = (d2 * d6) - (d3 * d5);
        double d17 = -((d6 * d) - (d3 * d4));
        double d18 = (d5 * d) - (d4 * d2);
        double d19 = (((d * d10) + (d2 * d11)) + (d3 * d12)) / dElementMaxAbs;
        dMatrix3x32.a11 = d10 / d19;
        dMatrix3x32.a12 = d13 / d19;
        dMatrix3x32.a13 = d16 / d19;
        dMatrix3x32.a21 = d11 / d19;
        dMatrix3x32.a22 = d14 / d19;
        dMatrix3x32.a23 = d17 / d19;
        dMatrix3x32.a31 = d12 / d19;
        dMatrix3x32.a32 = d15 / d19;
        dMatrix3x32.a33 = d18 / d19;
        return (Double.isNaN(d19) || Double.isInfinite(d19)) ? false : true;
    }

    public static double det(DMatrix3x3 dMatrix3x3) {
        return ((dMatrix3x3.a11 * ((dMatrix3x3.a22 * dMatrix3x3.a33) - (dMatrix3x3.a23 * dMatrix3x3.a32))) - (dMatrix3x3.a12 * ((dMatrix3x3.a21 * dMatrix3x3.a33) - (dMatrix3x3.a23 * dMatrix3x3.a31)))) + (dMatrix3x3.a13 * ((dMatrix3x3.a21 * dMatrix3x3.a32) - (dMatrix3x3.a31 * dMatrix3x3.a22)));
    }

    public static double trace(DMatrix3x3 dMatrix3x3) {
        return dMatrix3x3.a11 + dMatrix3x3.a22 + dMatrix3x3.a33;
    }

    public static void diag(DMatrix3x3 dMatrix3x3, DMatrix3 dMatrix3) {
        dMatrix3.f2399a1 = dMatrix3x3.a11;
        dMatrix3.f2400a2 = dMatrix3x3.a22;
        dMatrix3.f2401a3 = dMatrix3x3.a33;
    }

    public static double elementMax(DMatrix3x3 dMatrix3x3) {
        double d = dMatrix3x3.a11;
        if (dMatrix3x3.a12 > d) {
            d = dMatrix3x3.a12;
        }
        if (dMatrix3x3.a13 > d) {
            d = dMatrix3x3.a13;
        }
        if (dMatrix3x3.a21 > d) {
            d = dMatrix3x3.a21;
        }
        if (dMatrix3x3.a22 > d) {
            d = dMatrix3x3.a22;
        }
        if (dMatrix3x3.a23 > d) {
            d = dMatrix3x3.a23;
        }
        if (dMatrix3x3.a31 > d) {
            d = dMatrix3x3.a31;
        }
        if (dMatrix3x3.a32 > d) {
            d = dMatrix3x3.a32;
        }
        return dMatrix3x3.a33 > d ? dMatrix3x3.a33 : d;
    }

    public static double elementMax(DMatrix3 dMatrix3) {
        double d = dMatrix3.f2399a1;
        if (dMatrix3.f2400a2 > d) {
            d = dMatrix3.f2400a2;
        }
        return dMatrix3.f2401a3 > d ? dMatrix3.f2401a3 : d;
    }

    public static double elementMaxAbs(DMatrix3x3 dMatrix3x3) {
        double dAbs = Math.abs(dMatrix3x3.a11);
        double dAbs2 = Math.abs(dMatrix3x3.a12);
        if (dAbs2 > dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix3x3.a13);
        if (dAbs3 > dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix3x3.a21);
        if (dAbs4 > dAbs) {
            dAbs = dAbs4;
        }
        double dAbs5 = Math.abs(dMatrix3x3.a22);
        if (dAbs5 > dAbs) {
            dAbs = dAbs5;
        }
        double dAbs6 = Math.abs(dMatrix3x3.a23);
        if (dAbs6 > dAbs) {
            dAbs = dAbs6;
        }
        double dAbs7 = Math.abs(dMatrix3x3.a31);
        if (dAbs7 > dAbs) {
            dAbs = dAbs7;
        }
        double dAbs8 = Math.abs(dMatrix3x3.a32);
        if (dAbs8 > dAbs) {
            dAbs = dAbs8;
        }
        double dAbs9 = Math.abs(dMatrix3x3.a33);
        return dAbs9 > dAbs ? dAbs9 : dAbs;
    }

    public static double elementMaxAbs(DMatrix3 dMatrix3) {
        double dAbs = Math.abs(dMatrix3.f2399a1);
        double dAbs2 = Math.abs(dMatrix3.f2400a2);
        if (dAbs2 > dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix3.f2400a2);
        if (dAbs3 > dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix3.f2401a3);
        return dAbs4 > dAbs ? dAbs4 : dAbs;
    }

    public static double elementMin(DMatrix3x3 dMatrix3x3) {
        double d = dMatrix3x3.a11;
        if (dMatrix3x3.a12 < d) {
            d = dMatrix3x3.a12;
        }
        if (dMatrix3x3.a13 < d) {
            d = dMatrix3x3.a13;
        }
        if (dMatrix3x3.a21 < d) {
            d = dMatrix3x3.a21;
        }
        if (dMatrix3x3.a22 < d) {
            d = dMatrix3x3.a22;
        }
        if (dMatrix3x3.a23 < d) {
            d = dMatrix3x3.a23;
        }
        if (dMatrix3x3.a31 < d) {
            d = dMatrix3x3.a31;
        }
        if (dMatrix3x3.a32 < d) {
            d = dMatrix3x3.a32;
        }
        return dMatrix3x3.a33 < d ? dMatrix3x3.a33 : d;
    }

    public static double elementMin(DMatrix3 dMatrix3) {
        double d = dMatrix3.f2399a1;
        if (dMatrix3.f2400a2 < d) {
            d = dMatrix3.f2400a2;
        }
        return dMatrix3.f2401a3 < d ? dMatrix3.f2401a3 : d;
    }

    public static double elementMinAbs(DMatrix3x3 dMatrix3x3) {
        double dAbs = Math.abs(dMatrix3x3.a11);
        double dAbs2 = Math.abs(dMatrix3x3.a12);
        if (dAbs2 < dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix3x3.a13);
        if (dAbs3 < dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix3x3.a21);
        if (dAbs4 < dAbs) {
            dAbs = dAbs4;
        }
        double dAbs5 = Math.abs(dMatrix3x3.a22);
        if (dAbs5 < dAbs) {
            dAbs = dAbs5;
        }
        double dAbs6 = Math.abs(dMatrix3x3.a23);
        if (dAbs6 < dAbs) {
            dAbs = dAbs6;
        }
        double dAbs7 = Math.abs(dMatrix3x3.a31);
        if (dAbs7 < dAbs) {
            dAbs = dAbs7;
        }
        double dAbs8 = Math.abs(dMatrix3x3.a32);
        if (dAbs8 < dAbs) {
            dAbs = dAbs8;
        }
        double dAbs9 = Math.abs(dMatrix3x3.a33);
        return dAbs9 < dAbs ? dAbs9 : dAbs;
    }

    public static double elementMinAbs(DMatrix3 dMatrix3) {
        double dAbs = Math.abs(dMatrix3.f2399a1);
        double dAbs2 = Math.abs(dMatrix3.f2399a1);
        if (dAbs2 < dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix3.f2400a2);
        if (dAbs3 < dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix3.f2401a3);
        return dAbs4 < dAbs ? dAbs4 : dAbs;
    }

    public static void elementMult(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32) {
        dMatrix3x3.a11 *= dMatrix3x32.a11;
        dMatrix3x3.a12 *= dMatrix3x32.a12;
        dMatrix3x3.a13 *= dMatrix3x32.a13;
        dMatrix3x3.a21 *= dMatrix3x32.a21;
        dMatrix3x3.a22 *= dMatrix3x32.a22;
        dMatrix3x3.a23 *= dMatrix3x32.a23;
        dMatrix3x3.a31 *= dMatrix3x32.a31;
        dMatrix3x3.a32 *= dMatrix3x32.a32;
        dMatrix3x3.a33 *= dMatrix3x32.a33;
    }

    public static void elementMult(DMatrix3 dMatrix3, DMatrix3 dMatrix32) {
        dMatrix3.f2399a1 *= dMatrix32.f2399a1;
        dMatrix3.f2400a2 *= dMatrix32.f2400a2;
        dMatrix3.f2401a3 *= dMatrix32.f2401a3;
    }

    public static void elementMult(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32, DMatrix3x3 dMatrix3x33) {
        dMatrix3x33.a11 = dMatrix3x3.a11 * dMatrix3x32.a11;
        dMatrix3x33.a12 = dMatrix3x3.a12 * dMatrix3x32.a12;
        dMatrix3x33.a13 = dMatrix3x3.a13 * dMatrix3x32.a13;
        dMatrix3x33.a21 = dMatrix3x3.a21 * dMatrix3x32.a21;
        dMatrix3x33.a22 = dMatrix3x3.a22 * dMatrix3x32.a22;
        dMatrix3x33.a23 = dMatrix3x3.a23 * dMatrix3x32.a23;
        dMatrix3x33.a31 = dMatrix3x3.a31 * dMatrix3x32.a31;
        dMatrix3x33.a32 = dMatrix3x3.a32 * dMatrix3x32.a32;
        dMatrix3x33.a33 = dMatrix3x3.a33 * dMatrix3x32.a33;
    }

    public static void elementMult(DMatrix3 dMatrix3, DMatrix3 dMatrix32, DMatrix3 dMatrix33) {
        dMatrix33.f2399a1 = dMatrix3.f2399a1 * dMatrix32.f2399a1;
        dMatrix33.f2400a2 = dMatrix3.f2400a2 * dMatrix32.f2400a2;
        dMatrix33.f2401a3 = dMatrix3.f2401a3 * dMatrix32.f2401a3;
    }

    public static void elementDiv(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32) {
        dMatrix3x3.a11 /= dMatrix3x32.a11;
        dMatrix3x3.a12 /= dMatrix3x32.a12;
        dMatrix3x3.a13 /= dMatrix3x32.a13;
        dMatrix3x3.a21 /= dMatrix3x32.a21;
        dMatrix3x3.a22 /= dMatrix3x32.a22;
        dMatrix3x3.a23 /= dMatrix3x32.a23;
        dMatrix3x3.a31 /= dMatrix3x32.a31;
        dMatrix3x3.a32 /= dMatrix3x32.a32;
        dMatrix3x3.a33 /= dMatrix3x32.a33;
    }

    public static void elementDiv(DMatrix3 dMatrix3, DMatrix3 dMatrix32) {
        dMatrix3.f2399a1 /= dMatrix32.f2399a1;
        dMatrix3.f2400a2 /= dMatrix32.f2400a2;
        dMatrix3.f2401a3 /= dMatrix32.f2401a3;
    }

    public static void elementDiv(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32, DMatrix3x3 dMatrix3x33) {
        dMatrix3x33.a11 = dMatrix3x3.a11 / dMatrix3x32.a11;
        dMatrix3x33.a12 = dMatrix3x3.a12 / dMatrix3x32.a12;
        dMatrix3x33.a13 = dMatrix3x3.a13 / dMatrix3x32.a13;
        dMatrix3x33.a21 = dMatrix3x3.a21 / dMatrix3x32.a21;
        dMatrix3x33.a22 = dMatrix3x3.a22 / dMatrix3x32.a22;
        dMatrix3x33.a23 = dMatrix3x3.a23 / dMatrix3x32.a23;
        dMatrix3x33.a31 = dMatrix3x3.a31 / dMatrix3x32.a31;
        dMatrix3x33.a32 = dMatrix3x3.a32 / dMatrix3x32.a32;
        dMatrix3x33.a33 = dMatrix3x3.a33 / dMatrix3x32.a33;
    }

    public static void elementDiv(DMatrix3 dMatrix3, DMatrix3 dMatrix32, DMatrix3 dMatrix33) {
        dMatrix33.f2399a1 = dMatrix3.f2399a1 / dMatrix32.f2399a1;
        dMatrix33.f2400a2 = dMatrix3.f2400a2 / dMatrix32.f2400a2;
        dMatrix33.f2401a3 = dMatrix3.f2401a3 / dMatrix32.f2401a3;
    }

    public static void scale(double d, DMatrix3x3 dMatrix3x3) {
        dMatrix3x3.a11 *= d;
        dMatrix3x3.a12 *= d;
        dMatrix3x3.a13 *= d;
        dMatrix3x3.a21 *= d;
        dMatrix3x3.a22 *= d;
        dMatrix3x3.a23 *= d;
        dMatrix3x3.a31 *= d;
        dMatrix3x3.a32 *= d;
        dMatrix3x3.a33 *= d;
    }

    public static void scale(double d, DMatrix3 dMatrix3) {
        dMatrix3.f2399a1 *= d;
        dMatrix3.f2400a2 *= d;
        dMatrix3.f2401a3 *= d;
    }

    public static void scale(double d, DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32) {
        dMatrix3x32.a11 = dMatrix3x3.a11 * d;
        dMatrix3x32.a12 = dMatrix3x3.a12 * d;
        dMatrix3x32.a13 = dMatrix3x3.a13 * d;
        dMatrix3x32.a21 = dMatrix3x3.a21 * d;
        dMatrix3x32.a22 = dMatrix3x3.a22 * d;
        dMatrix3x32.a23 = dMatrix3x3.a23 * d;
        dMatrix3x32.a31 = dMatrix3x3.a31 * d;
        dMatrix3x32.a32 = dMatrix3x3.a32 * d;
        dMatrix3x32.a33 = dMatrix3x3.a33 * d;
    }

    public static void scale(double d, DMatrix3 dMatrix3, DMatrix3 dMatrix32) {
        dMatrix32.f2399a1 = dMatrix3.f2399a1 * d;
        dMatrix32.f2400a2 = dMatrix3.f2400a2 * d;
        dMatrix32.f2401a3 = dMatrix3.f2401a3 * d;
    }

    public static void divide(DMatrix3x3 dMatrix3x3, double d) {
        dMatrix3x3.a11 /= d;
        dMatrix3x3.a12 /= d;
        dMatrix3x3.a13 /= d;
        dMatrix3x3.a21 /= d;
        dMatrix3x3.a22 /= d;
        dMatrix3x3.a23 /= d;
        dMatrix3x3.a31 /= d;
        dMatrix3x3.a32 /= d;
        dMatrix3x3.a33 /= d;
    }

    public static void divide(DMatrix3 dMatrix3, double d) {
        dMatrix3.f2399a1 /= d;
        dMatrix3.f2400a2 /= d;
        dMatrix3.f2401a3 /= d;
    }

    public static void divide(DMatrix3x3 dMatrix3x3, double d, DMatrix3x3 dMatrix3x32) {
        dMatrix3x32.a11 = dMatrix3x3.a11 / d;
        dMatrix3x32.a12 = dMatrix3x3.a12 / d;
        dMatrix3x32.a13 = dMatrix3x3.a13 / d;
        dMatrix3x32.a21 = dMatrix3x3.a21 / d;
        dMatrix3x32.a22 = dMatrix3x3.a22 / d;
        dMatrix3x32.a23 = dMatrix3x3.a23 / d;
        dMatrix3x32.a31 = dMatrix3x3.a31 / d;
        dMatrix3x32.a32 = dMatrix3x3.a32 / d;
        dMatrix3x32.a33 = dMatrix3x3.a33 / d;
    }

    public static void divide(DMatrix3 dMatrix3, double d, DMatrix3 dMatrix32) {
        dMatrix32.f2399a1 = dMatrix3.f2399a1 / d;
        dMatrix32.f2400a2 = dMatrix3.f2400a2 / d;
        dMatrix32.f2401a3 = dMatrix3.f2401a3 / d;
    }

    public static void changeSign(DMatrix3x3 dMatrix3x3) {
        dMatrix3x3.a11 = -dMatrix3x3.a11;
        dMatrix3x3.a12 = -dMatrix3x3.a12;
        dMatrix3x3.a13 = -dMatrix3x3.a13;
        dMatrix3x3.a21 = -dMatrix3x3.a21;
        dMatrix3x3.a22 = -dMatrix3x3.a22;
        dMatrix3x3.a23 = -dMatrix3x3.a23;
        dMatrix3x3.a31 = -dMatrix3x3.a31;
        dMatrix3x3.a32 = -dMatrix3x3.a32;
        dMatrix3x3.a33 = -dMatrix3x3.a33;
    }

    public static void changeSign(DMatrix3 dMatrix3) {
        dMatrix3.f2399a1 = -dMatrix3.f2399a1;
        dMatrix3.f2400a2 = -dMatrix3.f2400a2;
        dMatrix3.f2401a3 = -dMatrix3.f2401a3;
    }

    public static void fill(DMatrix3x3 dMatrix3x3, double d) {
        dMatrix3x3.a11 = d;
        dMatrix3x3.a12 = d;
        dMatrix3x3.a13 = d;
        dMatrix3x3.a21 = d;
        dMatrix3x3.a22 = d;
        dMatrix3x3.a23 = d;
        dMatrix3x3.a31 = d;
        dMatrix3x3.a32 = d;
        dMatrix3x3.a33 = d;
    }

    public static void fill(DMatrix3 dMatrix3, double d) {
        dMatrix3.f2399a1 = d;
        dMatrix3.f2400a2 = d;
        dMatrix3.f2401a3 = d;
    }

    public static DMatrix3 extractRow(DMatrix3x3 dMatrix3x3, int i, DMatrix3 dMatrix3) {
        if (dMatrix3 == null) {
            dMatrix3 = new DMatrix3();
        }
        if (i == 0) {
            dMatrix3.f2399a1 = dMatrix3x3.a11;
            dMatrix3.f2400a2 = dMatrix3x3.a12;
            dMatrix3.f2401a3 = dMatrix3x3.a13;
            return dMatrix3;
        }
        if (i == 1) {
            dMatrix3.f2399a1 = dMatrix3x3.a21;
            dMatrix3.f2400a2 = dMatrix3x3.a22;
            dMatrix3.f2401a3 = dMatrix3x3.a23;
            return dMatrix3;
        }
        if (i == 2) {
            dMatrix3.f2399a1 = dMatrix3x3.a31;
            dMatrix3.f2400a2 = dMatrix3x3.a32;
            dMatrix3.f2401a3 = dMatrix3x3.a33;
            return dMatrix3;
        }
        throw new IllegalArgumentException("Out of bounds row.  row = " + i);
    }

    public static DMatrix3 extractColumn(DMatrix3x3 dMatrix3x3, int i, DMatrix3 dMatrix3) {
        if (dMatrix3 == null) {
            dMatrix3 = new DMatrix3();
        }
        if (i == 0) {
            dMatrix3.f2399a1 = dMatrix3x3.a11;
            dMatrix3.f2400a2 = dMatrix3x3.a21;
            dMatrix3.f2401a3 = dMatrix3x3.a31;
            return dMatrix3;
        }
        if (i == 1) {
            dMatrix3.f2399a1 = dMatrix3x3.a12;
            dMatrix3.f2400a2 = dMatrix3x3.a22;
            dMatrix3.f2401a3 = dMatrix3x3.a32;
            return dMatrix3;
        }
        if (i == 2) {
            dMatrix3.f2399a1 = dMatrix3x3.a13;
            dMatrix3.f2400a2 = dMatrix3x3.a23;
            dMatrix3.f2401a3 = dMatrix3x3.a33;
            return dMatrix3;
        }
        throw new IllegalArgumentException("Out of bounds column.  column = " + i);
    }
}
