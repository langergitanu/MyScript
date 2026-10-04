package org.ejml.dense.fixed;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrix5;
import org.ejml.data.DMatrix5x5;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_DDF5 {
    public static void add(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52, DMatrix5x5 dMatrix5x53) {
        dMatrix5x53.a11 = dMatrix5x5.a11 + dMatrix5x52.a11;
        dMatrix5x53.a12 = dMatrix5x5.a12 + dMatrix5x52.a12;
        dMatrix5x53.a13 = dMatrix5x5.a13 + dMatrix5x52.a13;
        dMatrix5x53.a14 = dMatrix5x5.a14 + dMatrix5x52.a14;
        dMatrix5x53.a15 = dMatrix5x5.a15 + dMatrix5x52.a15;
        dMatrix5x53.a21 = dMatrix5x5.a21 + dMatrix5x52.a21;
        dMatrix5x53.a22 = dMatrix5x5.a22 + dMatrix5x52.a22;
        dMatrix5x53.a23 = dMatrix5x5.a23 + dMatrix5x52.a23;
        dMatrix5x53.a24 = dMatrix5x5.a24 + dMatrix5x52.a24;
        dMatrix5x53.a25 = dMatrix5x5.a25 + dMatrix5x52.a25;
        dMatrix5x53.a31 = dMatrix5x5.a31 + dMatrix5x52.a31;
        dMatrix5x53.a32 = dMatrix5x5.a32 + dMatrix5x52.a32;
        dMatrix5x53.a33 = dMatrix5x5.a33 + dMatrix5x52.a33;
        dMatrix5x53.a34 = dMatrix5x5.a34 + dMatrix5x52.a34;
        dMatrix5x53.a35 = dMatrix5x5.a35 + dMatrix5x52.a35;
        dMatrix5x53.a41 = dMatrix5x5.a41 + dMatrix5x52.a41;
        dMatrix5x53.a42 = dMatrix5x5.a42 + dMatrix5x52.a42;
        dMatrix5x53.a43 = dMatrix5x5.a43 + dMatrix5x52.a43;
        dMatrix5x53.a44 = dMatrix5x5.a44 + dMatrix5x52.a44;
        dMatrix5x53.a45 = dMatrix5x5.a45 + dMatrix5x52.a45;
        dMatrix5x53.a51 = dMatrix5x5.a51 + dMatrix5x52.a51;
        dMatrix5x53.a52 = dMatrix5x5.a52 + dMatrix5x52.a52;
        dMatrix5x53.a53 = dMatrix5x5.a53 + dMatrix5x52.a53;
        dMatrix5x53.a54 = dMatrix5x5.a54 + dMatrix5x52.a54;
        dMatrix5x53.a55 = dMatrix5x5.a55 + dMatrix5x52.a55;
    }

    public static void add(DMatrix5 dMatrix5, DMatrix5 dMatrix52, DMatrix5 dMatrix53) {
        dMatrix53.f2406a1 = dMatrix5.f2406a1 + dMatrix52.f2406a1;
        dMatrix53.f2407a2 = dMatrix5.f2407a2 + dMatrix52.f2407a2;
        dMatrix53.f2408a3 = dMatrix5.f2408a3 + dMatrix52.f2408a3;
        dMatrix53.f2409a4 = dMatrix5.f2409a4 + dMatrix52.f2409a4;
        dMatrix53.f2410a5 = dMatrix5.f2410a5 + dMatrix52.f2410a5;
    }

    public static void addEquals(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52) {
        dMatrix5x5.a11 += dMatrix5x52.a11;
        dMatrix5x5.a12 += dMatrix5x52.a12;
        dMatrix5x5.a13 += dMatrix5x52.a13;
        dMatrix5x5.a14 += dMatrix5x52.a14;
        dMatrix5x5.a15 += dMatrix5x52.a15;
        dMatrix5x5.a21 += dMatrix5x52.a21;
        dMatrix5x5.a22 += dMatrix5x52.a22;
        dMatrix5x5.a23 += dMatrix5x52.a23;
        dMatrix5x5.a24 += dMatrix5x52.a24;
        dMatrix5x5.a25 += dMatrix5x52.a25;
        dMatrix5x5.a31 += dMatrix5x52.a31;
        dMatrix5x5.a32 += dMatrix5x52.a32;
        dMatrix5x5.a33 += dMatrix5x52.a33;
        dMatrix5x5.a34 += dMatrix5x52.a34;
        dMatrix5x5.a35 += dMatrix5x52.a35;
        dMatrix5x5.a41 += dMatrix5x52.a41;
        dMatrix5x5.a42 += dMatrix5x52.a42;
        dMatrix5x5.a43 += dMatrix5x52.a43;
        dMatrix5x5.a44 += dMatrix5x52.a44;
        dMatrix5x5.a45 += dMatrix5x52.a45;
        dMatrix5x5.a51 += dMatrix5x52.a51;
        dMatrix5x5.a52 += dMatrix5x52.a52;
        dMatrix5x5.a53 += dMatrix5x52.a53;
        dMatrix5x5.a54 += dMatrix5x52.a54;
        dMatrix5x5.a55 += dMatrix5x52.a55;
    }

    public static void addEquals(DMatrix5 dMatrix5, DMatrix5 dMatrix52) {
        dMatrix5.f2406a1 += dMatrix52.f2406a1;
        dMatrix5.f2407a2 += dMatrix52.f2407a2;
        dMatrix5.f2408a3 += dMatrix52.f2408a3;
        dMatrix5.f2409a4 += dMatrix52.f2409a4;
        dMatrix5.f2410a5 += dMatrix52.f2410a5;
    }

    public static void subtract(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52, DMatrix5x5 dMatrix5x53) {
        dMatrix5x53.a11 = dMatrix5x5.a11 - dMatrix5x52.a11;
        dMatrix5x53.a12 = dMatrix5x5.a12 - dMatrix5x52.a12;
        dMatrix5x53.a13 = dMatrix5x5.a13 - dMatrix5x52.a13;
        dMatrix5x53.a14 = dMatrix5x5.a14 - dMatrix5x52.a14;
        dMatrix5x53.a15 = dMatrix5x5.a15 - dMatrix5x52.a15;
        dMatrix5x53.a21 = dMatrix5x5.a21 - dMatrix5x52.a21;
        dMatrix5x53.a22 = dMatrix5x5.a22 - dMatrix5x52.a22;
        dMatrix5x53.a23 = dMatrix5x5.a23 - dMatrix5x52.a23;
        dMatrix5x53.a24 = dMatrix5x5.a24 - dMatrix5x52.a24;
        dMatrix5x53.a25 = dMatrix5x5.a25 - dMatrix5x52.a25;
        dMatrix5x53.a31 = dMatrix5x5.a31 - dMatrix5x52.a31;
        dMatrix5x53.a32 = dMatrix5x5.a32 - dMatrix5x52.a32;
        dMatrix5x53.a33 = dMatrix5x5.a33 - dMatrix5x52.a33;
        dMatrix5x53.a34 = dMatrix5x5.a34 - dMatrix5x52.a34;
        dMatrix5x53.a35 = dMatrix5x5.a35 - dMatrix5x52.a35;
        dMatrix5x53.a41 = dMatrix5x5.a41 - dMatrix5x52.a41;
        dMatrix5x53.a42 = dMatrix5x5.a42 - dMatrix5x52.a42;
        dMatrix5x53.a43 = dMatrix5x5.a43 - dMatrix5x52.a43;
        dMatrix5x53.a44 = dMatrix5x5.a44 - dMatrix5x52.a44;
        dMatrix5x53.a45 = dMatrix5x5.a45 - dMatrix5x52.a45;
        dMatrix5x53.a51 = dMatrix5x5.a51 - dMatrix5x52.a51;
        dMatrix5x53.a52 = dMatrix5x5.a52 - dMatrix5x52.a52;
        dMatrix5x53.a53 = dMatrix5x5.a53 - dMatrix5x52.a53;
        dMatrix5x53.a54 = dMatrix5x5.a54 - dMatrix5x52.a54;
        dMatrix5x53.a55 = dMatrix5x5.a55 - dMatrix5x52.a55;
    }

    public static void subtract(DMatrix5 dMatrix5, DMatrix5 dMatrix52, DMatrix5 dMatrix53) {
        dMatrix53.f2406a1 = dMatrix5.f2406a1 - dMatrix52.f2406a1;
        dMatrix53.f2407a2 = dMatrix5.f2407a2 - dMatrix52.f2407a2;
        dMatrix53.f2408a3 = dMatrix5.f2408a3 - dMatrix52.f2408a3;
        dMatrix53.f2409a4 = dMatrix5.f2409a4 - dMatrix52.f2409a4;
        dMatrix53.f2410a5 = dMatrix5.f2410a5 - dMatrix52.f2410a5;
    }

    public static void subtractEquals(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52) {
        dMatrix5x5.a11 -= dMatrix5x52.a11;
        dMatrix5x5.a12 -= dMatrix5x52.a12;
        dMatrix5x5.a13 -= dMatrix5x52.a13;
        dMatrix5x5.a14 -= dMatrix5x52.a14;
        dMatrix5x5.a15 -= dMatrix5x52.a15;
        dMatrix5x5.a21 -= dMatrix5x52.a21;
        dMatrix5x5.a22 -= dMatrix5x52.a22;
        dMatrix5x5.a23 -= dMatrix5x52.a23;
        dMatrix5x5.a24 -= dMatrix5x52.a24;
        dMatrix5x5.a25 -= dMatrix5x52.a25;
        dMatrix5x5.a31 -= dMatrix5x52.a31;
        dMatrix5x5.a32 -= dMatrix5x52.a32;
        dMatrix5x5.a33 -= dMatrix5x52.a33;
        dMatrix5x5.a34 -= dMatrix5x52.a34;
        dMatrix5x5.a35 -= dMatrix5x52.a35;
        dMatrix5x5.a41 -= dMatrix5x52.a41;
        dMatrix5x5.a42 -= dMatrix5x52.a42;
        dMatrix5x5.a43 -= dMatrix5x52.a43;
        dMatrix5x5.a44 -= dMatrix5x52.a44;
        dMatrix5x5.a45 -= dMatrix5x52.a45;
        dMatrix5x5.a51 -= dMatrix5x52.a51;
        dMatrix5x5.a52 -= dMatrix5x52.a52;
        dMatrix5x5.a53 -= dMatrix5x52.a53;
        dMatrix5x5.a54 -= dMatrix5x52.a54;
        dMatrix5x5.a55 -= dMatrix5x52.a55;
    }

    public static void subtractEquals(DMatrix5 dMatrix5, DMatrix5 dMatrix52) {
        dMatrix5.f2406a1 -= dMatrix52.f2406a1;
        dMatrix5.f2407a2 -= dMatrix52.f2407a2;
        dMatrix5.f2408a3 -= dMatrix52.f2408a3;
        dMatrix5.f2409a4 -= dMatrix52.f2409a4;
        dMatrix5.f2410a5 -= dMatrix52.f2410a5;
    }

    public static void transpose(DMatrix5x5 dMatrix5x5) {
        double d = dMatrix5x5.a12;
        dMatrix5x5.a12 = dMatrix5x5.a21;
        dMatrix5x5.a21 = d;
        double d2 = dMatrix5x5.a13;
        dMatrix5x5.a13 = dMatrix5x5.a31;
        dMatrix5x5.a31 = d2;
        double d3 = dMatrix5x5.a14;
        dMatrix5x5.a14 = dMatrix5x5.a41;
        dMatrix5x5.a41 = d3;
        double d4 = dMatrix5x5.a15;
        dMatrix5x5.a15 = dMatrix5x5.a51;
        dMatrix5x5.a51 = d4;
        double d5 = dMatrix5x5.a23;
        dMatrix5x5.a23 = dMatrix5x5.a32;
        dMatrix5x5.a32 = d5;
        double d6 = dMatrix5x5.a24;
        dMatrix5x5.a24 = dMatrix5x5.a42;
        dMatrix5x5.a42 = d6;
        double d7 = dMatrix5x5.a25;
        dMatrix5x5.a25 = dMatrix5x5.a52;
        dMatrix5x5.a52 = d7;
        double d8 = dMatrix5x5.a34;
        dMatrix5x5.a34 = dMatrix5x5.a43;
        dMatrix5x5.a43 = d8;
        double d9 = dMatrix5x5.a35;
        dMatrix5x5.a35 = dMatrix5x5.a53;
        dMatrix5x5.a53 = d9;
        double d10 = dMatrix5x5.a45;
        dMatrix5x5.a45 = dMatrix5x5.a54;
        dMatrix5x5.a54 = d10;
    }

    public static DMatrix5x5 transpose(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52) {
        if (dMatrix5x5 == null) {
            dMatrix5x5 = new DMatrix5x5();
        }
        dMatrix5x52.a11 = dMatrix5x5.a11;
        dMatrix5x52.a12 = dMatrix5x5.a21;
        dMatrix5x52.a13 = dMatrix5x5.a31;
        dMatrix5x52.a14 = dMatrix5x5.a41;
        dMatrix5x52.a15 = dMatrix5x5.a51;
        dMatrix5x52.a21 = dMatrix5x5.a12;
        dMatrix5x52.a22 = dMatrix5x5.a22;
        dMatrix5x52.a23 = dMatrix5x5.a32;
        dMatrix5x52.a24 = dMatrix5x5.a42;
        dMatrix5x52.a25 = dMatrix5x5.a52;
        dMatrix5x52.a31 = dMatrix5x5.a13;
        dMatrix5x52.a32 = dMatrix5x5.a23;
        dMatrix5x52.a33 = dMatrix5x5.a33;
        dMatrix5x52.a34 = dMatrix5x5.a43;
        dMatrix5x52.a35 = dMatrix5x5.a53;
        dMatrix5x52.a41 = dMatrix5x5.a14;
        dMatrix5x52.a42 = dMatrix5x5.a24;
        dMatrix5x52.a43 = dMatrix5x5.a34;
        dMatrix5x52.a44 = dMatrix5x5.a44;
        dMatrix5x52.a45 = dMatrix5x5.a54;
        dMatrix5x52.a51 = dMatrix5x5.a15;
        dMatrix5x52.a52 = dMatrix5x5.a25;
        dMatrix5x52.a53 = dMatrix5x5.a35;
        dMatrix5x52.a54 = dMatrix5x5.a45;
        dMatrix5x52.a55 = dMatrix5x5.a55;
        return dMatrix5x52;
    }

    public static void mult(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52, DMatrix5x5 dMatrix5x53) {
        dMatrix5x53.a11 = (dMatrix5x5.a11 * dMatrix5x52.a11) + (dMatrix5x5.a12 * dMatrix5x52.a21) + (dMatrix5x5.a13 * dMatrix5x52.a31) + (dMatrix5x5.a14 * dMatrix5x52.a41) + (dMatrix5x5.a15 * dMatrix5x52.a51);
        dMatrix5x53.a12 = (dMatrix5x5.a11 * dMatrix5x52.a12) + (dMatrix5x5.a12 * dMatrix5x52.a22) + (dMatrix5x5.a13 * dMatrix5x52.a32) + (dMatrix5x5.a14 * dMatrix5x52.a42) + (dMatrix5x5.a15 * dMatrix5x52.a52);
        dMatrix5x53.a13 = (dMatrix5x5.a11 * dMatrix5x52.a13) + (dMatrix5x5.a12 * dMatrix5x52.a23) + (dMatrix5x5.a13 * dMatrix5x52.a33) + (dMatrix5x5.a14 * dMatrix5x52.a43) + (dMatrix5x5.a15 * dMatrix5x52.a53);
        dMatrix5x53.a14 = (dMatrix5x5.a11 * dMatrix5x52.a14) + (dMatrix5x5.a12 * dMatrix5x52.a24) + (dMatrix5x5.a13 * dMatrix5x52.a34) + (dMatrix5x5.a14 * dMatrix5x52.a44) + (dMatrix5x5.a15 * dMatrix5x52.a54);
        dMatrix5x53.a15 = (dMatrix5x5.a11 * dMatrix5x52.a15) + (dMatrix5x5.a12 * dMatrix5x52.a25) + (dMatrix5x5.a13 * dMatrix5x52.a35) + (dMatrix5x5.a14 * dMatrix5x52.a45) + (dMatrix5x5.a15 * dMatrix5x52.a55);
        dMatrix5x53.a21 = (dMatrix5x5.a21 * dMatrix5x52.a11) + (dMatrix5x5.a22 * dMatrix5x52.a21) + (dMatrix5x5.a23 * dMatrix5x52.a31) + (dMatrix5x5.a24 * dMatrix5x52.a41) + (dMatrix5x5.a25 * dMatrix5x52.a51);
        dMatrix5x53.a22 = (dMatrix5x5.a21 * dMatrix5x52.a12) + (dMatrix5x5.a22 * dMatrix5x52.a22) + (dMatrix5x5.a23 * dMatrix5x52.a32) + (dMatrix5x5.a24 * dMatrix5x52.a42) + (dMatrix5x5.a25 * dMatrix5x52.a52);
        dMatrix5x53.a23 = (dMatrix5x5.a21 * dMatrix5x52.a13) + (dMatrix5x5.a22 * dMatrix5x52.a23) + (dMatrix5x5.a23 * dMatrix5x52.a33) + (dMatrix5x5.a24 * dMatrix5x52.a43) + (dMatrix5x5.a25 * dMatrix5x52.a53);
        dMatrix5x53.a24 = (dMatrix5x5.a21 * dMatrix5x52.a14) + (dMatrix5x5.a22 * dMatrix5x52.a24) + (dMatrix5x5.a23 * dMatrix5x52.a34) + (dMatrix5x5.a24 * dMatrix5x52.a44) + (dMatrix5x5.a25 * dMatrix5x52.a54);
        dMatrix5x53.a25 = (dMatrix5x5.a21 * dMatrix5x52.a15) + (dMatrix5x5.a22 * dMatrix5x52.a25) + (dMatrix5x5.a23 * dMatrix5x52.a35) + (dMatrix5x5.a24 * dMatrix5x52.a45) + (dMatrix5x5.a25 * dMatrix5x52.a55);
        dMatrix5x53.a31 = (dMatrix5x5.a31 * dMatrix5x52.a11) + (dMatrix5x5.a32 * dMatrix5x52.a21) + (dMatrix5x5.a33 * dMatrix5x52.a31) + (dMatrix5x5.a34 * dMatrix5x52.a41) + (dMatrix5x5.a35 * dMatrix5x52.a51);
        dMatrix5x53.a32 = (dMatrix5x5.a31 * dMatrix5x52.a12) + (dMatrix5x5.a32 * dMatrix5x52.a22) + (dMatrix5x5.a33 * dMatrix5x52.a32) + (dMatrix5x5.a34 * dMatrix5x52.a42) + (dMatrix5x5.a35 * dMatrix5x52.a52);
        dMatrix5x53.a33 = (dMatrix5x5.a31 * dMatrix5x52.a13) + (dMatrix5x5.a32 * dMatrix5x52.a23) + (dMatrix5x5.a33 * dMatrix5x52.a33) + (dMatrix5x5.a34 * dMatrix5x52.a43) + (dMatrix5x5.a35 * dMatrix5x52.a53);
        dMatrix5x53.a34 = (dMatrix5x5.a31 * dMatrix5x52.a14) + (dMatrix5x5.a32 * dMatrix5x52.a24) + (dMatrix5x5.a33 * dMatrix5x52.a34) + (dMatrix5x5.a34 * dMatrix5x52.a44) + (dMatrix5x5.a35 * dMatrix5x52.a54);
        dMatrix5x53.a35 = (dMatrix5x5.a31 * dMatrix5x52.a15) + (dMatrix5x5.a32 * dMatrix5x52.a25) + (dMatrix5x5.a33 * dMatrix5x52.a35) + (dMatrix5x5.a34 * dMatrix5x52.a45) + (dMatrix5x5.a35 * dMatrix5x52.a55);
        dMatrix5x53.a41 = (dMatrix5x5.a41 * dMatrix5x52.a11) + (dMatrix5x5.a42 * dMatrix5x52.a21) + (dMatrix5x5.a43 * dMatrix5x52.a31) + (dMatrix5x5.a44 * dMatrix5x52.a41) + (dMatrix5x5.a45 * dMatrix5x52.a51);
        dMatrix5x53.a42 = (dMatrix5x5.a41 * dMatrix5x52.a12) + (dMatrix5x5.a42 * dMatrix5x52.a22) + (dMatrix5x5.a43 * dMatrix5x52.a32) + (dMatrix5x5.a44 * dMatrix5x52.a42) + (dMatrix5x5.a45 * dMatrix5x52.a52);
        dMatrix5x53.a43 = (dMatrix5x5.a41 * dMatrix5x52.a13) + (dMatrix5x5.a42 * dMatrix5x52.a23) + (dMatrix5x5.a43 * dMatrix5x52.a33) + (dMatrix5x5.a44 * dMatrix5x52.a43) + (dMatrix5x5.a45 * dMatrix5x52.a53);
        dMatrix5x53.a44 = (dMatrix5x5.a41 * dMatrix5x52.a14) + (dMatrix5x5.a42 * dMatrix5x52.a24) + (dMatrix5x5.a43 * dMatrix5x52.a34) + (dMatrix5x5.a44 * dMatrix5x52.a44) + (dMatrix5x5.a45 * dMatrix5x52.a54);
        dMatrix5x53.a45 = (dMatrix5x5.a41 * dMatrix5x52.a15) + (dMatrix5x5.a42 * dMatrix5x52.a25) + (dMatrix5x5.a43 * dMatrix5x52.a35) + (dMatrix5x5.a44 * dMatrix5x52.a45) + (dMatrix5x5.a45 * dMatrix5x52.a55);
        dMatrix5x53.a51 = (dMatrix5x5.a51 * dMatrix5x52.a11) + (dMatrix5x5.a52 * dMatrix5x52.a21) + (dMatrix5x5.a53 * dMatrix5x52.a31) + (dMatrix5x5.a54 * dMatrix5x52.a41) + (dMatrix5x5.a55 * dMatrix5x52.a51);
        dMatrix5x53.a52 = (dMatrix5x5.a51 * dMatrix5x52.a12) + (dMatrix5x5.a52 * dMatrix5x52.a22) + (dMatrix5x5.a53 * dMatrix5x52.a32) + (dMatrix5x5.a54 * dMatrix5x52.a42) + (dMatrix5x5.a55 * dMatrix5x52.a52);
        dMatrix5x53.a53 = (dMatrix5x5.a51 * dMatrix5x52.a13) + (dMatrix5x5.a52 * dMatrix5x52.a23) + (dMatrix5x5.a53 * dMatrix5x52.a33) + (dMatrix5x5.a54 * dMatrix5x52.a43) + (dMatrix5x5.a55 * dMatrix5x52.a53);
        dMatrix5x53.a54 = (dMatrix5x5.a51 * dMatrix5x52.a14) + (dMatrix5x5.a52 * dMatrix5x52.a24) + (dMatrix5x5.a53 * dMatrix5x52.a34) + (dMatrix5x5.a54 * dMatrix5x52.a44) + (dMatrix5x5.a55 * dMatrix5x52.a54);
        dMatrix5x53.a55 = (dMatrix5x5.a51 * dMatrix5x52.a15) + (dMatrix5x5.a52 * dMatrix5x52.a25) + (dMatrix5x5.a53 * dMatrix5x52.a35) + (dMatrix5x5.a54 * dMatrix5x52.a45) + (dMatrix5x5.a55 * dMatrix5x52.a55);
    }

    public static void multTransA(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52, DMatrix5x5 dMatrix5x53) {
        dMatrix5x53.a11 = (dMatrix5x5.a11 * dMatrix5x52.a11) + (dMatrix5x5.a21 * dMatrix5x52.a21) + (dMatrix5x5.a31 * dMatrix5x52.a31) + (dMatrix5x5.a41 * dMatrix5x52.a41) + (dMatrix5x5.a51 * dMatrix5x52.a51);
        dMatrix5x53.a12 = (dMatrix5x5.a11 * dMatrix5x52.a12) + (dMatrix5x5.a21 * dMatrix5x52.a22) + (dMatrix5x5.a31 * dMatrix5x52.a32) + (dMatrix5x5.a41 * dMatrix5x52.a42) + (dMatrix5x5.a51 * dMatrix5x52.a52);
        dMatrix5x53.a13 = (dMatrix5x5.a11 * dMatrix5x52.a13) + (dMatrix5x5.a21 * dMatrix5x52.a23) + (dMatrix5x5.a31 * dMatrix5x52.a33) + (dMatrix5x5.a41 * dMatrix5x52.a43) + (dMatrix5x5.a51 * dMatrix5x52.a53);
        dMatrix5x53.a14 = (dMatrix5x5.a11 * dMatrix5x52.a14) + (dMatrix5x5.a21 * dMatrix5x52.a24) + (dMatrix5x5.a31 * dMatrix5x52.a34) + (dMatrix5x5.a41 * dMatrix5x52.a44) + (dMatrix5x5.a51 * dMatrix5x52.a54);
        dMatrix5x53.a15 = (dMatrix5x5.a11 * dMatrix5x52.a15) + (dMatrix5x5.a21 * dMatrix5x52.a25) + (dMatrix5x5.a31 * dMatrix5x52.a35) + (dMatrix5x5.a41 * dMatrix5x52.a45) + (dMatrix5x5.a51 * dMatrix5x52.a55);
        dMatrix5x53.a21 = (dMatrix5x5.a12 * dMatrix5x52.a11) + (dMatrix5x5.a22 * dMatrix5x52.a21) + (dMatrix5x5.a32 * dMatrix5x52.a31) + (dMatrix5x5.a42 * dMatrix5x52.a41) + (dMatrix5x5.a52 * dMatrix5x52.a51);
        dMatrix5x53.a22 = (dMatrix5x5.a12 * dMatrix5x52.a12) + (dMatrix5x5.a22 * dMatrix5x52.a22) + (dMatrix5x5.a32 * dMatrix5x52.a32) + (dMatrix5x5.a42 * dMatrix5x52.a42) + (dMatrix5x5.a52 * dMatrix5x52.a52);
        dMatrix5x53.a23 = (dMatrix5x5.a12 * dMatrix5x52.a13) + (dMatrix5x5.a22 * dMatrix5x52.a23) + (dMatrix5x5.a32 * dMatrix5x52.a33) + (dMatrix5x5.a42 * dMatrix5x52.a43) + (dMatrix5x5.a52 * dMatrix5x52.a53);
        dMatrix5x53.a24 = (dMatrix5x5.a12 * dMatrix5x52.a14) + (dMatrix5x5.a22 * dMatrix5x52.a24) + (dMatrix5x5.a32 * dMatrix5x52.a34) + (dMatrix5x5.a42 * dMatrix5x52.a44) + (dMatrix5x5.a52 * dMatrix5x52.a54);
        dMatrix5x53.a25 = (dMatrix5x5.a12 * dMatrix5x52.a15) + (dMatrix5x5.a22 * dMatrix5x52.a25) + (dMatrix5x5.a32 * dMatrix5x52.a35) + (dMatrix5x5.a42 * dMatrix5x52.a45) + (dMatrix5x5.a52 * dMatrix5x52.a55);
        dMatrix5x53.a31 = (dMatrix5x5.a13 * dMatrix5x52.a11) + (dMatrix5x5.a23 * dMatrix5x52.a21) + (dMatrix5x5.a33 * dMatrix5x52.a31) + (dMatrix5x5.a43 * dMatrix5x52.a41) + (dMatrix5x5.a53 * dMatrix5x52.a51);
        dMatrix5x53.a32 = (dMatrix5x5.a13 * dMatrix5x52.a12) + (dMatrix5x5.a23 * dMatrix5x52.a22) + (dMatrix5x5.a33 * dMatrix5x52.a32) + (dMatrix5x5.a43 * dMatrix5x52.a42) + (dMatrix5x5.a53 * dMatrix5x52.a52);
        dMatrix5x53.a33 = (dMatrix5x5.a13 * dMatrix5x52.a13) + (dMatrix5x5.a23 * dMatrix5x52.a23) + (dMatrix5x5.a33 * dMatrix5x52.a33) + (dMatrix5x5.a43 * dMatrix5x52.a43) + (dMatrix5x5.a53 * dMatrix5x52.a53);
        dMatrix5x53.a34 = (dMatrix5x5.a13 * dMatrix5x52.a14) + (dMatrix5x5.a23 * dMatrix5x52.a24) + (dMatrix5x5.a33 * dMatrix5x52.a34) + (dMatrix5x5.a43 * dMatrix5x52.a44) + (dMatrix5x5.a53 * dMatrix5x52.a54);
        dMatrix5x53.a35 = (dMatrix5x5.a13 * dMatrix5x52.a15) + (dMatrix5x5.a23 * dMatrix5x52.a25) + (dMatrix5x5.a33 * dMatrix5x52.a35) + (dMatrix5x5.a43 * dMatrix5x52.a45) + (dMatrix5x5.a53 * dMatrix5x52.a55);
        dMatrix5x53.a41 = (dMatrix5x5.a14 * dMatrix5x52.a11) + (dMatrix5x5.a24 * dMatrix5x52.a21) + (dMatrix5x5.a34 * dMatrix5x52.a31) + (dMatrix5x5.a44 * dMatrix5x52.a41) + (dMatrix5x5.a54 * dMatrix5x52.a51);
        dMatrix5x53.a42 = (dMatrix5x5.a14 * dMatrix5x52.a12) + (dMatrix5x5.a24 * dMatrix5x52.a22) + (dMatrix5x5.a34 * dMatrix5x52.a32) + (dMatrix5x5.a44 * dMatrix5x52.a42) + (dMatrix5x5.a54 * dMatrix5x52.a52);
        dMatrix5x53.a43 = (dMatrix5x5.a14 * dMatrix5x52.a13) + (dMatrix5x5.a24 * dMatrix5x52.a23) + (dMatrix5x5.a34 * dMatrix5x52.a33) + (dMatrix5x5.a44 * dMatrix5x52.a43) + (dMatrix5x5.a54 * dMatrix5x52.a53);
        dMatrix5x53.a44 = (dMatrix5x5.a14 * dMatrix5x52.a14) + (dMatrix5x5.a24 * dMatrix5x52.a24) + (dMatrix5x5.a34 * dMatrix5x52.a34) + (dMatrix5x5.a44 * dMatrix5x52.a44) + (dMatrix5x5.a54 * dMatrix5x52.a54);
        dMatrix5x53.a45 = (dMatrix5x5.a14 * dMatrix5x52.a15) + (dMatrix5x5.a24 * dMatrix5x52.a25) + (dMatrix5x5.a34 * dMatrix5x52.a35) + (dMatrix5x5.a44 * dMatrix5x52.a45) + (dMatrix5x5.a54 * dMatrix5x52.a55);
        dMatrix5x53.a51 = (dMatrix5x5.a15 * dMatrix5x52.a11) + (dMatrix5x5.a25 * dMatrix5x52.a21) + (dMatrix5x5.a35 * dMatrix5x52.a31) + (dMatrix5x5.a45 * dMatrix5x52.a41) + (dMatrix5x5.a55 * dMatrix5x52.a51);
        dMatrix5x53.a52 = (dMatrix5x5.a15 * dMatrix5x52.a12) + (dMatrix5x5.a25 * dMatrix5x52.a22) + (dMatrix5x5.a35 * dMatrix5x52.a32) + (dMatrix5x5.a45 * dMatrix5x52.a42) + (dMatrix5x5.a55 * dMatrix5x52.a52);
        dMatrix5x53.a53 = (dMatrix5x5.a15 * dMatrix5x52.a13) + (dMatrix5x5.a25 * dMatrix5x52.a23) + (dMatrix5x5.a35 * dMatrix5x52.a33) + (dMatrix5x5.a45 * dMatrix5x52.a43) + (dMatrix5x5.a55 * dMatrix5x52.a53);
        dMatrix5x53.a54 = (dMatrix5x5.a15 * dMatrix5x52.a14) + (dMatrix5x5.a25 * dMatrix5x52.a24) + (dMatrix5x5.a35 * dMatrix5x52.a34) + (dMatrix5x5.a45 * dMatrix5x52.a44) + (dMatrix5x5.a55 * dMatrix5x52.a54);
        dMatrix5x53.a55 = (dMatrix5x5.a15 * dMatrix5x52.a15) + (dMatrix5x5.a25 * dMatrix5x52.a25) + (dMatrix5x5.a35 * dMatrix5x52.a35) + (dMatrix5x5.a45 * dMatrix5x52.a45) + (dMatrix5x5.a55 * dMatrix5x52.a55);
    }

    public static void multTransAB(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52, DMatrix5x5 dMatrix5x53) {
        dMatrix5x53.a11 = (dMatrix5x5.a11 * dMatrix5x52.a11) + (dMatrix5x5.a21 * dMatrix5x52.a12) + (dMatrix5x5.a31 * dMatrix5x52.a13) + (dMatrix5x5.a41 * dMatrix5x52.a14) + (dMatrix5x5.a51 * dMatrix5x52.a15);
        dMatrix5x53.a12 = (dMatrix5x5.a11 * dMatrix5x52.a21) + (dMatrix5x5.a21 * dMatrix5x52.a22) + (dMatrix5x5.a31 * dMatrix5x52.a23) + (dMatrix5x5.a41 * dMatrix5x52.a24) + (dMatrix5x5.a51 * dMatrix5x52.a25);
        dMatrix5x53.a13 = (dMatrix5x5.a11 * dMatrix5x52.a31) + (dMatrix5x5.a21 * dMatrix5x52.a32) + (dMatrix5x5.a31 * dMatrix5x52.a33) + (dMatrix5x5.a41 * dMatrix5x52.a34) + (dMatrix5x5.a51 * dMatrix5x52.a35);
        dMatrix5x53.a14 = (dMatrix5x5.a11 * dMatrix5x52.a41) + (dMatrix5x5.a21 * dMatrix5x52.a42) + (dMatrix5x5.a31 * dMatrix5x52.a43) + (dMatrix5x5.a41 * dMatrix5x52.a44) + (dMatrix5x5.a51 * dMatrix5x52.a45);
        dMatrix5x53.a15 = (dMatrix5x5.a11 * dMatrix5x52.a51) + (dMatrix5x5.a21 * dMatrix5x52.a52) + (dMatrix5x5.a31 * dMatrix5x52.a53) + (dMatrix5x5.a41 * dMatrix5x52.a54) + (dMatrix5x5.a51 * dMatrix5x52.a55);
        dMatrix5x53.a21 = (dMatrix5x5.a12 * dMatrix5x52.a11) + (dMatrix5x5.a22 * dMatrix5x52.a12) + (dMatrix5x5.a32 * dMatrix5x52.a13) + (dMatrix5x5.a42 * dMatrix5x52.a14) + (dMatrix5x5.a52 * dMatrix5x52.a15);
        dMatrix5x53.a22 = (dMatrix5x5.a12 * dMatrix5x52.a21) + (dMatrix5x5.a22 * dMatrix5x52.a22) + (dMatrix5x5.a32 * dMatrix5x52.a23) + (dMatrix5x5.a42 * dMatrix5x52.a24) + (dMatrix5x5.a52 * dMatrix5x52.a25);
        dMatrix5x53.a23 = (dMatrix5x5.a12 * dMatrix5x52.a31) + (dMatrix5x5.a22 * dMatrix5x52.a32) + (dMatrix5x5.a32 * dMatrix5x52.a33) + (dMatrix5x5.a42 * dMatrix5x52.a34) + (dMatrix5x5.a52 * dMatrix5x52.a35);
        dMatrix5x53.a24 = (dMatrix5x5.a12 * dMatrix5x52.a41) + (dMatrix5x5.a22 * dMatrix5x52.a42) + (dMatrix5x5.a32 * dMatrix5x52.a43) + (dMatrix5x5.a42 * dMatrix5x52.a44) + (dMatrix5x5.a52 * dMatrix5x52.a45);
        dMatrix5x53.a25 = (dMatrix5x5.a12 * dMatrix5x52.a51) + (dMatrix5x5.a22 * dMatrix5x52.a52) + (dMatrix5x5.a32 * dMatrix5x52.a53) + (dMatrix5x5.a42 * dMatrix5x52.a54) + (dMatrix5x5.a52 * dMatrix5x52.a55);
        dMatrix5x53.a31 = (dMatrix5x5.a13 * dMatrix5x52.a11) + (dMatrix5x5.a23 * dMatrix5x52.a12) + (dMatrix5x5.a33 * dMatrix5x52.a13) + (dMatrix5x5.a43 * dMatrix5x52.a14) + (dMatrix5x5.a53 * dMatrix5x52.a15);
        dMatrix5x53.a32 = (dMatrix5x5.a13 * dMatrix5x52.a21) + (dMatrix5x5.a23 * dMatrix5x52.a22) + (dMatrix5x5.a33 * dMatrix5x52.a23) + (dMatrix5x5.a43 * dMatrix5x52.a24) + (dMatrix5x5.a53 * dMatrix5x52.a25);
        dMatrix5x53.a33 = (dMatrix5x5.a13 * dMatrix5x52.a31) + (dMatrix5x5.a23 * dMatrix5x52.a32) + (dMatrix5x5.a33 * dMatrix5x52.a33) + (dMatrix5x5.a43 * dMatrix5x52.a34) + (dMatrix5x5.a53 * dMatrix5x52.a35);
        dMatrix5x53.a34 = (dMatrix5x5.a13 * dMatrix5x52.a41) + (dMatrix5x5.a23 * dMatrix5x52.a42) + (dMatrix5x5.a33 * dMatrix5x52.a43) + (dMatrix5x5.a43 * dMatrix5x52.a44) + (dMatrix5x5.a53 * dMatrix5x52.a45);
        dMatrix5x53.a35 = (dMatrix5x5.a13 * dMatrix5x52.a51) + (dMatrix5x5.a23 * dMatrix5x52.a52) + (dMatrix5x5.a33 * dMatrix5x52.a53) + (dMatrix5x5.a43 * dMatrix5x52.a54) + (dMatrix5x5.a53 * dMatrix5x52.a55);
        dMatrix5x53.a41 = (dMatrix5x5.a14 * dMatrix5x52.a11) + (dMatrix5x5.a24 * dMatrix5x52.a12) + (dMatrix5x5.a34 * dMatrix5x52.a13) + (dMatrix5x5.a44 * dMatrix5x52.a14) + (dMatrix5x5.a54 * dMatrix5x52.a15);
        dMatrix5x53.a42 = (dMatrix5x5.a14 * dMatrix5x52.a21) + (dMatrix5x5.a24 * dMatrix5x52.a22) + (dMatrix5x5.a34 * dMatrix5x52.a23) + (dMatrix5x5.a44 * dMatrix5x52.a24) + (dMatrix5x5.a54 * dMatrix5x52.a25);
        dMatrix5x53.a43 = (dMatrix5x5.a14 * dMatrix5x52.a31) + (dMatrix5x5.a24 * dMatrix5x52.a32) + (dMatrix5x5.a34 * dMatrix5x52.a33) + (dMatrix5x5.a44 * dMatrix5x52.a34) + (dMatrix5x5.a54 * dMatrix5x52.a35);
        dMatrix5x53.a44 = (dMatrix5x5.a14 * dMatrix5x52.a41) + (dMatrix5x5.a24 * dMatrix5x52.a42) + (dMatrix5x5.a34 * dMatrix5x52.a43) + (dMatrix5x5.a44 * dMatrix5x52.a44) + (dMatrix5x5.a54 * dMatrix5x52.a45);
        dMatrix5x53.a45 = (dMatrix5x5.a14 * dMatrix5x52.a51) + (dMatrix5x5.a24 * dMatrix5x52.a52) + (dMatrix5x5.a34 * dMatrix5x52.a53) + (dMatrix5x5.a44 * dMatrix5x52.a54) + (dMatrix5x5.a54 * dMatrix5x52.a55);
        dMatrix5x53.a51 = (dMatrix5x5.a15 * dMatrix5x52.a11) + (dMatrix5x5.a25 * dMatrix5x52.a12) + (dMatrix5x5.a35 * dMatrix5x52.a13) + (dMatrix5x5.a45 * dMatrix5x52.a14) + (dMatrix5x5.a55 * dMatrix5x52.a15);
        dMatrix5x53.a52 = (dMatrix5x5.a15 * dMatrix5x52.a21) + (dMatrix5x5.a25 * dMatrix5x52.a22) + (dMatrix5x5.a35 * dMatrix5x52.a23) + (dMatrix5x5.a45 * dMatrix5x52.a24) + (dMatrix5x5.a55 * dMatrix5x52.a25);
        dMatrix5x53.a53 = (dMatrix5x5.a15 * dMatrix5x52.a31) + (dMatrix5x5.a25 * dMatrix5x52.a32) + (dMatrix5x5.a35 * dMatrix5x52.a33) + (dMatrix5x5.a45 * dMatrix5x52.a34) + (dMatrix5x5.a55 * dMatrix5x52.a35);
        dMatrix5x53.a54 = (dMatrix5x5.a15 * dMatrix5x52.a41) + (dMatrix5x5.a25 * dMatrix5x52.a42) + (dMatrix5x5.a35 * dMatrix5x52.a43) + (dMatrix5x5.a45 * dMatrix5x52.a44) + (dMatrix5x5.a55 * dMatrix5x52.a45);
        dMatrix5x53.a55 = (dMatrix5x5.a15 * dMatrix5x52.a51) + (dMatrix5x5.a25 * dMatrix5x52.a52) + (dMatrix5x5.a35 * dMatrix5x52.a53) + (dMatrix5x5.a45 * dMatrix5x52.a54) + (dMatrix5x5.a55 * dMatrix5x52.a55);
    }

    public static void multTransB(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52, DMatrix5x5 dMatrix5x53) {
        dMatrix5x53.a11 = (dMatrix5x5.a11 * dMatrix5x52.a11) + (dMatrix5x5.a12 * dMatrix5x52.a12) + (dMatrix5x5.a13 * dMatrix5x52.a13) + (dMatrix5x5.a14 * dMatrix5x52.a14) + (dMatrix5x5.a15 * dMatrix5x52.a15);
        dMatrix5x53.a12 = (dMatrix5x5.a11 * dMatrix5x52.a21) + (dMatrix5x5.a12 * dMatrix5x52.a22) + (dMatrix5x5.a13 * dMatrix5x52.a23) + (dMatrix5x5.a14 * dMatrix5x52.a24) + (dMatrix5x5.a15 * dMatrix5x52.a25);
        dMatrix5x53.a13 = (dMatrix5x5.a11 * dMatrix5x52.a31) + (dMatrix5x5.a12 * dMatrix5x52.a32) + (dMatrix5x5.a13 * dMatrix5x52.a33) + (dMatrix5x5.a14 * dMatrix5x52.a34) + (dMatrix5x5.a15 * dMatrix5x52.a35);
        dMatrix5x53.a14 = (dMatrix5x5.a11 * dMatrix5x52.a41) + (dMatrix5x5.a12 * dMatrix5x52.a42) + (dMatrix5x5.a13 * dMatrix5x52.a43) + (dMatrix5x5.a14 * dMatrix5x52.a44) + (dMatrix5x5.a15 * dMatrix5x52.a45);
        dMatrix5x53.a15 = (dMatrix5x5.a11 * dMatrix5x52.a51) + (dMatrix5x5.a12 * dMatrix5x52.a52) + (dMatrix5x5.a13 * dMatrix5x52.a53) + (dMatrix5x5.a14 * dMatrix5x52.a54) + (dMatrix5x5.a15 * dMatrix5x52.a55);
        dMatrix5x53.a21 = (dMatrix5x5.a21 * dMatrix5x52.a11) + (dMatrix5x5.a22 * dMatrix5x52.a12) + (dMatrix5x5.a23 * dMatrix5x52.a13) + (dMatrix5x5.a24 * dMatrix5x52.a14) + (dMatrix5x5.a25 * dMatrix5x52.a15);
        dMatrix5x53.a22 = (dMatrix5x5.a21 * dMatrix5x52.a21) + (dMatrix5x5.a22 * dMatrix5x52.a22) + (dMatrix5x5.a23 * dMatrix5x52.a23) + (dMatrix5x5.a24 * dMatrix5x52.a24) + (dMatrix5x5.a25 * dMatrix5x52.a25);
        dMatrix5x53.a23 = (dMatrix5x5.a21 * dMatrix5x52.a31) + (dMatrix5x5.a22 * dMatrix5x52.a32) + (dMatrix5x5.a23 * dMatrix5x52.a33) + (dMatrix5x5.a24 * dMatrix5x52.a34) + (dMatrix5x5.a25 * dMatrix5x52.a35);
        dMatrix5x53.a24 = (dMatrix5x5.a21 * dMatrix5x52.a41) + (dMatrix5x5.a22 * dMatrix5x52.a42) + (dMatrix5x5.a23 * dMatrix5x52.a43) + (dMatrix5x5.a24 * dMatrix5x52.a44) + (dMatrix5x5.a25 * dMatrix5x52.a45);
        dMatrix5x53.a25 = (dMatrix5x5.a21 * dMatrix5x52.a51) + (dMatrix5x5.a22 * dMatrix5x52.a52) + (dMatrix5x5.a23 * dMatrix5x52.a53) + (dMatrix5x5.a24 * dMatrix5x52.a54) + (dMatrix5x5.a25 * dMatrix5x52.a55);
        dMatrix5x53.a31 = (dMatrix5x5.a31 * dMatrix5x52.a11) + (dMatrix5x5.a32 * dMatrix5x52.a12) + (dMatrix5x5.a33 * dMatrix5x52.a13) + (dMatrix5x5.a34 * dMatrix5x52.a14) + (dMatrix5x5.a35 * dMatrix5x52.a15);
        dMatrix5x53.a32 = (dMatrix5x5.a31 * dMatrix5x52.a21) + (dMatrix5x5.a32 * dMatrix5x52.a22) + (dMatrix5x5.a33 * dMatrix5x52.a23) + (dMatrix5x5.a34 * dMatrix5x52.a24) + (dMatrix5x5.a35 * dMatrix5x52.a25);
        dMatrix5x53.a33 = (dMatrix5x5.a31 * dMatrix5x52.a31) + (dMatrix5x5.a32 * dMatrix5x52.a32) + (dMatrix5x5.a33 * dMatrix5x52.a33) + (dMatrix5x5.a34 * dMatrix5x52.a34) + (dMatrix5x5.a35 * dMatrix5x52.a35);
        dMatrix5x53.a34 = (dMatrix5x5.a31 * dMatrix5x52.a41) + (dMatrix5x5.a32 * dMatrix5x52.a42) + (dMatrix5x5.a33 * dMatrix5x52.a43) + (dMatrix5x5.a34 * dMatrix5x52.a44) + (dMatrix5x5.a35 * dMatrix5x52.a45);
        dMatrix5x53.a35 = (dMatrix5x5.a31 * dMatrix5x52.a51) + (dMatrix5x5.a32 * dMatrix5x52.a52) + (dMatrix5x5.a33 * dMatrix5x52.a53) + (dMatrix5x5.a34 * dMatrix5x52.a54) + (dMatrix5x5.a35 * dMatrix5x52.a55);
        dMatrix5x53.a41 = (dMatrix5x5.a41 * dMatrix5x52.a11) + (dMatrix5x5.a42 * dMatrix5x52.a12) + (dMatrix5x5.a43 * dMatrix5x52.a13) + (dMatrix5x5.a44 * dMatrix5x52.a14) + (dMatrix5x5.a45 * dMatrix5x52.a15);
        dMatrix5x53.a42 = (dMatrix5x5.a41 * dMatrix5x52.a21) + (dMatrix5x5.a42 * dMatrix5x52.a22) + (dMatrix5x5.a43 * dMatrix5x52.a23) + (dMatrix5x5.a44 * dMatrix5x52.a24) + (dMatrix5x5.a45 * dMatrix5x52.a25);
        dMatrix5x53.a43 = (dMatrix5x5.a41 * dMatrix5x52.a31) + (dMatrix5x5.a42 * dMatrix5x52.a32) + (dMatrix5x5.a43 * dMatrix5x52.a33) + (dMatrix5x5.a44 * dMatrix5x52.a34) + (dMatrix5x5.a45 * dMatrix5x52.a35);
        dMatrix5x53.a44 = (dMatrix5x5.a41 * dMatrix5x52.a41) + (dMatrix5x5.a42 * dMatrix5x52.a42) + (dMatrix5x5.a43 * dMatrix5x52.a43) + (dMatrix5x5.a44 * dMatrix5x52.a44) + (dMatrix5x5.a45 * dMatrix5x52.a45);
        dMatrix5x53.a45 = (dMatrix5x5.a41 * dMatrix5x52.a51) + (dMatrix5x5.a42 * dMatrix5x52.a52) + (dMatrix5x5.a43 * dMatrix5x52.a53) + (dMatrix5x5.a44 * dMatrix5x52.a54) + (dMatrix5x5.a45 * dMatrix5x52.a55);
        dMatrix5x53.a51 = (dMatrix5x5.a51 * dMatrix5x52.a11) + (dMatrix5x5.a52 * dMatrix5x52.a12) + (dMatrix5x5.a53 * dMatrix5x52.a13) + (dMatrix5x5.a54 * dMatrix5x52.a14) + (dMatrix5x5.a55 * dMatrix5x52.a15);
        dMatrix5x53.a52 = (dMatrix5x5.a51 * dMatrix5x52.a21) + (dMatrix5x5.a52 * dMatrix5x52.a22) + (dMatrix5x5.a53 * dMatrix5x52.a23) + (dMatrix5x5.a54 * dMatrix5x52.a24) + (dMatrix5x5.a55 * dMatrix5x52.a25);
        dMatrix5x53.a53 = (dMatrix5x5.a51 * dMatrix5x52.a31) + (dMatrix5x5.a52 * dMatrix5x52.a32) + (dMatrix5x5.a53 * dMatrix5x52.a33) + (dMatrix5x5.a54 * dMatrix5x52.a34) + (dMatrix5x5.a55 * dMatrix5x52.a35);
        dMatrix5x53.a54 = (dMatrix5x5.a51 * dMatrix5x52.a41) + (dMatrix5x5.a52 * dMatrix5x52.a42) + (dMatrix5x5.a53 * dMatrix5x52.a43) + (dMatrix5x5.a54 * dMatrix5x52.a44) + (dMatrix5x5.a55 * dMatrix5x52.a45);
        dMatrix5x53.a55 = (dMatrix5x5.a51 * dMatrix5x52.a51) + (dMatrix5x5.a52 * dMatrix5x52.a52) + (dMatrix5x5.a53 * dMatrix5x52.a53) + (dMatrix5x5.a54 * dMatrix5x52.a54) + (dMatrix5x5.a55 * dMatrix5x52.a55);
    }

    public static void multAdd(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52, DMatrix5x5 dMatrix5x53) {
        dMatrix5x53.a11 += (dMatrix5x5.a11 * dMatrix5x52.a11) + (dMatrix5x5.a12 * dMatrix5x52.a21) + (dMatrix5x5.a13 * dMatrix5x52.a31) + (dMatrix5x5.a14 * dMatrix5x52.a41) + (dMatrix5x5.a15 * dMatrix5x52.a51);
        dMatrix5x53.a12 += (dMatrix5x5.a11 * dMatrix5x52.a12) + (dMatrix5x5.a12 * dMatrix5x52.a22) + (dMatrix5x5.a13 * dMatrix5x52.a32) + (dMatrix5x5.a14 * dMatrix5x52.a42) + (dMatrix5x5.a15 * dMatrix5x52.a52);
        dMatrix5x53.a13 += (dMatrix5x5.a11 * dMatrix5x52.a13) + (dMatrix5x5.a12 * dMatrix5x52.a23) + (dMatrix5x5.a13 * dMatrix5x52.a33) + (dMatrix5x5.a14 * dMatrix5x52.a43) + (dMatrix5x5.a15 * dMatrix5x52.a53);
        dMatrix5x53.a14 += (dMatrix5x5.a11 * dMatrix5x52.a14) + (dMatrix5x5.a12 * dMatrix5x52.a24) + (dMatrix5x5.a13 * dMatrix5x52.a34) + (dMatrix5x5.a14 * dMatrix5x52.a44) + (dMatrix5x5.a15 * dMatrix5x52.a54);
        dMatrix5x53.a15 += (dMatrix5x5.a11 * dMatrix5x52.a15) + (dMatrix5x5.a12 * dMatrix5x52.a25) + (dMatrix5x5.a13 * dMatrix5x52.a35) + (dMatrix5x5.a14 * dMatrix5x52.a45) + (dMatrix5x5.a15 * dMatrix5x52.a55);
        dMatrix5x53.a21 += (dMatrix5x5.a21 * dMatrix5x52.a11) + (dMatrix5x5.a22 * dMatrix5x52.a21) + (dMatrix5x5.a23 * dMatrix5x52.a31) + (dMatrix5x5.a24 * dMatrix5x52.a41) + (dMatrix5x5.a25 * dMatrix5x52.a51);
        dMatrix5x53.a22 += (dMatrix5x5.a21 * dMatrix5x52.a12) + (dMatrix5x5.a22 * dMatrix5x52.a22) + (dMatrix5x5.a23 * dMatrix5x52.a32) + (dMatrix5x5.a24 * dMatrix5x52.a42) + (dMatrix5x5.a25 * dMatrix5x52.a52);
        dMatrix5x53.a23 += (dMatrix5x5.a21 * dMatrix5x52.a13) + (dMatrix5x5.a22 * dMatrix5x52.a23) + (dMatrix5x5.a23 * dMatrix5x52.a33) + (dMatrix5x5.a24 * dMatrix5x52.a43) + (dMatrix5x5.a25 * dMatrix5x52.a53);
        dMatrix5x53.a24 += (dMatrix5x5.a21 * dMatrix5x52.a14) + (dMatrix5x5.a22 * dMatrix5x52.a24) + (dMatrix5x5.a23 * dMatrix5x52.a34) + (dMatrix5x5.a24 * dMatrix5x52.a44) + (dMatrix5x5.a25 * dMatrix5x52.a54);
        dMatrix5x53.a25 += (dMatrix5x5.a21 * dMatrix5x52.a15) + (dMatrix5x5.a22 * dMatrix5x52.a25) + (dMatrix5x5.a23 * dMatrix5x52.a35) + (dMatrix5x5.a24 * dMatrix5x52.a45) + (dMatrix5x5.a25 * dMatrix5x52.a55);
        dMatrix5x53.a31 += (dMatrix5x5.a31 * dMatrix5x52.a11) + (dMatrix5x5.a32 * dMatrix5x52.a21) + (dMatrix5x5.a33 * dMatrix5x52.a31) + (dMatrix5x5.a34 * dMatrix5x52.a41) + (dMatrix5x5.a35 * dMatrix5x52.a51);
        dMatrix5x53.a32 += (dMatrix5x5.a31 * dMatrix5x52.a12) + (dMatrix5x5.a32 * dMatrix5x52.a22) + (dMatrix5x5.a33 * dMatrix5x52.a32) + (dMatrix5x5.a34 * dMatrix5x52.a42) + (dMatrix5x5.a35 * dMatrix5x52.a52);
        dMatrix5x53.a33 += (dMatrix5x5.a31 * dMatrix5x52.a13) + (dMatrix5x5.a32 * dMatrix5x52.a23) + (dMatrix5x5.a33 * dMatrix5x52.a33) + (dMatrix5x5.a34 * dMatrix5x52.a43) + (dMatrix5x5.a35 * dMatrix5x52.a53);
        dMatrix5x53.a34 += (dMatrix5x5.a31 * dMatrix5x52.a14) + (dMatrix5x5.a32 * dMatrix5x52.a24) + (dMatrix5x5.a33 * dMatrix5x52.a34) + (dMatrix5x5.a34 * dMatrix5x52.a44) + (dMatrix5x5.a35 * dMatrix5x52.a54);
        dMatrix5x53.a35 += (dMatrix5x5.a31 * dMatrix5x52.a15) + (dMatrix5x5.a32 * dMatrix5x52.a25) + (dMatrix5x5.a33 * dMatrix5x52.a35) + (dMatrix5x5.a34 * dMatrix5x52.a45) + (dMatrix5x5.a35 * dMatrix5x52.a55);
        dMatrix5x53.a41 += (dMatrix5x5.a41 * dMatrix5x52.a11) + (dMatrix5x5.a42 * dMatrix5x52.a21) + (dMatrix5x5.a43 * dMatrix5x52.a31) + (dMatrix5x5.a44 * dMatrix5x52.a41) + (dMatrix5x5.a45 * dMatrix5x52.a51);
        dMatrix5x53.a42 += (dMatrix5x5.a41 * dMatrix5x52.a12) + (dMatrix5x5.a42 * dMatrix5x52.a22) + (dMatrix5x5.a43 * dMatrix5x52.a32) + (dMatrix5x5.a44 * dMatrix5x52.a42) + (dMatrix5x5.a45 * dMatrix5x52.a52);
        dMatrix5x53.a43 += (dMatrix5x5.a41 * dMatrix5x52.a13) + (dMatrix5x5.a42 * dMatrix5x52.a23) + (dMatrix5x5.a43 * dMatrix5x52.a33) + (dMatrix5x5.a44 * dMatrix5x52.a43) + (dMatrix5x5.a45 * dMatrix5x52.a53);
        dMatrix5x53.a44 += (dMatrix5x5.a41 * dMatrix5x52.a14) + (dMatrix5x5.a42 * dMatrix5x52.a24) + (dMatrix5x5.a43 * dMatrix5x52.a34) + (dMatrix5x5.a44 * dMatrix5x52.a44) + (dMatrix5x5.a45 * dMatrix5x52.a54);
        dMatrix5x53.a45 += (dMatrix5x5.a41 * dMatrix5x52.a15) + (dMatrix5x5.a42 * dMatrix5x52.a25) + (dMatrix5x5.a43 * dMatrix5x52.a35) + (dMatrix5x5.a44 * dMatrix5x52.a45) + (dMatrix5x5.a45 * dMatrix5x52.a55);
        dMatrix5x53.a51 += (dMatrix5x5.a51 * dMatrix5x52.a11) + (dMatrix5x5.a52 * dMatrix5x52.a21) + (dMatrix5x5.a53 * dMatrix5x52.a31) + (dMatrix5x5.a54 * dMatrix5x52.a41) + (dMatrix5x5.a55 * dMatrix5x52.a51);
        dMatrix5x53.a52 += (dMatrix5x5.a51 * dMatrix5x52.a12) + (dMatrix5x5.a52 * dMatrix5x52.a22) + (dMatrix5x5.a53 * dMatrix5x52.a32) + (dMatrix5x5.a54 * dMatrix5x52.a42) + (dMatrix5x5.a55 * dMatrix5x52.a52);
        dMatrix5x53.a53 += (dMatrix5x5.a51 * dMatrix5x52.a13) + (dMatrix5x5.a52 * dMatrix5x52.a23) + (dMatrix5x5.a53 * dMatrix5x52.a33) + (dMatrix5x5.a54 * dMatrix5x52.a43) + (dMatrix5x5.a55 * dMatrix5x52.a53);
        dMatrix5x53.a54 += (dMatrix5x5.a51 * dMatrix5x52.a14) + (dMatrix5x5.a52 * dMatrix5x52.a24) + (dMatrix5x5.a53 * dMatrix5x52.a34) + (dMatrix5x5.a54 * dMatrix5x52.a44) + (dMatrix5x5.a55 * dMatrix5x52.a54);
        dMatrix5x53.a55 += (dMatrix5x5.a51 * dMatrix5x52.a15) + (dMatrix5x5.a52 * dMatrix5x52.a25) + (dMatrix5x5.a53 * dMatrix5x52.a35) + (dMatrix5x5.a54 * dMatrix5x52.a45) + (dMatrix5x5.a55 * dMatrix5x52.a55);
    }

    public static void multAddTransA(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52, DMatrix5x5 dMatrix5x53) {
        dMatrix5x53.a11 += (dMatrix5x5.a11 * dMatrix5x52.a11) + (dMatrix5x5.a21 * dMatrix5x52.a21) + (dMatrix5x5.a31 * dMatrix5x52.a31) + (dMatrix5x5.a41 * dMatrix5x52.a41) + (dMatrix5x5.a51 * dMatrix5x52.a51);
        dMatrix5x53.a12 += (dMatrix5x5.a11 * dMatrix5x52.a12) + (dMatrix5x5.a21 * dMatrix5x52.a22) + (dMatrix5x5.a31 * dMatrix5x52.a32) + (dMatrix5x5.a41 * dMatrix5x52.a42) + (dMatrix5x5.a51 * dMatrix5x52.a52);
        dMatrix5x53.a13 += (dMatrix5x5.a11 * dMatrix5x52.a13) + (dMatrix5x5.a21 * dMatrix5x52.a23) + (dMatrix5x5.a31 * dMatrix5x52.a33) + (dMatrix5x5.a41 * dMatrix5x52.a43) + (dMatrix5x5.a51 * dMatrix5x52.a53);
        dMatrix5x53.a14 += (dMatrix5x5.a11 * dMatrix5x52.a14) + (dMatrix5x5.a21 * dMatrix5x52.a24) + (dMatrix5x5.a31 * dMatrix5x52.a34) + (dMatrix5x5.a41 * dMatrix5x52.a44) + (dMatrix5x5.a51 * dMatrix5x52.a54);
        dMatrix5x53.a15 += (dMatrix5x5.a11 * dMatrix5x52.a15) + (dMatrix5x5.a21 * dMatrix5x52.a25) + (dMatrix5x5.a31 * dMatrix5x52.a35) + (dMatrix5x5.a41 * dMatrix5x52.a45) + (dMatrix5x5.a51 * dMatrix5x52.a55);
        dMatrix5x53.a21 += (dMatrix5x5.a12 * dMatrix5x52.a11) + (dMatrix5x5.a22 * dMatrix5x52.a21) + (dMatrix5x5.a32 * dMatrix5x52.a31) + (dMatrix5x5.a42 * dMatrix5x52.a41) + (dMatrix5x5.a52 * dMatrix5x52.a51);
        dMatrix5x53.a22 += (dMatrix5x5.a12 * dMatrix5x52.a12) + (dMatrix5x5.a22 * dMatrix5x52.a22) + (dMatrix5x5.a32 * dMatrix5x52.a32) + (dMatrix5x5.a42 * dMatrix5x52.a42) + (dMatrix5x5.a52 * dMatrix5x52.a52);
        dMatrix5x53.a23 += (dMatrix5x5.a12 * dMatrix5x52.a13) + (dMatrix5x5.a22 * dMatrix5x52.a23) + (dMatrix5x5.a32 * dMatrix5x52.a33) + (dMatrix5x5.a42 * dMatrix5x52.a43) + (dMatrix5x5.a52 * dMatrix5x52.a53);
        dMatrix5x53.a24 += (dMatrix5x5.a12 * dMatrix5x52.a14) + (dMatrix5x5.a22 * dMatrix5x52.a24) + (dMatrix5x5.a32 * dMatrix5x52.a34) + (dMatrix5x5.a42 * dMatrix5x52.a44) + (dMatrix5x5.a52 * dMatrix5x52.a54);
        dMatrix5x53.a25 += (dMatrix5x5.a12 * dMatrix5x52.a15) + (dMatrix5x5.a22 * dMatrix5x52.a25) + (dMatrix5x5.a32 * dMatrix5x52.a35) + (dMatrix5x5.a42 * dMatrix5x52.a45) + (dMatrix5x5.a52 * dMatrix5x52.a55);
        dMatrix5x53.a31 += (dMatrix5x5.a13 * dMatrix5x52.a11) + (dMatrix5x5.a23 * dMatrix5x52.a21) + (dMatrix5x5.a33 * dMatrix5x52.a31) + (dMatrix5x5.a43 * dMatrix5x52.a41) + (dMatrix5x5.a53 * dMatrix5x52.a51);
        dMatrix5x53.a32 += (dMatrix5x5.a13 * dMatrix5x52.a12) + (dMatrix5x5.a23 * dMatrix5x52.a22) + (dMatrix5x5.a33 * dMatrix5x52.a32) + (dMatrix5x5.a43 * dMatrix5x52.a42) + (dMatrix5x5.a53 * dMatrix5x52.a52);
        dMatrix5x53.a33 += (dMatrix5x5.a13 * dMatrix5x52.a13) + (dMatrix5x5.a23 * dMatrix5x52.a23) + (dMatrix5x5.a33 * dMatrix5x52.a33) + (dMatrix5x5.a43 * dMatrix5x52.a43) + (dMatrix5x5.a53 * dMatrix5x52.a53);
        dMatrix5x53.a34 += (dMatrix5x5.a13 * dMatrix5x52.a14) + (dMatrix5x5.a23 * dMatrix5x52.a24) + (dMatrix5x5.a33 * dMatrix5x52.a34) + (dMatrix5x5.a43 * dMatrix5x52.a44) + (dMatrix5x5.a53 * dMatrix5x52.a54);
        dMatrix5x53.a35 += (dMatrix5x5.a13 * dMatrix5x52.a15) + (dMatrix5x5.a23 * dMatrix5x52.a25) + (dMatrix5x5.a33 * dMatrix5x52.a35) + (dMatrix5x5.a43 * dMatrix5x52.a45) + (dMatrix5x5.a53 * dMatrix5x52.a55);
        dMatrix5x53.a41 += (dMatrix5x5.a14 * dMatrix5x52.a11) + (dMatrix5x5.a24 * dMatrix5x52.a21) + (dMatrix5x5.a34 * dMatrix5x52.a31) + (dMatrix5x5.a44 * dMatrix5x52.a41) + (dMatrix5x5.a54 * dMatrix5x52.a51);
        dMatrix5x53.a42 += (dMatrix5x5.a14 * dMatrix5x52.a12) + (dMatrix5x5.a24 * dMatrix5x52.a22) + (dMatrix5x5.a34 * dMatrix5x52.a32) + (dMatrix5x5.a44 * dMatrix5x52.a42) + (dMatrix5x5.a54 * dMatrix5x52.a52);
        dMatrix5x53.a43 += (dMatrix5x5.a14 * dMatrix5x52.a13) + (dMatrix5x5.a24 * dMatrix5x52.a23) + (dMatrix5x5.a34 * dMatrix5x52.a33) + (dMatrix5x5.a44 * dMatrix5x52.a43) + (dMatrix5x5.a54 * dMatrix5x52.a53);
        dMatrix5x53.a44 += (dMatrix5x5.a14 * dMatrix5x52.a14) + (dMatrix5x5.a24 * dMatrix5x52.a24) + (dMatrix5x5.a34 * dMatrix5x52.a34) + (dMatrix5x5.a44 * dMatrix5x52.a44) + (dMatrix5x5.a54 * dMatrix5x52.a54);
        dMatrix5x53.a45 += (dMatrix5x5.a14 * dMatrix5x52.a15) + (dMatrix5x5.a24 * dMatrix5x52.a25) + (dMatrix5x5.a34 * dMatrix5x52.a35) + (dMatrix5x5.a44 * dMatrix5x52.a45) + (dMatrix5x5.a54 * dMatrix5x52.a55);
        dMatrix5x53.a51 += (dMatrix5x5.a15 * dMatrix5x52.a11) + (dMatrix5x5.a25 * dMatrix5x52.a21) + (dMatrix5x5.a35 * dMatrix5x52.a31) + (dMatrix5x5.a45 * dMatrix5x52.a41) + (dMatrix5x5.a55 * dMatrix5x52.a51);
        dMatrix5x53.a52 += (dMatrix5x5.a15 * dMatrix5x52.a12) + (dMatrix5x5.a25 * dMatrix5x52.a22) + (dMatrix5x5.a35 * dMatrix5x52.a32) + (dMatrix5x5.a45 * dMatrix5x52.a42) + (dMatrix5x5.a55 * dMatrix5x52.a52);
        dMatrix5x53.a53 += (dMatrix5x5.a15 * dMatrix5x52.a13) + (dMatrix5x5.a25 * dMatrix5x52.a23) + (dMatrix5x5.a35 * dMatrix5x52.a33) + (dMatrix5x5.a45 * dMatrix5x52.a43) + (dMatrix5x5.a55 * dMatrix5x52.a53);
        dMatrix5x53.a54 += (dMatrix5x5.a15 * dMatrix5x52.a14) + (dMatrix5x5.a25 * dMatrix5x52.a24) + (dMatrix5x5.a35 * dMatrix5x52.a34) + (dMatrix5x5.a45 * dMatrix5x52.a44) + (dMatrix5x5.a55 * dMatrix5x52.a54);
        dMatrix5x53.a55 += (dMatrix5x5.a15 * dMatrix5x52.a15) + (dMatrix5x5.a25 * dMatrix5x52.a25) + (dMatrix5x5.a35 * dMatrix5x52.a35) + (dMatrix5x5.a45 * dMatrix5x52.a45) + (dMatrix5x5.a55 * dMatrix5x52.a55);
    }

    public static void multAddTransAB(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52, DMatrix5x5 dMatrix5x53) {
        dMatrix5x53.a11 += (dMatrix5x5.a11 * dMatrix5x52.a11) + (dMatrix5x5.a21 * dMatrix5x52.a12) + (dMatrix5x5.a31 * dMatrix5x52.a13) + (dMatrix5x5.a41 * dMatrix5x52.a14) + (dMatrix5x5.a51 * dMatrix5x52.a15);
        dMatrix5x53.a12 += (dMatrix5x5.a11 * dMatrix5x52.a21) + (dMatrix5x5.a21 * dMatrix5x52.a22) + (dMatrix5x5.a31 * dMatrix5x52.a23) + (dMatrix5x5.a41 * dMatrix5x52.a24) + (dMatrix5x5.a51 * dMatrix5x52.a25);
        dMatrix5x53.a13 += (dMatrix5x5.a11 * dMatrix5x52.a31) + (dMatrix5x5.a21 * dMatrix5x52.a32) + (dMatrix5x5.a31 * dMatrix5x52.a33) + (dMatrix5x5.a41 * dMatrix5x52.a34) + (dMatrix5x5.a51 * dMatrix5x52.a35);
        dMatrix5x53.a14 += (dMatrix5x5.a11 * dMatrix5x52.a41) + (dMatrix5x5.a21 * dMatrix5x52.a42) + (dMatrix5x5.a31 * dMatrix5x52.a43) + (dMatrix5x5.a41 * dMatrix5x52.a44) + (dMatrix5x5.a51 * dMatrix5x52.a45);
        dMatrix5x53.a15 += (dMatrix5x5.a11 * dMatrix5x52.a51) + (dMatrix5x5.a21 * dMatrix5x52.a52) + (dMatrix5x5.a31 * dMatrix5x52.a53) + (dMatrix5x5.a41 * dMatrix5x52.a54) + (dMatrix5x5.a51 * dMatrix5x52.a55);
        dMatrix5x53.a21 += (dMatrix5x5.a12 * dMatrix5x52.a11) + (dMatrix5x5.a22 * dMatrix5x52.a12) + (dMatrix5x5.a32 * dMatrix5x52.a13) + (dMatrix5x5.a42 * dMatrix5x52.a14) + (dMatrix5x5.a52 * dMatrix5x52.a15);
        dMatrix5x53.a22 += (dMatrix5x5.a12 * dMatrix5x52.a21) + (dMatrix5x5.a22 * dMatrix5x52.a22) + (dMatrix5x5.a32 * dMatrix5x52.a23) + (dMatrix5x5.a42 * dMatrix5x52.a24) + (dMatrix5x5.a52 * dMatrix5x52.a25);
        dMatrix5x53.a23 += (dMatrix5x5.a12 * dMatrix5x52.a31) + (dMatrix5x5.a22 * dMatrix5x52.a32) + (dMatrix5x5.a32 * dMatrix5x52.a33) + (dMatrix5x5.a42 * dMatrix5x52.a34) + (dMatrix5x5.a52 * dMatrix5x52.a35);
        dMatrix5x53.a24 += (dMatrix5x5.a12 * dMatrix5x52.a41) + (dMatrix5x5.a22 * dMatrix5x52.a42) + (dMatrix5x5.a32 * dMatrix5x52.a43) + (dMatrix5x5.a42 * dMatrix5x52.a44) + (dMatrix5x5.a52 * dMatrix5x52.a45);
        dMatrix5x53.a25 += (dMatrix5x5.a12 * dMatrix5x52.a51) + (dMatrix5x5.a22 * dMatrix5x52.a52) + (dMatrix5x5.a32 * dMatrix5x52.a53) + (dMatrix5x5.a42 * dMatrix5x52.a54) + (dMatrix5x5.a52 * dMatrix5x52.a55);
        dMatrix5x53.a31 += (dMatrix5x5.a13 * dMatrix5x52.a11) + (dMatrix5x5.a23 * dMatrix5x52.a12) + (dMatrix5x5.a33 * dMatrix5x52.a13) + (dMatrix5x5.a43 * dMatrix5x52.a14) + (dMatrix5x5.a53 * dMatrix5x52.a15);
        dMatrix5x53.a32 += (dMatrix5x5.a13 * dMatrix5x52.a21) + (dMatrix5x5.a23 * dMatrix5x52.a22) + (dMatrix5x5.a33 * dMatrix5x52.a23) + (dMatrix5x5.a43 * dMatrix5x52.a24) + (dMatrix5x5.a53 * dMatrix5x52.a25);
        dMatrix5x53.a33 += (dMatrix5x5.a13 * dMatrix5x52.a31) + (dMatrix5x5.a23 * dMatrix5x52.a32) + (dMatrix5x5.a33 * dMatrix5x52.a33) + (dMatrix5x5.a43 * dMatrix5x52.a34) + (dMatrix5x5.a53 * dMatrix5x52.a35);
        dMatrix5x53.a34 += (dMatrix5x5.a13 * dMatrix5x52.a41) + (dMatrix5x5.a23 * dMatrix5x52.a42) + (dMatrix5x5.a33 * dMatrix5x52.a43) + (dMatrix5x5.a43 * dMatrix5x52.a44) + (dMatrix5x5.a53 * dMatrix5x52.a45);
        dMatrix5x53.a35 += (dMatrix5x5.a13 * dMatrix5x52.a51) + (dMatrix5x5.a23 * dMatrix5x52.a52) + (dMatrix5x5.a33 * dMatrix5x52.a53) + (dMatrix5x5.a43 * dMatrix5x52.a54) + (dMatrix5x5.a53 * dMatrix5x52.a55);
        dMatrix5x53.a41 += (dMatrix5x5.a14 * dMatrix5x52.a11) + (dMatrix5x5.a24 * dMatrix5x52.a12) + (dMatrix5x5.a34 * dMatrix5x52.a13) + (dMatrix5x5.a44 * dMatrix5x52.a14) + (dMatrix5x5.a54 * dMatrix5x52.a15);
        dMatrix5x53.a42 += (dMatrix5x5.a14 * dMatrix5x52.a21) + (dMatrix5x5.a24 * dMatrix5x52.a22) + (dMatrix5x5.a34 * dMatrix5x52.a23) + (dMatrix5x5.a44 * dMatrix5x52.a24) + (dMatrix5x5.a54 * dMatrix5x52.a25);
        dMatrix5x53.a43 += (dMatrix5x5.a14 * dMatrix5x52.a31) + (dMatrix5x5.a24 * dMatrix5x52.a32) + (dMatrix5x5.a34 * dMatrix5x52.a33) + (dMatrix5x5.a44 * dMatrix5x52.a34) + (dMatrix5x5.a54 * dMatrix5x52.a35);
        dMatrix5x53.a44 += (dMatrix5x5.a14 * dMatrix5x52.a41) + (dMatrix5x5.a24 * dMatrix5x52.a42) + (dMatrix5x5.a34 * dMatrix5x52.a43) + (dMatrix5x5.a44 * dMatrix5x52.a44) + (dMatrix5x5.a54 * dMatrix5x52.a45);
        dMatrix5x53.a45 += (dMatrix5x5.a14 * dMatrix5x52.a51) + (dMatrix5x5.a24 * dMatrix5x52.a52) + (dMatrix5x5.a34 * dMatrix5x52.a53) + (dMatrix5x5.a44 * dMatrix5x52.a54) + (dMatrix5x5.a54 * dMatrix5x52.a55);
        dMatrix5x53.a51 += (dMatrix5x5.a15 * dMatrix5x52.a11) + (dMatrix5x5.a25 * dMatrix5x52.a12) + (dMatrix5x5.a35 * dMatrix5x52.a13) + (dMatrix5x5.a45 * dMatrix5x52.a14) + (dMatrix5x5.a55 * dMatrix5x52.a15);
        dMatrix5x53.a52 += (dMatrix5x5.a15 * dMatrix5x52.a21) + (dMatrix5x5.a25 * dMatrix5x52.a22) + (dMatrix5x5.a35 * dMatrix5x52.a23) + (dMatrix5x5.a45 * dMatrix5x52.a24) + (dMatrix5x5.a55 * dMatrix5x52.a25);
        dMatrix5x53.a53 += (dMatrix5x5.a15 * dMatrix5x52.a31) + (dMatrix5x5.a25 * dMatrix5x52.a32) + (dMatrix5x5.a35 * dMatrix5x52.a33) + (dMatrix5x5.a45 * dMatrix5x52.a34) + (dMatrix5x5.a55 * dMatrix5x52.a35);
        dMatrix5x53.a54 += (dMatrix5x5.a15 * dMatrix5x52.a41) + (dMatrix5x5.a25 * dMatrix5x52.a42) + (dMatrix5x5.a35 * dMatrix5x52.a43) + (dMatrix5x5.a45 * dMatrix5x52.a44) + (dMatrix5x5.a55 * dMatrix5x52.a45);
        dMatrix5x53.a55 += (dMatrix5x5.a15 * dMatrix5x52.a51) + (dMatrix5x5.a25 * dMatrix5x52.a52) + (dMatrix5x5.a35 * dMatrix5x52.a53) + (dMatrix5x5.a45 * dMatrix5x52.a54) + (dMatrix5x5.a55 * dMatrix5x52.a55);
    }

    public static void multAddTransB(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52, DMatrix5x5 dMatrix5x53) {
        dMatrix5x53.a11 += (dMatrix5x5.a11 * dMatrix5x52.a11) + (dMatrix5x5.a12 * dMatrix5x52.a12) + (dMatrix5x5.a13 * dMatrix5x52.a13) + (dMatrix5x5.a14 * dMatrix5x52.a14) + (dMatrix5x5.a15 * dMatrix5x52.a15);
        dMatrix5x53.a12 += (dMatrix5x5.a11 * dMatrix5x52.a21) + (dMatrix5x5.a12 * dMatrix5x52.a22) + (dMatrix5x5.a13 * dMatrix5x52.a23) + (dMatrix5x5.a14 * dMatrix5x52.a24) + (dMatrix5x5.a15 * dMatrix5x52.a25);
        dMatrix5x53.a13 += (dMatrix5x5.a11 * dMatrix5x52.a31) + (dMatrix5x5.a12 * dMatrix5x52.a32) + (dMatrix5x5.a13 * dMatrix5x52.a33) + (dMatrix5x5.a14 * dMatrix5x52.a34) + (dMatrix5x5.a15 * dMatrix5x52.a35);
        dMatrix5x53.a14 += (dMatrix5x5.a11 * dMatrix5x52.a41) + (dMatrix5x5.a12 * dMatrix5x52.a42) + (dMatrix5x5.a13 * dMatrix5x52.a43) + (dMatrix5x5.a14 * dMatrix5x52.a44) + (dMatrix5x5.a15 * dMatrix5x52.a45);
        dMatrix5x53.a15 += (dMatrix5x5.a11 * dMatrix5x52.a51) + (dMatrix5x5.a12 * dMatrix5x52.a52) + (dMatrix5x5.a13 * dMatrix5x52.a53) + (dMatrix5x5.a14 * dMatrix5x52.a54) + (dMatrix5x5.a15 * dMatrix5x52.a55);
        dMatrix5x53.a21 += (dMatrix5x5.a21 * dMatrix5x52.a11) + (dMatrix5x5.a22 * dMatrix5x52.a12) + (dMatrix5x5.a23 * dMatrix5x52.a13) + (dMatrix5x5.a24 * dMatrix5x52.a14) + (dMatrix5x5.a25 * dMatrix5x52.a15);
        dMatrix5x53.a22 += (dMatrix5x5.a21 * dMatrix5x52.a21) + (dMatrix5x5.a22 * dMatrix5x52.a22) + (dMatrix5x5.a23 * dMatrix5x52.a23) + (dMatrix5x5.a24 * dMatrix5x52.a24) + (dMatrix5x5.a25 * dMatrix5x52.a25);
        dMatrix5x53.a23 += (dMatrix5x5.a21 * dMatrix5x52.a31) + (dMatrix5x5.a22 * dMatrix5x52.a32) + (dMatrix5x5.a23 * dMatrix5x52.a33) + (dMatrix5x5.a24 * dMatrix5x52.a34) + (dMatrix5x5.a25 * dMatrix5x52.a35);
        dMatrix5x53.a24 += (dMatrix5x5.a21 * dMatrix5x52.a41) + (dMatrix5x5.a22 * dMatrix5x52.a42) + (dMatrix5x5.a23 * dMatrix5x52.a43) + (dMatrix5x5.a24 * dMatrix5x52.a44) + (dMatrix5x5.a25 * dMatrix5x52.a45);
        dMatrix5x53.a25 += (dMatrix5x5.a21 * dMatrix5x52.a51) + (dMatrix5x5.a22 * dMatrix5x52.a52) + (dMatrix5x5.a23 * dMatrix5x52.a53) + (dMatrix5x5.a24 * dMatrix5x52.a54) + (dMatrix5x5.a25 * dMatrix5x52.a55);
        dMatrix5x53.a31 += (dMatrix5x5.a31 * dMatrix5x52.a11) + (dMatrix5x5.a32 * dMatrix5x52.a12) + (dMatrix5x5.a33 * dMatrix5x52.a13) + (dMatrix5x5.a34 * dMatrix5x52.a14) + (dMatrix5x5.a35 * dMatrix5x52.a15);
        dMatrix5x53.a32 += (dMatrix5x5.a31 * dMatrix5x52.a21) + (dMatrix5x5.a32 * dMatrix5x52.a22) + (dMatrix5x5.a33 * dMatrix5x52.a23) + (dMatrix5x5.a34 * dMatrix5x52.a24) + (dMatrix5x5.a35 * dMatrix5x52.a25);
        dMatrix5x53.a33 += (dMatrix5x5.a31 * dMatrix5x52.a31) + (dMatrix5x5.a32 * dMatrix5x52.a32) + (dMatrix5x5.a33 * dMatrix5x52.a33) + (dMatrix5x5.a34 * dMatrix5x52.a34) + (dMatrix5x5.a35 * dMatrix5x52.a35);
        dMatrix5x53.a34 += (dMatrix5x5.a31 * dMatrix5x52.a41) + (dMatrix5x5.a32 * dMatrix5x52.a42) + (dMatrix5x5.a33 * dMatrix5x52.a43) + (dMatrix5x5.a34 * dMatrix5x52.a44) + (dMatrix5x5.a35 * dMatrix5x52.a45);
        dMatrix5x53.a35 += (dMatrix5x5.a31 * dMatrix5x52.a51) + (dMatrix5x5.a32 * dMatrix5x52.a52) + (dMatrix5x5.a33 * dMatrix5x52.a53) + (dMatrix5x5.a34 * dMatrix5x52.a54) + (dMatrix5x5.a35 * dMatrix5x52.a55);
        dMatrix5x53.a41 += (dMatrix5x5.a41 * dMatrix5x52.a11) + (dMatrix5x5.a42 * dMatrix5x52.a12) + (dMatrix5x5.a43 * dMatrix5x52.a13) + (dMatrix5x5.a44 * dMatrix5x52.a14) + (dMatrix5x5.a45 * dMatrix5x52.a15);
        dMatrix5x53.a42 += (dMatrix5x5.a41 * dMatrix5x52.a21) + (dMatrix5x5.a42 * dMatrix5x52.a22) + (dMatrix5x5.a43 * dMatrix5x52.a23) + (dMatrix5x5.a44 * dMatrix5x52.a24) + (dMatrix5x5.a45 * dMatrix5x52.a25);
        dMatrix5x53.a43 += (dMatrix5x5.a41 * dMatrix5x52.a31) + (dMatrix5x5.a42 * dMatrix5x52.a32) + (dMatrix5x5.a43 * dMatrix5x52.a33) + (dMatrix5x5.a44 * dMatrix5x52.a34) + (dMatrix5x5.a45 * dMatrix5x52.a35);
        dMatrix5x53.a44 += (dMatrix5x5.a41 * dMatrix5x52.a41) + (dMatrix5x5.a42 * dMatrix5x52.a42) + (dMatrix5x5.a43 * dMatrix5x52.a43) + (dMatrix5x5.a44 * dMatrix5x52.a44) + (dMatrix5x5.a45 * dMatrix5x52.a45);
        dMatrix5x53.a45 += (dMatrix5x5.a41 * dMatrix5x52.a51) + (dMatrix5x5.a42 * dMatrix5x52.a52) + (dMatrix5x5.a43 * dMatrix5x52.a53) + (dMatrix5x5.a44 * dMatrix5x52.a54) + (dMatrix5x5.a45 * dMatrix5x52.a55);
        dMatrix5x53.a51 += (dMatrix5x5.a51 * dMatrix5x52.a11) + (dMatrix5x5.a52 * dMatrix5x52.a12) + (dMatrix5x5.a53 * dMatrix5x52.a13) + (dMatrix5x5.a54 * dMatrix5x52.a14) + (dMatrix5x5.a55 * dMatrix5x52.a15);
        dMatrix5x53.a52 += (dMatrix5x5.a51 * dMatrix5x52.a21) + (dMatrix5x5.a52 * dMatrix5x52.a22) + (dMatrix5x5.a53 * dMatrix5x52.a23) + (dMatrix5x5.a54 * dMatrix5x52.a24) + (dMatrix5x5.a55 * dMatrix5x52.a25);
        dMatrix5x53.a53 += (dMatrix5x5.a51 * dMatrix5x52.a31) + (dMatrix5x5.a52 * dMatrix5x52.a32) + (dMatrix5x5.a53 * dMatrix5x52.a33) + (dMatrix5x5.a54 * dMatrix5x52.a34) + (dMatrix5x5.a55 * dMatrix5x52.a35);
        dMatrix5x53.a54 += (dMatrix5x5.a51 * dMatrix5x52.a41) + (dMatrix5x5.a52 * dMatrix5x52.a42) + (dMatrix5x5.a53 * dMatrix5x52.a43) + (dMatrix5x5.a54 * dMatrix5x52.a44) + (dMatrix5x5.a55 * dMatrix5x52.a45);
        dMatrix5x53.a55 += (dMatrix5x5.a51 * dMatrix5x52.a51) + (dMatrix5x5.a52 * dMatrix5x52.a52) + (dMatrix5x5.a53 * dMatrix5x52.a53) + (dMatrix5x5.a54 * dMatrix5x52.a54) + (dMatrix5x5.a55 * dMatrix5x52.a55);
    }

    public static void mult(DMatrix5x5 dMatrix5x5, DMatrix5 dMatrix5, DMatrix5 dMatrix52) {
        dMatrix52.f2406a1 = (dMatrix5x5.a11 * dMatrix5.f2406a1) + (dMatrix5x5.a12 * dMatrix5.f2407a2) + (dMatrix5x5.a13 * dMatrix5.f2408a3) + (dMatrix5x5.a14 * dMatrix5.f2409a4) + (dMatrix5x5.a15 * dMatrix5.f2410a5);
        dMatrix52.f2407a2 = (dMatrix5x5.a21 * dMatrix5.f2406a1) + (dMatrix5x5.a22 * dMatrix5.f2407a2) + (dMatrix5x5.a23 * dMatrix5.f2408a3) + (dMatrix5x5.a24 * dMatrix5.f2409a4) + (dMatrix5x5.a25 * dMatrix5.f2410a5);
        dMatrix52.f2408a3 = (dMatrix5x5.a31 * dMatrix5.f2406a1) + (dMatrix5x5.a32 * dMatrix5.f2407a2) + (dMatrix5x5.a33 * dMatrix5.f2408a3) + (dMatrix5x5.a34 * dMatrix5.f2409a4) + (dMatrix5x5.a35 * dMatrix5.f2410a5);
        dMatrix52.f2409a4 = (dMatrix5x5.a41 * dMatrix5.f2406a1) + (dMatrix5x5.a42 * dMatrix5.f2407a2) + (dMatrix5x5.a43 * dMatrix5.f2408a3) + (dMatrix5x5.a44 * dMatrix5.f2409a4) + (dMatrix5x5.a45 * dMatrix5.f2410a5);
        dMatrix52.f2410a5 = (dMatrix5x5.a51 * dMatrix5.f2406a1) + (dMatrix5x5.a52 * dMatrix5.f2407a2) + (dMatrix5x5.a53 * dMatrix5.f2408a3) + (dMatrix5x5.a54 * dMatrix5.f2409a4) + (dMatrix5x5.a55 * dMatrix5.f2410a5);
    }

    public static void mult(DMatrix5 dMatrix5, DMatrix5x5 dMatrix5x5, DMatrix5 dMatrix52) {
        dMatrix52.f2406a1 = (dMatrix5.f2406a1 * dMatrix5x5.a11) + (dMatrix5.f2407a2 * dMatrix5x5.a21) + (dMatrix5.f2408a3 * dMatrix5x5.a31) + (dMatrix5.f2409a4 * dMatrix5x5.a41) + (dMatrix5.f2410a5 * dMatrix5x5.a51);
        dMatrix52.f2407a2 = (dMatrix5.f2406a1 * dMatrix5x5.a12) + (dMatrix5.f2407a2 * dMatrix5x5.a22) + (dMatrix5.f2408a3 * dMatrix5x5.a32) + (dMatrix5.f2409a4 * dMatrix5x5.a42) + (dMatrix5.f2410a5 * dMatrix5x5.a52);
        dMatrix52.f2408a3 = (dMatrix5.f2406a1 * dMatrix5x5.a13) + (dMatrix5.f2407a2 * dMatrix5x5.a23) + (dMatrix5.f2408a3 * dMatrix5x5.a33) + (dMatrix5.f2409a4 * dMatrix5x5.a43) + (dMatrix5.f2410a5 * dMatrix5x5.a53);
        dMatrix52.f2409a4 = (dMatrix5.f2406a1 * dMatrix5x5.a14) + (dMatrix5.f2407a2 * dMatrix5x5.a24) + (dMatrix5.f2408a3 * dMatrix5x5.a34) + (dMatrix5.f2409a4 * dMatrix5x5.a44) + (dMatrix5.f2410a5 * dMatrix5x5.a54);
        dMatrix52.f2410a5 = (dMatrix5.f2406a1 * dMatrix5x5.a15) + (dMatrix5.f2407a2 * dMatrix5x5.a25) + (dMatrix5.f2408a3 * dMatrix5x5.a35) + (dMatrix5.f2409a4 * dMatrix5x5.a45) + (dMatrix5.f2410a5 * dMatrix5x5.a55);
    }

    public static double dot(DMatrix5 dMatrix5, DMatrix5 dMatrix52) {
        return (dMatrix5.f2406a1 * dMatrix52.f2406a1) + (dMatrix5.f2407a2 * dMatrix52.f2407a2) + (dMatrix5.f2408a3 * dMatrix52.f2408a3) + (dMatrix5.f2409a4 * dMatrix52.f2409a4) + (dMatrix5.f2410a5 * dMatrix52.f2410a5);
    }

    public static void setIdentity(DMatrix5x5 dMatrix5x5) {
        dMatrix5x5.a11 = 1.0d;
        dMatrix5x5.a21 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a31 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a41 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a51 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a12 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a22 = 1.0d;
        dMatrix5x5.a32 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a42 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a52 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a13 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a23 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a33 = 1.0d;
        dMatrix5x5.a43 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a53 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a14 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a24 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a34 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a44 = 1.0d;
        dMatrix5x5.a54 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a15 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a25 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a35 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a45 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix5x5.a55 = 1.0d;
    }

    public static boolean invert(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52) {
        double dElementMaxAbs = 1.0d / elementMaxAbs(dMatrix5x5);
        double d = dMatrix5x5.a11 * dElementMaxAbs;
        double d2 = dMatrix5x5.a12 * dElementMaxAbs;
        double d3 = dMatrix5x5.a13 * dElementMaxAbs;
        double d4 = dMatrix5x5.a14 * dElementMaxAbs;
        double d5 = dMatrix5x5.a15 * dElementMaxAbs;
        double d6 = dMatrix5x5.a21 * dElementMaxAbs;
        double d7 = dMatrix5x5.a22 * dElementMaxAbs;
        double d8 = dMatrix5x5.a23 * dElementMaxAbs;
        double d9 = dMatrix5x5.a24 * dElementMaxAbs;
        double d10 = dMatrix5x5.a25 * dElementMaxAbs;
        double d11 = dMatrix5x5.a31 * dElementMaxAbs;
        double d12 = dMatrix5x5.a32 * dElementMaxAbs;
        double d13 = dMatrix5x5.a33 * dElementMaxAbs;
        double d14 = dMatrix5x5.a34 * dElementMaxAbs;
        double d15 = dMatrix5x5.a35 * dElementMaxAbs;
        double d16 = dMatrix5x5.a41 * dElementMaxAbs;
        double d17 = dMatrix5x5.a42 * dElementMaxAbs;
        double d18 = dMatrix5x5.a43 * dElementMaxAbs;
        double d19 = dMatrix5x5.a44 * dElementMaxAbs;
        double d20 = dMatrix5x5.a45 * dElementMaxAbs;
        double d21 = dMatrix5x5.a51 * dElementMaxAbs;
        double d22 = dMatrix5x5.a52 * dElementMaxAbs;
        double d23 = dMatrix5x5.a53 * dElementMaxAbs;
        double d24 = dMatrix5x5.a54 * dElementMaxAbs;
        double d25 = dMatrix5x5.a55 * dElementMaxAbs;
        double d26 = (d19 * d25) - (d20 * d24);
        double d27 = (d18 * d25) - (d20 * d23);
        double d28 = (d18 * d24) - (d19 * d23);
        double d29 = ((d13 * d26) - (d14 * d27)) + (d15 * d28);
        double d30 = (d17 * d25) - (d20 * d22);
        double d31 = (d17 * d24) - (d19 * d22);
        double d32 = ((d12 * d26) - (d14 * d30)) + (d15 * d31);
        double d33 = (d17 * d23) - (d18 * d22);
        double d34 = ((d12 * d27) - (d13 * d30)) + (d15 * d33);
        double d35 = ((d12 * d28) - (d13 * d31)) + (d14 * d33);
        double d36 = (((d7 * d29) - (d8 * d32)) + (d9 * d34)) - (d10 * d35);
        double d37 = (d16 * d25) - (d20 * d21);
        double d38 = (d16 * d24) - (d19 * d21);
        double d39 = ((d11 * d26) - (d14 * d37)) + (d15 * d38);
        double d40 = (d16 * d23) - (d18 * d21);
        double d41 = ((d11 * d27) - (d13 * d37)) + (d15 * d40);
        double d42 = ((d11 * d28) - (d13 * d38)) + (d14 * d40);
        double d43 = -((((d6 * d29) - (d8 * d39)) + (d9 * d41)) - (d10 * d42));
        double d44 = (d16 * d22) - (d17 * d21);
        double d45 = ((d11 * d30) - (d12 * d37)) + (d15 * d44);
        double d46 = ((d11 * d31) - (d12 * d38)) + (d14 * d44);
        double d47 = (((d6 * d32) - (d7 * d39)) + (d9 * d45)) - (d10 * d46);
        double d48 = ((d11 * d33) - (d12 * d40)) + (d13 * d44);
        double d49 = -((((d6 * d34) - (d7 * d41)) + (d8 * d45)) - (d10 * d48));
        double d50 = (((d6 * d35) - (d7 * d42)) + (d8 * d46)) - (d9 * d48);
        double d51 = -((((d2 * d29) - (d3 * d32)) + (d4 * d34)) - (d5 * d35));
        double d52 = (((d29 * d) - (d3 * d39)) + (d4 * d41)) - (d5 * d42);
        double d53 = -((((d32 * d) - (d39 * d2)) + (d4 * d45)) - (d5 * d46));
        double d54 = (((d34 * d) - (d41 * d2)) + (d45 * d3)) - (d5 * d48);
        double d55 = -((((d35 * d) - (d42 * d2)) + (d46 * d3)) - (d48 * d4));
        double d56 = ((d8 * d26) - (d9 * d27)) + (d10 * d28);
        double d57 = ((d7 * d26) - (d9 * d30)) + (d10 * d31);
        double d58 = ((d7 * d27) - (d8 * d30)) + (d10 * d33);
        double d59 = ((d7 * d28) - (d8 * d31)) + (d9 * d33);
        double d60 = (((d2 * d56) - (d3 * d57)) + (d4 * d58)) - (d5 * d59);
        double d61 = ((d26 * d6) - (d9 * d37)) + (d10 * d38);
        double d62 = ((d27 * d6) - (d8 * d37)) + (d10 * d40);
        double d63 = ((d28 * d6) - (d8 * d38)) + (d9 * d40);
        double d64 = -((((d56 * d) - (d3 * d61)) + (d4 * d62)) - (d5 * d63));
        double d65 = ((d30 * d6) - (d7 * d37)) + (d10 * d44);
        double d66 = ((d31 * d6) - (d7 * d38)) + (d9 * d44);
        double d67 = (((d57 * d) - (d61 * d2)) + (d4 * d65)) - (d5 * d66);
        double d68 = ((d33 * d6) - (d7 * d40)) + (d8 * d44);
        double d69 = -((((d58 * d) - (d62 * d2)) + (d65 * d3)) - (d5 * d68));
        double d70 = (((d59 * d) - (d63 * d2)) + (d66 * d3)) - (d68 * d4);
        double d71 = (d14 * d25) - (d15 * d24);
        double d72 = (d13 * d25) - (d15 * d23);
        double d73 = (d13 * d24) - (d14 * d23);
        double d74 = ((d8 * d71) - (d9 * d72)) + (d10 * d73);
        double d75 = (d12 * d25) - (d15 * d22);
        double d76 = (d12 * d24) - (d14 * d22);
        double d77 = ((d7 * d71) - (d9 * d75)) + (d10 * d76);
        double d78 = (d12 * d23) - (d13 * d22);
        double d79 = ((d7 * d72) - (d8 * d75)) + (d10 * d78);
        double d80 = ((d7 * d73) - (d8 * d76)) + (d9 * d78);
        double d81 = -((((d2 * d74) - (d3 * d77)) + (d4 * d79)) - (d5 * d80));
        double d82 = (d11 * d25) - (d15 * d21);
        double d83 = (d24 * d11) - (d14 * d21);
        double d84 = ((d71 * d6) - (d9 * d82)) + (d10 * d83);
        double d85 = (d23 * d11) - (d13 * d21);
        double d86 = ((d72 * d6) - (d8 * d82)) + (d10 * d85);
        double d87 = ((d73 * d6) - (d8 * d83)) + (d9 * d85);
        double d88 = (((d74 * d) - (d3 * d84)) + (d4 * d86)) - (d5 * d87);
        double d89 = (d22 * d11) - (d21 * d12);
        double d90 = ((d75 * d6) - (d7 * d82)) + (d10 * d89);
        double d91 = ((d76 * d6) - (d7 * d83)) + (d9 * d89);
        double d92 = -((((d77 * d) - (d84 * d2)) + (d4 * d90)) - (d5 * d91));
        double d93 = ((d78 * d6) - (d7 * d85)) + (d8 * d89);
        double d94 = (((d79 * d) - (d86 * d2)) + (d90 * d3)) - (d5 * d93);
        double d95 = -((((d80 * d) - (d87 * d2)) + (d91 * d3)) - (d93 * d4));
        double d96 = (d14 * d20) - (d15 * d19);
        double d97 = (d13 * d20) - (d15 * d18);
        double d98 = (d13 * d19) - (d14 * d18);
        double d99 = ((d8 * d96) - (d9 * d97)) + (d10 * d98);
        double d100 = (d12 * d20) - (d15 * d17);
        double d101 = (d12 * d19) - (d14 * d17);
        double d102 = ((d7 * d96) - (d9 * d100)) + (d10 * d101);
        double d103 = (d12 * d18) - (d13 * d17);
        double d104 = ((d7 * d97) - (d8 * d100)) + (d10 * d103);
        double d105 = ((d7 * d98) - (d8 * d101)) + (d9 * d103);
        double d106 = (((d2 * d99) - (d3 * d102)) + (d4 * d104)) - (d5 * d105);
        double d107 = (d20 * d11) - (d15 * d16);
        double d108 = (d11 * d19) - (d14 * d16);
        double d109 = ((d96 * d6) - (d9 * d107)) + (d10 * d108);
        double d110 = (d11 * d18) - (d13 * d16);
        double d111 = ((d97 * d6) - (d8 * d107)) + (d10 * d110);
        double d112 = ((d98 * d6) - (d8 * d108)) + (d9 * d110);
        double d113 = -((((d99 * d) - (d3 * d109)) + (d4 * d111)) - (d5 * d112));
        double d114 = (d11 * d17) - (d12 * d16);
        double d115 = ((d100 * d6) - (d7 * d107)) + (d10 * d114);
        double d116 = ((d101 * d6) - (d7 * d108)) + (d9 * d114);
        double d117 = (((d102 * d) - (d109 * d2)) + (d4 * d115)) - (d5 * d116);
        double d118 = ((d6 * d103) - (d7 * d110)) + (d8 * d114);
        double d119 = -((((d104 * d) - (d111 * d2)) + (d115 * d3)) - (d5 * d118));
        double d120 = (((d105 * d) - (d112 * d2)) + (d116 * d3)) - (d118 * d4);
        double d121 = (((((d * d36) + (d2 * d43)) + (d3 * d47)) + (d4 * d49)) + (d5 * d50)) / dElementMaxAbs;
        dMatrix5x52.a11 = d36 / d121;
        dMatrix5x52.a12 = d51 / d121;
        dMatrix5x52.a13 = d60 / d121;
        dMatrix5x52.a14 = d81 / d121;
        dMatrix5x52.a15 = d106 / d121;
        dMatrix5x52.a21 = d43 / d121;
        dMatrix5x52.a22 = d52 / d121;
        dMatrix5x52.a23 = d64 / d121;
        dMatrix5x52.a24 = d88 / d121;
        dMatrix5x52.a25 = d113 / d121;
        dMatrix5x52.a31 = d47 / d121;
        dMatrix5x52.a32 = d53 / d121;
        dMatrix5x52.a33 = d67 / d121;
        dMatrix5x52.a34 = d92 / d121;
        dMatrix5x52.a35 = d117 / d121;
        dMatrix5x52.a41 = d49 / d121;
        dMatrix5x52.a42 = d54 / d121;
        dMatrix5x52.a43 = d69 / d121;
        dMatrix5x52.a44 = d94 / d121;
        dMatrix5x52.a45 = d119 / d121;
        dMatrix5x52.a51 = d50 / d121;
        dMatrix5x52.a52 = d55 / d121;
        dMatrix5x52.a53 = d70 / d121;
        dMatrix5x52.a54 = d95 / d121;
        dMatrix5x52.a55 = d120 / d121;
        return (Double.isNaN(d121) || Double.isInfinite(d121)) ? false : true;
    }

    public static double det(DMatrix5x5 dMatrix5x5) {
        double d = dMatrix5x5.a22;
        double d2 = dMatrix5x5.a23;
        double d3 = dMatrix5x5.a24;
        double d4 = dMatrix5x5.a25;
        double d5 = dMatrix5x5.a32;
        double d6 = dMatrix5x5.a33;
        double d7 = dMatrix5x5.a34;
        double d8 = dMatrix5x5.a35;
        double d9 = dMatrix5x5.a42;
        double d10 = dMatrix5x5.a43;
        double d11 = dMatrix5x5.a44;
        double d12 = dMatrix5x5.a45;
        double d13 = dMatrix5x5.a52;
        double d14 = dMatrix5x5.a53;
        double d15 = dMatrix5x5.a54;
        double d16 = dMatrix5x5.a55;
        double d17 = (d11 * d16) - (d12 * d15);
        double d18 = (d10 * d16) - (d12 * d14);
        double d19 = (d10 * d15) - (d11 * d14);
        double d20 = ((d6 * d17) - (d7 * d18)) + (d8 * d19);
        double d21 = (d9 * d16) - (d12 * d13);
        double d22 = (d9 * d15) - (d11 * d13);
        double d23 = (d9 * d14) - (d13 * d10);
        double d24 = (dMatrix5x5.a11 * ((((d * d20) - ((((d5 * d17) - (d7 * d21)) + (d8 * d22)) * d2)) + ((((d5 * d18) - (d21 * d6)) + (d8 * d23)) * d3)) - ((((d5 * d19) - (d22 * d6)) + (d23 * d7)) * d4))) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d25 = dMatrix5x5.a21;
        double d26 = dMatrix5x5.a31;
        double d27 = dMatrix5x5.a41;
        double d28 = dMatrix5x5.a51;
        double d29 = (d27 * d16) - (d12 * d28);
        double d30 = (d27 * d15) - (d11 * d28);
        double d31 = ((d26 * d17) - (d7 * d29)) + (d8 * d30);
        double d32 = (d14 * d27) - (d10 * d28);
        double d33 = d24 - (dMatrix5x5.a12 * ((((d20 * d25) - (d2 * d31)) + ((((d26 * d18) - (d6 * d29)) + (d8 * d32)) * d3)) - ((((d26 * d19) - (d6 * d30)) + (d32 * d7)) * d4)));
        double d34 = dMatrix5x5.a22;
        double d35 = dMatrix5x5.a32;
        double d36 = dMatrix5x5.a42;
        double d37 = dMatrix5x5.a52;
        double d38 = (d36 * d16) - (d12 * d37);
        double d39 = (d15 * d36) - (d11 * d37);
        double d40 = (d27 * d37) - (d36 * d28);
        double d41 = ((d26 * d38) - (d35 * d29)) + (d8 * d40);
        double d42 = (dMatrix5x5.a13 * (((((((d17 * d35) - (d7 * d38)) + (d8 * d39)) * d25) - (d31 * d34)) + (d3 * d41)) - ((((d26 * d39) - (d30 * d35)) + (d7 * d40)) * d4))) + d33;
        double d43 = dMatrix5x5.a23;
        double d44 = dMatrix5x5.a33;
        double d45 = dMatrix5x5.a43;
        double d46 = dMatrix5x5.a53;
        double d47 = (d16 * d45) - (d12 * d46);
        double d48 = (d35 * d47) - (d38 * d44);
        double d49 = (d36 * d46) - (d45 * d37);
        double d50 = (d27 * d46) - (d45 * d28);
        double d51 = ((d26 * d49) - (d35 * d50)) + (d44 * d40);
        double d52 = d42 - (dMatrix5x5.a14 * (((((d48 + (d8 * d49)) * d25) - ((((d47 * d26) - (d29 * d44)) + (d8 * d50)) * d34)) + (d41 * d43)) - (d4 * d51)));
        double d53 = dMatrix5x5.a24;
        double d54 = dMatrix5x5.a34;
        double d55 = dMatrix5x5.a44;
        double d56 = dMatrix5x5.a54;
        double d57 = (d45 * d56) - (d46 * d55);
        double d58 = (d36 * d56) - (d37 * d55);
        double d59 = (d27 * d56) - (d55 * d28);
        return d52 + (dMatrix5x5.a15 * ((((d25 * (((d35 * d57) - (d44 * d58)) + (d54 * d49))) - (d34 * (((d26 * d57) - (d44 * d59)) + (d54 * d50)))) + (d43 * (((d26 * d58) - (d35 * d59)) + (d54 * d40)))) - (d53 * d51)));
    }

    public static double trace(DMatrix5x5 dMatrix5x5) {
        return dMatrix5x5.a11 + dMatrix5x5.a22 + dMatrix5x5.a33 + dMatrix5x5.a44 + dMatrix5x5.a55;
    }

    public static void diag(DMatrix5x5 dMatrix5x5, DMatrix5 dMatrix5) {
        dMatrix5.f2406a1 = dMatrix5x5.a11;
        dMatrix5.f2407a2 = dMatrix5x5.a22;
        dMatrix5.f2408a3 = dMatrix5x5.a33;
        dMatrix5.f2409a4 = dMatrix5x5.a44;
        dMatrix5.f2410a5 = dMatrix5x5.a55;
    }

    public static double elementMax(DMatrix5x5 dMatrix5x5) {
        double d = dMatrix5x5.a11;
        if (dMatrix5x5.a12 > d) {
            d = dMatrix5x5.a12;
        }
        if (dMatrix5x5.a13 > d) {
            d = dMatrix5x5.a13;
        }
        if (dMatrix5x5.a14 > d) {
            d = dMatrix5x5.a14;
        }
        if (dMatrix5x5.a15 > d) {
            d = dMatrix5x5.a15;
        }
        if (dMatrix5x5.a21 > d) {
            d = dMatrix5x5.a21;
        }
        if (dMatrix5x5.a22 > d) {
            d = dMatrix5x5.a22;
        }
        if (dMatrix5x5.a23 > d) {
            d = dMatrix5x5.a23;
        }
        if (dMatrix5x5.a24 > d) {
            d = dMatrix5x5.a24;
        }
        if (dMatrix5x5.a25 > d) {
            d = dMatrix5x5.a25;
        }
        if (dMatrix5x5.a31 > d) {
            d = dMatrix5x5.a31;
        }
        if (dMatrix5x5.a32 > d) {
            d = dMatrix5x5.a32;
        }
        if (dMatrix5x5.a33 > d) {
            d = dMatrix5x5.a33;
        }
        if (dMatrix5x5.a34 > d) {
            d = dMatrix5x5.a34;
        }
        if (dMatrix5x5.a35 > d) {
            d = dMatrix5x5.a35;
        }
        if (dMatrix5x5.a41 > d) {
            d = dMatrix5x5.a41;
        }
        if (dMatrix5x5.a42 > d) {
            d = dMatrix5x5.a42;
        }
        if (dMatrix5x5.a43 > d) {
            d = dMatrix5x5.a43;
        }
        if (dMatrix5x5.a44 > d) {
            d = dMatrix5x5.a44;
        }
        if (dMatrix5x5.a45 > d) {
            d = dMatrix5x5.a45;
        }
        if (dMatrix5x5.a51 > d) {
            d = dMatrix5x5.a51;
        }
        if (dMatrix5x5.a52 > d) {
            d = dMatrix5x5.a52;
        }
        if (dMatrix5x5.a53 > d) {
            d = dMatrix5x5.a53;
        }
        if (dMatrix5x5.a54 > d) {
            d = dMatrix5x5.a54;
        }
        return dMatrix5x5.a55 > d ? dMatrix5x5.a55 : d;
    }

    public static double elementMax(DMatrix5 dMatrix5) {
        double d = dMatrix5.f2406a1;
        if (dMatrix5.f2407a2 > d) {
            d = dMatrix5.f2407a2;
        }
        if (dMatrix5.f2408a3 > d) {
            d = dMatrix5.f2408a3;
        }
        if (dMatrix5.f2409a4 > d) {
            d = dMatrix5.f2409a4;
        }
        return dMatrix5.f2410a5 > d ? dMatrix5.f2410a5 : d;
    }

    public static double elementMaxAbs(DMatrix5x5 dMatrix5x5) {
        double dAbs = Math.abs(dMatrix5x5.a11);
        double dAbs2 = Math.abs(dMatrix5x5.a12);
        if (dAbs2 > dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix5x5.a13);
        if (dAbs3 > dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix5x5.a14);
        if (dAbs4 > dAbs) {
            dAbs = dAbs4;
        }
        double dAbs5 = Math.abs(dMatrix5x5.a15);
        if (dAbs5 > dAbs) {
            dAbs = dAbs5;
        }
        double dAbs6 = Math.abs(dMatrix5x5.a21);
        if (dAbs6 > dAbs) {
            dAbs = dAbs6;
        }
        double dAbs7 = Math.abs(dMatrix5x5.a22);
        if (dAbs7 > dAbs) {
            dAbs = dAbs7;
        }
        double dAbs8 = Math.abs(dMatrix5x5.a23);
        if (dAbs8 > dAbs) {
            dAbs = dAbs8;
        }
        double dAbs9 = Math.abs(dMatrix5x5.a24);
        if (dAbs9 > dAbs) {
            dAbs = dAbs9;
        }
        double dAbs10 = Math.abs(dMatrix5x5.a25);
        if (dAbs10 > dAbs) {
            dAbs = dAbs10;
        }
        double dAbs11 = Math.abs(dMatrix5x5.a31);
        if (dAbs11 > dAbs) {
            dAbs = dAbs11;
        }
        double dAbs12 = Math.abs(dMatrix5x5.a32);
        if (dAbs12 > dAbs) {
            dAbs = dAbs12;
        }
        double dAbs13 = Math.abs(dMatrix5x5.a33);
        if (dAbs13 > dAbs) {
            dAbs = dAbs13;
        }
        double dAbs14 = Math.abs(dMatrix5x5.a34);
        if (dAbs14 > dAbs) {
            dAbs = dAbs14;
        }
        double dAbs15 = Math.abs(dMatrix5x5.a35);
        if (dAbs15 > dAbs) {
            dAbs = dAbs15;
        }
        double dAbs16 = Math.abs(dMatrix5x5.a41);
        if (dAbs16 > dAbs) {
            dAbs = dAbs16;
        }
        double dAbs17 = Math.abs(dMatrix5x5.a42);
        if (dAbs17 > dAbs) {
            dAbs = dAbs17;
        }
        double dAbs18 = Math.abs(dMatrix5x5.a43);
        if (dAbs18 > dAbs) {
            dAbs = dAbs18;
        }
        double dAbs19 = Math.abs(dMatrix5x5.a44);
        if (dAbs19 > dAbs) {
            dAbs = dAbs19;
        }
        double dAbs20 = Math.abs(dMatrix5x5.a45);
        if (dAbs20 > dAbs) {
            dAbs = dAbs20;
        }
        double dAbs21 = Math.abs(dMatrix5x5.a51);
        if (dAbs21 > dAbs) {
            dAbs = dAbs21;
        }
        double dAbs22 = Math.abs(dMatrix5x5.a52);
        if (dAbs22 > dAbs) {
            dAbs = dAbs22;
        }
        double dAbs23 = Math.abs(dMatrix5x5.a53);
        if (dAbs23 > dAbs) {
            dAbs = dAbs23;
        }
        double dAbs24 = Math.abs(dMatrix5x5.a54);
        if (dAbs24 > dAbs) {
            dAbs = dAbs24;
        }
        double dAbs25 = Math.abs(dMatrix5x5.a55);
        return dAbs25 > dAbs ? dAbs25 : dAbs;
    }

    public static double elementMaxAbs(DMatrix5 dMatrix5) {
        double dAbs = Math.abs(dMatrix5.f2406a1);
        double dAbs2 = Math.abs(dMatrix5.f2407a2);
        if (dAbs2 > dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix5.f2407a2);
        if (dAbs3 > dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix5.f2408a3);
        if (dAbs4 > dAbs) {
            dAbs = dAbs4;
        }
        double dAbs5 = Math.abs(dMatrix5.f2409a4);
        if (dAbs5 > dAbs) {
            dAbs = dAbs5;
        }
        double dAbs6 = Math.abs(dMatrix5.f2410a5);
        return dAbs6 > dAbs ? dAbs6 : dAbs;
    }

    public static double elementMin(DMatrix5x5 dMatrix5x5) {
        double d = dMatrix5x5.a11;
        if (dMatrix5x5.a12 < d) {
            d = dMatrix5x5.a12;
        }
        if (dMatrix5x5.a13 < d) {
            d = dMatrix5x5.a13;
        }
        if (dMatrix5x5.a14 < d) {
            d = dMatrix5x5.a14;
        }
        if (dMatrix5x5.a15 < d) {
            d = dMatrix5x5.a15;
        }
        if (dMatrix5x5.a21 < d) {
            d = dMatrix5x5.a21;
        }
        if (dMatrix5x5.a22 < d) {
            d = dMatrix5x5.a22;
        }
        if (dMatrix5x5.a23 < d) {
            d = dMatrix5x5.a23;
        }
        if (dMatrix5x5.a24 < d) {
            d = dMatrix5x5.a24;
        }
        if (dMatrix5x5.a25 < d) {
            d = dMatrix5x5.a25;
        }
        if (dMatrix5x5.a31 < d) {
            d = dMatrix5x5.a31;
        }
        if (dMatrix5x5.a32 < d) {
            d = dMatrix5x5.a32;
        }
        if (dMatrix5x5.a33 < d) {
            d = dMatrix5x5.a33;
        }
        if (dMatrix5x5.a34 < d) {
            d = dMatrix5x5.a34;
        }
        if (dMatrix5x5.a35 < d) {
            d = dMatrix5x5.a35;
        }
        if (dMatrix5x5.a41 < d) {
            d = dMatrix5x5.a41;
        }
        if (dMatrix5x5.a42 < d) {
            d = dMatrix5x5.a42;
        }
        if (dMatrix5x5.a43 < d) {
            d = dMatrix5x5.a43;
        }
        if (dMatrix5x5.a44 < d) {
            d = dMatrix5x5.a44;
        }
        if (dMatrix5x5.a45 < d) {
            d = dMatrix5x5.a45;
        }
        if (dMatrix5x5.a51 < d) {
            d = dMatrix5x5.a51;
        }
        if (dMatrix5x5.a52 < d) {
            d = dMatrix5x5.a52;
        }
        if (dMatrix5x5.a53 < d) {
            d = dMatrix5x5.a53;
        }
        if (dMatrix5x5.a54 < d) {
            d = dMatrix5x5.a54;
        }
        return dMatrix5x5.a55 < d ? dMatrix5x5.a55 : d;
    }

    public static double elementMin(DMatrix5 dMatrix5) {
        double d = dMatrix5.f2406a1;
        if (dMatrix5.f2407a2 < d) {
            d = dMatrix5.f2407a2;
        }
        if (dMatrix5.f2408a3 < d) {
            d = dMatrix5.f2408a3;
        }
        if (dMatrix5.f2409a4 < d) {
            d = dMatrix5.f2409a4;
        }
        return dMatrix5.f2410a5 < d ? dMatrix5.f2410a5 : d;
    }

    public static double elementMinAbs(DMatrix5x5 dMatrix5x5) {
        double dAbs = Math.abs(dMatrix5x5.a11);
        double dAbs2 = Math.abs(dMatrix5x5.a12);
        if (dAbs2 < dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix5x5.a13);
        if (dAbs3 < dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix5x5.a14);
        if (dAbs4 < dAbs) {
            dAbs = dAbs4;
        }
        double dAbs5 = Math.abs(dMatrix5x5.a15);
        if (dAbs5 < dAbs) {
            dAbs = dAbs5;
        }
        double dAbs6 = Math.abs(dMatrix5x5.a21);
        if (dAbs6 < dAbs) {
            dAbs = dAbs6;
        }
        double dAbs7 = Math.abs(dMatrix5x5.a22);
        if (dAbs7 < dAbs) {
            dAbs = dAbs7;
        }
        double dAbs8 = Math.abs(dMatrix5x5.a23);
        if (dAbs8 < dAbs) {
            dAbs = dAbs8;
        }
        double dAbs9 = Math.abs(dMatrix5x5.a24);
        if (dAbs9 < dAbs) {
            dAbs = dAbs9;
        }
        double dAbs10 = Math.abs(dMatrix5x5.a25);
        if (dAbs10 < dAbs) {
            dAbs = dAbs10;
        }
        double dAbs11 = Math.abs(dMatrix5x5.a31);
        if (dAbs11 < dAbs) {
            dAbs = dAbs11;
        }
        double dAbs12 = Math.abs(dMatrix5x5.a32);
        if (dAbs12 < dAbs) {
            dAbs = dAbs12;
        }
        double dAbs13 = Math.abs(dMatrix5x5.a33);
        if (dAbs13 < dAbs) {
            dAbs = dAbs13;
        }
        double dAbs14 = Math.abs(dMatrix5x5.a34);
        if (dAbs14 < dAbs) {
            dAbs = dAbs14;
        }
        double dAbs15 = Math.abs(dMatrix5x5.a35);
        if (dAbs15 < dAbs) {
            dAbs = dAbs15;
        }
        double dAbs16 = Math.abs(dMatrix5x5.a41);
        if (dAbs16 < dAbs) {
            dAbs = dAbs16;
        }
        double dAbs17 = Math.abs(dMatrix5x5.a42);
        if (dAbs17 < dAbs) {
            dAbs = dAbs17;
        }
        double dAbs18 = Math.abs(dMatrix5x5.a43);
        if (dAbs18 < dAbs) {
            dAbs = dAbs18;
        }
        double dAbs19 = Math.abs(dMatrix5x5.a44);
        if (dAbs19 < dAbs) {
            dAbs = dAbs19;
        }
        double dAbs20 = Math.abs(dMatrix5x5.a45);
        if (dAbs20 < dAbs) {
            dAbs = dAbs20;
        }
        double dAbs21 = Math.abs(dMatrix5x5.a51);
        if (dAbs21 < dAbs) {
            dAbs = dAbs21;
        }
        double dAbs22 = Math.abs(dMatrix5x5.a52);
        if (dAbs22 < dAbs) {
            dAbs = dAbs22;
        }
        double dAbs23 = Math.abs(dMatrix5x5.a53);
        if (dAbs23 < dAbs) {
            dAbs = dAbs23;
        }
        double dAbs24 = Math.abs(dMatrix5x5.a54);
        if (dAbs24 < dAbs) {
            dAbs = dAbs24;
        }
        double dAbs25 = Math.abs(dMatrix5x5.a55);
        return dAbs25 < dAbs ? dAbs25 : dAbs;
    }

    public static double elementMinAbs(DMatrix5 dMatrix5) {
        double dAbs = Math.abs(dMatrix5.f2406a1);
        double dAbs2 = Math.abs(dMatrix5.f2406a1);
        if (dAbs2 < dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix5.f2407a2);
        if (dAbs3 < dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix5.f2408a3);
        if (dAbs4 < dAbs) {
            dAbs = dAbs4;
        }
        double dAbs5 = Math.abs(dMatrix5.f2409a4);
        if (dAbs5 < dAbs) {
            dAbs = dAbs5;
        }
        double dAbs6 = Math.abs(dMatrix5.f2410a5);
        return dAbs6 < dAbs ? dAbs6 : dAbs;
    }

    public static void elementMult(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52) {
        dMatrix5x5.a11 *= dMatrix5x52.a11;
        dMatrix5x5.a12 *= dMatrix5x52.a12;
        dMatrix5x5.a13 *= dMatrix5x52.a13;
        dMatrix5x5.a14 *= dMatrix5x52.a14;
        dMatrix5x5.a15 *= dMatrix5x52.a15;
        dMatrix5x5.a21 *= dMatrix5x52.a21;
        dMatrix5x5.a22 *= dMatrix5x52.a22;
        dMatrix5x5.a23 *= dMatrix5x52.a23;
        dMatrix5x5.a24 *= dMatrix5x52.a24;
        dMatrix5x5.a25 *= dMatrix5x52.a25;
        dMatrix5x5.a31 *= dMatrix5x52.a31;
        dMatrix5x5.a32 *= dMatrix5x52.a32;
        dMatrix5x5.a33 *= dMatrix5x52.a33;
        dMatrix5x5.a34 *= dMatrix5x52.a34;
        dMatrix5x5.a35 *= dMatrix5x52.a35;
        dMatrix5x5.a41 *= dMatrix5x52.a41;
        dMatrix5x5.a42 *= dMatrix5x52.a42;
        dMatrix5x5.a43 *= dMatrix5x52.a43;
        dMatrix5x5.a44 *= dMatrix5x52.a44;
        dMatrix5x5.a45 *= dMatrix5x52.a45;
        dMatrix5x5.a51 *= dMatrix5x52.a51;
        dMatrix5x5.a52 *= dMatrix5x52.a52;
        dMatrix5x5.a53 *= dMatrix5x52.a53;
        dMatrix5x5.a54 *= dMatrix5x52.a54;
        dMatrix5x5.a55 *= dMatrix5x52.a55;
    }

    public static void elementMult(DMatrix5 dMatrix5, DMatrix5 dMatrix52) {
        dMatrix5.f2406a1 *= dMatrix52.f2406a1;
        dMatrix5.f2407a2 *= dMatrix52.f2407a2;
        dMatrix5.f2408a3 *= dMatrix52.f2408a3;
        dMatrix5.f2409a4 *= dMatrix52.f2409a4;
        dMatrix5.f2410a5 *= dMatrix52.f2410a5;
    }

    public static void elementMult(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52, DMatrix5x5 dMatrix5x53) {
        dMatrix5x53.a11 = dMatrix5x5.a11 * dMatrix5x52.a11;
        dMatrix5x53.a12 = dMatrix5x5.a12 * dMatrix5x52.a12;
        dMatrix5x53.a13 = dMatrix5x5.a13 * dMatrix5x52.a13;
        dMatrix5x53.a14 = dMatrix5x5.a14 * dMatrix5x52.a14;
        dMatrix5x53.a15 = dMatrix5x5.a15 * dMatrix5x52.a15;
        dMatrix5x53.a21 = dMatrix5x5.a21 * dMatrix5x52.a21;
        dMatrix5x53.a22 = dMatrix5x5.a22 * dMatrix5x52.a22;
        dMatrix5x53.a23 = dMatrix5x5.a23 * dMatrix5x52.a23;
        dMatrix5x53.a24 = dMatrix5x5.a24 * dMatrix5x52.a24;
        dMatrix5x53.a25 = dMatrix5x5.a25 * dMatrix5x52.a25;
        dMatrix5x53.a31 = dMatrix5x5.a31 * dMatrix5x52.a31;
        dMatrix5x53.a32 = dMatrix5x5.a32 * dMatrix5x52.a32;
        dMatrix5x53.a33 = dMatrix5x5.a33 * dMatrix5x52.a33;
        dMatrix5x53.a34 = dMatrix5x5.a34 * dMatrix5x52.a34;
        dMatrix5x53.a35 = dMatrix5x5.a35 * dMatrix5x52.a35;
        dMatrix5x53.a41 = dMatrix5x5.a41 * dMatrix5x52.a41;
        dMatrix5x53.a42 = dMatrix5x5.a42 * dMatrix5x52.a42;
        dMatrix5x53.a43 = dMatrix5x5.a43 * dMatrix5x52.a43;
        dMatrix5x53.a44 = dMatrix5x5.a44 * dMatrix5x52.a44;
        dMatrix5x53.a45 = dMatrix5x5.a45 * dMatrix5x52.a45;
        dMatrix5x53.a51 = dMatrix5x5.a51 * dMatrix5x52.a51;
        dMatrix5x53.a52 = dMatrix5x5.a52 * dMatrix5x52.a52;
        dMatrix5x53.a53 = dMatrix5x5.a53 * dMatrix5x52.a53;
        dMatrix5x53.a54 = dMatrix5x5.a54 * dMatrix5x52.a54;
        dMatrix5x53.a55 = dMatrix5x5.a55 * dMatrix5x52.a55;
    }

    public static void elementMult(DMatrix5 dMatrix5, DMatrix5 dMatrix52, DMatrix5 dMatrix53) {
        dMatrix53.f2406a1 = dMatrix5.f2406a1 * dMatrix52.f2406a1;
        dMatrix53.f2407a2 = dMatrix5.f2407a2 * dMatrix52.f2407a2;
        dMatrix53.f2408a3 = dMatrix5.f2408a3 * dMatrix52.f2408a3;
        dMatrix53.f2409a4 = dMatrix5.f2409a4 * dMatrix52.f2409a4;
        dMatrix53.f2410a5 = dMatrix5.f2410a5 * dMatrix52.f2410a5;
    }

    public static void elementDiv(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52) {
        dMatrix5x5.a11 /= dMatrix5x52.a11;
        dMatrix5x5.a12 /= dMatrix5x52.a12;
        dMatrix5x5.a13 /= dMatrix5x52.a13;
        dMatrix5x5.a14 /= dMatrix5x52.a14;
        dMatrix5x5.a15 /= dMatrix5x52.a15;
        dMatrix5x5.a21 /= dMatrix5x52.a21;
        dMatrix5x5.a22 /= dMatrix5x52.a22;
        dMatrix5x5.a23 /= dMatrix5x52.a23;
        dMatrix5x5.a24 /= dMatrix5x52.a24;
        dMatrix5x5.a25 /= dMatrix5x52.a25;
        dMatrix5x5.a31 /= dMatrix5x52.a31;
        dMatrix5x5.a32 /= dMatrix5x52.a32;
        dMatrix5x5.a33 /= dMatrix5x52.a33;
        dMatrix5x5.a34 /= dMatrix5x52.a34;
        dMatrix5x5.a35 /= dMatrix5x52.a35;
        dMatrix5x5.a41 /= dMatrix5x52.a41;
        dMatrix5x5.a42 /= dMatrix5x52.a42;
        dMatrix5x5.a43 /= dMatrix5x52.a43;
        dMatrix5x5.a44 /= dMatrix5x52.a44;
        dMatrix5x5.a45 /= dMatrix5x52.a45;
        dMatrix5x5.a51 /= dMatrix5x52.a51;
        dMatrix5x5.a52 /= dMatrix5x52.a52;
        dMatrix5x5.a53 /= dMatrix5x52.a53;
        dMatrix5x5.a54 /= dMatrix5x52.a54;
        dMatrix5x5.a55 /= dMatrix5x52.a55;
    }

    public static void elementDiv(DMatrix5 dMatrix5, DMatrix5 dMatrix52) {
        dMatrix5.f2406a1 /= dMatrix52.f2406a1;
        dMatrix5.f2407a2 /= dMatrix52.f2407a2;
        dMatrix5.f2408a3 /= dMatrix52.f2408a3;
        dMatrix5.f2409a4 /= dMatrix52.f2409a4;
        dMatrix5.f2410a5 /= dMatrix52.f2410a5;
    }

    public static void elementDiv(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52, DMatrix5x5 dMatrix5x53) {
        dMatrix5x53.a11 = dMatrix5x5.a11 / dMatrix5x52.a11;
        dMatrix5x53.a12 = dMatrix5x5.a12 / dMatrix5x52.a12;
        dMatrix5x53.a13 = dMatrix5x5.a13 / dMatrix5x52.a13;
        dMatrix5x53.a14 = dMatrix5x5.a14 / dMatrix5x52.a14;
        dMatrix5x53.a15 = dMatrix5x5.a15 / dMatrix5x52.a15;
        dMatrix5x53.a21 = dMatrix5x5.a21 / dMatrix5x52.a21;
        dMatrix5x53.a22 = dMatrix5x5.a22 / dMatrix5x52.a22;
        dMatrix5x53.a23 = dMatrix5x5.a23 / dMatrix5x52.a23;
        dMatrix5x53.a24 = dMatrix5x5.a24 / dMatrix5x52.a24;
        dMatrix5x53.a25 = dMatrix5x5.a25 / dMatrix5x52.a25;
        dMatrix5x53.a31 = dMatrix5x5.a31 / dMatrix5x52.a31;
        dMatrix5x53.a32 = dMatrix5x5.a32 / dMatrix5x52.a32;
        dMatrix5x53.a33 = dMatrix5x5.a33 / dMatrix5x52.a33;
        dMatrix5x53.a34 = dMatrix5x5.a34 / dMatrix5x52.a34;
        dMatrix5x53.a35 = dMatrix5x5.a35 / dMatrix5x52.a35;
        dMatrix5x53.a41 = dMatrix5x5.a41 / dMatrix5x52.a41;
        dMatrix5x53.a42 = dMatrix5x5.a42 / dMatrix5x52.a42;
        dMatrix5x53.a43 = dMatrix5x5.a43 / dMatrix5x52.a43;
        dMatrix5x53.a44 = dMatrix5x5.a44 / dMatrix5x52.a44;
        dMatrix5x53.a45 = dMatrix5x5.a45 / dMatrix5x52.a45;
        dMatrix5x53.a51 = dMatrix5x5.a51 / dMatrix5x52.a51;
        dMatrix5x53.a52 = dMatrix5x5.a52 / dMatrix5x52.a52;
        dMatrix5x53.a53 = dMatrix5x5.a53 / dMatrix5x52.a53;
        dMatrix5x53.a54 = dMatrix5x5.a54 / dMatrix5x52.a54;
        dMatrix5x53.a55 = dMatrix5x5.a55 / dMatrix5x52.a55;
    }

    public static void elementDiv(DMatrix5 dMatrix5, DMatrix5 dMatrix52, DMatrix5 dMatrix53) {
        dMatrix53.f2406a1 = dMatrix5.f2406a1 / dMatrix52.f2406a1;
        dMatrix53.f2407a2 = dMatrix5.f2407a2 / dMatrix52.f2407a2;
        dMatrix53.f2408a3 = dMatrix5.f2408a3 / dMatrix52.f2408a3;
        dMatrix53.f2409a4 = dMatrix5.f2409a4 / dMatrix52.f2409a4;
        dMatrix53.f2410a5 = dMatrix5.f2410a5 / dMatrix52.f2410a5;
    }

    public static void scale(double d, DMatrix5x5 dMatrix5x5) {
        dMatrix5x5.a11 *= d;
        dMatrix5x5.a12 *= d;
        dMatrix5x5.a13 *= d;
        dMatrix5x5.a14 *= d;
        dMatrix5x5.a15 *= d;
        dMatrix5x5.a21 *= d;
        dMatrix5x5.a22 *= d;
        dMatrix5x5.a23 *= d;
        dMatrix5x5.a24 *= d;
        dMatrix5x5.a25 *= d;
        dMatrix5x5.a31 *= d;
        dMatrix5x5.a32 *= d;
        dMatrix5x5.a33 *= d;
        dMatrix5x5.a34 *= d;
        dMatrix5x5.a35 *= d;
        dMatrix5x5.a41 *= d;
        dMatrix5x5.a42 *= d;
        dMatrix5x5.a43 *= d;
        dMatrix5x5.a44 *= d;
        dMatrix5x5.a45 *= d;
        dMatrix5x5.a51 *= d;
        dMatrix5x5.a52 *= d;
        dMatrix5x5.a53 *= d;
        dMatrix5x5.a54 *= d;
        dMatrix5x5.a55 *= d;
    }

    public static void scale(double d, DMatrix5 dMatrix5) {
        dMatrix5.f2406a1 *= d;
        dMatrix5.f2407a2 *= d;
        dMatrix5.f2408a3 *= d;
        dMatrix5.f2409a4 *= d;
        dMatrix5.f2410a5 *= d;
    }

    public static void scale(double d, DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52) {
        dMatrix5x52.a11 = dMatrix5x5.a11 * d;
        dMatrix5x52.a12 = dMatrix5x5.a12 * d;
        dMatrix5x52.a13 = dMatrix5x5.a13 * d;
        dMatrix5x52.a14 = dMatrix5x5.a14 * d;
        dMatrix5x52.a15 = dMatrix5x5.a15 * d;
        dMatrix5x52.a21 = dMatrix5x5.a21 * d;
        dMatrix5x52.a22 = dMatrix5x5.a22 * d;
        dMatrix5x52.a23 = dMatrix5x5.a23 * d;
        dMatrix5x52.a24 = dMatrix5x5.a24 * d;
        dMatrix5x52.a25 = dMatrix5x5.a25 * d;
        dMatrix5x52.a31 = dMatrix5x5.a31 * d;
        dMatrix5x52.a32 = dMatrix5x5.a32 * d;
        dMatrix5x52.a33 = dMatrix5x5.a33 * d;
        dMatrix5x52.a34 = dMatrix5x5.a34 * d;
        dMatrix5x52.a35 = dMatrix5x5.a35 * d;
        dMatrix5x52.a41 = dMatrix5x5.a41 * d;
        dMatrix5x52.a42 = dMatrix5x5.a42 * d;
        dMatrix5x52.a43 = dMatrix5x5.a43 * d;
        dMatrix5x52.a44 = dMatrix5x5.a44 * d;
        dMatrix5x52.a45 = dMatrix5x5.a45 * d;
        dMatrix5x52.a51 = dMatrix5x5.a51 * d;
        dMatrix5x52.a52 = dMatrix5x5.a52 * d;
        dMatrix5x52.a53 = dMatrix5x5.a53 * d;
        dMatrix5x52.a54 = dMatrix5x5.a54 * d;
        dMatrix5x52.a55 = dMatrix5x5.a55 * d;
    }

    public static void scale(double d, DMatrix5 dMatrix5, DMatrix5 dMatrix52) {
        dMatrix52.f2406a1 = dMatrix5.f2406a1 * d;
        dMatrix52.f2407a2 = dMatrix5.f2407a2 * d;
        dMatrix52.f2408a3 = dMatrix5.f2408a3 * d;
        dMatrix52.f2409a4 = dMatrix5.f2409a4 * d;
        dMatrix52.f2410a5 = dMatrix5.f2410a5 * d;
    }

    public static void divide(DMatrix5x5 dMatrix5x5, double d) {
        dMatrix5x5.a11 /= d;
        dMatrix5x5.a12 /= d;
        dMatrix5x5.a13 /= d;
        dMatrix5x5.a14 /= d;
        dMatrix5x5.a15 /= d;
        dMatrix5x5.a21 /= d;
        dMatrix5x5.a22 /= d;
        dMatrix5x5.a23 /= d;
        dMatrix5x5.a24 /= d;
        dMatrix5x5.a25 /= d;
        dMatrix5x5.a31 /= d;
        dMatrix5x5.a32 /= d;
        dMatrix5x5.a33 /= d;
        dMatrix5x5.a34 /= d;
        dMatrix5x5.a35 /= d;
        dMatrix5x5.a41 /= d;
        dMatrix5x5.a42 /= d;
        dMatrix5x5.a43 /= d;
        dMatrix5x5.a44 /= d;
        dMatrix5x5.a45 /= d;
        dMatrix5x5.a51 /= d;
        dMatrix5x5.a52 /= d;
        dMatrix5x5.a53 /= d;
        dMatrix5x5.a54 /= d;
        dMatrix5x5.a55 /= d;
    }

    public static void divide(DMatrix5 dMatrix5, double d) {
        dMatrix5.f2406a1 /= d;
        dMatrix5.f2407a2 /= d;
        dMatrix5.f2408a3 /= d;
        dMatrix5.f2409a4 /= d;
        dMatrix5.f2410a5 /= d;
    }

    public static void divide(DMatrix5x5 dMatrix5x5, double d, DMatrix5x5 dMatrix5x52) {
        dMatrix5x52.a11 = dMatrix5x5.a11 / d;
        dMatrix5x52.a12 = dMatrix5x5.a12 / d;
        dMatrix5x52.a13 = dMatrix5x5.a13 / d;
        dMatrix5x52.a14 = dMatrix5x5.a14 / d;
        dMatrix5x52.a15 = dMatrix5x5.a15 / d;
        dMatrix5x52.a21 = dMatrix5x5.a21 / d;
        dMatrix5x52.a22 = dMatrix5x5.a22 / d;
        dMatrix5x52.a23 = dMatrix5x5.a23 / d;
        dMatrix5x52.a24 = dMatrix5x5.a24 / d;
        dMatrix5x52.a25 = dMatrix5x5.a25 / d;
        dMatrix5x52.a31 = dMatrix5x5.a31 / d;
        dMatrix5x52.a32 = dMatrix5x5.a32 / d;
        dMatrix5x52.a33 = dMatrix5x5.a33 / d;
        dMatrix5x52.a34 = dMatrix5x5.a34 / d;
        dMatrix5x52.a35 = dMatrix5x5.a35 / d;
        dMatrix5x52.a41 = dMatrix5x5.a41 / d;
        dMatrix5x52.a42 = dMatrix5x5.a42 / d;
        dMatrix5x52.a43 = dMatrix5x5.a43 / d;
        dMatrix5x52.a44 = dMatrix5x5.a44 / d;
        dMatrix5x52.a45 = dMatrix5x5.a45 / d;
        dMatrix5x52.a51 = dMatrix5x5.a51 / d;
        dMatrix5x52.a52 = dMatrix5x5.a52 / d;
        dMatrix5x52.a53 = dMatrix5x5.a53 / d;
        dMatrix5x52.a54 = dMatrix5x5.a54 / d;
        dMatrix5x52.a55 = dMatrix5x5.a55 / d;
    }

    public static void divide(DMatrix5 dMatrix5, double d, DMatrix5 dMatrix52) {
        dMatrix52.f2406a1 = dMatrix5.f2406a1 / d;
        dMatrix52.f2407a2 = dMatrix5.f2407a2 / d;
        dMatrix52.f2408a3 = dMatrix5.f2408a3 / d;
        dMatrix52.f2409a4 = dMatrix5.f2409a4 / d;
        dMatrix52.f2410a5 = dMatrix5.f2410a5 / d;
    }

    public static void changeSign(DMatrix5x5 dMatrix5x5) {
        dMatrix5x5.a11 = -dMatrix5x5.a11;
        dMatrix5x5.a12 = -dMatrix5x5.a12;
        dMatrix5x5.a13 = -dMatrix5x5.a13;
        dMatrix5x5.a14 = -dMatrix5x5.a14;
        dMatrix5x5.a15 = -dMatrix5x5.a15;
        dMatrix5x5.a21 = -dMatrix5x5.a21;
        dMatrix5x5.a22 = -dMatrix5x5.a22;
        dMatrix5x5.a23 = -dMatrix5x5.a23;
        dMatrix5x5.a24 = -dMatrix5x5.a24;
        dMatrix5x5.a25 = -dMatrix5x5.a25;
        dMatrix5x5.a31 = -dMatrix5x5.a31;
        dMatrix5x5.a32 = -dMatrix5x5.a32;
        dMatrix5x5.a33 = -dMatrix5x5.a33;
        dMatrix5x5.a34 = -dMatrix5x5.a34;
        dMatrix5x5.a35 = -dMatrix5x5.a35;
        dMatrix5x5.a41 = -dMatrix5x5.a41;
        dMatrix5x5.a42 = -dMatrix5x5.a42;
        dMatrix5x5.a43 = -dMatrix5x5.a43;
        dMatrix5x5.a44 = -dMatrix5x5.a44;
        dMatrix5x5.a45 = -dMatrix5x5.a45;
        dMatrix5x5.a51 = -dMatrix5x5.a51;
        dMatrix5x5.a52 = -dMatrix5x5.a52;
        dMatrix5x5.a53 = -dMatrix5x5.a53;
        dMatrix5x5.a54 = -dMatrix5x5.a54;
        dMatrix5x5.a55 = -dMatrix5x5.a55;
    }

    public static void changeSign(DMatrix5 dMatrix5) {
        dMatrix5.f2406a1 = -dMatrix5.f2406a1;
        dMatrix5.f2407a2 = -dMatrix5.f2407a2;
        dMatrix5.f2408a3 = -dMatrix5.f2408a3;
        dMatrix5.f2409a4 = -dMatrix5.f2409a4;
        dMatrix5.f2410a5 = -dMatrix5.f2410a5;
    }

    public static void fill(DMatrix5x5 dMatrix5x5, double d) {
        dMatrix5x5.a11 = d;
        dMatrix5x5.a12 = d;
        dMatrix5x5.a13 = d;
        dMatrix5x5.a14 = d;
        dMatrix5x5.a15 = d;
        dMatrix5x5.a21 = d;
        dMatrix5x5.a22 = d;
        dMatrix5x5.a23 = d;
        dMatrix5x5.a24 = d;
        dMatrix5x5.a25 = d;
        dMatrix5x5.a31 = d;
        dMatrix5x5.a32 = d;
        dMatrix5x5.a33 = d;
        dMatrix5x5.a34 = d;
        dMatrix5x5.a35 = d;
        dMatrix5x5.a41 = d;
        dMatrix5x5.a42 = d;
        dMatrix5x5.a43 = d;
        dMatrix5x5.a44 = d;
        dMatrix5x5.a45 = d;
        dMatrix5x5.a51 = d;
        dMatrix5x5.a52 = d;
        dMatrix5x5.a53 = d;
        dMatrix5x5.a54 = d;
        dMatrix5x5.a55 = d;
    }

    public static void fill(DMatrix5 dMatrix5, double d) {
        dMatrix5.f2406a1 = d;
        dMatrix5.f2407a2 = d;
        dMatrix5.f2408a3 = d;
        dMatrix5.f2409a4 = d;
        dMatrix5.f2410a5 = d;
    }

    public static DMatrix5 extractRow(DMatrix5x5 dMatrix5x5, int i, DMatrix5 dMatrix5) {
        if (dMatrix5 == null) {
            dMatrix5 = new DMatrix5();
        }
        if (i == 0) {
            dMatrix5.f2406a1 = dMatrix5x5.a11;
            dMatrix5.f2407a2 = dMatrix5x5.a12;
            dMatrix5.f2408a3 = dMatrix5x5.a13;
            dMatrix5.f2409a4 = dMatrix5x5.a14;
            dMatrix5.f2410a5 = dMatrix5x5.a15;
            return dMatrix5;
        }
        if (i == 1) {
            dMatrix5.f2406a1 = dMatrix5x5.a21;
            dMatrix5.f2407a2 = dMatrix5x5.a22;
            dMatrix5.f2408a3 = dMatrix5x5.a23;
            dMatrix5.f2409a4 = dMatrix5x5.a24;
            dMatrix5.f2410a5 = dMatrix5x5.a25;
            return dMatrix5;
        }
        if (i == 2) {
            dMatrix5.f2406a1 = dMatrix5x5.a31;
            dMatrix5.f2407a2 = dMatrix5x5.a32;
            dMatrix5.f2408a3 = dMatrix5x5.a33;
            dMatrix5.f2409a4 = dMatrix5x5.a34;
            dMatrix5.f2410a5 = dMatrix5x5.a35;
            return dMatrix5;
        }
        if (i == 3) {
            dMatrix5.f2406a1 = dMatrix5x5.a41;
            dMatrix5.f2407a2 = dMatrix5x5.a42;
            dMatrix5.f2408a3 = dMatrix5x5.a43;
            dMatrix5.f2409a4 = dMatrix5x5.a44;
            dMatrix5.f2410a5 = dMatrix5x5.a45;
            return dMatrix5;
        }
        if (i == 4) {
            dMatrix5.f2406a1 = dMatrix5x5.a51;
            dMatrix5.f2407a2 = dMatrix5x5.a52;
            dMatrix5.f2408a3 = dMatrix5x5.a53;
            dMatrix5.f2409a4 = dMatrix5x5.a54;
            dMatrix5.f2410a5 = dMatrix5x5.a55;
            return dMatrix5;
        }
        throw new IllegalArgumentException("Out of bounds row.  row = " + i);
    }

    public static DMatrix5 extractColumn(DMatrix5x5 dMatrix5x5, int i, DMatrix5 dMatrix5) {
        if (dMatrix5 == null) {
            dMatrix5 = new DMatrix5();
        }
        if (i == 0) {
            dMatrix5.f2406a1 = dMatrix5x5.a11;
            dMatrix5.f2407a2 = dMatrix5x5.a21;
            dMatrix5.f2408a3 = dMatrix5x5.a31;
            dMatrix5.f2409a4 = dMatrix5x5.a41;
            dMatrix5.f2410a5 = dMatrix5x5.a51;
            return dMatrix5;
        }
        if (i == 1) {
            dMatrix5.f2406a1 = dMatrix5x5.a12;
            dMatrix5.f2407a2 = dMatrix5x5.a22;
            dMatrix5.f2408a3 = dMatrix5x5.a32;
            dMatrix5.f2409a4 = dMatrix5x5.a42;
            dMatrix5.f2410a5 = dMatrix5x5.a52;
            return dMatrix5;
        }
        if (i == 2) {
            dMatrix5.f2406a1 = dMatrix5x5.a13;
            dMatrix5.f2407a2 = dMatrix5x5.a23;
            dMatrix5.f2408a3 = dMatrix5x5.a33;
            dMatrix5.f2409a4 = dMatrix5x5.a43;
            dMatrix5.f2410a5 = dMatrix5x5.a53;
            return dMatrix5;
        }
        if (i == 3) {
            dMatrix5.f2406a1 = dMatrix5x5.a14;
            dMatrix5.f2407a2 = dMatrix5x5.a24;
            dMatrix5.f2408a3 = dMatrix5x5.a34;
            dMatrix5.f2409a4 = dMatrix5x5.a44;
            dMatrix5.f2410a5 = dMatrix5x5.a54;
            return dMatrix5;
        }
        if (i == 4) {
            dMatrix5.f2406a1 = dMatrix5x5.a15;
            dMatrix5.f2407a2 = dMatrix5x5.a25;
            dMatrix5.f2408a3 = dMatrix5x5.a35;
            dMatrix5.f2409a4 = dMatrix5x5.a45;
            dMatrix5.f2410a5 = dMatrix5x5.a55;
            return dMatrix5;
        }
        throw new IllegalArgumentException("Out of bounds column.  column = " + i);
    }
}
