package org.ejml.sparse.csc.factory;

import org.ejml.data.DMatrixRMaj;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.interfaces.linsol.LinearSolverSparse;
import org.ejml.sparse.FillReducing;
import org.ejml.sparse.csc.decomposition.chol.CholeskyUpLooking_DSCC;
import org.ejml.sparse.csc.decomposition.p053lu.LuUpLooking_DSCC;
import org.ejml.sparse.csc.decomposition.p054qr.QrLeftLookingDecomposition_DSCC;
import org.ejml.sparse.csc.linsol.chol.LinearSolverCholesky_DSCC;
import org.ejml.sparse.csc.linsol.p055lu.LinearSolverLu_DSCC;
import org.ejml.sparse.csc.linsol.p056qr.LinearSolverQrLeftLooking_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverFactory_DSCC {
    public static LinearSolverSparse<DMatrixSparseCSC, DMatrixRMaj> cholesky(FillReducing fillReducing) {
        return new LinearSolverCholesky_DSCC((CholeskyUpLooking_DSCC) DecompositionFactory_DSCC.cholesky(), FillReductionFactory_DSCC.create(fillReducing));
    }

    /* JADX INFO: renamed from: qr */
    public static LinearSolverSparse<DMatrixSparseCSC, DMatrixRMaj> m1684qr(FillReducing fillReducing) {
        return new LinearSolverQrLeftLooking_DSCC(new QrLeftLookingDecomposition_DSCC(FillReductionFactory_DSCC.create(fillReducing)));
    }

    /* JADX INFO: renamed from: lu */
    public static LinearSolverSparse<DMatrixSparseCSC, DMatrixRMaj> m1683lu(FillReducing fillReducing) {
        return new LinearSolverLu_DSCC(new LuUpLooking_DSCC(FillReductionFactory_DSCC.create(fillReducing)));
    }
}
