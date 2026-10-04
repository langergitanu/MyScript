package org.ejml.dense.row.factory;

import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.decompose.chol.CholeskyDecompositionInner_ZDRM;
import org.ejml.dense.row.decompose.p047lu.LUDecompositionAlt_ZDRM;
import org.ejml.dense.row.linsol.chol.LinearSolverChol_ZDRM;
import org.ejml.dense.row.linsol.p051lu.LinearSolverLu_ZDRM;
import org.ejml.dense.row.linsol.p052qr.LinearSolverQrHouseCol_ZDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverFactory_ZDRM {
    /* JADX INFO: renamed from: lu */
    public static LinearSolverDense<ZMatrixRMaj> m1679lu(int i) {
        return new LinearSolverLu_ZDRM(new LUDecompositionAlt_ZDRM());
    }

    public static LinearSolverDense<ZMatrixRMaj> chol(int i) {
        return new LinearSolverChol_ZDRM(new CholeskyDecompositionInner_ZDRM());
    }

    /* JADX INFO: renamed from: qr */
    public static LinearSolverDense<ZMatrixRMaj> m1680qr(int i, int i2) {
        return new LinearSolverQrHouseCol_ZDRM();
    }
}
