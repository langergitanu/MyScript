package org.ejml.dense.row.linsol;

import org.ejml.data.FMatrix1Row;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class InvertUsingSolve_FDRM {
    public static void invert(LinearSolverDense<FMatrixRMaj> linearSolverDense, FMatrix1Row fMatrix1Row, FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrix1Row.numRows != fMatrixRMaj.numRows || fMatrix1Row.numCols != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A and A_inv must have the same dimensions");
        }
        CommonOps_FDRM.setIdentity(fMatrixRMaj2);
        linearSolverDense.solve(fMatrixRMaj2, fMatrixRMaj);
    }

    public static void invert(LinearSolverDense<FMatrixRMaj> linearSolverDense, FMatrix1Row fMatrix1Row, FMatrixRMaj fMatrixRMaj) {
        if (fMatrix1Row.numRows != fMatrixRMaj.numRows || fMatrix1Row.numCols != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A and A_inv must have the same dimensions");
        }
        CommonOps_FDRM.setIdentity(fMatrixRMaj);
        linearSolverDense.solve(fMatrixRMaj, fMatrixRMaj);
    }
}
