package org.ejml.dense.row.mult;

import org.ejml.data.CMatrixRMaj;
import org.ejml.data.Complex_F32;

/* JADX INFO: loaded from: classes9.dex */
public class VectorVectorMult_CDRM {
    public static Complex_F32 innerProd(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, Complex_F32 complex_F32) {
        if (complex_F32 == null) {
            complex_F32 = new Complex_F32();
        } else {
            complex_F32.imaginary = 0.0f;
            complex_F32.real = 0.0f;
        }
        int dataLength = cMatrixRMaj.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            float f = cMatrixRMaj.data[i];
            int i2 = i + 1;
            float f2 = cMatrixRMaj.data[i2];
            float f3 = cMatrixRMaj2.data[i];
            float f4 = cMatrixRMaj2.data[i2];
            complex_F32.real += (f * f3) - (f2 * f4);
            complex_F32.imaginary += (f * f4) + (f2 * f3);
        }
        return complex_F32;
    }

    public static Complex_F32 innerProdH(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, Complex_F32 complex_F32) {
        if (complex_F32 == null) {
            complex_F32 = new Complex_F32();
        } else {
            complex_F32.imaginary = 0.0f;
            complex_F32.real = 0.0f;
        }
        int dataLength = cMatrixRMaj.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            float f = cMatrixRMaj.data[i];
            int i2 = i + 1;
            float f2 = cMatrixRMaj.data[i2];
            float f3 = cMatrixRMaj2.data[i];
            float f4 = -cMatrixRMaj2.data[i2];
            complex_F32.real += (f * f3) - (f2 * f4);
            complex_F32.imaginary += (f * f4) + (f2 * f3);
        }
        return complex_F32;
    }

    public static void outerProd(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        int i = cMatrixRMaj3.numRows;
        int i2 = cMatrixRMaj3.numCols;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i4 * 2;
            float f = cMatrixRMaj.data[i5];
            float f2 = cMatrixRMaj.data[i5 + 1];
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                int i8 = i6 + 1;
                float f3 = cMatrixRMaj2.data[i6];
                i6 += 2;
                float f4 = cMatrixRMaj2.data[i8];
                int i9 = i3 + 1;
                cMatrixRMaj3.data[i3] = (f * f3) - (f2 * f4);
                i3 += 2;
                cMatrixRMaj3.data[i9] = (f4 * f) + (f3 * f2);
            }
        }
    }

    public static void outerProdH(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        int i = cMatrixRMaj3.numRows;
        int i2 = cMatrixRMaj3.numCols;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i4 * 2;
            float f = cMatrixRMaj.data[i5];
            float f2 = cMatrixRMaj.data[i5 + 1];
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                int i8 = i6 + 1;
                float f3 = cMatrixRMaj2.data[i6];
                i6 += 2;
                float f4 = -cMatrixRMaj2.data[i8];
                int i9 = i3 + 1;
                cMatrixRMaj3.data[i3] = (f * f3) - (f2 * f4);
                i3 += 2;
                cMatrixRMaj3.data[i9] = (f4 * f) + (f3 * f2);
            }
        }
    }
}
