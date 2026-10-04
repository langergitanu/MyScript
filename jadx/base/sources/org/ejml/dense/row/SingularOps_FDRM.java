package org.ejml.dense.row;

import org.ejml.UtilEjml;
import org.ejml.data.FMatrixRMaj;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class SingularOps_FDRM {
    public static void descendingOrder(FMatrixRMaj fMatrixRMaj, boolean z, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3, boolean z2) {
        int iMin = Math.min(fMatrixRMaj2.numRows, fMatrixRMaj2.numCols);
        checkSvdMatrixSize(fMatrixRMaj, z, fMatrixRMaj2, fMatrixRMaj3, z2);
        for (int i = 0; i < iMin; i++) {
            float f = -1.0f;
            int i2 = -1;
            for (int i3 = i; i3 < iMin; i3++) {
                float f2 = fMatrixRMaj2.get(i3, i3);
                if (f2 > f) {
                    i2 = i3;
                    f = f2;
                }
            }
            if (i2 != i) {
                if (i2 == -1) {
                    return;
                }
                float f3 = fMatrixRMaj2.get(i, i);
                fMatrixRMaj2.set(i, i, f);
                fMatrixRMaj2.set(i2, i2, f3);
                if (fMatrixRMaj3 != null) {
                    swapRowOrCol(fMatrixRMaj3, z2, i, i2);
                }
                if (fMatrixRMaj != null) {
                    swapRowOrCol(fMatrixRMaj, z, i, i2);
                }
            }
        }
    }

    public static void descendingOrder(FMatrixRMaj fMatrixRMaj, boolean z, float[] fArr, int i, FMatrixRMaj fMatrixRMaj2, boolean z2) {
        for (int i2 = 0; i2 < i; i2++) {
            float f = -1.0f;
            int i3 = -1;
            for (int i4 = i2; i4 < i; i4++) {
                float f2 = fArr[i4];
                if (f2 > f) {
                    i3 = i4;
                    f = f2;
                }
            }
            if (i3 != i2) {
                if (i3 == -1) {
                    return;
                }
                float f3 = fArr[i2];
                fArr[i2] = f;
                fArr[i3] = f3;
                if (fMatrixRMaj2 != null) {
                    swapRowOrCol(fMatrixRMaj2, z2, i2, i3);
                }
                if (fMatrixRMaj != null) {
                    swapRowOrCol(fMatrixRMaj, z, i2, i3);
                }
            }
        }
    }

    public static void checkSvdMatrixSize(FMatrixRMaj fMatrixRMaj, boolean z, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3, boolean z2) {
        int iMin = Math.min(fMatrixRMaj2.numRows, fMatrixRMaj2.numCols);
        if (fMatrixRMaj2.numRows != fMatrixRMaj2.numCols) {
            if (fMatrixRMaj != null && fMatrixRMaj.numRows != fMatrixRMaj.numCols) {
                throw new IllegalArgumentException("Unexpected size of matrix U");
            }
            if (fMatrixRMaj3 != null && fMatrixRMaj3.numRows != fMatrixRMaj3.numCols) {
                throw new IllegalArgumentException("Unexpected size of matrix V");
            }
            if (fMatrixRMaj != null && fMatrixRMaj.numRows != fMatrixRMaj2.numRows) {
                throw new IllegalArgumentException("Unexpected size of W");
            }
            if (fMatrixRMaj3 != null && fMatrixRMaj3.numRows != fMatrixRMaj2.numCols) {
                throw new IllegalArgumentException("Unexpected size of W");
            }
            return;
        }
        if (fMatrixRMaj != null) {
            if (z && fMatrixRMaj.numRows != iMin) {
                throw new IllegalArgumentException("Unexpected size of matrix U");
            }
            if (!z && fMatrixRMaj.numCols != iMin) {
                throw new IllegalArgumentException("Unexpected size of matrix U");
            }
        }
        if (fMatrixRMaj3 != null) {
            if (z2 && fMatrixRMaj3.numRows != iMin) {
                throw new IllegalArgumentException("Unexpected size of matrix V");
            }
            if (!z2 && fMatrixRMaj3.numCols != iMin) {
                throw new IllegalArgumentException("Unexpected size of matrix V");
            }
        }
    }

    private static void swapRowOrCol(FMatrixRMaj fMatrixRMaj, boolean z, int i, int i2) {
        int i3 = 0;
        if (z) {
            while (i3 < fMatrixRMaj.numCols) {
                float f = fMatrixRMaj.get(i, i3);
                fMatrixRMaj.set(i, i3, fMatrixRMaj.get(i2, i3));
                fMatrixRMaj.set(i2, i3, f);
                i3++;
            }
            return;
        }
        while (i3 < fMatrixRMaj.numRows) {
            float f2 = fMatrixRMaj.get(i3, i);
            fMatrixRMaj.set(i3, i, fMatrixRMaj.get(i3, i2));
            fMatrixRMaj.set(i3, i2, f2);
            i3++;
        }
    }

    public static FMatrixRMaj nullSpace(SingularValueDecomposition_F32<FMatrixRMaj> singularValueDecomposition_F32, FMatrixRMaj fMatrixRMaj, float f) {
        int iNumberOfSingularValues = singularValueDecomposition_F32.numberOfSingularValues();
        float[] singularValues = singularValueDecomposition_F32.getSingularValues();
        FMatrixRMaj v = singularValueDecomposition_F32.getV(null, true);
        if (v.numRows != singularValueDecomposition_F32.numCols()) {
            throw new IllegalArgumentException("Can't compute the null space using a compact SVD for a matrix of this size.");
        }
        int iNumCols = singularValueDecomposition_F32.numCols() - iNumberOfSingularValues;
        for (int i = 0; i < iNumberOfSingularValues; i++) {
            if (singularValues[i] <= f) {
                iNumCols++;
            }
        }
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(iNumCols, singularValueDecomposition_F32.numCols());
        } else {
            fMatrixRMaj.reshape(iNumCols, singularValueDecomposition_F32.numCols());
        }
        FMatrixRMaj fMatrixRMaj2 = fMatrixRMaj;
        int i2 = 0;
        for (int i3 = 0; i3 < iNumberOfSingularValues; i3++) {
            if (singularValues[i3] <= f) {
                CommonOps_FDRM.extract(v, i3, i3 + 1, 0, v.numCols, fMatrixRMaj2, i2, 0);
                i2++;
            }
        }
        int i4 = iNumberOfSingularValues;
        while (i4 < singularValueDecomposition_F32.numCols()) {
            int i5 = i4 + 1;
            CommonOps_FDRM.extract(v, i4, i5, 0, v.numCols, fMatrixRMaj2, i2, 0);
            i2++;
            i4 = i5;
        }
        CommonOps_FDRM.transpose(fMatrixRMaj2);
        return fMatrixRMaj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static FMatrixRMaj nullVector(SingularValueDecomposition_F32<FMatrixRMaj> singularValueDecomposition_F32, boolean z, FMatrixRMaj fMatrixRMaj) {
        int i;
        int iNumRows;
        int iNumberOfSingularValues = singularValueDecomposition_F32.numberOfSingularValues();
        float[] singularValues = singularValueDecomposition_F32.getSingularValues();
        FMatrixRMaj v = z ? singularValueDecomposition_F32.getV(null, true) : singularValueDecomposition_F32.getU(null, false);
        if (z) {
            if (v.numRows != singularValueDecomposition_F32.numCols()) {
                throw new IllegalArgumentException("Can't compute the null space using a compact SVD for a matrix of this size.");
            }
            if (fMatrixRMaj == null) {
                fMatrixRMaj = new FMatrixRMaj(singularValueDecomposition_F32.numCols(), 1);
            }
        } else {
            if (v.numCols != singularValueDecomposition_F32.numRows()) {
                throw new IllegalArgumentException("Can't compute the null space using a compact SVD for a matrix of this size.");
            }
            if (fMatrixRMaj == null) {
                fMatrixRMaj = new FMatrixRMaj(singularValueDecomposition_F32.numRows(), 1);
            }
        }
        FMatrixRMaj fMatrixRMaj2 = fMatrixRMaj;
        if (z && singularValueDecomposition_F32.numCols() > singularValueDecomposition_F32.numRows()) {
            iNumRows = singularValueDecomposition_F32.numCols();
        } else {
            if (z || singularValueDecomposition_F32.numCols() >= singularValueDecomposition_F32.numRows()) {
                i = -1;
                float f = Float.MAX_VALUE;
                for (int i2 = 0; i2 < iNumberOfSingularValues; i2++) {
                    float f2 = singularValues[i2];
                    if (f2 < f) {
                        i = i2;
                        f = f2;
                    }
                }
                int i3 = i;
                if (!z) {
                    SpecializedOps_FDRM.subvector(v, i3, 0, v.numRows, true, 0, fMatrixRMaj2);
                    return fMatrixRMaj2;
                }
                SpecializedOps_FDRM.subvector(v, 0, i3, v.numRows, false, 0, fMatrixRMaj2);
                return fMatrixRMaj2;
            }
            iNumRows = singularValueDecomposition_F32.numRows();
        }
        i = iNumRows - 1;
        int i32 = i;
        if (!z) {
        }
    }

    public static float singularThreshold(SingularValueDecomposition_F32 singularValueDecomposition_F32) {
        float[] singularValues = singularValueDecomposition_F32.getSingularValues();
        int iNumberOfSingularValues = singularValueDecomposition_F32.numberOfSingularValues();
        float f = 0.0f;
        for (int i = 0; i < iNumberOfSingularValues; i++) {
            float f2 = singularValues[i];
            if (f2 > f) {
                f = f2;
            }
        }
        return Math.max(singularValueDecomposition_F32.numCols(), singularValueDecomposition_F32.numRows()) * f * UtilEjml.F_EPS;
    }

    public static int rank(SingularValueDecomposition_F32 singularValueDecomposition_F32) {
        return rank(singularValueDecomposition_F32, singularThreshold(singularValueDecomposition_F32));
    }

    public static int rank(SingularValueDecomposition_F32 singularValueDecomposition_F32, float f) {
        float[] singularValues = singularValueDecomposition_F32.getSingularValues();
        int iNumberOfSingularValues = singularValueDecomposition_F32.numberOfSingularValues();
        int i = 0;
        for (int i2 = 0; i2 < iNumberOfSingularValues; i2++) {
            if (singularValues[i2] > f) {
                i++;
            }
        }
        return i;
    }

    public static int nullity(SingularValueDecomposition_F32 singularValueDecomposition_F32) {
        return nullity(singularValueDecomposition_F32, singularThreshold(singularValueDecomposition_F32));
    }

    public static int nullity(SingularValueDecomposition_F32 singularValueDecomposition_F32, float f) {
        float[] singularValues = singularValueDecomposition_F32.getSingularValues();
        int iNumberOfSingularValues = singularValueDecomposition_F32.numberOfSingularValues();
        int iNumCols = singularValueDecomposition_F32.numCols();
        int i = 0;
        for (int i2 = 0; i2 < iNumberOfSingularValues; i2++) {
            if (singularValues[i2] <= f) {
                i++;
            }
        }
        return (i + iNumCols) - iNumberOfSingularValues;
    }
}
