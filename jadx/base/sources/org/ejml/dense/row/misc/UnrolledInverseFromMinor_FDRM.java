package org.ejml.dense.row.misc;

import org.ejml.data.FMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class UnrolledInverseFromMinor_FDRM {
    public static final int MAX = 5;

    public static void inv(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        float fAbs = Math.abs(fMatrixRMaj.data[0]);
        int numElements = fMatrixRMaj.getNumElements();
        for (int i = 1; i < numElements; i++) {
            float fAbs2 = Math.abs(fMatrixRMaj.data[i]);
            if (fAbs2 > fAbs) {
                fAbs = fAbs2;
            }
        }
        int i2 = fMatrixRMaj.numRows;
        if (i2 == 2) {
            inv2(fMatrixRMaj, fMatrixRMaj2, 1.0f / fAbs);
            return;
        }
        if (i2 == 3) {
            inv3(fMatrixRMaj, fMatrixRMaj2, 1.0f / fAbs);
        } else if (i2 == 4) {
            inv4(fMatrixRMaj, fMatrixRMaj2, 1.0f / fAbs);
        } else {
            if (i2 == 5) {
                inv5(fMatrixRMaj, fMatrixRMaj2, 1.0f / fAbs);
                return;
            }
            throw new IllegalArgumentException("Not supported");
        }
    }

    public static void inv2(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, float f) {
        float[] fArr = fMatrixRMaj.data;
        float f2 = fArr[0] * f;
        float f3 = fArr[1] * f;
        float f4 = fArr[2] * f;
        float f5 = fArr[3] * f;
        float f6 = -f4;
        float f7 = ((f2 * f5) + (f3 * f6)) / f;
        float[] fArr2 = fMatrixRMaj2.data;
        fArr2[0] = f5 / f7;
        fArr2[1] = (-f3) / f7;
        fArr2[2] = f6 / f7;
        fArr2[3] = f2 / f7;
    }

    public static void inv3(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, float f) {
        float[] fArr = fMatrixRMaj.data;
        float f2 = fArr[0] * f;
        float f3 = fArr[1] * f;
        float f4 = fArr[2] * f;
        float f5 = fArr[3] * f;
        float f6 = fArr[4] * f;
        float f7 = fArr[5] * f;
        float f8 = fArr[6] * f;
        float f9 = fArr[7] * f;
        float f10 = fArr[8] * f;
        float f11 = (f6 * f10) - (f7 * f9);
        float f12 = -((f5 * f10) - (f7 * f8));
        float f13 = (f5 * f9) - (f6 * f8);
        float f14 = -((f3 * f10) - (f4 * f9));
        float f15 = (f10 * f2) - (f4 * f8);
        float f16 = -((f9 * f2) - (f8 * f3));
        float f17 = (f3 * f7) - (f4 * f6);
        float f18 = -((f7 * f2) - (f4 * f5));
        float f19 = (f6 * f2) - (f5 * f3);
        float f20 = (((f2 * f11) + (f3 * f12)) + (f4 * f13)) / f;
        float[] fArr2 = fMatrixRMaj2.data;
        fArr2[0] = f11 / f20;
        fArr2[1] = f14 / f20;
        fArr2[2] = f17 / f20;
        fArr2[3] = f12 / f20;
        fArr2[4] = f15 / f20;
        fArr2[5] = f18 / f20;
        fArr2[6] = f13 / f20;
        fArr2[7] = f16 / f20;
        fArr2[8] = f19 / f20;
    }

    public static void inv4(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, float f) {
        float[] fArr = fMatrixRMaj.data;
        float f2 = fArr[0] * f;
        float f3 = fArr[1] * f;
        float f4 = fArr[2] * f;
        float f5 = fArr[3] * f;
        float f6 = fArr[4] * f;
        float f7 = fArr[5] * f;
        float f8 = fArr[6] * f;
        float f9 = fArr[7] * f;
        float f10 = fArr[8] * f;
        float f11 = fArr[9] * f;
        float f12 = fArr[10] * f;
        float f13 = fArr[11] * f;
        float f14 = fArr[12] * f;
        float f15 = fArr[13] * f;
        float f16 = fArr[14] * f;
        float f17 = fArr[15] * f;
        float f18 = (f12 * f17) - (f13 * f16);
        float f19 = (f11 * f17) - (f13 * f15);
        float f20 = (f11 * f16) - (f12 * f15);
        float f21 = ((f7 * f18) - (f8 * f19)) + (f9 * f20);
        float f22 = (f10 * f17) - (f13 * f14);
        float f23 = (f10 * f16) - (f12 * f14);
        float f24 = -(((f6 * f18) - (f8 * f22)) + (f9 * f23));
        float f25 = (f10 * f15) - (f11 * f14);
        float f26 = ((f6 * f19) - (f7 * f22)) + (f9 * f25);
        float f27 = -(((f6 * f20) - (f7 * f23)) + (f8 * f25));
        float f28 = -(((f3 * f18) - (f4 * f19)) + (f5 * f20));
        float f29 = ((f18 * f2) - (f4 * f22)) + (f5 * f23);
        float f30 = -(((f19 * f2) - (f22 * f3)) + (f5 * f25));
        float f31 = ((f20 * f2) - (f23 * f3)) + (f25 * f4);
        float f32 = (f8 * f17) - (f9 * f16);
        float f33 = (f7 * f17) - (f9 * f15);
        float f34 = (f7 * f16) - (f8 * f15);
        float f35 = ((f3 * f32) - (f4 * f33)) + (f5 * f34);
        float f36 = (f17 * f6) - (f9 * f14);
        float f37 = (f16 * f6) - (f8 * f14);
        float f38 = -(((f32 * f2) - (f4 * f36)) + (f5 * f37));
        float f39 = (f15 * f6) - (f14 * f7);
        float f40 = ((f33 * f2) - (f36 * f3)) + (f5 * f39);
        float f41 = -(((f34 * f2) - (f37 * f3)) + (f39 * f4));
        float f42 = (f8 * f13) - (f9 * f12);
        float f43 = (f7 * f13) - (f9 * f11);
        float f44 = (f7 * f12) - (f8 * f11);
        float f45 = -(((f3 * f42) - (f4 * f43)) + (f5 * f44));
        float f46 = (f13 * f6) - (f9 * f10);
        float f47 = (f12 * f6) - (f8 * f10);
        float f48 = ((f42 * f2) - (f4 * f46)) + (f5 * f47);
        float f49 = (f6 * f11) - (f7 * f10);
        float f50 = -(((f43 * f2) - (f46 * f3)) + (f5 * f49));
        float f51 = ((f44 * f2) - (f47 * f3)) + (f49 * f4);
        float f52 = ((((f2 * f21) + (f3 * f24)) + (f4 * f26)) + (f5 * f27)) / f;
        float[] fArr2 = fMatrixRMaj2.data;
        fArr2[0] = f21 / f52;
        fArr2[1] = f28 / f52;
        fArr2[2] = f35 / f52;
        fArr2[3] = f45 / f52;
        fArr2[4] = f24 / f52;
        fArr2[5] = f29 / f52;
        fArr2[6] = f38 / f52;
        fArr2[7] = f48 / f52;
        fArr2[8] = f26 / f52;
        fArr2[9] = f30 / f52;
        fArr2[10] = f40 / f52;
        fArr2[11] = f50 / f52;
        fArr2[12] = f27 / f52;
        fArr2[13] = f31 / f52;
        fArr2[14] = f41 / f52;
        fArr2[15] = f51 / f52;
    }

    public static void inv5(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, float f) {
        float[] fArr = fMatrixRMaj.data;
        float f2 = fArr[0] * f;
        float f3 = fArr[1] * f;
        float f4 = fArr[2] * f;
        float f5 = fArr[3] * f;
        float f6 = fArr[4] * f;
        float f7 = fArr[5] * f;
        float f8 = fArr[6] * f;
        float f9 = fArr[7] * f;
        float f10 = fArr[8] * f;
        float f11 = fArr[9] * f;
        float f12 = fArr[10] * f;
        float f13 = fArr[11] * f;
        float f14 = fArr[12] * f;
        float f15 = fArr[13] * f;
        float f16 = fArr[14] * f;
        float f17 = fArr[15] * f;
        float f18 = fArr[16] * f;
        float f19 = fArr[17] * f;
        float f20 = fArr[18] * f;
        float f21 = fArr[19] * f;
        float f22 = fArr[20] * f;
        float f23 = fArr[21] * f;
        float f24 = fArr[22] * f;
        float f25 = fArr[23] * f;
        float f26 = fArr[24] * f;
        float f27 = (f20 * f26) - (f21 * f25);
        float f28 = (f19 * f26) - (f21 * f24);
        float f29 = (f19 * f25) - (f20 * f24);
        float f30 = ((f14 * f27) - (f15 * f28)) + (f16 * f29);
        float f31 = (f18 * f26) - (f21 * f23);
        float f32 = (f18 * f25) - (f20 * f23);
        float f33 = ((f13 * f27) - (f15 * f31)) + (f16 * f32);
        float f34 = (f18 * f24) - (f19 * f23);
        float f35 = ((f13 * f28) - (f14 * f31)) + (f16 * f34);
        float f36 = ((f13 * f29) - (f14 * f32)) + (f15 * f34);
        float f37 = (((f8 * f30) - (f9 * f33)) + (f10 * f35)) - (f11 * f36);
        float f38 = (f17 * f26) - (f21 * f22);
        float f39 = (f17 * f25) - (f20 * f22);
        float f40 = ((f12 * f27) - (f15 * f38)) + (f16 * f39);
        float f41 = (f17 * f24) - (f19 * f22);
        float f42 = ((f12 * f28) - (f14 * f38)) + (f16 * f41);
        float f43 = ((f12 * f29) - (f14 * f39)) + (f15 * f41);
        float f44 = -((((f7 * f30) - (f9 * f40)) + (f10 * f42)) - (f11 * f43));
        float f45 = (f17 * f23) - (f18 * f22);
        float f46 = ((f12 * f31) - (f13 * f38)) + (f16 * f45);
        float f47 = ((f12 * f32) - (f13 * f39)) + (f15 * f45);
        float f48 = (((f7 * f33) - (f8 * f40)) + (f10 * f46)) - (f11 * f47);
        float f49 = ((f12 * f34) - (f13 * f41)) + (f14 * f45);
        float f50 = -((((f7 * f35) - (f8 * f42)) + (f9 * f46)) - (f11 * f49));
        float f51 = (((f7 * f36) - (f8 * f43)) + (f9 * f47)) - (f10 * f49);
        float f52 = -((((f3 * f30) - (f4 * f33)) + (f5 * f35)) - (f6 * f36));
        float f53 = (((f30 * f2) - (f4 * f40)) + (f5 * f42)) - (f6 * f43);
        float f54 = -((((f33 * f2) - (f40 * f3)) + (f5 * f46)) - (f6 * f47));
        float f55 = (((f35 * f2) - (f42 * f3)) + (f46 * f4)) - (f6 * f49);
        float f56 = -((((f36 * f2) - (f43 * f3)) + (f47 * f4)) - (f49 * f5));
        float f57 = ((f9 * f27) - (f10 * f28)) + (f11 * f29);
        float f58 = ((f8 * f27) - (f10 * f31)) + (f11 * f32);
        float f59 = ((f8 * f28) - (f9 * f31)) + (f11 * f34);
        float f60 = ((f8 * f29) - (f9 * f32)) + (f10 * f34);
        float f61 = (((f3 * f57) - (f4 * f58)) + (f5 * f59)) - (f6 * f60);
        float f62 = ((f27 * f7) - (f10 * f38)) + (f11 * f39);
        float f63 = ((f28 * f7) - (f9 * f38)) + (f11 * f41);
        float f64 = ((f29 * f7) - (f9 * f39)) + (f10 * f41);
        float f65 = -((((f57 * f2) - (f4 * f62)) + (f5 * f63)) - (f6 * f64));
        float f66 = ((f31 * f7) - (f38 * f8)) + (f11 * f45);
        float f67 = ((f32 * f7) - (f39 * f8)) + (f10 * f45);
        float f68 = (((f58 * f2) - (f62 * f3)) + (f5 * f66)) - (f6 * f67);
        float f69 = ((f34 * f7) - (f41 * f8)) + (f45 * f9);
        float f70 = -((((f59 * f2) - (f63 * f3)) + (f66 * f4)) - (f6 * f69));
        float f71 = (((f60 * f2) - (f64 * f3)) + (f67 * f4)) - (f69 * f5);
        float f72 = (f15 * f26) - (f16 * f25);
        float f73 = (f14 * f26) - (f16 * f24);
        float f74 = (f14 * f25) - (f15 * f24);
        float f75 = ((f9 * f72) - (f10 * f73)) + (f11 * f74);
        float f76 = (f13 * f26) - (f16 * f23);
        float f77 = (f13 * f25) - (f15 * f23);
        float f78 = ((f8 * f72) - (f10 * f76)) + (f11 * f77);
        float f79 = (f13 * f24) - (f14 * f23);
        float f80 = ((f8 * f73) - (f9 * f76)) + (f11 * f79);
        float f81 = ((f8 * f74) - (f9 * f77)) + (f10 * f79);
        float f82 = -((((f3 * f75) - (f4 * f78)) + (f5 * f80)) - (f6 * f81));
        float f83 = (f26 * f12) - (f16 * f22);
        float f84 = (f25 * f12) - (f15 * f22);
        float f85 = ((f72 * f7) - (f10 * f83)) + (f11 * f84);
        float f86 = (f24 * f12) - (f14 * f22);
        float f87 = ((f73 * f7) - (f9 * f83)) + (f11 * f86);
        float f88 = ((f74 * f7) - (f9 * f84)) + (f10 * f86);
        float f89 = (((f75 * f2) - (f4 * f85)) + (f5 * f87)) - (f6 * f88);
        float f90 = (f23 * f12) - (f22 * f13);
        float f91 = ((f76 * f7) - (f83 * f8)) + (f11 * f90);
        float f92 = ((f77 * f7) - (f84 * f8)) + (f10 * f90);
        float f93 = -((((f78 * f2) - (f85 * f3)) + (f5 * f91)) - (f6 * f92));
        float f94 = ((f79 * f7) - (f86 * f8)) + (f90 * f9);
        float f95 = (((f80 * f2) - (f87 * f3)) + (f91 * f4)) - (f6 * f94);
        float f96 = -((((f81 * f2) - (f88 * f3)) + (f92 * f4)) - (f94 * f5));
        float f97 = (f15 * f21) - (f16 * f20);
        float f98 = (f14 * f21) - (f16 * f19);
        float f99 = (f14 * f20) - (f15 * f19);
        float f100 = ((f9 * f97) - (f10 * f98)) + (f11 * f99);
        float f101 = (f13 * f21) - (f16 * f18);
        float f102 = (f13 * f20) - (f15 * f18);
        float f103 = ((f8 * f97) - (f10 * f101)) + (f11 * f102);
        float f104 = (f13 * f19) - (f14 * f18);
        float f105 = ((f8 * f98) - (f9 * f101)) + (f11 * f104);
        float f106 = ((f8 * f99) - (f9 * f102)) + (f10 * f104);
        float f107 = (((f3 * f100) - (f4 * f103)) + (f5 * f105)) - (f6 * f106);
        float f108 = (f21 * f12) - (f16 * f17);
        float f109 = (f20 * f12) - (f15 * f17);
        float f110 = ((f97 * f7) - (f10 * f108)) + (f11 * f109);
        float f111 = (f19 * f12) - (f14 * f17);
        float f112 = ((f98 * f7) - (f9 * f108)) + (f11 * f111);
        float f113 = ((f99 * f7) - (f9 * f109)) + (f10 * f111);
        float f114 = -((((f100 * f2) - (f4 * f110)) + (f5 * f112)) - (f6 * f113));
        float f115 = (f12 * f18) - (f13 * f17);
        float f116 = ((f101 * f7) - (f108 * f8)) + (f11 * f115);
        float f117 = ((f102 * f7) - (f109 * f8)) + (f10 * f115);
        float f118 = (((f103 * f2) - (f110 * f3)) + (f5 * f116)) - (f6 * f117);
        float f119 = ((f7 * f104) - (f8 * f111)) + (f9 * f115);
        float f120 = -((((f105 * f2) - (f112 * f3)) + (f116 * f4)) - (f6 * f119));
        float f121 = (((f106 * f2) - (f113 * f3)) + (f117 * f4)) - (f119 * f5);
        float f122 = (((((f2 * f37) + (f3 * f44)) + (f4 * f48)) + (f5 * f50)) + (f6 * f51)) / f;
        float[] fArr2 = fMatrixRMaj2.data;
        fArr2[0] = f37 / f122;
        fArr2[1] = f52 / f122;
        fArr2[2] = f61 / f122;
        fArr2[3] = f82 / f122;
        fArr2[4] = f107 / f122;
        fArr2[5] = f44 / f122;
        fArr2[6] = f53 / f122;
        fArr2[7] = f65 / f122;
        fArr2[8] = f89 / f122;
        fArr2[9] = f114 / f122;
        fArr2[10] = f48 / f122;
        fArr2[11] = f54 / f122;
        fArr2[12] = f68 / f122;
        fArr2[13] = f93 / f122;
        fArr2[14] = f118 / f122;
        fArr2[15] = f50 / f122;
        fArr2[16] = f55 / f122;
        fArr2[17] = f70 / f122;
        fArr2[18] = f95 / f122;
        fArr2[19] = f120 / f122;
        fArr2[20] = f51 / f122;
        fArr2[21] = f56 / f122;
        fArr2[22] = f71 / f122;
        fArr2[23] = f96 / f122;
        fArr2[24] = f121 / f122;
    }
}
