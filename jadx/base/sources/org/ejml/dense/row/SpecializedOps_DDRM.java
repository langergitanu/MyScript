package org.ejml.dense.row;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrix1Row;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class SpecializedOps_DDRM {
    public static DMatrixRMaj createReflector(DMatrix1Row dMatrix1Row) {
        if (!MatrixFeatures_DDRM.isVector(dMatrix1Row)) {
            throw new IllegalArgumentException("u must be a vector");
        }
        double dFastNormF = NormOps_DDRM.fastNormF(dMatrix1Row);
        double d = (-2.0d) / (dFastNormF * dFastNormF);
        DMatrixRMaj dMatrixRMajIdentity = CommonOps_DDRM.identity(dMatrix1Row.getNumElements());
        CommonOps_DDRM.multAddTransB(d, dMatrix1Row, dMatrix1Row, dMatrixRMajIdentity);
        return dMatrixRMajIdentity;
    }

    public static DMatrixRMaj createReflector(DMatrixRMaj dMatrixRMaj, double d) {
        if (!MatrixFeatures_DDRM.isVector(dMatrixRMaj)) {
            throw new IllegalArgumentException("u must be a vector");
        }
        DMatrixRMaj dMatrixRMajIdentity = CommonOps_DDRM.identity(dMatrixRMaj.getNumElements());
        CommonOps_DDRM.multAddTransB(-d, dMatrixRMaj, dMatrixRMaj, dMatrixRMajIdentity);
        return dMatrixRMajIdentity;
    }

    public static DMatrixRMaj copyChangeRow(int[] iArr, DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj2 == null) {
            dMatrixRMaj2 = new DMatrixRMaj(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        } else if (dMatrixRMaj.numRows != dMatrixRMaj2.numRows || dMatrixRMaj.numCols != dMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("src and dst must have the same dimensions.");
        }
        for (int i = 0; i < dMatrixRMaj.numRows; i++) {
            int i2 = dMatrixRMaj.numCols * i;
            System.arraycopy(dMatrixRMaj.data, iArr[i] * dMatrixRMaj.numCols, dMatrixRMaj2.data, i2, dMatrixRMaj.numCols);
        }
        return dMatrixRMaj2;
    }

    public static DMatrixRMaj copyTriangle(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, boolean z) {
        if (dMatrixRMaj2 == null) {
            dMatrixRMaj2 = new DMatrixRMaj(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        } else if (dMatrixRMaj.numRows != dMatrixRMaj2.numRows || dMatrixRMaj.numCols != dMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("src and dst must have the same dimensions.");
        }
        int i = 0;
        if (z) {
            int iMin = Math.min(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
            while (i < iMin) {
                int i2 = (dMatrixRMaj.numCols * i) + i;
                System.arraycopy(dMatrixRMaj.data, i2, dMatrixRMaj2.data, i2, dMatrixRMaj.numCols - i);
                i++;
            }
        } else {
            while (i < dMatrixRMaj.numRows) {
                int i3 = i + 1;
                int iMin2 = Math.min(i3, dMatrixRMaj.numCols);
                int i4 = i * dMatrixRMaj.numCols;
                System.arraycopy(dMatrixRMaj.data, i4, dMatrixRMaj2.data, i4, iMin2);
                i = i3;
            }
        }
        return dMatrixRMaj2;
    }

    public static double diffNormF(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            throw new IllegalArgumentException("Both matrices must have the same shape.");
        }
        int numElements = dMatrixD1.getNumElements();
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(numElements, 1);
        for (int i = 0; i < numElements; i++) {
            dMatrixRMaj.set(i, dMatrixD12.get(i) - dMatrixD1.get(i));
        }
        return NormOps_DDRM.normF(dMatrixRMaj);
    }

    public static double diffNormF_fast(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            throw new IllegalArgumentException("Both matrices must have the same shape.");
        }
        int numElements = dMatrixD1.getNumElements();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < numElements; i++) {
            double d2 = dMatrixD12.get(i) - dMatrixD1.get(i);
            d += d2 * d2;
        }
        return Math.sqrt(d);
    }

    public static double diffNormP1(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            throw new IllegalArgumentException("Both matrices must have the same shape.");
        }
        int numElements = dMatrixD1.getNumElements();
        double dAbs = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < numElements; i++) {
            dAbs += Math.abs(dMatrixD12.get(i) - dMatrixD1.get(i));
        }
        return dAbs;
    }

    public static void addIdentity(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, double d) {
        if (dMatrix1Row.numCols != dMatrix1Row.numRows) {
            throw new IllegalArgumentException("A must be square");
        }
        if (dMatrix1Row2.numCols != dMatrix1Row.numCols || dMatrix1Row2.numRows != dMatrix1Row.numRows) {
            throw new IllegalArgumentException("B must be the same shape as A");
        }
        int i = dMatrix1Row.numCols;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = 0;
            while (i4 < i) {
                if (i3 == i4) {
                    dMatrix1Row2.set(i2, dMatrix1Row.get(i2) + d);
                } else {
                    dMatrix1Row2.set(i2, dMatrix1Row.get(i2));
                }
                i4++;
                i2++;
            }
        }
    }

    public static void subvector(DMatrix1Row dMatrix1Row, int i, int i2, int i3, boolean z, int i4, DMatrix1Row dMatrix1Row2) {
        int i5 = 0;
        if (z) {
            while (i5 < i3) {
                dMatrix1Row2.set(i4 + i5, dMatrix1Row.get(i, i2 + i5));
                i5++;
            }
        } else {
            while (i5 < i3) {
                dMatrix1Row2.set(i4 + i5, dMatrix1Row.get(i + i5, i2));
                i5++;
            }
        }
    }

    public static DMatrixRMaj[] splitIntoVectors(DMatrix1Row dMatrix1Row, boolean z) {
        DMatrix1Row dMatrix1Row2;
        int i;
        int i2 = z ? dMatrix1Row.numCols : dMatrix1Row.numRows;
        int i3 = z ? dMatrix1Row.numRows : 1;
        int i4 = z ? 1 : dMatrix1Row.numCols;
        int iMax = Math.max(i3, i4);
        DMatrixRMaj[] dMatrixRMajArr = new DMatrixRMaj[i2];
        int i5 = 0;
        while (i5 < i2) {
            DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i3, i4);
            if (z) {
                i = i5;
                dMatrix1Row2 = dMatrix1Row;
                subvector(dMatrix1Row2, 0, i, iMax, false, 0, dMatrixRMaj);
            } else {
                dMatrix1Row2 = dMatrix1Row;
                subvector(dMatrix1Row2, i5, 0, iMax, true, 0, dMatrixRMaj);
                i = i5;
            }
            dMatrixRMajArr[i] = dMatrixRMaj;
            i5 = i + 1;
            dMatrix1Row = dMatrix1Row2;
        }
        return dMatrixRMajArr;
    }

    public static DMatrixRMaj pivotMatrix(DMatrixRMaj dMatrixRMaj, int[] iArr, int i, boolean z) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(i, i);
        } else {
            if (dMatrixRMaj.numCols != i || dMatrixRMaj.numRows != i) {
                throw new IllegalArgumentException("Unexpected matrix dimension");
            }
            CommonOps_DDRM.fill(dMatrixRMaj, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        int i2 = 0;
        if (z) {
            while (i2 < i) {
                dMatrixRMaj.set(iArr[i2], i2, 1.0d);
                i2++;
            }
        } else {
            while (i2 < i) {
                dMatrixRMaj.set(i2, iArr[i2], 1.0d);
                i2++;
            }
        }
        return dMatrixRMaj;
    }

    public static double diagProd(DMatrix1Row dMatrix1Row) {
        int iMin = Math.min(dMatrix1Row.numRows, dMatrix1Row.numCols);
        double dUnsafe_get = 1.0d;
        for (int i = 0; i < iMin; i++) {
            dUnsafe_get *= dMatrix1Row.unsafe_get(i, i);
        }
        return dUnsafe_get;
    }

    public static double elementDiagonalMaxAbs(DMatrixD1 dMatrixD1) {
        int iMin = Math.min(dMatrixD1.numRows, dMatrixD1.numCols);
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < iMin; i++) {
            double dAbs = Math.abs(dMatrixD1.get(i, i));
            if (dAbs > d) {
                d = dAbs;
            }
        }
        return d;
    }

    public static double qualityTriangular(DMatrixD1 dMatrixD1) {
        int iMin = Math.min(dMatrixD1.numRows, dMatrixD1.numCols);
        double dElementDiagonalMaxAbs = elementDiagonalMaxAbs(dMatrixD1);
        if (dElementDiagonalMaxAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double dUnsafe_get = 1.0d;
        for (int i = 0; i < iMin; i++) {
            dUnsafe_get *= dMatrixD1.unsafe_get(i, i) / dElementDiagonalMaxAbs;
        }
        return Math.abs(dUnsafe_get);
    }

    public static double elementSumSq(DMatrixD1 dMatrixD1) {
        int numElements = dMatrixD1.getNumElements();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < numElements; i++) {
            double d2 = dMatrixD1.data[i];
            d += d2 * d2;
        }
        return d;
    }
}
