package org.ejml.dense.row;

import org.ejml.data.FMatrix1Row;
import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class SpecializedOps_FDRM {
    public static FMatrixRMaj createReflector(FMatrix1Row fMatrix1Row) {
        if (!MatrixFeatures_FDRM.isVector(fMatrix1Row)) {
            throw new IllegalArgumentException("u must be a vector");
        }
        float fFastNormF = NormOps_FDRM.fastNormF(fMatrix1Row);
        float f = (-2.0f) / (fFastNormF * fFastNormF);
        FMatrixRMaj fMatrixRMajIdentity = CommonOps_FDRM.identity(fMatrix1Row.getNumElements());
        CommonOps_FDRM.multAddTransB(f, fMatrix1Row, fMatrix1Row, fMatrixRMajIdentity);
        return fMatrixRMajIdentity;
    }

    public static FMatrixRMaj createReflector(FMatrixRMaj fMatrixRMaj, float f) {
        if (!MatrixFeatures_FDRM.isVector(fMatrixRMaj)) {
            throw new IllegalArgumentException("u must be a vector");
        }
        FMatrixRMaj fMatrixRMajIdentity = CommonOps_FDRM.identity(fMatrixRMaj.getNumElements());
        CommonOps_FDRM.multAddTransB(-f, fMatrixRMaj, fMatrixRMaj, fMatrixRMajIdentity);
        return fMatrixRMajIdentity;
    }

    public static FMatrixRMaj copyChangeRow(int[] iArr, FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj2 == null) {
            fMatrixRMaj2 = new FMatrixRMaj(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        } else if (fMatrixRMaj.numRows != fMatrixRMaj2.numRows || fMatrixRMaj.numCols != fMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("src and dst must have the same dimensions.");
        }
        for (int i = 0; i < fMatrixRMaj.numRows; i++) {
            int i2 = fMatrixRMaj.numCols * i;
            System.arraycopy(fMatrixRMaj.data, iArr[i] * fMatrixRMaj.numCols, fMatrixRMaj2.data, i2, fMatrixRMaj.numCols);
        }
        return fMatrixRMaj2;
    }

    public static FMatrixRMaj copyTriangle(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, boolean z) {
        if (fMatrixRMaj2 == null) {
            fMatrixRMaj2 = new FMatrixRMaj(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        } else if (fMatrixRMaj.numRows != fMatrixRMaj2.numRows || fMatrixRMaj.numCols != fMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("src and dst must have the same dimensions.");
        }
        int i = 0;
        if (z) {
            int iMin = Math.min(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
            while (i < iMin) {
                int i2 = (fMatrixRMaj.numCols * i) + i;
                System.arraycopy(fMatrixRMaj.data, i2, fMatrixRMaj2.data, i2, fMatrixRMaj.numCols - i);
                i++;
            }
        } else {
            while (i < fMatrixRMaj.numRows) {
                int i3 = i + 1;
                int iMin2 = Math.min(i3, fMatrixRMaj.numCols);
                int i4 = i * fMatrixRMaj.numCols;
                System.arraycopy(fMatrixRMaj.data, i4, fMatrixRMaj2.data, i4, iMin2);
                i = i3;
            }
        }
        return fMatrixRMaj2;
    }

    public static float diffNormF(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            throw new IllegalArgumentException("Both matrices must have the same shape.");
        }
        int numElements = fMatrixD1.getNumElements();
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(numElements, 1);
        for (int i = 0; i < numElements; i++) {
            fMatrixRMaj.set(i, fMatrixD12.get(i) - fMatrixD1.get(i));
        }
        return NormOps_FDRM.normF(fMatrixRMaj);
    }

    public static float diffNormF_fast(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            throw new IllegalArgumentException("Both matrices must have the same shape.");
        }
        int numElements = fMatrixD1.getNumElements();
        float f = 0.0f;
        for (int i = 0; i < numElements; i++) {
            float f2 = fMatrixD12.get(i) - fMatrixD1.get(i);
            f += f2 * f2;
        }
        return (float) Math.sqrt(f);
    }

    public static float diffNormP1(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            throw new IllegalArgumentException("Both matrices must have the same shape.");
        }
        int numElements = fMatrixD1.getNumElements();
        float fAbs = 0.0f;
        for (int i = 0; i < numElements; i++) {
            fAbs += Math.abs(fMatrixD12.get(i) - fMatrixD1.get(i));
        }
        return fAbs;
    }

    public static void addIdentity(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, float f) {
        if (fMatrix1Row.numCols != fMatrix1Row.numRows) {
            throw new IllegalArgumentException("A must be square");
        }
        if (fMatrix1Row2.numCols != fMatrix1Row.numCols || fMatrix1Row2.numRows != fMatrix1Row.numRows) {
            throw new IllegalArgumentException("B must be the same shape as A");
        }
        int i = fMatrix1Row.numCols;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = 0;
            while (i4 < i) {
                if (i3 == i4) {
                    fMatrix1Row2.set(i2, fMatrix1Row.get(i2) + f);
                } else {
                    fMatrix1Row2.set(i2, fMatrix1Row.get(i2));
                }
                i4++;
                i2++;
            }
        }
    }

    public static void subvector(FMatrix1Row fMatrix1Row, int i, int i2, int i3, boolean z, int i4, FMatrix1Row fMatrix1Row2) {
        int i5 = 0;
        if (z) {
            while (i5 < i3) {
                fMatrix1Row2.set(i4 + i5, fMatrix1Row.get(i, i2 + i5));
                i5++;
            }
        } else {
            while (i5 < i3) {
                fMatrix1Row2.set(i4 + i5, fMatrix1Row.get(i + i5, i2));
                i5++;
            }
        }
    }

    public static FMatrixRMaj[] splitIntoVectors(FMatrix1Row fMatrix1Row, boolean z) {
        FMatrix1Row fMatrix1Row2;
        int i;
        int i2 = z ? fMatrix1Row.numCols : fMatrix1Row.numRows;
        int i3 = z ? fMatrix1Row.numRows : 1;
        int i4 = z ? 1 : fMatrix1Row.numCols;
        int iMax = Math.max(i3, i4);
        FMatrixRMaj[] fMatrixRMajArr = new FMatrixRMaj[i2];
        int i5 = 0;
        while (i5 < i2) {
            FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i3, i4);
            if (z) {
                i = i5;
                fMatrix1Row2 = fMatrix1Row;
                subvector(fMatrix1Row2, 0, i, iMax, false, 0, fMatrixRMaj);
            } else {
                fMatrix1Row2 = fMatrix1Row;
                subvector(fMatrix1Row2, i5, 0, iMax, true, 0, fMatrixRMaj);
                i = i5;
            }
            fMatrixRMajArr[i] = fMatrixRMaj;
            i5 = i + 1;
            fMatrix1Row = fMatrix1Row2;
        }
        return fMatrixRMajArr;
    }

    public static FMatrixRMaj pivotMatrix(FMatrixRMaj fMatrixRMaj, int[] iArr, int i, boolean z) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(i, i);
        } else {
            if (fMatrixRMaj.numCols != i || fMatrixRMaj.numRows != i) {
                throw new IllegalArgumentException("Unexpected matrix dimension");
            }
            CommonOps_FDRM.fill(fMatrixRMaj, 0.0f);
        }
        int i2 = 0;
        if (z) {
            while (i2 < i) {
                fMatrixRMaj.set(iArr[i2], i2, 1.0f);
                i2++;
            }
        } else {
            while (i2 < i) {
                fMatrixRMaj.set(i2, iArr[i2], 1.0f);
                i2++;
            }
        }
        return fMatrixRMaj;
    }

    public static float diagProd(FMatrix1Row fMatrix1Row) {
        int iMin = Math.min(fMatrix1Row.numRows, fMatrix1Row.numCols);
        float fUnsafe_get = 1.0f;
        for (int i = 0; i < iMin; i++) {
            fUnsafe_get *= fMatrix1Row.unsafe_get(i, i);
        }
        return fUnsafe_get;
    }

    public static float elementDiagonalMaxAbs(FMatrixD1 fMatrixD1) {
        int iMin = Math.min(fMatrixD1.numRows, fMatrixD1.numCols);
        float f = 0.0f;
        for (int i = 0; i < iMin; i++) {
            float fAbs = Math.abs(fMatrixD1.get(i, i));
            if (fAbs > f) {
                f = fAbs;
            }
        }
        return f;
    }

    public static float qualityTriangular(FMatrixD1 fMatrixD1) {
        int iMin = Math.min(fMatrixD1.numRows, fMatrixD1.numCols);
        float fElementDiagonalMaxAbs = elementDiagonalMaxAbs(fMatrixD1);
        if (fElementDiagonalMaxAbs == 0.0f) {
            return 0.0f;
        }
        float fUnsafe_get = 1.0f;
        for (int i = 0; i < iMin; i++) {
            fUnsafe_get *= fMatrixD1.unsafe_get(i, i) / fElementDiagonalMaxAbs;
        }
        return Math.abs(fUnsafe_get);
    }

    public static float elementSumSq(FMatrixD1 fMatrixD1) {
        int numElements = fMatrixD1.getNumElements();
        float f = 0.0f;
        for (int i = 0; i < numElements; i++) {
            float f2 = fMatrixD1.data[i];
            f += f2 * f2;
        }
        return f;
    }
}
