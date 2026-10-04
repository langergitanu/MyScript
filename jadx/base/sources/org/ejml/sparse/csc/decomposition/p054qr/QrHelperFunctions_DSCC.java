package org.ejml.sparse.csc.decomposition.p054qr;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DGrowArray;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.DScalar;
import org.ejml.data.IGrowArray;
import org.ejml.sparse.csc.CommonOps_DSCC;
import org.ejml.sparse.csc.misc.ImplCommonOps_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class QrHelperFunctions_DSCC {
    public static void applyHouseholder(DMatrixSparseCSC dMatrixSparseCSC, int i, double d, double[] dArr) {
        int i2 = dMatrixSparseCSC.col_idx[i];
        int i3 = dMatrixSparseCSC.col_idx[i + 1];
        double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i4 = i2; i4 < i3; i4++) {
            d2 += dMatrixSparseCSC.nz_values[i4] * dArr[dMatrixSparseCSC.nz_rows[i4]];
        }
        double d3 = d2 * d;
        while (i2 < i3) {
            int i5 = dMatrixSparseCSC.nz_rows[i2];
            dArr[i5] = dArr[i5] - (dMatrixSparseCSC.nz_values[i2] * d3);
            i2++;
        }
    }

    public static void rank1UpdateMultR(DMatrixSparseCSC dMatrixSparseCSC, int i, double d, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3, IGrowArray iGrowArray, DGrowArray dGrowArray) {
        DMatrixSparseCSC dMatrixSparseCSC4 = dMatrixSparseCSC2;
        DMatrixSparseCSC dMatrixSparseCSC5 = dMatrixSparseCSC3;
        if (dMatrixSparseCSC.numRows != dMatrixSparseCSC4.numRows) {
            throw new IllegalArgumentException("Number of rows in V and A must match");
        }
        dMatrixSparseCSC5.nz_length = 0;
        dMatrixSparseCSC5.numRows = dMatrixSparseCSC.numRows;
        dMatrixSparseCSC5.numCols = 0;
        int i2 = 0;
        while (i2 < dMatrixSparseCSC4.numCols) {
            double dDotInnerColumns = (-d) * CommonOps_DSCC.dotInnerColumns(dMatrixSparseCSC, i, dMatrixSparseCSC4, i2, iGrowArray, dGrowArray);
            dMatrixSparseCSC4 = dMatrixSparseCSC2;
            ImplCommonOps_DSCC.addColAppend(1.0d, dMatrixSparseCSC4, i2, dDotInnerColumns, dMatrixSparseCSC, i, dMatrixSparseCSC5, iGrowArray);
            i2++;
            dMatrixSparseCSC5 = dMatrixSparseCSC3;
        }
    }

    public static double computeHouseholder(double[] dArr, int i, int i2, double d, DScalar dScalar) {
        double d2 = 0.0d;
        for (int i3 = i; i3 < i2; i3++) {
            double d3 = dArr[i3] / d;
            dArr[i3] = d3;
            d2 += d3 * d3;
        }
        double dSqrt = Math.sqrt(d2);
        double d4 = dArr[i];
        if (d4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            dSqrt = -dSqrt;
        }
        double d5 = d4 + dSqrt;
        dScalar.value = d5 / dSqrt;
        dArr[i] = 1.0d;
        while (true) {
            i++;
            if (i >= i2) {
                return (-dSqrt) * d;
            }
            dArr[i] = dArr[i] / d5;
        }
    }
}
