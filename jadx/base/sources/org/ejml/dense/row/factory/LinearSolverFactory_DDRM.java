package org.ejml.dense.row.factory;

import org.ejml.EjmlParameters;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionInner_DDRM;
import org.ejml.dense.row.decomposition.p049lu.LUDecompositionAlt_DDRM;
import org.ejml.dense.row.decomposition.p050qr.QRColPivDecompositionHouseholderColumn_DDRM;
import org.ejml.dense.row.linsol.AdjustableLinearSolver_DDRM;
import org.ejml.dense.row.linsol.chol.LinearSolverChol_DDRB;
import org.ejml.dense.row.linsol.chol.LinearSolverChol_DDRM;
import org.ejml.dense.row.linsol.p051lu.LinearSolverLu_DDRM;
import org.ejml.dense.row.linsol.p052qr.AdjLinearSolverQr_DDRM;
import org.ejml.dense.row.linsol.p052qr.LinearSolverQrBlock64_DDRM;
import org.ejml.dense.row.linsol.p052qr.LinearSolverQrHouseCol_DDRM;
import org.ejml.dense.row.linsol.p052qr.LinearSolverQrpHouseCol_DDRM;
import org.ejml.dense.row.linsol.p052qr.SolvePseudoInverseQrp_DDRM;
import org.ejml.dense.row.linsol.svd.SolvePseudoInverseSvd_DDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverFactory_DDRM {
    /* JADX INFO: renamed from: lu */
    public static LinearSolverDense<DMatrixRMaj> m1675lu(int i) {
        return linear(i);
    }

    public static LinearSolverDense<DMatrixRMaj> chol(int i) {
        return symmPosDef(i);
    }

    /* JADX INFO: renamed from: qr */
    public static LinearSolverDense<DMatrixRMaj> m1676qr(int i, int i2) {
        return leastSquares(i, i2);
    }

    public static LinearSolverDense<DMatrixRMaj> qrp(boolean z, boolean z2) {
        return leastSquaresQrPivot(z, z2);
    }

    public static LinearSolverDense<DMatrixRMaj> general(int i, int i2) {
        if (i == i2) {
            return linear(i);
        }
        return leastSquares(i, i2);
    }

    public static LinearSolverDense<DMatrixRMaj> linear(int i) {
        return new LinearSolverLu_DDRM(new LUDecompositionAlt_DDRM());
    }

    public static LinearSolverDense<DMatrixRMaj> leastSquares(int i, int i2) {
        if (i2 < EjmlParameters.SWITCH_BLOCK64_QR) {
            return new LinearSolverQrHouseCol_DDRM();
        }
        if (EjmlParameters.MEMORY == EjmlParameters.MemoryUsage.FASTER) {
            return new LinearSolverQrBlock64_DDRM();
        }
        return new LinearSolverQrHouseCol_DDRM();
    }

    public static LinearSolverDense<DMatrixRMaj> symmPosDef(int i) {
        if (i < EjmlParameters.SWITCH_BLOCK64_CHOLESKY) {
            return new LinearSolverChol_DDRM(new CholeskyDecompositionInner_DDRM(true));
        }
        if (EjmlParameters.MEMORY == EjmlParameters.MemoryUsage.FASTER) {
            return new LinearSolverChol_DDRB();
        }
        return new LinearSolverChol_DDRM(new CholeskyDecompositionInner_DDRM(true));
    }

    public static LinearSolverDense<DMatrixRMaj> leastSquaresQrPivot(boolean z, boolean z2) {
        QRColPivDecompositionHouseholderColumn_DDRM qRColPivDecompositionHouseholderColumn_DDRM = new QRColPivDecompositionHouseholderColumn_DDRM();
        if (z2) {
            return new SolvePseudoInverseQrp_DDRM(qRColPivDecompositionHouseholderColumn_DDRM, z);
        }
        return new LinearSolverQrpHouseCol_DDRM(qRColPivDecompositionHouseholderColumn_DDRM, z);
    }

    public static LinearSolverDense<DMatrixRMaj> pseudoInverse(boolean z) {
        if (z) {
            return new SolvePseudoInverseSvd_DDRM();
        }
        return leastSquaresQrPivot(true, false);
    }

    public static AdjustableLinearSolver_DDRM adjustable() {
        return new AdjLinearSolverQr_DDRM();
    }
}
