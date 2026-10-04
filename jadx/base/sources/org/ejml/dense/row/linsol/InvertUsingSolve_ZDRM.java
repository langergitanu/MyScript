package org.ejml.dense.row.linsol;

import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.CommonOps_ZDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class InvertUsingSolve_ZDRM {
    public static void invert(LinearSolverDense<ZMatrixRMaj> linearSolverDense, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj.numRows != zMatrixRMaj2.numRows || zMatrixRMaj.numCols != zMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("A and A_inv must have the same dimensions");
        }
        CommonOps_ZDRM.setIdentity(zMatrixRMaj3);
        linearSolverDense.solve(zMatrixRMaj3, zMatrixRMaj2);
    }

    public static void invert(LinearSolverDense<ZMatrixRMaj> linearSolverDense, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        if (zMatrixRMaj.numRows != zMatrixRMaj2.numRows || zMatrixRMaj.numCols != zMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("A and A_inv must have the same dimensions");
        }
        CommonOps_ZDRM.setIdentity(zMatrixRMaj2);
        linearSolverDense.solve(zMatrixRMaj2, zMatrixRMaj2);
    }
}
