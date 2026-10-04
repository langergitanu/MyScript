package org.ejml.dense.fixed;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrix6;
import org.ejml.data.DMatrix6x6;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_DDF6 {
    public static void add(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62, DMatrix6x6 dMatrix6x63) {
        dMatrix6x63.a11 = dMatrix6x6.a11 + dMatrix6x62.a11;
        dMatrix6x63.a12 = dMatrix6x6.a12 + dMatrix6x62.a12;
        dMatrix6x63.a13 = dMatrix6x6.a13 + dMatrix6x62.a13;
        dMatrix6x63.a14 = dMatrix6x6.a14 + dMatrix6x62.a14;
        dMatrix6x63.a15 = dMatrix6x6.a15 + dMatrix6x62.a15;
        dMatrix6x63.a16 = dMatrix6x6.a16 + dMatrix6x62.a16;
        dMatrix6x63.a21 = dMatrix6x6.a21 + dMatrix6x62.a21;
        dMatrix6x63.a22 = dMatrix6x6.a22 + dMatrix6x62.a22;
        dMatrix6x63.a23 = dMatrix6x6.a23 + dMatrix6x62.a23;
        dMatrix6x63.a24 = dMatrix6x6.a24 + dMatrix6x62.a24;
        dMatrix6x63.a25 = dMatrix6x6.a25 + dMatrix6x62.a25;
        dMatrix6x63.a26 = dMatrix6x6.a26 + dMatrix6x62.a26;
        dMatrix6x63.a31 = dMatrix6x6.a31 + dMatrix6x62.a31;
        dMatrix6x63.a32 = dMatrix6x6.a32 + dMatrix6x62.a32;
        dMatrix6x63.a33 = dMatrix6x6.a33 + dMatrix6x62.a33;
        dMatrix6x63.a34 = dMatrix6x6.a34 + dMatrix6x62.a34;
        dMatrix6x63.a35 = dMatrix6x6.a35 + dMatrix6x62.a35;
        dMatrix6x63.a36 = dMatrix6x6.a36 + dMatrix6x62.a36;
        dMatrix6x63.a41 = dMatrix6x6.a41 + dMatrix6x62.a41;
        dMatrix6x63.a42 = dMatrix6x6.a42 + dMatrix6x62.a42;
        dMatrix6x63.a43 = dMatrix6x6.a43 + dMatrix6x62.a43;
        dMatrix6x63.a44 = dMatrix6x6.a44 + dMatrix6x62.a44;
        dMatrix6x63.a45 = dMatrix6x6.a45 + dMatrix6x62.a45;
        dMatrix6x63.a46 = dMatrix6x6.a46 + dMatrix6x62.a46;
        dMatrix6x63.a51 = dMatrix6x6.a51 + dMatrix6x62.a51;
        dMatrix6x63.a52 = dMatrix6x6.a52 + dMatrix6x62.a52;
        dMatrix6x63.a53 = dMatrix6x6.a53 + dMatrix6x62.a53;
        dMatrix6x63.a54 = dMatrix6x6.a54 + dMatrix6x62.a54;
        dMatrix6x63.a55 = dMatrix6x6.a55 + dMatrix6x62.a55;
        dMatrix6x63.a56 = dMatrix6x6.a56 + dMatrix6x62.a56;
        dMatrix6x63.a61 = dMatrix6x6.a61 + dMatrix6x62.a61;
        dMatrix6x63.a62 = dMatrix6x6.a62 + dMatrix6x62.a62;
        dMatrix6x63.a63 = dMatrix6x6.a63 + dMatrix6x62.a63;
        dMatrix6x63.a64 = dMatrix6x6.a64 + dMatrix6x62.a64;
        dMatrix6x63.a65 = dMatrix6x6.a65 + dMatrix6x62.a65;
        dMatrix6x63.a66 = dMatrix6x6.a66 + dMatrix6x62.a66;
    }

    public static void add(DMatrix6 dMatrix6, DMatrix6 dMatrix62, DMatrix6 dMatrix63) {
        dMatrix63.f2411a1 = dMatrix6.f2411a1 + dMatrix62.f2411a1;
        dMatrix63.f2412a2 = dMatrix6.f2412a2 + dMatrix62.f2412a2;
        dMatrix63.f2413a3 = dMatrix6.f2413a3 + dMatrix62.f2413a3;
        dMatrix63.f2414a4 = dMatrix6.f2414a4 + dMatrix62.f2414a4;
        dMatrix63.f2415a5 = dMatrix6.f2415a5 + dMatrix62.f2415a5;
        dMatrix63.f2416a6 = dMatrix6.f2416a6 + dMatrix62.f2416a6;
    }

    public static void addEquals(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62) {
        dMatrix6x6.a11 += dMatrix6x62.a11;
        dMatrix6x6.a12 += dMatrix6x62.a12;
        dMatrix6x6.a13 += dMatrix6x62.a13;
        dMatrix6x6.a14 += dMatrix6x62.a14;
        dMatrix6x6.a15 += dMatrix6x62.a15;
        dMatrix6x6.a16 += dMatrix6x62.a16;
        dMatrix6x6.a21 += dMatrix6x62.a21;
        dMatrix6x6.a22 += dMatrix6x62.a22;
        dMatrix6x6.a23 += dMatrix6x62.a23;
        dMatrix6x6.a24 += dMatrix6x62.a24;
        dMatrix6x6.a25 += dMatrix6x62.a25;
        dMatrix6x6.a26 += dMatrix6x62.a26;
        dMatrix6x6.a31 += dMatrix6x62.a31;
        dMatrix6x6.a32 += dMatrix6x62.a32;
        dMatrix6x6.a33 += dMatrix6x62.a33;
        dMatrix6x6.a34 += dMatrix6x62.a34;
        dMatrix6x6.a35 += dMatrix6x62.a35;
        dMatrix6x6.a36 += dMatrix6x62.a36;
        dMatrix6x6.a41 += dMatrix6x62.a41;
        dMatrix6x6.a42 += dMatrix6x62.a42;
        dMatrix6x6.a43 += dMatrix6x62.a43;
        dMatrix6x6.a44 += dMatrix6x62.a44;
        dMatrix6x6.a45 += dMatrix6x62.a45;
        dMatrix6x6.a46 += dMatrix6x62.a46;
        dMatrix6x6.a51 += dMatrix6x62.a51;
        dMatrix6x6.a52 += dMatrix6x62.a52;
        dMatrix6x6.a53 += dMatrix6x62.a53;
        dMatrix6x6.a54 += dMatrix6x62.a54;
        dMatrix6x6.a55 += dMatrix6x62.a55;
        dMatrix6x6.a56 += dMatrix6x62.a56;
        dMatrix6x6.a61 += dMatrix6x62.a61;
        dMatrix6x6.a62 += dMatrix6x62.a62;
        dMatrix6x6.a63 += dMatrix6x62.a63;
        dMatrix6x6.a64 += dMatrix6x62.a64;
        dMatrix6x6.a65 += dMatrix6x62.a65;
        dMatrix6x6.a66 += dMatrix6x62.a66;
    }

    public static void addEquals(DMatrix6 dMatrix6, DMatrix6 dMatrix62) {
        dMatrix6.f2411a1 += dMatrix62.f2411a1;
        dMatrix6.f2412a2 += dMatrix62.f2412a2;
        dMatrix6.f2413a3 += dMatrix62.f2413a3;
        dMatrix6.f2414a4 += dMatrix62.f2414a4;
        dMatrix6.f2415a5 += dMatrix62.f2415a5;
        dMatrix6.f2416a6 += dMatrix62.f2416a6;
    }

    public static void subtract(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62, DMatrix6x6 dMatrix6x63) {
        dMatrix6x63.a11 = dMatrix6x6.a11 - dMatrix6x62.a11;
        dMatrix6x63.a12 = dMatrix6x6.a12 - dMatrix6x62.a12;
        dMatrix6x63.a13 = dMatrix6x6.a13 - dMatrix6x62.a13;
        dMatrix6x63.a14 = dMatrix6x6.a14 - dMatrix6x62.a14;
        dMatrix6x63.a15 = dMatrix6x6.a15 - dMatrix6x62.a15;
        dMatrix6x63.a16 = dMatrix6x6.a16 - dMatrix6x62.a16;
        dMatrix6x63.a21 = dMatrix6x6.a21 - dMatrix6x62.a21;
        dMatrix6x63.a22 = dMatrix6x6.a22 - dMatrix6x62.a22;
        dMatrix6x63.a23 = dMatrix6x6.a23 - dMatrix6x62.a23;
        dMatrix6x63.a24 = dMatrix6x6.a24 - dMatrix6x62.a24;
        dMatrix6x63.a25 = dMatrix6x6.a25 - dMatrix6x62.a25;
        dMatrix6x63.a26 = dMatrix6x6.a26 - dMatrix6x62.a26;
        dMatrix6x63.a31 = dMatrix6x6.a31 - dMatrix6x62.a31;
        dMatrix6x63.a32 = dMatrix6x6.a32 - dMatrix6x62.a32;
        dMatrix6x63.a33 = dMatrix6x6.a33 - dMatrix6x62.a33;
        dMatrix6x63.a34 = dMatrix6x6.a34 - dMatrix6x62.a34;
        dMatrix6x63.a35 = dMatrix6x6.a35 - dMatrix6x62.a35;
        dMatrix6x63.a36 = dMatrix6x6.a36 - dMatrix6x62.a36;
        dMatrix6x63.a41 = dMatrix6x6.a41 - dMatrix6x62.a41;
        dMatrix6x63.a42 = dMatrix6x6.a42 - dMatrix6x62.a42;
        dMatrix6x63.a43 = dMatrix6x6.a43 - dMatrix6x62.a43;
        dMatrix6x63.a44 = dMatrix6x6.a44 - dMatrix6x62.a44;
        dMatrix6x63.a45 = dMatrix6x6.a45 - dMatrix6x62.a45;
        dMatrix6x63.a46 = dMatrix6x6.a46 - dMatrix6x62.a46;
        dMatrix6x63.a51 = dMatrix6x6.a51 - dMatrix6x62.a51;
        dMatrix6x63.a52 = dMatrix6x6.a52 - dMatrix6x62.a52;
        dMatrix6x63.a53 = dMatrix6x6.a53 - dMatrix6x62.a53;
        dMatrix6x63.a54 = dMatrix6x6.a54 - dMatrix6x62.a54;
        dMatrix6x63.a55 = dMatrix6x6.a55 - dMatrix6x62.a55;
        dMatrix6x63.a56 = dMatrix6x6.a56 - dMatrix6x62.a56;
        dMatrix6x63.a61 = dMatrix6x6.a61 - dMatrix6x62.a61;
        dMatrix6x63.a62 = dMatrix6x6.a62 - dMatrix6x62.a62;
        dMatrix6x63.a63 = dMatrix6x6.a63 - dMatrix6x62.a63;
        dMatrix6x63.a64 = dMatrix6x6.a64 - dMatrix6x62.a64;
        dMatrix6x63.a65 = dMatrix6x6.a65 - dMatrix6x62.a65;
        dMatrix6x63.a66 = dMatrix6x6.a66 - dMatrix6x62.a66;
    }

    public static void subtract(DMatrix6 dMatrix6, DMatrix6 dMatrix62, DMatrix6 dMatrix63) {
        dMatrix63.f2411a1 = dMatrix6.f2411a1 - dMatrix62.f2411a1;
        dMatrix63.f2412a2 = dMatrix6.f2412a2 - dMatrix62.f2412a2;
        dMatrix63.f2413a3 = dMatrix6.f2413a3 - dMatrix62.f2413a3;
        dMatrix63.f2414a4 = dMatrix6.f2414a4 - dMatrix62.f2414a4;
        dMatrix63.f2415a5 = dMatrix6.f2415a5 - dMatrix62.f2415a5;
        dMatrix63.f2416a6 = dMatrix6.f2416a6 - dMatrix62.f2416a6;
    }

    public static void subtractEquals(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62) {
        dMatrix6x6.a11 -= dMatrix6x62.a11;
        dMatrix6x6.a12 -= dMatrix6x62.a12;
        dMatrix6x6.a13 -= dMatrix6x62.a13;
        dMatrix6x6.a14 -= dMatrix6x62.a14;
        dMatrix6x6.a15 -= dMatrix6x62.a15;
        dMatrix6x6.a16 -= dMatrix6x62.a16;
        dMatrix6x6.a21 -= dMatrix6x62.a21;
        dMatrix6x6.a22 -= dMatrix6x62.a22;
        dMatrix6x6.a23 -= dMatrix6x62.a23;
        dMatrix6x6.a24 -= dMatrix6x62.a24;
        dMatrix6x6.a25 -= dMatrix6x62.a25;
        dMatrix6x6.a26 -= dMatrix6x62.a26;
        dMatrix6x6.a31 -= dMatrix6x62.a31;
        dMatrix6x6.a32 -= dMatrix6x62.a32;
        dMatrix6x6.a33 -= dMatrix6x62.a33;
        dMatrix6x6.a34 -= dMatrix6x62.a34;
        dMatrix6x6.a35 -= dMatrix6x62.a35;
        dMatrix6x6.a36 -= dMatrix6x62.a36;
        dMatrix6x6.a41 -= dMatrix6x62.a41;
        dMatrix6x6.a42 -= dMatrix6x62.a42;
        dMatrix6x6.a43 -= dMatrix6x62.a43;
        dMatrix6x6.a44 -= dMatrix6x62.a44;
        dMatrix6x6.a45 -= dMatrix6x62.a45;
        dMatrix6x6.a46 -= dMatrix6x62.a46;
        dMatrix6x6.a51 -= dMatrix6x62.a51;
        dMatrix6x6.a52 -= dMatrix6x62.a52;
        dMatrix6x6.a53 -= dMatrix6x62.a53;
        dMatrix6x6.a54 -= dMatrix6x62.a54;
        dMatrix6x6.a55 -= dMatrix6x62.a55;
        dMatrix6x6.a56 -= dMatrix6x62.a56;
        dMatrix6x6.a61 -= dMatrix6x62.a61;
        dMatrix6x6.a62 -= dMatrix6x62.a62;
        dMatrix6x6.a63 -= dMatrix6x62.a63;
        dMatrix6x6.a64 -= dMatrix6x62.a64;
        dMatrix6x6.a65 -= dMatrix6x62.a65;
        dMatrix6x6.a66 -= dMatrix6x62.a66;
    }

    public static void subtractEquals(DMatrix6 dMatrix6, DMatrix6 dMatrix62) {
        dMatrix6.f2411a1 -= dMatrix62.f2411a1;
        dMatrix6.f2412a2 -= dMatrix62.f2412a2;
        dMatrix6.f2413a3 -= dMatrix62.f2413a3;
        dMatrix6.f2414a4 -= dMatrix62.f2414a4;
        dMatrix6.f2415a5 -= dMatrix62.f2415a5;
        dMatrix6.f2416a6 -= dMatrix62.f2416a6;
    }

    public static void transpose(DMatrix6x6 dMatrix6x6) {
        double d = dMatrix6x6.a12;
        dMatrix6x6.a12 = dMatrix6x6.a21;
        dMatrix6x6.a21 = d;
        double d2 = dMatrix6x6.a13;
        dMatrix6x6.a13 = dMatrix6x6.a31;
        dMatrix6x6.a31 = d2;
        double d3 = dMatrix6x6.a14;
        dMatrix6x6.a14 = dMatrix6x6.a41;
        dMatrix6x6.a41 = d3;
        double d4 = dMatrix6x6.a15;
        dMatrix6x6.a15 = dMatrix6x6.a51;
        dMatrix6x6.a51 = d4;
        double d5 = dMatrix6x6.a16;
        dMatrix6x6.a16 = dMatrix6x6.a61;
        dMatrix6x6.a61 = d5;
        double d6 = dMatrix6x6.a23;
        dMatrix6x6.a23 = dMatrix6x6.a32;
        dMatrix6x6.a32 = d6;
        double d7 = dMatrix6x6.a24;
        dMatrix6x6.a24 = dMatrix6x6.a42;
        dMatrix6x6.a42 = d7;
        double d8 = dMatrix6x6.a25;
        dMatrix6x6.a25 = dMatrix6x6.a52;
        dMatrix6x6.a52 = d8;
        double d9 = dMatrix6x6.a26;
        dMatrix6x6.a26 = dMatrix6x6.a62;
        dMatrix6x6.a62 = d9;
        double d10 = dMatrix6x6.a34;
        dMatrix6x6.a34 = dMatrix6x6.a43;
        dMatrix6x6.a43 = d10;
        double d11 = dMatrix6x6.a35;
        dMatrix6x6.a35 = dMatrix6x6.a53;
        dMatrix6x6.a53 = d11;
        double d12 = dMatrix6x6.a36;
        dMatrix6x6.a36 = dMatrix6x6.a63;
        dMatrix6x6.a63 = d12;
        double d13 = dMatrix6x6.a45;
        dMatrix6x6.a45 = dMatrix6x6.a54;
        dMatrix6x6.a54 = d13;
        double d14 = dMatrix6x6.a46;
        dMatrix6x6.a46 = dMatrix6x6.a64;
        dMatrix6x6.a64 = d14;
        double d15 = dMatrix6x6.a56;
        dMatrix6x6.a56 = dMatrix6x6.a65;
        dMatrix6x6.a65 = d15;
    }

    public static DMatrix6x6 transpose(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62) {
        if (dMatrix6x6 == null) {
            dMatrix6x6 = new DMatrix6x6();
        }
        dMatrix6x62.a11 = dMatrix6x6.a11;
        dMatrix6x62.a12 = dMatrix6x6.a21;
        dMatrix6x62.a13 = dMatrix6x6.a31;
        dMatrix6x62.a14 = dMatrix6x6.a41;
        dMatrix6x62.a15 = dMatrix6x6.a51;
        dMatrix6x62.a16 = dMatrix6x6.a61;
        dMatrix6x62.a21 = dMatrix6x6.a12;
        dMatrix6x62.a22 = dMatrix6x6.a22;
        dMatrix6x62.a23 = dMatrix6x6.a32;
        dMatrix6x62.a24 = dMatrix6x6.a42;
        dMatrix6x62.a25 = dMatrix6x6.a52;
        dMatrix6x62.a26 = dMatrix6x6.a62;
        dMatrix6x62.a31 = dMatrix6x6.a13;
        dMatrix6x62.a32 = dMatrix6x6.a23;
        dMatrix6x62.a33 = dMatrix6x6.a33;
        dMatrix6x62.a34 = dMatrix6x6.a43;
        dMatrix6x62.a35 = dMatrix6x6.a53;
        dMatrix6x62.a36 = dMatrix6x6.a63;
        dMatrix6x62.a41 = dMatrix6x6.a14;
        dMatrix6x62.a42 = dMatrix6x6.a24;
        dMatrix6x62.a43 = dMatrix6x6.a34;
        dMatrix6x62.a44 = dMatrix6x6.a44;
        dMatrix6x62.a45 = dMatrix6x6.a54;
        dMatrix6x62.a46 = dMatrix6x6.a64;
        dMatrix6x62.a51 = dMatrix6x6.a15;
        dMatrix6x62.a52 = dMatrix6x6.a25;
        dMatrix6x62.a53 = dMatrix6x6.a35;
        dMatrix6x62.a54 = dMatrix6x6.a45;
        dMatrix6x62.a55 = dMatrix6x6.a55;
        dMatrix6x62.a56 = dMatrix6x6.a65;
        dMatrix6x62.a61 = dMatrix6x6.a16;
        dMatrix6x62.a62 = dMatrix6x6.a26;
        dMatrix6x62.a63 = dMatrix6x6.a36;
        dMatrix6x62.a64 = dMatrix6x6.a46;
        dMatrix6x62.a65 = dMatrix6x6.a56;
        dMatrix6x62.a66 = dMatrix6x6.a66;
        return dMatrix6x62;
    }

    public static void mult(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62, DMatrix6x6 dMatrix6x63) {
        dMatrix6x63.a11 = (dMatrix6x6.a11 * dMatrix6x62.a11) + (dMatrix6x6.a12 * dMatrix6x62.a21) + (dMatrix6x6.a13 * dMatrix6x62.a31) + (dMatrix6x6.a14 * dMatrix6x62.a41) + (dMatrix6x6.a15 * dMatrix6x62.a51) + (dMatrix6x6.a16 * dMatrix6x62.a61);
        dMatrix6x63.a12 = (dMatrix6x6.a11 * dMatrix6x62.a12) + (dMatrix6x6.a12 * dMatrix6x62.a22) + (dMatrix6x6.a13 * dMatrix6x62.a32) + (dMatrix6x6.a14 * dMatrix6x62.a42) + (dMatrix6x6.a15 * dMatrix6x62.a52) + (dMatrix6x6.a16 * dMatrix6x62.a62);
        dMatrix6x63.a13 = (dMatrix6x6.a11 * dMatrix6x62.a13) + (dMatrix6x6.a12 * dMatrix6x62.a23) + (dMatrix6x6.a13 * dMatrix6x62.a33) + (dMatrix6x6.a14 * dMatrix6x62.a43) + (dMatrix6x6.a15 * dMatrix6x62.a53) + (dMatrix6x6.a16 * dMatrix6x62.a63);
        dMatrix6x63.a14 = (dMatrix6x6.a11 * dMatrix6x62.a14) + (dMatrix6x6.a12 * dMatrix6x62.a24) + (dMatrix6x6.a13 * dMatrix6x62.a34) + (dMatrix6x6.a14 * dMatrix6x62.a44) + (dMatrix6x6.a15 * dMatrix6x62.a54) + (dMatrix6x6.a16 * dMatrix6x62.a64);
        dMatrix6x63.a15 = (dMatrix6x6.a11 * dMatrix6x62.a15) + (dMatrix6x6.a12 * dMatrix6x62.a25) + (dMatrix6x6.a13 * dMatrix6x62.a35) + (dMatrix6x6.a14 * dMatrix6x62.a45) + (dMatrix6x6.a15 * dMatrix6x62.a55) + (dMatrix6x6.a16 * dMatrix6x62.a65);
        dMatrix6x63.a16 = (dMatrix6x6.a11 * dMatrix6x62.a16) + (dMatrix6x6.a12 * dMatrix6x62.a26) + (dMatrix6x6.a13 * dMatrix6x62.a36) + (dMatrix6x6.a14 * dMatrix6x62.a46) + (dMatrix6x6.a15 * dMatrix6x62.a56) + (dMatrix6x6.a16 * dMatrix6x62.a66);
        dMatrix6x63.a21 = (dMatrix6x6.a21 * dMatrix6x62.a11) + (dMatrix6x6.a22 * dMatrix6x62.a21) + (dMatrix6x6.a23 * dMatrix6x62.a31) + (dMatrix6x6.a24 * dMatrix6x62.a41) + (dMatrix6x6.a25 * dMatrix6x62.a51) + (dMatrix6x6.a26 * dMatrix6x62.a61);
        dMatrix6x63.a22 = (dMatrix6x6.a21 * dMatrix6x62.a12) + (dMatrix6x6.a22 * dMatrix6x62.a22) + (dMatrix6x6.a23 * dMatrix6x62.a32) + (dMatrix6x6.a24 * dMatrix6x62.a42) + (dMatrix6x6.a25 * dMatrix6x62.a52) + (dMatrix6x6.a26 * dMatrix6x62.a62);
        dMatrix6x63.a23 = (dMatrix6x6.a21 * dMatrix6x62.a13) + (dMatrix6x6.a22 * dMatrix6x62.a23) + (dMatrix6x6.a23 * dMatrix6x62.a33) + (dMatrix6x6.a24 * dMatrix6x62.a43) + (dMatrix6x6.a25 * dMatrix6x62.a53) + (dMatrix6x6.a26 * dMatrix6x62.a63);
        dMatrix6x63.a24 = (dMatrix6x6.a21 * dMatrix6x62.a14) + (dMatrix6x6.a22 * dMatrix6x62.a24) + (dMatrix6x6.a23 * dMatrix6x62.a34) + (dMatrix6x6.a24 * dMatrix6x62.a44) + (dMatrix6x6.a25 * dMatrix6x62.a54) + (dMatrix6x6.a26 * dMatrix6x62.a64);
        dMatrix6x63.a25 = (dMatrix6x6.a21 * dMatrix6x62.a15) + (dMatrix6x6.a22 * dMatrix6x62.a25) + (dMatrix6x6.a23 * dMatrix6x62.a35) + (dMatrix6x6.a24 * dMatrix6x62.a45) + (dMatrix6x6.a25 * dMatrix6x62.a55) + (dMatrix6x6.a26 * dMatrix6x62.a65);
        dMatrix6x63.a26 = (dMatrix6x6.a21 * dMatrix6x62.a16) + (dMatrix6x6.a22 * dMatrix6x62.a26) + (dMatrix6x6.a23 * dMatrix6x62.a36) + (dMatrix6x6.a24 * dMatrix6x62.a46) + (dMatrix6x6.a25 * dMatrix6x62.a56) + (dMatrix6x6.a26 * dMatrix6x62.a66);
        dMatrix6x63.a31 = (dMatrix6x6.a31 * dMatrix6x62.a11) + (dMatrix6x6.a32 * dMatrix6x62.a21) + (dMatrix6x6.a33 * dMatrix6x62.a31) + (dMatrix6x6.a34 * dMatrix6x62.a41) + (dMatrix6x6.a35 * dMatrix6x62.a51) + (dMatrix6x6.a36 * dMatrix6x62.a61);
        dMatrix6x63.a32 = (dMatrix6x6.a31 * dMatrix6x62.a12) + (dMatrix6x6.a32 * dMatrix6x62.a22) + (dMatrix6x6.a33 * dMatrix6x62.a32) + (dMatrix6x6.a34 * dMatrix6x62.a42) + (dMatrix6x6.a35 * dMatrix6x62.a52) + (dMatrix6x6.a36 * dMatrix6x62.a62);
        dMatrix6x63.a33 = (dMatrix6x6.a31 * dMatrix6x62.a13) + (dMatrix6x6.a32 * dMatrix6x62.a23) + (dMatrix6x6.a33 * dMatrix6x62.a33) + (dMatrix6x6.a34 * dMatrix6x62.a43) + (dMatrix6x6.a35 * dMatrix6x62.a53) + (dMatrix6x6.a36 * dMatrix6x62.a63);
        dMatrix6x63.a34 = (dMatrix6x6.a31 * dMatrix6x62.a14) + (dMatrix6x6.a32 * dMatrix6x62.a24) + (dMatrix6x6.a33 * dMatrix6x62.a34) + (dMatrix6x6.a34 * dMatrix6x62.a44) + (dMatrix6x6.a35 * dMatrix6x62.a54) + (dMatrix6x6.a36 * dMatrix6x62.a64);
        dMatrix6x63.a35 = (dMatrix6x6.a31 * dMatrix6x62.a15) + (dMatrix6x6.a32 * dMatrix6x62.a25) + (dMatrix6x6.a33 * dMatrix6x62.a35) + (dMatrix6x6.a34 * dMatrix6x62.a45) + (dMatrix6x6.a35 * dMatrix6x62.a55) + (dMatrix6x6.a36 * dMatrix6x62.a65);
        dMatrix6x63.a36 = (dMatrix6x6.a31 * dMatrix6x62.a16) + (dMatrix6x6.a32 * dMatrix6x62.a26) + (dMatrix6x6.a33 * dMatrix6x62.a36) + (dMatrix6x6.a34 * dMatrix6x62.a46) + (dMatrix6x6.a35 * dMatrix6x62.a56) + (dMatrix6x6.a36 * dMatrix6x62.a66);
        dMatrix6x63.a41 = (dMatrix6x6.a41 * dMatrix6x62.a11) + (dMatrix6x6.a42 * dMatrix6x62.a21) + (dMatrix6x6.a43 * dMatrix6x62.a31) + (dMatrix6x6.a44 * dMatrix6x62.a41) + (dMatrix6x6.a45 * dMatrix6x62.a51) + (dMatrix6x6.a46 * dMatrix6x62.a61);
        dMatrix6x63.a42 = (dMatrix6x6.a41 * dMatrix6x62.a12) + (dMatrix6x6.a42 * dMatrix6x62.a22) + (dMatrix6x6.a43 * dMatrix6x62.a32) + (dMatrix6x6.a44 * dMatrix6x62.a42) + (dMatrix6x6.a45 * dMatrix6x62.a52) + (dMatrix6x6.a46 * dMatrix6x62.a62);
        dMatrix6x63.a43 = (dMatrix6x6.a41 * dMatrix6x62.a13) + (dMatrix6x6.a42 * dMatrix6x62.a23) + (dMatrix6x6.a43 * dMatrix6x62.a33) + (dMatrix6x6.a44 * dMatrix6x62.a43) + (dMatrix6x6.a45 * dMatrix6x62.a53) + (dMatrix6x6.a46 * dMatrix6x62.a63);
        dMatrix6x63.a44 = (dMatrix6x6.a41 * dMatrix6x62.a14) + (dMatrix6x6.a42 * dMatrix6x62.a24) + (dMatrix6x6.a43 * dMatrix6x62.a34) + (dMatrix6x6.a44 * dMatrix6x62.a44) + (dMatrix6x6.a45 * dMatrix6x62.a54) + (dMatrix6x6.a46 * dMatrix6x62.a64);
        dMatrix6x63.a45 = (dMatrix6x6.a41 * dMatrix6x62.a15) + (dMatrix6x6.a42 * dMatrix6x62.a25) + (dMatrix6x6.a43 * dMatrix6x62.a35) + (dMatrix6x6.a44 * dMatrix6x62.a45) + (dMatrix6x6.a45 * dMatrix6x62.a55) + (dMatrix6x6.a46 * dMatrix6x62.a65);
        dMatrix6x63.a46 = (dMatrix6x6.a41 * dMatrix6x62.a16) + (dMatrix6x6.a42 * dMatrix6x62.a26) + (dMatrix6x6.a43 * dMatrix6x62.a36) + (dMatrix6x6.a44 * dMatrix6x62.a46) + (dMatrix6x6.a45 * dMatrix6x62.a56) + (dMatrix6x6.a46 * dMatrix6x62.a66);
        dMatrix6x63.a51 = (dMatrix6x6.a51 * dMatrix6x62.a11) + (dMatrix6x6.a52 * dMatrix6x62.a21) + (dMatrix6x6.a53 * dMatrix6x62.a31) + (dMatrix6x6.a54 * dMatrix6x62.a41) + (dMatrix6x6.a55 * dMatrix6x62.a51) + (dMatrix6x6.a56 * dMatrix6x62.a61);
        dMatrix6x63.a52 = (dMatrix6x6.a51 * dMatrix6x62.a12) + (dMatrix6x6.a52 * dMatrix6x62.a22) + (dMatrix6x6.a53 * dMatrix6x62.a32) + (dMatrix6x6.a54 * dMatrix6x62.a42) + (dMatrix6x6.a55 * dMatrix6x62.a52) + (dMatrix6x6.a56 * dMatrix6x62.a62);
        dMatrix6x63.a53 = (dMatrix6x6.a51 * dMatrix6x62.a13) + (dMatrix6x6.a52 * dMatrix6x62.a23) + (dMatrix6x6.a53 * dMatrix6x62.a33) + (dMatrix6x6.a54 * dMatrix6x62.a43) + (dMatrix6x6.a55 * dMatrix6x62.a53) + (dMatrix6x6.a56 * dMatrix6x62.a63);
        dMatrix6x63.a54 = (dMatrix6x6.a51 * dMatrix6x62.a14) + (dMatrix6x6.a52 * dMatrix6x62.a24) + (dMatrix6x6.a53 * dMatrix6x62.a34) + (dMatrix6x6.a54 * dMatrix6x62.a44) + (dMatrix6x6.a55 * dMatrix6x62.a54) + (dMatrix6x6.a56 * dMatrix6x62.a64);
        dMatrix6x63.a55 = (dMatrix6x6.a51 * dMatrix6x62.a15) + (dMatrix6x6.a52 * dMatrix6x62.a25) + (dMatrix6x6.a53 * dMatrix6x62.a35) + (dMatrix6x6.a54 * dMatrix6x62.a45) + (dMatrix6x6.a55 * dMatrix6x62.a55) + (dMatrix6x6.a56 * dMatrix6x62.a65);
        dMatrix6x63.a56 = (dMatrix6x6.a51 * dMatrix6x62.a16) + (dMatrix6x6.a52 * dMatrix6x62.a26) + (dMatrix6x6.a53 * dMatrix6x62.a36) + (dMatrix6x6.a54 * dMatrix6x62.a46) + (dMatrix6x6.a55 * dMatrix6x62.a56) + (dMatrix6x6.a56 * dMatrix6x62.a66);
        dMatrix6x63.a61 = (dMatrix6x6.a61 * dMatrix6x62.a11) + (dMatrix6x6.a62 * dMatrix6x62.a21) + (dMatrix6x6.a63 * dMatrix6x62.a31) + (dMatrix6x6.a64 * dMatrix6x62.a41) + (dMatrix6x6.a65 * dMatrix6x62.a51) + (dMatrix6x6.a66 * dMatrix6x62.a61);
        dMatrix6x63.a62 = (dMatrix6x6.a61 * dMatrix6x62.a12) + (dMatrix6x6.a62 * dMatrix6x62.a22) + (dMatrix6x6.a63 * dMatrix6x62.a32) + (dMatrix6x6.a64 * dMatrix6x62.a42) + (dMatrix6x6.a65 * dMatrix6x62.a52) + (dMatrix6x6.a66 * dMatrix6x62.a62);
        dMatrix6x63.a63 = (dMatrix6x6.a61 * dMatrix6x62.a13) + (dMatrix6x6.a62 * dMatrix6x62.a23) + (dMatrix6x6.a63 * dMatrix6x62.a33) + (dMatrix6x6.a64 * dMatrix6x62.a43) + (dMatrix6x6.a65 * dMatrix6x62.a53) + (dMatrix6x6.a66 * dMatrix6x62.a63);
        dMatrix6x63.a64 = (dMatrix6x6.a61 * dMatrix6x62.a14) + (dMatrix6x6.a62 * dMatrix6x62.a24) + (dMatrix6x6.a63 * dMatrix6x62.a34) + (dMatrix6x6.a64 * dMatrix6x62.a44) + (dMatrix6x6.a65 * dMatrix6x62.a54) + (dMatrix6x6.a66 * dMatrix6x62.a64);
        dMatrix6x63.a65 = (dMatrix6x6.a61 * dMatrix6x62.a15) + (dMatrix6x6.a62 * dMatrix6x62.a25) + (dMatrix6x6.a63 * dMatrix6x62.a35) + (dMatrix6x6.a64 * dMatrix6x62.a45) + (dMatrix6x6.a65 * dMatrix6x62.a55) + (dMatrix6x6.a66 * dMatrix6x62.a65);
        dMatrix6x63.a66 = (dMatrix6x6.a61 * dMatrix6x62.a16) + (dMatrix6x6.a62 * dMatrix6x62.a26) + (dMatrix6x6.a63 * dMatrix6x62.a36) + (dMatrix6x6.a64 * dMatrix6x62.a46) + (dMatrix6x6.a65 * dMatrix6x62.a56) + (dMatrix6x6.a66 * dMatrix6x62.a66);
    }

    public static void multTransA(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62, DMatrix6x6 dMatrix6x63) {
        dMatrix6x63.a11 = (dMatrix6x6.a11 * dMatrix6x62.a11) + (dMatrix6x6.a21 * dMatrix6x62.a21) + (dMatrix6x6.a31 * dMatrix6x62.a31) + (dMatrix6x6.a41 * dMatrix6x62.a41) + (dMatrix6x6.a51 * dMatrix6x62.a51) + (dMatrix6x6.a61 * dMatrix6x62.a61);
        dMatrix6x63.a12 = (dMatrix6x6.a11 * dMatrix6x62.a12) + (dMatrix6x6.a21 * dMatrix6x62.a22) + (dMatrix6x6.a31 * dMatrix6x62.a32) + (dMatrix6x6.a41 * dMatrix6x62.a42) + (dMatrix6x6.a51 * dMatrix6x62.a52) + (dMatrix6x6.a61 * dMatrix6x62.a62);
        dMatrix6x63.a13 = (dMatrix6x6.a11 * dMatrix6x62.a13) + (dMatrix6x6.a21 * dMatrix6x62.a23) + (dMatrix6x6.a31 * dMatrix6x62.a33) + (dMatrix6x6.a41 * dMatrix6x62.a43) + (dMatrix6x6.a51 * dMatrix6x62.a53) + (dMatrix6x6.a61 * dMatrix6x62.a63);
        dMatrix6x63.a14 = (dMatrix6x6.a11 * dMatrix6x62.a14) + (dMatrix6x6.a21 * dMatrix6x62.a24) + (dMatrix6x6.a31 * dMatrix6x62.a34) + (dMatrix6x6.a41 * dMatrix6x62.a44) + (dMatrix6x6.a51 * dMatrix6x62.a54) + (dMatrix6x6.a61 * dMatrix6x62.a64);
        dMatrix6x63.a15 = (dMatrix6x6.a11 * dMatrix6x62.a15) + (dMatrix6x6.a21 * dMatrix6x62.a25) + (dMatrix6x6.a31 * dMatrix6x62.a35) + (dMatrix6x6.a41 * dMatrix6x62.a45) + (dMatrix6x6.a51 * dMatrix6x62.a55) + (dMatrix6x6.a61 * dMatrix6x62.a65);
        dMatrix6x63.a16 = (dMatrix6x6.a11 * dMatrix6x62.a16) + (dMatrix6x6.a21 * dMatrix6x62.a26) + (dMatrix6x6.a31 * dMatrix6x62.a36) + (dMatrix6x6.a41 * dMatrix6x62.a46) + (dMatrix6x6.a51 * dMatrix6x62.a56) + (dMatrix6x6.a61 * dMatrix6x62.a66);
        dMatrix6x63.a21 = (dMatrix6x6.a12 * dMatrix6x62.a11) + (dMatrix6x6.a22 * dMatrix6x62.a21) + (dMatrix6x6.a32 * dMatrix6x62.a31) + (dMatrix6x6.a42 * dMatrix6x62.a41) + (dMatrix6x6.a52 * dMatrix6x62.a51) + (dMatrix6x6.a62 * dMatrix6x62.a61);
        dMatrix6x63.a22 = (dMatrix6x6.a12 * dMatrix6x62.a12) + (dMatrix6x6.a22 * dMatrix6x62.a22) + (dMatrix6x6.a32 * dMatrix6x62.a32) + (dMatrix6x6.a42 * dMatrix6x62.a42) + (dMatrix6x6.a52 * dMatrix6x62.a52) + (dMatrix6x6.a62 * dMatrix6x62.a62);
        dMatrix6x63.a23 = (dMatrix6x6.a12 * dMatrix6x62.a13) + (dMatrix6x6.a22 * dMatrix6x62.a23) + (dMatrix6x6.a32 * dMatrix6x62.a33) + (dMatrix6x6.a42 * dMatrix6x62.a43) + (dMatrix6x6.a52 * dMatrix6x62.a53) + (dMatrix6x6.a62 * dMatrix6x62.a63);
        dMatrix6x63.a24 = (dMatrix6x6.a12 * dMatrix6x62.a14) + (dMatrix6x6.a22 * dMatrix6x62.a24) + (dMatrix6x6.a32 * dMatrix6x62.a34) + (dMatrix6x6.a42 * dMatrix6x62.a44) + (dMatrix6x6.a52 * dMatrix6x62.a54) + (dMatrix6x6.a62 * dMatrix6x62.a64);
        dMatrix6x63.a25 = (dMatrix6x6.a12 * dMatrix6x62.a15) + (dMatrix6x6.a22 * dMatrix6x62.a25) + (dMatrix6x6.a32 * dMatrix6x62.a35) + (dMatrix6x6.a42 * dMatrix6x62.a45) + (dMatrix6x6.a52 * dMatrix6x62.a55) + (dMatrix6x6.a62 * dMatrix6x62.a65);
        dMatrix6x63.a26 = (dMatrix6x6.a12 * dMatrix6x62.a16) + (dMatrix6x6.a22 * dMatrix6x62.a26) + (dMatrix6x6.a32 * dMatrix6x62.a36) + (dMatrix6x6.a42 * dMatrix6x62.a46) + (dMatrix6x6.a52 * dMatrix6x62.a56) + (dMatrix6x6.a62 * dMatrix6x62.a66);
        dMatrix6x63.a31 = (dMatrix6x6.a13 * dMatrix6x62.a11) + (dMatrix6x6.a23 * dMatrix6x62.a21) + (dMatrix6x6.a33 * dMatrix6x62.a31) + (dMatrix6x6.a43 * dMatrix6x62.a41) + (dMatrix6x6.a53 * dMatrix6x62.a51) + (dMatrix6x6.a63 * dMatrix6x62.a61);
        dMatrix6x63.a32 = (dMatrix6x6.a13 * dMatrix6x62.a12) + (dMatrix6x6.a23 * dMatrix6x62.a22) + (dMatrix6x6.a33 * dMatrix6x62.a32) + (dMatrix6x6.a43 * dMatrix6x62.a42) + (dMatrix6x6.a53 * dMatrix6x62.a52) + (dMatrix6x6.a63 * dMatrix6x62.a62);
        dMatrix6x63.a33 = (dMatrix6x6.a13 * dMatrix6x62.a13) + (dMatrix6x6.a23 * dMatrix6x62.a23) + (dMatrix6x6.a33 * dMatrix6x62.a33) + (dMatrix6x6.a43 * dMatrix6x62.a43) + (dMatrix6x6.a53 * dMatrix6x62.a53) + (dMatrix6x6.a63 * dMatrix6x62.a63);
        dMatrix6x63.a34 = (dMatrix6x6.a13 * dMatrix6x62.a14) + (dMatrix6x6.a23 * dMatrix6x62.a24) + (dMatrix6x6.a33 * dMatrix6x62.a34) + (dMatrix6x6.a43 * dMatrix6x62.a44) + (dMatrix6x6.a53 * dMatrix6x62.a54) + (dMatrix6x6.a63 * dMatrix6x62.a64);
        dMatrix6x63.a35 = (dMatrix6x6.a13 * dMatrix6x62.a15) + (dMatrix6x6.a23 * dMatrix6x62.a25) + (dMatrix6x6.a33 * dMatrix6x62.a35) + (dMatrix6x6.a43 * dMatrix6x62.a45) + (dMatrix6x6.a53 * dMatrix6x62.a55) + (dMatrix6x6.a63 * dMatrix6x62.a65);
        dMatrix6x63.a36 = (dMatrix6x6.a13 * dMatrix6x62.a16) + (dMatrix6x6.a23 * dMatrix6x62.a26) + (dMatrix6x6.a33 * dMatrix6x62.a36) + (dMatrix6x6.a43 * dMatrix6x62.a46) + (dMatrix6x6.a53 * dMatrix6x62.a56) + (dMatrix6x6.a63 * dMatrix6x62.a66);
        dMatrix6x63.a41 = (dMatrix6x6.a14 * dMatrix6x62.a11) + (dMatrix6x6.a24 * dMatrix6x62.a21) + (dMatrix6x6.a34 * dMatrix6x62.a31) + (dMatrix6x6.a44 * dMatrix6x62.a41) + (dMatrix6x6.a54 * dMatrix6x62.a51) + (dMatrix6x6.a64 * dMatrix6x62.a61);
        dMatrix6x63.a42 = (dMatrix6x6.a14 * dMatrix6x62.a12) + (dMatrix6x6.a24 * dMatrix6x62.a22) + (dMatrix6x6.a34 * dMatrix6x62.a32) + (dMatrix6x6.a44 * dMatrix6x62.a42) + (dMatrix6x6.a54 * dMatrix6x62.a52) + (dMatrix6x6.a64 * dMatrix6x62.a62);
        dMatrix6x63.a43 = (dMatrix6x6.a14 * dMatrix6x62.a13) + (dMatrix6x6.a24 * dMatrix6x62.a23) + (dMatrix6x6.a34 * dMatrix6x62.a33) + (dMatrix6x6.a44 * dMatrix6x62.a43) + (dMatrix6x6.a54 * dMatrix6x62.a53) + (dMatrix6x6.a64 * dMatrix6x62.a63);
        dMatrix6x63.a44 = (dMatrix6x6.a14 * dMatrix6x62.a14) + (dMatrix6x6.a24 * dMatrix6x62.a24) + (dMatrix6x6.a34 * dMatrix6x62.a34) + (dMatrix6x6.a44 * dMatrix6x62.a44) + (dMatrix6x6.a54 * dMatrix6x62.a54) + (dMatrix6x6.a64 * dMatrix6x62.a64);
        dMatrix6x63.a45 = (dMatrix6x6.a14 * dMatrix6x62.a15) + (dMatrix6x6.a24 * dMatrix6x62.a25) + (dMatrix6x6.a34 * dMatrix6x62.a35) + (dMatrix6x6.a44 * dMatrix6x62.a45) + (dMatrix6x6.a54 * dMatrix6x62.a55) + (dMatrix6x6.a64 * dMatrix6x62.a65);
        dMatrix6x63.a46 = (dMatrix6x6.a14 * dMatrix6x62.a16) + (dMatrix6x6.a24 * dMatrix6x62.a26) + (dMatrix6x6.a34 * dMatrix6x62.a36) + (dMatrix6x6.a44 * dMatrix6x62.a46) + (dMatrix6x6.a54 * dMatrix6x62.a56) + (dMatrix6x6.a64 * dMatrix6x62.a66);
        dMatrix6x63.a51 = (dMatrix6x6.a15 * dMatrix6x62.a11) + (dMatrix6x6.a25 * dMatrix6x62.a21) + (dMatrix6x6.a35 * dMatrix6x62.a31) + (dMatrix6x6.a45 * dMatrix6x62.a41) + (dMatrix6x6.a55 * dMatrix6x62.a51) + (dMatrix6x6.a65 * dMatrix6x62.a61);
        dMatrix6x63.a52 = (dMatrix6x6.a15 * dMatrix6x62.a12) + (dMatrix6x6.a25 * dMatrix6x62.a22) + (dMatrix6x6.a35 * dMatrix6x62.a32) + (dMatrix6x6.a45 * dMatrix6x62.a42) + (dMatrix6x6.a55 * dMatrix6x62.a52) + (dMatrix6x6.a65 * dMatrix6x62.a62);
        dMatrix6x63.a53 = (dMatrix6x6.a15 * dMatrix6x62.a13) + (dMatrix6x6.a25 * dMatrix6x62.a23) + (dMatrix6x6.a35 * dMatrix6x62.a33) + (dMatrix6x6.a45 * dMatrix6x62.a43) + (dMatrix6x6.a55 * dMatrix6x62.a53) + (dMatrix6x6.a65 * dMatrix6x62.a63);
        dMatrix6x63.a54 = (dMatrix6x6.a15 * dMatrix6x62.a14) + (dMatrix6x6.a25 * dMatrix6x62.a24) + (dMatrix6x6.a35 * dMatrix6x62.a34) + (dMatrix6x6.a45 * dMatrix6x62.a44) + (dMatrix6x6.a55 * dMatrix6x62.a54) + (dMatrix6x6.a65 * dMatrix6x62.a64);
        dMatrix6x63.a55 = (dMatrix6x6.a15 * dMatrix6x62.a15) + (dMatrix6x6.a25 * dMatrix6x62.a25) + (dMatrix6x6.a35 * dMatrix6x62.a35) + (dMatrix6x6.a45 * dMatrix6x62.a45) + (dMatrix6x6.a55 * dMatrix6x62.a55) + (dMatrix6x6.a65 * dMatrix6x62.a65);
        dMatrix6x63.a56 = (dMatrix6x6.a15 * dMatrix6x62.a16) + (dMatrix6x6.a25 * dMatrix6x62.a26) + (dMatrix6x6.a35 * dMatrix6x62.a36) + (dMatrix6x6.a45 * dMatrix6x62.a46) + (dMatrix6x6.a55 * dMatrix6x62.a56) + (dMatrix6x6.a65 * dMatrix6x62.a66);
        dMatrix6x63.a61 = (dMatrix6x6.a16 * dMatrix6x62.a11) + (dMatrix6x6.a26 * dMatrix6x62.a21) + (dMatrix6x6.a36 * dMatrix6x62.a31) + (dMatrix6x6.a46 * dMatrix6x62.a41) + (dMatrix6x6.a56 * dMatrix6x62.a51) + (dMatrix6x6.a66 * dMatrix6x62.a61);
        dMatrix6x63.a62 = (dMatrix6x6.a16 * dMatrix6x62.a12) + (dMatrix6x6.a26 * dMatrix6x62.a22) + (dMatrix6x6.a36 * dMatrix6x62.a32) + (dMatrix6x6.a46 * dMatrix6x62.a42) + (dMatrix6x6.a56 * dMatrix6x62.a52) + (dMatrix6x6.a66 * dMatrix6x62.a62);
        dMatrix6x63.a63 = (dMatrix6x6.a16 * dMatrix6x62.a13) + (dMatrix6x6.a26 * dMatrix6x62.a23) + (dMatrix6x6.a36 * dMatrix6x62.a33) + (dMatrix6x6.a46 * dMatrix6x62.a43) + (dMatrix6x6.a56 * dMatrix6x62.a53) + (dMatrix6x6.a66 * dMatrix6x62.a63);
        dMatrix6x63.a64 = (dMatrix6x6.a16 * dMatrix6x62.a14) + (dMatrix6x6.a26 * dMatrix6x62.a24) + (dMatrix6x6.a36 * dMatrix6x62.a34) + (dMatrix6x6.a46 * dMatrix6x62.a44) + (dMatrix6x6.a56 * dMatrix6x62.a54) + (dMatrix6x6.a66 * dMatrix6x62.a64);
        dMatrix6x63.a65 = (dMatrix6x6.a16 * dMatrix6x62.a15) + (dMatrix6x6.a26 * dMatrix6x62.a25) + (dMatrix6x6.a36 * dMatrix6x62.a35) + (dMatrix6x6.a46 * dMatrix6x62.a45) + (dMatrix6x6.a56 * dMatrix6x62.a55) + (dMatrix6x6.a66 * dMatrix6x62.a65);
        dMatrix6x63.a66 = (dMatrix6x6.a16 * dMatrix6x62.a16) + (dMatrix6x6.a26 * dMatrix6x62.a26) + (dMatrix6x6.a36 * dMatrix6x62.a36) + (dMatrix6x6.a46 * dMatrix6x62.a46) + (dMatrix6x6.a56 * dMatrix6x62.a56) + (dMatrix6x6.a66 * dMatrix6x62.a66);
    }

    public static void multTransAB(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62, DMatrix6x6 dMatrix6x63) {
        dMatrix6x63.a11 = (dMatrix6x6.a11 * dMatrix6x62.a11) + (dMatrix6x6.a21 * dMatrix6x62.a12) + (dMatrix6x6.a31 * dMatrix6x62.a13) + (dMatrix6x6.a41 * dMatrix6x62.a14) + (dMatrix6x6.a51 * dMatrix6x62.a15) + (dMatrix6x6.a61 * dMatrix6x62.a16);
        dMatrix6x63.a12 = (dMatrix6x6.a11 * dMatrix6x62.a21) + (dMatrix6x6.a21 * dMatrix6x62.a22) + (dMatrix6x6.a31 * dMatrix6x62.a23) + (dMatrix6x6.a41 * dMatrix6x62.a24) + (dMatrix6x6.a51 * dMatrix6x62.a25) + (dMatrix6x6.a61 * dMatrix6x62.a26);
        dMatrix6x63.a13 = (dMatrix6x6.a11 * dMatrix6x62.a31) + (dMatrix6x6.a21 * dMatrix6x62.a32) + (dMatrix6x6.a31 * dMatrix6x62.a33) + (dMatrix6x6.a41 * dMatrix6x62.a34) + (dMatrix6x6.a51 * dMatrix6x62.a35) + (dMatrix6x6.a61 * dMatrix6x62.a36);
        dMatrix6x63.a14 = (dMatrix6x6.a11 * dMatrix6x62.a41) + (dMatrix6x6.a21 * dMatrix6x62.a42) + (dMatrix6x6.a31 * dMatrix6x62.a43) + (dMatrix6x6.a41 * dMatrix6x62.a44) + (dMatrix6x6.a51 * dMatrix6x62.a45) + (dMatrix6x6.a61 * dMatrix6x62.a46);
        dMatrix6x63.a15 = (dMatrix6x6.a11 * dMatrix6x62.a51) + (dMatrix6x6.a21 * dMatrix6x62.a52) + (dMatrix6x6.a31 * dMatrix6x62.a53) + (dMatrix6x6.a41 * dMatrix6x62.a54) + (dMatrix6x6.a51 * dMatrix6x62.a55) + (dMatrix6x6.a61 * dMatrix6x62.a56);
        dMatrix6x63.a16 = (dMatrix6x6.a11 * dMatrix6x62.a61) + (dMatrix6x6.a21 * dMatrix6x62.a62) + (dMatrix6x6.a31 * dMatrix6x62.a63) + (dMatrix6x6.a41 * dMatrix6x62.a64) + (dMatrix6x6.a51 * dMatrix6x62.a65) + (dMatrix6x6.a61 * dMatrix6x62.a66);
        dMatrix6x63.a21 = (dMatrix6x6.a12 * dMatrix6x62.a11) + (dMatrix6x6.a22 * dMatrix6x62.a12) + (dMatrix6x6.a32 * dMatrix6x62.a13) + (dMatrix6x6.a42 * dMatrix6x62.a14) + (dMatrix6x6.a52 * dMatrix6x62.a15) + (dMatrix6x6.a62 * dMatrix6x62.a16);
        dMatrix6x63.a22 = (dMatrix6x6.a12 * dMatrix6x62.a21) + (dMatrix6x6.a22 * dMatrix6x62.a22) + (dMatrix6x6.a32 * dMatrix6x62.a23) + (dMatrix6x6.a42 * dMatrix6x62.a24) + (dMatrix6x6.a52 * dMatrix6x62.a25) + (dMatrix6x6.a62 * dMatrix6x62.a26);
        dMatrix6x63.a23 = (dMatrix6x6.a12 * dMatrix6x62.a31) + (dMatrix6x6.a22 * dMatrix6x62.a32) + (dMatrix6x6.a32 * dMatrix6x62.a33) + (dMatrix6x6.a42 * dMatrix6x62.a34) + (dMatrix6x6.a52 * dMatrix6x62.a35) + (dMatrix6x6.a62 * dMatrix6x62.a36);
        dMatrix6x63.a24 = (dMatrix6x6.a12 * dMatrix6x62.a41) + (dMatrix6x6.a22 * dMatrix6x62.a42) + (dMatrix6x6.a32 * dMatrix6x62.a43) + (dMatrix6x6.a42 * dMatrix6x62.a44) + (dMatrix6x6.a52 * dMatrix6x62.a45) + (dMatrix6x6.a62 * dMatrix6x62.a46);
        dMatrix6x63.a25 = (dMatrix6x6.a12 * dMatrix6x62.a51) + (dMatrix6x6.a22 * dMatrix6x62.a52) + (dMatrix6x6.a32 * dMatrix6x62.a53) + (dMatrix6x6.a42 * dMatrix6x62.a54) + (dMatrix6x6.a52 * dMatrix6x62.a55) + (dMatrix6x6.a62 * dMatrix6x62.a56);
        dMatrix6x63.a26 = (dMatrix6x6.a12 * dMatrix6x62.a61) + (dMatrix6x6.a22 * dMatrix6x62.a62) + (dMatrix6x6.a32 * dMatrix6x62.a63) + (dMatrix6x6.a42 * dMatrix6x62.a64) + (dMatrix6x6.a52 * dMatrix6x62.a65) + (dMatrix6x6.a62 * dMatrix6x62.a66);
        dMatrix6x63.a31 = (dMatrix6x6.a13 * dMatrix6x62.a11) + (dMatrix6x6.a23 * dMatrix6x62.a12) + (dMatrix6x6.a33 * dMatrix6x62.a13) + (dMatrix6x6.a43 * dMatrix6x62.a14) + (dMatrix6x6.a53 * dMatrix6x62.a15) + (dMatrix6x6.a63 * dMatrix6x62.a16);
        dMatrix6x63.a32 = (dMatrix6x6.a13 * dMatrix6x62.a21) + (dMatrix6x6.a23 * dMatrix6x62.a22) + (dMatrix6x6.a33 * dMatrix6x62.a23) + (dMatrix6x6.a43 * dMatrix6x62.a24) + (dMatrix6x6.a53 * dMatrix6x62.a25) + (dMatrix6x6.a63 * dMatrix6x62.a26);
        dMatrix6x63.a33 = (dMatrix6x6.a13 * dMatrix6x62.a31) + (dMatrix6x6.a23 * dMatrix6x62.a32) + (dMatrix6x6.a33 * dMatrix6x62.a33) + (dMatrix6x6.a43 * dMatrix6x62.a34) + (dMatrix6x6.a53 * dMatrix6x62.a35) + (dMatrix6x6.a63 * dMatrix6x62.a36);
        dMatrix6x63.a34 = (dMatrix6x6.a13 * dMatrix6x62.a41) + (dMatrix6x6.a23 * dMatrix6x62.a42) + (dMatrix6x6.a33 * dMatrix6x62.a43) + (dMatrix6x6.a43 * dMatrix6x62.a44) + (dMatrix6x6.a53 * dMatrix6x62.a45) + (dMatrix6x6.a63 * dMatrix6x62.a46);
        dMatrix6x63.a35 = (dMatrix6x6.a13 * dMatrix6x62.a51) + (dMatrix6x6.a23 * dMatrix6x62.a52) + (dMatrix6x6.a33 * dMatrix6x62.a53) + (dMatrix6x6.a43 * dMatrix6x62.a54) + (dMatrix6x6.a53 * dMatrix6x62.a55) + (dMatrix6x6.a63 * dMatrix6x62.a56);
        dMatrix6x63.a36 = (dMatrix6x6.a13 * dMatrix6x62.a61) + (dMatrix6x6.a23 * dMatrix6x62.a62) + (dMatrix6x6.a33 * dMatrix6x62.a63) + (dMatrix6x6.a43 * dMatrix6x62.a64) + (dMatrix6x6.a53 * dMatrix6x62.a65) + (dMatrix6x6.a63 * dMatrix6x62.a66);
        dMatrix6x63.a41 = (dMatrix6x6.a14 * dMatrix6x62.a11) + (dMatrix6x6.a24 * dMatrix6x62.a12) + (dMatrix6x6.a34 * dMatrix6x62.a13) + (dMatrix6x6.a44 * dMatrix6x62.a14) + (dMatrix6x6.a54 * dMatrix6x62.a15) + (dMatrix6x6.a64 * dMatrix6x62.a16);
        dMatrix6x63.a42 = (dMatrix6x6.a14 * dMatrix6x62.a21) + (dMatrix6x6.a24 * dMatrix6x62.a22) + (dMatrix6x6.a34 * dMatrix6x62.a23) + (dMatrix6x6.a44 * dMatrix6x62.a24) + (dMatrix6x6.a54 * dMatrix6x62.a25) + (dMatrix6x6.a64 * dMatrix6x62.a26);
        dMatrix6x63.a43 = (dMatrix6x6.a14 * dMatrix6x62.a31) + (dMatrix6x6.a24 * dMatrix6x62.a32) + (dMatrix6x6.a34 * dMatrix6x62.a33) + (dMatrix6x6.a44 * dMatrix6x62.a34) + (dMatrix6x6.a54 * dMatrix6x62.a35) + (dMatrix6x6.a64 * dMatrix6x62.a36);
        dMatrix6x63.a44 = (dMatrix6x6.a14 * dMatrix6x62.a41) + (dMatrix6x6.a24 * dMatrix6x62.a42) + (dMatrix6x6.a34 * dMatrix6x62.a43) + (dMatrix6x6.a44 * dMatrix6x62.a44) + (dMatrix6x6.a54 * dMatrix6x62.a45) + (dMatrix6x6.a64 * dMatrix6x62.a46);
        dMatrix6x63.a45 = (dMatrix6x6.a14 * dMatrix6x62.a51) + (dMatrix6x6.a24 * dMatrix6x62.a52) + (dMatrix6x6.a34 * dMatrix6x62.a53) + (dMatrix6x6.a44 * dMatrix6x62.a54) + (dMatrix6x6.a54 * dMatrix6x62.a55) + (dMatrix6x6.a64 * dMatrix6x62.a56);
        dMatrix6x63.a46 = (dMatrix6x6.a14 * dMatrix6x62.a61) + (dMatrix6x6.a24 * dMatrix6x62.a62) + (dMatrix6x6.a34 * dMatrix6x62.a63) + (dMatrix6x6.a44 * dMatrix6x62.a64) + (dMatrix6x6.a54 * dMatrix6x62.a65) + (dMatrix6x6.a64 * dMatrix6x62.a66);
        dMatrix6x63.a51 = (dMatrix6x6.a15 * dMatrix6x62.a11) + (dMatrix6x6.a25 * dMatrix6x62.a12) + (dMatrix6x6.a35 * dMatrix6x62.a13) + (dMatrix6x6.a45 * dMatrix6x62.a14) + (dMatrix6x6.a55 * dMatrix6x62.a15) + (dMatrix6x6.a65 * dMatrix6x62.a16);
        dMatrix6x63.a52 = (dMatrix6x6.a15 * dMatrix6x62.a21) + (dMatrix6x6.a25 * dMatrix6x62.a22) + (dMatrix6x6.a35 * dMatrix6x62.a23) + (dMatrix6x6.a45 * dMatrix6x62.a24) + (dMatrix6x6.a55 * dMatrix6x62.a25) + (dMatrix6x6.a65 * dMatrix6x62.a26);
        dMatrix6x63.a53 = (dMatrix6x6.a15 * dMatrix6x62.a31) + (dMatrix6x6.a25 * dMatrix6x62.a32) + (dMatrix6x6.a35 * dMatrix6x62.a33) + (dMatrix6x6.a45 * dMatrix6x62.a34) + (dMatrix6x6.a55 * dMatrix6x62.a35) + (dMatrix6x6.a65 * dMatrix6x62.a36);
        dMatrix6x63.a54 = (dMatrix6x6.a15 * dMatrix6x62.a41) + (dMatrix6x6.a25 * dMatrix6x62.a42) + (dMatrix6x6.a35 * dMatrix6x62.a43) + (dMatrix6x6.a45 * dMatrix6x62.a44) + (dMatrix6x6.a55 * dMatrix6x62.a45) + (dMatrix6x6.a65 * dMatrix6x62.a46);
        dMatrix6x63.a55 = (dMatrix6x6.a15 * dMatrix6x62.a51) + (dMatrix6x6.a25 * dMatrix6x62.a52) + (dMatrix6x6.a35 * dMatrix6x62.a53) + (dMatrix6x6.a45 * dMatrix6x62.a54) + (dMatrix6x6.a55 * dMatrix6x62.a55) + (dMatrix6x6.a65 * dMatrix6x62.a56);
        dMatrix6x63.a56 = (dMatrix6x6.a15 * dMatrix6x62.a61) + (dMatrix6x6.a25 * dMatrix6x62.a62) + (dMatrix6x6.a35 * dMatrix6x62.a63) + (dMatrix6x6.a45 * dMatrix6x62.a64) + (dMatrix6x6.a55 * dMatrix6x62.a65) + (dMatrix6x6.a65 * dMatrix6x62.a66);
        dMatrix6x63.a61 = (dMatrix6x6.a16 * dMatrix6x62.a11) + (dMatrix6x6.a26 * dMatrix6x62.a12) + (dMatrix6x6.a36 * dMatrix6x62.a13) + (dMatrix6x6.a46 * dMatrix6x62.a14) + (dMatrix6x6.a56 * dMatrix6x62.a15) + (dMatrix6x6.a66 * dMatrix6x62.a16);
        dMatrix6x63.a62 = (dMatrix6x6.a16 * dMatrix6x62.a21) + (dMatrix6x6.a26 * dMatrix6x62.a22) + (dMatrix6x6.a36 * dMatrix6x62.a23) + (dMatrix6x6.a46 * dMatrix6x62.a24) + (dMatrix6x6.a56 * dMatrix6x62.a25) + (dMatrix6x6.a66 * dMatrix6x62.a26);
        dMatrix6x63.a63 = (dMatrix6x6.a16 * dMatrix6x62.a31) + (dMatrix6x6.a26 * dMatrix6x62.a32) + (dMatrix6x6.a36 * dMatrix6x62.a33) + (dMatrix6x6.a46 * dMatrix6x62.a34) + (dMatrix6x6.a56 * dMatrix6x62.a35) + (dMatrix6x6.a66 * dMatrix6x62.a36);
        dMatrix6x63.a64 = (dMatrix6x6.a16 * dMatrix6x62.a41) + (dMatrix6x6.a26 * dMatrix6x62.a42) + (dMatrix6x6.a36 * dMatrix6x62.a43) + (dMatrix6x6.a46 * dMatrix6x62.a44) + (dMatrix6x6.a56 * dMatrix6x62.a45) + (dMatrix6x6.a66 * dMatrix6x62.a46);
        dMatrix6x63.a65 = (dMatrix6x6.a16 * dMatrix6x62.a51) + (dMatrix6x6.a26 * dMatrix6x62.a52) + (dMatrix6x6.a36 * dMatrix6x62.a53) + (dMatrix6x6.a46 * dMatrix6x62.a54) + (dMatrix6x6.a56 * dMatrix6x62.a55) + (dMatrix6x6.a66 * dMatrix6x62.a56);
        dMatrix6x63.a66 = (dMatrix6x6.a16 * dMatrix6x62.a61) + (dMatrix6x6.a26 * dMatrix6x62.a62) + (dMatrix6x6.a36 * dMatrix6x62.a63) + (dMatrix6x6.a46 * dMatrix6x62.a64) + (dMatrix6x6.a56 * dMatrix6x62.a65) + (dMatrix6x6.a66 * dMatrix6x62.a66);
    }

    public static void multTransB(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62, DMatrix6x6 dMatrix6x63) {
        dMatrix6x63.a11 = (dMatrix6x6.a11 * dMatrix6x62.a11) + (dMatrix6x6.a12 * dMatrix6x62.a12) + (dMatrix6x6.a13 * dMatrix6x62.a13) + (dMatrix6x6.a14 * dMatrix6x62.a14) + (dMatrix6x6.a15 * dMatrix6x62.a15) + (dMatrix6x6.a16 * dMatrix6x62.a16);
        dMatrix6x63.a12 = (dMatrix6x6.a11 * dMatrix6x62.a21) + (dMatrix6x6.a12 * dMatrix6x62.a22) + (dMatrix6x6.a13 * dMatrix6x62.a23) + (dMatrix6x6.a14 * dMatrix6x62.a24) + (dMatrix6x6.a15 * dMatrix6x62.a25) + (dMatrix6x6.a16 * dMatrix6x62.a26);
        dMatrix6x63.a13 = (dMatrix6x6.a11 * dMatrix6x62.a31) + (dMatrix6x6.a12 * dMatrix6x62.a32) + (dMatrix6x6.a13 * dMatrix6x62.a33) + (dMatrix6x6.a14 * dMatrix6x62.a34) + (dMatrix6x6.a15 * dMatrix6x62.a35) + (dMatrix6x6.a16 * dMatrix6x62.a36);
        dMatrix6x63.a14 = (dMatrix6x6.a11 * dMatrix6x62.a41) + (dMatrix6x6.a12 * dMatrix6x62.a42) + (dMatrix6x6.a13 * dMatrix6x62.a43) + (dMatrix6x6.a14 * dMatrix6x62.a44) + (dMatrix6x6.a15 * dMatrix6x62.a45) + (dMatrix6x6.a16 * dMatrix6x62.a46);
        dMatrix6x63.a15 = (dMatrix6x6.a11 * dMatrix6x62.a51) + (dMatrix6x6.a12 * dMatrix6x62.a52) + (dMatrix6x6.a13 * dMatrix6x62.a53) + (dMatrix6x6.a14 * dMatrix6x62.a54) + (dMatrix6x6.a15 * dMatrix6x62.a55) + (dMatrix6x6.a16 * dMatrix6x62.a56);
        dMatrix6x63.a16 = (dMatrix6x6.a11 * dMatrix6x62.a61) + (dMatrix6x6.a12 * dMatrix6x62.a62) + (dMatrix6x6.a13 * dMatrix6x62.a63) + (dMatrix6x6.a14 * dMatrix6x62.a64) + (dMatrix6x6.a15 * dMatrix6x62.a65) + (dMatrix6x6.a16 * dMatrix6x62.a66);
        dMatrix6x63.a21 = (dMatrix6x6.a21 * dMatrix6x62.a11) + (dMatrix6x6.a22 * dMatrix6x62.a12) + (dMatrix6x6.a23 * dMatrix6x62.a13) + (dMatrix6x6.a24 * dMatrix6x62.a14) + (dMatrix6x6.a25 * dMatrix6x62.a15) + (dMatrix6x6.a26 * dMatrix6x62.a16);
        dMatrix6x63.a22 = (dMatrix6x6.a21 * dMatrix6x62.a21) + (dMatrix6x6.a22 * dMatrix6x62.a22) + (dMatrix6x6.a23 * dMatrix6x62.a23) + (dMatrix6x6.a24 * dMatrix6x62.a24) + (dMatrix6x6.a25 * dMatrix6x62.a25) + (dMatrix6x6.a26 * dMatrix6x62.a26);
        dMatrix6x63.a23 = (dMatrix6x6.a21 * dMatrix6x62.a31) + (dMatrix6x6.a22 * dMatrix6x62.a32) + (dMatrix6x6.a23 * dMatrix6x62.a33) + (dMatrix6x6.a24 * dMatrix6x62.a34) + (dMatrix6x6.a25 * dMatrix6x62.a35) + (dMatrix6x6.a26 * dMatrix6x62.a36);
        dMatrix6x63.a24 = (dMatrix6x6.a21 * dMatrix6x62.a41) + (dMatrix6x6.a22 * dMatrix6x62.a42) + (dMatrix6x6.a23 * dMatrix6x62.a43) + (dMatrix6x6.a24 * dMatrix6x62.a44) + (dMatrix6x6.a25 * dMatrix6x62.a45) + (dMatrix6x6.a26 * dMatrix6x62.a46);
        dMatrix6x63.a25 = (dMatrix6x6.a21 * dMatrix6x62.a51) + (dMatrix6x6.a22 * dMatrix6x62.a52) + (dMatrix6x6.a23 * dMatrix6x62.a53) + (dMatrix6x6.a24 * dMatrix6x62.a54) + (dMatrix6x6.a25 * dMatrix6x62.a55) + (dMatrix6x6.a26 * dMatrix6x62.a56);
        dMatrix6x63.a26 = (dMatrix6x6.a21 * dMatrix6x62.a61) + (dMatrix6x6.a22 * dMatrix6x62.a62) + (dMatrix6x6.a23 * dMatrix6x62.a63) + (dMatrix6x6.a24 * dMatrix6x62.a64) + (dMatrix6x6.a25 * dMatrix6x62.a65) + (dMatrix6x6.a26 * dMatrix6x62.a66);
        dMatrix6x63.a31 = (dMatrix6x6.a31 * dMatrix6x62.a11) + (dMatrix6x6.a32 * dMatrix6x62.a12) + (dMatrix6x6.a33 * dMatrix6x62.a13) + (dMatrix6x6.a34 * dMatrix6x62.a14) + (dMatrix6x6.a35 * dMatrix6x62.a15) + (dMatrix6x6.a36 * dMatrix6x62.a16);
        dMatrix6x63.a32 = (dMatrix6x6.a31 * dMatrix6x62.a21) + (dMatrix6x6.a32 * dMatrix6x62.a22) + (dMatrix6x6.a33 * dMatrix6x62.a23) + (dMatrix6x6.a34 * dMatrix6x62.a24) + (dMatrix6x6.a35 * dMatrix6x62.a25) + (dMatrix6x6.a36 * dMatrix6x62.a26);
        dMatrix6x63.a33 = (dMatrix6x6.a31 * dMatrix6x62.a31) + (dMatrix6x6.a32 * dMatrix6x62.a32) + (dMatrix6x6.a33 * dMatrix6x62.a33) + (dMatrix6x6.a34 * dMatrix6x62.a34) + (dMatrix6x6.a35 * dMatrix6x62.a35) + (dMatrix6x6.a36 * dMatrix6x62.a36);
        dMatrix6x63.a34 = (dMatrix6x6.a31 * dMatrix6x62.a41) + (dMatrix6x6.a32 * dMatrix6x62.a42) + (dMatrix6x6.a33 * dMatrix6x62.a43) + (dMatrix6x6.a34 * dMatrix6x62.a44) + (dMatrix6x6.a35 * dMatrix6x62.a45) + (dMatrix6x6.a36 * dMatrix6x62.a46);
        dMatrix6x63.a35 = (dMatrix6x6.a31 * dMatrix6x62.a51) + (dMatrix6x6.a32 * dMatrix6x62.a52) + (dMatrix6x6.a33 * dMatrix6x62.a53) + (dMatrix6x6.a34 * dMatrix6x62.a54) + (dMatrix6x6.a35 * dMatrix6x62.a55) + (dMatrix6x6.a36 * dMatrix6x62.a56);
        dMatrix6x63.a36 = (dMatrix6x6.a31 * dMatrix6x62.a61) + (dMatrix6x6.a32 * dMatrix6x62.a62) + (dMatrix6x6.a33 * dMatrix6x62.a63) + (dMatrix6x6.a34 * dMatrix6x62.a64) + (dMatrix6x6.a35 * dMatrix6x62.a65) + (dMatrix6x6.a36 * dMatrix6x62.a66);
        dMatrix6x63.a41 = (dMatrix6x6.a41 * dMatrix6x62.a11) + (dMatrix6x6.a42 * dMatrix6x62.a12) + (dMatrix6x6.a43 * dMatrix6x62.a13) + (dMatrix6x6.a44 * dMatrix6x62.a14) + (dMatrix6x6.a45 * dMatrix6x62.a15) + (dMatrix6x6.a46 * dMatrix6x62.a16);
        dMatrix6x63.a42 = (dMatrix6x6.a41 * dMatrix6x62.a21) + (dMatrix6x6.a42 * dMatrix6x62.a22) + (dMatrix6x6.a43 * dMatrix6x62.a23) + (dMatrix6x6.a44 * dMatrix6x62.a24) + (dMatrix6x6.a45 * dMatrix6x62.a25) + (dMatrix6x6.a46 * dMatrix6x62.a26);
        dMatrix6x63.a43 = (dMatrix6x6.a41 * dMatrix6x62.a31) + (dMatrix6x6.a42 * dMatrix6x62.a32) + (dMatrix6x6.a43 * dMatrix6x62.a33) + (dMatrix6x6.a44 * dMatrix6x62.a34) + (dMatrix6x6.a45 * dMatrix6x62.a35) + (dMatrix6x6.a46 * dMatrix6x62.a36);
        dMatrix6x63.a44 = (dMatrix6x6.a41 * dMatrix6x62.a41) + (dMatrix6x6.a42 * dMatrix6x62.a42) + (dMatrix6x6.a43 * dMatrix6x62.a43) + (dMatrix6x6.a44 * dMatrix6x62.a44) + (dMatrix6x6.a45 * dMatrix6x62.a45) + (dMatrix6x6.a46 * dMatrix6x62.a46);
        dMatrix6x63.a45 = (dMatrix6x6.a41 * dMatrix6x62.a51) + (dMatrix6x6.a42 * dMatrix6x62.a52) + (dMatrix6x6.a43 * dMatrix6x62.a53) + (dMatrix6x6.a44 * dMatrix6x62.a54) + (dMatrix6x6.a45 * dMatrix6x62.a55) + (dMatrix6x6.a46 * dMatrix6x62.a56);
        dMatrix6x63.a46 = (dMatrix6x6.a41 * dMatrix6x62.a61) + (dMatrix6x6.a42 * dMatrix6x62.a62) + (dMatrix6x6.a43 * dMatrix6x62.a63) + (dMatrix6x6.a44 * dMatrix6x62.a64) + (dMatrix6x6.a45 * dMatrix6x62.a65) + (dMatrix6x6.a46 * dMatrix6x62.a66);
        dMatrix6x63.a51 = (dMatrix6x6.a51 * dMatrix6x62.a11) + (dMatrix6x6.a52 * dMatrix6x62.a12) + (dMatrix6x6.a53 * dMatrix6x62.a13) + (dMatrix6x6.a54 * dMatrix6x62.a14) + (dMatrix6x6.a55 * dMatrix6x62.a15) + (dMatrix6x6.a56 * dMatrix6x62.a16);
        dMatrix6x63.a52 = (dMatrix6x6.a51 * dMatrix6x62.a21) + (dMatrix6x6.a52 * dMatrix6x62.a22) + (dMatrix6x6.a53 * dMatrix6x62.a23) + (dMatrix6x6.a54 * dMatrix6x62.a24) + (dMatrix6x6.a55 * dMatrix6x62.a25) + (dMatrix6x6.a56 * dMatrix6x62.a26);
        dMatrix6x63.a53 = (dMatrix6x6.a51 * dMatrix6x62.a31) + (dMatrix6x6.a52 * dMatrix6x62.a32) + (dMatrix6x6.a53 * dMatrix6x62.a33) + (dMatrix6x6.a54 * dMatrix6x62.a34) + (dMatrix6x6.a55 * dMatrix6x62.a35) + (dMatrix6x6.a56 * dMatrix6x62.a36);
        dMatrix6x63.a54 = (dMatrix6x6.a51 * dMatrix6x62.a41) + (dMatrix6x6.a52 * dMatrix6x62.a42) + (dMatrix6x6.a53 * dMatrix6x62.a43) + (dMatrix6x6.a54 * dMatrix6x62.a44) + (dMatrix6x6.a55 * dMatrix6x62.a45) + (dMatrix6x6.a56 * dMatrix6x62.a46);
        dMatrix6x63.a55 = (dMatrix6x6.a51 * dMatrix6x62.a51) + (dMatrix6x6.a52 * dMatrix6x62.a52) + (dMatrix6x6.a53 * dMatrix6x62.a53) + (dMatrix6x6.a54 * dMatrix6x62.a54) + (dMatrix6x6.a55 * dMatrix6x62.a55) + (dMatrix6x6.a56 * dMatrix6x62.a56);
        dMatrix6x63.a56 = (dMatrix6x6.a51 * dMatrix6x62.a61) + (dMatrix6x6.a52 * dMatrix6x62.a62) + (dMatrix6x6.a53 * dMatrix6x62.a63) + (dMatrix6x6.a54 * dMatrix6x62.a64) + (dMatrix6x6.a55 * dMatrix6x62.a65) + (dMatrix6x6.a56 * dMatrix6x62.a66);
        dMatrix6x63.a61 = (dMatrix6x6.a61 * dMatrix6x62.a11) + (dMatrix6x6.a62 * dMatrix6x62.a12) + (dMatrix6x6.a63 * dMatrix6x62.a13) + (dMatrix6x6.a64 * dMatrix6x62.a14) + (dMatrix6x6.a65 * dMatrix6x62.a15) + (dMatrix6x6.a66 * dMatrix6x62.a16);
        dMatrix6x63.a62 = (dMatrix6x6.a61 * dMatrix6x62.a21) + (dMatrix6x6.a62 * dMatrix6x62.a22) + (dMatrix6x6.a63 * dMatrix6x62.a23) + (dMatrix6x6.a64 * dMatrix6x62.a24) + (dMatrix6x6.a65 * dMatrix6x62.a25) + (dMatrix6x6.a66 * dMatrix6x62.a26);
        dMatrix6x63.a63 = (dMatrix6x6.a61 * dMatrix6x62.a31) + (dMatrix6x6.a62 * dMatrix6x62.a32) + (dMatrix6x6.a63 * dMatrix6x62.a33) + (dMatrix6x6.a64 * dMatrix6x62.a34) + (dMatrix6x6.a65 * dMatrix6x62.a35) + (dMatrix6x6.a66 * dMatrix6x62.a36);
        dMatrix6x63.a64 = (dMatrix6x6.a61 * dMatrix6x62.a41) + (dMatrix6x6.a62 * dMatrix6x62.a42) + (dMatrix6x6.a63 * dMatrix6x62.a43) + (dMatrix6x6.a64 * dMatrix6x62.a44) + (dMatrix6x6.a65 * dMatrix6x62.a45) + (dMatrix6x6.a66 * dMatrix6x62.a46);
        dMatrix6x63.a65 = (dMatrix6x6.a61 * dMatrix6x62.a51) + (dMatrix6x6.a62 * dMatrix6x62.a52) + (dMatrix6x6.a63 * dMatrix6x62.a53) + (dMatrix6x6.a64 * dMatrix6x62.a54) + (dMatrix6x6.a65 * dMatrix6x62.a55) + (dMatrix6x6.a66 * dMatrix6x62.a56);
        dMatrix6x63.a66 = (dMatrix6x6.a61 * dMatrix6x62.a61) + (dMatrix6x6.a62 * dMatrix6x62.a62) + (dMatrix6x6.a63 * dMatrix6x62.a63) + (dMatrix6x6.a64 * dMatrix6x62.a64) + (dMatrix6x6.a65 * dMatrix6x62.a65) + (dMatrix6x6.a66 * dMatrix6x62.a66);
    }

    public static void multAdd(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62, DMatrix6x6 dMatrix6x63) {
        dMatrix6x63.a11 += (dMatrix6x6.a11 * dMatrix6x62.a11) + (dMatrix6x6.a12 * dMatrix6x62.a21) + (dMatrix6x6.a13 * dMatrix6x62.a31) + (dMatrix6x6.a14 * dMatrix6x62.a41) + (dMatrix6x6.a15 * dMatrix6x62.a51) + (dMatrix6x6.a16 * dMatrix6x62.a61);
        dMatrix6x63.a12 += (dMatrix6x6.a11 * dMatrix6x62.a12) + (dMatrix6x6.a12 * dMatrix6x62.a22) + (dMatrix6x6.a13 * dMatrix6x62.a32) + (dMatrix6x6.a14 * dMatrix6x62.a42) + (dMatrix6x6.a15 * dMatrix6x62.a52) + (dMatrix6x6.a16 * dMatrix6x62.a62);
        dMatrix6x63.a13 += (dMatrix6x6.a11 * dMatrix6x62.a13) + (dMatrix6x6.a12 * dMatrix6x62.a23) + (dMatrix6x6.a13 * dMatrix6x62.a33) + (dMatrix6x6.a14 * dMatrix6x62.a43) + (dMatrix6x6.a15 * dMatrix6x62.a53) + (dMatrix6x6.a16 * dMatrix6x62.a63);
        dMatrix6x63.a14 += (dMatrix6x6.a11 * dMatrix6x62.a14) + (dMatrix6x6.a12 * dMatrix6x62.a24) + (dMatrix6x6.a13 * dMatrix6x62.a34) + (dMatrix6x6.a14 * dMatrix6x62.a44) + (dMatrix6x6.a15 * dMatrix6x62.a54) + (dMatrix6x6.a16 * dMatrix6x62.a64);
        dMatrix6x63.a15 += (dMatrix6x6.a11 * dMatrix6x62.a15) + (dMatrix6x6.a12 * dMatrix6x62.a25) + (dMatrix6x6.a13 * dMatrix6x62.a35) + (dMatrix6x6.a14 * dMatrix6x62.a45) + (dMatrix6x6.a15 * dMatrix6x62.a55) + (dMatrix6x6.a16 * dMatrix6x62.a65);
        dMatrix6x63.a16 += (dMatrix6x6.a11 * dMatrix6x62.a16) + (dMatrix6x6.a12 * dMatrix6x62.a26) + (dMatrix6x6.a13 * dMatrix6x62.a36) + (dMatrix6x6.a14 * dMatrix6x62.a46) + (dMatrix6x6.a15 * dMatrix6x62.a56) + (dMatrix6x6.a16 * dMatrix6x62.a66);
        dMatrix6x63.a21 += (dMatrix6x6.a21 * dMatrix6x62.a11) + (dMatrix6x6.a22 * dMatrix6x62.a21) + (dMatrix6x6.a23 * dMatrix6x62.a31) + (dMatrix6x6.a24 * dMatrix6x62.a41) + (dMatrix6x6.a25 * dMatrix6x62.a51) + (dMatrix6x6.a26 * dMatrix6x62.a61);
        dMatrix6x63.a22 += (dMatrix6x6.a21 * dMatrix6x62.a12) + (dMatrix6x6.a22 * dMatrix6x62.a22) + (dMatrix6x6.a23 * dMatrix6x62.a32) + (dMatrix6x6.a24 * dMatrix6x62.a42) + (dMatrix6x6.a25 * dMatrix6x62.a52) + (dMatrix6x6.a26 * dMatrix6x62.a62);
        dMatrix6x63.a23 += (dMatrix6x6.a21 * dMatrix6x62.a13) + (dMatrix6x6.a22 * dMatrix6x62.a23) + (dMatrix6x6.a23 * dMatrix6x62.a33) + (dMatrix6x6.a24 * dMatrix6x62.a43) + (dMatrix6x6.a25 * dMatrix6x62.a53) + (dMatrix6x6.a26 * dMatrix6x62.a63);
        dMatrix6x63.a24 += (dMatrix6x6.a21 * dMatrix6x62.a14) + (dMatrix6x6.a22 * dMatrix6x62.a24) + (dMatrix6x6.a23 * dMatrix6x62.a34) + (dMatrix6x6.a24 * dMatrix6x62.a44) + (dMatrix6x6.a25 * dMatrix6x62.a54) + (dMatrix6x6.a26 * dMatrix6x62.a64);
        dMatrix6x63.a25 += (dMatrix6x6.a21 * dMatrix6x62.a15) + (dMatrix6x6.a22 * dMatrix6x62.a25) + (dMatrix6x6.a23 * dMatrix6x62.a35) + (dMatrix6x6.a24 * dMatrix6x62.a45) + (dMatrix6x6.a25 * dMatrix6x62.a55) + (dMatrix6x6.a26 * dMatrix6x62.a65);
        dMatrix6x63.a26 += (dMatrix6x6.a21 * dMatrix6x62.a16) + (dMatrix6x6.a22 * dMatrix6x62.a26) + (dMatrix6x6.a23 * dMatrix6x62.a36) + (dMatrix6x6.a24 * dMatrix6x62.a46) + (dMatrix6x6.a25 * dMatrix6x62.a56) + (dMatrix6x6.a26 * dMatrix6x62.a66);
        dMatrix6x63.a31 += (dMatrix6x6.a31 * dMatrix6x62.a11) + (dMatrix6x6.a32 * dMatrix6x62.a21) + (dMatrix6x6.a33 * dMatrix6x62.a31) + (dMatrix6x6.a34 * dMatrix6x62.a41) + (dMatrix6x6.a35 * dMatrix6x62.a51) + (dMatrix6x6.a36 * dMatrix6x62.a61);
        dMatrix6x63.a32 += (dMatrix6x6.a31 * dMatrix6x62.a12) + (dMatrix6x6.a32 * dMatrix6x62.a22) + (dMatrix6x6.a33 * dMatrix6x62.a32) + (dMatrix6x6.a34 * dMatrix6x62.a42) + (dMatrix6x6.a35 * dMatrix6x62.a52) + (dMatrix6x6.a36 * dMatrix6x62.a62);
        dMatrix6x63.a33 += (dMatrix6x6.a31 * dMatrix6x62.a13) + (dMatrix6x6.a32 * dMatrix6x62.a23) + (dMatrix6x6.a33 * dMatrix6x62.a33) + (dMatrix6x6.a34 * dMatrix6x62.a43) + (dMatrix6x6.a35 * dMatrix6x62.a53) + (dMatrix6x6.a36 * dMatrix6x62.a63);
        dMatrix6x63.a34 += (dMatrix6x6.a31 * dMatrix6x62.a14) + (dMatrix6x6.a32 * dMatrix6x62.a24) + (dMatrix6x6.a33 * dMatrix6x62.a34) + (dMatrix6x6.a34 * dMatrix6x62.a44) + (dMatrix6x6.a35 * dMatrix6x62.a54) + (dMatrix6x6.a36 * dMatrix6x62.a64);
        dMatrix6x63.a35 += (dMatrix6x6.a31 * dMatrix6x62.a15) + (dMatrix6x6.a32 * dMatrix6x62.a25) + (dMatrix6x6.a33 * dMatrix6x62.a35) + (dMatrix6x6.a34 * dMatrix6x62.a45) + (dMatrix6x6.a35 * dMatrix6x62.a55) + (dMatrix6x6.a36 * dMatrix6x62.a65);
        dMatrix6x63.a36 += (dMatrix6x6.a31 * dMatrix6x62.a16) + (dMatrix6x6.a32 * dMatrix6x62.a26) + (dMatrix6x6.a33 * dMatrix6x62.a36) + (dMatrix6x6.a34 * dMatrix6x62.a46) + (dMatrix6x6.a35 * dMatrix6x62.a56) + (dMatrix6x6.a36 * dMatrix6x62.a66);
        dMatrix6x63.a41 += (dMatrix6x6.a41 * dMatrix6x62.a11) + (dMatrix6x6.a42 * dMatrix6x62.a21) + (dMatrix6x6.a43 * dMatrix6x62.a31) + (dMatrix6x6.a44 * dMatrix6x62.a41) + (dMatrix6x6.a45 * dMatrix6x62.a51) + (dMatrix6x6.a46 * dMatrix6x62.a61);
        dMatrix6x63.a42 += (dMatrix6x6.a41 * dMatrix6x62.a12) + (dMatrix6x6.a42 * dMatrix6x62.a22) + (dMatrix6x6.a43 * dMatrix6x62.a32) + (dMatrix6x6.a44 * dMatrix6x62.a42) + (dMatrix6x6.a45 * dMatrix6x62.a52) + (dMatrix6x6.a46 * dMatrix6x62.a62);
        dMatrix6x63.a43 += (dMatrix6x6.a41 * dMatrix6x62.a13) + (dMatrix6x6.a42 * dMatrix6x62.a23) + (dMatrix6x6.a43 * dMatrix6x62.a33) + (dMatrix6x6.a44 * dMatrix6x62.a43) + (dMatrix6x6.a45 * dMatrix6x62.a53) + (dMatrix6x6.a46 * dMatrix6x62.a63);
        dMatrix6x63.a44 += (dMatrix6x6.a41 * dMatrix6x62.a14) + (dMatrix6x6.a42 * dMatrix6x62.a24) + (dMatrix6x6.a43 * dMatrix6x62.a34) + (dMatrix6x6.a44 * dMatrix6x62.a44) + (dMatrix6x6.a45 * dMatrix6x62.a54) + (dMatrix6x6.a46 * dMatrix6x62.a64);
        dMatrix6x63.a45 += (dMatrix6x6.a41 * dMatrix6x62.a15) + (dMatrix6x6.a42 * dMatrix6x62.a25) + (dMatrix6x6.a43 * dMatrix6x62.a35) + (dMatrix6x6.a44 * dMatrix6x62.a45) + (dMatrix6x6.a45 * dMatrix6x62.a55) + (dMatrix6x6.a46 * dMatrix6x62.a65);
        dMatrix6x63.a46 += (dMatrix6x6.a41 * dMatrix6x62.a16) + (dMatrix6x6.a42 * dMatrix6x62.a26) + (dMatrix6x6.a43 * dMatrix6x62.a36) + (dMatrix6x6.a44 * dMatrix6x62.a46) + (dMatrix6x6.a45 * dMatrix6x62.a56) + (dMatrix6x6.a46 * dMatrix6x62.a66);
        dMatrix6x63.a51 += (dMatrix6x6.a51 * dMatrix6x62.a11) + (dMatrix6x6.a52 * dMatrix6x62.a21) + (dMatrix6x6.a53 * dMatrix6x62.a31) + (dMatrix6x6.a54 * dMatrix6x62.a41) + (dMatrix6x6.a55 * dMatrix6x62.a51) + (dMatrix6x6.a56 * dMatrix6x62.a61);
        dMatrix6x63.a52 += (dMatrix6x6.a51 * dMatrix6x62.a12) + (dMatrix6x6.a52 * dMatrix6x62.a22) + (dMatrix6x6.a53 * dMatrix6x62.a32) + (dMatrix6x6.a54 * dMatrix6x62.a42) + (dMatrix6x6.a55 * dMatrix6x62.a52) + (dMatrix6x6.a56 * dMatrix6x62.a62);
        dMatrix6x63.a53 += (dMatrix6x6.a51 * dMatrix6x62.a13) + (dMatrix6x6.a52 * dMatrix6x62.a23) + (dMatrix6x6.a53 * dMatrix6x62.a33) + (dMatrix6x6.a54 * dMatrix6x62.a43) + (dMatrix6x6.a55 * dMatrix6x62.a53) + (dMatrix6x6.a56 * dMatrix6x62.a63);
        dMatrix6x63.a54 += (dMatrix6x6.a51 * dMatrix6x62.a14) + (dMatrix6x6.a52 * dMatrix6x62.a24) + (dMatrix6x6.a53 * dMatrix6x62.a34) + (dMatrix6x6.a54 * dMatrix6x62.a44) + (dMatrix6x6.a55 * dMatrix6x62.a54) + (dMatrix6x6.a56 * dMatrix6x62.a64);
        dMatrix6x63.a55 += (dMatrix6x6.a51 * dMatrix6x62.a15) + (dMatrix6x6.a52 * dMatrix6x62.a25) + (dMatrix6x6.a53 * dMatrix6x62.a35) + (dMatrix6x6.a54 * dMatrix6x62.a45) + (dMatrix6x6.a55 * dMatrix6x62.a55) + (dMatrix6x6.a56 * dMatrix6x62.a65);
        dMatrix6x63.a56 += (dMatrix6x6.a51 * dMatrix6x62.a16) + (dMatrix6x6.a52 * dMatrix6x62.a26) + (dMatrix6x6.a53 * dMatrix6x62.a36) + (dMatrix6x6.a54 * dMatrix6x62.a46) + (dMatrix6x6.a55 * dMatrix6x62.a56) + (dMatrix6x6.a56 * dMatrix6x62.a66);
        dMatrix6x63.a61 += (dMatrix6x6.a61 * dMatrix6x62.a11) + (dMatrix6x6.a62 * dMatrix6x62.a21) + (dMatrix6x6.a63 * dMatrix6x62.a31) + (dMatrix6x6.a64 * dMatrix6x62.a41) + (dMatrix6x6.a65 * dMatrix6x62.a51) + (dMatrix6x6.a66 * dMatrix6x62.a61);
        dMatrix6x63.a62 += (dMatrix6x6.a61 * dMatrix6x62.a12) + (dMatrix6x6.a62 * dMatrix6x62.a22) + (dMatrix6x6.a63 * dMatrix6x62.a32) + (dMatrix6x6.a64 * dMatrix6x62.a42) + (dMatrix6x6.a65 * dMatrix6x62.a52) + (dMatrix6x6.a66 * dMatrix6x62.a62);
        dMatrix6x63.a63 += (dMatrix6x6.a61 * dMatrix6x62.a13) + (dMatrix6x6.a62 * dMatrix6x62.a23) + (dMatrix6x6.a63 * dMatrix6x62.a33) + (dMatrix6x6.a64 * dMatrix6x62.a43) + (dMatrix6x6.a65 * dMatrix6x62.a53) + (dMatrix6x6.a66 * dMatrix6x62.a63);
        dMatrix6x63.a64 += (dMatrix6x6.a61 * dMatrix6x62.a14) + (dMatrix6x6.a62 * dMatrix6x62.a24) + (dMatrix6x6.a63 * dMatrix6x62.a34) + (dMatrix6x6.a64 * dMatrix6x62.a44) + (dMatrix6x6.a65 * dMatrix6x62.a54) + (dMatrix6x6.a66 * dMatrix6x62.a64);
        dMatrix6x63.a65 += (dMatrix6x6.a61 * dMatrix6x62.a15) + (dMatrix6x6.a62 * dMatrix6x62.a25) + (dMatrix6x6.a63 * dMatrix6x62.a35) + (dMatrix6x6.a64 * dMatrix6x62.a45) + (dMatrix6x6.a65 * dMatrix6x62.a55) + (dMatrix6x6.a66 * dMatrix6x62.a65);
        dMatrix6x63.a66 += (dMatrix6x6.a61 * dMatrix6x62.a16) + (dMatrix6x6.a62 * dMatrix6x62.a26) + (dMatrix6x6.a63 * dMatrix6x62.a36) + (dMatrix6x6.a64 * dMatrix6x62.a46) + (dMatrix6x6.a65 * dMatrix6x62.a56) + (dMatrix6x6.a66 * dMatrix6x62.a66);
    }

    public static void multAddTransA(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62, DMatrix6x6 dMatrix6x63) {
        dMatrix6x63.a11 += (dMatrix6x6.a11 * dMatrix6x62.a11) + (dMatrix6x6.a21 * dMatrix6x62.a21) + (dMatrix6x6.a31 * dMatrix6x62.a31) + (dMatrix6x6.a41 * dMatrix6x62.a41) + (dMatrix6x6.a51 * dMatrix6x62.a51) + (dMatrix6x6.a61 * dMatrix6x62.a61);
        dMatrix6x63.a12 += (dMatrix6x6.a11 * dMatrix6x62.a12) + (dMatrix6x6.a21 * dMatrix6x62.a22) + (dMatrix6x6.a31 * dMatrix6x62.a32) + (dMatrix6x6.a41 * dMatrix6x62.a42) + (dMatrix6x6.a51 * dMatrix6x62.a52) + (dMatrix6x6.a61 * dMatrix6x62.a62);
        dMatrix6x63.a13 += (dMatrix6x6.a11 * dMatrix6x62.a13) + (dMatrix6x6.a21 * dMatrix6x62.a23) + (dMatrix6x6.a31 * dMatrix6x62.a33) + (dMatrix6x6.a41 * dMatrix6x62.a43) + (dMatrix6x6.a51 * dMatrix6x62.a53) + (dMatrix6x6.a61 * dMatrix6x62.a63);
        dMatrix6x63.a14 += (dMatrix6x6.a11 * dMatrix6x62.a14) + (dMatrix6x6.a21 * dMatrix6x62.a24) + (dMatrix6x6.a31 * dMatrix6x62.a34) + (dMatrix6x6.a41 * dMatrix6x62.a44) + (dMatrix6x6.a51 * dMatrix6x62.a54) + (dMatrix6x6.a61 * dMatrix6x62.a64);
        dMatrix6x63.a15 += (dMatrix6x6.a11 * dMatrix6x62.a15) + (dMatrix6x6.a21 * dMatrix6x62.a25) + (dMatrix6x6.a31 * dMatrix6x62.a35) + (dMatrix6x6.a41 * dMatrix6x62.a45) + (dMatrix6x6.a51 * dMatrix6x62.a55) + (dMatrix6x6.a61 * dMatrix6x62.a65);
        dMatrix6x63.a16 += (dMatrix6x6.a11 * dMatrix6x62.a16) + (dMatrix6x6.a21 * dMatrix6x62.a26) + (dMatrix6x6.a31 * dMatrix6x62.a36) + (dMatrix6x6.a41 * dMatrix6x62.a46) + (dMatrix6x6.a51 * dMatrix6x62.a56) + (dMatrix6x6.a61 * dMatrix6x62.a66);
        dMatrix6x63.a21 += (dMatrix6x6.a12 * dMatrix6x62.a11) + (dMatrix6x6.a22 * dMatrix6x62.a21) + (dMatrix6x6.a32 * dMatrix6x62.a31) + (dMatrix6x6.a42 * dMatrix6x62.a41) + (dMatrix6x6.a52 * dMatrix6x62.a51) + (dMatrix6x6.a62 * dMatrix6x62.a61);
        dMatrix6x63.a22 += (dMatrix6x6.a12 * dMatrix6x62.a12) + (dMatrix6x6.a22 * dMatrix6x62.a22) + (dMatrix6x6.a32 * dMatrix6x62.a32) + (dMatrix6x6.a42 * dMatrix6x62.a42) + (dMatrix6x6.a52 * dMatrix6x62.a52) + (dMatrix6x6.a62 * dMatrix6x62.a62);
        dMatrix6x63.a23 += (dMatrix6x6.a12 * dMatrix6x62.a13) + (dMatrix6x6.a22 * dMatrix6x62.a23) + (dMatrix6x6.a32 * dMatrix6x62.a33) + (dMatrix6x6.a42 * dMatrix6x62.a43) + (dMatrix6x6.a52 * dMatrix6x62.a53) + (dMatrix6x6.a62 * dMatrix6x62.a63);
        dMatrix6x63.a24 += (dMatrix6x6.a12 * dMatrix6x62.a14) + (dMatrix6x6.a22 * dMatrix6x62.a24) + (dMatrix6x6.a32 * dMatrix6x62.a34) + (dMatrix6x6.a42 * dMatrix6x62.a44) + (dMatrix6x6.a52 * dMatrix6x62.a54) + (dMatrix6x6.a62 * dMatrix6x62.a64);
        dMatrix6x63.a25 += (dMatrix6x6.a12 * dMatrix6x62.a15) + (dMatrix6x6.a22 * dMatrix6x62.a25) + (dMatrix6x6.a32 * dMatrix6x62.a35) + (dMatrix6x6.a42 * dMatrix6x62.a45) + (dMatrix6x6.a52 * dMatrix6x62.a55) + (dMatrix6x6.a62 * dMatrix6x62.a65);
        dMatrix6x63.a26 += (dMatrix6x6.a12 * dMatrix6x62.a16) + (dMatrix6x6.a22 * dMatrix6x62.a26) + (dMatrix6x6.a32 * dMatrix6x62.a36) + (dMatrix6x6.a42 * dMatrix6x62.a46) + (dMatrix6x6.a52 * dMatrix6x62.a56) + (dMatrix6x6.a62 * dMatrix6x62.a66);
        dMatrix6x63.a31 += (dMatrix6x6.a13 * dMatrix6x62.a11) + (dMatrix6x6.a23 * dMatrix6x62.a21) + (dMatrix6x6.a33 * dMatrix6x62.a31) + (dMatrix6x6.a43 * dMatrix6x62.a41) + (dMatrix6x6.a53 * dMatrix6x62.a51) + (dMatrix6x6.a63 * dMatrix6x62.a61);
        dMatrix6x63.a32 += (dMatrix6x6.a13 * dMatrix6x62.a12) + (dMatrix6x6.a23 * dMatrix6x62.a22) + (dMatrix6x6.a33 * dMatrix6x62.a32) + (dMatrix6x6.a43 * dMatrix6x62.a42) + (dMatrix6x6.a53 * dMatrix6x62.a52) + (dMatrix6x6.a63 * dMatrix6x62.a62);
        dMatrix6x63.a33 += (dMatrix6x6.a13 * dMatrix6x62.a13) + (dMatrix6x6.a23 * dMatrix6x62.a23) + (dMatrix6x6.a33 * dMatrix6x62.a33) + (dMatrix6x6.a43 * dMatrix6x62.a43) + (dMatrix6x6.a53 * dMatrix6x62.a53) + (dMatrix6x6.a63 * dMatrix6x62.a63);
        dMatrix6x63.a34 += (dMatrix6x6.a13 * dMatrix6x62.a14) + (dMatrix6x6.a23 * dMatrix6x62.a24) + (dMatrix6x6.a33 * dMatrix6x62.a34) + (dMatrix6x6.a43 * dMatrix6x62.a44) + (dMatrix6x6.a53 * dMatrix6x62.a54) + (dMatrix6x6.a63 * dMatrix6x62.a64);
        dMatrix6x63.a35 += (dMatrix6x6.a13 * dMatrix6x62.a15) + (dMatrix6x6.a23 * dMatrix6x62.a25) + (dMatrix6x6.a33 * dMatrix6x62.a35) + (dMatrix6x6.a43 * dMatrix6x62.a45) + (dMatrix6x6.a53 * dMatrix6x62.a55) + (dMatrix6x6.a63 * dMatrix6x62.a65);
        dMatrix6x63.a36 += (dMatrix6x6.a13 * dMatrix6x62.a16) + (dMatrix6x6.a23 * dMatrix6x62.a26) + (dMatrix6x6.a33 * dMatrix6x62.a36) + (dMatrix6x6.a43 * dMatrix6x62.a46) + (dMatrix6x6.a53 * dMatrix6x62.a56) + (dMatrix6x6.a63 * dMatrix6x62.a66);
        dMatrix6x63.a41 += (dMatrix6x6.a14 * dMatrix6x62.a11) + (dMatrix6x6.a24 * dMatrix6x62.a21) + (dMatrix6x6.a34 * dMatrix6x62.a31) + (dMatrix6x6.a44 * dMatrix6x62.a41) + (dMatrix6x6.a54 * dMatrix6x62.a51) + (dMatrix6x6.a64 * dMatrix6x62.a61);
        dMatrix6x63.a42 += (dMatrix6x6.a14 * dMatrix6x62.a12) + (dMatrix6x6.a24 * dMatrix6x62.a22) + (dMatrix6x6.a34 * dMatrix6x62.a32) + (dMatrix6x6.a44 * dMatrix6x62.a42) + (dMatrix6x6.a54 * dMatrix6x62.a52) + (dMatrix6x6.a64 * dMatrix6x62.a62);
        dMatrix6x63.a43 += (dMatrix6x6.a14 * dMatrix6x62.a13) + (dMatrix6x6.a24 * dMatrix6x62.a23) + (dMatrix6x6.a34 * dMatrix6x62.a33) + (dMatrix6x6.a44 * dMatrix6x62.a43) + (dMatrix6x6.a54 * dMatrix6x62.a53) + (dMatrix6x6.a64 * dMatrix6x62.a63);
        dMatrix6x63.a44 += (dMatrix6x6.a14 * dMatrix6x62.a14) + (dMatrix6x6.a24 * dMatrix6x62.a24) + (dMatrix6x6.a34 * dMatrix6x62.a34) + (dMatrix6x6.a44 * dMatrix6x62.a44) + (dMatrix6x6.a54 * dMatrix6x62.a54) + (dMatrix6x6.a64 * dMatrix6x62.a64);
        dMatrix6x63.a45 += (dMatrix6x6.a14 * dMatrix6x62.a15) + (dMatrix6x6.a24 * dMatrix6x62.a25) + (dMatrix6x6.a34 * dMatrix6x62.a35) + (dMatrix6x6.a44 * dMatrix6x62.a45) + (dMatrix6x6.a54 * dMatrix6x62.a55) + (dMatrix6x6.a64 * dMatrix6x62.a65);
        dMatrix6x63.a46 += (dMatrix6x6.a14 * dMatrix6x62.a16) + (dMatrix6x6.a24 * dMatrix6x62.a26) + (dMatrix6x6.a34 * dMatrix6x62.a36) + (dMatrix6x6.a44 * dMatrix6x62.a46) + (dMatrix6x6.a54 * dMatrix6x62.a56) + (dMatrix6x6.a64 * dMatrix6x62.a66);
        dMatrix6x63.a51 += (dMatrix6x6.a15 * dMatrix6x62.a11) + (dMatrix6x6.a25 * dMatrix6x62.a21) + (dMatrix6x6.a35 * dMatrix6x62.a31) + (dMatrix6x6.a45 * dMatrix6x62.a41) + (dMatrix6x6.a55 * dMatrix6x62.a51) + (dMatrix6x6.a65 * dMatrix6x62.a61);
        dMatrix6x63.a52 += (dMatrix6x6.a15 * dMatrix6x62.a12) + (dMatrix6x6.a25 * dMatrix6x62.a22) + (dMatrix6x6.a35 * dMatrix6x62.a32) + (dMatrix6x6.a45 * dMatrix6x62.a42) + (dMatrix6x6.a55 * dMatrix6x62.a52) + (dMatrix6x6.a65 * dMatrix6x62.a62);
        dMatrix6x63.a53 += (dMatrix6x6.a15 * dMatrix6x62.a13) + (dMatrix6x6.a25 * dMatrix6x62.a23) + (dMatrix6x6.a35 * dMatrix6x62.a33) + (dMatrix6x6.a45 * dMatrix6x62.a43) + (dMatrix6x6.a55 * dMatrix6x62.a53) + (dMatrix6x6.a65 * dMatrix6x62.a63);
        dMatrix6x63.a54 += (dMatrix6x6.a15 * dMatrix6x62.a14) + (dMatrix6x6.a25 * dMatrix6x62.a24) + (dMatrix6x6.a35 * dMatrix6x62.a34) + (dMatrix6x6.a45 * dMatrix6x62.a44) + (dMatrix6x6.a55 * dMatrix6x62.a54) + (dMatrix6x6.a65 * dMatrix6x62.a64);
        dMatrix6x63.a55 += (dMatrix6x6.a15 * dMatrix6x62.a15) + (dMatrix6x6.a25 * dMatrix6x62.a25) + (dMatrix6x6.a35 * dMatrix6x62.a35) + (dMatrix6x6.a45 * dMatrix6x62.a45) + (dMatrix6x6.a55 * dMatrix6x62.a55) + (dMatrix6x6.a65 * dMatrix6x62.a65);
        dMatrix6x63.a56 += (dMatrix6x6.a15 * dMatrix6x62.a16) + (dMatrix6x6.a25 * dMatrix6x62.a26) + (dMatrix6x6.a35 * dMatrix6x62.a36) + (dMatrix6x6.a45 * dMatrix6x62.a46) + (dMatrix6x6.a55 * dMatrix6x62.a56) + (dMatrix6x6.a65 * dMatrix6x62.a66);
        dMatrix6x63.a61 += (dMatrix6x6.a16 * dMatrix6x62.a11) + (dMatrix6x6.a26 * dMatrix6x62.a21) + (dMatrix6x6.a36 * dMatrix6x62.a31) + (dMatrix6x6.a46 * dMatrix6x62.a41) + (dMatrix6x6.a56 * dMatrix6x62.a51) + (dMatrix6x6.a66 * dMatrix6x62.a61);
        dMatrix6x63.a62 += (dMatrix6x6.a16 * dMatrix6x62.a12) + (dMatrix6x6.a26 * dMatrix6x62.a22) + (dMatrix6x6.a36 * dMatrix6x62.a32) + (dMatrix6x6.a46 * dMatrix6x62.a42) + (dMatrix6x6.a56 * dMatrix6x62.a52) + (dMatrix6x6.a66 * dMatrix6x62.a62);
        dMatrix6x63.a63 += (dMatrix6x6.a16 * dMatrix6x62.a13) + (dMatrix6x6.a26 * dMatrix6x62.a23) + (dMatrix6x6.a36 * dMatrix6x62.a33) + (dMatrix6x6.a46 * dMatrix6x62.a43) + (dMatrix6x6.a56 * dMatrix6x62.a53) + (dMatrix6x6.a66 * dMatrix6x62.a63);
        dMatrix6x63.a64 += (dMatrix6x6.a16 * dMatrix6x62.a14) + (dMatrix6x6.a26 * dMatrix6x62.a24) + (dMatrix6x6.a36 * dMatrix6x62.a34) + (dMatrix6x6.a46 * dMatrix6x62.a44) + (dMatrix6x6.a56 * dMatrix6x62.a54) + (dMatrix6x6.a66 * dMatrix6x62.a64);
        dMatrix6x63.a65 += (dMatrix6x6.a16 * dMatrix6x62.a15) + (dMatrix6x6.a26 * dMatrix6x62.a25) + (dMatrix6x6.a36 * dMatrix6x62.a35) + (dMatrix6x6.a46 * dMatrix6x62.a45) + (dMatrix6x6.a56 * dMatrix6x62.a55) + (dMatrix6x6.a66 * dMatrix6x62.a65);
        dMatrix6x63.a66 += (dMatrix6x6.a16 * dMatrix6x62.a16) + (dMatrix6x6.a26 * dMatrix6x62.a26) + (dMatrix6x6.a36 * dMatrix6x62.a36) + (dMatrix6x6.a46 * dMatrix6x62.a46) + (dMatrix6x6.a56 * dMatrix6x62.a56) + (dMatrix6x6.a66 * dMatrix6x62.a66);
    }

    public static void multAddTransAB(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62, DMatrix6x6 dMatrix6x63) {
        dMatrix6x63.a11 += (dMatrix6x6.a11 * dMatrix6x62.a11) + (dMatrix6x6.a21 * dMatrix6x62.a12) + (dMatrix6x6.a31 * dMatrix6x62.a13) + (dMatrix6x6.a41 * dMatrix6x62.a14) + (dMatrix6x6.a51 * dMatrix6x62.a15) + (dMatrix6x6.a61 * dMatrix6x62.a16);
        dMatrix6x63.a12 += (dMatrix6x6.a11 * dMatrix6x62.a21) + (dMatrix6x6.a21 * dMatrix6x62.a22) + (dMatrix6x6.a31 * dMatrix6x62.a23) + (dMatrix6x6.a41 * dMatrix6x62.a24) + (dMatrix6x6.a51 * dMatrix6x62.a25) + (dMatrix6x6.a61 * dMatrix6x62.a26);
        dMatrix6x63.a13 += (dMatrix6x6.a11 * dMatrix6x62.a31) + (dMatrix6x6.a21 * dMatrix6x62.a32) + (dMatrix6x6.a31 * dMatrix6x62.a33) + (dMatrix6x6.a41 * dMatrix6x62.a34) + (dMatrix6x6.a51 * dMatrix6x62.a35) + (dMatrix6x6.a61 * dMatrix6x62.a36);
        dMatrix6x63.a14 += (dMatrix6x6.a11 * dMatrix6x62.a41) + (dMatrix6x6.a21 * dMatrix6x62.a42) + (dMatrix6x6.a31 * dMatrix6x62.a43) + (dMatrix6x6.a41 * dMatrix6x62.a44) + (dMatrix6x6.a51 * dMatrix6x62.a45) + (dMatrix6x6.a61 * dMatrix6x62.a46);
        dMatrix6x63.a15 += (dMatrix6x6.a11 * dMatrix6x62.a51) + (dMatrix6x6.a21 * dMatrix6x62.a52) + (dMatrix6x6.a31 * dMatrix6x62.a53) + (dMatrix6x6.a41 * dMatrix6x62.a54) + (dMatrix6x6.a51 * dMatrix6x62.a55) + (dMatrix6x6.a61 * dMatrix6x62.a56);
        dMatrix6x63.a16 += (dMatrix6x6.a11 * dMatrix6x62.a61) + (dMatrix6x6.a21 * dMatrix6x62.a62) + (dMatrix6x6.a31 * dMatrix6x62.a63) + (dMatrix6x6.a41 * dMatrix6x62.a64) + (dMatrix6x6.a51 * dMatrix6x62.a65) + (dMatrix6x6.a61 * dMatrix6x62.a66);
        dMatrix6x63.a21 += (dMatrix6x6.a12 * dMatrix6x62.a11) + (dMatrix6x6.a22 * dMatrix6x62.a12) + (dMatrix6x6.a32 * dMatrix6x62.a13) + (dMatrix6x6.a42 * dMatrix6x62.a14) + (dMatrix6x6.a52 * dMatrix6x62.a15) + (dMatrix6x6.a62 * dMatrix6x62.a16);
        dMatrix6x63.a22 += (dMatrix6x6.a12 * dMatrix6x62.a21) + (dMatrix6x6.a22 * dMatrix6x62.a22) + (dMatrix6x6.a32 * dMatrix6x62.a23) + (dMatrix6x6.a42 * dMatrix6x62.a24) + (dMatrix6x6.a52 * dMatrix6x62.a25) + (dMatrix6x6.a62 * dMatrix6x62.a26);
        dMatrix6x63.a23 += (dMatrix6x6.a12 * dMatrix6x62.a31) + (dMatrix6x6.a22 * dMatrix6x62.a32) + (dMatrix6x6.a32 * dMatrix6x62.a33) + (dMatrix6x6.a42 * dMatrix6x62.a34) + (dMatrix6x6.a52 * dMatrix6x62.a35) + (dMatrix6x6.a62 * dMatrix6x62.a36);
        dMatrix6x63.a24 += (dMatrix6x6.a12 * dMatrix6x62.a41) + (dMatrix6x6.a22 * dMatrix6x62.a42) + (dMatrix6x6.a32 * dMatrix6x62.a43) + (dMatrix6x6.a42 * dMatrix6x62.a44) + (dMatrix6x6.a52 * dMatrix6x62.a45) + (dMatrix6x6.a62 * dMatrix6x62.a46);
        dMatrix6x63.a25 += (dMatrix6x6.a12 * dMatrix6x62.a51) + (dMatrix6x6.a22 * dMatrix6x62.a52) + (dMatrix6x6.a32 * dMatrix6x62.a53) + (dMatrix6x6.a42 * dMatrix6x62.a54) + (dMatrix6x6.a52 * dMatrix6x62.a55) + (dMatrix6x6.a62 * dMatrix6x62.a56);
        dMatrix6x63.a26 += (dMatrix6x6.a12 * dMatrix6x62.a61) + (dMatrix6x6.a22 * dMatrix6x62.a62) + (dMatrix6x6.a32 * dMatrix6x62.a63) + (dMatrix6x6.a42 * dMatrix6x62.a64) + (dMatrix6x6.a52 * dMatrix6x62.a65) + (dMatrix6x6.a62 * dMatrix6x62.a66);
        dMatrix6x63.a31 += (dMatrix6x6.a13 * dMatrix6x62.a11) + (dMatrix6x6.a23 * dMatrix6x62.a12) + (dMatrix6x6.a33 * dMatrix6x62.a13) + (dMatrix6x6.a43 * dMatrix6x62.a14) + (dMatrix6x6.a53 * dMatrix6x62.a15) + (dMatrix6x6.a63 * dMatrix6x62.a16);
        dMatrix6x63.a32 += (dMatrix6x6.a13 * dMatrix6x62.a21) + (dMatrix6x6.a23 * dMatrix6x62.a22) + (dMatrix6x6.a33 * dMatrix6x62.a23) + (dMatrix6x6.a43 * dMatrix6x62.a24) + (dMatrix6x6.a53 * dMatrix6x62.a25) + (dMatrix6x6.a63 * dMatrix6x62.a26);
        dMatrix6x63.a33 += (dMatrix6x6.a13 * dMatrix6x62.a31) + (dMatrix6x6.a23 * dMatrix6x62.a32) + (dMatrix6x6.a33 * dMatrix6x62.a33) + (dMatrix6x6.a43 * dMatrix6x62.a34) + (dMatrix6x6.a53 * dMatrix6x62.a35) + (dMatrix6x6.a63 * dMatrix6x62.a36);
        dMatrix6x63.a34 += (dMatrix6x6.a13 * dMatrix6x62.a41) + (dMatrix6x6.a23 * dMatrix6x62.a42) + (dMatrix6x6.a33 * dMatrix6x62.a43) + (dMatrix6x6.a43 * dMatrix6x62.a44) + (dMatrix6x6.a53 * dMatrix6x62.a45) + (dMatrix6x6.a63 * dMatrix6x62.a46);
        dMatrix6x63.a35 += (dMatrix6x6.a13 * dMatrix6x62.a51) + (dMatrix6x6.a23 * dMatrix6x62.a52) + (dMatrix6x6.a33 * dMatrix6x62.a53) + (dMatrix6x6.a43 * dMatrix6x62.a54) + (dMatrix6x6.a53 * dMatrix6x62.a55) + (dMatrix6x6.a63 * dMatrix6x62.a56);
        dMatrix6x63.a36 += (dMatrix6x6.a13 * dMatrix6x62.a61) + (dMatrix6x6.a23 * dMatrix6x62.a62) + (dMatrix6x6.a33 * dMatrix6x62.a63) + (dMatrix6x6.a43 * dMatrix6x62.a64) + (dMatrix6x6.a53 * dMatrix6x62.a65) + (dMatrix6x6.a63 * dMatrix6x62.a66);
        dMatrix6x63.a41 += (dMatrix6x6.a14 * dMatrix6x62.a11) + (dMatrix6x6.a24 * dMatrix6x62.a12) + (dMatrix6x6.a34 * dMatrix6x62.a13) + (dMatrix6x6.a44 * dMatrix6x62.a14) + (dMatrix6x6.a54 * dMatrix6x62.a15) + (dMatrix6x6.a64 * dMatrix6x62.a16);
        dMatrix6x63.a42 += (dMatrix6x6.a14 * dMatrix6x62.a21) + (dMatrix6x6.a24 * dMatrix6x62.a22) + (dMatrix6x6.a34 * dMatrix6x62.a23) + (dMatrix6x6.a44 * dMatrix6x62.a24) + (dMatrix6x6.a54 * dMatrix6x62.a25) + (dMatrix6x6.a64 * dMatrix6x62.a26);
        dMatrix6x63.a43 += (dMatrix6x6.a14 * dMatrix6x62.a31) + (dMatrix6x6.a24 * dMatrix6x62.a32) + (dMatrix6x6.a34 * dMatrix6x62.a33) + (dMatrix6x6.a44 * dMatrix6x62.a34) + (dMatrix6x6.a54 * dMatrix6x62.a35) + (dMatrix6x6.a64 * dMatrix6x62.a36);
        dMatrix6x63.a44 += (dMatrix6x6.a14 * dMatrix6x62.a41) + (dMatrix6x6.a24 * dMatrix6x62.a42) + (dMatrix6x6.a34 * dMatrix6x62.a43) + (dMatrix6x6.a44 * dMatrix6x62.a44) + (dMatrix6x6.a54 * dMatrix6x62.a45) + (dMatrix6x6.a64 * dMatrix6x62.a46);
        dMatrix6x63.a45 += (dMatrix6x6.a14 * dMatrix6x62.a51) + (dMatrix6x6.a24 * dMatrix6x62.a52) + (dMatrix6x6.a34 * dMatrix6x62.a53) + (dMatrix6x6.a44 * dMatrix6x62.a54) + (dMatrix6x6.a54 * dMatrix6x62.a55) + (dMatrix6x6.a64 * dMatrix6x62.a56);
        dMatrix6x63.a46 += (dMatrix6x6.a14 * dMatrix6x62.a61) + (dMatrix6x6.a24 * dMatrix6x62.a62) + (dMatrix6x6.a34 * dMatrix6x62.a63) + (dMatrix6x6.a44 * dMatrix6x62.a64) + (dMatrix6x6.a54 * dMatrix6x62.a65) + (dMatrix6x6.a64 * dMatrix6x62.a66);
        dMatrix6x63.a51 += (dMatrix6x6.a15 * dMatrix6x62.a11) + (dMatrix6x6.a25 * dMatrix6x62.a12) + (dMatrix6x6.a35 * dMatrix6x62.a13) + (dMatrix6x6.a45 * dMatrix6x62.a14) + (dMatrix6x6.a55 * dMatrix6x62.a15) + (dMatrix6x6.a65 * dMatrix6x62.a16);
        dMatrix6x63.a52 += (dMatrix6x6.a15 * dMatrix6x62.a21) + (dMatrix6x6.a25 * dMatrix6x62.a22) + (dMatrix6x6.a35 * dMatrix6x62.a23) + (dMatrix6x6.a45 * dMatrix6x62.a24) + (dMatrix6x6.a55 * dMatrix6x62.a25) + (dMatrix6x6.a65 * dMatrix6x62.a26);
        dMatrix6x63.a53 += (dMatrix6x6.a15 * dMatrix6x62.a31) + (dMatrix6x6.a25 * dMatrix6x62.a32) + (dMatrix6x6.a35 * dMatrix6x62.a33) + (dMatrix6x6.a45 * dMatrix6x62.a34) + (dMatrix6x6.a55 * dMatrix6x62.a35) + (dMatrix6x6.a65 * dMatrix6x62.a36);
        dMatrix6x63.a54 += (dMatrix6x6.a15 * dMatrix6x62.a41) + (dMatrix6x6.a25 * dMatrix6x62.a42) + (dMatrix6x6.a35 * dMatrix6x62.a43) + (dMatrix6x6.a45 * dMatrix6x62.a44) + (dMatrix6x6.a55 * dMatrix6x62.a45) + (dMatrix6x6.a65 * dMatrix6x62.a46);
        dMatrix6x63.a55 += (dMatrix6x6.a15 * dMatrix6x62.a51) + (dMatrix6x6.a25 * dMatrix6x62.a52) + (dMatrix6x6.a35 * dMatrix6x62.a53) + (dMatrix6x6.a45 * dMatrix6x62.a54) + (dMatrix6x6.a55 * dMatrix6x62.a55) + (dMatrix6x6.a65 * dMatrix6x62.a56);
        dMatrix6x63.a56 += (dMatrix6x6.a15 * dMatrix6x62.a61) + (dMatrix6x6.a25 * dMatrix6x62.a62) + (dMatrix6x6.a35 * dMatrix6x62.a63) + (dMatrix6x6.a45 * dMatrix6x62.a64) + (dMatrix6x6.a55 * dMatrix6x62.a65) + (dMatrix6x6.a65 * dMatrix6x62.a66);
        dMatrix6x63.a61 += (dMatrix6x6.a16 * dMatrix6x62.a11) + (dMatrix6x6.a26 * dMatrix6x62.a12) + (dMatrix6x6.a36 * dMatrix6x62.a13) + (dMatrix6x6.a46 * dMatrix6x62.a14) + (dMatrix6x6.a56 * dMatrix6x62.a15) + (dMatrix6x6.a66 * dMatrix6x62.a16);
        dMatrix6x63.a62 += (dMatrix6x6.a16 * dMatrix6x62.a21) + (dMatrix6x6.a26 * dMatrix6x62.a22) + (dMatrix6x6.a36 * dMatrix6x62.a23) + (dMatrix6x6.a46 * dMatrix6x62.a24) + (dMatrix6x6.a56 * dMatrix6x62.a25) + (dMatrix6x6.a66 * dMatrix6x62.a26);
        dMatrix6x63.a63 += (dMatrix6x6.a16 * dMatrix6x62.a31) + (dMatrix6x6.a26 * dMatrix6x62.a32) + (dMatrix6x6.a36 * dMatrix6x62.a33) + (dMatrix6x6.a46 * dMatrix6x62.a34) + (dMatrix6x6.a56 * dMatrix6x62.a35) + (dMatrix6x6.a66 * dMatrix6x62.a36);
        dMatrix6x63.a64 += (dMatrix6x6.a16 * dMatrix6x62.a41) + (dMatrix6x6.a26 * dMatrix6x62.a42) + (dMatrix6x6.a36 * dMatrix6x62.a43) + (dMatrix6x6.a46 * dMatrix6x62.a44) + (dMatrix6x6.a56 * dMatrix6x62.a45) + (dMatrix6x6.a66 * dMatrix6x62.a46);
        dMatrix6x63.a65 += (dMatrix6x6.a16 * dMatrix6x62.a51) + (dMatrix6x6.a26 * dMatrix6x62.a52) + (dMatrix6x6.a36 * dMatrix6x62.a53) + (dMatrix6x6.a46 * dMatrix6x62.a54) + (dMatrix6x6.a56 * dMatrix6x62.a55) + (dMatrix6x6.a66 * dMatrix6x62.a56);
        dMatrix6x63.a66 += (dMatrix6x6.a16 * dMatrix6x62.a61) + (dMatrix6x6.a26 * dMatrix6x62.a62) + (dMatrix6x6.a36 * dMatrix6x62.a63) + (dMatrix6x6.a46 * dMatrix6x62.a64) + (dMatrix6x6.a56 * dMatrix6x62.a65) + (dMatrix6x6.a66 * dMatrix6x62.a66);
    }

    public static void multAddTransB(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62, DMatrix6x6 dMatrix6x63) {
        dMatrix6x63.a11 += (dMatrix6x6.a11 * dMatrix6x62.a11) + (dMatrix6x6.a12 * dMatrix6x62.a12) + (dMatrix6x6.a13 * dMatrix6x62.a13) + (dMatrix6x6.a14 * dMatrix6x62.a14) + (dMatrix6x6.a15 * dMatrix6x62.a15) + (dMatrix6x6.a16 * dMatrix6x62.a16);
        dMatrix6x63.a12 += (dMatrix6x6.a11 * dMatrix6x62.a21) + (dMatrix6x6.a12 * dMatrix6x62.a22) + (dMatrix6x6.a13 * dMatrix6x62.a23) + (dMatrix6x6.a14 * dMatrix6x62.a24) + (dMatrix6x6.a15 * dMatrix6x62.a25) + (dMatrix6x6.a16 * dMatrix6x62.a26);
        dMatrix6x63.a13 += (dMatrix6x6.a11 * dMatrix6x62.a31) + (dMatrix6x6.a12 * dMatrix6x62.a32) + (dMatrix6x6.a13 * dMatrix6x62.a33) + (dMatrix6x6.a14 * dMatrix6x62.a34) + (dMatrix6x6.a15 * dMatrix6x62.a35) + (dMatrix6x6.a16 * dMatrix6x62.a36);
        dMatrix6x63.a14 += (dMatrix6x6.a11 * dMatrix6x62.a41) + (dMatrix6x6.a12 * dMatrix6x62.a42) + (dMatrix6x6.a13 * dMatrix6x62.a43) + (dMatrix6x6.a14 * dMatrix6x62.a44) + (dMatrix6x6.a15 * dMatrix6x62.a45) + (dMatrix6x6.a16 * dMatrix6x62.a46);
        dMatrix6x63.a15 += (dMatrix6x6.a11 * dMatrix6x62.a51) + (dMatrix6x6.a12 * dMatrix6x62.a52) + (dMatrix6x6.a13 * dMatrix6x62.a53) + (dMatrix6x6.a14 * dMatrix6x62.a54) + (dMatrix6x6.a15 * dMatrix6x62.a55) + (dMatrix6x6.a16 * dMatrix6x62.a56);
        dMatrix6x63.a16 += (dMatrix6x6.a11 * dMatrix6x62.a61) + (dMatrix6x6.a12 * dMatrix6x62.a62) + (dMatrix6x6.a13 * dMatrix6x62.a63) + (dMatrix6x6.a14 * dMatrix6x62.a64) + (dMatrix6x6.a15 * dMatrix6x62.a65) + (dMatrix6x6.a16 * dMatrix6x62.a66);
        dMatrix6x63.a21 += (dMatrix6x6.a21 * dMatrix6x62.a11) + (dMatrix6x6.a22 * dMatrix6x62.a12) + (dMatrix6x6.a23 * dMatrix6x62.a13) + (dMatrix6x6.a24 * dMatrix6x62.a14) + (dMatrix6x6.a25 * dMatrix6x62.a15) + (dMatrix6x6.a26 * dMatrix6x62.a16);
        dMatrix6x63.a22 += (dMatrix6x6.a21 * dMatrix6x62.a21) + (dMatrix6x6.a22 * dMatrix6x62.a22) + (dMatrix6x6.a23 * dMatrix6x62.a23) + (dMatrix6x6.a24 * dMatrix6x62.a24) + (dMatrix6x6.a25 * dMatrix6x62.a25) + (dMatrix6x6.a26 * dMatrix6x62.a26);
        dMatrix6x63.a23 += (dMatrix6x6.a21 * dMatrix6x62.a31) + (dMatrix6x6.a22 * dMatrix6x62.a32) + (dMatrix6x6.a23 * dMatrix6x62.a33) + (dMatrix6x6.a24 * dMatrix6x62.a34) + (dMatrix6x6.a25 * dMatrix6x62.a35) + (dMatrix6x6.a26 * dMatrix6x62.a36);
        dMatrix6x63.a24 += (dMatrix6x6.a21 * dMatrix6x62.a41) + (dMatrix6x6.a22 * dMatrix6x62.a42) + (dMatrix6x6.a23 * dMatrix6x62.a43) + (dMatrix6x6.a24 * dMatrix6x62.a44) + (dMatrix6x6.a25 * dMatrix6x62.a45) + (dMatrix6x6.a26 * dMatrix6x62.a46);
        dMatrix6x63.a25 += (dMatrix6x6.a21 * dMatrix6x62.a51) + (dMatrix6x6.a22 * dMatrix6x62.a52) + (dMatrix6x6.a23 * dMatrix6x62.a53) + (dMatrix6x6.a24 * dMatrix6x62.a54) + (dMatrix6x6.a25 * dMatrix6x62.a55) + (dMatrix6x6.a26 * dMatrix6x62.a56);
        dMatrix6x63.a26 += (dMatrix6x6.a21 * dMatrix6x62.a61) + (dMatrix6x6.a22 * dMatrix6x62.a62) + (dMatrix6x6.a23 * dMatrix6x62.a63) + (dMatrix6x6.a24 * dMatrix6x62.a64) + (dMatrix6x6.a25 * dMatrix6x62.a65) + (dMatrix6x6.a26 * dMatrix6x62.a66);
        dMatrix6x63.a31 += (dMatrix6x6.a31 * dMatrix6x62.a11) + (dMatrix6x6.a32 * dMatrix6x62.a12) + (dMatrix6x6.a33 * dMatrix6x62.a13) + (dMatrix6x6.a34 * dMatrix6x62.a14) + (dMatrix6x6.a35 * dMatrix6x62.a15) + (dMatrix6x6.a36 * dMatrix6x62.a16);
        dMatrix6x63.a32 += (dMatrix6x6.a31 * dMatrix6x62.a21) + (dMatrix6x6.a32 * dMatrix6x62.a22) + (dMatrix6x6.a33 * dMatrix6x62.a23) + (dMatrix6x6.a34 * dMatrix6x62.a24) + (dMatrix6x6.a35 * dMatrix6x62.a25) + (dMatrix6x6.a36 * dMatrix6x62.a26);
        dMatrix6x63.a33 += (dMatrix6x6.a31 * dMatrix6x62.a31) + (dMatrix6x6.a32 * dMatrix6x62.a32) + (dMatrix6x6.a33 * dMatrix6x62.a33) + (dMatrix6x6.a34 * dMatrix6x62.a34) + (dMatrix6x6.a35 * dMatrix6x62.a35) + (dMatrix6x6.a36 * dMatrix6x62.a36);
        dMatrix6x63.a34 += (dMatrix6x6.a31 * dMatrix6x62.a41) + (dMatrix6x6.a32 * dMatrix6x62.a42) + (dMatrix6x6.a33 * dMatrix6x62.a43) + (dMatrix6x6.a34 * dMatrix6x62.a44) + (dMatrix6x6.a35 * dMatrix6x62.a45) + (dMatrix6x6.a36 * dMatrix6x62.a46);
        dMatrix6x63.a35 += (dMatrix6x6.a31 * dMatrix6x62.a51) + (dMatrix6x6.a32 * dMatrix6x62.a52) + (dMatrix6x6.a33 * dMatrix6x62.a53) + (dMatrix6x6.a34 * dMatrix6x62.a54) + (dMatrix6x6.a35 * dMatrix6x62.a55) + (dMatrix6x6.a36 * dMatrix6x62.a56);
        dMatrix6x63.a36 += (dMatrix6x6.a31 * dMatrix6x62.a61) + (dMatrix6x6.a32 * dMatrix6x62.a62) + (dMatrix6x6.a33 * dMatrix6x62.a63) + (dMatrix6x6.a34 * dMatrix6x62.a64) + (dMatrix6x6.a35 * dMatrix6x62.a65) + (dMatrix6x6.a36 * dMatrix6x62.a66);
        dMatrix6x63.a41 += (dMatrix6x6.a41 * dMatrix6x62.a11) + (dMatrix6x6.a42 * dMatrix6x62.a12) + (dMatrix6x6.a43 * dMatrix6x62.a13) + (dMatrix6x6.a44 * dMatrix6x62.a14) + (dMatrix6x6.a45 * dMatrix6x62.a15) + (dMatrix6x6.a46 * dMatrix6x62.a16);
        dMatrix6x63.a42 += (dMatrix6x6.a41 * dMatrix6x62.a21) + (dMatrix6x6.a42 * dMatrix6x62.a22) + (dMatrix6x6.a43 * dMatrix6x62.a23) + (dMatrix6x6.a44 * dMatrix6x62.a24) + (dMatrix6x6.a45 * dMatrix6x62.a25) + (dMatrix6x6.a46 * dMatrix6x62.a26);
        dMatrix6x63.a43 += (dMatrix6x6.a41 * dMatrix6x62.a31) + (dMatrix6x6.a42 * dMatrix6x62.a32) + (dMatrix6x6.a43 * dMatrix6x62.a33) + (dMatrix6x6.a44 * dMatrix6x62.a34) + (dMatrix6x6.a45 * dMatrix6x62.a35) + (dMatrix6x6.a46 * dMatrix6x62.a36);
        dMatrix6x63.a44 += (dMatrix6x6.a41 * dMatrix6x62.a41) + (dMatrix6x6.a42 * dMatrix6x62.a42) + (dMatrix6x6.a43 * dMatrix6x62.a43) + (dMatrix6x6.a44 * dMatrix6x62.a44) + (dMatrix6x6.a45 * dMatrix6x62.a45) + (dMatrix6x6.a46 * dMatrix6x62.a46);
        dMatrix6x63.a45 += (dMatrix6x6.a41 * dMatrix6x62.a51) + (dMatrix6x6.a42 * dMatrix6x62.a52) + (dMatrix6x6.a43 * dMatrix6x62.a53) + (dMatrix6x6.a44 * dMatrix6x62.a54) + (dMatrix6x6.a45 * dMatrix6x62.a55) + (dMatrix6x6.a46 * dMatrix6x62.a56);
        dMatrix6x63.a46 += (dMatrix6x6.a41 * dMatrix6x62.a61) + (dMatrix6x6.a42 * dMatrix6x62.a62) + (dMatrix6x6.a43 * dMatrix6x62.a63) + (dMatrix6x6.a44 * dMatrix6x62.a64) + (dMatrix6x6.a45 * dMatrix6x62.a65) + (dMatrix6x6.a46 * dMatrix6x62.a66);
        dMatrix6x63.a51 += (dMatrix6x6.a51 * dMatrix6x62.a11) + (dMatrix6x6.a52 * dMatrix6x62.a12) + (dMatrix6x6.a53 * dMatrix6x62.a13) + (dMatrix6x6.a54 * dMatrix6x62.a14) + (dMatrix6x6.a55 * dMatrix6x62.a15) + (dMatrix6x6.a56 * dMatrix6x62.a16);
        dMatrix6x63.a52 += (dMatrix6x6.a51 * dMatrix6x62.a21) + (dMatrix6x6.a52 * dMatrix6x62.a22) + (dMatrix6x6.a53 * dMatrix6x62.a23) + (dMatrix6x6.a54 * dMatrix6x62.a24) + (dMatrix6x6.a55 * dMatrix6x62.a25) + (dMatrix6x6.a56 * dMatrix6x62.a26);
        dMatrix6x63.a53 += (dMatrix6x6.a51 * dMatrix6x62.a31) + (dMatrix6x6.a52 * dMatrix6x62.a32) + (dMatrix6x6.a53 * dMatrix6x62.a33) + (dMatrix6x6.a54 * dMatrix6x62.a34) + (dMatrix6x6.a55 * dMatrix6x62.a35) + (dMatrix6x6.a56 * dMatrix6x62.a36);
        dMatrix6x63.a54 += (dMatrix6x6.a51 * dMatrix6x62.a41) + (dMatrix6x6.a52 * dMatrix6x62.a42) + (dMatrix6x6.a53 * dMatrix6x62.a43) + (dMatrix6x6.a54 * dMatrix6x62.a44) + (dMatrix6x6.a55 * dMatrix6x62.a45) + (dMatrix6x6.a56 * dMatrix6x62.a46);
        dMatrix6x63.a55 += (dMatrix6x6.a51 * dMatrix6x62.a51) + (dMatrix6x6.a52 * dMatrix6x62.a52) + (dMatrix6x6.a53 * dMatrix6x62.a53) + (dMatrix6x6.a54 * dMatrix6x62.a54) + (dMatrix6x6.a55 * dMatrix6x62.a55) + (dMatrix6x6.a56 * dMatrix6x62.a56);
        dMatrix6x63.a56 += (dMatrix6x6.a51 * dMatrix6x62.a61) + (dMatrix6x6.a52 * dMatrix6x62.a62) + (dMatrix6x6.a53 * dMatrix6x62.a63) + (dMatrix6x6.a54 * dMatrix6x62.a64) + (dMatrix6x6.a55 * dMatrix6x62.a65) + (dMatrix6x6.a56 * dMatrix6x62.a66);
        dMatrix6x63.a61 += (dMatrix6x6.a61 * dMatrix6x62.a11) + (dMatrix6x6.a62 * dMatrix6x62.a12) + (dMatrix6x6.a63 * dMatrix6x62.a13) + (dMatrix6x6.a64 * dMatrix6x62.a14) + (dMatrix6x6.a65 * dMatrix6x62.a15) + (dMatrix6x6.a66 * dMatrix6x62.a16);
        dMatrix6x63.a62 += (dMatrix6x6.a61 * dMatrix6x62.a21) + (dMatrix6x6.a62 * dMatrix6x62.a22) + (dMatrix6x6.a63 * dMatrix6x62.a23) + (dMatrix6x6.a64 * dMatrix6x62.a24) + (dMatrix6x6.a65 * dMatrix6x62.a25) + (dMatrix6x6.a66 * dMatrix6x62.a26);
        dMatrix6x63.a63 += (dMatrix6x6.a61 * dMatrix6x62.a31) + (dMatrix6x6.a62 * dMatrix6x62.a32) + (dMatrix6x6.a63 * dMatrix6x62.a33) + (dMatrix6x6.a64 * dMatrix6x62.a34) + (dMatrix6x6.a65 * dMatrix6x62.a35) + (dMatrix6x6.a66 * dMatrix6x62.a36);
        dMatrix6x63.a64 += (dMatrix6x6.a61 * dMatrix6x62.a41) + (dMatrix6x6.a62 * dMatrix6x62.a42) + (dMatrix6x6.a63 * dMatrix6x62.a43) + (dMatrix6x6.a64 * dMatrix6x62.a44) + (dMatrix6x6.a65 * dMatrix6x62.a45) + (dMatrix6x6.a66 * dMatrix6x62.a46);
        dMatrix6x63.a65 += (dMatrix6x6.a61 * dMatrix6x62.a51) + (dMatrix6x6.a62 * dMatrix6x62.a52) + (dMatrix6x6.a63 * dMatrix6x62.a53) + (dMatrix6x6.a64 * dMatrix6x62.a54) + (dMatrix6x6.a65 * dMatrix6x62.a55) + (dMatrix6x6.a66 * dMatrix6x62.a56);
        dMatrix6x63.a66 += (dMatrix6x6.a61 * dMatrix6x62.a61) + (dMatrix6x6.a62 * dMatrix6x62.a62) + (dMatrix6x6.a63 * dMatrix6x62.a63) + (dMatrix6x6.a64 * dMatrix6x62.a64) + (dMatrix6x6.a65 * dMatrix6x62.a65) + (dMatrix6x6.a66 * dMatrix6x62.a66);
    }

    public static void mult(DMatrix6x6 dMatrix6x6, DMatrix6 dMatrix6, DMatrix6 dMatrix62) {
        dMatrix62.f2411a1 = (dMatrix6x6.a11 * dMatrix6.f2411a1) + (dMatrix6x6.a12 * dMatrix6.f2412a2) + (dMatrix6x6.a13 * dMatrix6.f2413a3) + (dMatrix6x6.a14 * dMatrix6.f2414a4) + (dMatrix6x6.a15 * dMatrix6.f2415a5) + (dMatrix6x6.a16 * dMatrix6.f2416a6);
        dMatrix62.f2412a2 = (dMatrix6x6.a21 * dMatrix6.f2411a1) + (dMatrix6x6.a22 * dMatrix6.f2412a2) + (dMatrix6x6.a23 * dMatrix6.f2413a3) + (dMatrix6x6.a24 * dMatrix6.f2414a4) + (dMatrix6x6.a25 * dMatrix6.f2415a5) + (dMatrix6x6.a26 * dMatrix6.f2416a6);
        dMatrix62.f2413a3 = (dMatrix6x6.a31 * dMatrix6.f2411a1) + (dMatrix6x6.a32 * dMatrix6.f2412a2) + (dMatrix6x6.a33 * dMatrix6.f2413a3) + (dMatrix6x6.a34 * dMatrix6.f2414a4) + (dMatrix6x6.a35 * dMatrix6.f2415a5) + (dMatrix6x6.a36 * dMatrix6.f2416a6);
        dMatrix62.f2414a4 = (dMatrix6x6.a41 * dMatrix6.f2411a1) + (dMatrix6x6.a42 * dMatrix6.f2412a2) + (dMatrix6x6.a43 * dMatrix6.f2413a3) + (dMatrix6x6.a44 * dMatrix6.f2414a4) + (dMatrix6x6.a45 * dMatrix6.f2415a5) + (dMatrix6x6.a46 * dMatrix6.f2416a6);
        dMatrix62.f2415a5 = (dMatrix6x6.a51 * dMatrix6.f2411a1) + (dMatrix6x6.a52 * dMatrix6.f2412a2) + (dMatrix6x6.a53 * dMatrix6.f2413a3) + (dMatrix6x6.a54 * dMatrix6.f2414a4) + (dMatrix6x6.a55 * dMatrix6.f2415a5) + (dMatrix6x6.a56 * dMatrix6.f2416a6);
        dMatrix62.f2416a6 = (dMatrix6x6.a61 * dMatrix6.f2411a1) + (dMatrix6x6.a62 * dMatrix6.f2412a2) + (dMatrix6x6.a63 * dMatrix6.f2413a3) + (dMatrix6x6.a64 * dMatrix6.f2414a4) + (dMatrix6x6.a65 * dMatrix6.f2415a5) + (dMatrix6x6.a66 * dMatrix6.f2416a6);
    }

    public static void mult(DMatrix6 dMatrix6, DMatrix6x6 dMatrix6x6, DMatrix6 dMatrix62) {
        dMatrix62.f2411a1 = (dMatrix6.f2411a1 * dMatrix6x6.a11) + (dMatrix6.f2412a2 * dMatrix6x6.a21) + (dMatrix6.f2413a3 * dMatrix6x6.a31) + (dMatrix6.f2414a4 * dMatrix6x6.a41) + (dMatrix6.f2415a5 * dMatrix6x6.a51) + (dMatrix6.f2416a6 * dMatrix6x6.a61);
        dMatrix62.f2412a2 = (dMatrix6.f2411a1 * dMatrix6x6.a12) + (dMatrix6.f2412a2 * dMatrix6x6.a22) + (dMatrix6.f2413a3 * dMatrix6x6.a32) + (dMatrix6.f2414a4 * dMatrix6x6.a42) + (dMatrix6.f2415a5 * dMatrix6x6.a52) + (dMatrix6.f2416a6 * dMatrix6x6.a62);
        dMatrix62.f2413a3 = (dMatrix6.f2411a1 * dMatrix6x6.a13) + (dMatrix6.f2412a2 * dMatrix6x6.a23) + (dMatrix6.f2413a3 * dMatrix6x6.a33) + (dMatrix6.f2414a4 * dMatrix6x6.a43) + (dMatrix6.f2415a5 * dMatrix6x6.a53) + (dMatrix6.f2416a6 * dMatrix6x6.a63);
        dMatrix62.f2414a4 = (dMatrix6.f2411a1 * dMatrix6x6.a14) + (dMatrix6.f2412a2 * dMatrix6x6.a24) + (dMatrix6.f2413a3 * dMatrix6x6.a34) + (dMatrix6.f2414a4 * dMatrix6x6.a44) + (dMatrix6.f2415a5 * dMatrix6x6.a54) + (dMatrix6.f2416a6 * dMatrix6x6.a64);
        dMatrix62.f2415a5 = (dMatrix6.f2411a1 * dMatrix6x6.a15) + (dMatrix6.f2412a2 * dMatrix6x6.a25) + (dMatrix6.f2413a3 * dMatrix6x6.a35) + (dMatrix6.f2414a4 * dMatrix6x6.a45) + (dMatrix6.f2415a5 * dMatrix6x6.a55) + (dMatrix6.f2416a6 * dMatrix6x6.a65);
        dMatrix62.f2416a6 = (dMatrix6.f2411a1 * dMatrix6x6.a16) + (dMatrix6.f2412a2 * dMatrix6x6.a26) + (dMatrix6.f2413a3 * dMatrix6x6.a36) + (dMatrix6.f2414a4 * dMatrix6x6.a46) + (dMatrix6.f2415a5 * dMatrix6x6.a56) + (dMatrix6.f2416a6 * dMatrix6x6.a66);
    }

    public static double dot(DMatrix6 dMatrix6, DMatrix6 dMatrix62) {
        return (dMatrix6.f2411a1 * dMatrix62.f2411a1) + (dMatrix6.f2412a2 * dMatrix62.f2412a2) + (dMatrix6.f2413a3 * dMatrix62.f2413a3) + (dMatrix6.f2414a4 * dMatrix62.f2414a4) + (dMatrix6.f2415a5 * dMatrix62.f2415a5) + (dMatrix6.f2416a6 * dMatrix62.f2416a6);
    }

    public static void setIdentity(DMatrix6x6 dMatrix6x6) {
        dMatrix6x6.a11 = 1.0d;
        dMatrix6x6.a21 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a31 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a41 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a51 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a61 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a12 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a22 = 1.0d;
        dMatrix6x6.a32 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a42 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a52 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a62 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a13 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a23 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a33 = 1.0d;
        dMatrix6x6.a43 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a53 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a63 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a14 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a24 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a34 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a44 = 1.0d;
        dMatrix6x6.a54 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a64 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a15 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a25 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a35 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a45 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a55 = 1.0d;
        dMatrix6x6.a65 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a16 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a26 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a36 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a46 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a56 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix6x6.a66 = 1.0d;
    }

    public static double trace(DMatrix6x6 dMatrix6x6) {
        return dMatrix6x6.a11 + dMatrix6x6.a22 + dMatrix6x6.a33 + dMatrix6x6.a44 + dMatrix6x6.a55 + dMatrix6x6.a66;
    }

    public static void diag(DMatrix6x6 dMatrix6x6, DMatrix6 dMatrix6) {
        dMatrix6.f2411a1 = dMatrix6x6.a11;
        dMatrix6.f2412a2 = dMatrix6x6.a22;
        dMatrix6.f2413a3 = dMatrix6x6.a33;
        dMatrix6.f2414a4 = dMatrix6x6.a44;
        dMatrix6.f2415a5 = dMatrix6x6.a55;
        dMatrix6.f2416a6 = dMatrix6x6.a66;
    }

    public static double elementMax(DMatrix6x6 dMatrix6x6) {
        double d = dMatrix6x6.a11;
        if (dMatrix6x6.a12 > d) {
            d = dMatrix6x6.a12;
        }
        if (dMatrix6x6.a13 > d) {
            d = dMatrix6x6.a13;
        }
        if (dMatrix6x6.a14 > d) {
            d = dMatrix6x6.a14;
        }
        if (dMatrix6x6.a15 > d) {
            d = dMatrix6x6.a15;
        }
        if (dMatrix6x6.a16 > d) {
            d = dMatrix6x6.a16;
        }
        if (dMatrix6x6.a21 > d) {
            d = dMatrix6x6.a21;
        }
        if (dMatrix6x6.a22 > d) {
            d = dMatrix6x6.a22;
        }
        if (dMatrix6x6.a23 > d) {
            d = dMatrix6x6.a23;
        }
        if (dMatrix6x6.a24 > d) {
            d = dMatrix6x6.a24;
        }
        if (dMatrix6x6.a25 > d) {
            d = dMatrix6x6.a25;
        }
        if (dMatrix6x6.a26 > d) {
            d = dMatrix6x6.a26;
        }
        if (dMatrix6x6.a31 > d) {
            d = dMatrix6x6.a31;
        }
        if (dMatrix6x6.a32 > d) {
            d = dMatrix6x6.a32;
        }
        if (dMatrix6x6.a33 > d) {
            d = dMatrix6x6.a33;
        }
        if (dMatrix6x6.a34 > d) {
            d = dMatrix6x6.a34;
        }
        if (dMatrix6x6.a35 > d) {
            d = dMatrix6x6.a35;
        }
        if (dMatrix6x6.a36 > d) {
            d = dMatrix6x6.a36;
        }
        if (dMatrix6x6.a41 > d) {
            d = dMatrix6x6.a41;
        }
        if (dMatrix6x6.a42 > d) {
            d = dMatrix6x6.a42;
        }
        if (dMatrix6x6.a43 > d) {
            d = dMatrix6x6.a43;
        }
        if (dMatrix6x6.a44 > d) {
            d = dMatrix6x6.a44;
        }
        if (dMatrix6x6.a45 > d) {
            d = dMatrix6x6.a45;
        }
        if (dMatrix6x6.a46 > d) {
            d = dMatrix6x6.a46;
        }
        if (dMatrix6x6.a51 > d) {
            d = dMatrix6x6.a51;
        }
        if (dMatrix6x6.a52 > d) {
            d = dMatrix6x6.a52;
        }
        if (dMatrix6x6.a53 > d) {
            d = dMatrix6x6.a53;
        }
        if (dMatrix6x6.a54 > d) {
            d = dMatrix6x6.a54;
        }
        if (dMatrix6x6.a55 > d) {
            d = dMatrix6x6.a55;
        }
        if (dMatrix6x6.a56 > d) {
            d = dMatrix6x6.a56;
        }
        if (dMatrix6x6.a61 > d) {
            d = dMatrix6x6.a61;
        }
        if (dMatrix6x6.a62 > d) {
            d = dMatrix6x6.a62;
        }
        if (dMatrix6x6.a63 > d) {
            d = dMatrix6x6.a63;
        }
        if (dMatrix6x6.a64 > d) {
            d = dMatrix6x6.a64;
        }
        if (dMatrix6x6.a65 > d) {
            d = dMatrix6x6.a65;
        }
        return dMatrix6x6.a66 > d ? dMatrix6x6.a66 : d;
    }

    public static double elementMax(DMatrix6 dMatrix6) {
        double d = dMatrix6.f2411a1;
        if (dMatrix6.f2412a2 > d) {
            d = dMatrix6.f2412a2;
        }
        if (dMatrix6.f2413a3 > d) {
            d = dMatrix6.f2413a3;
        }
        if (dMatrix6.f2414a4 > d) {
            d = dMatrix6.f2414a4;
        }
        if (dMatrix6.f2415a5 > d) {
            d = dMatrix6.f2415a5;
        }
        return dMatrix6.f2416a6 > d ? dMatrix6.f2416a6 : d;
    }

    public static double elementMaxAbs(DMatrix6x6 dMatrix6x6) {
        double dAbs = Math.abs(dMatrix6x6.a11);
        double dAbs2 = Math.abs(dMatrix6x6.a12);
        if (dAbs2 > dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix6x6.a13);
        if (dAbs3 > dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix6x6.a14);
        if (dAbs4 > dAbs) {
            dAbs = dAbs4;
        }
        double dAbs5 = Math.abs(dMatrix6x6.a15);
        if (dAbs5 > dAbs) {
            dAbs = dAbs5;
        }
        double dAbs6 = Math.abs(dMatrix6x6.a16);
        if (dAbs6 > dAbs) {
            dAbs = dAbs6;
        }
        double dAbs7 = Math.abs(dMatrix6x6.a21);
        if (dAbs7 > dAbs) {
            dAbs = dAbs7;
        }
        double dAbs8 = Math.abs(dMatrix6x6.a22);
        if (dAbs8 > dAbs) {
            dAbs = dAbs8;
        }
        double dAbs9 = Math.abs(dMatrix6x6.a23);
        if (dAbs9 > dAbs) {
            dAbs = dAbs9;
        }
        double dAbs10 = Math.abs(dMatrix6x6.a24);
        if (dAbs10 > dAbs) {
            dAbs = dAbs10;
        }
        double dAbs11 = Math.abs(dMatrix6x6.a25);
        if (dAbs11 > dAbs) {
            dAbs = dAbs11;
        }
        double dAbs12 = Math.abs(dMatrix6x6.a26);
        if (dAbs12 > dAbs) {
            dAbs = dAbs12;
        }
        double dAbs13 = Math.abs(dMatrix6x6.a31);
        if (dAbs13 > dAbs) {
            dAbs = dAbs13;
        }
        double dAbs14 = Math.abs(dMatrix6x6.a32);
        if (dAbs14 > dAbs) {
            dAbs = dAbs14;
        }
        double dAbs15 = Math.abs(dMatrix6x6.a33);
        if (dAbs15 > dAbs) {
            dAbs = dAbs15;
        }
        double dAbs16 = Math.abs(dMatrix6x6.a34);
        if (dAbs16 > dAbs) {
            dAbs = dAbs16;
        }
        double dAbs17 = Math.abs(dMatrix6x6.a35);
        if (dAbs17 > dAbs) {
            dAbs = dAbs17;
        }
        double dAbs18 = Math.abs(dMatrix6x6.a36);
        if (dAbs18 > dAbs) {
            dAbs = dAbs18;
        }
        double dAbs19 = Math.abs(dMatrix6x6.a41);
        if (dAbs19 > dAbs) {
            dAbs = dAbs19;
        }
        double dAbs20 = Math.abs(dMatrix6x6.a42);
        if (dAbs20 > dAbs) {
            dAbs = dAbs20;
        }
        double dAbs21 = Math.abs(dMatrix6x6.a43);
        if (dAbs21 > dAbs) {
            dAbs = dAbs21;
        }
        double dAbs22 = Math.abs(dMatrix6x6.a44);
        if (dAbs22 > dAbs) {
            dAbs = dAbs22;
        }
        double dAbs23 = Math.abs(dMatrix6x6.a45);
        if (dAbs23 > dAbs) {
            dAbs = dAbs23;
        }
        double dAbs24 = Math.abs(dMatrix6x6.a46);
        if (dAbs24 > dAbs) {
            dAbs = dAbs24;
        }
        double dAbs25 = Math.abs(dMatrix6x6.a51);
        if (dAbs25 > dAbs) {
            dAbs = dAbs25;
        }
        double dAbs26 = Math.abs(dMatrix6x6.a52);
        if (dAbs26 > dAbs) {
            dAbs = dAbs26;
        }
        double dAbs27 = Math.abs(dMatrix6x6.a53);
        if (dAbs27 > dAbs) {
            dAbs = dAbs27;
        }
        double dAbs28 = Math.abs(dMatrix6x6.a54);
        if (dAbs28 > dAbs) {
            dAbs = dAbs28;
        }
        double dAbs29 = Math.abs(dMatrix6x6.a55);
        if (dAbs29 > dAbs) {
            dAbs = dAbs29;
        }
        double dAbs30 = Math.abs(dMatrix6x6.a56);
        if (dAbs30 > dAbs) {
            dAbs = dAbs30;
        }
        double dAbs31 = Math.abs(dMatrix6x6.a61);
        if (dAbs31 > dAbs) {
            dAbs = dAbs31;
        }
        double dAbs32 = Math.abs(dMatrix6x6.a62);
        if (dAbs32 > dAbs) {
            dAbs = dAbs32;
        }
        double dAbs33 = Math.abs(dMatrix6x6.a63);
        if (dAbs33 > dAbs) {
            dAbs = dAbs33;
        }
        double dAbs34 = Math.abs(dMatrix6x6.a64);
        if (dAbs34 > dAbs) {
            dAbs = dAbs34;
        }
        double dAbs35 = Math.abs(dMatrix6x6.a65);
        if (dAbs35 > dAbs) {
            dAbs = dAbs35;
        }
        double dAbs36 = Math.abs(dMatrix6x6.a66);
        return dAbs36 > dAbs ? dAbs36 : dAbs;
    }

    public static double elementMaxAbs(DMatrix6 dMatrix6) {
        double dAbs = Math.abs(dMatrix6.f2411a1);
        double dAbs2 = Math.abs(dMatrix6.f2412a2);
        if (dAbs2 > dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix6.f2412a2);
        if (dAbs3 > dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix6.f2413a3);
        if (dAbs4 > dAbs) {
            dAbs = dAbs4;
        }
        double dAbs5 = Math.abs(dMatrix6.f2414a4);
        if (dAbs5 > dAbs) {
            dAbs = dAbs5;
        }
        double dAbs6 = Math.abs(dMatrix6.f2415a5);
        if (dAbs6 > dAbs) {
            dAbs = dAbs6;
        }
        double dAbs7 = Math.abs(dMatrix6.f2416a6);
        return dAbs7 > dAbs ? dAbs7 : dAbs;
    }

    public static double elementMin(DMatrix6x6 dMatrix6x6) {
        double d = dMatrix6x6.a11;
        if (dMatrix6x6.a12 < d) {
            d = dMatrix6x6.a12;
        }
        if (dMatrix6x6.a13 < d) {
            d = dMatrix6x6.a13;
        }
        if (dMatrix6x6.a14 < d) {
            d = dMatrix6x6.a14;
        }
        if (dMatrix6x6.a15 < d) {
            d = dMatrix6x6.a15;
        }
        if (dMatrix6x6.a16 < d) {
            d = dMatrix6x6.a16;
        }
        if (dMatrix6x6.a21 < d) {
            d = dMatrix6x6.a21;
        }
        if (dMatrix6x6.a22 < d) {
            d = dMatrix6x6.a22;
        }
        if (dMatrix6x6.a23 < d) {
            d = dMatrix6x6.a23;
        }
        if (dMatrix6x6.a24 < d) {
            d = dMatrix6x6.a24;
        }
        if (dMatrix6x6.a25 < d) {
            d = dMatrix6x6.a25;
        }
        if (dMatrix6x6.a26 < d) {
            d = dMatrix6x6.a26;
        }
        if (dMatrix6x6.a31 < d) {
            d = dMatrix6x6.a31;
        }
        if (dMatrix6x6.a32 < d) {
            d = dMatrix6x6.a32;
        }
        if (dMatrix6x6.a33 < d) {
            d = dMatrix6x6.a33;
        }
        if (dMatrix6x6.a34 < d) {
            d = dMatrix6x6.a34;
        }
        if (dMatrix6x6.a35 < d) {
            d = dMatrix6x6.a35;
        }
        if (dMatrix6x6.a36 < d) {
            d = dMatrix6x6.a36;
        }
        if (dMatrix6x6.a41 < d) {
            d = dMatrix6x6.a41;
        }
        if (dMatrix6x6.a42 < d) {
            d = dMatrix6x6.a42;
        }
        if (dMatrix6x6.a43 < d) {
            d = dMatrix6x6.a43;
        }
        if (dMatrix6x6.a44 < d) {
            d = dMatrix6x6.a44;
        }
        if (dMatrix6x6.a45 < d) {
            d = dMatrix6x6.a45;
        }
        if (dMatrix6x6.a46 < d) {
            d = dMatrix6x6.a46;
        }
        if (dMatrix6x6.a51 < d) {
            d = dMatrix6x6.a51;
        }
        if (dMatrix6x6.a52 < d) {
            d = dMatrix6x6.a52;
        }
        if (dMatrix6x6.a53 < d) {
            d = dMatrix6x6.a53;
        }
        if (dMatrix6x6.a54 < d) {
            d = dMatrix6x6.a54;
        }
        if (dMatrix6x6.a55 < d) {
            d = dMatrix6x6.a55;
        }
        if (dMatrix6x6.a56 < d) {
            d = dMatrix6x6.a56;
        }
        if (dMatrix6x6.a61 < d) {
            d = dMatrix6x6.a61;
        }
        if (dMatrix6x6.a62 < d) {
            d = dMatrix6x6.a62;
        }
        if (dMatrix6x6.a63 < d) {
            d = dMatrix6x6.a63;
        }
        if (dMatrix6x6.a64 < d) {
            d = dMatrix6x6.a64;
        }
        if (dMatrix6x6.a65 < d) {
            d = dMatrix6x6.a65;
        }
        return dMatrix6x6.a66 < d ? dMatrix6x6.a66 : d;
    }

    public static double elementMin(DMatrix6 dMatrix6) {
        double d = dMatrix6.f2411a1;
        if (dMatrix6.f2412a2 < d) {
            d = dMatrix6.f2412a2;
        }
        if (dMatrix6.f2413a3 < d) {
            d = dMatrix6.f2413a3;
        }
        if (dMatrix6.f2414a4 < d) {
            d = dMatrix6.f2414a4;
        }
        if (dMatrix6.f2415a5 < d) {
            d = dMatrix6.f2415a5;
        }
        return dMatrix6.f2416a6 < d ? dMatrix6.f2416a6 : d;
    }

    public static double elementMinAbs(DMatrix6x6 dMatrix6x6) {
        double dAbs = Math.abs(dMatrix6x6.a11);
        double dAbs2 = Math.abs(dMatrix6x6.a12);
        if (dAbs2 < dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix6x6.a13);
        if (dAbs3 < dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix6x6.a14);
        if (dAbs4 < dAbs) {
            dAbs = dAbs4;
        }
        double dAbs5 = Math.abs(dMatrix6x6.a15);
        if (dAbs5 < dAbs) {
            dAbs = dAbs5;
        }
        double dAbs6 = Math.abs(dMatrix6x6.a16);
        if (dAbs6 < dAbs) {
            dAbs = dAbs6;
        }
        double dAbs7 = Math.abs(dMatrix6x6.a21);
        if (dAbs7 < dAbs) {
            dAbs = dAbs7;
        }
        double dAbs8 = Math.abs(dMatrix6x6.a22);
        if (dAbs8 < dAbs) {
            dAbs = dAbs8;
        }
        double dAbs9 = Math.abs(dMatrix6x6.a23);
        if (dAbs9 < dAbs) {
            dAbs = dAbs9;
        }
        double dAbs10 = Math.abs(dMatrix6x6.a24);
        if (dAbs10 < dAbs) {
            dAbs = dAbs10;
        }
        double dAbs11 = Math.abs(dMatrix6x6.a25);
        if (dAbs11 < dAbs) {
            dAbs = dAbs11;
        }
        double dAbs12 = Math.abs(dMatrix6x6.a26);
        if (dAbs12 < dAbs) {
            dAbs = dAbs12;
        }
        double dAbs13 = Math.abs(dMatrix6x6.a31);
        if (dAbs13 < dAbs) {
            dAbs = dAbs13;
        }
        double dAbs14 = Math.abs(dMatrix6x6.a32);
        if (dAbs14 < dAbs) {
            dAbs = dAbs14;
        }
        double dAbs15 = Math.abs(dMatrix6x6.a33);
        if (dAbs15 < dAbs) {
            dAbs = dAbs15;
        }
        double dAbs16 = Math.abs(dMatrix6x6.a34);
        if (dAbs16 < dAbs) {
            dAbs = dAbs16;
        }
        double dAbs17 = Math.abs(dMatrix6x6.a35);
        if (dAbs17 < dAbs) {
            dAbs = dAbs17;
        }
        double dAbs18 = Math.abs(dMatrix6x6.a36);
        if (dAbs18 < dAbs) {
            dAbs = dAbs18;
        }
        double dAbs19 = Math.abs(dMatrix6x6.a41);
        if (dAbs19 < dAbs) {
            dAbs = dAbs19;
        }
        double dAbs20 = Math.abs(dMatrix6x6.a42);
        if (dAbs20 < dAbs) {
            dAbs = dAbs20;
        }
        double dAbs21 = Math.abs(dMatrix6x6.a43);
        if (dAbs21 < dAbs) {
            dAbs = dAbs21;
        }
        double dAbs22 = Math.abs(dMatrix6x6.a44);
        if (dAbs22 < dAbs) {
            dAbs = dAbs22;
        }
        double dAbs23 = Math.abs(dMatrix6x6.a45);
        if (dAbs23 < dAbs) {
            dAbs = dAbs23;
        }
        double dAbs24 = Math.abs(dMatrix6x6.a46);
        if (dAbs24 < dAbs) {
            dAbs = dAbs24;
        }
        double dAbs25 = Math.abs(dMatrix6x6.a51);
        if (dAbs25 < dAbs) {
            dAbs = dAbs25;
        }
        double dAbs26 = Math.abs(dMatrix6x6.a52);
        if (dAbs26 < dAbs) {
            dAbs = dAbs26;
        }
        double dAbs27 = Math.abs(dMatrix6x6.a53);
        if (dAbs27 < dAbs) {
            dAbs = dAbs27;
        }
        double dAbs28 = Math.abs(dMatrix6x6.a54);
        if (dAbs28 < dAbs) {
            dAbs = dAbs28;
        }
        double dAbs29 = Math.abs(dMatrix6x6.a55);
        if (dAbs29 < dAbs) {
            dAbs = dAbs29;
        }
        double dAbs30 = Math.abs(dMatrix6x6.a56);
        if (dAbs30 < dAbs) {
            dAbs = dAbs30;
        }
        double dAbs31 = Math.abs(dMatrix6x6.a61);
        if (dAbs31 < dAbs) {
            dAbs = dAbs31;
        }
        double dAbs32 = Math.abs(dMatrix6x6.a62);
        if (dAbs32 < dAbs) {
            dAbs = dAbs32;
        }
        double dAbs33 = Math.abs(dMatrix6x6.a63);
        if (dAbs33 < dAbs) {
            dAbs = dAbs33;
        }
        double dAbs34 = Math.abs(dMatrix6x6.a64);
        if (dAbs34 < dAbs) {
            dAbs = dAbs34;
        }
        double dAbs35 = Math.abs(dMatrix6x6.a65);
        if (dAbs35 < dAbs) {
            dAbs = dAbs35;
        }
        double dAbs36 = Math.abs(dMatrix6x6.a66);
        return dAbs36 < dAbs ? dAbs36 : dAbs;
    }

    public static double elementMinAbs(DMatrix6 dMatrix6) {
        double dAbs = Math.abs(dMatrix6.f2411a1);
        double dAbs2 = Math.abs(dMatrix6.f2411a1);
        if (dAbs2 < dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix6.f2412a2);
        if (dAbs3 < dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix6.f2413a3);
        if (dAbs4 < dAbs) {
            dAbs = dAbs4;
        }
        double dAbs5 = Math.abs(dMatrix6.f2414a4);
        if (dAbs5 < dAbs) {
            dAbs = dAbs5;
        }
        double dAbs6 = Math.abs(dMatrix6.f2415a5);
        if (dAbs6 < dAbs) {
            dAbs = dAbs6;
        }
        double dAbs7 = Math.abs(dMatrix6.f2416a6);
        return dAbs7 < dAbs ? dAbs7 : dAbs;
    }

    public static void elementMult(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62) {
        dMatrix6x6.a11 *= dMatrix6x62.a11;
        dMatrix6x6.a12 *= dMatrix6x62.a12;
        dMatrix6x6.a13 *= dMatrix6x62.a13;
        dMatrix6x6.a14 *= dMatrix6x62.a14;
        dMatrix6x6.a15 *= dMatrix6x62.a15;
        dMatrix6x6.a16 *= dMatrix6x62.a16;
        dMatrix6x6.a21 *= dMatrix6x62.a21;
        dMatrix6x6.a22 *= dMatrix6x62.a22;
        dMatrix6x6.a23 *= dMatrix6x62.a23;
        dMatrix6x6.a24 *= dMatrix6x62.a24;
        dMatrix6x6.a25 *= dMatrix6x62.a25;
        dMatrix6x6.a26 *= dMatrix6x62.a26;
        dMatrix6x6.a31 *= dMatrix6x62.a31;
        dMatrix6x6.a32 *= dMatrix6x62.a32;
        dMatrix6x6.a33 *= dMatrix6x62.a33;
        dMatrix6x6.a34 *= dMatrix6x62.a34;
        dMatrix6x6.a35 *= dMatrix6x62.a35;
        dMatrix6x6.a36 *= dMatrix6x62.a36;
        dMatrix6x6.a41 *= dMatrix6x62.a41;
        dMatrix6x6.a42 *= dMatrix6x62.a42;
        dMatrix6x6.a43 *= dMatrix6x62.a43;
        dMatrix6x6.a44 *= dMatrix6x62.a44;
        dMatrix6x6.a45 *= dMatrix6x62.a45;
        dMatrix6x6.a46 *= dMatrix6x62.a46;
        dMatrix6x6.a51 *= dMatrix6x62.a51;
        dMatrix6x6.a52 *= dMatrix6x62.a52;
        dMatrix6x6.a53 *= dMatrix6x62.a53;
        dMatrix6x6.a54 *= dMatrix6x62.a54;
        dMatrix6x6.a55 *= dMatrix6x62.a55;
        dMatrix6x6.a56 *= dMatrix6x62.a56;
        dMatrix6x6.a61 *= dMatrix6x62.a61;
        dMatrix6x6.a62 *= dMatrix6x62.a62;
        dMatrix6x6.a63 *= dMatrix6x62.a63;
        dMatrix6x6.a64 *= dMatrix6x62.a64;
        dMatrix6x6.a65 *= dMatrix6x62.a65;
        dMatrix6x6.a66 *= dMatrix6x62.a66;
    }

    public static void elementMult(DMatrix6 dMatrix6, DMatrix6 dMatrix62) {
        dMatrix6.f2411a1 *= dMatrix62.f2411a1;
        dMatrix6.f2412a2 *= dMatrix62.f2412a2;
        dMatrix6.f2413a3 *= dMatrix62.f2413a3;
        dMatrix6.f2414a4 *= dMatrix62.f2414a4;
        dMatrix6.f2415a5 *= dMatrix62.f2415a5;
        dMatrix6.f2416a6 *= dMatrix62.f2416a6;
    }

    public static void elementMult(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62, DMatrix6x6 dMatrix6x63) {
        dMatrix6x63.a11 = dMatrix6x6.a11 * dMatrix6x62.a11;
        dMatrix6x63.a12 = dMatrix6x6.a12 * dMatrix6x62.a12;
        dMatrix6x63.a13 = dMatrix6x6.a13 * dMatrix6x62.a13;
        dMatrix6x63.a14 = dMatrix6x6.a14 * dMatrix6x62.a14;
        dMatrix6x63.a15 = dMatrix6x6.a15 * dMatrix6x62.a15;
        dMatrix6x63.a16 = dMatrix6x6.a16 * dMatrix6x62.a16;
        dMatrix6x63.a21 = dMatrix6x6.a21 * dMatrix6x62.a21;
        dMatrix6x63.a22 = dMatrix6x6.a22 * dMatrix6x62.a22;
        dMatrix6x63.a23 = dMatrix6x6.a23 * dMatrix6x62.a23;
        dMatrix6x63.a24 = dMatrix6x6.a24 * dMatrix6x62.a24;
        dMatrix6x63.a25 = dMatrix6x6.a25 * dMatrix6x62.a25;
        dMatrix6x63.a26 = dMatrix6x6.a26 * dMatrix6x62.a26;
        dMatrix6x63.a31 = dMatrix6x6.a31 * dMatrix6x62.a31;
        dMatrix6x63.a32 = dMatrix6x6.a32 * dMatrix6x62.a32;
        dMatrix6x63.a33 = dMatrix6x6.a33 * dMatrix6x62.a33;
        dMatrix6x63.a34 = dMatrix6x6.a34 * dMatrix6x62.a34;
        dMatrix6x63.a35 = dMatrix6x6.a35 * dMatrix6x62.a35;
        dMatrix6x63.a36 = dMatrix6x6.a36 * dMatrix6x62.a36;
        dMatrix6x63.a41 = dMatrix6x6.a41 * dMatrix6x62.a41;
        dMatrix6x63.a42 = dMatrix6x6.a42 * dMatrix6x62.a42;
        dMatrix6x63.a43 = dMatrix6x6.a43 * dMatrix6x62.a43;
        dMatrix6x63.a44 = dMatrix6x6.a44 * dMatrix6x62.a44;
        dMatrix6x63.a45 = dMatrix6x6.a45 * dMatrix6x62.a45;
        dMatrix6x63.a46 = dMatrix6x6.a46 * dMatrix6x62.a46;
        dMatrix6x63.a51 = dMatrix6x6.a51 * dMatrix6x62.a51;
        dMatrix6x63.a52 = dMatrix6x6.a52 * dMatrix6x62.a52;
        dMatrix6x63.a53 = dMatrix6x6.a53 * dMatrix6x62.a53;
        dMatrix6x63.a54 = dMatrix6x6.a54 * dMatrix6x62.a54;
        dMatrix6x63.a55 = dMatrix6x6.a55 * dMatrix6x62.a55;
        dMatrix6x63.a56 = dMatrix6x6.a56 * dMatrix6x62.a56;
        dMatrix6x63.a61 = dMatrix6x6.a61 * dMatrix6x62.a61;
        dMatrix6x63.a62 = dMatrix6x6.a62 * dMatrix6x62.a62;
        dMatrix6x63.a63 = dMatrix6x6.a63 * dMatrix6x62.a63;
        dMatrix6x63.a64 = dMatrix6x6.a64 * dMatrix6x62.a64;
        dMatrix6x63.a65 = dMatrix6x6.a65 * dMatrix6x62.a65;
        dMatrix6x63.a66 = dMatrix6x6.a66 * dMatrix6x62.a66;
    }

    public static void elementMult(DMatrix6 dMatrix6, DMatrix6 dMatrix62, DMatrix6 dMatrix63) {
        dMatrix63.f2411a1 = dMatrix6.f2411a1 * dMatrix62.f2411a1;
        dMatrix63.f2412a2 = dMatrix6.f2412a2 * dMatrix62.f2412a2;
        dMatrix63.f2413a3 = dMatrix6.f2413a3 * dMatrix62.f2413a3;
        dMatrix63.f2414a4 = dMatrix6.f2414a4 * dMatrix62.f2414a4;
        dMatrix63.f2415a5 = dMatrix6.f2415a5 * dMatrix62.f2415a5;
        dMatrix63.f2416a6 = dMatrix6.f2416a6 * dMatrix62.f2416a6;
    }

    public static void elementDiv(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62) {
        dMatrix6x6.a11 /= dMatrix6x62.a11;
        dMatrix6x6.a12 /= dMatrix6x62.a12;
        dMatrix6x6.a13 /= dMatrix6x62.a13;
        dMatrix6x6.a14 /= dMatrix6x62.a14;
        dMatrix6x6.a15 /= dMatrix6x62.a15;
        dMatrix6x6.a16 /= dMatrix6x62.a16;
        dMatrix6x6.a21 /= dMatrix6x62.a21;
        dMatrix6x6.a22 /= dMatrix6x62.a22;
        dMatrix6x6.a23 /= dMatrix6x62.a23;
        dMatrix6x6.a24 /= dMatrix6x62.a24;
        dMatrix6x6.a25 /= dMatrix6x62.a25;
        dMatrix6x6.a26 /= dMatrix6x62.a26;
        dMatrix6x6.a31 /= dMatrix6x62.a31;
        dMatrix6x6.a32 /= dMatrix6x62.a32;
        dMatrix6x6.a33 /= dMatrix6x62.a33;
        dMatrix6x6.a34 /= dMatrix6x62.a34;
        dMatrix6x6.a35 /= dMatrix6x62.a35;
        dMatrix6x6.a36 /= dMatrix6x62.a36;
        dMatrix6x6.a41 /= dMatrix6x62.a41;
        dMatrix6x6.a42 /= dMatrix6x62.a42;
        dMatrix6x6.a43 /= dMatrix6x62.a43;
        dMatrix6x6.a44 /= dMatrix6x62.a44;
        dMatrix6x6.a45 /= dMatrix6x62.a45;
        dMatrix6x6.a46 /= dMatrix6x62.a46;
        dMatrix6x6.a51 /= dMatrix6x62.a51;
        dMatrix6x6.a52 /= dMatrix6x62.a52;
        dMatrix6x6.a53 /= dMatrix6x62.a53;
        dMatrix6x6.a54 /= dMatrix6x62.a54;
        dMatrix6x6.a55 /= dMatrix6x62.a55;
        dMatrix6x6.a56 /= dMatrix6x62.a56;
        dMatrix6x6.a61 /= dMatrix6x62.a61;
        dMatrix6x6.a62 /= dMatrix6x62.a62;
        dMatrix6x6.a63 /= dMatrix6x62.a63;
        dMatrix6x6.a64 /= dMatrix6x62.a64;
        dMatrix6x6.a65 /= dMatrix6x62.a65;
        dMatrix6x6.a66 /= dMatrix6x62.a66;
    }

    public static void elementDiv(DMatrix6 dMatrix6, DMatrix6 dMatrix62) {
        dMatrix6.f2411a1 /= dMatrix62.f2411a1;
        dMatrix6.f2412a2 /= dMatrix62.f2412a2;
        dMatrix6.f2413a3 /= dMatrix62.f2413a3;
        dMatrix6.f2414a4 /= dMatrix62.f2414a4;
        dMatrix6.f2415a5 /= dMatrix62.f2415a5;
        dMatrix6.f2416a6 /= dMatrix62.f2416a6;
    }

    public static void elementDiv(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62, DMatrix6x6 dMatrix6x63) {
        dMatrix6x63.a11 = dMatrix6x6.a11 / dMatrix6x62.a11;
        dMatrix6x63.a12 = dMatrix6x6.a12 / dMatrix6x62.a12;
        dMatrix6x63.a13 = dMatrix6x6.a13 / dMatrix6x62.a13;
        dMatrix6x63.a14 = dMatrix6x6.a14 / dMatrix6x62.a14;
        dMatrix6x63.a15 = dMatrix6x6.a15 / dMatrix6x62.a15;
        dMatrix6x63.a16 = dMatrix6x6.a16 / dMatrix6x62.a16;
        dMatrix6x63.a21 = dMatrix6x6.a21 / dMatrix6x62.a21;
        dMatrix6x63.a22 = dMatrix6x6.a22 / dMatrix6x62.a22;
        dMatrix6x63.a23 = dMatrix6x6.a23 / dMatrix6x62.a23;
        dMatrix6x63.a24 = dMatrix6x6.a24 / dMatrix6x62.a24;
        dMatrix6x63.a25 = dMatrix6x6.a25 / dMatrix6x62.a25;
        dMatrix6x63.a26 = dMatrix6x6.a26 / dMatrix6x62.a26;
        dMatrix6x63.a31 = dMatrix6x6.a31 / dMatrix6x62.a31;
        dMatrix6x63.a32 = dMatrix6x6.a32 / dMatrix6x62.a32;
        dMatrix6x63.a33 = dMatrix6x6.a33 / dMatrix6x62.a33;
        dMatrix6x63.a34 = dMatrix6x6.a34 / dMatrix6x62.a34;
        dMatrix6x63.a35 = dMatrix6x6.a35 / dMatrix6x62.a35;
        dMatrix6x63.a36 = dMatrix6x6.a36 / dMatrix6x62.a36;
        dMatrix6x63.a41 = dMatrix6x6.a41 / dMatrix6x62.a41;
        dMatrix6x63.a42 = dMatrix6x6.a42 / dMatrix6x62.a42;
        dMatrix6x63.a43 = dMatrix6x6.a43 / dMatrix6x62.a43;
        dMatrix6x63.a44 = dMatrix6x6.a44 / dMatrix6x62.a44;
        dMatrix6x63.a45 = dMatrix6x6.a45 / dMatrix6x62.a45;
        dMatrix6x63.a46 = dMatrix6x6.a46 / dMatrix6x62.a46;
        dMatrix6x63.a51 = dMatrix6x6.a51 / dMatrix6x62.a51;
        dMatrix6x63.a52 = dMatrix6x6.a52 / dMatrix6x62.a52;
        dMatrix6x63.a53 = dMatrix6x6.a53 / dMatrix6x62.a53;
        dMatrix6x63.a54 = dMatrix6x6.a54 / dMatrix6x62.a54;
        dMatrix6x63.a55 = dMatrix6x6.a55 / dMatrix6x62.a55;
        dMatrix6x63.a56 = dMatrix6x6.a56 / dMatrix6x62.a56;
        dMatrix6x63.a61 = dMatrix6x6.a61 / dMatrix6x62.a61;
        dMatrix6x63.a62 = dMatrix6x6.a62 / dMatrix6x62.a62;
        dMatrix6x63.a63 = dMatrix6x6.a63 / dMatrix6x62.a63;
        dMatrix6x63.a64 = dMatrix6x6.a64 / dMatrix6x62.a64;
        dMatrix6x63.a65 = dMatrix6x6.a65 / dMatrix6x62.a65;
        dMatrix6x63.a66 = dMatrix6x6.a66 / dMatrix6x62.a66;
    }

    public static void elementDiv(DMatrix6 dMatrix6, DMatrix6 dMatrix62, DMatrix6 dMatrix63) {
        dMatrix63.f2411a1 = dMatrix6.f2411a1 / dMatrix62.f2411a1;
        dMatrix63.f2412a2 = dMatrix6.f2412a2 / dMatrix62.f2412a2;
        dMatrix63.f2413a3 = dMatrix6.f2413a3 / dMatrix62.f2413a3;
        dMatrix63.f2414a4 = dMatrix6.f2414a4 / dMatrix62.f2414a4;
        dMatrix63.f2415a5 = dMatrix6.f2415a5 / dMatrix62.f2415a5;
        dMatrix63.f2416a6 = dMatrix6.f2416a6 / dMatrix62.f2416a6;
    }

    public static void scale(double d, DMatrix6x6 dMatrix6x6) {
        dMatrix6x6.a11 *= d;
        dMatrix6x6.a12 *= d;
        dMatrix6x6.a13 *= d;
        dMatrix6x6.a14 *= d;
        dMatrix6x6.a15 *= d;
        dMatrix6x6.a16 *= d;
        dMatrix6x6.a21 *= d;
        dMatrix6x6.a22 *= d;
        dMatrix6x6.a23 *= d;
        dMatrix6x6.a24 *= d;
        dMatrix6x6.a25 *= d;
        dMatrix6x6.a26 *= d;
        dMatrix6x6.a31 *= d;
        dMatrix6x6.a32 *= d;
        dMatrix6x6.a33 *= d;
        dMatrix6x6.a34 *= d;
        dMatrix6x6.a35 *= d;
        dMatrix6x6.a36 *= d;
        dMatrix6x6.a41 *= d;
        dMatrix6x6.a42 *= d;
        dMatrix6x6.a43 *= d;
        dMatrix6x6.a44 *= d;
        dMatrix6x6.a45 *= d;
        dMatrix6x6.a46 *= d;
        dMatrix6x6.a51 *= d;
        dMatrix6x6.a52 *= d;
        dMatrix6x6.a53 *= d;
        dMatrix6x6.a54 *= d;
        dMatrix6x6.a55 *= d;
        dMatrix6x6.a56 *= d;
        dMatrix6x6.a61 *= d;
        dMatrix6x6.a62 *= d;
        dMatrix6x6.a63 *= d;
        dMatrix6x6.a64 *= d;
        dMatrix6x6.a65 *= d;
        dMatrix6x6.a66 *= d;
    }

    public static void scale(double d, DMatrix6 dMatrix6) {
        dMatrix6.f2411a1 *= d;
        dMatrix6.f2412a2 *= d;
        dMatrix6.f2413a3 *= d;
        dMatrix6.f2414a4 *= d;
        dMatrix6.f2415a5 *= d;
        dMatrix6.f2416a6 *= d;
    }

    public static void scale(double d, DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62) {
        dMatrix6x62.a11 = dMatrix6x6.a11 * d;
        dMatrix6x62.a12 = dMatrix6x6.a12 * d;
        dMatrix6x62.a13 = dMatrix6x6.a13 * d;
        dMatrix6x62.a14 = dMatrix6x6.a14 * d;
        dMatrix6x62.a15 = dMatrix6x6.a15 * d;
        dMatrix6x62.a16 = dMatrix6x6.a16 * d;
        dMatrix6x62.a21 = dMatrix6x6.a21 * d;
        dMatrix6x62.a22 = dMatrix6x6.a22 * d;
        dMatrix6x62.a23 = dMatrix6x6.a23 * d;
        dMatrix6x62.a24 = dMatrix6x6.a24 * d;
        dMatrix6x62.a25 = dMatrix6x6.a25 * d;
        dMatrix6x62.a26 = dMatrix6x6.a26 * d;
        dMatrix6x62.a31 = dMatrix6x6.a31 * d;
        dMatrix6x62.a32 = dMatrix6x6.a32 * d;
        dMatrix6x62.a33 = dMatrix6x6.a33 * d;
        dMatrix6x62.a34 = dMatrix6x6.a34 * d;
        dMatrix6x62.a35 = dMatrix6x6.a35 * d;
        dMatrix6x62.a36 = dMatrix6x6.a36 * d;
        dMatrix6x62.a41 = dMatrix6x6.a41 * d;
        dMatrix6x62.a42 = dMatrix6x6.a42 * d;
        dMatrix6x62.a43 = dMatrix6x6.a43 * d;
        dMatrix6x62.a44 = dMatrix6x6.a44 * d;
        dMatrix6x62.a45 = dMatrix6x6.a45 * d;
        dMatrix6x62.a46 = dMatrix6x6.a46 * d;
        dMatrix6x62.a51 = dMatrix6x6.a51 * d;
        dMatrix6x62.a52 = dMatrix6x6.a52 * d;
        dMatrix6x62.a53 = dMatrix6x6.a53 * d;
        dMatrix6x62.a54 = dMatrix6x6.a54 * d;
        dMatrix6x62.a55 = dMatrix6x6.a55 * d;
        dMatrix6x62.a56 = dMatrix6x6.a56 * d;
        dMatrix6x62.a61 = dMatrix6x6.a61 * d;
        dMatrix6x62.a62 = dMatrix6x6.a62 * d;
        dMatrix6x62.a63 = dMatrix6x6.a63 * d;
        dMatrix6x62.a64 = dMatrix6x6.a64 * d;
        dMatrix6x62.a65 = dMatrix6x6.a65 * d;
        dMatrix6x62.a66 = dMatrix6x6.a66 * d;
    }

    public static void scale(double d, DMatrix6 dMatrix6, DMatrix6 dMatrix62) {
        dMatrix62.f2411a1 = dMatrix6.f2411a1 * d;
        dMatrix62.f2412a2 = dMatrix6.f2412a2 * d;
        dMatrix62.f2413a3 = dMatrix6.f2413a3 * d;
        dMatrix62.f2414a4 = dMatrix6.f2414a4 * d;
        dMatrix62.f2415a5 = dMatrix6.f2415a5 * d;
        dMatrix62.f2416a6 = dMatrix6.f2416a6 * d;
    }

    public static void divide(DMatrix6x6 dMatrix6x6, double d) {
        dMatrix6x6.a11 /= d;
        dMatrix6x6.a12 /= d;
        dMatrix6x6.a13 /= d;
        dMatrix6x6.a14 /= d;
        dMatrix6x6.a15 /= d;
        dMatrix6x6.a16 /= d;
        dMatrix6x6.a21 /= d;
        dMatrix6x6.a22 /= d;
        dMatrix6x6.a23 /= d;
        dMatrix6x6.a24 /= d;
        dMatrix6x6.a25 /= d;
        dMatrix6x6.a26 /= d;
        dMatrix6x6.a31 /= d;
        dMatrix6x6.a32 /= d;
        dMatrix6x6.a33 /= d;
        dMatrix6x6.a34 /= d;
        dMatrix6x6.a35 /= d;
        dMatrix6x6.a36 /= d;
        dMatrix6x6.a41 /= d;
        dMatrix6x6.a42 /= d;
        dMatrix6x6.a43 /= d;
        dMatrix6x6.a44 /= d;
        dMatrix6x6.a45 /= d;
        dMatrix6x6.a46 /= d;
        dMatrix6x6.a51 /= d;
        dMatrix6x6.a52 /= d;
        dMatrix6x6.a53 /= d;
        dMatrix6x6.a54 /= d;
        dMatrix6x6.a55 /= d;
        dMatrix6x6.a56 /= d;
        dMatrix6x6.a61 /= d;
        dMatrix6x6.a62 /= d;
        dMatrix6x6.a63 /= d;
        dMatrix6x6.a64 /= d;
        dMatrix6x6.a65 /= d;
        dMatrix6x6.a66 /= d;
    }

    public static void divide(DMatrix6 dMatrix6, double d) {
        dMatrix6.f2411a1 /= d;
        dMatrix6.f2412a2 /= d;
        dMatrix6.f2413a3 /= d;
        dMatrix6.f2414a4 /= d;
        dMatrix6.f2415a5 /= d;
        dMatrix6.f2416a6 /= d;
    }

    public static void divide(DMatrix6x6 dMatrix6x6, double d, DMatrix6x6 dMatrix6x62) {
        dMatrix6x62.a11 = dMatrix6x6.a11 / d;
        dMatrix6x62.a12 = dMatrix6x6.a12 / d;
        dMatrix6x62.a13 = dMatrix6x6.a13 / d;
        dMatrix6x62.a14 = dMatrix6x6.a14 / d;
        dMatrix6x62.a15 = dMatrix6x6.a15 / d;
        dMatrix6x62.a16 = dMatrix6x6.a16 / d;
        dMatrix6x62.a21 = dMatrix6x6.a21 / d;
        dMatrix6x62.a22 = dMatrix6x6.a22 / d;
        dMatrix6x62.a23 = dMatrix6x6.a23 / d;
        dMatrix6x62.a24 = dMatrix6x6.a24 / d;
        dMatrix6x62.a25 = dMatrix6x6.a25 / d;
        dMatrix6x62.a26 = dMatrix6x6.a26 / d;
        dMatrix6x62.a31 = dMatrix6x6.a31 / d;
        dMatrix6x62.a32 = dMatrix6x6.a32 / d;
        dMatrix6x62.a33 = dMatrix6x6.a33 / d;
        dMatrix6x62.a34 = dMatrix6x6.a34 / d;
        dMatrix6x62.a35 = dMatrix6x6.a35 / d;
        dMatrix6x62.a36 = dMatrix6x6.a36 / d;
        dMatrix6x62.a41 = dMatrix6x6.a41 / d;
        dMatrix6x62.a42 = dMatrix6x6.a42 / d;
        dMatrix6x62.a43 = dMatrix6x6.a43 / d;
        dMatrix6x62.a44 = dMatrix6x6.a44 / d;
        dMatrix6x62.a45 = dMatrix6x6.a45 / d;
        dMatrix6x62.a46 = dMatrix6x6.a46 / d;
        dMatrix6x62.a51 = dMatrix6x6.a51 / d;
        dMatrix6x62.a52 = dMatrix6x6.a52 / d;
        dMatrix6x62.a53 = dMatrix6x6.a53 / d;
        dMatrix6x62.a54 = dMatrix6x6.a54 / d;
        dMatrix6x62.a55 = dMatrix6x6.a55 / d;
        dMatrix6x62.a56 = dMatrix6x6.a56 / d;
        dMatrix6x62.a61 = dMatrix6x6.a61 / d;
        dMatrix6x62.a62 = dMatrix6x6.a62 / d;
        dMatrix6x62.a63 = dMatrix6x6.a63 / d;
        dMatrix6x62.a64 = dMatrix6x6.a64 / d;
        dMatrix6x62.a65 = dMatrix6x6.a65 / d;
        dMatrix6x62.a66 = dMatrix6x6.a66 / d;
    }

    public static void divide(DMatrix6 dMatrix6, double d, DMatrix6 dMatrix62) {
        dMatrix62.f2411a1 = dMatrix6.f2411a1 / d;
        dMatrix62.f2412a2 = dMatrix6.f2412a2 / d;
        dMatrix62.f2413a3 = dMatrix6.f2413a3 / d;
        dMatrix62.f2414a4 = dMatrix6.f2414a4 / d;
        dMatrix62.f2415a5 = dMatrix6.f2415a5 / d;
        dMatrix62.f2416a6 = dMatrix6.f2416a6 / d;
    }

    public static void changeSign(DMatrix6x6 dMatrix6x6) {
        dMatrix6x6.a11 = -dMatrix6x6.a11;
        dMatrix6x6.a12 = -dMatrix6x6.a12;
        dMatrix6x6.a13 = -dMatrix6x6.a13;
        dMatrix6x6.a14 = -dMatrix6x6.a14;
        dMatrix6x6.a15 = -dMatrix6x6.a15;
        dMatrix6x6.a16 = -dMatrix6x6.a16;
        dMatrix6x6.a21 = -dMatrix6x6.a21;
        dMatrix6x6.a22 = -dMatrix6x6.a22;
        dMatrix6x6.a23 = -dMatrix6x6.a23;
        dMatrix6x6.a24 = -dMatrix6x6.a24;
        dMatrix6x6.a25 = -dMatrix6x6.a25;
        dMatrix6x6.a26 = -dMatrix6x6.a26;
        dMatrix6x6.a31 = -dMatrix6x6.a31;
        dMatrix6x6.a32 = -dMatrix6x6.a32;
        dMatrix6x6.a33 = -dMatrix6x6.a33;
        dMatrix6x6.a34 = -dMatrix6x6.a34;
        dMatrix6x6.a35 = -dMatrix6x6.a35;
        dMatrix6x6.a36 = -dMatrix6x6.a36;
        dMatrix6x6.a41 = -dMatrix6x6.a41;
        dMatrix6x6.a42 = -dMatrix6x6.a42;
        dMatrix6x6.a43 = -dMatrix6x6.a43;
        dMatrix6x6.a44 = -dMatrix6x6.a44;
        dMatrix6x6.a45 = -dMatrix6x6.a45;
        dMatrix6x6.a46 = -dMatrix6x6.a46;
        dMatrix6x6.a51 = -dMatrix6x6.a51;
        dMatrix6x6.a52 = -dMatrix6x6.a52;
        dMatrix6x6.a53 = -dMatrix6x6.a53;
        dMatrix6x6.a54 = -dMatrix6x6.a54;
        dMatrix6x6.a55 = -dMatrix6x6.a55;
        dMatrix6x6.a56 = -dMatrix6x6.a56;
        dMatrix6x6.a61 = -dMatrix6x6.a61;
        dMatrix6x6.a62 = -dMatrix6x6.a62;
        dMatrix6x6.a63 = -dMatrix6x6.a63;
        dMatrix6x6.a64 = -dMatrix6x6.a64;
        dMatrix6x6.a65 = -dMatrix6x6.a65;
        dMatrix6x6.a66 = -dMatrix6x6.a66;
    }

    public static void changeSign(DMatrix6 dMatrix6) {
        dMatrix6.f2411a1 = -dMatrix6.f2411a1;
        dMatrix6.f2412a2 = -dMatrix6.f2412a2;
        dMatrix6.f2413a3 = -dMatrix6.f2413a3;
        dMatrix6.f2414a4 = -dMatrix6.f2414a4;
        dMatrix6.f2415a5 = -dMatrix6.f2415a5;
        dMatrix6.f2416a6 = -dMatrix6.f2416a6;
    }

    public static void fill(DMatrix6x6 dMatrix6x6, double d) {
        dMatrix6x6.a11 = d;
        dMatrix6x6.a12 = d;
        dMatrix6x6.a13 = d;
        dMatrix6x6.a14 = d;
        dMatrix6x6.a15 = d;
        dMatrix6x6.a16 = d;
        dMatrix6x6.a21 = d;
        dMatrix6x6.a22 = d;
        dMatrix6x6.a23 = d;
        dMatrix6x6.a24 = d;
        dMatrix6x6.a25 = d;
        dMatrix6x6.a26 = d;
        dMatrix6x6.a31 = d;
        dMatrix6x6.a32 = d;
        dMatrix6x6.a33 = d;
        dMatrix6x6.a34 = d;
        dMatrix6x6.a35 = d;
        dMatrix6x6.a36 = d;
        dMatrix6x6.a41 = d;
        dMatrix6x6.a42 = d;
        dMatrix6x6.a43 = d;
        dMatrix6x6.a44 = d;
        dMatrix6x6.a45 = d;
        dMatrix6x6.a46 = d;
        dMatrix6x6.a51 = d;
        dMatrix6x6.a52 = d;
        dMatrix6x6.a53 = d;
        dMatrix6x6.a54 = d;
        dMatrix6x6.a55 = d;
        dMatrix6x6.a56 = d;
        dMatrix6x6.a61 = d;
        dMatrix6x6.a62 = d;
        dMatrix6x6.a63 = d;
        dMatrix6x6.a64 = d;
        dMatrix6x6.a65 = d;
        dMatrix6x6.a66 = d;
    }

    public static void fill(DMatrix6 dMatrix6, double d) {
        dMatrix6.f2411a1 = d;
        dMatrix6.f2412a2 = d;
        dMatrix6.f2413a3 = d;
        dMatrix6.f2414a4 = d;
        dMatrix6.f2415a5 = d;
        dMatrix6.f2416a6 = d;
    }

    public static DMatrix6 extractRow(DMatrix6x6 dMatrix6x6, int i, DMatrix6 dMatrix6) {
        if (dMatrix6 == null) {
            dMatrix6 = new DMatrix6();
        }
        if (i == 0) {
            dMatrix6.f2411a1 = dMatrix6x6.a11;
            dMatrix6.f2412a2 = dMatrix6x6.a12;
            dMatrix6.f2413a3 = dMatrix6x6.a13;
            dMatrix6.f2414a4 = dMatrix6x6.a14;
            dMatrix6.f2415a5 = dMatrix6x6.a15;
            dMatrix6.f2416a6 = dMatrix6x6.a16;
            return dMatrix6;
        }
        if (i == 1) {
            dMatrix6.f2411a1 = dMatrix6x6.a21;
            dMatrix6.f2412a2 = dMatrix6x6.a22;
            dMatrix6.f2413a3 = dMatrix6x6.a23;
            dMatrix6.f2414a4 = dMatrix6x6.a24;
            dMatrix6.f2415a5 = dMatrix6x6.a25;
            dMatrix6.f2416a6 = dMatrix6x6.a26;
            return dMatrix6;
        }
        if (i == 2) {
            dMatrix6.f2411a1 = dMatrix6x6.a31;
            dMatrix6.f2412a2 = dMatrix6x6.a32;
            dMatrix6.f2413a3 = dMatrix6x6.a33;
            dMatrix6.f2414a4 = dMatrix6x6.a34;
            dMatrix6.f2415a5 = dMatrix6x6.a35;
            dMatrix6.f2416a6 = dMatrix6x6.a36;
            return dMatrix6;
        }
        if (i == 3) {
            dMatrix6.f2411a1 = dMatrix6x6.a41;
            dMatrix6.f2412a2 = dMatrix6x6.a42;
            dMatrix6.f2413a3 = dMatrix6x6.a43;
            dMatrix6.f2414a4 = dMatrix6x6.a44;
            dMatrix6.f2415a5 = dMatrix6x6.a45;
            dMatrix6.f2416a6 = dMatrix6x6.a46;
            return dMatrix6;
        }
        if (i == 4) {
            dMatrix6.f2411a1 = dMatrix6x6.a51;
            dMatrix6.f2412a2 = dMatrix6x6.a52;
            dMatrix6.f2413a3 = dMatrix6x6.a53;
            dMatrix6.f2414a4 = dMatrix6x6.a54;
            dMatrix6.f2415a5 = dMatrix6x6.a55;
            dMatrix6.f2416a6 = dMatrix6x6.a56;
            return dMatrix6;
        }
        if (i == 5) {
            dMatrix6.f2411a1 = dMatrix6x6.a61;
            dMatrix6.f2412a2 = dMatrix6x6.a62;
            dMatrix6.f2413a3 = dMatrix6x6.a63;
            dMatrix6.f2414a4 = dMatrix6x6.a64;
            dMatrix6.f2415a5 = dMatrix6x6.a65;
            dMatrix6.f2416a6 = dMatrix6x6.a66;
            return dMatrix6;
        }
        throw new IllegalArgumentException("Out of bounds row.  row = " + i);
    }

    public static DMatrix6 extractColumn(DMatrix6x6 dMatrix6x6, int i, DMatrix6 dMatrix6) {
        if (dMatrix6 == null) {
            dMatrix6 = new DMatrix6();
        }
        if (i == 0) {
            dMatrix6.f2411a1 = dMatrix6x6.a11;
            dMatrix6.f2412a2 = dMatrix6x6.a21;
            dMatrix6.f2413a3 = dMatrix6x6.a31;
            dMatrix6.f2414a4 = dMatrix6x6.a41;
            dMatrix6.f2415a5 = dMatrix6x6.a51;
            dMatrix6.f2416a6 = dMatrix6x6.a61;
            return dMatrix6;
        }
        if (i == 1) {
            dMatrix6.f2411a1 = dMatrix6x6.a12;
            dMatrix6.f2412a2 = dMatrix6x6.a22;
            dMatrix6.f2413a3 = dMatrix6x6.a32;
            dMatrix6.f2414a4 = dMatrix6x6.a42;
            dMatrix6.f2415a5 = dMatrix6x6.a52;
            dMatrix6.f2416a6 = dMatrix6x6.a62;
            return dMatrix6;
        }
        if (i == 2) {
            dMatrix6.f2411a1 = dMatrix6x6.a13;
            dMatrix6.f2412a2 = dMatrix6x6.a23;
            dMatrix6.f2413a3 = dMatrix6x6.a33;
            dMatrix6.f2414a4 = dMatrix6x6.a43;
            dMatrix6.f2415a5 = dMatrix6x6.a53;
            dMatrix6.f2416a6 = dMatrix6x6.a63;
            return dMatrix6;
        }
        if (i == 3) {
            dMatrix6.f2411a1 = dMatrix6x6.a14;
            dMatrix6.f2412a2 = dMatrix6x6.a24;
            dMatrix6.f2413a3 = dMatrix6x6.a34;
            dMatrix6.f2414a4 = dMatrix6x6.a44;
            dMatrix6.f2415a5 = dMatrix6x6.a54;
            dMatrix6.f2416a6 = dMatrix6x6.a64;
            return dMatrix6;
        }
        if (i == 4) {
            dMatrix6.f2411a1 = dMatrix6x6.a15;
            dMatrix6.f2412a2 = dMatrix6x6.a25;
            dMatrix6.f2413a3 = dMatrix6x6.a35;
            dMatrix6.f2414a4 = dMatrix6x6.a45;
            dMatrix6.f2415a5 = dMatrix6x6.a55;
            dMatrix6.f2416a6 = dMatrix6x6.a65;
            return dMatrix6;
        }
        if (i == 5) {
            dMatrix6.f2411a1 = dMatrix6x6.a16;
            dMatrix6.f2412a2 = dMatrix6x6.a26;
            dMatrix6.f2413a3 = dMatrix6x6.a36;
            dMatrix6.f2414a4 = dMatrix6x6.a46;
            dMatrix6.f2415a5 = dMatrix6x6.a56;
            dMatrix6.f2416a6 = dMatrix6x6.a66;
            return dMatrix6;
        }
        throw new IllegalArgumentException("Out of bounds column.  column = " + i);
    }
}
