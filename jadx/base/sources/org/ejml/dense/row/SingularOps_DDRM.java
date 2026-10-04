package org.ejml.dense.row;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.UtilEjml;
import org.ejml.data.DMatrixRMaj;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class SingularOps_DDRM {
    public static void descendingOrder(DMatrixRMaj dMatrixRMaj, boolean z, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3, boolean z2) {
        int iMin = Math.min(dMatrixRMaj2.numRows, dMatrixRMaj2.numCols);
        checkSvdMatrixSize(dMatrixRMaj, z, dMatrixRMaj2, dMatrixRMaj3, z2);
        for (int i = 0; i < iMin; i++) {
            double d = -1.0d;
            int i2 = -1;
            for (int i3 = i; i3 < iMin; i3++) {
                double d2 = dMatrixRMaj2.get(i3, i3);
                if (d2 > d) {
                    i2 = i3;
                    d = d2;
                }
            }
            if (i2 != i) {
                if (i2 == -1) {
                    return;
                }
                double d3 = dMatrixRMaj2.get(i, i);
                dMatrixRMaj2.set(i, i, d);
                dMatrixRMaj2.set(i2, i2, d3);
                if (dMatrixRMaj3 != null) {
                    swapRowOrCol(dMatrixRMaj3, z2, i, i2);
                }
                if (dMatrixRMaj != null) {
                    swapRowOrCol(dMatrixRMaj, z, i, i2);
                }
            }
        }
    }

    public static void descendingOrder(DMatrixRMaj dMatrixRMaj, boolean z, double[] dArr, int i, DMatrixRMaj dMatrixRMaj2, boolean z2) {
        for (int i2 = 0; i2 < i; i2++) {
            double d = -1.0d;
            int i3 = -1;
            for (int i4 = i2; i4 < i; i4++) {
                double d2 = dArr[i4];
                if (d2 > d) {
                    i3 = i4;
                    d = d2;
                }
            }
            if (i3 != i2) {
                if (i3 == -1) {
                    return;
                }
                double d3 = dArr[i2];
                dArr[i2] = d;
                dArr[i3] = d3;
                if (dMatrixRMaj2 != null) {
                    swapRowOrCol(dMatrixRMaj2, z2, i2, i3);
                }
                if (dMatrixRMaj != null) {
                    swapRowOrCol(dMatrixRMaj, z, i2, i3);
                }
            }
        }
    }

    public static void checkSvdMatrixSize(DMatrixRMaj dMatrixRMaj, boolean z, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3, boolean z2) {
        int iMin = Math.min(dMatrixRMaj2.numRows, dMatrixRMaj2.numCols);
        if (dMatrixRMaj2.numRows != dMatrixRMaj2.numCols) {
            if (dMatrixRMaj != null && dMatrixRMaj.numRows != dMatrixRMaj.numCols) {
                throw new IllegalArgumentException("Unexpected size of matrix U");
            }
            if (dMatrixRMaj3 != null && dMatrixRMaj3.numRows != dMatrixRMaj3.numCols) {
                throw new IllegalArgumentException("Unexpected size of matrix V");
            }
            if (dMatrixRMaj != null && dMatrixRMaj.numRows != dMatrixRMaj2.numRows) {
                throw new IllegalArgumentException("Unexpected size of W");
            }
            if (dMatrixRMaj3 != null && dMatrixRMaj3.numRows != dMatrixRMaj2.numCols) {
                throw new IllegalArgumentException("Unexpected size of W");
            }
            return;
        }
        if (dMatrixRMaj != null) {
            if (z && dMatrixRMaj.numRows != iMin) {
                throw new IllegalArgumentException("Unexpected size of matrix U");
            }
            if (!z && dMatrixRMaj.numCols != iMin) {
                throw new IllegalArgumentException("Unexpected size of matrix U");
            }
        }
        if (dMatrixRMaj3 != null) {
            if (z2 && dMatrixRMaj3.numRows != iMin) {
                throw new IllegalArgumentException("Unexpected size of matrix V");
            }
            if (!z2 && dMatrixRMaj3.numCols != iMin) {
                throw new IllegalArgumentException("Unexpected size of matrix V");
            }
        }
    }

    private static void swapRowOrCol(DMatrixRMaj dMatrixRMaj, boolean z, int i, int i2) {
        int i3 = 0;
        if (z) {
            while (i3 < dMatrixRMaj.numCols) {
                double d = dMatrixRMaj.get(i, i3);
                dMatrixRMaj.set(i, i3, dMatrixRMaj.get(i2, i3));
                dMatrixRMaj.set(i2, i3, d);
                i3++;
            }
            return;
        }
        while (i3 < dMatrixRMaj.numRows) {
            double d2 = dMatrixRMaj.get(i3, i);
            dMatrixRMaj.set(i3, i, dMatrixRMaj.get(i3, i2));
            dMatrixRMaj.set(i3, i2, d2);
            i3++;
        }
    }

    public static DMatrixRMaj nullSpace(SingularValueDecomposition_F64<DMatrixRMaj> singularValueDecomposition_F64, DMatrixRMaj dMatrixRMaj, double d) {
        int iNumberOfSingularValues = singularValueDecomposition_F64.numberOfSingularValues();
        double[] singularValues = singularValueDecomposition_F64.getSingularValues();
        DMatrixRMaj v = singularValueDecomposition_F64.getV(null, true);
        if (v.numRows != singularValueDecomposition_F64.numCols()) {
            throw new IllegalArgumentException("Can't compute the null space using a compact SVD for a matrix of this size.");
        }
        int iNumCols = singularValueDecomposition_F64.numCols() - iNumberOfSingularValues;
        for (int i = 0; i < iNumberOfSingularValues; i++) {
            if (singularValues[i] <= d) {
                iNumCols++;
            }
        }
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(iNumCols, singularValueDecomposition_F64.numCols());
        } else {
            dMatrixRMaj.reshape(iNumCols, singularValueDecomposition_F64.numCols());
        }
        DMatrixRMaj dMatrixRMaj2 = dMatrixRMaj;
        int i2 = 0;
        for (int i3 = 0; i3 < iNumberOfSingularValues; i3++) {
            if (singularValues[i3] <= d) {
                CommonOps_DDRM.extract(v, i3, i3 + 1, 0, v.numCols, dMatrixRMaj2, i2, 0);
                i2++;
            }
        }
        int i4 = iNumberOfSingularValues;
        while (i4 < singularValueDecomposition_F64.numCols()) {
            int i5 = i4 + 1;
            CommonOps_DDRM.extract(v, i4, i5, 0, v.numCols, dMatrixRMaj2, i2, 0);
            i2++;
            i4 = i5;
        }
        CommonOps_DDRM.transpose(dMatrixRMaj2);
        return dMatrixRMaj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DMatrixRMaj nullVector(SingularValueDecomposition_F64<DMatrixRMaj> singularValueDecomposition_F64, boolean z, DMatrixRMaj dMatrixRMaj) {
        int i;
        int iNumRows;
        int iNumberOfSingularValues = singularValueDecomposition_F64.numberOfSingularValues();
        double[] singularValues = singularValueDecomposition_F64.getSingularValues();
        DMatrixRMaj v = z ? singularValueDecomposition_F64.getV(null, true) : singularValueDecomposition_F64.getU(null, false);
        if (z) {
            if (v.numRows != singularValueDecomposition_F64.numCols()) {
                throw new IllegalArgumentException("Can't compute the null space using a compact SVD for a matrix of this size.");
            }
            if (dMatrixRMaj == null) {
                dMatrixRMaj = new DMatrixRMaj(singularValueDecomposition_F64.numCols(), 1);
            }
        } else {
            if (v.numCols != singularValueDecomposition_F64.numRows()) {
                throw new IllegalArgumentException("Can't compute the null space using a compact SVD for a matrix of this size.");
            }
            if (dMatrixRMaj == null) {
                dMatrixRMaj = new DMatrixRMaj(singularValueDecomposition_F64.numRows(), 1);
            }
        }
        DMatrixRMaj dMatrixRMaj2 = dMatrixRMaj;
        if (z && singularValueDecomposition_F64.numCols() > singularValueDecomposition_F64.numRows()) {
            iNumRows = singularValueDecomposition_F64.numCols();
        } else {
            if (z || singularValueDecomposition_F64.numCols() >= singularValueDecomposition_F64.numRows()) {
                i = -1;
                double d = Double.MAX_VALUE;
                for (int i2 = 0; i2 < iNumberOfSingularValues; i2++) {
                    double d2 = singularValues[i2];
                    if (d2 < d) {
                        i = i2;
                        d = d2;
                    }
                }
                int i3 = i;
                if (!z) {
                    SpecializedOps_DDRM.subvector(v, i3, 0, v.numRows, true, 0, dMatrixRMaj2);
                    return dMatrixRMaj2;
                }
                SpecializedOps_DDRM.subvector(v, 0, i3, v.numRows, false, 0, dMatrixRMaj2);
                return dMatrixRMaj2;
            }
            iNumRows = singularValueDecomposition_F64.numRows();
        }
        i = iNumRows - 1;
        int i32 = i;
        if (!z) {
        }
    }

    public static double singularThreshold(SingularValueDecomposition_F64 singularValueDecomposition_F64) {
        double[] singularValues = singularValueDecomposition_F64.getSingularValues();
        int iNumberOfSingularValues = singularValueDecomposition_F64.numberOfSingularValues();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < iNumberOfSingularValues; i++) {
            double d2 = singularValues[i];
            if (d2 > d) {
                d = d2;
            }
        }
        return ((double) Math.max(singularValueDecomposition_F64.numCols(), singularValueDecomposition_F64.numRows())) * d * UtilEjml.EPS;
    }

    public static int rank(SingularValueDecomposition_F64 singularValueDecomposition_F64) {
        return rank(singularValueDecomposition_F64, singularThreshold(singularValueDecomposition_F64));
    }

    public static int rank(SingularValueDecomposition_F64 singularValueDecomposition_F64, double d) {
        double[] singularValues = singularValueDecomposition_F64.getSingularValues();
        int iNumberOfSingularValues = singularValueDecomposition_F64.numberOfSingularValues();
        int i = 0;
        for (int i2 = 0; i2 < iNumberOfSingularValues; i2++) {
            if (singularValues[i2] > d) {
                i++;
            }
        }
        return i;
    }

    public static int nullity(SingularValueDecomposition_F64 singularValueDecomposition_F64) {
        return nullity(singularValueDecomposition_F64, singularThreshold(singularValueDecomposition_F64));
    }

    public static int nullity(SingularValueDecomposition_F64 singularValueDecomposition_F64, double d) {
        double[] singularValues = singularValueDecomposition_F64.getSingularValues();
        int iNumberOfSingularValues = singularValueDecomposition_F64.numberOfSingularValues();
        int iNumCols = singularValueDecomposition_F64.numCols();
        int i = 0;
        for (int i2 = 0; i2 < iNumberOfSingularValues; i2++) {
            if (singularValues[i2] <= d) {
                i++;
            }
        }
        return (i + iNumCols) - iNumberOfSingularValues;
    }
}
