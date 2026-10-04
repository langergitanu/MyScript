package org.ejml.dense.row.factory;

import org.ejml.EjmlParameters;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionInner_FDRM;
import org.ejml.dense.row.decomposition.p049lu.LUDecompositionAlt_FDRM;
import org.ejml.dense.row.decomposition.p050qr.QRColPivDecompositionHouseholderColumn_FDRM;
import org.ejml.dense.row.linsol.AdjustableLinearSolver_FDRM;
import org.ejml.dense.row.linsol.chol.LinearSolverChol_FDRB;
import org.ejml.dense.row.linsol.chol.LinearSolverChol_FDRM;
import org.ejml.dense.row.linsol.p051lu.LinearSolverLu_FDRM;
import org.ejml.dense.row.linsol.p052qr.AdjLinearSolverQr_FDRM;
import org.ejml.dense.row.linsol.p052qr.LinearSolverQrBlock64_FDRM;
import org.ejml.dense.row.linsol.p052qr.LinearSolverQrHouseCol_FDRM;
import org.ejml.dense.row.linsol.p052qr.LinearSolverQrpHouseCol_FDRM;
import org.ejml.dense.row.linsol.p052qr.SolvePseudoInverseQrp_FDRM;
import org.ejml.dense.row.linsol.svd.SolvePseudoInverseSvd_FDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverFactory_FDRM {
    /* JADX INFO: renamed from: lu */
    public static LinearSolverDense<FMatrixRMaj> m1677lu(int i) {
        return linear(i);
    }

    public static LinearSolverDense<FMatrixRMaj> chol(int i) {
        return symmPosDef(i);
    }

    /* JADX INFO: renamed from: qr */
    public static LinearSolverDense<FMatrixRMaj> m1678qr(int i, int i2) {
        return leastSquares(i, i2);
    }

    public static LinearSolverDense<FMatrixRMaj> qrp(boolean z, boolean z2) {
        return leastSquaresQrPivot(z, z2);
    }

    public static LinearSolverDense<FMatrixRMaj> general(int i, int i2) {
        if (i == i2) {
            return linear(i);
        }
        return leastSquares(i, i2);
    }

    public static LinearSolverDense<FMatrixRMaj> linear(int i) {
        return new LinearSolverLu_FDRM(new LUDecompositionAlt_FDRM());
    }

    public static LinearSolverDense<FMatrixRMaj> leastSquares(int i, int i2) {
        if (i2 < EjmlParameters.SWITCH_BLOCK64_QR) {
            return new LinearSolverQrHouseCol_FDRM();
        }
        if (EjmlParameters.MEMORY == EjmlParameters.MemoryUsage.FASTER) {
            return new LinearSolverQrBlock64_FDRM();
        }
        return new LinearSolverQrHouseCol_FDRM();
    }

    public static LinearSolverDense<FMatrixRMaj> symmPosDef(int i) {
        if (i < EjmlParameters.SWITCH_BLOCK64_CHOLESKY) {
            return new LinearSolverChol_FDRM(new CholeskyDecompositionInner_FDRM(true));
        }
        if (EjmlParameters.MEMORY == EjmlParameters.MemoryUsage.FASTER) {
            return new LinearSolverChol_FDRB();
        }
        return new LinearSolverChol_FDRM(new CholeskyDecompositionInner_FDRM(true));
    }

    public static LinearSolverDense<FMatrixRMaj> leastSquaresQrPivot(boolean z, boolean z2) {
        QRColPivDecompositionHouseholderColumn_FDRM qRColPivDecompositionHouseholderColumn_FDRM = new QRColPivDecompositionHouseholderColumn_FDRM();
        if (z2) {
            return new SolvePseudoInverseQrp_FDRM(qRColPivDecompositionHouseholderColumn_FDRM, z);
        }
        return new LinearSolverQrpHouseCol_FDRM(qRColPivDecompositionHouseholderColumn_FDRM, z);
    }

    public static LinearSolverDense<FMatrixRMaj> pseudoInverse(boolean z) {
        if (z) {
            return new SolvePseudoInverseSvd_FDRM();
        }
        return leastSquaresQrPivot(true, false);
    }

    public static AdjustableLinearSolver_FDRM adjustable() {
        return new AdjLinearSolverQr_FDRM();
    }
}
