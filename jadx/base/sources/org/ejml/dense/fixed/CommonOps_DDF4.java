package org.ejml.dense.fixed;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrix4;
import org.ejml.data.DMatrix4x4;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_DDF4 {
    public static void add(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42, DMatrix4x4 dMatrix4x43) {
        dMatrix4x43.a11 = dMatrix4x4.a11 + dMatrix4x42.a11;
        dMatrix4x43.a12 = dMatrix4x4.a12 + dMatrix4x42.a12;
        dMatrix4x43.a13 = dMatrix4x4.a13 + dMatrix4x42.a13;
        dMatrix4x43.a14 = dMatrix4x4.a14 + dMatrix4x42.a14;
        dMatrix4x43.a21 = dMatrix4x4.a21 + dMatrix4x42.a21;
        dMatrix4x43.a22 = dMatrix4x4.a22 + dMatrix4x42.a22;
        dMatrix4x43.a23 = dMatrix4x4.a23 + dMatrix4x42.a23;
        dMatrix4x43.a24 = dMatrix4x4.a24 + dMatrix4x42.a24;
        dMatrix4x43.a31 = dMatrix4x4.a31 + dMatrix4x42.a31;
        dMatrix4x43.a32 = dMatrix4x4.a32 + dMatrix4x42.a32;
        dMatrix4x43.a33 = dMatrix4x4.a33 + dMatrix4x42.a33;
        dMatrix4x43.a34 = dMatrix4x4.a34 + dMatrix4x42.a34;
        dMatrix4x43.a41 = dMatrix4x4.a41 + dMatrix4x42.a41;
        dMatrix4x43.a42 = dMatrix4x4.a42 + dMatrix4x42.a42;
        dMatrix4x43.a43 = dMatrix4x4.a43 + dMatrix4x42.a43;
        dMatrix4x43.a44 = dMatrix4x4.a44 + dMatrix4x42.a44;
    }

    public static void add(DMatrix4 dMatrix4, DMatrix4 dMatrix42, DMatrix4 dMatrix43) {
        dMatrix43.f2402a1 = dMatrix4.f2402a1 + dMatrix42.f2402a1;
        dMatrix43.f2403a2 = dMatrix4.f2403a2 + dMatrix42.f2403a2;
        dMatrix43.f2404a3 = dMatrix4.f2404a3 + dMatrix42.f2404a3;
        dMatrix43.f2405a4 = dMatrix4.f2405a4 + dMatrix42.f2405a4;
    }

    public static void addEquals(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42) {
        dMatrix4x4.a11 += dMatrix4x42.a11;
        dMatrix4x4.a12 += dMatrix4x42.a12;
        dMatrix4x4.a13 += dMatrix4x42.a13;
        dMatrix4x4.a14 += dMatrix4x42.a14;
        dMatrix4x4.a21 += dMatrix4x42.a21;
        dMatrix4x4.a22 += dMatrix4x42.a22;
        dMatrix4x4.a23 += dMatrix4x42.a23;
        dMatrix4x4.a24 += dMatrix4x42.a24;
        dMatrix4x4.a31 += dMatrix4x42.a31;
        dMatrix4x4.a32 += dMatrix4x42.a32;
        dMatrix4x4.a33 += dMatrix4x42.a33;
        dMatrix4x4.a34 += dMatrix4x42.a34;
        dMatrix4x4.a41 += dMatrix4x42.a41;
        dMatrix4x4.a42 += dMatrix4x42.a42;
        dMatrix4x4.a43 += dMatrix4x42.a43;
        dMatrix4x4.a44 += dMatrix4x42.a44;
    }

    public static void addEquals(DMatrix4 dMatrix4, DMatrix4 dMatrix42) {
        dMatrix4.f2402a1 += dMatrix42.f2402a1;
        dMatrix4.f2403a2 += dMatrix42.f2403a2;
        dMatrix4.f2404a3 += dMatrix42.f2404a3;
        dMatrix4.f2405a4 += dMatrix42.f2405a4;
    }

    public static void subtract(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42, DMatrix4x4 dMatrix4x43) {
        dMatrix4x43.a11 = dMatrix4x4.a11 - dMatrix4x42.a11;
        dMatrix4x43.a12 = dMatrix4x4.a12 - dMatrix4x42.a12;
        dMatrix4x43.a13 = dMatrix4x4.a13 - dMatrix4x42.a13;
        dMatrix4x43.a14 = dMatrix4x4.a14 - dMatrix4x42.a14;
        dMatrix4x43.a21 = dMatrix4x4.a21 - dMatrix4x42.a21;
        dMatrix4x43.a22 = dMatrix4x4.a22 - dMatrix4x42.a22;
        dMatrix4x43.a23 = dMatrix4x4.a23 - dMatrix4x42.a23;
        dMatrix4x43.a24 = dMatrix4x4.a24 - dMatrix4x42.a24;
        dMatrix4x43.a31 = dMatrix4x4.a31 - dMatrix4x42.a31;
        dMatrix4x43.a32 = dMatrix4x4.a32 - dMatrix4x42.a32;
        dMatrix4x43.a33 = dMatrix4x4.a33 - dMatrix4x42.a33;
        dMatrix4x43.a34 = dMatrix4x4.a34 - dMatrix4x42.a34;
        dMatrix4x43.a41 = dMatrix4x4.a41 - dMatrix4x42.a41;
        dMatrix4x43.a42 = dMatrix4x4.a42 - dMatrix4x42.a42;
        dMatrix4x43.a43 = dMatrix4x4.a43 - dMatrix4x42.a43;
        dMatrix4x43.a44 = dMatrix4x4.a44 - dMatrix4x42.a44;
    }

    public static void subtract(DMatrix4 dMatrix4, DMatrix4 dMatrix42, DMatrix4 dMatrix43) {
        dMatrix43.f2402a1 = dMatrix4.f2402a1 - dMatrix42.f2402a1;
        dMatrix43.f2403a2 = dMatrix4.f2403a2 - dMatrix42.f2403a2;
        dMatrix43.f2404a3 = dMatrix4.f2404a3 - dMatrix42.f2404a3;
        dMatrix43.f2405a4 = dMatrix4.f2405a4 - dMatrix42.f2405a4;
    }

    public static void subtractEquals(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42) {
        dMatrix4x4.a11 -= dMatrix4x42.a11;
        dMatrix4x4.a12 -= dMatrix4x42.a12;
        dMatrix4x4.a13 -= dMatrix4x42.a13;
        dMatrix4x4.a14 -= dMatrix4x42.a14;
        dMatrix4x4.a21 -= dMatrix4x42.a21;
        dMatrix4x4.a22 -= dMatrix4x42.a22;
        dMatrix4x4.a23 -= dMatrix4x42.a23;
        dMatrix4x4.a24 -= dMatrix4x42.a24;
        dMatrix4x4.a31 -= dMatrix4x42.a31;
        dMatrix4x4.a32 -= dMatrix4x42.a32;
        dMatrix4x4.a33 -= dMatrix4x42.a33;
        dMatrix4x4.a34 -= dMatrix4x42.a34;
        dMatrix4x4.a41 -= dMatrix4x42.a41;
        dMatrix4x4.a42 -= dMatrix4x42.a42;
        dMatrix4x4.a43 -= dMatrix4x42.a43;
        dMatrix4x4.a44 -= dMatrix4x42.a44;
    }

    public static void subtractEquals(DMatrix4 dMatrix4, DMatrix4 dMatrix42) {
        dMatrix4.f2402a1 -= dMatrix42.f2402a1;
        dMatrix4.f2403a2 -= dMatrix42.f2403a2;
        dMatrix4.f2404a3 -= dMatrix42.f2404a3;
        dMatrix4.f2405a4 -= dMatrix42.f2405a4;
    }

    public static void transpose(DMatrix4x4 dMatrix4x4) {
        double d = dMatrix4x4.a12;
        dMatrix4x4.a12 = dMatrix4x4.a21;
        dMatrix4x4.a21 = d;
        double d2 = dMatrix4x4.a13;
        dMatrix4x4.a13 = dMatrix4x4.a31;
        dMatrix4x4.a31 = d2;
        double d3 = dMatrix4x4.a14;
        dMatrix4x4.a14 = dMatrix4x4.a41;
        dMatrix4x4.a41 = d3;
        double d4 = dMatrix4x4.a23;
        dMatrix4x4.a23 = dMatrix4x4.a32;
        dMatrix4x4.a32 = d4;
        double d5 = dMatrix4x4.a24;
        dMatrix4x4.a24 = dMatrix4x4.a42;
        dMatrix4x4.a42 = d5;
        double d6 = dMatrix4x4.a34;
        dMatrix4x4.a34 = dMatrix4x4.a43;
        dMatrix4x4.a43 = d6;
    }

    public static DMatrix4x4 transpose(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42) {
        if (dMatrix4x4 == null) {
            dMatrix4x4 = new DMatrix4x4();
        }
        dMatrix4x42.a11 = dMatrix4x4.a11;
        dMatrix4x42.a12 = dMatrix4x4.a21;
        dMatrix4x42.a13 = dMatrix4x4.a31;
        dMatrix4x42.a14 = dMatrix4x4.a41;
        dMatrix4x42.a21 = dMatrix4x4.a12;
        dMatrix4x42.a22 = dMatrix4x4.a22;
        dMatrix4x42.a23 = dMatrix4x4.a32;
        dMatrix4x42.a24 = dMatrix4x4.a42;
        dMatrix4x42.a31 = dMatrix4x4.a13;
        dMatrix4x42.a32 = dMatrix4x4.a23;
        dMatrix4x42.a33 = dMatrix4x4.a33;
        dMatrix4x42.a34 = dMatrix4x4.a43;
        dMatrix4x42.a41 = dMatrix4x4.a14;
        dMatrix4x42.a42 = dMatrix4x4.a24;
        dMatrix4x42.a43 = dMatrix4x4.a34;
        dMatrix4x42.a44 = dMatrix4x4.a44;
        return dMatrix4x42;
    }

    public static void mult(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42, DMatrix4x4 dMatrix4x43) {
        dMatrix4x43.a11 = (dMatrix4x4.a11 * dMatrix4x42.a11) + (dMatrix4x4.a12 * dMatrix4x42.a21) + (dMatrix4x4.a13 * dMatrix4x42.a31) + (dMatrix4x4.a14 * dMatrix4x42.a41);
        dMatrix4x43.a12 = (dMatrix4x4.a11 * dMatrix4x42.a12) + (dMatrix4x4.a12 * dMatrix4x42.a22) + (dMatrix4x4.a13 * dMatrix4x42.a32) + (dMatrix4x4.a14 * dMatrix4x42.a42);
        dMatrix4x43.a13 = (dMatrix4x4.a11 * dMatrix4x42.a13) + (dMatrix4x4.a12 * dMatrix4x42.a23) + (dMatrix4x4.a13 * dMatrix4x42.a33) + (dMatrix4x4.a14 * dMatrix4x42.a43);
        dMatrix4x43.a14 = (dMatrix4x4.a11 * dMatrix4x42.a14) + (dMatrix4x4.a12 * dMatrix4x42.a24) + (dMatrix4x4.a13 * dMatrix4x42.a34) + (dMatrix4x4.a14 * dMatrix4x42.a44);
        dMatrix4x43.a21 = (dMatrix4x4.a21 * dMatrix4x42.a11) + (dMatrix4x4.a22 * dMatrix4x42.a21) + (dMatrix4x4.a23 * dMatrix4x42.a31) + (dMatrix4x4.a24 * dMatrix4x42.a41);
        dMatrix4x43.a22 = (dMatrix4x4.a21 * dMatrix4x42.a12) + (dMatrix4x4.a22 * dMatrix4x42.a22) + (dMatrix4x4.a23 * dMatrix4x42.a32) + (dMatrix4x4.a24 * dMatrix4x42.a42);
        dMatrix4x43.a23 = (dMatrix4x4.a21 * dMatrix4x42.a13) + (dMatrix4x4.a22 * dMatrix4x42.a23) + (dMatrix4x4.a23 * dMatrix4x42.a33) + (dMatrix4x4.a24 * dMatrix4x42.a43);
        dMatrix4x43.a24 = (dMatrix4x4.a21 * dMatrix4x42.a14) + (dMatrix4x4.a22 * dMatrix4x42.a24) + (dMatrix4x4.a23 * dMatrix4x42.a34) + (dMatrix4x4.a24 * dMatrix4x42.a44);
        dMatrix4x43.a31 = (dMatrix4x4.a31 * dMatrix4x42.a11) + (dMatrix4x4.a32 * dMatrix4x42.a21) + (dMatrix4x4.a33 * dMatrix4x42.a31) + (dMatrix4x4.a34 * dMatrix4x42.a41);
        dMatrix4x43.a32 = (dMatrix4x4.a31 * dMatrix4x42.a12) + (dMatrix4x4.a32 * dMatrix4x42.a22) + (dMatrix4x4.a33 * dMatrix4x42.a32) + (dMatrix4x4.a34 * dMatrix4x42.a42);
        dMatrix4x43.a33 = (dMatrix4x4.a31 * dMatrix4x42.a13) + (dMatrix4x4.a32 * dMatrix4x42.a23) + (dMatrix4x4.a33 * dMatrix4x42.a33) + (dMatrix4x4.a34 * dMatrix4x42.a43);
        dMatrix4x43.a34 = (dMatrix4x4.a31 * dMatrix4x42.a14) + (dMatrix4x4.a32 * dMatrix4x42.a24) + (dMatrix4x4.a33 * dMatrix4x42.a34) + (dMatrix4x4.a34 * dMatrix4x42.a44);
        dMatrix4x43.a41 = (dMatrix4x4.a41 * dMatrix4x42.a11) + (dMatrix4x4.a42 * dMatrix4x42.a21) + (dMatrix4x4.a43 * dMatrix4x42.a31) + (dMatrix4x4.a44 * dMatrix4x42.a41);
        dMatrix4x43.a42 = (dMatrix4x4.a41 * dMatrix4x42.a12) + (dMatrix4x4.a42 * dMatrix4x42.a22) + (dMatrix4x4.a43 * dMatrix4x42.a32) + (dMatrix4x4.a44 * dMatrix4x42.a42);
        dMatrix4x43.a43 = (dMatrix4x4.a41 * dMatrix4x42.a13) + (dMatrix4x4.a42 * dMatrix4x42.a23) + (dMatrix4x4.a43 * dMatrix4x42.a33) + (dMatrix4x4.a44 * dMatrix4x42.a43);
        dMatrix4x43.a44 = (dMatrix4x4.a41 * dMatrix4x42.a14) + (dMatrix4x4.a42 * dMatrix4x42.a24) + (dMatrix4x4.a43 * dMatrix4x42.a34) + (dMatrix4x4.a44 * dMatrix4x42.a44);
    }

    public static void multTransA(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42, DMatrix4x4 dMatrix4x43) {
        dMatrix4x43.a11 = (dMatrix4x4.a11 * dMatrix4x42.a11) + (dMatrix4x4.a21 * dMatrix4x42.a21) + (dMatrix4x4.a31 * dMatrix4x42.a31) + (dMatrix4x4.a41 * dMatrix4x42.a41);
        dMatrix4x43.a12 = (dMatrix4x4.a11 * dMatrix4x42.a12) + (dMatrix4x4.a21 * dMatrix4x42.a22) + (dMatrix4x4.a31 * dMatrix4x42.a32) + (dMatrix4x4.a41 * dMatrix4x42.a42);
        dMatrix4x43.a13 = (dMatrix4x4.a11 * dMatrix4x42.a13) + (dMatrix4x4.a21 * dMatrix4x42.a23) + (dMatrix4x4.a31 * dMatrix4x42.a33) + (dMatrix4x4.a41 * dMatrix4x42.a43);
        dMatrix4x43.a14 = (dMatrix4x4.a11 * dMatrix4x42.a14) + (dMatrix4x4.a21 * dMatrix4x42.a24) + (dMatrix4x4.a31 * dMatrix4x42.a34) + (dMatrix4x4.a41 * dMatrix4x42.a44);
        dMatrix4x43.a21 = (dMatrix4x4.a12 * dMatrix4x42.a11) + (dMatrix4x4.a22 * dMatrix4x42.a21) + (dMatrix4x4.a32 * dMatrix4x42.a31) + (dMatrix4x4.a42 * dMatrix4x42.a41);
        dMatrix4x43.a22 = (dMatrix4x4.a12 * dMatrix4x42.a12) + (dMatrix4x4.a22 * dMatrix4x42.a22) + (dMatrix4x4.a32 * dMatrix4x42.a32) + (dMatrix4x4.a42 * dMatrix4x42.a42);
        dMatrix4x43.a23 = (dMatrix4x4.a12 * dMatrix4x42.a13) + (dMatrix4x4.a22 * dMatrix4x42.a23) + (dMatrix4x4.a32 * dMatrix4x42.a33) + (dMatrix4x4.a42 * dMatrix4x42.a43);
        dMatrix4x43.a24 = (dMatrix4x4.a12 * dMatrix4x42.a14) + (dMatrix4x4.a22 * dMatrix4x42.a24) + (dMatrix4x4.a32 * dMatrix4x42.a34) + (dMatrix4x4.a42 * dMatrix4x42.a44);
        dMatrix4x43.a31 = (dMatrix4x4.a13 * dMatrix4x42.a11) + (dMatrix4x4.a23 * dMatrix4x42.a21) + (dMatrix4x4.a33 * dMatrix4x42.a31) + (dMatrix4x4.a43 * dMatrix4x42.a41);
        dMatrix4x43.a32 = (dMatrix4x4.a13 * dMatrix4x42.a12) + (dMatrix4x4.a23 * dMatrix4x42.a22) + (dMatrix4x4.a33 * dMatrix4x42.a32) + (dMatrix4x4.a43 * dMatrix4x42.a42);
        dMatrix4x43.a33 = (dMatrix4x4.a13 * dMatrix4x42.a13) + (dMatrix4x4.a23 * dMatrix4x42.a23) + (dMatrix4x4.a33 * dMatrix4x42.a33) + (dMatrix4x4.a43 * dMatrix4x42.a43);
        dMatrix4x43.a34 = (dMatrix4x4.a13 * dMatrix4x42.a14) + (dMatrix4x4.a23 * dMatrix4x42.a24) + (dMatrix4x4.a33 * dMatrix4x42.a34) + (dMatrix4x4.a43 * dMatrix4x42.a44);
        dMatrix4x43.a41 = (dMatrix4x4.a14 * dMatrix4x42.a11) + (dMatrix4x4.a24 * dMatrix4x42.a21) + (dMatrix4x4.a34 * dMatrix4x42.a31) + (dMatrix4x4.a44 * dMatrix4x42.a41);
        dMatrix4x43.a42 = (dMatrix4x4.a14 * dMatrix4x42.a12) + (dMatrix4x4.a24 * dMatrix4x42.a22) + (dMatrix4x4.a34 * dMatrix4x42.a32) + (dMatrix4x4.a44 * dMatrix4x42.a42);
        dMatrix4x43.a43 = (dMatrix4x4.a14 * dMatrix4x42.a13) + (dMatrix4x4.a24 * dMatrix4x42.a23) + (dMatrix4x4.a34 * dMatrix4x42.a33) + (dMatrix4x4.a44 * dMatrix4x42.a43);
        dMatrix4x43.a44 = (dMatrix4x4.a14 * dMatrix4x42.a14) + (dMatrix4x4.a24 * dMatrix4x42.a24) + (dMatrix4x4.a34 * dMatrix4x42.a34) + (dMatrix4x4.a44 * dMatrix4x42.a44);
    }

    public static void multTransAB(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42, DMatrix4x4 dMatrix4x43) {
        dMatrix4x43.a11 = (dMatrix4x4.a11 * dMatrix4x42.a11) + (dMatrix4x4.a21 * dMatrix4x42.a12) + (dMatrix4x4.a31 * dMatrix4x42.a13) + (dMatrix4x4.a41 * dMatrix4x42.a14);
        dMatrix4x43.a12 = (dMatrix4x4.a11 * dMatrix4x42.a21) + (dMatrix4x4.a21 * dMatrix4x42.a22) + (dMatrix4x4.a31 * dMatrix4x42.a23) + (dMatrix4x4.a41 * dMatrix4x42.a24);
        dMatrix4x43.a13 = (dMatrix4x4.a11 * dMatrix4x42.a31) + (dMatrix4x4.a21 * dMatrix4x42.a32) + (dMatrix4x4.a31 * dMatrix4x42.a33) + (dMatrix4x4.a41 * dMatrix4x42.a34);
        dMatrix4x43.a14 = (dMatrix4x4.a11 * dMatrix4x42.a41) + (dMatrix4x4.a21 * dMatrix4x42.a42) + (dMatrix4x4.a31 * dMatrix4x42.a43) + (dMatrix4x4.a41 * dMatrix4x42.a44);
        dMatrix4x43.a21 = (dMatrix4x4.a12 * dMatrix4x42.a11) + (dMatrix4x4.a22 * dMatrix4x42.a12) + (dMatrix4x4.a32 * dMatrix4x42.a13) + (dMatrix4x4.a42 * dMatrix4x42.a14);
        dMatrix4x43.a22 = (dMatrix4x4.a12 * dMatrix4x42.a21) + (dMatrix4x4.a22 * dMatrix4x42.a22) + (dMatrix4x4.a32 * dMatrix4x42.a23) + (dMatrix4x4.a42 * dMatrix4x42.a24);
        dMatrix4x43.a23 = (dMatrix4x4.a12 * dMatrix4x42.a31) + (dMatrix4x4.a22 * dMatrix4x42.a32) + (dMatrix4x4.a32 * dMatrix4x42.a33) + (dMatrix4x4.a42 * dMatrix4x42.a34);
        dMatrix4x43.a24 = (dMatrix4x4.a12 * dMatrix4x42.a41) + (dMatrix4x4.a22 * dMatrix4x42.a42) + (dMatrix4x4.a32 * dMatrix4x42.a43) + (dMatrix4x4.a42 * dMatrix4x42.a44);
        dMatrix4x43.a31 = (dMatrix4x4.a13 * dMatrix4x42.a11) + (dMatrix4x4.a23 * dMatrix4x42.a12) + (dMatrix4x4.a33 * dMatrix4x42.a13) + (dMatrix4x4.a43 * dMatrix4x42.a14);
        dMatrix4x43.a32 = (dMatrix4x4.a13 * dMatrix4x42.a21) + (dMatrix4x4.a23 * dMatrix4x42.a22) + (dMatrix4x4.a33 * dMatrix4x42.a23) + (dMatrix4x4.a43 * dMatrix4x42.a24);
        dMatrix4x43.a33 = (dMatrix4x4.a13 * dMatrix4x42.a31) + (dMatrix4x4.a23 * dMatrix4x42.a32) + (dMatrix4x4.a33 * dMatrix4x42.a33) + (dMatrix4x4.a43 * dMatrix4x42.a34);
        dMatrix4x43.a34 = (dMatrix4x4.a13 * dMatrix4x42.a41) + (dMatrix4x4.a23 * dMatrix4x42.a42) + (dMatrix4x4.a33 * dMatrix4x42.a43) + (dMatrix4x4.a43 * dMatrix4x42.a44);
        dMatrix4x43.a41 = (dMatrix4x4.a14 * dMatrix4x42.a11) + (dMatrix4x4.a24 * dMatrix4x42.a12) + (dMatrix4x4.a34 * dMatrix4x42.a13) + (dMatrix4x4.a44 * dMatrix4x42.a14);
        dMatrix4x43.a42 = (dMatrix4x4.a14 * dMatrix4x42.a21) + (dMatrix4x4.a24 * dMatrix4x42.a22) + (dMatrix4x4.a34 * dMatrix4x42.a23) + (dMatrix4x4.a44 * dMatrix4x42.a24);
        dMatrix4x43.a43 = (dMatrix4x4.a14 * dMatrix4x42.a31) + (dMatrix4x4.a24 * dMatrix4x42.a32) + (dMatrix4x4.a34 * dMatrix4x42.a33) + (dMatrix4x4.a44 * dMatrix4x42.a34);
        dMatrix4x43.a44 = (dMatrix4x4.a14 * dMatrix4x42.a41) + (dMatrix4x4.a24 * dMatrix4x42.a42) + (dMatrix4x4.a34 * dMatrix4x42.a43) + (dMatrix4x4.a44 * dMatrix4x42.a44);
    }

    public static void multTransB(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42, DMatrix4x4 dMatrix4x43) {
        dMatrix4x43.a11 = (dMatrix4x4.a11 * dMatrix4x42.a11) + (dMatrix4x4.a12 * dMatrix4x42.a12) + (dMatrix4x4.a13 * dMatrix4x42.a13) + (dMatrix4x4.a14 * dMatrix4x42.a14);
        dMatrix4x43.a12 = (dMatrix4x4.a11 * dMatrix4x42.a21) + (dMatrix4x4.a12 * dMatrix4x42.a22) + (dMatrix4x4.a13 * dMatrix4x42.a23) + (dMatrix4x4.a14 * dMatrix4x42.a24);
        dMatrix4x43.a13 = (dMatrix4x4.a11 * dMatrix4x42.a31) + (dMatrix4x4.a12 * dMatrix4x42.a32) + (dMatrix4x4.a13 * dMatrix4x42.a33) + (dMatrix4x4.a14 * dMatrix4x42.a34);
        dMatrix4x43.a14 = (dMatrix4x4.a11 * dMatrix4x42.a41) + (dMatrix4x4.a12 * dMatrix4x42.a42) + (dMatrix4x4.a13 * dMatrix4x42.a43) + (dMatrix4x4.a14 * dMatrix4x42.a44);
        dMatrix4x43.a21 = (dMatrix4x4.a21 * dMatrix4x42.a11) + (dMatrix4x4.a22 * dMatrix4x42.a12) + (dMatrix4x4.a23 * dMatrix4x42.a13) + (dMatrix4x4.a24 * dMatrix4x42.a14);
        dMatrix4x43.a22 = (dMatrix4x4.a21 * dMatrix4x42.a21) + (dMatrix4x4.a22 * dMatrix4x42.a22) + (dMatrix4x4.a23 * dMatrix4x42.a23) + (dMatrix4x4.a24 * dMatrix4x42.a24);
        dMatrix4x43.a23 = (dMatrix4x4.a21 * dMatrix4x42.a31) + (dMatrix4x4.a22 * dMatrix4x42.a32) + (dMatrix4x4.a23 * dMatrix4x42.a33) + (dMatrix4x4.a24 * dMatrix4x42.a34);
        dMatrix4x43.a24 = (dMatrix4x4.a21 * dMatrix4x42.a41) + (dMatrix4x4.a22 * dMatrix4x42.a42) + (dMatrix4x4.a23 * dMatrix4x42.a43) + (dMatrix4x4.a24 * dMatrix4x42.a44);
        dMatrix4x43.a31 = (dMatrix4x4.a31 * dMatrix4x42.a11) + (dMatrix4x4.a32 * dMatrix4x42.a12) + (dMatrix4x4.a33 * dMatrix4x42.a13) + (dMatrix4x4.a34 * dMatrix4x42.a14);
        dMatrix4x43.a32 = (dMatrix4x4.a31 * dMatrix4x42.a21) + (dMatrix4x4.a32 * dMatrix4x42.a22) + (dMatrix4x4.a33 * dMatrix4x42.a23) + (dMatrix4x4.a34 * dMatrix4x42.a24);
        dMatrix4x43.a33 = (dMatrix4x4.a31 * dMatrix4x42.a31) + (dMatrix4x4.a32 * dMatrix4x42.a32) + (dMatrix4x4.a33 * dMatrix4x42.a33) + (dMatrix4x4.a34 * dMatrix4x42.a34);
        dMatrix4x43.a34 = (dMatrix4x4.a31 * dMatrix4x42.a41) + (dMatrix4x4.a32 * dMatrix4x42.a42) + (dMatrix4x4.a33 * dMatrix4x42.a43) + (dMatrix4x4.a34 * dMatrix4x42.a44);
        dMatrix4x43.a41 = (dMatrix4x4.a41 * dMatrix4x42.a11) + (dMatrix4x4.a42 * dMatrix4x42.a12) + (dMatrix4x4.a43 * dMatrix4x42.a13) + (dMatrix4x4.a44 * dMatrix4x42.a14);
        dMatrix4x43.a42 = (dMatrix4x4.a41 * dMatrix4x42.a21) + (dMatrix4x4.a42 * dMatrix4x42.a22) + (dMatrix4x4.a43 * dMatrix4x42.a23) + (dMatrix4x4.a44 * dMatrix4x42.a24);
        dMatrix4x43.a43 = (dMatrix4x4.a41 * dMatrix4x42.a31) + (dMatrix4x4.a42 * dMatrix4x42.a32) + (dMatrix4x4.a43 * dMatrix4x42.a33) + (dMatrix4x4.a44 * dMatrix4x42.a34);
        dMatrix4x43.a44 = (dMatrix4x4.a41 * dMatrix4x42.a41) + (dMatrix4x4.a42 * dMatrix4x42.a42) + (dMatrix4x4.a43 * dMatrix4x42.a43) + (dMatrix4x4.a44 * dMatrix4x42.a44);
    }

    public static void multAdd(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42, DMatrix4x4 dMatrix4x43) {
        dMatrix4x43.a11 += (dMatrix4x4.a11 * dMatrix4x42.a11) + (dMatrix4x4.a12 * dMatrix4x42.a21) + (dMatrix4x4.a13 * dMatrix4x42.a31) + (dMatrix4x4.a14 * dMatrix4x42.a41);
        dMatrix4x43.a12 += (dMatrix4x4.a11 * dMatrix4x42.a12) + (dMatrix4x4.a12 * dMatrix4x42.a22) + (dMatrix4x4.a13 * dMatrix4x42.a32) + (dMatrix4x4.a14 * dMatrix4x42.a42);
        dMatrix4x43.a13 += (dMatrix4x4.a11 * dMatrix4x42.a13) + (dMatrix4x4.a12 * dMatrix4x42.a23) + (dMatrix4x4.a13 * dMatrix4x42.a33) + (dMatrix4x4.a14 * dMatrix4x42.a43);
        dMatrix4x43.a14 += (dMatrix4x4.a11 * dMatrix4x42.a14) + (dMatrix4x4.a12 * dMatrix4x42.a24) + (dMatrix4x4.a13 * dMatrix4x42.a34) + (dMatrix4x4.a14 * dMatrix4x42.a44);
        dMatrix4x43.a21 += (dMatrix4x4.a21 * dMatrix4x42.a11) + (dMatrix4x4.a22 * dMatrix4x42.a21) + (dMatrix4x4.a23 * dMatrix4x42.a31) + (dMatrix4x4.a24 * dMatrix4x42.a41);
        dMatrix4x43.a22 += (dMatrix4x4.a21 * dMatrix4x42.a12) + (dMatrix4x4.a22 * dMatrix4x42.a22) + (dMatrix4x4.a23 * dMatrix4x42.a32) + (dMatrix4x4.a24 * dMatrix4x42.a42);
        dMatrix4x43.a23 += (dMatrix4x4.a21 * dMatrix4x42.a13) + (dMatrix4x4.a22 * dMatrix4x42.a23) + (dMatrix4x4.a23 * dMatrix4x42.a33) + (dMatrix4x4.a24 * dMatrix4x42.a43);
        dMatrix4x43.a24 += (dMatrix4x4.a21 * dMatrix4x42.a14) + (dMatrix4x4.a22 * dMatrix4x42.a24) + (dMatrix4x4.a23 * dMatrix4x42.a34) + (dMatrix4x4.a24 * dMatrix4x42.a44);
        dMatrix4x43.a31 += (dMatrix4x4.a31 * dMatrix4x42.a11) + (dMatrix4x4.a32 * dMatrix4x42.a21) + (dMatrix4x4.a33 * dMatrix4x42.a31) + (dMatrix4x4.a34 * dMatrix4x42.a41);
        dMatrix4x43.a32 += (dMatrix4x4.a31 * dMatrix4x42.a12) + (dMatrix4x4.a32 * dMatrix4x42.a22) + (dMatrix4x4.a33 * dMatrix4x42.a32) + (dMatrix4x4.a34 * dMatrix4x42.a42);
        dMatrix4x43.a33 += (dMatrix4x4.a31 * dMatrix4x42.a13) + (dMatrix4x4.a32 * dMatrix4x42.a23) + (dMatrix4x4.a33 * dMatrix4x42.a33) + (dMatrix4x4.a34 * dMatrix4x42.a43);
        dMatrix4x43.a34 += (dMatrix4x4.a31 * dMatrix4x42.a14) + (dMatrix4x4.a32 * dMatrix4x42.a24) + (dMatrix4x4.a33 * dMatrix4x42.a34) + (dMatrix4x4.a34 * dMatrix4x42.a44);
        dMatrix4x43.a41 += (dMatrix4x4.a41 * dMatrix4x42.a11) + (dMatrix4x4.a42 * dMatrix4x42.a21) + (dMatrix4x4.a43 * dMatrix4x42.a31) + (dMatrix4x4.a44 * dMatrix4x42.a41);
        dMatrix4x43.a42 += (dMatrix4x4.a41 * dMatrix4x42.a12) + (dMatrix4x4.a42 * dMatrix4x42.a22) + (dMatrix4x4.a43 * dMatrix4x42.a32) + (dMatrix4x4.a44 * dMatrix4x42.a42);
        dMatrix4x43.a43 += (dMatrix4x4.a41 * dMatrix4x42.a13) + (dMatrix4x4.a42 * dMatrix4x42.a23) + (dMatrix4x4.a43 * dMatrix4x42.a33) + (dMatrix4x4.a44 * dMatrix4x42.a43);
        dMatrix4x43.a44 += (dMatrix4x4.a41 * dMatrix4x42.a14) + (dMatrix4x4.a42 * dMatrix4x42.a24) + (dMatrix4x4.a43 * dMatrix4x42.a34) + (dMatrix4x4.a44 * dMatrix4x42.a44);
    }

    public static void multAddTransA(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42, DMatrix4x4 dMatrix4x43) {
        dMatrix4x43.a11 += (dMatrix4x4.a11 * dMatrix4x42.a11) + (dMatrix4x4.a21 * dMatrix4x42.a21) + (dMatrix4x4.a31 * dMatrix4x42.a31) + (dMatrix4x4.a41 * dMatrix4x42.a41);
        dMatrix4x43.a12 += (dMatrix4x4.a11 * dMatrix4x42.a12) + (dMatrix4x4.a21 * dMatrix4x42.a22) + (dMatrix4x4.a31 * dMatrix4x42.a32) + (dMatrix4x4.a41 * dMatrix4x42.a42);
        dMatrix4x43.a13 += (dMatrix4x4.a11 * dMatrix4x42.a13) + (dMatrix4x4.a21 * dMatrix4x42.a23) + (dMatrix4x4.a31 * dMatrix4x42.a33) + (dMatrix4x4.a41 * dMatrix4x42.a43);
        dMatrix4x43.a14 += (dMatrix4x4.a11 * dMatrix4x42.a14) + (dMatrix4x4.a21 * dMatrix4x42.a24) + (dMatrix4x4.a31 * dMatrix4x42.a34) + (dMatrix4x4.a41 * dMatrix4x42.a44);
        dMatrix4x43.a21 += (dMatrix4x4.a12 * dMatrix4x42.a11) + (dMatrix4x4.a22 * dMatrix4x42.a21) + (dMatrix4x4.a32 * dMatrix4x42.a31) + (dMatrix4x4.a42 * dMatrix4x42.a41);
        dMatrix4x43.a22 += (dMatrix4x4.a12 * dMatrix4x42.a12) + (dMatrix4x4.a22 * dMatrix4x42.a22) + (dMatrix4x4.a32 * dMatrix4x42.a32) + (dMatrix4x4.a42 * dMatrix4x42.a42);
        dMatrix4x43.a23 += (dMatrix4x4.a12 * dMatrix4x42.a13) + (dMatrix4x4.a22 * dMatrix4x42.a23) + (dMatrix4x4.a32 * dMatrix4x42.a33) + (dMatrix4x4.a42 * dMatrix4x42.a43);
        dMatrix4x43.a24 += (dMatrix4x4.a12 * dMatrix4x42.a14) + (dMatrix4x4.a22 * dMatrix4x42.a24) + (dMatrix4x4.a32 * dMatrix4x42.a34) + (dMatrix4x4.a42 * dMatrix4x42.a44);
        dMatrix4x43.a31 += (dMatrix4x4.a13 * dMatrix4x42.a11) + (dMatrix4x4.a23 * dMatrix4x42.a21) + (dMatrix4x4.a33 * dMatrix4x42.a31) + (dMatrix4x4.a43 * dMatrix4x42.a41);
        dMatrix4x43.a32 += (dMatrix4x4.a13 * dMatrix4x42.a12) + (dMatrix4x4.a23 * dMatrix4x42.a22) + (dMatrix4x4.a33 * dMatrix4x42.a32) + (dMatrix4x4.a43 * dMatrix4x42.a42);
        dMatrix4x43.a33 += (dMatrix4x4.a13 * dMatrix4x42.a13) + (dMatrix4x4.a23 * dMatrix4x42.a23) + (dMatrix4x4.a33 * dMatrix4x42.a33) + (dMatrix4x4.a43 * dMatrix4x42.a43);
        dMatrix4x43.a34 += (dMatrix4x4.a13 * dMatrix4x42.a14) + (dMatrix4x4.a23 * dMatrix4x42.a24) + (dMatrix4x4.a33 * dMatrix4x42.a34) + (dMatrix4x4.a43 * dMatrix4x42.a44);
        dMatrix4x43.a41 += (dMatrix4x4.a14 * dMatrix4x42.a11) + (dMatrix4x4.a24 * dMatrix4x42.a21) + (dMatrix4x4.a34 * dMatrix4x42.a31) + (dMatrix4x4.a44 * dMatrix4x42.a41);
        dMatrix4x43.a42 += (dMatrix4x4.a14 * dMatrix4x42.a12) + (dMatrix4x4.a24 * dMatrix4x42.a22) + (dMatrix4x4.a34 * dMatrix4x42.a32) + (dMatrix4x4.a44 * dMatrix4x42.a42);
        dMatrix4x43.a43 += (dMatrix4x4.a14 * dMatrix4x42.a13) + (dMatrix4x4.a24 * dMatrix4x42.a23) + (dMatrix4x4.a34 * dMatrix4x42.a33) + (dMatrix4x4.a44 * dMatrix4x42.a43);
        dMatrix4x43.a44 += (dMatrix4x4.a14 * dMatrix4x42.a14) + (dMatrix4x4.a24 * dMatrix4x42.a24) + (dMatrix4x4.a34 * dMatrix4x42.a34) + (dMatrix4x4.a44 * dMatrix4x42.a44);
    }

    public static void multAddTransAB(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42, DMatrix4x4 dMatrix4x43) {
        dMatrix4x43.a11 += (dMatrix4x4.a11 * dMatrix4x42.a11) + (dMatrix4x4.a21 * dMatrix4x42.a12) + (dMatrix4x4.a31 * dMatrix4x42.a13) + (dMatrix4x4.a41 * dMatrix4x42.a14);
        dMatrix4x43.a12 += (dMatrix4x4.a11 * dMatrix4x42.a21) + (dMatrix4x4.a21 * dMatrix4x42.a22) + (dMatrix4x4.a31 * dMatrix4x42.a23) + (dMatrix4x4.a41 * dMatrix4x42.a24);
        dMatrix4x43.a13 += (dMatrix4x4.a11 * dMatrix4x42.a31) + (dMatrix4x4.a21 * dMatrix4x42.a32) + (dMatrix4x4.a31 * dMatrix4x42.a33) + (dMatrix4x4.a41 * dMatrix4x42.a34);
        dMatrix4x43.a14 += (dMatrix4x4.a11 * dMatrix4x42.a41) + (dMatrix4x4.a21 * dMatrix4x42.a42) + (dMatrix4x4.a31 * dMatrix4x42.a43) + (dMatrix4x4.a41 * dMatrix4x42.a44);
        dMatrix4x43.a21 += (dMatrix4x4.a12 * dMatrix4x42.a11) + (dMatrix4x4.a22 * dMatrix4x42.a12) + (dMatrix4x4.a32 * dMatrix4x42.a13) + (dMatrix4x4.a42 * dMatrix4x42.a14);
        dMatrix4x43.a22 += (dMatrix4x4.a12 * dMatrix4x42.a21) + (dMatrix4x4.a22 * dMatrix4x42.a22) + (dMatrix4x4.a32 * dMatrix4x42.a23) + (dMatrix4x4.a42 * dMatrix4x42.a24);
        dMatrix4x43.a23 += (dMatrix4x4.a12 * dMatrix4x42.a31) + (dMatrix4x4.a22 * dMatrix4x42.a32) + (dMatrix4x4.a32 * dMatrix4x42.a33) + (dMatrix4x4.a42 * dMatrix4x42.a34);
        dMatrix4x43.a24 += (dMatrix4x4.a12 * dMatrix4x42.a41) + (dMatrix4x4.a22 * dMatrix4x42.a42) + (dMatrix4x4.a32 * dMatrix4x42.a43) + (dMatrix4x4.a42 * dMatrix4x42.a44);
        dMatrix4x43.a31 += (dMatrix4x4.a13 * dMatrix4x42.a11) + (dMatrix4x4.a23 * dMatrix4x42.a12) + (dMatrix4x4.a33 * dMatrix4x42.a13) + (dMatrix4x4.a43 * dMatrix4x42.a14);
        dMatrix4x43.a32 += (dMatrix4x4.a13 * dMatrix4x42.a21) + (dMatrix4x4.a23 * dMatrix4x42.a22) + (dMatrix4x4.a33 * dMatrix4x42.a23) + (dMatrix4x4.a43 * dMatrix4x42.a24);
        dMatrix4x43.a33 += (dMatrix4x4.a13 * dMatrix4x42.a31) + (dMatrix4x4.a23 * dMatrix4x42.a32) + (dMatrix4x4.a33 * dMatrix4x42.a33) + (dMatrix4x4.a43 * dMatrix4x42.a34);
        dMatrix4x43.a34 += (dMatrix4x4.a13 * dMatrix4x42.a41) + (dMatrix4x4.a23 * dMatrix4x42.a42) + (dMatrix4x4.a33 * dMatrix4x42.a43) + (dMatrix4x4.a43 * dMatrix4x42.a44);
        dMatrix4x43.a41 += (dMatrix4x4.a14 * dMatrix4x42.a11) + (dMatrix4x4.a24 * dMatrix4x42.a12) + (dMatrix4x4.a34 * dMatrix4x42.a13) + (dMatrix4x4.a44 * dMatrix4x42.a14);
        dMatrix4x43.a42 += (dMatrix4x4.a14 * dMatrix4x42.a21) + (dMatrix4x4.a24 * dMatrix4x42.a22) + (dMatrix4x4.a34 * dMatrix4x42.a23) + (dMatrix4x4.a44 * dMatrix4x42.a24);
        dMatrix4x43.a43 += (dMatrix4x4.a14 * dMatrix4x42.a31) + (dMatrix4x4.a24 * dMatrix4x42.a32) + (dMatrix4x4.a34 * dMatrix4x42.a33) + (dMatrix4x4.a44 * dMatrix4x42.a34);
        dMatrix4x43.a44 += (dMatrix4x4.a14 * dMatrix4x42.a41) + (dMatrix4x4.a24 * dMatrix4x42.a42) + (dMatrix4x4.a34 * dMatrix4x42.a43) + (dMatrix4x4.a44 * dMatrix4x42.a44);
    }

    public static void multAddTransB(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42, DMatrix4x4 dMatrix4x43) {
        dMatrix4x43.a11 += (dMatrix4x4.a11 * dMatrix4x42.a11) + (dMatrix4x4.a12 * dMatrix4x42.a12) + (dMatrix4x4.a13 * dMatrix4x42.a13) + (dMatrix4x4.a14 * dMatrix4x42.a14);
        dMatrix4x43.a12 += (dMatrix4x4.a11 * dMatrix4x42.a21) + (dMatrix4x4.a12 * dMatrix4x42.a22) + (dMatrix4x4.a13 * dMatrix4x42.a23) + (dMatrix4x4.a14 * dMatrix4x42.a24);
        dMatrix4x43.a13 += (dMatrix4x4.a11 * dMatrix4x42.a31) + (dMatrix4x4.a12 * dMatrix4x42.a32) + (dMatrix4x4.a13 * dMatrix4x42.a33) + (dMatrix4x4.a14 * dMatrix4x42.a34);
        dMatrix4x43.a14 += (dMatrix4x4.a11 * dMatrix4x42.a41) + (dMatrix4x4.a12 * dMatrix4x42.a42) + (dMatrix4x4.a13 * dMatrix4x42.a43) + (dMatrix4x4.a14 * dMatrix4x42.a44);
        dMatrix4x43.a21 += (dMatrix4x4.a21 * dMatrix4x42.a11) + (dMatrix4x4.a22 * dMatrix4x42.a12) + (dMatrix4x4.a23 * dMatrix4x42.a13) + (dMatrix4x4.a24 * dMatrix4x42.a14);
        dMatrix4x43.a22 += (dMatrix4x4.a21 * dMatrix4x42.a21) + (dMatrix4x4.a22 * dMatrix4x42.a22) + (dMatrix4x4.a23 * dMatrix4x42.a23) + (dMatrix4x4.a24 * dMatrix4x42.a24);
        dMatrix4x43.a23 += (dMatrix4x4.a21 * dMatrix4x42.a31) + (dMatrix4x4.a22 * dMatrix4x42.a32) + (dMatrix4x4.a23 * dMatrix4x42.a33) + (dMatrix4x4.a24 * dMatrix4x42.a34);
        dMatrix4x43.a24 += (dMatrix4x4.a21 * dMatrix4x42.a41) + (dMatrix4x4.a22 * dMatrix4x42.a42) + (dMatrix4x4.a23 * dMatrix4x42.a43) + (dMatrix4x4.a24 * dMatrix4x42.a44);
        dMatrix4x43.a31 += (dMatrix4x4.a31 * dMatrix4x42.a11) + (dMatrix4x4.a32 * dMatrix4x42.a12) + (dMatrix4x4.a33 * dMatrix4x42.a13) + (dMatrix4x4.a34 * dMatrix4x42.a14);
        dMatrix4x43.a32 += (dMatrix4x4.a31 * dMatrix4x42.a21) + (dMatrix4x4.a32 * dMatrix4x42.a22) + (dMatrix4x4.a33 * dMatrix4x42.a23) + (dMatrix4x4.a34 * dMatrix4x42.a24);
        dMatrix4x43.a33 += (dMatrix4x4.a31 * dMatrix4x42.a31) + (dMatrix4x4.a32 * dMatrix4x42.a32) + (dMatrix4x4.a33 * dMatrix4x42.a33) + (dMatrix4x4.a34 * dMatrix4x42.a34);
        dMatrix4x43.a34 += (dMatrix4x4.a31 * dMatrix4x42.a41) + (dMatrix4x4.a32 * dMatrix4x42.a42) + (dMatrix4x4.a33 * dMatrix4x42.a43) + (dMatrix4x4.a34 * dMatrix4x42.a44);
        dMatrix4x43.a41 += (dMatrix4x4.a41 * dMatrix4x42.a11) + (dMatrix4x4.a42 * dMatrix4x42.a12) + (dMatrix4x4.a43 * dMatrix4x42.a13) + (dMatrix4x4.a44 * dMatrix4x42.a14);
        dMatrix4x43.a42 += (dMatrix4x4.a41 * dMatrix4x42.a21) + (dMatrix4x4.a42 * dMatrix4x42.a22) + (dMatrix4x4.a43 * dMatrix4x42.a23) + (dMatrix4x4.a44 * dMatrix4x42.a24);
        dMatrix4x43.a43 += (dMatrix4x4.a41 * dMatrix4x42.a31) + (dMatrix4x4.a42 * dMatrix4x42.a32) + (dMatrix4x4.a43 * dMatrix4x42.a33) + (dMatrix4x4.a44 * dMatrix4x42.a34);
        dMatrix4x43.a44 += (dMatrix4x4.a41 * dMatrix4x42.a41) + (dMatrix4x4.a42 * dMatrix4x42.a42) + (dMatrix4x4.a43 * dMatrix4x42.a43) + (dMatrix4x4.a44 * dMatrix4x42.a44);
    }

    public static void mult(DMatrix4x4 dMatrix4x4, DMatrix4 dMatrix4, DMatrix4 dMatrix42) {
        dMatrix42.f2402a1 = (dMatrix4x4.a11 * dMatrix4.f2402a1) + (dMatrix4x4.a12 * dMatrix4.f2403a2) + (dMatrix4x4.a13 * dMatrix4.f2404a3) + (dMatrix4x4.a14 * dMatrix4.f2405a4);
        dMatrix42.f2403a2 = (dMatrix4x4.a21 * dMatrix4.f2402a1) + (dMatrix4x4.a22 * dMatrix4.f2403a2) + (dMatrix4x4.a23 * dMatrix4.f2404a3) + (dMatrix4x4.a24 * dMatrix4.f2405a4);
        dMatrix42.f2404a3 = (dMatrix4x4.a31 * dMatrix4.f2402a1) + (dMatrix4x4.a32 * dMatrix4.f2403a2) + (dMatrix4x4.a33 * dMatrix4.f2404a3) + (dMatrix4x4.a34 * dMatrix4.f2405a4);
        dMatrix42.f2405a4 = (dMatrix4x4.a41 * dMatrix4.f2402a1) + (dMatrix4x4.a42 * dMatrix4.f2403a2) + (dMatrix4x4.a43 * dMatrix4.f2404a3) + (dMatrix4x4.a44 * dMatrix4.f2405a4);
    }

    public static void mult(DMatrix4 dMatrix4, DMatrix4x4 dMatrix4x4, DMatrix4 dMatrix42) {
        dMatrix42.f2402a1 = (dMatrix4.f2402a1 * dMatrix4x4.a11) + (dMatrix4.f2403a2 * dMatrix4x4.a21) + (dMatrix4.f2404a3 * dMatrix4x4.a31) + (dMatrix4.f2405a4 * dMatrix4x4.a41);
        dMatrix42.f2403a2 = (dMatrix4.f2402a1 * dMatrix4x4.a12) + (dMatrix4.f2403a2 * dMatrix4x4.a22) + (dMatrix4.f2404a3 * dMatrix4x4.a32) + (dMatrix4.f2405a4 * dMatrix4x4.a42);
        dMatrix42.f2404a3 = (dMatrix4.f2402a1 * dMatrix4x4.a13) + (dMatrix4.f2403a2 * dMatrix4x4.a23) + (dMatrix4.f2404a3 * dMatrix4x4.a33) + (dMatrix4.f2405a4 * dMatrix4x4.a43);
        dMatrix42.f2405a4 = (dMatrix4.f2402a1 * dMatrix4x4.a14) + (dMatrix4.f2403a2 * dMatrix4x4.a24) + (dMatrix4.f2404a3 * dMatrix4x4.a34) + (dMatrix4.f2405a4 * dMatrix4x4.a44);
    }

    public static double dot(DMatrix4 dMatrix4, DMatrix4 dMatrix42) {
        return (dMatrix4.f2402a1 * dMatrix42.f2402a1) + (dMatrix4.f2403a2 * dMatrix42.f2403a2) + (dMatrix4.f2404a3 * dMatrix42.f2404a3) + (dMatrix4.f2405a4 * dMatrix42.f2405a4);
    }

    public static void setIdentity(DMatrix4x4 dMatrix4x4) {
        dMatrix4x4.a11 = 1.0d;
        dMatrix4x4.a21 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix4x4.a31 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix4x4.a41 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix4x4.a12 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix4x4.a22 = 1.0d;
        dMatrix4x4.a32 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix4x4.a42 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix4x4.a13 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix4x4.a23 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix4x4.a33 = 1.0d;
        dMatrix4x4.a43 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix4x4.a14 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix4x4.a24 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix4x4.a34 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix4x4.a44 = 1.0d;
    }

    public static boolean invert(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42) {
        double dElementMaxAbs = 1.0d / elementMaxAbs(dMatrix4x4);
        double d = dMatrix4x4.a11 * dElementMaxAbs;
        double d2 = dMatrix4x4.a12 * dElementMaxAbs;
        double d3 = dMatrix4x4.a13 * dElementMaxAbs;
        double d4 = dMatrix4x4.a14 * dElementMaxAbs;
        double d5 = dMatrix4x4.a21 * dElementMaxAbs;
        double d6 = dMatrix4x4.a22 * dElementMaxAbs;
        double d7 = dMatrix4x4.a23 * dElementMaxAbs;
        double d8 = dMatrix4x4.a24 * dElementMaxAbs;
        double d9 = dMatrix4x4.a31 * dElementMaxAbs;
        double d10 = dMatrix4x4.a32 * dElementMaxAbs;
        double d11 = dMatrix4x4.a33 * dElementMaxAbs;
        double d12 = dMatrix4x4.a34 * dElementMaxAbs;
        double d13 = dMatrix4x4.a41 * dElementMaxAbs;
        double d14 = dMatrix4x4.a42 * dElementMaxAbs;
        double d15 = dMatrix4x4.a43 * dElementMaxAbs;
        double d16 = dMatrix4x4.a44 * dElementMaxAbs;
        double d17 = (d11 * d16) - (d12 * d15);
        double d18 = (d10 * d16) - (d12 * d14);
        double d19 = (d10 * d15) - (d11 * d14);
        double d20 = ((d6 * d17) - (d7 * d18)) + (d8 * d19);
        double d21 = (d9 * d16) - (d12 * d13);
        double d22 = (d9 * d15) - (d11 * d13);
        double d23 = -(((d5 * d17) - (d7 * d21)) + (d8 * d22));
        double d24 = (d9 * d14) - (d10 * d13);
        double d25 = ((d5 * d18) - (d6 * d21)) + (d8 * d24);
        double d26 = -(((d5 * d19) - (d6 * d22)) + (d7 * d24));
        double d27 = -(((d2 * d17) - (d3 * d18)) + (d4 * d19));
        double d28 = ((d17 * d) - (d3 * d21)) + (d4 * d22);
        double d29 = -(((d18 * d) - (d21 * d2)) + (d4 * d24));
        double d30 = ((d19 * d) - (d22 * d2)) + (d24 * d3);
        double d31 = (d7 * d16) - (d8 * d15);
        double d32 = (d6 * d16) - (d8 * d14);
        double d33 = (d6 * d15) - (d7 * d14);
        double d34 = ((d2 * d31) - (d3 * d32)) + (d4 * d33);
        double d35 = (d16 * d5) - (d8 * d13);
        double d36 = (d15 * d5) - (d7 * d13);
        double d37 = -(((d31 * d) - (d3 * d35)) + (d4 * d36));
        double d38 = (d14 * d5) - (d13 * d6);
        double d39 = ((d32 * d) - (d35 * d2)) + (d4 * d38);
        double d40 = -(((d33 * d) - (d36 * d2)) + (d38 * d3));
        double d41 = (d7 * d12) - (d8 * d11);
        double d42 = (d6 * d12) - (d8 * d10);
        double d43 = (d6 * d11) - (d7 * d10);
        double d44 = -(((d2 * d41) - (d3 * d42)) + (d4 * d43));
        double d45 = (d12 * d5) - (d8 * d9);
        double d46 = (d5 * d11) - (d7 * d9);
        double d47 = ((d41 * d) - (d3 * d45)) + (d4 * d46);
        double d48 = (d5 * d10) - (d6 * d9);
        double d49 = -(((d42 * d) - (d45 * d2)) + (d4 * d48));
        double d50 = ((d43 * d) - (d46 * d2)) + (d48 * d3);
        double d51 = ((((d * d20) + (d2 * d23)) + (d3 * d25)) + (d4 * d26)) / dElementMaxAbs;
        dMatrix4x42.a11 = d20 / d51;
        dMatrix4x42.a12 = d27 / d51;
        dMatrix4x42.a13 = d34 / d51;
        dMatrix4x42.a14 = d44 / d51;
        dMatrix4x42.a21 = d23 / d51;
        dMatrix4x42.a22 = d28 / d51;
        dMatrix4x42.a23 = d37 / d51;
        dMatrix4x42.a24 = d47 / d51;
        dMatrix4x42.a31 = d25 / d51;
        dMatrix4x42.a32 = d29 / d51;
        dMatrix4x42.a33 = d39 / d51;
        dMatrix4x42.a34 = d49 / d51;
        dMatrix4x42.a41 = d26 / d51;
        dMatrix4x42.a42 = d30 / d51;
        dMatrix4x42.a43 = d40 / d51;
        dMatrix4x42.a44 = d50 / d51;
        return (Double.isNaN(d51) || Double.isInfinite(d51)) ? false : true;
    }

    public static double det(DMatrix4x4 dMatrix4x4) {
        double d = dMatrix4x4.a22;
        double d2 = dMatrix4x4.a23;
        double d3 = dMatrix4x4.a24;
        double d4 = dMatrix4x4.a32;
        double d5 = dMatrix4x4.a33;
        double d6 = dMatrix4x4.a34;
        double d7 = dMatrix4x4.a42;
        double d8 = dMatrix4x4.a43;
        double d9 = dMatrix4x4.a44;
        double d10 = (d5 * d9) - (d6 * d8);
        double d11 = (dMatrix4x4.a11 * (((d * d10) - (((d4 * d9) - (d6 * d7)) * d2)) + (((d4 * d8) - (d7 * d5)) * d3))) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d12 = dMatrix4x4.a21;
        double d13 = dMatrix4x4.a31;
        double d14 = dMatrix4x4.a41;
        double d15 = (d13 * d9) - (d6 * d14);
        double d16 = d11 - (dMatrix4x4.a12 * (((d10 * d12) - (d2 * d15)) + (((d13 * d8) - (d5 * d14)) * d3)));
        double d17 = dMatrix4x4.a22;
        double d18 = dMatrix4x4.a32;
        double d19 = dMatrix4x4.a42;
        double d20 = (((d9 * d18) - (d6 * d19)) * d12) - (d15 * d17);
        double d21 = (d13 * d19) - (d18 * d14);
        double d22 = (dMatrix4x4.a13 * (d20 + (d3 * d21))) + d16;
        double d23 = dMatrix4x4.a23;
        double d24 = dMatrix4x4.a33;
        double d25 = dMatrix4x4.a43;
        return d22 - (dMatrix4x4.a14 * (((d12 * ((d18 * d25) - (d19 * d24))) - (d17 * ((d13 * d25) - (d24 * d14)))) + (d23 * d21)));
    }

    public static double trace(DMatrix4x4 dMatrix4x4) {
        return dMatrix4x4.a11 + dMatrix4x4.a22 + dMatrix4x4.a33 + dMatrix4x4.a44;
    }

    public static void diag(DMatrix4x4 dMatrix4x4, DMatrix4 dMatrix4) {
        dMatrix4.f2402a1 = dMatrix4x4.a11;
        dMatrix4.f2403a2 = dMatrix4x4.a22;
        dMatrix4.f2404a3 = dMatrix4x4.a33;
        dMatrix4.f2405a4 = dMatrix4x4.a44;
    }

    public static double elementMax(DMatrix4x4 dMatrix4x4) {
        double d = dMatrix4x4.a11;
        if (dMatrix4x4.a12 > d) {
            d = dMatrix4x4.a12;
        }
        if (dMatrix4x4.a13 > d) {
            d = dMatrix4x4.a13;
        }
        if (dMatrix4x4.a14 > d) {
            d = dMatrix4x4.a14;
        }
        if (dMatrix4x4.a21 > d) {
            d = dMatrix4x4.a21;
        }
        if (dMatrix4x4.a22 > d) {
            d = dMatrix4x4.a22;
        }
        if (dMatrix4x4.a23 > d) {
            d = dMatrix4x4.a23;
        }
        if (dMatrix4x4.a24 > d) {
            d = dMatrix4x4.a24;
        }
        if (dMatrix4x4.a31 > d) {
            d = dMatrix4x4.a31;
        }
        if (dMatrix4x4.a32 > d) {
            d = dMatrix4x4.a32;
        }
        if (dMatrix4x4.a33 > d) {
            d = dMatrix4x4.a33;
        }
        if (dMatrix4x4.a34 > d) {
            d = dMatrix4x4.a34;
        }
        if (dMatrix4x4.a41 > d) {
            d = dMatrix4x4.a41;
        }
        if (dMatrix4x4.a42 > d) {
            d = dMatrix4x4.a42;
        }
        if (dMatrix4x4.a43 > d) {
            d = dMatrix4x4.a43;
        }
        return dMatrix4x4.a44 > d ? dMatrix4x4.a44 : d;
    }

    public static double elementMax(DMatrix4 dMatrix4) {
        double d = dMatrix4.f2402a1;
        if (dMatrix4.f2403a2 > d) {
            d = dMatrix4.f2403a2;
        }
        if (dMatrix4.f2404a3 > d) {
            d = dMatrix4.f2404a3;
        }
        return dMatrix4.f2405a4 > d ? dMatrix4.f2405a4 : d;
    }

    public static double elementMaxAbs(DMatrix4x4 dMatrix4x4) {
        double dAbs = Math.abs(dMatrix4x4.a11);
        double dAbs2 = Math.abs(dMatrix4x4.a12);
        if (dAbs2 > dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix4x4.a13);
        if (dAbs3 > dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix4x4.a14);
        if (dAbs4 > dAbs) {
            dAbs = dAbs4;
        }
        double dAbs5 = Math.abs(dMatrix4x4.a21);
        if (dAbs5 > dAbs) {
            dAbs = dAbs5;
        }
        double dAbs6 = Math.abs(dMatrix4x4.a22);
        if (dAbs6 > dAbs) {
            dAbs = dAbs6;
        }
        double dAbs7 = Math.abs(dMatrix4x4.a23);
        if (dAbs7 > dAbs) {
            dAbs = dAbs7;
        }
        double dAbs8 = Math.abs(dMatrix4x4.a24);
        if (dAbs8 > dAbs) {
            dAbs = dAbs8;
        }
        double dAbs9 = Math.abs(dMatrix4x4.a31);
        if (dAbs9 > dAbs) {
            dAbs = dAbs9;
        }
        double dAbs10 = Math.abs(dMatrix4x4.a32);
        if (dAbs10 > dAbs) {
            dAbs = dAbs10;
        }
        double dAbs11 = Math.abs(dMatrix4x4.a33);
        if (dAbs11 > dAbs) {
            dAbs = dAbs11;
        }
        double dAbs12 = Math.abs(dMatrix4x4.a34);
        if (dAbs12 > dAbs) {
            dAbs = dAbs12;
        }
        double dAbs13 = Math.abs(dMatrix4x4.a41);
        if (dAbs13 > dAbs) {
            dAbs = dAbs13;
        }
        double dAbs14 = Math.abs(dMatrix4x4.a42);
        if (dAbs14 > dAbs) {
            dAbs = dAbs14;
        }
        double dAbs15 = Math.abs(dMatrix4x4.a43);
        if (dAbs15 > dAbs) {
            dAbs = dAbs15;
        }
        double dAbs16 = Math.abs(dMatrix4x4.a44);
        return dAbs16 > dAbs ? dAbs16 : dAbs;
    }

    public static double elementMaxAbs(DMatrix4 dMatrix4) {
        double dAbs = Math.abs(dMatrix4.f2402a1);
        double dAbs2 = Math.abs(dMatrix4.f2403a2);
        if (dAbs2 > dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix4.f2403a2);
        if (dAbs3 > dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix4.f2404a3);
        if (dAbs4 > dAbs) {
            dAbs = dAbs4;
        }
        double dAbs5 = Math.abs(dMatrix4.f2405a4);
        return dAbs5 > dAbs ? dAbs5 : dAbs;
    }

    public static double elementMin(DMatrix4x4 dMatrix4x4) {
        double d = dMatrix4x4.a11;
        if (dMatrix4x4.a12 < d) {
            d = dMatrix4x4.a12;
        }
        if (dMatrix4x4.a13 < d) {
            d = dMatrix4x4.a13;
        }
        if (dMatrix4x4.a14 < d) {
            d = dMatrix4x4.a14;
        }
        if (dMatrix4x4.a21 < d) {
            d = dMatrix4x4.a21;
        }
        if (dMatrix4x4.a22 < d) {
            d = dMatrix4x4.a22;
        }
        if (dMatrix4x4.a23 < d) {
            d = dMatrix4x4.a23;
        }
        if (dMatrix4x4.a24 < d) {
            d = dMatrix4x4.a24;
        }
        if (dMatrix4x4.a31 < d) {
            d = dMatrix4x4.a31;
        }
        if (dMatrix4x4.a32 < d) {
            d = dMatrix4x4.a32;
        }
        if (dMatrix4x4.a33 < d) {
            d = dMatrix4x4.a33;
        }
        if (dMatrix4x4.a34 < d) {
            d = dMatrix4x4.a34;
        }
        if (dMatrix4x4.a41 < d) {
            d = dMatrix4x4.a41;
        }
        if (dMatrix4x4.a42 < d) {
            d = dMatrix4x4.a42;
        }
        if (dMatrix4x4.a43 < d) {
            d = dMatrix4x4.a43;
        }
        return dMatrix4x4.a44 < d ? dMatrix4x4.a44 : d;
    }

    public static double elementMin(DMatrix4 dMatrix4) {
        double d = dMatrix4.f2402a1;
        if (dMatrix4.f2403a2 < d) {
            d = dMatrix4.f2403a2;
        }
        if (dMatrix4.f2404a3 < d) {
            d = dMatrix4.f2404a3;
        }
        return dMatrix4.f2405a4 < d ? dMatrix4.f2405a4 : d;
    }

    public static double elementMinAbs(DMatrix4x4 dMatrix4x4) {
        double dAbs = Math.abs(dMatrix4x4.a11);
        double dAbs2 = Math.abs(dMatrix4x4.a12);
        if (dAbs2 < dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix4x4.a13);
        if (dAbs3 < dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix4x4.a14);
        if (dAbs4 < dAbs) {
            dAbs = dAbs4;
        }
        double dAbs5 = Math.abs(dMatrix4x4.a21);
        if (dAbs5 < dAbs) {
            dAbs = dAbs5;
        }
        double dAbs6 = Math.abs(dMatrix4x4.a22);
        if (dAbs6 < dAbs) {
            dAbs = dAbs6;
        }
        double dAbs7 = Math.abs(dMatrix4x4.a23);
        if (dAbs7 < dAbs) {
            dAbs = dAbs7;
        }
        double dAbs8 = Math.abs(dMatrix4x4.a24);
        if (dAbs8 < dAbs) {
            dAbs = dAbs8;
        }
        double dAbs9 = Math.abs(dMatrix4x4.a31);
        if (dAbs9 < dAbs) {
            dAbs = dAbs9;
        }
        double dAbs10 = Math.abs(dMatrix4x4.a32);
        if (dAbs10 < dAbs) {
            dAbs = dAbs10;
        }
        double dAbs11 = Math.abs(dMatrix4x4.a33);
        if (dAbs11 < dAbs) {
            dAbs = dAbs11;
        }
        double dAbs12 = Math.abs(dMatrix4x4.a34);
        if (dAbs12 < dAbs) {
            dAbs = dAbs12;
        }
        double dAbs13 = Math.abs(dMatrix4x4.a41);
        if (dAbs13 < dAbs) {
            dAbs = dAbs13;
        }
        double dAbs14 = Math.abs(dMatrix4x4.a42);
        if (dAbs14 < dAbs) {
            dAbs = dAbs14;
        }
        double dAbs15 = Math.abs(dMatrix4x4.a43);
        if (dAbs15 < dAbs) {
            dAbs = dAbs15;
        }
        double dAbs16 = Math.abs(dMatrix4x4.a44);
        return dAbs16 < dAbs ? dAbs16 : dAbs;
    }

    public static double elementMinAbs(DMatrix4 dMatrix4) {
        double dAbs = Math.abs(dMatrix4.f2402a1);
        double dAbs2 = Math.abs(dMatrix4.f2402a1);
        if (dAbs2 < dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix4.f2403a2);
        if (dAbs3 < dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix4.f2404a3);
        if (dAbs4 < dAbs) {
            dAbs = dAbs4;
        }
        double dAbs5 = Math.abs(dMatrix4.f2405a4);
        return dAbs5 < dAbs ? dAbs5 : dAbs;
    }

    public static void elementMult(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42) {
        dMatrix4x4.a11 *= dMatrix4x42.a11;
        dMatrix4x4.a12 *= dMatrix4x42.a12;
        dMatrix4x4.a13 *= dMatrix4x42.a13;
        dMatrix4x4.a14 *= dMatrix4x42.a14;
        dMatrix4x4.a21 *= dMatrix4x42.a21;
        dMatrix4x4.a22 *= dMatrix4x42.a22;
        dMatrix4x4.a23 *= dMatrix4x42.a23;
        dMatrix4x4.a24 *= dMatrix4x42.a24;
        dMatrix4x4.a31 *= dMatrix4x42.a31;
        dMatrix4x4.a32 *= dMatrix4x42.a32;
        dMatrix4x4.a33 *= dMatrix4x42.a33;
        dMatrix4x4.a34 *= dMatrix4x42.a34;
        dMatrix4x4.a41 *= dMatrix4x42.a41;
        dMatrix4x4.a42 *= dMatrix4x42.a42;
        dMatrix4x4.a43 *= dMatrix4x42.a43;
        dMatrix4x4.a44 *= dMatrix4x42.a44;
    }

    public static void elementMult(DMatrix4 dMatrix4, DMatrix4 dMatrix42) {
        dMatrix4.f2402a1 *= dMatrix42.f2402a1;
        dMatrix4.f2403a2 *= dMatrix42.f2403a2;
        dMatrix4.f2404a3 *= dMatrix42.f2404a3;
        dMatrix4.f2405a4 *= dMatrix42.f2405a4;
    }

    public static void elementMult(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42, DMatrix4x4 dMatrix4x43) {
        dMatrix4x43.a11 = dMatrix4x4.a11 * dMatrix4x42.a11;
        dMatrix4x43.a12 = dMatrix4x4.a12 * dMatrix4x42.a12;
        dMatrix4x43.a13 = dMatrix4x4.a13 * dMatrix4x42.a13;
        dMatrix4x43.a14 = dMatrix4x4.a14 * dMatrix4x42.a14;
        dMatrix4x43.a21 = dMatrix4x4.a21 * dMatrix4x42.a21;
        dMatrix4x43.a22 = dMatrix4x4.a22 * dMatrix4x42.a22;
        dMatrix4x43.a23 = dMatrix4x4.a23 * dMatrix4x42.a23;
        dMatrix4x43.a24 = dMatrix4x4.a24 * dMatrix4x42.a24;
        dMatrix4x43.a31 = dMatrix4x4.a31 * dMatrix4x42.a31;
        dMatrix4x43.a32 = dMatrix4x4.a32 * dMatrix4x42.a32;
        dMatrix4x43.a33 = dMatrix4x4.a33 * dMatrix4x42.a33;
        dMatrix4x43.a34 = dMatrix4x4.a34 * dMatrix4x42.a34;
        dMatrix4x43.a41 = dMatrix4x4.a41 * dMatrix4x42.a41;
        dMatrix4x43.a42 = dMatrix4x4.a42 * dMatrix4x42.a42;
        dMatrix4x43.a43 = dMatrix4x4.a43 * dMatrix4x42.a43;
        dMatrix4x43.a44 = dMatrix4x4.a44 * dMatrix4x42.a44;
    }

    public static void elementMult(DMatrix4 dMatrix4, DMatrix4 dMatrix42, DMatrix4 dMatrix43) {
        dMatrix43.f2402a1 = dMatrix4.f2402a1 * dMatrix42.f2402a1;
        dMatrix43.f2403a2 = dMatrix4.f2403a2 * dMatrix42.f2403a2;
        dMatrix43.f2404a3 = dMatrix4.f2404a3 * dMatrix42.f2404a3;
        dMatrix43.f2405a4 = dMatrix4.f2405a4 * dMatrix42.f2405a4;
    }

    public static void elementDiv(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42) {
        dMatrix4x4.a11 /= dMatrix4x42.a11;
        dMatrix4x4.a12 /= dMatrix4x42.a12;
        dMatrix4x4.a13 /= dMatrix4x42.a13;
        dMatrix4x4.a14 /= dMatrix4x42.a14;
        dMatrix4x4.a21 /= dMatrix4x42.a21;
        dMatrix4x4.a22 /= dMatrix4x42.a22;
        dMatrix4x4.a23 /= dMatrix4x42.a23;
        dMatrix4x4.a24 /= dMatrix4x42.a24;
        dMatrix4x4.a31 /= dMatrix4x42.a31;
        dMatrix4x4.a32 /= dMatrix4x42.a32;
        dMatrix4x4.a33 /= dMatrix4x42.a33;
        dMatrix4x4.a34 /= dMatrix4x42.a34;
        dMatrix4x4.a41 /= dMatrix4x42.a41;
        dMatrix4x4.a42 /= dMatrix4x42.a42;
        dMatrix4x4.a43 /= dMatrix4x42.a43;
        dMatrix4x4.a44 /= dMatrix4x42.a44;
    }

    public static void elementDiv(DMatrix4 dMatrix4, DMatrix4 dMatrix42) {
        dMatrix4.f2402a1 /= dMatrix42.f2402a1;
        dMatrix4.f2403a2 /= dMatrix42.f2403a2;
        dMatrix4.f2404a3 /= dMatrix42.f2404a3;
        dMatrix4.f2405a4 /= dMatrix42.f2405a4;
    }

    public static void elementDiv(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42, DMatrix4x4 dMatrix4x43) {
        dMatrix4x43.a11 = dMatrix4x4.a11 / dMatrix4x42.a11;
        dMatrix4x43.a12 = dMatrix4x4.a12 / dMatrix4x42.a12;
        dMatrix4x43.a13 = dMatrix4x4.a13 / dMatrix4x42.a13;
        dMatrix4x43.a14 = dMatrix4x4.a14 / dMatrix4x42.a14;
        dMatrix4x43.a21 = dMatrix4x4.a21 / dMatrix4x42.a21;
        dMatrix4x43.a22 = dMatrix4x4.a22 / dMatrix4x42.a22;
        dMatrix4x43.a23 = dMatrix4x4.a23 / dMatrix4x42.a23;
        dMatrix4x43.a24 = dMatrix4x4.a24 / dMatrix4x42.a24;
        dMatrix4x43.a31 = dMatrix4x4.a31 / dMatrix4x42.a31;
        dMatrix4x43.a32 = dMatrix4x4.a32 / dMatrix4x42.a32;
        dMatrix4x43.a33 = dMatrix4x4.a33 / dMatrix4x42.a33;
        dMatrix4x43.a34 = dMatrix4x4.a34 / dMatrix4x42.a34;
        dMatrix4x43.a41 = dMatrix4x4.a41 / dMatrix4x42.a41;
        dMatrix4x43.a42 = dMatrix4x4.a42 / dMatrix4x42.a42;
        dMatrix4x43.a43 = dMatrix4x4.a43 / dMatrix4x42.a43;
        dMatrix4x43.a44 = dMatrix4x4.a44 / dMatrix4x42.a44;
    }

    public static void elementDiv(DMatrix4 dMatrix4, DMatrix4 dMatrix42, DMatrix4 dMatrix43) {
        dMatrix43.f2402a1 = dMatrix4.f2402a1 / dMatrix42.f2402a1;
        dMatrix43.f2403a2 = dMatrix4.f2403a2 / dMatrix42.f2403a2;
        dMatrix43.f2404a3 = dMatrix4.f2404a3 / dMatrix42.f2404a3;
        dMatrix43.f2405a4 = dMatrix4.f2405a4 / dMatrix42.f2405a4;
    }

    public static void scale(double d, DMatrix4x4 dMatrix4x4) {
        dMatrix4x4.a11 *= d;
        dMatrix4x4.a12 *= d;
        dMatrix4x4.a13 *= d;
        dMatrix4x4.a14 *= d;
        dMatrix4x4.a21 *= d;
        dMatrix4x4.a22 *= d;
        dMatrix4x4.a23 *= d;
        dMatrix4x4.a24 *= d;
        dMatrix4x4.a31 *= d;
        dMatrix4x4.a32 *= d;
        dMatrix4x4.a33 *= d;
        dMatrix4x4.a34 *= d;
        dMatrix4x4.a41 *= d;
        dMatrix4x4.a42 *= d;
        dMatrix4x4.a43 *= d;
        dMatrix4x4.a44 *= d;
    }

    public static void scale(double d, DMatrix4 dMatrix4) {
        dMatrix4.f2402a1 *= d;
        dMatrix4.f2403a2 *= d;
        dMatrix4.f2404a3 *= d;
        dMatrix4.f2405a4 *= d;
    }

    public static void scale(double d, DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42) {
        dMatrix4x42.a11 = dMatrix4x4.a11 * d;
        dMatrix4x42.a12 = dMatrix4x4.a12 * d;
        dMatrix4x42.a13 = dMatrix4x4.a13 * d;
        dMatrix4x42.a14 = dMatrix4x4.a14 * d;
        dMatrix4x42.a21 = dMatrix4x4.a21 * d;
        dMatrix4x42.a22 = dMatrix4x4.a22 * d;
        dMatrix4x42.a23 = dMatrix4x4.a23 * d;
        dMatrix4x42.a24 = dMatrix4x4.a24 * d;
        dMatrix4x42.a31 = dMatrix4x4.a31 * d;
        dMatrix4x42.a32 = dMatrix4x4.a32 * d;
        dMatrix4x42.a33 = dMatrix4x4.a33 * d;
        dMatrix4x42.a34 = dMatrix4x4.a34 * d;
        dMatrix4x42.a41 = dMatrix4x4.a41 * d;
        dMatrix4x42.a42 = dMatrix4x4.a42 * d;
        dMatrix4x42.a43 = dMatrix4x4.a43 * d;
        dMatrix4x42.a44 = dMatrix4x4.a44 * d;
    }

    public static void scale(double d, DMatrix4 dMatrix4, DMatrix4 dMatrix42) {
        dMatrix42.f2402a1 = dMatrix4.f2402a1 * d;
        dMatrix42.f2403a2 = dMatrix4.f2403a2 * d;
        dMatrix42.f2404a3 = dMatrix4.f2404a3 * d;
        dMatrix42.f2405a4 = dMatrix4.f2405a4 * d;
    }

    public static void divide(DMatrix4x4 dMatrix4x4, double d) {
        dMatrix4x4.a11 /= d;
        dMatrix4x4.a12 /= d;
        dMatrix4x4.a13 /= d;
        dMatrix4x4.a14 /= d;
        dMatrix4x4.a21 /= d;
        dMatrix4x4.a22 /= d;
        dMatrix4x4.a23 /= d;
        dMatrix4x4.a24 /= d;
        dMatrix4x4.a31 /= d;
        dMatrix4x4.a32 /= d;
        dMatrix4x4.a33 /= d;
        dMatrix4x4.a34 /= d;
        dMatrix4x4.a41 /= d;
        dMatrix4x4.a42 /= d;
        dMatrix4x4.a43 /= d;
        dMatrix4x4.a44 /= d;
    }

    public static void divide(DMatrix4 dMatrix4, double d) {
        dMatrix4.f2402a1 /= d;
        dMatrix4.f2403a2 /= d;
        dMatrix4.f2404a3 /= d;
        dMatrix4.f2405a4 /= d;
    }

    public static void divide(DMatrix4x4 dMatrix4x4, double d, DMatrix4x4 dMatrix4x42) {
        dMatrix4x42.a11 = dMatrix4x4.a11 / d;
        dMatrix4x42.a12 = dMatrix4x4.a12 / d;
        dMatrix4x42.a13 = dMatrix4x4.a13 / d;
        dMatrix4x42.a14 = dMatrix4x4.a14 / d;
        dMatrix4x42.a21 = dMatrix4x4.a21 / d;
        dMatrix4x42.a22 = dMatrix4x4.a22 / d;
        dMatrix4x42.a23 = dMatrix4x4.a23 / d;
        dMatrix4x42.a24 = dMatrix4x4.a24 / d;
        dMatrix4x42.a31 = dMatrix4x4.a31 / d;
        dMatrix4x42.a32 = dMatrix4x4.a32 / d;
        dMatrix4x42.a33 = dMatrix4x4.a33 / d;
        dMatrix4x42.a34 = dMatrix4x4.a34 / d;
        dMatrix4x42.a41 = dMatrix4x4.a41 / d;
        dMatrix4x42.a42 = dMatrix4x4.a42 / d;
        dMatrix4x42.a43 = dMatrix4x4.a43 / d;
        dMatrix4x42.a44 = dMatrix4x4.a44 / d;
    }

    public static void divide(DMatrix4 dMatrix4, double d, DMatrix4 dMatrix42) {
        dMatrix42.f2402a1 = dMatrix4.f2402a1 / d;
        dMatrix42.f2403a2 = dMatrix4.f2403a2 / d;
        dMatrix42.f2404a3 = dMatrix4.f2404a3 / d;
        dMatrix42.f2405a4 = dMatrix4.f2405a4 / d;
    }

    public static void changeSign(DMatrix4x4 dMatrix4x4) {
        dMatrix4x4.a11 = -dMatrix4x4.a11;
        dMatrix4x4.a12 = -dMatrix4x4.a12;
        dMatrix4x4.a13 = -dMatrix4x4.a13;
        dMatrix4x4.a14 = -dMatrix4x4.a14;
        dMatrix4x4.a21 = -dMatrix4x4.a21;
        dMatrix4x4.a22 = -dMatrix4x4.a22;
        dMatrix4x4.a23 = -dMatrix4x4.a23;
        dMatrix4x4.a24 = -dMatrix4x4.a24;
        dMatrix4x4.a31 = -dMatrix4x4.a31;
        dMatrix4x4.a32 = -dMatrix4x4.a32;
        dMatrix4x4.a33 = -dMatrix4x4.a33;
        dMatrix4x4.a34 = -dMatrix4x4.a34;
        dMatrix4x4.a41 = -dMatrix4x4.a41;
        dMatrix4x4.a42 = -dMatrix4x4.a42;
        dMatrix4x4.a43 = -dMatrix4x4.a43;
        dMatrix4x4.a44 = -dMatrix4x4.a44;
    }

    public static void changeSign(DMatrix4 dMatrix4) {
        dMatrix4.f2402a1 = -dMatrix4.f2402a1;
        dMatrix4.f2403a2 = -dMatrix4.f2403a2;
        dMatrix4.f2404a3 = -dMatrix4.f2404a3;
        dMatrix4.f2405a4 = -dMatrix4.f2405a4;
    }

    public static void fill(DMatrix4x4 dMatrix4x4, double d) {
        dMatrix4x4.a11 = d;
        dMatrix4x4.a12 = d;
        dMatrix4x4.a13 = d;
        dMatrix4x4.a14 = d;
        dMatrix4x4.a21 = d;
        dMatrix4x4.a22 = d;
        dMatrix4x4.a23 = d;
        dMatrix4x4.a24 = d;
        dMatrix4x4.a31 = d;
        dMatrix4x4.a32 = d;
        dMatrix4x4.a33 = d;
        dMatrix4x4.a34 = d;
        dMatrix4x4.a41 = d;
        dMatrix4x4.a42 = d;
        dMatrix4x4.a43 = d;
        dMatrix4x4.a44 = d;
    }

    public static void fill(DMatrix4 dMatrix4, double d) {
        dMatrix4.f2402a1 = d;
        dMatrix4.f2403a2 = d;
        dMatrix4.f2404a3 = d;
        dMatrix4.f2405a4 = d;
    }

    public static DMatrix4 extractRow(DMatrix4x4 dMatrix4x4, int i, DMatrix4 dMatrix4) {
        if (dMatrix4 == null) {
            dMatrix4 = new DMatrix4();
        }
        if (i == 0) {
            dMatrix4.f2402a1 = dMatrix4x4.a11;
            dMatrix4.f2403a2 = dMatrix4x4.a12;
            dMatrix4.f2404a3 = dMatrix4x4.a13;
            dMatrix4.f2405a4 = dMatrix4x4.a14;
            return dMatrix4;
        }
        if (i == 1) {
            dMatrix4.f2402a1 = dMatrix4x4.a21;
            dMatrix4.f2403a2 = dMatrix4x4.a22;
            dMatrix4.f2404a3 = dMatrix4x4.a23;
            dMatrix4.f2405a4 = dMatrix4x4.a24;
            return dMatrix4;
        }
        if (i == 2) {
            dMatrix4.f2402a1 = dMatrix4x4.a31;
            dMatrix4.f2403a2 = dMatrix4x4.a32;
            dMatrix4.f2404a3 = dMatrix4x4.a33;
            dMatrix4.f2405a4 = dMatrix4x4.a34;
            return dMatrix4;
        }
        if (i == 3) {
            dMatrix4.f2402a1 = dMatrix4x4.a41;
            dMatrix4.f2403a2 = dMatrix4x4.a42;
            dMatrix4.f2404a3 = dMatrix4x4.a43;
            dMatrix4.f2405a4 = dMatrix4x4.a44;
            return dMatrix4;
        }
        throw new IllegalArgumentException("Out of bounds row.  row = " + i);
    }

    public static DMatrix4 extractColumn(DMatrix4x4 dMatrix4x4, int i, DMatrix4 dMatrix4) {
        if (dMatrix4 == null) {
            dMatrix4 = new DMatrix4();
        }
        if (i == 0) {
            dMatrix4.f2402a1 = dMatrix4x4.a11;
            dMatrix4.f2403a2 = dMatrix4x4.a21;
            dMatrix4.f2404a3 = dMatrix4x4.a31;
            dMatrix4.f2405a4 = dMatrix4x4.a41;
            return dMatrix4;
        }
        if (i == 1) {
            dMatrix4.f2402a1 = dMatrix4x4.a12;
            dMatrix4.f2403a2 = dMatrix4x4.a22;
            dMatrix4.f2404a3 = dMatrix4x4.a32;
            dMatrix4.f2405a4 = dMatrix4x4.a42;
            return dMatrix4;
        }
        if (i == 2) {
            dMatrix4.f2402a1 = dMatrix4x4.a13;
            dMatrix4.f2403a2 = dMatrix4x4.a23;
            dMatrix4.f2404a3 = dMatrix4x4.a33;
            dMatrix4.f2405a4 = dMatrix4x4.a43;
            return dMatrix4;
        }
        if (i == 3) {
            dMatrix4.f2402a1 = dMatrix4x4.a14;
            dMatrix4.f2403a2 = dMatrix4x4.a24;
            dMatrix4.f2404a3 = dMatrix4x4.a34;
            dMatrix4.f2405a4 = dMatrix4x4.a44;
            return dMatrix4;
        }
        throw new IllegalArgumentException("Out of bounds column.  column = " + i);
    }
}
