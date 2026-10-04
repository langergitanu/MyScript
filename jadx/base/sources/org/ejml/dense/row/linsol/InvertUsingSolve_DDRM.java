package org.ejml.dense.row.linsol;

import org.ejml.data.DMatrix1Row;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class InvertUsingSolve_DDRM {
    public static void invert(LinearSolverDense<DMatrixRMaj> linearSolverDense, DMatrix1Row dMatrix1Row, DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrix1Row.numRows != dMatrixRMaj.numRows || dMatrix1Row.numCols != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A and A_inv must have the same dimensions");
        }
        CommonOps_DDRM.setIdentity(dMatrixRMaj2);
        linearSolverDense.solve(dMatrixRMaj2, dMatrixRMaj);
    }

    public static void invert(LinearSolverDense<DMatrixRMaj> linearSolverDense, DMatrix1Row dMatrix1Row, DMatrixRMaj dMatrixRMaj) {
        if (dMatrix1Row.numRows != dMatrixRMaj.numRows || dMatrix1Row.numCols != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A and A_inv must have the same dimensions");
        }
        CommonOps_DDRM.setIdentity(dMatrixRMaj);
        linearSolverDense.solve(dMatrixRMaj, dMatrixRMaj);
    }
}
