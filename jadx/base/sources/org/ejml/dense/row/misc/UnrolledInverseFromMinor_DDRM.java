package org.ejml.dense.row.misc;

import org.ejml.data.DMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class UnrolledInverseFromMinor_DDRM {
    public static final int MAX = 5;

    public static void inv(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        double dAbs = Math.abs(dMatrixRMaj.data[0]);
        int numElements = dMatrixRMaj.getNumElements();
        for (int i = 1; i < numElements; i++) {
            double dAbs2 = Math.abs(dMatrixRMaj.data[i]);
            if (dAbs2 > dAbs) {
                dAbs = dAbs2;
            }
        }
        int i2 = dMatrixRMaj.numRows;
        if (i2 == 2) {
            inv2(dMatrixRMaj, dMatrixRMaj2, 1.0d / dAbs);
            return;
        }
        if (i2 == 3) {
            inv3(dMatrixRMaj, dMatrixRMaj2, 1.0d / dAbs);
        } else if (i2 == 4) {
            inv4(dMatrixRMaj, dMatrixRMaj2, 1.0d / dAbs);
        } else {
            if (i2 == 5) {
                inv5(dMatrixRMaj, dMatrixRMaj2, 1.0d / dAbs);
                return;
            }
            throw new IllegalArgumentException("Not supported");
        }
    }

    public static void inv2(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, double d) {
        double[] dArr = dMatrixRMaj.data;
        double d2 = dArr[0] * d;
        double d3 = dArr[1] * d;
        double d4 = dArr[2] * d;
        double d5 = dArr[3] * d;
        double d6 = -d4;
        double d7 = ((d2 * d5) + (d3 * d6)) / d;
        double[] dArr2 = dMatrixRMaj2.data;
        dArr2[0] = d5 / d7;
        dArr2[1] = (-d3) / d7;
        dArr2[2] = d6 / d7;
        dArr2[3] = d2 / d7;
    }

    public static void inv3(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, double d) {
        double[] dArr = dMatrixRMaj.data;
        double d2 = dArr[0] * d;
        double d3 = dArr[1] * d;
        double d4 = dArr[2] * d;
        double d5 = dArr[3] * d;
        double d6 = dArr[4] * d;
        double d7 = dArr[5] * d;
        double d8 = dArr[6] * d;
        double d9 = dArr[7] * d;
        double d10 = dArr[8] * d;
        double d11 = (d6 * d10) - (d7 * d9);
        double d12 = -((d5 * d10) - (d7 * d8));
        double d13 = (d5 * d9) - (d6 * d8);
        double d14 = -((d3 * d10) - (d4 * d9));
        double d15 = (d10 * d2) - (d4 * d8);
        double d16 = -((d9 * d2) - (d8 * d3));
        double d17 = (d3 * d7) - (d4 * d6);
        double d18 = -((d7 * d2) - (d4 * d5));
        double d19 = (d6 * d2) - (d5 * d3);
        double d20 = (((d2 * d11) + (d3 * d12)) + (d4 * d13)) / d;
        double[] dArr2 = dMatrixRMaj2.data;
        dArr2[0] = d11 / d20;
        dArr2[1] = d14 / d20;
        dArr2[2] = d17 / d20;
        dArr2[3] = d12 / d20;
        dArr2[4] = d15 / d20;
        dArr2[5] = d18 / d20;
        dArr2[6] = d13 / d20;
        dArr2[7] = d16 / d20;
        dArr2[8] = d19 / d20;
    }

    public static void inv4(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, double d) {
        double[] dArr = dMatrixRMaj.data;
        double d2 = dArr[0] * d;
        double d3 = dArr[1] * d;
        double d4 = dArr[2] * d;
        double d5 = dArr[3] * d;
        double d6 = dArr[4] * d;
        double d7 = dArr[5] * d;
        double d8 = dArr[6] * d;
        double d9 = dArr[7] * d;
        double d10 = dArr[8] * d;
        double d11 = dArr[9] * d;
        double d12 = dArr[10] * d;
        double d13 = dArr[11] * d;
        double d14 = dArr[12] * d;
        double d15 = dArr[13] * d;
        double d16 = dArr[14] * d;
        double d17 = dArr[15] * d;
        double d18 = (d12 * d17) - (d13 * d16);
        double d19 = (d11 * d17) - (d13 * d15);
        double d20 = (d11 * d16) - (d12 * d15);
        double d21 = ((d7 * d18) - (d8 * d19)) + (d9 * d20);
        double d22 = (d10 * d17) - (d13 * d14);
        double d23 = (d10 * d16) - (d12 * d14);
        double d24 = -(((d6 * d18) - (d8 * d22)) + (d9 * d23));
        double d25 = (d10 * d15) - (d11 * d14);
        double d26 = ((d6 * d19) - (d7 * d22)) + (d9 * d25);
        double d27 = -(((d6 * d20) - (d7 * d23)) + (d8 * d25));
        double d28 = -(((d3 * d18) - (d4 * d19)) + (d5 * d20));
        double d29 = ((d18 * d2) - (d4 * d22)) + (d5 * d23);
        double d30 = -(((d19 * d2) - (d22 * d3)) + (d5 * d25));
        double d31 = ((d2 * d20) - (d3 * d23)) + (d4 * d25);
        double d32 = (d8 * d17) - (d9 * d16);
        double d33 = (d7 * d17) - (d9 * d15);
        double d34 = (d7 * d16) - (d8 * d15);
        double d35 = ((d3 * d32) - (d4 * d33)) + (d5 * d34);
        double d36 = (d17 * d6) - (d9 * d14);
        double d37 = (d16 * d6) - (d8 * d14);
        double d38 = -(((d32 * d2) - (d4 * d36)) + (d5 * d37));
        double d39 = (d15 * d6) - (d14 * d7);
        double d40 = ((d2 * d33) - (d36 * d3)) + (d5 * d39);
        double d41 = -(((d2 * d34) - (d37 * d3)) + (d39 * d4));
        double d42 = (d8 * d13) - (d9 * d12);
        double d43 = (d7 * d13) - (d9 * d11);
        double d44 = (d3 * d42) - (d4 * d43);
        double d45 = (d7 * d12) - (d8 * d11);
        double d46 = (d13 * d6) - (d9 * d10);
        double d47 = (d6 * d12) - (d8 * d10);
        double d48 = (d11 * d6) - (d7 * d10);
        double d49 = ((((d2 * d21) + (d3 * d24)) + (d4 * d26)) + (d5 * d27)) / d;
        double[] dArr2 = dMatrixRMaj2.data;
        dArr2[0] = d21 / d49;
        dArr2[1] = d28 / d49;
        dArr2[2] = d35 / d49;
        dArr2[3] = (-(d44 + (d5 * d45))) / d49;
        dArr2[4] = d24 / d49;
        dArr2[5] = d29 / d49;
        dArr2[6] = d38 / d49;
        dArr2[7] = (((d42 * d2) - (d4 * d46)) + (d5 * d47)) / d49;
        dArr2[8] = d26 / d49;
        dArr2[9] = d30 / d49;
        dArr2[10] = d40 / d49;
        dArr2[11] = (-(((d2 * d43) - (d3 * d46)) + (d5 * d48))) / d49;
        dArr2[12] = d27 / d49;
        dArr2[13] = d31 / d49;
        dArr2[14] = d41 / d49;
        dArr2[15] = (((d2 * d45) - (d3 * d47)) + (d4 * d48)) / d49;
    }

    public static void inv5(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, double d) {
        double[] dArr = dMatrixRMaj.data;
        double d2 = dArr[0] * d;
        double d3 = dArr[1] * d;
        double d4 = dArr[2] * d;
        double d5 = dArr[3] * d;
        double d6 = dArr[4] * d;
        double d7 = dArr[5] * d;
        double d8 = dArr[6] * d;
        double d9 = dArr[7] * d;
        double d10 = dArr[8] * d;
        double d11 = dArr[9] * d;
        double d12 = dArr[10] * d;
        double d13 = dArr[11] * d;
        double d14 = dArr[12] * d;
        double d15 = dArr[13] * d;
        double d16 = dArr[14] * d;
        double d17 = dArr[15] * d;
        double d18 = dArr[16] * d;
        double d19 = dArr[17] * d;
        double d20 = dArr[18] * d;
        double d21 = dArr[19] * d;
        double d22 = dArr[20] * d;
        double d23 = dArr[21] * d;
        double d24 = dArr[22] * d;
        double d25 = dArr[23] * d;
        double d26 = dArr[24] * d;
        double d27 = (d20 * d26) - (d21 * d25);
        double d28 = (d19 * d26) - (d21 * d24);
        double d29 = (d19 * d25) - (d20 * d24);
        double d30 = ((d14 * d27) - (d15 * d28)) + (d16 * d29);
        double d31 = (d18 * d26) - (d21 * d23);
        double d32 = (d18 * d25) - (d20 * d23);
        double d33 = ((d13 * d27) - (d15 * d31)) + (d16 * d32);
        double d34 = (d18 * d24) - (d19 * d23);
        double d35 = ((d13 * d28) - (d14 * d31)) + (d16 * d34);
        double d36 = ((d13 * d29) - (d14 * d32)) + (d15 * d34);
        double d37 = (((d8 * d30) - (d9 * d33)) + (d10 * d35)) - (d11 * d36);
        double d38 = (d17 * d26) - (d21 * d22);
        double d39 = (d17 * d25) - (d20 * d22);
        double d40 = ((d12 * d27) - (d15 * d38)) + (d16 * d39);
        double d41 = (d17 * d24) - (d19 * d22);
        double d42 = ((d12 * d28) - (d14 * d38)) + (d16 * d41);
        double d43 = ((d12 * d29) - (d14 * d39)) + (d15 * d41);
        double d44 = -((((d7 * d30) - (d9 * d40)) + (d10 * d42)) - (d11 * d43));
        double d45 = (d17 * d23) - (d18 * d22);
        double d46 = ((d12 * d31) - (d13 * d38)) + (d16 * d45);
        double d47 = ((d12 * d32) - (d13 * d39)) + (d15 * d45);
        double d48 = (((d7 * d33) - (d8 * d40)) + (d10 * d46)) - (d11 * d47);
        double d49 = ((d12 * d34) - (d13 * d41)) + (d14 * d45);
        double d50 = -((((d7 * d35) - (d8 * d42)) + (d9 * d46)) - (d11 * d49));
        double d51 = (((d7 * d36) - (d8 * d43)) + (d9 * d47)) - (d10 * d49);
        double d52 = -((((d3 * d30) - (d4 * d33)) + (d5 * d35)) - (d6 * d36));
        double d53 = (((d30 * d2) - (d4 * d40)) + (d5 * d42)) - (d6 * d43);
        double d54 = -((((d33 * d2) - (d40 * d3)) + (d5 * d46)) - (d6 * d47));
        double d55 = (((d2 * d35) - (d3 * d42)) + (d4 * d46)) - (d6 * d49);
        double d56 = -((((d2 * d36) - (d3 * d43)) + (d4 * d47)) - (d49 * d5));
        double d57 = ((d9 * d27) - (d10 * d28)) + (d11 * d29);
        double d58 = ((d8 * d27) - (d10 * d31)) + (d11 * d32);
        double d59 = ((d8 * d28) - (d9 * d31)) + (d11 * d34);
        double d60 = ((d8 * d29) - (d9 * d32)) + (d10 * d34);
        double d61 = (((d3 * d57) - (d4 * d58)) + (d5 * d59)) - (d6 * d60);
        double d62 = ((d27 * d7) - (d10 * d38)) + (d11 * d39);
        double d63 = ((d28 * d7) - (d9 * d38)) + (d11 * d41);
        double d64 = ((d29 * d7) - (d9 * d39)) + (d10 * d41);
        double d65 = -((((d57 * d2) - (d4 * d62)) + (d5 * d63)) - (d6 * d64));
        double d66 = ((d31 * d7) - (d38 * d8)) + (d11 * d45);
        double d67 = ((d32 * d7) - (d39 * d8)) + (d10 * d45);
        double d68 = (((d2 * d58) - (d62 * d3)) + (d5 * d66)) - (d6 * d67);
        double d69 = ((d34 * d7) - (d41 * d8)) + (d45 * d9);
        double d70 = -((((d2 * d59) - (d63 * d3)) + (d4 * d66)) - (d6 * d69));
        double d71 = (((d2 * d60) - (d3 * d64)) + (d4 * d67)) - (d69 * d5);
        double d72 = (d15 * d26) - (d16 * d25);
        double d73 = (d14 * d26) - (d16 * d24);
        double d74 = (d14 * d25) - (d15 * d24);
        double d75 = ((d9 * d72) - (d10 * d73)) + (d11 * d74);
        double d76 = (d13 * d26) - (d16 * d23);
        double d77 = (d13 * d25) - (d15 * d23);
        double d78 = ((d8 * d72) - (d10 * d76)) + (d11 * d77);
        double d79 = (d13 * d24) - (d14 * d23);
        double d80 = ((d8 * d73) - (d9 * d76)) + (d11 * d79);
        double d81 = ((d8 * d74) - (d9 * d77)) + (d10 * d79);
        double d82 = -((((d3 * d75) - (d4 * d78)) + (d5 * d80)) - (d6 * d81));
        double d83 = (d26 * d12) - (d16 * d22);
        double d84 = (d25 * d12) - (d15 * d22);
        double d85 = ((d72 * d7) - (d10 * d83)) + (d11 * d84);
        double d86 = (d24 * d12) - (d14 * d22);
        double d87 = ((d73 * d7) - (d9 * d83)) + (d11 * d86);
        double d88 = ((d74 * d7) - (d9 * d84)) + (d10 * d86);
        double d89 = (((d75 * d2) - (d4 * d85)) + (d5 * d87)) - (d6 * d88);
        double d90 = (d23 * d12) - (d22 * d13);
        double d91 = ((d76 * d7) - (d83 * d8)) + (d11 * d90);
        double d92 = ((d77 * d7) - (d84 * d8)) + (d10 * d90);
        double d93 = -((((d2 * d78) - (d85 * d3)) + (d5 * d91)) - (d6 * d92));
        double d94 = ((d79 * d7) - (d86 * d8)) + (d90 * d9);
        double d95 = (((d2 * d80) - (d3 * d87)) + (d4 * d91)) - (d6 * d94);
        double d96 = -((((d2 * d81) - (d3 * d88)) + (d4 * d92)) - (d5 * d94));
        double d97 = (d15 * d21) - (d16 * d20);
        double d98 = (d14 * d21) - (d16 * d19);
        double d99 = (d14 * d20) - (d15 * d19);
        double d100 = ((d9 * d97) - (d10 * d98)) + (d11 * d99);
        double d101 = (d13 * d21) - (d16 * d18);
        double d102 = (d13 * d20) - (d15 * d18);
        double d103 = ((d8 * d97) - (d10 * d101)) + (d11 * d102);
        double d104 = (d13 * d19) - (d14 * d18);
        double d105 = ((d8 * d98) - (d9 * d101)) + (d11 * d104);
        double d106 = ((d3 * d100) - (d4 * d103)) + (d5 * d105);
        double d107 = ((d8 * d99) - (d9 * d102)) + (d10 * d104);
        double d108 = (d21 * d12) - (d16 * d17);
        double d109 = (d20 * d12) - (d15 * d17);
        double d110 = ((d97 * d7) - (d10 * d108)) + (d11 * d109);
        double d111 = (d19 * d12) - (d14 * d17);
        double d112 = ((d98 * d7) - (d9 * d108)) + (d11 * d111);
        double d113 = ((d99 * d7) - (d9 * d109)) + (d10 * d111);
        double d114 = (d12 * d18) - (d13 * d17);
        double d115 = ((d101 * d7) - (d108 * d8)) + (d11 * d114);
        double d116 = ((d102 * d7) - (d109 * d8)) + (d10 * d114);
        double d117 = ((d7 * d104) - (d8 * d111)) + (d9 * d114);
        double d118 = -((((d2 * d105) - (d3 * d112)) + (d4 * d115)) - (d6 * d117));
        double d119 = (((d2 * d107) - (d3 * d113)) + (d4 * d116)) - (d117 * d5);
        double d120 = (((((d2 * d37) + (d3 * d44)) + (d4 * d48)) + (d5 * d50)) + (d6 * d51)) / d;
        double[] dArr2 = dMatrixRMaj2.data;
        dArr2[0] = d37 / d120;
        dArr2[1] = d52 / d120;
        dArr2[2] = d61 / d120;
        dArr2[3] = d82 / d120;
        dArr2[4] = (d106 - (d6 * d107)) / d120;
        dArr2[5] = d44 / d120;
        dArr2[6] = d53 / d120;
        dArr2[7] = d65 / d120;
        dArr2[8] = d89 / d120;
        dArr2[9] = (-((((d100 * d2) - (d4 * d110)) + (d5 * d112)) - (d6 * d113))) / d120;
        dArr2[10] = d48 / d120;
        dArr2[11] = d54 / d120;
        dArr2[12] = d68 / d120;
        dArr2[13] = d93 / d120;
        dArr2[14] = ((((d2 * d103) - (d3 * d110)) + (d5 * d115)) - (d6 * d116)) / d120;
        dArr2[15] = d50 / d120;
        dArr2[16] = d55 / d120;
        dArr2[17] = d70 / d120;
        dArr2[18] = d95 / d120;
        dArr2[19] = d118 / d120;
        dArr2[20] = d51 / d120;
        dArr2[21] = d56 / d120;
        dArr2[22] = d71 / d120;
        dArr2[23] = d96 / d120;
        dArr2[24] = d119 / d120;
    }
}
