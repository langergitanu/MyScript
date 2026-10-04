package org.ejml.dense.row.factory;

import org.ejml.EjmlParameters;
import org.ejml.UtilEjml;
import org.ejml.data.FMatrix;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.EigenOps_FDRM;
import org.ejml.dense.row.NormOps_FDRM;
import org.ejml.dense.row.SpecializedOps_FDRM;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionBlock_FDRM;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionInner_FDRM;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionLDL_FDRM;
import org.ejml.dense.row.decomposition.chol.CholeskyDecomposition_FDRB_to_FDRM;
import org.ejml.dense.row.decomposition.eig.SwitchingEigenDecomposition_FDRM;
import org.ejml.dense.row.decomposition.eig.SymmetricQRAlgorithmDecomposition_FDRM;
import org.ejml.dense.row.decomposition.eig.WatchedDoubleStepQRDecomposition_FDRM;
import org.ejml.dense.row.decomposition.hessenberg.TridiagonalDecompositionHouseholder_FDRM;
import org.ejml.dense.row.decomposition.hessenberg.TridiagonalDecomposition_FDRB_to_FDRM;
import org.ejml.dense.row.decomposition.p049lu.LUDecompositionAlt_FDRM;
import org.ejml.dense.row.decomposition.p050qr.QRColPivDecompositionHouseholderColumn_FDRM;
import org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholderColumn_FDRM;
import org.ejml.dense.row.decomposition.svd.SvdImplicitQrDecompose_FDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F32;
import org.ejml.interfaces.decomposition.CholeskyLDLDecomposition_F32;
import org.ejml.interfaces.decomposition.DecompositionInterface;
import org.ejml.interfaces.decomposition.EigenDecomposition_F32;
import org.ejml.interfaces.decomposition.LUDecomposition_F32;
import org.ejml.interfaces.decomposition.QRDecomposition;
import org.ejml.interfaces.decomposition.QRPDecomposition_F32;
import org.ejml.interfaces.decomposition.SingularValueDecomposition;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F32;
import org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class DecompositionFactory_FDRM {
    public static CholeskyDecomposition_F32<FMatrixRMaj> chol(int i, boolean z) {
        if (i < EjmlParameters.SWITCH_BLOCK64_CHOLESKY) {
            return new CholeskyDecompositionInner_FDRM(z);
        }
        if (EjmlParameters.MEMORY == EjmlParameters.MemoryUsage.FASTER) {
            return new CholeskyDecomposition_FDRB_to_FDRM(z);
        }
        return new CholeskyDecompositionBlock_FDRM(EjmlParameters.BLOCK_WIDTH_CHOL);
    }

    public static CholeskyLDLDecomposition_F32<FMatrixRMaj> cholLDL(int i) {
        return new CholeskyDecompositionLDL_FDRM();
    }

    /* JADX INFO: renamed from: lu */
    public static LUDecomposition_F32<FMatrixRMaj> m1669lu(int i, int i2) {
        return new LUDecompositionAlt_FDRM();
    }

    public static SingularValueDecomposition_F32<FMatrixRMaj> svd(int i, int i2, boolean z, boolean z2, boolean z3) {
        return new SvdImplicitQrDecompose_FDRM(z3, z, z2, false);
    }

    /* JADX INFO: renamed from: qr */
    public static QRDecomposition<FMatrixRMaj> m1670qr(int i, int i2) {
        return new QRDecompositionHouseholderColumn_FDRM();
    }

    public static QRPDecomposition_F32<FMatrixRMaj> qrp(int i, int i2) {
        return new QRColPivDecompositionHouseholderColumn_FDRM();
    }

    public static EigenDecomposition_F32<FMatrixRMaj> eig(int i, boolean z) {
        return new SwitchingEigenDecomposition_FDRM(i, z, UtilEjml.TEST_F32);
    }

    public static EigenDecomposition_F32<FMatrixRMaj> eig(int i, boolean z, boolean z2) {
        if (z2) {
            return new SymmetricQRAlgorithmDecomposition_FDRM(tridiagonal(i), z);
        }
        return new WatchedDoubleStepQRDecomposition_FDRM(z);
    }

    public static float quality(FMatrixRMaj fMatrixRMaj, SingularValueDecomposition<FMatrixRMaj> singularValueDecomposition) {
        return quality(fMatrixRMaj, (FMatrixRMaj) singularValueDecomposition.getU(null, false), (FMatrixRMaj) singularValueDecomposition.getW(null), (FMatrixRMaj) singularValueDecomposition.getV(null, true));
    }

    public static float quality(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3, FMatrixRMaj fMatrixRMaj4) {
        FMatrixRMaj fMatrixRMaj5 = new FMatrixRMaj(fMatrixRMaj2.numRows, fMatrixRMaj3.numCols);
        CommonOps_FDRM.mult(fMatrixRMaj2, fMatrixRMaj3, fMatrixRMaj5);
        FMatrixRMaj fMatrixRMaj6 = new FMatrixRMaj(fMatrixRMaj5.numRows, fMatrixRMaj4.numCols);
        CommonOps_FDRM.mult(fMatrixRMaj5, fMatrixRMaj4, fMatrixRMaj6);
        return SpecializedOps_FDRM.diffNormF(fMatrixRMaj, fMatrixRMaj6) / NormOps_FDRM.normF(fMatrixRMaj6);
    }

    public static float quality(FMatrixRMaj fMatrixRMaj, EigenDecomposition_F32<FMatrixRMaj> eigenDecomposition_F32) {
        FMatrixRMaj fMatrixRMajCreateMatrixV = EigenOps_FDRM.createMatrixV(eigenDecomposition_F32);
        FMatrixRMaj fMatrixRMajCreateMatrixD = EigenOps_FDRM.createMatrixD(eigenDecomposition_F32);
        FMatrixRMaj fMatrixRMaj2 = new FMatrixRMaj(fMatrixRMaj.numRows, fMatrixRMajCreateMatrixV.numCols);
        CommonOps_FDRM.mult(fMatrixRMaj, fMatrixRMajCreateMatrixV, fMatrixRMaj2);
        FMatrixRMaj fMatrixRMaj3 = new FMatrixRMaj(fMatrixRMajCreateMatrixV.numRows, fMatrixRMajCreateMatrixD.numCols);
        CommonOps_FDRM.mult(fMatrixRMajCreateMatrixV, fMatrixRMajCreateMatrixD, fMatrixRMaj3);
        FMatrixRMaj fMatrixRMaj4 = new FMatrixRMaj(fMatrixRMaj2.numRows, fMatrixRMaj2.numCols);
        CommonOps_FDRM.subtract(fMatrixRMaj2, fMatrixRMaj3, fMatrixRMaj4);
        return NormOps_FDRM.normF(fMatrixRMaj4) / NormOps_FDRM.normF(fMatrixRMaj2);
    }

    public static TridiagonalSimilarDecomposition_F32<FMatrixRMaj> tridiagonal(int i) {
        if (i >= 1800) {
            return new TridiagonalDecomposition_FDRB_to_FDRM();
        }
        return new TridiagonalDecompositionHouseholder_FDRM();
    }

    public static <T extends FMatrix> boolean decomposeSafe(DecompositionInterface<T> decompositionInterface, T t) {
        if (decompositionInterface.inputModified()) {
            return decompositionInterface.decompose(t.copy());
        }
        return decompositionInterface.decompose(t);
    }
}
