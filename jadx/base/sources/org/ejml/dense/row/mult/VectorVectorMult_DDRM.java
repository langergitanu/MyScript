package org.ejml.dense.row.mult;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrix1Row;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class VectorVectorMult_DDRM {
    public static double innerProd(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        int numElements = dMatrixD1.getNumElements();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < numElements; i++) {
            d += dMatrixD1.get(i) * dMatrixD12.get(i);
        }
        return d;
    }

    public static double innerProdA(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12, DMatrixD1 dMatrixD13) {
        int i = dMatrixD12.numRows;
        int i2 = dMatrixD12.numCols;
        if (dMatrixD1.getNumElements() != i) {
            throw new IllegalArgumentException("Unexpected number of elements in x");
        }
        if (dMatrixD13.getNumElements() != i2) {
            throw new IllegalArgumentException("Unexpected number of elements in y");
        }
        double d = 0.0d;
        for (int i3 = 0; i3 < i2; i3++) {
            double dUnsafe_get = 0.0d;
            for (int i4 = 0; i4 < i; i4++) {
                dUnsafe_get += dMatrixD1.get(i4) * dMatrixD12.unsafe_get(i4, i3);
            }
            d += dUnsafe_get * dMatrixD13.get(i3);
        }
        return d;
    }

    public static double innerProdTranA(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12, DMatrixD1 dMatrixD13) {
        int i = dMatrixD12.numRows;
        if (i != dMatrixD12.numCols) {
            throw new IllegalArgumentException("A must be square");
        }
        if (dMatrixD1.getNumElements() != i) {
            throw new IllegalArgumentException("Unexpected number of elements in x");
        }
        if (dMatrixD13.getNumElements() != i) {
            throw new IllegalArgumentException("Unexpected number of elements in y");
        }
        double d = 0.0d;
        for (int i2 = 0; i2 < i; i2++) {
            double dUnsafe_get = 0.0d;
            for (int i3 = 0; i3 < i; i3++) {
                dUnsafe_get += dMatrixD1.get(i3) * dMatrixD12.unsafe_get(i2, i3);
            }
            d += dUnsafe_get * dMatrixD13.get(i2);
        }
        return d;
    }

    public static void outerProd(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12, DMatrix1Row dMatrix1Row) {
        int i = dMatrix1Row.numRows;
        int i2 = dMatrix1Row.numCols;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            double d = dMatrixD1.get(i4);
            int i5 = 0;
            while (i5 < i2) {
                dMatrix1Row.set(i3, dMatrixD12.get(i5) * d);
                i5++;
                i3++;
            }
        }
    }

    public static void addOuterProd(double d, DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12, DMatrix1Row dMatrix1Row) {
        int i = dMatrix1Row.numRows;
        int i2 = dMatrix1Row.numCols;
        if (d == 1.0d) {
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                double d2 = dMatrixD1.get(i4);
                int i5 = 0;
                while (i5 < i2) {
                    dMatrix1Row.plus(i3, dMatrixD12.get(i5) * d2);
                    i5++;
                    i3++;
                }
            }
            return;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < i; i7++) {
            double d3 = dMatrixD1.get(i7);
            int i8 = 0;
            while (i8 < i2) {
                dMatrix1Row.plus(i6, d * d3 * dMatrixD12.get(i8));
                i8++;
                i6++;
            }
        }
    }

    public static void householder(double d, DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12, DMatrixD1 dMatrixD13) {
        int numElements = dMatrixD1.getNumElements();
        double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < numElements; i++) {
            d2 += dMatrixD1.get(i) * dMatrixD12.get(i);
        }
        for (int i2 = 0; i2 < numElements; i2++) {
            dMatrixD13.set(i2, dMatrixD12.get(i2) + (dMatrixD1.get(i2) * d * d2));
        }
    }

    public static void rank1Update(double d, DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3, DMatrixRMaj dMatrixRMaj4) {
        int numElements = dMatrixRMaj2.getNumElements();
        int i = 0;
        for (int i2 = 0; i2 < numElements; i2++) {
            double d2 = dMatrixRMaj2.data[i2];
            int i3 = 0;
            while (i3 < numElements) {
                dMatrixRMaj4.data[i] = dMatrixRMaj.data[i] + (d * d2 * dMatrixRMaj3.data[i3]);
                i3++;
                i++;
            }
        }
    }

    public static void rank1Update(double d, DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3) {
        int numElements = dMatrixRMaj2.getNumElements();
        int i = 0;
        for (int i2 = 0; i2 < numElements; i2++) {
            double d2 = dMatrixRMaj2.data[i2];
            int i3 = 0;
            while (i3 < numElements) {
                double[] dArr = dMatrixRMaj.data;
                dArr[i] = dArr[i] + (d * d2 * dMatrixRMaj3.data[i3]);
                i3++;
                i++;
            }
        }
    }
}
