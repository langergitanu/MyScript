package org.ejml.dense.row.linsol;

import org.ejml.data.FMatrixRMaj;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public interface AdjustableLinearSolver_FDRM extends LinearSolverDense<FMatrixRMaj> {
    boolean addRowToA(float[] fArr, int i);

    boolean removeRowFromA(int i);
}
