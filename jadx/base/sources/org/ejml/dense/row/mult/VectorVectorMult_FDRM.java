package org.ejml.dense.row.mult;

import org.ejml.data.FMatrix1Row;
import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class VectorVectorMult_FDRM {
    public static float innerProd(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        int numElements = fMatrixD1.getNumElements();
        float f = 0.0f;
        for (int i = 0; i < numElements; i++) {
            f += fMatrixD1.get(i) * fMatrixD12.get(i);
        }
        return f;
    }

    public static float innerProdA(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12, FMatrixD1 fMatrixD13) {
        int i = fMatrixD12.numRows;
        int i2 = fMatrixD12.numCols;
        if (fMatrixD1.getNumElements() != i) {
            throw new IllegalArgumentException("Unexpected number of elements in x");
        }
        if (fMatrixD13.getNumElements() != i2) {
            throw new IllegalArgumentException("Unexpected number of elements in y");
        }
        float f = 0.0f;
        for (int i3 = 0; i3 < i2; i3++) {
            float fUnsafe_get = 0.0f;
            for (int i4 = 0; i4 < i; i4++) {
                fUnsafe_get += fMatrixD1.get(i4) * fMatrixD12.unsafe_get(i4, i3);
            }
            f += fUnsafe_get * fMatrixD13.get(i3);
        }
        return f;
    }

    public static float innerProdTranA(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12, FMatrixD1 fMatrixD13) {
        int i = fMatrixD12.numRows;
        if (i != fMatrixD12.numCols) {
            throw new IllegalArgumentException("A must be square");
        }
        if (fMatrixD1.getNumElements() != i) {
            throw new IllegalArgumentException("Unexpected number of elements in x");
        }
        if (fMatrixD13.getNumElements() != i) {
            throw new IllegalArgumentException("Unexpected number of elements in y");
        }
        float f = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            float fUnsafe_get = 0.0f;
            for (int i3 = 0; i3 < i; i3++) {
                fUnsafe_get += fMatrixD1.get(i3) * fMatrixD12.unsafe_get(i2, i3);
            }
            f += fUnsafe_get * fMatrixD13.get(i2);
        }
        return f;
    }

    public static void outerProd(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12, FMatrix1Row fMatrix1Row) {
        int i = fMatrix1Row.numRows;
        int i2 = fMatrix1Row.numCols;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            float f = fMatrixD1.get(i4);
            int i5 = 0;
            while (i5 < i2) {
                fMatrix1Row.set(i3, fMatrixD12.get(i5) * f);
                i5++;
                i3++;
            }
        }
    }

    public static void addOuterProd(float f, FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12, FMatrix1Row fMatrix1Row) {
        int i = fMatrix1Row.numRows;
        int i2 = fMatrix1Row.numCols;
        if (f == 1.0f) {
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                float f2 = fMatrixD1.get(i4);
                int i5 = 0;
                while (i5 < i2) {
                    fMatrix1Row.plus(i3, fMatrixD12.get(i5) * f2);
                    i5++;
                    i3++;
                }
            }
            return;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < i; i7++) {
            float f3 = fMatrixD1.get(i7);
            int i8 = 0;
            while (i8 < i2) {
                fMatrix1Row.plus(i6, f * f3 * fMatrixD12.get(i8));
                i8++;
                i6++;
            }
        }
    }

    public static void householder(float f, FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12, FMatrixD1 fMatrixD13) {
        int numElements = fMatrixD1.getNumElements();
        float f2 = 0.0f;
        for (int i = 0; i < numElements; i++) {
            f2 += fMatrixD1.get(i) * fMatrixD12.get(i);
        }
        for (int i2 = 0; i2 < numElements; i2++) {
            fMatrixD13.set(i2, fMatrixD12.get(i2) + (fMatrixD1.get(i2) * f * f2));
        }
    }

    public static void rank1Update(float f, FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3, FMatrixRMaj fMatrixRMaj4) {
        int numElements = fMatrixRMaj2.getNumElements();
        int i = 0;
        for (int i2 = 0; i2 < numElements; i2++) {
            float f2 = fMatrixRMaj2.data[i2];
            int i3 = 0;
            while (i3 < numElements) {
                fMatrixRMaj4.data[i] = fMatrixRMaj.data[i] + (f * f2 * fMatrixRMaj3.data[i3]);
                i3++;
                i++;
            }
        }
    }

    public static void rank1Update(float f, FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3) {
        int numElements = fMatrixRMaj2.getNumElements();
        int i = 0;
        for (int i2 = 0; i2 < numElements; i2++) {
            float f2 = fMatrixRMaj2.data[i2];
            int i3 = 0;
            while (i3 < numElements) {
                float[] fArr = fMatrixRMaj.data;
                fArr[i] = fArr[i] + (f * f2 * fMatrixRMaj3.data[i3]);
                i3++;
                i++;
            }
        }
    }
}
