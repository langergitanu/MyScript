package org.ejml.dense.fixed;

import org.ejml.data.FMatrix5;
import org.ejml.data.FMatrix5x5;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_FDF5 {
    public static void add(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52, FMatrix5x5 fMatrix5x53) {
        fMatrix5x53.a11 = fMatrix5x5.a11 + fMatrix5x52.a11;
        fMatrix5x53.a12 = fMatrix5x5.a12 + fMatrix5x52.a12;
        fMatrix5x53.a13 = fMatrix5x5.a13 + fMatrix5x52.a13;
        fMatrix5x53.a14 = fMatrix5x5.a14 + fMatrix5x52.a14;
        fMatrix5x53.a15 = fMatrix5x5.a15 + fMatrix5x52.a15;
        fMatrix5x53.a21 = fMatrix5x5.a21 + fMatrix5x52.a21;
        fMatrix5x53.a22 = fMatrix5x5.a22 + fMatrix5x52.a22;
        fMatrix5x53.a23 = fMatrix5x5.a23 + fMatrix5x52.a23;
        fMatrix5x53.a24 = fMatrix5x5.a24 + fMatrix5x52.a24;
        fMatrix5x53.a25 = fMatrix5x5.a25 + fMatrix5x52.a25;
        fMatrix5x53.a31 = fMatrix5x5.a31 + fMatrix5x52.a31;
        fMatrix5x53.a32 = fMatrix5x5.a32 + fMatrix5x52.a32;
        fMatrix5x53.a33 = fMatrix5x5.a33 + fMatrix5x52.a33;
        fMatrix5x53.a34 = fMatrix5x5.a34 + fMatrix5x52.a34;
        fMatrix5x53.a35 = fMatrix5x5.a35 + fMatrix5x52.a35;
        fMatrix5x53.a41 = fMatrix5x5.a41 + fMatrix5x52.a41;
        fMatrix5x53.a42 = fMatrix5x5.a42 + fMatrix5x52.a42;
        fMatrix5x53.a43 = fMatrix5x5.a43 + fMatrix5x52.a43;
        fMatrix5x53.a44 = fMatrix5x5.a44 + fMatrix5x52.a44;
        fMatrix5x53.a45 = fMatrix5x5.a45 + fMatrix5x52.a45;
        fMatrix5x53.a51 = fMatrix5x5.a51 + fMatrix5x52.a51;
        fMatrix5x53.a52 = fMatrix5x5.a52 + fMatrix5x52.a52;
        fMatrix5x53.a53 = fMatrix5x5.a53 + fMatrix5x52.a53;
        fMatrix5x53.a54 = fMatrix5x5.a54 + fMatrix5x52.a54;
        fMatrix5x53.a55 = fMatrix5x5.a55 + fMatrix5x52.a55;
    }

    public static void add(FMatrix5 fMatrix5, FMatrix5 fMatrix52, FMatrix5 fMatrix53) {
        fMatrix53.f2427a1 = fMatrix5.f2427a1 + fMatrix52.f2427a1;
        fMatrix53.f2428a2 = fMatrix5.f2428a2 + fMatrix52.f2428a2;
        fMatrix53.f2429a3 = fMatrix5.f2429a3 + fMatrix52.f2429a3;
        fMatrix53.f2430a4 = fMatrix5.f2430a4 + fMatrix52.f2430a4;
        fMatrix53.f2431a5 = fMatrix5.f2431a5 + fMatrix52.f2431a5;
    }

    public static void addEquals(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52) {
        fMatrix5x5.a11 += fMatrix5x52.a11;
        fMatrix5x5.a12 += fMatrix5x52.a12;
        fMatrix5x5.a13 += fMatrix5x52.a13;
        fMatrix5x5.a14 += fMatrix5x52.a14;
        fMatrix5x5.a15 += fMatrix5x52.a15;
        fMatrix5x5.a21 += fMatrix5x52.a21;
        fMatrix5x5.a22 += fMatrix5x52.a22;
        fMatrix5x5.a23 += fMatrix5x52.a23;
        fMatrix5x5.a24 += fMatrix5x52.a24;
        fMatrix5x5.a25 += fMatrix5x52.a25;
        fMatrix5x5.a31 += fMatrix5x52.a31;
        fMatrix5x5.a32 += fMatrix5x52.a32;
        fMatrix5x5.a33 += fMatrix5x52.a33;
        fMatrix5x5.a34 += fMatrix5x52.a34;
        fMatrix5x5.a35 += fMatrix5x52.a35;
        fMatrix5x5.a41 += fMatrix5x52.a41;
        fMatrix5x5.a42 += fMatrix5x52.a42;
        fMatrix5x5.a43 += fMatrix5x52.a43;
        fMatrix5x5.a44 += fMatrix5x52.a44;
        fMatrix5x5.a45 += fMatrix5x52.a45;
        fMatrix5x5.a51 += fMatrix5x52.a51;
        fMatrix5x5.a52 += fMatrix5x52.a52;
        fMatrix5x5.a53 += fMatrix5x52.a53;
        fMatrix5x5.a54 += fMatrix5x52.a54;
        fMatrix5x5.a55 += fMatrix5x52.a55;
    }

    public static void addEquals(FMatrix5 fMatrix5, FMatrix5 fMatrix52) {
        fMatrix5.f2427a1 += fMatrix52.f2427a1;
        fMatrix5.f2428a2 += fMatrix52.f2428a2;
        fMatrix5.f2429a3 += fMatrix52.f2429a3;
        fMatrix5.f2430a4 += fMatrix52.f2430a4;
        fMatrix5.f2431a5 += fMatrix52.f2431a5;
    }

    public static void subtract(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52, FMatrix5x5 fMatrix5x53) {
        fMatrix5x53.a11 = fMatrix5x5.a11 - fMatrix5x52.a11;
        fMatrix5x53.a12 = fMatrix5x5.a12 - fMatrix5x52.a12;
        fMatrix5x53.a13 = fMatrix5x5.a13 - fMatrix5x52.a13;
        fMatrix5x53.a14 = fMatrix5x5.a14 - fMatrix5x52.a14;
        fMatrix5x53.a15 = fMatrix5x5.a15 - fMatrix5x52.a15;
        fMatrix5x53.a21 = fMatrix5x5.a21 - fMatrix5x52.a21;
        fMatrix5x53.a22 = fMatrix5x5.a22 - fMatrix5x52.a22;
        fMatrix5x53.a23 = fMatrix5x5.a23 - fMatrix5x52.a23;
        fMatrix5x53.a24 = fMatrix5x5.a24 - fMatrix5x52.a24;
        fMatrix5x53.a25 = fMatrix5x5.a25 - fMatrix5x52.a25;
        fMatrix5x53.a31 = fMatrix5x5.a31 - fMatrix5x52.a31;
        fMatrix5x53.a32 = fMatrix5x5.a32 - fMatrix5x52.a32;
        fMatrix5x53.a33 = fMatrix5x5.a33 - fMatrix5x52.a33;
        fMatrix5x53.a34 = fMatrix5x5.a34 - fMatrix5x52.a34;
        fMatrix5x53.a35 = fMatrix5x5.a35 - fMatrix5x52.a35;
        fMatrix5x53.a41 = fMatrix5x5.a41 - fMatrix5x52.a41;
        fMatrix5x53.a42 = fMatrix5x5.a42 - fMatrix5x52.a42;
        fMatrix5x53.a43 = fMatrix5x5.a43 - fMatrix5x52.a43;
        fMatrix5x53.a44 = fMatrix5x5.a44 - fMatrix5x52.a44;
        fMatrix5x53.a45 = fMatrix5x5.a45 - fMatrix5x52.a45;
        fMatrix5x53.a51 = fMatrix5x5.a51 - fMatrix5x52.a51;
        fMatrix5x53.a52 = fMatrix5x5.a52 - fMatrix5x52.a52;
        fMatrix5x53.a53 = fMatrix5x5.a53 - fMatrix5x52.a53;
        fMatrix5x53.a54 = fMatrix5x5.a54 - fMatrix5x52.a54;
        fMatrix5x53.a55 = fMatrix5x5.a55 - fMatrix5x52.a55;
    }

    public static void subtract(FMatrix5 fMatrix5, FMatrix5 fMatrix52, FMatrix5 fMatrix53) {
        fMatrix53.f2427a1 = fMatrix5.f2427a1 - fMatrix52.f2427a1;
        fMatrix53.f2428a2 = fMatrix5.f2428a2 - fMatrix52.f2428a2;
        fMatrix53.f2429a3 = fMatrix5.f2429a3 - fMatrix52.f2429a3;
        fMatrix53.f2430a4 = fMatrix5.f2430a4 - fMatrix52.f2430a4;
        fMatrix53.f2431a5 = fMatrix5.f2431a5 - fMatrix52.f2431a5;
    }

    public static void subtractEquals(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52) {
        fMatrix5x5.a11 -= fMatrix5x52.a11;
        fMatrix5x5.a12 -= fMatrix5x52.a12;
        fMatrix5x5.a13 -= fMatrix5x52.a13;
        fMatrix5x5.a14 -= fMatrix5x52.a14;
        fMatrix5x5.a15 -= fMatrix5x52.a15;
        fMatrix5x5.a21 -= fMatrix5x52.a21;
        fMatrix5x5.a22 -= fMatrix5x52.a22;
        fMatrix5x5.a23 -= fMatrix5x52.a23;
        fMatrix5x5.a24 -= fMatrix5x52.a24;
        fMatrix5x5.a25 -= fMatrix5x52.a25;
        fMatrix5x5.a31 -= fMatrix5x52.a31;
        fMatrix5x5.a32 -= fMatrix5x52.a32;
        fMatrix5x5.a33 -= fMatrix5x52.a33;
        fMatrix5x5.a34 -= fMatrix5x52.a34;
        fMatrix5x5.a35 -= fMatrix5x52.a35;
        fMatrix5x5.a41 -= fMatrix5x52.a41;
        fMatrix5x5.a42 -= fMatrix5x52.a42;
        fMatrix5x5.a43 -= fMatrix5x52.a43;
        fMatrix5x5.a44 -= fMatrix5x52.a44;
        fMatrix5x5.a45 -= fMatrix5x52.a45;
        fMatrix5x5.a51 -= fMatrix5x52.a51;
        fMatrix5x5.a52 -= fMatrix5x52.a52;
        fMatrix5x5.a53 -= fMatrix5x52.a53;
        fMatrix5x5.a54 -= fMatrix5x52.a54;
        fMatrix5x5.a55 -= fMatrix5x52.a55;
    }

    public static void subtractEquals(FMatrix5 fMatrix5, FMatrix5 fMatrix52) {
        fMatrix5.f2427a1 -= fMatrix52.f2427a1;
        fMatrix5.f2428a2 -= fMatrix52.f2428a2;
        fMatrix5.f2429a3 -= fMatrix52.f2429a3;
        fMatrix5.f2430a4 -= fMatrix52.f2430a4;
        fMatrix5.f2431a5 -= fMatrix52.f2431a5;
    }

    public static void transpose(FMatrix5x5 fMatrix5x5) {
        float f = fMatrix5x5.a12;
        fMatrix5x5.a12 = fMatrix5x5.a21;
        fMatrix5x5.a21 = f;
        float f2 = fMatrix5x5.a13;
        fMatrix5x5.a13 = fMatrix5x5.a31;
        fMatrix5x5.a31 = f2;
        float f3 = fMatrix5x5.a14;
        fMatrix5x5.a14 = fMatrix5x5.a41;
        fMatrix5x5.a41 = f3;
        float f4 = fMatrix5x5.a15;
        fMatrix5x5.a15 = fMatrix5x5.a51;
        fMatrix5x5.a51 = f4;
        float f5 = fMatrix5x5.a23;
        fMatrix5x5.a23 = fMatrix5x5.a32;
        fMatrix5x5.a32 = f5;
        float f6 = fMatrix5x5.a24;
        fMatrix5x5.a24 = fMatrix5x5.a42;
        fMatrix5x5.a42 = f6;
        float f7 = fMatrix5x5.a25;
        fMatrix5x5.a25 = fMatrix5x5.a52;
        fMatrix5x5.a52 = f7;
        float f8 = fMatrix5x5.a34;
        fMatrix5x5.a34 = fMatrix5x5.a43;
        fMatrix5x5.a43 = f8;
        float f9 = fMatrix5x5.a35;
        fMatrix5x5.a35 = fMatrix5x5.a53;
        fMatrix5x5.a53 = f9;
        float f10 = fMatrix5x5.a45;
        fMatrix5x5.a45 = fMatrix5x5.a54;
        fMatrix5x5.a54 = f10;
    }

    public static FMatrix5x5 transpose(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52) {
        if (fMatrix5x5 == null) {
            fMatrix5x5 = new FMatrix5x5();
        }
        fMatrix5x52.a11 = fMatrix5x5.a11;
        fMatrix5x52.a12 = fMatrix5x5.a21;
        fMatrix5x52.a13 = fMatrix5x5.a31;
        fMatrix5x52.a14 = fMatrix5x5.a41;
        fMatrix5x52.a15 = fMatrix5x5.a51;
        fMatrix5x52.a21 = fMatrix5x5.a12;
        fMatrix5x52.a22 = fMatrix5x5.a22;
        fMatrix5x52.a23 = fMatrix5x5.a32;
        fMatrix5x52.a24 = fMatrix5x5.a42;
        fMatrix5x52.a25 = fMatrix5x5.a52;
        fMatrix5x52.a31 = fMatrix5x5.a13;
        fMatrix5x52.a32 = fMatrix5x5.a23;
        fMatrix5x52.a33 = fMatrix5x5.a33;
        fMatrix5x52.a34 = fMatrix5x5.a43;
        fMatrix5x52.a35 = fMatrix5x5.a53;
        fMatrix5x52.a41 = fMatrix5x5.a14;
        fMatrix5x52.a42 = fMatrix5x5.a24;
        fMatrix5x52.a43 = fMatrix5x5.a34;
        fMatrix5x52.a44 = fMatrix5x5.a44;
        fMatrix5x52.a45 = fMatrix5x5.a54;
        fMatrix5x52.a51 = fMatrix5x5.a15;
        fMatrix5x52.a52 = fMatrix5x5.a25;
        fMatrix5x52.a53 = fMatrix5x5.a35;
        fMatrix5x52.a54 = fMatrix5x5.a45;
        fMatrix5x52.a55 = fMatrix5x5.a55;
        return fMatrix5x52;
    }

    public static void mult(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52, FMatrix5x5 fMatrix5x53) {
        fMatrix5x53.a11 = (fMatrix5x5.a11 * fMatrix5x52.a11) + (fMatrix5x5.a12 * fMatrix5x52.a21) + (fMatrix5x5.a13 * fMatrix5x52.a31) + (fMatrix5x5.a14 * fMatrix5x52.a41) + (fMatrix5x5.a15 * fMatrix5x52.a51);
        fMatrix5x53.a12 = (fMatrix5x5.a11 * fMatrix5x52.a12) + (fMatrix5x5.a12 * fMatrix5x52.a22) + (fMatrix5x5.a13 * fMatrix5x52.a32) + (fMatrix5x5.a14 * fMatrix5x52.a42) + (fMatrix5x5.a15 * fMatrix5x52.a52);
        fMatrix5x53.a13 = (fMatrix5x5.a11 * fMatrix5x52.a13) + (fMatrix5x5.a12 * fMatrix5x52.a23) + (fMatrix5x5.a13 * fMatrix5x52.a33) + (fMatrix5x5.a14 * fMatrix5x52.a43) + (fMatrix5x5.a15 * fMatrix5x52.a53);
        fMatrix5x53.a14 = (fMatrix5x5.a11 * fMatrix5x52.a14) + (fMatrix5x5.a12 * fMatrix5x52.a24) + (fMatrix5x5.a13 * fMatrix5x52.a34) + (fMatrix5x5.a14 * fMatrix5x52.a44) + (fMatrix5x5.a15 * fMatrix5x52.a54);
        fMatrix5x53.a15 = (fMatrix5x5.a11 * fMatrix5x52.a15) + (fMatrix5x5.a12 * fMatrix5x52.a25) + (fMatrix5x5.a13 * fMatrix5x52.a35) + (fMatrix5x5.a14 * fMatrix5x52.a45) + (fMatrix5x5.a15 * fMatrix5x52.a55);
        fMatrix5x53.a21 = (fMatrix5x5.a21 * fMatrix5x52.a11) + (fMatrix5x5.a22 * fMatrix5x52.a21) + (fMatrix5x5.a23 * fMatrix5x52.a31) + (fMatrix5x5.a24 * fMatrix5x52.a41) + (fMatrix5x5.a25 * fMatrix5x52.a51);
        fMatrix5x53.a22 = (fMatrix5x5.a21 * fMatrix5x52.a12) + (fMatrix5x5.a22 * fMatrix5x52.a22) + (fMatrix5x5.a23 * fMatrix5x52.a32) + (fMatrix5x5.a24 * fMatrix5x52.a42) + (fMatrix5x5.a25 * fMatrix5x52.a52);
        fMatrix5x53.a23 = (fMatrix5x5.a21 * fMatrix5x52.a13) + (fMatrix5x5.a22 * fMatrix5x52.a23) + (fMatrix5x5.a23 * fMatrix5x52.a33) + (fMatrix5x5.a24 * fMatrix5x52.a43) + (fMatrix5x5.a25 * fMatrix5x52.a53);
        fMatrix5x53.a24 = (fMatrix5x5.a21 * fMatrix5x52.a14) + (fMatrix5x5.a22 * fMatrix5x52.a24) + (fMatrix5x5.a23 * fMatrix5x52.a34) + (fMatrix5x5.a24 * fMatrix5x52.a44) + (fMatrix5x5.a25 * fMatrix5x52.a54);
        fMatrix5x53.a25 = (fMatrix5x5.a21 * fMatrix5x52.a15) + (fMatrix5x5.a22 * fMatrix5x52.a25) + (fMatrix5x5.a23 * fMatrix5x52.a35) + (fMatrix5x5.a24 * fMatrix5x52.a45) + (fMatrix5x5.a25 * fMatrix5x52.a55);
        fMatrix5x53.a31 = (fMatrix5x5.a31 * fMatrix5x52.a11) + (fMatrix5x5.a32 * fMatrix5x52.a21) + (fMatrix5x5.a33 * fMatrix5x52.a31) + (fMatrix5x5.a34 * fMatrix5x52.a41) + (fMatrix5x5.a35 * fMatrix5x52.a51);
        fMatrix5x53.a32 = (fMatrix5x5.a31 * fMatrix5x52.a12) + (fMatrix5x5.a32 * fMatrix5x52.a22) + (fMatrix5x5.a33 * fMatrix5x52.a32) + (fMatrix5x5.a34 * fMatrix5x52.a42) + (fMatrix5x5.a35 * fMatrix5x52.a52);
        fMatrix5x53.a33 = (fMatrix5x5.a31 * fMatrix5x52.a13) + (fMatrix5x5.a32 * fMatrix5x52.a23) + (fMatrix5x5.a33 * fMatrix5x52.a33) + (fMatrix5x5.a34 * fMatrix5x52.a43) + (fMatrix5x5.a35 * fMatrix5x52.a53);
        fMatrix5x53.a34 = (fMatrix5x5.a31 * fMatrix5x52.a14) + (fMatrix5x5.a32 * fMatrix5x52.a24) + (fMatrix5x5.a33 * fMatrix5x52.a34) + (fMatrix5x5.a34 * fMatrix5x52.a44) + (fMatrix5x5.a35 * fMatrix5x52.a54);
        fMatrix5x53.a35 = (fMatrix5x5.a31 * fMatrix5x52.a15) + (fMatrix5x5.a32 * fMatrix5x52.a25) + (fMatrix5x5.a33 * fMatrix5x52.a35) + (fMatrix5x5.a34 * fMatrix5x52.a45) + (fMatrix5x5.a35 * fMatrix5x52.a55);
        fMatrix5x53.a41 = (fMatrix5x5.a41 * fMatrix5x52.a11) + (fMatrix5x5.a42 * fMatrix5x52.a21) + (fMatrix5x5.a43 * fMatrix5x52.a31) + (fMatrix5x5.a44 * fMatrix5x52.a41) + (fMatrix5x5.a45 * fMatrix5x52.a51);
        fMatrix5x53.a42 = (fMatrix5x5.a41 * fMatrix5x52.a12) + (fMatrix5x5.a42 * fMatrix5x52.a22) + (fMatrix5x5.a43 * fMatrix5x52.a32) + (fMatrix5x5.a44 * fMatrix5x52.a42) + (fMatrix5x5.a45 * fMatrix5x52.a52);
        fMatrix5x53.a43 = (fMatrix5x5.a41 * fMatrix5x52.a13) + (fMatrix5x5.a42 * fMatrix5x52.a23) + (fMatrix5x5.a43 * fMatrix5x52.a33) + (fMatrix5x5.a44 * fMatrix5x52.a43) + (fMatrix5x5.a45 * fMatrix5x52.a53);
        fMatrix5x53.a44 = (fMatrix5x5.a41 * fMatrix5x52.a14) + (fMatrix5x5.a42 * fMatrix5x52.a24) + (fMatrix5x5.a43 * fMatrix5x52.a34) + (fMatrix5x5.a44 * fMatrix5x52.a44) + (fMatrix5x5.a45 * fMatrix5x52.a54);
        fMatrix5x53.a45 = (fMatrix5x5.a41 * fMatrix5x52.a15) + (fMatrix5x5.a42 * fMatrix5x52.a25) + (fMatrix5x5.a43 * fMatrix5x52.a35) + (fMatrix5x5.a44 * fMatrix5x52.a45) + (fMatrix5x5.a45 * fMatrix5x52.a55);
        fMatrix5x53.a51 = (fMatrix5x5.a51 * fMatrix5x52.a11) + (fMatrix5x5.a52 * fMatrix5x52.a21) + (fMatrix5x5.a53 * fMatrix5x52.a31) + (fMatrix5x5.a54 * fMatrix5x52.a41) + (fMatrix5x5.a55 * fMatrix5x52.a51);
        fMatrix5x53.a52 = (fMatrix5x5.a51 * fMatrix5x52.a12) + (fMatrix5x5.a52 * fMatrix5x52.a22) + (fMatrix5x5.a53 * fMatrix5x52.a32) + (fMatrix5x5.a54 * fMatrix5x52.a42) + (fMatrix5x5.a55 * fMatrix5x52.a52);
        fMatrix5x53.a53 = (fMatrix5x5.a51 * fMatrix5x52.a13) + (fMatrix5x5.a52 * fMatrix5x52.a23) + (fMatrix5x5.a53 * fMatrix5x52.a33) + (fMatrix5x5.a54 * fMatrix5x52.a43) + (fMatrix5x5.a55 * fMatrix5x52.a53);
        fMatrix5x53.a54 = (fMatrix5x5.a51 * fMatrix5x52.a14) + (fMatrix5x5.a52 * fMatrix5x52.a24) + (fMatrix5x5.a53 * fMatrix5x52.a34) + (fMatrix5x5.a54 * fMatrix5x52.a44) + (fMatrix5x5.a55 * fMatrix5x52.a54);
        fMatrix5x53.a55 = (fMatrix5x5.a51 * fMatrix5x52.a15) + (fMatrix5x5.a52 * fMatrix5x52.a25) + (fMatrix5x5.a53 * fMatrix5x52.a35) + (fMatrix5x5.a54 * fMatrix5x52.a45) + (fMatrix5x5.a55 * fMatrix5x52.a55);
    }

    public static void multTransA(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52, FMatrix5x5 fMatrix5x53) {
        fMatrix5x53.a11 = (fMatrix5x5.a11 * fMatrix5x52.a11) + (fMatrix5x5.a21 * fMatrix5x52.a21) + (fMatrix5x5.a31 * fMatrix5x52.a31) + (fMatrix5x5.a41 * fMatrix5x52.a41) + (fMatrix5x5.a51 * fMatrix5x52.a51);
        fMatrix5x53.a12 = (fMatrix5x5.a11 * fMatrix5x52.a12) + (fMatrix5x5.a21 * fMatrix5x52.a22) + (fMatrix5x5.a31 * fMatrix5x52.a32) + (fMatrix5x5.a41 * fMatrix5x52.a42) + (fMatrix5x5.a51 * fMatrix5x52.a52);
        fMatrix5x53.a13 = (fMatrix5x5.a11 * fMatrix5x52.a13) + (fMatrix5x5.a21 * fMatrix5x52.a23) + (fMatrix5x5.a31 * fMatrix5x52.a33) + (fMatrix5x5.a41 * fMatrix5x52.a43) + (fMatrix5x5.a51 * fMatrix5x52.a53);
        fMatrix5x53.a14 = (fMatrix5x5.a11 * fMatrix5x52.a14) + (fMatrix5x5.a21 * fMatrix5x52.a24) + (fMatrix5x5.a31 * fMatrix5x52.a34) + (fMatrix5x5.a41 * fMatrix5x52.a44) + (fMatrix5x5.a51 * fMatrix5x52.a54);
        fMatrix5x53.a15 = (fMatrix5x5.a11 * fMatrix5x52.a15) + (fMatrix5x5.a21 * fMatrix5x52.a25) + (fMatrix5x5.a31 * fMatrix5x52.a35) + (fMatrix5x5.a41 * fMatrix5x52.a45) + (fMatrix5x5.a51 * fMatrix5x52.a55);
        fMatrix5x53.a21 = (fMatrix5x5.a12 * fMatrix5x52.a11) + (fMatrix5x5.a22 * fMatrix5x52.a21) + (fMatrix5x5.a32 * fMatrix5x52.a31) + (fMatrix5x5.a42 * fMatrix5x52.a41) + (fMatrix5x5.a52 * fMatrix5x52.a51);
        fMatrix5x53.a22 = (fMatrix5x5.a12 * fMatrix5x52.a12) + (fMatrix5x5.a22 * fMatrix5x52.a22) + (fMatrix5x5.a32 * fMatrix5x52.a32) + (fMatrix5x5.a42 * fMatrix5x52.a42) + (fMatrix5x5.a52 * fMatrix5x52.a52);
        fMatrix5x53.a23 = (fMatrix5x5.a12 * fMatrix5x52.a13) + (fMatrix5x5.a22 * fMatrix5x52.a23) + (fMatrix5x5.a32 * fMatrix5x52.a33) + (fMatrix5x5.a42 * fMatrix5x52.a43) + (fMatrix5x5.a52 * fMatrix5x52.a53);
        fMatrix5x53.a24 = (fMatrix5x5.a12 * fMatrix5x52.a14) + (fMatrix5x5.a22 * fMatrix5x52.a24) + (fMatrix5x5.a32 * fMatrix5x52.a34) + (fMatrix5x5.a42 * fMatrix5x52.a44) + (fMatrix5x5.a52 * fMatrix5x52.a54);
        fMatrix5x53.a25 = (fMatrix5x5.a12 * fMatrix5x52.a15) + (fMatrix5x5.a22 * fMatrix5x52.a25) + (fMatrix5x5.a32 * fMatrix5x52.a35) + (fMatrix5x5.a42 * fMatrix5x52.a45) + (fMatrix5x5.a52 * fMatrix5x52.a55);
        fMatrix5x53.a31 = (fMatrix5x5.a13 * fMatrix5x52.a11) + (fMatrix5x5.a23 * fMatrix5x52.a21) + (fMatrix5x5.a33 * fMatrix5x52.a31) + (fMatrix5x5.a43 * fMatrix5x52.a41) + (fMatrix5x5.a53 * fMatrix5x52.a51);
        fMatrix5x53.a32 = (fMatrix5x5.a13 * fMatrix5x52.a12) + (fMatrix5x5.a23 * fMatrix5x52.a22) + (fMatrix5x5.a33 * fMatrix5x52.a32) + (fMatrix5x5.a43 * fMatrix5x52.a42) + (fMatrix5x5.a53 * fMatrix5x52.a52);
        fMatrix5x53.a33 = (fMatrix5x5.a13 * fMatrix5x52.a13) + (fMatrix5x5.a23 * fMatrix5x52.a23) + (fMatrix5x5.a33 * fMatrix5x52.a33) + (fMatrix5x5.a43 * fMatrix5x52.a43) + (fMatrix5x5.a53 * fMatrix5x52.a53);
        fMatrix5x53.a34 = (fMatrix5x5.a13 * fMatrix5x52.a14) + (fMatrix5x5.a23 * fMatrix5x52.a24) + (fMatrix5x5.a33 * fMatrix5x52.a34) + (fMatrix5x5.a43 * fMatrix5x52.a44) + (fMatrix5x5.a53 * fMatrix5x52.a54);
        fMatrix5x53.a35 = (fMatrix5x5.a13 * fMatrix5x52.a15) + (fMatrix5x5.a23 * fMatrix5x52.a25) + (fMatrix5x5.a33 * fMatrix5x52.a35) + (fMatrix5x5.a43 * fMatrix5x52.a45) + (fMatrix5x5.a53 * fMatrix5x52.a55);
        fMatrix5x53.a41 = (fMatrix5x5.a14 * fMatrix5x52.a11) + (fMatrix5x5.a24 * fMatrix5x52.a21) + (fMatrix5x5.a34 * fMatrix5x52.a31) + (fMatrix5x5.a44 * fMatrix5x52.a41) + (fMatrix5x5.a54 * fMatrix5x52.a51);
        fMatrix5x53.a42 = (fMatrix5x5.a14 * fMatrix5x52.a12) + (fMatrix5x5.a24 * fMatrix5x52.a22) + (fMatrix5x5.a34 * fMatrix5x52.a32) + (fMatrix5x5.a44 * fMatrix5x52.a42) + (fMatrix5x5.a54 * fMatrix5x52.a52);
        fMatrix5x53.a43 = (fMatrix5x5.a14 * fMatrix5x52.a13) + (fMatrix5x5.a24 * fMatrix5x52.a23) + (fMatrix5x5.a34 * fMatrix5x52.a33) + (fMatrix5x5.a44 * fMatrix5x52.a43) + (fMatrix5x5.a54 * fMatrix5x52.a53);
        fMatrix5x53.a44 = (fMatrix5x5.a14 * fMatrix5x52.a14) + (fMatrix5x5.a24 * fMatrix5x52.a24) + (fMatrix5x5.a34 * fMatrix5x52.a34) + (fMatrix5x5.a44 * fMatrix5x52.a44) + (fMatrix5x5.a54 * fMatrix5x52.a54);
        fMatrix5x53.a45 = (fMatrix5x5.a14 * fMatrix5x52.a15) + (fMatrix5x5.a24 * fMatrix5x52.a25) + (fMatrix5x5.a34 * fMatrix5x52.a35) + (fMatrix5x5.a44 * fMatrix5x52.a45) + (fMatrix5x5.a54 * fMatrix5x52.a55);
        fMatrix5x53.a51 = (fMatrix5x5.a15 * fMatrix5x52.a11) + (fMatrix5x5.a25 * fMatrix5x52.a21) + (fMatrix5x5.a35 * fMatrix5x52.a31) + (fMatrix5x5.a45 * fMatrix5x52.a41) + (fMatrix5x5.a55 * fMatrix5x52.a51);
        fMatrix5x53.a52 = (fMatrix5x5.a15 * fMatrix5x52.a12) + (fMatrix5x5.a25 * fMatrix5x52.a22) + (fMatrix5x5.a35 * fMatrix5x52.a32) + (fMatrix5x5.a45 * fMatrix5x52.a42) + (fMatrix5x5.a55 * fMatrix5x52.a52);
        fMatrix5x53.a53 = (fMatrix5x5.a15 * fMatrix5x52.a13) + (fMatrix5x5.a25 * fMatrix5x52.a23) + (fMatrix5x5.a35 * fMatrix5x52.a33) + (fMatrix5x5.a45 * fMatrix5x52.a43) + (fMatrix5x5.a55 * fMatrix5x52.a53);
        fMatrix5x53.a54 = (fMatrix5x5.a15 * fMatrix5x52.a14) + (fMatrix5x5.a25 * fMatrix5x52.a24) + (fMatrix5x5.a35 * fMatrix5x52.a34) + (fMatrix5x5.a45 * fMatrix5x52.a44) + (fMatrix5x5.a55 * fMatrix5x52.a54);
        fMatrix5x53.a55 = (fMatrix5x5.a15 * fMatrix5x52.a15) + (fMatrix5x5.a25 * fMatrix5x52.a25) + (fMatrix5x5.a35 * fMatrix5x52.a35) + (fMatrix5x5.a45 * fMatrix5x52.a45) + (fMatrix5x5.a55 * fMatrix5x52.a55);
    }

    public static void multTransAB(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52, FMatrix5x5 fMatrix5x53) {
        fMatrix5x53.a11 = (fMatrix5x5.a11 * fMatrix5x52.a11) + (fMatrix5x5.a21 * fMatrix5x52.a12) + (fMatrix5x5.a31 * fMatrix5x52.a13) + (fMatrix5x5.a41 * fMatrix5x52.a14) + (fMatrix5x5.a51 * fMatrix5x52.a15);
        fMatrix5x53.a12 = (fMatrix5x5.a11 * fMatrix5x52.a21) + (fMatrix5x5.a21 * fMatrix5x52.a22) + (fMatrix5x5.a31 * fMatrix5x52.a23) + (fMatrix5x5.a41 * fMatrix5x52.a24) + (fMatrix5x5.a51 * fMatrix5x52.a25);
        fMatrix5x53.a13 = (fMatrix5x5.a11 * fMatrix5x52.a31) + (fMatrix5x5.a21 * fMatrix5x52.a32) + (fMatrix5x5.a31 * fMatrix5x52.a33) + (fMatrix5x5.a41 * fMatrix5x52.a34) + (fMatrix5x5.a51 * fMatrix5x52.a35);
        fMatrix5x53.a14 = (fMatrix5x5.a11 * fMatrix5x52.a41) + (fMatrix5x5.a21 * fMatrix5x52.a42) + (fMatrix5x5.a31 * fMatrix5x52.a43) + (fMatrix5x5.a41 * fMatrix5x52.a44) + (fMatrix5x5.a51 * fMatrix5x52.a45);
        fMatrix5x53.a15 = (fMatrix5x5.a11 * fMatrix5x52.a51) + (fMatrix5x5.a21 * fMatrix5x52.a52) + (fMatrix5x5.a31 * fMatrix5x52.a53) + (fMatrix5x5.a41 * fMatrix5x52.a54) + (fMatrix5x5.a51 * fMatrix5x52.a55);
        fMatrix5x53.a21 = (fMatrix5x5.a12 * fMatrix5x52.a11) + (fMatrix5x5.a22 * fMatrix5x52.a12) + (fMatrix5x5.a32 * fMatrix5x52.a13) + (fMatrix5x5.a42 * fMatrix5x52.a14) + (fMatrix5x5.a52 * fMatrix5x52.a15);
        fMatrix5x53.a22 = (fMatrix5x5.a12 * fMatrix5x52.a21) + (fMatrix5x5.a22 * fMatrix5x52.a22) + (fMatrix5x5.a32 * fMatrix5x52.a23) + (fMatrix5x5.a42 * fMatrix5x52.a24) + (fMatrix5x5.a52 * fMatrix5x52.a25);
        fMatrix5x53.a23 = (fMatrix5x5.a12 * fMatrix5x52.a31) + (fMatrix5x5.a22 * fMatrix5x52.a32) + (fMatrix5x5.a32 * fMatrix5x52.a33) + (fMatrix5x5.a42 * fMatrix5x52.a34) + (fMatrix5x5.a52 * fMatrix5x52.a35);
        fMatrix5x53.a24 = (fMatrix5x5.a12 * fMatrix5x52.a41) + (fMatrix5x5.a22 * fMatrix5x52.a42) + (fMatrix5x5.a32 * fMatrix5x52.a43) + (fMatrix5x5.a42 * fMatrix5x52.a44) + (fMatrix5x5.a52 * fMatrix5x52.a45);
        fMatrix5x53.a25 = (fMatrix5x5.a12 * fMatrix5x52.a51) + (fMatrix5x5.a22 * fMatrix5x52.a52) + (fMatrix5x5.a32 * fMatrix5x52.a53) + (fMatrix5x5.a42 * fMatrix5x52.a54) + (fMatrix5x5.a52 * fMatrix5x52.a55);
        fMatrix5x53.a31 = (fMatrix5x5.a13 * fMatrix5x52.a11) + (fMatrix5x5.a23 * fMatrix5x52.a12) + (fMatrix5x5.a33 * fMatrix5x52.a13) + (fMatrix5x5.a43 * fMatrix5x52.a14) + (fMatrix5x5.a53 * fMatrix5x52.a15);
        fMatrix5x53.a32 = (fMatrix5x5.a13 * fMatrix5x52.a21) + (fMatrix5x5.a23 * fMatrix5x52.a22) + (fMatrix5x5.a33 * fMatrix5x52.a23) + (fMatrix5x5.a43 * fMatrix5x52.a24) + (fMatrix5x5.a53 * fMatrix5x52.a25);
        fMatrix5x53.a33 = (fMatrix5x5.a13 * fMatrix5x52.a31) + (fMatrix5x5.a23 * fMatrix5x52.a32) + (fMatrix5x5.a33 * fMatrix5x52.a33) + (fMatrix5x5.a43 * fMatrix5x52.a34) + (fMatrix5x5.a53 * fMatrix5x52.a35);
        fMatrix5x53.a34 = (fMatrix5x5.a13 * fMatrix5x52.a41) + (fMatrix5x5.a23 * fMatrix5x52.a42) + (fMatrix5x5.a33 * fMatrix5x52.a43) + (fMatrix5x5.a43 * fMatrix5x52.a44) + (fMatrix5x5.a53 * fMatrix5x52.a45);
        fMatrix5x53.a35 = (fMatrix5x5.a13 * fMatrix5x52.a51) + (fMatrix5x5.a23 * fMatrix5x52.a52) + (fMatrix5x5.a33 * fMatrix5x52.a53) + (fMatrix5x5.a43 * fMatrix5x52.a54) + (fMatrix5x5.a53 * fMatrix5x52.a55);
        fMatrix5x53.a41 = (fMatrix5x5.a14 * fMatrix5x52.a11) + (fMatrix5x5.a24 * fMatrix5x52.a12) + (fMatrix5x5.a34 * fMatrix5x52.a13) + (fMatrix5x5.a44 * fMatrix5x52.a14) + (fMatrix5x5.a54 * fMatrix5x52.a15);
        fMatrix5x53.a42 = (fMatrix5x5.a14 * fMatrix5x52.a21) + (fMatrix5x5.a24 * fMatrix5x52.a22) + (fMatrix5x5.a34 * fMatrix5x52.a23) + (fMatrix5x5.a44 * fMatrix5x52.a24) + (fMatrix5x5.a54 * fMatrix5x52.a25);
        fMatrix5x53.a43 = (fMatrix5x5.a14 * fMatrix5x52.a31) + (fMatrix5x5.a24 * fMatrix5x52.a32) + (fMatrix5x5.a34 * fMatrix5x52.a33) + (fMatrix5x5.a44 * fMatrix5x52.a34) + (fMatrix5x5.a54 * fMatrix5x52.a35);
        fMatrix5x53.a44 = (fMatrix5x5.a14 * fMatrix5x52.a41) + (fMatrix5x5.a24 * fMatrix5x52.a42) + (fMatrix5x5.a34 * fMatrix5x52.a43) + (fMatrix5x5.a44 * fMatrix5x52.a44) + (fMatrix5x5.a54 * fMatrix5x52.a45);
        fMatrix5x53.a45 = (fMatrix5x5.a14 * fMatrix5x52.a51) + (fMatrix5x5.a24 * fMatrix5x52.a52) + (fMatrix5x5.a34 * fMatrix5x52.a53) + (fMatrix5x5.a44 * fMatrix5x52.a54) + (fMatrix5x5.a54 * fMatrix5x52.a55);
        fMatrix5x53.a51 = (fMatrix5x5.a15 * fMatrix5x52.a11) + (fMatrix5x5.a25 * fMatrix5x52.a12) + (fMatrix5x5.a35 * fMatrix5x52.a13) + (fMatrix5x5.a45 * fMatrix5x52.a14) + (fMatrix5x5.a55 * fMatrix5x52.a15);
        fMatrix5x53.a52 = (fMatrix5x5.a15 * fMatrix5x52.a21) + (fMatrix5x5.a25 * fMatrix5x52.a22) + (fMatrix5x5.a35 * fMatrix5x52.a23) + (fMatrix5x5.a45 * fMatrix5x52.a24) + (fMatrix5x5.a55 * fMatrix5x52.a25);
        fMatrix5x53.a53 = (fMatrix5x5.a15 * fMatrix5x52.a31) + (fMatrix5x5.a25 * fMatrix5x52.a32) + (fMatrix5x5.a35 * fMatrix5x52.a33) + (fMatrix5x5.a45 * fMatrix5x52.a34) + (fMatrix5x5.a55 * fMatrix5x52.a35);
        fMatrix5x53.a54 = (fMatrix5x5.a15 * fMatrix5x52.a41) + (fMatrix5x5.a25 * fMatrix5x52.a42) + (fMatrix5x5.a35 * fMatrix5x52.a43) + (fMatrix5x5.a45 * fMatrix5x52.a44) + (fMatrix5x5.a55 * fMatrix5x52.a45);
        fMatrix5x53.a55 = (fMatrix5x5.a15 * fMatrix5x52.a51) + (fMatrix5x5.a25 * fMatrix5x52.a52) + (fMatrix5x5.a35 * fMatrix5x52.a53) + (fMatrix5x5.a45 * fMatrix5x52.a54) + (fMatrix5x5.a55 * fMatrix5x52.a55);
    }

    public static void multTransB(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52, FMatrix5x5 fMatrix5x53) {
        fMatrix5x53.a11 = (fMatrix5x5.a11 * fMatrix5x52.a11) + (fMatrix5x5.a12 * fMatrix5x52.a12) + (fMatrix5x5.a13 * fMatrix5x52.a13) + (fMatrix5x5.a14 * fMatrix5x52.a14) + (fMatrix5x5.a15 * fMatrix5x52.a15);
        fMatrix5x53.a12 = (fMatrix5x5.a11 * fMatrix5x52.a21) + (fMatrix5x5.a12 * fMatrix5x52.a22) + (fMatrix5x5.a13 * fMatrix5x52.a23) + (fMatrix5x5.a14 * fMatrix5x52.a24) + (fMatrix5x5.a15 * fMatrix5x52.a25);
        fMatrix5x53.a13 = (fMatrix5x5.a11 * fMatrix5x52.a31) + (fMatrix5x5.a12 * fMatrix5x52.a32) + (fMatrix5x5.a13 * fMatrix5x52.a33) + (fMatrix5x5.a14 * fMatrix5x52.a34) + (fMatrix5x5.a15 * fMatrix5x52.a35);
        fMatrix5x53.a14 = (fMatrix5x5.a11 * fMatrix5x52.a41) + (fMatrix5x5.a12 * fMatrix5x52.a42) + (fMatrix5x5.a13 * fMatrix5x52.a43) + (fMatrix5x5.a14 * fMatrix5x52.a44) + (fMatrix5x5.a15 * fMatrix5x52.a45);
        fMatrix5x53.a15 = (fMatrix5x5.a11 * fMatrix5x52.a51) + (fMatrix5x5.a12 * fMatrix5x52.a52) + (fMatrix5x5.a13 * fMatrix5x52.a53) + (fMatrix5x5.a14 * fMatrix5x52.a54) + (fMatrix5x5.a15 * fMatrix5x52.a55);
        fMatrix5x53.a21 = (fMatrix5x5.a21 * fMatrix5x52.a11) + (fMatrix5x5.a22 * fMatrix5x52.a12) + (fMatrix5x5.a23 * fMatrix5x52.a13) + (fMatrix5x5.a24 * fMatrix5x52.a14) + (fMatrix5x5.a25 * fMatrix5x52.a15);
        fMatrix5x53.a22 = (fMatrix5x5.a21 * fMatrix5x52.a21) + (fMatrix5x5.a22 * fMatrix5x52.a22) + (fMatrix5x5.a23 * fMatrix5x52.a23) + (fMatrix5x5.a24 * fMatrix5x52.a24) + (fMatrix5x5.a25 * fMatrix5x52.a25);
        fMatrix5x53.a23 = (fMatrix5x5.a21 * fMatrix5x52.a31) + (fMatrix5x5.a22 * fMatrix5x52.a32) + (fMatrix5x5.a23 * fMatrix5x52.a33) + (fMatrix5x5.a24 * fMatrix5x52.a34) + (fMatrix5x5.a25 * fMatrix5x52.a35);
        fMatrix5x53.a24 = (fMatrix5x5.a21 * fMatrix5x52.a41) + (fMatrix5x5.a22 * fMatrix5x52.a42) + (fMatrix5x5.a23 * fMatrix5x52.a43) + (fMatrix5x5.a24 * fMatrix5x52.a44) + (fMatrix5x5.a25 * fMatrix5x52.a45);
        fMatrix5x53.a25 = (fMatrix5x5.a21 * fMatrix5x52.a51) + (fMatrix5x5.a22 * fMatrix5x52.a52) + (fMatrix5x5.a23 * fMatrix5x52.a53) + (fMatrix5x5.a24 * fMatrix5x52.a54) + (fMatrix5x5.a25 * fMatrix5x52.a55);
        fMatrix5x53.a31 = (fMatrix5x5.a31 * fMatrix5x52.a11) + (fMatrix5x5.a32 * fMatrix5x52.a12) + (fMatrix5x5.a33 * fMatrix5x52.a13) + (fMatrix5x5.a34 * fMatrix5x52.a14) + (fMatrix5x5.a35 * fMatrix5x52.a15);
        fMatrix5x53.a32 = (fMatrix5x5.a31 * fMatrix5x52.a21) + (fMatrix5x5.a32 * fMatrix5x52.a22) + (fMatrix5x5.a33 * fMatrix5x52.a23) + (fMatrix5x5.a34 * fMatrix5x52.a24) + (fMatrix5x5.a35 * fMatrix5x52.a25);
        fMatrix5x53.a33 = (fMatrix5x5.a31 * fMatrix5x52.a31) + (fMatrix5x5.a32 * fMatrix5x52.a32) + (fMatrix5x5.a33 * fMatrix5x52.a33) + (fMatrix5x5.a34 * fMatrix5x52.a34) + (fMatrix5x5.a35 * fMatrix5x52.a35);
        fMatrix5x53.a34 = (fMatrix5x5.a31 * fMatrix5x52.a41) + (fMatrix5x5.a32 * fMatrix5x52.a42) + (fMatrix5x5.a33 * fMatrix5x52.a43) + (fMatrix5x5.a34 * fMatrix5x52.a44) + (fMatrix5x5.a35 * fMatrix5x52.a45);
        fMatrix5x53.a35 = (fMatrix5x5.a31 * fMatrix5x52.a51) + (fMatrix5x5.a32 * fMatrix5x52.a52) + (fMatrix5x5.a33 * fMatrix5x52.a53) + (fMatrix5x5.a34 * fMatrix5x52.a54) + (fMatrix5x5.a35 * fMatrix5x52.a55);
        fMatrix5x53.a41 = (fMatrix5x5.a41 * fMatrix5x52.a11) + (fMatrix5x5.a42 * fMatrix5x52.a12) + (fMatrix5x5.a43 * fMatrix5x52.a13) + (fMatrix5x5.a44 * fMatrix5x52.a14) + (fMatrix5x5.a45 * fMatrix5x52.a15);
        fMatrix5x53.a42 = (fMatrix5x5.a41 * fMatrix5x52.a21) + (fMatrix5x5.a42 * fMatrix5x52.a22) + (fMatrix5x5.a43 * fMatrix5x52.a23) + (fMatrix5x5.a44 * fMatrix5x52.a24) + (fMatrix5x5.a45 * fMatrix5x52.a25);
        fMatrix5x53.a43 = (fMatrix5x5.a41 * fMatrix5x52.a31) + (fMatrix5x5.a42 * fMatrix5x52.a32) + (fMatrix5x5.a43 * fMatrix5x52.a33) + (fMatrix5x5.a44 * fMatrix5x52.a34) + (fMatrix5x5.a45 * fMatrix5x52.a35);
        fMatrix5x53.a44 = (fMatrix5x5.a41 * fMatrix5x52.a41) + (fMatrix5x5.a42 * fMatrix5x52.a42) + (fMatrix5x5.a43 * fMatrix5x52.a43) + (fMatrix5x5.a44 * fMatrix5x52.a44) + (fMatrix5x5.a45 * fMatrix5x52.a45);
        fMatrix5x53.a45 = (fMatrix5x5.a41 * fMatrix5x52.a51) + (fMatrix5x5.a42 * fMatrix5x52.a52) + (fMatrix5x5.a43 * fMatrix5x52.a53) + (fMatrix5x5.a44 * fMatrix5x52.a54) + (fMatrix5x5.a45 * fMatrix5x52.a55);
        fMatrix5x53.a51 = (fMatrix5x5.a51 * fMatrix5x52.a11) + (fMatrix5x5.a52 * fMatrix5x52.a12) + (fMatrix5x5.a53 * fMatrix5x52.a13) + (fMatrix5x5.a54 * fMatrix5x52.a14) + (fMatrix5x5.a55 * fMatrix5x52.a15);
        fMatrix5x53.a52 = (fMatrix5x5.a51 * fMatrix5x52.a21) + (fMatrix5x5.a52 * fMatrix5x52.a22) + (fMatrix5x5.a53 * fMatrix5x52.a23) + (fMatrix5x5.a54 * fMatrix5x52.a24) + (fMatrix5x5.a55 * fMatrix5x52.a25);
        fMatrix5x53.a53 = (fMatrix5x5.a51 * fMatrix5x52.a31) + (fMatrix5x5.a52 * fMatrix5x52.a32) + (fMatrix5x5.a53 * fMatrix5x52.a33) + (fMatrix5x5.a54 * fMatrix5x52.a34) + (fMatrix5x5.a55 * fMatrix5x52.a35);
        fMatrix5x53.a54 = (fMatrix5x5.a51 * fMatrix5x52.a41) + (fMatrix5x5.a52 * fMatrix5x52.a42) + (fMatrix5x5.a53 * fMatrix5x52.a43) + (fMatrix5x5.a54 * fMatrix5x52.a44) + (fMatrix5x5.a55 * fMatrix5x52.a45);
        fMatrix5x53.a55 = (fMatrix5x5.a51 * fMatrix5x52.a51) + (fMatrix5x5.a52 * fMatrix5x52.a52) + (fMatrix5x5.a53 * fMatrix5x52.a53) + (fMatrix5x5.a54 * fMatrix5x52.a54) + (fMatrix5x5.a55 * fMatrix5x52.a55);
    }

    public static void multAdd(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52, FMatrix5x5 fMatrix5x53) {
        fMatrix5x53.a11 += (fMatrix5x5.a11 * fMatrix5x52.a11) + (fMatrix5x5.a12 * fMatrix5x52.a21) + (fMatrix5x5.a13 * fMatrix5x52.a31) + (fMatrix5x5.a14 * fMatrix5x52.a41) + (fMatrix5x5.a15 * fMatrix5x52.a51);
        fMatrix5x53.a12 += (fMatrix5x5.a11 * fMatrix5x52.a12) + (fMatrix5x5.a12 * fMatrix5x52.a22) + (fMatrix5x5.a13 * fMatrix5x52.a32) + (fMatrix5x5.a14 * fMatrix5x52.a42) + (fMatrix5x5.a15 * fMatrix5x52.a52);
        fMatrix5x53.a13 += (fMatrix5x5.a11 * fMatrix5x52.a13) + (fMatrix5x5.a12 * fMatrix5x52.a23) + (fMatrix5x5.a13 * fMatrix5x52.a33) + (fMatrix5x5.a14 * fMatrix5x52.a43) + (fMatrix5x5.a15 * fMatrix5x52.a53);
        fMatrix5x53.a14 += (fMatrix5x5.a11 * fMatrix5x52.a14) + (fMatrix5x5.a12 * fMatrix5x52.a24) + (fMatrix5x5.a13 * fMatrix5x52.a34) + (fMatrix5x5.a14 * fMatrix5x52.a44) + (fMatrix5x5.a15 * fMatrix5x52.a54);
        fMatrix5x53.a15 += (fMatrix5x5.a11 * fMatrix5x52.a15) + (fMatrix5x5.a12 * fMatrix5x52.a25) + (fMatrix5x5.a13 * fMatrix5x52.a35) + (fMatrix5x5.a14 * fMatrix5x52.a45) + (fMatrix5x5.a15 * fMatrix5x52.a55);
        fMatrix5x53.a21 += (fMatrix5x5.a21 * fMatrix5x52.a11) + (fMatrix5x5.a22 * fMatrix5x52.a21) + (fMatrix5x5.a23 * fMatrix5x52.a31) + (fMatrix5x5.a24 * fMatrix5x52.a41) + (fMatrix5x5.a25 * fMatrix5x52.a51);
        fMatrix5x53.a22 += (fMatrix5x5.a21 * fMatrix5x52.a12) + (fMatrix5x5.a22 * fMatrix5x52.a22) + (fMatrix5x5.a23 * fMatrix5x52.a32) + (fMatrix5x5.a24 * fMatrix5x52.a42) + (fMatrix5x5.a25 * fMatrix5x52.a52);
        fMatrix5x53.a23 += (fMatrix5x5.a21 * fMatrix5x52.a13) + (fMatrix5x5.a22 * fMatrix5x52.a23) + (fMatrix5x5.a23 * fMatrix5x52.a33) + (fMatrix5x5.a24 * fMatrix5x52.a43) + (fMatrix5x5.a25 * fMatrix5x52.a53);
        fMatrix5x53.a24 += (fMatrix5x5.a21 * fMatrix5x52.a14) + (fMatrix5x5.a22 * fMatrix5x52.a24) + (fMatrix5x5.a23 * fMatrix5x52.a34) + (fMatrix5x5.a24 * fMatrix5x52.a44) + (fMatrix5x5.a25 * fMatrix5x52.a54);
        fMatrix5x53.a25 += (fMatrix5x5.a21 * fMatrix5x52.a15) + (fMatrix5x5.a22 * fMatrix5x52.a25) + (fMatrix5x5.a23 * fMatrix5x52.a35) + (fMatrix5x5.a24 * fMatrix5x52.a45) + (fMatrix5x5.a25 * fMatrix5x52.a55);
        fMatrix5x53.a31 += (fMatrix5x5.a31 * fMatrix5x52.a11) + (fMatrix5x5.a32 * fMatrix5x52.a21) + (fMatrix5x5.a33 * fMatrix5x52.a31) + (fMatrix5x5.a34 * fMatrix5x52.a41) + (fMatrix5x5.a35 * fMatrix5x52.a51);
        fMatrix5x53.a32 += (fMatrix5x5.a31 * fMatrix5x52.a12) + (fMatrix5x5.a32 * fMatrix5x52.a22) + (fMatrix5x5.a33 * fMatrix5x52.a32) + (fMatrix5x5.a34 * fMatrix5x52.a42) + (fMatrix5x5.a35 * fMatrix5x52.a52);
        fMatrix5x53.a33 += (fMatrix5x5.a31 * fMatrix5x52.a13) + (fMatrix5x5.a32 * fMatrix5x52.a23) + (fMatrix5x5.a33 * fMatrix5x52.a33) + (fMatrix5x5.a34 * fMatrix5x52.a43) + (fMatrix5x5.a35 * fMatrix5x52.a53);
        fMatrix5x53.a34 += (fMatrix5x5.a31 * fMatrix5x52.a14) + (fMatrix5x5.a32 * fMatrix5x52.a24) + (fMatrix5x5.a33 * fMatrix5x52.a34) + (fMatrix5x5.a34 * fMatrix5x52.a44) + (fMatrix5x5.a35 * fMatrix5x52.a54);
        fMatrix5x53.a35 += (fMatrix5x5.a31 * fMatrix5x52.a15) + (fMatrix5x5.a32 * fMatrix5x52.a25) + (fMatrix5x5.a33 * fMatrix5x52.a35) + (fMatrix5x5.a34 * fMatrix5x52.a45) + (fMatrix5x5.a35 * fMatrix5x52.a55);
        fMatrix5x53.a41 += (fMatrix5x5.a41 * fMatrix5x52.a11) + (fMatrix5x5.a42 * fMatrix5x52.a21) + (fMatrix5x5.a43 * fMatrix5x52.a31) + (fMatrix5x5.a44 * fMatrix5x52.a41) + (fMatrix5x5.a45 * fMatrix5x52.a51);
        fMatrix5x53.a42 += (fMatrix5x5.a41 * fMatrix5x52.a12) + (fMatrix5x5.a42 * fMatrix5x52.a22) + (fMatrix5x5.a43 * fMatrix5x52.a32) + (fMatrix5x5.a44 * fMatrix5x52.a42) + (fMatrix5x5.a45 * fMatrix5x52.a52);
        fMatrix5x53.a43 += (fMatrix5x5.a41 * fMatrix5x52.a13) + (fMatrix5x5.a42 * fMatrix5x52.a23) + (fMatrix5x5.a43 * fMatrix5x52.a33) + (fMatrix5x5.a44 * fMatrix5x52.a43) + (fMatrix5x5.a45 * fMatrix5x52.a53);
        fMatrix5x53.a44 += (fMatrix5x5.a41 * fMatrix5x52.a14) + (fMatrix5x5.a42 * fMatrix5x52.a24) + (fMatrix5x5.a43 * fMatrix5x52.a34) + (fMatrix5x5.a44 * fMatrix5x52.a44) + (fMatrix5x5.a45 * fMatrix5x52.a54);
        fMatrix5x53.a45 += (fMatrix5x5.a41 * fMatrix5x52.a15) + (fMatrix5x5.a42 * fMatrix5x52.a25) + (fMatrix5x5.a43 * fMatrix5x52.a35) + (fMatrix5x5.a44 * fMatrix5x52.a45) + (fMatrix5x5.a45 * fMatrix5x52.a55);
        fMatrix5x53.a51 += (fMatrix5x5.a51 * fMatrix5x52.a11) + (fMatrix5x5.a52 * fMatrix5x52.a21) + (fMatrix5x5.a53 * fMatrix5x52.a31) + (fMatrix5x5.a54 * fMatrix5x52.a41) + (fMatrix5x5.a55 * fMatrix5x52.a51);
        fMatrix5x53.a52 += (fMatrix5x5.a51 * fMatrix5x52.a12) + (fMatrix5x5.a52 * fMatrix5x52.a22) + (fMatrix5x5.a53 * fMatrix5x52.a32) + (fMatrix5x5.a54 * fMatrix5x52.a42) + (fMatrix5x5.a55 * fMatrix5x52.a52);
        fMatrix5x53.a53 += (fMatrix5x5.a51 * fMatrix5x52.a13) + (fMatrix5x5.a52 * fMatrix5x52.a23) + (fMatrix5x5.a53 * fMatrix5x52.a33) + (fMatrix5x5.a54 * fMatrix5x52.a43) + (fMatrix5x5.a55 * fMatrix5x52.a53);
        fMatrix5x53.a54 += (fMatrix5x5.a51 * fMatrix5x52.a14) + (fMatrix5x5.a52 * fMatrix5x52.a24) + (fMatrix5x5.a53 * fMatrix5x52.a34) + (fMatrix5x5.a54 * fMatrix5x52.a44) + (fMatrix5x5.a55 * fMatrix5x52.a54);
        fMatrix5x53.a55 += (fMatrix5x5.a51 * fMatrix5x52.a15) + (fMatrix5x5.a52 * fMatrix5x52.a25) + (fMatrix5x5.a53 * fMatrix5x52.a35) + (fMatrix5x5.a54 * fMatrix5x52.a45) + (fMatrix5x5.a55 * fMatrix5x52.a55);
    }

    public static void multAddTransA(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52, FMatrix5x5 fMatrix5x53) {
        fMatrix5x53.a11 += (fMatrix5x5.a11 * fMatrix5x52.a11) + (fMatrix5x5.a21 * fMatrix5x52.a21) + (fMatrix5x5.a31 * fMatrix5x52.a31) + (fMatrix5x5.a41 * fMatrix5x52.a41) + (fMatrix5x5.a51 * fMatrix5x52.a51);
        fMatrix5x53.a12 += (fMatrix5x5.a11 * fMatrix5x52.a12) + (fMatrix5x5.a21 * fMatrix5x52.a22) + (fMatrix5x5.a31 * fMatrix5x52.a32) + (fMatrix5x5.a41 * fMatrix5x52.a42) + (fMatrix5x5.a51 * fMatrix5x52.a52);
        fMatrix5x53.a13 += (fMatrix5x5.a11 * fMatrix5x52.a13) + (fMatrix5x5.a21 * fMatrix5x52.a23) + (fMatrix5x5.a31 * fMatrix5x52.a33) + (fMatrix5x5.a41 * fMatrix5x52.a43) + (fMatrix5x5.a51 * fMatrix5x52.a53);
        fMatrix5x53.a14 += (fMatrix5x5.a11 * fMatrix5x52.a14) + (fMatrix5x5.a21 * fMatrix5x52.a24) + (fMatrix5x5.a31 * fMatrix5x52.a34) + (fMatrix5x5.a41 * fMatrix5x52.a44) + (fMatrix5x5.a51 * fMatrix5x52.a54);
        fMatrix5x53.a15 += (fMatrix5x5.a11 * fMatrix5x52.a15) + (fMatrix5x5.a21 * fMatrix5x52.a25) + (fMatrix5x5.a31 * fMatrix5x52.a35) + (fMatrix5x5.a41 * fMatrix5x52.a45) + (fMatrix5x5.a51 * fMatrix5x52.a55);
        fMatrix5x53.a21 += (fMatrix5x5.a12 * fMatrix5x52.a11) + (fMatrix5x5.a22 * fMatrix5x52.a21) + (fMatrix5x5.a32 * fMatrix5x52.a31) + (fMatrix5x5.a42 * fMatrix5x52.a41) + (fMatrix5x5.a52 * fMatrix5x52.a51);
        fMatrix5x53.a22 += (fMatrix5x5.a12 * fMatrix5x52.a12) + (fMatrix5x5.a22 * fMatrix5x52.a22) + (fMatrix5x5.a32 * fMatrix5x52.a32) + (fMatrix5x5.a42 * fMatrix5x52.a42) + (fMatrix5x5.a52 * fMatrix5x52.a52);
        fMatrix5x53.a23 += (fMatrix5x5.a12 * fMatrix5x52.a13) + (fMatrix5x5.a22 * fMatrix5x52.a23) + (fMatrix5x5.a32 * fMatrix5x52.a33) + (fMatrix5x5.a42 * fMatrix5x52.a43) + (fMatrix5x5.a52 * fMatrix5x52.a53);
        fMatrix5x53.a24 += (fMatrix5x5.a12 * fMatrix5x52.a14) + (fMatrix5x5.a22 * fMatrix5x52.a24) + (fMatrix5x5.a32 * fMatrix5x52.a34) + (fMatrix5x5.a42 * fMatrix5x52.a44) + (fMatrix5x5.a52 * fMatrix5x52.a54);
        fMatrix5x53.a25 += (fMatrix5x5.a12 * fMatrix5x52.a15) + (fMatrix5x5.a22 * fMatrix5x52.a25) + (fMatrix5x5.a32 * fMatrix5x52.a35) + (fMatrix5x5.a42 * fMatrix5x52.a45) + (fMatrix5x5.a52 * fMatrix5x52.a55);
        fMatrix5x53.a31 += (fMatrix5x5.a13 * fMatrix5x52.a11) + (fMatrix5x5.a23 * fMatrix5x52.a21) + (fMatrix5x5.a33 * fMatrix5x52.a31) + (fMatrix5x5.a43 * fMatrix5x52.a41) + (fMatrix5x5.a53 * fMatrix5x52.a51);
        fMatrix5x53.a32 += (fMatrix5x5.a13 * fMatrix5x52.a12) + (fMatrix5x5.a23 * fMatrix5x52.a22) + (fMatrix5x5.a33 * fMatrix5x52.a32) + (fMatrix5x5.a43 * fMatrix5x52.a42) + (fMatrix5x5.a53 * fMatrix5x52.a52);
        fMatrix5x53.a33 += (fMatrix5x5.a13 * fMatrix5x52.a13) + (fMatrix5x5.a23 * fMatrix5x52.a23) + (fMatrix5x5.a33 * fMatrix5x52.a33) + (fMatrix5x5.a43 * fMatrix5x52.a43) + (fMatrix5x5.a53 * fMatrix5x52.a53);
        fMatrix5x53.a34 += (fMatrix5x5.a13 * fMatrix5x52.a14) + (fMatrix5x5.a23 * fMatrix5x52.a24) + (fMatrix5x5.a33 * fMatrix5x52.a34) + (fMatrix5x5.a43 * fMatrix5x52.a44) + (fMatrix5x5.a53 * fMatrix5x52.a54);
        fMatrix5x53.a35 += (fMatrix5x5.a13 * fMatrix5x52.a15) + (fMatrix5x5.a23 * fMatrix5x52.a25) + (fMatrix5x5.a33 * fMatrix5x52.a35) + (fMatrix5x5.a43 * fMatrix5x52.a45) + (fMatrix5x5.a53 * fMatrix5x52.a55);
        fMatrix5x53.a41 += (fMatrix5x5.a14 * fMatrix5x52.a11) + (fMatrix5x5.a24 * fMatrix5x52.a21) + (fMatrix5x5.a34 * fMatrix5x52.a31) + (fMatrix5x5.a44 * fMatrix5x52.a41) + (fMatrix5x5.a54 * fMatrix5x52.a51);
        fMatrix5x53.a42 += (fMatrix5x5.a14 * fMatrix5x52.a12) + (fMatrix5x5.a24 * fMatrix5x52.a22) + (fMatrix5x5.a34 * fMatrix5x52.a32) + (fMatrix5x5.a44 * fMatrix5x52.a42) + (fMatrix5x5.a54 * fMatrix5x52.a52);
        fMatrix5x53.a43 += (fMatrix5x5.a14 * fMatrix5x52.a13) + (fMatrix5x5.a24 * fMatrix5x52.a23) + (fMatrix5x5.a34 * fMatrix5x52.a33) + (fMatrix5x5.a44 * fMatrix5x52.a43) + (fMatrix5x5.a54 * fMatrix5x52.a53);
        fMatrix5x53.a44 += (fMatrix5x5.a14 * fMatrix5x52.a14) + (fMatrix5x5.a24 * fMatrix5x52.a24) + (fMatrix5x5.a34 * fMatrix5x52.a34) + (fMatrix5x5.a44 * fMatrix5x52.a44) + (fMatrix5x5.a54 * fMatrix5x52.a54);
        fMatrix5x53.a45 += (fMatrix5x5.a14 * fMatrix5x52.a15) + (fMatrix5x5.a24 * fMatrix5x52.a25) + (fMatrix5x5.a34 * fMatrix5x52.a35) + (fMatrix5x5.a44 * fMatrix5x52.a45) + (fMatrix5x5.a54 * fMatrix5x52.a55);
        fMatrix5x53.a51 += (fMatrix5x5.a15 * fMatrix5x52.a11) + (fMatrix5x5.a25 * fMatrix5x52.a21) + (fMatrix5x5.a35 * fMatrix5x52.a31) + (fMatrix5x5.a45 * fMatrix5x52.a41) + (fMatrix5x5.a55 * fMatrix5x52.a51);
        fMatrix5x53.a52 += (fMatrix5x5.a15 * fMatrix5x52.a12) + (fMatrix5x5.a25 * fMatrix5x52.a22) + (fMatrix5x5.a35 * fMatrix5x52.a32) + (fMatrix5x5.a45 * fMatrix5x52.a42) + (fMatrix5x5.a55 * fMatrix5x52.a52);
        fMatrix5x53.a53 += (fMatrix5x5.a15 * fMatrix5x52.a13) + (fMatrix5x5.a25 * fMatrix5x52.a23) + (fMatrix5x5.a35 * fMatrix5x52.a33) + (fMatrix5x5.a45 * fMatrix5x52.a43) + (fMatrix5x5.a55 * fMatrix5x52.a53);
        fMatrix5x53.a54 += (fMatrix5x5.a15 * fMatrix5x52.a14) + (fMatrix5x5.a25 * fMatrix5x52.a24) + (fMatrix5x5.a35 * fMatrix5x52.a34) + (fMatrix5x5.a45 * fMatrix5x52.a44) + (fMatrix5x5.a55 * fMatrix5x52.a54);
        fMatrix5x53.a55 += (fMatrix5x5.a15 * fMatrix5x52.a15) + (fMatrix5x5.a25 * fMatrix5x52.a25) + (fMatrix5x5.a35 * fMatrix5x52.a35) + (fMatrix5x5.a45 * fMatrix5x52.a45) + (fMatrix5x5.a55 * fMatrix5x52.a55);
    }

    public static void multAddTransAB(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52, FMatrix5x5 fMatrix5x53) {
        fMatrix5x53.a11 += (fMatrix5x5.a11 * fMatrix5x52.a11) + (fMatrix5x5.a21 * fMatrix5x52.a12) + (fMatrix5x5.a31 * fMatrix5x52.a13) + (fMatrix5x5.a41 * fMatrix5x52.a14) + (fMatrix5x5.a51 * fMatrix5x52.a15);
        fMatrix5x53.a12 += (fMatrix5x5.a11 * fMatrix5x52.a21) + (fMatrix5x5.a21 * fMatrix5x52.a22) + (fMatrix5x5.a31 * fMatrix5x52.a23) + (fMatrix5x5.a41 * fMatrix5x52.a24) + (fMatrix5x5.a51 * fMatrix5x52.a25);
        fMatrix5x53.a13 += (fMatrix5x5.a11 * fMatrix5x52.a31) + (fMatrix5x5.a21 * fMatrix5x52.a32) + (fMatrix5x5.a31 * fMatrix5x52.a33) + (fMatrix5x5.a41 * fMatrix5x52.a34) + (fMatrix5x5.a51 * fMatrix5x52.a35);
        fMatrix5x53.a14 += (fMatrix5x5.a11 * fMatrix5x52.a41) + (fMatrix5x5.a21 * fMatrix5x52.a42) + (fMatrix5x5.a31 * fMatrix5x52.a43) + (fMatrix5x5.a41 * fMatrix5x52.a44) + (fMatrix5x5.a51 * fMatrix5x52.a45);
        fMatrix5x53.a15 += (fMatrix5x5.a11 * fMatrix5x52.a51) + (fMatrix5x5.a21 * fMatrix5x52.a52) + (fMatrix5x5.a31 * fMatrix5x52.a53) + (fMatrix5x5.a41 * fMatrix5x52.a54) + (fMatrix5x5.a51 * fMatrix5x52.a55);
        fMatrix5x53.a21 += (fMatrix5x5.a12 * fMatrix5x52.a11) + (fMatrix5x5.a22 * fMatrix5x52.a12) + (fMatrix5x5.a32 * fMatrix5x52.a13) + (fMatrix5x5.a42 * fMatrix5x52.a14) + (fMatrix5x5.a52 * fMatrix5x52.a15);
        fMatrix5x53.a22 += (fMatrix5x5.a12 * fMatrix5x52.a21) + (fMatrix5x5.a22 * fMatrix5x52.a22) + (fMatrix5x5.a32 * fMatrix5x52.a23) + (fMatrix5x5.a42 * fMatrix5x52.a24) + (fMatrix5x5.a52 * fMatrix5x52.a25);
        fMatrix5x53.a23 += (fMatrix5x5.a12 * fMatrix5x52.a31) + (fMatrix5x5.a22 * fMatrix5x52.a32) + (fMatrix5x5.a32 * fMatrix5x52.a33) + (fMatrix5x5.a42 * fMatrix5x52.a34) + (fMatrix5x5.a52 * fMatrix5x52.a35);
        fMatrix5x53.a24 += (fMatrix5x5.a12 * fMatrix5x52.a41) + (fMatrix5x5.a22 * fMatrix5x52.a42) + (fMatrix5x5.a32 * fMatrix5x52.a43) + (fMatrix5x5.a42 * fMatrix5x52.a44) + (fMatrix5x5.a52 * fMatrix5x52.a45);
        fMatrix5x53.a25 += (fMatrix5x5.a12 * fMatrix5x52.a51) + (fMatrix5x5.a22 * fMatrix5x52.a52) + (fMatrix5x5.a32 * fMatrix5x52.a53) + (fMatrix5x5.a42 * fMatrix5x52.a54) + (fMatrix5x5.a52 * fMatrix5x52.a55);
        fMatrix5x53.a31 += (fMatrix5x5.a13 * fMatrix5x52.a11) + (fMatrix5x5.a23 * fMatrix5x52.a12) + (fMatrix5x5.a33 * fMatrix5x52.a13) + (fMatrix5x5.a43 * fMatrix5x52.a14) + (fMatrix5x5.a53 * fMatrix5x52.a15);
        fMatrix5x53.a32 += (fMatrix5x5.a13 * fMatrix5x52.a21) + (fMatrix5x5.a23 * fMatrix5x52.a22) + (fMatrix5x5.a33 * fMatrix5x52.a23) + (fMatrix5x5.a43 * fMatrix5x52.a24) + (fMatrix5x5.a53 * fMatrix5x52.a25);
        fMatrix5x53.a33 += (fMatrix5x5.a13 * fMatrix5x52.a31) + (fMatrix5x5.a23 * fMatrix5x52.a32) + (fMatrix5x5.a33 * fMatrix5x52.a33) + (fMatrix5x5.a43 * fMatrix5x52.a34) + (fMatrix5x5.a53 * fMatrix5x52.a35);
        fMatrix5x53.a34 += (fMatrix5x5.a13 * fMatrix5x52.a41) + (fMatrix5x5.a23 * fMatrix5x52.a42) + (fMatrix5x5.a33 * fMatrix5x52.a43) + (fMatrix5x5.a43 * fMatrix5x52.a44) + (fMatrix5x5.a53 * fMatrix5x52.a45);
        fMatrix5x53.a35 += (fMatrix5x5.a13 * fMatrix5x52.a51) + (fMatrix5x5.a23 * fMatrix5x52.a52) + (fMatrix5x5.a33 * fMatrix5x52.a53) + (fMatrix5x5.a43 * fMatrix5x52.a54) + (fMatrix5x5.a53 * fMatrix5x52.a55);
        fMatrix5x53.a41 += (fMatrix5x5.a14 * fMatrix5x52.a11) + (fMatrix5x5.a24 * fMatrix5x52.a12) + (fMatrix5x5.a34 * fMatrix5x52.a13) + (fMatrix5x5.a44 * fMatrix5x52.a14) + (fMatrix5x5.a54 * fMatrix5x52.a15);
        fMatrix5x53.a42 += (fMatrix5x5.a14 * fMatrix5x52.a21) + (fMatrix5x5.a24 * fMatrix5x52.a22) + (fMatrix5x5.a34 * fMatrix5x52.a23) + (fMatrix5x5.a44 * fMatrix5x52.a24) + (fMatrix5x5.a54 * fMatrix5x52.a25);
        fMatrix5x53.a43 += (fMatrix5x5.a14 * fMatrix5x52.a31) + (fMatrix5x5.a24 * fMatrix5x52.a32) + (fMatrix5x5.a34 * fMatrix5x52.a33) + (fMatrix5x5.a44 * fMatrix5x52.a34) + (fMatrix5x5.a54 * fMatrix5x52.a35);
        fMatrix5x53.a44 += (fMatrix5x5.a14 * fMatrix5x52.a41) + (fMatrix5x5.a24 * fMatrix5x52.a42) + (fMatrix5x5.a34 * fMatrix5x52.a43) + (fMatrix5x5.a44 * fMatrix5x52.a44) + (fMatrix5x5.a54 * fMatrix5x52.a45);
        fMatrix5x53.a45 += (fMatrix5x5.a14 * fMatrix5x52.a51) + (fMatrix5x5.a24 * fMatrix5x52.a52) + (fMatrix5x5.a34 * fMatrix5x52.a53) + (fMatrix5x5.a44 * fMatrix5x52.a54) + (fMatrix5x5.a54 * fMatrix5x52.a55);
        fMatrix5x53.a51 += (fMatrix5x5.a15 * fMatrix5x52.a11) + (fMatrix5x5.a25 * fMatrix5x52.a12) + (fMatrix5x5.a35 * fMatrix5x52.a13) + (fMatrix5x5.a45 * fMatrix5x52.a14) + (fMatrix5x5.a55 * fMatrix5x52.a15);
        fMatrix5x53.a52 += (fMatrix5x5.a15 * fMatrix5x52.a21) + (fMatrix5x5.a25 * fMatrix5x52.a22) + (fMatrix5x5.a35 * fMatrix5x52.a23) + (fMatrix5x5.a45 * fMatrix5x52.a24) + (fMatrix5x5.a55 * fMatrix5x52.a25);
        fMatrix5x53.a53 += (fMatrix5x5.a15 * fMatrix5x52.a31) + (fMatrix5x5.a25 * fMatrix5x52.a32) + (fMatrix5x5.a35 * fMatrix5x52.a33) + (fMatrix5x5.a45 * fMatrix5x52.a34) + (fMatrix5x5.a55 * fMatrix5x52.a35);
        fMatrix5x53.a54 += (fMatrix5x5.a15 * fMatrix5x52.a41) + (fMatrix5x5.a25 * fMatrix5x52.a42) + (fMatrix5x5.a35 * fMatrix5x52.a43) + (fMatrix5x5.a45 * fMatrix5x52.a44) + (fMatrix5x5.a55 * fMatrix5x52.a45);
        fMatrix5x53.a55 += (fMatrix5x5.a15 * fMatrix5x52.a51) + (fMatrix5x5.a25 * fMatrix5x52.a52) + (fMatrix5x5.a35 * fMatrix5x52.a53) + (fMatrix5x5.a45 * fMatrix5x52.a54) + (fMatrix5x5.a55 * fMatrix5x52.a55);
    }

    public static void multAddTransB(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52, FMatrix5x5 fMatrix5x53) {
        fMatrix5x53.a11 += (fMatrix5x5.a11 * fMatrix5x52.a11) + (fMatrix5x5.a12 * fMatrix5x52.a12) + (fMatrix5x5.a13 * fMatrix5x52.a13) + (fMatrix5x5.a14 * fMatrix5x52.a14) + (fMatrix5x5.a15 * fMatrix5x52.a15);
        fMatrix5x53.a12 += (fMatrix5x5.a11 * fMatrix5x52.a21) + (fMatrix5x5.a12 * fMatrix5x52.a22) + (fMatrix5x5.a13 * fMatrix5x52.a23) + (fMatrix5x5.a14 * fMatrix5x52.a24) + (fMatrix5x5.a15 * fMatrix5x52.a25);
        fMatrix5x53.a13 += (fMatrix5x5.a11 * fMatrix5x52.a31) + (fMatrix5x5.a12 * fMatrix5x52.a32) + (fMatrix5x5.a13 * fMatrix5x52.a33) + (fMatrix5x5.a14 * fMatrix5x52.a34) + (fMatrix5x5.a15 * fMatrix5x52.a35);
        fMatrix5x53.a14 += (fMatrix5x5.a11 * fMatrix5x52.a41) + (fMatrix5x5.a12 * fMatrix5x52.a42) + (fMatrix5x5.a13 * fMatrix5x52.a43) + (fMatrix5x5.a14 * fMatrix5x52.a44) + (fMatrix5x5.a15 * fMatrix5x52.a45);
        fMatrix5x53.a15 += (fMatrix5x5.a11 * fMatrix5x52.a51) + (fMatrix5x5.a12 * fMatrix5x52.a52) + (fMatrix5x5.a13 * fMatrix5x52.a53) + (fMatrix5x5.a14 * fMatrix5x52.a54) + (fMatrix5x5.a15 * fMatrix5x52.a55);
        fMatrix5x53.a21 += (fMatrix5x5.a21 * fMatrix5x52.a11) + (fMatrix5x5.a22 * fMatrix5x52.a12) + (fMatrix5x5.a23 * fMatrix5x52.a13) + (fMatrix5x5.a24 * fMatrix5x52.a14) + (fMatrix5x5.a25 * fMatrix5x52.a15);
        fMatrix5x53.a22 += (fMatrix5x5.a21 * fMatrix5x52.a21) + (fMatrix5x5.a22 * fMatrix5x52.a22) + (fMatrix5x5.a23 * fMatrix5x52.a23) + (fMatrix5x5.a24 * fMatrix5x52.a24) + (fMatrix5x5.a25 * fMatrix5x52.a25);
        fMatrix5x53.a23 += (fMatrix5x5.a21 * fMatrix5x52.a31) + (fMatrix5x5.a22 * fMatrix5x52.a32) + (fMatrix5x5.a23 * fMatrix5x52.a33) + (fMatrix5x5.a24 * fMatrix5x52.a34) + (fMatrix5x5.a25 * fMatrix5x52.a35);
        fMatrix5x53.a24 += (fMatrix5x5.a21 * fMatrix5x52.a41) + (fMatrix5x5.a22 * fMatrix5x52.a42) + (fMatrix5x5.a23 * fMatrix5x52.a43) + (fMatrix5x5.a24 * fMatrix5x52.a44) + (fMatrix5x5.a25 * fMatrix5x52.a45);
        fMatrix5x53.a25 += (fMatrix5x5.a21 * fMatrix5x52.a51) + (fMatrix5x5.a22 * fMatrix5x52.a52) + (fMatrix5x5.a23 * fMatrix5x52.a53) + (fMatrix5x5.a24 * fMatrix5x52.a54) + (fMatrix5x5.a25 * fMatrix5x52.a55);
        fMatrix5x53.a31 += (fMatrix5x5.a31 * fMatrix5x52.a11) + (fMatrix5x5.a32 * fMatrix5x52.a12) + (fMatrix5x5.a33 * fMatrix5x52.a13) + (fMatrix5x5.a34 * fMatrix5x52.a14) + (fMatrix5x5.a35 * fMatrix5x52.a15);
        fMatrix5x53.a32 += (fMatrix5x5.a31 * fMatrix5x52.a21) + (fMatrix5x5.a32 * fMatrix5x52.a22) + (fMatrix5x5.a33 * fMatrix5x52.a23) + (fMatrix5x5.a34 * fMatrix5x52.a24) + (fMatrix5x5.a35 * fMatrix5x52.a25);
        fMatrix5x53.a33 += (fMatrix5x5.a31 * fMatrix5x52.a31) + (fMatrix5x5.a32 * fMatrix5x52.a32) + (fMatrix5x5.a33 * fMatrix5x52.a33) + (fMatrix5x5.a34 * fMatrix5x52.a34) + (fMatrix5x5.a35 * fMatrix5x52.a35);
        fMatrix5x53.a34 += (fMatrix5x5.a31 * fMatrix5x52.a41) + (fMatrix5x5.a32 * fMatrix5x52.a42) + (fMatrix5x5.a33 * fMatrix5x52.a43) + (fMatrix5x5.a34 * fMatrix5x52.a44) + (fMatrix5x5.a35 * fMatrix5x52.a45);
        fMatrix5x53.a35 += (fMatrix5x5.a31 * fMatrix5x52.a51) + (fMatrix5x5.a32 * fMatrix5x52.a52) + (fMatrix5x5.a33 * fMatrix5x52.a53) + (fMatrix5x5.a34 * fMatrix5x52.a54) + (fMatrix5x5.a35 * fMatrix5x52.a55);
        fMatrix5x53.a41 += (fMatrix5x5.a41 * fMatrix5x52.a11) + (fMatrix5x5.a42 * fMatrix5x52.a12) + (fMatrix5x5.a43 * fMatrix5x52.a13) + (fMatrix5x5.a44 * fMatrix5x52.a14) + (fMatrix5x5.a45 * fMatrix5x52.a15);
        fMatrix5x53.a42 += (fMatrix5x5.a41 * fMatrix5x52.a21) + (fMatrix5x5.a42 * fMatrix5x52.a22) + (fMatrix5x5.a43 * fMatrix5x52.a23) + (fMatrix5x5.a44 * fMatrix5x52.a24) + (fMatrix5x5.a45 * fMatrix5x52.a25);
        fMatrix5x53.a43 += (fMatrix5x5.a41 * fMatrix5x52.a31) + (fMatrix5x5.a42 * fMatrix5x52.a32) + (fMatrix5x5.a43 * fMatrix5x52.a33) + (fMatrix5x5.a44 * fMatrix5x52.a34) + (fMatrix5x5.a45 * fMatrix5x52.a35);
        fMatrix5x53.a44 += (fMatrix5x5.a41 * fMatrix5x52.a41) + (fMatrix5x5.a42 * fMatrix5x52.a42) + (fMatrix5x5.a43 * fMatrix5x52.a43) + (fMatrix5x5.a44 * fMatrix5x52.a44) + (fMatrix5x5.a45 * fMatrix5x52.a45);
        fMatrix5x53.a45 += (fMatrix5x5.a41 * fMatrix5x52.a51) + (fMatrix5x5.a42 * fMatrix5x52.a52) + (fMatrix5x5.a43 * fMatrix5x52.a53) + (fMatrix5x5.a44 * fMatrix5x52.a54) + (fMatrix5x5.a45 * fMatrix5x52.a55);
        fMatrix5x53.a51 += (fMatrix5x5.a51 * fMatrix5x52.a11) + (fMatrix5x5.a52 * fMatrix5x52.a12) + (fMatrix5x5.a53 * fMatrix5x52.a13) + (fMatrix5x5.a54 * fMatrix5x52.a14) + (fMatrix5x5.a55 * fMatrix5x52.a15);
        fMatrix5x53.a52 += (fMatrix5x5.a51 * fMatrix5x52.a21) + (fMatrix5x5.a52 * fMatrix5x52.a22) + (fMatrix5x5.a53 * fMatrix5x52.a23) + (fMatrix5x5.a54 * fMatrix5x52.a24) + (fMatrix5x5.a55 * fMatrix5x52.a25);
        fMatrix5x53.a53 += (fMatrix5x5.a51 * fMatrix5x52.a31) + (fMatrix5x5.a52 * fMatrix5x52.a32) + (fMatrix5x5.a53 * fMatrix5x52.a33) + (fMatrix5x5.a54 * fMatrix5x52.a34) + (fMatrix5x5.a55 * fMatrix5x52.a35);
        fMatrix5x53.a54 += (fMatrix5x5.a51 * fMatrix5x52.a41) + (fMatrix5x5.a52 * fMatrix5x52.a42) + (fMatrix5x5.a53 * fMatrix5x52.a43) + (fMatrix5x5.a54 * fMatrix5x52.a44) + (fMatrix5x5.a55 * fMatrix5x52.a45);
        fMatrix5x53.a55 += (fMatrix5x5.a51 * fMatrix5x52.a51) + (fMatrix5x5.a52 * fMatrix5x52.a52) + (fMatrix5x5.a53 * fMatrix5x52.a53) + (fMatrix5x5.a54 * fMatrix5x52.a54) + (fMatrix5x5.a55 * fMatrix5x52.a55);
    }

    public static void mult(FMatrix5x5 fMatrix5x5, FMatrix5 fMatrix5, FMatrix5 fMatrix52) {
        fMatrix52.f2427a1 = (fMatrix5x5.a11 * fMatrix5.f2427a1) + (fMatrix5x5.a12 * fMatrix5.f2428a2) + (fMatrix5x5.a13 * fMatrix5.f2429a3) + (fMatrix5x5.a14 * fMatrix5.f2430a4) + (fMatrix5x5.a15 * fMatrix5.f2431a5);
        fMatrix52.f2428a2 = (fMatrix5x5.a21 * fMatrix5.f2427a1) + (fMatrix5x5.a22 * fMatrix5.f2428a2) + (fMatrix5x5.a23 * fMatrix5.f2429a3) + (fMatrix5x5.a24 * fMatrix5.f2430a4) + (fMatrix5x5.a25 * fMatrix5.f2431a5);
        fMatrix52.f2429a3 = (fMatrix5x5.a31 * fMatrix5.f2427a1) + (fMatrix5x5.a32 * fMatrix5.f2428a2) + (fMatrix5x5.a33 * fMatrix5.f2429a3) + (fMatrix5x5.a34 * fMatrix5.f2430a4) + (fMatrix5x5.a35 * fMatrix5.f2431a5);
        fMatrix52.f2430a4 = (fMatrix5x5.a41 * fMatrix5.f2427a1) + (fMatrix5x5.a42 * fMatrix5.f2428a2) + (fMatrix5x5.a43 * fMatrix5.f2429a3) + (fMatrix5x5.a44 * fMatrix5.f2430a4) + (fMatrix5x5.a45 * fMatrix5.f2431a5);
        fMatrix52.f2431a5 = (fMatrix5x5.a51 * fMatrix5.f2427a1) + (fMatrix5x5.a52 * fMatrix5.f2428a2) + (fMatrix5x5.a53 * fMatrix5.f2429a3) + (fMatrix5x5.a54 * fMatrix5.f2430a4) + (fMatrix5x5.a55 * fMatrix5.f2431a5);
    }

    public static void mult(FMatrix5 fMatrix5, FMatrix5x5 fMatrix5x5, FMatrix5 fMatrix52) {
        fMatrix52.f2427a1 = (fMatrix5.f2427a1 * fMatrix5x5.a11) + (fMatrix5.f2428a2 * fMatrix5x5.a21) + (fMatrix5.f2429a3 * fMatrix5x5.a31) + (fMatrix5.f2430a4 * fMatrix5x5.a41) + (fMatrix5.f2431a5 * fMatrix5x5.a51);
        fMatrix52.f2428a2 = (fMatrix5.f2427a1 * fMatrix5x5.a12) + (fMatrix5.f2428a2 * fMatrix5x5.a22) + (fMatrix5.f2429a3 * fMatrix5x5.a32) + (fMatrix5.f2430a4 * fMatrix5x5.a42) + (fMatrix5.f2431a5 * fMatrix5x5.a52);
        fMatrix52.f2429a3 = (fMatrix5.f2427a1 * fMatrix5x5.a13) + (fMatrix5.f2428a2 * fMatrix5x5.a23) + (fMatrix5.f2429a3 * fMatrix5x5.a33) + (fMatrix5.f2430a4 * fMatrix5x5.a43) + (fMatrix5.f2431a5 * fMatrix5x5.a53);
        fMatrix52.f2430a4 = (fMatrix5.f2427a1 * fMatrix5x5.a14) + (fMatrix5.f2428a2 * fMatrix5x5.a24) + (fMatrix5.f2429a3 * fMatrix5x5.a34) + (fMatrix5.f2430a4 * fMatrix5x5.a44) + (fMatrix5.f2431a5 * fMatrix5x5.a54);
        fMatrix52.f2431a5 = (fMatrix5.f2427a1 * fMatrix5x5.a15) + (fMatrix5.f2428a2 * fMatrix5x5.a25) + (fMatrix5.f2429a3 * fMatrix5x5.a35) + (fMatrix5.f2430a4 * fMatrix5x5.a45) + (fMatrix5.f2431a5 * fMatrix5x5.a55);
    }

    public static float dot(FMatrix5 fMatrix5, FMatrix5 fMatrix52) {
        return (fMatrix5.f2427a1 * fMatrix52.f2427a1) + (fMatrix5.f2428a2 * fMatrix52.f2428a2) + (fMatrix5.f2429a3 * fMatrix52.f2429a3) + (fMatrix5.f2430a4 * fMatrix52.f2430a4) + (fMatrix5.f2431a5 * fMatrix52.f2431a5);
    }

    public static void setIdentity(FMatrix5x5 fMatrix5x5) {
        fMatrix5x5.a11 = 1.0f;
        fMatrix5x5.a21 = 0.0f;
        fMatrix5x5.a31 = 0.0f;
        fMatrix5x5.a41 = 0.0f;
        fMatrix5x5.a51 = 0.0f;
        fMatrix5x5.a12 = 0.0f;
        fMatrix5x5.a22 = 1.0f;
        fMatrix5x5.a32 = 0.0f;
        fMatrix5x5.a42 = 0.0f;
        fMatrix5x5.a52 = 0.0f;
        fMatrix5x5.a13 = 0.0f;
        fMatrix5x5.a23 = 0.0f;
        fMatrix5x5.a33 = 1.0f;
        fMatrix5x5.a43 = 0.0f;
        fMatrix5x5.a53 = 0.0f;
        fMatrix5x5.a14 = 0.0f;
        fMatrix5x5.a24 = 0.0f;
        fMatrix5x5.a34 = 0.0f;
        fMatrix5x5.a44 = 1.0f;
        fMatrix5x5.a54 = 0.0f;
        fMatrix5x5.a15 = 0.0f;
        fMatrix5x5.a25 = 0.0f;
        fMatrix5x5.a35 = 0.0f;
        fMatrix5x5.a45 = 0.0f;
        fMatrix5x5.a55 = 1.0f;
    }

    public static boolean invert(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52) {
        float fElementMaxAbs = 1.0f / elementMaxAbs(fMatrix5x5);
        float f = fMatrix5x5.a11 * fElementMaxAbs;
        float f2 = fMatrix5x5.a12 * fElementMaxAbs;
        float f3 = fMatrix5x5.a13 * fElementMaxAbs;
        float f4 = fMatrix5x5.a14 * fElementMaxAbs;
        float f5 = fMatrix5x5.a15 * fElementMaxAbs;
        float f6 = fMatrix5x5.a21 * fElementMaxAbs;
        float f7 = fMatrix5x5.a22 * fElementMaxAbs;
        float f8 = fMatrix5x5.a23 * fElementMaxAbs;
        float f9 = fMatrix5x5.a24 * fElementMaxAbs;
        float f10 = fMatrix5x5.a25 * fElementMaxAbs;
        float f11 = fMatrix5x5.a31 * fElementMaxAbs;
        float f12 = fMatrix5x5.a32 * fElementMaxAbs;
        float f13 = fMatrix5x5.a33 * fElementMaxAbs;
        float f14 = fMatrix5x5.a34 * fElementMaxAbs;
        float f15 = fMatrix5x5.a35 * fElementMaxAbs;
        float f16 = fMatrix5x5.a41 * fElementMaxAbs;
        float f17 = fMatrix5x5.a42 * fElementMaxAbs;
        float f18 = fMatrix5x5.a43 * fElementMaxAbs;
        float f19 = fMatrix5x5.a44 * fElementMaxAbs;
        float f20 = fMatrix5x5.a45 * fElementMaxAbs;
        float f21 = fMatrix5x5.a51 * fElementMaxAbs;
        float f22 = fMatrix5x5.a52 * fElementMaxAbs;
        float f23 = fMatrix5x5.a53 * fElementMaxAbs;
        float f24 = fMatrix5x5.a54 * fElementMaxAbs;
        float f25 = fMatrix5x5.a55 * fElementMaxAbs;
        float f26 = (f19 * f25) - (f20 * f24);
        float f27 = (f18 * f25) - (f20 * f23);
        float f28 = (f18 * f24) - (f19 * f23);
        float f29 = ((f13 * f26) - (f14 * f27)) + (f15 * f28);
        float f30 = (f17 * f25) - (f20 * f22);
        float f31 = (f17 * f24) - (f19 * f22);
        float f32 = ((f12 * f26) - (f14 * f30)) + (f15 * f31);
        float f33 = (f17 * f23) - (f18 * f22);
        float f34 = ((f12 * f27) - (f13 * f30)) + (f15 * f33);
        float f35 = ((f12 * f28) - (f13 * f31)) + (f14 * f33);
        float f36 = (((f7 * f29) - (f8 * f32)) + (f9 * f34)) - (f10 * f35);
        float f37 = (f16 * f25) - (f20 * f21);
        float f38 = (f16 * f24) - (f19 * f21);
        float f39 = ((f11 * f26) - (f14 * f37)) + (f15 * f38);
        float f40 = (f16 * f23) - (f18 * f21);
        float f41 = ((f11 * f27) - (f13 * f37)) + (f15 * f40);
        float f42 = ((f11 * f28) - (f13 * f38)) + (f14 * f40);
        float f43 = -((((f6 * f29) - (f8 * f39)) + (f9 * f41)) - (f10 * f42));
        float f44 = (f16 * f22) - (f17 * f21);
        float f45 = ((f11 * f30) - (f12 * f37)) + (f15 * f44);
        float f46 = ((f11 * f31) - (f12 * f38)) + (f14 * f44);
        float f47 = (((f6 * f32) - (f7 * f39)) + (f9 * f45)) - (f10 * f46);
        float f48 = ((f11 * f33) - (f12 * f40)) + (f13 * f44);
        float f49 = -((((f6 * f34) - (f7 * f41)) + (f8 * f45)) - (f10 * f48));
        float f50 = (((f6 * f35) - (f7 * f42)) + (f8 * f46)) - (f9 * f48);
        float f51 = -((((f2 * f29) - (f3 * f32)) + (f4 * f34)) - (f5 * f35));
        float f52 = (((f29 * f) - (f3 * f39)) + (f4 * f41)) - (f5 * f42);
        float f53 = -((((f32 * f) - (f39 * f2)) + (f4 * f45)) - (f5 * f46));
        float f54 = (((f34 * f) - (f41 * f2)) + (f45 * f3)) - (f5 * f48);
        float f55 = -((((f35 * f) - (f42 * f2)) + (f46 * f3)) - (f48 * f4));
        float f56 = ((f8 * f26) - (f9 * f27)) + (f10 * f28);
        float f57 = ((f7 * f26) - (f9 * f30)) + (f10 * f31);
        float f58 = ((f7 * f27) - (f8 * f30)) + (f10 * f33);
        float f59 = ((f7 * f28) - (f8 * f31)) + (f9 * f33);
        float f60 = (((f2 * f56) - (f3 * f57)) + (f4 * f58)) - (f5 * f59);
        float f61 = ((f26 * f6) - (f9 * f37)) + (f10 * f38);
        float f62 = ((f27 * f6) - (f8 * f37)) + (f10 * f40);
        float f63 = ((f28 * f6) - (f8 * f38)) + (f9 * f40);
        float f64 = -((((f56 * f) - (f3 * f61)) + (f4 * f62)) - (f5 * f63));
        float f65 = ((f30 * f6) - (f37 * f7)) + (f10 * f44);
        float f66 = ((f31 * f6) - (f38 * f7)) + (f9 * f44);
        float f67 = (((f57 * f) - (f61 * f2)) + (f4 * f65)) - (f5 * f66);
        float f68 = ((f33 * f6) - (f40 * f7)) + (f44 * f8);
        float f69 = -((((f58 * f) - (f62 * f2)) + (f65 * f3)) - (f5 * f68));
        float f70 = (((f59 * f) - (f63 * f2)) + (f66 * f3)) - (f68 * f4);
        float f71 = (f14 * f25) - (f15 * f24);
        float f72 = (f13 * f25) - (f15 * f23);
        float f73 = (f13 * f24) - (f14 * f23);
        float f74 = ((f8 * f71) - (f9 * f72)) + (f10 * f73);
        float f75 = (f12 * f25) - (f15 * f22);
        float f76 = (f12 * f24) - (f14 * f22);
        float f77 = ((f7 * f71) - (f9 * f75)) + (f10 * f76);
        float f78 = (f12 * f23) - (f13 * f22);
        float f79 = ((f7 * f72) - (f8 * f75)) + (f10 * f78);
        float f80 = ((f7 * f73) - (f8 * f76)) + (f9 * f78);
        float f81 = -((((f2 * f74) - (f3 * f77)) + (f4 * f79)) - (f5 * f80));
        float f82 = (f11 * f25) - (f15 * f21);
        float f83 = (f24 * f11) - (f14 * f21);
        float f84 = ((f71 * f6) - (f9 * f82)) + (f10 * f83);
        float f85 = (f23 * f11) - (f13 * f21);
        float f86 = ((f72 * f6) - (f8 * f82)) + (f10 * f85);
        float f87 = ((f73 * f6) - (f8 * f83)) + (f9 * f85);
        float f88 = (((f74 * f) - (f3 * f84)) + (f4 * f86)) - (f5 * f87);
        float f89 = (f22 * f11) - (f21 * f12);
        float f90 = ((f75 * f6) - (f82 * f7)) + (f10 * f89);
        float f91 = ((f76 * f6) - (f83 * f7)) + (f9 * f89);
        float f92 = -((((f77 * f) - (f84 * f2)) + (f4 * f90)) - (f5 * f91));
        float f93 = ((f78 * f6) - (f85 * f7)) + (f89 * f8);
        float f94 = (((f79 * f) - (f86 * f2)) + (f90 * f3)) - (f5 * f93);
        float f95 = -((((f80 * f) - (f87 * f2)) + (f91 * f3)) - (f93 * f4));
        float f96 = (f14 * f20) - (f15 * f19);
        float f97 = (f13 * f20) - (f15 * f18);
        float f98 = (f13 * f19) - (f14 * f18);
        float f99 = ((f8 * f96) - (f9 * f97)) + (f10 * f98);
        float f100 = (f12 * f20) - (f15 * f17);
        float f101 = (f12 * f19) - (f14 * f17);
        float f102 = ((f7 * f96) - (f9 * f100)) + (f10 * f101);
        float f103 = (f12 * f18) - (f13 * f17);
        float f104 = ((f7 * f97) - (f8 * f100)) + (f10 * f103);
        float f105 = ((f7 * f98) - (f8 * f101)) + (f9 * f103);
        float f106 = (((f2 * f99) - (f3 * f102)) + (f4 * f104)) - (f5 * f105);
        float f107 = (f20 * f11) - (f15 * f16);
        float f108 = (f11 * f19) - (f14 * f16);
        float f109 = ((f96 * f6) - (f9 * f107)) + (f10 * f108);
        float f110 = (f11 * f18) - (f13 * f16);
        float f111 = ((f97 * f6) - (f8 * f107)) + (f10 * f110);
        float f112 = ((f98 * f6) - (f8 * f108)) + (f9 * f110);
        float f113 = -((((f99 * f) - (f3 * f109)) + (f4 * f111)) - (f5 * f112));
        float f114 = (f11 * f17) - (f12 * f16);
        float f115 = ((f100 * f6) - (f107 * f7)) + (f10 * f114);
        float f116 = ((f101 * f6) - (f108 * f7)) + (f9 * f114);
        float f117 = (((f102 * f) - (f109 * f2)) + (f4 * f115)) - (f5 * f116);
        float f118 = ((f6 * f103) - (f7 * f110)) + (f8 * f114);
        float f119 = -((((f104 * f) - (f111 * f2)) + (f115 * f3)) - (f5 * f118));
        float f120 = (((f105 * f) - (f112 * f2)) + (f116 * f3)) - (f118 * f4);
        float f121 = (((((f * f36) + (f2 * f43)) + (f3 * f47)) + (f4 * f49)) + (f5 * f50)) / fElementMaxAbs;
        fMatrix5x52.a11 = f36 / f121;
        fMatrix5x52.a12 = f51 / f121;
        fMatrix5x52.a13 = f60 / f121;
        fMatrix5x52.a14 = f81 / f121;
        fMatrix5x52.a15 = f106 / f121;
        fMatrix5x52.a21 = f43 / f121;
        fMatrix5x52.a22 = f52 / f121;
        fMatrix5x52.a23 = f64 / f121;
        fMatrix5x52.a24 = f88 / f121;
        fMatrix5x52.a25 = f113 / f121;
        fMatrix5x52.a31 = f47 / f121;
        fMatrix5x52.a32 = f53 / f121;
        fMatrix5x52.a33 = f67 / f121;
        fMatrix5x52.a34 = f92 / f121;
        fMatrix5x52.a35 = f117 / f121;
        fMatrix5x52.a41 = f49 / f121;
        fMatrix5x52.a42 = f54 / f121;
        fMatrix5x52.a43 = f69 / f121;
        fMatrix5x52.a44 = f94 / f121;
        fMatrix5x52.a45 = f119 / f121;
        fMatrix5x52.a51 = f50 / f121;
        fMatrix5x52.a52 = f55 / f121;
        fMatrix5x52.a53 = f70 / f121;
        fMatrix5x52.a54 = f95 / f121;
        fMatrix5x52.a55 = f120 / f121;
        return (Float.isNaN(f121) || Float.isInfinite(f121)) ? false : true;
    }

    public static float det(FMatrix5x5 fMatrix5x5) {
        float f = fMatrix5x5.a22;
        float f2 = fMatrix5x5.a23;
        float f3 = fMatrix5x5.a24;
        float f4 = fMatrix5x5.a25;
        float f5 = fMatrix5x5.a32;
        float f6 = fMatrix5x5.a33;
        float f7 = fMatrix5x5.a34;
        float f8 = fMatrix5x5.a35;
        float f9 = fMatrix5x5.a42;
        float f10 = fMatrix5x5.a43;
        float f11 = fMatrix5x5.a44;
        float f12 = fMatrix5x5.a45;
        float f13 = fMatrix5x5.a52;
        float f14 = fMatrix5x5.a53;
        float f15 = fMatrix5x5.a54;
        float f16 = fMatrix5x5.a55;
        float f17 = (f11 * f16) - (f12 * f15);
        float f18 = (f10 * f16) - (f12 * f14);
        float f19 = (f10 * f15) - (f11 * f14);
        float f20 = ((f6 * f17) - (f7 * f18)) + (f8 * f19);
        float f21 = (f9 * f16) - (f12 * f13);
        float f22 = (f9 * f15) - (f11 * f13);
        float f23 = (f9 * f14) - (f13 * f10);
        float f24 = (fMatrix5x5.a11 * ((((f * f20) - ((((f5 * f17) - (f7 * f21)) + (f8 * f22)) * f2)) + ((((f5 * f18) - (f21 * f6)) + (f8 * f23)) * f3)) - ((((f5 * f19) - (f22 * f6)) + (f23 * f7)) * f4))) + 0.0f;
        float f25 = fMatrix5x5.a21;
        float f26 = fMatrix5x5.a31;
        float f27 = fMatrix5x5.a41;
        float f28 = fMatrix5x5.a51;
        float f29 = (f27 * f16) - (f12 * f28);
        float f30 = (f27 * f15) - (f11 * f28);
        float f31 = ((f26 * f17) - (f7 * f29)) + (f8 * f30);
        float f32 = (f14 * f27) - (f10 * f28);
        float f33 = f24 - (fMatrix5x5.a12 * ((((f20 * f25) - (f2 * f31)) + ((((f18 * f26) - (f6 * f29)) + (f8 * f32)) * f3)) - ((((f19 * f26) - (f6 * f30)) + (f32 * f7)) * f4)));
        float f34 = fMatrix5x5.a22;
        float f35 = fMatrix5x5.a32;
        float f36 = fMatrix5x5.a42;
        float f37 = fMatrix5x5.a52;
        float f38 = (f36 * f16) - (f12 * f37);
        float f39 = (f15 * f36) - (f11 * f37);
        float f40 = (f27 * f37) - (f36 * f28);
        float f41 = ((f26 * f38) - (f35 * f29)) + (f8 * f40);
        float f42 = f33 + (fMatrix5x5.a13 * (((((((f17 * f35) - (f7 * f38)) + (f8 * f39)) * f25) - (f31 * f34)) + (f3 * f41)) - ((((f39 * f26) - (f30 * f35)) + (f7 * f40)) * f4)));
        float f43 = fMatrix5x5.a23;
        float f44 = fMatrix5x5.a33;
        float f45 = fMatrix5x5.a43;
        float f46 = fMatrix5x5.a53;
        float f47 = (f16 * f45) - (f12 * f46);
        float f48 = (f35 * f47) - (f38 * f44);
        float f49 = (f36 * f46) - (f45 * f37);
        float f50 = (f27 * f46) - (f45 * f28);
        float f51 = (((f48 + (f8 * f49)) * f25) - ((((f47 * f26) - (f29 * f44)) + (f8 * f50)) * f34)) + (f41 * f43);
        float f52 = ((f26 * f49) - (f35 * f50)) + (f44 * f40);
        float f53 = f42 - (fMatrix5x5.a14 * (f51 - (f4 * f52)));
        float f54 = fMatrix5x5.a24;
        float f55 = fMatrix5x5.a34;
        float f56 = fMatrix5x5.a44;
        float f57 = fMatrix5x5.a54;
        float f58 = (f45 * f57) - (f56 * f46);
        float f59 = (f36 * f57) - (f37 * f56);
        float f60 = (f27 * f57) - (f56 * f28);
        return f53 + (fMatrix5x5.a15 * ((((f25 * (((f35 * f58) - (f44 * f59)) + (f49 * f55))) - (f34 * (((f58 * f26) - (f44 * f60)) + (f50 * f55)))) + (f43 * (((f26 * f59) - (f35 * f60)) + (f55 * f40)))) - (f54 * f52)));
    }

    public static float trace(FMatrix5x5 fMatrix5x5) {
        return fMatrix5x5.a11 + fMatrix5x5.a22 + fMatrix5x5.a33 + fMatrix5x5.a44 + fMatrix5x5.a55;
    }

    public static void diag(FMatrix5x5 fMatrix5x5, FMatrix5 fMatrix5) {
        fMatrix5.f2427a1 = fMatrix5x5.a11;
        fMatrix5.f2428a2 = fMatrix5x5.a22;
        fMatrix5.f2429a3 = fMatrix5x5.a33;
        fMatrix5.f2430a4 = fMatrix5x5.a44;
        fMatrix5.f2431a5 = fMatrix5x5.a55;
    }

    public static float elementMax(FMatrix5x5 fMatrix5x5) {
        float f = fMatrix5x5.a11;
        if (fMatrix5x5.a12 > f) {
            f = fMatrix5x5.a12;
        }
        if (fMatrix5x5.a13 > f) {
            f = fMatrix5x5.a13;
        }
        if (fMatrix5x5.a14 > f) {
            f = fMatrix5x5.a14;
        }
        if (fMatrix5x5.a15 > f) {
            f = fMatrix5x5.a15;
        }
        if (fMatrix5x5.a21 > f) {
            f = fMatrix5x5.a21;
        }
        if (fMatrix5x5.a22 > f) {
            f = fMatrix5x5.a22;
        }
        if (fMatrix5x5.a23 > f) {
            f = fMatrix5x5.a23;
        }
        if (fMatrix5x5.a24 > f) {
            f = fMatrix5x5.a24;
        }
        if (fMatrix5x5.a25 > f) {
            f = fMatrix5x5.a25;
        }
        if (fMatrix5x5.a31 > f) {
            f = fMatrix5x5.a31;
        }
        if (fMatrix5x5.a32 > f) {
            f = fMatrix5x5.a32;
        }
        if (fMatrix5x5.a33 > f) {
            f = fMatrix5x5.a33;
        }
        if (fMatrix5x5.a34 > f) {
            f = fMatrix5x5.a34;
        }
        if (fMatrix5x5.a35 > f) {
            f = fMatrix5x5.a35;
        }
        if (fMatrix5x5.a41 > f) {
            f = fMatrix5x5.a41;
        }
        if (fMatrix5x5.a42 > f) {
            f = fMatrix5x5.a42;
        }
        if (fMatrix5x5.a43 > f) {
            f = fMatrix5x5.a43;
        }
        if (fMatrix5x5.a44 > f) {
            f = fMatrix5x5.a44;
        }
        if (fMatrix5x5.a45 > f) {
            f = fMatrix5x5.a45;
        }
        if (fMatrix5x5.a51 > f) {
            f = fMatrix5x5.a51;
        }
        if (fMatrix5x5.a52 > f) {
            f = fMatrix5x5.a52;
        }
        if (fMatrix5x5.a53 > f) {
            f = fMatrix5x5.a53;
        }
        if (fMatrix5x5.a54 > f) {
            f = fMatrix5x5.a54;
        }
        return fMatrix5x5.a55 > f ? fMatrix5x5.a55 : f;
    }

    public static float elementMax(FMatrix5 fMatrix5) {
        float f = fMatrix5.f2427a1;
        if (fMatrix5.f2428a2 > f) {
            f = fMatrix5.f2428a2;
        }
        if (fMatrix5.f2429a3 > f) {
            f = fMatrix5.f2429a3;
        }
        if (fMatrix5.f2430a4 > f) {
            f = fMatrix5.f2430a4;
        }
        return fMatrix5.f2431a5 > f ? fMatrix5.f2431a5 : f;
    }

    public static float elementMaxAbs(FMatrix5x5 fMatrix5x5) {
        float fAbs = Math.abs(fMatrix5x5.a11);
        float fAbs2 = Math.abs(fMatrix5x5.a12);
        if (fAbs2 > fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix5x5.a13);
        if (fAbs3 > fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix5x5.a14);
        if (fAbs4 > fAbs) {
            fAbs = fAbs4;
        }
        float fAbs5 = Math.abs(fMatrix5x5.a15);
        if (fAbs5 > fAbs) {
            fAbs = fAbs5;
        }
        float fAbs6 = Math.abs(fMatrix5x5.a21);
        if (fAbs6 > fAbs) {
            fAbs = fAbs6;
        }
        float fAbs7 = Math.abs(fMatrix5x5.a22);
        if (fAbs7 > fAbs) {
            fAbs = fAbs7;
        }
        float fAbs8 = Math.abs(fMatrix5x5.a23);
        if (fAbs8 > fAbs) {
            fAbs = fAbs8;
        }
        float fAbs9 = Math.abs(fMatrix5x5.a24);
        if (fAbs9 > fAbs) {
            fAbs = fAbs9;
        }
        float fAbs10 = Math.abs(fMatrix5x5.a25);
        if (fAbs10 > fAbs) {
            fAbs = fAbs10;
        }
        float fAbs11 = Math.abs(fMatrix5x5.a31);
        if (fAbs11 > fAbs) {
            fAbs = fAbs11;
        }
        float fAbs12 = Math.abs(fMatrix5x5.a32);
        if (fAbs12 > fAbs) {
            fAbs = fAbs12;
        }
        float fAbs13 = Math.abs(fMatrix5x5.a33);
        if (fAbs13 > fAbs) {
            fAbs = fAbs13;
        }
        float fAbs14 = Math.abs(fMatrix5x5.a34);
        if (fAbs14 > fAbs) {
            fAbs = fAbs14;
        }
        float fAbs15 = Math.abs(fMatrix5x5.a35);
        if (fAbs15 > fAbs) {
            fAbs = fAbs15;
        }
        float fAbs16 = Math.abs(fMatrix5x5.a41);
        if (fAbs16 > fAbs) {
            fAbs = fAbs16;
        }
        float fAbs17 = Math.abs(fMatrix5x5.a42);
        if (fAbs17 > fAbs) {
            fAbs = fAbs17;
        }
        float fAbs18 = Math.abs(fMatrix5x5.a43);
        if (fAbs18 > fAbs) {
            fAbs = fAbs18;
        }
        float fAbs19 = Math.abs(fMatrix5x5.a44);
        if (fAbs19 > fAbs) {
            fAbs = fAbs19;
        }
        float fAbs20 = Math.abs(fMatrix5x5.a45);
        if (fAbs20 > fAbs) {
            fAbs = fAbs20;
        }
        float fAbs21 = Math.abs(fMatrix5x5.a51);
        if (fAbs21 > fAbs) {
            fAbs = fAbs21;
        }
        float fAbs22 = Math.abs(fMatrix5x5.a52);
        if (fAbs22 > fAbs) {
            fAbs = fAbs22;
        }
        float fAbs23 = Math.abs(fMatrix5x5.a53);
        if (fAbs23 > fAbs) {
            fAbs = fAbs23;
        }
        float fAbs24 = Math.abs(fMatrix5x5.a54);
        if (fAbs24 > fAbs) {
            fAbs = fAbs24;
        }
        float fAbs25 = Math.abs(fMatrix5x5.a55);
        return fAbs25 > fAbs ? fAbs25 : fAbs;
    }

    public static float elementMaxAbs(FMatrix5 fMatrix5) {
        float fAbs = Math.abs(fMatrix5.f2427a1);
        float fAbs2 = Math.abs(fMatrix5.f2428a2);
        if (fAbs2 > fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix5.f2428a2);
        if (fAbs3 > fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix5.f2429a3);
        if (fAbs4 > fAbs) {
            fAbs = fAbs4;
        }
        float fAbs5 = Math.abs(fMatrix5.f2430a4);
        if (fAbs5 > fAbs) {
            fAbs = fAbs5;
        }
        float fAbs6 = Math.abs(fMatrix5.f2431a5);
        return fAbs6 > fAbs ? fAbs6 : fAbs;
    }

    public static float elementMin(FMatrix5x5 fMatrix5x5) {
        float f = fMatrix5x5.a11;
        if (fMatrix5x5.a12 < f) {
            f = fMatrix5x5.a12;
        }
        if (fMatrix5x5.a13 < f) {
            f = fMatrix5x5.a13;
        }
        if (fMatrix5x5.a14 < f) {
            f = fMatrix5x5.a14;
        }
        if (fMatrix5x5.a15 < f) {
            f = fMatrix5x5.a15;
        }
        if (fMatrix5x5.a21 < f) {
            f = fMatrix5x5.a21;
        }
        if (fMatrix5x5.a22 < f) {
            f = fMatrix5x5.a22;
        }
        if (fMatrix5x5.a23 < f) {
            f = fMatrix5x5.a23;
        }
        if (fMatrix5x5.a24 < f) {
            f = fMatrix5x5.a24;
        }
        if (fMatrix5x5.a25 < f) {
            f = fMatrix5x5.a25;
        }
        if (fMatrix5x5.a31 < f) {
            f = fMatrix5x5.a31;
        }
        if (fMatrix5x5.a32 < f) {
            f = fMatrix5x5.a32;
        }
        if (fMatrix5x5.a33 < f) {
            f = fMatrix5x5.a33;
        }
        if (fMatrix5x5.a34 < f) {
            f = fMatrix5x5.a34;
        }
        if (fMatrix5x5.a35 < f) {
            f = fMatrix5x5.a35;
        }
        if (fMatrix5x5.a41 < f) {
            f = fMatrix5x5.a41;
        }
        if (fMatrix5x5.a42 < f) {
            f = fMatrix5x5.a42;
        }
        if (fMatrix5x5.a43 < f) {
            f = fMatrix5x5.a43;
        }
        if (fMatrix5x5.a44 < f) {
            f = fMatrix5x5.a44;
        }
        if (fMatrix5x5.a45 < f) {
            f = fMatrix5x5.a45;
        }
        if (fMatrix5x5.a51 < f) {
            f = fMatrix5x5.a51;
        }
        if (fMatrix5x5.a52 < f) {
            f = fMatrix5x5.a52;
        }
        if (fMatrix5x5.a53 < f) {
            f = fMatrix5x5.a53;
        }
        if (fMatrix5x5.a54 < f) {
            f = fMatrix5x5.a54;
        }
        return fMatrix5x5.a55 < f ? fMatrix5x5.a55 : f;
    }

    public static float elementMin(FMatrix5 fMatrix5) {
        float f = fMatrix5.f2427a1;
        if (fMatrix5.f2428a2 < f) {
            f = fMatrix5.f2428a2;
        }
        if (fMatrix5.f2429a3 < f) {
            f = fMatrix5.f2429a3;
        }
        if (fMatrix5.f2430a4 < f) {
            f = fMatrix5.f2430a4;
        }
        return fMatrix5.f2431a5 < f ? fMatrix5.f2431a5 : f;
    }

    public static float elementMinAbs(FMatrix5x5 fMatrix5x5) {
        float fAbs = Math.abs(fMatrix5x5.a11);
        float fAbs2 = Math.abs(fMatrix5x5.a12);
        if (fAbs2 < fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix5x5.a13);
        if (fAbs3 < fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix5x5.a14);
        if (fAbs4 < fAbs) {
            fAbs = fAbs4;
        }
        float fAbs5 = Math.abs(fMatrix5x5.a15);
        if (fAbs5 < fAbs) {
            fAbs = fAbs5;
        }
        float fAbs6 = Math.abs(fMatrix5x5.a21);
        if (fAbs6 < fAbs) {
            fAbs = fAbs6;
        }
        float fAbs7 = Math.abs(fMatrix5x5.a22);
        if (fAbs7 < fAbs) {
            fAbs = fAbs7;
        }
        float fAbs8 = Math.abs(fMatrix5x5.a23);
        if (fAbs8 < fAbs) {
            fAbs = fAbs8;
        }
        float fAbs9 = Math.abs(fMatrix5x5.a24);
        if (fAbs9 < fAbs) {
            fAbs = fAbs9;
        }
        float fAbs10 = Math.abs(fMatrix5x5.a25);
        if (fAbs10 < fAbs) {
            fAbs = fAbs10;
        }
        float fAbs11 = Math.abs(fMatrix5x5.a31);
        if (fAbs11 < fAbs) {
            fAbs = fAbs11;
        }
        float fAbs12 = Math.abs(fMatrix5x5.a32);
        if (fAbs12 < fAbs) {
            fAbs = fAbs12;
        }
        float fAbs13 = Math.abs(fMatrix5x5.a33);
        if (fAbs13 < fAbs) {
            fAbs = fAbs13;
        }
        float fAbs14 = Math.abs(fMatrix5x5.a34);
        if (fAbs14 < fAbs) {
            fAbs = fAbs14;
        }
        float fAbs15 = Math.abs(fMatrix5x5.a35);
        if (fAbs15 < fAbs) {
            fAbs = fAbs15;
        }
        float fAbs16 = Math.abs(fMatrix5x5.a41);
        if (fAbs16 < fAbs) {
            fAbs = fAbs16;
        }
        float fAbs17 = Math.abs(fMatrix5x5.a42);
        if (fAbs17 < fAbs) {
            fAbs = fAbs17;
        }
        float fAbs18 = Math.abs(fMatrix5x5.a43);
        if (fAbs18 < fAbs) {
            fAbs = fAbs18;
        }
        float fAbs19 = Math.abs(fMatrix5x5.a44);
        if (fAbs19 < fAbs) {
            fAbs = fAbs19;
        }
        float fAbs20 = Math.abs(fMatrix5x5.a45);
        if (fAbs20 < fAbs) {
            fAbs = fAbs20;
        }
        float fAbs21 = Math.abs(fMatrix5x5.a51);
        if (fAbs21 < fAbs) {
            fAbs = fAbs21;
        }
        float fAbs22 = Math.abs(fMatrix5x5.a52);
        if (fAbs22 < fAbs) {
            fAbs = fAbs22;
        }
        float fAbs23 = Math.abs(fMatrix5x5.a53);
        if (fAbs23 < fAbs) {
            fAbs = fAbs23;
        }
        float fAbs24 = Math.abs(fMatrix5x5.a54);
        if (fAbs24 < fAbs) {
            fAbs = fAbs24;
        }
        float fAbs25 = Math.abs(fMatrix5x5.a55);
        return fAbs25 < fAbs ? fAbs25 : fAbs;
    }

    public static float elementMinAbs(FMatrix5 fMatrix5) {
        float fAbs = Math.abs(fMatrix5.f2427a1);
        float fAbs2 = Math.abs(fMatrix5.f2427a1);
        if (fAbs2 < fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix5.f2428a2);
        if (fAbs3 < fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix5.f2429a3);
        if (fAbs4 < fAbs) {
            fAbs = fAbs4;
        }
        float fAbs5 = Math.abs(fMatrix5.f2430a4);
        if (fAbs5 < fAbs) {
            fAbs = fAbs5;
        }
        float fAbs6 = Math.abs(fMatrix5.f2431a5);
        return fAbs6 < fAbs ? fAbs6 : fAbs;
    }

    public static void elementMult(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52) {
        fMatrix5x5.a11 *= fMatrix5x52.a11;
        fMatrix5x5.a12 *= fMatrix5x52.a12;
        fMatrix5x5.a13 *= fMatrix5x52.a13;
        fMatrix5x5.a14 *= fMatrix5x52.a14;
        fMatrix5x5.a15 *= fMatrix5x52.a15;
        fMatrix5x5.a21 *= fMatrix5x52.a21;
        fMatrix5x5.a22 *= fMatrix5x52.a22;
        fMatrix5x5.a23 *= fMatrix5x52.a23;
        fMatrix5x5.a24 *= fMatrix5x52.a24;
        fMatrix5x5.a25 *= fMatrix5x52.a25;
        fMatrix5x5.a31 *= fMatrix5x52.a31;
        fMatrix5x5.a32 *= fMatrix5x52.a32;
        fMatrix5x5.a33 *= fMatrix5x52.a33;
        fMatrix5x5.a34 *= fMatrix5x52.a34;
        fMatrix5x5.a35 *= fMatrix5x52.a35;
        fMatrix5x5.a41 *= fMatrix5x52.a41;
        fMatrix5x5.a42 *= fMatrix5x52.a42;
        fMatrix5x5.a43 *= fMatrix5x52.a43;
        fMatrix5x5.a44 *= fMatrix5x52.a44;
        fMatrix5x5.a45 *= fMatrix5x52.a45;
        fMatrix5x5.a51 *= fMatrix5x52.a51;
        fMatrix5x5.a52 *= fMatrix5x52.a52;
        fMatrix5x5.a53 *= fMatrix5x52.a53;
        fMatrix5x5.a54 *= fMatrix5x52.a54;
        fMatrix5x5.a55 *= fMatrix5x52.a55;
    }

    public static void elementMult(FMatrix5 fMatrix5, FMatrix5 fMatrix52) {
        fMatrix5.f2427a1 *= fMatrix52.f2427a1;
        fMatrix5.f2428a2 *= fMatrix52.f2428a2;
        fMatrix5.f2429a3 *= fMatrix52.f2429a3;
        fMatrix5.f2430a4 *= fMatrix52.f2430a4;
        fMatrix5.f2431a5 *= fMatrix52.f2431a5;
    }

    public static void elementMult(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52, FMatrix5x5 fMatrix5x53) {
        fMatrix5x53.a11 = fMatrix5x5.a11 * fMatrix5x52.a11;
        fMatrix5x53.a12 = fMatrix5x5.a12 * fMatrix5x52.a12;
        fMatrix5x53.a13 = fMatrix5x5.a13 * fMatrix5x52.a13;
        fMatrix5x53.a14 = fMatrix5x5.a14 * fMatrix5x52.a14;
        fMatrix5x53.a15 = fMatrix5x5.a15 * fMatrix5x52.a15;
        fMatrix5x53.a21 = fMatrix5x5.a21 * fMatrix5x52.a21;
        fMatrix5x53.a22 = fMatrix5x5.a22 * fMatrix5x52.a22;
        fMatrix5x53.a23 = fMatrix5x5.a23 * fMatrix5x52.a23;
        fMatrix5x53.a24 = fMatrix5x5.a24 * fMatrix5x52.a24;
        fMatrix5x53.a25 = fMatrix5x5.a25 * fMatrix5x52.a25;
        fMatrix5x53.a31 = fMatrix5x5.a31 * fMatrix5x52.a31;
        fMatrix5x53.a32 = fMatrix5x5.a32 * fMatrix5x52.a32;
        fMatrix5x53.a33 = fMatrix5x5.a33 * fMatrix5x52.a33;
        fMatrix5x53.a34 = fMatrix5x5.a34 * fMatrix5x52.a34;
        fMatrix5x53.a35 = fMatrix5x5.a35 * fMatrix5x52.a35;
        fMatrix5x53.a41 = fMatrix5x5.a41 * fMatrix5x52.a41;
        fMatrix5x53.a42 = fMatrix5x5.a42 * fMatrix5x52.a42;
        fMatrix5x53.a43 = fMatrix5x5.a43 * fMatrix5x52.a43;
        fMatrix5x53.a44 = fMatrix5x5.a44 * fMatrix5x52.a44;
        fMatrix5x53.a45 = fMatrix5x5.a45 * fMatrix5x52.a45;
        fMatrix5x53.a51 = fMatrix5x5.a51 * fMatrix5x52.a51;
        fMatrix5x53.a52 = fMatrix5x5.a52 * fMatrix5x52.a52;
        fMatrix5x53.a53 = fMatrix5x5.a53 * fMatrix5x52.a53;
        fMatrix5x53.a54 = fMatrix5x5.a54 * fMatrix5x52.a54;
        fMatrix5x53.a55 = fMatrix5x5.a55 * fMatrix5x52.a55;
    }

    public static void elementMult(FMatrix5 fMatrix5, FMatrix5 fMatrix52, FMatrix5 fMatrix53) {
        fMatrix53.f2427a1 = fMatrix5.f2427a1 * fMatrix52.f2427a1;
        fMatrix53.f2428a2 = fMatrix5.f2428a2 * fMatrix52.f2428a2;
        fMatrix53.f2429a3 = fMatrix5.f2429a3 * fMatrix52.f2429a3;
        fMatrix53.f2430a4 = fMatrix5.f2430a4 * fMatrix52.f2430a4;
        fMatrix53.f2431a5 = fMatrix5.f2431a5 * fMatrix52.f2431a5;
    }

    public static void elementDiv(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52) {
        fMatrix5x5.a11 /= fMatrix5x52.a11;
        fMatrix5x5.a12 /= fMatrix5x52.a12;
        fMatrix5x5.a13 /= fMatrix5x52.a13;
        fMatrix5x5.a14 /= fMatrix5x52.a14;
        fMatrix5x5.a15 /= fMatrix5x52.a15;
        fMatrix5x5.a21 /= fMatrix5x52.a21;
        fMatrix5x5.a22 /= fMatrix5x52.a22;
        fMatrix5x5.a23 /= fMatrix5x52.a23;
        fMatrix5x5.a24 /= fMatrix5x52.a24;
        fMatrix5x5.a25 /= fMatrix5x52.a25;
        fMatrix5x5.a31 /= fMatrix5x52.a31;
        fMatrix5x5.a32 /= fMatrix5x52.a32;
        fMatrix5x5.a33 /= fMatrix5x52.a33;
        fMatrix5x5.a34 /= fMatrix5x52.a34;
        fMatrix5x5.a35 /= fMatrix5x52.a35;
        fMatrix5x5.a41 /= fMatrix5x52.a41;
        fMatrix5x5.a42 /= fMatrix5x52.a42;
        fMatrix5x5.a43 /= fMatrix5x52.a43;
        fMatrix5x5.a44 /= fMatrix5x52.a44;
        fMatrix5x5.a45 /= fMatrix5x52.a45;
        fMatrix5x5.a51 /= fMatrix5x52.a51;
        fMatrix5x5.a52 /= fMatrix5x52.a52;
        fMatrix5x5.a53 /= fMatrix5x52.a53;
        fMatrix5x5.a54 /= fMatrix5x52.a54;
        fMatrix5x5.a55 /= fMatrix5x52.a55;
    }

    public static void elementDiv(FMatrix5 fMatrix5, FMatrix5 fMatrix52) {
        fMatrix5.f2427a1 /= fMatrix52.f2427a1;
        fMatrix5.f2428a2 /= fMatrix52.f2428a2;
        fMatrix5.f2429a3 /= fMatrix52.f2429a3;
        fMatrix5.f2430a4 /= fMatrix52.f2430a4;
        fMatrix5.f2431a5 /= fMatrix52.f2431a5;
    }

    public static void elementDiv(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52, FMatrix5x5 fMatrix5x53) {
        fMatrix5x53.a11 = fMatrix5x5.a11 / fMatrix5x52.a11;
        fMatrix5x53.a12 = fMatrix5x5.a12 / fMatrix5x52.a12;
        fMatrix5x53.a13 = fMatrix5x5.a13 / fMatrix5x52.a13;
        fMatrix5x53.a14 = fMatrix5x5.a14 / fMatrix5x52.a14;
        fMatrix5x53.a15 = fMatrix5x5.a15 / fMatrix5x52.a15;
        fMatrix5x53.a21 = fMatrix5x5.a21 / fMatrix5x52.a21;
        fMatrix5x53.a22 = fMatrix5x5.a22 / fMatrix5x52.a22;
        fMatrix5x53.a23 = fMatrix5x5.a23 / fMatrix5x52.a23;
        fMatrix5x53.a24 = fMatrix5x5.a24 / fMatrix5x52.a24;
        fMatrix5x53.a25 = fMatrix5x5.a25 / fMatrix5x52.a25;
        fMatrix5x53.a31 = fMatrix5x5.a31 / fMatrix5x52.a31;
        fMatrix5x53.a32 = fMatrix5x5.a32 / fMatrix5x52.a32;
        fMatrix5x53.a33 = fMatrix5x5.a33 / fMatrix5x52.a33;
        fMatrix5x53.a34 = fMatrix5x5.a34 / fMatrix5x52.a34;
        fMatrix5x53.a35 = fMatrix5x5.a35 / fMatrix5x52.a35;
        fMatrix5x53.a41 = fMatrix5x5.a41 / fMatrix5x52.a41;
        fMatrix5x53.a42 = fMatrix5x5.a42 / fMatrix5x52.a42;
        fMatrix5x53.a43 = fMatrix5x5.a43 / fMatrix5x52.a43;
        fMatrix5x53.a44 = fMatrix5x5.a44 / fMatrix5x52.a44;
        fMatrix5x53.a45 = fMatrix5x5.a45 / fMatrix5x52.a45;
        fMatrix5x53.a51 = fMatrix5x5.a51 / fMatrix5x52.a51;
        fMatrix5x53.a52 = fMatrix5x5.a52 / fMatrix5x52.a52;
        fMatrix5x53.a53 = fMatrix5x5.a53 / fMatrix5x52.a53;
        fMatrix5x53.a54 = fMatrix5x5.a54 / fMatrix5x52.a54;
        fMatrix5x53.a55 = fMatrix5x5.a55 / fMatrix5x52.a55;
    }

    public static void elementDiv(FMatrix5 fMatrix5, FMatrix5 fMatrix52, FMatrix5 fMatrix53) {
        fMatrix53.f2427a1 = fMatrix5.f2427a1 / fMatrix52.f2427a1;
        fMatrix53.f2428a2 = fMatrix5.f2428a2 / fMatrix52.f2428a2;
        fMatrix53.f2429a3 = fMatrix5.f2429a3 / fMatrix52.f2429a3;
        fMatrix53.f2430a4 = fMatrix5.f2430a4 / fMatrix52.f2430a4;
        fMatrix53.f2431a5 = fMatrix5.f2431a5 / fMatrix52.f2431a5;
    }

    public static void scale(float f, FMatrix5x5 fMatrix5x5) {
        fMatrix5x5.a11 *= f;
        fMatrix5x5.a12 *= f;
        fMatrix5x5.a13 *= f;
        fMatrix5x5.a14 *= f;
        fMatrix5x5.a15 *= f;
        fMatrix5x5.a21 *= f;
        fMatrix5x5.a22 *= f;
        fMatrix5x5.a23 *= f;
        fMatrix5x5.a24 *= f;
        fMatrix5x5.a25 *= f;
        fMatrix5x5.a31 *= f;
        fMatrix5x5.a32 *= f;
        fMatrix5x5.a33 *= f;
        fMatrix5x5.a34 *= f;
        fMatrix5x5.a35 *= f;
        fMatrix5x5.a41 *= f;
        fMatrix5x5.a42 *= f;
        fMatrix5x5.a43 *= f;
        fMatrix5x5.a44 *= f;
        fMatrix5x5.a45 *= f;
        fMatrix5x5.a51 *= f;
        fMatrix5x5.a52 *= f;
        fMatrix5x5.a53 *= f;
        fMatrix5x5.a54 *= f;
        fMatrix5x5.a55 *= f;
    }

    public static void scale(float f, FMatrix5 fMatrix5) {
        fMatrix5.f2427a1 *= f;
        fMatrix5.f2428a2 *= f;
        fMatrix5.f2429a3 *= f;
        fMatrix5.f2430a4 *= f;
        fMatrix5.f2431a5 *= f;
    }

    public static void scale(float f, FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52) {
        fMatrix5x52.a11 = fMatrix5x5.a11 * f;
        fMatrix5x52.a12 = fMatrix5x5.a12 * f;
        fMatrix5x52.a13 = fMatrix5x5.a13 * f;
        fMatrix5x52.a14 = fMatrix5x5.a14 * f;
        fMatrix5x52.a15 = fMatrix5x5.a15 * f;
        fMatrix5x52.a21 = fMatrix5x5.a21 * f;
        fMatrix5x52.a22 = fMatrix5x5.a22 * f;
        fMatrix5x52.a23 = fMatrix5x5.a23 * f;
        fMatrix5x52.a24 = fMatrix5x5.a24 * f;
        fMatrix5x52.a25 = fMatrix5x5.a25 * f;
        fMatrix5x52.a31 = fMatrix5x5.a31 * f;
        fMatrix5x52.a32 = fMatrix5x5.a32 * f;
        fMatrix5x52.a33 = fMatrix5x5.a33 * f;
        fMatrix5x52.a34 = fMatrix5x5.a34 * f;
        fMatrix5x52.a35 = fMatrix5x5.a35 * f;
        fMatrix5x52.a41 = fMatrix5x5.a41 * f;
        fMatrix5x52.a42 = fMatrix5x5.a42 * f;
        fMatrix5x52.a43 = fMatrix5x5.a43 * f;
        fMatrix5x52.a44 = fMatrix5x5.a44 * f;
        fMatrix5x52.a45 = fMatrix5x5.a45 * f;
        fMatrix5x52.a51 = fMatrix5x5.a51 * f;
        fMatrix5x52.a52 = fMatrix5x5.a52 * f;
        fMatrix5x52.a53 = fMatrix5x5.a53 * f;
        fMatrix5x52.a54 = fMatrix5x5.a54 * f;
        fMatrix5x52.a55 = fMatrix5x5.a55 * f;
    }

    public static void scale(float f, FMatrix5 fMatrix5, FMatrix5 fMatrix52) {
        fMatrix52.f2427a1 = fMatrix5.f2427a1 * f;
        fMatrix52.f2428a2 = fMatrix5.f2428a2 * f;
        fMatrix52.f2429a3 = fMatrix5.f2429a3 * f;
        fMatrix52.f2430a4 = fMatrix5.f2430a4 * f;
        fMatrix52.f2431a5 = fMatrix5.f2431a5 * f;
    }

    public static void divide(FMatrix5x5 fMatrix5x5, float f) {
        fMatrix5x5.a11 /= f;
        fMatrix5x5.a12 /= f;
        fMatrix5x5.a13 /= f;
        fMatrix5x5.a14 /= f;
        fMatrix5x5.a15 /= f;
        fMatrix5x5.a21 /= f;
        fMatrix5x5.a22 /= f;
        fMatrix5x5.a23 /= f;
        fMatrix5x5.a24 /= f;
        fMatrix5x5.a25 /= f;
        fMatrix5x5.a31 /= f;
        fMatrix5x5.a32 /= f;
        fMatrix5x5.a33 /= f;
        fMatrix5x5.a34 /= f;
        fMatrix5x5.a35 /= f;
        fMatrix5x5.a41 /= f;
        fMatrix5x5.a42 /= f;
        fMatrix5x5.a43 /= f;
        fMatrix5x5.a44 /= f;
        fMatrix5x5.a45 /= f;
        fMatrix5x5.a51 /= f;
        fMatrix5x5.a52 /= f;
        fMatrix5x5.a53 /= f;
        fMatrix5x5.a54 /= f;
        fMatrix5x5.a55 /= f;
    }

    public static void divide(FMatrix5 fMatrix5, float f) {
        fMatrix5.f2427a1 /= f;
        fMatrix5.f2428a2 /= f;
        fMatrix5.f2429a3 /= f;
        fMatrix5.f2430a4 /= f;
        fMatrix5.f2431a5 /= f;
    }

    public static void divide(FMatrix5x5 fMatrix5x5, float f, FMatrix5x5 fMatrix5x52) {
        fMatrix5x52.a11 = fMatrix5x5.a11 / f;
        fMatrix5x52.a12 = fMatrix5x5.a12 / f;
        fMatrix5x52.a13 = fMatrix5x5.a13 / f;
        fMatrix5x52.a14 = fMatrix5x5.a14 / f;
        fMatrix5x52.a15 = fMatrix5x5.a15 / f;
        fMatrix5x52.a21 = fMatrix5x5.a21 / f;
        fMatrix5x52.a22 = fMatrix5x5.a22 / f;
        fMatrix5x52.a23 = fMatrix5x5.a23 / f;
        fMatrix5x52.a24 = fMatrix5x5.a24 / f;
        fMatrix5x52.a25 = fMatrix5x5.a25 / f;
        fMatrix5x52.a31 = fMatrix5x5.a31 / f;
        fMatrix5x52.a32 = fMatrix5x5.a32 / f;
        fMatrix5x52.a33 = fMatrix5x5.a33 / f;
        fMatrix5x52.a34 = fMatrix5x5.a34 / f;
        fMatrix5x52.a35 = fMatrix5x5.a35 / f;
        fMatrix5x52.a41 = fMatrix5x5.a41 / f;
        fMatrix5x52.a42 = fMatrix5x5.a42 / f;
        fMatrix5x52.a43 = fMatrix5x5.a43 / f;
        fMatrix5x52.a44 = fMatrix5x5.a44 / f;
        fMatrix5x52.a45 = fMatrix5x5.a45 / f;
        fMatrix5x52.a51 = fMatrix5x5.a51 / f;
        fMatrix5x52.a52 = fMatrix5x5.a52 / f;
        fMatrix5x52.a53 = fMatrix5x5.a53 / f;
        fMatrix5x52.a54 = fMatrix5x5.a54 / f;
        fMatrix5x52.a55 = fMatrix5x5.a55 / f;
    }

    public static void divide(FMatrix5 fMatrix5, float f, FMatrix5 fMatrix52) {
        fMatrix52.f2427a1 = fMatrix5.f2427a1 / f;
        fMatrix52.f2428a2 = fMatrix5.f2428a2 / f;
        fMatrix52.f2429a3 = fMatrix5.f2429a3 / f;
        fMatrix52.f2430a4 = fMatrix5.f2430a4 / f;
        fMatrix52.f2431a5 = fMatrix5.f2431a5 / f;
    }

    public static void changeSign(FMatrix5x5 fMatrix5x5) {
        fMatrix5x5.a11 = -fMatrix5x5.a11;
        fMatrix5x5.a12 = -fMatrix5x5.a12;
        fMatrix5x5.a13 = -fMatrix5x5.a13;
        fMatrix5x5.a14 = -fMatrix5x5.a14;
        fMatrix5x5.a15 = -fMatrix5x5.a15;
        fMatrix5x5.a21 = -fMatrix5x5.a21;
        fMatrix5x5.a22 = -fMatrix5x5.a22;
        fMatrix5x5.a23 = -fMatrix5x5.a23;
        fMatrix5x5.a24 = -fMatrix5x5.a24;
        fMatrix5x5.a25 = -fMatrix5x5.a25;
        fMatrix5x5.a31 = -fMatrix5x5.a31;
        fMatrix5x5.a32 = -fMatrix5x5.a32;
        fMatrix5x5.a33 = -fMatrix5x5.a33;
        fMatrix5x5.a34 = -fMatrix5x5.a34;
        fMatrix5x5.a35 = -fMatrix5x5.a35;
        fMatrix5x5.a41 = -fMatrix5x5.a41;
        fMatrix5x5.a42 = -fMatrix5x5.a42;
        fMatrix5x5.a43 = -fMatrix5x5.a43;
        fMatrix5x5.a44 = -fMatrix5x5.a44;
        fMatrix5x5.a45 = -fMatrix5x5.a45;
        fMatrix5x5.a51 = -fMatrix5x5.a51;
        fMatrix5x5.a52 = -fMatrix5x5.a52;
        fMatrix5x5.a53 = -fMatrix5x5.a53;
        fMatrix5x5.a54 = -fMatrix5x5.a54;
        fMatrix5x5.a55 = -fMatrix5x5.a55;
    }

    public static void changeSign(FMatrix5 fMatrix5) {
        fMatrix5.f2427a1 = -fMatrix5.f2427a1;
        fMatrix5.f2428a2 = -fMatrix5.f2428a2;
        fMatrix5.f2429a3 = -fMatrix5.f2429a3;
        fMatrix5.f2430a4 = -fMatrix5.f2430a4;
        fMatrix5.f2431a5 = -fMatrix5.f2431a5;
    }

    public static void fill(FMatrix5x5 fMatrix5x5, float f) {
        fMatrix5x5.a11 = f;
        fMatrix5x5.a12 = f;
        fMatrix5x5.a13 = f;
        fMatrix5x5.a14 = f;
        fMatrix5x5.a15 = f;
        fMatrix5x5.a21 = f;
        fMatrix5x5.a22 = f;
        fMatrix5x5.a23 = f;
        fMatrix5x5.a24 = f;
        fMatrix5x5.a25 = f;
        fMatrix5x5.a31 = f;
        fMatrix5x5.a32 = f;
        fMatrix5x5.a33 = f;
        fMatrix5x5.a34 = f;
        fMatrix5x5.a35 = f;
        fMatrix5x5.a41 = f;
        fMatrix5x5.a42 = f;
        fMatrix5x5.a43 = f;
        fMatrix5x5.a44 = f;
        fMatrix5x5.a45 = f;
        fMatrix5x5.a51 = f;
        fMatrix5x5.a52 = f;
        fMatrix5x5.a53 = f;
        fMatrix5x5.a54 = f;
        fMatrix5x5.a55 = f;
    }

    public static void fill(FMatrix5 fMatrix5, float f) {
        fMatrix5.f2427a1 = f;
        fMatrix5.f2428a2 = f;
        fMatrix5.f2429a3 = f;
        fMatrix5.f2430a4 = f;
        fMatrix5.f2431a5 = f;
    }

    public static FMatrix5 extractRow(FMatrix5x5 fMatrix5x5, int i, FMatrix5 fMatrix5) {
        if (fMatrix5 == null) {
            fMatrix5 = new FMatrix5();
        }
        if (i == 0) {
            fMatrix5.f2427a1 = fMatrix5x5.a11;
            fMatrix5.f2428a2 = fMatrix5x5.a12;
            fMatrix5.f2429a3 = fMatrix5x5.a13;
            fMatrix5.f2430a4 = fMatrix5x5.a14;
            fMatrix5.f2431a5 = fMatrix5x5.a15;
            return fMatrix5;
        }
        if (i == 1) {
            fMatrix5.f2427a1 = fMatrix5x5.a21;
            fMatrix5.f2428a2 = fMatrix5x5.a22;
            fMatrix5.f2429a3 = fMatrix5x5.a23;
            fMatrix5.f2430a4 = fMatrix5x5.a24;
            fMatrix5.f2431a5 = fMatrix5x5.a25;
            return fMatrix5;
        }
        if (i == 2) {
            fMatrix5.f2427a1 = fMatrix5x5.a31;
            fMatrix5.f2428a2 = fMatrix5x5.a32;
            fMatrix5.f2429a3 = fMatrix5x5.a33;
            fMatrix5.f2430a4 = fMatrix5x5.a34;
            fMatrix5.f2431a5 = fMatrix5x5.a35;
            return fMatrix5;
        }
        if (i == 3) {
            fMatrix5.f2427a1 = fMatrix5x5.a41;
            fMatrix5.f2428a2 = fMatrix5x5.a42;
            fMatrix5.f2429a3 = fMatrix5x5.a43;
            fMatrix5.f2430a4 = fMatrix5x5.a44;
            fMatrix5.f2431a5 = fMatrix5x5.a45;
            return fMatrix5;
        }
        if (i == 4) {
            fMatrix5.f2427a1 = fMatrix5x5.a51;
            fMatrix5.f2428a2 = fMatrix5x5.a52;
            fMatrix5.f2429a3 = fMatrix5x5.a53;
            fMatrix5.f2430a4 = fMatrix5x5.a54;
            fMatrix5.f2431a5 = fMatrix5x5.a55;
            return fMatrix5;
        }
        throw new IllegalArgumentException("Out of bounds row.  row = " + i);
    }

    public static FMatrix5 extractColumn(FMatrix5x5 fMatrix5x5, int i, FMatrix5 fMatrix5) {
        if (fMatrix5 == null) {
            fMatrix5 = new FMatrix5();
        }
        if (i == 0) {
            fMatrix5.f2427a1 = fMatrix5x5.a11;
            fMatrix5.f2428a2 = fMatrix5x5.a21;
            fMatrix5.f2429a3 = fMatrix5x5.a31;
            fMatrix5.f2430a4 = fMatrix5x5.a41;
            fMatrix5.f2431a5 = fMatrix5x5.a51;
            return fMatrix5;
        }
        if (i == 1) {
            fMatrix5.f2427a1 = fMatrix5x5.a12;
            fMatrix5.f2428a2 = fMatrix5x5.a22;
            fMatrix5.f2429a3 = fMatrix5x5.a32;
            fMatrix5.f2430a4 = fMatrix5x5.a42;
            fMatrix5.f2431a5 = fMatrix5x5.a52;
            return fMatrix5;
        }
        if (i == 2) {
            fMatrix5.f2427a1 = fMatrix5x5.a13;
            fMatrix5.f2428a2 = fMatrix5x5.a23;
            fMatrix5.f2429a3 = fMatrix5x5.a33;
            fMatrix5.f2430a4 = fMatrix5x5.a43;
            fMatrix5.f2431a5 = fMatrix5x5.a53;
            return fMatrix5;
        }
        if (i == 3) {
            fMatrix5.f2427a1 = fMatrix5x5.a14;
            fMatrix5.f2428a2 = fMatrix5x5.a24;
            fMatrix5.f2429a3 = fMatrix5x5.a34;
            fMatrix5.f2430a4 = fMatrix5x5.a44;
            fMatrix5.f2431a5 = fMatrix5x5.a54;
            return fMatrix5;
        }
        if (i == 4) {
            fMatrix5.f2427a1 = fMatrix5x5.a15;
            fMatrix5.f2428a2 = fMatrix5x5.a25;
            fMatrix5.f2429a3 = fMatrix5x5.a35;
            fMatrix5.f2430a4 = fMatrix5x5.a45;
            fMatrix5.f2431a5 = fMatrix5x5.a55;
            return fMatrix5;
        }
        throw new IllegalArgumentException("Out of bounds column.  column = " + i);
    }
}
