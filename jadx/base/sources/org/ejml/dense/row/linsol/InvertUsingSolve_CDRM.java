package org.ejml.dense.row.linsol;

import org.ejml.data.CMatrixRMaj;
import org.ejml.dense.row.CommonOps_CDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class InvertUsingSolve_CDRM {
    public static void invert(LinearSolverDense<CMatrixRMaj> linearSolverDense, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numRows || cMatrixRMaj.numCols != cMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("A and A_inv must have the same dimensions");
        }
        CommonOps_CDRM.setIdentity(cMatrixRMaj3);
        linearSolverDense.solve(cMatrixRMaj3, cMatrixRMaj2);
    }

    public static void invert(LinearSolverDense<CMatrixRMaj> linearSolverDense, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numRows || cMatrixRMaj.numCols != cMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("A and A_inv must have the same dimensions");
        }
        CommonOps_CDRM.setIdentity(cMatrixRMaj2);
        linearSolverDense.solve(cMatrixRMaj2, cMatrixRMaj2);
    }
}
