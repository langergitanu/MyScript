package org.ejml.dense.row.factory;

import org.ejml.data.CMatrixRMaj;
import org.ejml.dense.row.decompose.chol.CholeskyDecompositionInner_CDRM;
import org.ejml.dense.row.decompose.p047lu.LUDecompositionAlt_CDRM;
import org.ejml.dense.row.linsol.chol.LinearSolverChol_CDRM;
import org.ejml.dense.row.linsol.p051lu.LinearSolverLu_CDRM;
import org.ejml.dense.row.linsol.p052qr.LinearSolverQrHouseCol_CDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverFactory_CDRM {
    /* JADX INFO: renamed from: lu */
    public static LinearSolverDense<CMatrixRMaj> m1673lu(int i) {
        return new LinearSolverLu_CDRM(new LUDecompositionAlt_CDRM());
    }

    public static LinearSolverDense<CMatrixRMaj> chol(int i) {
        return new LinearSolverChol_CDRM(new CholeskyDecompositionInner_CDRM());
    }

    /* JADX INFO: renamed from: qr */
    public static LinearSolverDense<CMatrixRMaj> m1674qr(int i, int i2) {
        return new LinearSolverQrHouseCol_CDRM();
    }
}
