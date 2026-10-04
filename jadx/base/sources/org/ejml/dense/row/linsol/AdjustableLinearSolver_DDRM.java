package org.ejml.dense.row.linsol;

import org.ejml.data.DMatrixRMaj;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public interface AdjustableLinearSolver_DDRM extends LinearSolverDense<DMatrixRMaj> {
    boolean addRowToA(double[] dArr, int i);

    boolean removeRowFromA(int i);
}
