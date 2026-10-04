package org.ejml.dense.row.factory;

import org.ejml.EjmlParameters;
import org.ejml.UtilEjml;
import org.ejml.data.DMatrix;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.EigenOps_DDRM;
import org.ejml.dense.row.NormOps_DDRM;
import org.ejml.dense.row.SpecializedOps_DDRM;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionBlock_DDRM;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionInner_DDRM;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionLDL_DDRM;
import org.ejml.dense.row.decomposition.chol.CholeskyDecomposition_DDRB_to_DDRM;
import org.ejml.dense.row.decomposition.eig.SwitchingEigenDecomposition_DDRM;
import org.ejml.dense.row.decomposition.eig.SymmetricQRAlgorithmDecomposition_DDRM;
import org.ejml.dense.row.decomposition.eig.WatchedDoubleStepQRDecomposition_DDRM;
import org.ejml.dense.row.decomposition.hessenberg.TridiagonalDecompositionHouseholder_DDRM;
import org.ejml.dense.row.decomposition.hessenberg.TridiagonalDecomposition_DDRB_to_DDRM;
import org.ejml.dense.row.decomposition.p049lu.LUDecompositionAlt_DDRM;
import org.ejml.dense.row.decomposition.p050qr.QRColPivDecompositionHouseholderColumn_DDRM;
import org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholderColumn_DDRM;
import org.ejml.dense.row.decomposition.svd.SvdImplicitQrDecompose_DDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F64;
import org.ejml.interfaces.decomposition.CholeskyLDLDecomposition_F64;
import org.ejml.interfaces.decomposition.DecompositionInterface;
import org.ejml.interfaces.decomposition.EigenDecomposition_F64;
import org.ejml.interfaces.decomposition.LUDecomposition_F64;
import org.ejml.interfaces.decomposition.QRDecomposition;
import org.ejml.interfaces.decomposition.QRPDecomposition_F64;
import org.ejml.interfaces.decomposition.SingularValueDecomposition;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F64;
import org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class DecompositionFactory_DDRM {
    public static CholeskyDecomposition_F64<DMatrixRMaj> chol(int i, boolean z) {
        if (i < EjmlParameters.SWITCH_BLOCK64_CHOLESKY) {
            return new CholeskyDecompositionInner_DDRM(z);
        }
        if (EjmlParameters.MEMORY == EjmlParameters.MemoryUsage.FASTER) {
            return new CholeskyDecomposition_DDRB_to_DDRM(z);
        }
        return new CholeskyDecompositionBlock_DDRM(EjmlParameters.BLOCK_WIDTH_CHOL);
    }

    public static CholeskyLDLDecomposition_F64<DMatrixRMaj> cholLDL(int i) {
        return new CholeskyDecompositionLDL_DDRM();
    }

    /* JADX INFO: renamed from: lu */
    public static LUDecomposition_F64<DMatrixRMaj> m1667lu(int i, int i2) {
        return new LUDecompositionAlt_DDRM();
    }

    public static SingularValueDecomposition_F64<DMatrixRMaj> svd(int i, int i2, boolean z, boolean z2, boolean z3) {
        return new SvdImplicitQrDecompose_DDRM(z3, z, z2, false);
    }

    /* JADX INFO: renamed from: qr */
    public static QRDecomposition<DMatrixRMaj> m1668qr(int i, int i2) {
        return new QRDecompositionHouseholderColumn_DDRM();
    }

    public static QRPDecomposition_F64<DMatrixRMaj> qrp(int i, int i2) {
        return new QRColPivDecompositionHouseholderColumn_DDRM();
    }

    public static EigenDecomposition_F64<DMatrixRMaj> eig(int i, boolean z) {
        return new SwitchingEigenDecomposition_DDRM(i, z, UtilEjml.TEST_F64);
    }

    public static EigenDecomposition_F64<DMatrixRMaj> eig(int i, boolean z, boolean z2) {
        if (z2) {
            return new SymmetricQRAlgorithmDecomposition_DDRM(tridiagonal(i), z);
        }
        return new WatchedDoubleStepQRDecomposition_DDRM(z);
    }

    public static double quality(DMatrixRMaj dMatrixRMaj, SingularValueDecomposition<DMatrixRMaj> singularValueDecomposition) {
        return quality(dMatrixRMaj, (DMatrixRMaj) singularValueDecomposition.getU(null, false), (DMatrixRMaj) singularValueDecomposition.getW(null), (DMatrixRMaj) singularValueDecomposition.getV(null, true));
    }

    public static double quality(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3, DMatrixRMaj dMatrixRMaj4) {
        DMatrixRMaj dMatrixRMaj5 = new DMatrixRMaj(dMatrixRMaj2.numRows, dMatrixRMaj3.numCols);
        CommonOps_DDRM.mult(dMatrixRMaj2, dMatrixRMaj3, dMatrixRMaj5);
        DMatrixRMaj dMatrixRMaj6 = new DMatrixRMaj(dMatrixRMaj5.numRows, dMatrixRMaj4.numCols);
        CommonOps_DDRM.mult(dMatrixRMaj5, dMatrixRMaj4, dMatrixRMaj6);
        return SpecializedOps_DDRM.diffNormF(dMatrixRMaj, dMatrixRMaj6) / NormOps_DDRM.normF(dMatrixRMaj6);
    }

    public static double quality(DMatrixRMaj dMatrixRMaj, EigenDecomposition_F64<DMatrixRMaj> eigenDecomposition_F64) {
        DMatrixRMaj dMatrixRMajCreateMatrixV = EigenOps_DDRM.createMatrixV(eigenDecomposition_F64);
        DMatrixRMaj dMatrixRMajCreateMatrixD = EigenOps_DDRM.createMatrixD(eigenDecomposition_F64);
        DMatrixRMaj dMatrixRMaj2 = new DMatrixRMaj(dMatrixRMaj.numRows, dMatrixRMajCreateMatrixV.numCols);
        CommonOps_DDRM.mult(dMatrixRMaj, dMatrixRMajCreateMatrixV, dMatrixRMaj2);
        DMatrixRMaj dMatrixRMaj3 = new DMatrixRMaj(dMatrixRMajCreateMatrixV.numRows, dMatrixRMajCreateMatrixD.numCols);
        CommonOps_DDRM.mult(dMatrixRMajCreateMatrixV, dMatrixRMajCreateMatrixD, dMatrixRMaj3);
        DMatrixRMaj dMatrixRMaj4 = new DMatrixRMaj(dMatrixRMaj2.numRows, dMatrixRMaj2.numCols);
        CommonOps_DDRM.subtract(dMatrixRMaj2, dMatrixRMaj3, dMatrixRMaj4);
        return NormOps_DDRM.normF(dMatrixRMaj4) / NormOps_DDRM.normF(dMatrixRMaj2);
    }

    public static TridiagonalSimilarDecomposition_F64<DMatrixRMaj> tridiagonal(int i) {
        if (i >= 1800) {
            return new TridiagonalDecomposition_DDRB_to_DDRM();
        }
        return new TridiagonalDecompositionHouseholder_DDRM();
    }

    public static <T extends DMatrix> boolean decomposeSafe(DecompositionInterface<T> decompositionInterface, T t) {
        if (decompositionInterface.inputModified()) {
            return decompositionInterface.decompose(t.copy());
        }
        return decompositionInterface.decompose(t);
    }
}
